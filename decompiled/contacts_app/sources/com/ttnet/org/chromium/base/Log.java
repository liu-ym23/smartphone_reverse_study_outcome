package com.ttnet.org.chromium.base;

import com.android.contacts.common.SimContactsConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";

    private static boolean isDebug() {
        return false;
    }

    private Log() {
    }

    private static String formatLog(String r1, Throwable r2, Object... r3) {
        if (r3 == null) goto L10;
        if (r2 != null) goto L7;
        if (r3.length <= 0) goto L7;
    L9:
        return String.format(Locale.US, r1, r3);
    L7:
        if (r3.length > 1) goto L9;
        return r1;
    L10:
        return r1;
    }

    public static String normalizeTag(String r3) {
        if (r3.startsWith(sTagPrefix) == false) goto L6;
        return r3;
    L6:
        if (r3.startsWith(sDeprecatedTagPrefix) == false) goto L8;
        int r1 = 3;
    L10:
        return sTagPrefix + r3.substring(r1, r3.length());
    L8:
        r1 = 0;
        goto L10
    }

    private static String formatLogWithStack(String r2, Throwable r3, Object... r4) {
        return "[" + getCallOrigin() + "] " + formatLog(r2, r3, r4);
    }

    public static boolean isLoggable(String r1, int r2) {
        if (isDebug() == true) goto L9;
        if (r2 > 4) goto L9;
        return false;
    L9:
        return android.util.Log.isLoggable(r1, r2);
    }

    public static void v(String r1, String r2, Object... r3) {
        if (isDebug() == true) goto L5;
        return;
    L5:
        Throwable r0 = getThrowableToLog(r3);
        String r4 = formatLogWithStack(r2, r0, r3);
        if (r0 == null) goto L8;
        android.util.Log.v(normalizeTag(r1), r4, r0);
        return;
    L8:
        android.util.Log.v(normalizeTag(r1), r4);
    }

    public static void d(String r1, String r2, Object... r3) {
        if (isDebug() == true) goto L5;
        return;
    L5:
        Throwable r0 = getThrowableToLog(r3);
        String r4 = formatLogWithStack(r2, r0, r3);
        if (r0 == null) goto L8;
        android.util.Log.d(normalizeTag(r1), r4, r0);
        return;
    L8:
        android.util.Log.d(normalizeTag(r1), r4);
    }

    public static void i(String r1, String r2, Object... r3) {
        Throwable r0 = getThrowableToLog(r3);
        String r4 = formatLog(r2, r0, r3);
        if (r0 == null) goto L5;
        android.util.Log.i(normalizeTag(r1), r4, r0);
        return;
    L5:
        android.util.Log.i(normalizeTag(r1), r4);
    }

    public static void w(String r1, String r2, Object... r3) {
        Throwable r0 = getThrowableToLog(r3);
        String r4 = formatLog(r2, r0, r3);
        if (r0 == null) goto L5;
        android.util.Log.w(normalizeTag(r1), r4, r0);
        return;
    L5:
        android.util.Log.w(normalizeTag(r1), r4);
    }

    public static void e(String r1, String r2, Object... r3) {
        Throwable r0 = getThrowableToLog(r3);
        String r4 = formatLog(r2, r0, r3);
        if (r0 == null) goto L5;
        android.util.Log.e(normalizeTag(r1), r4, r0);
        return;
    L5:
        android.util.Log.e(normalizeTag(r1), r4);
    }

    public static void wtf(String r1, String r2, Object... r3) {
        Throwable r0 = getThrowableToLog(r3);
        String r4 = formatLog(r2, r0, r3);
        if (r0 == null) goto L5;
        android.util.Log.wtf(normalizeTag(r1), r4, r0);
        return;
    L5:
        android.util.Log.wtf(normalizeTag(r1), r4);
    }

    public static String getStackTraceString(Throwable r0) {
        return android.util.Log.getStackTraceString(r0);
    }

    private static Throwable getThrowableToLog(Object[] r2) {
        if (r2 != null) goto L5;
    L12:
        return null;
    L5:
        if (r2.length == 0) goto L12;
        Object r3 = r2[r2.length - 1];
        if ((r3 instanceof Throwable) == true) goto L11;
        return null;
    L11:
        return (Throwable) r3;
    }

    private static String getCallOrigin() {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        String r1 = Log.class.getName();
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        if (r0[r2].getClassName().equals(r1) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r2 = r2 + 3;
    L10:
        return r0[r2].getFileName() + SimContactsConstants.ANR_SEP + r0[r2].getLineNumber();
    }
}
