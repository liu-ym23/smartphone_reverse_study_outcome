package com.bytedance.common.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static c sLogWriter;

    public static /* synthetic */ class a {
    }

    public static final class b extends c {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f6834a = null;

            static {
                f6834a = new b(null);
            }

            public static /* synthetic */ b a() {
                return f6834a;
            }
        }

        public /* synthetic */ b(a r10) {
            this();
        }

        public static b m() {
            return a.a();
        }

        @Override // r0.a.c
        public void b(String r10, String r11) {
            Log.d(r10, r11);
        }

        @Override // r0.a.c
        public void c(String r10, String r11, Throwable r12) {
            Log.d(r10, r11, r12);
        }

        @Override // r0.a.c
        public void d(String r10, String r11) {
            Log.e(r10, r11);
        }

        @Override // r0.a.c
        public void e(String r10, String r11, Throwable r12) {
            Log.e(r10, r11, r12);
        }

        @Override // r0.a.c
        public void f(String r10, String r11) {
            Log.i(r10, r11);
        }

        @Override // r0.a.c
        public void g(String r10, String r11, Throwable r12) {
            Log.i(r10, r11, r12);
        }

        @Override // r0.a.c
        public void i(String r10, String r11) {
            Log.v(r10, r11);
        }

        @Override // r0.a.c
        public void j(String r10, String r11, Throwable r12) {
            Log.v(r10, r11, r12);
        }

        @Override // r0.a.c
        public void k(String r10, String r11) {
            Log.w(r10, r11);
        }

        @Override // r0.a.c
        public void l(String r10, String r11, Throwable r12) {
            Log.w(r10, r11, r12);
        }

        public b() {
        }
    }

    public static abstract class c extends r0.a.c {
        public c() {
        }

        @Override // r0.a.c
        public boolean a(int r10) {
            if (Logger.getLogLevel() > r10) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // r0.a.c
        public void h(String r10, String r11) {
        }
    }

    static {
        sLogWriter = b.m();
    }

    public Logger() {
    }

    public static void alertErrorInfo(String r10) {
        r0.a.a(r10);
    }

    public static void d(String r10) {
        r0.a.b(r10);
    }

    public static boolean debug() {
        return r0.a.e();
    }

    public static void e(String r10) {
        r0.a.f(r10);
    }

    public static int getLogLevel() {
        return r0.a.i();
    }

    private static String getSimpleClassName(String r10) {
        int r11 = r10.lastIndexOf(46);
        if (r11 >= 0) goto L6;
        return r10;
    L6:
        return r10.substring(r11 + 1);
    }

    public static void i(String r10) {
        r0.a.k(r10);
    }

    @Deprecated
    public static void k(String r10) {
        r0.a.n(r10);
    }

    public static void registerLogHandler(c r10) {
        r0.a.p(r10);
    }

    public static void setLogLevel(int r10) {
        r0.a.q(r10);
    }

    public static void st(String r10, int r11) {
        r0.a.r(r10, r11);
    }

    public static void throwException(Throwable r10) {
        r0.a.s(r10);
    }

    public static void v(String r10) {
        r0.a.t(r10);
    }

    public static void w(String r10) {
        r0.a.w(r10);
    }

    public static void d(String r10, String r11) {
        r0.a.c(r10, r11);
    }

    public static void e(String r10, String r11) {
        r0.a.g(r10, r11);
    }

    public static void i(String r10, String r11) {
        r0.a.l(r10, r11);
    }

    @Deprecated
    public static void k(String r10, String r11) {
        r0.a.o(r10, r11);
    }

    public static void v(String r10, String r11) {
        r0.a.u(r10, r11);
    }

    public static void w(String r10, String r11) {
        r0.a.x(r10, r11);
    }

    public static void d(String r10, String r11, Throwable r12) {
        r0.a.d(r10, r11, r12);
    }

    public static void e(String r10, String r11, Throwable r12) {
        r0.a.h(r10, r11, r12);
    }

    public static void i(String r10, String r11, Throwable r12) {
        r0.a.m(r10, r11, r12);
    }

    public static void v(String r10, String r11, Throwable r12) {
        r0.a.v(r10, r11, r12);
    }

    public static void w(String r10, String r11, Throwable r12) {
        r0.a.y(r10, r11, r12);
    }
}
