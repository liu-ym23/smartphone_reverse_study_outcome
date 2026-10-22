package com.byted.cast.linkcommon.security;

import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes28.dex */
public class SecurityUtil {
    public static final String ENCRYPT_ECB = "AES/ECB/PKCS5Padding";
    public static final String ENCRYPT_GCM = "AES/GCM/NoPadding";
    private static final Object TAG = null;
    private static final String keyBytes = "hijdkljdkjafjajd";

    public SecurityUtil() {
    }

    static {
        TAG = "SecurityUtil";
    }

    public static String decode(String r100) {
        byte[] r101 = decrypt(Base64.decode(r100.getBytes(), 2), keyBytes);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r101 != null) goto L10;
        return "";
    L10:
        return new String(r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L6
    }

    public static String encode(String r100) {
        byte[] r101 = encrypt(r100, keyBytes);
        if (r101 != null) goto L7;
        return "";
    L7:
        return Base64.encodeToString(r101, 2);
    }

    private static byte[] getKey(String r100) {
        if (r100 == null) goto L5;
        return r100.getBytes();
    L5:
        return new byte[24];
    }

    public static String decode(String r100, String r101) {
        byte[] r102 = decrypt(Base64.decode(r100.getBytes(), 2), keyBytes, r101);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r102 != null) goto L10;
        return "";
    L10:
        return new String(r102);
    L4:
        e = move-exception;
        e.printStackTrace();
        r102 = null;
        goto L6
    }

    private static byte[] decrypt(byte[] r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(getKey(r101), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L4
        Cipher r103 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Throwable -> L4
        r103.init(2, r102);     // Catch: Throwable -> L4
        return r103.doFinal(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String encode(String r100, String r101) {
        return Base64.encodeToString(encrypt(r100, keyBytes, r101), 2);
    }

    private static byte[] encrypt(String r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(getKey(r101), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L4
        Cipher r103 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Throwable -> L4
        byte[] r104 = r100.getBytes(XML.CHARSET_UTF8);     // Catch: Throwable -> L4
        r103.init(1, r102);     // Catch: Throwable -> L4
        return r103.doFinal(r104);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static byte[] decrypt(byte[] r100, String r101, String r102) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (TextUtils.equals(r102, "AES/ECB/PKCS5Padding") == false) goto L7;
        SecretKeySpec r103 = new SecretKeySpec(getKey(r101), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L9
        Cipher r104 = Cipher.getInstance(r102);     // Catch: Throwable -> L9
        r104.init(2, r103);     // Catch: Throwable -> L9
        return r104.doFinal(r100);
    L7:
        SecretKeySpec r105 = new SecretKeySpec(r101.getBytes("UTF-8"), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L9
        Cipher r106 = Cipher.getInstance(r102);     // Catch: Throwable -> L9
        r106.init(2, r105, new IvParameterSpec(r105.getEncoded(), 0, 16));     // Catch: Throwable -> L9
        return r106.doFinal(r100);
    }

    private static byte[] encrypt(String r100, String r101, String r102) {
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L5:
        if (TextUtils.equals(r102, "AES/ECB/PKCS5Padding") == false) goto L8;
        SecretKeySpec r103 = new SecretKeySpec(getKey(r101), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L10
        Cipher r104 = Cipher.getInstance(r102);     // Catch: Throwable -> L10
        byte[] r105 = r100.getBytes(XML.CHARSET_UTF8);     // Catch: Throwable -> L10
        r104.init(1, r103);     // Catch: Throwable -> L10
        return r104.doFinal(r105);
    L8:
        SecretKeySpec r106 = new SecretKeySpec(r101.getBytes("UTF-8"), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L10
        Cipher r107 = Cipher.getInstance(r102);     // Catch: Throwable -> L10
        IvParameterSpec r108 = new IvParameterSpec(r106.getEncoded(), 0, 16);     // Catch: Throwable -> L10
        byte[] r109 = r100.getBytes("UTF-8");     // Catch: Throwable -> L10
        r107.init(1, r106, r108);     // Catch: Throwable -> L10
        return r107.doFinal(r109);
    }
}
