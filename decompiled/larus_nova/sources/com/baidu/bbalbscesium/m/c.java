package com.baidu.bbalbscesium.m;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class c {
    private c() {
    }

    public static String a(byte[] r100, String r101, boolean r102) {
        StringBuilder r103 = new StringBuilder();
        int r104 = r100.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L12;
        String r106 = Integer.toHexString(r100[r105] & UByte.MAX_VALUE);
        if (r102 == false) goto L8;
        r106 = r106.toUpperCase();
    L8:
        if (r106.length() != 1) goto L10;
        r103.append("0");
    L10:
        r103.append(r106);
        r103.append(r101);
        r105 = r105 + 1;
        goto L3
    L12:
        return r103.toString();
    }

    public static String a(byte[] r100, boolean r101) {
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
        r102.reset();     // Catch: NoSuchAlgorithmException -> L4
        r102.update(r100);     // Catch: NoSuchAlgorithmException -> L4
        return a(r102.digest(), "", r101);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
