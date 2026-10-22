package R1;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f4965a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static int f4966b = 3;

    /* renamed from: c, reason: collision with root package name */
    public static int f4967c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static int f4968d = 5;

    /* renamed from: e, reason: collision with root package name */
    public static int f4969e = 6;

    /* renamed from: f, reason: collision with root package name */
    private static int f4970f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static Set<b> f4971g;

    public static void a(String str, String str2) {
        g(f4966b, str, str2);
    }

    public static void b(String str, String str2) {
        g(f4969e, str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        h(f4969e, str, str2, th);
    }

    public static void d(String str, Throwable th) {
        i(f4969e, str, th);
    }

    public static void e(String str, String str2) {
        g(f4967c, str, str2);
    }

    public static boolean f(String str, int i5) {
        return Log.isLoggable(str, i5);
    }

    private static void g(int i5, String str, String str2) {
        h(i5, str, str2, null);
    }

    private static void h(int i5, String str, String str2, Throwable th) {
        try {
            if (f4971g != null && f4970f <= i5) {
                if (TextUtils.isEmpty(str2) && th == null) {
                    return;
                }
                Iterator<b> it = f4971g.iterator();
                while (it.hasNext()) {
                    it.next().a(i5, str, str2, th);
                }
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    private static void i(int i5, String str, Throwable th) {
        h(i5, str, BuildConfig.FLAVOR, th);
    }

    public static void j(c cVar) {
        f4970f = cVar.b();
        f4971g = cVar.a();
    }

    public static void k(String str, String str2) {
        g(f4965a, str, str2);
    }

    public static void l(String str, String str2) {
        g(f4968d, str, str2);
    }

    public static void m(String str, String str2, Throwable th) {
        h(f4968d, str, str2, th);
    }

    public static void n(String str, Throwable th) {
        i(f4968d, str, th);
    }
}
