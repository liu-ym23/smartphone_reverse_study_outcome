package com.baidu.mapauto.auth.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class SHAUtil {
    public SHAUtil() {
    }

    private static String byte2Hex(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() != 1) goto L7;
        r101.append("0");
    L7:
        r101.append(r104);
        r103 = r103 + 1;
        goto L3
    L9:
        return r101.toString();
    }

    public static String getSHA256(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L4
        r101.update(r100.getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L4
        return byte2Hex(r101.digest());
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
