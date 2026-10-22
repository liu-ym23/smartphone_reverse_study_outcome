package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class u6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f28099a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<v8> f28100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakReference<v8> f28101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f28102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f28103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f28104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f28105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static w5 f28106h;

    public static class a extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f28107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w5 f28108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f28110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f28111f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d8 f28112h;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            Context r100 = this.f28107b;
            w5 r101 = this.f28108c;
            String r102 = this.f28109d;
            String r103 = this.f28110e;
            String r104 = this.f28111f;
            String r105 = x5.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
            String r106 = e8.a(r100, r101);
            l5.d(r100);
            StringBuffer r107 = new StringBuffer();
            r107.append(r106);
            r107.append(",\"timestamp\":\"");
            r107.append(r105);
            r107.append("\",\"et\":\"1\",\"classname\":\"");
            r107.append(r102);
            r107.append("\",\"traceInfo\":\"");
            r107.append(r104);
            r107.append("\",\"detail\":\"");
            r107.append(r103);
            r107.append("\"");
            String r108 = r107.toString();
            d8 r109 = this.f28112h;
            if (r109.f27185e != null) goto L5;
            r109.f27185e = new h7(new i7(new k7(new l7())));
        L5:
            String r110 = t5.a(r108);
            e8.a(r110, x5.e(r108), this.f28112h);     // Catch: Throwable -> L8
            return;
        }

        public a(Context r100, w5 r101, String r102, String r103, String r104, d8 r105) {
            this.f28107b = r100;
            this.f28108c = r101;
            this.f28109d = r102;
            this.f28110e = r103;
            this.f28111f = r104;
            this.f28112h = r105;
        }
    }

    public static class b extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f28113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ v8 f28115d;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            monitor-enter(u6.class);     // Catch: Throwable -> L16
            d8 r100 = e8.a(null);     // Catch: Throwable -> L13
            e8.a(this.f28113b, r100, this.f28114c, 1000, 4096000, "1");     // Catch: Throwable -> L13
            r100.f27186f = this.f28115d;     // Catch: Throwable -> L13
            if (r100.f27187g != null) goto L10;
            Context r101 = this.f28113b;     // Catch: Throwable -> L13
            q8 r102 = new q8();     // Catch: Throwable -> L13
            i7 r103 = new i7(new k7(new l7()));     // Catch: Throwable -> L13
            r100.f27187g = new m8(new l8(r101, r102, r103, "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", new Object[]{l5.e(r101), o5.b(), o5.o(this.f28113b), l5.f(this.f28113b), Build.MODEL, l5.b(this.f28113b), l5.c(this.f28113b), Build.VERSION.RELEASE}));     // Catch: Throwable -> L13
        L10:
            r100.f27188h = BaseConstants.Time.HOUR;     // Catch: Throwable -> L13
            e8.a(r100);     // Catch: Throwable -> L13
            monitor-exit(u6.class);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            t6.a(th, "lg", "pul");
        }

        public b(Context r100, String r101, v8 r102) {
            this.f28113b = r100;
            this.f28114c = r101;
            this.f28115d = r102;
        }
    }

    public static class c extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d8 f28116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f28117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f28118d;

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            monitor-enter(u6.class);     // Catch: Throwable -> L17
            d8 r100 = this.f28116b;     // Catch: Throwable -> L14
            if (r100.f27187g != null) goto L9;
            Context r101 = this.f28117c;     // Catch: Throwable -> L14
            q8 r102 = new q8();     // Catch: Throwable -> L14
            i7 r103 = new i7(new k7(new l7()));     // Catch: Throwable -> L14
            r100.f27187g = new m8(new l8(r101, r102, r103, "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", new Object[]{l5.e(r101), o5.b(), o5.o(this.f28117c), l5.f(this.f28117c), Build.MODEL, l5.b(this.f28117c), l5.c(this.f28117c), Build.VERSION.RELEASE}));     // Catch: Throwable -> L14
        L9:
            int r104 = e8.a(this.f28116b);     // Catch: Throwable -> L14
            d r105 = this.f28118d;     // Catch: Throwable -> L14
            if (r105 == null) goto L12;
            r105.a(r104);     // Catch: Throwable -> L14
        L12:
            monitor-exit(u6.class);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            t6.a(th, "lg", "pul");
        }

        public c(d8 r100, Context r101, d r102) {
            this.f28116b = r100;
            this.f28117c = r101;
            this.f28118d = r102;
        }
    }

    public interface d {
        void a(int r100);
    }

    static {
        f28102d = new String[10];
    }

    public u6() {
    }

    public static void a(Context r110) {
        List<w5> r100 = q6.a();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() == 0) goto L159;
        int r101 = 0;
        String r102 = null;
        PolarisFileWrapper r103 = new PolarisFileWrapper("/data/anr/traces.txt");     // Catch: Throwable -> L58 FileNotFoundException -> L80
        if (r103.exists() == false) goto L106;
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r103);     // Catch: Throwable -> L58 FileNotFoundException -> L80
        int r105 = r104.available();     // Catch: Throwable -> L55 FileNotFoundException -> L57
        if (r105 <= 1024000) goto L15;
        r104.skip(r105 - 1024000);     // Catch: Throwable -> L55 FileNotFoundException -> L57
    L15:
        p7 r106 = new p7(r104, o7.f27769p);     // Catch: Throwable -> L55 FileNotFoundException -> L57
        boolean r107 = false;
    L137:
        String r111 = r106.a().trim();     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        if (r111.contains("pid") == false) goto L24;
    L20:
        if (r111.startsWith("\"main\"") == true) goto L22;
        r111 = r106.a();     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        goto L20
    L22:
        r107 = true;
    L24:
        if (r111.equals("") == false) goto L27;
        if (r107 == true) goto L125;
    L27:
        if (r107 == false) goto L137;
        if (f28103e <= 9) goto L31;
        f28103e = 0;     // Catch: Throwable -> L33
    L31:
        String[] r112 = f28102d;     // Catch: Throwable -> L33
        int r113 = f28103e;     // Catch: Throwable -> L33
        r112[r113] = r111;     // Catch: Throwable -> L33
        f28103e = r113 + 1;     // Catch: Throwable -> L33
    L35:
        int r114 = f28105g;     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        if (r114 == 5) goto L125;
        if (f28104f == false) goto L40;
        f28105g = r114 + 1;     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        goto L137
    L40:
        Iterator<w5> r115 = r100.iterator();     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
    L42:
        if (r115.hasNext() == false) goto L137;
        w5 r116 = r115.next();     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        boolean r117 = q6.a(r116.c(), r111);     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        f28104f = r117;     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        if (r117 == false) goto L42;
        f28106h = r116;     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
    L33:
        th = move-exception;
        t6.a(th, "alg", "aDa");     // Catch: Throwable -> L48 FileNotFoundException -> L50 EOFException -> L114
        goto L35
    L48:
        th = th;
    L123:
        t6.a(th, "alg", "getA");     // Catch: Throwable -> L68
        if (r106 != null) goto L119;
    L66:
        if (r104 == null) goto L92;
    L131:
        r104.close();     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        t6.a(th, "alg", "getA");
    L92:
        if (f28104f == false) goto L106;
        StringBuilder r108 = new StringBuilder();
        int r109 = f28103e;     // Catch: Throwable -> L103
    L96:
        if (r109 >= 10) goto L99;
        if (r109 > 9) goto L99;
        r108.append(f28102d[r109]);     // Catch: Throwable -> L103
        r109 = r109 + 1;     // Catch: Throwable -> L103
    L99:
        if (r101 >= f28103e) goto L105;
        r108.append(f28102d[r101]);     // Catch: Throwable -> L103
        r101 = r101 + 1;
    L105:
        r102 = r108.toString();
    L103:
        th = move-exception;
        t6.a(th, "alg", "gLI");
        goto L105
    L119:
        r106.close();     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        t6.a(th, "alg", "getA");
    L68:
        th = move-exception;
        if (r106 != null) goto L129;
    L74:
        if (r104 == null) goto L154;
        r104.close();     // Catch: Throwable -> L77
        throw th;
    L77:
        th = move-exception;
        t6.a(th, "alg", "getA");
        throw th;
    L154:
        throw th;
    L129:
        r106.close();     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        t6.a(th, "alg", "getA");
    L125:
        r106.close();     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        t6.a(th, "alg", "getA");
    L81:
        if (r106 != null) goto L121;
    L86:
        if (r104 == null) goto L92;
    L121:
        r106.close();     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        t6.a(th, "alg", "getA");
        goto L86
    L57:
        r106 = null;
    L55:
        th = th;
        r106 = null;
        goto L123
    L106:
        if (r102 != null) goto L108;
        return;
    L108:
        if ("".equals(r102) == true) goto L158;
        w5 r118 = f28106h;
        if (r118 == null) goto L160;
        a(r110, r118, 2, "ANR", r102);
        return;
    L160:
        return;
    L158:
        return;
    L80:
        r106 = null;
        r104 = null;
    L58:
        th = th;
        r106 = null;
        r104 = null;
        goto L123
    }

    public static void b(Context r100) {
        t8 r101 = new t8(f28099a);
        f28099a = false;
        int r102 = q6.f27894c;
        a(r100, r101, "c");
    }

    public static void c(Context r100) {
        WeakReference<v8> r101 = f28100b;
        if (r101 != null) goto L5;
    L6:
        f28100b = new WeakReference(new u8(r100, BaseConstants.Time.HOUR, "hKey", new w8(r100, false)));
    L7:
        v8 r102 = f28100b.get();
        int r103 = q6.f27894c;
        a(r100, r102, "d");
        return;
    L5:
        if (r101.get() != null) goto L7;
        goto L6
    }

    public static void d(Context r100) {
        WeakReference<v8> r101 = f28101c;
        if (r101 != null) goto L5;
    L6:
        f28101c = new WeakReference(new u8(r100, BaseConstants.Time.HOUR, "gKey", new w8(r100, false)));
    L7:
        v8 r102 = f28101c.get();
        int r103 = q6.f27894c;
        a(r100, r102, "b");
        return;
    L5:
        if (r101.get() != null) goto L7;
        goto L6
    }

    public static void a(Context r100, d8 r101, d r102) {
        z8.f().d(new c(r101, r100, r102));     // Catch: Throwable -> L4
        return;
    }

    private static void a(Context r100, v8 r101, String r102) {
        z8.f().d(new b(r100, r102, r101));
    }

    public static void a(w5 r100, Context r101, String r102, String r103) {
        if (r100 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        return;
    L10:
        if (r102 != null) goto L12;
        return;
    L12:
        if ("".equals(r102) == true) goto L17;
        a(r101, r100, 1, r102, r103);
        return;
    L17:
        return;
    L5:
        if (r100.f() == false) goto L7;
        r104 = true;
        goto L8
    }

    public static void a(Context r110, Throwable r111, int r112, String r210, String r211) {
        int r100 = x5.f28335d;
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L22
        PrintWriter r102 = new PrintWriter(r101);     // Catch: Throwable -> L20
        r111.printStackTrace(r102);     // Catch: Throwable -> L18
        Throwable r103 = r111.getCause();     // Catch: Throwable -> L18
    L7:
        if (r103 == null) goto L9;
        r103.printStackTrace(r102);     // Catch: Throwable -> L18
        r103 = r103.getCause();     // Catch: Throwable -> L18
        goto L7
    L9:
        String r104 = r101.toString();     // Catch: Throwable -> L18
        r101.close();     // Catch: Throwable -> L12
    L126:
        r102.close();     // Catch: Throwable -> L16
    L37:
        List r105 = q6.a();
        if (r105 != null) goto L40;
        r105 = new ArrayList();
    L40:
        boolean r106 = false;
        if (r104 != null) goto L43;
    L90:
        w5 r107 = null;
    L91:
        if (r107 != null) goto L93;
    L95:
        if (r106 == true) goto L97;
        return;
    L97:
        String r108 = r104.replaceAll("\n", "<br/>");
        String r109 = r111.toString();
        if (r109 != null) goto L100;
        return;
    L100:
        if ("".equals(r109) == true) goto L159;
        StringBuilder r113 = new StringBuilder();
        if (r210 == null) goto L105;
        r113.append("class:");
        r113.append(r210);
    L105:
        if (r211 == null) goto L107;
        r113.append(" method:");
        r113.append(r211);
        r113.append("$<br/>");
    L107:
        r113.append(r108);
        a(r110, r107, r112, r109, r113.toString());
        return;
    L159:
        return;
    L93:
        if (r107.f() == false) goto L95;
        r106 = true;
        goto L95
    L43:
        if ("".equals(r104) == true) goto L90;
        Iterator r114 = r105.iterator();
    L47:
        if (r114.hasNext() == false) goto L75;
        w5 r115 = (w5) r114.next();
        String[] r116 = r115.c();
        if (r116 != null) goto L124;
    L71:
        boolean r117 = false;
    L72:
        if (r117 == false) goto L47;
        r107 = r115;
        goto L91
    L124:
        String[] r118 = r104.split("\n");     // Catch: Throwable -> L69
        int r119 = r118.length;     // Catch: Throwable -> L69
        int r120 = 0;
    L51:
        if (r120 >= r119) goto L63;
        String r121 = r118[r120].trim();     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r121) == false) goto L55;
    L59:
        boolean r122 = false;
    L60:
        if (r122 == true) goto L71;
        r120 = r120 + 1;     // Catch: Throwable -> L69
        goto L51
    L55:
        if (r121.startsWith("at ") == false) goto L59;
        if (r121.contains("uncaughtException") == false) goto L59;
        r122 = true;
        goto L60
    L63:
        int r123 = r118.length;     // Catch: Throwable -> L69
        int r124 = 0;
    L64:
        if (r124 >= r123) goto L71;
        if (q6.a(r116, r118[r124].trim()) == true) goto L67;
        r124 = r124 + 1;
        goto L64
    L67:
        r117 = true;
    L69:
        th = move-exception;
        th.printStackTrace();
        goto L71
    L75:
        if (r104.contains("com.amap.api.col") == false) goto L81;
        r107 = x5.b();     // Catch: k5 -> L78
    L78:
        e = move-exception;
        e.printStackTrace();
    L81:
        if (r104.contains("com.amap.co") == false) goto L83;
    L130:
        int r125 = x5.f28335d;     // Catch: k5 -> L88
        w5 r126 = new w5.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();     // Catch: k5 -> L88
        r126.a(true);     // Catch: k5 -> L88
        r107 = r126;
    L88:
        e = move-exception;
        e.printStackTrace();
        goto L90
    L83:
        if (r104.contains("com.amap.opensdk.co") == true) goto L130;
        if (r104.contains("com.amap.location") == false) goto L90;
    L16:
        th = move-exception;
        th.printStackTrace();
    L12:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = th;
    L128:
        th.printStackTrace();     // Catch: Throwable -> L109
        if (r101 != null) goto L146;
    L31:
        if (r102 != null) goto L134;
    L36:
        r104 = null;
        goto L37
    L134:
        r102.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L146:
        r101.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
    L109:
        th = move-exception;
        if (r101 != null) goto L144;
    L116:
        if (r102 == null) goto L160;
        r102.close();     // Catch: Throwable -> L119
        throw th;
    L119:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L160:
        throw th;
    L144:
        r101.close();     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = th;
    L24:
        r102 = null;
    L22:
        th = th;
        r101 = null;
        goto L24
    }

    private static void a(Context r100, w5 r101, int r102, String r103, String r104) {
        String r105 = x5.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
        String r106 = e8.a(r100, r101);
        l5.d(r100);
        StringBuffer r107 = new StringBuffer();
        r107.append(r106);
        r107.append(",\"timestamp\":\"");
        r107.append(r105);
        r107.append("\",\"et\":\"");
        r107.append(r102);
        r107.append("\",\"classname\":\"");
        r107.append(r103);
        r107.append("\",\"detail\":\"");
        r107.append(r104);
        r107.append("\"");
        String r108 = r107.toString();
        if (r108 != null) goto L5;
        return;
    L5:
        if ("".equals(r108) == true) goto L25;
        String r109 = t5.a(r104);
        if (r102 != 1) goto L11;
        int r110 = q6.f27894c;
        String r111 = "b";
    L15:
        d8 r112 = e8.a(null);
        r112.f27181a = q6.a(r100, r111);
        r112.f27184d = 1000;
        r112.f27182b = 4096000;
        r112.f27183c = "1";
        if (r112.f27185e != null) goto L21;
        r112.f27185e = new h7(new i7(new k7(new l7())));
    L21:
        e8.a(r109, x5.e(r108.replaceAll("\n", "<br/>")), r112);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L11:
        if (r102 != 2) goto L13;
        int r113 = q6.f27894c;
        r111 = "d";
        goto L15
    L13:
        if (r102 != 0) goto L24;
        int r114 = q6.f27894c;
        r111 = "c";
        goto L15
    L24:
        return;
    }

    public static void a(Context r100, w5 r101, String r102, int r103, String r104, String r105) {
        if (r104 != null) goto L4;
        return;
    L4:
        if ("".equals(r104) == true) goto L12;
        StringBuilder r106 = new StringBuilder("class:");
        r106.append(r104);
        if (r105 == null) goto L9;
        r106.append(" method:");
        r106.append(r105);
        r106.append("$<br/>");
    L9:
        r106.append(r102);
        a(r100, r101, r103, r104, r106.toString());
        return;
    }

    public static void a(Context r100, w5 r110, String r111, d8 r112, String r113, String r114) {
        z8.f().d(new a(r100, r110, r111, r113, r114, r112));     // Catch: Throwable -> L4
        return;
    }
}
