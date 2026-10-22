package com.bytedance.applog.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class BlockHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f6027a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f6028b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile long f6029c = -1;

    static {
    }

    public BlockHelper() {
    }

    public static void setBlockInterval(long r2) {
        f6027a = Math.max(r2, 1);
    }

    public static long getBlockInterval() {
        return f6027a;
    }

    public static void beginBlock() {
        f6028b = true;
        f6029c = SystemClock.elapsedRealtime();
    }

    public static void endBlock() {
        f6028b = false;
        f6029c = -1;
    }

    public static void tryBlock() {
    L3:
        if (f6028b == false) goto L5;
        a();
        goto L3
    }

    private static void a() {
        if (f6028b == false) goto L16;
    L9:
        e = move-exception;
        com.bytedance.applog.log.m.a().a("BlockHelper: block interrupted!", e, new Object[0]);
        return;
    L5:
        if (Math.abs(SystemClock.elapsedRealtime() - f6029c) >= 10000) goto L7;
        Thread.sleep(f6027a);     // Catch: InterruptedException -> L9
    L12:
        return;
    L7:
        endBlock();     // Catch: InterruptedException -> L9
        goto L12
    }
}
