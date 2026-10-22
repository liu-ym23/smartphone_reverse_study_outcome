package com.android.server.pm;

import android.content.Context;
import android.content.pm.PackageStats;
import android.os.Binder;
import android.os.Build;
import android.os.CreateAppDataArgs;
import android.os.CreateAppDataResult;
import android.os.IBinder;
import android.os.IInstalld;
import android.os.ParcelFileDescriptor;
import android.os.ReconcileSdkDataArgs;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.storage.CrateMetadata;
import android.util.EventLog;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.android.server.EventLogTags;
import com.android.server.SystemService;
import dalvik.system.BlockGuard;
import dalvik.system.VMRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class Installer extends SystemService {
    private static final long CONNECT_RETRY_DELAY_MS = 100;
    private static final long CONNECT_WAIT_MS = 10000;
    public static final int DEXOPT_BOOTCOMPLETE = 8;
    public static final int DEXOPT_DEBUGGABLE = 4;
    public static final int DEXOPT_ENABLE_HIDDEN_API_CHECKS = 1024;
    public static final int DEXOPT_FORCE = 64;
    public static final int DEXOPT_FOR_RESTORE = 8192;
    public static final int DEXOPT_GENERATE_APP_IMAGE = 4096;
    public static final int DEXOPT_GENERATE_COMPACT_DEX = 2048;
    public static final int DEXOPT_IDLE_BACKGROUND_JOB = 512;
    public static final int DEXOPT_PROFILE_GUIDED = 16;
    public static final int DEXOPT_PUBLIC = 2;
    public static final int DEXOPT_SECONDARY_DEX = 32;
    public static final int DEXOPT_STORAGE_CE = 128;
    public static final int DEXOPT_STORAGE_DE = 256;
    public static final int FLAG_CLEAR_APP_DATA_KEEP_ART_PROFILES = 131072;
    public static final int FLAG_CLEAR_CACHE_ONLY = 16;
    public static final int FLAG_CLEAR_CODE_CACHE_ONLY = 32;
    public static final int FLAG_FORCE = 8192;
    public static final int FLAG_FREE_CACHE_DEFY_TARGET_FREE_BYTES = 2048;
    public static final int FLAG_FREE_CACHE_NOOP = 1024;
    public static final int FLAG_FREE_CACHE_V2 = 256;
    public static final int FLAG_FREE_CACHE_V2_DEFY_QUOTA = 512;
    public static final int FLAG_STORAGE_CE = 2;
    public static final int FLAG_STORAGE_DE = 1;
    public static final int FLAG_STORAGE_EXTERNAL = 4;
    public static final int FLAG_STORAGE_SDK = 8;
    public static final int FLAG_USE_QUOTA = 4096;
    public static final int PROFILE_ANALYSIS_DONT_OPTIMIZE_EMPTY_PROFILES = 3;
    public static final int PROFILE_ANALYSIS_DONT_OPTIMIZE_SMALL_DELTA = 2;
    public static final int PROFILE_ANALYSIS_OPTIMIZE = 1;
    private static final String TAG = "Installer";
    private volatile boolean mDeferSetFirstBoot;
    private volatile IInstalld mInstalld;
    private volatile CountDownLatch mInstalldLatch;
    private final boolean mIsolated;
    private volatile Object mWarnIfHeld;

    public static class Batch {
        private static final int CREATE_APP_DATA_BATCH_SIZE = 256;
        private final List<CreateAppDataArgs> mArgs;
        private boolean mExecuted;
        private final List<CompletableFuture<CreateAppDataResult>> mFutures;

        public Batch() {
            this.mArgs = new ArrayList();
            this.mFutures = new ArrayList();
        }

        public synchronized CompletableFuture<CreateAppDataResult> createAppData(CreateAppDataArgs args) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mExecuted == true) goto L11;
            CompletableFuture<CreateAppDataResult> future = new CompletableFuture();     // Catch: Throwable -> L8
            this.mArgs.add(args);     // Catch: Throwable -> L8
            this.mFutures.add(future);     // Catch: Throwable -> L8
            monitor-exit(this);
            return future;
        L11:
            throw new IllegalStateException();     // Catch: Throwable -> L8
        }

        public synchronized void execute(Installer installer) throws InstallerException {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mExecuted == true) goto L26;
            this.mExecuted = true;     // Catch: Throwable -> L11
            int size = this.mArgs.size();     // Catch: Throwable -> L11
            int i = 0;
        L6:
            if (i >= size) goto L23;
            CreateAppDataArgs[] args = new CreateAppDataArgs[Math.min(size - i, 256)];     // Catch: Throwable -> L11
            int j = 0;
        L9:
            if (j >= args.length) goto L13;
            args[j] = this.mArgs.get(i + j);     // Catch: Throwable -> L11
            j = j + 1;     // Catch: Throwable -> L11
            goto L9
        L13:
            CreateAppDataResult[] results = installer.createAppDataBatched(args);     // Catch: Throwable -> L11
            int j2 = 0;
        L15:
            if (j2 >= results.length) goto L21;
            CreateAppDataResult result = results[j2];     // Catch: Throwable -> L11
            CompletableFuture<CreateAppDataResult> future = this.mFutures.get(i + j2);     // Catch: Throwable -> L11
            if (result.exceptionCode != 0) goto L19;
            future.complete(result);     // Catch: Throwable -> L11
        L20:
            j2 = j2 + 1;
            goto L15
        L19:
            future.completeExceptionally(new InstallerException(result.exceptionMessage));     // Catch: Throwable -> L11
            goto L20
        L21:
            i = i + 256;
            goto L6
        L23:
            monitor-exit(this);
            return;
        L26:
            throw new IllegalStateException();     // Catch: Throwable -> L11
        }
    }

    public static class InstallerException extends Exception {
        public InstallerException(String detailMessage) {
            super(detailMessage);
        }

        public static InstallerException from(Exception e) throws InstallerException {
            throw new InstallerException(e.toString());
        }
    }

    public static class LegacyDexoptDisabledException extends Exception {
        public LegacyDexoptDisabledException() {
            super("Invalid call to legacy dexopt method while ART Service is in use.");
        }
    }

    public static /* synthetic */ void $r8$lambda$0tq57UxfzsROQRoEFibdwJAIjkY(Installer r0) {
        r0.lambda$connect$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$ziOso-zBD6EBOzh2GxLZccmaXlE, reason: not valid java name */
    public static /* synthetic */ void m6670$r8$lambda$ziOsozBD6EBOzh2GxLZccmaXlE(Installer r0) {
        r0.connect();
    }

    public Installer(Context context) {
        this(context, false);
    }

    public Installer(Context context, boolean isolated) {
        super(context);
        this.mInstalld = null;
        this.mInstalldLatch = new CountDownLatch(1);
        this.mIsolated = isolated;
    }

    public void setWarnIfHeld(Object warnIfHeld) {
        this.mWarnIfHeld = warnIfHeld;
    }

    public boolean isIsolated() {
        return this.mIsolated;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (this.mIsolated == false) goto L5;
        this.mInstalld = null;
        this.mInstalldLatch.countDown();
        return;
    L5:
        connect();
    }

    private void connect() {
        IBinder binder = ServiceManager.getService("installd");
        if (binder != null) goto L16;
    L8:
        if (binder == null) goto L14;
        IInstalld installd = IInstalld.Stub.asInterface(binder);
        this.mInstalld = installd;
        this.mInstalldLatch.countDown();
        invalidateMounts();     // Catch: InstallerException -> L12
        executeDeferredActions();     // Catch: InstallerException -> L12
        return;
    L20:
        return;
    L14:
        Slog.w(TAG, "installd not found; trying again");
        BackgroundThread.getHandler().postDelayed(new Installer$$ExternalSyntheticLambda1(this), CONNECT_RETRY_DELAY_MS);
        return;
    L16:
        binder.linkToDeath(new Installer$$ExternalSyntheticLambda0(this), 0);     // Catch: RemoteException -> L6
    L7:
        binder = null;
        goto L8
    }

    private /* synthetic */ void lambda$connect$0() {
        Slog.w(TAG, "installd died; reconnecting");
        this.mInstalldLatch = new CountDownLatch(1);
        connect();
    }

    private void executeDeferredActions() throws InstallerException {
        if (this.mDeferSetFirstBoot == false) goto L6;
        setFirstBoot();
        return;
    }

    private boolean checkBeforeRemote() throws InstallerException {
        if (this.mWarnIfHeld == null) goto L8;
        if (Thread.holdsLock(this.mWarnIfHeld) == false) goto L8;
        Slog.wtf(TAG, "Calling thread " + Thread.currentThread().getName() + " is holding 0x" + Integer.toHexString(System.identityHashCode(this.mWarnIfHeld)), new Throwable());
    L8:
        if (this.mIsolated == false) goto L19;
        Slog.i(TAG, "Ignoring request because this installer is isolated");
        return false;
    L19:
        if (this.mInstalldLatch.await(10000, TimeUnit.MILLISECONDS) == false) goto L15;
        return true;
    L15:
        throw new InstallerException("time out waiting for the installer to be ready");     // Catch: InterruptedException -> L16
    L17:
        return true;
    }

    static CreateAppDataArgs buildCreateAppDataArgs(String uuid, String packageName, int userId, int flags, int appId, String seInfo, int targetSdkVersion, boolean usesSdk) {
        CreateAppDataArgs args = new CreateAppDataArgs();
        args.uuid = uuid;
        args.packageName = packageName;
        args.userId = userId;
        args.flags = flags;
        if (usesSdk == false) goto L5;
        args.flags |= 8;
    L5:
        args.appId = appId;
        args.seInfo = seInfo;
        args.targetSdkVersion = targetSdkVersion;
        return args;
    }

    private static CreateAppDataResult buildPlaceholderCreateAppDataResult() {
        CreateAppDataResult result = new CreateAppDataResult();
        result.ceDataInode = -1;
        result.deDataInode = -1;
        result.exceptionCode = 0;
        result.exceptionMessage = null;
        return result;
    }

    static ReconcileSdkDataArgs buildReconcileSdkDataArgs(String uuid, String packageName, List<String> subDirNames, int userId, int appId, String seInfo, int flags) {
        ReconcileSdkDataArgs args = new ReconcileSdkDataArgs();
        args.uuid = uuid;
        args.packageName = packageName;
        args.subDirNames = subDirNames;
        args.userId = userId;
        args.appId = appId;
        args.previousAppId = 0;
        args.seInfo = seInfo;
        args.flags = flags;
        return args;
    }

    public CreateAppDataResult createAppData(CreateAppDataArgs args) throws InstallerException {
        if (checkBeforeRemote() == false) goto L5;
        args.previousAppId = 0;
        return this.mInstalld.createAppData(args);
    L9:
        e = move-exception;
        throw InstallerException.from(e);
    L5:
        return buildPlaceholderCreateAppDataResult();
    }

    public CreateAppDataResult[] createAppDataBatched(CreateAppDataArgs[] args) throws InstallerException {
        if (checkBeforeRemote() == true) goto L6;
        CreateAppDataResult[] results = new CreateAppDataResult[args.length];
        Arrays.fill(results, buildPlaceholderCreateAppDataResult());
        return results;
    L6:
        int r0 = args.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L14;
        CreateAppDataArgs arg = args[r2];
        arg.previousAppId = 0;
        r2 = r2 + 1;
        goto L7
    L14:
        return this.mInstalld.createAppDataBatched(args);
    L11:
        e = move-exception;
        throw InstallerException.from(e);
    }

    void reconcileSdkData(ReconcileSdkDataArgs args) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.reconcileSdkData(args);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void setFirstBoot() throws InstallerException {
        if (checkBeforeRemote() == true) goto L15;
        return;
    L15:
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    L6:
        if (this.mInstalld == null) goto L10;
        this.mInstalld.setFirstBoot();     // Catch: Exception -> L8
        return;
    L10:
        this.mDeferSetFirstBoot = true;     // Catch: Exception -> L8
    }

    public void migrateAppData(String uuid, String packageName, int userId, int flags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.migrateAppData(uuid, packageName, userId, flags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void clearAppData(String uuid, String packageName, int userId, int flags, long ceDataInode) throws InstallerException {
        if (checkBeforeRemote() == true) goto L16;
        return;
    L16:
        this.mInstalld.clearAppData(uuid, packageName, userId, flags, ceDataInode);     // Catch: Exception -> L10
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();     // Catch: Exception -> L10
        int pid = Binder.getCallingPid();     // Catch: Exception -> L10
        int uid = Binder.getCallingUid();     // Catch: Exception -> L10
        EventLog.writeEvent(EventLogTags.INSTALLER_CLEAR_APP_DATA_CALLER, new Object[]{Integer.valueOf(pid), Integer.valueOf(uid), packageName, Integer.valueOf(flags)});     // Catch: Exception -> L10
        int i = 2;
    L7:
        if (i >= elements.length) goto L13;
        String className = elements[i].getClassName();     // Catch: Exception -> L10
        String methodName = elements[i].getMethodName();     // Catch: Exception -> L10
        String fileName = elements[i].getFileName();     // Catch: Exception -> L10
        int lineNumber = elements[i].getLineNumber();     // Catch: Exception -> L10
        EventLog.writeEvent(EventLogTags.INSTALLER_CLEAR_APP_DATA_CALL_STACK, new Object[]{methodName, className, fileName, Integer.valueOf(lineNumber)});     // Catch: Exception -> L10
        i = i + 1;
        goto L7
    L13:
        return;
    L10:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void destroyAppData(String uuid, String packageName, int userId, int flags, long ceDataInode) throws InstallerException {
        if (checkBeforeRemote() == true) goto L15;
        return;
    L15:
        this.mInstalld.destroyAppData(uuid, packageName, userId, flags, ceDataInode);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Exception e = e;
    L14:
        throw InstallerException.from(e);
    L11:
        e = move-exception;
        e = e;
        goto L14
    }

    public void fixupAppData(String uuid, int flags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.fixupAppData(uuid, flags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void cleanupInvalidPackageDirs(String uuid, int userId, int flags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.cleanupInvalidPackageDirs(uuid, userId, flags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void moveCompleteApp(String fromUuid, String toUuid, String packageName, int appId, String seInfo, int targetSdkVersion, String fromCodePath) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.moveCompleteApp(fromUuid, toUuid, packageName, appId, seInfo, targetSdkVersion, fromCodePath);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void getAppSize(String uuid, String[] packageNames, int userId, int flags, int appId, long[] ceDataInodes, String[] codePaths, PackageStats stats) throws InstallerException {
        if (checkBeforeRemote() == true) goto L6;
        return;
    L6:
        if (codePaths == null) goto L16;
        int r0 = codePaths.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L16;
        String codePath = codePaths[r1];
        BlockGuard.getVmPolicy().onPathAccess(codePath);
        r1 = r1 + 1;
    L16:
        long[] res = this.mInstalld.getAppSize(uuid, packageNames, userId, flags, appId, ceDataInodes, codePaths);     // Catch: Exception -> L13
        stats.codeSize += res[0];     // Catch: Exception -> L13
        stats.dataSize += res[1];     // Catch: Exception -> L13
        stats.cacheSize += res[2];     // Catch: Exception -> L13
        stats.externalCodeSize += res[3];     // Catch: Exception -> L13
        stats.externalDataSize += res[4];     // Catch: Exception -> L13
        stats.externalCacheSize += res[5];     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void getUserSize(String uuid, int userId, int flags, int[] appIds, PackageStats stats) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        long[] res = this.mInstalld.getUserSize(uuid, userId, flags, appIds);     // Catch: Exception -> L7
        stats.codeSize += res[0];     // Catch: Exception -> L7
        stats.dataSize += res[1];     // Catch: Exception -> L7
        stats.cacheSize += res[2];     // Catch: Exception -> L7
        stats.externalCodeSize += res[3];     // Catch: Exception -> L7
        stats.externalDataSize += res[4];     // Catch: Exception -> L7
        stats.externalCacheSize += res[5];     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public long[] getExternalSize(String uuid, int userId, int flags, int[] appIds) throws InstallerException {
        if (checkBeforeRemote() == false) goto L5;
        return this.mInstalld.getExternalSize(uuid, userId, flags, appIds);
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    L5:
        return new long[6];
    }

    public CrateMetadata[] getAppCrates(String uuid, String[] packageNames, int userId) throws InstallerException {
        if (checkBeforeRemote() == true) goto L11;
        return null;
    L11:
        return this.mInstalld.getAppCrates(uuid, packageNames, userId);
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public CrateMetadata[] getUserCrates(String uuid, int userId) throws InstallerException {
        if (checkBeforeRemote() == true) goto L11;
        return null;
    L11:
        return this.mInstalld.getUserCrates(uuid, userId);
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void setAppQuota(String uuid, int userId, int appId, long cacheQuota) throws InstallerException {
        if (checkBeforeRemote() == true) goto L15;
        return;
    L15:
        this.mInstalld.setAppQuota(uuid, userId, appId, cacheQuota);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Exception e = e;
    L14:
        throw InstallerException.from(e);
    L11:
        e = move-exception;
        e = e;
        goto L14
    }

    public boolean dexopt(String apkPath, int uid, String pkgName, String instructionSet, int dexoptNeeded, String outputPath, int dexFlags, String compilerFilter, String volumeUuid, String classLoaderContext, String seInfo, boolean downgrade, int targetSdkVersion, String profileName, String dexMetadataPath, String compilationReason) throws InstallerException, LegacyDexoptDisabledException {
        throw new LegacyDexoptDisabledException();
    }

    public void rmPackageDir(String packageName, String packageDir) throws InstallerException {
        if (checkBeforeRemote() == true) goto L5;
        return;
    L5:
        BlockGuard.getVmPolicy().onPathAccess(packageDir);
        this.mInstalld.rmPackageDir(packageName, packageDir);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void createUserData(String uuid, int userId, int userSerial, int flags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.createUserData(uuid, userId, userSerial, flags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void destroyUserData(String uuid, int userId, int flags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.destroyUserData(uuid, userId, flags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void freeCache(String uuid, long targetFreeBytes, int flags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.freeCache(uuid, targetFreeBytes, flags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void linkNativeLibraryDirectory(String uuid, String packageName, String nativeLibPath32, int userId) throws InstallerException {
        if (checkBeforeRemote() == true) goto L5;
        return;
    L5:
        BlockGuard.getVmPolicy().onPathAccess(nativeLibPath32);
        this.mInstalld.linkNativeLibraryDirectory(uuid, packageName, nativeLibPath32, userId);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void createOatDir(String packageName, String oatDir, String dexInstructionSet) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.createOatDir(packageName, oatDir, dexInstructionSet);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void linkFile(String packageName, String relativePath, String fromBase, String toBase) throws InstallerException {
        if (checkBeforeRemote() == true) goto L5;
        return;
    L5:
        BlockGuard.getVmPolicy().onPathAccess(fromBase);
        BlockGuard.getVmPolicy().onPathAccess(toBase);
        this.mInstalld.linkFile(packageName, relativePath, fromBase, toBase);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void moveAb(String packageName, String apkPath, String instructionSet, String outputPath) throws InstallerException {
        if (checkBeforeRemote() == true) goto L5;
        return;
    L5:
        BlockGuard.getVmPolicy().onPathAccess(apkPath);
        BlockGuard.getVmPolicy().onPathAccess(outputPath);
        this.mInstalld.moveAb(packageName, apkPath, instructionSet, outputPath);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public byte[] hashSecondaryDexFile(String dexPath, String packageName, int uid, String volumeUuid, int flags) throws InstallerException {
        if (checkBeforeRemote() == false) goto L5;
        BlockGuard.getVmPolicy().onPathAccess(dexPath);
        return this.mInstalld.hashSecondaryDexFile(dexPath, packageName, uid, volumeUuid, flags);
    L11:
        e = move-exception;
        Exception e = e;
    L16:
        throw InstallerException.from(e);
    L13:
        e = move-exception;
        e = e;
        goto L16
    L5:
        return new byte[0];
    }

    public void invalidateMounts() throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.invalidateMounts();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public boolean isQuotaSupported(String volumeUuid) throws InstallerException {
        if (checkBeforeRemote() == true) goto L11;
        return false;
    L11:
        return this.mInstalld.isQuotaSupported(volumeUuid);
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void tryMountDataMirror(String volumeUuid) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.tryMountDataMirror(volumeUuid);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public void onPrivateVolumeRemoved(String volumeUuid) throws InstallerException {
        if (checkBeforeRemote() == true) goto L10;
        return;
    L10:
        this.mInstalld.onPrivateVolumeRemoved(volumeUuid);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public boolean snapshotAppData(String pkg, int userId, int snapshotId, int storageFlags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L17;
        return false;
    L17:
        this.mInstalld.snapshotAppData(null, pkg, userId, snapshotId, storageFlags);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        Exception e = e;
    L16:
        throw InstallerException.from(e);
    L13:
        e = move-exception;
        e = e;
        goto L16
    }

    public boolean restoreAppDataSnapshot(String pkg, int appId, String seInfo, int userId, int snapshotId, int storageFlags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L17;
        return false;
    L17:
        this.mInstalld.restoreAppDataSnapshot(null, pkg, appId, seInfo, userId, snapshotId, storageFlags);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        Exception e = e;
    L16:
        throw InstallerException.from(e);
    L13:
        e = move-exception;
        e = e;
        goto L16
    }

    public boolean destroyAppDataSnapshot(String pkg, int userId, int snapshotId, int storageFlags) throws InstallerException {
        if (checkBeforeRemote() == true) goto L17;
        return false;
    L17:
        this.mInstalld.destroyAppDataSnapshot(null, pkg, userId, 0, snapshotId, storageFlags);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        Exception e = e;
    L16:
        throw InstallerException.from(e);
    L13:
        e = move-exception;
        e = e;
        goto L16
    }

    public boolean destroyCeSnapshotsNotSpecified(int userId, int[] retainSnapshotIds) throws InstallerException {
        if (checkBeforeRemote() == true) goto L12;
        return false;
    L12:
        this.mInstalld.destroyCeSnapshotsNotSpecified(null, userId, retainSnapshotIds);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public boolean migrateLegacyObbData() throws InstallerException {
        if (checkBeforeRemote() == true) goto L12;
        return false;
    L12:
        this.mInstalld.migrateLegacyObbData();     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        throw InstallerException.from(e);
    }

    private static void assertValidInstructionSet(String instructionSet) throws InstallerException {
        String[] r0 = Build.SUPPORTED_ABIS;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        String abi = r0[r2];
        if (VMRuntime.getInstructionSet(abi).equals(instructionSet) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new InstallerException("Invalid instruction set: " + instructionSet);
    }

    public IInstalld.IFsveritySetupAuthToken createFsveritySetupAuthToken(ParcelFileDescriptor authFd, int uid) throws InstallerException {
        if (checkBeforeRemote() == true) goto L11;
        return null;
    L11:
        return this.mInstalld.createFsveritySetupAuthToken(authFd, uid);
    L8:
        e = move-exception;
        throw InstallerException.from(e);
    }

    public int do6939Service(String[] cmdAndArgs) throws InstallerException {
        if (checkBeforeRemote() == true) goto L11;
        return -1;
    L11:
        int rc = this.mInstalld.do6939Service(cmdAndArgs);     // Catch: Exception -> L8
        return rc;
    L8:
        e = move-exception;
        Slog.e(TAG, "zbackup do6939Service fail", e);
        throw InstallerException.from(e);
    }

    public String getAllFilesPathsForPackage(String packageName) throws InstallerException {
        if (checkBeforeRemote() == true) goto L11;
        Slog.d(TAG, "zbackup getAllFilesPathsForPackage checkBeforeRemote fail");
        return null;
    L11:
        return this.mInstalld.getPackageFilesInfo(packageName);
    L8:
        e = move-exception;
        Slog.e(TAG, "zbackup installer getAllFilesPathsForPackage fail", e);
        throw InstallerException.from(e);
    }

    public int enableFsverity(IInstalld.IFsveritySetupAuthToken authToken, String filePath, String packageName) throws InstallerException {
        if (checkBeforeRemote() == false) goto L11;
        BlockGuard.getVmPolicy().onPathAccess(filePath);
        return this.mInstalld.enableFsverity(authToken, filePath, packageName);
    L7:
        e = move-exception;
        throw InstallerException.from(e);
    L11:
        throw new InstallerException("fs-verity wasn't enabled with an isolated installer");
    }
}
