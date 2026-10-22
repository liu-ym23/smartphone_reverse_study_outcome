package com.baidu.platform.comapi.util;

import android.graphics.Color;

/* JADX INFO: loaded from: classes39.dex */
public class d {
    public static int[] a(int[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L14;
        int[] r101 = new int[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = Color.argb(Color.alpha(r100[r102]), Color.blue(r100[r102]), Color.green(r100[r102]), Color.red(r100[r102]));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L14:
        return null;
    }
}
