package com.android.server.pm.permission;

import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.permission.IOnPermissionsChangeListener;
import android.permission.PermissionManager;
import android.util.Log;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionManagerServiceLoggingDecorator implements PermissionManagerServiceInterface {
    private static final String LOG_TAG = null;
    private final PermissionManagerServiceInterface mService;

    static {
        LOG_TAG = PermissionManagerServiceLoggingDecorator.class.getSimpleName();
    }

    public PermissionManagerServiceLoggingDecorator(PermissionManagerServiceInterface service) {
        this.mService = service;
    }

    public byte[] backupRuntimePermissions(int userId) {
        Log.i(LOG_TAG, "backupRuntimePermissions(userId = " + userId + ")");
        return this.mService.backupRuntimePermissions(userId);
    }

    public void restoreRuntimePermissions(byte[] backup, int userId) {
        Log.i(LOG_TAG, "restoreRuntimePermissions(backup = " + backup + ", userId = " + userId + ")");
        this.mService.restoreRuntimePermissions(backup, userId);
    }

    public void restoreDelayedRuntimePermissions(String packageName, int userId) {
        Log.i(LOG_TAG, "restoreDelayedRuntimePermissions(packageName = " + packageName + ", userId = " + userId + ")");
        this.mService.restoreDelayedRuntimePermissions(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Log.i(LOG_TAG, "dump(fd = " + fd + ", pw = " + pw + ", args = " + Arrays.toString(args) + ")");
        this.mService.dump(fd, pw, args);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        Log.i(LOG_TAG, "getAllPermissionGroups(flags = " + flags + ")");
        return this.mService.getAllPermissionGroups(flags);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionGroupInfo getPermissionGroupInfo(String groupName, int flags) {
        Log.i(LOG_TAG, "getPermissionGroupInfo(groupName = " + groupName + ", flags = " + flags + ")");
        return this.mService.getPermissionGroupInfo(groupName, flags);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionInfo getPermissionInfo(String permName, int flags, String opPackageName) {
        Log.i(LOG_TAG, "getPermissionInfo(permName = " + permName + ", flags = " + flags + ", opPackageName = " + opPackageName + ")");
        return this.mService.getPermissionInfo(permName, flags, opPackageName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> queryPermissionsByGroup(String groupName, int flags) {
        Log.i(LOG_TAG, "queryPermissionsByGroup(groupName = " + groupName + ", flags = " + flags + ")");
        return this.mService.queryPermissionsByGroup(groupName, flags);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addPermission(PermissionInfo info, boolean async) {
        Log.i(LOG_TAG, "addPermission(info = " + info + ", async = " + async + ")");
        return this.mService.addPermission(info, async);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removePermission(String permName) {
        Log.i(LOG_TAG, "removePermission(permName = " + permName + ")");
        this.mService.removePermission(permName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionFlags(String packageName, String permName, String deviceId, int userId) {
        Log.i(LOG_TAG, "getPermissionFlags(packageName = " + packageName + ", permName = " + permName + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        return this.mService.getPermissionFlags(packageName, permName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlags(String packageName, String permName, int flagMask, int flagValues, boolean checkAdjustPolicyFlagPermission, String deviceId, int userId) {
        Log.i(LOG_TAG, "updatePermissionFlags(packageName = " + packageName + ", permName = " + permName + ", flagMask = " + flagMask + ", flagValues = " + flagValues + ", checkAdjustPolicyFlagPermission = " + checkAdjustPolicyFlagPermission + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        this.mService.updatePermissionFlags(packageName, permName, flagMask, flagValues, checkAdjustPolicyFlagPermission, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) {
        Log.i(LOG_TAG, "updatePermissionFlagsForAllApps(flagMask = " + flagMask + ", flagValues = " + flagValues + ", userId = " + userId + ")");
        this.mService.updatePermissionFlagsForAllApps(flagMask, flagValues, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void addOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        Log.i(LOG_TAG, "addOnPermissionsChangeListener(listener = " + listener + ")");
        this.mService.addOnPermissionsChangeListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removeOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        Log.i(LOG_TAG, "removeOnPermissionsChangeListener(listener = " + listener + ")");
        this.mService.removeOnPermissionsChangeListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        Log.i(LOG_TAG, "addAllowlistedRestrictedPermission(packageName = " + packageName + ", permName = " + permName + ", flags = " + flags + ", userId = " + userId + ")");
        return this.mService.addAllowlistedRestrictedPermission(packageName, permName, flags, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<String> getAllowlistedRestrictedPermissions(String packageName, int flags, int userId) {
        Log.i(LOG_TAG, "getAllowlistedRestrictedPermissions(packageName = " + packageName + ", flags = " + flags + ", userId = " + userId + ")");
        return this.mService.getAllowlistedRestrictedPermissions(packageName, flags, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean removeAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        Log.i(LOG_TAG, "removeAllowlistedRestrictedPermission(packageName = " + packageName + ", permName = " + permName + ", flags = " + flags + ", userId = " + userId + ")");
        return this.mService.removeAllowlistedRestrictedPermission(packageName, permName, flags, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void grantRuntimePermission(String packageName, String permName, String deviceId, int userId) {
        Log.i(LOG_TAG, "grantRuntimePermission(packageName = " + packageName + ", permName = " + permName + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        this.mService.grantRuntimePermission(packageName, permName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokeRuntimePermission(String packageName, String permName, String deviceId, int userId, String reason) {
        Log.i(LOG_TAG, "revokeRuntimePermission(packageName = " + packageName + ", permName = " + permName + ", deviceId = " + deviceId + ", userId = " + userId + ", reason = " + reason + ")");
        this.mService.revokeRuntimePermission(packageName, permName, deviceId, userId, reason);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokePostNotificationPermissionWithoutKillForTest(String packageName, int userId) {
        Log.i(LOG_TAG, "revokePostNotificationPermissionWithoutKillForTest(packageName = " + packageName + ", userId = " + userId + ")");
        this.mService.revokePostNotificationPermissionWithoutKillForTest(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean shouldShowRequestPermissionRationale(String packageName, String permName, String deviceId, int userId) {
        Log.i(LOG_TAG, "shouldShowRequestPermissionRationale(packageName = " + packageName + ", permName = " + permName + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        return this.mService.shouldShowRequestPermissionRationale(packageName, permName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionRevokedByPolicy(String packageName, String permName, String deviceId, int userId) {
        Log.i(LOG_TAG, "isPermissionRevokedByPolicy(packageName = " + packageName + ", permName = " + permName + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        return this.mService.isPermissionRevokedByPolicy(packageName, permName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<SplitPermissionInfoParcelable> getSplitPermissions() {
        Log.i(LOG_TAG, "getSplitPermissions()");
        return this.mService.getSplitPermissions();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkPermission(String pkgName, String permName, String deviceId, int userId) {
        Log.i(LOG_TAG, "checkPermission(pkgName = " + pkgName + ", permName = " + permName + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        return this.mService.checkPermission(pkgName, permName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkUidPermission(int uid, String permName, String deviceId) {
        Log.i(LOG_TAG, "checkUidPermission(uid = " + uid + ", permName = " + permName + ", deviceId = " + deviceId + ")");
        return this.mService.checkUidPermission(uid, permName, deviceId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionRequestState(String packageName, String permName, int deviceId, String persistentDeviceId) {
        Log.i(LOG_TAG, "checkUidPermissionState(permName = " + permName + ", deviceId = " + persistentDeviceId + ", packageName = " + packageName + ")");
        return this.mService.getPermissionRequestState(packageName, permName, deviceId, persistentDeviceId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, PermissionManager.PermissionState> getAllPermissionStates(String packageName, String deviceId, int userId) {
        Log.i(LOG_TAG, "getAllPermissionStates(packageName = " + packageName + ", deviceId = " + deviceId + ", userId = " + userId + ")");
        return this.mService.getAllPermissionStates(packageName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, Set<String>> getAllAppOpPermissionPackages() {
        Log.i(LOG_TAG, "getAllAppOpPermissionPackages()");
        return this.mService.getAllAppOpPermissionPackages();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionsReviewRequired(String packageName, int userId) {
        Log.i(LOG_TAG, "isPermissionsReviewRequired(packageName = " + packageName + ", userId = " + userId + ")");
        return this.mService.isPermissionsReviewRequired(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissions(AndroidPackage pkg, int userId, boolean shouldRestorePregrants) {
        Log.i(LOG_TAG, "resetRuntimePermissions(pkg = " + pkg + ", userId = " + userId + "shouldRestorePregrants: " + shouldRestorePregrants + ")");
        this.mService.resetRuntimePermissions(pkg, userId, shouldRestorePregrants);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissionsForUser(int userId) {
        Log.i(LOG_TAG, "resetRuntimePermissionsForUser(userId = " + userId + ")");
        this.mService.resetRuntimePermissionsForUser(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionStateTEMP() {
        Log.i(LOG_TAG, "readLegacyPermissionStateTEMP()");
        this.mService.readLegacyPermissionStateTEMP();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionStateTEMP() {
        Log.i(LOG_TAG, "writeLegacyPermissionStateTEMP()");
        this.mService.writeLegacyPermissionStateTEMP();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getInstalledPermissions(String packageName) {
        Log.i(LOG_TAG, "getInstalledPermissions(packageName = " + packageName + ")");
        return this.mService.getInstalledPermissions(packageName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getGrantedPermissions(String packageName, int userId) {
        Log.i(LOG_TAG, "getGrantedPermissions(packageName = " + packageName + ", userId = " + userId + ")");
        return this.mService.getGrantedPermissions(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getPermissionGids(String permissionName, int userId) {
        Log.i(LOG_TAG, "getPermissionGids(permissionName = " + permissionName + ", userId = " + userId + ")");
        return this.mService.getPermissionGids(permissionName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String[] getAppOpPermissionPackages(String permissionName) {
        Log.i(LOG_TAG, "getAppOpPermissionPackages(permissionName = " + permissionName + ")");
        return this.mService.getAppOpPermissionPackages(permissionName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Permission getPermissionTEMP(String permName) {
        Log.i(LOG_TAG, "getPermissionTEMP(permName = " + permName + ")");
        return this.mService.getPermissionTEMP(permName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtection(int protection) {
        Log.i(LOG_TAG, "getAllPermissionsWithProtection(protection = " + protection + ")");
        return this.mService.getAllPermissionsWithProtection(protection);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtectionFlags(int protectionFlags) {
        Log.i(LOG_TAG, "getAllPermissionsWithProtectionFlags(protectionFlags = " + protectionFlags + ")");
        return this.mService.getAllPermissionsWithProtectionFlags(protectionFlags);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<LegacyPermission> getLegacyPermissions() {
        Log.i(LOG_TAG, "getLegacyPermissions()");
        return this.mService.getLegacyPermissions();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public LegacyPermissionState getLegacyPermissionState(int appId) {
        Log.i(LOG_TAG, "getLegacyPermissionState(appId = " + appId + ")");
        return this.mService.getLegacyPermissionState(appId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        Log.i(LOG_TAG, "readLegacyPermissionsTEMP(legacyPermissionSettings = " + legacyPermissionSettings + ")");
        this.mService.readLegacyPermissionsTEMP(legacyPermissionSettings);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        Log.i(LOG_TAG, "writeLegacyPermissionsTEMP(legacyPermissionSettings = " + legacyPermissionSettings + ")");
        this.mService.writeLegacyPermissionsTEMP(legacyPermissionSettings);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String getDefaultPermissionGrantFingerprint(int userId) {
        Log.i(LOG_TAG, "getDefaultPermissionGrantFingerprint(userId = " + userId + ")");
        return this.mService.getDefaultPermissionGrantFingerprint(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void setDefaultPermissionGrantFingerprint(String fingerprint, int userId) {
        Log.i(LOG_TAG, "setDefaultPermissionGrantFingerprint(fingerprint = " + fingerprint + ", userId = " + userId + ")");
        this.mService.setDefaultPermissionGrantFingerprint(fingerprint, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onSystemReady() {
        Log.i(LOG_TAG, "onSystemReady()");
        this.mService.onSystemReady();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onStorageVolumeMounted(String volumeUuid, boolean fingerprintChanged) {
        Log.i(LOG_TAG, "onStorageVolumeMounted(volumeUuid = " + volumeUuid + ", fingerprintChanged = " + fingerprintChanged + ")");
        this.mService.onStorageVolumeMounted(volumeUuid, fingerprintChanged);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getGidsForUid(int uid) {
        Log.i(LOG_TAG, "getGidsForUid(uid = " + uid + ")");
        return this.mService.getGidsForUid(uid);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserCreated(int userId) {
        Log.i(LOG_TAG, "onUserCreated(userId = " + userId + ")");
        this.mService.onUserCreated(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserRemoved(int userId) {
        Log.i(LOG_TAG, "onUserRemoved(userId = " + userId + ")");
        this.mService.onUserRemoved(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageAdded(PackageState packageState, boolean isInstantApp, AndroidPackage oldPkg) {
        Log.i(LOG_TAG, "onPackageAdded(packageState = " + packageState + ", isInstantApp = " + isInstantApp + ", oldPkg = " + oldPkg + ")");
        this.mService.onPackageAdded(packageState, isInstantApp, oldPkg);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageInstalled(AndroidPackage pkg, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int userId) {
        Log.i(LOG_TAG, "onPackageInstalled(pkg = " + pkg + ", previousAppId = " + previousAppId + ", params = " + params + ", userId = " + userId + ")");
        this.mService.onPackageInstalled(pkg, previousAppId, params, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageRemoved(AndroidPackage pkg) {
        Log.i(LOG_TAG, "onPackageRemoved(pkg = " + pkg + ")");
        this.mService.onPackageRemoved(pkg);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageUninstalled(String packageName, int appId, PackageState packageState, AndroidPackage pkg, List<AndroidPackage> sharedUserPkgs, int userId) {
        Log.i(LOG_TAG, "onPackageUninstalled(packageName = " + packageName + ", appId = " + appId + ", packageState = " + packageState + ", pkg = " + pkg + ", sharedUserPkgs = " + sharedUserPkgs + ", userId = " + userId + ")");
        this.mService.onPackageUninstalled(packageName, appId, packageState, pkg, sharedUserPkgs, userId);
    }
}
