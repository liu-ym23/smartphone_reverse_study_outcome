package com.android.server.permission.access;

import android.util.Slog;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.SystemConfig;
import com.android.server.permission.access.appop.AppIdAppOpPolicy;
import com.android.server.permission.access.appop.PackageAppOpPolicy;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.IntSet;
import com.android.server.permission.access.immutable.IntSetExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableIntSet;
import com.android.server.permission.access.permission.AppIdPermissionPolicy;
import com.android.server.permission.access.permission.DevicePermissionPolicy;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.Settings;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.pkg.PackageState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AccessPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessPolicy {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;
    private final IndexedMap<String, IndexedMap<String, SchemePolicy>> schemePolicies;

    /* JADX INFO: compiled from: AccessPolicy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    private AccessPolicy(IndexedMap<String, IndexedMap<String, SchemePolicy>> r1) {
        this.schemePolicies = r1;
    }

    public AccessPolicy() {
        MutableIndexedMap $this$_init__u24lambda_u241 = new MutableIndexedMap(null, 1, null);
        _init_$lambda$1$addPolicy($this$_init__u24lambda_u241, new AppIdPermissionPolicy());
        _init_$lambda$1$addPolicy($this$_init__u24lambda_u241, new DevicePermissionPolicy());
        _init_$lambda$1$addPolicy($this$_init__u24lambda_u241, new AppIdAppOpPolicy());
        _init_$lambda$1$addPolicy($this$_init__u24lambda_u241, new PackageAppOpPolicy());
        this($this$_init__u24lambda_u241);
    }

    private static final void _init_$lambda$1$addPolicy(MutableIndexedMap<String, MutableIndexedMap<String, SchemePolicy>> r7, SchemePolicy policy) {
        String r0 = policy.getSubjectScheme();
        MutableIndexedMap<String, SchemePolicy> r3 = r7.get(r0);
        if (r3 != null) goto L6;
        r3 = new MutableIndexedMap(null, 1, null);
        r7.put(r0, r3);
    L6:
        r3.put(policy.getObjectScheme(), policy);
    }

    public final SchemePolicy getSchemePolicy(String subjectScheme, String objectScheme) {
        IndexedMap<String, SchemePolicy> r0 = this.schemePolicies.get(subjectScheme);
        if (r0 == null) goto L5;
        SchemePolicy r1 = r0.get(objectScheme);
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalStateException(("Scheme policy for " + subjectScheme + " and " + objectScheme + " does not exist").toString());
    L5:
        r1 = null;
        goto L6
    }

    public final void initialize(MutableAccessState state, IntSet userIds, Map<String, ? extends PackageState> r20, Map<String, ? extends PackageState> r21, IntMap<String[]> r22, boolean isLeanback, Map<String, SystemConfig.PermissionEntry> r24, IndexedListSet<String> r25, PermissionAllowlist permissionAllowlist, IndexedMap<String, IndexedListSet<String>> r27) {
        MutableExternalState $this$initialize_u24lambda_u245 = state.mutateExternalState();
        int r1 = 0;
        IntSetExtensionsKt.plusAssign($this$initialize_u24lambda_u245.mutateUserIds(), userIds);
        $this$initialize_u24lambda_u245.setPackageStatesPublic(r20);
        $this$initialize_u24lambda_u245.setDisabledSystemPackageStatesPublic(r21);
        Iterator<Map.Entry<String, ? extends PackageState>> r7 = r20.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        PackageState packageState = r7.next().getValue();
        if (packageState.isApex() == false) goto L8;
        r1 = r1;
    L13:
        r1 = r1;
        goto L4
    L8:
        MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r11 = $this$initialize_u24lambda_u245.mutateAppIdPackageNames();
        int key$iv = packageState.getAppId();
        Immutable r14 = r11.mutate(key$iv);
        if (r14 != null) goto L12;
        Immutable it$iv = new MutableIndexedListSet(null, 1, null);
        r11.put(key$iv, it$iv);
        r14 = it$iv;
    L12:
        ((MutableIndexedListSet) r14).add(packageState.getPackageName());
        goto L13
    L14:
        $this$initialize_u24lambda_u245.setKnownPackagesPublic(r22);
        $this$initialize_u24lambda_u245.setLeanbackPublic(isLeanback);
        $this$initialize_u24lambda_u245.setConfigPermissionsPublic(r24);
        $this$initialize_u24lambda_u245.setPrivilegedPermissionAllowlistPackagesPublic(r25);
        $this$initialize_u24lambda_u245.setPermissionAllowlistPublic(permissionAllowlist);
        $this$initialize_u24lambda_u245.setImplicitToSourcePermissionsPublic(r27);
        MutableIntReferenceMap<UserState, MutableUserState> r0 = state.mutateUserStatesNoWrite();
        int index$iv = 0;
        int r13 = userIds.getSize();
    L15:
        if (index$iv >= r13) goto L18;
        int userId = userIds.elementAt(index$iv);
        IntReferenceMapExtensionsKt.set(r0, userId, new MutableUserState());
        index$iv = index$iv + 1;
        goto L15
    }

    public final void onStateMutated(GetStateScope $this$onStateMutated) {
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r2 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r5 = r2.getSize();
    L3:
        if (index$iv$iv >= r5) goto L9;
        String r6 = r2.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r7 = r2.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r11 = r7.getSize();
    L5:
        if (index$iv$iv2 >= r11) goto L7;
        String r12 = r7.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r7.valueAt(index$iv$iv2);
        schemePolicy$iv.onStateMutated($this$onStateMutated);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        this_$iv = this_$iv;
        goto L3
    }

    public final void onUserAdded(MutateStateScope $this$onUserAdded, int userId) {
        IntSetExtensionsKt.plusAssign($this$onUserAdded.getNewState().mutateExternalState().mutateUserIds(), userId);
        IntReferenceMapExtensionsKt.set($this$onUserAdded.getNewState().mutateUserStatesNoWrite(), userId, new MutableUserState());
        AccessPolicy this_$iv = this;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r4 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r7 = r4.getSize();
    L3:
        if (index$iv$iv >= r7) goto L8;
        String r8 = r4.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r9 = r4.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r13 = r9.getSize();
    L5:
        if (index$iv$iv2 >= r13) goto L7;
        String r14 = r9.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r9.valueAt(index$iv$iv2);
        schemePolicy$iv.onUserAdded($this$onUserAdded, userId);
        index$iv$iv2 = index$iv$iv2 + 1;
        this_$iv = this_$iv;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        goto L3
    L8:
        Iterator<Map.Entry<String, PackageState>> r5 = $this$onUserAdded.getNewState().getExternalState().getPackageStates().entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        PackageState packageState = r5.next().getValue();
        if (packageState.isApex() == true) goto L10;
        upgradePackageVersion($this$onUserAdded, packageState, userId);
        goto L10
    }

    public final void onUserRemoved(MutateStateScope $this$onUserRemoved, int userId) {
        IntSetExtensionsKt.minusAssign($this$onUserRemoved.getNewState().mutateExternalState().mutateUserIds(), userId);
        IntReferenceMapExtensionsKt.minusAssign($this$onUserRemoved.getNewState().mutateUserStatesNoWrite(), userId);
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r3 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r6 = r3.getSize();
    L3:
        if (index$iv$iv >= r6) goto L9;
        String r7 = r3.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r8 = r3.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r12 = r8.getSize();
    L5:
        if (index$iv$iv2 >= r12) goto L7;
        String r13 = r8.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r8.valueAt(index$iv$iv2);
        schemePolicy$iv.onUserRemoved($this$onUserRemoved, userId);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        this_$iv = this_$iv;
        goto L3
    }

    public final void onStorageVolumeMounted(MutateStateScope $this$onStorageVolumeMounted, Map<String, ? extends PackageState> r32, Map<String, ? extends PackageState> r33, IntMap<String[]> r34, String volumeUuid, List<String> r36, boolean isSystemUpdated) {
        String r1 = volumeUuid;
        boolean r5 = true;
        MutableIntSet addedAppIds = new MutableIntSet(null, 1, null);
        MutableExternalState $this$onStorageVolumeMounted_u24lambda_u2418 = $this$onStorageVolumeMounted.getNewState().mutateExternalState();
        int r7 = 0;
        $this$onStorageVolumeMounted_u24lambda_u2418.setPackageStatesPublic(r32);
        $this$onStorageVolumeMounted_u24lambda_u2418.setDisabledSystemPackageStatesPublic(r33);
        Iterator<Map.Entry<String, ? extends PackageState>> r12 = r32.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L28;
        Map.Entry<String, ? extends PackageState> r13 = r12.next();
        String packageName = r13.getKey();
        PackageState packageState = r13.getValue();
        if (packageState.isApex() == false) goto L9;
        addedAppIds = addedAppIds;
        boolean r8 = r5;
        r7 = r7;
    L27:
        r5 = r8;
        addedAppIds = addedAppIds;
        r7 = r7;
        goto L4
    L9:
        if (Intrinsics.areEqual(packageState.getVolumeUuid(), r1) == true) goto L11;
        addedAppIds = addedAppIds;
        r8 = r5;
        r7 = r7;
        goto L27
    L11:
        if (packageState.getAndroidPackage() != null) goto L13;
    L16:
        boolean r4 = r5;
    L17:
        if (r4 == false) goto L24;
        int appId = packageState.getAppId();
        MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r6 = $this$onStorageVolumeMounted_u24lambda_u2418.mutateAppIdPackageNames();
        Immutable it$iv = r6.mutate(appId);
        if (it$iv == null) goto L21;
        Immutable it$iv2 = it$iv;
        r8 = true;
    L22:
        MutableIndexedListSet $this$plusAssign$iv = (MutableIndexedListSet) it$iv2;
        $this$plusAssign$iv.add(packageName);
        goto L27
    L21:
        IntSetExtensionsKt.plusAssign(addedAppIds, appId);
        r8 = true;
        it$iv2 = new MutableIndexedListSet(null, 1, null);
        r6.put(appId, it$iv2);
        goto L22
    L24:
        throw new IllegalStateException(("Package " + packageName + " on storage volume " + r1 + " didn't receive onPackageAdded() before onStorageVolumeMounted()").toString());
    L13:
        if (r36.contains(packageName) == true) goto L16;
        r4 = false;
        goto L17
    L28:
        $this$onStorageVolumeMounted_u24lambda_u2418.setKnownPackagesPublic(r34);
        IntSet $this$forEachIndexed$iv = addedAppIds;
        int index$iv = 0;
        int r9 = $this$forEachIndexed$iv.getSize();
    L29:
        if (index$iv >= r9) goto L37;
        int appId2 = $this$forEachIndexed$iv.elementAt(index$iv);
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r14 = this.schemePolicies;
        int index$iv$iv = 0;
        int r3 = r14.getSize();
    L31:
        if (index$iv$iv >= r3) goto L36;
        String r16 = r14.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r18 = r14.valueAt(index$iv$iv);
        int r22 = r3;
        int r10 = r18.getSize();
        IntSet $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
        int index$iv$iv2 = 0;
    L33:
        if (index$iv$iv2 >= r10) goto L35;
        int r20 = r10;
        IndexedMap<String, SchemePolicy> r11 = r18;
        String r19 = r11.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r11.valueAt(index$iv$iv2);
        schemePolicy$iv.onAppIdAdded($this$onStorageVolumeMounted, appId2);
        index$iv$iv2 = index$iv$iv2 + 1;
        r10 = r20;
        r18 = r11;
        goto L33
    L35:
        index$iv$iv = index$iv$iv + 1;
        r3 = r22;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
        goto L31
    L36:
        index$iv = index$iv + 1;
        goto L29
    L37:
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r15 = this_$iv.schemePolicies;
        int index$iv$iv3 = 0;
        int r17 = r15.getSize();
    L38:
        if (index$iv$iv3 >= r17) goto L43;
        String r110 = r15.keyAt(index$iv$iv3);
        IndexedMap<String, SchemePolicy> r111 = r15.valueAt(index$iv$iv3);
        int index$iv$iv4 = 0;
        int r112 = r111.getSize();
    L40:
        if (index$iv$iv4 >= r112) goto L42;
        String r113 = r111.keyAt(index$iv$iv4);
        SchemePolicy schemePolicy$iv2 = r111.valueAt(index$iv$iv4);
        schemePolicy$iv2.onStorageVolumeMounted($this$onStorageVolumeMounted, r1, r36, isSystemUpdated);
        index$iv$iv4 = index$iv$iv4 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L40
    L42:
        index$iv$iv3 = index$iv$iv3 + 1;
        this_$iv = this_$iv;
        goto L38
    L43:
        Iterator<Map.Entry<String, ? extends PackageState>> r21 = r32.entrySet().iterator();
    L45:
        if (r21.hasNext() == false) goto L59;
        PackageState packageState2 = r21.next().getValue();
        if (packageState2.isApex() == true) goto L57;
        if (Intrinsics.areEqual(packageState2.getVolumeUuid(), r1) == false) goto L57;
        IntReferenceMap<UserState, MutableUserState> r114 = $this$onStorageVolumeMounted.getNewState().getUserStates();
        int index$iv2 = 0;
        int r115 = r114.getSize();
    L52:
        if (index$iv2 >= r115) goto L57;
        int userId = r114.keyAt(index$iv2);
        UserState r116 = (UserState) r114.valueAt(index$iv2);
        upgradePackageVersion($this$onStorageVolumeMounted, packageState2, userId);
        index$iv2 = index$iv2 + 1;
    L57:
        r1 = volumeUuid;
        goto L45
    }

    public final void onPackageAdded(MutateStateScope $this$onPackageAdded, Map<String, ? extends PackageState> r28, Map<String, ? extends PackageState> r29, IntMap<String[]> r30, String packageName) {
        PackageState packageState = r28.get(packageName);
        if (packageState == null) goto L30;
        int appId = packageState.getAppId();
        boolean isAppIdAdded = false;
        MutableExternalState $this$onPackageAdded_u24lambda_u2428 = $this$onPackageAdded.getNewState().mutateExternalState();
        $this$onPackageAdded_u24lambda_u2428.setPackageStatesPublic(r28);
        $this$onPackageAdded_u24lambda_u2428.setDisabledSystemPackageStatesPublic(r29);
        MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> r9 = $this$onPackageAdded_u24lambda_u2428.mutateAppIdPackageNames();
        Immutable it$iv = r9.mutate(appId);
        if (it$iv != null) goto L8;
        isAppIdAdded = true;
        it$iv = new MutableIndexedListSet(null, 1, null);
        r9.put(appId, it$iv);
    L8:
        MutableIndexedListSet $this$plusAssign$iv = (MutableIndexedListSet) it$iv;
        $this$plusAssign$iv.add(packageName);
        $this$onPackageAdded_u24lambda_u2428.setKnownPackagesPublic(r30);
        if (isAppIdAdded == false) goto L18;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r10 = this.schemePolicies;
        int index$iv$iv = 0;
        int r13 = r10.getSize();
    L11:
        if (index$iv$iv >= r13) goto L18;
        String r14 = r10.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r16 = r10.valueAt(index$iv$iv);
        int r1 = r16.getSize();
        boolean isAppIdAdded2 = isAppIdAdded;
        int index$iv$iv2 = 0;
    L13:
        if (index$iv$iv2 >= r1) goto L15;
        int r18 = r1;
        IndexedMap<String, SchemePolicy> r2 = r16;
        String r17 = r2.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r2.valueAt(index$iv$iv2);
        schemePolicy$iv.onAppIdAdded($this$onPackageAdded, appId);
        index$iv$iv2 = index$iv$iv2 + 1;
        r1 = r18;
        r16 = r2;
        goto L13
    L15:
        index$iv$iv = index$iv$iv + 1;
        isAppIdAdded = isAppIdAdded2;
    L18:
        AccessPolicy this_$iv = this;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r6 = this_$iv.schemePolicies;
        int index$iv$iv3 = 0;
        int r11 = r6.getSize();
    L19:
        if (index$iv$iv3 >= r11) goto L24;
        String r12 = r6.keyAt(index$iv$iv3);
        IndexedMap<String, SchemePolicy> r15 = r6.valueAt(index$iv$iv3);
        AccessPolicy this_$iv2 = this_$iv;
        int r3 = r15.getSize();
        int appId2 = appId;
        int appId3 = 0;
    L21:
        if (appId3 >= r3) goto L23;
        String r19 = r15.keyAt(appId3);
        SchemePolicy schemePolicy$iv2 = r15.valueAt(appId3);
        schemePolicy$iv2.onPackageAdded($this$onPackageAdded, packageState);
        appId3 = appId3 + 1;
        r3 = r3;
        goto L21
    L23:
        index$iv$iv3 = index$iv$iv3 + 1;
        this_$iv = this_$iv2;
        appId = appId2;
        goto L19
    L24:
        IntReferenceMap<UserState, MutableUserState> r4 = $this$onPackageAdded.getNewState().getUserStates();
        int index$iv = 0;
        int r7 = r4.getSize();
    L25:
        if (index$iv >= r7) goto L28;
        int userId = r4.keyAt(index$iv);
        UserState r110 = (UserState) r4.valueAt(index$iv);
        upgradePackageVersion($this$onPackageAdded, packageState, userId);
        index$iv = index$iv + 1;
        goto L25
    L28:
        return;
    L30:
        throw new IllegalStateException(("Added package " + packageName + " isn't found in packageStates in onPackageAdded()").toString());
    }

    public final void onPackageRemoved(MutateStateScope $this$onPackageRemoved, Map<String, ? extends PackageState> r27, Map<String, ? extends PackageState> r28, IntMap<String[]> r29, String packageName, int appId) {
        if (r27.containsKey(packageName) == true) goto L34;
        boolean isAppIdRemoved = false;
        MutableExternalState $this$onPackageRemoved_u24lambda_u2436 = $this$onPackageRemoved.getNewState().mutateExternalState();
        $this$onPackageRemoved_u24lambda_u2436.setPackageStatesPublic(r27);
        $this$onPackageRemoved_u24lambda_u2436.setDisabledSystemPackageStatesPublic(r28);
        MutableIndexedListSet $this$onPackageRemoved_u24lambda_u2436_u24lambda_u2435 = (MutableIndexedListSet) $this$onPackageRemoved_u24lambda_u2436.mutateAppIdPackageNames().mutate(appId);
        if ($this$onPackageRemoved_u24lambda_u2436_u24lambda_u2435 == null) goto L10;
        $this$onPackageRemoved_u24lambda_u2436_u24lambda_u2435.remove(packageName);
        if ($this$onPackageRemoved_u24lambda_u2436_u24lambda_u2435.isEmpty() == false) goto L10;
        IntReferenceMapExtensionsKt.minusAssign($this$onPackageRemoved_u24lambda_u2436.mutateAppIdPackageNames(), appId);
        isAppIdRemoved = true;
    L10:
        $this$onPackageRemoved_u24lambda_u2436.setKnownPackagesPublic(r29);
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r9 = this.schemePolicies;
        int index$iv$iv = 0;
        int r12 = r9.getSize();
    L11:
        if (index$iv$iv >= r12) goto L17;
        String r13 = r9.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r14 = r9.valueAt(index$iv$iv);
        int r1 = r14.getSize();
        boolean isAppIdRemoved2 = isAppIdRemoved;
        int index$iv$iv2 = 0;
    L13:
        if (index$iv$iv2 >= r1) goto L15;
        String r17 = r14.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r14.valueAt(index$iv$iv2);
        schemePolicy$iv.onPackageRemoved($this$onPackageRemoved, packageName, appId);
        index$iv$iv2 = index$iv$iv2 + 1;
        r1 = r1;
        goto L13
    L15:
        index$iv$iv = index$iv$iv + 1;
        isAppIdRemoved = isAppIdRemoved2;
        goto L11
    L17:
        if (isAppIdRemoved == false) goto L25;
        AccessPolicy this_$iv = this;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r5 = this_$iv.schemePolicies;
        int index$iv$iv3 = 0;
        int r10 = r5.getSize();
    L19:
        if (index$iv$iv3 >= r10) goto L25;
        String r11 = r5.keyAt(index$iv$iv3);
        IndexedMap<String, SchemePolicy> r15 = r5.valueAt(index$iv$iv3);
        int index$iv$iv4 = 0;
        AccessPolicy this_$iv2 = this_$iv;
        int r2 = r15.getSize();
    L21:
        if (index$iv$iv4 >= r2) goto L23;
        String r18 = r15.keyAt(index$iv$iv4);
        SchemePolicy schemePolicy$iv2 = r15.valueAt(index$iv$iv4);
        schemePolicy$iv2.onAppIdRemoved($this$onPackageRemoved, appId);
        index$iv$iv4 = index$iv$iv4 + 1;
        r2 = r2;
        goto L21
    L23:
        index$iv$iv3 = index$iv$iv3 + 1;
        this_$iv = this_$iv2;
    L25:
        IntReferenceMap<UserState, MutableUserState> r3 = $this$onPackageRemoved.getNewState().getUserStates();
        int index$iv = 0;
        int r6 = r3.getSize();
    L26:
        if (index$iv >= r6) goto L32;
        r3.keyAt(index$iv);
        UserState userState = (UserState) r3.valueAt(index$iv);
        int userStateIndex = index$iv;
        if (userState.getPackageVersions().contains(packageName) == false) goto L30;
        MutableAccessState.mutateUserStateAt$default($this$onPackageRemoved.getNewState(), userStateIndex, 0, 2, null).mutatePackageVersions().remove(packageName);
    L30:
        index$iv = index$iv + 1;
        goto L26
    L32:
        return;
    L34:
        throw new IllegalStateException(("Removed package " + packageName + " is still in packageStates in onPackageRemoved()").toString());
    }

    public final void onPackageInstalled(MutateStateScope $this$onPackageInstalled, Map<String, ? extends PackageState> r25, Map<String, ? extends PackageState> r26, IntMap<String[]> r27, String packageName, int userId) {
        MutableExternalState $this$onPackageInstalled_u24lambda_u2442 = $this$onPackageInstalled.getNewState().mutateExternalState();
        $this$onPackageInstalled_u24lambda_u2442.setPackageStatesPublic(r25);
        $this$onPackageInstalled_u24lambda_u2442.setDisabledSystemPackageStatesPublic(r26);
        $this$onPackageInstalled_u24lambda_u2442.setKnownPackagesPublic(r27);
        PackageState packageState = r25.get(packageName);
        if (packageState == null) goto L13;
        AccessPolicy this_$iv = this;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r7 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r10 = r7.getSize();
    L5:
        if (index$iv$iv >= r10) goto L11;
        String r11 = r7.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r12 = r7.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r0 = r12.getSize();
    L7:
        if (index$iv$iv2 >= r0) goto L9;
        String r16 = r12.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r12.valueAt(index$iv$iv2);
        schemePolicy$iv.onPackageInstalled($this$onPackageInstalled, packageState, userId);
        index$iv$iv2 = index$iv$iv2 + 1;
        this_$iv = this_$iv;
        r0 = r0;
        goto L7
    L9:
        index$iv$iv = index$iv$iv + 1;
        this_$iv = this_$iv;
        goto L5
    L11:
        return;
    L13:
        throw new IllegalStateException(("Installed package " + packageName + " isn't found in packageStates in onPackageInstalled()").toString());
    }

    public final void onPackageUninstalled(MutateStateScope $this$onPackageUninstalled, Map<String, ? extends PackageState> r24, Map<String, ? extends PackageState> r25, IntMap<String[]> r26, String packageName, int appId, int userId) {
        MutableExternalState $this$onPackageUninstalled_u24lambda_u2446 = $this$onPackageUninstalled.getNewState().mutateExternalState();
        $this$onPackageUninstalled_u24lambda_u2446.setPackageStatesPublic(r24);
        $this$onPackageUninstalled_u24lambda_u2446.setDisabledSystemPackageStatesPublic(r25);
        $this$onPackageUninstalled_u24lambda_u2446.setKnownPackagesPublic(r26);
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r5 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r8 = r5.getSize();
    L3:
        if (index$iv$iv >= r8) goto L9;
        String r9 = r5.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r10 = r5.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r14 = r10.getSize();
    L5:
        if (index$iv$iv2 >= r14) goto L7;
        String r15 = r10.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r10.valueAt(index$iv$iv2);
        schemePolicy$iv.onPackageUninstalled($this$onPackageUninstalled, packageName, appId, userId);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L3
    }

    public final void onSystemReady(MutateStateScope $this$onSystemReady) {
        $this$onSystemReady.getNewState().mutateExternalState().setSystemReadyPublic(true);
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r2 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r5 = r2.getSize();
    L3:
        if (index$iv$iv >= r5) goto L9;
        String r6 = r2.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r7 = r2.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r11 = r7.getSize();
    L5:
        if (index$iv$iv2 >= r11) goto L7;
        String r12 = r7.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r7.valueAt(index$iv$iv2);
        schemePolicy$iv.onSystemReady($this$onSystemReady);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        this_$iv = this_$iv;
        goto L3
    }

    public final void migrateSystemState(MutableAccessState state) {
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r2 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r5 = r2.getSize();
    L3:
        if (index$iv$iv >= r5) goto L9;
        String r6 = r2.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r7 = r2.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r11 = r7.getSize();
    L5:
        if (index$iv$iv2 >= r11) goto L7;
        String r12 = r7.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r7.valueAt(index$iv$iv2);
        schemePolicy$iv.migrateSystemState(state);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        this_$iv = this_$iv;
        goto L3
    }

    public final void migrateUserState(MutableAccessState state, int userId) {
        AccessPolicy this_$iv = this;
        int $i$f$forEachSchemePolicy = 0;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r2 = this_$iv.schemePolicies;
        int index$iv$iv = 0;
        int r5 = r2.getSize();
    L3:
        if (index$iv$iv >= r5) goto L9;
        String r6 = r2.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r7 = r2.valueAt(index$iv$iv);
        int index$iv$iv2 = 0;
        int r11 = r7.getSize();
    L5:
        if (index$iv$iv2 >= r11) goto L7;
        String r12 = r7.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r7.valueAt(index$iv$iv2);
        schemePolicy$iv.migrateUserState(state, userId);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        r2 = r2;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy;
        this_$iv = this_$iv;
        goto L3
    }

    private final void upgradePackageVersion(MutateStateScope $this$upgradePackageVersion, PackageState packageState, int userId) {
        if (packageState.getAndroidPackage() != null) goto L5;
        return;
    L5:
        String packageName = packageState.getPackageName();
        Immutable r2 = $this$upgradePackageVersion.getNewState().getUserStates().get(userId);
        Intrinsics.checkNotNull(r2);
        Integer version = ((UserState) r2).getPackageVersions().get(packageName);
        int r6 = 17;
        if (version != null) goto L9;
        MutableUserState r3 = MutableAccessState.mutateUserState$default($this$upgradePackageVersion.getNewState(), userId, 0, 2, null);
        Intrinsics.checkNotNull(r3);
        r3.mutatePackageVersions().put(packageName, 17);
        return;
    L9:
        if (version.intValue() >= 17) goto L18;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r9 = this.schemePolicies;
        int index$iv$iv = 0;
        int r12 = r9.getSize();
    L11:
        if (index$iv$iv >= r12) goto L16;
        String r13 = r9.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r14 = r9.valueAt(index$iv$iv);
        int r18 = r6;
        int r7 = r14.getSize();
        int index$iv$iv2 = 0;
    L13:
        if (index$iv$iv2 >= r7) goto L15;
        String r17 = r14.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r14.valueAt(index$iv$iv2);
        schemePolicy$iv.upgradePackageState($this$upgradePackageVersion, packageState, userId, version.intValue());
        index$iv$iv2 = index$iv$iv2 + 1;
        r7 = r7;
        goto L13
    L15:
        index$iv$iv = index$iv$iv + 1;
        r6 = r18;
        goto L11
    L16:
        MutableUserState r4 = MutableAccessState.mutateUserState$default($this$upgradePackageVersion.getNewState(), userId, 0, 2, null);
        Intrinsics.checkNotNull(r4);
        r4.mutatePackageVersions().put(packageName, Integer.valueOf(r6));
        return;
    L18:
        if (version.intValue() == 17) goto L25;
        Slog.w(LOG_TAG, "Unexpected version " + version + " for package " + packageName + ",latest version is 17");
        return;
    }

    public final void parseSystemState(BinaryXmlPullParser $this$parseSystemState, MutableAccessState state) {
        BinaryXmlPullParser $this$forEachTag$iv = $this$parseSystemState;
        int postBlockDepth$iv = 0;
        int eventType$iv = $this$forEachTag$iv.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$forEachTag$iv.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$forEachTag$iv.getEventType();
        switch(eventType$iv2) {
            case 1: goto L91;
            case 2: goto L15;
            case 3: goto L91;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$forEachTag$iv.getDepth();
        BinaryXmlPullParser $this$parseSystemState_u24lambda_u2460 = $this$forEachTag$iv;
        if (Intrinsics.areEqual($this$parseSystemState_u24lambda_u2460.getName(), "access") == false) goto L63;
        int eventType$iv3 = $this$parseSystemState_u24lambda_u2460.getEventType();
        switch(eventType$iv3) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L22;
            default: goto L20;
        };
    L22:
        int eventType$iv$iv2 = $this$parseSystemState_u24lambda_u2460.next();
        switch(eventType$iv$iv2) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L26;
            default: goto L22;
        };
    L26:
        int eventType$iv4 = $this$parseSystemState_u24lambda_u2460.getEventType();
        switch(eventType$iv4) {
            case 1: goto L62;
            case 2: goto L30;
            case 3: goto L62;
            default: goto L29;
        };
    L30:
        int childDepth$iv2 = $this$parseSystemState_u24lambda_u2460.getDepth();
        BinaryXmlPullParser $this$forEachTag$iv2 = $this$forEachTag$iv;
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r0 = this.schemePolicies;
        int $i$f$forEachTag = postBlockDepth$iv;
        int $i$f$forEachTag2 = r0.getSize();
        int eventType$iv5 = eventType$iv2;
        int eventType$iv6 = 0;
    L31:
        if (eventType$iv6 >= $i$f$forEachTag2) goto L36;
        String r19 = r0.keyAt(eventType$iv6);
        IndexedMap<String, SchemePolicy> r23 = r0.valueAt(eventType$iv6);
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r26 = r0;
        int r1 = r23.getSize();
        int r27 = $i$f$forEachTag2;
        int index$iv$iv = 0;
    L33:
        if (index$iv$iv >= r1) goto L35;
        int r25 = r1;
        IndexedMap<String, SchemePolicy> r2 = r23;
        String r24 = r2.keyAt(index$iv$iv);
        SchemePolicy schemePolicy$iv = r2.valueAt(index$iv$iv);
        schemePolicy$iv.parseSystemState($this$parseSystemState_u24lambda_u2460, state);
        index$iv$iv = index$iv$iv + 1;
        r1 = r25;
        r23 = r2;
        goto L33
    L35:
        eventType$iv6 = eventType$iv6 + 1;
        r0 = r26;
        $i$f$forEachTag2 = r27;
        goto L31
    L36:
        int postBlockDepth$iv2 = $this$parseSystemState_u24lambda_u2460.getDepth();
        if (postBlockDepth$iv2 != childDepth$iv2) goto L61;
    L39:
        int childEventType$iv = $this$parseSystemState_u24lambda_u2460.getEventType();
        switch(childEventType$iv) {
            case 2: goto L56;
            case 3: goto L44;
            default: goto L42;
        };
    L42:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L56:
        int eventType$iv$iv3 = $this$parseSystemState_u24lambda_u2460.next();
        switch(eventType$iv$iv3) {
            case 1: goto L39;
            case 2: goto L39;
            case 3: goto L39;
            default: goto L56;
        };
    L44:
        if ($this$parseSystemState_u24lambda_u2460.getDepth() <= childDepth$iv2) goto L51;
    L46:
        int eventType$iv$iv4 = $this$parseSystemState_u24lambda_u2460.next();
        switch(eventType$iv$iv4) {
            case 1: goto L39;
            case 2: goto L39;
            case 3: goto L39;
            default: goto L46;
        };
    L51:
        int eventType$iv$iv5 = $this$parseSystemState_u24lambda_u2460.next();
        switch(eventType$iv$iv5) {
            case 1: goto L54;
            case 2: goto L54;
            case 3: goto L54;
            default: goto L51;
        };
    L54:
        $this$forEachTag$iv = $this$forEachTag$iv2;
        postBlockDepth$iv = $i$f$forEachTag;
        eventType$iv2 = eventType$iv5;
        goto L26
    L61:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv2 + ", expected " + childDepth$iv2);
    L29:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv4);
    L62:
        BinaryXmlPullParser $this$forEachTag$iv3 = $this$forEachTag$iv;
        int $i$f$forEachTag3 = postBlockDepth$iv;
    L64:
        int postBlockDepth$iv3 = $this$forEachTag$iv3.getDepth();
        if (postBlockDepth$iv3 != childDepth$iv) goto L89;
    L67:
        int childEventType$iv2 = $this$forEachTag$iv3.getEventType();
        switch(childEventType$iv2) {
            case 2: goto L83;
            case 3: goto L72;
            default: goto L70;
        };
    L70:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv2);
    L83:
        BinaryXmlPullParser $this$nextTagOrEnd$iv$iv = $this$forEachTag$iv3;
    L84:
        int eventType$iv$iv6 = $this$nextTagOrEnd$iv$iv.next();
        switch(eventType$iv$iv6) {
            case 1: goto L67;
            case 2: goto L67;
            case 3: goto L67;
            default: goto L84;
        };
    L72:
        if ($this$forEachTag$iv3.getDepth() <= childDepth$iv) goto L78;
        BinaryXmlPullParser $this$nextTagOrEnd$iv$iv2 = $this$forEachTag$iv3;
    L74:
        int eventType$iv$iv7 = $this$nextTagOrEnd$iv$iv2.next();
        switch(eventType$iv$iv7) {
            case 1: goto L67;
            case 2: goto L67;
            case 3: goto L67;
            default: goto L74;
        };
    L78:
        BinaryXmlPullParser $this$nextTagOrEnd$iv$iv3 = $this$forEachTag$iv3;
    L79:
        int eventType$iv$iv8 = $this$nextTagOrEnd$iv$iv3.next();
        switch(eventType$iv$iv8) {
            case 1: goto L82;
            case 2: goto L82;
            case 3: goto L82;
            default: goto L79;
        };
    L82:
        $this$forEachTag$iv = $this$forEachTag$iv3;
        postBlockDepth$iv = $i$f$forEachTag3;
        goto L11
    L89:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv3 + ", expected " + childDepth$iv);
    L20:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv3);
    L63:
        $this$forEachTag$iv3 = $this$forEachTag$iv;
        $i$f$forEachTag3 = postBlockDepth$iv;
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseSystemState_u24lambda_u2460.getName() + " when parsing system state");
        goto L64
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    }

    public final void serializeSystemState(BinaryXmlSerializer $this$serializeSystemState, AccessState state) {
        int $i$f$tag = 0;
        $this$serializeSystemState.startTag(null, "access");
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r8 = this.schemePolicies;
        int index$iv$iv = 0;
        int r11 = r8.getSize();
    L3:
        if (index$iv$iv >= r11) goto L8;
        String r12 = r8.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r13 = r8.valueAt(index$iv$iv);
        int r3 = r13.getSize();
        int $i$f$tag2 = $i$f$tag;
        int $i$f$tag3 = 0;
    L5:
        if ($i$f$tag3 >= r3) goto L7;
        String r16 = r13.keyAt($i$f$tag3);
        SchemePolicy schemePolicy$iv = r13.valueAt($i$f$tag3);
        int index$iv$iv2 = $i$f$tag3;
        schemePolicy$iv.serializeSystemState($this$serializeSystemState, state);
        $i$f$tag3 = index$iv$iv2 + 1;
        r3 = r3;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        $i$f$tag = $i$f$tag2;
        goto L3
    L8:
        $this$serializeSystemState.endTag(null, "access");
    }

    public final void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        BinaryXmlPullParser $this$nextTagOrEnd$iv$iv = $this$parseUserState;
        int $i$f$nextTagOrEnd = 0;
        int eventType$iv = $this$nextTagOrEnd$iv$iv.getEventType();
        switch(eventType$iv) {
            case 0: goto L8;
            case 1: goto L5;
            case 2: goto L8;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L8:
        switch($this$nextTagOrEnd$iv$iv.next()) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L8;
        };
    L11:
        int eventType$iv$iv = $this$nextTagOrEnd$iv$iv.getEventType();
        switch(eventType$iv$iv) {
            case 1: goto L98;
            case 2: goto L15;
            case 3: goto L98;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$nextTagOrEnd$iv$iv.getDepth();
        BinaryXmlPullParser $this$parseUserState_u24lambda_u2467 = $this$nextTagOrEnd$iv$iv;
        if (Intrinsics.areEqual($this$parseUserState_u24lambda_u2467.getName(), "access") == false) goto L70;
        int eventType$iv2 = $this$parseUserState_u24lambda_u2467.getEventType();
        switch(eventType$iv2) {
            case 0: goto L23;
            case 1: goto L20;
            case 2: goto L23;
            default: goto L20;
        };
    L23:
        switch($this$parseUserState_u24lambda_u2467.next()) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L26;
            default: goto L23;
        };
    L26:
        int eventType$iv3 = $this$parseUserState_u24lambda_u2467.getEventType();
        switch(eventType$iv3) {
            case 1: goto L69;
            case 2: goto L30;
            case 3: goto L69;
            default: goto L29;
        };
    L30:
        int childDepth$iv2 = $this$parseUserState_u24lambda_u2467.getDepth();
        BinaryXmlPullParser $this$forEachTag$iv = $this$nextTagOrEnd$iv$iv;
        String r3 = $this$parseUserState_u24lambda_u2467.getName();
        int $i$f$forEachTag = $i$f$nextTagOrEnd;
        if (Intrinsics.areEqual(r3, "package-versions") == false) goto L33;
        this.parsePackageVersions($this$parseUserState_u24lambda_u2467, state, userId);
        int eventType$iv4 = eventType$iv$iv;
    L43:
        int postBlockDepth$iv = $this$parseUserState_u24lambda_u2467.getDepth();
        if (postBlockDepth$iv != childDepth$iv2) goto L68;
    L46:
        int childEventType$iv = $this$parseUserState_u24lambda_u2467.getEventType();
        switch(childEventType$iv) {
            case 2: goto L64;
            case 3: goto L51;
            default: goto L49;
        };
    L49:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L64:
        switch($this$parseUserState_u24lambda_u2467.next()) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L46;
            default: goto L64;
        };
    L51:
        if ($this$parseUserState_u24lambda_u2467.getDepth() <= childDepth$iv2) goto L59;
    L54:
        switch($this$parseUserState_u24lambda_u2467.next()) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L46;
            default: goto L54;
        };
    L59:
        switch($this$parseUserState_u24lambda_u2467.next()) {
            case 1: goto L61;
            case 2: goto L61;
            case 3: goto L61;
            default: goto L59;
        };
    L61:
        AccessPolicy this = this;
        eventType$iv$iv = eventType$iv4;
        $i$f$nextTagOrEnd = $i$f$forEachTag;
        $this$nextTagOrEnd$iv$iv = $this$forEachTag$iv;
        goto L26
    L68:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv2);
    L33:
        eventType$iv4 = eventType$iv$iv;
        if (Intrinsics.areEqual(r3, "default-permission-grant") == false) goto L36;
        this.parseDefaultPermissionGrant($this$parseUserState_u24lambda_u2467, state, userId);
        goto L43
    L36:
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r0 = this.schemePolicies;
        int r4 = r0.getSize();
        int $i$f$forEachSchemePolicy = 0;
    L37:
        if ($i$f$forEachSchemePolicy >= r4) goto L43;
        String r21 = r0.keyAt($i$f$forEachSchemePolicy);
        IndexedMap<String, SchemePolicy> r25 = r0.valueAt($i$f$forEachSchemePolicy);
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r28 = r0;
        int r1 = r25.getSize();
        int r29 = r4;
        int index$iv$iv = 0;
    L39:
        if (index$iv$iv >= r1) goto L41;
        int r27 = r1;
        IndexedMap<String, SchemePolicy> r2 = r25;
        String r26 = r2.keyAt(index$iv$iv);
        SchemePolicy schemePolicy$iv = r2.valueAt(index$iv$iv);
        schemePolicy$iv.parseUserState($this$parseUserState_u24lambda_u2467, state, userId);
        index$iv$iv = index$iv$iv + 1;
        r1 = r27;
        r25 = r2;
        goto L39
    L41:
        $i$f$forEachSchemePolicy = $i$f$forEachSchemePolicy + 1;
        r0 = r28;
        r4 = r29;
        goto L37
    L29:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv3);
    L69:
        BinaryXmlPullParser $this$forEachTag$iv2 = $this$nextTagOrEnd$iv$iv;
        int $i$f$forEachTag2 = $i$f$nextTagOrEnd;
    L71:
        int postBlockDepth$iv2 = $this$forEachTag$iv2.getDepth();
        if (postBlockDepth$iv2 != childDepth$iv) goto L96;
    L74:
        int childEventType$iv2 = $this$forEachTag$iv2.getEventType();
        switch(childEventType$iv2) {
            case 2: goto L92;
            case 3: goto L79;
            default: goto L77;
        };
    L77:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv2);
    L92:
        switch($this$forEachTag$iv2.next()) {
            case 1: goto L74;
            case 2: goto L74;
            case 3: goto L74;
            default: goto L92;
        };
    L79:
        if ($this$forEachTag$iv2.getDepth() <= childDepth$iv) goto L87;
    L82:
        switch($this$forEachTag$iv2.next()) {
            case 1: goto L74;
            case 2: goto L74;
            case 3: goto L74;
            default: goto L82;
        };
    L87:
        switch($this$forEachTag$iv2.next()) {
            case 1: goto L89;
            case 2: goto L89;
            case 3: goto L89;
            default: goto L87;
        };
    L89:
        $i$f$nextTagOrEnd = $i$f$forEachTag2;
        $this$nextTagOrEnd$iv$iv = $this$forEachTag$iv2;
        goto L11
    L96:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv2 + ", expected " + childDepth$iv);
    L20:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L70:
        $this$forEachTag$iv2 = $this$nextTagOrEnd$iv$iv;
        $i$f$forEachTag2 = $i$f$nextTagOrEnd;
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parseUserState_u24lambda_u2467.getName() + " when parsing user state for user " + userId);
        goto L71
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv$iv);
    }

    private final void parsePackageVersions(BinaryXmlPullParser $this$parsePackageVersions, MutableAccessState state, int userId) {
        MutableUserState userState = state.mutateUserState(userId, 0);
        Intrinsics.checkNotNull(userState);
        MutableIndexedMap<String, Integer> r3 = userState.mutatePackageVersions();
        int eventType$iv = $this$parsePackageVersions.getEventType();
        switch(eventType$iv) {
            case 0: goto L7;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv);
    L7:
        int eventType$iv$iv = $this$parsePackageVersions.next();
        switch(eventType$iv$iv) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L7;
        };
    L11:
        int eventType$iv2 = $this$parsePackageVersions.getEventType();
        switch(eventType$iv2) {
            case 1: goto L45;
            case 2: goto L15;
            case 3: goto L45;
            default: goto L14;
        };
    L15:
        int childDepth$iv = $this$parsePackageVersions.getDepth();
        if (Intrinsics.areEqual($this$parsePackageVersions.getName(), Settings.ATTR_PACKAGE) == false) goto L18;
        parsePackageVersion($this$parsePackageVersions, r3);
    L19:
        int postBlockDepth$iv = $this$parsePackageVersions.getDepth();
        if (postBlockDepth$iv != childDepth$iv) goto L44;
    L22:
        int childEventType$iv = $this$parsePackageVersions.getEventType();
        switch(childEventType$iv) {
            case 2: goto L39;
            case 3: goto L27;
            default: goto L25;
        };
    L25:
        throw new XmlPullParserException("Unexpected event type " + childEventType$iv);
    L39:
        int eventType$iv$iv2 = $this$parsePackageVersions.next();
        switch(eventType$iv$iv2) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L39;
        };
    L27:
        if ($this$parsePackageVersions.getDepth() <= childDepth$iv) goto L34;
    L29:
        int eventType$iv$iv3 = $this$parsePackageVersions.next();
        switch(eventType$iv$iv3) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            default: goto L29;
        };
    L34:
        int eventType$iv$iv4 = $this$parsePackageVersions.next();
        switch(eventType$iv$iv4) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            default: goto L34;
        };
    L44:
        throw new XmlPullParserException("Unexpected post-block depth " + postBlockDepth$iv + ", expected " + childDepth$iv);
    L18:
        Slog.w(LOG_TAG, "Ignoring unknown tag " + $this$parsePackageVersions.getName() + " when parsing package versions");
        goto L19
    L14:
        throw new XmlPullParserException("Unexpected event type " + eventType$iv2);
    L45:
        int index$iv = r3.getSize() - 1;
    L47:
        if ((-1) >= index$iv) goto L53;
        String r5 = r3.keyAt(index$iv);
        r3.valueAt(index$iv).intValue();
        String packageName = r5;
        int packageVersionIndex = index$iv;
        if (state.getExternalState().getPackageStates().containsKey(packageName) == true) goto L51;
        Slog.w(LOG_TAG, "Dropping unknown " + packageName + " when parsing package versions");
        r3.removeAt(packageVersionIndex);
        userState.requestWriteMode(1);
    L51:
        index$iv = index$iv - 1;
        goto L47
    }

    private final void parsePackageVersion(BinaryXmlPullParser $this$parsePackageVersion, MutableIndexedMap<String, Integer> r8) {
        String name$iv = $this$parsePackageVersion.getAttributeValue($this$parsePackageVersion.getAttributeIndexOrThrow(null, "name"));
        String packageName = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(packageName, "intern(...)");
        int version = $this$parsePackageVersion.getAttributeInt(null, "version");
        r8.put(packageName, Integer.valueOf(version));
    }

    private final void parseDefaultPermissionGrant(BinaryXmlPullParser $this$parseDefaultPermissionGrant, MutableAccessState state, int userId) {
        MutableUserState userState = state.mutateUserState(userId, 0);
        Intrinsics.checkNotNull(userState);
        String name$iv = $this$parseDefaultPermissionGrant.getAttributeValue($this$parseDefaultPermissionGrant.getAttributeIndexOrThrow(null, "fingerprint"));
        String fingerprint = name$iv.intern();
        Intrinsics.checkNotNullExpressionValue(fingerprint, "intern(...)");
        userState.setDefaultPermissionGrantFingerprintPublic(fingerprint);
    }

    public final void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        int $i$f$tag = 0;
        $this$serializeUserState.startTag(null, "access");
        Immutable r8 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r8);
        serializePackageVersions($this$serializeUserState, ((UserState) r8).getPackageVersions());
        Immutable r9 = state.getUserStates().get(userId);
        Intrinsics.checkNotNull(r9);
        serializeDefaultPermissionGrantFingerprint($this$serializeUserState, ((UserState) r9).getDefaultPermissionGrantFingerprint());
        IndexedMap<String, IndexedMap<String, SchemePolicy>> r10 = this.schemePolicies;
        int index$iv$iv = 0;
        int r13 = r10.getSize();
    L3:
        if (index$iv$iv >= r13) goto L8;
        String r14 = r10.keyAt(index$iv$iv);
        IndexedMap<String, SchemePolicy> r16 = r10.valueAt(index$iv$iv);
        int r5 = r16.getSize();
        int index$iv$iv2 = 0;
    L5:
        if (index$iv$iv2 >= r5) goto L7;
        int $i$f$tag2 = $i$f$tag;
        IndexedMap<String, SchemePolicy> r4 = r16;
        String r17 = r4.keyAt(index$iv$iv2);
        SchemePolicy schemePolicy$iv = r4.valueAt(index$iv$iv2);
        schemePolicy$iv.serializeUserState($this$serializeUserState, state, userId);
        index$iv$iv2 = index$iv$iv2 + 1;
        $i$f$tag = $i$f$tag2;
        r16 = r4;
        goto L5
    L7:
        index$iv$iv = index$iv$iv + 1;
        goto L3
    L8:
        $this$serializeUserState.endTag(null, "access");
    }

    private final void serializePackageVersions(BinaryXmlSerializer $this$serializePackageVersions, IndexedMap<String, Integer> r24) {
        int $i$f$tag = 0;
        String r3 = null;
        $this$serializePackageVersions.startTag(null, "package-versions");
        BinaryXmlSerializer $this$serializePackageVersions_u24lambda_u2475 = $this$serializePackageVersions;
        int index$iv = 0;
        int r9 = r24.getSize();
    L3:
        if (index$iv >= r9) goto L5;
        String r10 = r24.keyAt(index$iv);
        int version = r24.valueAt(index$iv).intValue();
        String packageName = r10;
        BinaryXmlSerializer $this$tag$iv = $this$serializePackageVersions_u24lambda_u2475;
        $this$tag$iv.startTag(r3, Settings.ATTR_PACKAGE);
        BinaryXmlSerializer $this$attributeInterned$iv = $this$serializePackageVersions_u24lambda_u2475;
        $this$tag$iv.attributeInterned(null, "name", packageName);
        $this$tag$iv.attributeInt(null, "version", version);
        $this$tag$iv.endTag(null, Settings.ATTR_PACKAGE);
        index$iv = index$iv + 1;
        $this$serializePackageVersions_u24lambda_u2475 = $this$attributeInterned$iv;
        $i$f$tag = $i$f$tag;
        r3 = null;
        goto L3
    L5:
        $this$serializePackageVersions.endTag(null, "package-versions");
    }

    private final void serializeDefaultPermissionGrantFingerprint(BinaryXmlSerializer $this$serializeDefaultPermissionGrantFingerprint, String fingerprint) {
        if (fingerprint == null) goto L5;
        $this$serializeDefaultPermissionGrantFingerprint.startTag(null, "default-permission-grant");
        $this$serializeDefaultPermissionGrantFingerprint.attributeInterned(null, "fingerprint", fingerprint);
        $this$serializeDefaultPermissionGrantFingerprint.endTag(null, "default-permission-grant");
        return;
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AccessPolicy.class.getSimpleName();
    }
}
