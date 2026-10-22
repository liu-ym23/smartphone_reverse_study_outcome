package com.android.server.permission.access;

import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IndexedReferenceMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableReference;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class UserState implements WritableState, Immutable<MutableUserState> {
    private final MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> appIdAppOpModesReference;
    private final MutableReference<IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>, MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>> appIdDevicePermissionFlagsReference;
    private final MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> appIdPermissionFlagsReference;
    private String defaultPermissionGrantFingerprint;
    private final MutableReference<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> packageAppOpModesReference;
    private final MutableReference<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> packageVersionsReference;
    private int writeMode;

    public /* synthetic */ UserState(MutableReference r1, MutableReference r2, MutableReference r3, MutableReference r4, MutableReference r5, String r6, int r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    private UserState(MutableReference<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r1, MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r2, MutableReference<IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>, MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>> r3, MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r4, MutableReference<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> r5, String defaultPermissionGrantFingerprint, int writeMode) {
        this.packageVersionsReference = r1;
        this.appIdPermissionFlagsReference = r2;
        this.appIdDevicePermissionFlagsReference = r3;
        this.appIdAppOpModesReference = r4;
        this.packageAppOpModesReference = r5;
        this.defaultPermissionGrantFingerprint = defaultPermissionGrantFingerprint;
        this.writeMode = writeMode;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ MutableUserState toMutable() {
        return toMutable();
    }

    public final MutableReference<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> getPackageVersionsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.packageVersionsReference;
    }

    public final MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> getAppIdPermissionFlagsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.appIdPermissionFlagsReference;
    }

    public final MutableReference<IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>, MutableIntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>>> getAppIdDevicePermissionFlagsReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.appIdDevicePermissionFlagsReference;
    }

    public final MutableReference<IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> getAppIdAppOpModesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.appIdAppOpModesReference;
    }

    public final MutableReference<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> getPackageAppOpModesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.packageAppOpModesReference;
    }

    public final IndexedMap<String, Integer> getPackageVersions() {
        return (IndexedMap) this.packageVersionsReference.get();
    }

    public final IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> getAppIdPermissionFlags() {
        return (IntReferenceMap) this.appIdPermissionFlagsReference.get();
    }

    public final IntReferenceMap<IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>, MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>>> getAppIdDevicePermissionFlags() {
        return (IntReferenceMap) this.appIdDevicePermissionFlagsReference.get();
    }

    public final IntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> getAppIdAppOpModes() {
        return (IntReferenceMap) this.appIdAppOpModesReference.get();
    }

    public final IndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> getPackageAppOpModes() {
        return (IndexedReferenceMap) this.packageAppOpModesReference.get();
    }

    public final String getDefaultPermissionGrantFingerprint() {
        return this.defaultPermissionGrantFingerprint;
    }

    protected final void setDefaultPermissionGrantFingerprint(String r1) {
        this.defaultPermissionGrantFingerprint = r1;
    }

    @Override // com.android.server.permission.access.WritableState
    public int getWriteMode() {
        return this.writeMode;
    }

    protected void setWriteMode(int r1) {
        this.writeMode = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableUserState toMutable() {
        return new MutableUserState(this);
    }
}
