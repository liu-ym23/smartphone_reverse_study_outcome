package com.android.server.permission.access.permission;

import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.util.IntExtensionsKt;
import com.android.server.permission.access.util.PackageVersionMigration;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.permission.PermissionMigrationHelper;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AppIdPermissionMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdPermissionMigration {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: AppIdPermissionMigration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public AppIdPermissionMigration() {
    }

    public final void migrateSystemState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(MutableAccessState state) {
        Object r0 = LocalServices.getService(PermissionMigrationHelper.class);
        Intrinsics.checkNotNull(r0);
        PermissionMigrationHelper legacyPermissionsManager = (PermissionMigrationHelper) r0;
        if (legacyPermissionsManager.hasLegacyPermission() == true) goto L5;
        return;
    L5:
        migratePermissions$default(this, MutableAccessState.mutateSystemState$default(state, 0, 1, null).mutatePermissions(), legacyPermissionsManager.getLegacyPermissions(), false, 4, null);
        migratePermissions(MutableAccessState.mutateSystemState$default(state, 0, 1, null).mutatePermissionTrees(), legacyPermissionsManager.getLegacyPermissionTrees(), true);
    }

    static /* synthetic */ void migratePermissions$default(AppIdPermissionMigration r0, MutableIndexedMap r1, Map r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.migratePermissions(r1, r2, r3);
    }

    private final void migratePermissions(MutableIndexedMap<String, Permission> r16, Map<String, PermissionMigrationHelper.LegacyPermission> r17, boolean isPermissionTree) {
        Iterator<Map.Entry<String, PermissionMigrationHelper.LegacyPermission>> r2 = r17.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        PermissionMigrationHelper.LegacyPermission legacyPermission = r2.next().getValue();
        Permission permission = new Permission(legacyPermission.getPermissionInfo(), false, legacyPermission.getType(), 0, null, false, 48, null);
        r16.put(permission.getPermissionInfo().name, permission);
        goto L4
    }

    public final void migrateUserState$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(MutableAccessState state, int userId) {
        int r0 = userId;
        Object r1 = LocalServices.getService(PermissionMigrationHelper.class);
        Intrinsics.checkNotNull(r1);
        PermissionMigrationHelper permissionMigrationHelper = (PermissionMigrationHelper) r1;
        if (permissionMigrationHelper.hasLegacyPermissionState(r0) == true) goto L5;
        return;
    L5:
        Map<Integer, Map<String, PermissionMigrationHelper.LegacyPermissionState>> r2 = permissionMigrationHelper.getLegacyPermissionStates(r0);
        int version = PackageVersionMigration.INSTANCE.getVersion$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(r0);
        MutableUserState userState = MutableAccessState.mutateUserState$default(state, r0, 0, 2, null);
        Intrinsics.checkNotNull(userState);
        MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r5 = userState.mutateAppIdPermissionFlags();
        Iterator<Map.Entry<Integer, Map<String, PermissionMigrationHelper.LegacyPermissionState>>> r10 = r2.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L25;
        Map.Entry<Integer, Map<String, PermissionMigrationHelper.LegacyPermissionState>> r11 = r10.next();
        Integer appId = r11.getKey();
        Map<String, PermissionMigrationHelper.LegacyPermissionState> r14 = r11.getValue();
        IndexedListSet packageNames = (IndexedListSet) state.getExternalState().getAppIdPackageNames().get(appId.intValue());
        if (packageNames != null) goto L11;
        String r3 = LOG_TAG;
        StringBuilder r4 = new StringBuilder();
        int version2 = version;
        r4.append("Dropping unknown app ID ");
        r4.append(appId);
        r4.append(" when migrating permission state");
        Slog.w(r3, r4.toString());
        MutableUserState userState2 = userState;
        MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r26 = r5;
    L23:
        r0 = userId;
        permissionMigrationHelper = permissionMigrationHelper;
        r2 = r2;
        version = version2;
        userState = userState2;
        r5 = r26;
        goto L7
    L11:
        version2 = version;
        MutableIndexedMap permissionFlags = new MutableIndexedMap(null, 1, null);
        IntReferenceMapExtensionsKt.set(r5, appId.intValue(), permissionFlags);
        Map<String, PermissionMigrationHelper.LegacyPermissionState> r6 = r14;
        Iterator<Map.Entry<String, PermissionMigrationHelper.LegacyPermissionState>> r20 = r6.entrySet().iterator();
    L13:
        if (r20.hasNext() == false) goto L19;
        Map.Entry<String, PermissionMigrationHelper.LegacyPermissionState> r21 = r20.next();
        String permissionName = r21.getKey();
        MutableIndexedMap permissionFlags2 = permissionFlags;
        PermissionMigrationHelper.LegacyPermissionState legacyPermissionState = r21.getValue();
        Map<String, PermissionMigrationHelper.LegacyPermissionState> r25 = r6;
        Permission permission = state.getSystemState().getPermissions().get(permissionName);
        if (permission != null) goto L17;
        Slog.w(LOG_TAG, "Dropping unknown permission " + permissionName + " for app ID " + appId + " when migrating permission state");
    L18:
        userState = userState;
        permissionFlags = permissionFlags2;
        r6 = r25;
        r5 = r5;
        packageNames = packageNames;
        goto L13
    L17:
        permissionFlags2.put(permissionName, Integer.valueOf(migratePermissionFlags(permission, legacyPermissionState, appId.intValue(), r0)));
        goto L18
    L19:
        userState2 = userState;
        r26 = r5;
        IndexedListSet packageNames2 = packageNames;
        MutableIndexedMap<String, Integer> r7 = userState2.mutatePackageVersions();
        int index$iv = 0;
        int r8 = packageNames2.getSize();
    L20:
        if (index$iv >= r8) goto L23;
        String packageName = (String) packageNames2.elementAt(index$iv);
        r7.put(packageName, Integer.valueOf(version2));
        index$iv = index$iv + 1;
        goto L20
    }

    private final int migratePermissionFlags(Permission permission, PermissionMigrationHelper.LegacyPermissionState legacyPermissionState, int appId, int userId) {
        int flags = 1;
        if (permission.getPermissionInfo().getProtection() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L13;
        if (legacyPermissionState.isGranted() == true) goto L45;
        flags = 2;
    L45:
        return PermissionFlags.INSTANCE.updateFlags(permission, flags, legacyPermissionState.getFlags(), legacyPermissionState.getFlags());
    L13:
        if (permission.getPermissionInfo().getProtection() != 2) goto L15;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L35;
        if (permission.getPermissionInfo().getProtection() != 4) goto L21;
        boolean r2 = true;
    L22:
        if (r2 == true) goto L35;
        if (permission.getPermissionInfo().getProtection() == 1) goto L28;
        flags = 0;
    L28:
        if (flags != 0) goto L30;
        flags = 0;
        goto L45
    L30:
        if (legacyPermissionState.isGranted() == false) goto L32;
        flags = 16;
        goto L45
    L32:
        flags = 0;
        goto L45
    L21:
        r2 = false;
    L35:
        if (legacyPermissionState.isGranted() == true) goto L37;
        flags = 0;
        goto L45
    L37:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 32) == false) goto L39;
    L42:
        flags = 20;
        goto L45
    L39:
        if (IntExtensionsKt.hasBits(permission.getPermissionInfo().getProtectionFlags(), 67108864) == true) goto L42;
        flags = 4;
        goto L45
    L15:
        r1 = false;
        goto L17
    L5:
        r0 = false;
        goto L7
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppIdPermissionMigration.class.getSimpleName();
    }
}
