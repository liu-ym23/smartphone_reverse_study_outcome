package com.android.server.permission.access;

import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableReference;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableUserState extends UserState implements WritableState {
    private MutableUserState(MutableReference<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r10, MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r11, MutableReference<IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>, MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>> r12, MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r13, MutableReference<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r14, String defaultPermissionGrantFingerprint, int writeMode) {
        super(r10, r11, r12, r13, r14, defaultPermissionGrantFingerprint, writeMode, null);
    }

    public MutableUserState() {
        this(new MutableReference(new MutableIndexedMap(null, 1, null)), new MutableReference(new MutableIntReferenceMap(null, 1, null)), new MutableReference(new MutableIntReferenceMap(null, 1, null)), new MutableReference(new MutableIntReferenceMap(null, 1, null)), new MutableReference(new MutableIndexedReferenceMap(null, 1, null)), null, 0);
    }

    public MutableUserState(UserState userState) {
        this(userState.getPackageVersionsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), userState.getAppIdPermissionFlagsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), userState.getAppIdDevicePermissionFlagsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), userState.getAppIdAppOpModesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), userState.getPackageAppOpModesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), userState.getDefaultPermissionGrantFingerprint(), 0);
    }

    public final MutableIndexedMap<String, Integer> mutatePackageVersions() {
        return (MutableIndexedMap) getPackageVersionsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public final MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> mutateAppIdPermissionFlags() {
        return (MutableIntReferenceMap) getAppIdPermissionFlagsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public final MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> mutateAppIdDevicePermissionFlags() {
        return (MutableIntReferenceMap) getAppIdDevicePermissionFlagsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public final MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> mutateAppIdAppOpModes() {
        return (MutableIntReferenceMap) getAppIdAppOpModesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public final MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> mutatePackageAppOpModes() {
        return (MutableIndexedReferenceMap) getPackageAppOpModesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public final void setDefaultPermissionGrantFingerprintPublic(String defaultPermissionGrantFingerprint) {
        setDefaultPermissionGrantFingerprint(defaultPermissionGrantFingerprint);
    }

    public void requestWriteMode(int writeMode) {
        setWriteMode(Math.max(getWriteMode(), writeMode));
    }
}
