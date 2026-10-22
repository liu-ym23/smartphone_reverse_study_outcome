package com.alipay.sdk.m.n;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class b {
    public b() {
    }

    public static byte[] a(byte[] r100) throws IOException {
        ByteArrayInputStream r101 = null;
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);     // Catch: Throwable -> L22
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L20
        GZIPOutputStream r104 = new GZIPOutputStream(r103);     // Catch: Throwable -> L18
        byte[] r105 = new byte[4096];     // Catch: Throwable -> L16
    L8:
        int r106 = r102.read(r105);     // Catch: Throwable -> L16
        if (r106 == (-1)) goto L11;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L16
        goto L8
    L11:
        r104.flush();     // Catch: Throwable -> L16
        r104.finish();     // Catch: Throwable -> L16
        byte[] r107 = r103.toByteArray();     // Catch: Throwable -> L16
        r102.close();     // Catch: Exception -> L35
    L39:
        r103.close();     // Catch: Exception -> L36
    L55:
        r104.close();     // Catch: Exception -> L37
    L15:
        return r107;
    L16:
        th = move-exception;
        Throwable r108 = th;
        r101 = r102;
    L24:
        if (r101 != null) goto L41;
    L28:
        if (r103 != null) goto L53;
    L32:
        if (r104 == null) goto L60;
        r104.close();     // Catch: Exception -> L38
        throw r108;
    L61:
        throw r108;
    L60:
        throw r108;
    L53:
        r103.close();     // Catch: Exception -> L31
        goto L32
    L41:
        r101.close();     // Catch: Exception -> L27
    L18:
        th = move-exception;
        r104 = null;
        r101 = r102;
        r108 = th;
    L20:
        th = move-exception;
        r104 = null;
        r101 = r102;
        r108 = th;
        r103 = null;
    L22:
        th = move-exception;
        r108 = th;
        r103 = null;
        r104 = null;
        goto L24
    }

    public static byte[] b(byte[] r100) throws IOException {
        ByteArrayOutputStream r101 = null;
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);     // Catch: Throwable -> L22
        GZIPInputStream r103 = new GZIPInputStream(r102);     // Catch: Throwable -> L20
        byte[] r104 = new byte[4096];     // Catch: Throwable -> L18
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
    L36:
        int r106 = r103.read(r104, 0, 4096);     // Catch: Throwable -> L16
        if (r106 == (-1)) goto L11;
        r105.write(r104, 0, r106);     // Catch: Throwable -> L16
        goto L36
    L11:
        r105.flush();     // Catch: Throwable -> L16
        byte[] r107 = r105.toByteArray();     // Catch: Throwable -> L16
        r105.close();     // Catch: Exception -> L28
    L38:
        r103.close();     // Catch: Exception -> L29
    L34:
        r102.close();     // Catch: Exception -> L30
    L15:
        return r107;
    L16:
        th = move-exception;
        Throwable th10 = th;
        r101 = r105;
    L52:
        r101.close();     // Catch: Exception -> L31
    L48:
        r103.close();     // Catch: Exception -> L32
    L46:
        r102.close();     // Catch: Exception -> L33
        throw th10;
    L55:
        throw th10;
    L18:
        th10 = th;
    L20:
        th = move-exception;
        th10 = th;
        r103 = null;
    L22:
        th = move-exception;
        th10 = th;
        r103 = null;
        r102 = null;
        goto L52
    }
}
