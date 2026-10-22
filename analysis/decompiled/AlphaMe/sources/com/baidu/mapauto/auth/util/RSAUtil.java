package com.baidu.mapauto.auth.util;

import android.text.TextUtils;
import com.baidu.mapauto.auth.org.spongycastle.asn1.i;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m0;
import com.baidu.mapauto.auth.org.spongycastle.asn1.pkcs.a;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.util.io.pem.b;
import com.baidu.mapauto.auth.org.spongycastle.util.io.pem.c;
import com.stepos.activeview.utils.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class RSAUtil {
    private static final String ALGORITHMS = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
    private static final String ALGORITHM_KEY = "RSA";
    private static final int KEY_SIZE = 2048;
    public static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static KeyPair keyPair;

    public static String byte2Hex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            sb.append(Integer.toString((b4 & UByte.MAX_VALUE) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    public static String convertCS2Pem(byte[] bArr) throws IOException {
        try {
            b bVar = new b(b.f7803c, bArr);
            StringWriter stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.a(bVar);
            cVar.close();
            return stringWriter.toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public static byte[] decode(String str, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            cipher.init(2, privateKey, new OAEPParameterSpec("SHA1", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(hex2Byte(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decryptHexStringBySec(String str, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrHex2Byte = hex2Byte(str);
            Cipher cipher = Cipher.getInstance(ALGORITHMS);
            cipher.init(2, privateKey);
            return cipher.doFinal(bArrHex2Byte);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
        cipher.init(1, publicKey, new OAEPParameterSpec("SHA1", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
        return byte2Hex(cipher.doFinal(str.getBytes(Constants.UTF_8_CODE)));
    }

    public static String encryptToHexStringPub(String str, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (!TextUtils.isEmpty(str) && publicKey != null) {
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHMS);
                cipher.init(1, publicKey);
                return byte2Hex(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] formatPublicKeyPKCS1ToPKCS8(byte[] bArr) {
        a aVar = bArr instanceof a ? (a) bArr : bArr != 0 ? new a(s.a((Object) bArr)) : null;
        try {
            return KeyFactory.getInstance(ALGORITHM_KEY).generatePublic(new RSAPublicKeySpec(aVar.f7753a, aVar.f7754b)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_KEY);
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (keyPair == null) {
                keyPair = keyPairGenerator.generateKeyPair();
            }
            return keyPair;
        } catch (Exception unused) {
            return null;
        }
    }

    public static PrivateKey getPrivateKeyFrom16(String str) {
        try {
            return KeyFactory.getInstance(ALGORITHM_KEY).generatePrivate(new PKCS8EncodedKeySpec(hex2Byte(str)));
        } catch (Exception e4) {
            e4.getMessage();
            return null;
        }
    }

    public static PrivateKey getPrivateKeyFromPemString(String str, boolean z4) {
        if (!z4) {
            str = pemString2PemFormat(str);
        }
        try {
            return (PrivateKey) KeyFactory.getInstance(ALGORITHM_KEY).generatePublic(new PKCS8EncodedKeySpec(Base64Util.decode(str.getBytes(StandardCharsets.UTF_8))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            return null;
        }
    }

    public static String getPrivateKeyStr(PrivateKey privateKey) throws Exception {
        return byte2Hex(privateKey.getEncoded());
    }

    @Deprecated
    public static PublicKey getPublicKey(String str) {
        try {
            return KeyFactory.getInstance(ALGORITHM_KEY).generatePublic(new X509EncodedKeySpec(Base64Util.decode(str.getBytes(StandardCharsets.UTF_8))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getPublicKeyCS1Pem(PublicKey publicKey) {
        try {
            byte[] encoded = publicKey.getEncoded();
            com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b bVar = encoded instanceof com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b ? (com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b) encoded : encoded != 0 ? new com.baidu.mapauto.auth.org.spongycastle.asn1.x509.b(s.a((Object) encoded)) : null;
            bVar.getClass();
            m0 m0Var = bVar.f7786b;
            if (m0Var.f7696b != 0) {
                throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
            }
            byte[] bArrD = new i(com.baidu.mapauto.auth.org.spongycastle.util.a.a(m0Var.f7695a)).a().d();
            formatPublicKeyPKCS1ToPKCS8(bArrD);
            return pemFormat2PemString(convertCS2Pem(bArrD));
        } catch (IOException unused) {
            return null;
        }
    }

    public static PublicKey getPublicKeyFromPemString(String str, boolean z4) {
        if (!z4) {
            str = pemString2PemFormat(str);
        }
        try {
            return KeyFactory.getInstance(ALGORITHM_KEY).generatePublic(new X509EncodedKeySpec(formatPublicKeyPKCS1ToPKCS8(Base64Util.decode(str.getBytes(StandardCharsets.UTF_8)))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            return null;
        }
    }

    public static byte[] hex2Byte(String str) throws NumberFormatException {
        if (str == null || str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i4 = 0; i4 < str.length() / 2; i4++) {
            int i5 = i4 * 2;
            int i6 = i5 + 1;
            bArr[i4] = (byte) ((Integer.parseInt(str.substring(i5, i6), 16) * 16) + Integer.parseInt(str.substring(i6, i5 + 2), 16));
        }
        return bArr;
    }

    public static String pemFormat2PemString(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                if (!line.contains("-----END RSA PUBLIC KEY-----") && !line.contains("-----BEGIN RSA PUBLIC KEY-----")) {
                    sb.append(line);
                }
            } catch (IOException unused) {
                return sb.toString();
            }
        }
    }

    public static String pemString2PemFormat(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (i4 != 0 && i4 % 64 == 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(str.charAt(i4));
        }
        return stringBuffer.toString();
    }

    public static boolean verify(String str, PublicKey publicKey, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(str.getBytes(StandardCharsets.UTF_8));
            return signature.verify(hex2Byte(str2));
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
