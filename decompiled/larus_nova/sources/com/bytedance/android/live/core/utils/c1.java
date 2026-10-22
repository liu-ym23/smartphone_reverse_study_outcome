package com.bytedance.android.live.core.utils;

import android.util.Pair;

/* JADX INFO: loaded from: classes45.dex */
public final class c1 {
    public static String a(long r110) {
        if (r110 >= 10000) goto L7;
        return String.valueOf(r110);
    L7:
        if (r110 >= 100000000) goto L14;
        long r111 = (r110 * 10) / 10000;
        if ((r111 % 10) != 0) goto L11;
        String r112 = (r111 / 10) + "";
    L13:
        return r112 + "万";
    L11:
        r112 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r111 / 10.0f)});
        goto L13
    L14:
        long r113 = (r110 * 10) / 100000000;
        if ((r113 % 10) != 0) goto L17;
        String r114 = (r113 / 10) + "";
    L19:
        return r114 + "亿";
    L17:
        r114 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r113 / 10.0f)});
        goto L19
    }

    public static Pair<String, String> b(long r110) {
        if (r110 >= 10000) goto L7;
        return new Pair(String.valueOf(r110), "");
    L7:
        if (r110 >= 100000000) goto L14;
        long r111 = (r110 * 10) / 10000;
        if ((r111 % 10) != 0) goto L11;
        String r112 = (r111 / 10) + "";
    L13:
        return new Pair(r112, "万");
    L11:
        r112 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r111 / 10.0f)});
        goto L13
    L14:
        long r113 = (r110 * 10) / 100000000;
        if ((r113 % 10) != 0) goto L17;
        String r114 = (r113 / 10) + "";
    L19:
        return new Pair(r114, "亿");
    L17:
        r114 = FormatUtils.format("%.1f", new Object[]{Float.valueOf(r113 / 10.0f)});
        goto L19
    }
}
