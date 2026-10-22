package com.alipay.sdk.m.u;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes28.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f25804a = 3000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f25805b = -1;

    public static synchronized boolean a() {
        monitor-enter(b.class);
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        if ((r100 - f25805b) < 3000) goto L10;
        f25805b = r100;     // Catch: Throwable -> L13
        monitor-exit(b.class);
        return false;
    L10:
        monitor-exit(b.class);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public b() {
    }
}
