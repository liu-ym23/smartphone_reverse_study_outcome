package com.android.server.permission.access.permission;

import android.util.Slog;
import com.android.modules.utils.BinaryXmlPullParser;
import com.android.modules.utils.BinaryXmlSerializer;
import com.android.server.permission.access.AccessState;
import com.android.server.permission.access.GetStateScope;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.SchemePolicy;
import com.android.server.permission.access.UserState;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedListSetExtensionsKt;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedMapExtensionsKt;
import com.android.server.permission.access.immutable.IndexedReferenceMap;
import com.android.server.permission.access.immutable.IndexedSetExtensionsKt;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.access.immutable.MutableIndexedSet;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.jarjar.kotlin.Unit;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: DevicePermissionPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DevicePermissionPolicy extends SchemePolicy {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;
    private volatile IndexedListSet<OnDevicePermissionFlagsChangedListener> listeners;
    private final Object listenersLock;
    private final DevicePermissionPersistence persistence;

    /* JADX INFO: compiled from: DevicePermissionPolicy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: DevicePermissionPolicy.kt */
    public interface OnDevicePermissionFlagsChangedListener {
        void onDevicePermissionFlagsChanged(int r1, int r2, String r3, String r4, int r5, int r6);

        void onStateMutated();
    }

    public DevicePermissionPolicy() {
        this.persistence = new DevicePermissionPersistence();
        this.listeners = new MutableIndexedListSet(null, 1, null);
        this.listenersLock = new Object();
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public String getSubjectScheme() {
        return "uid";
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public String getObjectScheme() {
        return "device-permission";
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onStateMutated(GetStateScope $this$onStateMutated) {
        IndexedListSet<OnDevicePermissionFlagsChangedListener> r0 = this.listeners;
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L6;
        OnDevicePermissionFlagsChangedListener it = r0.elementAt(index$iv);
        it.onStateMutated();
        index$iv = index$iv + 1;
        goto L3
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
        if (userState.getAppIdDevicePermissionFlags().contains(appId) == false) goto L7;
        IntReferenceMapExtensionsKt.minusAssign(MutableAccessState.mutateUserStateAt$default($this$onAppIdRemoved.getNewState(), userStateIndex, 0, 2, null).mutateAppIdDevicePermissionFlags(), appId);
    L7:
        index$iv = index$iv + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void trimDevicePermissionStates(MutateStateScope $this$trimDevicePermissionStates, Set<String> r25) {
        IntReferenceMap<UserState, MutableUserState> r0 = $this$trimDevicePermissionStates.getNewState().getUserStates();
        int $i$f$forEachIndexed = 0;
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L21;
        int userId = r0.keyAt(index$iv);
        UserState userState = (UserState) r0.valueAt(index$iv);
        IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r7 = userState.getAppIdDevicePermissionFlags();
        int index$iv2 = r7.getSize() - 1;
    L6:
        if ((-1) >= index$iv2) goto L19;
        int appId = r7.keyAt(index$iv2);
        IndexedReferenceMap r12 = (IndexedReferenceMap) r7.valueAt(index$iv2);
        MutableUserState r9 = MutableAccessState.mutateUserState$default($this$trimDevicePermissionStates.getNewState(), userId, 0, 2, null);
        Intrinsics.checkNotNull(r9);
        MutableIndexedReferenceMap devicePermissionFlags = (MutableIndexedReferenceMap) r9.mutateAppIdDevicePermissionFlags().mutate(appId);
        if (devicePermissionFlags != null) goto L10;
        int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
    L18:
        index$iv2 = index$iv2 - 1;
        r0 = r0;
        $i$f$forEachIndexed = $i$f$forEachIndexed2;
        goto L6
    L10:
        int index$iv3 = devicePermissionFlags.getSize() - 1;
    L11:
        $i$f$forEachIndexed2 = $i$f$forEachIndexed;
        if ((-1) >= index$iv3) goto L18;
        K r16 = devicePermissionFlags.keyAt(index$iv3);
        IndexedMap r19 = (IndexedMap) devicePermissionFlags.valueAt(index$iv3);
        String deviceId = (String) r16;
        int index$iv4 = index$iv3;
        if (r25.contains(deviceId) == true) goto L16;
        devicePermissionFlags.remove(deviceId);
    L16:
        index$iv3 = index$iv4 - 1;
        $i$f$forEachIndexed = $i$f$forEachIndexed2;
        goto L11
    L19:
        index$iv = index$iv + 1;
        goto L3
    }

    public final void onDeviceIdRemoved(MutateStateScope $this$onDeviceIdRemoved, String deviceId) {
        IntReferenceMap<UserState, MutableUserState> r0 = $this$onDeviceIdRemoved.getNewState().getUserStates();
        int index$iv = 0;
        int r3 = r0.getSize();
    L3:
        if (index$iv >= r3) goto L14;
        int userId = r0.keyAt(index$iv);
        UserState userState = (UserState) r0.valueAt(index$iv);
        IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r7 = userState.getAppIdDevicePermissionFlags();
        int index$iv2 = r7.getSize() - 1;
    L6:
        if ((-1) >= index$iv2) goto L12;
        int appId = r7.keyAt(index$iv2);
        IndexedReferenceMap r10 = (IndexedReferenceMap) r7.valueAt(index$iv2);
        MutableUserState r12 = MutableAccessState.mutateUserState$default($this$onDeviceIdRemoved.getNewState(), userId, 0, 2, null);
        Intrinsics.checkNotNull(r12);
        MutableIndexedReferenceMap devicePermissionFlags = (MutableIndexedReferenceMap) r12.mutateAppIdDevicePermissionFlags().mutate(appId);
        if (devicePermissionFlags == null) goto L11;
        devicePermissionFlags.remove(deviceId);
    L11:
        index$iv2 = index$iv2 - 1;
        r0 = r0;
        goto L6
    L12:
        index$iv = index$iv + 1;
        r0 = r0;
        goto L3
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onStorageVolumeMounted(MutateStateScope $this$onStorageVolumeMounted, String volumeUuid, List<String> r11, boolean isSystemUpdated) {
        int index$iv = 0;
        int r3 = r11.size();
    L3:
        if (index$iv >= r3) goto L10;
        String packageName = r11.get(index$iv);
        PackageState packageState = $this$onStorageVolumeMounted.getNewState().getExternalState().getPackageStates().get(packageName);
        if (packageState == null) goto L8;
        trimPermissionStates($this$onStorageVolumeMounted, packageState.getAppId());
    L8:
        index$iv = index$iv + 1;
        goto L3
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageAdded(MutateStateScope $this$onPackageAdded, PackageState packageState) {
        trimPermissionStates($this$onPackageAdded, packageState.getAppId());
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageRemoved(MutateStateScope $this$onPackageRemoved, String packageName, int appId) {
        if ($this$onPackageRemoved.getNewState().getExternalState().getAppIdPackageNames().contains(appId) == false) goto L6;
        trimPermissionStates($this$onPackageRemoved, appId);
        return;
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void onPackageUninstalled(MutateStateScope $this$onPackageUninstalled, String packageName, int appId, int userId) {
        resetRuntimePermissions($this$onPackageUninstalled, packageName, userId);
    }

    public final void resetRuntimePermissions(MutateStateScope $this$resetRuntimePermissions, String packageName, int userId) {
        PackageState packageState = $this$resetRuntimePermissions.getNewState().getExternalState().getPackageStates().get(packageName);
        if (packageState != null) goto L5;
        return;
    L5:
        AndroidPackage androidPackage = packageState.getAndroidPackage();
        if (androidPackage != null) goto L8;
        return;
    L8:
        int appId = packageState.getAppId();
        int r7 = userId;
        UserState userState = (UserState) $this$resetRuntimePermissions.getNewState().getUserStates().get(r7);
        if (userState != null) goto L11;
        return;
    L11:
        IndexedReferenceMap devicePermissionFlags = (IndexedReferenceMap) userState.getAppIdDevicePermissionFlags().get(appId);
        if (devicePermissionFlags != null) goto L14;
        return;
    L14:
        Iterable $this$forEach$iv = androidPackage.getRequestedPermissions();
        Iterator r14 = $this$forEach$iv.iterator();
    L16:
        if (r14.hasNext() == false) goto L44;
        Object element$iv = r14.next();
        String permissionName = (String) element$iv;
        AccessState state$iv = $this$resetRuntimePermissions.getNewState();
        Immutable r6 = state$iv.getExternalState().getAppIdPackageNames().get(appId);
        Intrinsics.checkNotNull(r6);
        IndexedListSet packageNames$iv = (IndexedListSet) r6;
        IndexedListSet $this$forEachIndexed$iv$iv$iv = packageNames$iv;
        PackageState packageState2 = packageState;
        int r1 = $this$forEachIndexed$iv$iv$iv.getSize();
        AndroidPackage androidPackage2 = androidPackage;
        int index$iv$iv$iv = 0;
    L18:
        int index$iv$iv$iv2 = 0;
        if (index$iv$iv$iv >= r1) goto L36;
        int r23 = r1;
        IndexedListSet $this$forEachIndexed$iv$iv$iv2 = $this$forEachIndexed$iv$iv$iv;
        Object element$iv$iv = $this$forEachIndexed$iv$iv$iv2.elementAt(index$iv$iv$iv);
        String packageName$iv = (String) element$iv$iv;
        int index$iv$iv$iv3 = index$iv$iv$iv;
        PackageState r2 = state$iv.getExternalState().getPackageStates().get(packageName$iv);
        Intrinsics.checkNotNull(r2);
        PackageState packageState$iv = r2;
        if (packageState$iv.getAndroidPackage() == null) goto L31;
        String packageName$iv2 = packageState$iv.getPackageName();
        if (Intrinsics.areEqual(packageName$iv2, packageName) == true) goto L27;
        AndroidPackage r3 = packageState$iv.getAndroidPackage();
        Intrinsics.checkNotNull(r3);
        if (r3.getRequestedPermissions().contains(permissionName) == false) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == false) goto L31;
        index$iv$iv$iv2 = 1;
    L27:
        r4 = false;
    L31:
        if (index$iv$iv$iv2 != 0) goto L32;
        index$iv$iv$iv = index$iv$iv$iv3 + 1;
        r1 = r23;
        $this$forEachIndexed$iv$iv$iv = $this$forEachIndexed$iv$iv$iv2;
        goto L18
    L32:
        index$iv$iv$iv2 = 1;
    L36:
        if (index$iv$iv$iv2 != 0) goto L42;
        int index$iv = 0;
        int r5 = devicePermissionFlags.getSize();
    L39:
        if (index$iv >= r5) goto L42;
        Object r8 = devicePermissionFlags.keyAt(index$iv);
        IndexedMap r9 = (IndexedMap) devicePermissionFlags.valueAt(index$iv);
        String deviceId = (String) r8;
        setPermissionFlags($this$resetRuntimePermissions, appId, deviceId, r7, permissionName, 0);
        index$iv = index$iv + 1;
        r7 = userId;
        r5 = r5;
    L42:
        r7 = userId;
        packageState = packageState2;
        androidPackage = androidPackage2;
        goto L16
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
        IntReferenceMap<UserState, MutableUserState> r10 = $this$trimPermissionStates.getNewState().getUserStates();
        int r11 = r10.getSize();
        int index$iv = 0;
    L9:
        if (index$iv >= r11) goto L26;
        int userId = r10.keyAt(index$iv);
        UserState userState = (UserState) r10.valueAt(index$iv);
        IndexedReferenceMap $this$lastIndex$iv$iv = (IndexedReferenceMap) userState.getAppIdDevicePermissionFlags().get(r2);
        if ($this$lastIndex$iv$iv == null) goto L24;
        int index$iv2 = $this$lastIndex$iv$iv.getSize() - 1;
    L13:
        int r1 = -1;
        if ((-1) >= index$iv2) goto L24;
        Object r4 = $this$lastIndex$iv$iv.keyAt(index$iv2);
        IndexedMap permissionFlags = (IndexedMap) $this$lastIndex$iv$iv.valueAt(index$iv2);
        String deviceId = (String) r4;
        IndexedMap $this$forEachReversedIndexed$iv = permissionFlags;
        int index$iv3 = $this$forEachReversedIndexed$iv.getSize() - 1;
    L16:
        if (r1 >= index$iv3) goto L22;
        Object r20 = $this$forEachReversedIndexed$iv.keyAt(index$iv3);
        ((Number) $this$forEachReversedIndexed$iv.valueAt(index$iv3)).intValue();
        String permissionName = (String) r20;
        if (requestedPermissions.contains(permissionName) == true) goto L20;
        int index$iv4 = index$iv3;
        int index$iv5 = -1;
        setPermissionFlags($this$trimPermissionStates, r2, deviceId, userId, permissionName, 0);
    L21:
        index$iv3 = index$iv4 - 1;
        r2 = appId;
        index$iv2 = index$iv2;
        r1 = index$iv5;
        $this$forEachReversedIndexed$iv = $this$forEachReversedIndexed$iv;
        goto L16
    L20:
        index$iv4 = index$iv3;
        index$iv5 = -1;
        goto L21
    L22:
        index$iv2 = index$iv2 - 1;
        r2 = appId;
    L24:
        index$iv = index$iv + 1;
        r2 = appId;
        goto L9
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void parseUserState(BinaryXmlPullParser $this$parseUserState, MutableAccessState state, int userId) {
        DevicePermissionPersistence $this$parseUserState_u24lambda_u2417 = this.persistence;
        $this$parseUserState_u24lambda_u2417.parseUserState($this$parseUserState, state, userId);
    }

    @Override // com.android.server.permission.access.SchemePolicy
    public void serializeUserState(BinaryXmlSerializer $this$serializeUserState, AccessState state, int userId) {
        DevicePermissionPersistence $this$serializeUserState_u24lambda_u2418 = this.persistence;
        $this$serializeUserState_u24lambda_u2418.serializeUserState($this$serializeUserState, state, userId);
    }

    public final int getPermissionFlags(GetStateScope $this$getPermissionFlags, int appId, String deviceId, int userId, String permissionName) {
        UserState r0 = (UserState) $this$getPermissionFlags.getState().getUserStates().get(userId);
        if (r0 == null) goto L14;
        IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r1 = r0.getAppIdDevicePermissionFlags();
        if (r1 == null) goto L15;
        IndexedReferenceMap r2 = (IndexedReferenceMap) r1.get(appId);
        if (r2 == null) goto L16;
        IndexedMap r3 = (IndexedMap) r2.get(deviceId);
        if (r3 == null) goto L17;
        int flags = ((Number) IndexedMapExtensionsKt.getWithDefault(r3, permissionName, 0)).intValue();
        return flags;
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    L14:
        return 0;
    }

    public final IndexedMap<String, Integer> getAllPermissionFlags(GetStateScope $this$getAllPermissionFlags, int appId, String persistentDeviceId, int userId) {
        UserState r0 = (UserState) $this$getAllPermissionFlags.getState().getUserStates().get(userId);
        if (r0 == null) goto L9;
        IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r1 = r0.getAppIdDevicePermissionFlags();
        if (r1 == null) goto L9;
        IndexedReferenceMap r2 = (IndexedReferenceMap) r1.get(appId);
        if (r2 == null) goto L9;
        return (IndexedMap) r2.get(persistentDeviceId);
    L9:
        return null;
    }

    public final boolean setPermissionFlags(MutateStateScope $this$setPermissionFlags, int appId, String deviceId, int userId, String permissionName, int flags) {
        return updatePermissionFlags($this$setPermissionFlags, appId, deviceId, userId, permissionName, -1, flags);
    }

    private final boolean updatePermissionFlags(MutateStateScope $this$updatePermissionFlags, int appId, String deviceId, int userId, String permissionName, int flagMask, int flagValues) {
        int r1 = appId;
        String r3 = deviceId;
        int r2 = userId;
        String r4 = permissionName;
        if ($this$updatePermissionFlags.getNewState().getUserStates().contains(r2) == true) goto L6;
        Slog.e(LOG_TAG, "Unable to update permission flags for missing user " + r2);
        return false;
    L6:
        Immutable r0 = $this$updatePermissionFlags.getNewState().getUserStates().get(r2);
        Intrinsics.checkNotNull(r0);
        IndexedReferenceMap r5 = (IndexedReferenceMap) ((UserState) r0).getAppIdDevicePermissionFlags().get(r1);
        if (r5 == null) goto L9;
        IndexedMap r6 = (IndexedMap) r5.get(r3);
    L10:
        int oldFlags = ((Number) IndexedMapExtensionsKt.getWithDefault(r6, r4, 0)).intValue();
        int newFlags = IntExtensionsKt.andInv(oldFlags, flagMask) | (flagValues & flagMask);
        if (oldFlags != newFlags) goto L13;
        return false;
    L13:
        MutableUserState r7 = MutableAccessState.mutateUserState$default($this$updatePermissionFlags.getNewState(), r2, 0, 2, null);
        Intrinsics.checkNotNull(r7);
        MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r8 = r7.mutateAppIdDevicePermissionFlags();
        Immutable it$iv = r8.mutate(r1);
        if (it$iv != null) goto L17;
        it$iv = new MutableIndexedReferenceMap(null, 1, null);
        r8.put(r1, it$iv);
    L17:
        MutableIndexedReferenceMap devicePermissionFlags = (MutableIndexedReferenceMap) it$iv;
        Immutable it$iv2 = devicePermissionFlags.mutate(r3);
        if (it$iv2 != null) goto L21;
        Immutable it$iv3 = new MutableIndexedMap(null, 1, null);
        devicePermissionFlags.put(r3, it$iv3);
        it$iv2 = it$iv3;
    L21:
        MutableIndexedMap permissionFlags = (MutableIndexedMap) it$iv2;
        IndexedMapExtensionsKt.putWithDefault(permissionFlags, r4, Integer.valueOf(newFlags), 0);
        if (permissionFlags.isEmpty() == false) goto L26;
        devicePermissionFlags.remove(r3);
        if (devicePermissionFlags.isEmpty() == false) goto L26;
        IntReferenceMapExtensionsKt.minusAssign(r8, r1);
    L26:
        IndexedListSet<OnDevicePermissionFlagsChangedListener> r14 = this.listeners;
        int oldFlags2 = 0;
        int newFlags2 = r14.getSize();
    L27:
        if (oldFlags2 >= newFlags2) goto L30;
        OnDevicePermissionFlagsChangedListener it = r14.elementAt(oldFlags2);
        int index$iv = oldFlags2;
        int index$iv2 = oldFlags;
        int newFlags3 = newFlags;
        it.onDevicePermissionFlagsChanged(r1, r2, r3, r4, index$iv2, newFlags3);
        oldFlags2 = index$iv + 1;
        oldFlags = index$iv2;
        newFlags = newFlags3;
        newFlags2 = newFlags2;
        r1 = appId;
        r3 = deviceId;
        r2 = userId;
        r4 = permissionName;
        goto L27
    L30:
        return true;
    L9:
        r6 = null;
        goto L10
    }

    public final void addOnPermissionFlagsChangedListener(OnDevicePermissionFlagsChangedListener listener) {
        Object r0 = this.listenersLock;
        monitor-enter(r0);
        this.listeners = IndexedListSetExtensionsKt.plus(this.listeners, listener);     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = DevicePermissionPolicy.class.getSimpleName();
    }
}
