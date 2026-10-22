package com.android.server.permission.access.permission;

import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.SigningDetails;
import android.os.Build;
import android.pico.utils.Features;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.pm.permission.CompatibilityPermissionInfo;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.internal.pm.pkg.component.ParsedPermissionGroup;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.ExternalState;
import com.android.server.permission.access.GetStateScope;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.SchemePolicy;
import com.android.server.permission.access.UserState;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedList;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedListSetExtensionsKt;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedMapExtensionsKt;
import com.android.server.permission.access.immutable.IndexedSet;
import com.android.server.permission.access.immutable.IndexedSetExtensionsKt;
import com.android.server.permission.access.immutable.IntMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.IntSet;
import com.android.server.permission.access.immutable.MutableIndexedList;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedSet;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.collections.ArraysKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.ArrayIteratorKt;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Ref$IntRef;
import com.android.server.permission.jarjar.kotlin.ranges.RangesKt;
import com.android.server.permission.jarjar.kotlin.text.StringsKt;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageUserState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

/* JADX INFO: compiled from: AppIdPermissionPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdPermissionPolicy extends SchemePolicy {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;
    private static final IndexedSet<String> NEARBY_DEVICES_PERMISSIONS = null;
    private static final IndexedSet<String> NOTIFICATIONS_PERMISSIONS = null;
    private static final IndexedSet<String> NO_IMPLICIT_FLAG_PERMISSIONS = null;
    private static final IndexedSet<String> STORAGE_AND_MEDIA_PERMISSIONS = null;
    private volatile boolean isSignaturePermissionAllowlistForceEnforced;
    private final AppIdPermissionMigration migration;
    private volatile IndexedListSet<OnPermissionFlagsChangedListener> onPermissionFlagsChangedListeners;
    private final Object onPermissionFlagsChangedListenersLock;
    private final AppIdPermissionPersistence persistence;
    private final MutableIndexedSet<String> privilegedPermissionAllowlistViolations;
    private final AppIdPermissionUpgrade upgrade;

    /* JADX INFO: compiled from: AppIdPermissionPolicy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AppIdPermissionPolicy.kt */
    public interface OnPermissionFlagsChangedListener {
        void onPermissionFlagsChanged(int r1, int r2, String r3, int r4, int r5);

        void onStateMutated();
    }

    public AppIdPermissionPolicy() {
        this.persistence = new AppIdPermissionPersistence();
        this.migration = new AppIdPermissionMigration();
        this.upgrade = new AppIdPermissionUpgrade(this);
        this.onPermissionFlagsChangedListeners = new MutableIndexedListSet(null, 1, null);
        this.onPermissionFlagsChangedListenersLock = new Object();
        this.privilegedPermissionAllowlistViolations = new MutableIndexedSet(null, 1, null);
    }

    public final boolean isSignaturePermissionAllowlistForceEnforced() {
        return this.isSignaturePermissionAllowlistForceEnforced;
    }

    public final void setSignaturePermissionAllowlistForceEnforced(boolean r1) {
        this.isSignaturePermissionAllowlistForceEnforced = r1;
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public String getSubjectScheme() {
        return "uid";
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public String getObjectScheme() {
        return "permission";
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onStateMutated(GetStateScope $this$onStateMutated) {
        IndexedListSet<OnPermissionFlagsChangedListener> r0 = this.onPermissionFlagsChangedListeners;
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        OnPermissionFlagsChangedListener it = r0.elementAt(index$iv);
        it.onStateMutated();
        index$iv = index$iv + 1;
        goto L3
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onUserAdded(MutateStateScope $this$onUserAdded, int userId) {
        Iterator<Map.Entry<String, PackageState>> r2 = $this$onUserAdded.getNewState().getExternalState().getPackageStates().entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        PackageState packageState = r2.next().getValue();
        if (packageState.isApex() == true) goto L4;
        evaluateAllPermissionStatesForPackageAndUser($this$onUserAdded, packageState, userId, null);
        goto L4
    L10:
        IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r0 = $this$onUserAdded.getNewState().getExternalState().getAppIdPackageNames();
        int index$iv = 0;
        int r3 = r0.getSize();
    L11:
        if (index$iv >= r3) goto L14;
        int appId = r0.keyAt(index$iv);
        IndexedListSet r5 = (IndexedListSet) r0.valueAt(index$iv);
        inheritImplicitPermissionStates($this$onUserAdded, appId, userId);
        index$iv = index$iv + 1;
        goto L11
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onAppIdRemoved(MutateStateScope $this$onAppIdRemoved, int appId) {
        IntReferenceMap<UserState, MutableUserState> r0 = $this$onAppIdRemoved.getNewState().getUserStates();
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L9;
        r0.keyAt(index$iv);
        UserState userState = (UserState) r0.valueAt(index$iv);
        int userStateIndex = index$iv;
        if (userState.getAppIdPermissionFlags().contains(appId) == false) goto L7;
        IntReferenceMapExtensionsKt.minusAssign(MutableAccessState.mutateUserStateAt$default($this$onAppIdRemoved.getNewState(), userStateIndex, 0, 2, null).mutateAppIdPermissionFlags(), appId);
    L7:
        index$iv = index$iv + 1;
        goto L3
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onStorageVolumeMounted(MutateStateScope $this$onStorageVolumeMounted, String volumeUuid, List<String> r20, boolean isSystemUpdated) {
        MutableIndexedSet<String> r2 = new MutableIndexedSet(null, 1, null);
        int index$iv = 0;
        int r7 = r20.size();
    L3:
        if (index$iv >= r7) goto L9;
        String packageName = r20.get(index$iv);
        PackageState packageState = $this$onStorageVolumeMounted.getNewState().getExternalState().getPackageStates().get(packageName);
        if (packageState == null) goto L8;
        adoptPermissions($this$onStorageVolumeMounted, packageState, r2);
        addPermissionGroups($this$onStorageVolumeMounted, packageState);
        addPermissions($this$onStorageVolumeMounted, packageState, r2);
        trimPermissions($this$onStorageVolumeMounted, packageState.getPackageName(), r2);
        trimPermissionStates($this$onStorageVolumeMounted, packageState.getAppId());
    L8:
        index$iv = index$iv + 1;
        goto L3
    L9:
        int index$iv2 = 0;
        int r8 = r2.getSize();
    L10:
        if (index$iv2 >= r8) goto L12;
        String permissionName = r2.elementAt(index$iv2);
        evaluatePermissionStateForAllPackages($this$onStorageVolumeMounted, permissionName, null);
        index$iv2 = index$iv2 + 1;
        goto L10
    L12:
        int index$iv3 = 0;
        int r9 = r20.size();
    L13:
        if (index$iv3 >= r9) goto L23;
        String packageName2 = r20.get(index$iv3);
        PackageState packageState2 = $this$onStorageVolumeMounted.getNewState().getExternalState().getPackageStates().get(packageName2);
        if (packageState2 == null) goto L22;
        if (isSystemUpdated == false) goto L20;
        PackageState installedPackageState = packageState2;
    L21:
        evaluateAllPermissionStatesForPackage($this$onStorageVolumeMounted, packageState2, installedPackageState);
        goto L22
    L20:
        installedPackageState = null;
    L22:
        index$iv3 = index$iv3 + 1;
        goto L13
    L23:
        int index$iv4 = 0;
        int r6 = r20.size();
    L24:
        if (index$iv4 >= r6) goto L34;
        String packageName3 = r20.get(index$iv4);
        PackageState packageState3 = $this$onStorageVolumeMounted.getNewState().getExternalState().getPackageStates().get(packageName3);
        if (packageState3 != null) goto L28;
        MutableIndexedSet<String> r16 = r2;
    L32:
        index$iv4 = index$iv4 + 1;
        r2 = r16;
        goto L24
    L28:
        IntSet $this$forEachIndexed$iv = $this$onStorageVolumeMounted.getNewState().getExternalState().getUserIds();
        int index$iv5 = 0;
        int r13 = $this$forEachIndexed$iv.getSize();
    L29:
        if (index$iv5 >= r13) goto L31;
        int userId = $this$forEachIndexed$iv.elementAt(index$iv5);
        inheritImplicitPermissionStates($this$onStorageVolumeMounted, packageState3.getAppId(), userId);
        index$iv5 = index$iv5 + 1;
        r2 = r2;
        goto L29
    L31:
        r16 = r2;
        revokePermissionsOnPackageUpdate($this$onStorageVolumeMounted, packageState3.getAppId());
        goto L32
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageAdded(MutateStateScope $this$onPackageAdded, PackageState packageState) {
        MutableIndexedSet<String> r0 = new MutableIndexedSet(null, 1, null);
        adoptPermissions($this$onPackageAdded, packageState, r0);
        addPermissionGroups($this$onPackageAdded, packageState);
        addPermissions($this$onPackageAdded, packageState, r0);
        trimPermissions($this$onPackageAdded, packageState.getPackageName(), r0);
        trimPermissionStates($this$onPackageAdded, packageState.getAppId());
        int index$iv = 0;
        int r5 = r0.getSize();
    L3:
        if (index$iv >= r5) goto L5;
        String permissionName = r0.elementAt(index$iv);
        evaluatePermissionStateForAllPackages($this$onPackageAdded, permissionName, null);
        index$iv = index$iv + 1;
        goto L3
    L5:
        evaluateAllPermissionStatesForPackage($this$onPackageAdded, packageState, packageState);
        IntSet $this$forEachIndexed$iv = $this$onPackageAdded.getNewState().getExternalState().getUserIds();
        int index$iv2 = 0;
        int r4 = $this$forEachIndexed$iv.getSize();
    L6:
        if (index$iv2 >= r4) goto L8;
        int userId = $this$forEachIndexed$iv.elementAt(index$iv2);
        inheritImplicitPermissionStates($this$onPackageAdded, packageState.getAppId(), userId);
        index$iv2 = index$iv2 + 1;
        goto L6
    L8:
        revokePermissionsOnPackageUpdate($this$onPackageAdded, packageState.getAppId());
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageRemoved(MutateStateScope $this$onPackageRemoved, String packageName, int appId) {
        if ($this$onPackageRemoved.getNewState().getExternalState().getDisabledSystemPackageStates().containsKey(packageName) == true) goto L13;
        MutableIndexedSet<String> r0 = new MutableIndexedSet(null, 1, null);
        trimPermissions($this$onPackageRemoved, packageName, r0);
        if ($this$onPackageRemoved.getNewState().getExternalState().getAppIdPackageNames().contains(appId) == false) goto L7;
        trimPermissionStates($this$onPackageRemoved, appId);
    L7:
        int index$iv = 0;
        int r5 = r0.getSize();
    L8:
        if (index$iv >= r5) goto L11;
        String permissionName = r0.elementAt(index$iv);
        evaluatePermissionStateForAllPackages($this$onPackageRemoved, permissionName, null);
        index$iv = index$iv + 1;
        goto L8
    L11:
        return;
    L13:
        throw new IllegalStateException(("Package " + packageName + " reported as removed before disabled system package is enabled").toString());
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageInstalled(MutateStateScope $this$onPackageInstalled, PackageState packageState, int userId) {
        clearRestrictedPermissionImplicitExemption($this$onPackageInstalled, packageState, userId);
    }

    private final void clearRestrictedPermissionImplicitExemption(MutateStateScope $this$clearRestrictedPermissionImplicitExemption, PackageState packageState, int userId) {
        if (packageState.isSystem() == false) goto L5;
        return;
    L5:
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        if (androidPackage != null) goto L8;
        return;
    L8:
        int appId = packageState.getAppId();
        Iterable $this$forEach$iv = androidPackage.getRequestedPermissions();
        Iterator r10 = $this$forEach$iv.iterator();
    L10:
        if (r10.hasNext() == false) goto L51;
        Object element$iv = r10.next();
        String permissionName = (String) element$iv;
        Permission permission = $this$clearRestrictedPermissionImplicitExemption.getNewState().getSystemState().getPermissions().get(permissionName);
        if (permission != null) goto L15;
        AndroidPackage androidPackage2 = androidPackage;
    L49:
        androidPackage = androidPackage2;
        goto L10
    L15:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 4) == false) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L23;
        androidPackage2 = androidPackage;
        goto L49
    L23:
        AccessState state$iv = $this$clearRestrictedPermissionImplicitExemption.getNewState();
        Immutable r4 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r4);
        IndexedListSet packageNames$iv = (IndexedListSet) r4;
        int r7 = packageNames$iv.getSize();
        androidPackage2 = androidPackage;
        int index$iv$iv$iv = 0;
    L24:
        if (index$iv$iv$iv >= r7) goto L44;
        Object element$iv$iv = packageNames$iv.elementAt(index$iv$iv$iv);
        int index$iv$iv$iv2 = index$iv$iv$iv;
        String packageName$iv = (String) element$iv$iv;
        AccessState state$iv2 = state$iv;
        PackageState packageState$iv = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        if (packageState$iv == null) goto L28;
        AndroidPackage r23 = packageState$iv.getAndroidPackage();
    L29:
        if (r23 == null) goto L40;
        if (packageState$iv.isSystem() == false) goto L36;
        AndroidPackage r26 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r26);
        if (r26.getRequestedPermissions().contains(permissionName) == false) goto L36;
        boolean r0 = true;
    L37:
        if (r0 == false) goto L40;
        boolean r2 = true;
    L41:
        if (r2 == true) goto L42;
        index$iv$iv$iv = index$iv$iv$iv2 + 1;
        state$iv = state$iv2;
        goto L24
    L42:
        boolean r6 = true;
    L45:
        boolean isRequestedBySystemPackage = r6;
        if (isRequestedBySystemPackage == true) goto L49;
        updatePermissionExemptFlags($this$clearRestrictedPermissionImplicitExemption, appId, userId, permission, 131072, 0);
    L36:
        r0 = false;
    L40:
        r2 = false;
        goto L41
    L28:
        r23 = null;
        goto L29
    L44:
        r6 = false;
        goto L45
    L17:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == true) goto L20;
        r1 = false;
        goto L21
    }

    public final void updatePermissionExemptFlags(MutateStateScope $this$updatePermissionExemptFlags, int appId, int userId, Permission permission, int exemptFlagMask, int exemptFlagValues) {
        String permissionName = permission.getPermissionInfo().name;
        int oldFlags = getPermissionFlags($this$updatePermissionExemptFlags, appId, userId, permissionName);
        int newFlags = IntExtensionsKt.andInv(oldFlags, exemptFlagMask) | (exemptFlagValues & exemptFlagMask);
        if (oldFlags != newFlags) goto L5;
        return;
    L5:
        boolean isExempt = IntExtensionsKt.hasAnyBit(newFlags, 229376);
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 4) == false) goto L12;
        if (isExempt == true) goto L12;
        int newFlags2 = newFlags | 262144;
        if (PermissionFlags.INSTANCE.isPermissionGranted(oldFlags) == false) goto L11;
        int newFlags3 = IntExtensionsKt.andInv(newFlags2, 128);
    L14:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == false) goto L44;
        if (isExempt == true) goto L44;
        int targetSdkVersion = getAppIdTargetSdkVersion$default(this, $this$updatePermissionExemptFlags, appId, permissionName, null, 4, null);
        AccessState state$iv = $this$updatePermissionExemptFlags.getNewState();
        Immutable r6 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r6);
        IndexedListSet packageNames$iv = (IndexedListSet) r6;
        int r12 = packageNames$iv.getSize();
        int index$iv$iv$iv = 0;
    L18:
        if (index$iv$iv$iv >= r12) goto L39;
        Object element$iv$iv = packageNames$iv.elementAt(index$iv$iv$iv);
        int index$iv$iv$iv2 = index$iv$iv$iv;
        String packageName$iv = (String) element$iv$iv;
        PackageState packageState$iv = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        if (packageState$iv == null) goto L22;
        AndroidPackage r24 = packageState$iv.getAndroidPackage();
    L23:
        if (r24 == null) goto L35;
        AndroidPackage r26 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r26);
        if (r26.getRequestedPermissions().contains(permissionName) == false) goto L30;
        if (isSoftRestrictedPermissionExemptForPackage(packageState$iv, targetSdkVersion, permissionName) == false) goto L30;
        boolean r25 = true;
    L32:
        if (r25 == false) goto L35;
        boolean r1 = true;
    L36:
        if (r1 == true) goto L37;
        index$iv$iv$iv = index$iv$iv$iv2 + 1;
        goto L18
    L37:
        boolean r2 = true;
    L41:
        if (r2 == true) goto L43;
        boolean isSoftRestricted = true;
    L46:
        if (isSoftRestricted == false) goto L48;
        int newFlags4 = 524288 | newFlags3;
    L50:
        if (oldFlags != newFlags4) goto L52;
        return;
    L52:
        setPermissionFlags($this$updatePermissionExemptFlags, appId, userId, permissionName, newFlags4);
        return;
    L48:
        newFlags4 = IntExtensionsKt.andInv(newFlags3, 524288);
        goto L50
    L43:
        isSoftRestricted = false;
    L30:
        r25 = false;
    L35:
        r1 = false;
        goto L36
    L22:
        r24 = null;
        goto L23
    L39:
        r2 = false;
    L44:
        isSoftRestricted = false;
        goto L46
    L11:
        newFlags3 = newFlags2;
    L12:
        newFlags3 = IntExtensionsKt.andInv(newFlags, 262144);
        goto L14
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageUninstalled(MutateStateScope $this$onPackageUninstalled, String packageName, int appId, int userId) {
        resetRuntimePermissions($this$onPackageUninstalled, packageName, userId, true);
    }

    public final void resetRuntimePermissions(MutateStateScope $this$resetRuntimePermissions, String packageName, int userId, boolean restorePregrants) {
        String r0 = packageName;
        PackageState packageState = $this$resetRuntimePermissions.getNewState().getExternalState().getPackageStates().get(r0);
        if (packageState != null) goto L5;
        return;
    L5:
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        if (androidPackage != null) goto L8;
        return;
    L8:
        int appId = packageState.getAppId();
        Iterable $this$forEach$iv = androidPackage.getRequestedPermissions();
        Iterator r11 = $this$forEach$iv.iterator();
    L10:
        if (r11.hasNext() == false) goto L71;
        Object element$iv = r11.next();
        String permissionName = (String) element$iv;
        Permission this_$iv = $this$resetRuntimePermissions.getNewState().getSystemState().getPermissions().get(permissionName);
        if (this_$iv == null) goto L69;
        if (this_$iv.getPermissionInfo().getProtection() != 1) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L69;
        if (IntExtensionsKt.hasBits(this_$iv.getPermissionInfo().flags, 2) == true) goto L69;
        AccessState state$iv = $this$resetRuntimePermissions.getNewState();
        Immutable r6 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r6);
        IndexedListSet packageNames$iv = (IndexedListSet) r6;
        IndexedListSet $this$forEachIndexed$iv$iv$iv = packageNames$iv;
        int r2 = $this$forEachIndexed$iv$iv$iv.getSize();
        int $i$f$anyPackageInAppId = 0;
    L23:
        if ($i$f$anyPackageInAppId >= r2) goto L42;
        int r20 = r2;
        IndexedListSet $this$forEachIndexed$iv$iv$iv2 = $this$forEachIndexed$iv$iv$iv;
        Object element$iv$iv = $this$forEachIndexed$iv$iv$iv2.elementAt($i$f$anyPackageInAppId);
        String packageName$iv = (String) element$iv$iv;
        int index$iv$iv$iv = $i$f$anyPackageInAppId;
        PackageState packageState$iv = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        if (packageState$iv == null) goto L27;
        AndroidPackage r27 = packageState$iv.getAndroidPackage();
    L28:
        if (r27 == null) goto L38;
        String packageName$iv2 = packageState$iv.getPackageName();
        if (Intrinsics.areEqual(packageName$iv2, r0) == true) goto L34;
        AndroidPackage r3 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r3);
        if (r3.getRequestedPermissions().contains(permissionName) == false) goto L34;
        boolean r4 = true;
    L35:
        if (r4 == false) goto L38;
        boolean r5 = true;
    L39:
        if (r5 == true) goto L40;
        $i$f$anyPackageInAppId = index$iv$iv$iv + 1;
        r2 = r20;
        $this$forEachIndexed$iv$iv$iv = $this$forEachIndexed$iv$iv$iv2;
        goto L23
    L40:
        boolean r7 = true;
    L43:
        boolean isRequestedByOtherPackages = r7;
        if (isRequestedByOtherPackages == true) goto L69;
        int oldFlags = getPermissionFlags($this$resetRuntimePermissions, appId, userId, permissionName);
        if (IntExtensionsKt.hasAnyBit(oldFlags, FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT) == true) goto L69;
        if (packageState.isSystem() == false) goto L52;
    L55:
        boolean isSystemOrInstalled = true;
    L57:
        if (isSystemOrInstalled == true) goto L59;
    L63:
        int newFlags = IntExtensionsKt.andInv(oldFlags, 536);
    L64:
        int newFlags2 = IntExtensionsKt.andInv(newFlags, 15728736);
        if (IntExtensionsKt.hasBits(newFlags2, 1024) == false) goto L67;
        newFlags2 = newFlags2 | 4096;
    L67:
        setPermissionFlags($this$resetRuntimePermissions, appId, userId, permissionName, newFlags2);
        goto L69
    L59:
        if (IntExtensionsKt.hasAnyBit(oldFlags, SystemService.PHASE_DEVICE_SPECIFIC_SERVICES_READY) == false) goto L63;
        if (restorePregrants == false) goto L62;
        newFlags = oldFlags | 16;
        goto L64
    L62:
        newFlags = oldFlags;
        goto L64
    L52:
        if (packageState.getUserStateOrDefault(userId).isInstalled() == true) goto L55;
        isSystemOrInstalled = false;
    L34:
        r4 = false;
    L38:
        r5 = false;
        goto L39
    L27:
        r27 = null;
        goto L28
    L42:
        r7 = false;
        goto L43
    L17:
        r1 = false;
    L69:
        r0 = packageName;
        goto L10
    }

    private final void adoptPermissions(MutateStateScope $this$adoptPermissions, PackageState packageState, MutableIndexedSet<String> r31) {
        AndroidPackage r0 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r0);
        List $this$forEachIndexed$iv = r0.getAdoptPermissions();
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int r4 = $this$forEachIndexed$iv.size();
    L3:
        if (index$iv >= r4) goto L17;
        String originalPackageName = (String) $this$forEachIndexed$iv.get(index$iv);
        String packageName = r0.getPackageName();
        if (canAdoptPermissions($this$adoptPermissions, packageName, originalPackageName) == false) goto L15;
        IndexedMap<String, Permission> r10 = $this$adoptPermissions.getNewState().getSystemState().getPermissions();
        int index$iv2 = 0;
        int r13 = r10.getSize();
    L8:
        if (index$iv2 >= r13) goto L15;
        String r14 = r10.keyAt(index$iv2);
        Permission oldPermission = r10.valueAt(index$iv2);
        String permissionName = r14;
        int permissionIndex = index$iv2;
        AndroidPackage r26 = r0;
        if (Intrinsics.areEqual(oldPermission.getPermissionInfo().packageName, originalPackageName) == false) goto L13;
        PermissionInfo newPermissionInfo = new PermissionInfo();
        newPermissionInfo.name = oldPermission.getPermissionInfo().name;
        newPermissionInfo.packageName = packageName;
        newPermissionInfo.protectionLevel = oldPermission.getPermissionInfo().protectionLevel;
        Permission newPermission = Permission.copy$default(oldPermission, newPermissionInfo, false, 0, 0, null, false, 52, null);
        MutableAccessState.mutateSystemState$default($this$adoptPermissions.getNewState(), 0, 1, null).mutatePermissions().putAt(permissionIndex, newPermission);
        r31.add(permissionName);
    L13:
        index$iv2 = index$iv2 + 1;
        $i$f$forEachIndexed = $i$f$forEachIndexed;
        index$iv = index$iv;
        r4 = r4;
        r0 = r26;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv;
    L15:
        index$iv = index$iv + 1;
        $i$f$forEachIndexed = $i$f$forEachIndexed;
        r4 = r4;
        r0 = r0;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv;
        goto L3
    }

    private final boolean canAdoptPermissions(MutateStateScope $this$canAdoptPermissions, String packageName, String originalPackageName) {
        PackageState originalPackageState = $this$canAdoptPermissions.getNewState().getExternalState().getPackageStates().get(originalPackageName);
        if (originalPackageState != null) goto L6;
        return false;
    L6:
        if (originalPackageState.isSystem() == true) goto L10;
        Slog.w(LOG_TAG, "Unable to adopt permissions from " + originalPackageName + " to " + packageName + ": original package not in system partition");
        return false;
    L10:
        if (originalPackageState.getAndroidPackage() == null) goto L13;
        Slog.w(LOG_TAG, "Unable to adopt permissions from " + originalPackageName + " to " + packageName + ": original package still exists");
        return false;
    L13:
        return true;
    }

    private final void addPermissionGroups(MutateStateScope $this$addPermissionGroups, PackageState packageState) {
        SparseArray<? extends PackageUserState> r0 = packageState.getUserStates();
        int index$iv$iv = 0;
        int r5 = r0.size();
    L4:
        if (index$iv$iv >= r5) goto L9;
        r0.keyAt(index$iv$iv);
        Object value$iv = r0.valueAt(index$iv$iv);
        PackageUserState it = (PackageUserState) value$iv;
        if (it.isInstantApp() == false) goto L7;
        index$iv$iv = index$iv$iv + 1;
        goto L4
    L7:
        boolean isInstantApp = false;
    L11:
        if (isInstantApp == false) goto L14;
        Slog.w(LOG_TAG, "Ignoring permission groups declared in package " + packageState.getPackageName() + ": instant apps cannot declare permission groups");
        return;
    L14:
        AndroidPackage r1 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r1);
        List $this$forEachIndexed$iv = r1.getPermissionGroups();
        int index$iv = 0;
        int r4 = $this$forEachIndexed$iv.size();
    L15:
        if (index$iv >= r4) goto L35;
        ParsedPermissionGroup parsedPermissionGroup = (ParsedPermissionGroup) $this$forEachIndexed$iv.get(index$iv);
        PermissionGroupInfo newPermissionGroup = PackageInfoUtils.generatePermissionGroupInfo(parsedPermissionGroup, 128);
        Intrinsics.checkNotNull(newPermissionGroup);
        String permissionGroupName = newPermissionGroup.name;
        PermissionGroupInfo oldPermissionGroup = $this$addPermissionGroups.getNewState().getSystemState().getPermissionGroups().get(permissionGroupName);
        if (oldPermissionGroup != null) goto L19;
    L32:
        MutableAccessState.mutateSystemState$default($this$addPermissionGroups.getNewState(), 0, 1, null).mutatePermissionGroups().put(permissionGroupName, newPermissionGroup);
    L33:
        index$iv = index$iv + 1;
        goto L15
    L19:
        if (Intrinsics.areEqual(newPermissionGroup.packageName, oldPermissionGroup.packageName) == true) goto L32;
        String newPackageName = newPermissionGroup.packageName;
        String oldPackageName = oldPermissionGroup.packageName;
        if (packageState.isSystem() == true) goto L23;
        Slog.w(LOG_TAG, "Ignoring permission group " + permissionGroupName + " declared in package " + newPackageName + ": already declared in another package " + oldPackageName);
        goto L33
    L23:
        PackageState r6 = $this$addPermissionGroups.getNewState().getExternalState().getPackageStates().get(oldPackageName);
        if (r6 != null) goto L26;
    L28:
        boolean r7 = false;
    L29:
        if (r7 == false) goto L31;
        Slog.w(LOG_TAG, "Ignoring permission group " + permissionGroupName + " declared in system package " + newPackageName + ": already declared in another system package " + oldPackageName);
        goto L33
    L31:
        Slog.w(LOG_TAG, "Overriding permission group " + permissionGroupName + " with new declaration in system package " + newPackageName + ": originally declared in another package " + oldPackageName);
        goto L32
    L26:
        if (r6.isSystem() != true) goto L28;
        r7 = true;
        goto L29
    L35:
        return;
    L9:
        isInstantApp = true;
        goto L11
    }

    private final void addPermissions(MutateStateScope $this$addPermissions, PackageState packageState, MutableIndexedSet<String> r43) {
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        PackageState r1 = $this$addPermissions.getOldState().getExternalState().getPackageStates().get(packageState.getPackageName());
        if (r1 == null) goto L5;
        AndroidPackage oldNewPackage = r1.getAndroidPackage();
    L7:
        if (oldNewPackage != null) goto L9;
    L11:
        boolean isPackageSigningChanged = false;
    L12:
        List $this$forEachIndexed$iv = androidPackage.getPermissions();
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int r9 = $this$forEachIndexed$iv.size();
    L13:
        if (index$iv >= r9) goto L153;
        ParsedPermission parsedPermission = (ParsedPermission) $this$forEachIndexed$iv.get(index$iv);
        PermissionInfo newPermissionInfo = PackageInfoUtils.generatePermissionInfo(parsedPermission, 128);
        Intrinsics.checkNotNull(newPermissionInfo);
        String permissionName = newPermissionInfo.name;
        if (parsedPermission.isTree() == false) goto L17;
        Permission r13 = $this$addPermissions.getNewState().getSystemState().getPermissionTrees().get(permissionName);
    L18:
        Permission oldPermission = r13;
        AppIdPermissionPolicy r15 = this;
        MutateStateScope r14 = $this$addPermissions;
        Permission permissionTree = r15.findPermissionTree(r14, permissionName);
        String newPackageName = newPermissionInfo.packageName;
        if (permissionTree == null) goto L24;
        AndroidPackage androidPackage2 = androidPackage;
        if (Intrinsics.areEqual(newPackageName, permissionTree.getPermissionInfo().packageName) == true) goto L25;
        oldNewPackage = oldNewPackage;
        isPackageSigningChanged = isPackageSigningChanged;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv;
        Slog.w(LOG_TAG, "Ignoring permission " + permissionName + " declared in package " + newPackageName + ": base permission tree " + permissionTree.getPermissionInfo().name + " is declared in another package " + permissionTree.getPermissionInfo().packageName);
        int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        int index$iv2 = index$iv;
    L151:
        index$iv = index$iv2 + 1;
        androidPackage = androidPackage2;
        oldNewPackage = oldNewPackage;
        isPackageSigningChanged = isPackageSigningChanged;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv;
        $i$f$forEachIndexed = $i$f$forEachIndexed2;
    L25:
        if (oldPermission != null) goto L27;
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
    L95:
        int[] r0 = EmptyArray.INT;
        boolean areGidsPerUser = false;
        if (parsedPermission.isTree() == false) goto L98;
    L105:
        int[] r18 = r0;
        boolean areGidsPerUser2 = false;
    L106:
        Permission newPermission = new Permission(newPermissionInfo, true, 0, packageState.getAppId(), r18, areGidsPerUser2);
        if (parsedPermission.isTree() == false) goto L109;
        MutableAccessState.mutateSystemState$default($this$addPermissions.getNewState(), 0, 1, null).mutatePermissionTrees().put(permissionName, newPermission);
        goto L151
    L109:
        MutableAccessState.mutateSystemState$default($this$addPermissions.getNewState(), 0, 1, null).mutatePermissions().put(permissionName, newPermission);
        if (oldPermission != null) goto L112;
        boolean r6 = true;
    L146:
        boolean isPermissionChanged = r6;
    L148:
        if (isPermissionChanged == false) goto L151;
        r43.add(permissionName);
        goto L151
    L112:
        if (Intrinsics.areEqual(newPackageName, oldPermission.getPermissionInfo().packageName) == true) goto L114;
        r6 = true;
        goto L146
    L114:
        if (newPermission.getPermissionInfo().protectionLevel == oldPermission.getPermissionInfo().protectionLevel) goto L116;
        r6 = true;
        goto L146
    L116:
        if (oldPermission.isReconciled() == false) goto L142;
        if (newPermission.getPermissionInfo().getProtection() != 2) goto L120;
        boolean r2 = true;
    L121:
        if (r2 == false) goto L126;
        if (isPackageSigningChanged == 0) goto L126;
        r6 = true;
    L126:
        if (IntExtensionsKt.hasBits(newPermission.getPermissionInfo().getProtectionFlags(), 134217728) == true) goto L128;
    L131:
        r6 = true;
        if (newPermission.getPermissionInfo().getProtection() != 1) goto L134;
        boolean r3 = true;
    L135:
        if (r3 == false) goto L142;
        if (newPermission.getPermissionInfo().group == null) goto L142;
        if (Intrinsics.areEqual(newPermission.getPermissionInfo().group, oldPermission.getPermissionInfo().group) == true) goto L142;
    L134:
        r3 = false;
        goto L135
    L128:
        if (Intrinsics.areEqual(newPermission.getPermissionInfo().knownCerts, oldPermission.getPermissionInfo().knownCerts) == true) goto L131;
        r6 = true;
        goto L146
    L120:
        r2 = false;
    L142:
        isPermissionChanged = false;
        goto L148
    L98:
        if (packageState.isSystem() == false) goto L105;
        SystemConfig.PermissionEntry it = $this$addPermissions.getNewState().getExternalState().getConfigPermissions().get(permissionName);
        if (it == null) goto L105;
        if (it.gids == null) goto L104;
        r0 = it.gids;
        areGidsPerUser = it.perUser;
    L104:
        r18 = r0;
        areGidsPerUser2 = areGidsPerUser;
        goto L106
    L27:
        if (Intrinsics.areEqual(newPackageName, oldPermission.getPermissionInfo().packageName) == true) goto L47;
        String oldPackageName = oldPermission.getPermissionInfo().packageName;
        if (packageState.isSystem() == true) goto L31;
        Slog.w(LOG_TAG, "Ignoring permission " + permissionName + " declared in package " + newPackageName + ": already declared in another package " + oldPackageName);
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
        goto L151
    L31:
        PackageState r4 = r14.getNewState().getExternalState().getPackageStates().get(oldPackageName);
        if (r4 != null) goto L34;
    L36:
        boolean r5 = false;
    L37:
        if (r5 == false) goto L39;
        Slog.w(LOG_TAG, "Ignoring permission " + permissionName + " declared in system package " + newPackageName + ": already declared in another system package " + oldPackageName);
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
        goto L151
    L39:
        Slog.w(LOG_TAG, "Overriding permission " + permissionName + " with new declaration in system package " + newPackageName + ": originally declared in another package " + oldPackageName);
        IntSet $this$forEachIndexed$iv2 = r14.getNewState().getExternalState().getUserIds();
        int $i$f$forEachIndexed3 = 0;
        int index$iv3 = 0;
        int r7 = $this$forEachIndexed$iv2.getSize();
    L40:
        if (index$iv3 >= r7) goto L45;
        int userId = $this$forEachIndexed$iv2.elementAt(index$iv3);
        String oldPackageName2 = oldPackageName;
        IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r8 = r14.getNewState().getExternalState().getAppIdPackageNames();
        IntSet $this$forEachIndexed$iv3 = $this$forEachIndexed$iv2;
        int r10 = r8.getSize();
        int $i$f$forEachIndexed4 = $i$f$forEachIndexed3;
        int $i$f$forEachIndexed5 = 0;
    L42:
        if ($i$f$forEachIndexed5 >= r10) goto L44;
        int appId = r8.keyAt($i$f$forEachIndexed5);
        IndexedListSet r16 = (IndexedListSet) r8.valueAt($i$f$forEachIndexed5);
        r15.setPermissionFlags(r14, appId, userId, permissionName, 0);
        $i$f$forEachIndexed5 = $i$f$forEachIndexed5 + 1;
        r15 = this;
        r14 = $this$addPermissions;
        goto L42
    L44:
        index$iv3 = index$iv3 + 1;
        r15 = this;
        r14 = $this$addPermissions;
        oldPackageName = oldPackageName2;
        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv3;
        $i$f$forEachIndexed3 = $i$f$forEachIndexed4;
        goto L40
    L45:
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
        goto L95
    L34:
        if (r4.isSystem() != true) goto L36;
        r5 = true;
        goto L37
    L47:
        if (oldPermission.isReconciled() == true) goto L49;
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
        goto L95
    L49:
        if (newPermissionInfo.isRuntime() == true) goto L51;
    L55:
        boolean isPermissionGroupChanged = false;
    L57:
        if (newPermissionInfo.isRuntime() == false) goto L64;
        if (oldPermission.getPermissionInfo().getProtection() != 1) goto L61;
        boolean r11 = true;
    L62:
        if (r11 == true) goto L64;
    L73:
        boolean isPermissionProtectionChanged = true;
    L76:
        if (isPermissionGroupChanged == true) goto L80;
        if (isPermissionProtectionChanged == true) goto L80;
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
    L80:
        IntSet $this$forEachIndexed$iv4 = $this$addPermissions.getNewState().getExternalState().getUserIds();
        int $i$f$forEachIndexed6 = 0;
        int index$iv4 = 0;
        int r12 = $this$forEachIndexed$iv4.getSize();
    L81:
        if (index$iv4 >= r12) goto L92;
        int userId2 = $this$forEachIndexed$iv4.elementAt(index$iv4);
        IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r17 = $this$addPermissions.getNewState().getExternalState().getAppIdPackageNames();
        boolean isPermissionGroupChanged2 = isPermissionGroupChanged;
        int r19 = r17.getSize();
        boolean isPermissionProtectionChanged2 = isPermissionProtectionChanged;
        int index$iv5 = 0;
    L83:
        if (index$iv5 >= r19) goto L91;
        int r31 = r19;
        int appId2 = r17.keyAt(index$iv5);
        IndexedListSet r110 = (IndexedListSet) r17.valueAt(index$iv5);
        int index$iv6 = index$iv5;
        IntSet $this$forEachIndexed$iv5 = $this$forEachIndexed$iv4;
        if (isPermissionGroupChanged2 == false) goto L88;
        Slog.w(LOG_TAG, "Revoking runtime permission " + permissionName + " for appId " + appId2 + " and userId " + userId2 + " as the permission group changed from " + oldPermission.getPermissionInfo().group + " to " + newPermissionInfo.group);
    L88:
        if (isPermissionProtectionChanged2 == false) goto L90;
        Slog.w(LOG_TAG, "Revoking permission " + permissionName + " for appId " + appId2 + " and userId " + userId2 + " as the permission protection changed.");
    L90:
        setPermissionFlags($this$addPermissions, appId2, userId2, permissionName, 0);
        index$iv5 = index$iv6 + 1;
        r17 = r17;
        r19 = r31;
        $this$forEachIndexed$iv4 = $this$forEachIndexed$iv5;
        $i$f$forEachIndexed6 = $i$f$forEachIndexed6;
        index$iv4 = index$iv4;
        r12 = r12;
        $i$f$forEachIndexed = $i$f$forEachIndexed;
        index$iv = index$iv;
        goto L83
    L91:
        index$iv4 = index$iv4 + 1;
        isPermissionGroupChanged = isPermissionGroupChanged2;
        isPermissionProtectionChanged = isPermissionProtectionChanged2;
        goto L81
    L92:
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        index$iv2 = index$iv;
        goto L95
    L61:
        r11 = false;
    L64:
        if (newPermissionInfo.getProtection() != 4) goto L66;
        boolean r20 = true;
    L67:
        if (r20 == true) goto L69;
    L74:
        isPermissionProtectionChanged = false;
        goto L76
    L69:
        if (oldPermission.getPermissionInfo().getProtection() != 4) goto L71;
        boolean r21 = true;
    L72:
        if (r21 == true) goto L74;
    L71:
        r21 = false;
        goto L72
    L66:
        r20 = false;
        goto L67
    L51:
        if (newPermissionInfo.group == null) goto L55;
        if (Intrinsics.areEqual(newPermissionInfo.group, oldPermission.getPermissionInfo().group) == true) goto L55;
        isPermissionGroupChanged = true;
        goto L57
    L24:
        androidPackage2 = androidPackage;
        goto L25
    L17:
        r13 = $this$addPermissions.getNewState().getSystemState().getPermissions().get(permissionName);
        goto L18
    L153:
        return;
    L9:
        if (Intrinsics.areEqual(androidPackage.getSigningDetails(), oldNewPackage.getSigningDetails()) == true) goto L11;
        isPackageSigningChanged = true;
        goto L12
    L5:
        oldNewPackage = null;
        goto L7
    }

    private final void trimPermissions(MutateStateScope $this$trimPermissions, String packageName, MutableIndexedSet<String> r31) {
        String r0 = packageName;
        PackageState packageState = $this$trimPermissions.getNewState().getExternalState().getPackageStates().get(r0);
        if (packageState == null) goto L5;
        AndroidPackage androidPackage = packageState.getAndroidPackage();
    L6:
        if (packageState == null) goto L9;
        if (androidPackage != null) goto L9;
        return;
    L9:
        PackageState r4 = $this$trimPermissions.getNewState().getExternalState().getDisabledSystemPackageStates().get(r0);
        if (r4 == null) goto L12;
        AndroidPackage disabledSystemPackage = r4.getAndroidPackage();
    L13:
        IndexedMap<String, Permission> r5 = $this$trimPermissions.getNewState().getSystemState().getPermissionTrees();
        int index$iv = r5.getSize() - 1;
    L14:
        int r7 = -1;
        if ((-1) >= index$iv) goto L59;
        String r8 = r5.keyAt(index$iv);
        Permission permissionTree = r5.valueAt(index$iv);
        String permissionTreeName = r8;
        int permissionTreeIndex = index$iv;
        if (Intrinsics.areEqual(permissionTree.getPermissionInfo().packageName, r0) == false) goto L57;
        if (packageState == null) goto L34;
        Intrinsics.checkNotNull(androidPackage);
        List $this$noneIndexed$iv = androidPackage.getPermissions();
        int r9 = $this$noneIndexed$iv.size();
        int index$iv$iv = 0;
    L20:
        if (index$iv$iv >= r9) goto L31;
        Object element$iv = $this$noneIndexed$iv.get(index$iv$iv);
        ParsedPermission it = (ParsedPermission) element$iv;
        if (it.isTree() == false) goto L26;
        PackageState packageState2 = packageState;
        if (Intrinsics.areEqual(it.getName(), permissionTreeName) == false) goto L27;
        boolean r1 = true;
    L28:
        if (r1 == true) goto L29;
        index$iv$iv = index$iv$iv + 1;
        packageState = packageState2;
        goto L20
    L29:
        boolean r2 = false;
    L32:
        if (r2 == false) goto L58;
    L35:
        if (disabledSystemPackage == null) goto L54;
        List $this$anyIndexed$iv = disabledSystemPackage.getPermissions();
        if ($this$anyIndexed$iv == null) goto L54;
        int index$iv$iv2 = 0;
        int r15 = $this$anyIndexed$iv.size();
    L39:
        if (index$iv$iv2 >= r15) goto L50;
        Object element$iv2 = $this$anyIndexed$iv.get(index$iv$iv2);
        ParsedPermission it2 = (ParsedPermission) element$iv2;
        if (it2.isTree() == false) goto L45;
        List $this$anyIndexed$iv2 = $this$anyIndexed$iv;
        if (Intrinsics.areEqual(it2.getName(), permissionTreeName) == false) goto L46;
        boolean r3 = true;
    L47:
        if (r3 == true) goto L48;
        index$iv$iv2 = index$iv$iv2 + 1;
        $this$anyIndexed$iv = $this$anyIndexed$iv2;
        goto L39
    L48:
        boolean r6 = true;
    L52:
        if (r6 != true) goto L54;
        boolean r10 = true;
    L55:
        if (r10 == true) goto L58;
        MutableAccessState.mutateSystemState$default($this$trimPermissions.getNewState(), 0, 1, null).mutatePermissionTrees().removeAt(permissionTreeIndex);
    L46:
        r3 = false;
        goto L47
    L45:
        $this$anyIndexed$iv2 = $this$anyIndexed$iv;
        goto L46
    L50:
        r6 = false;
    L54:
        r10 = false;
    L58:
        index$iv = index$iv - 1;
        packageState = packageState2;
    L27:
        r1 = false;
        goto L28
    L26:
        packageState2 = packageState;
        goto L27
    L31:
        packageState2 = packageState;
        r2 = true;
        goto L32
    L34:
        packageState2 = packageState;
        goto L35
    L57:
        packageState2 = packageState;
        goto L58
    L59:
        PackageState packageState3 = packageState;
        IndexedMap<String, Permission> r11 = $this$trimPermissions.getNewState().getSystemState().getPermissions();
        int index$iv2 = r11.getSize() - 1;
    L60:
        if (r7 >= index$iv2) goto L112;
        String r12 = r11.keyAt(index$iv2);
        Permission permission = r11.valueAt(index$iv2);
        String permissionName = r12;
        int permissionIndex = index$iv2;
        AppIdPermissionPolicy r13 = this;
        MutateStateScope r14 = $this$trimPermissions;
        Permission updatedPermission = r13.updatePermissionIfDynamic(r14, permission);
        IndexedMap<String, Permission> r17 = r11;
        MutableAccessState.mutateSystemState$default(r14.getNewState(), 0, 1, null).mutatePermissions().putAt(permissionIndex, updatedPermission);
        if (Intrinsics.areEqual(updatedPermission.getPermissionInfo().packageName, r0) == false) goto L110;
        if (packageState3 == null) goto L80;
        Intrinsics.checkNotNull(androidPackage);
        List $this$noneIndexed$iv2 = androidPackage.getPermissions();
        int r16 = $this$noneIndexed$iv2.size();
        int index$iv$iv3 = 0;
    L65:
        if (index$iv$iv3 >= r16) goto L76;
        Object element$iv3 = $this$noneIndexed$iv2.get(index$iv$iv3);
        ParsedPermission it3 = (ParsedPermission) element$iv3;
        if (it3.isTree() == true) goto L71;
        int r26 = r16;
        if (Intrinsics.areEqual(it3.getName(), permissionName) == false) goto L72;
        boolean r18 = true;
    L73:
        if (r18 == true) goto L74;
        index$iv$iv3 = index$iv$iv3 + 1;
        r16 = r26;
        goto L65
    L74:
        boolean r19 = false;
    L77:
        if (r19 == false) goto L110;
    L72:
        r18 = false;
        goto L73
    L71:
        r26 = r16;
        goto L72
    L76:
        r19 = true;
    L80:
        if (disabledSystemPackage == null) goto L99;
        List $this$anyIndexed$iv3 = disabledSystemPackage.getPermissions();
        if ($this$anyIndexed$iv3 == null) goto L99;
        int index$iv$iv4 = 0;
        int r20 = $this$anyIndexed$iv3.size();
    L84:
        if (index$iv$iv4 >= r20) goto L95;
        Object element$iv4 = $this$anyIndexed$iv3.get(index$iv$iv4);
        ParsedPermission it4 = (ParsedPermission) element$iv4;
        if (it4.isTree() == true) goto L90;
        int r27 = r20;
        if (Intrinsics.areEqual(it4.getName(), permissionName) == false) goto L91;
        boolean r21 = true;
    L92:
        if (r21 == true) goto L93;
        index$iv$iv4 = index$iv$iv4 + 1;
        r20 = r27;
        goto L84
    L93:
        boolean r22 = true;
    L97:
        if (r22 != true) goto L99;
        boolean r23 = true;
    L100:
        if (r23 == true) goto L110;
        IntSet $this$forEachIndexed$iv = r14.getNewState().getExternalState().getUserIds();
        int $i$f$forEachIndexed = 0;
        int index$iv3 = 0;
        int r110 = $this$forEachIndexed$iv.getSize();
    L102:
        if (index$iv3 >= r110) goto L107;
        int r111 = r110;
        int userId = $this$forEachIndexed$iv.elementAt(index$iv3);
        IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r112 = r14.getNewState().getExternalState().getAppIdPackageNames();
        IntSet $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
        int r24 = r112.getSize();
        int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        int $i$f$forEachIndexed3 = 0;
    L104:
        if ($i$f$forEachIndexed3 >= r24) goto L106;
        Permission updatedPermission2 = updatedPermission;
        int appId = r112.keyAt($i$f$forEachIndexed3);
        IndexedListSet r28 = (IndexedListSet) r112.valueAt($i$f$forEachIndexed3);
        r13.setPermissionFlags(r14, appId, userId, permissionName, 0);
        $i$f$forEachIndexed3 = $i$f$forEachIndexed3 + 1;
        r13 = this;
        r14 = $this$trimPermissions;
        updatedPermission = updatedPermission2;
        r112 = r112;
        goto L104
    L106:
        index$iv3 = index$iv3 + 1;
        r13 = this;
        r14 = $this$trimPermissions;
        r110 = r111;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
        $i$f$forEachIndexed = $i$f$forEachIndexed2;
        goto L102
    L107:
        MutableAccessState.mutateSystemState$default($this$trimPermissions.getNewState(), 0, 1, null).mutatePermissions().removeAt(permissionIndex);
        r31.add(permissionName);
    L91:
        r21 = false;
        goto L92
    L90:
        r27 = r20;
        goto L91
    L95:
        r22 = false;
    L99:
        r23 = false;
    L110:
        index$iv2 = index$iv2 - 1;
        r0 = packageName;
        r11 = r17;
        r7 = -1;
        goto L60
    L112:
        return;
    L12:
        disabledSystemPackage = null;
        goto L13
    L5:
        androidPackage = null;
        goto L6
    }

    private final Permission updatePermissionIfDynamic(MutateStateScope $this$updatePermissionIfDynamic, Permission permission) {
        if (permission.getType() != 2) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        return permission;
    L8:
        Permission permissionTree = findPermissionTree($this$updatePermissionIfDynamic, permission.getPermissionInfo().name);
        if (permissionTree != null) goto L11;
        return permission;
    L11:
        PermissionInfo $this$updatePermissionIfDynamic_u24lambda_u2437 = new PermissionInfo(permission.getPermissionInfo());
        $this$updatePermissionIfDynamic_u24lambda_u2437.packageName = permissionTree.getPermissionInfo().packageName;
        return Permission.copy$default(permission, $this$updatePermissionIfDynamic_u24lambda_u2437, true, 0, permissionTree.getAppId(), null, false, 52, null);
    L5:
        r2 = false;
        goto L6
    }

    private final void trimPermissionStates(MutateStateScope $this$trimPermissionStates, int appId) {
        int r2 = appId;
        MutableIndexedSet requestedPermissions = new MutableIndexedSet(null, 1, null);
        AccessState state$iv = $this$trimPermissionStates.getNewState();
        Immutable r3 = state$iv.getExternalState().getAppIdPackageNames().get(r2);
        Intrinsics.checkNotNull(r3);
        IndexedListSet packageNames$iv = (IndexedListSet) r3;
        int index$iv$iv = 0;
        int r9 = packageNames$iv.getSize();
    L3:
        if (index$iv$iv >= r9) goto L8;
        String packageName$iv = (String) packageNames$iv.elementAt(index$iv$iv);
        PackageState r12 = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        Intrinsics.checkNotNull(r12);
        PackageState packageState$iv = r12;
        if (packageState$iv.getAndroidPackage() == null) goto L7;
        AndroidPackage r15 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r15);
        IndexedSetExtensionsKt.plusAssign(requestedPermissions, r15.getRequestedPermissions());
    L7:
        index$iv$iv = index$iv$iv + 1;
        goto L3
    L8:
        IntReferenceMap<UserState, MutableUserState> r8 = $this$trimPermissionStates.getNewState().getUserStates();
        int r10 = r8.getSize();
        int index$iv = 0;
    L9:
        if (index$iv >= r10) goto L23;
        int userId = r8.keyAt(index$iv);
        UserState userState = (UserState) r8.valueAt(index$iv);
        IndexedMap $this$lastIndex$iv$iv = (IndexedMap) userState.getAppIdPermissionFlags().get(r2);
        if ($this$lastIndex$iv$iv == null) goto L21;
        int index$iv2 = $this$lastIndex$iv$iv.getSize() - 1;
    L14:
        if ((-1) >= index$iv2) goto L21;
        Object r1 = $this$lastIndex$iv$iv.keyAt(index$iv2);
        ((Number) $this$lastIndex$iv$iv.valueAt(index$iv2)).intValue();
        String permissionName = (String) r1;
        if (requestedPermissions.contains(permissionName) == true) goto L19;
        setPermissionFlags($this$trimPermissionStates, r2, userId, permissionName, 0);
    L19:
        index$iv2 = index$iv2 - 1;
        r2 = appId;
    L21:
        index$iv = index$iv + 1;
        r2 = appId;
        goto L9
    }

    private final void revokePermissionsOnPackageUpdate(MutateStateScope $this$revokePermissionsOnPackageUpdate, int appId) {
        revokeStorageAndMediaPermissionsOnPackageUpdate($this$revokePermissionsOnPackageUpdate, appId);
        revokeHeartRatePermissionsOnPackageUpdate($this$revokePermissionsOnPackageUpdate, appId);
    }

    private final void revokeStorageAndMediaPermissionsOnPackageUpdate(MutateStateScope $this$revokeStorageAndMediaPermissionsOnPackageUpdate, int appId) {
        if ($this$revokeStorageAndMediaPermissionsOnPackageUpdate.getOldState().getExternalState().getAppIdPackageNames().contains(appId) == false) goto L21;
        AccessState state$iv = $this$revokeStorageAndMediaPermissionsOnPackageUpdate.getOldState();
        Immutable r10 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r10);
        IndexedListSet packageNames$iv = (IndexedListSet) r10;
        int index$iv$iv$iv = 0;
        int r5 = packageNames$iv.getSize();
    L5:
        if (index$iv$iv$iv >= r5) goto L17;
        Object element$iv$iv = packageNames$iv.elementAt(index$iv$iv$iv);
        boolean r20 = true;
        String packageName$iv = (String) element$iv$iv;
        PackageState packageState$iv = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        if (packageState$iv == null) goto L9;
        AndroidPackage r22 = packageState$iv.getAndroidPackage();
    L11:
        if (r22 == null) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L15;
        index$iv$iv$iv = index$iv$iv$iv + 1;
        goto L5
    L15:
        boolean r6 = true;
    L19:
        if (r6 == false) goto L22;
        boolean hasOldPackage = r20;
    L24:
        if (hasOldPackage == true) goto L26;
        return;
    L26:
        int oldTargetSdkVersion = getAppIdTargetSdkVersion($this$revokeStorageAndMediaPermissionsOnPackageUpdate, appId, null, $this$revokeStorageAndMediaPermissionsOnPackageUpdate.getOldState());
        int newTargetSdkVersion = getAppIdTargetSdkVersion($this$revokeStorageAndMediaPermissionsOnPackageUpdate, appId, null, $this$revokeStorageAndMediaPermissionsOnPackageUpdate.getNewState());
        if (oldTargetSdkVersion < 29) goto L30;
        if (newTargetSdkVersion >= 29) goto L30;
        boolean isTargetSdkVersionDowngraded = r20;
    L32:
        if (oldTargetSdkVersion >= 29) goto L35;
        if (newTargetSdkVersion < 29) goto L35;
        boolean isTargetSdkVersionUpgraded = r20;
    L36:
        AccessState state$iv2 = $this$revokeStorageAndMediaPermissionsOnPackageUpdate.getOldState();
        Immutable r13 = state$iv2.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r13);
        IndexedListSet $this$forEachIndexed$iv$iv$iv = (IndexedListSet) r13;
        int r7 = $this$forEachIndexed$iv$iv$iv.getSize();
        int index$iv$iv$iv2 = 0;
    L37:
        if (index$iv$iv$iv2 >= r7) goto L50;
        int oldTargetSdkVersion2 = oldTargetSdkVersion;
        IndexedListSet $this$forEachIndexed$iv$iv$iv2 = $this$forEachIndexed$iv$iv$iv;
        Object element$iv$iv2 = $this$forEachIndexed$iv$iv$iv2.elementAt(index$iv$iv$iv2);
        int index$iv$iv$iv3 = index$iv$iv$iv2;
        String packageName$iv2 = (String) element$iv$iv2;
        PackageState packageState$iv2 = state$iv2.getExternalState().getPackageStates().get(packageName$iv2);
        if (packageState$iv2 == null) goto L41;
        AndroidPackage r27 = packageState$iv2.getAndroidPackage();
    L42:
        if (r27 == null) goto L46;
        AndroidPackage r30 = packageState$iv2.getAndroidPackage();
        Intrinsics.checkNotNull(r30);
        if (r30.isRequestLegacyExternalStorage() == false) goto L46;
        boolean r3 = r20;
    L47:
        if (r3 == true) goto L48;
        index$iv$iv$iv2 = index$iv$iv$iv3 + 1;
        oldTargetSdkVersion = oldTargetSdkVersion2;
        $this$forEachIndexed$iv$iv$iv = $this$forEachIndexed$iv$iv$iv2;
        goto L37
    L48:
        boolean oldIsRequestLegacyExternalStorage = r20;
    L51:
        AccessState state$iv3 = $this$revokeStorageAndMediaPermissionsOnPackageUpdate.getNewState();
        Immutable r11 = state$iv3.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r11);
        IndexedListSet packageNames$iv2 = (IndexedListSet) r11;
        boolean oldIsRequestLegacyExternalStorage2 = oldIsRequestLegacyExternalStorage;
        int r8 = packageNames$iv2.getSize();
        int index$iv$iv$iv4 = 0;
    L52:
        if (index$iv$iv$iv4 >= r8) goto L65;
        Object element$iv$iv3 = packageNames$iv2.elementAt(index$iv$iv$iv4);
        int r26 = r8;
        String packageName$iv3 = (String) element$iv$iv3;
        int index$iv$iv$iv5 = index$iv$iv$iv4;
        PackageState packageState$iv3 = state$iv3.getExternalState().getPackageStates().get(packageName$iv3);
        if (packageState$iv3 == null) goto L56;
        AndroidPackage r28 = packageState$iv3.getAndroidPackage();
    L57:
        if (r28 == null) goto L61;
        AndroidPackage r31 = packageState$iv3.getAndroidPackage();
        Intrinsics.checkNotNull(r31);
        if (r31.isRequestLegacyExternalStorage() == false) goto L61;
        boolean r9 = r20;
    L62:
        if (r9 == true) goto L63;
        index$iv$iv$iv4 = index$iv$iv$iv5 + 1;
        r8 = r26;
        goto L52
    L63:
        boolean newIsRequestLegacyExternalStorage = r20;
    L67:
        if (isTargetSdkVersionUpgraded == true) goto L71;
        if (oldIsRequestLegacyExternalStorage2 == true) goto L71;
        if (newIsRequestLegacyExternalStorage == false) goto L71;
        boolean isNewlyRequestingLegacyExternalStorage = r20;
    L73:
        if (isNewlyRequestingLegacyExternalStorage == true) goto L77;
        if (isTargetSdkVersionDowngraded == true) goto L77;
        boolean shouldRevokeStorageAndMediaPermissions = false;
    L79:
        if (shouldRevokeStorageAndMediaPermissions == false) goto L98;
        IntReferenceMap<UserState, MutableUserState> r12 = $this$revokeStorageAndMediaPermissionsOnPackageUpdate.getNewState().getUserStates();
        int index$iv = 0;
        int r14 = r12.getSize();
    L81:
        if (index$iv >= r14) goto L112;
        int userId = r12.keyAt(index$iv);
        UserState userState = (UserState) r12.valueAt(index$iv);
        boolean newIsRequestLegacyExternalStorage2 = newIsRequestLegacyExternalStorage;
        IndexedMap $this$forEachReversedIndexed$iv = (IndexedMap) userState.getAppIdPermissionFlags().get(appId);
        if ($this$forEachReversedIndexed$iv == null) goto L94;
        int index$iv2 = $this$forEachReversedIndexed$iv.getSize() - 1;
    L85:
        boolean shouldRevokeStorageAndMediaPermissions2 = shouldRevokeStorageAndMediaPermissions;
        if ((-1) >= index$iv2) goto L95;
        Object r15 = $this$forEachReversedIndexed$iv.keyAt(index$iv2);
        IndexedMap $this$forEachReversedIndexed$iv2 = $this$forEachReversedIndexed$iv;
        int oldFlags = ((Number) $this$forEachReversedIndexed$iv.valueAt(index$iv2)).intValue();
        String permissionName = (String) r15;
        int index$iv3 = index$iv2;
        if (STORAGE_AND_MEDIA_PERMISSIONS.contains(permissionName) == false) goto L92;
        if (IntExtensionsKt.hasBits(oldFlags, 16) == false) goto L92;
        revokeRuntimePermission($this$revokeStorageAndMediaPermissionsOnPackageUpdate, appId, userId, permissionName);
    L92:
        index$iv2 = index$iv3 - 1;
        shouldRevokeStorageAndMediaPermissions = shouldRevokeStorageAndMediaPermissions2;
        $this$forEachReversedIndexed$iv = $this$forEachReversedIndexed$iv2;
    L95:
        index$iv = index$iv + 1;
        newIsRequestLegacyExternalStorage = newIsRequestLegacyExternalStorage2;
        isNewlyRequestingLegacyExternalStorage = isNewlyRequestingLegacyExternalStorage;
        shouldRevokeStorageAndMediaPermissions = shouldRevokeStorageAndMediaPermissions2;
        goto L81
    L94:
        shouldRevokeStorageAndMediaPermissions2 = shouldRevokeStorageAndMediaPermissions;
        goto L95
    L112:
        return;
    L98:
        return;
    L77:
        shouldRevokeStorageAndMediaPermissions = r20;
    L71:
        isNewlyRequestingLegacyExternalStorage = false;
    L61:
        r9 = false;
        goto L62
    L56:
        r28 = null;
        goto L57
    L65:
        newIsRequestLegacyExternalStorage = false;
    L46:
        r3 = false;
        goto L47
    L41:
        r27 = null;
        goto L42
    L50:
        oldIsRequestLegacyExternalStorage = false;
    L35:
        isTargetSdkVersionUpgraded = false;
    L30:
        isTargetSdkVersionDowngraded = false;
    L22:
        hasOldPackage = false;
        goto L24
    L13:
        r4 = false;
        goto L14
    L9:
        r22 = null;
        goto L11
    L17:
        r20 = true;
        r6 = false;
        goto L19
    L21:
        r20 = true;
        goto L22
    }

    private final void revokeHeartRatePermissionsOnPackageUpdate(MutateStateScope $this$revokeHeartRatePermissionsOnPackageUpdate, int appId) {
        int targetSdkVersion = getAppIdTargetSdkVersion$default(this, $this$revokeHeartRatePermissionsOnPackageUpdate, appId, null, null, 4, null);
        if (targetSdkVersion < 36) goto L5;
        return;
    L5:
        AccessState state$iv = $this$revokeHeartRatePermissionsOnPackageUpdate.getNewState();
        Immutable r8 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r8);
        IndexedListSet packageNames$iv = (IndexedListSet) r8;
        int index$iv$iv$iv = 0;
        int r14 = packageNames$iv.getSize();
    L6:
        boolean isReadHealthDataInBackgroundRequested = false;
        if (index$iv$iv$iv >= r14) goto L21;
        Object element$iv$iv = packageNames$iv.elementAt(index$iv$iv$iv);
        int targetSdkVersion2 = targetSdkVersion;
        String packageName$iv = (String) element$iv$iv;
        AccessState state$iv2 = state$iv;
        PackageState packageState$iv = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        if (packageState$iv == null) goto L11;
        AndroidPackage r24 = packageState$iv.getAndroidPackage();
    L12:
        if (r24 == null) goto L17;
        AndroidPackage r27 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r27);
        if (r27.getRequestedPermissions().contains("android.permission.BODY_SENSORS") == false) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L19;
        index$iv$iv$iv = index$iv$iv$iv + 1;
        targetSdkVersion = targetSdkVersion2;
        state$iv = state$iv2;
        goto L6
    L19:
        boolean isBodySensorsRequested = true;
    L22:
        AccessState state$iv3 = $this$revokeHeartRatePermissionsOnPackageUpdate.getNewState();
        AppIdPermissionPolicy this_$iv = this;
        Immutable r9 = state$iv3.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r9);
        IndexedListSet packageNames$iv2 = (IndexedListSet) r9;
        int index$iv$iv$iv2 = 0;
        int r15 = packageNames$iv2.getSize();
    L23:
        boolean isBodySensorsRequested2 = isBodySensorsRequested;
        if (index$iv$iv$iv2 >= r15) goto L38;
        Object element$iv$iv2 = packageNames$iv2.elementAt(index$iv$iv$iv2);
        AccessState state$iv4 = state$iv3;
        String packageName$iv2 = (String) element$iv$iv2;
        AppIdPermissionPolicy this_$iv2 = this_$iv;
        PackageState packageState$iv2 = state$iv4.getExternalState().getPackageStates().get(packageName$iv2);
        if (packageState$iv2 == null) goto L28;
        AndroidPackage r26 = packageState$iv2.getAndroidPackage();
    L29:
        if (r26 == null) goto L34;
        AndroidPackage r29 = packageState$iv2.getAndroidPackage();
        Intrinsics.checkNotNull(r29);
        if (r29.getRequestedPermissions().contains("android.permission.health.READ_HEART_RATE") == false) goto L34;
        boolean r4 = true;
    L35:
        if (r4 == true) goto L36;
        index$iv$iv$iv2 = index$iv$iv$iv2 + 1;
        isBodySensorsRequested = isBodySensorsRequested2;
        state$iv3 = state$iv4;
        this_$iv = this_$iv2;
        goto L23
    L36:
        boolean isReadHeartRateRequested = true;
    L39:
        AccessState state$iv5 = $this$revokeHeartRatePermissionsOnPackageUpdate.getNewState();
        MutateStateScope $this$anyPackageInAppId$iv = $this$revokeHeartRatePermissionsOnPackageUpdate;
        Immutable r10 = state$iv5.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r10);
        IndexedListSet packageNames$iv3 = (IndexedListSet) r10;
        int index$iv$iv$iv3 = 0;
        boolean isReadHeartRateRequested2 = isReadHeartRateRequested;
        int r5 = packageNames$iv3.getSize();
    L40:
        AccessState state$iv6 = state$iv5;
        if (index$iv$iv$iv3 >= r5) goto L55;
        Object element$iv$iv3 = packageNames$iv3.elementAt(index$iv$iv$iv3);
        int r28 = r5;
        String packageName$iv3 = (String) element$iv$iv3;
        MutateStateScope $this$anyPackageInAppId$iv2 = $this$anyPackageInAppId$iv;
        PackageState packageState$iv3 = state$iv6.getExternalState().getPackageStates().get(packageName$iv3);
        if (packageState$iv3 == null) goto L45;
        AndroidPackage r210 = packageState$iv3.getAndroidPackage();
    L46:
        if (r210 == null) goto L51;
        AndroidPackage r31 = packageState$iv3.getAndroidPackage();
        Intrinsics.checkNotNull(r31);
        if (r31.getRequestedPermissions().contains("android.permission.BODY_SENSORS_BACKGROUND") == false) goto L51;
        boolean r6 = true;
    L52:
        if (r6 == true) goto L53;
        index$iv$iv$iv3 = index$iv$iv$iv3 + 1;
        state$iv5 = state$iv6;
        r5 = r28;
        $this$anyPackageInAppId$iv = $this$anyPackageInAppId$iv2;
        goto L40
    L53:
        boolean isBodySensorsBackgroundRequested = true;
    L56:
        AccessState state$iv7 = $this$revokeHeartRatePermissionsOnPackageUpdate.getNewState();
        AppIdPermissionPolicy this_$iv3 = this;
        Immutable r11 = state$iv7.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r11);
        IndexedListSet packageNames$iv4 = (IndexedListSet) r11;
        boolean isBodySensorsBackgroundRequested2 = isBodySensorsBackgroundRequested;
        int r7 = packageNames$iv4.getSize();
        int index$iv$iv$iv4 = 0;
    L57:
        AppIdPermissionPolicy this_$iv4 = this_$iv3;
        if (index$iv$iv$iv4 >= r7) goto L73;
        Object element$iv$iv4 = packageNames$iv4.elementAt(index$iv$iv$iv4);
        int r211 = r7;
        String packageName$iv4 = (String) element$iv$iv4;
        int index$iv$iv$iv5 = index$iv$iv$iv4;
        PackageState packageState$iv4 = state$iv7.getExternalState().getPackageStates().get(packageName$iv4);
        if (packageState$iv4 == null) goto L62;
        AndroidPackage r30 = packageState$iv4.getAndroidPackage();
    L63:
        if (r30 == null) goto L68;
        AndroidPackage r33 = packageState$iv4.getAndroidPackage();
        Intrinsics.checkNotNull(r33);
        if (r33.getRequestedPermissions().contains("android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND") == false) goto L68;
        boolean r12 = true;
    L69:
        if (r12 == true) goto L70;
        index$iv$iv$iv4 = index$iv$iv$iv5 + 1;
        this_$iv3 = this_$iv4;
        r7 = r211;
        goto L57
    L70:
        isReadHealthDataInBackgroundRequested = true;
    L68:
        r12 = false;
        goto L69
    L62:
        r30 = null;
    L73:
        IntReferenceMap<UserState, MutableUserState> r13 = $this$revokeHeartRatePermissionsOnPackageUpdate.getNewState().getUserStates();
        int index$iv = 0;
        int r16 = r13.getSize();
    L74:
        if (index$iv >= r16) goto L102;
        int userId = r13.keyAt(index$iv);
        UserState r17 = (UserState) r13.valueAt(index$iv);
        boolean isBodySensorsGranted = isRuntimePermissionGranted($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.BODY_SENSORS");
        if (isBodySensorsRequested2 == false) goto L86;
        if (isReadHeartRateRequested2 == false) goto L86;
        boolean isReadHeartRateGranted = isRuntimePermissionGranted($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.health.READ_HEART_RATE");
        if (isBodySensorsGranted == isReadHeartRateGranted) goto L86;
        if (isBodySensorsGranted == true) goto L82;
    L84:
        if (isReadHeartRateGranted == false) goto L86;
        revokeRuntimePermission($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.health.READ_HEART_RATE");
        goto L86
    L82:
        if (revokeRuntimePermission($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.BODY_SENSORS") == false) goto L84;
        isBodySensorsGranted = false;
    L86:
        boolean isBodySensorsBackgroundGranted = isRuntimePermissionGranted($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.BODY_SENSORS_BACKGROUND");
        if (isBodySensorsBackgroundGranted == false) goto L92;
        if (isBodySensorsGranted == true) goto L92;
        if (revokeRuntimePermission($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.BODY_SENSORS_BACKGROUND") == false) goto L92;
        isBodySensorsBackgroundGranted = false;
    L92:
        if (isBodySensorsBackgroundRequested2 == false) goto L100;
        if (isReadHealthDataInBackgroundRequested == false) goto L100;
        boolean isReadHealthDataInBackgroundGranted = isRuntimePermissionGranted($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
        if (isBodySensorsBackgroundGranted == isReadHealthDataInBackgroundGranted) goto L100;
        if (isBodySensorsBackgroundGranted == false) goto L98;
        revokeRuntimePermission($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.BODY_SENSORS_BACKGROUND");
    L98:
        if (isReadHealthDataInBackgroundGranted == false) goto L100;
        revokeRuntimePermission($this$revokeHeartRatePermissionsOnPackageUpdate, appId, userId, "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
    L100:
        index$iv = index$iv + 1;
        goto L74
    L102:
        return;
    L51:
        r6 = false;
        goto L52
    L45:
        r210 = null;
        goto L46
    L55:
        isBodySensorsBackgroundRequested = false;
    L34:
        r4 = false;
        goto L35
    L28:
        r26 = null;
        goto L29
    L38:
        isReadHeartRateRequested = false;
    L17:
        r3 = false;
        goto L18
    L11:
        r24 = null;
        goto L12
    L21:
        isBodySensorsRequested = false;
        goto L22
    }

    private final boolean isRuntimePermissionGranted(GetStateScope $this$isRuntimePermissionGranted, int appId, int userId, String permissionName) {
        int flags = getPermissionFlags($this$isRuntimePermissionGranted, appId, userId, permissionName);
        return PermissionFlags.INSTANCE.isAppOpGranted(flags);
    }

    public final boolean revokeRuntimePermission(MutateStateScope $this$revokeRuntimePermission, int appId, int userId, String permissionName) {
        Slog.v(LOG_TAG, "Revoking runtime permission for appId: " + appId + ", permission: " + permissionName + ", userId: " + userId);
        int flags = getPermissionFlags($this$revokeRuntimePermission, appId, userId, permissionName);
        if (IntExtensionsKt.hasAnyBit(flags, FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT) == false) goto L6;
        Slog.v(LOG_TAG, "Not allowed to revoke " + permissionName + " for appId: " + appId + ", userId: " + userId);
        return false;
    L6:
        setPermissionFlags($this$revokeRuntimePermission, appId, userId, permissionName, IntExtensionsKt.andInv(flags, 15729272));
        return true;
    }

    private final void evaluatePermissionStateForAllPackages(MutateStateScope $this$evaluatePermissionStateForAllPackages, String permissionName, PackageState installedPackageState) {
        ExternalState externalState = $this$evaluatePermissionStateForAllPackages.getNewState().getExternalState();
        IntSet $this$forEachIndexed$iv = externalState.getUserIds();
        int index$iv = 0;
        int r4 = $this$forEachIndexed$iv.getSize();
    L3:
        if (index$iv >= r4) goto L29;
        int userId = $this$forEachIndexed$iv.elementAt(index$iv);
        IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r12 = externalState.getAppIdPackageNames();
        int r14 = r12.getSize();
        int index$iv2 = 0;
    L5:
        if (index$iv2 >= r14) goto L27;
        int appId = r12.keyAt(index$iv2);
        IndexedListSet r5 = (IndexedListSet) r12.valueAt(index$iv2);
        AccessState state$iv = $this$evaluatePermissionStateForAllPackages.getNewState();
        Immutable r9 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r9);
        IndexedListSet packageNames$iv = (IndexedListSet) r9;
        IndexedListSet $this$forEachIndexed$iv$iv$iv = packageNames$iv;
        ExternalState externalState2 = externalState;
        int r0 = $this$forEachIndexed$iv$iv$iv.getSize();
        IntSet $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
        int index$iv$iv$iv = 0;
    L7:
        int index$iv$iv$iv2 = 0;
        if (index$iv$iv$iv >= r0) goto L22;
        int r23 = r0;
        IndexedListSet $this$forEachIndexed$iv$iv$iv2 = $this$forEachIndexed$iv$iv$iv;
        Object element$iv$iv = $this$forEachIndexed$iv$iv$iv2.elementAt(index$iv$iv$iv);
        String packageName$iv = (String) element$iv$iv;
        int index$iv$iv$iv3 = index$iv$iv$iv;
        PackageState packageState$iv = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        if (packageState$iv == null) goto L12;
        AndroidPackage r28 = packageState$iv.getAndroidPackage();
    L14:
        if (r28 == null) goto L18;
        AndroidPackage r32 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r32);
        String r1 = permissionName;
        if (r32.getRequestedPermissions().contains(r1) == false) goto L19;
        index$iv$iv$iv2 = 1;
    L19:
        if (index$iv$iv$iv2 != 0) goto L20;
        index$iv$iv$iv = index$iv$iv$iv3 + 1;
        r0 = r23;
        $this$forEachIndexed$iv$iv$iv = $this$forEachIndexed$iv$iv$iv2;
        goto L7
    L20:
        index$iv$iv$iv2 = 1;
    L24:
        if (index$iv$iv$iv2 == 0) goto L26;
        evaluatePermissionState($this$evaluatePermissionStateForAllPackages, appId, userId, r1, installedPackageState);
    L26:
        index$iv2 = index$iv2 + 1;
        externalState = externalState2;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
        goto L5
    L18:
        r1 = permissionName;
        goto L19
    L12:
        r28 = null;
        goto L14
    L22:
        r1 = permissionName;
        goto L24
    L27:
        index$iv = index$iv + 1;
        goto L3
    }

    private final void evaluateAllPermissionStatesForPackage(MutateStateScope $this$evaluateAllPermissionStatesForPackage, PackageState packageState, PackageState installedPackageState) {
        IntSet $this$forEachIndexed$iv = $this$evaluateAllPermissionStatesForPackage.getNewState().getExternalState().getUserIds();
        int index$iv = 0;
        int r3 = $this$forEachIndexed$iv.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        int userId = $this$forEachIndexed$iv.elementAt(index$iv);
        evaluateAllPermissionStatesForPackageAndUser($this$evaluateAllPermissionStatesForPackage, packageState, userId, installedPackageState);
        index$iv = index$iv + 1;
        goto L3
    }

    private final void evaluateAllPermissionStatesForPackageAndUser(MutateStateScope $this$evaluateAllPermissionStatesForPackageAndUser, PackageState packageState, int userId, PackageState installedPackageState) {
        AndroidPackage r0 = packageState.getAndroidPackage();
        if (r0 == null) goto L12;
        Iterable $this$forEach$iv = r0.getRequestedPermissions();
        if ($this$forEach$iv == null) goto L12;
        Iterator r2 = $this$forEach$iv.iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Object element$iv = r2.next();
        String permissionName = (String) element$iv;
        evaluatePermissionState($this$evaluateAllPermissionStatesForPackageAndUser, packageState.getAppId(), userId, permissionName, installedPackageState);
        goto L8
    L14:
        return;
    }

    private final void evaluatePermissionState(MutateStateScope $this$evaluatePermissionState, int appId, int userId, String permissionName, PackageState installedPackageState) {
        Immutable r3 = $this$evaluatePermissionState.getNewState().getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r3);
        IndexedListSet packageNames = (IndexedListSet) r3;
        MutableIndexedList requestingPackageStates = new MutableIndexedList(null, 1, null);
        int r11 = packageNames.getSize();
        int index$iv = 0;
        int index$iv2 = 0;
    L3:
        if (index$iv2 >= r11) goto L12;
        String packageName = (String) packageNames.elementAt(index$iv2);
        PackageState r14 = $this$evaluatePermissionState.getNewState().getExternalState().getPackageStates().get(packageName);
        Intrinsics.checkNotNull(r14);
        PackageState packageState = r14;
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        if (androidPackage != null) goto L7;
        index$iv = 1;
    L10:
        index$iv2 = index$iv2 + 1;
        goto L3
    L7:
        if (androidPackage.getRequestedPermissions().contains(permissionName) == false) goto L10;
        requestingPackageStates.add(packageState);
        goto L10
    L12:
        if (packageNames.getSize() != 1) goto L15;
        if (index$iv == 0) goto L15;
        return;
    L15:
        Permission permission = $this$evaluatePermissionState.getNewState().getSystemState().getPermissions().get(permissionName);
        int oldFlags = getPermissionFlags($this$evaluatePermissionState, appId, userId, permissionName);
        if (permission != null) goto L22;
        if (oldFlags != 0) goto L20;
        setPermissionFlags($this$evaluatePermissionState, appId, userId, permissionName, 2);
        return;
    L20:
        return;
    L22:
        if (permission.getPermissionInfo().getProtection() != 0) goto L24;
        boolean r2 = true;
    L26:
        if (r2 == false) goto L65;
        boolean wasGranted = IntExtensionsKt.hasBits(oldFlags, 1);
        if (wasGranted == true) goto L63;
        boolean wasRevoked = IntExtensionsKt.hasBits(oldFlags, 2);
        if (installedPackageState == null) goto L34;
        AndroidPackage r0 = installedPackageState.getAndroidPackage();
        Intrinsics.checkNotNull(r0);
        if (r0.getRequestedPermissions().contains(permissionName) == false) goto L34;
        boolean r1 = true;
    L35:
        boolean isRequestedByInstalledPackage = r1;
        IndexedList $this$forEachIndexed$iv$iv = requestingPackageStates;
        int r12 = $this$forEachIndexed$iv$iv.getSize();
        int index$iv$iv = 0;
    L36:
        if (index$iv$iv >= r12) goto L41;
        IndexedList $this$forEachIndexed$iv$iv2 = $this$forEachIndexed$iv$iv;
        Object element$iv = $this$forEachIndexed$iv$iv2.get(index$iv$iv);
        PackageState it = (PackageState) element$iv;
        if (it.isSystem() == true) goto L39;
        index$iv$iv = index$iv$iv + 1;
        $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv$iv2;
        goto L36
    L39:
        boolean r4 = true;
    L42:
        boolean isRequestedBySystemPackage = r4;
        int r5 = requestingPackageStates.getSize();
        int index$iv$iv2 = 0;
    L43:
        if (index$iv$iv2 >= r5) goto L48;
        Object element$iv2 = requestingPackageStates.get(index$iv$iv2);
        PackageState it2 = (PackageState) element$iv2;
        int index$iv$iv3 = index$iv$iv2;
        AndroidPackage r6 = it2.getAndroidPackage();
        Intrinsics.checkNotNull(r6);
        if (isCompatibilityPermissionForPackage(r6, permissionName) == true) goto L46;
        index$iv$iv2 = index$iv$iv3 + 1;
        goto L43
    L46:
        int $i$f$forEachIndexed = 1;
    L50:
        if (wasRevoked == false) goto L56;
        if (isRequestedByInstalledPackage == true) goto L56;
        if (isRequestedBySystemPackage == true) goto L56;
        if ($i$f$forEachIndexed != 0) goto L56;
        int newFlags = 2;
    L58:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 64) == false) goto L60;
        int newFlags2 = newFlags | (oldFlags & 40);
    L61:
        setPermissionFlags($this$evaluatePermissionState, appId, userId, permissionName, newFlags2);
        goto L63
    L60:
        newFlags2 = newFlags;
    L56:
        newFlags = 1;
        goto L58
    L48:
        $i$f$forEachIndexed = 0;
        goto L50
    L41:
        r4 = false;
    L34:
        r1 = false;
    L63:
        Unit r7 = Unit.INSTANCE;
        return;
    L65:
        if (permission.getPermissionInfo().getProtection() != 2) goto L67;
        boolean r8 = true;
    L69:
        if (r8 == true) goto L236;
        if (permission.getPermissionInfo().getProtection() != 4) goto L73;
        boolean r9 = true;
    L74:
        if (r9 == true) goto L236;
        if (permission.getPermissionInfo().getProtection() != 1) goto L79;
        boolean r10 = true;
    L80:
        if (r10 == false) goto L234;
        int newFlags3 = 16777208 & oldFlags;
        if (newFlags3 != 0) goto L84;
    L86:
        boolean wasRevoked2 = false;
    L87:
        int value$iv = 10000;
        IndexedList $this$forEachIndexed$iv$iv3 = requestingPackageStates;
        int r13 = $this$forEachIndexed$iv$iv3.getSize();
        int index$iv$iv4 = 0;
    L88:
        if (index$iv$iv4 >= r13) goto L90;
        IndexedListSet packageNames2 = packageNames;
        IndexedList $this$forEachIndexed$iv$iv4 = $this$forEachIndexed$iv$iv3;
        Object element$iv3 = $this$forEachIndexed$iv$iv4.get(index$iv$iv4);
        AndroidPackage r31 = ((PackageState) element$iv3).getAndroidPackage();
        Intrinsics.checkNotNull(r31);
        int index$iv$iv5 = index$iv$iv4;
        int index$iv$iv6 = r31.getTargetSdkVersion();
        value$iv = RangesKt.coerceAtMost(value$iv, index$iv$iv6);
        index$iv$iv4 = index$iv$iv5 + 1;
        packageNames = packageNames2;
        $this$forEachIndexed$iv$iv3 = $this$forEachIndexed$iv$iv4;
        goto L88
    L90:
        int targetSdkVersion = value$iv;
        if (targetSdkVersion >= 23) goto L106;
        int r22 = 229376;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 8192) == false) goto L95;
        int newFlags4 = newFlags3 & 229376;
        MutableIndexedList requestingPackageStates2 = requestingPackageStates;
    L201:
        boolean wasExempt = IntExtensionsKt.hasAnyBit(newFlags4, r22);
        boolean wasRestricted = IntExtensionsKt.hasAnyBit(newFlags4, 786432);
        int newFlags5 = newFlags4;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 4) == false) goto L204;
    L207:
        boolean r15 = true;
    L208:
        if (r15 == false) goto L212;
        if (wasExempt == true) goto L212;
        if (wasRestricted == true) goto L212;
        int newFlags6 = newFlags5 | 131072;
        boolean isExempt = true;
    L214:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 4) == false) goto L217;
        if (isExempt == true) goto L217;
        int newFlags7 = newFlags6 | 262144;
    L219:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == false) goto L231;
        if (isExempt == true) goto L230;
        MutableIndexedList $this$anyIndexed$iv = requestingPackageStates2;
        int r18 = 524288;
        int r16 = $this$anyIndexed$iv.getSize();
        int index$iv$iv7 = 0;
    L222:
        if (index$iv$iv7 >= r16) goto L227;
        Object element$iv4 = $this$anyIndexed$iv.get(index$iv$iv7);
        int index$iv$iv8 = index$iv$iv7;
        PackageState it3 = (PackageState) element$iv4;
        if (isSoftRestrictedPermissionExemptForPackage(it3, targetSdkVersion, permissionName) == true) goto L225;
        index$iv$iv7 = index$iv$iv8 + 1;
        goto L222
    L225:
        boolean r19 = true;
    L228:
        if (r19 == true) goto L232;
        int newFlags8 = newFlags7 | 524288;
    L233:
        Boolean.valueOf(setPermissionFlags($this$evaluatePermissionState, appId, userId, permissionName, newFlags8));
        return;
    L232:
        newFlags8 = IntExtensionsKt.andInv(newFlags7, r18);
        goto L233
    L227:
        r19 = false;
        goto L228
    L230:
        r18 = 524288;
        goto L232
    L231:
        r18 = 524288;
    L217:
        newFlags7 = IntExtensionsKt.andInv(newFlags6, 262144);
    L212:
        isExempt = wasExempt;
        newFlags6 = newFlags5;
        goto L214
    L204:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().flags, 8) == true) goto L207;
        r15 = false;
        goto L208
    L95:
        newFlags4 = newFlags3 | 1024;
        if (wasRevoked2 == false) goto L99;
        newFlags4 = newFlags4 | 1048576;
    L99:
        if (getOldStatePermissionFlags($this$evaluatePermissionState, appId, userId, permissionName) != 0) goto L101;
        boolean isNewPermission = true;
    L103:
        if (isNewPermission == false) goto L105;
        newFlags4 = newFlags4 | 4096;
        requestingPackageStates2 = requestingPackageStates;
        goto L201
    L105:
        requestingPackageStates2 = requestingPackageStates;
        goto L201
    L101:
        isNewPermission = false;
        goto L103
    L106:
        r22 = 229376;
        boolean wasGrantedByLegacy = IntExtensionsKt.hasBits(newFlags3, 1024);
        boolean hasImplicitFlag = IntExtensionsKt.hasBits(newFlags3, 4096);
        if (wasGrantedByLegacy == false) goto L111;
        newFlags3 = IntExtensionsKt.andInv(newFlags3, 1024);
        if (hasImplicitFlag == true) goto L111;
        newFlags3 = newFlags3 | 16;
    L111:
        boolean wasGrantedByImplicit = IntExtensionsKt.hasBits(newFlags3, 2048);
        if ($this$evaluatePermissionState.getNewState().getExternalState().isLeanback() == true) goto L114;
    L116:
        boolean isLeanbackNotificationsPermission = false;
    L117:
        IndexedList $this$forEachIndexed$iv$iv5 = requestingPackageStates;
        int r17 = $this$forEachIndexed$iv$iv5.getSize();
        requestingPackageStates2 = requestingPackageStates;
        int index$iv$iv9 = 0;
    L118:
        if (index$iv$iv9 >= r17) goto L123;
        int r29 = r17;
        IndexedList $this$forEachIndexed$iv$iv6 = $this$forEachIndexed$iv$iv5;
        Object element$iv5 = $this$forEachIndexed$iv$iv6.get(index$iv$iv9);
        PackageState it4 = (PackageState) element$iv5;
        AndroidPackage r36 = it4.getAndroidPackage();
        Intrinsics.checkNotNull(r36);
        if (r36.getImplicitPermissions().contains(permissionName) == true) goto L121;
        index$iv$iv9 = index$iv$iv9 + 1;
        r17 = r29;
        $this$forEachIndexed$iv$iv5 = $this$forEachIndexed$iv$iv6;
        goto L118
    L121:
        boolean isImplicitPermission = true;
    L124:
        IndexedListSet<String> r20 = $this$evaluatePermissionState.getNewState().getExternalState().getImplicitToSourcePermissions().get(permissionName);
        if (r20 == null) goto L142;
        IndexedListSet<String> r27 = r20;
        boolean isImplicitPermission2 = isImplicitPermission;
        int r21 = r27.getSize();
        int index$iv$iv10 = 0;
    L127:
        if (index$iv$iv10 >= r21) goto L140;
        int r210 = r21;
        IndexedListSet<String> r23 = r27;
        Object element$iv6 = r23.elementAt(index$iv$iv10);
        String sourcePermissionName = (String) element$iv6;
        int index$iv$iv11 = index$iv$iv10;
        Permission sourcePermission = $this$evaluatePermissionState.getNewState().getSystemState().getPermissions().get(sourcePermissionName);
        if (sourcePermission == null) goto L139;
        int r41 = index$iv;
        if (sourcePermission.getPermissionInfo().getProtection() != 1) goto L133;
        boolean r24 = true;
    L135:
        if (r24 == false) goto L136;
        index$iv$iv10 = index$iv$iv11 + 1;
        r21 = r210;
        r27 = r23;
        index$iv = r41;
        goto L127
    L136:
        boolean isAnySourcePermissionNonRuntime = true;
    L144:
        if (isLeanbackNotificationsPermission == true) goto L149;
        if (isImplicitPermission2 == false) goto L148;
        if (isAnySourcePermissionNonRuntime == true) goto L149;
    L148:
        boolean shouldGrantByImplicit = false;
    L151:
        if (shouldGrantByImplicit == false) goto L155;
        int newFlags9 = newFlags3 | 2048;
        if (wasRevoked2 == false) goto L161;
        newFlags9 = newFlags9 | 1048576;
    L161:
        if (isImplicitPermission2 == true) goto L180;
        if (hasImplicitFlag == false) goto L180;
        int newFlags10 = IntExtensionsKt.andInv(newFlags9, 4096);
        boolean shouldRetainAsNearbyDevices = false;
        if (NEARBY_DEVICES_PERMISSIONS.contains(permissionName) == false) goto L172;
        int accessBackgroundLocationFlags = getPermissionFlags($this$evaluatePermissionState, appId, userId, "android.permission.ACCESS_BACKGROUND_LOCATION");
        if (PermissionFlags.INSTANCE.isAppOpGranted(accessBackgroundLocationFlags) == true) goto L168;
    L170:
        boolean r25 = false;
    L171:
        shouldRetainAsNearbyDevices = r25;
        goto L172
    L168:
        if (IntExtensionsKt.hasBits(accessBackgroundLocationFlags, 4096) == true) goto L170;
        r25 = true;
    L172:
        boolean shouldRetainByMask = IntExtensionsKt.hasAnyBit(newFlags10, FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT);
        if (shouldRetainAsNearbyDevices == true) goto L177;
        if (shouldRetainByMask == true) goto L177;
        int newFlags11 = IntExtensionsKt.andInv(newFlags10, 112);
    L182:
        if (Features.FEAT_FW_OVERSEAS == false) goto L184;
        int newFlags12 = newFlags11;
    L200:
        newFlags4 = newFlags12;
        goto L201
    L184:
        if (Intrinsics.areEqual("com.android.permission.GET_INSTALLED_APPS", permissionName) == false) goto L198;
        newFlags12 = newFlags11;
        int newFlags13 = requestingPackageStates2.getSize();
        int index$iv$iv12 = 0;
    L186:
        if (index$iv$iv12 >= newFlags13) goto L191;
        Object element$iv7 = requestingPackageStates2.get(index$iv$iv12);
        PackageState it5 = (PackageState) element$iv7;
        if ((it5.isSystem() | it5.isUpdatedSystemApp()) == true) goto L189;
        index$iv$iv12 = index$iv$iv12 + 1;
        goto L186
    L189:
        boolean isSystem = true;
    L193:
        if (isSystem == false) goto L195;
    L196:
        if (isImplicitPermission2 == false) goto L200;
        newFlags4 = newFlags12 | 16;
        goto L201
    L195:
        if (targetSdkVersion > 22) goto L200;
    L191:
        isSystem = false;
        goto L193
    L198:
        newFlags12 = newFlags11;
    L177:
        if (wasGrantedByImplicit == false) goto L179;
        newFlags11 = newFlags10 | 16;
        goto L182
    L179:
        newFlags11 = newFlags10;
    L180:
        newFlags11 = newFlags9;
        goto L182
    L155:
        newFlags9 = IntExtensionsKt.andInv(newFlags3, 2048);
        if (wasGrantedByLegacy == true) goto L159;
        if (wasGrantedByImplicit == false) goto L161;
    L159:
        if (IntExtensionsKt.hasBits(newFlags9, 1048576) == false) goto L161;
        newFlags9 = IntExtensionsKt.andInv(newFlags9, 1048592);
    L149:
        shouldGrantByImplicit = true;
        goto L151
    L133:
        r24 = false;
        goto L135
    L139:
        throw new IllegalStateException(("Unknown source permission " + sourcePermissionName + " in split permissions").toString());
    L140:
        isAnySourcePermissionNonRuntime = false;
        goto L144
    L142:
        isImplicitPermission2 = isImplicitPermission;
        isAnySourcePermissionNonRuntime = false;
        goto L144
    L123:
        isImplicitPermission = false;
        goto L124
    L114:
        if (NOTIFICATIONS_PERMISSIONS.contains(permissionName) == false) goto L116;
        isLeanbackNotificationsPermission = true;
        goto L117
    L84:
        if (PermissionFlags.INSTANCE.isPermissionGranted(newFlags3) == true) goto L86;
        wasRevoked2 = true;
        goto L87
    L234:
        Integer.valueOf(Slog.e(LOG_TAG, "Unknown protection level " + permission.getPermissionInfo().protectionLevel + "for permission " + permission.getPermissionInfo().name + " while evaluating permission statefor appId " + appId + " and userId " + userId));
        return;
    L79:
        r10 = false;
        goto L80
    L73:
        r9 = false;
    L236:
        boolean wasProtectionGranted = IntExtensionsKt.hasBits(oldFlags, 4);
        if (index$iv == 0) goto L241;
        if (wasProtectionGranted == false) goto L241;
        int newFlags14 = 4;
    L282:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 64) == false) goto L285;
        newFlags14 = (oldFlags & 40) | newFlags14;
    L285:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 32) == false) goto L288;
        newFlags14 = newFlags14 | (oldFlags & 16);
    L288:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 67108864) == false) goto L290;
        int newFlags15 = (oldFlags & 24) | newFlags14;
    L291:
        Boolean.valueOf(setPermissionFlags($this$evaluatePermissionState, appId, userId, permissionName, newFlags15));
        return;
    L290:
        newFlags15 = newFlags14;
    L241:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 16) == false) goto L252;
        int index$iv$iv13 = 0;
        int r110 = requestingPackageStates.getSize();
    L243:
        if (index$iv$iv13 >= r110) goto L248;
        Object element$iv8 = requestingPackageStates.get(index$iv$iv13);
        PackageState it6 = (PackageState) element$iv8;
        if (checkPrivilegedPermissionAllowlistIfNeeded(r2, it6, permission) == true) goto L246;
        index$iv$iv13 = index$iv$iv13 + 1;
        goto L243
    L246:
        boolean r26 = true;
    L249:
        if (r26 == true) goto L252;
        boolean mayGrantByPrivileged = false;
    L254:
        if (permission.getPermissionInfo().getProtection() != 2) goto L256;
        boolean r28 = true;
    L257:
        if (r28 == false) goto L267;
        int index$iv$iv14 = 0;
        int r111 = r8.getSize();
    L259:
        if (index$iv$iv14 >= r111) goto L264;
        Object element$iv9 = r8.get(index$iv$iv14);
        PackageState it7 = (PackageState) element$iv9;
        if (shouldGrantPermissionBySignature(r2, it7, permission) == true) goto L262;
        index$iv$iv14 = index$iv$iv14 + 1;
        goto L259
    L262:
        int index$iv3 = 1;
    L265:
        if (index$iv3 == 0) goto L267;
        boolean shouldGrantBySignature = true;
    L268:
        IndexedList $this$anyIndexed$iv2 = r8;
        int index$iv$iv15 = 0;
        int r112 = $this$anyIndexed$iv2.getSize();
    L269:
        if (index$iv$iv15 >= r112) goto L274;
        Object element$iv10 = $this$anyIndexed$iv2.get(index$iv$iv15);
        IndexedList $this$anyIndexed$iv3 = $this$anyIndexed$iv2;
        PackageState it8 = (PackageState) element$iv10;
        if (shouldGrantPermissionByProtectionFlags(r2, it8, permission) == true) goto L272;
        index$iv$iv15 = index$iv$iv15 + 1;
        $this$anyIndexed$iv2 = $this$anyIndexed$iv3;
        goto L269
    L272:
        boolean shouldGrantByProtectionFlags = true;
    L276:
        if (mayGrantByPrivileged == false) goto L280;
        if (shouldGrantBySignature == true) goto L279;
        if (shouldGrantByProtectionFlags == false) goto L280;
    L279:
        newFlags14 = 4;
    L280:
        newFlags14 = 0;
        goto L282
    L274:
        shouldGrantByProtectionFlags = false;
        goto L276
    L264:
        index$iv3 = 0;
    L267:
        shouldGrantBySignature = false;
        goto L268
    L256:
        r28 = false;
        goto L257
    L248:
        r26 = false;
    L252:
        mayGrantByPrivileged = true;
        goto L254
    L67:
        r8 = false;
        goto L69
    L24:
        r2 = false;
        goto L26
    }

    private final void inheritImplicitPermissionStates(MutateStateScope $this$inheritImplicitPermissionStates, int appId, int userId) {
        AppIdPermissionPolicy r0 = this;
        MutateStateScope r1 = $this$inheritImplicitPermissionStates;
        int r2 = appId;
        int targetSdkVersion = getAppIdTargetSdkVersion$default(r0, r1, r2, null, null, 4, null);
        MutableIndexedSet implicitPermissions = new MutableIndexedSet(null, 1, null);
        AccessState state$iv = r1.getNewState();
        Immutable r5 = state$iv.getExternalState().getAppIdPackageNames().get(r2);
        Intrinsics.checkNotNull(r5);
        IndexedListSet packageNames$iv = (IndexedListSet) r5;
        int index$iv$iv = 0;
        int r13 = packageNames$iv.getSize();
    L3:
        if (index$iv$iv >= r13) goto L9;
        String packageName$iv = (String) packageNames$iv.elementAt(index$iv$iv);
        PackageState r8 = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        Intrinsics.checkNotNull(r8);
        PackageState packageState$iv = r8;
        if (packageState$iv.getAndroidPackage() == null) goto L8;
        AndroidPackage r19 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r19);
        IndexedSetExtensionsKt.plusAssign(implicitPermissions, r19.getImplicitPermissions());
    L8:
        index$iv$iv = index$iv$iv + 1;
        state$iv = state$iv;
        goto L3
    L9:
        IndexedSet $this$forEachIndexed$iv = implicitPermissions;
        int r11 = $this$forEachIndexed$iv.getSize();
        int index$iv = 0;
    L10:
        if (index$iv >= r11) goto L57;
        String implicitPermissionName = (String) $this$forEachIndexed$iv.elementAt(index$iv);
        Permission implicitPermission = r1.getNewState().getSystemState().getPermissions().get(implicitPermissionName);
        if (implicitPermission == null) goto L55;
        IndexedSet $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
        if (implicitPermission.getPermissionInfo().getProtection() != 1) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
    L53:
        index$iv = index$iv + 1;
        r0 = this;
        r1 = $this$inheritImplicitPermissionStates;
        r2 = appId;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
        implicitPermissions = implicitPermissions;
        goto L10
    L20:
        if (r0.getOldStatePermissionFlags(r1, r2, userId, implicitPermissionName) != 0) goto L22;
        boolean r7 = true;
    L23:
        boolean isNewPermission = r7;
        if (isNewPermission == false) goto L53;
        IndexedListSet<String> r9 = r1.getNewState().getExternalState().getImplicitToSourcePermissions().get(implicitPermissionName);
        if (r9 == null) goto L53;
        int newFlags = r0.getPermissionFlags(r1, r2, userId, implicitPermissionName);
        IndexedListSet<String> r110 = r9;
        int r10 = r110.getSize();
        int index$iv2 = 0;
    L30:
        if (index$iv2 >= r10) goto L47;
        int r22 = r10;
        IndexedListSet<String> r12 = r110;
        String sourcePermissionName = r12.elementAt(index$iv2);
        int index$iv3 = index$iv2;
        Permission sourcePermission = r1.getNewState().getSystemState().getPermissions().get(sourcePermissionName);
        if (sourcePermission == null) goto L45;
        int sourceFlags = r0.getPermissionFlags(r1, r2, userId, sourcePermissionName);
        boolean isSourceGranted = PermissionFlags.INSTANCE.isPermissionGranted(sourceFlags);
        boolean isNewGranted = PermissionFlags.INSTANCE.isPermissionGranted(newFlags);
        if (isSourceGranted == false) goto L37;
        if (isNewGranted == true) goto L37;
        boolean isGrantingNewFromRevoke = true;
    L38:
        if (isSourceGranted == isNewGranted) goto L40;
        if (isGrantingNewFromRevoke == true) goto L40;
    L43:
        index$iv2 = index$iv3 + 1;
        r0 = this;
        r1 = $this$inheritImplicitPermissionStates;
        r10 = r22;
        r110 = r12;
    L40:
        if (isGrantingNewFromRevoke == false) goto L42;
        newFlags = 0;
    L42:
        newFlags = newFlags | (sourceFlags & 16777208);
    L37:
        isGrantingNewFromRevoke = false;
        goto L38
    L45:
        throw new IllegalStateException(("Unknown source permission " + sourcePermissionName + " in split permissions").toString());
    L47:
        if (targetSdkVersion >= 23) goto L49;
    L51:
        int newFlags2 = newFlags | 4096;
    L52:
        setPermissionFlags($this$inheritImplicitPermissionStates, r2, userId, implicitPermissionName, newFlags2);
        goto L53
    L49:
        if (NO_IMPLICIT_FLAG_PERMISSIONS.contains(implicitPermissionName) == false) goto L51;
        newFlags2 = IntExtensionsKt.andInv(newFlags, 4096);
        goto L52
    L22:
        r7 = false;
        goto L23
    L16:
        r6 = false;
        goto L17
    L55:
        throw new IllegalStateException(("Unknown implicit permission " + implicitPermissionName + " in split permissions").toString());
    }

    private final boolean isCompatibilityPermissionForPackage(AndroidPackage androidPackage, String permissionName) {
        Iterator r0 = ArrayIteratorKt.iterator(CompatibilityPermissionInfo.COMPAT_PERMS);
    L4:
        if (r0.hasNext() == false) goto L11;
        CompatibilityPermissionInfo compatibilityPermission = (CompatibilityPermissionInfo) r0.next();
        if (Intrinsics.areEqual(compatibilityPermission.getName(), permissionName) == false) goto L4;
        if (androidPackage.getTargetSdkVersion() >= compatibilityPermission.getSdkVersion()) goto L4;
        Slog.i(LOG_TAG, "Auto-granting " + permissionName + " to old package " + androidPackage.getPackageName());
        return true;
    L11:
        return false;
    }

    private final boolean shouldGrantPermissionBySignature(MutateStateScope $this$shouldGrantPermissionBySignature, PackageState packageState, Permission permission) {
        AndroidPackage r1 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r1);
        SigningDetails packageSigningDetails = r1.getSigningDetails();
        PackageState r2 = $this$shouldGrantPermissionBySignature.getNewState().getExternalState().getPackageStates().get(permission.getPermissionInfo().packageName);
        AndroidPackage disabledSystemPackage = null;
        if (r2 == null) goto L7;
        AndroidPackage r3 = r2.getAndroidPackage();
        if (r3 == null) goto L7;
        SigningDetails sourceSigningDetails = r3.getSigningDetails();
    L8:
        PackageState r4 = $this$shouldGrantPermissionBySignature.getNewState().getExternalState().getPackageStates().get(PackageManagerService.PLATFORM_PACKAGE_NAME);
        Intrinsics.checkNotNull(r4);
        AndroidPackage r5 = r4.getAndroidPackage();
        Intrinsics.checkNotNull(r5);
        SigningDetails platformSigningDetails = r5.getSigningDetails();
        if (sourceSigningDetails != null) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == false) goto L16;
    L21:
        boolean hasCommonSigner = true;
    L23:
        if (hasCommonSigner == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(permission.getPermissionInfo().packageName, PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L51;
        if (packageState.isSystem() == true) goto L30;
        boolean isRequestedByFactoryApp = false;
    L43:
        if (isRequestedByFactoryApp == true) goto L51;
        if (Intrinsics.areEqual(getSignaturePermissionAllowlistState($this$shouldGrantPermissionBySignature, packageState, permission.getPermissionInfo().name), true) == true) goto L51;
        Slog.w(LOG_TAG, "Signature permission " + permission.getPermissionInfo().name + " for package " + packageState.getPackageName() + " (" + packageState.getPath() + ") not in signature permission allowlist");
        Build.isDebuggable();
        if (this.isSignaturePermissionAllowlistForceEnforced == false) goto L51;
        return false;
    L30:
        if (packageState.isUpdatedSystemApp() == false) goto L40;
        PackageState r6 = $this$shouldGrantPermissionBySignature.getNewState().getExternalState().getDisabledSystemPackageStates().get(packageState.getPackageName());
        if (r6 == null) goto L35;
        disabledSystemPackage = r6.getAndroidPackage();
    L35:
        if (disabledSystemPackage != null) goto L37;
    L39:
        isRequestedByFactoryApp = false;
        goto L43
    L37:
        if (disabledSystemPackage.getRequestedPermissions().contains(permission.getPermissionInfo().name) == false) goto L39;
        isRequestedByFactoryApp = true;
        goto L43
    L40:
        isRequestedByFactoryApp = true;
    L51:
        return true;
    L16:
        if (packageSigningDetails.hasAncestorOrSelf(platformSigningDetails) == true) goto L21;
        if (platformSigningDetails.checkCapability(packageSigningDetails, 4) == true) goto L21;
        hasCommonSigner = false;
        goto L23
    L11:
        if (sourceSigningDetails.hasCommonSignerWithCapability(packageSigningDetails, 4) != true) goto L13;
        r9 = true;
    L7:
        sourceSigningDetails = null;
        goto L8
    }

    private final Boolean getSignaturePermissionAllowlistState(MutateStateScope $this$getSignaturePermissionAllowlistState, PackageState packageState, String permissionName) {
        PermissionAllowlist permissionAllowlist = $this$getSignaturePermissionAllowlistState.getNewState().getExternalState().getPermissionAllowlist();
        String packageName = packageState.getPackageName();
        if (packageState.isVendor() == true) goto L23;
        if (packageState.isOdm() == true) goto L23;
        if (packageState.isProduct() == false) goto L11;
        return permissionAllowlist.getProductSignatureAppAllowlistState(packageName, permissionName);
    L11:
        if (packageState.isSystemExt() == true) goto L25;
        Boolean r2 = permissionAllowlist.getApexSignatureAppAllowlistState(packageName, permissionName);
        if (r2 != null) goto L26;
        Boolean r3 = permissionAllowlist.getProductSignatureAppAllowlistState(packageName, permissionName);
        if (r3 != null) goto L27;
        Boolean r4 = permissionAllowlist.getVendorSignatureAppAllowlistState(packageName, permissionName);
        if (r4 != null) goto L28;
        Boolean r5 = permissionAllowlist.getSystemExtSignatureAppAllowlistState(packageName, permissionName);
        if (r5 == null) goto L30;
        return r5;
    L30:
        return permissionAllowlist.getSignatureAppAllowlistState(packageName, permissionName);
    L28:
        return r4;
    L27:
        return r3;
    L26:
        return r2;
    L25:
        return permissionAllowlist.getSystemExtSignatureAppAllowlistState(packageName, permissionName);
    L23:
        return permissionAllowlist.getVendorSignatureAppAllowlistState(packageName, permissionName);
    }

    private final boolean checkPrivilegedPermissionAllowlistIfNeeded(MutateStateScope $this$checkPrivilegedPermissionAllowlistIfNeeded, PackageState packageState, Permission permission) {
        if (RoSystemProperties.CONTROL_PRIVAPP_PERMISSIONS_DISABLE == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(packageState.getPackageName(), PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L9;
        return true;
    L9:
        if (packageState.isSystem() == true) goto L11;
    L32:
        return true;
    L11:
        if (packageState.isPrivileged() == false) goto L32;
        if ($this$checkPrivilegedPermissionAllowlistIfNeeded.getNewState().getExternalState().getPrivilegedPermissionAllowlistPackages().contains(permission.getPermissionInfo().packageName) == true) goto L16;
        return true;
    L16:
        Boolean allowlistState = getPrivilegedPermissionAllowlistState($this$checkPrivilegedPermissionAllowlistIfNeeded, packageState, permission.getPermissionInfo().name);
        if (allowlistState == null) goto L21;
        return allowlistState.booleanValue();
    L21:
        if (packageState.isUpdatedSystemApp() == false) goto L24;
        return true;
    L24:
        if ($this$checkPrivilegedPermissionAllowlistIfNeeded.getNewState().getExternalState().isSystemReady() == true) goto L31;
        if (packageState.isApkInUpdatedApex() == true) goto L31;
        Slog.w(LOG_TAG, "Privileged permission " + permission.getPermissionInfo().name + " for package " + packageState.getPackageName() + " (" + packageState.getPath() + ") not in privileged permission allowlist");
        if (RoSystemProperties.CONTROL_PRIVAPP_PERMISSIONS_ENFORCE == false) goto L31;
        this.privilegedPermissionAllowlistViolations.add(packageState.getPackageName() + " (" + packageState.getPath() + "): " + permission.getPermissionInfo().name);
    L31:
        return true ^ RoSystemProperties.CONTROL_PRIVAPP_PERMISSIONS_ENFORCE;
    }

    private final Boolean getPrivilegedPermissionAllowlistState(MutateStateScope $this$getPrivilegedPermissionAllowlistState, PackageState packageState, String permissionName) {
        PermissionAllowlist permissionAllowlist = $this$getPrivilegedPermissionAllowlistState.getNewState().getExternalState().getPermissionAllowlist();
        String apexModuleName = packageState.getApexModuleName();
        String packageName = packageState.getPackageName();
        if (packageState.isVendor() == true) goto L23;
        if (packageState.isOdm() == true) goto L23;
        if (packageState.isProduct() == false) goto L11;
        return permissionAllowlist.getProductPrivilegedAppAllowlistState(packageName, permissionName);
    L11:
        if (packageState.isSystemExt() == true) goto L25;
        if (apexModuleName == null) goto L27;
        Boolean nonApexAllowlistState = permissionAllowlist.getPrivilegedAppAllowlistState(packageName, permissionName);
        if (nonApexAllowlistState == null) goto L17;
        Slog.w(LOG_TAG, "Package " + packageName + " is an APK in APEX but has permission allowlist on the system image, please bundle the allowlist in the " + apexModuleName + " APEX instead");
    L17:
        Boolean apexAllowlistState = permissionAllowlist.getApexPrivilegedAppAllowlistState(apexModuleName, packageName, permissionName);
        if (apexAllowlistState != null) goto L26;
        return nonApexAllowlistState;
    L26:
        return apexAllowlistState;
    L27:
        return permissionAllowlist.getPrivilegedAppAllowlistState(packageName, permissionName);
    L25:
        return permissionAllowlist.getSystemExtPrivilegedAppAllowlistState(packageName, permissionName);
    L23:
        return permissionAllowlist.getVendorPrivilegedAppAllowlistState(packageName, permissionName);
    }

    private final boolean isSoftRestrictedPermissionExemptForPackage(PackageState packageState, int appIdTargetSdkVersion, String permissionName) {
        if (Intrinsics.areEqual(permissionName, "android.permission.READ_EXTERNAL_STORAGE") == true) goto L9;
        if (Intrinsics.areEqual(permissionName, "android.permission.WRITE_EXTERNAL_STORAGE") == true) goto L9;
        return false;
    L9:
        if (appIdTargetSdkVersion < 29) goto L12;
        return true;
    L12:
        return false;
    }

    static /* synthetic */ int getAppIdTargetSdkVersion$default(AppIdPermissionPolicy r0, MutateStateScope r1, int r2, String r3, AccessState r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = r1.getNewState();
    L6:
        return r0.getAppIdTargetSdkVersion(r1, r2, r3, r4);
    }

    private final int getAppIdTargetSdkVersion(MutateStateScope $this$getAppIdTargetSdkVersion, int appId, String permissionName, AccessState state) {
        int initialValue$iv = 10000;
        MutateStateScope $this$reducePackageInAppId$iv = $this$getAppIdTargetSdkVersion;
        Immutable r5 = state.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r5);
        IndexedListSet packageNames$iv = (IndexedListSet) r5;
        Ref$IntRef value$iv$iv = new Ref$IntRef();
        value$iv$iv.element = 10000;
        int index$iv$iv$iv = 0;
        int r13 = packageNames$iv.getSize();
    L3:
        if (index$iv$iv$iv >= r13) goto L18;
        Object element$iv$iv = packageNames$iv.elementAt(index$iv$iv$iv);
        int initialValue$iv2 = initialValue$iv;
        int initialValue$iv3 = value$iv$iv.element;
        String packageName$iv = (String) element$iv$iv;
        MutateStateScope $this$reducePackageInAppId$iv2 = $this$reducePackageInAppId$iv;
        PackageState r2 = state.getExternalState().getPackageStates().get(packageName$iv);
        Intrinsics.checkNotNull(r2);
        PackageState packageState$iv = r2;
        if (packageState$iv.getAndroidPackage() == null) goto L15;
        int targetSdkVersion = initialValue$iv3;
        AndroidPackage androidPackage = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        if (permissionName == 0) goto L13;
        if (androidPackage.getRequestedPermissions().contains(permissionName) == true) goto L13;
    L16:
        value$iv$iv.element = Integer.valueOf(targetSdkVersion).intValue();
        index$iv$iv$iv = index$iv$iv$iv + 1;
        initialValue$iv = initialValue$iv2;
        $this$reducePackageInAppId$iv = $this$reducePackageInAppId$iv2;
    L13:
        targetSdkVersion = RangesKt.coerceAtMost(targetSdkVersion, androidPackage.getTargetSdkVersion());
        goto L16
    L15:
        targetSdkVersion = initialValue$iv3;
        goto L16
    L18:
        return value$iv$iv.element;
    }

    private final boolean shouldGrantPermissionByProtectionFlags(MutateStateScope $this$shouldGrantPermissionByProtectionFlags, PackageState packageState, Permission permission) {
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(androidPackage);
        IntMap<String[]> r1 = $this$shouldGrantPermissionByProtectionFlags.getNewState().getExternalState().getKnownPackages();
        String packageName = packageState.getPackageName();
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 16) == true) goto L7;
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 16384) == true) goto L7;
    L26:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 128) == false) goto L31;
        if (androidPackage.getTargetSdkVersion() >= 23) goto L31;
        return true;
    L31:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 256) == false) goto L38;
        String[] r3 = r1.get(2);
        Intrinsics.checkNotNull(r3);
        if (ArraysKt.contains(r3, packageName) == true) goto L36;
        String[] r4 = r1.get(7);
        Intrinsics.checkNotNull(r4);
        if (ArraysKt.contains(r4, packageName) == false) goto L38;
    L36:
        return true;
    L38:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 512) == false) goto L43;
        String[] r5 = r1.get(4);
        Intrinsics.checkNotNull(r5);
        if (ArraysKt.contains(r5, packageName) == false) goto L43;
        return true;
    L43:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 1024) == false) goto L48;
        if (packageState.isSystem() == false) goto L48;
        return true;
    L48:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 134217728) == false) goto L53;
        if (androidPackage.getSigningDetails().hasAncestorOrSelfWithDigest(permission.getPermissionInfo().knownCerts) == false) goto L53;
        return true;
    L53:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 2048) == false) goto L58;
        String[] r6 = r1.get(1);
        Intrinsics.checkNotNull(r6);
        if (ArraysKt.contains(r6, packageName) == false) goto L58;
        return true;
    L58:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 65536) == false) goto L63;
        String[] r7 = r1.get(6);
        Intrinsics.checkNotNull(r7);
        if (ArraysKt.contains(r7, packageName) == false) goto L63;
        return true;
    L63:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 524288) == false) goto L68;
        String[] r8 = r1.get(10);
        Intrinsics.checkNotNull(r8);
        if (ArraysKt.contains(r8, packageName) == false) goto L68;
        return true;
    L68:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 1048576) == false) goto L73;
        String[] r9 = r1.get(11);
        Intrinsics.checkNotNull(r9);
        if (ArraysKt.contains(r9, packageName) == false) goto L73;
        return true;
    L73:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 2097152) == false) goto L78;
        String[] r10 = r1.get(12);
        Intrinsics.checkNotNull(r10);
        if (ArraysKt.contains(r10, packageName) == false) goto L78;
        return true;
    L78:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 8388608) == false) goto L83;
        String[] r11 = r1.get(15);
        Intrinsics.checkNotNull(r11);
        if (ArraysKt.contains(r11, packageName) == false) goto L83;
        return true;
    L83:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 33554432) == false) goto L88;
        String[] r12 = r1.get(17);
        Intrinsics.checkNotNull(r12);
        if (ArraysKt.contains(r12, packageName) == false) goto L88;
        return true;
    L88:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 4194304) == true) goto L90;
    L92:
        return false;
    L90:
        if (packageState.getApexModuleName() == null) goto L92;
        return true;
    L7:
        if (packageState.isSystem() == false) goto L26;
        if (packageState.isUpdatedSystemApp() == false) goto L21;
        PackageState disabledSystemPackageState = $this$shouldGrantPermissionByProtectionFlags.getNewState().getExternalState().getDisabledSystemPackageStates().get(packageState.getPackageName());
        if (disabledSystemPackageState == null) goto L13;
        AndroidPackage disabledSystemPackage = disabledSystemPackageState.getAndroidPackage();
    L14:
        if (disabledSystemPackage != null) goto L16;
    L20:
        boolean shouldGrant = false;
    L23:
        if (shouldGrant == false) goto L26;
        return true;
    L16:
        if (disabledSystemPackage.getRequestedPermissions().contains(permission.getPermissionInfo().name) == false) goto L20;
        if (shouldGrantPrivilegedOrOemPermission($this$shouldGrantPermissionByProtectionFlags, disabledSystemPackageState, permission) == false) goto L20;
        shouldGrant = true;
        goto L23
    L13:
        disabledSystemPackage = null;
        goto L14
    L21:
        shouldGrant = shouldGrantPrivilegedOrOemPermission($this$shouldGrantPermissionByProtectionFlags, packageState, permission);
        goto L23
    }

    private final boolean shouldGrantPrivilegedOrOemPermission(MutateStateScope $this$shouldGrantPrivilegedOrOemPermission, PackageState packageState, Permission permission) {
        String permissionName = permission.getPermissionInfo().name;
        String packageName = packageState.getPackageName();
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 16) == false) goto L17;
        if (packageState.isPrivileged() == true) goto L7;
    L26:
        return false;
    L7:
        if (packageState.isVendor() == true) goto L11;
        if (packageState.isOdm() == true) goto L11;
        return true;
    L11:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 32768) == true) goto L27;
        Slog.w(LOG_TAG, "Permission " + permissionName + " cannot be granted to privileged vendor (or odm) app " + packageName + " because it isn't a vendorPrivileged permission");
        return false;
    L27:
        return true;
    L17:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 16384) == false) goto L26;
        if (packageState.isOem() == false) goto L26;
        Boolean allowlistState = $this$shouldGrantPrivilegedOrOemPermission.getNewState().getExternalState().getPermissionAllowlist().getOemAppAllowlistState(packageName, permissionName);
        if (allowlistState == null) goto L25;
        return allowlistState.booleanValue();
    L25:
        throw new IllegalStateException(("OEM permission " + permissionName + " requested by package " + packageName + " must be explicitly declared granted or not").toString());
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onSystemReady(MutateStateScope $this$onSystemReady) {
        if (this.privilegedPermissionAllowlistViolations.isEmpty() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Signature|privileged permissions not in privileged permission allowlist: " + this.privilegedPermissionAllowlistViolations);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void parseSystemState(BinaryXmlPullParser $this$parseSystemState, MutableAccessState state) {
        AppIdPermissionPersistence $this$parseSystemState_u24lambda_u2478 = this.persistence;
        $this$parseSystemState_u24lambda_u2478.parseSystemState($this$parseSystemState, state);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void serializeSystemState(BinaryXmlSerializer $this$serializeSystemState, AccessState state) {
        AppIdPermissionPersistence $this$serializeSystemState_u24lambda_u2479 = this.persistence;
        $this$serializeSystemState_u24lambda_u2479.serializeSystemState($this$serializeSystemState, state);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        AppIdPermissionPersistence $this$parseUserState_u24lambda_u2480 = this.persistence;
        $this$parseUserState_u24lambda_u2480.parseUserState($this$parseUserState, state, userId);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        AppIdPermissionPersistence $this$serializeUserState_u24lambda_u2481 = this.persistence;
        $this$serializeUserState_u24lambda_u2481.serializeUserState($this$serializeUserState, state, userId);
    }

    public final IndexedMap<String, Permission> getPermissionTrees(GetStateScope $this$getPermissionTrees) {
        return $this$getPermissionTrees.getState().getSystemState().getPermissionTrees();
    }

    public final Permission findPermissionTree(GetStateScope $this$findPermissionTree, String permissionName) {
        IndexedMap<String, Permission> r1 = $this$findPermissionTree.getState().getSystemState().getPermissionTrees();
        int index$iv$iv = 0;
        int r6 = r1.getSize();
    L3:
        Permission r7 = null;
        if (index$iv$iv >= r6) goto L18;
        Object key$iv = r1.keyAt(index$iv$iv);
        Object value$iv = r1.valueAt(index$iv$iv);
        Permission permissionTree = (Permission) value$iv;
        String permissionTreeName = (String) key$iv;
        IndexedMap<String, Permission> r16 = r1;
        if (StringsKt.startsWith$default(permissionName, permissionTreeName, false, 2, null) == true) goto L8;
    L14:
        if (r7 != null) goto L18;
        index$iv$iv = index$iv$iv + 1;
        r1 = r16;
        goto L3
    L8:
        if (permissionName.length() <= permissionTreeName.length()) goto L14;
        if (permissionName.charAt(permissionTreeName.length()) != '.') goto L14;
        r7 = permissionTree;
    L18:
        return r7;
    }

    public final IndexedMap<String, PermissionGroupInfo> getPermissionGroups(GetStateScope $this$getPermissionGroups) {
        return $this$getPermissionGroups.getState().getSystemState().getPermissionGroups();
    }

    public final IndexedMap<String, Permission> getPermissions(GetStateScope $this$getPermissions) {
        return $this$getPermissions.getState().getSystemState().getPermissions();
    }

    public final void addPermission(MutateStateScope $this$addPermission, Permission permission, boolean isSynchronousWrite) {
        if (isSynchronousWrite == false) goto L4;
        int writeMode = 2;
    L5:
        $this$addPermission.getNewState().mutateSystemState(writeMode).mutatePermissions().put(permission.getPermissionInfo().name, permission);
        return;
    L4:
        writeMode = 1;
        goto L5
    }

    public final void removePermission(MutateStateScope $this$removePermission, Permission permission) {
        MutableAccessState.mutateSystemState$default($this$removePermission.getNewState(), 0, 1, null).mutatePermissions().remove(permission.getPermissionInfo().name);
    }

    public final IndexedMap<String, Integer> getUidPermissionFlags(GetStateScope $this$getUidPermissionFlags, int appId, int userId) {
        UserState r0 = (UserState) $this$getUidPermissionFlags.getState().getUserStates().get(userId);
        if (r0 == null) goto L7;
        IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = r0.getAppIdPermissionFlags();
        if (r1 == null) goto L7;
        return (IndexedMap) r1.get(appId);
    L7:
        return null;
    }

    public final int getPermissionFlags(GetStateScope $this$getPermissionFlags, int appId, int userId, String permissionName) {
        return getPermissionFlags($this$getPermissionFlags.getState(), appId, userId, permissionName);
    }

    private final int getOldStatePermissionFlags(MutateStateScope $this$getOldStatePermissionFlags, int appId, int userId, String permissionName) {
        return getPermissionFlags($this$getOldStatePermissionFlags.getOldState(), appId, userId, permissionName);
    }

    private final int getPermissionFlags(AccessState state, int appId, int userId, String permissionName) {
        UserState r0 = (UserState) state.getUserStates().get(userId);
        if (r0 == null) goto L7;
        IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = r0.getAppIdPermissionFlags();
        if (r1 == null) goto L7;
        IndexedMap r2 = (IndexedMap) r1.get(appId);
    L9:
        return ((Number) IndexedMapExtensionsKt.getWithDefault(r2, permissionName, 0)).intValue();
    L7:
        r2 = null;
        goto L9
    }

    public final IndexedMap<String, Integer> getAllPermissionFlags(GetStateScope $this$getAllPermissionFlags, int appId, int userId) {
        UserState r0 = (UserState) $this$getAllPermissionFlags.getState().getUserStates().get(userId);
        if (r0 == null) goto L7;
        IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1 = r0.getAppIdPermissionFlags();
        if (r1 == null) goto L7;
        return (IndexedMap) r1.get(appId);
    L7:
        return null;
    }

    public final boolean setPermissionFlags(MutateStateScope $this$setPermissionFlags, int appId, int userId, String permissionName, int flags) {
        return updatePermissionFlags($this$setPermissionFlags, appId, userId, permissionName, -1, flags);
    }

    public final boolean updatePermissionFlags(MutateStateScope $this$updatePermissionFlags, int appId, int userId, String permissionName, int flagMask, int flagValues) {
        int r1 = appId;
        int r2 = userId;
        String r3 = permissionName;
        if ($this$updatePermissionFlags.getNewState().getUserStates().contains(r2) == true) goto L6;
        Slog.e(LOG_TAG, "Unable to update permission flags for missing user " + r2);
        return false;
    L6:
        Immutable r0 = $this$updatePermissionFlags.getNewState().getUserStates().get(r2);
        Intrinsics.checkNotNull(r0);
        int oldFlags = ((Number) IndexedMapExtensionsKt.getWithDefault((IndexedMap) ((UserState) r0).getAppIdPermissionFlags().get(r1), r3, 0)).intValue();
        int newFlags = IntExtensionsKt.andInv(oldFlags, flagMask) | (flagValues & flagMask);
        if (oldFlags != newFlags) goto L9;
        return false;
    L9:
        MutableUserState r4 = MutableAccessState.mutateUserState$default($this$updatePermissionFlags.getNewState(), r2, 0, 2, null);
        Intrinsics.checkNotNull(r4);
        MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r8 = r4.mutateAppIdPermissionFlags();
        Immutable r11 = r8.mutate(r1);
        if (r11 != null) goto L13;
        Immutable it$iv = new MutableIndexedMap(null, 1, null);
        r8.put(r1, it$iv);
        r11 = it$iv;
    L13:
        MutableIndexedMap permissionFlags = (MutableIndexedMap) r11;
        IndexedMapExtensionsKt.putWithDefault(permissionFlags, r3, Integer.valueOf(newFlags), 0);
        if (permissionFlags.isEmpty() == false) goto L16;
        IntReferenceMapExtensionsKt.minusAssign(r8, r1);
    L16:
        IndexedListSet<OnPermissionFlagsChangedListener> r12 = this.onPermissionFlagsChangedListeners;
        int r14 = r12.getSize();
        int index$iv = 0;
    L17:
        if (index$iv >= r14) goto L20;
        OnPermissionFlagsChangedListener it = r12.elementAt(index$iv);
        int oldFlags2 = oldFlags;
        it.onPermissionFlagsChanged(r1, r2, r3, oldFlags2, newFlags);
        index$iv = index$iv + 1;
        r1 = appId;
        r2 = userId;
        r3 = permissionName;
        oldFlags = oldFlags2;
        goto L17
    L20:
        return true;
    }

    public final void addOnPermissionFlagsChangedListener(OnPermissionFlagsChangedListener listener) {
        Object r0 = this.onPermissionFlagsChangedListenersLock;
        monitor-enter(r0);
        this.onPermissionFlagsChangedListeners = IndexedListSetExtensionsKt.plus(this.onPermissionFlagsChangedListeners, listener);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void migrateSystemState(MutableAccessState state) {
        this.migration.migrateSystemState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(state);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void migrateUserState(MutableAccessState state, int userId) {
        this.migration.migrateUserState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(state, userId);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void upgradePackageState(MutateStateScope $this$upgradePackageState, PackageState packageState, int userId, int version) {
        AppIdPermissionUpgrade $this$upgradePackageState_u24lambda_u2487 = this.upgrade;
        $this$upgradePackageState_u24lambda_u2487.upgradePackageState($this$upgradePackageState, packageState, userId, version);
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppIdPermissionPolicy.class.getSimpleName();
        NO_IMPLICIT_FLAG_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.ACCESS_MEDIA_LOCATION", "android.permission.ACTIVITY_RECOGNITION", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"});
        NEARBY_DEVICES_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.NEARBY_WIFI_DEVICES"});
        NOTIFICATIONS_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.POST_NOTIFICATIONS"});
        STORAGE_AND_MEDIA_PERMISSIONS = IndexedSetExtensionsKt.indexedSetOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES", "android.permission.ACCESS_MEDIA_LOCATION", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"});
    }
}
