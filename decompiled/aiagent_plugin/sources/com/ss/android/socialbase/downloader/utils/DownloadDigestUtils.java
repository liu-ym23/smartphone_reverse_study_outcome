package com.ss.android.socialbase.downloader.utils;

import com.bytedance.crypto.utils.CryptoConst;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadDigestUtils {
    static final char[] HEX_CHARS = null;

    public DownloadDigestUtils() {
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String toHexString(byte[] r2) {
        Objects.requireNonNull(r2, "bytes is null");
        return toHexString(r2, 0, r2.length);
    }

    public static String toHexString(byte[] r9, int r10, int r11) {
        Objects.requireNonNull(r9, "bytes is null");
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & 255;
        int r6 = r4 + 1;
        char[] r7 = HEX_CHARS;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    }

    public static String md5Hex(File r7) {
        FileInputStream r0 = null;
        MessageDigest r3 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Throwable -> L18 Exception -> L21
        if (r3 != null) goto L7;
        DownloadUtils.safeClose(new Closeable[]{null});
        return null;
    L7:
        FileInputStream r4 = new FileInputStream(r7);     // Catch: Throwable -> L18 Exception -> L21
    L25:
        byte[] r5 = new byte[8192];     // Catch: Throwable -> L16 Exception -> L24
    L10:
        int r6 = r4.read(r5, 0, 8192);     // Catch: Throwable -> L16 Exception -> L24
        if (r6 <= 0) goto L13;
        r3.update(r5, 0, r6);     // Catch: Throwable -> L16 Exception -> L24
        goto L10
    L13:
        String r8 = toHexString(r3.digest());     // Catch: Throwable -> L16 Exception -> L24
        DownloadUtils.safeClose(new Closeable[]{r4});
        return r8;
    L16:
        th = th;
        r0 = r4;
    L19:
        DownloadUtils.safeClose(new Closeable[]{r0});
        throw th;
    L22:
        DownloadUtils.safeClose(new Closeable[]{r4});
        return null;
    L21:
        r4 = null;
    L18:
        th = th;
        goto L19
    }

    public static byte[] hexStringToBytes(String r7) {
        if (r7 == null) goto L10;
        if ((r7.length() % 2) == 1) goto L10;
        char[] r8 = r7.toCharArray();
        int r0 = r8.length;
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2 / 2] = (byte) ((Character.digit(r8[r2], 16) << 4) + Character.digit(r8[r2 + 1], 16));
        r2 = r2 + 2;
        goto L6
    L8:
        return r1;
    L10:
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + r7);
    }

    public static String md5Hex(String r3) {
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        if (r3.length() == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r1.update(r3.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r1.digest());
    }

    public static String md5Hex(byte[] r2) {
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        if (r2.length == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r1.update(r2);     // Catch: Exception -> L10
        return toHexString(r1.digest());
    }

    public static String md5Hex(byte[] r3, int r4, int r5) {
        if (r3 == null) goto L12;
        if (r4 < 0) goto L12;
        if (r5 <= 0) goto L12;
        if ((r4 + r5) > r3.length) goto L12;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L13
        r1.update(r3, r4, r5);     // Catch: Exception -> L13
        return toHexString(r1.digest());
    L12:
        return null;
    }
}
