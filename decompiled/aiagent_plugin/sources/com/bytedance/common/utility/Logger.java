package com.bytedance.common.utility;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static b sLogWriter;

    /* JADX INFO: renamed from: com.bytedance.common.utility.Logger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a extends b {

        /* JADX INFO: renamed from: com.bytedance.common.utility.Logger$a$a, reason: collision with other inner class name */
        private static class C0149a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a f6675a = null;

            static /* synthetic */ a a() {
                return f6675a;
            }

            static {
                f6675a = new a(null);
            }
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private a() {
        }

        static a a() {
            return C0149a.a();
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void a(String r1, String r2) {
            b(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void a(String r1, String r2, Throwable r3) {
            b(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void c(String r1, String r2) {
            d(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void c(String r1, String r2, Throwable r3) {
            d(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void e(String r1, String r2) {
            f(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void e(String r1, String r2, Throwable r3) {
            f(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void g(String r1, String r2, Throwable r3) {
            h(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void g(String r1, String r2) {
            h(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void i(String r1, String r2) {
            j(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.b
        public void i(String r1, String r2, Throwable r3) {
            j(r1, r2, r3);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2, r3);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int d(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int d(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2, r3);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int f(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int f(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2, r3);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int j(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int j(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int h(String r0, String r1) {
            return Log.e(r0, r1);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int h(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static abstract class b {
        public void a(String r1, String r2) {
        }

        public void a(String r1, String r2, Throwable r3) {
        }

        public void c(String r1, String r2) {
        }

        public void c(String r1, String r2, Throwable r3) {
        }

        public void e(String r1, String r2) {
        }

        public void e(String r1, String r2, Throwable r3) {
        }

        public void g(String r1, String r2) {
        }

        public void g(String r1, String r2, Throwable r3) {
        }

        public void i(String r1, String r2) {
        }

        public void i(String r1, String r2, Throwable r3) {
        }

        public void k(String r1, String r2) {
        }

        public b() {
        }

        public boolean a(int r1) {
            if (Logger.getLogLevel() > r1) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Logger() {
    }

    public static void setLogLevel(int r0) {
        mLevel = r0;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void v(String r1) {
        v(TAG, r1);
    }

    public static void v(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.a(2) == false) goto L8;
        sLogWriter.a(r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(2) == false) goto L9;
        sLogWriter.a(r2, r3, r4);
        return;
    }

    public static void d(String r1) {
        d(TAG, r1);
    }

    public static void d(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.a(3) == false) goto L8;
        sLogWriter.c(r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(3) == false) goto L9;
        sLogWriter.c(r2, r3, r4);
        return;
    }

    public static void i(String r1) {
        i(TAG, r1);
    }

    public static void i(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.a(4) == false) goto L8;
        sLogWriter.e(r2, r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(4) == false) goto L9;
        sLogWriter.e(r2, r3, r4);
        return;
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static void w(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.a(5) == false) goto L8;
        sLogWriter.i(r2, r3);
        return;
    }

    public static void w(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(5) == false) goto L9;
        sLogWriter.i(r2, r3, r4);
        return;
    }

    public static void e(String r1) {
        e(TAG, r1);
    }

    public static void e(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.a(6) == false) goto L8;
        sLogWriter.g(r2, r3);
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.a(6) == false) goto L9;
        sLogWriter.g(r2, r3, r4);
        return;
    }

    @Deprecated
    public static void k(String r1) {
        k(TAG, r1);
    }

    @Deprecated
    public static void k(String r2, String r3) {
        if (sLogWriter.a(3) == false) goto L6;
        sLogWriter.k(r2, r3);
        return;
    }

    public static void st(String r5, int r6) {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        StringBuilder r1 = new StringBuilder();
        int r3 = 1;
    L7:
        if (r3 >= Math.min(r6, r0.length)) goto L11;
        if (r3 <= 1) goto L10;
        r1.append("\n");
    L10:
        r1.append(getSimpleClassName(r0[r3].getClassName()));
        r1.append(".");
        r1.append(r0[r3].getMethodName());
        r3 = r3 + 1;
        goto L7
    L11:
        v(r5, r1.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void throwException(Throwable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r2);
    }

    public static void alertErrorInfo(String r1) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r1);
    }

    static {
        sLogWriter = a.a();
    }

    public static void registerLogHandler(b r0) {
        sLogWriter = r0;
    }
}
