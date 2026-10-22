package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: classes39.dex */
public class SysOSUtil {
    public static String getAuthToken() {
        return g.a();
    }

    public static int getDensityDpi() {
        return g.d();
    }

    public static String getDeviceID() {
        String r100 = g.c();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        return r100.substring(0, r100.indexOf(HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
    }

    public static String getModuleFileName() {
        return g.e();
    }

    public static String getNetType() {
        return g.f();
    }

    public static String getPhoneType() {
        return g.l();
    }

    public static int getScreenSizeX() {
        return g.m();
    }

    public static int getScreenSizeY() {
        return g.n();
    }

    public SysOSUtil() {
    }

    public static float getDensity() {
        return g.f32353y;
    }

    public static void updateCuid() {
        g.c();
    }
}
