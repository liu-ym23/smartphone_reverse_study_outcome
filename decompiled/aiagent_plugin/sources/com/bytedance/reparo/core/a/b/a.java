package com.bytedance.reparo.core.a.b;

import com.bytedance.crypto.utils.CryptoConst;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: compiled from: DigestUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f9151a = null;

    static {
        f9151a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] r2) {
        Objects.requireNonNull(r2, "bytes is null");
        return a(r2, 0, r2.length);
    }

    public static String a(byte[] r9, int r10, int r11) {
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
        char[] r7 = f9151a;
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

    public static String a(File r6) {
        if (r6 != null) goto L5;
    L16:
        return null;
    L5:
        if (r6.exists() == false) goto L16;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L17
        if (r1 != null) goto L10;
        return null;
    L10:
        FileInputStream r2 = new FileInputStream(r6);     // Catch: Exception -> L17
        byte[] r3 = new byte[8192];     // Catch: Exception -> L17
    L11:
        int r5 = r2.read(r3, 0, 8192);     // Catch: Exception -> L17
        if (r5 <= 0) goto L14;
        r1.update(r3, 0, r5);     // Catch: Exception -> L17
        goto L11
    L14:
        r2.close();     // Catch: Exception -> L17
        return a(r1.digest());
    }

    public static String a(String r3) {
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        if (r3.length() == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r1.update(r3.getBytes("UTF-8"));     // Catch: Exception -> L10
        return a(r1.digest());
    }
}
