package com.autonavi.aps.amapapi.security;

import T1.a;
import com.amap.api.col.jmsl.C1568j1;
import com.amap.api.col.jmsl.C1604s2;
import com.amap.api.col.jmsl.C1611u1;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import io.ktor.util.date.GMTDateParser;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class Encrypt {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String KEY_TRANSFORMATION = "CUlNBL0VDQi9QS0NTMVBhZGRpbmc";

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f18347a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f18348b = {61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f18349c;

    /* renamed from: d, reason: collision with root package name */
    private static final IvParameterSpec f18350d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        f18349c = bArr;
        f18350d = new IvParameterSpec(bArr);
    }

    private static SecretKeySpec a(String str) {
        byte[] bytes;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bytes = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Encrypt", "createKey");
            bytes = null;
        }
        return new SecretKeySpec(bytes, "AES");
    }

    public static byte[] aesDecrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(C1604s2.o());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpecA, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    public static byte[] aesDecryptByCBC(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(bArr, "AES"), f18350d);
        return cipher.doFinal(bArr2);
    }

    public static byte[] aesEncrypt(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpecA = a(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(C1604s2.o());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpecA, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        try {
            BigInteger bigIntegerModPow = new BigInteger(bArr).modPow(bigInteger, bigInteger2);
            byte[] bArr2 = new byte[16];
            BigInteger bigInteger3 = new BigInteger("256");
            int i10 = 0;
            while (bigIntegerModPow.bitCount() > 0 && i10 < 16) {
                BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerModPow.divideAndRemainder(bigInteger3);
                BigInteger bigInteger4 = bigIntegerArrDivideAndRemainder[0];
                bArr2[i10] = (byte) bigIntegerArrDivideAndRemainder[1].intValue();
                i10++;
                bigIntegerModPow = bigInteger4;
            }
            return bArr2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decryptAES(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(C1604s2.m("YQUVTL0VDQi9Ob1BhZGRpbmc="));
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] decryptRsponse(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(C1604s2.o()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Encrypt", "decryptRsponse length = " + (bArr != null ? bArr.length : 0));
            return null;
        }
    }

    public static String encode(String str, String str2) {
        byte[] bArrDigest;
        if (str2 == null) {
            return null;
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bytes);
                bArrDigest = messageDigest.digest();
            } catch (Throwable th) {
                C1611u1.b(th, "MD5", "gmb");
                bArrDigest = null;
            }
            int length = bArrDigest.length;
            StringBuilder sb2 = new StringBuilder(length * 2);
            for (int i10 = 0; i10 < length; i10++) {
                char[] cArr = f18347a;
                sb2.append(cArr[(bArrDigest[i10] >> 4) & 15]);
                sb2.append(cArr[bArrDigest[i10] & 15]);
            }
            return sb2.toString();
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "Encrypt", "encode");
            return null;
        }
    }

    public static String generatorKey(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return encode("MD5", encode("SHA1", str) + str);
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static synchronized byte[] rsaDecryptByPrivateKey(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        try {
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(C1568j1.b(str)));
            Cipher cipher = Cipher.getInstance(C1604s2.m(KEY_TRANSFORMATION));
            cipher.init(2, privateKeyGeneratePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = length - i10;
                if (i12 > 0) {
                    byte[] bArrDoFinal = i12 > 256 ? cipher.doFinal(bArr, i10, 256) : cipher.doFinal(bArr, i10, i12);
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i11++;
                    i10 = i11 * 256;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return byteArray;
    }

    public static synchronized byte[] rsaEncryptByPrivateKey(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        try {
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(C1568j1.b(str)));
            Cipher cipher = Cipher.getInstance(C1604s2.m(KEY_TRANSFORMATION));
            cipher.init(1, privateKeyGeneratePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = length - i10;
                if (i12 > 0) {
                    byte[] bArrDoFinal = i12 > 245 ? cipher.doFinal(bArr, i10, 245) : cipher.doFinal(bArr, i10, i12);
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i11++;
                    i10 = i11 * 245;
                } else {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return byteArray;
    }

    public static byte[] rsaEncryptCarrier(byte[] bArr) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(a.a(new StringBuilder(new String(f18348b)).reverse().toString().getBytes(), 2)));
        Cipher cipher = Cipher.getInstance(C1604s2.m("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }
}
