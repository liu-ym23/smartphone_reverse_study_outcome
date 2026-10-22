package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/* renamed from: com.amap.api.col.jmsl.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1594q {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f16799a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f16800b;

    public static void b(Context context) {
        V1.h().f(new a(context, 3));
    }

    public static void c(Context context, byte[] bArr) throws IOException {
        K2 k2B = Q2.b(null);
        k2B.f16161a = D1.a(context, "e");
        k2B.f16164d = 1000;
        k2B.f16162b = 307200;
        k2B.f16163c = "2";
        if (k2B.f16165e == null) {
            k2B.f16165e = new C1590p();
        }
        try {
            Q2.e(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, k2B);
        } catch (Throwable th) {
            C1541c2.b(th, "stm", "wts");
        }
    }

    public static synchronized void d(C1558h c1558h, Context context) {
        V1.h().f(new a(context, 1, c1558h));
    }

    public static synchronized void e(List<C1558h> list, Context context) {
        try {
            List<C1558h> listO = C1615v1.o();
            if (listO != null && listO.size() > 0) {
                list.addAll(listO);
            }
        } catch (Throwable unused) {
        }
        g(list, context);
    }

    public static synchronized void f(boolean z10, int i10) {
        f16799a = z10;
        f16800b = Math.max(0, i10);
    }

    public static synchronized void g(List<C1558h> list, Context context) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    V1.h().f(new a(context, 2, list));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.amap.api.col.jmsl.q$a */
    public static class a extends AbstractRunnableC1545d2 {

        /* renamed from: d, reason: collision with root package name */
        public Context f16801d;

        /* renamed from: e, reason: collision with root package name */
        public C1558h f16802e;

        /* renamed from: f, reason: collision with root package name */
        public int f16803f;

        /* renamed from: g, reason: collision with root package name */
        public List<C1558h> f16804g;

        public a(Context context, int i10) {
            this.f16801d = context;
            this.f16803f = i10;
        }

        @Override // com.amap.api.col.jmsl.AbstractRunnableC1545d2
        public final void runTask() {
            C1558h c1558h;
            byte[] byteArray;
            ByteArrayOutputStream byteArrayOutputStream;
            int i10 = this.f16803f;
            if (i10 == 1) {
                try {
                    if (this.f16801d != null && this.f16802e != null) {
                        synchronized (C1594q.class) {
                            try {
                                Context context = this.f16801d;
                                if (context != null && (c1558h = this.f16802e) != null) {
                                    C1594q.c(context, c1558h.b());
                                    return;
                                }
                                return;
                            } finally {
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    C1541c2.b(th, "stm", "as");
                    return;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (i10 != 2) {
                if (i10 == 3) {
                    try {
                        if (this.f16801d == null) {
                            return;
                        }
                        K2 k2B = Q2.b(null);
                        Context context2 = this.f16801d;
                        Vector<C1569j2> vector = D1.f15990b;
                        Q2.d(context2, k2B, "e", 1000, 307200, "2");
                        if (k2B.f16167g == null) {
                            k2B.f16167g = new C1625y(new C1547e0(this.f16801d, new G(new C1579m0(new D0()))));
                        }
                        k2B.f16168h = 3600000;
                        if (TextUtils.isEmpty(k2B.f16169i)) {
                            k2B.f16169i = "cKey";
                        }
                        if (k2B.f16166f == null) {
                            Context context3 = this.f16801d;
                            k2B.f16166f = new C1580m1(context3, k2B.f16168h, k2B.f16169i, new M0(30, k2B.f16161a, new U0(context3, C1594q.f16799a, 20480, 20480, "staticUpdate", C1594q.f16800b * 1024)));
                        }
                        Q2.a(k2B);
                        return;
                    } catch (Throwable th2) {
                        C1541c2.b(th2, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (C1594q.class) {
                    try {
                        if (this.f16804g != null && this.f16801d != null) {
                            try {
                                byteArray = new byte[0];
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                            try {
                                for (C1558h c1558h2 : this.f16804g) {
                                    if (c1558h2 != null) {
                                        byteArrayOutputStream.write(c1558h2.b());
                                    }
                                }
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                try {
                                    C1541c2.b(th, "stm", "aStB");
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    C1594q.c(this.f16801d, byteArray);
                                } finally {
                                }
                            }
                            C1594q.c(this.f16801d, byteArray);
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                C1541c2.b(th7, "stm", "apb");
            }
        }

        public a(Context context, int i10, List<C1558h> list) {
            this(context, i10);
            this.f16804g = list;
        }

        public a(Context context, int i10, C1558h c1558h) {
            this(context, i10);
            this.f16802e = c1558h;
        }
    }
}
