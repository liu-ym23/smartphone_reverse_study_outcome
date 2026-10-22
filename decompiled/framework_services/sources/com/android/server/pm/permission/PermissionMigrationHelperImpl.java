package com.android.server.pm.permission;

import android.content.pm.PackageManagerInternal;
import android.util.ArrayMap;
import android.util.Log;
import com.android.permission.persistence.RuntimePermissionsState;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.SharedUserApi;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionMigrationHelperImpl implements PermissionMigrationHelper {
    private static final String LOG_TAG = null;

    public static /* synthetic */ void $r8$lambda$R5XTkidoyIxdkQIqDvyXrxPf8p4(PermissionMigrationHelperImpl r0, Map r1, Map r2, String r3, List r4) {
        r0.lambda$getLegacyPermissionStates$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$Z4y7L7x4Dc57nC4S5j8eQePbN08(PermissionMigrationHelperImpl r0, Map r1, Map r2, String r3, List r4) {
        r0.lambda$getLegacyPermissionStates$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$zNlyzYVYObN6604q1jplQmceyfs(Map r0, LegacyPermission r1) {
        lambda$toLegacyPermissions$0(r0, r1);
    }

    public PermissionMigrationHelperImpl() {
    }

    static {
        LOG_TAG = PermissionMigrationHelperImpl.class.getSimpleName();
    }

    @Override // com.android.server.pm.permission.PermissionMigrationHelper
    public boolean hasLegacyPermission() {
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        LegacyPermissionSettings legacySettings = packageManagerInternal.getLegacyPermissions();
        if (legacySettings.getPermissions().isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (legacySettings.getPermissionTrees().isEmpty() == false) goto L8;
        return false;
    }

    @Override // com.android.server.pm.permission.PermissionMigrationHelper
    public Map<String, PermissionMigrationHelper.LegacyPermission> getLegacyPermissions() {
        PackageManagerInternal mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        return toLegacyPermissions(mPackageManagerInternal.getLegacyPermissions().getPermissions());
    }

    @Override // com.android.server.pm.permission.PermissionMigrationHelper
    public Map<String, PermissionMigrationHelper.LegacyPermission> getLegacyPermissionTrees() {
        PackageManagerInternal mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        return toLegacyPermissions(mPackageManagerInternal.getLegacyPermissions().getPermissionTrees());
    }

    private Map<String, PermissionMigrationHelper.LegacyPermission> toLegacyPermissions(List<LegacyPermission> legacyPermissions) {
        final Map<String, PermissionMigrationHelper.LegacyPermission> permissions = new ArrayMap();
        legacyPermissions.forEach(new PermissionMigrationHelperImpl$$ExternalSyntheticLambda0(permissions));
        return permissions;
    }

    private static /* synthetic */ void lambda$toLegacyPermissions$0(Map permissions, LegacyPermission legacyPermission) {
        PermissionMigrationHelper.LegacyPermission permission = new PermissionMigrationHelper.LegacyPermission(legacyPermission.getPermissionInfo(), legacyPermission.getType());
        permissions.put(legacyPermission.getPermissionInfo().name, permission);
    }

    @Override // com.android.server.pm.permission.PermissionMigrationHelper
    public Map<Integer, Map<String, PermissionMigrationHelper.LegacyPermissionState>> getLegacyPermissionStates(int userId) {
        PackageManagerInternal mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        final Map<Integer, Map<String, PermissionMigrationHelper.LegacyPermissionState>> appIdPermissionStates = new ArrayMap();
        RuntimePermissionsState legacyState = (RuntimePermissionsState) mPackageManagerInternal.getLegacyPermissionsState(userId);
        PackageManagerLocal packageManagerLocal = (PackageManagerLocal) LocalManagerRegistry.getManager(PackageManagerLocal.class);
        PackageManagerLocal.UnfilteredSnapshot snapshot = packageManagerLocal.withUnfilteredSnapshot();
        final Map<String, PackageState> packageStates = snapshot.getPackageStates();     // Catch: Throwable -> L6
        legacyState.getPackagePermissions().forEach(new PermissionMigrationHelperImpl$$ExternalSyntheticLambda1(this, packageStates, appIdPermissionStates));     // Catch: Throwable -> L6
        final Map<String, SharedUserApi> sharedUsers = snapshot.getSharedUsers();     // Catch: Throwable -> L6
        legacyState.getSharedUserPermissions().forEach(new PermissionMigrationHelperImpl$$ExternalSyntheticLambda2(this, sharedUsers, appIdPermissionStates));     // Catch: Throwable -> L6
        snapshot.close();
        return appIdPermissionStates;
    L6:
        th = move-exception;
        if (snapshot != null) goto L15;
    L12:
        throw th;
    L15:
        snapshot.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    private /* synthetic */ void lambda$getLegacyPermissionStates$1(Map packageStates, Map appIdPermissionStates, String packageName, List permissionStates) {
        if (permissionStates.isEmpty() == true) goto L9;
        PackageState packageState = (PackageState) packageStates.get(packageName);
        if (packageState == null) goto L7;
        int appId = packageState.getAppId();
        appIdPermissionStates.put(Integer.valueOf(appId), toLegacyPermissionStates(permissionStates));
        return;
    L7:
        Log.w(LOG_TAG, "Package " + packageName + " not found.");
        return;
    }

    private /* synthetic */ void lambda$getLegacyPermissionStates$2(Map sharedUsers, Map appIdPermissionStates, String sharedUserName, List permissionStates) {
        if (permissionStates.isEmpty() == true) goto L9;
        SharedUserApi sharedUser = (SharedUserApi) sharedUsers.get(sharedUserName);
        if (sharedUser == null) goto L7;
        int appId = sharedUser.getAppId();
        appIdPermissionStates.put(Integer.valueOf(appId), toLegacyPermissionStates(permissionStates));
        return;
    L7:
        Log.w(LOG_TAG, "Shared user " + sharedUserName + " not found.");
        return;
    }

    @Override // com.android.server.pm.permission.PermissionMigrationHelper
    public int getLegacyPermissionStateVersion(int userId) {
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int version = packageManagerInternal.getLegacyPermissionsVersion(userId);
        switch(version) {
            case -1: goto L7;
            case 0: goto L5;
            default: goto L4;
        };
    L4:
        return version;
    L5:
        return -1;
    L7:
        return 0;
    }

    @Override // com.android.server.pm.permission.PermissionMigrationHelper
    public boolean hasLegacyPermissionState(int userId) {
        if (getLegacyPermissionStateVersion(userId) <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private Map<String, PermissionMigrationHelper.LegacyPermissionState> toLegacyPermissionStates(List<RuntimePermissionsState.PermissionState> permissions) {
        Map<String, PermissionMigrationHelper.LegacyPermissionState> legacyPermissions = new ArrayMap();
        int size = permissions.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        RuntimePermissionsState.PermissionState permState = permissions.get(i);
        legacyPermissions.put(permState.getName(), new PermissionMigrationHelper.LegacyPermissionState(permState.isGranted(), permState.getFlags()));
        i = i + 1;
        goto L3
    L6:
        return legacyPermissions;
    }
}
