package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FunctionSwitcher.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f4697a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f4698b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f4699c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f4700d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4701e = 0;
    private static int f = 100;

    static {
    }

    public static synchronized void a(Context r4) {
        monitor-enter(a.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (f4697a == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f4697a = true;     // Catch: Throwable -> L17
        if (f4698b != null) goto L12;
        f4698b = r5.getSharedPreferences("monitor_switch_config", 0);     // Catch: Throwable -> L17
    L12:
        SharedPreferences r6 = f4698b;     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        int r7 = r6.getInt("monitor_switch_config_first_flag", 0);     // Catch: Throwable -> L17
        f4699c = r7;     // Catch: Throwable -> L17
        f4700d = r7;     // Catch: Throwable -> L17
        f4701e = f4698b.getLong("monitor_switch_config_atrace_flag", 0);     // Catch: Throwable -> L17
        f = f4698b.getInt("monitor_thread_info_count", 100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(a.class);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void a(int r0, boolean r1) {
        if (r1 == false) goto L4;
        f4700d = r0 | f4700d;
        return;
    L4:
        int r2 = f4700d;
        f4700d = (~r0) & r2;
    }

    public static void a(int r0) {
        if (r0 <= 0) goto L5;
        f = r0;
        return;
    }

    public static void a(int r1, int r2) {
        int r0 = f4700d;
        f4700d = (r2 & r1) + ((~r1) & r0);
    }

    public static void a(long r0) {
        f4701e = r0;
    }

    public static void a() {
        SharedPreferences r0 = f4698b;
        if (r0 == null) goto L6;
        r0.edit().putInt("monitor_switch_config_first_flag", f4700d).putLong("monitor_switch_config_atrace_flag", f4701e).putInt("monitor_thread_info_count", f).apply();
        return;
    }

    public static boolean b(int r1) {
        if ((r1 & f4699c) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static long b() {
        return f4701e;
    }

    public static int c() {
        return (f4699c & (-536870912)) >>> 29;
    }

    public static int d() {
        return f;
    }
}
