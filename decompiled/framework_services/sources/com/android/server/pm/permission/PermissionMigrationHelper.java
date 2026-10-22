package com.android.server.pm.permission;

import android.content.pm.PermissionInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionMigrationHelper {

    public static final class LegacyPermission {
        private final PermissionInfo mPermissionInfo;
        private final int mType;

        LegacyPermission(PermissionInfo permissionInfo, int type) {
            this.mPermissionInfo = permissionInfo;
            this.mType = type;
        }

        public PermissionInfo getPermissionInfo() {
            return this.mPermissionInfo;
        }

        public int getType() {
            return this.mType;
        }
    }

    public static final class LegacyPermissionState {
        private final int mFlags;
        private final boolean mGranted;

        LegacyPermissionState(boolean granted, int flags) {
            this.mGranted = granted;
            this.mFlags = flags;
        }

        public boolean isGranted() {
            return this.mGranted;
        }

        public int getFlags() {
            return this.mFlags;
        }
    }

    int getLegacyPermissionStateVersion(int r1);

    Map<Integer, Map<String, LegacyPermissionState>> getLegacyPermissionStates(int r1);

    Map<String, LegacyPermission> getLegacyPermissionTrees();

    Map<String, LegacyPermission> getLegacyPermissions();

    boolean hasLegacyPermission();

    boolean hasLegacyPermissionState(int r1);
}
