package com.obric.agent.intents.findphone;

import android.app.Application;
import android.content.Context;
import android.os.PowerManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: ScreenUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "FindPhone:ScreenUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14701b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static PowerManager.WakeLock f14702c;

    private c() {
    }

    static {
        f14700a = new c();
        f14701b = new Object();
    }

    public final void a(long r4) {
        PowerManager r3 = c();
        if (r3 != null) goto L5;
        return;
    L5:
        Object r0 = f14701b;
        monitor-enter(r0);
        f14700a.b();     // Catch: Throwable -> L14
        PowerManager.WakeLock r5 = r3.newWakeLock(268435466, TAG);     // Catch: Throwable -> L14
        r5.setReferenceCounted(false);     // Catch: Throwable -> L14
        if (r4 <= 0) goto L10;
        a(r5, r4);     // Catch: Throwable -> L14
    L11:
        f14702c = r5;     // Catch: Throwable -> L14
        x r6 = x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L10:
        a(r5);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void a() {
        Object r1 = f14701b;
        monitor-enter(r1);
        f14700a.b();     // Catch: Throwable -> L7
        x r0 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void b() {
        PowerManager.WakeLock r1 = f14702c;
        if (r1 != null) goto L5;
    L7:
        f14702c = null;
        return;
    L5:
        if (r1.isHeld() == false) goto L7;
        b(r1);
        goto L7
    }

    private final PowerManager c() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r4 = r3.getSystemService("power");
        if (ZeusTransformUtils.instanceOf(r4, PowerManager.class) == true) goto L8;
        return null;
    L8:
        return (PowerManager) ZeusTransformUtils.preCheckCast(r4, PowerManager.class, "com.obric.aiagent.plugin");
    }

    private final Context d() {
        Object r1 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: ReflectiveOperationException -> L10
        if (ZeusTransformUtils.instanceOf(r1, Application.class) == false) goto L6;
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(r1, Application.class, "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L10
    L7:
        return (Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.aiagent.plugin");
    L6:
        r2 = null;
    L13:
        return null;
    }

    public static void a(PowerManager.WakeLock r1) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.acquire();
        return;
    L6:
        r1.acquire();
        com.obric.performance.power.monitor.cpu.c.a(r1);
    }

    public static void a(PowerManager.WakeLock r1, long r2) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.acquire(r2);
        return;
    L6:
        r1.acquire(r2);
        com.obric.performance.power.monitor.cpu.c.a(r1);
    }

    public static void b(PowerManager.WakeLock r1) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.release();
        return;
    L6:
        r1.release();
        com.obric.performance.power.monitor.cpu.c.b(r1);
    }
}
