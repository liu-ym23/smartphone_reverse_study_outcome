package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes28.dex */
public class n5 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f27651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f27652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f27653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f27654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f27655e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f27656f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f27657g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f27658h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        String f27659i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        String f27660j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        String f27661k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f27662l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        String f27663m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f27664n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        String f27665o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f27666p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        String f27667q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        String f27668r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        String f27669s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        String f27670t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        String f27671u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        String f27672v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        String f27673w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        String f27674x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        String f27675y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        String f27676z;

        private a() {
        }

        public /* synthetic */ a(byte r100) {
            this();
        }
    }

    public static String a() {
        String r100 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L9
        if (l5.a() == true) goto L6;
        String r101 = "0";
    L7:
        int r102 = r100.length();     // Catch: Throwable -> L9
        return r100.substring(0, r102 - 2) + r101 + r100.substring(r102 - 1);
    L6:
        r101 = "1";
    L9:
        th = move-exception;
        p6.a(th, "CI", "TS");
        return null;
    }

    public static String a(Context r100) {
        return q5.c(a(r100, a(r100, false, false, false)));
    L5:
        th = move-exception;
        p6.a(th, "CI", "gCXi");
        return null;
    }

    private static byte[] a(Context r100, a r101) {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        a(r102, r101.f27651a);     // Catch: Throwable -> L13
        a(r102, r101.f27652b);     // Catch: Throwable -> L13
        a(r102, r101.f27653c);     // Catch: Throwable -> L13
        a(r102, r101.f27654d);     // Catch: Throwable -> L13
        a(r102, r101.f27655e);     // Catch: Throwable -> L13
        a(r102, r101.f27656f);     // Catch: Throwable -> L13
        a(r102, r101.f27657g);     // Catch: Throwable -> L13
        a(r102, r101.f27658h);     // Catch: Throwable -> L13
        a(r102, r101.f27659i);     // Catch: Throwable -> L13
        a(r102, r101.f27660j);     // Catch: Throwable -> L13
        a(r102, r101.f27661k);     // Catch: Throwable -> L13
        a(r102, r101.f27662l);     // Catch: Throwable -> L13
        a(r102, r101.f27663m);     // Catch: Throwable -> L13
        a(r102, r101.f27664n);     // Catch: Throwable -> L13
        a(r102, r101.f27665o);     // Catch: Throwable -> L13
        a(r102, r101.f27666p);     // Catch: Throwable -> L13
        a(r102, r101.f27667q);     // Catch: Throwable -> L13
        a(r102, r101.f27668r);     // Catch: Throwable -> L13
        a(r102, r101.f27669s);     // Catch: Throwable -> L13
        a(r102, r101.f27670t);     // Catch: Throwable -> L13
        a(r102, null);     // Catch: Throwable -> L13
        a(r102, null);     // Catch: Throwable -> L13
        a(r102, null);     // Catch: Throwable -> L13
        a(r102, r101.f27671u);     // Catch: Throwable -> L13
        a(r102, r101.f27672v);     // Catch: Throwable -> L13
        a(r102, r101.f27673w);     // Catch: Throwable -> L13
        a(r102, r101.f27674x);     // Catch: Throwable -> L13
        a(r102, r101.f27675y);     // Catch: Throwable -> L13
        a(r102, r101.f27676z);     // Catch: Throwable -> L13
        byte[] r103 = r102.toByteArray();     // Catch: Throwable -> L13
        new String(r103);     // Catch: Throwable -> L13
        byte[] r104 = x5.f(r103);     // Catch: Throwable -> L13
        PublicKey r105 = x5.a();     // Catch: Throwable -> L13
        if (r104.length <= 117) goto L7;
        byte[] r106 = new byte[117];     // Catch: Throwable -> L13
        System.arraycopy(r104, 0, r106, 0, 117);     // Catch: Throwable -> L13
        byte[] r107 = q5.a(r106, r105);     // Catch: Throwable -> L13
        byte[] r108 = new byte[(r104.length + 128) - 117];     // Catch: Throwable -> L13
        System.arraycopy(r107, 0, r108, 0, 128);     // Catch: Throwable -> L13
        System.arraycopy(r104, 117, r108, 128, r104.length - 117);     // Catch: Throwable -> L13
    L35:
        r102.close();     // Catch: Throwable -> L10
    L12:
        return r108;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L7:
        r108 = q5.a(r104, r105);     // Catch: Throwable -> L13
    L13:
        th = th;
    L33:
        p6.a(th, "CI", "gzx");     // Catch: Throwable -> L24
        if (r102 != null) goto L40;
    L23:
        return null;
    L40:
        r102.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = move-exception;
        if (r102 != null) goto L37;
    L30:
        throw th;
    L37:
        r102.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        r102 = null;
        goto L33
    }

    public static void a(ByteArrayOutputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        x5.a(r100, (byte) 0, new byte[0]);
        return;
    L5:
        if (r101.getBytes().length <= 255) goto L7;
        byte r102 = -1;
    L8:
        x5.a(r100, r102, x5.e(r101));
        return;
    L7:
        r102 = (byte) r101.getBytes().length;
        goto L8
    }

    public static String a(Context r100, String r101, String r102) {
        return t5.c(l5.g(r100) + ":" + r101.substring(0, r101.length() - 3) + ":" + r102);
    L5:
        th = move-exception;
        p6.a(th, "CI", "Sco");
        return null;
    }

    public static byte[] a(Context r100, boolean r101, boolean r102) {
        return a(r100, a(r100, r101, r102, false));
    L5:
        th = move-exception;
        p6.a(th, "CI", "gz");
        return null;
    }

    private static a a(Context r100, boolean r101, boolean r102, boolean r103) {
        a r104 = new a(0);
        r104.f27651a = o5.b();
        r104.f27652b = o5.c();
        String r105 = o5.s(r100);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.f27653c = r105;
        r104.f27654d = l5.f(r100);
        r104.f27655e = Build.MODEL;
        r104.f27656f = Build.MANUFACTURER;
        r104.f27657g = Build.DEVICE;
        r104.f27658h = l5.b(r100);
        r104.f27659i = l5.c(r100);
        r104.f27660j = String.valueOf(Build.VERSION.SDK_INT);
        r104.f27661k = "";
        r104.f27662l = o5.c(r100);
        StringBuilder r106 = new StringBuilder();
        r106.append(o5.h(r100));
        r104.f27663m = r106.toString();
        StringBuilder r107 = new StringBuilder();
        r107.append(o5.n(r100));
        r104.f27664n = r107.toString();
        r104.f27665o = o5.d(r100);
        r104.f27666p = o5.a(r100);
        r104.f27667q = "";
        r104.f27668r = "";
        if (r101 == false) goto L8;
        r104.f27669s = "";
        r104.f27670t = "";
    L9:
        String r108 = o5.g(r100);
        if (TextUtils.isEmpty(r108) == true) goto L12;
        r104.f27671u = r108;
    L13:
        r104.f27672v = "aid=";
        if (r102 == false) goto L18;
        if (m6.f27614b == false) goto L18;
    L19:
        String r109 = o5.p(r100);
        if (TextUtils.isEmpty(r109) == true) goto L22;
        r104.f27672v += "|oaid=" + r109;
    L22:
        String r110 = o5.f27751s;
        if (TextUtils.isEmpty(r110) == true) goto L26;
        r104.f27672v += "|multiImeis=" + r110;
    L26:
        if (TextUtils.isEmpty("") == true) goto L28;
        r104.f27672v += "|meid=";
    L28:
        r104.f27672v += "|serial=";
        if (TextUtils.isEmpty("") == false) goto L38;
        o5.d r111 = o5.f27736d;     // Catch: Throwable -> L37
        if (r111 == null) goto L38;
        r111.a();     // Catch: Throwable -> L37
        String r112 = null;
    L40:
        if (TextUtils.isEmpty(r112) == true) goto L42;
        r104.f27672v += "|adiuExtras=" + r112;
    L42:
        r104.f27672v += "|storage=" + o5.d() + "|ram=" + o5.q(r100) + "|arch=" + o5.a();
        n6 r113 = o6.a();
        if (r113 != null) goto L45;
    L47:
        r104.f27673w = "";
    L48:
        if (r101 == true) goto L50;
        if (r103 == true) goto L50;
    L53:
        r104.f27675y = String.valueOf(true);
        r104.f27676z = String.valueOf(true);
        return r104;
    L50:
        y5.a(r100);
        if (TextUtils.isEmpty("") == true) goto L53;
        r104.f27674x = "";
        goto L53
    L45:
        if (TextUtils.isEmpty(r113.b()) == true) goto L47;
        r104.f27673w = r113.b();
    L38:
        r112 = "";
    L18:
        if (m6.f27615c == false) goto L22;
    L12:
        r104.f27671u = "";
        goto L13
    L8:
        String[] r114 = {"", ""};
        r104.f27669s = r114[0];
        r104.f27670t = r114[1];
        goto L9
    }
}
