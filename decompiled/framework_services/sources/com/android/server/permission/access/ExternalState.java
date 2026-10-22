package com.android.server.permission.access;

import com.android.server.SystemConfig;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntMap;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.IntSet;
import com.android.server.permission.access.immutable.MutableIndexedListSet;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableIntSet;
import com.android.server.permission.access.immutable.MutableReference;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.pkg.PackageState;
import java.util.Map;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ExternalState implements Immutable<MutableExternalState> {
    private final MutableReference<IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>, MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>> appIdPackageNamesReference;
    private Map<String, SystemConfig.PermissionEntry> configPermissions;
    private Map<String, ? extends PackageState> disabledSystemPackageStates;
    private IndexedMap<String, IndexedListSet<String>> implicitToSourcePermissions;
    private boolean isLeanback;
    private boolean isSystemReady;
    private IntMap<String[]> knownPackages;
    private Map<String, ? extends PackageState> packageStates;
    private PermissionAllowlist permissionAllowlist;
    private IndexedListSet<String> privilegedPermissionAllowlistPackages;
    private final MutableReference<IntSet, MutableIntSet> userIdsReference;

    public /* synthetic */ ExternalState(MutableReference r1, Map r2, Map r3, MutableReference r4, IntMap r5, boolean r6, Map r7, IndexedListSet r8, PermissionAllowlist r9, IndexedMap r10, boolean r11, DefaultConstructorMarker r12) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    private ExternalState(MutableReference<IntSet, MutableIntSet> r1, Map<String, ? extends PackageState> r2, Map<String, ? extends PackageState> r3, MutableReference<IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>, MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>> r4, IntMap<String[]> r5, boolean isLeanback, Map<String, SystemConfig.PermissionEntry> r7, IndexedListSet<String> r8, PermissionAllowlist permissionAllowlist, IndexedMap<String, IndexedListSet<String>> r10, boolean isSystemReady) {
        this.userIdsReference = r1;
        this.appIdPackageNamesReference = r4;
        this.packageStates = r2;
        this.disabledSystemPackageStates = r3;
        this.knownPackages = r5;
        this.isLeanback = isLeanback;
        this.configPermissions = r7;
        this.privilegedPermissionAllowlistPackages = r8;
        this.permissionAllowlist = permissionAllowlist;
        this.implicitToSourcePermissions = r10;
        this.isSystemReady = isSystemReady;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ MutableExternalState toMutable() {
        return toMutable();
    }

    public final MutableReference<IntSet, MutableIntSet> getUserIdsReference() {
        return this.userIdsReference;
    }

    public final MutableReference<IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>, MutableIntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>>> getAppIdPackageNamesReference() {
        return this.appIdPackageNamesReference;
    }

    public final IntSet getUserIds() {
        return (IntSet) this.userIdsReference.get();
    }

    public final Map<String, PackageState> getPackageStates() {
        return this.packageStates;
    }

    protected final void setPackageStates(Map<String, ? extends PackageState> r1) {
        this.packageStates = r1;
    }

    public final Map<String, PackageState> getDisabledSystemPackageStates() {
        return this.disabledSystemPackageStates;
    }

    protected final void setDisabledSystemPackageStates(Map<String, ? extends PackageState> r1) {
        this.disabledSystemPackageStates = r1;
    }

    public final IntReferenceMap<IndexedListSet<String>, MutableIndexedListSet<String>> getAppIdPackageNames() {
        return (IntReferenceMap) this.appIdPackageNamesReference.get();
    }

    public final IntMap<String[]> getKnownPackages() {
        return this.knownPackages;
    }

    protected final void setKnownPackages(IntMap<String[]> r1) {
        this.knownPackages = r1;
    }

    public final boolean isLeanback() {
        return this.isLeanback;
    }

    protected final void setLeanback(boolean r1) {
        this.isLeanback = r1;
    }

    public final Map<String, SystemConfig.PermissionEntry> getConfigPermissions() {
        return this.configPermissions;
    }

    protected final void setConfigPermissions(Map<String, SystemConfig.PermissionEntry> r1) {
        this.configPermissions = r1;
    }

    public final IndexedListSet<String> getPrivilegedPermissionAllowlistPackages() {
        return this.privilegedPermissionAllowlistPackages;
    }

    protected final void setPrivilegedPermissionAllowlistPackages(IndexedListSet<String> r1) {
        this.privilegedPermissionAllowlistPackages = r1;
    }

    public final PermissionAllowlist getPermissionAllowlist() {
        return this.permissionAllowlist;
    }

    protected final void setPermissionAllowlist(PermissionAllowlist r1) {
        this.permissionAllowlist = r1;
    }

    public final IndexedMap<String, IndexedListSet<String>> getImplicitToSourcePermissions() {
        return this.implicitToSourcePermissions;
    }

    protected final void setImplicitToSourcePermissions(IndexedMap<String, IndexedListSet<String>> r1) {
        this.implicitToSourcePermissions = r1;
    }

    public final boolean isSystemReady() {
        return this.isSystemReady;
    }

    protected final void setSystemReady(boolean r1) {
        this.isSystemReady = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableExternalState toMutable() {
        return new MutableExternalState(this);
    }
}
