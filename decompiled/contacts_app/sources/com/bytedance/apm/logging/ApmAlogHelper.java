package com.bytedance.apm.logging;

import com.bytedance.apm6.foundation.UnSampleListener;

/* JADX INFO: loaded from: classes2.dex */
public class ApmAlogHelper {
    private static IApmAlog sApmLogger = null;
    private static boolean sEnable = true;
    private static boolean sFeedbackALogEnabled;
    private static IApmAlog sInnerLogger;
    private static volatile UnSampleListener unSampleListener;

    static {
    }

    public ApmAlogHelper() {
    }

    public static void setEnable(boolean r0) {
        sEnable = r0;
    }

    public static void setFeedbackALogEnabled(boolean r0) {
        sFeedbackALogEnabled = r0;
    }

    public static boolean isFeedbackALogEnabled() {
        return sFeedbackALogEnabled;
    }

    public static void setApmLogger(IApmAlog r0) {
        sApmLogger = r0;
        if (r0 == null) goto L6;
        sEnable = true;
        return;
    }

    public static void setUnSampleListener(UnSampleListener r0) {
        unSampleListener = r0;
    }

    public static IApmAlog getApmLogger() {
        return sApmLogger;
    }

    public static void d(String r1, String r2) {
        if (sEnable == false) goto L8;
        IApmAlog r0 = sApmLogger;
        if (r0 == null) goto L9;
        r0.d(r1, r2);
        return;
    L9:
        return;
    }

    public static void e(String r1, String r2) {
        if (sEnable == false) goto L8;
        IApmAlog r0 = sApmLogger;
        if (r0 == null) goto L9;
        r0.e(r1, r2);
        return;
    L9:
        return;
    }

    public static void i(String r1, String r2) {
        if (sEnable == false) goto L8;
        IApmAlog r0 = sApmLogger;
        if (r0 == null) goto L9;
        r0.i(r1, r2);
        return;
    L9:
        return;
    }

    public static void feedbackI(String r1, String r2) {
        if (sFeedbackALogEnabled == false) goto L8;
        IApmAlog r0 = sApmLogger;
        if (r0 == null) goto L9;
        r0.i(r1, r2);
        return;
    L9:
        return;
    }

    public static void onUnSampleLog(String r1, String r2) {
        if (unSampleListener == null) goto L6;
        unSampleListener.onLog(r1, r2);
        return;
    }

    public static boolean isUnSampleEnable() {
        if (unSampleListener == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static void setApmInnerAlog(IApmAlog r0) {
        sInnerLogger = r0;
    }

    public static IApmAlog getInnerLogger() {
        return sInnerLogger;
    }
}
