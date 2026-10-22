package s0;

import android.util.Log;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f14211b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile t f14212c;

    /* renamed from: a, reason: collision with root package name */
    public final int f14213a;

    public t(int i4) {
        this.f14213a = i4;
    }

    public static t d() {
        t tVar;
        synchronized (f14211b) {
            try {
                if (f14212c == null) {
                    f14212c = new t(3);
                }
                tVar = f14212c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public final void a(String str, String str2) {
        if (this.f14213a <= 3) {
            Log.d(str, str2);
        }
    }

    public final void b(String str, String str2) {
        if (this.f14213a <= 6) {
            Log.e(str, str2);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (this.f14213a <= 6) {
            Log.e(str, str2, th);
        }
    }

    public final void e(String str, String str2) {
        if (this.f14213a <= 4) {
            Log.i(str, str2);
        }
    }

    public final void g(String str, String str2) {
        if (this.f14213a <= 5) {
            Log.w(str, str2);
        }
    }
}
