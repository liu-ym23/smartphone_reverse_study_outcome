package com.byted.cast.common.crypto;

import com.byted.cast.common.StringUtil;

/* JADX INFO: loaded from: classes39.dex */
public class CryptoUtil {
    public static final int CRYPTO_MODE_OFF = 0;
    public static final int CRYPTO_MODE_SOFT = 1;
    public static final int CRYPTO_MODE_STRONG = 2;
    public static final String CRYPTO_UNIQUE_KEY = "cryptoUniqueKey";

    public CryptoUtil() {
    }

    public static String base64Decode(String r100) {
        byte[] r101 = JavaCryptoUtil.base64Decode(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return new String(r101);
    }

    public static String base64Encode(String r100) {
        return StringUtil.getNonEmptyString(JavaCryptoUtil.base64Encode(r100.getBytes()));
    }

    public static String sha256Encode(String r100) {
        return StringUtil.getNonEmptyString(JavaCryptoUtil.sha256Encode(r100));
    }

    public static String rsaDecryptWithPublicKey(String r100, String r101) {
        return StringUtil.getNonEmptyString(JavaCryptoUtil.rsaDecryptWithPublicKey(r100, r101));
    }

    public static String rsaEncryptWithPrivateKey(String r100, String r101) {
        return StringUtil.getNonEmptyString(JavaCryptoUtil.rsaEncryptWithPrivateKey(r100, r101));
    }
}
