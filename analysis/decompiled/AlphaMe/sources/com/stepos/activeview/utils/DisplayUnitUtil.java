package com.stepos.activeview.utils;

import android.content.Context;

/* loaded from: classes.dex */
public class DisplayUnitUtil {
    static final String DISPLAY_UNIT_DIP = "dip";
    static final String DISPLAY_UNIT_DP = "dp";
    static final String DISPLAY_UNIT_PX = "px";
    static final String DISPLAY_UNIT_SP = "sp";
    private static final String LOG_TAG = "DisplayUnitUtil";

    public static int dip2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getPixelValue(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            return 0;
        }
        String str2 = str.endsWith(DISPLAY_UNIT_SP) ? DISPLAY_UNIT_SP : str.endsWith(DISPLAY_UNIT_DP) ? DISPLAY_UNIT_DP : str.endsWith(DISPLAY_UNIT_DIP) ? DISPLAY_UNIT_DIP : DISPLAY_UNIT_PX;
        try {
            return str2.equals(DISPLAY_UNIT_DP) ? dip2px(context, Float.parseFloat(str.substring(0, str.length() - 2))) : str2.equals(DISPLAY_UNIT_DIP) ? dip2px(context, Float.parseFloat(str.substring(0, str.length() - 3))) : str2.equals(DISPLAY_UNIT_SP) ? sp2px(context, Float.parseFloat(str.substring(0, str.length() - 2))) : (int) Float.parseFloat(str.substring(0, str.length() - 2));
        } catch (Exception e4) {
            LogUtil.e(LOG_TAG, "Exception =" + e4.toString());
            return 0;
        }
    }

    public static int px2dip(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int getPixelValue(Context context, String str, float f4) {
        if (context == null || str == null || str.isEmpty()) {
            return (int) f4;
        }
        if (str.equals(DISPLAY_UNIT_DP)) {
            return dip2px(context, f4);
        }
        if (str.equals(DISPLAY_UNIT_DIP)) {
            return dip2px(context, f4);
        }
        return str.equals(DISPLAY_UNIT_SP) ? sp2px(context, f4) : (int) f4;
    }
}
