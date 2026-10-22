package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.fg0;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f154427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f154428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f154429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f154430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f154431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f154432f;

    public static int a() {
        if (fg0.f120201a.getValue().booleanValue() == false) goto L6;
        return 0;
    L6:
        if (f154427a > 0) goto L8;
    L10:
        int r100 = 0;
    L12:
        if (f154428b == false) goto L14;
    L15:
        r100 = r100 + 1;
    L17:
        if (f154430d == false) goto L20;
        r100 = r100 + 1;
    L20:
        if (f154431e <= 100) goto L23;
        r100 = r100 + 1;
    L23:
        if (f154432f <= 900) goto L25;
        r100 = r100 + 1;
    L25:
        StringBuilder r101 = new StringBuilder("perf risk evaluate finish: ");
        if (r100 < 2) goto L28;
        int r102 = 1;
    L29:
        r101.append(r102);
        ALogger.e("wujl", r101.toString());
        if (r100 < 2) goto L33;
        return 1;
    L33:
        return 0;
    L28:
        r102 = 0;
        goto L29
    L14:
        if (f154429c >= 20) goto L17;
    L8:
        if ((System.currentTimeMillis() - f154427a) <= 1800000) goto L10;
        r100 = 1;
        goto L12
    }

    static {
    }
}
