package com.alipay.sdk.m.g;

import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SecureRandom f25314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f25315b = null;

    public static byte[] a(byte r100) {
        return new byte[]{r100};
    }

    public static byte[] a(char r100) {
        return new byte[]{(byte) (r100 & 255)};
    }

    public static byte[] a(char r100, char r101) {
        return new byte[]{(byte) (r100 & 255), (byte) (r101 & 255)};
    }

    public static byte[] a(int r100) {
        return new byte[]{(byte) r100, (byte) (r100 >> 8), (byte) (r100 >> 16), (byte) (r100 >> 24)};
    }

    public static byte[] a(long r100) {
        return new byte[]{(byte) r100, (byte) (r100 >> 8), (byte) (r100 >> 16), (byte) (r100 >> 24), (byte) (r100 >> 32), (byte) (r100 >> 40), (byte) (r100 >> 48), (byte) (r100 >> 56)};
    }

    public static byte[] a(short r100) {
        return new byte[]{(byte) r100, (byte) (r100 >> 8)};
    }

    public static byte[] b() {
        byte[] r100 = new byte[2];
        a().nextBytes(r100);
        return r100;
    }

    public static byte[] c() {
        byte[] r100 = new byte[4];
        a().nextBytes(r100);
        return r100;
    }

    static {
        f25315b = "0123456789ABCDEF".toCharArray();
    }

    public static SecureRandom a() {
        if (f25314a == null) goto L7;
        return f25314a;
    L7:
        monitor-enter(c.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (f25314a != null) goto L11;
        f25314a = new SecureRandom();     // Catch: Throwable -> L14
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L14
        return f25314a;
    }

    public c() {
    }

    public static byte[] a(byte[]... r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r103 = r103 + r100[r102].length;
        r102 = r102 + 1;
        goto L3
    L5:
        int r104 = r100.length;
        byte[] r105 = null;
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= r104) goto L12;
        byte[] r108 = r100[r106];
        if (r105 != null) goto L10;
        r105 = Arrays.copyOf(r108, r103);
        r107 = r108.length;
    L11:
        r106 = r106 + 1;
        goto L6
    L10:
        System.arraycopy(r108, 0, r105, r107, r108.length);
        r107 = r107 + r108.length;
        goto L11
    L12:
        return r105;
    }

    public static String b(byte[] r100) {
        char[] r101 = new char[r100.length * 2];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r102 * 2;
        char[] r105 = f25315b;
        r101[r104] = r105[r103 >>> 4];
        r101[r104 + 1] = r105[r103 & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    public static String a(byte[] r100) {
        return Base64.encodeToString(r100, 3);
    }
}
