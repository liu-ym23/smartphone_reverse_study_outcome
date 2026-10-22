package com.android.ttcjpaysdk.thirdparty.fingerprint;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.text.TextUtils;
import android.util.Base64;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayKeyManager {
    private static final int AES_KEY_SIZE = 256;
    private static final String BLOCK_MODE_CBC = "CBC";
    private static final String BLOCK_MODE_ECB = "ECB";
    private static final int BLOCK_SIZE = 16;
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String KEY_ALGORITHM_AES = "AES";
    private static final String KEY_ALGORITHM_RSA = "RSA";
    private static final String PKCS1_PADDING = "PKCS1Padding";
    private static final String PKCS7_PADDING = "PKCS7Padding";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5ZvJz6ooLtOppomaQqkwLciushwtw8wOKKudkGYqiOzEn3Q0wskw2w2L2Ve1uvOPGHsKH/haEWgqSQpmp2gIKGlZHZnLVzecNUEtEoogeZcJ9BC4YiCYLYt3HUUIfOXRSsoWsmEd2/rUQYAxdI5rq0Bj5d00PQB2yXQioHsDHPwIDAQAB";
    private static KeyPair keyPair;

    public CJPayKeyManager() {
    }

    private static KeyStore loadKeystore() {
        KeyStore r100 = KeyStore.getInstance(KEYSTORE_PROVIDER);     // Catch: Throwable -> L5 IOException -> L7 NoSuchAlgorithmException -> L9 CertificateException -> L11 KeyStoreException -> L13
        r100.load(null);     // Catch: Throwable -> L5 IOException -> L7 NoSuchAlgorithmException -> L9 CertificateException -> L11 KeyStoreException -> L13
        return r100;
    L7:
        e = move-exception;
        e.printStackTrace();
    L15:
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static KeyPair generateRSAKeyPair() {
        KeyPairGenerator r100 = KeyPairGenerator.getInstance("RSA");     // Catch: Throwable -> L4 NoSuchAlgorithmException -> L6
        r100.initialize(1024);     // Catch: Throwable -> L4 NoSuchAlgorithmException -> L6
        return r100.genKeyPair();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static Cipher getRSACipher() {
        return Cipher.getInstance("RSA/ECB/PKCS1Padding");
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static PublicKey loadPublicKey() {
        X509EncodedKeySpec r100 = new X509EncodedKeySpec(Base64.decode(PUBLIC_KEY, 0));
        return KeyFactory.getInstance("RSA").generatePublic(r100);
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    static {
        keyPair = generateRSAKeyPair();
    }

    private static String base64Encode(byte[] r100) {
        String r101 = Base64.encodeToString(r100, 10);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return "";
    L5:
        return r101.replace("_", "^");
    }

    public static byte[] decryptByPrivate(byte[] r100) {
        PrivateKey r101 = keyPair.getPrivate();     // Catch: Throwable -> L6 IllegalBlockSizeException -> L8 BadPaddingException -> L10 InvalidKeyException -> L12
        Cipher r102 = getRSACipher();     // Catch: Throwable -> L6 IllegalBlockSizeException -> L8 BadPaddingException -> L10 InvalidKeyException -> L12
        if (r102 == null) goto L18;
        r102.init(2, r101);     // Catch: Throwable -> L6 IllegalBlockSizeException -> L8 BadPaddingException -> L10 InvalidKeyException -> L12
        return r102.doFinal(r100);
    L18:
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String encryptByPublic(byte[] r100) {
        PublicKey r101 = loadPublicKey();     // Catch: Throwable -> L6 IllegalBlockSizeException -> L8 BadPaddingException -> L10 InvalidKeyException -> L12
        Cipher r102 = getRSACipher();     // Catch: Throwable -> L6 IllegalBlockSizeException -> L8 BadPaddingException -> L10 InvalidKeyException -> L12
        if (r102 == null) goto L18;
        r102.init(1, r101);     // Catch: Throwable -> L6 IllegalBlockSizeException -> L8 BadPaddingException -> L10 InvalidKeyException -> L12
        return base64Encode(r102.doFinal(r100));
    L18:
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static void generateAESKeyInKeystore(String r100) {
        loadKeystore();
        KeyGenerator r101 = KeyGenerator.getInstance("AES", KEYSTORE_PROVIDER);     // Catch: Throwable -> L5
        r101.init(new KeyGenParameterSpec.Builder(r100, 3).setBlockModes(new String[]{BLOCK_MODE_CBC}).setUserAuthenticationRequired(true).setEncryptionPaddings(new String[]{PKCS7_PADDING}).build());     // Catch: Throwable -> L5
        r101.generateKey();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        fingerprintExceptionUpload("generateAESKeyInKeystore", th.getMessage());
        th.printStackTrace();
    }

    public static SecretKey loadKeyFromKeystore(String r100) {
        KeyStore r101 = loadKeystore();
        if (r101 != null) goto L15;
    L14:
        return null;
    L15:
        return (SecretKey) r101.getKey(r100, null);
    L8:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    private static IvParameterSpec buildIv(int r100, byte[] r101) {
        byte[] r102 = new byte[r100];
        System.arraycopy(r101, 0, r102, 0, r100);
        return new IvParameterSpec(r102);
    }

    public static byte[] decryptWithAES(byte[] r100, byte[] r101) {
        Cipher r102 = getAESCipher(2, new SecretKeySpec(r100, "AES"), buildIv(16, r100));     // Catch: Throwable -> L6 KeyPermanentlyInvalidatedException -> L8 IllegalBlockSizeException -> L10 BadPaddingException -> L12
        if (r102 == null) goto L18;
        return r102.doFinal(r101);
    L18:
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String encryptWithAES(byte[] r100, String r101) {
        Cipher r102 = getAESCipher(1, new SecretKeySpec(r100, "AES"), buildIv(16, r100));     // Catch: Throwable -> L6 KeyPermanentlyInvalidatedException -> L8 IllegalBlockSizeException -> L10 BadPaddingException -> L12
        if (r102 == null) goto L18;
        return base64Encode(r102.doFinal(r101.getBytes()));
    L18:
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static void fingerprintExceptionUpload(String r100, String r101) {
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams("", "");
        KtSafeMethodExtensionKt.safePut(r102, "method_name", r100);
        KtSafeMethodExtensionKt.safePut(r102, "error_msg", r101);
        CJPayCallBackCenter.getInstance().onMonitor("wallet_rd_exception_log", r102);
    }

    public static Cipher getAESCipher(int r100, SecretKey r101, IvParameterSpec r102) throws KeyPermanentlyInvalidatedException {
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L5 KeyPermanentlyInvalidatedException -> L8
        r103.init(r100, r101, r102);     // Catch: Throwable -> L5 KeyPermanentlyInvalidatedException -> L8
        return r103;
    L8:
        e = move-exception;
        fingerprintExceptionUpload("getAESCipher", e.getMessage());
        throw new KeyPermanentlyInvalidatedException(e.getMessage());
    L5:
        th = move-exception;
        fingerprintExceptionUpload("getAESCipher", th.getMessage());
        th.printStackTrace();
        return null;
    }
}
