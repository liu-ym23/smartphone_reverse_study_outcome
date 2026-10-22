package com.android.server.pm.permission;

import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.internal.pm.pkg.component.ParsedPermissionGroup;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionRegistry {
    private final ArrayMap<String, ArraySet<String>> mAppOpPermissionPackages;
    private final ArrayMap<String, ParsedPermissionGroup> mPermissionGroups;
    private final ArrayMap<String, Permission> mPermissionTrees;
    private final ArrayMap<String, Permission> mPermissions;

    public PermissionRegistry() {
        this.mPermissions = new ArrayMap();
        this.mPermissionTrees = new ArrayMap();
        this.mPermissionGroups = new ArrayMap();
        this.mAppOpPermissionPackages = new ArrayMap();
    }

    public Collection<Permission> getPermissions() {
        return this.mPermissions.values();
    }

    public Permission getPermission(String permissionName) {
        return this.mPermissions.get(permissionName);
    }

    public void addPermission(Permission permission) {
        this.mPermissions.put(permission.getName(), permission);
    }

    public void removePermission(String permissionName) {
        this.mPermissions.remove(permissionName);
    }

    public Collection<Permission> getPermissionTrees() {
        return this.mPermissionTrees.values();
    }

    public Permission getPermissionTree(String permissionTreeName) {
        return this.mPermissionTrees.get(permissionTreeName);
    }

    public void addPermissionTree(Permission permissionTree) {
        this.mPermissionTrees.put(permissionTree.getName(), permissionTree);
    }

    public void transferPermissions(String oldPackageName, String newPackageName) {
        int i = 0;
    L4:
        if (i >= 2) goto L14;
        if (i != 0) goto L7;
        ArrayMap<String, Permission> permissions = this.mPermissionTrees;
    L8:
        Iterator<Permission> r2 = permissions.values().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        Permission permission = r2.next();
        permission.transfer(oldPackageName, newPackageName);
        goto L10
    L12:
        i = i + 1;
        goto L4
    L7:
        permissions = this.mPermissions;
        goto L8
    }

    public Collection<ParsedPermissionGroup> getPermissionGroups() {
        return this.mPermissionGroups.values();
    }

    public ParsedPermissionGroup getPermissionGroup(String permissionGroupName) {
        return this.mPermissionGroups.get(permissionGroupName);
    }

    public void addPermissionGroup(ParsedPermissionGroup permissionGroup) {
        this.mPermissionGroups.put(permissionGroup.getName(), permissionGroup);
    }

    public ArrayMap<String, ArraySet<String>> getAllAppOpPermissionPackages() {
        return this.mAppOpPermissionPackages;
    }

    public ArraySet<String> getAppOpPermissionPackages(String permissionName) {
        return this.mAppOpPermissionPackages.get(permissionName);
    }

    public void addAppOpPermissionPackage(String permissionName, String packageName) {
        ArraySet<String> packageNames = this.mAppOpPermissionPackages.get(permissionName);
        if (packageNames != null) goto L5;
        packageNames = new ArraySet();
        this.mAppOpPermissionPackages.put(permissionName, packageNames);
    L5:
        packageNames.add(packageName);
    }

    public void removeAppOpPermissionPackage(String permissionName, String packageName) {
        ArraySet<String> packageNames = this.mAppOpPermissionPackages.get(permissionName);
        if (packageNames != null) goto L5;
        return;
    L5:
        boolean removed = packageNames.remove(packageName);
        if (removed == true) goto L8;
        return;
    L8:
        if (packageNames.isEmpty() == false) goto L12;
        this.mAppOpPermissionPackages.remove(permissionName);
        return;
    }

    public Permission enforcePermissionTree(String permissionName, int callingUid) {
        return Permission.enforcePermissionTree(this.mPermissionTrees.values(), permissionName, callingUid);
    }
}
