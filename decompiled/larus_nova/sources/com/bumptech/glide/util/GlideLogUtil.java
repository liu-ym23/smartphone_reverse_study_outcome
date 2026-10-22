package com.bumptech.glide.util;

import com.larksuite.framework.utils.LogSafetyTools;
import com.ss.android.lark.log.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes39.dex */
public class GlideLogUtil {
    private static final String LOG_TAG = "GlideLogUtil_";
    private static final int MAX_LOAD_FAILED_COUNT = 1;
    private static boolean sEnableGlideWriter = true;
    private static AtomicInteger sLoadFailedCount;

    public GlideLogUtil() {
    }

    static {
        sLoadFailedCount = new AtomicInteger(0);
    }

    public static void incrementErrorCount() {
        sLoadFailedCount.incrementAndGet();
    }

    private static boolean needWriteLogToFile() {
        if (sEnableGlideWriter == true) goto L5;
    L7:
        return false;
    L5:
        if (sLoadFailedCount.get() < 1) goto L7;
        return true;
    }

    public static void enableGlideWriter(boolean r100) {
        sEnableGlideWriter = r100;
    }

    public static void d(String r100, String r101) {
        if (needWriteLogToFile() == false) goto L6;
        Log.d(LOG_TAG + r100, LogSafetyTools.a(r101));
        return;
    }

    public static void e(String r100, String r101) {
        if (needWriteLogToFile() == false) goto L6;
        Log.e(LOG_TAG + r100, LogSafetyTools.a(r101));
        return;
    }

    public static void i(String r100, String r101) {
        if (needWriteLogToFile() == false) goto L6;
        Log.i(LOG_TAG + r100, LogSafetyTools.a(r101));
        return;
    }

    public static void v(String r100, String r101) {
        if (needWriteLogToFile() == false) goto L6;
        Log.v(LOG_TAG + r100, LogSafetyTools.a(r101));
        return;
    }

    public static void w(String r100, String r101) {
        if (needWriteLogToFile() == false) goto L6;
        Log.w(LOG_TAG + r100, LogSafetyTools.a(r101));
        return;
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (needWriteLogToFile() == false) goto L6;
        Log.e(LOG_TAG + r100, LogSafetyTools.a(r101), r102);
        return;
    }
}
