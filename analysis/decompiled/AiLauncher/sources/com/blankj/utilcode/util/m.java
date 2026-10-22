package com.blankj.utilcode.util;

import android.content.res.Resources;

/* loaded from: classes.dex */
public final class m {
    public static int a(float f10) {
        return (int) ((f10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
