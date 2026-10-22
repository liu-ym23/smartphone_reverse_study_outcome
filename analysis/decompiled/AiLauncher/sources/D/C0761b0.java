package D;

import android.util.Log;

/* renamed from: D.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0761b0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f2084a = 3;

    public static void a(String str, String str2) {
        String strN = n(str);
        if (i(strN, 3)) {
            Log.d(strN, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        String strN = n(str);
        if (i(strN, 3)) {
            Log.d(strN, str2, th);
        }
    }

    public static void c(String str, String str2) {
        String strN = n(str);
        if (i(strN, 6)) {
            Log.e(strN, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String strN = n(str);
        if (i(strN, 6)) {
            Log.e(strN, str2, th);
        }
    }

    public static void e(String str, String str2) {
        String strN = n(str);
        if (i(strN, 4)) {
            Log.i(strN, str2);
        }
    }

    public static boolean f(String str) {
        return i(n(str), 3);
    }

    public static boolean g(String str) {
        return i(n(str), 6);
    }

    public static boolean h(String str) {
        return i(n(str), 4);
    }

    public static boolean i(String str, int i10) {
        return f2084a <= i10 || Log.isLoggable(str, i10);
    }

    public static boolean j(String str) {
        return i(n(str), 2);
    }

    public static boolean k(String str) {
        return i(n(str), 5);
    }

    public static void l() {
        f2084a = 3;
    }

    public static void m(int i10) {
        f2084a = i10;
    }

    public static String n(String str) {
        return str;
    }

    public static void o(String str, String str2) {
        String strN = n(str);
        if (i(strN, 5)) {
            Log.w(strN, str2);
        }
    }

    public static void p(String str, String str2, Throwable th) {
        String strN = n(str);
        if (i(strN, 5)) {
            Log.w(strN, str2, th);
        }
    }
}
