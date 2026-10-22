package com.baidu.lbsapi.auth;

import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public static byte[] a(byte[] r100, byte[] r101, byte[] r102) throws Exception {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L16;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.length <= 0) goto L18;
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.length <= 0) goto L20;
        SecretKeySpec r103 = new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES);
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r104.init(2, r103, new IvParameterSpec(r100));
        return r104.doFinal(r102);
    L20:
        return null;
    L18:
        return null;
    L16:
        return null;
    }
}
