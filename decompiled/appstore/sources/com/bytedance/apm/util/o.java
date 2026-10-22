package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static String a(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException(r11 + " must not be empty");
    }

    public static String b(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        Log.w("apm", r11 + " is empty, please make sure");
    L5:
        return r10;
    }

    public static Object c(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11 + " must not be null");
    }
}
