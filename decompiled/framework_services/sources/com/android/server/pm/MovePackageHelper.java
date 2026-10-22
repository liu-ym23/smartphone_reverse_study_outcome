package com.android.server.pm;

import android.R;
import android.content.pm.IPackageInstallObserver2;
import android.content.pm.IPackageMoveObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.UserInfo;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.PackageLite;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.os.storage.VolumeInfo;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.internal.os.SomeArgs;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class MovePackageHelper {
    final PackageManagerService mPm;

    public static class MoveCallbacks extends Handler {
        private static final int MSG_CREATED = 1;
        private static final int MSG_STATUS_CHANGED = 2;
        private final RemoteCallbackList<IPackageMoveObserver> mCallbacks;
        public final SparseIntArray mLastStatus;

        public MoveCallbacks(Looper looper) {
            super(looper);
            this.mCallbacks = new RemoteCallbackList();
            this.mLastStatus = new SparseIntArray();
        }

        public void register(IPackageMoveObserver callback) {
            this.mCallbacks.register(callback);
        }

        public void unregister(IPackageMoveObserver callback) {
            this.mCallbacks.unregister(callback);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SomeArgs args = (SomeArgs) msg.obj;
            int n = this.mCallbacks.beginBroadcast();
            int i = 0;
        L3:
            if (i >= n) goto L9;
            IPackageMoveObserver callback = (IPackageMoveObserver) this.mCallbacks.getBroadcastItem(i);
            invokeCallback(callback, msg.what, args);     // Catch: RemoteException -> L7
        L8:
            i = i + 1;
            goto L3
        L9:
            this.mCallbacks.finishBroadcast();
            args.recycle();
        }

        private void invokeCallback(IPackageMoveObserver callback, int what, SomeArgs args) throws RemoteException {
            switch(what) {
                case 1: goto L5;
                case 2: goto L4;
                default: goto L8;
            };
        L4:
            callback.onStatusChanged(args.argi1, args.argi2, ((Long) args.arg3).longValue());
            return;
        L5:
            callback.onCreated(args.argi1, (Bundle) args.arg2);
            return;
        }

        public void notifyCreated(int moveId, Bundle extras) {
            Slog.v(PackageManagerServiceMonitorEx.TAG, "Move " + moveId + " created " + extras.toString());
            SomeArgs args = SomeArgs.obtain();
            args.argi1 = moveId;
            args.arg2 = extras;
            obtainMessage(1, args).sendToTarget();
        }

        public void notifyStatusChanged(int moveId, int status) {
            notifyStatusChanged(moveId, status, -1);
        }

        public void notifyStatusChanged(int moveId, int status, long estMillis) {
            Slog.v(PackageManagerServiceMonitorEx.TAG, "Move " + moveId + " status " + status);
            SomeArgs args = SomeArgs.obtain();
            args.argi1 = moveId;
            args.argi2 = status;
            args.arg3 = Long.valueOf(estMillis);
            obtainMessage(2, args).sendToTarget();
            SparseIntArray r1 = this.mLastStatus;
            monitor-enter(r1);
            this.mLastStatus.put(moveId, status);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$hO6Xq9gpW5zc9gxy7Z4mO-vs088, reason: not valid java name */
    public static /* synthetic */ void m6714$r8$lambda$hO6Xq9gpW5zc9gxy7Z4mOvs088(MovePackageHelper r0, CountDownLatch r1, long r2, File r4, long r5, int r7) {
        r0.lambda$movePackageInternal$0(r1, r2, r4, r5, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogAppMovedStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6715$$Nest$mlogAppMovedStorage(MovePackageHelper r0, String r1, boolean r2) {
        r0.logAppMovedStorage(r1, r2);
    }

    public MovePackageHelper(PackageManagerService pm) {
        this.mPm = pm;
    }

    public void movePackageInternal(final String packageName, String volumeUuid, final int moveId, int callingUid, UserHandle user) throws PackageManagerException {
        StorageManager storage = (StorageManager) this.mPm.mInjector.getSystemService(StorageManager.class);
        PackageManager pm = this.mPm.mContext.getPackageManager();
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, user.getIdentifier());
        if (packageState == null) goto L143;
        if (packageState.getPkg() == null) goto L143;
        int[] installedUserIds = PackageStateUtils.queryInstalledUsers(packageState, this.mPm.mUserManager.getUserIds(), true);
        if (installedUserIds.length <= 0) goto L141;
        UserHandle userForMove = UserHandle.of(installedUserIds[0]);
        int r5 = installedUserIds.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L15;
        if (snapshot.shouldFilterApplicationIncludingUninstalled(packageState, callingUid, installedUserIds[r6]) == true) goto L14;
        r6 = r6 + 1;
        goto L9
    L14:
        throw new PackageManagerException(-2, "Missing package");
    L15:
        AndroidPackageInternal r17 = packageState.getPkg();
        if (packageState.isSystem() == true) goto L139;
        boolean isInternalStorage = "private".equals(volumeUuid);
        boolean allow3rdPartyOnInternal = this.mPm.mContext.getResources().getBoolean(R.bool.config_allow3rdPartyAppOnInternal);
        if (isInternalStorage == false) goto L23;
        if (allow3rdPartyOnInternal == true) goto L23;
        throw new PackageManagerException(-9, "3rd party apps are not allowed on internal storage");
    L23:
        File probe = new File(r17.getPath());
        if (probe.isDirectory() == false) goto L137;
        String currentVolumeUuid = packageState.getVolumeUuid();
        if (Objects.equals(currentVolumeUuid, volumeUuid) == true) goto L135;
        if (r17.isExternalStorage() == true) goto L35;
        if (this.mPm.isPackageDeviceAdminOnAnyUser(snapshot, packageName) == false) goto L35;
        throw new PackageManagerException(-8, "Device admin cannot be moved");
    L35:
        if (snapshot.getFrozenPackages().containsKey(packageName) == true) goto L133;
        final boolean isCurrentLocationExternal = r17.isExternalStorage();
        File codeFile = new File(r17.getPath());
        InstallSource installSource = packageState.getInstallSource();
        String packageAbiOverride = packageState.getCpuAbiOverride();
        int appId = UserHandle.getAppId(r17.getUid());
        String seinfo = packageState.getSeInfo();
        String label = String.valueOf(pm.getApplicationLabel(AndroidPackageUtils.generateAppInfoWithoutState(r17)));
        int targetSdkVersion = r17.getTargetSdkVersion();
        if (codeFile.getParentFile().getName().startsWith("~~") == false) goto L39;
        String fromCodePath = codeFile.getParentFile().getAbsolutePath();
    L40:
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        PackageManagerTracedLock r34 = r4;
        PackageFreezer freezer = this.mPm.freezePackage(packageName, -1, "movePackageInternal", 10, null);     // Catch: Throwable -> L123
        monitor-exit(r34);     // Catch: Throwable -> L123
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Bundle extras = new Bundle();
        extras.putString("android.intent.extra.PACKAGE_NAME", packageName);
        extras.putString("android.intent.extra.TITLE", label);
        this.mPm.mMoveCallbacks.notifyCreated(moveId, extras);
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, volumeUuid) == false) goto L51;
        File measurePath = Environment.getDataAppDirectory(volumeUuid);
        boolean moveCompleteApp = true;
    L60:
        if (moveCompleteApp == false) goto L73;
        int r0 = installedUserIds.length;
        int r7 = 0;
    L62:
        if (r7 >= r0) goto L72;
        int userId = installedUserIds[r7];
        if (StorageManager.isFileEncrypted() == false) goto L71;
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L71;
        freezer.close();
        throw new PackageManagerException(-10, "User " + userId + " must be unlocked");
    L71:
        r7 = r7 + 1;
        freezer = freezer;
        goto L62
    L72:
        PackageFreezer freezer2 = freezer;
    L74:
        PackageStats stats = new PackageStats(null, -1);
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        int r1 = installedUserIds.length;     // Catch: Throwable -> L111
        int r8 = 0;
    L77:
        if (r8 >= r1) goto L86;
        int r38 = r1;
        if (getPackageSizeInfoLI(packageName, installedUserIds[r8], stats) == false) goto L81;
        r8 = r8 + 1;     // Catch: Throwable -> L83
        r1 = r38;
        goto L77
    L81:
        freezer2.close();     // Catch: Throwable -> L83
        throw new PackageManagerException(-6, "Failed to measure package size");     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        Throwable r2 = th;
    L113:
        if (installLock == null) goto L168;
        installLock.close();     // Catch: Throwable -> L116
        throw r2;
    L116:
        th = move-exception;
        r2.addSuppressed(th);
        throw r2;
    L168:
        throw r2;
    L86:
        if (installLock == null) goto L88;
        installLock.close();
    L88:
        final long startFreeBytes = measurePath.getUsableSpace();
        if (moveCompleteApp == false) goto L91;
        long sizeBytes = stats.codeSize + stats.dataSize;
    L92:
        final File measurePath2 = measurePath;
        if (sizeBytes <= storage.getStorageBytesUntilLow(measurePath2)) goto L144;
        freezer2.close();
        throw new PackageManagerException(-6, "Not enough free space to move");
    L144:
        prepareUserStorageForMove(currentVolumeUuid, volumeUuid, installedUserIds);     // Catch: RuntimeException -> L106
        this.mPm.mMoveCallbacks.notifyStatusChanged(moveId, 10);
        final CountDownLatch installedLatch = new CountDownLatch(1);
        final PackageFreezer freezer3 = freezer2;
        IPackageInstallObserver2.Stub r3 = new AnonymousClass1(this, freezer3, installedLatch, moveId, packageName, isCurrentLocationExternal);
        if (moveCompleteApp == false) goto L99;
        final long sizeBytes2 = sizeBytes;
        new Thread(new MovePackageHelper$$ExternalSyntheticLambda0(this, installedLatch, startFreeBytes, measurePath2, sizeBytes2, moveId)).start();
        MoveInfo move = new MoveInfo(moveId, currentVolumeUuid, volumeUuid, packageName, appId, seinfo, targetSdkVersion, fromCodePath);
    L100:
        int installFlags = 16 | 2;
        OriginInfo origin = OriginInfo.fromExistingFile(codeFile);
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<PackageLite> ret = ApkLiteParseUtils.parsePackageLite(input, new File(origin.mResolvedPath), 0);
        if (ret.isSuccess() == false) goto L103;
        PackageLite lite = (PackageLite) ret.getResult();
    L104:
        InstallingSession installingSession = new InstallingSession(origin, move, r3, installFlags, 0, installSource, volumeUuid, userForMove, packageAbiOverride, 0, lite, this.mPm);
        installingSession.movePackage();
        return;
    L103:
        lite = null;
        goto L104
    L99:
        move = null;
    L107:
        freezer2.close();
        throw new PackageManagerException(-6, "Failed to prepare user storage while moving app");
    L91:
        sizeBytes = stats.codeSize;
    L111:
        th = move-exception;
        r2 = th;
        goto L113
    L73:
        freezer2 = freezer;
        goto L74
    L51:
        if (Objects.equals("primary_physical", volumeUuid) == false) goto L53;
        measurePath = storage.getPrimaryPhysicalVolume().getPath();
        moveCompleteApp = false;
        goto L60
    L53:
        VolumeInfo volume = storage.findVolumeByUuid(volumeUuid);
        if (volume == null) goto L121;
        if (volume.getType() != 1) goto L121;
        if (volume.isMountedWritable() == false) goto L121;
        moveCompleteApp = true;
        measurePath = Environment.getDataAppDirectory(volumeUuid);
    L121:
        freezer.close();
        throw new PackageManagerException(-6, "Move location not mounted private volume");
    L123:
        th = th;
    L150:
        monitor-exit(r34);     // Catch: Throwable -> L130
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L130:
        th = th;
    L125:
        th = th;
        r34 = r4;
        goto L150
    L39:
        String fromCodePath2 = codeFile.getAbsolutePath();
        fromCodePath = fromCodePath2;
        goto L40
    L133:
        throw new PackageManagerException(-7, "Failed to move already frozen package");
    L135:
        throw new PackageManagerException(-6, "Package already moved to " + volumeUuid);
    L137:
        throw new PackageManagerException(-6, "Move only supported for modern cluster style installs");
    L139:
        throw new PackageManagerException(-3, "Cannot move system application");
    L141:
        throw new PackageManagerException(-2, "Package is not installed for any user");
    L143:
        throw new PackageManagerException(-2, "Missing package");
    }

    private /* synthetic */ void lambda$movePackageInternal$0(CountDownLatch installedLatch, long startFreeBytes, File measurePath, long sizeBytes, int moveId) {
    L8:
        if (installedLatch.await(1, TimeUnit.SECONDS) == false) goto L7;
        return;
    L7:
        long deltaFreeBytes = startFreeBytes - measurePath.getUsableSpace();
        int progress = ((int) MathUtils.constrain((80 * deltaFreeBytes) / sizeBytes, 0, 80)) + 10;
        this.mPm.mMoveCallbacks.notifyStatusChanged(moveId, progress);
        goto L8
    }

    private void logAppMovedStorage(String packageName, boolean isPreviousLocationExternal) {
        Computer snapshot = this.mPm.snapshotComputer();
        AndroidPackage pkg = snapshot.getPackage(packageName);
        if (pkg != null) goto L5;
        return;
    L5:
        StorageManager storage = (StorageManager) this.mPm.mInjector.getSystemService(StorageManager.class);
        VolumeInfo volume = storage.findVolumeByUuid(StorageManager.convert(pkg.getVolumeUuid()).toString());
        int packageExternalStorageType = PackageManagerServiceUtils.getPackageExternalStorageType(volume, pkg.isExternalStorage());
        if (isPreviousLocationExternal == false) goto L8;
    L10:
        if (isPreviousLocationExternal == true) goto L12;
        return;
    L12:
        if (pkg.isExternalStorage() == true) goto L17;
        FrameworkStatsLog.write(183, packageExternalStorageType, 2, packageName);
        return;
    L17:
        return;
    L8:
        if (pkg.isExternalStorage() == false) goto L10;
        FrameworkStatsLog.write(183, packageExternalStorageType, 1, packageName);
    }

    private boolean getPackageSizeInfoLI(String packageName, int userId, PackageStats stats) {
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal packageStateInternal = snapshot.getPackageStateInternal(packageName);
        if (packageStateInternal != null) goto L6;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to find settings for " + packageName);
        return false;
    L6:
        String[] packageNames = {packageName};
        long[] ceDataInodes = {packageStateInternal.getUserStateOrDefault(userId).getCeDataInode()};
        String[] codePaths = {packageStateInternal.getPathString()};
        this.mPm.mInstaller.getAppSize(packageStateInternal.getVolumeUuid(), packageNames, userId, 0, packageStateInternal.getAppId(), ceDataInodes, codePaths, stats);     // Catch: Installer.InstallerException -> L14
        if (PackageManagerServiceUtils.isSystemApp(packageStateInternal) == true) goto L12;
    L16:
        stats.dataSize -= stats.cacheSize;     // Catch: Installer.InstallerException -> L14
        return true;
    L12:
        if (PackageManagerServiceUtils.isUpdatedSystemApp(packageStateInternal) == true) goto L16;
        stats.codeSize = 0;     // Catch: Installer.InstallerException -> L14
    L14:
        e = e;
    L20:
        Slog.w(PackageManagerServiceMonitorEx.TAG, String.valueOf(e));
        return false;
    L18:
        e = e;
        goto L20
    }

    private void prepareUserStorageForMove(String fromVolumeUuid, String toVolumeUuid, int[] userIds) {
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mPm.mInjector.getLocalService(StorageManagerInternal.class);
        ArrayList<UserInfo> users = new ArrayList();
        int r2 = userIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int userId = userIds[r3];
        UserInfo user = this.mPm.mUserManager.getUserInfo(userId);
        users.add(user);
        r3 = r3 + 1;
        goto L3
    L5:
        smInternal.prepareUserStorageForMove(fromVolumeUuid, toVolumeUuid, users);
    }
}
