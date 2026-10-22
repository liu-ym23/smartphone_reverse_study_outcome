package com.android.server.pm.permission;

import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.permission.IOnPermissionsChangeListener;
import android.permission.PermissionManager;
import android.permission.PermissionManagerInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionManagerServiceInterface extends PermissionManagerInternal {
    boolean addAllowlistedRestrictedPermission(String r1, String r2, int r3, int r4);

    void addOnPermissionsChangeListener(IOnPermissionsChangeListener r1);

    boolean addPermission(PermissionInfo r1, boolean r2);

    int checkPermission(String r1, String r2, String r3, int r4);

    int checkUidPermission(int r1, String r2, String r3);

    void dump(FileDescriptor r1, PrintWriter r2, String[] r3);

    Map<String, Set<String>> getAllAppOpPermissionPackages();

    List<PermissionGroupInfo> getAllPermissionGroups(int r1);

    Map<String, PermissionManager.PermissionState> getAllPermissionStates(String r1, String r2, int r3);

    List<PermissionInfo> getAllPermissionsWithProtection(int r1);

    List<PermissionInfo> getAllPermissionsWithProtectionFlags(int r1);

    List<String> getAllowlistedRestrictedPermissions(String r1, int r2, int r3);

    String[] getAppOpPermissionPackages(String r1);

    String getDefaultPermissionGrantFingerprint(int r1);

    int[] getGidsForUid(int r1);

    Set<String> getGrantedPermissions(String r1, int r2);

    Set<String> getInstalledPermissions(String r1);

    LegacyPermissionState getLegacyPermissionState(int r1);

    List<LegacyPermission> getLegacyPermissions();

    int getPermissionFlags(String r1, String r2, String r3, int r4);

    int[] getPermissionGids(String r1, int r2);

    PermissionGroupInfo getPermissionGroupInfo(String r1, int r2);

    PermissionInfo getPermissionInfo(String r1, int r2, String r3);

    int getPermissionRequestState(String r1, String r2, int r3, String r4);

    Permission getPermissionTEMP(String r1);

    List<SplitPermissionInfoParcelable> getSplitPermissions();

    void grantRuntimePermission(String r1, String r2, String r3, int r4);

    boolean isPermissionRevokedByPolicy(String r1, String r2, String r3, int r4);

    boolean isPermissionsReviewRequired(String r1, int r2);

    void onPackageAdded(PackageState r1, boolean r2, AndroidPackage r3);

    void onPackageInstalled(AndroidPackage r1, int r2, PermissionManagerServiceInternal.PackageInstalledParams r3, int r4);

    void onPackageRemoved(AndroidPackage r1);

    void onPackageUninstalled(String r1, int r2, PackageState r3, AndroidPackage r4, List<AndroidPackage> r5, int r6);

    void onStorageVolumeMounted(String r1, boolean r2);

    void onSystemReady();

    void onUserCreated(int r1);

    void onUserRemoved(int r1);

    List<PermissionInfo> queryPermissionsByGroup(String r1, int r2);

    void readLegacyPermissionStateTEMP();

    void readLegacyPermissionsTEMP(LegacyPermissionSettings r1);

    boolean removeAllowlistedRestrictedPermission(String r1, String r2, int r3, int r4);

    void removeOnPermissionsChangeListener(IOnPermissionsChangeListener r1);

    void removePermission(String r1);

    void resetRuntimePermissions(AndroidPackage r1, int r2, boolean r3);

    void resetRuntimePermissionsForUser(int r1);

    void revokePostNotificationPermissionWithoutKillForTest(String r1, int r2);

    void revokeRuntimePermission(String r1, String r2, String r3, int r4, String r5);

    void setDefaultPermissionGrantFingerprint(String r1, int r2);

    boolean shouldShowRequestPermissionRationale(String r1, String r2, String r3, int r4);

    void updatePermissionFlags(String r1, String r2, int r3, int r4, boolean r5, String r6, int r7);

    void updatePermissionFlagsForAllApps(int r1, int r2, int r3);

    void writeLegacyPermissionStateTEMP();

    void writeLegacyPermissionsTEMP(LegacyPermissionSettings r1);

    default void setPermissionManagerServiceSmtEx(PermissionManagerServiceSmtEx smtEx) {
    }
}
