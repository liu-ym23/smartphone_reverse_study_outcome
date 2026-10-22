package com.android.server.permission.access;

import android.content.pm.PermissionGroupInfo;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableReference;
import com.android.server.permission.access.permission.Permission;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableSystemState extends SystemState implements WritableState {
    private MutableSystemState(MutableReference<IndexedMap<String, PermissionGroupInfo>, MutableIndexedMap<String, PermissionGroupInfo>> r7, MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> r8, MutableReference<IndexedMap<String, Permission>, MutableIndexedMap<String, Permission>> r9, int writeMode) {
        super(r7, r8, r9, writeMode, null);
    }

    public MutableSystemState() {
        this(new MutableReference(new MutableIndexedMap(null, 1, null)), new MutableReference(new MutableIndexedMap(null, 1, null)), new MutableReference(new MutableIndexedMap(null, 1, null)), 0);
    }

    public MutableSystemState(SystemState systemState) {
        this(systemState.getPermissionGroupsReference().toImmutable(), systemState.getPermissionTreesReference().toImmutable(), systemState.getPermissionsReference().toImmutable(), 0);
    }

    public final MutableIndexedMap<String, PermissionGroupInfo> mutatePermissionGroups() {
        return (MutableIndexedMap) getPermissionGroupsReference().mutate();
    }

    public final MutableIndexedMap<String, Permission> mutatePermissionTrees() {
        return (MutableIndexedMap) getPermissionTreesReference().mutate();
    }

    public final MutableIndexedMap<String, Permission> mutatePermissions() {
        return (MutableIndexedMap) getPermissionsReference().mutate();
    }

    public void requestWriteMode(int writeMode) {
        setWriteMode(Math.max(getWriteMode(), writeMode));
    }
}
