package com.alipay.sdk.m.n;

import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes28.dex */
public class c {
    public c() {
    }

    public static byte[] a(Cipher r100, String r101) {
        SecureRandom r102 = new SecureRandom();
        int r103 = r100.getBlockSize();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = String.valueOf(r102.nextDouble());
    L5:
        int r104 = r103 * 2;
        byte[] r105 = new byte[r104];
        byte[] r106 = new byte[r103];
        r102.nextBytes(r106);
        int r107 = 1;
    L7:
        if (r107 >= r104) goto L12;
        byte r108 = (byte) (r101.codePointAt(r107 % r101.length()) & 127);
        r105[r107] = r108;
        if (r107 < r103) goto L11;
        r105[r107] = (byte) (r105[0] & r108);
    L11:
        r107 = r107 + 1;
        goto L7
    L12:
        System.arraycopy(r105, r103, r106, 0, r103);
        return r106;
    }
}
