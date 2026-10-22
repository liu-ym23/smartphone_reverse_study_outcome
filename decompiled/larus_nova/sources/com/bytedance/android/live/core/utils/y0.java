package com.bytedance.android.live.core.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes45.dex */
public final class y0 {
    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = String.valueOf(-1);
    L6:
        if (r100.contains("_") == false) goto L8;
        return r100;
    L8:
        return TextUtils.concat(new CharSequence[]{r100, "_", String.valueOf(0)}).toString();
    }

    public static boolean a(String r100, String r101) {
        return TextUtils.equals(b(r100), b(r101));
    }
}
