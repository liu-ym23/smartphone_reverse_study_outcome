package com.baidu.mapsdkplatform.comapi.util;

import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public final class AlgorithmUtil {
    private AlgorithmUtil() {
    }

    private static byte[] a(String r100, String r101, byte[] r102) throws Exception {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        SecretKeySpec r103 = new SecretKeySpec(r101.getBytes("ASCII"), CryptoConst.ALGORITHM_AES);
        Cipher r104 = Cipher.getInstance("AES/CBC/NoPadding");
        r104.init(2, r103, new IvParameterSpec(r100.getBytes()));
        return r104.doFinal(r102);
    L11:
        return null;
    }

    private static byte[] b(String r100, String r101, byte[] r102) throws Exception {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        SecretKeySpec r103 = new SecretKeySpec(r101.getBytes(), CryptoConst.ALGORITHM_AES);
        Cipher r104 = Cipher.getInstance("AES/CTR/NoPadding");
        r104.init(2, r103, new IvParameterSpec(r100.getBytes()));
        return r104.doFinal(r102);
    L11:
        return null;
    }

    private static byte[] c(String r100, String r101, byte[] r102) throws Exception {
        if (r101 != null) goto L5;
        return null;
    L5:
        SecretKeySpec r103 = new SecretKeySpec(r101.getBytes(), CryptoConst.ALGORITHM_AES);
        Cipher r104 = Cipher.getInstance("AES/CBC/NoPadding");
        r104.init(1, r103, new IvParameterSpec(r100.getBytes()));
        int r105 = r102.length;
    L7:
        if ((r105 % 16) == 0) goto L9;
        r105 = r105 + 1;
        goto L7
    L9:
        byte[] r106 = new byte[r105];
        int r107 = 0;
    L10:
        if (r107 >= r105) goto L17;
        if (r107 >= r102.length) goto L14;
        r106[r107] = r102[r107];
    L15:
        r107 = r107 + 1;
        goto L10
    L14:
        r106[r107] = 0;
        goto L15
    L17:
        return r104.doFinal(r106);
    }

    public static byte[] getDecryptInfo(String r100, String r101, byte[] r102) throws Exception {
        return b(r100, r101, r102);
    }

    public static byte[] getUrlNeedInfo(String r100, String r101, byte[] r102) throws Exception {
        return a(r100, r101, r102);
    }

    public static byte[] setUrlNeedInfo(String r100, String r101, byte[] r102) throws Exception {
        return c(r100, r101, r102);
    }
}
