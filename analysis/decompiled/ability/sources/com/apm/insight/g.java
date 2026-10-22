package com.apm.insight;

import android.app.Application;
import android.content.Context;
import com.apm.insight.runtime.ConfigManager;
import fa.C1449a;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import w0.C2085f;
import w2.k;
import w2.n;
import w2.o;

/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static Context f2160a = null;
    public static Application b = null;
    public static long c = 0;
    public static String d = "default";
    public static boolean e = false;
    public static A5.c f;
    public static final ConfigManager g = new ConfigManager();
    public static final u1.d h;
    public static volatile ConcurrentHashMap i;

    /* renamed from: j, reason: collision with root package name */
    public static C1449a f2161j;
    public static volatile String k;
    public static final Object l;
    public static volatile int m;
    public static volatile String n;
    public static int o;
    public static f2.a p;

    /* renamed from: q, reason: collision with root package name */
    public static int f2162q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f2163r;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f2164s;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f2165t;
    public static boolean u;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f2166v;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f2167w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f2168x;

    static {
        u1.d dVar = new u1.d(9, false);
        dVar.b = new HashMap();
        dVar.c = new HashMap();
        dVar.d = new HashMap();
        dVar.e = null;
        h = dVar;
        f2161j = null;
        k = null;
        l = new Object();
        m = 0;
        o = 0;
        p = null;
        f2162q = ExitType.NONE.type;
        f2163r = false;
        f2164s = true;
        f2165t = true;
        u = true;
        f2166v = false;
        f2167w = true;
        f2168x = false;
    }

    public static A5.c a() {
        if (f == null) {
            f = new A5.c(f2160a, new C2085f(10), (A5.c) null);
        }
        return f;
    }

    public static String b(long j5, CrashType crashType, boolean z10, boolean z11) {
        StringBuilder sb = new StringBuilder();
        sb.append(j5);
        sb.append("_");
        sb.append(crashType.getName());
        sb.append('_');
        sb.append(g());
        sb.append('_');
        sb.append(z10 ? "oom_" : "normal_");
        sb.append(c);
        sb.append('_');
        sb.append(z11 ? "ignore_" : "normal_");
        sb.append(Long.toHexString(new Random().nextLong()));
        sb.append("G");
        return sb.toString();
    }

    public static w2.b c(String str, HashMap map, boolean z10) {
        f2.a aVar = p;
        return (aVar == null || (aVar instanceof k)) ? new n(map, str, z10) : new o(map, str, z10);
    }

    public static void d(Application application, Context context) {
        if (b == null) {
            c = System.currentTimeMillis();
            f2160a = context;
            b = application;
            k = Long.toHexString(new Random().nextLong()) + "G";
        }
    }

    public static C1449a e() {
        if (f2161j == null) {
            synchronized (g.class) {
                C1449a c1449a = new C1449a(11);
                c1449a.b = null;
                c1449a.c = null;
                f2161j = c1449a;
            }
        }
        return f2161j;
    }

    public static String f() {
        return g() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static String g() {
        if (k == null) {
            synchronized (l) {
                try {
                    if (k == null) {
                        k = Long.toHexString(new Random().nextLong()) + "U";
                    }
                } finally {
                }
            }
        }
        return k;
    }
}
