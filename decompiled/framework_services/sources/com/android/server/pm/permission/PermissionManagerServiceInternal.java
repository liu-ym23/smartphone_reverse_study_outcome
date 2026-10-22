package com.android.server.pm.permission;

import android.content.pm.PermissionInfo;
import android.permission.PermissionManagerInternal;
import android.util.ArrayMap;
import com.android.internal.util.function.QuadFunction;
import com.android.internal.util.function.TriFunction;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionManagerServiceInternal extends PermissionManagerInternal, LegacyPermissionDataProvider {

    public interface CheckPermissionDelegate {
        int checkPermission(String r1, String r2, String r3, int r4, QuadFunction<String, String, String, Integer, Integer> r5);

        int checkUidPermission(int r1, String r2, String r3, TriFunction<Integer, String, String, Integer> r4);
    }

    public interface HotwordDetectionServiceProvider {
        int getUid();
    }

    public static final class PackageInstalledParams {
        public static final PackageInstalledParams DEFAULT = null;
        private final List<String> mAllowlistedRestrictedPermissions;
        private final int mAutoRevokePermissionsMode;
        private final ArrayMap<String, Integer> mPermissionStates;

        public static final class Builder {
            private List<String> mAllowlistedRestrictedPermissions;
            private int mAutoRevokePermissionsMode;
            private ArrayMap<String, Integer> mPermissionStates;

            public Builder() {
                this.mPermissionStates = null;
                this.mAllowlistedRestrictedPermissions = Collections.emptyList();
                this.mAutoRevokePermissionsMode = 3;
            }

            public Builder setPermissionStates(ArrayMap<String, Integer> permissionStates) {
                permissionStates.getClass();
                this.mPermissionStates = permissionStates;
                return this;
            }

            public void setAllowlistedRestrictedPermissions(List<String> allowlistedRestrictedPermissions) {
                allowlistedRestrictedPermissions.getClass();
                this.mAllowlistedRestrictedPermissions = new ArrayList(allowlistedRestrictedPermissions);
            }

            public void setAutoRevokePermissionsMode(int autoRevokePermissionsMode) {
                this.mAutoRevokePermissionsMode = autoRevokePermissionsMode;
            }

            public PackageInstalledParams build() {
                if (this.mPermissionStates != null) goto L5;
                ArrayMap<String, Integer> r1 = new ArrayMap();
            L7:
                return new PackageInstalledParams(r1, this.mAllowlistedRestrictedPermissions, this.mAutoRevokePermissionsMode, null);
            L5:
                r1 = this.mPermissionStates;
                goto L7
            }
        }

        /* synthetic */ PackageInstalledParams(ArrayMap r1, List r2, int r3, PermissionManagerServiceInternalIA r4) {
            this(r1, r2, r3);
        }

        static {
            DEFAULT = new Builder().build();
        }

        private PackageInstalledParams(ArrayMap<String, Integer> permissionStates, List<String> allowlistedRestrictedPermissions, int autoRevokePermissionsMode) {
            this.mPermissionStates = permissionStates;
            this.mAllowlistedRestrictedPermissions = allowlistedRestrictedPermissions;
            this.mAutoRevokePermissionsMode = autoRevokePermissionsMode;
        }

        public ArrayMap<String, Integer> getPermissionStates() {
            return this.mPermissionStates;
        }

        public List<String> getAllowlistedRestrictedPermissions() {
            return this.mAllowlistedRestrictedPermissions;
        }

        public int getAutoRevokePermissionsMode() {
            return this.mAutoRevokePermissionsMode;
        }
    }

    int checkPermission(String r1, String r2, String r3, int r4);

    int checkUidPermission(int r1, String r2, int r3);

    List<PermissionInfo> getAllPermissionsWithProtection(int r1);

    List<PermissionInfo> getAllPermissionsWithProtectionFlags(int r1);

    String[] getAppOpPermissionPackages(String r1);

    String getDefaultPermissionGrantFingerprint(int r1);

    Set<String> getGrantedPermissions(String r1, int r2);

    HotwordDetectionServiceProvider getHotwordDetectionServiceProvider();

    Set<String> getInstalledPermissions(String r1);

    int[] getPermissionGids(String r1, int r2);

    Permission getPermissionTEMP(String r1);

    boolean isPermissionsReviewRequired(String r1, int r2);

    void onPackageAdded(PackageState r1, boolean r2, AndroidPackage r3);

    void onPackageInstalled(AndroidPackage r1, int r2, PackageInstalledParams r3, int r4);

    void onPackageRemoved(AndroidPackage r1);

    void onPackageUninstalled(String r1, int r2, PackageState r3, AndroidPackage r4, List<AndroidPackage> r5, int r6);

    void onStorageVolumeMounted(String r1, boolean r2);

    void onSystemReady();

    void onUserCreated(int r1);

    void onUserRemoved(int r1);

    void readLegacyPermissionStateTEMP();

    void readLegacyPermissionsTEMP(LegacyPermissionSettings r1);

    void resetRuntimePermissions(AndroidPackage r1, int r2, boolean r3);

    void resetRuntimePermissionsForUser(int r1);

    void setCheckPermissionDelegate(CheckPermissionDelegate r1);

    void setDefaultPermissionGrantFingerprint(String r1, int r2);

    void setHotwordDetectionServiceProvider(HotwordDetectionServiceProvider r1);

    void writeLegacyPermissionStateTEMP();

    void writeLegacyPermissionsTEMP(LegacyPermissionSettings r1);
}
