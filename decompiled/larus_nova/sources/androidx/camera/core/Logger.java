package androidx.camera.core;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    public static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    private Logger() {
    }

    public static int getMinLogLevel() {
        return sMinLogLevel;
    }

    public static boolean isDebugEnabled(String r100) {
        return isLogLevelEnabled(truncateTag(r100), 3);
    }

    public static boolean isErrorEnabled(String r100) {
        return isLogLevelEnabled(truncateTag(r100), 6);
    }

    public static boolean isInfoEnabled(String r100) {
        return isLogLevelEnabled(truncateTag(r100), 4);
    }

    public static boolean isVerboseEnabled(String r100) {
        return isLogLevelEnabled(truncateTag(r100), 2);
    }

    public static boolean isWarnEnabled(String r100) {
        return isLogLevelEnabled(truncateTag(r100), 5);
    }

    public static void setMinLogLevel(int r100) {
        sMinLogLevel = r100;
    }

    private static String truncateTag(String r100) {
        if (Build.VERSION.SDK_INT <= 25) goto L5;
        return r100;
    L5:
        if (23 < r100.length()) goto L7;
        return r100;
    L7:
        return r100.substring(0, 23);
    }

    public static void d(String r100, String r101) {
        isLogLevelEnabled(truncateTag(r100), 3);
    }

    public static void e(String r100, String r101) {
        isLogLevelEnabled(truncateTag(r100), 6);
    }

    public static void i(String r100, String r101) {
        isLogLevelEnabled(truncateTag(r100), 4);
    }

    private static boolean isLogLevelEnabled(String r100, int r101) {
        if (sMinLogLevel > r101) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable(r100, r101) == true) goto L8;
        return false;
    }

    public static void w(String r100, String r101) {
        isLogLevelEnabled(truncateTag(r100), 5);
    }

    public static void d(String r100, String r101, Throwable r102) {
        isLogLevelEnabled(truncateTag(r100), 3);
    }

    public static void e(String r100, String r101, Throwable r102) {
        isLogLevelEnabled(truncateTag(r100), 6);
    }

    public static void i(String r100, String r101, Throwable r102) {
        isLogLevelEnabled(truncateTag(r100), 4);
    }

    public static void w(String r100, String r101, Throwable r102) {
        isLogLevelEnabled(truncateTag(r100), 5);
    }
}
