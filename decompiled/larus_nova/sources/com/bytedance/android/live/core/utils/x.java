package com.bytedance.android.live.core.utils;

/* JADX INFO: loaded from: classes45.dex */
public final class x {
    public static String a(long r100) {
        if (r100 != (-1)) goto L7;
        return "---";
    L7:
        if (r100 >= 10000) goto L11;
        return String.valueOf(r100);
    L11:
        if (r100 >= 100000000) goto L15;
        return com.bytedance.android.livesdk.utils.r1.a(Double.valueOf((r100 * 1.0d) / 10000.0d)) + "万";
    L15:
        return com.bytedance.android.livesdk.utils.r1.a(Double.valueOf((r100 * 1.0d) / 1.0E8d)) + "亿";
    }

    public static String b(long r100) {
        if (r100 >= 10000) goto L6;
        return String.valueOf(r100);
    L6:
        return com.bytedance.android.livesdk.utils.r1.b("%.1f", new Object[]{Double.valueOf((r100 * 1.0d) / 10000.0d)}) + "w";
    }

    public static String c(long r100) {
        if (r100 < 100000000) goto L7;
        return com.bytedance.android.livesdk.utils.r1.b("%.1f", new Object[]{Double.valueOf((r100 * 1.0d) / 1.0E8d)}) + "亿";
    L7:
        if (r100 < 10000) goto L11;
        return com.bytedance.android.livesdk.utils.r1.b("%.1f", new Object[]{Double.valueOf((r100 * 1.0d) / 10000.0d)}) + "万";
    L11:
        return String.valueOf(r100);
    }
}
