package com.android.server.pm;

import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.CreateAppDataArgs;
import android.os.CreateAppDataResult;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Trace;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.os.storage.VolumeInfo;
import android.security.AndroidKeyStoreMaintenance;
import android.text.TextUtils;
import android.util.Slog;
import android.util.TimingsTraceLog;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.Preconditions;
import com.android.server.SystemServerInitThreadPool;
import com.android.server.pm.dex.ArtManagerService;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.SELinuxUtil;
import dalvik.system.VMRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class AppDataHelper {
    private static final boolean DEBUG_APP_DATA = false;
    private final ArtManagerService mArtManagerService;
    private final PackageManagerServiceInjector mInjector;
    private final Installer mInstaller;
    private final PackageManagerService mPm;

    public static /* synthetic */ void $r8$lambda$2BeLf97yLOm88wYtplb9WF4eyqo(AppDataHelper r0, boolean r1, PackageSetting r2, int r3, int r4) {
        r0.lambda$prepareAppDataAndMigrate$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$5xplHV_4vos93_1QnUOg72Ugz-w, reason: not valid java name */
    public static /* synthetic */ void m6598$r8$lambda$5xplHV_4vos93_1QnUOg72Ugzw(AppDataHelper r0, String r1, String r2, int r3, int r4, CreateAppDataArgs r5, int r6, PackageSetting r7, AndroidPackage r8, CreateAppDataResult r9, Throwable r10) {
        r0.lambda$prepareAppData$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$EcbQ0RDhsp50zlsyfvd3o8Q6RFA(UserManagerInternal r0, int r1, PackageSetting r2, StorageManagerInternal r3) {
        lambda$prepareAppDataPostCommitLIF$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$YFf7DSMx-MyHV4nCg6MSaBHl8TQ, reason: not valid java name */
    public static /* synthetic */ void m6599$r8$lambda$YFf7DSMxMyHV4nCg6MSaBHl8TQ(AppDataHelper r0, List r1, int r2) {
        r0.lambda$fixAppsDataOnBoot$3(r1, r2);
    }

    AppDataHelper(PackageManagerService pm) {
        this.mPm = pm;
        this.mInjector = this.mPm.mInjector;
        this.mInstaller = this.mInjector.getInstaller();
        this.mArtManagerService = this.mInjector.getArtManagerService();
    }

    public void prepareAppDataAfterInstallLIF(AndroidPackage pkg) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(pkg.getPackageName());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        prepareAppDataPostCommitLIF(ps, 0, getInstalledUsersForPackage(ps));
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private int[] getInstalledUsersForPackage(PackageSetting ps) {
        UserManagerInternal umInternal = this.mInjector.getUserManagerInternal();
        List<UserInfo> users = umInternal.getUsers(false);
        int[] userIds = new int[users.size()];
        int userIdsCount = 0;
        int i = 0;
        int size = users.size();
    L3:
        if (i >= size) goto L9;
        int userId = users.get(i).id;
        if (ps.getInstalled(userId) == false) goto L7;
        userIds[userIdsCount] = userId;
        userIdsCount = userIdsCount + 1;
    L7:
        i = i + 1;
        goto L3
    L9:
        return Arrays.copyOf(userIds, userIdsCount);
    }

    public void prepareAppDataPostCommitLIF(final PackageSetting ps, int previousAppId, int[] userIds) {
        StringBuilder r2 = new StringBuilder();
        r2.append("prepareAppDataPostCommitLIF: start packageName=");
        r2.append(ps.getPackageName());
        r2.append(" previousAppId=");
        int r7 = previousAppId;
        r2.append(r7);
        r2.append(" userIds=");
        r2.append(Arrays.toString(userIds));
        Slog.d(PackageManagerServiceMonitorEx.TAG, r2.toString());
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        this.mPm.mSettings.writeKernelMappingLPr(ps);     // Catch: Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (shouldHaveAppStorage(ps) == true) goto L10;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Skipping preparing app data for " + ps.getPackageName());
        Slog.d(PackageManagerServiceMonitorEx.TAG, "prepareAppDataPostCommitLIF: skip no app storage packageName=" + ps.getPackageName());
        return;
    L10:
        Installer.Batch batch = new Installer.Batch();
        final UserManagerInternal umInternal = this.mInjector.getUserManagerInternal();
        final StorageManagerInternal smInternal = (StorageManagerInternal) this.mInjector.getLocalService(StorageManagerInternal.class);
        int r4 = userIds.length;
        int r11 = 0;
    L11:
        if (r11 >= r4) goto L29;
        final int userId = userIds[r11];
        if (StorageManager.isCeStorageUnlocked(userId) == false) goto L18;
        if (smInternal.isCeStoragePrepared(userId) == false) goto L18;
        int flags = 3;
    L20:
        logPrepareAppDataPostCommitState("enqueue", ps, userId, flags);
        prepareAppData(batch, ps, r7, userId, flags).thenRun(new AppDataHelper$$ExternalSyntheticLambda3(umInternal, userId, ps, smInternal));
    L28:
        r11 = r11 + 1;
        r7 = previousAppId;
    L18:
        if (umInternal.isUserRunning(userId) == false) goto L21;
        flags = 1;
        goto L20
    L21:
        StringBuilder r9 = new StringBuilder();
        r9.append("prepareAppDataPostCommitLIF: skip user not running packageName=");
        r9.append(ps.getPackageName());
        r9.append(" userId=");
        r9.append(userId);
        r9.append(" ceStorageUnlocked=");
        r9.append(StorageManager.isCeStorageUnlocked(userId));
        r9.append(" ceStoragePrepared=");
        if (smInternal != null) goto L24;
    L26:
        boolean r12 = false;
    L27:
        r9.append(r12);
        r9.append(" ceDataInode=");
        r9.append(ps.getCeDataInode(userId));
        r9.append(" deDataInode=");
        r9.append(ps.getDeDataInode(userId));
        Slog.d(PackageManagerServiceMonitorEx.TAG, r9.toString());
        goto L28
    L24:
        if (smInternal.isCeStoragePrepared(userId) == false) goto L26;
        r12 = true;
        goto L27
    L29:
        executeBatchLI(batch);
        Slog.d(PackageManagerServiceMonitorEx.TAG, "prepareAppDataPostCommitLIF: end packageName=" + ps.getPackageName() + " userIds=" + Arrays.toString(userIds));
        return;
    L31:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$prepareAppDataPostCommitLIF$0(UserManagerInternal umInternal, int userId, PackageSetting ps, StorageManagerInternal smInternal) {
        if (umInternal.isUserUnlockingOrUnlocked(userId) == false) goto L6;
        int uid = UserHandle.getUid(userId, ps.getAppId());
        smInternal.prepareAppDataAfterInstall(ps.getPackageName(), uid);
        return;
    }

    private void executeBatchLI(Installer.Batch batch) {
        batch.execute(this.mInstaller);     // Catch: Installer.InstallerException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to execute pending operations", e);
    }

    private void prepareAppDataAndMigrate(Installer.Batch batch, PackageStateInternal psi, final int userId, final int flags, final boolean maybeMigrateAppData) {
        if (psi == null) goto L24;
        if (psi.getPkg() == null) goto L24;
        if (shouldHaveAppStorage(psi) == true) goto L10;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Skipping preparing app data for " + psi.getPackageName());
        return;
    L10:
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        final PackageSetting ps = this.mPm.mSettings.getPackageLPr(psi.getPackageName());     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        prepareAppData(batch, ps, -1, userId, flags).thenRun(new AppDataHelper$$ExternalSyntheticLambda0(this, maybeMigrateAppData, ps, userId, flags));
        return;
    L16:
        th = th;
    L26:
        Throwable r9 = th;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw r9;
    L21:
        th = th;
    L24:
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Package was null!", new Throwable());
    }

    private /* synthetic */ void lambda$prepareAppDataAndMigrate$1(boolean maybeMigrateAppData, PackageSetting ps, int userId, int flags) {
        if (maybeMigrateAppData == false) goto L7;
        if (maybeMigrateAppDataLIF(ps, userId) == false) goto L7;
        Installer.Batch batchInner = new Installer.Batch();
        prepareAppData(batchInner, ps, -1, userId, flags);
        executeBatchLI(batchInner);
        return;
    }

    private CompletableFuture<?> prepareAppData(Installer.Batch batch, final PackageSetting ps, final int previousAppId, final int userId, final int flags) {
        final String packageName = ps.getPackageName();
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        String seInfoUser = SELinuxUtil.getSeinfoUser(ps.readUserState(userId));     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        final AndroidPackageInternal r9 = ps.getPkg();
        final String volumeUuid = ps.getVolumeUuid();
        int appId = ps.getAppId();
        String pkgSeInfo = ps.getSeInfo();
        Preconditions.checkNotNull(pkgSeInfo);
        String seInfo = pkgSeInfo + seInfoUser;
        int targetSdkVersion = ps.getTargetSdkVersion();
        if (ps.getUsesSdkLibraries().length <= 0) goto L11;
        boolean r3 = true;
    L10:
        boolean usesSdk = r3;
        final CreateAppDataArgs args = Installer.buildCreateAppDataArgs(volumeUuid, packageName, userId, flags, appId, seInfo, targetSdkVersion, usesSdk);
        args.previousAppId = previousAppId;
        return batch.createAppData(args).whenComplete(new AppDataHelper$$ExternalSyntheticLambda1(this, packageName, volumeUuid, userId, flags, args, previousAppId, ps, r9));
    L11:
        r3 = false;
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$prepareAppData$2(String packageName, String volumeUuid, int userId, int flags, CreateAppDataArgs args, int previousAppId, PackageSetting ps, AndroidPackage pkg, CreateAppDataResult createAppDataResult, Throwable e) {
        if (e == null) goto L18;
        PackageManagerServiceUtils.logCriticalInfo(5, "Failed to create app data for " + packageName + ", but trying to recover: " + e);
        destroyAppDataLeafLIF(packageName, volumeUuid, userId, flags);
        CreateAppDataResult createAppDataResult2 = this.mInstaller.createAppData(args);     // Catch: Installer.InstallerException -> L13
        PackageManagerServiceUtils.logCriticalInfo(3, "Recovery succeeded!");     // Catch: Installer.InstallerException -> L11
    L19:
        long ceDataInode = createAppDataResult2.ceDataInode;
        long deDataInode = createAppDataResult2.deDataInode;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "prepareAppData: createAppData result packageName=" + packageName + " userId=" + userId + " flags=0x" + Integer.toHexString(flags) + " ceDataInode=" + ceDataInode + " deDataInode=" + deDataInode + " previousAppId=" + previousAppId);
        if ((flags & 2) == 0) goto L33;
        if (ceDataInode == (-1)) goto L33;
        PackageManagerTracedLock r8 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        ps.setCeDataInode(ceDataInode, userId);     // Catch: Throwable -> L28
        monitor-exit(r8);     // Catch: Throwable -> L28
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L28:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L33:
        if ((flags & 1) != 0) goto L35;
    L45:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "prepareAppData: inode state updated packageName=" + packageName + " userId=" + userId + " flags=0x" + Integer.toHexString(flags) + " storedCeDataInode=" + ps.getCeDataInode(userId) + " storedDeDataInode=" + ps.getDeDataInode(userId));
        if (pkg == null) goto L59;
        prepareAppDataContentsLeafLIF(pkg, ps, userId, flags);
        return;
    L59:
        return;
    L35:
        if (deDataInode == (-1)) goto L45;
        PackageManagerTracedLock r9 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        ps.setDeDataInode(deDataInode, userId);     // Catch: Throwable -> L41
        monitor-exit(r9);     // Catch: Throwable -> L41
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L41:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L17:
        PackageManagerServiceUtils.logCriticalInfo(3, "Recovery failed!");
    L14:
        createAppDataResult2 = createAppDataResult;
        goto L17
    L18:
        createAppDataResult2 = createAppDataResult;
        goto L19
    }

    public void prepareAppDataContentsLIF(AndroidPackage pkg, PackageStateInternal pkgSetting, int userId, int flags) {
        if (pkg != null) goto L5;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Package was null!", new Throwable());
        return;
    L5:
        prepareAppDataContentsLeafLIF(pkg, pkgSetting, userId, flags);
    }

    private void prepareAppDataContentsLeafLIF(AndroidPackage pkg, PackageStateInternal pkgSetting, int userId, int flags) {
        String volumeUuid = pkg.getVolumeUuid();
        String packageName = pkg.getPackageName();
        if ((flags & 2) == 0) goto L20;
        if (pkgSetting != null) goto L6;
        String primaryCpuAbi = AndroidPackageUtils.getRawPrimaryCpuAbi(pkg);
    L7:
        if (primaryCpuAbi != null) goto L9;
        return;
    L9:
        if (VMRuntime.is64BitAbi(primaryCpuAbi) == true) goto L22;
        String nativeLibPath = pkg.getNativeLibraryDir();
        if (new File(nativeLibPath).exists() == true) goto L18;
        return;
    L18:
        this.mInstaller.linkNativeLibraryDirectory(volumeUuid, packageName, nativeLibPath, userId);     // Catch: Installer.InstallerException -> L15
        return;
    L15:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to link native for " + packageName + ": " + e);
        return;
    L22:
        return;
    L6:
        primaryCpuAbi = pkgSetting.getPrimaryCpuAbi();
        goto L7
    }

    private boolean maybeMigrateAppDataLIF(PackageSetting ps, int userId) {
        if (ps.isSystem() == true) goto L5;
        return false;
    L5:
        if (StorageManager.isFileEncrypted() == false) goto L7;
        return false;
    L7:
        if (ps.isDefaultToDeviceProtectedStorage() == false) goto L9;
        int storageTarget = 1;
    L17:
        this.mInstaller.migrateAppData(ps.getVolumeUuid(), ps.getPackageName(), userId, storageTarget);     // Catch: Installer.InstallerException -> L12
    L14:
        return true;
    L12:
        e = move-exception;
        PackageManagerServiceUtils.logCriticalInfo(5, "Failed to migrate " + ps.getPackageName() + ": " + e.getMessage());
        goto L14
    L9:
        storageTarget = 2;
        goto L17
    }

    public void reconcileAppsData(int userId, int flags, boolean migrateAppsData) {
        StorageManager storage = (StorageManager) this.mInjector.getSystemService(StorageManager.class);
        Iterator r1 = storage.getWritablePrivateVolumes().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        VolumeInfo vol = (VolumeInfo) r1.next();
        String volumeUuid = vol.getFsUuid();
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        reconcileAppsDataLI(volumeUuid, userId, flags, migrateAppsData);     // Catch: Throwable -> L10
        if (installLock == null) goto L4;
        installLock.close();
    L10:
        th = move-exception;
        if (installLock != null) goto L20;
    L16:
        throw th;
    L20:
        installLock.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    void reconcileAppsDataLI(String volumeUuid, int userId, int flags, boolean migrateAppData) {
        reconcileAppsDataLI(volumeUuid, userId, flags, migrateAppData, false);
    }

    private List<String> reconcileAppsDataLI(String volumeUuid, int userId, int flags, boolean migrateAppData, boolean onlyCoreApps) {
        String r3 = volumeUuid;
        int r5 = userId;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "reconcileAppsData for " + r3 + " u" + r5 + " 0x" + Integer.toHexString(flags) + " migrateAppData=" + migrateAppData);
        if (onlyCoreApps == false) goto L5;
        List<String> r0 = new ArrayList();
    L6:
        List<String> result = r0;
        this.mInstaller.cleanupInvalidPackageDirs(r3, r5, flags);     // Catch: Installer.InstallerException -> L9
    L11:
        File ceDir = Environment.getDataUserCeDirectory(volumeUuid, userId);
        File deDir = Environment.getDataUserDeDirectory(volumeUuid, userId);
        Computer snapshot = this.mPm.snapshotComputer();
        String r4 = "Failed to destroy: ";
        String r6 = " due to: ";
        String r7 = "Destroying ";
        if ((flags & 2) != 0) goto L14;
        Computer snapshot2 = snapshot;
        String r10 = "Failed to destroy: ";
        String r13 = " due to: ";
        String r14 = "Destroying ";
    L40:
        if ((flags & 1) == 0) goto L59;
        File[] files = FileUtils.listFilesOrEmpty(deDir);
        int r8 = files.length;
        int r9 = 0;
    L42:
        if (r9 >= r8) goto L58;
        File file = files[r9];
        int r11 = r8;
        String packageName = file.getName();
        assertPackageStorageValid(snapshot2, r3, packageName, r5);     // Catch: PackageManagerException -> L46
        File[] files2 = files;
        r3 = r3;
        int r18 = r9;
        int r21 = r11;
    L57:
        r9 = r18 + 1;
        r3 = r3;
        files = files2;
        r8 = r21;
    L46:
        e = move-exception;
        StringBuilder r1 = new StringBuilder();
        r1.append(r14);
        r1.append(file);
        r1.append(r13);
        r18 = r9;
        r1.append(e);
        files2 = files;
        PackageManagerServiceUtils.logCriticalInfo(5, r1.toString());
        r21 = r11;
        this.mInstaller.destroyAppData(r3, packageName, r5, 1, 0);     // Catch: Installer.InstallerException -> L52
        r3 = r3;
    L52:
        e2 = e;
    L56:
        PackageManagerServiceUtils.logCriticalInfo(5, r10 + e2);
    L54:
        e2 = e;
        r21 = r11;
        goto L56
    L58:
        String r12 = r3;
    L60:
        long r15 = 262144;
        Trace.traceBegin(262144, "prepareAppDataAndMigrate");
        Installer.Batch batch = new Installer.Batch();
        List<? extends PackageStateInternal> packages = snapshot2.getVolumePackages(r12);
        Iterator<? extends PackageStateInternal> r16 = packages.iterator();
        int preparedCount = 0;
    L62:
        if (r16.hasNext() == false) goto L77;
        PackageStateInternal ps = r16.next();
        String packageName2 = ps.getPackageName();
        if (ps.getPkg() == null) goto L65;
        long r17 = r15;
        if (onlyCoreApps == false) goto L73;
        if (ps.getPkg().isCoreApp() == true) goto L73;
        result.add(packageName2);
    L71:
        r15 = r17;
    L73:
        if (ps.getUserStateOrDefault(r5).isInstalled() == false) goto L76;
        prepareAppDataAndMigrate(batch, ps, r5, flags, migrateAppData);
        preparedCount = preparedCount + 1;
    L76:
        r5 = userId;
        r15 = r17;
        goto L62
    L65:
        StringBuilder r19 = new StringBuilder();
        r17 = r15;
        r19.append("Odd, missing scanned package ");
        r19.append(packageName2);
        Slog.w(PackageManagerServiceMonitorEx.TAG, r19.toString());
        goto L71
    L77:
        executeBatchLI(batch);
        Trace.traceEnd(r15);
        Slog.v(PackageManagerServiceMonitorEx.TAG, "reconcileAppsData finished " + preparedCount + " packages");
        return result;
    L59:
        r12 = r3;
        goto L60
    L14:
        if (StorageManager.isFileEncrypted() == true) goto L16;
    L20:
        File[] files3 = FileUtils.listFilesOrEmpty(ceDir);
        int r110 = files3.length;
        File[] files4 = files3;
        int r20 = 0;
    L21:
        if (r20 >= r110) goto L37;
        int r111 = r20;
        File file2 = files4[r111];
        String r22 = r4;
        String packageName3 = file2.getName();
        assertPackageStorageValid(snapshot, r3, packageName3, r5);     // Catch: PackageManagerException -> L25
        Computer snapshot3 = snapshot;
        int r23 = r111;
        String r112 = r22;
        File ceDir2 = ceDir;
        File[] files5 = files4;
        String r113 = r7;
        int r114 = r110;
        String r115 = r6;
    L36:
        r20 = r23 + 1;
        snapshot = snapshot3;
        r4 = r112;
        r6 = r115;
        r7 = r113;
        r110 = r114;
        ceDir = ceDir2;
        files4 = files5;
    L25:
        e = move-exception;
        StringBuilder r2 = new StringBuilder();
        r2.append(r7);
        r2.append(file2);
        r2.append(r6);
        String r24 = r6;
        r2.append(e);
        Computer snapshot4 = snapshot;
        PackageManagerServiceUtils.logCriticalInfo(5, r2.toString());
        r112 = r22;
        snapshot3 = snapshot4;
        files5 = files4;
        r23 = r111;
        r114 = r110;
        ceDir2 = ceDir;
        r115 = r24;
        r113 = r7;
        this.mInstaller.destroyAppData(r3, packageName3, r5, 2, 0);     // Catch: Installer.InstallerException -> L31
    L31:
        e2 = e;
    L35:
        PackageManagerServiceUtils.logCriticalInfo(5, r112 + e2);
    L33:
        e2 = e;
        r112 = r22;
        snapshot3 = snapshot4;
        files5 = files4;
        r23 = r111;
        r114 = r110;
        ceDir2 = ceDir;
        r115 = r24;
        r113 = r7;
        goto L35
    L37:
        snapshot2 = snapshot;
        r10 = r4;
        r13 = r6;
        r14 = r7;
        goto L40
    L16:
        if (StorageManager.isCeStorageUnlocked(r5) == true) goto L20;
        throw new RuntimeException("Yikes, someone asked us to reconcile CE storage while " + r5 + " was still locked; this would have caused massive data loss!");
    L9:
        e = move-exception;
        PackageManagerServiceUtils.logCriticalInfo(5, "Failed to cleanup deleted dirs: " + e);
        goto L11
    L5:
        r0 = null;
        goto L6
    }

    private void assertPackageStorageValid(Computer snapshot, String volumeUuid, String packageName, int userId) throws PackageManagerException {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState == null) goto L21;
        if (TextUtils.equals(volumeUuid, packageState.getVolumeUuid()) == false) goto L19;
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        if (userState.isInstalled() == true) goto L14;
        if (userState.dataExists() == true) goto L14;
        throw PackageManagerException.ofInternalError("Package " + packageName + " not installed for user " + userId + " or was deleted without DELETE_KEEP_DATA", -9);
    L14:
        if (shouldHaveAppStorage(packageState) == false) goto L17;
        return;
    L17:
        throw PackageManagerException.ofInternalError("Package " + packageName + " shouldn't have storage", -10);
    L19:
        throw PackageManagerException.ofInternalError("Package " + packageName + " found on unknown volume " + volumeUuid + "; expected volume " + packageState.getVolumeUuid(), -8);
    L21:
        throw PackageManagerException.ofInternalError("Package " + packageName + " is unknown", -7);
    }

    public Future<?> fixAppsDataOnBoot() {
        if (StorageManager.isFileEncrypted() == false) goto L5;
        final int storageFlags = 1;
    L6:
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        final List<String> deferPackages = reconcileAppsDataLI(StorageManager.UUID_PRIVATE_INTERNAL, 0, storageFlags, true, true);     // Catch: Throwable -> L14
        if (installLock == null) goto L12;
        installLock.close();
    L12:
        Future<?> prepareAppDataFuture = SystemServerInitThreadPool.submit(new AppDataHelper$$ExternalSyntheticLambda2(this, deferPackages, storageFlags), "prepareAppData");
        return prepareAppDataFuture;
    L14:
        th = th;
    L15:
        Throwable r2 = th;
        if (installLock == null) goto L30;
        installLock.close();     // Catch: Throwable -> L21
        throw r2;
    L21:
        th = move-exception;
        r2.addSuppressed(th);
        throw r2;
    L30:
        throw r2;
    L16:
        th = th;
        goto L15
    L5:
        storageFlags = 3;
        goto L6
    }

    private /* synthetic */ void lambda$fixAppsDataOnBoot$3(List deferPackages, int storageFlags) {
        TimingsTraceLog traceLog = new TimingsTraceLog("SystemServerTimingAsync", 262144);
        traceLog.traceBegin("AppDataFixup");
        this.mInstaller.fixupAppData(StorageManager.UUID_PRIVATE_INTERNAL, 3);     // Catch: Installer.InstallerException -> L5
    L7:
        traceLog.traceEnd();
        traceLog.traceBegin("AppDataPrepare");
        if (deferPackages == null) goto L38;
        if (deferPackages.isEmpty() == true) goto L51;
        Installer.Batch batch = new Installer.Batch();
        Iterator r3 = deferPackages.iterator();
        int count = 0;
    L14:
        if (r3.hasNext() == false) goto L23;
        String pkgName = (String) r3.next();
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal packageStateInternal = snapshot.getPackageStateInternal(pkgName);
        if (packageStateInternal != null) goto L18;
        int storageFlags2 = storageFlags;
    L22:
        storageFlags = storageFlags2;
        goto L14
    L18:
        if (packageStateInternal.getUserStateOrDefault(0).isInstalled() == false) goto L20;
        storageFlags2 = storageFlags;
        prepareAppDataAndMigrate(batch, packageStateInternal, 0, storageFlags2, true);
        count = count + 1;
        goto L22
    L20:
        storageFlags2 = storageFlags;
        goto L22
    L23:
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        executeBatchLI(batch);     // Catch: Throwable -> L29
        if (installLock == null) goto L27;
        installLock.close();
    L27:
        traceLog.traceEnd();
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Deferred reconcileAppsData finished " + count + " packages");
        return;
    L29:
        th = move-exception;
        if (installLock == null) goto L49;
        installLock.close();     // Catch: Throwable -> L34
        throw th;
    L34:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L49:
        throw th;
    L51:
        return;
    L38:
        return;
    L5:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Trouble fixing GIDs", e);
        goto L7
    }

    void clearAppDataLIF(AndroidPackage pkg, int userId, int flags) {
        if (pkg != null) goto L4;
        return;
    L4:
        clearAppDataLeafLIF(pkg.getPackageName(), pkg.getVolumeUuid(), userId, flags);
        if ((131072 & flags) != 0) goto L8;
        clearAppProfilesLIF(pkg);
        return;
    }

    void clearAppDataLeafLIF(String packageName, String volumeUuid, int userId, int flags) {
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal packageStateInternal = snapshot.getPackageStateInternal(packageName);
        int[] r4 = this.mPm.resolveUserIds(userId);
        int r5 = r4.length;
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L14;
        int realUserId = r4[r6];
        if (packageStateInternal == null) goto L8;
        long r7 = packageStateInternal.getUserStateOrDefault(realUserId).getCeDataInode();
    L7:
        long ceDataInode = r7;
        this.mInstaller.clearAppData(volumeUuid, packageName, realUserId, flags, ceDataInode);     // Catch: Installer.InstallerException -> L11
    L13:
        r6 = r6 + 1;
    L11:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, String.valueOf(e));
        goto L13
    L8:
        r7 = 0;
        goto L7
    }

    void clearAppProfilesLIF(AndroidPackage pkg) {
        if (pkg != null) goto L5;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Package was null!", new Throwable());
        return;
    L5:
        destroyAppProfilesLIF(pkg.getPackageName());
    }

    public void destroyAppDataLIF(AndroidPackage pkg, int userId, int flags) {
        if (pkg != null) goto L5;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Package was null!", new Throwable());
        return;
    L5:
        destroyAppDataLeafLIF(pkg.getPackageName(), pkg.getVolumeUuid(), userId, flags);
    }

    private void destroyAppDataLeafLIF(String packageName, String volumeUuid, int userId, int flags) {
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal packageStateInternal = snapshot.getPackageStateInternal(packageName);
        int[] r4 = this.mPm.resolveUserIds(userId);
        int r5 = r4.length;
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L14;
        int realUserId = r4[r6];
        if (packageStateInternal == null) goto L8;
        long r7 = packageStateInternal.getUserStateOrDefault(realUserId).getCeDataInode();
    L7:
        long ceDataInode = r7;
        this.mInstaller.destroyAppData(volumeUuid, packageName, realUserId, flags, ceDataInode);     // Catch: Installer.InstallerException -> L11
    L13:
        this.mPm.getDexManager().notifyPackageDataDestroyed(packageName, userId);
        this.mPm.getDynamicCodeLogger().notifyPackageDataDestroyed(packageName, userId);
        r6 = r6 + 1;
    L11:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, String.valueOf(e));
        goto L13
    L8:
        r7 = 0;
        goto L7
    }

    void destroyAppProfilesLIF(String packageName) {
        if (DexOptHelper.artManagerLocalIsInitialized() == true) goto L5;
        return;
    L5:
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();
        DexOptHelper.getArtManagerLocal().clearAppProfiles(snapshot, packageName);     // Catch: Throwable -> L8 IllegalArgumentException -> L10
    L12:
        if (snapshot == null) goto L26;
        snapshot.close();
        return;
    L26:
        return;
    L8:
        th = move-exception;
        if (snapshot != null) goto L23;
    L20:
        throw th;
    L23:
        snapshot.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
    L10:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, e);     // Catch: Throwable -> L8
        goto L12
    }

    private boolean shouldHaveAppStorage(PackageStateInternal ps) {
        if (ps.getPkg() != null) goto L5;
        return true;
    L5:
        PackageManager.Property noAppDataProp = (PackageManager.Property) ps.getPkg().getProperties().get("android.internal.PROPERTY_NO_APP_DATA_STORAGE");
        if (noAppDataProp == null) goto L10;
        if (noAppDataProp.getBoolean() == false) goto L10;
    L12:
        return false;
    L10:
        if (ps.getAppId() < 0) goto L12;
        return true;
    }

    public void clearKeystoreData(int userId, int appId) {
        if (appId >= 0) goto L4;
        return;
    L4:
        int[] r0 = this.mPm.resolveUserIds(userId);
        int r1 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L7;
        int realUserId = r0[r3];
        AndroidKeyStoreMaintenance.clearNamespace(0, UserHandle.getUid(realUserId, appId));
        r3 = r3 + 1;
        goto L5
    }

    protected void destroyExternalAppData(String packageName, int userId, int flags) {
        this.mPm.getObricExt().destroyExternalAppData(packageName, userId, flags, this.mInstaller);
    }

    private void logPrepareAppDataPostCommitState(String stage, PackageSetting ps, int userId, int flags) {
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mInjector.getLocalService(StorageManagerInternal.class);
        UserManagerInternal umInternal = this.mInjector.getUserManagerInternal();
        File ceDir = Environment.getDataUserCePackageDirectory(ps.getVolumeUuid(), userId, ps.getPackageName());
        File deDir = Environment.getDataUserDePackageDirectory(ps.getVolumeUuid(), userId, ps.getPackageName());
        StringBuilder r4 = new StringBuilder();
        r4.append("prepareAppDataPostCommitLIF: ");
        r4.append(stage);
        r4.append(" packageName=");
        r4.append(ps.getPackageName());
        r4.append(" userId=");
        r4.append(userId);
        r4.append(" flags=0x");
        r4.append(Integer.toHexString(flags));
        r4.append(" ceStorageUnlocked=");
        r4.append(StorageManager.isCeStorageUnlocked(userId));
        r4.append(" ceStoragePrepared=");
        if (smInternal != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        r4.append(r5);
        r4.append(" userRunning=");
        r4.append(umInternal.isUserRunning(userId));
        r4.append(" ceDataInode=");
        r4.append(ps.getCeDataInode(userId));
        r4.append(" deDataInode=");
        r4.append(ps.getDeDataInode(userId));
        r4.append(" ceDirExists=");
        r4.append(ceDir.exists());
        r4.append(" deDirExists=");
        r4.append(deDir.exists());
        r4.append(" ceDir=");
        r4.append(ceDir);
        r4.append(" deDir=");
        r4.append(deDir);
        Slog.d(PackageManagerServiceMonitorEx.TAG, r4.toString());
        return;
    L5:
        if (smInternal.isCeStoragePrepared(userId) == false) goto L7;
        r5 = true;
        goto L8
    }
}
