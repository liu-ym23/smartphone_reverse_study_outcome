package com.bytedance.crash.o;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Digest.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static String a(String r9) {
        MessageDigest r0 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Throwable -> L11
        r0.update(r9.getBytes());     // Catch: Throwable -> L11
        byte[] r10 = r0.digest();     // Catch: Throwable -> L11
        if (r10.length <= 0) goto L9;
        int r2 = 0;
        char[] r1 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};     // Catch: Throwable -> L11
        char[] r3 = new char[r10.length * 2];     // Catch: Throwable -> L11
        int r4 = r10.length;     // Catch: Throwable -> L11
        int r5 = 0;
    L5:
        if (r2 >= r4) goto L7;
        byte r6 = r10[r2];     // Catch: Throwable -> L11
        int r7 = r5 + 1;     // Catch: Throwable -> L11
        r3[r5] = r1[(r6 >>> 4) & 15];     // Catch: Throwable -> L11
        r5 = r7 + 1;     // Catch: Throwable -> L11
        r3[r7] = r1[r6 & 15];     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L5
    L7:
        return new String(r3);
    L9:
        return null;
    L15:
        return null;
    }
}
