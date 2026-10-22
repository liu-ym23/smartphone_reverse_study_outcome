package com.bytedance.platform.godzilla.common;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivityThreadHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f9076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f9077b;

    static /* synthetic */ Object a(Object r0) {
        f9077b = r0;
        return r0;
    }

    static /* synthetic */ Class b() {
        return f9076a;
    }

    private b() {
    }

    public static Object a() {
        if (f9077b != null) goto L36;
        monitor-enter(b.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (f9077b != null) goto L13;
        if (f9076a != null) goto L11;
        f9076a = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin");     // Catch: Throwable -> L30
    L11:
        f9077b = com.bytedance.platform.godzilla.b.d.a(f9076a, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (f9077b == null) goto L15;
    L28:
        monitor-exit(b.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        final Object r1 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r1));     // Catch: Throwable -> L30
        if (f9077b != null) goto L28;
        monitor-enter(r1);     // Catch: Throwable -> L30
        r1.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return f9077b;
    }
}
