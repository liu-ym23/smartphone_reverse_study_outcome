package com.stepos.cloudsdk;

import android.util.Log;

/* loaded from: classes.dex */
public final class Logger {
    private static final String TAG_PREFIX = "CloudSDK_";
    private static boolean sEnabled = true;
    private static int sLogLevel = 2;

    private Logger() {
        throw new AssertionError("No Logger instances for you!");
    }

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    private static String makeTag(String str) {
        return TAG_PREFIX + str;
    }

    public static void v(String str, String str2) {
        if (!sEnabled || sLogLevel > 2) {
            return;
        }
        Log.v(makeTag(str), str2);
    }

    public static void v(String str, String str2, Throwable th) {
        if (!sEnabled || sLogLevel > 2) {
            return;
        }
        Log.v(makeTag(str), str2, th);
    }

    public static void d(String str, String str2) {
        if (!sEnabled || sLogLevel > 3) {
            return;
        }
        Log.d(makeTag(str), str2);
    }

    public static void d(String str, String str2, Throwable th) {
        if (!sEnabled || sLogLevel > 3) {
            return;
        }
        Log.d(makeTag(str), str2, th);
    }

    public static void i(String str, String str2) {
        if (!sEnabled || sLogLevel > 4) {
            return;
        }
        Log.i(makeTag(str), str2);
    }

    public static void i(String str, String str2, Throwable th) {
        if (!sEnabled || sLogLevel > 4) {
            return;
        }
        Log.i(makeTag(str), str2, th);
    }

    public static void w(String str, String str2) {
        if (!sEnabled || sLogLevel > 5) {
            return;
        }
        Log.w(makeTag(str), str2);
    }

    public static void w(String str, String str2, Throwable th) {
        if (!sEnabled || sLogLevel > 5) {
            return;
        }
        Log.w(makeTag(str), str2, th);
    }

    public static void w(String str, Throwable th) {
        if (!sEnabled || sLogLevel > 5) {
            return;
        }
        Log.w(makeTag(str), th);
    }

    public static void e(String str, String str2) {
        if (!sEnabled || sLogLevel > 6) {
            return;
        }
        Log.e(makeTag(str), str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (!sEnabled || sLogLevel > 6) {
            return;
        }
        Log.e(makeTag(str), str2, th);
    }

    public static void wtf(String str, String str2) {
        if (sEnabled) {
            Log.wtf(makeTag(str), str2);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sEnabled) {
            Log.wtf(makeTag(str), str2, th);
        }
    }

    public static void wtf(String str, Throwable th) {
        if (sEnabled) {
            Log.wtf(makeTag(str), th);
        }
    }

    public static void printStackTrace(String str) {
        if (!sEnabled || sLogLevel > 3) {
            return;
        }
        Log.d(makeTag(str), Log.getStackTraceString(new Throwable("Stack trace")));
    }

    public static void df(String str, String str2, Object... objArr) {
        if (!sEnabled || sLogLevel > 3) {
            return;
        }
        Log.d(makeTag(str), String.format(str2, objArr));
    }

    public static void inf(String str, String str2, Object... objArr) {
        if (!sEnabled || sLogLevel > 4) {
            return;
        }
        Log.i(makeTag(str), String.format(str2, objArr));
    }

    public static void ef(String str, String str2, Object... objArr) {
        if (!sEnabled || sLogLevel > 6) {
            return;
        }
        Log.e(makeTag(str), String.format(str2, objArr));
    }
}
