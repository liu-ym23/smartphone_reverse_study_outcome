package com.amap.api.col.s;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes28.dex */
public final class bz {
    public static PublicKey a(String r100) throws Exception {
        byte[] r101 = bv.a(r100);     // Catch: NullPointerException -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
        return KeyFactory.getInstance(bs.c("EUlNB")).generatePublic(new X509EncodedKeySpec(r101));
    L5:
        throw new Exception("公钥数据为空");
    L9:
        throw new Exception("无此算法");
    L7:
        throw new Exception("公钥非法");
    }

    public static byte[] a(byte[] r100, PublicKey r101) {
        Cipher r102 = Cipher.getInstance(bs.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L4
        r102.init(1, r101);     // Catch: Throwable -> L4
        return r102.doFinal(r100);
    L4:
        return null;
    }
}
