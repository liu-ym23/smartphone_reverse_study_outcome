package h2;

import android.util.Log;

/* renamed from: h2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4124a {
    public static void a(String str, String str2, Object obj) {
        Log.d(d(str), String.format(str2, obj));
    }

    public static void b(String str, String str2, Object... objArr) {
        Log.d(d(str), String.format(str2, objArr));
    }

    public static void c(String str, String str2, Throwable th) {
        Log.e(d(str), str2, th);
    }

    public static String d(String str) {
        return "TransportRuntime." + str;
    }

    public static void e(String str, String str2) {
        Log.i(d(str), str2);
    }

    public static void f(String str, String str2, Object obj) {
        Log.w(d(str), String.format(str2, obj));
    }
}
