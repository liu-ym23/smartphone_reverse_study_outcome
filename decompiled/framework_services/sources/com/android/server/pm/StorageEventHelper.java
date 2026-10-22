package com.android.server.pm;

import android.app.ResourcesManager;
import android.content.pm.PackageManager;
import android.content.pm.PackagePartitions;
import android.content.pm.UserInfo;
import android.content.pm.VersionedPackage;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.os.Environment;
import android.os.FileUtils;
import android.os.storage.StorageEventListener;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.os.storage.VolumeInfo;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.policy.AttributeCache;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageEventHelper extends StorageEventListener {
    private final BroadcastHelper mBroadcastHelper;
    private final DeletePackageHelper mDeletePackageHelper;
    final ArraySet<String> mLoadedVolumes;
    private final PackageManagerService mPm;
    private final RemovePackageHelper mRemovePackageHelper;

    public static /* synthetic */ void $r8$lambda$OKPqQvReXscBtU8R4ZUOKIra7y8(StorageEventHelper r0, VolumeInfo r1) {
        r0.lambda$unloadPrivatePackages$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$oGQTujXkyf6hAr1JQHoYLq02Ge0(StorageEventHelper r0, VolumeInfo r1) {
        r0.lambda$loadPrivatePackages$0(r1);
    }

    public StorageEventHelper(PackageManagerService pm, DeletePackageHelper deletePackageHelper, RemovePackageHelper removePackageHelper) {
        this.mLoadedVolumes = new ArraySet();
        this.mPm = pm;
        this.mBroadcastHelper = new BroadcastHelper(this.mPm.mInjector);
        this.mDeletePackageHelper = deletePackageHelper;
        this.mRemovePackageHelper = removePackageHelper;
    }

    public void onVolumeStateChanged(VolumeInfo vol, int oldState, int newState) {
        if (vol.type == 1) goto L5;
        return;
    L5:
        if (vol.state != 2) goto L9;
        String volumeUuid = vol.getFsUuid();
        this.mPm.mUserManager.reconcileUsers(volumeUuid);
        reconcileApps(this.mPm.snapshotComputer(), volumeUuid);
        this.mPm.mInstallerService.onPrivateVolumeMounted(volumeUuid);
        loadPrivatePackages(vol);
        return;
    L9:
        if (vol.state != 5) goto L14;
        unloadPrivatePackages(vol);
        return;
    }

    public void onVolumeForgotten(String fsUuid) {
        if (TextUtils.isEmpty(fsUuid) == false) goto L6;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Forgetting internal storage is probably a mistake; ignoring");
        return;
    L6:
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        List<? extends PackageStateInternal> packages = this.mPm.mSettings.getVolumePackagesLPr(fsUuid);     // Catch: Throwable -> L12
        Iterator<? extends PackageStateInternal> r2 = packages.iterator();     // Catch: Throwable -> L12
    L10:
        if (r2.hasNext() == false) goto L14;
        PackageStateInternal ps = r2.next();     // Catch: Throwable -> L12
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Destroying " + ps.getPackageName() + " because volume was forgotten");     // Catch: Throwable -> L12
        this.mPm.deletePackageVersioned(new VersionedPackage(ps.getPackageName(), -1), new PackageManager.LegacyPackageDeleteObserver(null).getBinder(), 0, 2);     // Catch: Throwable -> L12
        AttributeCache.instance().removePackage(ps.getPackageName());     // Catch: Throwable -> L12
        goto L10
    L14:
        this.mPm.mSettings.onVolumeForgotten(fsUuid);     // Catch: Throwable -> L12
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$loadPrivatePackages$0(VolumeInfo vol) {
        loadPrivatePackagesInner(vol);
    }

    private void loadPrivatePackages(final VolumeInfo vol) {
        this.mPm.mHandler.post(new StorageEventHelper$$ExternalSyntheticLambda0(this, vol));
    }

    private void loadPrivatePackagesInner(VolumeInfo vol) {
        vol = vol;
        String volumeUuid = vol.fsUuid;
        if (TextUtils.isEmpty(volumeUuid) == false) goto L6;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Loading internal storage is probably a mistake; ignoring");
        return;
    L6:
        AppDataHelper appDataHelper = new AppDataHelper(this.mPm);
        ArrayList<PackageFreezer> freezers = new ArrayList();
        ArrayList<AndroidPackage> loaded = new ArrayList();
        int parseFlags = this.mPm.getDefParseFlags() | 8;
        PackageManagerTracedLock r8 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        Settings.VersionInfo ver = this.mPm.mSettings.findOrCreateVersion(volumeUuid);     // Catch: Throwable -> L103
        List<? extends PackageStateInternal> packages = this.mPm.mSettings.getVolumePackagesLPr(volumeUuid);     // Catch: Throwable -> L103
        monitor-exit(r8);     // Catch: Throwable -> L103
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Iterator<? extends PackageStateInternal> r9 = packages.iterator();
    L12:
        if (r9.hasNext() == false) goto L32;
        PackageStateInternal ps = r9.next();
        freezers.add(this.mPm.freezePackage(ps.getPackageName(), -1, "loadPrivatePackagesInner", 13, null));
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        AndroidPackage pkg = this.mPm.initPackageTracedLI(ps.getPath(), parseFlags, 512);     // Catch: Throwable -> L16 PackageManagerException -> L18
        loaded.add(pkg);     // Catch: Throwable -> L16 PackageManagerException -> L18
    L21:
        if (PackagePartitions.FINGERPRINT.equals(ver.fingerprint) == true) goto L23;
        appDataHelper.clearAppDataLIF(ps.getPkg(), -1, 131111);     // Catch: Throwable -> L16
    L23:
        if (installLock == null) goto L12;
        installLock.close();
    L18:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to scan " + ps.getPath() + ": " + e.getMessage());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (installLock == null) goto L149;
        installLock.close();     // Catch: Throwable -> L29
        throw th;
    L29:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L149:
        throw th;
    L32:
        StorageManager sm = (StorageManager) this.mPm.mInjector.getSystemService(StorageManager.class);
        UserManagerInternal umInternal = this.mPm.mInjector.getUserManagerInternal();
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mPm.mInjector.getLocalService(StorageManagerInternal.class);
        Iterator<UserInfo> r14 = this.mPm.mUserManager.getUsers(false).iterator();
    L34:
        if (r14.hasNext() == false) goto L79;
        UserInfo user = r14.next();
        if (StorageManager.isCeStorageUnlocked(user.id) == true) goto L38;
    L40:
        int flags = user.id;
        if (umInternal.isUserRunning(flags) == false) goto L34;
        int flags2 = 1;
    L43:
        int flags3 = flags2;
        if ((vol.disk.flags & 32) != 32) goto L46;
        int flags4 = flags3 | 32;
    L110:
        sm.prepareUserStorage(volumeUuid, user.id, flags4);     // Catch: RuntimeException -> L72
        PackageManagerTracedLock installLock2 = this.mPm.mInstallLock.acquireLock();     // Catch: RuntimeException -> L72
        appDataHelper.reconcileAppsDataLI(volumeUuid, user.id, flags4, true);     // Catch: Throwable -> L61
        if (installLock2 == null) goto L77;
        installLock2.close();     // Catch: RuntimeException -> L58
    L58:
        e = e;
    L76:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to prepare storage: " + e);
    L77:
        appDataHelper = appDataHelper;
        freezers = freezers;
    L61:
        th = move-exception;
        Throwable r2 = th;
    L65:
        if (installLock2 != null) goto L130;
    L71:
        throw r2;     // Catch: RuntimeException -> L58
    L130:
        installLock2.close();     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        r2.addSuppressed(th);     // Catch: RuntimeException -> L58
    L63:
        th = move-exception;
        r2 = th;
    L72:
        e = e;
    L74:
        e = e;
        goto L76
    L46:
        flags4 = flags3;
        goto L110
    L38:
        if (smInternal.isCeStoragePrepared(user.id) == false) goto L40;
        flags2 = 3;
        goto L43
    L79:
        ArrayList<PackageFreezer> freezers2 = freezers;
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        boolean isUpgrade = !PackagePartitions.FINGERPRINT.equals(ver.fingerprint);     // Catch: Throwable -> L84
        if (isUpgrade == false) goto L86;
        PackageManagerServiceUtils.logCriticalInfo(4, "Partitions fingerprint changed from " + ver.fingerprint + " to " + PackagePartitions.FINGERPRINT + "; regranting permissions for " + volumeUuid);     // Catch: Throwable -> L84
    L86:
        this.mPm.mPermissionManager.onStorageVolumeMounted(volumeUuid, isUpgrade);     // Catch: Throwable -> L84
        ver.forceCurrent();     // Catch: Throwable -> L84
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L84
        monitor-exit(r3);     // Catch: Throwable -> L84
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Iterator<PackageFreezer> r0 = freezers2.iterator();
    L90:
        if (r0.hasNext() == false) goto L92;
        PackageFreezer freezer = r0.next();
        freezer.close();
        goto L90
    L92:
        BroadcastHelper r1 = this.mBroadcastHelper;
        PackageManagerService r4 = this.mPm;
        r4.getClass();
        r1.sendResourcesChangedBroadcastAndNotify(new DistractingPackageHelper$$ExternalSyntheticLambda1(r4), true, false, loaded);
        ArraySet<String> r5 = this.mLoadedVolumes;
        monitor-enter(r5);
        this.mLoadedVolumes.add(vol.getId());     // Catch: Throwable -> L97
        monitor-exit(r5);     // Catch: Throwable -> L97
        return;
    L97:
        th = move-exception;
        throw th;
    L84:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L103:
        th = th;
    L120:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L108:
        th = th;
        goto L120
    }

    private /* synthetic */ void lambda$unloadPrivatePackages$1(VolumeInfo vol) {
        unloadPrivatePackagesInner(vol);
    }

    private void unloadPrivatePackages(final VolumeInfo vol) {
        this.mPm.mHandler.post(new StorageEventHelper$$ExternalSyntheticLambda1(this, vol));
    }

    private void unloadPrivatePackagesInner(VolumeInfo vol) {
        String volumeUuid = vol.fsUuid;
        if (TextUtils.isEmpty(volumeUuid) == false) goto L6;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Unloading internal storage is probably a mistake; ignoring");
        return;
    L6:
        int[] userIds = this.mPm.mUserManager.getUserIds();
        ArrayList<AndroidPackage> unloaded = new ArrayList();
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        PackageManagerTracedLock r14 = this.mPm.mLock;     // Catch: Throwable -> L62
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L62
        monitor-enter(r14);     // Catch: Throwable -> L62
        List<? extends PackageStateInternal> packages = this.mPm.mSettings.getVolumePackagesLPr(volumeUuid);     // Catch: Throwable -> L29
        Iterator<? extends PackageStateInternal> r0 = packages.iterator();     // Catch: Throwable -> L29
    L11:
        if (r0.hasNext() == false) goto L44;
        PackageStateInternal ps = r0.next();     // Catch: Throwable -> L29
        if (ps.getPkg() == null) goto L11;
        AndroidPackageInternal r4 = ps.getPkg();     // Catch: Throwable -> L29
        PackageFreezer freezer = this.mPm.freezePackageForDelete(ps.getPackageName(), -1, 1, "unloadPrivatePackagesInner", 13);     // Catch: Throwable -> L29
        if (this.mDeletePackageHelper.deletePackageLIF(ps.getPackageName(), null, false, userIds, 1, new PackageRemovedInfo(), false) == false) goto L26;
        unloaded.add(r4);     // Catch: Throwable -> L24
    L27:
        if (freezer == null) goto L31;
        freezer.close();     // Catch: Throwable -> L29
    L31:
        AttributeCache.instance().removePackage(ps.getPackageName());     // Catch: Throwable -> L29
        goto L11
    L26:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to unload " + ps.getPath());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Throwable r5 = th;
    L37:
        if (freezer == null) goto L94;
        freezer.close();     // Catch: Throwable -> L40
    L95:
        throw r5;     // Catch: Throwable -> L29
    L40:
        th = move-exception;
        r5.addSuppressed(th);     // Catch: Throwable -> L29
        throw r5;     // Catch: Throwable -> L29
    L94:
        throw r5;     // Catch: Throwable -> L29
    L33:
        th = move-exception;
        r5 = th;
    L35:
        th = move-exception;
        r5 = th;
        goto L37
    L44:
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L29
        monitor-exit(r14);     // Catch: Throwable -> L29
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L62
        if (installLock == null) goto L49;
        installLock.close();
    L49:
        BroadcastHelper r1 = this.mBroadcastHelper;
        PackageManagerService r2 = this.mPm;
        r2.getClass();
        r1.sendResourcesChangedBroadcastAndNotify(new DistractingPackageHelper$$ExternalSyntheticLambda1(r2), false, false, unloaded);
        ArraySet<String> r3 = this.mLoadedVolumes;
        monitor-enter(r3);
        this.mLoadedVolumes.remove(vol.getId());     // Catch: Throwable -> L59
        monitor-exit(r3);     // Catch: Throwable -> L59
        ResourcesManager.getInstance().invalidatePath(vol.getPath().getAbsolutePath());
        int i = 0;
    L55:
        if (i >= 3) goto L58;
        System.gc();
        System.runFinalization();
        i = i + 1;
        goto L55
    L58:
        return;
    L59:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        if (installLock == null) goto L96;
        installLock.close();     // Catch: Throwable -> L70
        throw th;
    L70:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L96:
        throw th;
    }

    public void reconcileApps(Computer snapshot, String volumeUuid) {
        List<String> absoluteCodePaths = collectAbsoluteCodePaths(snapshot);
        List<File> filesToDelete = null;
        File[] files = FileUtils.listFilesOrEmpty(Environment.getDataAppDirectory(volumeUuid));
        int r3 = files.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L25;
        File file = files[r5];
        if (ApkLiteParseUtils.isApkFile(file) == true) goto L9;
        if (file.isDirectory() == true) goto L9;
    L11:
        boolean isPackage = false;
    L12:
        if (isPackage == false) goto L24;
        String absolutePath = file.getAbsolutePath();
        boolean pathValid = false;
        int absoluteCodePathCount = absoluteCodePaths.size();
        int i = 0;
    L15:
        if (i >= absoluteCodePathCount) goto L20;
        String absoluteCodePath = absoluteCodePaths.get(i);
        if (absoluteCodePath.startsWith(absolutePath) == true) goto L18;
        i = i + 1;
        goto L15
    L18:
        pathValid = true;
    L20:
        if (pathValid == true) goto L24;
        if (filesToDelete != null) goto L23;
        filesToDelete = new ArrayList();
    L23:
        filesToDelete.add(file);
    L24:
        r5 = r5 + 1;
    L9:
        if (PackageInstallerService.isStageName(file.getName()) == true) goto L11;
        isPackage = true;
        goto L12
    L25:
        if (filesToDelete == null) goto L29;
        int fileToDeleteCount = filesToDelete.size();
        int i2 = 0;
    L27:
        if (i2 >= fileToDeleteCount) goto L37;
        File fileToDelete = filesToDelete.get(i2);
        PackageManagerServiceUtils.logCriticalInfo(5, "Destroying orphaned at " + fileToDelete);
        this.mRemovePackageHelper.removeCodePath(fileToDelete);
        i2 = i2 + 1;
        goto L27
    L37:
        return;
    }

    private List<String> collectAbsoluteCodePaths(Computer snapshot) {
        List<String> codePaths = new ArrayList();
        ArrayMap<String, ? extends PackageStateInternal> packageStates = snapshot.getPackageStates();
        int packageCount = packageStates.size();
        int i = 0;
    L3:
        if (i >= packageCount) goto L6;
        PackageStateInternal ps = packageStates.valueAt(i);
        codePaths.add(ps.getPath().getAbsolutePath());
        i = i + 1;
        goto L3
    L6:
        return codePaths;
    }

    public void dumpLoadedVolumes(PrintWriter pw, DumpState dumpState) {
        if (dumpState.onTitlePrinted() == false) goto L5;
        pw.println();
    L5:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ", 120);
        ipw.println();
        ipw.println("Loaded volumes:");
        ipw.increaseIndent();
        ArraySet<String> r1 = this.mLoadedVolumes;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mLoadedVolumes.size() != 0) goto L12;
        ipw.println("(none)");     // Catch: Throwable -> L10
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L10
        ipw.decreaseIndent();
        return;
    L12:
        int i = 0;
    L14:
        if (i >= this.mLoadedVolumes.size()) goto L16;
        ipw.println(this.mLoadedVolumes.valueAt(i));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L14
    }
}
