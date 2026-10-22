package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Vector;

/* loaded from: classes.dex */
public class e3 {

    /* renamed from: a, reason: collision with root package name */
    public static int f16612a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f16613b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f16614c = 20;

    /* renamed from: d, reason: collision with root package name */
    public static int f16615d = 10;

    /* renamed from: e, reason: collision with root package name */
    public static int f16616e;

    @Deprecated
    public static synchronized void b(int i10, boolean z10) {
        f16612a = i10;
        f16613b = z10;
    }

    public static synchronized void c(int i10, boolean z10, int i11, int i12) {
        try {
            f16612a = i10;
            f16613b = z10;
            if (i11 < 10 || i11 > 100) {
                i11 = 20;
            }
            f16614c = i11;
            if (i11 / 5 > f16615d) {
                f16615d = i11 / 5;
            }
            f16616e = i12;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void d(Context context) {
        V1.h().f(new a(context, 2));
    }

    public static synchronized void e(X2 x22, Context context) {
        V1.h().f(new a(context, x22));
    }

    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public int f16617d;

        /* renamed from: e, reason: collision with root package name */
        public Context f16618e;

        /* renamed from: f, reason: collision with root package name */
        public X2 f16619f;

        public a(Context context, int i10) {
            this.f16618e = context;
            this.f16617d = i10;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            int i10 = this.f16617d;
            if (i10 == 1) {
                try {
                    synchronized (e3.class) {
                        try {
                            String string = Long.toString(System.currentTimeMillis());
                            K2 k2B = Q2.b(null);
                            Context context = this.f16618e;
                            Vector<C1569j2> vector = D1.f15990b;
                            Q2.d(context, k2B, "f", e3.f16612a, 2097152, "6");
                            if (k2B.f16165e == null) {
                                k2B.f16165e = new F(new W(new C1543d0(new W())));
                            }
                            Q2.e(string, this.f16619f.a(), k2B);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    C1541c2.b(th2, "ofm", "aple");
                    return;
                }
            }
            if (i10 == 2) {
                try {
                    K2 k2B2 = Q2.b(null);
                    Context context2 = this.f16618e;
                    Vector<C1569j2> vector2 = D1.f15990b;
                    Q2.d(context2, k2B2, "f", e3.f16612a, 2097152, "6");
                    k2B2.f16168h = 14400000;
                    if (k2B2.f16167g == null) {
                        F f10 = new F(new W(new C1543d0()));
                        Context context3 = this.f16618e;
                        D0 d02 = new D0();
                        String str = new String(K0.c());
                        String strN = C1567j0.n(this.f16618e);
                        String strH = S0.h();
                        String strK = S0.k();
                        String strD = S0.D(this.f16618e);
                        String strO = S0.o();
                        String str2 = Build.MANUFACTURER;
                        String str3 = Build.DEVICE;
                        String strP = C1567j0.p(this.f16618e);
                        String str4 = Build.MODEL;
                        String strK2 = C1567j0.k(this.f16618e);
                        String strH2 = C1567j0.h(this.f16618e);
                        String strA = S0.A(this.f16618e);
                        String strQ = S0.q(this.f16618e);
                        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
                        B2.a(this.f16618e);
                        k2B2.f16167g = new X(new O(context3, d02, f10, str, strN, strH, strK, strD, strO, str2, str3, "", strP, str4, strK2, strH2, strA, strQ, strValueOf, ""));
                    }
                    if (TextUtils.isEmpty(k2B2.f16169i)) {
                        k2B2.f16169i = "fKey";
                    }
                    Context context4 = this.f16618e;
                    k2B2.f16166f = new C1580m1(context4, k2B2.f16168h, k2B2.f16169i, new U0(context4, e3.f16613b, e3.f16615d * 1024, e3.f16614c * 1024, "offLocKey", e3.f16616e * 1024));
                    Q2.a(k2B2);
                } catch (Throwable th3) {
                    C1541c2.b(th3, "ofm", "uold");
                }
            }
        }

        public a(Context context, X2 x22) {
            this(context, 1);
            this.f16619f = x22;
        }
    }
}
