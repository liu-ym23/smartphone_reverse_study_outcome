package net.zetetic.database;

/* loaded from: classes2.dex */
public class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LogTarget target;

    static {
        setTarget(new LogcatTarget());
    }

    public static void d(String str, String str2) {
        getTarget().log(3, str, str2, null);
    }

    public static void e(String str, String str2) {
        getTarget().log(6, str, str2, null);
    }

    private static LogTarget getTarget() {
        if (target == null) {
            setTarget(new NoopTarget());
        }
        return target;
    }

    public static void i(String str, String str2) {
        getTarget().log(4, str, str2, null);
    }

    public static boolean isLoggable(String str, int i4) {
        return getTarget().isLoggable(str, i4);
    }

    public static void setTarget(LogTarget logTarget) {
        target = logTarget;
    }

    public static void v(String str, String str2) {
        getTarget().log(2, str, str2, null);
    }

    public static void w(String str, String str2) {
        getTarget().log(5, str, str2, null);
    }

    public static void wtf(String str, String str2) {
        getTarget().log(7, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        getTarget().log(3, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        getTarget().log(6, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        getTarget().log(4, str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        getTarget().log(2, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        getTarget().log(5, str, str2, th);
    }

    public static void wtf(String str, String str2, Throwable th) {
        getTarget().log(7, str, str2, th);
    }
}
