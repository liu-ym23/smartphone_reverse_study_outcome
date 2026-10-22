package com.android.server.pm;

import android.app.AppOpsManager;
import android.content.pm.SuspendDialogInfo;
import android.content.pm.UserPackage;
import android.os.Binder;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.SuspendParams;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import com.android.server.pm.pkg.mutate.PackageUserStateWrite;
import com.android.server.utils.WatchedArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class SuspendPackageHelper {
    private static final String SYSTEM_EXEMPT_FROM_SUSPENSION = "system_exempt_from_suspension";
    private final BroadcastHelper mBroadcastHelper;
    private final PackageManagerServiceInjector mInjector;
    private final PackageManagerService mPm;
    private final ProtectedPackages mProtectedPackages;

    /* JADX INFO: renamed from: $r8$lambda$5Ax2v5UvhsR67N-0JmdztLNWe2U, reason: not valid java name */
    public static /* synthetic */ void m6968$r8$lambda$5Ax2v5UvhsR67N0JmdztLNWe2U(ArraySet r0, int r1, boolean r2, UserPackage r3, SuspendParams r4, PackageStateMutator r5) {
        lambda$setPackagesSuspended$0(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$dguAfIKYkbFhj4CajhMWmJ4hzqs(ArrayMap r0, int r1, PackageStateMutator r2) {
        lambda$removeSuspensionsBySuspendingPackage$1(r0, r1, r2);
    }

    SuspendPackageHelper(PackageManagerService pm, PackageManagerServiceInjector injector, BroadcastHelper broadcastHelper, ProtectedPackages protectedPackages) {
        this.mPm = pm;
        this.mInjector = injector;
        this.mBroadcastHelper = broadcastHelper;
        this.mProtectedPackages = protectedPackages;
    }

    String[] setPackagesSuspended(Computer snapshot, String[] packageNames, final boolean suspended, PersistableBundle appExtras, PersistableBundle launcherExtras, SuspendDialogInfo dialogInfo, final UserPackage suspendingPackage, final int targetUserId, int callingUid, boolean quarantined) {
        Computer r1 = snapshot;
        String[] r2 = packageNames;
        if (ArrayUtils.isEmpty(r2) == false) goto L6;
        return r2;
    L6:
        if (suspended == false) goto L12;
        if (quarantined == true) goto L12;
        if (isSuspendAllowedForUser(r1, targetUserId, callingUid) == true) goto L12;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend due to restrictions on user " + targetUserId);
        return r2;
    L12:
        if (suspended == false) goto L14;
        final SuspendParams newSuspendParams = new SuspendParams(dialogInfo, appExtras, launcherExtras, quarantined);
    L15:
        List<String> unmodifiablePackages = new ArrayList(r2.length);
        List<String> notifyPackagesList = new ArrayList(r2.length);
        IntArray notifyUids = new IntArray(r2.length);
        final ArraySet<String> changedPackagesList = new ArraySet(r2.length);
        IntArray changedUids = new IntArray(r2.length);
        if (suspended == false) goto L18;
        boolean[] canSuspend = canSuspendPackageForUser(r1, r2, targetUserId, callingUid);
    L19:
        boolean[] canSuspend2 = canSuspend;
        int i = 0;
    L21:
        if (i >= r2.length) goto L69;
        String packageName = packageNames[i];
        if (suspendingPackage.packageName.equals(packageName) == true) goto L25;
    L31:
        int i2 = i;
        PackageStateInternal packageState = r1.getPackageStateInternal(packageName);
        if (packageState == null) goto L67;
        if (packageState.getUserStateOrDefault(targetUserId).isInstalled() == false) goto L67;
        if (r1.shouldFilterApplication(packageState, callingUid, targetUserId) == true) goto L67;
        if (canSuspend2 != null) goto L40;
    L42:
        WatchedArrayMap<UserPackage, SuspendParams> suspendParamsMap = packageState.getUserStateOrDefault(targetUserId).getSuspendParams();
        if (suspendParamsMap != null) goto L45;
        SuspendParams r19 = null;
    L46:
        SuspendParams oldSuspendParams = r19;
        boolean packageUnsuspended = true;
        boolean changed = !Objects.equals(oldSuspendParams, newSuspendParams);
        if (suspended == false) goto L50;
        if (changed == true) goto L50;
        notifyPackagesList.add(packageName);
        notifyUids.add(UserHandle.getUid(targetUserId, packageState.getAppId()));
        newSuspendParams = newSuspendParams;
    L68:
        i = i2 + 1;
        r1 = snapshot;
        r2 = packageNames;
        newSuspendParams = newSuspendParams;
    L50:
        if (suspended == true) goto L56;
        newSuspendParams = newSuspendParams;
        if (CollectionUtils.size(suspendParamsMap) == 1) goto L54;
    L57:
        packageUnsuspended = false;
    L59:
        if (suspended == true) goto L61;
        if (packageUnsuspended == true) goto L61;
    L62:
        if (changed == false) goto L64;
        changedPackagesList.add(packageName);
        changedUids.add(UserHandle.getUid(targetUserId, packageState.getAppId()));
        goto L68
    L64:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "No change is needed for package: " + packageName + ". Skipping suspending/un-suspending.");
    L61:
        notifyPackagesList.add(packageName);
        notifyUids.add(UserHandle.getUid(targetUserId, packageState.getAppId()));
        goto L62
    L54:
        if (suspendParamsMap.containsKey(suspendingPackage) == false) goto L57;
    L56:
        newSuspendParams = newSuspendParams;
        goto L57
    L45:
        r19 = suspendParamsMap.get(suspendingPackage);
        goto L46
    L40:
        if (canSuspend2[i2] == true) goto L42;
        unmodifiablePackages.add(packageName);
        newSuspendParams = newSuspendParams;
    L67:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Could not find package setting for package: " + packageName + ". Skipping suspending/un-suspending.");
        unmodifiablePackages.add(packageName);
        goto L68
    L25:
        if (suspendingPackage.userId != targetUserId) goto L31;
        StringBuilder r3 = new StringBuilder();
        i2 = i;
        r3.append("Suspending package: ");
        r3.append(suspendingPackage);
        r3.append(" trying to ");
        if (suspended == false) goto L29;
        String r13 = "";
    L30:
        r3.append(r13);
        r3.append("suspend itself. Ignoring");
        Slog.w(PackageManagerServiceMonitorEx.TAG, r3.toString());
        unmodifiablePackages.add(packageName);
        newSuspendParams = newSuspendParams;
        goto L68
    L29:
        r13 = "un";
        goto L30
    L69:
        this.mPm.commitPackageStateMutation(null, new SuspendPackageHelper$$ExternalSyntheticLambda0(changedPackagesList, targetUserId, suspended, suspendingPackage, newSuspendParams));
        if (notifyPackagesList.isEmpty() == true) goto L76;
        String[] changedPackages = (String[]) notifyPackagesList.toArray(new String[0]);
        BroadcastHelper r4 = this.mBroadcastHelper;
        PackageManagerService r5 = this.mPm;
        r5.getClass();
        DistractingPackageHelper$$ExternalSyntheticLambda1 r6 = new DistractingPackageHelper$$ExternalSyntheticLambda1(r5);
        if (suspended == false) goto L74;
        String r7 = "android.intent.action.PACKAGES_SUSPENDED";
    L75:
        String r8 = r7;
        ArraySet<String> changedPackagesList2 = changedPackagesList;
        int r9 = targetUserId;
        r4.sendPackagesSuspendedOrUnsuspendedForUser(r6, r8, changedPackages, notifyUids.toArray(), quarantined, r9);
        BroadcastHelper r10 = this.mBroadcastHelper;
        PackageManagerService r11 = this.mPm;
        r11.getClass();
        r10.sendMyPackageSuspendedOrUnsuspended(new DistractingPackageHelper$$ExternalSyntheticLambda1(r11), changedPackages, suspended, r9);
        this.mPm.scheduleWritePackageRestrictions(r9);
    L78:
        if (changedPackagesList2.isEmpty() == true) goto L81;
        BroadcastHelper r12 = this.mBroadcastHelper;
        PackageManagerService r14 = this.mPm;
        r14.getClass();
        r12.sendPackagesSuspendedOrUnsuspendedForUser(new DistractingPackageHelper$$ExternalSyntheticLambda1(r14), "android.intent.action.PACKAGES_SUSPENSION_CHANGED", (String[]) changedPackagesList2.toArray(new String[0]), changedUids.toArray(), quarantined, r9);
    L81:
        return (String[]) unmodifiablePackages.toArray(new String[0]);
    L74:
        r7 = "android.intent.action.PACKAGES_UNSUSPENDED";
        goto L75
    L76:
        r9 = targetUserId;
        changedPackagesList2 = changedPackagesList;
        goto L78
    L18:
        canSuspend = null;
        goto L19
    L14:
        newSuspendParams = null;
        goto L15
    }

    private static /* synthetic */ void lambda$setPackagesSuspended$0(ArraySet changedPackagesList, int targetUserId, boolean suspended, UserPackage suspendingPackage, SuspendParams newSuspendParams, PackageStateMutator mutator) {
        int size = changedPackagesList.size();
        int index = 0;
    L3:
        if (index >= size) goto L10;
        String packageName = (String) changedPackagesList.valueAt(index);
        PackageUserStateWrite userState = mutator.forPackage(packageName).userState(targetUserId);
        if (suspended == false) goto L7;
        userState.putSuspendParams(suspendingPackage, newSuspendParams);
    L8:
        index = index + 1;
        goto L3
    L7:
        userState.removeSuspension(suspendingPackage);
        goto L8
    }

    String[] getUnsuspendablePackagesForUser(Computer snapshot, String[] packageNames, int targetUserId, int callingUid) {
        if (isSuspendAllowedForUser(snapshot, targetUserId, callingUid) == true) goto L6;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend due to restrictions on user " + targetUserId);
        return packageNames;
    L6:
        ArraySet<String> unactionablePackages = new ArraySet();
        boolean[] canSuspend = canSuspendPackageForUser(snapshot, packageNames, targetUserId, callingUid);
        int i = 0;
    L8:
        if (i >= packageNames.length) goto L17;
        if (canSuspend[i] == true) goto L12;
        unactionablePackages.add(packageNames[i]);
    L15:
        i = i + 1;
        goto L8
    L12:
        PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageNames[i], callingUid, targetUserId);
        if (packageState != null) goto L15;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Could not find package setting for package: " + packageNames[i]);
        unactionablePackages.add(packageNames[i]);
        goto L15
    L17:
        return (String[]) unactionablePackages.toArray(new String[unactionablePackages.size()]);
    }

    static Bundle getSuspendedPackageAppExtras(Computer snapshot, String packageName, int userId, int callingUid) {
        PackageStateInternal ps = snapshot.getPackageStateInternal(packageName, callingUid);
        if (ps != null) goto L5;
        return null;
    L5:
        PackageUserStateInternal pus = ps.getUserStateOrDefault(userId);
        Bundle allExtras = new Bundle();
        if (pus.isSuspended() == false) goto L16;
        int i = 0;
    L9:
        if (i >= pus.getSuspendParams().size()) goto L16;
        SuspendParams params = pus.getSuspendParams().valueAt(i);
        if (params == null) goto L15;
        if (params.getAppExtras() == null) goto L15;
        allExtras.putAll(params.getAppExtras());
    L15:
        i = i + 1;
    L16:
        int i2 = allExtras.size();
        if (i2 > 0) goto L19;
        return null;
    L19:
        return allExtras;
    }

    void removeSuspensionsBySuspendingPackage(Computer snapshot, String[] packagesToChange, Predicate<UserPackage> suspendingPackagePredicate, final int targetUserId) {
        String[] r1 = packagesToChange;
        List<String> unsuspendedPackages = new ArrayList();
        IntArray unsuspendedUids = new IntArray();
        final ArrayMap<String, ArraySet<UserPackage>> pkgToSuspendingPkgsToCommit = new ArrayMap();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        PackageUserStateInternal packageUserState = null;
        if (r4 >= r2) goto L29;
        String packageName = r1[r4];
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState == null) goto L9;
        packageUserState = packageState.getUserStateOrDefault(targetUserId);
    L9:
        if (packageUserState == null) goto L28;
        if (packageUserState.isSuspended() == false) goto L28;
        WatchedArrayMap<UserPackage, SuspendParams> suspendParamsMap = packageUserState.getSuspendParams();
        int countRemoved = 0;
        int index = 0;
    L15:
        if (index >= suspendParamsMap.size()) goto L24;
        UserPackage suspendingPackage = suspendParamsMap.keyAt(index);
        PackageStateInternal packageState2 = packageState;
        if (suspendingPackagePredicate.test(suspendingPackage) == false) goto L23;
        ArraySet<UserPackage> suspendingPkgsToCommit = pkgToSuspendingPkgsToCommit.get(packageName);
        if (suspendingPkgsToCommit != null) goto L21;
        ArraySet<UserPackage> suspendingPkgsToCommit2 = new ArraySet();
        pkgToSuspendingPkgsToCommit.put(packageName, suspendingPkgsToCommit2);
    L22:
        suspendingPkgsToCommit2.add(suspendingPackage);
        countRemoved = countRemoved + 1;
        goto L23
    L21:
        suspendingPkgsToCommit2 = suspendingPkgsToCommit;
    L23:
        index = index + 1;
        packageState = packageState2;
        goto L15
    L24:
        PackageStateInternal packageState3 = packageState;
        if (countRemoved != suspendParamsMap.size()) goto L28;
        unsuspendedPackages.add(packageState3.getPackageName());
        unsuspendedUids.add(UserHandle.getUid(targetUserId, packageState3.getAppId()));
    L28:
        r4 = r4 + 1;
        r1 = packagesToChange;
        goto L3
    L29:
        this.mPm.commitPackageStateMutation(null, new SuspendPackageHelper$$ExternalSyntheticLambda1(pkgToSuspendingPkgsToCommit, targetUserId));
        this.mPm.scheduleWritePackageRestrictions(targetUserId);
        if (unsuspendedPackages.isEmpty() == true) goto L41;
        String[] packageArray = (String[]) unsuspendedPackages.toArray(new String[unsuspendedPackages.size()]);
        BroadcastHelper r3 = this.mBroadcastHelper;
        PackageManagerService r5 = this.mPm;
        r5.getClass();
        r3.sendMyPackageSuspendedOrUnsuspended(new DistractingPackageHelper$$ExternalSyntheticLambda1(r5), packageArray, false, targetUserId);
        BroadcastHelper r6 = this.mBroadcastHelper;
        PackageManagerService r7 = this.mPm;
        r7.getClass();
        r6.sendPackagesSuspendedOrUnsuspendedForUser(new DistractingPackageHelper$$ExternalSyntheticLambda1(r7), "android.intent.action.PACKAGES_UNSUSPENDED", packageArray, unsuspendedUids.toArray(), false, targetUserId);
        return;
    }

    private static /* synthetic */ void lambda$removeSuspensionsBySuspendingPackage$1(ArrayMap pkgToSuspendingPkgsToCommit, int targetUserId, PackageStateMutator mutator) {
        int mapIndex = 0;
    L4:
        if (mapIndex >= pkgToSuspendingPkgsToCommit.size()) goto L11;
        String packageName = (String) pkgToSuspendingPkgsToCommit.keyAt(mapIndex);
        ArraySet<UserPackage> packagesToRemove = (ArraySet) pkgToSuspendingPkgsToCommit.valueAt(mapIndex);
        PackageUserStateWrite userState = mutator.forPackage(packageName).userState(targetUserId);
        int setIndex = 0;
    L7:
        if (setIndex >= packagesToRemove.size()) goto L9;
        userState.removeSuspension(packagesToRemove.valueAt(setIndex));
        setIndex = setIndex + 1;
        goto L7
    L9:
        mapIndex = mapIndex + 1;
        goto L4
    }

    Bundle getSuspendedPackageLauncherExtras(Computer snapshot, String packageName, int userId, int callingUid) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName, callingUid);
        if (packageState != null) goto L5;
        return null;
    L5:
        Bundle allExtras = new Bundle();
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        if (userState.isSuspended() == false) goto L16;
        int i = 0;
    L9:
        if (i >= userState.getSuspendParams().size()) goto L16;
        SuspendParams params = userState.getSuspendParams().valueAt(i);
        if (params == null) goto L15;
        if (params.getLauncherExtras() == null) goto L15;
        allExtras.putAll(params.getLauncherExtras());
    L15:
        i = i + 1;
    L16:
        int i2 = allExtras.size();
        if (i2 > 0) goto L19;
        return null;
    L19:
        return allExtras;
    }

    boolean isPackageSuspended(Computer snapshot, String packageName, int userId, int callingUid) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName, callingUid);
        if (packageState != null) goto L5;
    L7:
        return false;
    L5:
        if (packageState.getUserStateOrDefault(userId).isSuspended() == false) goto L7;
        return true;
    }

    UserPackage getSuspendingPackage(Computer snapshot, String suspendedPackage, int userId, int callingUid) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(suspendedPackage, callingUid);
        if (packageState != null) goto L5;
        return null;
    L5:
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        if (userState.isSuspended() == true) goto L8;
        return null;
    L8:
        UserPackage suspendingPackage = null;
        UserPackage suspendedBySystem = null;
        UserPackage qasPackage = null;
        int i = 0;
    L10:
        if (i >= userState.getSuspendParams().size()) goto L20;
        UserPackage suspendingPackage2 = userState.getSuspendParams().keyAt(i);
        suspendingPackage = suspendingPackage2;
        SuspendParams suspendParams = userState.getSuspendParams().valueAt(i);
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(suspendingPackage.packageName) == false) goto L15;
        suspendedBySystem = suspendingPackage;
    L15:
        if (suspendParams.isQuarantined() == false) goto L18;
        if (qasPackage != null) goto L18;
        qasPackage = suspendingPackage;
    L18:
        i = i + 1;
        goto L10
    L20:
        if (qasPackage == null) goto L22;
        return qasPackage;
    L22:
        if (suspendedBySystem == null) goto L24;
        return suspendedBySystem;
    L24:
        return suspendingPackage;
    }

    SuspendDialogInfo getSuspendedDialogInfo(Computer snapshot, String suspendedPackage, UserPackage suspendingPackage, int userId, int callingUid) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(suspendedPackage, callingUid);
        if (packageState != null) goto L5;
        return null;
    L5:
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        if (userState.isSuspended() == true) goto L8;
        return null;
    L8:
        WatchedArrayMap<UserPackage, SuspendParams> suspendParamsMap = userState.getSuspendParams();
        if (suspendParamsMap != null) goto L11;
        return null;
    L11:
        SuspendParams suspendParams = suspendParamsMap.get(suspendingPackage);
        if (suspendParams != null) goto L14;
        return null;
    L14:
        return suspendParams.getDialogInfo();
    }

    boolean isSuspendAllowedForUser(Computer snapshot, int userId, int callingUid) {
        UserManagerService userManager = this.mInjector.getUserManagerService();
        if (isCallerDeviceOrProfileOwner(snapshot, userId, callingUid) == false) goto L5;
    L10:
        return true;
    L5:
        if (userManager.hasUserRestriction("no_control_apps", userId) == false) goto L7;
    L9:
        return false;
    L7:
        if (userManager.hasUserRestriction("no_uninstall_apps", userId) == true) goto L9;
        goto L9
    }

    boolean[] canSuspendPackageForUser(Computer snapshot, String[] packageNames, int targetUserId, int callingUid) {
        Computer r2 = snapshot;
        String[] r3 = packageNames;
        int r4 = targetUserId;
        boolean[] canSuspend = new boolean[r3.length];
        boolean isCallerOwner = isCallerDeviceOrProfileOwner(r2, r4, callingUid);
        long token = Binder.clearCallingIdentity();
        DefaultAppProvider defaultAppProvider = this.mInjector.getDefaultAppProvider();     // Catch: Throwable -> L61
        String activeLauncherPackageName = defaultAppProvider.getDefaultHome(r4);     // Catch: Throwable -> L61
        String dialerPackageName = defaultAppProvider.getDefaultDialer(r4);     // Catch: Throwable -> L61
        String requiredInstallerPackage = getKnownPackageName(r2, 2, r4);     // Catch: Throwable -> L61
        String requiredUninstallerPackage = getKnownPackageName(r2, 3, r4);     // Catch: Throwable -> L61
        String requiredVerifierPackage = getKnownPackageName(r2, 4, r4);     // Catch: Throwable -> L61
        String requiredPermissionControllerPackage = getKnownPackageName(r2, 7, r4);     // Catch: Throwable -> L61
        int i = 0;
    L5:
        boolean[] canSuspend2 = canSuspend;
        if (i >= r3.length) goto L59;
        canSuspend2[i] = false;     // Catch: Throwable -> L12
        String packageName = r3[i];     // Catch: Throwable -> L12
        int i2 = i;
        if (this.mPm.isPackageDeviceAdmin(packageName, r4) == false) goto L15;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": has an active device admin");     // Catch: Throwable -> L12
    L58:
        i = i2 + 1;
        r2 = snapshot;
        r3 = packageNames;
        r4 = targetUserId;
        canSuspend = canSuspend2;
        goto L5
    L15:
        if (packageName.equals(activeLauncherPackageName) == false) goto L18;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": contains the active launcher");     // Catch: Throwable -> L12
        goto L58
    L18:
        if (packageName.equals(requiredInstallerPackage) == false) goto L21;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": required for package installation");     // Catch: Throwable -> L12
        goto L58
    L21:
        if (packageName.equals(requiredUninstallerPackage) == false) goto L24;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": required for package uninstallation");     // Catch: Throwable -> L12
        goto L58
    L24:
        if (packageName.equals(requiredVerifierPackage) == false) goto L27;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": required for package verification");     // Catch: Throwable -> L12
        goto L58
    L27:
        if (packageName.equals(dialerPackageName) == false) goto L30;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": is the default dialer");     // Catch: Throwable -> L12
        goto L58
    L30:
        if (packageName.equals(requiredPermissionControllerPackage) == false) goto L33;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": required for permissions management");     // Catch: Throwable -> L12
        goto L58
    L33:
        if (this.mProtectedPackages.isPackageStateProtected(r4, packageName) == false) goto L35;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": protected package");     // Catch: Throwable -> L12
        goto L58
    L35:
        if (isCallerOwner == false) goto L37;
    L39:
        PackageStateInternal packageState = r2.getPackageStateInternal(packageName);     // Catch: Throwable -> L12
        if (packageState != null) goto L42;
        AndroidPackage pkg = null;
    L43:
        if (pkg == null) goto L55;
        int uid = UserHandle.getUid(r4, packageState.getAppId());     // Catch: Throwable -> L12
        if (pkg.isSdkLibrary() == false) goto L49;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package: " + packageName + " providing SDK library: " + pkg.getSdkLibraryName());     // Catch: Throwable -> L12
        goto L58
    L49:
        if (pkg.isStaticSharedLibrary() == false) goto L52;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package: " + packageName + " providing static shared library: " + pkg.getStaticSharedLibraryName());     // Catch: Throwable -> L12
        goto L58
    L52:
        if (exemptFromSuspensionByAppOp(uid, packageName) == false) goto L55;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": has OP_SYSTEM_EXEMPT_FROM_SUSPENSION set");     // Catch: Throwable -> L12
    L55:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L57;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend the platform package: " + packageName);     // Catch: Throwable -> L12
        goto L58
    L57:
        canSuspend2[i2] = true;     // Catch: Throwable -> L12
        goto L58
    L42:
        pkg = packageState.getPkg();     // Catch: Throwable -> L12
        goto L43
    L37:
        if (r2.getBlockUninstall(r4, packageName) == false) goto L39;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot suspend package \"" + packageName + "\": blocked by admin");     // Catch: Throwable -> L12
        goto L58
    L59:
        Binder.restoreCallingIdentity(token);
        return canSuspend2;
    L12:
        th = th;
    L63:
        Binder.restoreCallingIdentity(token);
        throw th;
    L61:
        th = th;
        goto L63
    }

    private boolean exemptFromSuspensionByAppOp(int uid, String packageName) {
        AppOpsManager appOpsManager = (AppOpsManager) this.mInjector.getSystemService(AppOpsManager.class);
        if (appOpsManager.checkOpNoThrow(124, uid, packageName) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private String getKnownPackageName(Computer snapshot, int knownPackage, int userId) {
        String[] knownPackages = this.mPm.getKnownPackageNamesInternal(snapshot, knownPackage, userId);
        if (knownPackages.length > 0) goto L7;
        return null;
    L7:
        return knownPackages[0];
    }

    private boolean isCallerDeviceOrProfileOwner(Computer snapshot, int targetUserId, int callingUid) {
        if (callingUid != 1000) goto L5;
        return true;
    L5:
        String ownerPackage = this.mProtectedPackages.getDeviceOwnerOrProfileOwnerPackage(targetUserId);
        if (ownerPackage != null) goto L8;
        return false;
    L8:
        if (callingUid != snapshot.getPackageUidInternal(ownerPackage, 0, targetUserId, callingUid)) goto L11;
        return true;
    L11:
        return false;
    }
}
