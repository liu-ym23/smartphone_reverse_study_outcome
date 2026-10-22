package com.android.server.pm;

import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.PackageLite;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.Environment;
import android.os.Trace;
import android.os.incremental.IncrementalManager;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageLegacyUtils;
import com.android.internal.pm.parsing.pkg.PackageImpl;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.util.ArrayUtils;
import com.android.server.pm.parsing.PackageCacher;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.File;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class RemovePackageHelper {
    private final AppDataHelper mAppDataHelper;
    private final BroadcastHelper mBroadcastHelper;
    private final IncrementalManager mIncrementalManager;
    private final Installer mInstaller;
    private final PermissionManagerServiceInternal mPermissionManager;
    private final PackageManagerService mPm;
    private final SharedLibrariesImpl mSharedLibraries;

    public static /* synthetic */ void $r8$lambda$1W3ehgD8MEpq955kSQ4lXmg6q64(RemovePackageHelper r0, SparseBooleanArray r1, PreferredActivityHelper r2) {
        r0.lambda$clearPackageStateForUserLIF$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZTspOFFzqQnnQ7fAaVtXNVGEwRE(RemovePackageHelper r0, PackageSetting r1, int r2) {
        r0.lambda$clearPackageStateForUserLIF$1(r1, r2);
    }

    RemovePackageHelper(PackageManagerService pm, AppDataHelper appDataHelper, BroadcastHelper broadcastHelper) {
        this.mPm = pm;
        this.mIncrementalManager = this.mPm.mInjector.getIncrementalManager();
        this.mInstaller = this.mPm.mInjector.getInstaller();
        this.mPermissionManager = this.mPm.mInjector.getPermissionManagerServiceInternal();
        this.mSharedLibraries = this.mPm.mInjector.getSharedLibrariesImpl();
        this.mAppDataHelper = appDataHelper;
        this.mBroadcastHelper = broadcastHelper;
    }

    public void removeCodePath(File codePath) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        removeCodePathLI(codePath);     // Catch: Throwable -> L7
        if (installLock == null) goto L18;
        installLock.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (installLock != null) goto L16;
    L13:
        throw th;
    L16:
        installLock.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    private void removeCodePathLI(File codePath) {
        if (codePath != null) goto L4;
        return;
    L4:
        if (codePath.exists() == true) goto L7;
        return;
    L7:
        if (codePath.isDirectory() == false) goto L28;
        File codePathParent = codePath.getParentFile();
        boolean needRemoveParent = codePathParent.getName().startsWith("~~");
    L14:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to remove code path", e);
        return;
    L10:
        if (this.mIncrementalManager != null) goto L12;
    L16:
        boolean isIncremental = false;
    L18:
        if (isIncremental == false) goto L22;
        if (needRemoveParent == false) goto L21;
        this.mIncrementalManager.rmPackageDir(codePathParent);     // Catch: Installer.InstallerException -> L14
        goto L22
    L21:
        this.mIncrementalManager.rmPackageDir(codePath);     // Catch: Installer.InstallerException -> L14
    L22:
        String packageName = codePath.getName();     // Catch: Installer.InstallerException -> L14
        this.mInstaller.rmPackageDir(packageName, codePath.getAbsolutePath());     // Catch: Installer.InstallerException -> L14
        if (needRemoveParent == false) goto L35;
        this.mInstaller.rmPackageDir(packageName, codePathParent.getAbsolutePath());     // Catch: Installer.InstallerException -> L14
        removeCachedResult(codePathParent);     // Catch: Installer.InstallerException -> L14
        return;
    L35:
        return;
    L12:
        if (IncrementalManager.isIncrementalPath(codePath.getAbsolutePath()) == false) goto L16;
        isIncremental = true;
        goto L18
    L28:
        codePath.delete();
    }

    private void removeCachedResult(File codePath) {
        if (this.mPm.getCacheDir() != null) goto L5;
        return;
    L5:
        PackageCacher cacher = new PackageCacher(this.mPm.getCacheDir());
        cacher.cleanCachedResult(codePath);
    }

    public void removePackage(AndroidPackage pkg, boolean chatty) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        removePackageLI(pkg, chatty);     // Catch: Throwable -> L7
        if (installLock == null) goto L18;
        installLock.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (installLock != null) goto L16;
    L13:
        throw th;
    L16:
        installLock.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    private void removePackageLI(AndroidPackage pkg, boolean chatty) {
        PackageStateInternal ps = this.mPm.snapshotComputer().getPackageStateInternal(pkg.getPackageName());
        if (ps == null) goto L5;
        removePackageLI(ps.getPackageName(), chatty);
        return;
    L5:
        if (chatty == false) goto L9;
        Log.d(PackageManagerServiceMonitorEx.TAG, "Not removing package " + pkg.getPackageName() + "; mExtras == null");
        return;
    }

    private void removePackageLI(String packageName, boolean chatty) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        AndroidPackage removedPackage = this.mPm.mPackages.remove(packageName);     // Catch: Throwable -> L7
        if (removedPackage == null) goto L9;
        cleanPackageDataStructuresLILPw(removedPackage, AndroidPackageLegacyUtils.isSystem(removedPackage), chatty);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void cleanPackageDataStructuresLILPw(AndroidPackage pkg, boolean isSystemApp, boolean chatty) {
        this.mPm.mComponentResolver.removeAllComponents(pkg, chatty);
        this.mPermissionManager.onPackageRemoved(pkg);
        this.mPm.getPackageProperty().removeAllProperties(pkg);
        int instrumentationSize = ArrayUtils.size(pkg.getInstrumentations());
        StringBuilder r = null;
        int i = 0;
    L4:
        if (i >= instrumentationSize) goto L13;
        ParsedInstrumentation a = (ParsedInstrumentation) pkg.getInstrumentations().get(i);
        this.mPm.getInstrumentation().remove(a.getComponentName());
        if (chatty == false) goto L11;
        if (r != null) goto L9;
        r = new StringBuilder(256);
    L10:
        r.append(a.getName());
        goto L11
    L9:
        r.append(' ');
    L11:
        i = i + 1;
        goto L4
    L13:
        if (r == null) goto L15;
        Log.d(PackageManagerServiceMonitorEx.TAG, "  Instrumentation: " + r);
    L15:
        StringBuilder r2 = null;
        if (isSystemApp == false) goto L27;
        int libraryNamesSize = pkg.getLibraryNames().size();
        int i2 = 0;
    L18:
        if (i2 >= libraryNamesSize) goto L27;
        String name = (String) pkg.getLibraryNames().get(i2);
        if (this.mSharedLibraries.removeSharedLibrary(name, 0) == false) goto L26;
        if (chatty == false) goto L26;
        if (r2 != null) goto L24;
        r2 = new StringBuilder(256);
    L25:
        r2.append(name);
        goto L26
    L24:
        r2.append(' ');
    L26:
        i2 = i2 + 1;
    L27:
        StringBuilder r3 = null;
        if (pkg.getSdkLibraryName() == null) goto L37;
        if (this.mSharedLibraries.removeSharedLibrary(pkg.getSdkLibraryName(), pkg.getSdkLibVersionMajor()) == false) goto L37;
        if (chatty == false) goto L37;
        if (0 != 0) goto L34;
        r3 = new StringBuilder(256);
    L35:
        r3.append(pkg.getSdkLibraryName());
        goto L37
    L34:
        r3.append(' ');
    L37:
        if (pkg.getStaticSharedLibraryName() != null) goto L39;
    L45:
        if (r3 == null) goto L55;
        Log.d(PackageManagerServiceMonitorEx.TAG, "  Libraries: " + r3);
        return;
    L55:
        return;
    L39:
        if (this.mSharedLibraries.removeSharedLibrary(pkg.getStaticSharedLibraryName(), pkg.getStaticSharedLibraryVersion()) == false) goto L45;
        if (chatty == false) goto L45;
        if (r3 != null) goto L43;
        r3 = new StringBuilder(256);
    L44:
        r3.append(pkg.getStaticSharedLibraryName());
        goto L45
    L43:
        r3.append(' ');
        goto L44
    }

    public void clearPackageStateForUserLIF(PackageSetting ps, int userId, int flags) {
        String packageName = ps.getPackageName();
        if ((flags & 131072) != 0) goto L5;
        this.mAppDataHelper.destroyAppProfilesLIF(packageName);
    L5:
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        AndroidPackage pkg = this.mPm.mPackages.get(packageName);     // Catch: Throwable -> L50
        SharedUserSetting sus = this.mPm.mSettings.getSharedUserSettingLPr(ps);     // Catch: Throwable -> L50
        monitor-exit(r2);     // Catch: Throwable -> L50
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (pkg == null) goto L12;
        AndroidPackage resolvedPkg = pkg;
    L13:
        int appDataDeletionFlags = (131072 & flags) | 7;
        if ((flags & 1) != 0) goto L16;
        this.mAppDataHelper.destroyAppDataLIF(resolvedPkg, userId, appDataDeletionFlags);
        if (userId == (-1)) goto L31;
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        ps.setCeDataInode(-1, userId);     // Catch: Throwable -> L27
        ps.setDeDataInode(-1, userId);     // Catch: Throwable -> L27
        monitor-exit(r3);     // Catch: Throwable -> L27
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L27:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L31:
        final PreferredActivityHelper preferredActivityHelper = new PreferredActivityHelper(this.mPm, this.mBroadcastHelper);
        if (userId != (-1)) goto L42;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Clear package:" + packageName + " state for all users");
        this.mPm.mDomainVerificationManager.clearPackage(packageName);
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        this.mPm.mSettings.getKeySetManagerService().removeAppKeySetDataLPw(packageName);     // Catch: Throwable -> L38
        this.mPm.mInjector.getUpdateOwnershipHelper().removeUpdateOwnerDenyList(packageName);     // Catch: Throwable -> L38
        Computer snapshot = this.mPm.snapshotComputer();     // Catch: Throwable -> L38
        this.mPm.mAppsFilter.removePackage(snapshot, snapshot.getPackageStateInternal(packageName));     // Catch: Throwable -> L38
        final SparseBooleanArray changedUsers = new SparseBooleanArray();     // Catch: Throwable -> L38
        this.mPm.clearPackagePreferredActivitiesLPw(packageName, changedUsers, -1);     // Catch: Throwable -> L38
        this.mPm.mInjector.getBackgroundHandler().post(new RemovePackageHelper$$ExternalSyntheticLambda0(this, changedUsers, preferredActivityHelper));     // Catch: Throwable -> L38
        monitor-exit(r4);     // Catch: Throwable -> L38
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        final PackageSetting ps2 = ps;
        final int userId2 = userId;
    L48:
        this.mPm.mInjector.getBackgroundHandler().post(new RemovePackageHelper$$ExternalSyntheticLambda1(this, ps2, userId2));
        return;
    L38:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L42:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Clear package:" + packageName + " state for user:" + userId);
        this.mPm.mDomainVerificationManager.clearPackageForUser(packageName, userId);
        preferredActivityHelper.clearPackagePreferredActivities(packageName, userId);
        if (sus == null) goto L46;
        List<AndroidPackage> r0 = sus.getPackages();
    L45:
        List<AndroidPackage> sharedUserPkgs = r0;
        ps2 = ps;
        userId2 = userId;
        this.mPermissionManager.onPackageUninstalled(packageName, ps.getAppId(), ps2, pkg, sharedUserPkgs, userId2);
        goto L48
    L46:
        r0 = Collections.emptyList();
        goto L45
    L16:
        if ((flags & 16) == 0) goto L66;
        this.mAppDataHelper.clearAppDataLIF(resolvedPkg, userId, appDataDeletionFlags | 16);
        this.mAppDataHelper.clearAppDataLIF(resolvedPkg, userId, appDataDeletionFlags | 32);
        return;
    L66:
        return;
    L12:
        resolvedPkg = PackageImpl.buildFakeForDeletion(packageName, ps.getVolumeUuid());
    L50:
        th = th;
    L61:
        Throwable r12 = th;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw r12;
    L55:
        th = th;
        goto L61
    }

    private /* synthetic */ void lambda$clearPackageStateForUserLIF$0(SparseBooleanArray changedUsers, PreferredActivityHelper preferredActivityHelper) {
        if (changedUsers.size() <= 0) goto L6;
        preferredActivityHelper.updateDefaultHomeNotLocked(this.mPm.snapshotComputer(), changedUsers);
        this.mBroadcastHelper.sendPreferredActivityChangedBroadcast(-1);
        return;
    }

    private /* synthetic */ void lambda$clearPackageStateForUserLIF$1(PackageSetting ps, int userId) {
        Trace.traceBegin(262144, "clearKeystoreData:" + ps.getAppId() + " for user: " + userId);     // Catch: Throwable -> L6
        this.mAppDataHelper.clearKeystoreData(userId, ps.getAppId());     // Catch: Throwable -> L6
        Trace.traceEnd(262144);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    }

    public void removePackageData(PackageSetting deletedPs, int[] allUserHandles) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        removePackageDataLIF(deletedPs, -1, allUserHandles, new PackageRemovedInfo(), 0, false);     // Catch: Throwable -> L9
        if (installLock == null) goto L25;
        installLock.close();
        return;
    L25:
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        if (installLock == null) goto L26;
        installLock.close();     // Catch: Throwable -> L16
        throw r10;
    L16:
        th = move-exception;
        r10.addSuppressed(th);
        throw r10;
    L26:
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public void removePackageDataLIF(PackageSetting deletedPs, int targetUserId, int[] allUserHandles, PackageRemovedInfo outInfo, int flags, boolean writeSettings) {
        String packageName = deletedPs.getPackageName();
        Slog.d(PackageManagerServiceMonitorEx.TAG, "removePackageDataLI: " + deletedPs);
        boolean shouldDeletePackageSetting = shouldDeletePackageSetting(deletedPs, targetUserId, allUserHandles, flags);
        AndroidPackage deletedPkg = deletedPs.getPkg();
        if (shouldDeletePackageSetting == false) goto L5;
        int r0 = -1;
    L6:
        clearPackageStateForUserLIF(deletedPs, r0, flags);
        boolean isArchive = true;
        if ((Integer.MIN_VALUE & flags) == 0) goto L9;
        boolean r1 = true;
    L10:
        removePackageLI(packageName, r1);
        if (deletedPs.isSystem() == true) goto L13;
        deletedPs.setPkg(null);
    L13:
        if (shouldDeletePackageSetting == false) goto L48;
        new SparseBooleanArray();
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        outInfo.mIsAppIdRemoved = this.mPm.mSettings.removePackageAndAppIdLPw(packageName);     // Catch: Throwable -> L22
        if (this.mPm.mSettings.isDisabledSystemPackageLPr(packageName) == true) goto L40;
        SharedUserSetting sus = this.mPm.mSettings.getSharedUserSettingLPr(deletedPs);     // Catch: Throwable -> L22
        if (sus == null) goto L24;
        List<AndroidPackage> r4 = sus.getPackages();     // Catch: Throwable -> L22
    L21:
        List<AndroidPackage> sharedUserPkgs = r4;
        PackageManagerTracedLock r16 = r2;
        this.mPermissionManager.onPackageUninstalled(packageName, deletedPs.getAppId(), deletedPs, deletedPkg, sharedUserPkgs, -1);     // Catch: Throwable -> L34
        if (sus == null) goto L41;
        this.mPm.mSettings.checkAndConvertSharedUserSettingsLPw(sus);     // Catch: Throwable -> L34
    L41:
        this.mPm.mSettings.removeRenamedPackageLPw(deletedPs.getRealName());     // Catch: Throwable -> L34
        monitor-exit(r16);     // Catch: Throwable -> L34
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L90:
        boolean installedStateChanged = false;
        if (outInfo.mOrigUsers != null) goto L93;
    L113:
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        if (writeSettings == true) goto L130;
    L119:
        if (installedStateChanged == false) goto L121;
        this.mPm.mSettings.writeKernelMappingLPr(deletedPs);     // Catch: Throwable -> L117
    L121:
        monitor-exit(r3);     // Catch: Throwable -> L117
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L117:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L130:
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L117
        goto L119
    L93:
        if (deletedPs.isSystem() == false) goto L113;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Propagating install state across downgrade");
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        int r6 = allUserHandles.length;     // Catch: Throwable -> L104
        int r7 = 0;
    L97:
        if (r7 >= r6) goto L108;
        int userId = allUserHandles[r7];     // Catch: Throwable -> L104
        boolean installed = ArrayUtils.contains(outInfo.mOrigUsers, userId);     // Catch: Throwable -> L104
        Slog.d(PackageManagerServiceMonitorEx.TAG, "    user " + userId + " => " + installed);     // Catch: Throwable -> L104
        if (installed == deletedPs.getInstalled(userId)) goto L101;
        installedStateChanged = true;
    L101:
        deletedPs.setInstalled(installed, userId);     // Catch: Throwable -> L104
        if (installed == false) goto L107;
        deletedPs.setUninstallReason(0, userId);     // Catch: Throwable -> L104
    L107:
        r7 = r7 + 1;     // Catch: Throwable -> L104
        goto L97
    L108:
        monitor-exit(r5);     // Catch: Throwable -> L104
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L104:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L36:
        th = th;
        PackageManagerTracedLock r17 = r2;
    L44:
        monitor-exit(r17);     // Catch: Throwable -> L34
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L38:
        th = th;
        r17 = r2;
        goto L44
    L24:
        r4 = Collections.emptyList();     // Catch: Throwable -> L22
        goto L21
    L40:
        r16 = r2;
    L22:
        th = th;
        r17 = r2;
    L34:
        th = th;
        goto L44
    L48:
        if (deletedPs.isSystem() == true) goto L90;
        if (outInfo.mIsUpdate == true) goto L90;
        if (outInfo.mRemovedUsers == null) goto L90;
        if (deletedPs.isExternalStorage() == true) goto L90;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Updating installed state to false because of DELETE_KEEP_DATA");
        if ((flags & 16) != 0) goto L59;
        isArchive = false;
    L59:
        System.currentTimeMillis();
        PackageManagerTracedLock r8 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        int[] r9 = outInfo.mRemovedUsers;     // Catch: Throwable -> L76
        int r15 = r9.length;     // Catch: Throwable -> L76
        int r14 = 0;
    L62:
        if (r14 >= r15) goto L78;
        int userId2 = r9[r14];     // Catch: Throwable -> L76
        int[] r18 = r9;
        boolean wasInstalled = deletedPs.getInstalled(userId2);     // Catch: Throwable -> L76
        boolean isArchive2 = isArchive;
        String packageName2 = packageName;
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L72
        AndroidPackage deletedPkg2 = deletedPkg;
        r10.append("    user ");     // Catch: Throwable -> L70
        r10.append(userId2);     // Catch: Throwable -> L70
        r10.append(": ");     // Catch: Throwable -> L70
        r10.append(wasInstalled);     // Catch: Throwable -> L70
        r10.append(" => ");     // Catch: Throwable -> L70
        r10.append(false);     // Catch: Throwable -> L70
        Slog.d(PackageManagerServiceMonitorEx.TAG, r10.toString());     // Catch: Throwable -> L70
        deletedPs.setInstalled(false, userId2);     // Catch: Throwable -> L70
        r14 = r14 + 1;     // Catch: Throwable -> L70
        r9 = r18;
        isArchive = isArchive2;
        packageName = packageName2;
        deletedPkg = deletedPkg2;
    L70:
        th = th;
    L85:
        monitor-exit(r8);     // Catch: Throwable -> L70
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L72:
        th = th;
        goto L85
    L78:
        AndroidPackage deletedPkg3 = deletedPkg;
        if (deletedPkg3 != null) goto L81;
    L83:
        monitor-exit(r8);     // Catch: Throwable -> L70
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L90
    L81:
        if (deletedPkg3.getSplitNames() == null) goto L83;
        deletedPs.setSplitNames(deletedPkg3.getSplitNames());     // Catch: Throwable -> L70
        deletedPs.setSplitRevisionCodes(deletedPkg3.getSplitRevisionCodes());     // Catch: Throwable -> L70
    L76:
        th = th;
        goto L85
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = targetUserId;
        goto L6
    }

    private static boolean shouldDeletePackageSetting(PackageSetting deletedPs, int userId, int[] allUserHandles, int flags) {
        if ((flags & 1) == 0) goto L6;
        return false;
    L6:
        if (userId != (-1)) goto L9;
        return true;
    L9:
        if (deletedPs.hasDataOnAnyOtherUser(allUserHandles, userId) == false) goto L11;
        return false;
    L11:
        return true;
    }

    void cleanUpResources(String packageName, File codeFile, String[] instructionSets) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        cleanUpResourcesLI(codeFile, instructionSets);     // Catch: Throwable -> L21
        if (installLock == null) goto L6;
        installLock.close();
    L6:
        if (packageName != null) goto L8;
        return;
    L8:
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L13
        if (ps == null) goto L15;
        ps.removeOldPath(codeFile);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L21:
        th = move-exception;
        if (installLock != null) goto L32;
    L27:
        throw th;
    L32:
        installLock.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);
        goto L27
    }

    private void cleanUpResourcesLI(File codeFile, String[] instructionSets) {
        List r0 = Collections.EMPTY_LIST;
        if (codeFile != null) goto L5;
    L9:
        removeCodePathLI(codeFile);
        return;
    L5:
        if (codeFile.exists() == false) goto L9;
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<PackageLite> result = ApkLiteParseUtils.parsePackageLite(input.reset(), codeFile, 0);
        if (result.isSuccess() == false) goto L9;
        ((PackageLite) result.getResult()).getAllApkPaths();
        goto L9
    }

    void cleanUpForMoveInstall(String volumeUuid, String packageName, String fromCodePath) {
        String toPathName = new File(fromCodePath).getName();
        File codeFile = new File(Environment.getDataAppDirectory(volumeUuid), toPathName);
        StringBuilder r0 = new StringBuilder();
        r0.append("Cleaning up ");
        String r8 = packageName;
        r0.append(r8);
        r0.append(" on ");
        String r7 = volumeUuid;
        r0.append(r7);
        Slog.d(PackageManagerServiceMonitorEx.TAG, r0.toString());
        int[] userIds = this.mPm.mUserManager.getUserIds();
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        int r6 = userIds.length;     // Catch: Throwable -> L11
        int userId = 0;
    L4:
        if (userId >= r6) goto L20;
        int r17 = userId;
        int r16 = r6;
        this.mPm.mInstaller.destroyAppData(r7, r8, userIds[userId], 131075, 0);     // Catch: Throwable -> L11 Installer.InstallerException -> L13
    L19:
        userId = r17 + 1;     // Catch: Throwable -> L11
        r7 = volumeUuid;
        r8 = packageName;
        r6 = r16;
    L13:
        e = e;
    L18:
        Slog.w(PackageManagerServiceMonitorEx.TAG, String.valueOf(e));     // Catch: Throwable -> L11
    L15:
        e = e;
        r16 = r6;
        r17 = userId;
        goto L18
    L20:
        removeCodePathLI(codeFile);     // Catch: Throwable -> L11
        if (installLock == null) goto L41;
        installLock.close();
        return;
    L41:
        return;
    L11:
        th = move-exception;
        if (installLock == null) goto L42;
        installLock.close();     // Catch: Throwable -> L27
        throw th;
    L27:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L42:
        throw th;
    }
}
