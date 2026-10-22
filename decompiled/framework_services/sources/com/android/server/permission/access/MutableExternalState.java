package com.android.server.permission.access;

import com.android.server.SystemConfig;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntSet;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableIntSet;
import com.android.server.permission.access.immutable.MutableReference;
import com.android.server.permission.jarjar.kotlin.collections.MapsKt;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.pkg.PackageState;
import java.util.Map;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableExternalState extends ExternalState {
    private MutableExternalState(MutableReference<IntSet, MutableIntSet> r14, Map<String, ? extends PackageState> r15, Map<String, ? extends PackageState> r16, MutableReference<IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>, MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>> r17, IntMap<String[]> r18, boolean isLeanback, Map<String, SystemConfig.PermissionEntry> r20, IndexedListSet<String> r21, PermissionAllowlist permissionAllowlist, IndexedMap<String, IndexedListSet<String>> r23, boolean isSystemReady) {
        super(r14, r15, r16, r17, r18, isLeanback, r20, r21, permissionAllowlist, r23, isSystemReady, null);
    }

    public MutableExternalState() {
        this(new MutableReference(new MutableIntSet(null, 1, null)), MapsKt.emptyMap(), MapsKt.emptyMap(), new MutableReference(new MutableIntReferenceMap(null, 1, null)), new MutableIntMap(null, 1, null), false, MapsKt.emptyMap(), new MutableIndexedListSet(null, 1, null), new PermissionAllowlist(), new MutableIndexedMap(null, 1, null), false);
    }

    public MutableExternalState(ExternalState externalState) {
        this(externalState.getUserIdsReference().toImmutable(), externalState.getPackageStates(), externalState.getDisabledSystemPackageStates(), externalState.getAppIdPackageNamesReference().toImmutable(), externalState.getKnownPackages(), externalState.isLeanback(), externalState.getConfigPermissions(), externalState.getPrivilegedPermissionAllowlistPackages(), externalState.getPermissionAllowlist(), externalState.getImplicitToSourcePermissions(), externalState.isSystemReady());
    }

    public final MutableIntSet mutateUserIds() {
        return (MutableIntSet) getUserIdsReference().mutate();
    }

    public final void setPackageStatesPublic(Map<String, ? extends PackageState> r1) {
        setPackageStates(r1);
    }

    public final void setDisabledSystemPackageStatesPublic(Map<String, ? extends PackageState> r1) {
        setDisabledSystemPackageStates(r1);
    }

    public final MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> mutateAppIdPackageNames() {
        return (MutableIntReferenceMap) getAppIdPackageNamesReference().mutate();
    }

    public final void setKnownPackagesPublic(IntMap<String[]> r1) {
        setKnownPackages(r1);
    }

    public final void setLeanbackPublic(boolean isLeanback) {
        setLeanback(isLeanback);
    }

    public final void setConfigPermissionsPublic(Map<String, SystemConfig.PermissionEntry> r1) {
        setConfigPermissions(r1);
    }

    public final void setPrivilegedPermissionAllowlistPackagesPublic(IndexedListSet<String> r1) {
        setPrivilegedPermissionAllowlistPackages(r1);
    }

    public final void setPermissionAllowlistPublic(PermissionAllowlist permissionAllowlist) {
        setPermissionAllowlist(permissionAllowlist);
    }

    public final void setImplicitToSourcePermissionsPublic(IndexedMap<String, IndexedListSet<String>> r1) {
        setImplicitToSourcePermissions(r1);
    }

    public final void setSystemReadyPublic(boolean isSystemReady) {
        setSystemReady(isSystemReady);
    }
}
