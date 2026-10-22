package h2;

import android.util.Log;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9272a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f9273b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends j {

        /* renamed from: c, reason: collision with root package name */
        public final int f9274c;

        public a(int i10) {
            this.f9274c = i10;
        }

        @Override // h2.j
        public final void a(String str, String str2) {
            if (this.f9274c <= 3) {
                Log.d(str, str2);
            }
        }

        @Override // h2.j
        public final void b(String str, String str2) {
            if (this.f9274c <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // h2.j
        public final void c(String str, String str2, Throwable th) {
            if (this.f9274c <= 6) {
                Log.e(str, str2, th);
            }
        }

        @Override // h2.j
        public final void e(String str, String str2) {
            if (this.f9274c <= 4) {
                Log.i(str, str2);
            }
        }

        @Override // h2.j
        public final void g(String str, String str2) {
            if (this.f9274c <= 5) {
                Log.w(str, str2);
            }
        }
    }

    public static j d() {
        a aVar;
        synchronized (f9272a) {
            try {
                if (f9273b == null) {
                    f9273b = new a(3);
                }
                aVar = f9273b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
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

    public abstract void a(String str, String str2);

    public abstract void b(String str, String str2);

    public abstract void c(String str, String str2, Throwable th);

    public abstract void e(String str, String str2);

    public abstract void g(String str, String str2);
}
