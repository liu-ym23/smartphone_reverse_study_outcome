package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.jmsl.C1540c1;
import com.amap.api.col.jmsl.C1585n2;
import com.amap.api.col.jmsl.C1602s0;
import com.amap.api.col.jmsl.C1607t1;

/* loaded from: classes.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isContainsJsMapAssets = true;
    private static boolean isDebugMode = false;
    private static boolean isNetWorkEnable = true;
    private static boolean isPreLoadWorkerJS = false;
    private static boolean isloadWorldVectorMap = false;
    private static int mProtocol = 1;
    private static String mapLanguage = "zh_cn";
    private static String vectorMapStyle = "style_zh_cn";

    public static void debugMode(boolean z10) {
        isDebugMode = z10;
    }

    public static void disableCachedMapDataUpdate(boolean z10) {
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static String getMapLanguage() {
        return mapLanguage;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static String getVersion() {
        return "1.2.0";
    }

    public static String getWorldVectorMapStyle() {
        return vectorMapStyle;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            C1585n2.f16776f = context.getApplicationContext();
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isContainsJsMapAssets() {
        return isContainsJsMapAssets;
    }

    public static boolean isDebugMode() {
        return isDebugMode;
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isPreLoadWorkerJS() {
        return isPreLoadWorkerJS;
    }

    public static void loadWorldVectorMap(boolean z10) {
        isloadWorldVectorMap = z10;
    }

    public static void preLoadWorkerJS(boolean z10) {
        isPreLoadWorkerJS = z10;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        C1602s0.j(C1585n2.f16776f, str);
    }

    public static void setContainsJsMapAssets(boolean z10) {
        isContainsJsMapAssets = z10;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            C1540c1.f16543a = -1;
            C1540c1.f16544b = "";
        } else {
            C1540c1.f16543a = 1;
            C1540c1.f16544b = str;
        }
    }

    public static void setMapLanguage(String str) {
        mapLanguage = str;
    }

    public static void setNetWorkEnable(boolean z10) {
        isNetWorkEnable = z10;
    }

    public static void setProtocol(int i10) {
        mProtocol = i10;
        C1607t1.a().e(mProtocol == 2);
    }

    public static void setWorldVectorMapStyle(String str) {
        vectorMapStyle = str;
    }
}
