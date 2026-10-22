package com.android.server.permission.access.appop;

import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.appop.AppOpMigrationHelper;
import com.android.server.permission.access.MutableAccessState;
import com.android.server.permission.access.MutableUserState;
import com.android.server.permission.access.immutable.IndexedListSet;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.access.immutable.IntReferenceMapExtensionsKt;
import com.android.server.permission.access.immutable.MutableIndexedMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.util.PackageVersionMigration;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AppIdAppOpMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdAppOpMigration {
    public static final Companion Companion = null;
    private static final String LOG_TAG = null;

    /* JADX INFO: compiled from: AppIdAppOpMigration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public AppIdAppOpMigration() {
    }

    public final void migrateUserState(MutableAccessState state, int userId) {
        Object r1 = LocalServices.getService(AppOpMigrationHelper.class);
        Intrinsics.checkNotNull(r1);
        AppOpMigrationHelper legacyAppOpsManager = (AppOpMigrationHelper) r1;
        if (legacyAppOpsManager.hasLegacyAppOpState() == true) goto L5;
        return;
    L5:
        Map<Integer, Map<String, Integer>> r2 = legacyAppOpsManager.getLegacyAppIdAppOpModes(userId);
        int version = PackageVersionMigration.INSTANCE.getVersion$frameworks__base__services__permission__android_common__services_permission_pre_jarjar(userId);
        MutableUserState userState = MutableAccessState.mutateUserState$default(state, userId, 0, 2, null);
        Intrinsics.checkNotNull(userState);
        MutableIntReferenceMap<IndexedMap<String, Integer>, MutableIndexedMap<String, Integer>> r5 = userState.mutateAppIdAppOpModes();
        Iterator<Map.Entry<Integer, Map<String, Integer>>> r10 = r2.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L27;
        Map.Entry<Integer, Map<String, Integer>> r11 = r10.next();
        Integer appId = r11.getKey();
        Map<String, Integer> r14 = r11.getValue();
        IndexedListSet packageNames = (IndexedListSet) state.getExternalState().getAppIdPackageNames().get(appId.intValue());
        if (packageNames == null) goto L11;
    L13:
        AppOpMigrationHelper legacyAppOpsManager2 = legacyAppOpsManager;
        MutableIndexedMap appOpModes = new MutableIndexedMap(null, 1, null);
        IntReferenceMapExtensionsKt.set(r5, appId.intValue(), appOpModes);
        Map<String, Integer> r3 = r14;
        Iterator<Map.Entry<String, Integer>> r18 = r3.entrySet().iterator();
    L15:
        if (r18.hasNext() == false) goto L18;
        Map.Entry<String, Integer> r19 = r18.next();
        String appOpName = r19.getKey();
        MutableIndexedMap appOpModes2 = appOpModes;
        Integer appOpMode = r19.getValue();
        appOpModes2.put(appOpName, appOpMode);
        appOpModes = appOpModes2;
        r3 = r3;
        goto L15
    L18:
        if (packageNames == null) goto L25;
        MutableIndexedMap<String, Integer> r0 = userState.mutatePackageVersions();
        IndexedListSet $this$forEachIndexed$iv = packageNames;
        int r4 = $this$forEachIndexed$iv.getSize();
        int index$iv = 0;
    L20:
        if (index$iv >= r4) goto L25;
        int r20 = r4;
        String packageName = (String) $this$forEachIndexed$iv.elementAt(index$iv);
        r0.put(packageName, Integer.valueOf(version));
        index$iv = index$iv + 1;
        r4 = r20;
        $this$forEachIndexed$iv = $this$forEachIndexed$iv;
    L25:
        legacyAppOpsManager = legacyAppOpsManager2;
        r2 = r2;
        goto L7
    L11:
        if (appId.intValue() < 10000) goto L13;
        String r6 = LOG_TAG;
        StringBuilder r15 = new StringBuilder();
        legacyAppOpsManager2 = legacyAppOpsManager;
        r15.append("Dropping unknown app ID ");
        r15.append(appId);
        r15.append(" when migrating app op state");
        Slog.w(r6, r15.toString());
        goto L25
    }

    static {
        Companion = new Companion(null);
        LOG_TAG = AppIdAppOpMigration.class.getSimpleName();
    }
}
