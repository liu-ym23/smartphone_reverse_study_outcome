package com.obric.autogui.platforms.tools.security;

import android.os.Bundle;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.Arrays;

/* JADX INFO: compiled from: SecurityGuardCompat.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "SecurityGuardCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30540a = null;

    static {
        f30540a = new c();
    }

    private c() {
    }

    public final Bundle a(String r5) {
        o.e(r5, "packageName");
        Object r4 = a("getCurrentAppGrantPermissionInfo", new Class[]{String.class}, new Object[]{r5});
        if (ZeusTransformUtils.instanceOf(r4, Bundle.class) == true) goto L7;
        return null;
    L7:
        return (Bundle) ZeusTransformUtils.preCheckCast(r4, Bundle.class, "com.obric.aiagent.plugin");
    }

    public final Integer a(String r7, String r8, Bundle r9) {
        o.e(r7, "packageName");
        o.e(r8, "className");
        Object r6 = a("getActivityRiskType", new Class[]{String.class, String.class, Bundle.class}, new Object[]{r7, r8, r9});
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == true) goto L7;
        return null;
    L7:
        return (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
    }

    private final Object a(String r6, Class<?>[] r7, Object[] r8) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        Class r5 = ZeusTransformUtils.forName(((c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin")).a(), "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Object r3 = r5.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return null;
    L6:
        Object r9 = n.f(r5.getMethod(r6, (Class[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r7, r7.length), Class[].class, "com.obric.aiagent.plugin")).invoke(r3, Arrays.copyOf(r8, r8.length)));     // Catch: Throwable -> L8
    L10:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L17;
        Loog.INSTANCE.e(TAG, "invoke " + r6 + " failed: " + r10);
        return null;
    L17:
        return r9;
    L8:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L10
    }

    private final String a() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = n.f(Boolean.valueOf(ObricProductSdk.INSTANCE.platformService().romInfo().useAssistantApi()));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r5);
        if (r2 == null) goto L12;
        Loog.INSTANCE.w(TAG, "read useAssistantApi failed, fallback to obric api: " + r2);
        r5 = false;
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L14;
        return "android.security.aiassistant.guard.AssistantSecurityGuardStub";
    L14:
        return "android.security.obric.guard.ObricSecurityGuardStub";
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L7
    }
}
