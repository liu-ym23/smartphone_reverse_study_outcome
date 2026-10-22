package com.amap.api.col.s;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public final class dg {
    public static da a(WeakReference<da> r100) {
        if (r100 != null) goto L4;
    L5:
        r100 = new WeakReference(new da());
    L7:
        return r100.get();
    L4:
        if (r100.get() != null) goto L7;
        goto L5
    }

    public static byte[] a(cp r100, String r101) {
        byte[] r102 = new byte[0];
        InputStream r103 = null;
        cp.b r104 = r100.a(r101);     // Catch: Throwable -> L35
        if (r104 != null) goto L79;
        if (r104 != null) goto L65;
    L34:
        return r102;
    L65:
        r104.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L79:
        InputStream r105 = r104.a();     // Catch: Throwable -> L27
        if (r105 != null) goto L17;
        if (r105 == null) goto L81;
        r105.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    L81:
        r104.close();     // Catch: Throwable -> L14
    L16:
        return r102;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L17:
        r102 = new byte[r105.available()];     // Catch: Throwable -> L27
        r105.read(r102);     // Catch: Throwable -> L27
        r105.close();     // Catch: Throwable -> L20
    L71:
        r104.close();     // Catch: Throwable -> L24
    L26:
        return r102;
    L24:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = th;
    L69:
        cg.c(th, "sui", "rdS");     // Catch: Throwable -> L49
        if (0 != 0) goto L75;
    L43:
        if (r104 != null) goto L63;
    L48:
        return r102;
    L63:
        r104.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.printStackTrace();
        goto L48
    L75:
        r103.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.printStackTrace();
    L49:
        th = move-exception;
        if (0 != 0) goto L83;
    L55:
        if (r104 == null) goto L85;
        r104.close();     // Catch: Throwable -> L58
        throw th;
    L58:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L85:
        throw th;
    L83:
        r103.close();     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        th.printStackTrace();
    L35:
        th = th;
        r104 = null;
        goto L69
    }

    public static String a(Context r100, br r101) {
        StringBuilder r102 = new StringBuilder();
        String r103 = bm.f(r100);     // Catch: Throwable -> L5
        r102.append("\"sim\":\"");     // Catch: Throwable -> L5
        r102.append(r103);     // Catch: Throwable -> L5
        r102.append("\",\"sdkversion\":\"");     // Catch: Throwable -> L5
        r102.append(r101.d());     // Catch: Throwable -> L5
        r102.append("\",\"product\":\"");     // Catch: Throwable -> L5
        r102.append(r101.b());     // Catch: Throwable -> L5
        r102.append("\",\"ed\":\"");     // Catch: Throwable -> L5
        r102.append(r101.e());     // Catch: Throwable -> L5
        r102.append("\",\"nt\":\"");     // Catch: Throwable -> L5
        r102.append(bm.d(r100));     // Catch: Throwable -> L5
        r102.append("\",\"np\":\"");     // Catch: Throwable -> L5
        r102.append(bm.b(r100));     // Catch: Throwable -> L5
        r102.append("\",\"mnc\":\"");     // Catch: Throwable -> L5
        r102.append(bm.c(r100));     // Catch: Throwable -> L5
        r102.append("\",\"ant\":\"");     // Catch: Throwable -> L5
        r102.append(bm.e(r100));     // Catch: Throwable -> L5
        r102.append("\"");     // Catch: Throwable -> L5
    L8:
        return r102.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static void a(Context r100, da r101, String r102, int r103, int r104, String r105) {
        r101.f26532a = ce.c(r100, r102);
        r101.f26535d = r103;
        r101.f26533b = r104;
        r101.f26534c = r105;
    }
}
