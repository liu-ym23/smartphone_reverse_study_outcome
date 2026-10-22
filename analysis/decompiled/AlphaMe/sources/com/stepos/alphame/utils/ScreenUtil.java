package com.stepos.alphame.utils;

import android.content.Context;

/* loaded from: classes.dex */
public class ScreenUtil {
    public static float dip2Px(Context context, float f4) {
        return (f4 <= Property.DEFAULT_FLOAT_VALUE || context == null) ? Property.DEFAULT_FLOAT_VALUE : (f4 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int dip2px(Context context, float f4) {
        if (f4 <= Property.DEFAULT_FLOAT_VALUE || context == null) {
            return 0;
        }
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, int i4) {
        if (i4 <= 0 || context == null) {
            return 0;
        }
        return (int) ((i4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
