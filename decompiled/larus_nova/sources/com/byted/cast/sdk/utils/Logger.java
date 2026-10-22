package com.byted.cast.sdk.utils;

import com.byted.cast.common.api.ILogger;

/* JADX INFO: loaded from: classes43.dex */
public class Logger {
    private static int LOG_LEVEL = 4;
    private static String TAG = "BYTELINK";
    private static ILogger sLogger;

    public Logger() {
    }

    private static int transNativeLogLevelToJava(int r100) {
        if (r100 == (-1)) goto L19;
        if (r100 != 0) goto L6;
        return 6;
    L6:
        if (r100 != 1) goto L8;
        return 5;
    L8:
        if (r100 != 3) goto L10;
        return 3;
    L10:
        if (r100 == 4) goto L12;
        return 4;
    L12:
        return 2;
    L19:
        return 7;
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

    public static void setLogLevel(int r100) {
        LOG_LEVEL = r100;
    }

    public static void setLogger(ILogger r100) {
        sLogger = r100;
    }

    public static void d(String r100, String r101) {
        if (LOG_LEVEL <= 3) goto L5;
        return;
    L5:
        ILogger r102 = sLogger;
        if (r102 == null) goto L8;
        r102.onDebug(TAG, prefix(r100) + r101);
        return;
    L8:
        prefix(r100);
    }

    public static void e(String r100, String r101) {
        if (LOG_LEVEL <= 6) goto L5;
        return;
    L5:
        ILogger r102 = sLogger;
        if (r102 == null) goto L8;
        r102.onError(TAG, prefix(r100) + r101);
        return;
    L8:
        prefix(r100);
    }

    public static void i(String r100, String r101) {
        if (LOG_LEVEL <= 4) goto L5;
        return;
    L5:
        ILogger r102 = sLogger;
        if (r102 == null) goto L8;
        r102.onInfo(TAG, prefix(r100) + r101);
        return;
    L8:
        prefix(r100);
    }

    public static void v(String r100, String r101) {
        if (LOG_LEVEL <= 2) goto L5;
        return;
    L5:
        ILogger r102 = sLogger;
        if (r102 == null) goto L8;
        r102.onVerbose(TAG, prefix(r100) + r101);
        return;
    L8:
        prefix(r100);
    }

    public static void w(String r100, String r101) {
        if (LOG_LEVEL <= 5) goto L5;
        return;
    L5:
        ILogger r102 = sLogger;
        if (r102 == null) goto L8;
        r102.onWarn(TAG, prefix(r100) + r101);
        return;
    L8:
        prefix(r100);
    }

    public static void logger(int r100, String r101, String r102) {
        switch(transNativeLogLevelToJava(r100)) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L9;
            default: goto L15;
        };
    L5:
        e(r101, r102);
        return;
    L6:
        w(r101, r102);
        return;
    L7:
        i(r101, r102);
        return;
    L8:
        d(r101, r102);
        return;
    L9:
        v(r101, r102);
        return;
    }
}
