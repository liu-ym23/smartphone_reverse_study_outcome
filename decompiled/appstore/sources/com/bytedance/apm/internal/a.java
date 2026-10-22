package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm.constant.SlardarConfigConsts;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6498a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences f6499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f6500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f6501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f6502e;

    static {
    }

    public static long a() {
        return f6502e;
    }

    public static int b() {
        return ((-536870912) & f6500c) >>> 29;
    }

    public static boolean c(int r10) {
        if ((r10 & f6500c) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void d(Context r10) {
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f6498a == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f6498a = true;     // Catch: Throwable -> L12
        if (f6499b != null) goto L14;
        f6499b = r10.getSharedPreferences(SlardarConfigConsts.MONITOR_SWITCH_CONFIG, 0);     // Catch: Throwable -> L12
    L14:
        SharedPreferences r11 = f6499b;     // Catch: Throwable -> L12
        if (r11 == null) goto L17;
        int r12 = r11.getInt(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_FIRST_FLAG, 0);     // Catch: Throwable -> L12
        f6500c = r12;     // Catch: Throwable -> L12
        f6501d = r12;     // Catch: Throwable -> L12
        f6502e = f6499b.getLong(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_ATRACE_FLAG, 0);     // Catch: Throwable -> L12
    L17:
        monitor-exit(a.class);
    }

    public static void e() {
        SharedPreferences r10 = f6499b;
        if (r10 == null) goto L6;
        r10.edit().putInt(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_FIRST_FLAG, f6501d).putLong(SlardarConfigConsts.MONITOR_SWITCH_CONFIG_ATRACE_FLAG, f6502e).apply();
        return;
    }

    public static void f(long r10) {
        f6502e = r10;
    }

    public static void g(int r10, int r11) {
        int r12 = f6501d;
        f6501d = (r11 & r10) + ((~r10) & r12);
    }

    public static void h(int r10, boolean r11) {
        if (r11 == false) goto L4;
        f6501d = r10 | f6501d;
        return;
    L4:
        int r12 = f6501d;
        f6501d = (~r10) & r12;
    }
}
