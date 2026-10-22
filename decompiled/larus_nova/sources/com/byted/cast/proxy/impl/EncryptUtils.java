package com.byted.cast.proxy.impl;

import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoConst;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public class EncryptUtils {
    private static final String AES_CBC = "AES/CBC/PKCS7Padding";

    public EncryptUtils() {
    }

    public static SecretKey generateAes128Key() throws Exception {
        KeyGenerator r100 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);
        r100.init(128, new SecureRandom());
        return r100.generateKey();
    }

    public static SecretKey generateHmacSHA256Key() throws Exception {
        KeyGenerator r100 = KeyGenerator.getInstance("HmacSHA256");
        r100.init(256, new SecureRandom());
        return r100.generateKey();
    }

    public static byte[] hmac(String r100) throws Exception {
        Mac r101 = Mac.getInstance("HmacSHA256");
        r101.init(new SecretKeySpec(generateHmacSHA256Key().getEncoded(), r101.getAlgorithm()));
        return r101.doFinal(r100.getBytes());
    }

    public static String urlDecoded(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return URLDecoder.decode(r100, "UTF-8");
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String urlEncoded(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return URLEncoder.encode(r100, "UTF-8");
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static byte[] decrypt(byte[] r100, byte[] r101) throws Exception {
        SecretKeySpec r102 = new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES);
        Cipher r103 = Cipher.getInstance(AES_CBC);
        r103.init(2, r102, new IvParameterSpec(new byte[r103.getBlockSize()]));
        return r103.doFinal(r100);
    }

    public static String decryptData(byte[] r100, byte[] r101) throws Exception {
        return new String(decrypt(r100, r101), "UTF-8");
    }

    public static byte[] encrypt(byte[] r100, byte[] r101) throws Exception {
        SecretKeySpec r102 = new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES);
        Cipher r103 = Cipher.getInstance(AES_CBC);
        r103.init(1, r102, new IvParameterSpec(new byte[r103.getBlockSize()]));
        return r103.doFinal(r100);
    }

    public static byte[] encrypt(String r100, byte[] r101) throws Exception {
        return encrypt(r100.getBytes("UTF-8"), r101);
    }
}
