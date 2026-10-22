package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes28.dex */
public class q8 extends p8 {
    public q8() {
    }

    @Override // com.amap.api.mapcore.util.p8
    public byte[] b(byte[] r100) {
        int r101 = x5.f28335d;
        byte[] r102 = null;
        if (r100 != null) goto L5;
    L44:
        return r102;
    L5:
        if (r100.length == 0) goto L44;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        ZipOutputStream r104 = new ZipOutputStream(r103);     // Catch: Throwable -> L17
        r104.putNextEntry(new ZipEntry("log"));     // Catch: Throwable -> L15
        r104.write(r100);     // Catch: Throwable -> L15
        r104.closeEntry();     // Catch: Throwable -> L15
        r104.finish();     // Catch: Throwable -> L15
        byte[] r105 = r103.toByteArray();     // Catch: Throwable -> L15
        r104.close();     // Catch: Throwable -> L12
    L14:
        r102 = r105;
    L59:
        r103.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        p6.a(th, "ut", "zp2");
    L12:
        th = move-exception;
        p6.a(th, "ut", "zp1");
    L15:
        th = th;
    L47:
        p6.a(th, "ut", "zp");     // Catch: Throwable -> L32
        if (r104 != null) goto L51;
    L27:
        if (r103 == null) goto L44;
    L51:
        r104.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        p6.a(th, "ut", "zp1");
    L32:
        th = move-exception;
        if (r104 != null) goto L55;
    L38:
        if (r103 == null) goto L63;
        r103.close();     // Catch: Throwable -> L41
        throw th;
    L41:
        th = move-exception;
        p6.a(th, "ut", "zp2");
        throw th;
    L63:
        throw th;
    L55:
        r104.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        p6.a(th, "ut", "zp1");
    L17:
        th = th;
        r104 = null;
    L19:
        th = th;
        r103 = null;
        r104 = null;
        goto L47
    }
}
