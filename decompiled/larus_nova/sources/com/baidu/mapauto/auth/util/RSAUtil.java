package com.baidu.mapauto.auth.util;

import android.text.TextUtils;
import com.baidu.mapauto.auth.org.spongycastle.asn1.i;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m0;
import com.baidu.mapauto.auth.org.spongycastle.asn1.pkcs.a;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.util.io.pem.b;
import com.baidu.mapauto.auth.org.spongycastle.util.io.pem.c;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class RSAUtil {
    private static final String ALGORITHMS = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
    private static final String ALGORITHM_KEY = "RSA";
    private static final int KEY_SIZE = 2048;
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static KeyPair keyPair;

    public RSAUtil() {
    }

    public static String byte2Hex(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L10;
        r101.append(Integer.toString((r100[r102] & UByte.MAX_VALUE) + 256, 16).substring(1));
        r102 = r102 + 1;
        goto L7
    L10:
        return r101.toString();
    }

    public static byte[] decode(String r100, PrivateKey r101) {
        Cipher r102 = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");     // Catch: Exception -> L6
        r102.init(2, r101, new OAEPParameterSpec("SHA1", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));     // Catch: Exception -> L6
        return r102.doFinal(hex2Byte(r100));
    L6:
        return null;
    }

    public static byte[] decryptHexStringBySec(String r100, PrivateKey r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        byte[] r102 = hex2Byte(r100);     // Catch: Exception -> L7
        Cipher r103 = Cipher.getInstance(ALGORITHMS);     // Catch: Exception -> L7
        r103.init(2, r101);     // Catch: Exception -> L7
        return r103.doFinal(r102);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String encrypt(String r100, PublicKey r101) throws Exception {
        Cipher r102 = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        r102.init(1, r101, new OAEPParameterSpec("SHA1", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
        return byte2Hex(r102.doFinal(r100.getBytes("UTF-8")));
    }

    public static String encryptToHexStringPub(String r100, PublicKey r101) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 == null) goto L10;
        Cipher r102 = Cipher.getInstance(ALGORITHMS);     // Catch: Exception -> L8
        r102.init(1, r101);     // Catch: Exception -> L8
        return byte2Hex(r102.doFinal(r100.getBytes(StandardCharsets.UTF_8)));
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        return null;
    }

    public static KeyPair generateKeyPair() {
        KeyPairGenerator r100 = KeyPairGenerator.getInstance("RSA");     // Catch: Exception -> L7
        r100.initialize(2048, new SecureRandom());     // Catch: Exception -> L7
        if (keyPair != null) goto L5;
        keyPair = r100.generateKeyPair();     // Catch: Exception -> L7
    L5:
        return keyPair;
    L7:
        return null;
    }

    public static PrivateKey getPrivateKeyFrom16(String r100) {
        PKCS8EncodedKeySpec r101 = new PKCS8EncodedKeySpec(hex2Byte(r100));     // Catch: Exception -> L4
        return KeyFactory.getInstance("RSA").generatePrivate(r101);
    L4:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static PrivateKey getPrivateKeyFromPemString(String r100, boolean r101) {
        if (r101 == true) goto L8;
        r100 = pemString2PemFormat(r100);
    L8:
        byte[] r102 = Base64Util.decode(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L6
        return (PrivateKey) KeyFactory.getInstance("RSA").generatePublic(new PKCS8EncodedKeySpec(r102));
    L6:
        return null;
    }

    public static String getPrivateKeyStr(PrivateKey r100) throws Exception {
        return byte2Hex(r100.getEncoded());
    }

    public static PublicKey getPublicKey(String r100) {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(Base64Util.decode(r100.getBytes(StandardCharsets.UTF_8)));     // Catch: Throwable -> L4 NoSuchAlgorithmException -> L6
        return KeyFactory.getInstance("RSA").generatePublic(r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static PublicKey getPublicKeyFromPemString(String r100, boolean r101) {
        if (r101 == true) goto L8;
        r100 = pemString2PemFormat(r100);
    L8:
        byte[] r102 = formatPublicKeyPKCS1ToPKCS8(Base64Util.decode(r100.getBytes(StandardCharsets.UTF_8)));     // Catch: Throwable -> L6
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(r102));
    L6:
        return null;
    }

    public static byte[] hex2Byte(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() < 1) goto L14;
        byte[] r101 = new byte[r100.length() / 2];
        int r102 = 0;
    L8:
        if (r102 >= (r100.length() / 2)) goto L10;
        int r103 = r102 * 2;
        int r104 = r103 + 1;
        int r105 = CastIntegerProtector.parseInt(r100.substring(r103, r104), 16);
        int r106 = r105 * 16;
        r101[r102] = (byte) (r106 + CastIntegerProtector.parseInt(r100.substring(r104, r103 + 2), 16));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L14:
        return null;
    }

    public static String pemFormat2PemString(String r100) {
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r100.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
    L15:
        String r103 = r102.readLine();     // Catch: IOException -> L13
        if (r103 == null) goto L11;
        if (r103.contains("-----END RSA PUBLIC KEY-----") == true) goto L15;
        if (r103.contains("-----BEGIN RSA PUBLIC KEY-----") == true) goto L15;
        r101.append(r103);     // Catch: IOException -> L13
        goto L15
    L11:
        return r101.toString();
    L14:
        return r101.toString();
    }

    public static String pemString2PemFormat(String r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L11;
        if (r102 == 0) goto L9;
        if ((r102 % 64) != 0) goto L9;
        r101.append('\n');
    L9:
        r101.append(r100.charAt(r102));
        r102 = r102 + 1;
        goto L4
    L11:
        return r101.toString();
    }

    public static boolean verify(String r100, PublicKey r101, String r102) {
        Signature r103 = Signature.getInstance(SIGNATURE_ALGORITHM);     // Catch: Exception -> L4
        r103.initVerify(r101);     // Catch: Exception -> L4
        r103.update(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L4
        return r103.verify(hex2Byte(r102));
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static String convertCS2Pem(byte[] r100) {
        b r101 = new b(b.f31923c, r100);     // Catch: IOException -> L4
        StringWriter r102 = new StringWriter();     // Catch: IOException -> L4
        c r103 = new c(r102);     // Catch: IOException -> L4
        r103.a(r101);     // Catch: IOException -> L4
        r103.close();     // Catch: IOException -> L4
        return r102.toString();
    L4:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] formatPublicKeyPKCS1ToPKCS8(byte[] r100) {
        if ((r100 instanceof a) == false) goto L5;
        a r101 = (a) r100;
    L15:
        return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(r101.f31873a, r101.f31874b)).getEncoded();
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r100 == 0) goto L7;
        r101 = new a(s.a(r100));
        goto L15
    L7:
        r101 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getPublicKeyCS1Pem(PublicKey r100) {
        byte[] r101 = r100.getEncoded();     // Catch: IOException -> L15
        if ((r101 instanceof com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b) == false) goto L6;
        com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b r102 = (com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b) r101;     // Catch: IOException -> L15
    L9:
        r102.getClass();     // Catch: IOException -> L15
        m0 r103 = r102.f31906b;     // Catch: IOException -> L15
        if (r103.f31816b != 0) goto L14;
        byte[] r104 = new i(com.baidu.mapauto.auth.org.spongycastle.util.a.a(r103.f31815a)).a().d();     // Catch: IOException -> L15
        formatPublicKeyPKCS1ToPKCS8(r104);     // Catch: IOException -> L15
        return pemFormat2PemString(convertCS2Pem(r104));
    L14:
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");     // Catch: IOException -> L15
    L6:
        if (r101 == 0) goto L8;
        r102 = new com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b(s.a(r101));     // Catch: IOException -> L15
        goto L9
    L8:
        r102 = null;
    L15:
        return null;
    }
}
