package com.android.server.pm.permission;

import android.content.pm.PackageManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class UidPermissionState {
    private boolean mMissing;
    private ArrayMap<String, PermissionState> mPermissions;

    public UidPermissionState() {
    }

    public UidPermissionState(UidPermissionState other) {
        this.mMissing = other.mMissing;
        if (other.mPermissions == null) goto L7;
        this.mPermissions = new ArrayMap();
        int permissionsSize = other.mPermissions.size();
        int i = 0;
    L5:
        if (i >= permissionsSize) goto L9;
        String name = other.mPermissions.keyAt(i);
        PermissionState permissionState = other.mPermissions.valueAt(i);
        this.mPermissions.put(name, new PermissionState(permissionState));
        i = i + 1;
        goto L5
    L9:
        return;
    }

    public void reset() {
        this.mMissing = false;
        this.mPermissions = null;
        invalidateCache();
    }

    public boolean isMissing() {
        return this.mMissing;
    }

    public void setMissing(boolean missing) {
        this.mMissing = missing;
    }

    @Deprecated
    public boolean hasPermissionState(String name) {
        if (this.mPermissions != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPermissions.containsKey(name) == false) goto L7;
        return true;
    }

    @Deprecated
    public boolean hasPermissionState(ArraySet<String> names) {
        if (this.mPermissions != null) goto L5;
        return false;
    L5:
        int namesSize = names.size();
        int i = 0;
    L6:
        if (i >= namesSize) goto L13;
        String name = names.valueAt(i);
        if (this.mPermissions.containsKey(name) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return true;
    L13:
        return false;
    }

    public PermissionState getPermissionState(String name) {
        if (this.mPermissions != null) goto L7;
        return null;
    L7:
        return this.mPermissions.get(name);
    }

    private PermissionState getOrCreatePermissionState(Permission permission) {
        if (this.mPermissions != null) goto L5;
        this.mPermissions = new ArrayMap();
    L5:
        String name = permission.getName();
        PermissionState permissionState = this.mPermissions.get(name);
        if (permissionState != null) goto L9;
        PermissionState permissionState2 = new PermissionState(permission);
        this.mPermissions.put(name, permissionState2);
        return permissionState2;
    L9:
        return permissionState;
    }

    public List<PermissionState> getPermissionStates() {
        if (this.mPermissions != null) goto L7;
        return Collections.emptyList();
    L7:
        return new ArrayList(this.mPermissions.values());
    }

    public void putPermissionState(Permission permission, boolean granted, int flags) {
        String name = permission.getName();
        if (this.mPermissions != null) goto L5;
        this.mPermissions = new ArrayMap();
    L6:
        PermissionState permissionState = new PermissionState(permission);
        if (granted == false) goto L9;
        permissionState.grant();
    L9:
        permissionState.updateFlags(flags, flags);
        this.mPermissions.put(name, permissionState);
        return;
    L5:
        this.mPermissions.remove(name);
        goto L6
    }

    public boolean removePermissionState(String name) {
        boolean changed = false;
        if (this.mPermissions != null) goto L6;
        return false;
    L6:
        if (this.mPermissions.remove(name) == null) goto L8;
        changed = true;
    L8:
        if (changed == true) goto L10;
    L12:
        return changed;
    L10:
        if (this.mPermissions.isEmpty() == false) goto L12;
        this.mPermissions = null;
        goto L12
    }

    public boolean isPermissionGranted(String name) {
        PermissionState permissionState = getPermissionState(name);
        if (permissionState != null) goto L5;
    L7:
        return false;
    L5:
        if (permissionState.isGranted() == false) goto L7;
        return true;
    }

    public Set<String> getGrantedPermissions() {
        if (this.mPermissions == null) goto L5;
        Set<String> permissions = new ArraySet(this.mPermissions.size());
        int permissionsSize = this.mPermissions.size();
        int i = 0;
    L7:
        if (i >= permissionsSize) goto L13;
        PermissionState permissionState = this.mPermissions.valueAt(i);
        if (permissionState.isGranted() == false) goto L11;
        permissions.add(permissionState.getName());
    L11:
        i = i + 1;
        goto L7
    L13:
        return permissions;
    L5:
        return Collections.emptySet();
    }

    public boolean grantPermission(Permission permission) {
        PermissionState permissionState = getOrCreatePermissionState(permission);
        return permissionState.grant();
    }

    public boolean revokePermission(Permission permission) {
        String name = permission.getName();
        PermissionState permissionState = getPermissionState(name);
        if (permissionState != null) goto L6;
        return false;
    L6:
        boolean changed = permissionState.revoke();
        if (changed == true) goto L9;
    L11:
        return changed;
    L9:
        if (permissionState.isDefault() == false) goto L11;
        removePermissionState(name);
        goto L11
    }

    public int getPermissionFlags(String name) {
        PermissionState permissionState = getPermissionState(name);
        if (permissionState != null) goto L7;
        return 0;
    L7:
        return permissionState.getFlags();
    }

    public boolean updatePermissionFlags(Permission permission, int flagMask, int flagValues) {
        if (flagMask != 0) goto L5;
        return false;
    L5:
        PermissionState permissionState = getOrCreatePermissionState(permission);
        boolean changed = permissionState.updateFlags(flagMask, flagValues);
        if (changed == true) goto L8;
    L10:
        return changed;
    L8:
        if (permissionState.isDefault() == false) goto L10;
        removePermissionState(permission.getName());
        goto L10
    }

    public boolean updatePermissionFlagsForAllPermissions(int flagMask, int flagValues) {
        if (flagMask != 0) goto L6;
        return false;
    L6:
        if (this.mPermissions != null) goto L8;
        return false;
    L8:
        boolean anyChanged = false;
        int i = this.mPermissions.size() - 1;
    L9:
        if (i < 0) goto L17;
        PermissionState permissionState = this.mPermissions.valueAt(i);
        boolean changed = permissionState.updateFlags(flagMask, flagValues);
        if (changed == false) goto L15;
        if (permissionState.isDefault() == false) goto L15;
        this.mPermissions.removeAt(i);
    L15:
        anyChanged = anyChanged | changed;
        i = i - 1;
        goto L9
    L17:
        return anyChanged;
    }

    public boolean isPermissionsReviewRequired() {
        if (this.mPermissions != null) goto L5;
        return false;
    L5:
        int permissionsSize = this.mPermissions.size();
        int i = 0;
    L6:
        if (i >= permissionsSize) goto L13;
        PermissionState permission = this.mPermissions.valueAt(i);
        if ((permission.getFlags() & 64) != 0) goto L9;
        i = i + 1;
        goto L6
    L9:
        return true;
    L13:
        return false;
    }

    public int[] computeGids(int[] globalGids, int userId) {
        IntArray gids = IntArray.wrap(globalGids);
        if (this.mPermissions == null) goto L5;
        int permissionsSize = this.mPermissions.size();
        int i = 0;
    L7:
        if (i >= permissionsSize) goto L16;
        PermissionState permissionState = this.mPermissions.valueAt(i);
        if (permissionState.isGranted() == false) goto L14;
        int[] permissionGids = permissionState.computeGids(userId);
        if (permissionGids.length == 0) goto L14;
        gids.addAll(permissionGids);
    L14:
        i = i + 1;
        goto L7
    L16:
        return gids.toArray();
    L5:
        return gids.toArray();
    }

    static void invalidateCache() {
        PackageManager.invalidatePackageInfoCache();
    }
}
