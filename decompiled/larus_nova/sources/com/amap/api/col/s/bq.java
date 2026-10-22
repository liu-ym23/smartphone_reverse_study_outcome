package com.amap.api.col.s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes28.dex */
public final class bq {
    public static String a(byte[] r100) {
        return bs.e(a(r100, bs.c("ETUQ1")));
    }

    public static String b(String r100) {
        return bs.f(d(r100));
    }

    private static byte[] c(String r100) {
        return e(r100);
    L4:
        th = move-exception;
        cd.a(th, "MD5", "gmb");
        return new byte[0];
    }

    private static byte[] d(String r100) {
        return e(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return new byte[0];
    }

    private static byte[] e(String r100) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (r100 != null) goto L5;
        return null;
    L5:
        MessageDigest r101 = MessageDigest.getInstance(bs.c("ETUQ1"));
        r101.update(bs.a(r100));
        return r101.digest();
    }

    public static String a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return bs.e(c(r100));
    }

    private static byte[] a(byte[] r100, String r101) {
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: Throwable -> L4
        r102.update(r100);     // Catch: Throwable -> L4
        return r102.digest();
    L4:
        th = move-exception;
        cd.a(th, "MD5", "gmb");
        return null;
    }
}
