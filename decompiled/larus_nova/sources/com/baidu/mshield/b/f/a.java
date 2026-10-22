package com.baidu.mshield.b.f;

import android.util.Base64;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f32383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f32384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f32385c;

    public static synchronized byte[] a() {
        monitor-enter(a.class);
        byte[] r100 = f32385c;     // Catch: Throwable -> L12
        if (r100 != null) goto L8;
    L9:
        f32385c = Base64.decode(new byte[]{78, 68, 65, 121, 77, 122, 85, 120, 78, 122, 74, 108, 97, 71, 78, 110, 90, 109, 108, 106, 89, 81, kotlin.io.encoding.Base64.padSymbol, kotlin.io.encoding.Base64.padSymbol, 10}, 0);     // Catch: Throwable -> L12
    L10:
        byte[] r101 = f32385c;     // Catch: Throwable -> L12
    L14:
        monitor-exit(a.class);
        return r101;
    L8:
        if (r100.length == 16) goto L10;
    L12:
        th = move-exception;
        r101 = new byte[0];     // Catch: Throwable -> L16
        com.baidu.sec.privacy.f.c.a(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized byte[] a(int r110) {
        monitor-enter(a.class);
        if (r110 == 16) goto L14;
        if (r110 == 24) goto L8;
        byte[] r100 = new byte[0];     // Catch: Throwable -> L21
    L24:
        monitor-exit(a.class);
        return r100;
    L8:
        byte[] r101 = f32384b;     // Catch: Throwable -> L21
        if (r101 != null) goto L11;
    L12:
        f32384b = Base64.decode(new byte[]{84, 88, 112, 66, 101, 85, 49, 85, 83, 88, 104, 78, 82, 69, 112, 114, 89, 86, 100, 79, 77, 86, 112, 72, 98, 71, 104, 90, 90, 122, 48, 57, 10}, 0);     // Catch: Throwable -> L21
    L13:
        r100 = f32384b;     // Catch: Throwable -> L21
        goto L24
    L11:
        if (r101.length == 24) goto L13;
    L14:
        byte[] r102 = f32383a;     // Catch: Throwable -> L21
        if (r102 != null) goto L17;
    L18:
        f32383a = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, kotlin.io.encoding.Base64.padSymbol, kotlin.io.encoding.Base64.padSymbol}, 0);     // Catch: Throwable -> L21
    L19:
        r100 = f32383a;     // Catch: Throwable -> L21
        goto L24
    L17:
        if (r102.length == 16) goto L19;
    L21:
        th = move-exception;
        byte[] r103 = new byte[0];     // Catch: Throwable -> L26
        com.baidu.sec.privacy.f.c.a(th);     // Catch: Throwable -> L26
        r100 = r103;
    L26:
        th = move-exception;
        throw th;
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        return c(r101, r100);
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        return d(r101, r100);
    }

    public static byte[] c(byte[] r100, byte[] r101) {
        return com.baidu.xclient.gdid.a.b(r101, r100);
    L4:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return null;
    }

    public static byte[] d(byte[] r100, byte[] r101) {
        return com.baidu.xclient.gdid.a.a(r101, r100);
    L4:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
        return null;
    }
}
