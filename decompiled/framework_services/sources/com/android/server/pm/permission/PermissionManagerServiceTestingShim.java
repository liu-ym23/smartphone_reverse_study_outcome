package com.android.server.pm.permission;

import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.os.Build;
import android.permission.IOnPermissionsChangeListener;
import android.permission.PermissionManager;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionManagerServiceTestingShim implements PermissionManagerServiceInterface {
    private PermissionManagerServiceInterface mNewImplementation;
    private PermissionManagerServiceInterface mOldImplementation;

    public PermissionManagerServiceTestingShim(PermissionManagerServiceInterface oldImpl, PermissionManagerServiceInterface newImpl) {
        this.mOldImplementation = oldImpl;
        this.mNewImplementation = newImpl;
    }

    private void signalImplDifference(String message) {
    }

    public byte[] backupRuntimePermissions(int userId) {
        byte[] oldVal = this.mOldImplementation.backupRuntimePermissions(userId);
        byte[] newVal = this.mNewImplementation.backupRuntimePermissions(userId);
        if (Arrays.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("backupRuntimePermissions");
    L5:
        return newVal;
    }

    public void restoreRuntimePermissions(byte[] backup, int userId) {
        this.mOldImplementation.backupRuntimePermissions(userId);
        this.mNewImplementation.backupRuntimePermissions(userId);
    }

    public void restoreDelayedRuntimePermissions(String packageName, int userId) {
        this.mOldImplementation.restoreDelayedRuntimePermissions(packageName, userId);
        this.mNewImplementation.restoreDelayedRuntimePermissions(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        this.mOldImplementation.dump(fd, pw, args);
        this.mNewImplementation.dump(fd, pw, args);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        List<PermissionGroupInfo> oldVal = this.mOldImplementation.getAllPermissionGroups(flags);
        List<PermissionGroupInfo> newVal = this.mNewImplementation.getAllPermissionGroups(flags);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getAllPermissionGroups");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionGroupInfo getPermissionGroupInfo(String groupName, int flags) {
        PermissionGroupInfo oldVal = this.mOldImplementation.getPermissionGroupInfo(groupName, flags);
        PermissionGroupInfo newVal = this.mNewImplementation.getPermissionGroupInfo(groupName, flags);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getPermissionGroupInfo");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionInfo getPermissionInfo(String permName, int flags, String opPackageName) {
        PermissionInfo oldVal = this.mOldImplementation.getPermissionInfo(permName, flags, opPackageName);
        PermissionInfo newVal = this.mNewImplementation.getPermissionInfo(permName, flags, opPackageName);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getPermissionInfo");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> queryPermissionsByGroup(String groupName, int flags) {
        List<PermissionInfo> oldVal = this.mOldImplementation.queryPermissionsByGroup(groupName, flags);
        List<PermissionInfo> newVal = this.mNewImplementation.queryPermissionsByGroup(groupName, flags);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("queryPermissionsByGroup");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addPermission(PermissionInfo info, boolean async) {
        boolean oldVal = this.mOldImplementation.addPermission(info, async);
        boolean newVal = this.mNewImplementation.addPermission(info, async);
        if (Objects.equals(Boolean.valueOf(oldVal), Boolean.valueOf(newVal)) == true) goto L5;
        signalImplDifference("addPermission");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removePermission(String permName) {
        this.mOldImplementation.removePermission(permName);
        this.mNewImplementation.removePermission(permName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionFlags(String packageName, String permName, String deviceId, int userId) {
        int oldVal = this.mOldImplementation.getPermissionFlags(packageName, permName, deviceId, userId);
        int newVal = this.mNewImplementation.getPermissionFlags(packageName, permName, deviceId, userId);
        if (Objects.equals(Integer.valueOf(oldVal), Integer.valueOf(newVal)) == true) goto L5;
        signalImplDifference("getPermissionFlags");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlags(String packageName, String permName, int flagMask, int flagValues, boolean checkAdjustPolicyFlagPermission, String deviceId, int userId) {
        this.mOldImplementation.updatePermissionFlags(packageName, permName, flagMask, flagValues, checkAdjustPolicyFlagPermission, deviceId, userId);
        this.mNewImplementation.updatePermissionFlags(packageName, permName, flagMask, flagValues, checkAdjustPolicyFlagPermission, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) {
        this.mOldImplementation.updatePermissionFlagsForAllApps(flagMask, flagValues, userId);
        this.mNewImplementation.updatePermissionFlagsForAllApps(flagMask, flagValues, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void addOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.mOldImplementation.addOnPermissionsChangeListener(listener);
        this.mNewImplementation.addOnPermissionsChangeListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removeOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.mOldImplementation.removeOnPermissionsChangeListener(listener);
        this.mNewImplementation.removeOnPermissionsChangeListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        boolean oldVal = this.mOldImplementation.addAllowlistedRestrictedPermission(packageName, permName, flags, userId);
        boolean newVal = this.mNewImplementation.addAllowlistedRestrictedPermission(packageName, permName, flags, userId);
        if (Objects.equals(Boolean.valueOf(oldVal), Boolean.valueOf(newVal)) == true) goto L5;
        signalImplDifference("addAllowlistedRestrictedPermission");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<String> getAllowlistedRestrictedPermissions(String packageName, int flags, int userId) {
        List<String> oldVal = this.mOldImplementation.getAllowlistedRestrictedPermissions(packageName, flags, userId);
        List<String> newVal = this.mNewImplementation.getAllowlistedRestrictedPermissions(packageName, flags, userId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getAllowlistedRestrictedPermissions");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean removeAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        boolean oldVal = this.mOldImplementation.removeAllowlistedRestrictedPermission(packageName, permName, flags, userId);
        boolean newVal = this.mNewImplementation.removeAllowlistedRestrictedPermission(packageName, permName, flags, userId);
        if (Objects.equals(Boolean.valueOf(oldVal), Boolean.valueOf(newVal)) == true) goto L5;
        signalImplDifference("removeAllowlistedRestrictedPermission");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void grantRuntimePermission(String packageName, String permName, String deviceId, int userId) {
        this.mOldImplementation.grantRuntimePermission(packageName, permName, deviceId, userId);
        this.mNewImplementation.grantRuntimePermission(packageName, permName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokeRuntimePermission(String packageName, String permName, String deviceId, int userId, String reason) {
        this.mOldImplementation.revokeRuntimePermission(packageName, permName, deviceId, userId, reason);
        this.mNewImplementation.revokeRuntimePermission(packageName, permName, deviceId, userId, reason);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokePostNotificationPermissionWithoutKillForTest(String packageName, int userId) {
        this.mOldImplementation.revokePostNotificationPermissionWithoutKillForTest(packageName, userId);
        this.mNewImplementation.revokePostNotificationPermissionWithoutKillForTest(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean shouldShowRequestPermissionRationale(String packageName, String permName, String deviceId, int userId) {
        boolean oldVal = this.mOldImplementation.shouldShowRequestPermissionRationale(packageName, permName, deviceId, userId);
        boolean newVal = this.mNewImplementation.shouldShowRequestPermissionRationale(packageName, permName, deviceId, userId);
        if (Objects.equals(Boolean.valueOf(oldVal), Boolean.valueOf(newVal)) == true) goto L5;
        signalImplDifference("shouldShowRequestPermissionRationale");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionRevokedByPolicy(String packageName, String permName, String deviceId, int userId) {
        boolean oldVal = this.mOldImplementation.isPermissionRevokedByPolicy(packageName, permName, deviceId, userId);
        boolean newVal = this.mNewImplementation.isPermissionRevokedByPolicy(packageName, permName, deviceId, userId);
        if (Objects.equals(Boolean.valueOf(oldVal), Boolean.valueOf(newVal)) == true) goto L5;
        signalImplDifference("isPermissionRevokedByPolicy");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<SplitPermissionInfoParcelable> getSplitPermissions() {
        List<SplitPermissionInfoParcelable> oldVal = this.mOldImplementation.getSplitPermissions();
        List<SplitPermissionInfoParcelable> newVal = this.mNewImplementation.getSplitPermissions();
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getSplitPermissions");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkPermission(String pkgName, String permName, String deviceId, int userId) {
        int oldVal = this.mOldImplementation.checkPermission(pkgName, permName, deviceId, userId);
        int newVal = this.mNewImplementation.checkPermission(pkgName, permName, deviceId, userId);
        if (Objects.equals(Integer.valueOf(oldVal), Integer.valueOf(newVal)) == true) goto L5;
        signalImplDifference("checkPermission");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkUidPermission(int uid, String permName, String deviceId) {
        int oldVal = this.mOldImplementation.checkUidPermission(uid, permName, deviceId);
        int newVal = this.mNewImplementation.checkUidPermission(uid, permName, deviceId);
        if (Objects.equals(Integer.valueOf(oldVal), Integer.valueOf(newVal)) == true) goto L5;
        signalImplDifference("checkUidPermission");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionRequestState(String packageName, String permName, int deviceId, String persistentDeviceId) {
        return this.mNewImplementation.getPermissionRequestState(packageName, permName, deviceId, persistentDeviceId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, PermissionManager.PermissionState> getAllPermissionStates(String packageName, String deviceId, int userId) {
        return this.mNewImplementation.getAllPermissionStates(packageName, deviceId, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, Set<String>> getAllAppOpPermissionPackages() {
        Map<String, Set<String>> oldVal = this.mOldImplementation.getAllAppOpPermissionPackages();
        Map<String, Set<String>> newVal = this.mNewImplementation.getAllAppOpPermissionPackages();
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getAllAppOpPermissionPackages");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionsReviewRequired(String packageName, int userId) {
        boolean oldVal = this.mOldImplementation.isPermissionsReviewRequired(packageName, userId);
        boolean newVal = this.mNewImplementation.isPermissionsReviewRequired(packageName, userId);
        if (Objects.equals(Boolean.valueOf(oldVal), Boolean.valueOf(newVal)) == true) goto L5;
        signalImplDifference("isPermissionsReviewRequired");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissions(AndroidPackage pkg, int userId, boolean restoreRuntimePermissions) {
        this.mOldImplementation.resetRuntimePermissions(pkg, userId, restoreRuntimePermissions);
        this.mNewImplementation.resetRuntimePermissions(pkg, userId, restoreRuntimePermissions);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissionsForUser(int userId) {
        this.mOldImplementation.resetRuntimePermissionsForUser(userId);
        this.mNewImplementation.resetRuntimePermissionsForUser(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionStateTEMP() {
        this.mOldImplementation.readLegacyPermissionStateTEMP();
        this.mNewImplementation.readLegacyPermissionStateTEMP();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionStateTEMP() {
        this.mOldImplementation.writeLegacyPermissionStateTEMP();
        this.mNewImplementation.writeLegacyPermissionStateTEMP();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getInstalledPermissions(String packageName) {
        Set<String> oldVal = this.mOldImplementation.getInstalledPermissions(packageName);
        Set<String> newVal = this.mNewImplementation.getInstalledPermissions(packageName);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getInstalledPermissions");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getGrantedPermissions(String packageName, int userId) {
        Set<String> oldVal = this.mOldImplementation.getGrantedPermissions(packageName, userId);
        Set<String> newVal = this.mNewImplementation.getGrantedPermissions(packageName, userId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getGrantedPermissions");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getPermissionGids(String permissionName, int userId) {
        int[] oldVal = this.mOldImplementation.getPermissionGids(permissionName, userId);
        int[] newVal = this.mNewImplementation.getPermissionGids(permissionName, userId);
        if (Arrays.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getPermissionGids");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String[] getAppOpPermissionPackages(String permissionName) {
        String[] oldVal = this.mOldImplementation.getAppOpPermissionPackages(permissionName);
        String[] newVal = this.mNewImplementation.getAppOpPermissionPackages(permissionName);
        if (Arrays.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getAppOpPermissionPackages");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Permission getPermissionTEMP(String permName) {
        Permission oldVal = this.mOldImplementation.getPermissionTEMP(permName);
        Permission newVal = this.mNewImplementation.getPermissionTEMP(permName);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getPermissionTEMP");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtection(int protection) {
        List<PermissionInfo> oldVal = this.mOldImplementation.getAllPermissionsWithProtection(protection);
        List<PermissionInfo> newVal = this.mNewImplementation.getAllPermissionsWithProtection(protection);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getAllPermissionsWithProtection");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtectionFlags(int protectionFlags) {
        List<PermissionInfo> oldVal = this.mOldImplementation.getAllPermissionsWithProtectionFlags(protectionFlags);
        List<PermissionInfo> newVal = this.mNewImplementation.getAllPermissionsWithProtectionFlags(protectionFlags);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getAllPermissionsWithProtectionFlags");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<LegacyPermission> getLegacyPermissions() {
        List<LegacyPermission> oldVal = this.mOldImplementation.getLegacyPermissions();
        List<LegacyPermission> newVal = this.mNewImplementation.getLegacyPermissions();
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getLegacyPermissions");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public LegacyPermissionState getLegacyPermissionState(int appId) {
        LegacyPermissionState oldVal = this.mOldImplementation.getLegacyPermissionState(appId);
        LegacyPermissionState newVal = this.mNewImplementation.getLegacyPermissionState(appId);
        if (Objects.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getLegacyPermissionState");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        this.mOldImplementation.readLegacyPermissionsTEMP(legacyPermissionSettings);
        this.mNewImplementation.readLegacyPermissionsTEMP(legacyPermissionSettings);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        this.mOldImplementation.writeLegacyPermissionsTEMP(legacyPermissionSettings);
        this.mNewImplementation.writeLegacyPermissionsTEMP(legacyPermissionSettings);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String getDefaultPermissionGrantFingerprint(int userId) {
        String oldVal = this.mOldImplementation.getDefaultPermissionGrantFingerprint(userId);
        String newVal = this.mNewImplementation.getDefaultPermissionGrantFingerprint(userId);
        if (Objects.equals(oldVal, Build.FINGERPRINT) == Objects.equals(newVal, Build.FINGERPRINT)) goto L5;
        signalImplDifference("getDefaultPermissionGrantFingerprint");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void setDefaultPermissionGrantFingerprint(String fingerprint, int userId) {
        this.mOldImplementation.setDefaultPermissionGrantFingerprint(fingerprint, userId);
        this.mNewImplementation.setDefaultPermissionGrantFingerprint(fingerprint, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onSystemReady() {
        this.mOldImplementation.onSystemReady();
        this.mNewImplementation.onSystemReady();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onStorageVolumeMounted(String volumeUuid, boolean fingerprintChanged) {
        this.mOldImplementation.onStorageVolumeMounted(volumeUuid, fingerprintChanged);
        this.mNewImplementation.onStorageVolumeMounted(volumeUuid, fingerprintChanged);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getGidsForUid(int uid) {
        int[] oldVal = this.mOldImplementation.getGidsForUid(uid);
        int[] newVal = this.mNewImplementation.getGidsForUid(uid);
        if (Arrays.equals(oldVal, newVal) == true) goto L5;
        signalImplDifference("getGidsForUid");
    L5:
        return newVal;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserCreated(int userId) {
        this.mOldImplementation.onUserCreated(userId);
        this.mNewImplementation.onUserCreated(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserRemoved(int userId) {
        this.mOldImplementation.onUserRemoved(userId);
        this.mNewImplementation.onUserRemoved(userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageAdded(PackageState pkg, boolean isInstantApp, AndroidPackage oldPkg) {
        this.mOldImplementation.onPackageAdded(pkg, isInstantApp, oldPkg);
        this.mNewImplementation.onPackageAdded(pkg, isInstantApp, oldPkg);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageInstalled(AndroidPackage pkg, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int userId) {
        this.mOldImplementation.onPackageInstalled(pkg, previousAppId, params, userId);
        this.mNewImplementation.onPackageInstalled(pkg, previousAppId, params, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageRemoved(AndroidPackage pkg) {
        this.mOldImplementation.onPackageRemoved(pkg);
        this.mNewImplementation.onPackageRemoved(pkg);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageUninstalled(String packageName, int appId, PackageState packageState, AndroidPackage pkg, List<AndroidPackage> sharedUserPkgs, int userId) {
        this.mOldImplementation.onPackageUninstalled(packageName, appId, packageState, pkg, sharedUserPkgs, userId);
        this.mNewImplementation.onPackageUninstalled(packageName, appId, packageState, pkg, sharedUserPkgs, userId);
    }
}
