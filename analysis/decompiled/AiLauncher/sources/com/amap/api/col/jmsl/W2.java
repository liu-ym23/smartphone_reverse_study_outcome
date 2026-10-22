package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1573k2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class W2 {

    /* renamed from: a, reason: collision with root package name */
    public Context f16425a;

    /* renamed from: b, reason: collision with root package name */
    public C1569j2 f16426b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16427c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16428d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16429e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16430f = false;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f16431g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public C1550f f16432h = new C1550f((byte) 0);

    /* renamed from: i, reason: collision with root package name */
    public C1550f f16433i = new C1550f();

    /* renamed from: j, reason: collision with root package name */
    public C1573k2.c f16434j = new a();

    /* renamed from: k, reason: collision with root package name */
    public C1573k2.c f16435k = new b();

    /* renamed from: l, reason: collision with root package name */
    public Handler f16436l = null;

    /* renamed from: m, reason: collision with root package name */
    public K2 f16437m = null;

    /* renamed from: n, reason: collision with root package name */
    public K2 f16438n = null;

    public class a implements C1573k2.c {

        /* renamed from: com.amap.api.col.jmsl.W2$a$a, reason: collision with other inner class name */
        public class RunnableC0201a implements Runnable {
            public RunnableC0201a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                W2.this.f(false);
            }
        }

        public a() {
        }

        @Override // com.amap.api.col.jmsl.C1573k2.c
        public final void f(int i10) {
            if (i10 > 0 && W2.b(W2.this) != null) {
                ((d3) W2.i(W2.this).f16166f).f(i10);
                W2.e(W2.this, "error", String.valueOf(((d3) W2.i(W2.this).f16166f).h()));
                W2.b(W2.this).postDelayed(new RunnableC0201a(), 660000L);
            }
        }
    }

    public class b implements C1573k2.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                W2.this.j(false);
            }
        }

        public b() {
        }

        @Override // com.amap.api.col.jmsl.C1573k2.c
        public final void f(int i10) {
            if (i10 <= 0) {
                return;
            }
            ((d3) W2.p(W2.this).f16166f).f(i10);
            W2.e(W2.this, "info", String.valueOf(((d3) W2.p(W2.this).f16166f).h()));
            if (W2.b(W2.this) == null) {
                return;
            }
            W2.b(W2.this).postDelayed(new a(), 660000L);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, W2> f16443a = new HashMap();
    }

    public W2(C1569j2 c1569j2) {
        this.f16426b = c1569j2;
    }

    public static /* synthetic */ Handler b(W2 w22) {
        if (w22.f16425a == null) {
            return null;
        }
        if (w22.f16436l == null) {
            w22.f16436l = new Handler(w22.f16425a.getMainLooper());
        }
        return w22.f16436l;
    }

    public static W2 c(C1569j2 c1569j2) {
        if (c1569j2 == null || TextUtils.isEmpty(c1569j2.g())) {
            return null;
        }
        if (c.f16443a.get(c1569j2.g()) == null) {
            c.f16443a.put(c1569j2.g(), new W2(c1569j2));
        }
        return c.f16443a.get(c1569j2.g());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.content.Context r3, java.lang.String r4, com.amap.api.col.jmsl.C1569j2 r5) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            if (r5 == 0) goto L19
            java.lang.String r1 = r5.g()     // Catch: java.lang.Throwable -> L46
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L46
            if (r1 != 0) goto L19
            java.lang.String r5 = r5.g()     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = com.amap.api.col.jmsl.L1.c(r5)     // Catch: java.lang.Throwable -> L46
            goto L1b
        L19:
            java.lang.String r5 = "a"
        L1b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            r1.<init>()     // Catch: java.lang.Throwable -> L46
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L46
            r1.append(r3)     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L46
            r1.append(r3)     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = "EBDEC84EF205FEA2DF0719DEB822869E"
            r1.append(r2)     // Catch: java.lang.Throwable -> L46
            r1.append(r3)     // Catch: java.lang.Throwable -> L46
            r1.append(r4)     // Catch: java.lang.Throwable -> L46
            r1.append(r3)     // Catch: java.lang.Throwable -> L46
            r1.append(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L46
            return r3
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.W2.d(android.content.Context, java.lang.String, com.amap.api.col.jmsl.j2):java.lang.String");
    }

    public static /* synthetic */ void e(W2 w22, String str, String str2) {
        try {
            String str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
            C1586o.a(w22.f16426b).d(w22.f16425a, "", "", str3 + str, str2);
        } catch (Throwable unused) {
        }
    }

    public static K2 i(W2 w22) {
        K2 k22 = w22.f16438n;
        if (k22 != null) {
            return k22;
        }
        w22.l();
        return w22.f16438n;
    }

    public static K2 p(W2 w22) {
        K2 k22 = w22.f16437m;
        if (k22 != null) {
            return k22;
        }
        w22.o();
        return w22.f16437m;
    }

    public final long a(String str) {
        try {
            String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
            return Long.parseLong(C1586o.a(this.f16426b).c(this.f16425a, "", "", str2 + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final void f(boolean z10) {
        K2 k2H = h(2);
        if (z10) {
            ((d3) k2H.f16166f).g(z10);
        }
        Context context = this.f16425a;
        if (context == null) {
            return;
        }
        C1573k2.d(context, k2H, this.f16434j);
    }

    public void g(boolean z10, boolean z11, boolean z12, boolean z13, List<String> list) {
        this.f16427c = z10;
        this.f16428d = z11;
        this.f16429e = z12;
        this.f16430f = z13;
        this.f16431g = list;
        l();
        o();
    }

    public final K2 h(int i10) {
        if (i10 == 2) {
            K2 k22 = this.f16438n;
            if (k22 == null) {
                if (k22 == null) {
                    l();
                    k22 = this.f16438n;
                }
                this.f16438n = k22;
            }
            return this.f16438n;
        }
        K2 k23 = this.f16437m;
        if (k23 == null) {
            if (k23 == null) {
                o();
                k23 = this.f16437m;
            }
            this.f16437m = k23;
        }
        return this.f16437m;
    }

    public final void j(boolean z10) {
        K2 k2H = h(1);
        if (z10) {
            ((d3) k2H.f16166f).g(z10);
        }
        Context context = this.f16425a;
        if (context == null) {
            return;
        }
        C1573k2.d(context, k2H, this.f16435k);
    }

    public final boolean k() {
        return this.f16425a != null;
    }

    public final K2 l() {
        Context context = this.f16425a;
        if (context == null) {
            return null;
        }
        K2 k22 = new K2();
        this.f16438n = k22;
        k22.f16161a = d(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f16426b);
        K2 k23 = this.f16438n;
        k23.f16162b = 512000000L;
        k23.f16164d = 12500;
        k23.f16163c = "1";
        k23.f16168h = -1;
        k23.f16169i = "elkey";
        long jA = a("error");
        K2 k24 = this.f16438n;
        k24.f16166f = new d3(true, new F1(this.f16425a, this.f16428d), jA, 10000000);
        k24.f16167g = null;
        return k24;
    }

    public void n(boolean z10) {
        if (k()) {
            f(z10);
            j(z10);
        }
    }

    public final K2 o() {
        Context context = this.f16425a;
        if (context == null) {
            return null;
        }
        K2 k22 = new K2();
        this.f16437m = k22;
        k22.f16161a = d(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f16426b);
        K2 k23 = this.f16437m;
        k23.f16162b = 512000000L;
        k23.f16164d = 12500;
        k23.f16163c = "1";
        k23.f16168h = -1;
        k23.f16169i = "inlkey";
        long jA = a("info");
        K2 k24 = this.f16437m;
        k24.f16166f = new d3(this.f16430f, new F1(this.f16425a, this.f16428d), jA, 30000000);
        k24.f16167g = null;
        return k24;
    }
}
