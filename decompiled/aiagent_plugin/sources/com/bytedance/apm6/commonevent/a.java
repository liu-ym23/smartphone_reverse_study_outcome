package com.bytedance.apm6.commonevent;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.b.d;
import com.bytedance.apm6.monitor.b;
import com.bytedance.apm6.service.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonEventDeliverer.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5037a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.bytedance.apm6.commonevent.a.a f5038b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f5039c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.bytedance.apm6.util.a.a<b> f5040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f5041e;

    static /* synthetic */ boolean a() {
        return f5041e;
    }

    static {
        com.bytedance.apm6.util.a.a<b> r0 = new com.bytedance.apm6.util.a.a(1000);
        f5040d = r0;
        f5041e = true;
        r0.a(new AnonymousClass1());
    }

    public static synchronized void a(boolean r1) {
        monitor-enter(a.class);
        f5041e = r1;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized void b() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f5039c == true) goto L9;
        com.bytedance.apm6.commonevent.a.b r1 = (com.bytedance.apm6.commonevent.a.b) ZeusTransformUtils.preCheckCast(c.a(com.bytedance.apm6.commonevent.a.b.class), com.bytedance.apm6.commonevent.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        a(r1.a());     // Catch: Throwable -> L11
        f5039c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);
    }

    public static void a(com.bytedance.apm6.commonevent.b.a r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f5038b != null) goto L12;
        f5040d.a(r3);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "cached CommonEvent:" + r3);
    L9:
        b();
        return;
    L12:
        if (f5038b.a(r3.a()) == false) goto L17;
        r3.j();
        com.bytedance.apm6.monitor.a.a(r3);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L23;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "Sampled CommonEvent:" + r3);
        return;
    L23:
        return;
    L17:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L20;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "UnSampled CommonEvent:" + r3);
    L20:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L25;
        r3.j();
        com.bytedance.apm.doctor.a.a(r3.g(), r3.i(), false);
        return;
    }

    public static void a(com.bytedance.apm6.commonevent.b.b r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (f5038b != null) goto L12;
        f5040d.a(r4);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "Cached CommonLog: " + r4);
    L9:
        b();
        return;
    L12:
        if (f5038b.b(r4.g()) == false) goto L18;
        r4.b();
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L16;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "Sampled CommonLog:" + r4);
    L16:
        com.bytedance.apm6.monitor.a.a(r4);
        return;
    L18:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L22;
        r4.b();
        com.bytedance.apm.doctor.a.a(r4.g(), r4.i(), false);
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "UnSampled CommonLog:" + r4);
        return;
    }

    public static boolean a(String r2, Boolean r3) {
        if (f5037a == true) goto L5;
        return false;
    L5:
        if (f5038b != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        if (r3.booleanValue() == false) goto L15;
        if (f5038b.a(r2) == true) goto L22;
    L16:
        return true;
    L22:
        return false;
    L15:
        if (f5038b.b(r2) == false) goto L16;
        return false;
    }

    public static void a(com.bytedance.apm6.commonevent.b.c r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        com.bytedance.apm6.monitor.a.a(r0);
    }

    public static void a(d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L7;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "trace_data:" + r2.i());
    L7:
        com.bytedance.apm6.monitor.a.a(r2);
    }

    public static synchronized void a(com.bytedance.apm6.commonevent.a.a r4) {
        monitor-enter(a.class);
        if (r4 != null) goto L28;
    L26:
        monitor-exit(a.class);
        return;
    L28:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (f5038b == r4) goto L26;
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "updateConfig " + r4);     // Catch: Throwable -> L23
    L11:
        f5038b = r4;     // Catch: Throwable -> L23
    L12:
        if (f5040d.b() == true) goto L21;
        b r5 = (b) ZeusTransformUtils.preCheckCast(f5040d.a(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.apm6.commonevent.b.a.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, com.bytedance.apm6.commonevent.b.b.class) == false) goto L12;
        a((com.bytedance.apm6.commonevent.b.b) ZeusTransformUtils.preCheckCast(r5, com.bytedance.apm6.commonevent.b.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        goto L12
    L16:
        a((com.bytedance.apm6.commonevent.b.a) ZeusTransformUtils.preCheckCast(r5, com.bytedance.apm6.commonevent.b.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        goto L12
    L21:
        monitor-exit(a.class);
    }

    public static void a(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        a(r1, 0, r2, r3, r4);
    }

    public static void a(String r8, int r9, JSONObject r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        a(new com.bytedance.apm6.commonevent.b.a(r8, r9, r10, r11, r12, r13));
    }

    public static void a(String r6, int r7, JSONObject r8, JSONObject r9, JSONObject r10) {
        a(r6, r7, null, r8, r9, r10);
    }

    public static void a(String r8, JSONObject r9, JSONObject r10) {
        a(new com.bytedance.apm6.commonevent.b.a(r8, 0, r9, null, null, r10));
    }

    public static void a(String r1, int r2, JSONObject r3) {
        a(r1, r2, null, null, r3);
    }

    public static void a(String r8, int r9, JSONObject r10, JSONObject r11) {
        a(new com.bytedance.apm6.commonevent.b.a(r8, r9, r10, null, null, r11));
    }

    public static void a(String r1, JSONObject r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        a(new com.bytedance.apm6.commonevent.b.b(r1, r2));
        return;
    L5:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L10;
        com.bytedance.apm6.util.c.b.a("APM-CommonEvent", "logType must be not empty");
        return;
    }
}
