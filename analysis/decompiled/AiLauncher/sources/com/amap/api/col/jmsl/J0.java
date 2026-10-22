package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.PublicKey;

/* loaded from: classes.dex */
public class J0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f16109a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f16110b = true;

    public static class a {

        /* renamed from: A, reason: collision with root package name */
        public String f16111A;

        /* renamed from: a, reason: collision with root package name */
        public String f16112a;

        /* renamed from: b, reason: collision with root package name */
        public String f16113b;

        /* renamed from: c, reason: collision with root package name */
        public String f16114c;

        /* renamed from: d, reason: collision with root package name */
        public String f16115d;

        /* renamed from: e, reason: collision with root package name */
        public String f16116e;

        /* renamed from: f, reason: collision with root package name */
        public String f16117f;

        /* renamed from: g, reason: collision with root package name */
        public String f16118g;

        /* renamed from: h, reason: collision with root package name */
        public String f16119h;

        /* renamed from: i, reason: collision with root package name */
        public String f16120i;

        /* renamed from: j, reason: collision with root package name */
        public String f16121j;

        /* renamed from: k, reason: collision with root package name */
        public String f16122k;

        /* renamed from: l, reason: collision with root package name */
        public String f16123l;

        /* renamed from: m, reason: collision with root package name */
        public String f16124m;

        /* renamed from: n, reason: collision with root package name */
        public String f16125n;

        /* renamed from: o, reason: collision with root package name */
        public String f16126o;

        /* renamed from: p, reason: collision with root package name */
        public String f16127p;

        /* renamed from: q, reason: collision with root package name */
        public String f16128q;

        /* renamed from: r, reason: collision with root package name */
        public String f16129r;

        /* renamed from: s, reason: collision with root package name */
        public String f16130s;

        /* renamed from: t, reason: collision with root package name */
        public String f16131t;

        /* renamed from: u, reason: collision with root package name */
        public String f16132u;

        /* renamed from: v, reason: collision with root package name */
        public String f16133v;

        /* renamed from: w, reason: collision with root package name */
        public String f16134w;

        /* renamed from: x, reason: collision with root package name */
        public String f16135x;

        /* renamed from: y, reason: collision with root package name */
        public String f16136y;

        /* renamed from: z, reason: collision with root package name */
        public String f16137z;

        public a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.amap.api.col.jmsl.J0.a a(android.content.Context r5, boolean r6, boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.J0.a(android.content.Context, boolean, boolean, boolean):com.amap.api.col.jmsl.J0$a");
    }

    public static String b() {
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String str = !C1567j0.f() ? "0" : "1";
            int length = strValueOf.length();
            return strValueOf.substring(0, length - 2) + str + strValueOf.substring(length - 1);
        } catch (Throwable th) {
            C1611u1.b(th, "CI", "TS");
            return null;
        }
    }

    public static String c(Context context) {
        try {
            return C1568j1.g(f(context, a(context, false, false, false)));
        } catch (Throwable th) {
            C1611u1.b(th, "CI", "gCXi");
            return null;
        }
    }

    public static String d(Context context, String str, String str2) {
        try {
            return L1.c(C1567j0.q(context) + ServerSentEventKt.COLON + str.substring(0, str.length() - 3) + ServerSentEventKt.COLON + str2);
        } catch (Throwable th) {
            C1611u1.b(th, "CI", "Sco");
            return null;
        }
    }

    public static void e(ByteArrayOutputStream byteArrayOutputStream, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            C1604s2.g(byteArrayOutputStream, (byte) 0, new byte[0]);
        } else {
            C1604s2.g(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, C1604s2.t(str));
        }
    }

    public static byte[] f(Context context, a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArrC;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            e(byteArrayOutputStream, aVar.f16112a);
            e(byteArrayOutputStream, aVar.f16113b);
            e(byteArrayOutputStream, aVar.f16114c);
            e(byteArrayOutputStream, aVar.f16115d);
            e(byteArrayOutputStream, aVar.f16116e);
            e(byteArrayOutputStream, aVar.f16117f);
            e(byteArrayOutputStream, aVar.f16118g);
            e(byteArrayOutputStream, aVar.f16119h);
            e(byteArrayOutputStream, aVar.f16120i);
            e(byteArrayOutputStream, aVar.f16121j);
            e(byteArrayOutputStream, aVar.f16122k);
            e(byteArrayOutputStream, aVar.f16123l);
            e(byteArrayOutputStream, aVar.f16124m);
            e(byteArrayOutputStream, aVar.f16125n);
            e(byteArrayOutputStream, aVar.f16126o);
            e(byteArrayOutputStream, aVar.f16127p);
            e(byteArrayOutputStream, aVar.f16128q);
            e(byteArrayOutputStream, aVar.f16129r);
            e(byteArrayOutputStream, aVar.f16130s);
            e(byteArrayOutputStream, aVar.f16131t);
            e(byteArrayOutputStream, null);
            e(byteArrayOutputStream, null);
            e(byteArrayOutputStream, aVar.f16132u);
            e(byteArrayOutputStream, aVar.f16133v);
            e(byteArrayOutputStream, aVar.f16134w);
            e(byteArrayOutputStream, aVar.f16135x);
            e(byteArrayOutputStream, aVar.f16136y);
            e(byteArrayOutputStream, aVar.f16137z);
            e(byteArrayOutputStream, aVar.f16111A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] bArrU = C1604s2.u(byteArray);
            PublicKey publicKeyE = C1604s2.e();
            if (bArrU.length > 117) {
                byte[] bArr = new byte[117];
                System.arraycopy(bArrU, 0, bArr, 0, 117);
                byte[] bArrC2 = C1568j1.c(bArr, publicKeyE);
                bArrC = new byte[bArrU.length + 11];
                System.arraycopy(bArrC2, 0, bArrC, 0, 128);
                System.arraycopy(bArrU, 117, bArrC, 128, bArrU.length - 117);
            } else {
                bArrC = C1568j1.c(bArrU, publicKeyE);
            }
            try {
                byteArrayOutputStream.close();
                return bArrC;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return bArrC;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                C1611u1.b(th, "CI", "gzx");
                return null;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public static byte[] g(Context context, boolean z10, boolean z11) {
        try {
            return f(context, a(context, z10, z11, false));
        } catch (Throwable th) {
            C1611u1.b(th, "CI", "gz");
            return null;
        }
    }

    public static String h(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.f16115d = C1567j0.p(context);
            aVar.f16120i = C1567j0.k(context);
            return C1568j1.g(f(context, aVar));
        } catch (Throwable th) {
            C1611u1.b(th, "CI", "IX");
            return null;
        }
    }
}
