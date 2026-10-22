package com.android.server.permission.access.util;

import com.android.server.LocalServices;
import com.android.server.appop.AppOpMigrationHelper;
import com.android.server.pm.permission.PermissionMigrationHelper;

/* JADX INFO: compiled from: PackageVersionMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageVersionMigration {
    public static final PackageVersionMigration INSTANCE = null;

    static {
        INSTANCE = new PackageVersionMigration();
    }

    private PackageVersionMigration() {
    }

    public final int getVersion$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(int userId) {
        PermissionMigrationHelper permissionMigrationHelper = (PermissionMigrationHelper) LocalServices.getService(PermissionMigrationHelper.class);
        int permissionVersion = permissionMigrationHelper.getLegacyPermissionStateVersion(userId);
        AppOpMigrationHelper appOpMigrationHelper = (AppOpMigrationHelper) LocalServices.getService(AppOpMigrationHelper.class);
        int appOpVersion = appOpMigrationHelper.getLegacyAppOpVersion();
        if (permissionVersion != (-1)) goto L9;
        if (appOpVersion != (-1)) goto L9;
        throw new IllegalStateException("getVersion() called when there are no legacy files".toString());
    L9:
        if (permissionVersion < 11) goto L13;
        if (appOpVersion < 3) goto L13;
        return 15;
    L13:
        if (permissionVersion < 10) goto L17;
        if (appOpVersion < 3) goto L17;
        return 14;
    L17:
        if (permissionVersion < 10) goto L21;
        if (appOpVersion < 1) goto L21;
        return 13;
    L21:
        if (permissionVersion < 9) goto L25;
        if (appOpVersion < 1) goto L25;
        return 12;
    L25:
        if (permissionVersion < 8) goto L29;
        if (appOpVersion < 1) goto L29;
        return 11;
    L29:
        if (permissionVersion < 7) goto L33;
        if (appOpVersion < 1) goto L33;
        return 10;
    L33:
        if (permissionVersion < 6) goto L37;
        if (appOpVersion < 1) goto L37;
        return 9;
    L37:
        if (permissionVersion < 5) goto L41;
        if (appOpVersion < 1) goto L41;
        return 8;
    L41:
        if (permissionVersion < 4) goto L44;
        if (appOpVersion < 1) goto L44;
        return 7;
    L44:
        if (permissionVersion < 3) goto L48;
        if (appOpVersion < 1) goto L48;
        return 6;
    L48:
        if (permissionVersion < 2) goto L51;
        if (appOpVersion < 1) goto L51;
        return 5;
    L51:
        if (permissionVersion < 1) goto L54;
        if (appOpVersion < 1) goto L54;
        return 4;
    L54:
        if (permissionVersion < 0) goto L57;
        if (appOpVersion < 1) goto L57;
        return 3;
    L57:
        if (permissionVersion < 0) goto L60;
        if (appOpVersion < 0) goto L60;
        return 2;
    L60:
        if (permissionVersion < (-1)) goto L63;
        if (appOpVersion < 0) goto L63;
        return 1;
    L63:
        return 0;
    }
}
