package com.baidu.sec.privacy.f;

import android.util.Base64;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f33529a;

    public static synchronized byte[] a() {
        monitor-enter(a.class);
        byte[] r100 = f33529a;     // Catch: Throwable -> L12
        if (r100 != null) goto L8;
    L9:
        f33529a = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, kotlin.io.encoding.Base64.padSymbol, kotlin.io.encoding.Base64.padSymbol}, 0);     // Catch: Throwable -> L12
    L10:
        byte[] r101 = f33529a;     // Catch: Throwable -> L12
    L14:
        monitor-exit(a.class);
        return r101;
    L8:
        if (r100.length == 16) goto L10;
    L12:
        th = move-exception;
        r101 = new byte[0];     // Catch: Throwable -> L16
        c.a(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L18;
    L17:
        return null;
    L18:
    L15:
        th = move-exception;
        c.a(th);
        goto L17
    L5:
        if (r100.length == 0) goto L17;
        byte[] r101 = b(a(), r100);     // Catch: Throwable -> L15
        if (r101 != null) goto L10;
    L14:
        return null;
    L10:
        if (r101.length <= 0) goto L14;
        return Base64.encodeToString(r101, 0);
    }

    public static String a(String r100) {
        if (r100 != null) goto L11;
        return null;
    L11:
        byte[] r101 = Base64.decode(r100, 0);     // Catch: Throwable -> L8
        return new String(a(a(), r101));
    L8:
        th = move-exception;
        c.a(th);
        return null;
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        return com.baidu.xclient.gdid.a.b(r101, r100);
    L4:
        return null;
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        return com.baidu.xclient.gdid.a.a(r101, r100);
    L4:
        th = move-exception;
        c.a(th);
        return null;
    }
}
