package androidx.profileinstaller;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static int a(int r10) {
        return ((r10 + 7) & (-8)) / 8;
    }

    public static byte[] b(byte[] r10) {
        Deflater r11 = new Deflater(1);
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        DeflaterOutputStream r13 = new DeflaterOutputStream(r12, r11);     // Catch: Throwable -> L8
        r13.write(r10);     // Catch: Throwable -> L10
        r13.close();     // Catch: Throwable -> L8
        r11.end();
        return r12.toByteArray();
    L10:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Throwable -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r11.end();
        throw th;
    }

    public static RuntimeException c(String r10) {
        return new IllegalStateException(r10);
    }

    public static byte[] d(InputStream r10, int r11) {
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L9;
        int r14 = r10.read(r12, r13, r11 - r13);
        if (r14 < 0) goto L8;
        r13 = r13 + r14;
        goto L3
    L8:
        throw c("Not enough bytes to read: " + r11);
    L9:
        return r12;
    }

    public static byte[] e(InputStream r10, int r11, int r12) {
        Inflater r13 = new Inflater();
        byte[] r14 = new byte[r12];     // Catch: Throwable -> L15
        byte[] r15 = new byte[2048];     // Catch: Throwable -> L15
        int r16 = 0;
        int r17 = 0;
    L5:
        if (r13.finished() == true) goto L22;
        if (r13.needsDictionary() == true) goto L22;
        if (r16 >= r11) goto L22;
        int r18 = r10.read(r15);     // Catch: Throwable -> L15
        if (r18 < 0) goto L21;
        r13.setInput(r15, 0, r18);     // Catch: Throwable -> L15
        r17 = r17 + r13.inflate(r14, r17, r12 - r17);
        r16 = r16 + r18;
        goto L5
    L17:
        e = move-exception;
        throw c(e.getMessage());     // Catch: Throwable -> L15
    L21:
        throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r11 + " bytes");     // Catch: Throwable -> L15
    L22:
        if (r16 != r11) goto L30;
        if (r13.finished() == false) goto L28;
        r13.end();
        return r14;
    L28:
        throw c("Inflater did not finish");     // Catch: Throwable -> L15
    L30:
        throw c("Didn't read enough bytes during decompression. expected=" + r11 + " actual=" + r16);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r13.end();
        throw th;
    }

    public static String f(InputStream r10, int r11) {
        return new String(d(r10, r11), StandardCharsets.UTF_8);
    }

    public static long g(InputStream r10, int r11) {
        byte[] r12 = d(r10, r11);
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13 = r13 + (((long) (r12[r14] & UnsignedBytes.MAX_VALUE)) << (r14 * 8));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    public static int h(InputStream r10) {
        return (int) g(r10, 2);
    }

    public static long i(InputStream r10) {
        return g(r10, 4);
    }

    public static int j(InputStream r10) {
        return (int) g(r10, 1);
    }

    public static int k(String r10) {
        return r10.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void l(InputStream r10, OutputStream r11) {
        byte[] r12 = new byte[512];
    L3:
        int r13 = r10.read(r12);
        if (r13 <= 0) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    }

    public static void m(OutputStream r10, byte[] r11) {
        q(r10, r11.length);
        byte[] r12 = b(r11);
        q(r10, r12.length);
        r10.write(r12);
    }

    public static void n(OutputStream r10, String r11) {
        r10.write(r11.getBytes(StandardCharsets.UTF_8));
    }

    public static void o(OutputStream r10, long r11, int r12) {
        byte[] r13 = new byte[r12];
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13[r14] = (byte) ((r11 >> (r14 * 8)) & 255);
        r14 = r14 + 1;
        goto L3
    L5:
        r10.write(r13);
    }

    public static void p(OutputStream r10, int r11) {
        o(r10, r11, 2);
    }

    public static void q(OutputStream r10, long r11) {
        o(r10, r11, 4);
    }

    public static void r(OutputStream r10, int r11) {
        o(r10, r11, 1);
    }
}
