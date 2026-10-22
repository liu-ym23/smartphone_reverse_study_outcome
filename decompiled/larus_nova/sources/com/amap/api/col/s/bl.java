package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes28.dex */
public final class bl {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f26251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f26252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f26253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f26254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f26255f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f26256g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f26257h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f26258i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        String f26259j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        String f26260k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f26261l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f26262m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f26263n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        String f26264o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f26265p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        String f26266q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        String f26267r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        String f26268s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        String f26269t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        String f26270u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        String f26271v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        String f26272w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        String f26273x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f26274y;

        private a() {
        }

        public /* synthetic */ a(byte r100) {
            this();
        }
    }

    public static String a() {
        String r100 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        String r101 = "1";
        if (bi.a() == true) goto L6;
        r101 = "0";
    L6:
        int r102 = r100.length();     // Catch: Throwable -> L8
        return r100.substring(0, r102 - 2) + r101 + r100.substring(r102 - 1);
    L8:
        th = move-exception;
        cd.a(th, "CI", "TS");
        return null;
    }

    private static byte[] a(a r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        a(r101, r100.f26250a);     // Catch: Throwable -> L13
        a(r101, r100.f26251b);     // Catch: Throwable -> L13
        a(r101, r100.f26252c);     // Catch: Throwable -> L13
        a(r101, r100.f26253d);     // Catch: Throwable -> L13
        a(r101, r100.f26254e);     // Catch: Throwable -> L13
        a(r101, r100.f26255f);     // Catch: Throwable -> L13
        a(r101, r100.f26256g);     // Catch: Throwable -> L13
        a(r101, r100.f26257h);     // Catch: Throwable -> L13
        a(r101, r100.f26258i);     // Catch: Throwable -> L13
        a(r101, r100.f26259j);     // Catch: Throwable -> L13
        a(r101, r100.f26260k);     // Catch: Throwable -> L13
        a(r101, r100.f26261l);     // Catch: Throwable -> L13
        a(r101, r100.f26262m);     // Catch: Throwable -> L13
        a(r101, r100.f26263n);     // Catch: Throwable -> L13
        a(r101, r100.f26264o);     // Catch: Throwable -> L13
        a(r101, r100.f26265p);     // Catch: Throwable -> L13
        a(r101, r100.f26266q);     // Catch: Throwable -> L13
        a(r101, r100.f26267r);     // Catch: Throwable -> L13
        a(r101, r100.f26268s);     // Catch: Throwable -> L13
        a(r101, r100.f26269t);     // Catch: Throwable -> L13
        a(r101, r100.f26270u);     // Catch: Throwable -> L13
        a(r101, r100.f26271v);     // Catch: Throwable -> L13
        a(r101, r100.f26272w);     // Catch: Throwable -> L13
        a(r101, r100.f26273x);     // Catch: Throwable -> L13
        a(r101, r100.f26274y);     // Catch: Throwable -> L13
        byte[] r102 = bs.b(r101.toByteArray());     // Catch: Throwable -> L13
        PublicKey r103 = bs.d();     // Catch: Throwable -> L13
        if (r102.length <= 117) goto L7;
        byte[] r104 = new byte[117];     // Catch: Throwable -> L13
        System.arraycopy(r102, 0, r104, 0, 117);     // Catch: Throwable -> L13
        byte[] r105 = bn.a(r104, r103);     // Catch: Throwable -> L13
        byte[] r106 = new byte[(r102.length + 128) - 117];     // Catch: Throwable -> L13
        System.arraycopy(r105, 0, r106, 0, 128);     // Catch: Throwable -> L13
        System.arraycopy(r102, 117, r106, 128, r102.length - 117);     // Catch: Throwable -> L13
    L33:
        r101.close();     // Catch: Throwable -> L10
    L12:
        return r106;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L7:
        r106 = bn.a(r102, r103);     // Catch: Throwable -> L13
    L13:
        th = th;
    L31:
        cd.a(th, "CI", "gzx");     // Catch: Throwable -> L24
        if (r101 != null) goto L38;
    L23:
        return null;
    L38:
        r101.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = move-exception;
        if (r101 != null) goto L35;
    L30:
        throw th;
    L35:
        r101.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        r101 = null;
        goto L31
    }

    public static String a(Context r100) {
        return bn.b(a(b(r100, false)));
    L5:
        th = move-exception;
        cd.a(th, "CI", "gCXi");
        return null;
    }

    private static void a(ByteArrayOutputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        bs.a(r100, (byte) 0, new byte[0]);
        return;
    L5:
        if (r101.getBytes().length <= 255) goto L7;
        byte r102 = -1;
    L8:
        bs.a(r100, r102, bs.a(r101));
        return;
    L7:
        r102 = (byte) r101.getBytes().length;
        goto L8
    }

    private static a b(Context r100, boolean r101) {
        a r102 = new a(0);
        r102.f26250a = bm.t(r100);
        r102.f26251b = bm.m(r100);
        String r103 = bm.h(r100);
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.f26252c = r103;
        r102.f26253d = bi.c(r100);
        r102.f26254e = Build.MODEL;
        r102.f26255f = Build.MANUFACTURER;
        r102.f26256g = Build.DEVICE;
        r102.f26257h = bi.b(r100);
        r102.f26258i = bi.d(r100);
        r102.f26259j = String.valueOf(Build.VERSION.SDK_INT);
        r102.f26260k = bm.v(r100);
        r102.f26261l = bm.q(r100);
        StringBuilder r104 = new StringBuilder();
        r104.append(bm.p(r100));
        r102.f26262m = r104.toString();
        StringBuilder r105 = new StringBuilder();
        r105.append(bm.o(r100));
        r102.f26263n = r105.toString();
        r102.f26264o = bm.x(r100);
        r102.f26265p = bm.n(r100);
        r102.f26266q = bm.l(r100);
        r102.f26267r = bm.k(r100);
        String[] r106 = bm.d();
        r102.f26268s = r106[0];
        r102.f26269t = r106[1];
        r102.f26272w = bm.a();
        String r107 = bm.a(r100);
        if (TextUtils.isEmpty(r107) == true) goto L8;
        r102.f26273x = r107;
    L9:
        r102.f26274y = "aid=" + bm.j(r100);
        if (r101 == false) goto L14;
        if (cc.f26374d == false) goto L14;
    L15:
        String r108 = bm.g(r100);
        if (TextUtils.isEmpty(r108) == true) goto L18;
        r102.f26274y += "|oaid=" + r108;
    L18:
        String r109 = bm.a(r100, ",");
        if (TextUtils.isEmpty(r109) == true) goto L21;
        r102.f26274y += "|multiImeis=" + r109;
    L21:
        String r110 = bm.u(r100);
        if (TextUtils.isEmpty(r110) == true) goto L24;
        r102.f26274y += "|meid=" + r110;
    L24:
        r102.f26274y += "|serial=" + bm.i(r100);
        String r111 = bm.b();
        if (TextUtils.isEmpty(r111) == true) goto L27;
        r102.f26274y += "|adiuExtras=" + r111;
    L27:
        r102.f26274y += "|storage=" + bm.e() + "|ram=" + bm.w(r100) + "|arch=" + bm.f();
        return r102;
    L14:
        if (cc.f26375e == false) goto L18;
    L8:
        r102.f26273x = "";
        goto L9
    }

    public static byte[] a(Context r100, boolean r101) {
        return a(b(r100, r101));
    L4:
        th = move-exception;
        cd.a(th, "CI", "gz");
        return null;
    }

    public static String a(Context r100, String r101, String r102) {
        return bq.a(bi.e(r100) + ":" + r101.substring(0, r101.length() - 3) + ":" + r102);
    L5:
        th = move-exception;
        cd.a(th, "CI", "Sco");
        return null;
    }
}
