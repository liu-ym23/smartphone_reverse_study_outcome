package com.byted.cast.render.utils;

import com.byted.cast.common.CastLogger;

/* JADX INFO: loaded from: classes43.dex */
public class Logger {
    private static int LOG_LEVEL = 2;
    private static final String TAG = "MediaRender";
    private static CastLogger mCastLogger;

    public Logger() {
    }

    private static String prefix(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if ("".equals(r100) == false) goto L7;
        return "";
    L7:
        return r100.concat(":");
    }

    public static void setCastLogger(CastLogger r100) {
        mCastLogger = r100;
    }

    public static void setLogLevel(int r100) {
        LOG_LEVEL = r100;
    }

    public static void d(String r100, String r101) {
        CastLogger r102 = mCastLogger;
        if (r102 == null) goto L7;
        r102.d(TAG, prefix(r100) + r101);
        return;
    L7:
        if (LOG_LEVEL <= 3) goto L9;
        return;
    L9:
        prefix(r100);
    }

    public static void e(String r100, String r101) {
        CastLogger r102 = mCastLogger;
        if (r102 == null) goto L7;
        r102.e(TAG, prefix(r100) + r101);
        return;
    L7:
        if (LOG_LEVEL <= 6) goto L9;
        return;
    L9:
        prefix(r100);
    }

    public static void i(String r100, String r101) {
        CastLogger r102 = mCastLogger;
        if (r102 == null) goto L7;
        r102.i(TAG, prefix(r100) + r101);
        return;
    L7:
        if (LOG_LEVEL <= 4) goto L9;
        return;
    L9:
        prefix(r100);
    }

    public static void v(String r100, String r101) {
        CastLogger r102 = mCastLogger;
        if (r102 == null) goto L7;
        r102.v(TAG, prefix(r100) + r101);
        return;
    L7:
        if (LOG_LEVEL <= 2) goto L9;
        return;
    L9:
        prefix(r100);
    }

    public static void w(String r100, String r101) {
        CastLogger r102 = mCastLogger;
        if (r102 == null) goto L7;
        r102.w(TAG, prefix(r100) + r101);
        return;
    L7:
        if (LOG_LEVEL <= 5) goto L9;
        return;
    L9:
        prefix(r100);
    }
}
