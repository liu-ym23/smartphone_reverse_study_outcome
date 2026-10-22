package com.apm.lite;

import android.app.Application;
import android.content.Context;
import com.apm.lite.runtime.ConfigManager;
import java.util.Random;
import r1.h;
import r1.p;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f29909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f29910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f29911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static r1.d f29912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConfigManager f29913e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f29914f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static p f29915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile String f29916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f29917i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f29918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f29919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f29920l;

    static {
        f29913e = new ConfigManager();
        f29914f = new a();
        f29915g = null;
        f29916h = null;
        f29917i = new Object();
        f29918j = true;
        f29919k = false;
        f29920l = true;
    }

    public e() {
    }

    public static void c(Application r100, Context r101) {
        if (f29910b != null) goto L6;
        f29911c = System.currentTimeMillis();
        f29909a = r101;
        f29910b = r100;
        f29916h = Long.toHexString(new Random().nextLong()) + "G";
        return;
    }

    public static p d() {
        if (f29915g != null) goto L13;
        monitor-enter(e.class);
        f29915g = new p();     // Catch: Throwable -> L9
        monitor-exit(e.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f29915g;
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static String f() {
        if (f29916h != null) goto L15;
        Object r100 = f29917i;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f29916h != null) goto L9;
        f29916h = Long.toHexString(new Random().nextLong()) + "U";     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return f29916h;
    }

    public static r1.d b() {
        if (f29912d != null) goto L6;
        f29912d = new r1.d(f29909a, new h());
    L6:
        return f29912d;
    }

    public static String a(long r100, CrashType r101, boolean r102, boolean r103) {
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append("_");
        r104.append(r101.getName());
        r104.append('_');
        r104.append(f());
        r104.append('_');
        String r105 = "normal_";
        if (r102 == false) goto L5;
        String r106 = "oom_";
    L6:
        r104.append(r106);
        r104.append(f29911c);
        r104.append('_');
        if (r103 == false) goto L9;
        r105 = "ignore_";
    L9:
        r104.append(r105);
        r104.append(Long.toHexString(new Random().nextLong()));
        r104.append("G");
        return r104.toString();
    L5:
        r106 = "normal_";
        goto L6
    }
}
