package com.bytedance.android.livesdk.performance;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f154833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f154834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f154835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f154836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f154837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f154838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f154839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f154840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f154841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f154842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f154843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f154844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f154845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f154846n;

    static {
        f154833a = "";
        f154834b = "";
        f154835c = "";
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopType");
        long r101 = System.currentTimeMillis() - f154839g;
        HashMap r102 = new HashMap();
        r102.put("enter_from_merge", f154833a);
        r102.put("enter_method", f154834b);
        r102.put("room_id", f154835c);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_STOP_TYPE, r100);
        r102.put("battery_level", String.valueOf(f154837e));
        if (f154836d == false) goto L5;
        String r103 = "1";
    L6:
        r102.put("is_charging", r103);
        r102.put("low_duration", String.valueOf(r101));
        qm0.b r104 = om0.c.g();
        if (r104 == null) goto L9;
        r104.sendLog("livesdk_live_lowbattery_stop", r102, new Object[0]);
    L9:
        f154838f = false;
        return;
    L5:
        r103 = "0";
        goto L6
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopType");
        long r101 = System.currentTimeMillis() - f154841i;
        HashMap r102 = new HashMap();
        r102.put("enter_from_merge", f154833a);
        r102.put("enter_method", f154834b);
        r102.put("room_id", f154835c);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_STOP_TYPE, r100);
        r102.put("low_duration", String.valueOf(r101));
        qm0.b r103 = om0.c.g();
        if (r103 == null) goto L5;
        r103.sendLog("livesdk_live_overheating_stop", r102, new Object[0]);
    L5:
        f154840h = false;
    }
}
