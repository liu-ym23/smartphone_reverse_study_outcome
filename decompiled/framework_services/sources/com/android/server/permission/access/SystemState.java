package com.android.server.permission.access;

import android.content.pm.PermissionGroupInfo;
import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableReference;
import com.android.server.permission.access.permission.Permission;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SystemState implements WritableState, Immutable<MutableSystemState> {
    private final MutableReference<IndexedMap<String, PermissionGroupInfo>, MutableIndexedMap<String, PermissionGroupInfo>> permissionGroupsReference;
    private final MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> permissionTreesReference;
    private final MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> permissionsReference;
    private int writeMode;

    public /* synthetic */ SystemState(MutableReference r1, MutableReference r2, MutableReference r3, int r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    private SystemState(MutableReference<IndexedMap<String, PermissionGroupInfo>, MutableIndexedMap<String, PermissionGroupInfo>> r1, MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> r2, MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> r3, int writeMode) {
        this.permissionGroupsReference = r1;
        this.permissionTreesReference = r2;
        this.permissionsReference = r3;
        this.writeMode = writeMode;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ MutableSystemState toMutable() {
        return toMutable();
    }

    public final MutableReference<IndexedMap<String, PermissionGroupInfo>, MutableIndexedMap<String, PermissionGroupInfo>> getPermissionGroupsReference() {
        return this.permissionGroupsReference;
    }

    public final MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> getPermissionTreesReference() {
        return this.permissionTreesReference;
    }

    public final MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> getPermissionsReference() {
        return this.permissionsReference;
    }

    public final IndexedMap<String, PermissionGroupInfo> getPermissionGroups() {
        return (IndexedMap) this.permissionGroupsReference.get();
    }

    public final IndexedMap<String, Permission> getPermissionTrees() {
        return (IndexedMap) this.permissionTreesReference.get();
    }

    public final IndexedMap<String, Permission> getPermissions() {
        return (IndexedMap) this.permissionsReference.get();
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
    public MutableSystemState toMutable() {
        return new MutableSystemState(this);
    }
}
