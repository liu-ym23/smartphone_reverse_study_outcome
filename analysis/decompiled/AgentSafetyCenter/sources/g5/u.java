package g5;

import android.util.Log;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f4342b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile u f4343c;

    /* renamed from: a, reason: collision with root package name */
    public final int f4344a;

    public u(int i) {
        this.f4344a = i;
    }

    public static u d() {
        u uVar;
        synchronized (f4342b) {
            try {
                if (f4343c == null) {
                    f4343c = new u(3);
                }
                uVar = f4343c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        if (length >= 20) {
            sb2.append(str.substring(0, 20));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public final void a(String str, String str2) {
        if (this.f4344a <= 3) {
            Log.d(str, str2);
        }
    }

    public final void b(String str, String str2) {
        if (this.f4344a <= 6) {
            Log.e(str, str2);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (this.f4344a <= 6) {
            Log.e(str, str2, th);
        }
    }

    public final void e(String str, String str2) {
        if (this.f4344a <= 4) {
            Log.i(str, str2);
        }
    }

    public final void g(String str, String str2) {
        if (this.f4344a <= 5) {
            Log.w(str, str2);
        }
    }
}
