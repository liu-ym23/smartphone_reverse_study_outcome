package Z7;

import android.util.Log;
import java.util.Locale;

/* renamed from: Z7.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1139k {

    /* renamed from: a, reason: collision with root package name */
    public static String f7546a = "CrashReportInfo";

    /* renamed from: b, reason: collision with root package name */
    public static String f7547b = "CrashReport";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7548c = false;

    public static boolean a(int i10, String str, Object... objArr) {
        if (!f7548c) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i10 == 0) {
            Log.i(f7547b, str);
            return true;
        }
        if (i10 == 1) {
            Log.d(f7547b, str);
            return true;
        }
        if (i10 == 2) {
            Log.w(f7547b, str);
            return true;
        }
        if (i10 == 3) {
            Log.e(f7547b, str);
            return true;
        }
        if (i10 != 5) {
            return false;
        }
        Log.i(f7546a, str);
        return true;
    }

    public static boolean b(int i10, Throwable th) {
        if (f7548c) {
            return a(i10, C1143o.l(th), new Object[0]);
        }
        return false;
    }

    public static boolean c(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean e(Throwable th) {
        return b(2, th);
    }

    public static boolean f(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean g(Throwable th) {
        return b(3, th);
    }

    public static boolean h(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean i(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean j(String str, Object... objArr) {
        return a(3, str, objArr);
    }
}
