package com.bytedance.android.live.core.log;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.v;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: classes45.dex */
public class ALogger {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    private ALogger() {
    }

    private static boolean isLevelTooLow(int r100) {
        boolean r101 = ALoggerConfigHelper.f64881a;
        if (v.a() == true) goto L5;
    L7:
        boolean r102 = ALoggerConfigHelper.a().getEnableRestrictLevel();
    L8:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (r100 >= ALoggerConfigHelper.a().getRestrictLevel()) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (ALoggerConfigHelper.a().getEnableTest() == true) goto L7;
        r102 = false;
        goto L8
    }

    public static boolean isLoggable(int r100) {
        boolean r101 = ALoggerConfigHelper.f64881a;
        if (v.a() == false) goto L8;
        if (ALoggerConfigHelper.a().getEnableTest() == true) goto L8;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        return false;
    L14:
        if (isLevelTooLow(r100) == false) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (ALoggerConfigHelper.f64881a == false) goto L10;
        r102 = false;
        goto L11
    L10:
        r102 = ALoggerConfigHelper.a().getEnable();
        goto L11
    }

    public static void d(String r100, c r101) {
        print(3, r100, r101);
    }

    public static void e(String r100, Throwable r101) {
        throwable(6, r100, null, r101);
    }

    public static void i(String r100, String r101) {
        print(4, r100, r101);
    }

    public static void v(String r100, c r101) {
        print(2, r100, r101);
    }

    public static void w(String r100, Throwable r101) {
        throwable(5, r100, null, r101);
    }

    public static void d(String r100, String r101) {
        print(3, r100, r101);
    }

    public static void e(String r100, String r101) {
        print(6, r100, r101);
    }

    public static void v(String r100, String r101) {
        print(2, r100, r101);
    }

    public static void w(String r100, String r101) {
        print(5, r100, r101);
    }

    public static void bundle(int r100, String r101, Bundle r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        ALogService.bundleSafely(r100, r101, r102);
    }

    public static void e(String r100, String r101, Throwable r102) {
        throwable(6, r100, r101, r102);
    }

    public static void header(int r100, String r101, String r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        ALogService.headerSafely(r100, r101, r102);
    }

    public static void intent(int r100, String r101, Intent r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        ALogService.intentSafely(r100, r101, r102);
    }

    public static void json(int r100, String r101, String r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        ALogService.jsonSafely(r100, r101, r102);
    }

    private static void print(int r100, String r101, c r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        boolean r103 = ALoggerConfigHelper.f64881a;
        if (v.a() == true) goto L7;
    L9:
        boolean r104 = ALoggerConfigHelper.a().getEnablePreCheck();
    L10:
        if (r104 == true) goto L12;
        print(r100, r101, r102.generate());
        return;
    L12:
        if (isLoggable(r100) == false) goto L16;
        print(r100, r101, r102.generate());
        return;
    L16:
        return;
    L7:
        if (ALoggerConfigHelper.a().getEnableTest() == true) goto L9;
        r104 = false;
        goto L10
    }

    public static void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        ALogService.statcktraceSafely(r100, r101, r102);
    }

    public static void thread(int r100, String r101, Thread r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        ALogService.threadSafely(r100, r101, r102);
    }

    public static void w(String r100, String r101, Throwable r102) {
        throwable(5, r100, r101, r102);
    }

    private static void print(int r100, String r101, String r102) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        int r103 = a.f64883a;
        v.b();
        if (r100 != 2) goto L8;
        ALogService.vSafely(r101, r102);
        return;
    L8:
        if (r100 != 3) goto L10;
        ALogService.dSafely(r101, r102);
        return;
    L10:
        if (r100 != 4) goto L12;
        ALogService.iSafely(r101, r102);
        return;
    L12:
        if (r100 != 5) goto L14;
        ALogService.wSafely(r101, r102);
        return;
    L14:
        if (r100 != 6) goto L26;
        ALogService.eSafely(r101, r102);
        return;
    }

    private static void print(int r100, String r101, String r102, Throwable r103) {
        if (isLoggable(r100) == true) goto L5;
        return;
    L5:
        boolean r104 = TextUtils.isEmpty(r102);
        if (r100 != 5) goto L8;
        if (r104 == false) goto L15;
        ALogService.wSafely(r101, r103);
        return;
    L15:
        ALogService.wSafely(r101, r102, r103);
        return;
    L8:
        if (r100 != 6) goto L20;
        if (r104 == false) goto L12;
        ALogService.eSafely(r101, r103);
        return;
    L12:
        ALogService.eSafely(r101, r102, r103);
        return;
    }

    public static void throwable(int r100, String r101, String r102, Throwable r103) {
        print(r100, r101, r102, r103);
    }
}
