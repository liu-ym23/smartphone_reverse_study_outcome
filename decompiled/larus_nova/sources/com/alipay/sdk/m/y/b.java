package com.alipay.sdk.m.y;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes28.dex */
public final class b {
    public static String a(String r100) {
    L13:
        return null;
    L4:
        if (com.alipay.sdk.m.z.a.a(r100) == false) goto L6;
        return null;
    L6:
        MessageDigest r101 = MessageDigest.getInstance("SHA-1");     // Catch: Exception -> L13
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L13
        byte[] r102 = r101.digest();     // Catch: Exception -> L13
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L13
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L11;
        r103.append(String.format("%02x", new Object[]{Byte.valueOf(r102[r104])}));     // Catch: Exception -> L13
        r104 = r104 + 1;     // Catch: Exception -> L13
        goto L8
    L11:
        return r103.toString();
    }
}
