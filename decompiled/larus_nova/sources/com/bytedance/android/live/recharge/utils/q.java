package com.bytedance.android.live.recharge.utils;

/* JADX INFO: loaded from: classes47.dex */
public final class q {
    public static final String a(long r100) {
        if ((r100 % 100) == 0) goto L5;
        Object[] r101 = new Object[1];
        if (r100 > 0) goto L9;
        float r102 = 0.0f;
    L10:
        r101[0] = Float.valueOf(r102);
        return com.bytedance.android.live.revenue.common.l.a("%.1f", r101);
    L9:
        r102 = r100 / 100.0f;
        goto L10
    L5:
        return String.valueOf(r100 / 100);
    }

    public static final String b(long r100) {
        if ((r100 % 100) == 0) goto L5;
        Object[] r101 = new Object[1];
        if (r100 > 0) goto L9;
        float r102 = 0.0f;
    L10:
        r101[0] = Float.valueOf(r102);
        return com.bytedance.android.live.revenue.common.l.a("%.2f", r101);
    L9:
        r102 = r100 / 100.0f;
        goto L10
    L5:
        return String.valueOf(r100 / 100);
    }
}
