package com.autonavi.amap.mapcore.tools;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes39.dex */
public class GlMapUtil {
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1 = 2;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_1_EAGLE_EYE = 3;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2 = 4;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_2_EAGLE_EYE = 5;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3 = 6;
    public static final int AMAP_ENGINE_TYPE_DISPLAY_EXTERNAL_3_EAGLE_EYE = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1 = 3;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_1_EAGLE_EYE = 4;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2 = 5;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_2_EAGLE_EYE = 6;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3 = 7;
    public static final int AN_ENGINE_ID_DISPLAY_EXTERNAL_3_EAGLE_EYE = 8;
    public static final int AN_ENGINE_ID_EAGLE_EYE = 2;
    public static final int AN_ENGINE_ID_INVALID = -1;
    public static final int AN_ENGINE_ID_MAIN = 1;
    public static final int DEVICE_DISPLAY_DPI_HIGH = 320;
    public static final int DEVICE_DISPLAY_DPI_LOW = 120;
    public static final int DEVICE_DISPLAY_DPI_MEDIAN = 240;
    public static final int DEVICE_DISPLAY_DPI_NORMAL = 160;
    public static final int DEVICE_DISPLAY_DPI_XHIGH = 480;
    public static final int DEVICE_DISPLAY_DPI_XXHIGH = 640;

    public GlMapUtil() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_autonavi_amap_mapcore_tools_GlMapUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String getAppVersionName(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;
    L4:
        return "";
    }

    public static boolean isAssic(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L14;
        char r103 = r101[r102];
        if (r103 >= 256) goto L13;
        if (r103 <= 0) goto L13;
        r102 = r102 + 1;
    L13:
        return false;
    L14:
        return true;
    }

    public static int dipToPixel(Context r100, int r101) {
        if (r100 != null) goto L9;
        return r101;
    L9:
        return (int) TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_autonavi_amap_mapcore_tools_GlMapUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    L8:
        return r101;
    }

    public static String getString(Context r100, int r101) {
        return r100.getResources().getString(r101);
    }

    public static int spToPixel(Context r100, int r101) {
        return (int) TypedValue.applyDimension(2, r101, INVOKEVIRTUAL_com_autonavi_amap_mapcore_tools_GlMapUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }
}
