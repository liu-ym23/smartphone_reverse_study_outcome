package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: Encoding.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    static int a(String r1) {
        return r1.getBytes(StandardCharsets.UTF_8).length;
    }

    static void a(OutputStream r6, long r7, int r9) {
        byte[] r0 = new byte[r9];
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        r0[r1] = (byte) ((r7 >> (r1 * 8)) & 255);
        r1 = r1 + 1;
        goto L3
    L5:
        r6.write(r0);
    }

    static void a(OutputStream r2, int r3) {
        a(r2, r3, 1);
    }

    static void b(OutputStream r2, int r3) {
        a(r2, r3, 2);
    }

    static void a(OutputStream r1, long r2) {
        a(r1, r2, 4);
    }

    static void a(OutputStream r1, String r2) {
        r1.write(r2.getBytes(StandardCharsets.UTF_8));
    }

    static int a(int r0) {
        return (((r0 + 8) - 1) & (-8)) / 8;
    }

    static byte[] a(InputStream r3, int r4) {
        byte[] r0 = new byte[r4];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L9;
        int r2 = r3.read(r0, r1, r4 - r1);
        if (r2 < 0) goto L8;
        r1 = r1 + r2;
        goto L3
    L8:
        throw b("Not enough bytes to read: " + r4);
    L9:
        return r0;
    }

    static long b(InputStream r6, int r7) {
        byte[] r8 = a(r6, r7);
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L5;
        r0 = r0 + (((long) (r8[r2] & 255)) << (r2 * 8));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    static int a(InputStream r2) {
        return (int) b(r2, 1);
    }

    static int b(InputStream r2) {
        return (int) b(r2, 2);
    }

    static long c(InputStream r2) {
        return b(r2, 4);
    }

    static String c(InputStream r1, int r2) {
        return new String(a(r1, r2), StandardCharsets.UTF_8);
    }

    static byte[] a(InputStream r8, int r9, int r10) {
        Inflater r0 = new Inflater();
        byte[] r1 = new byte[r10];     // Catch: Throwable -> L29
        byte[] r2 = new byte[2048];     // Catch: Throwable -> L29
        int r4 = 0;
        int r5 = 0;
    L5:
        if (r0.finished() == true) goto L20;
        if (r0.needsDictionary() == true) goto L20;
        if (r4 >= r9) goto L20;
        int r6 = r8.read(r2);     // Catch: Throwable -> L29
        if (r6 < 0) goto L19;
        r0.setInput(r2, 0, r6);     // Catch: Throwable -> L29
        r5 = r5 + r0.inflate(r1, r5, r10 - r5);
        r4 = r4 + r6;
        goto L5
    L15:
        e = move-exception;
        throw b(e.getMessage());     // Catch: Throwable -> L29
    L19:
        throw b("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r9 + " bytes");     // Catch: Throwable -> L29
    L20:
        if (r4 != r9) goto L28;
        if (r0.finished() == false) goto L26;
        r0.end();
        return r1;
    L26:
        throw b("Inflater did not finish");     // Catch: Throwable -> L29
    L28:
        throw b("Didn't read enough bytes during decompression. expected=" + r9 + " actual=" + r4);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r0.end();
        throw th;
    }

    static void a(OutputStream r2, byte[] r3) {
        a(r2, r3.length);
        byte[] r4 = a(r3);
        a(r2, r4.length);
        r2.write(r4);
    }

    static byte[] a(byte[] r3) {
        Deflater r0 = new Deflater(1);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        DeflaterOutputStream r2 = new DeflaterOutputStream(r1, r0);     // Catch: Throwable -> L14
        r2.write(r3);     // Catch: Throwable -> L8
        r2.close();     // Catch: Throwable -> L14
        r0.end();
        return r1.toByteArray();
    L8:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r0.end();
        throw th;
    }

    static void a(InputStream r3, OutputStream r4) {
        byte[] r0 = new byte[512];
    L3:
        int r1 = r3.read(r0);
        if (r1 <= 0) goto L6;
        r4.write(r0, 0, r1);
        goto L3
    }

    static RuntimeException b(String r1) {
        return new IllegalStateException(r1);
    }
}
