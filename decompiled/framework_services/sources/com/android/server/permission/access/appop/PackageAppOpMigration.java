package com.android.server.permission.access.appop;

import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.appop.AppOpMigrationHelper;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIndexedReferenceMap;
import com.android.server.permission.access.util.PackageVersionMigration;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PackageAppOpMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageAppOpMigration {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: PackageAppOpMigration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public PackageAppOpMigration() {
    }

    public final void migrateUserState(MutableAccessState state, int userId) {
        Object r1 = LocalServices.getService(AppOpMigrationHelper.class);
        Intrinsics.checkNotNull(r1);
        AppOpMigrationHelper legacyAppOpsManager = (AppOpMigrationHelper) r1;
        if (legacyAppOpsManager.hasLegacyAppOpState() == true) goto L5;
        return;
    L5:
        Map<String, Map<String, Integer>> r2 = legacyAppOpsManager.getLegacyPackageAppOpModes(userId);
        int version = PackageVersionMigration.INSTANCE.getVersion$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(userId);
        MutableUserState userState = MutableAccessState.mutateUserState$default(state, userId, 0, 2, null);
        Intrinsics.checkNotNull(userState);
        MutableIndexedReferenceMap<String, IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r5 = userState.mutatePackageAppOpModes();
        Iterator<Map.Entry<String, Map<String, Integer>>> r10 = r2.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        Map.Entry<String, Map<String, Integer>> r11 = r10.next();
        String packageName = r11.getKey();
        Map<String, Integer> r14 = r11.getValue();
        if (state.getExternalState().getPackageStates().containsKey(packageName) == true) goto L11;
        Slog.w(LOG_TAG, "Dropping unknown package " + packageName + " when migrating app op state");
        AppOpMigrationHelper legacyAppOpsManager2 = legacyAppOpsManager;
    L16:
        legacyAppOpsManager = legacyAppOpsManager2;
        goto L7
    L11:
        MutableIndexedMap appOpModes = new MutableIndexedMap(null, 1, null);
        r5.put(packageName, appOpModes);
        Iterator<Map.Entry<String, Integer>> r17 = r14.entrySet().iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        Map.Entry<String, Integer> r18 = r17.next();
        String appOpName = r18.getKey();
        MutableIndexedMap appOpModes2 = appOpModes;
        Integer appOpMode = r18.getValue();
        appOpModes2.put(appOpName, appOpMode);
        appOpModes = appOpModes2;
        legacyAppOpsManager = legacyAppOpsManager;
        goto L13
    L15:
        legacyAppOpsManager2 = legacyAppOpsManager;
        userState.mutatePackageVersions().put(packageName, Integer.valueOf(version));
        goto L16
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = PackageAppOpMigration.class.getSimpleName();
    }
}
