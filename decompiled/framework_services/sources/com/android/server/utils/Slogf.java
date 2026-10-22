package com.android.server.utils;

import android.util.Slog;
import android.util.TimingsTraceLog;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class Slogf {
    private static final Formatter sFormatter = null;
    private static final StringBuilder sMessageBuilder = null;

    static {
        TimingsTraceLog t = new TimingsTraceLog("SLog", 524288);
        t.traceBegin("static_init");
        sMessageBuilder = new StringBuilder();
        sFormatter = new Formatter(sMessageBuilder, Locale.ENGLISH);
        t.traceEnd();
    }

    private Slogf() {
        throw new UnsupportedOperationException("provides only static methods");
    }

    public static int v(String tag, String msg) {
        return Slog.v(tag, msg);
    }

    public static int v(String tag, String msg, Throwable tr) {
        return Slog.v(tag, msg, tr);
    }

    public static int d(String tag, String msg) {
        return Slog.d(tag, msg);
    }

    public static int d(String tag, String msg, Throwable tr) {
        return Slog.d(tag, msg, tr);
    }

    public static int i(String tag, String msg) {
        return Slog.i(tag, msg);
    }

    public static int i(String tag, String msg, Throwable tr) {
        return Slog.i(tag, msg, tr);
    }

    public static int w(String tag, String msg) {
        return Slog.w(tag, msg);
    }

    public static int w(String tag, String msg, Throwable tr) {
        return Slog.w(tag, msg, tr);
    }

    public static int w(String tag, Throwable tr) {
        return Slog.w(tag, tr);
    }

    public static int e(String tag, String msg) {
        return Slog.e(tag, msg);
    }

    public static int e(String tag, String msg, Throwable tr) {
        return Slog.e(tag, msg, tr);
    }

    public static int wtf(String tag, String msg) {
        return Slog.wtf(tag, msg);
    }

    public static void wtfQuiet(String tag, String msg) {
        Slog.wtfQuiet(tag, msg);
    }

    public static int wtfStack(String tag, String msg) {
        return Slog.wtfStack(tag, msg);
    }

    public static int wtf(String tag, Throwable tr) {
        return Slog.wtf(tag, tr);
    }

    public static int wtf(String tag, String msg, Throwable tr) {
        return Slog.wtf(tag, msg, tr);
    }

    public static int println(int priority, String tag, String msg) {
        return Slog.println(priority, tag, msg);
    }

    public static void v(String tag, String format, Object... args) {
        v(tag, getMessage(format, args));
    }

    public static void v(String tag, Throwable throwable, String format, Object... args) {
        v(tag, getMessage(format, args), throwable);
    }

    public static void d(String tag, String format, Object... args) {
        d(tag, getMessage(format, args));
    }

    public static void d(String tag, Throwable throwable, String format, Object... args) {
        d(tag, getMessage(format, args), throwable);
    }

    public static void i(String tag, String format, Object... args) {
        i(tag, getMessage(format, args));
    }

    public static void i(String tag, Throwable throwable, String format, Object... args) {
        i(tag, getMessage(format, args), throwable);
    }

    public static void w(String tag, String format, Object... args) {
        w(tag, getMessage(format, args));
    }

    public static void w(String tag, Throwable throwable, String format, Object... args) {
        w(tag, getMessage(format, args), throwable);
    }

    public static void e(String tag, String format, Object... args) {
        e(tag, getMessage(format, args));
    }

    public static void e(String tag, Throwable throwable, String format, Object... args) {
        e(tag, getMessage(format, args), throwable);
    }

    public static void wtf(String tag, String format, Object... args) {
        wtf(tag, getMessage(format, args));
    }

    public static void wtf(String tag, Throwable throwable, String format, Object... args) {
        wtf(tag, getMessage(format, args), throwable);
    }

    private static String getMessage(String format, Object... args) {
        StringBuilder r0 = sMessageBuilder;
        monitor-enter(r0);
        sFormatter.format(format, args);     // Catch: Throwable -> L7
        String message = sMessageBuilder.toString();     // Catch: Throwable -> L7
        sMessageBuilder.setLength(0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return message;
    L7:
        th = move-exception;
        throw th;
    }
}
