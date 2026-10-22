package com.android.server.pm.permission;

import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.os.Trace;
import android.permission.IOnPermissionsChangeListener;
import android.permission.PermissionManager;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionManagerServiceTracingDecorator implements PermissionManagerServiceInterface {
    private static final long TRACE_TAG = 262144;
    private final PermissionManagerServiceInterface mService;

    public PermissionManagerServiceTracingDecorator(PermissionManagerServiceInterface service) {
        this.mService = service;
    }

    public byte[] backupRuntimePermissions(int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#backupRuntimePermissions");
        byte[] r0 = this.mService.backupRuntimePermissions(userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    public void restoreRuntimePermissions(byte[] backup, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#restoreRuntimePermissions");
        this.mService.restoreRuntimePermissions(backup, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    public void restoreDelayedRuntimePermissions(String packageName, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#restoreDelayedRuntimePermissions");
        this.mService.restoreDelayedRuntimePermissions(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#dump");
        this.mService.dump(fd, pw, args);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAllPermissionGroups");
        List<PermissionGroupInfo> r0 = this.mService.getAllPermissionGroups(flags);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionGroupInfo getPermissionGroupInfo(String groupName, int flags) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getPermissionGroupInfo");
        PermissionGroupInfo r0 = this.mService.getPermissionGroupInfo(groupName, flags);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionInfo getPermissionInfo(String permName, int flags, String opPackageName) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getPermissionInfo");
        PermissionInfo r0 = this.mService.getPermissionInfo(permName, flags, opPackageName);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> queryPermissionsByGroup(String groupName, int flags) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#queryPermissionsByGroup");
        List<PermissionInfo> r0 = this.mService.queryPermissionsByGroup(groupName, flags);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addPermission(PermissionInfo info, boolean async) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#addPermission");
        boolean r0 = this.mService.addPermission(info, async);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removePermission(String permName) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#removePermission");
        this.mService.removePermission(permName);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionFlags(String packageName, String permName, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getPermissionFlags");
        int r0 = this.mService.getPermissionFlags(packageName, permName, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlags(String packageName, String permName, int flagMask, int flagValues, boolean checkAdjustPolicyFlagPermission, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#updatePermissionFlags");
        this.mService.updatePermissionFlags(packageName, permName, flagMask, flagValues, checkAdjustPolicyFlagPermission, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#updatePermissionFlagsForAllApps");
        this.mService.updatePermissionFlagsForAllApps(flagMask, flagValues, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void addOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#addOnPermissionsChangeListener");
        this.mService.addOnPermissionsChangeListener(listener);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removeOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#removeOnPermissionsChangeListener");
        this.mService.removeOnPermissionsChangeListener(listener);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#addAllowlistedRestrictedPermission");
        boolean r0 = this.mService.addAllowlistedRestrictedPermission(packageName, permName, flags, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<String> getAllowlistedRestrictedPermissions(String packageName, int flags, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAllowlistedRestrictedPermissions");
        List<String> r0 = this.mService.getAllowlistedRestrictedPermissions(packageName, flags, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean removeAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#removeAllowlistedRestrictedPermission");
        boolean r0 = this.mService.removeAllowlistedRestrictedPermission(packageName, permName, flags, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void grantRuntimePermission(String packageName, String permName, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#grantRuntimePermission");
        this.mService.grantRuntimePermission(packageName, permName, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokeRuntimePermission(String packageName, String permName, String deviceId, int userId, String reason) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#revokeRuntimePermission");
        this.mService.revokeRuntimePermission(packageName, permName, deviceId, userId, reason);     // Catch: Throwable -> L8
        Trace.traceEnd(TRACE_TAG);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Trace.traceEnd(TRACE_TAG);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokePostNotificationPermissionWithoutKillForTest(String packageName, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#revokePostNotificationPermissionWithoutKillForTest");
        this.mService.revokePostNotificationPermissionWithoutKillForTest(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean shouldShowRequestPermissionRationale(String packageName, String permName, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#shouldShowRequestPermissionRationale");
        boolean r0 = this.mService.shouldShowRequestPermissionRationale(packageName, permName, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionRevokedByPolicy(String packageName, String permName, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#isPermissionRevokedByPolicy");
        boolean r0 = this.mService.isPermissionRevokedByPolicy(packageName, permName, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<SplitPermissionInfoParcelable> getSplitPermissions() {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getSplitPermissions");
        List<SplitPermissionInfoParcelable> r0 = this.mService.getSplitPermissions();     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkPermission(String pkgName, String permName, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#checkPermission");
        int r0 = this.mService.checkPermission(pkgName, permName, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkUidPermission(int uid, String permName, String deviceId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#checkUidPermission");
        int r0 = this.mService.checkUidPermission(uid, permName, deviceId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionRequestState(String packageName, String permName, int deviceId, String persistentDeviceId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#checkUidPermissionState");
        int r0 = this.mService.getPermissionRequestState(packageName, permName, deviceId, persistentDeviceId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, PermissionManager.PermissionState> getAllPermissionStates(String packageName, String deviceId, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAllPermissionStates");
        Map<String, PermissionManager.PermissionState> r0 = this.mService.getAllPermissionStates(packageName, deviceId, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, Set<String>> getAllAppOpPermissionPackages() {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAllAppOpPermissionPackages");
        Map<String, Set<String>> r0 = this.mService.getAllAppOpPermissionPackages();     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionsReviewRequired(String packageName, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#isPermissionsReviewRequired");
        boolean r0 = this.mService.isPermissionsReviewRequired(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissions(AndroidPackage pkg, int userId, boolean restorePregrants) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#resetRuntimePermissions");
        this.mService.resetRuntimePermissions(pkg, userId, restorePregrants);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissionsForUser(int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#resetRuntimePermissionsForUser");
        this.mService.resetRuntimePermissionsForUser(userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionStateTEMP() {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#readLegacyPermissionStateTEMP");
        this.mService.readLegacyPermissionStateTEMP();     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionStateTEMP() {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#writeLegacyPermissionStateTEMP");
        this.mService.writeLegacyPermissionStateTEMP();     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getInstalledPermissions(String packageName) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getInstalledPermissions");
        Set<String> r0 = this.mService.getInstalledPermissions(packageName);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getGrantedPermissions(String packageName, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getGrantedPermissions");
        Set<String> r0 = this.mService.getGrantedPermissions(packageName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getPermissionGids(String permissionName, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getPermissionGids");
        int[] r0 = this.mService.getPermissionGids(permissionName, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String[] getAppOpPermissionPackages(String permissionName) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAppOpPermissionPackages");
        String[] r0 = this.mService.getAppOpPermissionPackages(permissionName);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Permission getPermissionTEMP(String permName) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getPermissionTEMP");
        Permission r0 = this.mService.getPermissionTEMP(permName);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtection(int protection) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAllPermissionsWithProtection");
        List<PermissionInfo> r0 = this.mService.getAllPermissionsWithProtection(protection);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtectionFlags(int protectionFlags) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getAllPermissionsWithProtectionFlags");
        List<PermissionInfo> r0 = this.mService.getAllPermissionsWithProtectionFlags(protectionFlags);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<LegacyPermission> getLegacyPermissions() {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getLegacyPermissions");
        List<LegacyPermission> r0 = this.mService.getLegacyPermissions();     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public LegacyPermissionState getLegacyPermissionState(int appId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getLegacyPermissionState");
        LegacyPermissionState r0 = this.mService.getLegacyPermissionState(appId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#readLegacyPermissionsTEMP");
        this.mService.readLegacyPermissionsTEMP(legacyPermissionSettings);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#writeLegacyPermissionsTEMP");
        this.mService.writeLegacyPermissionsTEMP(legacyPermissionSettings);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String getDefaultPermissionGrantFingerprint(int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getDefaultPermissionGrantFingerprint");
        String r0 = this.mService.getDefaultPermissionGrantFingerprint(userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void setDefaultPermissionGrantFingerprint(String fingerprint, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#setDefaultPermissionGrantFingerprint");
        this.mService.setDefaultPermissionGrantFingerprint(fingerprint, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onSystemReady() {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onSystemReady");
        this.mService.onSystemReady();     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onStorageVolumeMounted(String volumeUuid, boolean fingerprintChanged) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onStorageVolumeMounted");
        this.mService.onStorageVolumeMounted(volumeUuid, fingerprintChanged);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getGidsForUid(int uid) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#getGidsForUid");
        int[] r0 = this.mService.getGidsForUid(uid);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserCreated(int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onUserCreated");
        this.mService.onUserCreated(userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserRemoved(int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onUserRemoved");
        this.mService.onUserRemoved(userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageAdded(PackageState packageState, boolean isInstantApp, AndroidPackage oldPkg) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onPackageAdded");
        this.mService.onPackageAdded(packageState, isInstantApp, oldPkg);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageInstalled(AndroidPackage pkg, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onPackageInstalled");
        this.mService.onPackageInstalled(pkg, previousAppId, params, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageRemoved(AndroidPackage pkg) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onPackageRemoved");
        this.mService.onPackageRemoved(pkg);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageUninstalled(String packageName, int appId, PackageState packageState, AndroidPackage pkg, List<AndroidPackage> sharedUserPkgs, int userId) {
        Trace.traceBegin(TRACE_TAG, "TaggedTracingPermissionManagerServiceImpl#onPackageUninstalled");
        this.mService.onPackageUninstalled(packageName, appId, packageState, pkg, sharedUserPkgs, userId);     // Catch: Throwable -> L6
        Trace.traceEnd(TRACE_TAG);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(TRACE_TAG);
        throw th;
    }
}
