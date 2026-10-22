package com.bytedance.android.livesdk.utils;

/* JADX INFO: loaded from: classes11.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f159226a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f159227b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f159228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f159229d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f159230e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f159231f = null;

    static {
        f159226a = com.bytedance.android.live.core.setting.k.f65335a.getValue().floatValue();
        f159227b = com.bytedance.android.live.core.setting.p.f65378a.getValue().floatValue();
        f159228c = -1;
        f159229d = 1;
        f159230e = 2;
        f159231f = 3;
    }

    public static int a() {
        int r100 = f159228c;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        float r101 = f159227b;
        if (r101 <= 0.0f) goto L11;
        if (r101 > 7.15d) goto L11;
        f159228c = f159229d.intValue();
    L11:
        if (r101 <= 7.15d) goto L16;
        if (r101 > 8.8d) goto L16;
        f159228c = f159230e.intValue();
    L16:
        if (r101 <= 8.8d) goto L19;
        f159228c = f159231f.intValue();
    L19:
        return f159228c;
    }

    public static float b(boolean r100) {
        if (r100 == false) goto L6;
        return f159226a;
    L6:
        return f159227b;
    }
}
