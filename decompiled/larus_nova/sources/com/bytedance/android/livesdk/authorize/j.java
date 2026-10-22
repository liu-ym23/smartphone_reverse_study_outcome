package com.bytedance.android.livesdk.authorize;

import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class j {
    static {
    }

    public static Pair a(int r100, int r101, int r102) {
        if (r100 != 22) goto L5;
        String r103 = "减" + r102 + "优惠券";
        String r104 = String.valueOf(r102);
    L10:
        return new Pair(r103, r104);
    L5:
        if (r100 == 26) goto L7;
        r103 = "";
        new Pair("", "");
        r104 = "";
        goto L10
    L7:
        r103 = "满" + r101 + "减" + r102 + "优惠券";
        r104 = String.valueOf(r102);
        goto L10
    }
}
