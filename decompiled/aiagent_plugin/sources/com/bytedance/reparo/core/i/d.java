package com.bytedance.reparo.core.i;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: NetworkSignUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f9284a = null;

    public static String a(String r3, String r4) {
        Mac r1 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L5
        r1.init(new SecretKeySpec(r4.getBytes(), "HmacSHA256"));     // Catch: Exception -> L5
        return a(r1.doFinal(r3.getBytes()));
    L5:
        return "";
    }

    static {
        f9284a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString().toLowerCase();
    }
}
