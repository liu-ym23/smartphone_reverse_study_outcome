package com.baidu.mapauto.auth.util;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes39.dex */
public class AESGCMPKCS5PaddingUtil {
    private static final Charset CHARSET_UTF8 = null;
    private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    private static final String DEFAULT_VALUE = "0";
    private static final String KEY_ALGORITHM = "AES";
    public static final int SECRET_KEY_LENGTH = 32;

    static {
        CHARSET_UTF8 = StandardCharsets.UTF_8;
    }

    public AESGCMPKCS5PaddingUtil() {
    }

    public static byte[] base64Decode(String r100) {
        return Base64.decode(r100, 2);
    }

    public static String base64Encode(byte[] r100) {
        return Base64.encodeToString(r100, 2);
    }

    public static String decrypt(String r100, String r101) {
        byte[] r102 = base64Decode(r100);     // Catch: Exception -> L11
        if (r102 != null) goto L5;
        return "";
    L5:
        if (r102.length < 12) goto L16;
        byte[] r103 = new byte[12];     // Catch: Exception -> L11
        int r104 = r102.length - 12;     // Catch: Exception -> L11
        byte[] r105 = new byte[r104];     // Catch: Exception -> L11
        System.arraycopy(r102, 0, r103, 0, 12);     // Catch: Exception -> L11
        System.arraycopy(r102, 12, r105, 0, r104);     // Catch: Exception -> L11
        Cipher r106 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L11
        GCMParameterSpec r107 = new GCMParameterSpec(128, r103);     // Catch: Exception -> L11
        r106.init(2, getSecretKey(r101), r107);     // Catch: Exception -> L11
        return new String(r106.doFinal(r105), CHARSET_UTF8);
    L16:
        return "";
    L11:
        e = move-exception;
        handleException(e);
        return null;
    }

    public static String encrypt(String r100, String r101) {
        Cipher r102 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L4
        byte[] r103 = new byte[12];     // Catch: Exception -> L4
        new SecureRandom().nextBytes(r103);     // Catch: Exception -> L4
        GCMParameterSpec r104 = new GCMParameterSpec(128, r103);     // Catch: Exception -> L4
        r102.init(1, getSecretKey(r101), r104);     // Catch: Exception -> L4
        byte[] r105 = r102.doFinal(r100.getBytes(CHARSET_UTF8));     // Catch: Exception -> L4
        byte[] r106 = new byte[r105.length + 12];     // Catch: Exception -> L4
        System.arraycopy(r103, 0, r106, 0, 12);     // Catch: Exception -> L4
        System.arraycopy(r105, 0, r106, 12, r105.length);     // Catch: Exception -> L4
        return base64Encode(r106);
    L4:
        e = move-exception;
        handleException(e);
        return null;
    }

    public static SecretKeySpec getSecretKey(String r100) {
        return new SecretKeySpec(toMakeKey(r100, 32, "0").getBytes(CHARSET_UTF8), "AES");
    }

    private static void handleException(Exception r100) {
        r100.printStackTrace();
    }

    private static String toMakeKey(String r100, int r101, String r102) {
        int r103 = r100.length();
        if (r103 >= r101) goto L10;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        int r105 = 0;
    L6:
        if (r105 >= (r101 - r103)) goto L8;
        r104.append(r102);
        r105 = r105 + 1;
        goto L6
    L8:
        r100 = r104.toString();
    L10:
        return r100.substring(0, 32);
    }
}
