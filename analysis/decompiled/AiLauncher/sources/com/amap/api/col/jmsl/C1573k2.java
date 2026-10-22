package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.Vector;

/* renamed from: com.amap.api.col.jmsl.k2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1573k2 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f16703a = true;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference<AbstractC1619w1> f16704b = null;

    /* renamed from: c, reason: collision with root package name */
    public static WeakReference<AbstractC1619w1> f16705c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String[] f16706d = new String[10];

    /* renamed from: e, reason: collision with root package name */
    public static int f16707e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f16708f = false;

    /* renamed from: g, reason: collision with root package name */
    public static int f16709g;

    /* renamed from: h, reason: collision with root package name */
    public static C1569j2 f16710h;

    /* renamed from: com.amap.api.col.jmsl.k2$a */
    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f16711d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f16712e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AbstractC1619w1 f16713f;

        public a(Context context, String str, AbstractC1619w1 abstractC1619w1) {
            this.f16711d = context;
            this.f16712e = str;
            this.f16713f = abstractC1619w1;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            try {
                synchronized (C1573k2.class) {
                    try {
                        K2 k2B = Q2.b(null);
                        Q2.d(this.f16711d, k2B, this.f16712e, 1000, 4096000, "1");
                        k2B.f16166f = this.f16713f;
                        if (k2B.f16167g == null) {
                            Context context = this.f16711d;
                            k2B.f16167g = new X(new O(context, new D0(), new F(new W(new C1543d0())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", C1567j0.n(context), S0.h(), S0.z(this.f16711d), C1567j0.p(this.f16711d), Build.MODEL, C1567j0.h(this.f16711d), C1567j0.k(this.f16711d), Build.VERSION.RELEASE));
                        }
                        k2B.f16168h = 3600000;
                        Q2.a(k2B);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                C1541c2.b(th2, "lg", "pul");
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.k2$b */
    public static class b extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ K2 f16714d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f16715e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ c f16716f;

        public b(K2 k22, Context context, c cVar) {
            this.f16714d = k22;
            this.f16715e = context;
            this.f16716f = cVar;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            try {
                synchronized (C1573k2.class) {
                    try {
                        K2 k22 = this.f16714d;
                        if (k22.f16167g == null) {
                            Context context = this.f16715e;
                            k22.f16167g = new X(new O(context, new D0(), new F(new W(new C1543d0())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", C1567j0.n(context), S0.h(), S0.z(this.f16715e), C1567j0.p(this.f16715e), Build.MODEL, C1567j0.h(this.f16715e), C1567j0.k(this.f16715e), Build.VERSION.RELEASE));
                        }
                        int iA = Q2.a(this.f16714d);
                        c cVar = this.f16716f;
                        if (cVar != null) {
                            cVar.f(iA);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                C1541c2.b(th, "lg", "pul");
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.k2$c */
    public interface c {
        void f(int i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00fd A[EDGE_INSN: B:53:0x00b9->B:122:0x00fd BREAK  A[LOOP:0: B:140:0x0046->B:146:0x0046], EXC_TOP_SPLITTER, PHI: r8
      0x00fd: PHI (r8v4 java.io.FileInputStream) = 
      (r8v2 java.io.FileInputStream)
      (r8v3 java.io.FileInputStream)
      (r8v7 java.io.FileInputStream)
      (r8v7 java.io.FileInputStream)
     binds: [B:67:0x00d6, B:87:0x00fb, B:56:0x00be, B:53:0x00b9] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1573k2.a(android.content.Context):void");
    }

    public static void b(Context context, AbstractC1619w1 abstractC1619w1, String str) {
        V1.h().f(new a(context, str, abstractC1619w1));
    }

    public static void c(Context context, C1569j2 c1569j2, int i10, String str, String str2) {
        String str3;
        String strA = C1604s2.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
        String strC = Q2.c(context, c1569j2);
        C1567j0.l(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strC);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(strA);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i10);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        String string = stringBuffer.toString();
        if (string == null || "".equals(string)) {
            return;
        }
        String strA2 = L1.a(str2);
        if (i10 == 1) {
            Vector<C1569j2> vector = D1.f15990b;
            str3 = Const.INTENT_KEY_PKGNAME;
        } else if (i10 == 2) {
            Vector<C1569j2> vector2 = D1.f15990b;
            str3 = Const.INTENT_KEY_UMID;
        } else {
            if (i10 != 0) {
                return;
            }
            Vector<C1569j2> vector3 = D1.f15990b;
            str3 = "c";
        }
        K2 k2B = Q2.b(null);
        k2B.f16161a = D1.a(context, str3);
        k2B.f16164d = 1000;
        k2B.f16162b = 4096000;
        k2B.f16163c = "1";
        if (k2B.f16165e == null) {
            k2B.f16165e = new C1621x(new F(new W(new C1543d0())));
        }
        try {
            Q2.e(strA2, C1604s2.t(string.replaceAll("\n", "<br/>")), k2B);
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context, K2 k22, c cVar) {
        try {
            V1.h().f(new b(k22, context, cVar));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(android.content.Context r16, java.lang.Throwable r17, int r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1573k2.e(android.content.Context, java.lang.Throwable, int, java.lang.String, java.lang.String):void");
    }

    public static void f(C1569j2 c1569j2, Context context, String str, String str2) {
        if (c1569j2 == null || !c1569j2.i() || str == null || "".equals(str)) {
            return;
        }
        c(context, c1569j2, 1, str, str2);
    }

    public static void g(Context context) {
        C1544d1 c1544d1 = new C1544d1(f16703a);
        f16703a = false;
        Vector<C1569j2> vector = D1.f15990b;
        b(context, c1544d1, "c");
    }

    public static void h(Context context) {
        WeakReference<AbstractC1619w1> weakReference = f16704b;
        if (weakReference == null || weakReference.get() == null) {
            f16704b = new WeakReference<>(new C1580m1(context, 3600000, "hKey", new F1(context, false)));
        }
        AbstractC1619w1 abstractC1619w1 = f16704b.get();
        Vector<C1569j2> vector = D1.f15990b;
        b(context, abstractC1619w1, Const.INTENT_KEY_UMID);
    }

    public static void i(Context context) {
        WeakReference<AbstractC1619w1> weakReference = f16705c;
        if (weakReference == null || weakReference.get() == null) {
            f16705c = new WeakReference<>(new C1580m1(context, 3600000, "gKey", new F1(context, false)));
        }
        AbstractC1619w1 abstractC1619w1 = f16705c.get();
        Vector<C1569j2> vector = D1.f15990b;
        b(context, abstractC1619w1, Const.INTENT_KEY_PKGNAME);
    }
}
