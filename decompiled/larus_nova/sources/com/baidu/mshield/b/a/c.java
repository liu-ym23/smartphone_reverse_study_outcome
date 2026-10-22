package com.baidu.mshield.b.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes39.dex */
public abstract class c {
    public static byte[] a(byte[] r100) throws IOException {
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        a(r101, r102);
        byte[] r103 = r102.toByteArray();
        r102.flush();
        r102.close();
        r101.close();
        return r103;
    }

    public static byte[] b(byte[] r100) throws IOException {
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        b(r101, r102);
        byte[] r103 = r102.toByteArray();
        r102.flush();
        r102.close();
        r101.close();
        return r103;
    }

    public static void a(InputStream r100, OutputStream r101) throws IOException {
        GZIPOutputStream r102 = new GZIPOutputStream(r101);
        byte[] r103 = new byte[2048];
    L3:
        int r104 = r100.read(r103, 0, 2048);
        if (r104 == (-1)) goto L6;
        r102.write(r103, 0, r104);
        goto L3
    L6:
        r102.flush();
        r102.finish();
        r102.close();
    }

    public static void b(InputStream r100, OutputStream r101) throws IOException {
        GZIPInputStream r102 = new GZIPInputStream(r100);
        byte[] r103 = new byte[2048];
    L3:
        int r104 = r102.read(r103, 0, 2048);
        if (r104 == (-1)) goto L6;
        r101.write(r103, 0, r104);
        goto L3
    L6:
        r102.close();
    }
}
