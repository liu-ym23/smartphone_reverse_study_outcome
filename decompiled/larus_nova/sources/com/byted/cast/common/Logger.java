package com.byted.cast.common;

import com.byted.cast.common.api.ILogger;

/* JADX INFO: loaded from: classes39.dex */
public class Logger {
    public Logger() {
    }

    public static int getLogLevel() {
        return CastLogger.getInstance().getLogLevel();
    }

    public static void d(String r100) {
        CastLogger.getInstance().d(r100);
    }

    public static void e(String r100) {
        CastLogger.getInstance().e(r100);
    }

    public static void i(String r100) {
        CastLogger.getInstance().i(r100);
    }

    public static void setEnable(boolean r100) {
        CastLogger.getInstance().setEnable(r100);
    }

    public static void setLogLevel(int r100) {
        CastLogger.getInstance().setLogLevel(r100);
    }

    public static void setLogger(ILogger r100) {
        CastLogger.getInstance().setLogger(r100);
    }

    public static void v(String r100) {
        CastLogger.getInstance().v(r100);
    }

    public static void w(String r100) {
        CastLogger.getInstance().w(r100);
    }

    public static void d(String r100, String r101) {
        CastLogger.getInstance().d(r100, r101);
    }

    public static void e(String r100, String r101) {
        CastLogger.getInstance().e(r100, r101);
    }

    public static void i(String r100, String r101) {
        CastLogger.getInstance().i(r100, r101);
    }

    public static void v(String r100, String r101) {
        CastLogger.getInstance().v(r100, r101);
    }

    public static void w(String r100, String r101) {
        CastLogger.getInstance().w(r100, r101);
    }

    public static void e(String r100, String r101, Throwable r102) {
        CastLogger.getInstance().e(r100, r101, r102);
    }

    public static void logger(String r100, int r101, String r102, String r103) {
        CastLogger.logger(r100, r101, r102, r103);
    }
}
