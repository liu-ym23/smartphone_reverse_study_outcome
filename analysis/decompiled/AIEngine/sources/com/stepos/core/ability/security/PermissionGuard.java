package com.stepos.core.ability.security;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.g;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PermissionGuard {
    private static final String INFER_PERMISSION = "com.stepos.aiengine.permission.AI_ENGINE_MANAGER_SERVICE";
    private static final int SYSTEM_UID_THRESHOLD = 10000;
    private static final String TAG = "PermissionGuard";
    public static final PermissionGuard INSTANCE = new PermissionGuard();
    private static final AtomicLong inferDeniedCount = new AtomicLong(0);
    private static final AtomicLong manageDeniedCount = new AtomicLong(0);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PermissionLevel {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ PermissionLevel[] $VALUES;
        public static final PermissionLevel QUERY = new PermissionLevel("QUERY", 0);
        public static final PermissionLevel INFER = new PermissionLevel("INFER", 1);
        public static final PermissionLevel MANAGE = new PermissionLevel("MANAGE", 2);

        private static final /* synthetic */ PermissionLevel[] $values() {
            return new PermissionLevel[]{QUERY, INFER, MANAGE};
        }

        static {
            PermissionLevel[] permissionLevelArr$values = $values();
            $VALUES = permissionLevelArr$values;
            $ENTRIES = kotlin.enums.a.a(permissionLevelArr$values);
        }

        private PermissionLevel(String str, int i10) {
        }

        public static a<PermissionLevel> getEntries() {
            return $ENTRIES;
        }

        public static PermissionLevel valueOf(String str) {
            return (PermissionLevel) Enum.valueOf(PermissionLevel.class, str);
        }

        public static PermissionLevel[] values() {
            return (PermissionLevel[]) $VALUES.clone();
        }
    }

    private PermissionGuard() {
    }

    public final boolean checkInfer(int i10, int i11) {
        if (i10 < SYSTEM_UID_THRESHOLD) {
            return true;
        }
        Context context = l7.a.f10344a;
        if (context == null) {
            context = null;
        }
        if (context == null) {
            AIEngineLogger.w(LogModule.SERVICE, TAG, a0.a.f("INFER denied: service not ready (ContextHolder uninitialized), uid=", i10, i11, ", pid="));
            return false;
        }
        boolean z = context.checkPermission(INFER_PERMISSION, i11, i10) == 0;
        if (!z) {
            inferDeniedCount.incrementAndGet();
            AIEngineLogger.w(LogModule.SERVICE, TAG, a0.a.f("INFER permission denied: uid=", i10, i11, ", pid="));
        }
        return z;
    }

    public final boolean checkManage(int i10, int i11) {
        if (i10 < SYSTEM_UID_THRESHOLD) {
            return true;
        }
        boolean zIsCallerTrusted = SignatureUtils.INSTANCE.isCallerTrusted(i10);
        if (!zIsCallerTrusted) {
            manageDeniedCount.incrementAndGet();
            AIEngineLogger.w(LogModule.SERVICE, TAG, d.e(i10, "MANAGE permission denied: uid=", i11, ", pid=", " (signature mismatch)"));
        }
        return zIsCallerTrusted;
    }

    public final boolean checkQuery(int i10, int i11) {
        return checkInfer(i10, i11);
    }

    public final String dumpStats() {
        StringBuilder sb2 = new StringBuilder("----- Permission Audit -----\n");
        sb2.append("  INFER  denied: " + inferDeniedCount.get());
        sb2.append('\n');
        sb2.append("  MANAGE denied: " + manageDeniedCount.get());
        sb2.append('\n');
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }
}
