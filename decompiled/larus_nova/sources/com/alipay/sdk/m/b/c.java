package com.alipay.sdk.m.b;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f25236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f25237b;

    public c() {
    }

    public static synchronized String a(Context r100) {
        monitor-enter(c.class);
        if (r100 == null) goto L18;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L16;
        b(r100);     // Catch: Throwable -> L19
        b r101 = f25236a;     // Catch: Throwable -> L19
        if (r101 != null) goto L23;
    L12:
        monitor-exit(c.class);
        return null;
    L23:
        String r102 = r101.a(r100);     // Catch: Exception -> L22 Throwable -> L19
        monitor-exit(c.class);
        return r102;
    L16:
        throw new IllegalStateException("Cannot be called from the main thread");     // Catch: Throwable -> L19
    L18:
        throw new RuntimeException("Context is null");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void b(Context r100) {
        if (f25236a == null) goto L5;
        return;
    L5:
        if (f25237b == false) goto L7;
        return;
    L7:
        monitor-enter(c.class);
    L15:
        th = move-exception;
        throw th;
    L9:
        if (f25236a == null) goto L11;
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
        return;
    L11:
        if (f25237b == true) goto L13;
        f25236a = com.alipay.sdk.m.c.a.a(r100);     // Catch: Throwable -> L15
        f25237b = true;     // Catch: Throwable -> L15
        goto L13
    }
}
