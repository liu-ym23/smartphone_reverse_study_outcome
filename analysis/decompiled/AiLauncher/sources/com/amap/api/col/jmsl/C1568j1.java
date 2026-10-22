package com.amap.api.col.jmsl;

import com.autonavi.aps.amapapi.security.Encrypt;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.date.GMTDateParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.amap.api.col.jmsl.j1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1568j1 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f16679a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', 'u', 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', JsonPointer.SEPARATOR};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f16680b = new byte[128];

    static {
        for (int i10 = 0; i10 < 128; i10++) {
            f16680b[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            f16680b[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            f16680b[i12] = (byte) (i12 - 71);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            f16680b[i13] = (byte) (i13 + 4);
        }
        byte[] bArr = f16680b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int i11 = i10 + 1;
            byte b10 = bArr[i10];
            int i12 = b10 & 255;
            if (i11 == length) {
                char[] cArr = f16679a;
                stringBuffer.append(cArr[i12 >>> 2]);
                stringBuffer.append(cArr[(b10 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i13 = i10 + 2;
            byte b11 = bArr[i11];
            if (i13 == length) {
                char[] cArr2 = f16679a;
                stringBuffer.append(cArr2[i12 >>> 2]);
                stringBuffer.append(cArr2[((b10 & 3) << 4) | ((b11 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(b11 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i10 += 3;
            byte b12 = bArr[i13];
            char[] cArr3 = f16679a;
            stringBuffer.append(cArr3[i12 >>> 2]);
            stringBuffer.append(cArr3[((b10 & 3) << 4) | ((b11 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((b11 & 15) << 2) | ((b12 & 192) >>> 6)]);
            stringBuffer.append(cArr3[b12 & 63]);
        }
        return stringBuffer.toString();
    }

    public static byte[] b(String str) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        int i12 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bArrT = C1604s2.t(str);
        int length = bArrT.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i12 < length) {
            while (true) {
                i10 = i12 + 1;
                b10 = f16680b[bArrT[i12]];
                if (i10 >= length || b10 != -1) {
                    break;
                }
                i12 = i10;
            }
            if (b10 == -1) {
                break;
            }
            while (true) {
                i11 = i10 + 1;
                b11 = f16680b[bArrT[i10]];
                if (i11 >= length || b11 != -1) {
                    break;
                }
                i10 = i11;
            }
            if (b11 == -1) {
                break;
            }
            byteArrayOutputStream.write((b10 << 2) | ((b11 & 48) >>> 4));
            while (i11 != length) {
                int i13 = i11 + 1;
                byte b12 = bArrT[i11];
                if (b12 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b13 = f16680b[b12];
                if (i13 >= length || b13 != -1) {
                    if (b13 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b11 & 15) << 4) | ((b13 & 60) >>> 2));
                    while (i13 != length) {
                        int i14 = i13 + 1;
                        byte b14 = bArrT[i13];
                        if (b14 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b15 = f16680b[b14];
                        if (i14 < length && b15 == -1) {
                            i13 = i14;
                        } else {
                            if (b15 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b15 | ((b13 & 3) << 6));
                            i12 = i14;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i11 = i13;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] c(byte[] bArr, Key key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(C1604s2.m(Encrypt.KEY_TRANSFORMATION));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, C1604s2.m("EQUVT"));
        Cipher cipher = Cipher.getInstance(C1604s2.m("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e10) {
            e10.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    public static String e(byte[] bArr) {
        try {
            return a(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, C1604s2.m("EQUVT"));
        Cipher cipher = Cipher.getInstance(C1604s2.m("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String g(byte[] bArr) {
        try {
            return a(bArr);
        } catch (Throwable th) {
            C1611u1.b(th, "er", "e64");
            return null;
        }
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, byte[] bArr3) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        return d(bArr, bArr2, bArr3);
    }

    public static byte[] i(byte[] bArr) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, NullPointerException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(C1604s2.m("EQUVT"));
        byte[] bArrD = null;
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey publicKeyE = C1604s2.e();
        if (publicKeyE == null) {
            return null;
        }
        byte[] bArrC = c(encoded, publicKeyE);
        try {
            bArrD = d(encoded, bArr, C1604s2.o());
        } catch (Throwable th) {
            C1611u1.b(th, "er", "asEn");
        }
        byte[] bArr2 = new byte[bArrC.length + bArrD.length];
        System.arraycopy(bArrC, 0, bArr2, 0, bArrC.length);
        System.arraycopy(bArrD, 0, bArr2, bArrC.length, bArrD.length);
        return bArr2;
    }
}
