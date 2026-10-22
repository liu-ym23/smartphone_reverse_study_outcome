package com.bytedance.android.livesdk.performance;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BatteryManager f154464a;

    public b() {
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (b(r100) == null) goto L6;
        return true;
    }

    public static BatteryManager b(Context r100) {
        if (f154464a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f154464a != null) goto L9;
        f154464a = (BatteryManager) r100.getSystemService("batterymanager");     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f154464a;
    }

    public static int c(Context r100) {
    L14:
        return -1;
    L4:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return -1;
    L7:
        if (a(r100) == true) goto L9;
        return -1;
    L9:
        BatteryManager r101 = b(r100);     // Catch: Exception -> L14
        if (r101 != null) goto L12;
        return -1;
    L12:
        return r101.getIntProperty(6);
    }

    public static long d(Context r100) {
        if (a(r100) == true) goto L6;
        return -1;
    L6:
        BatteryManager r101 = b(r100);     // Catch: Exception -> L23
        if (r101 != null) goto L9;
        return -1;
    L9:
        int r102 = r101.getIntProperty(4);     // Catch: Exception -> L23
        long r103 = r101.getLongProperty(1);     // Catch: Exception -> L23
        if (r102 <= 0) goto L22;
        if (r103 == Long.MIN_VALUE) goto L22;
        if (Math.abs((r103 / ((long) r102)) * 100) >= 50000) goto L19;
        r103 = r103 * 1000;
    L19:
        if (r103 < 0) goto L21;
        return r103;
    L21:
        return -r103;
    L22:
        return -1;
    }
}
