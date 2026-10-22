package com.baidu.platform.comapi.util;

import android.graphics.Color;

/* loaded from: classes.dex */
public class d {
    public static int[] a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr2[i4] = Color.argb(Color.alpha(iArr[i4]), Color.blue(iArr[i4]), Color.green(iArr[i4]), Color.red(iArr[i4]));
        }
        return iArr2;
    }
}
