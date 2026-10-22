package x6;

import com.stepos.cloud.securedata.SdkException;
import d7.n;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import q7.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SecureRandom f11241a = new SecureRandom();

    public static byte[] a(String str) throws SdkException {
        try {
            byte[] bArrDecode = Base64.getDecoder().decode(str);
            k.b(bArrDecode);
            return bArrDecode;
        } catch (IllegalArgumentException e10) {
            throw new SdkException("Invalid encrypted data format", e10);
        }
    }

    public static String b(long j2, String str, String str2, String str3, byte[] bArr) throws BadPaddingException, SdkException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        k.e(str, "encryptedBase64");
        k.e(bArr, "deviceSk");
        k.e(str2, "requestId");
        if (bArr.length != 32) {
            throw new SdkException("Invalid DeviceSK, expected 32 bytes", null, 2, null);
        }
        if (ga.k.t0(str)) {
            throw new SdkException("Encrypted data must not be empty", null, 2, null);
        }
        try {
            byte[] bArrA = a(str);
            d(bArrA);
            long jC = c(bArrA);
            if (jC != j2) {
                throw new SdkException("keyId mismatch expected=" + j2 + " got=" + jC + ", requestId=" + str2, null, 2, null);
            }
            byte[] bArrB0 = n.b0(bArrA, 10, 22);
            byte[] bArrB02 = n.b0(bArrA, 22, bArrA.length);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr, "AES"), new GCMParameterSpec(128, bArrB0));
            byte[] bArrDoFinal = cipher.doFinal(bArrB02);
            k.d(bArrDoFinal, "doFinal(...)");
            Charset charset = StandardCharsets.UTF_8;
            k.d(charset, "UTF_8");
            return new String(bArrDoFinal, charset);
        } catch (SdkException e10) {
            throw e10;
        } catch (IllegalArgumentException e11) {
            throw new SdkException("Invalid encrypted data format", e11);
        } catch (Exception e12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("decrypt failed, requestId=".concat(str2));
            if (str3 != null && !ga.k.t0(str3)) {
                sb2.append(", userId=".concat(str3));
            }
            throw new SdkException(sb2.toString(), e12);
        }
    }

    public static long c(byte[] bArr) {
        return ((bArr[2] & 255) << 56) | ((bArr[3] & 255) << 48) | ((bArr[4] & 255) << 40) | ((bArr[5] & 255) << 32) | ((bArr[6] & 255) << 24) | ((bArr[7] & 255) << 16) | ((bArr[8] & 255) << 8) | (255 & bArr[9]);
    }

    public static void d(byte[] bArr) throws SdkException {
        if (bArr.length < 22) {
            throw new SdkException("Encrypted data is corrupted or invalid", null, 2, null);
        }
        if (bArr[0] != 90 || bArr[1] != 89) {
            throw new SdkException("illegal ciphertext header", null, 2, null);
        }
    }

    public static /* synthetic */ String decrypt$default(a aVar, String str, byte[] bArr, long j2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str3 = null;
        }
        aVar.getClass();
        return b(j2, str, str2, str3, bArr);
    }

    public static void e(long j2, byte[] bArr) {
        bArr[2] = (byte) (j2 >>> 56);
        bArr[3] = (byte) (j2 >>> 48);
        bArr[4] = (byte) (j2 >>> 40);
        bArr[5] = (byte) (j2 >>> 32);
        bArr[6] = (byte) (j2 >>> 24);
        bArr[7] = (byte) (j2 >>> 16);
        bArr[8] = (byte) (j2 >>> 8);
        bArr[9] = (byte) j2;
    }

    public static /* synthetic */ String runCrypto$default(a aVar, String str, String str2, String str3, p7.a aVar2, int i2, Object obj) throws SdkException {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        try {
            return (String) aVar2.c();
        } catch (SdkException e10) {
            throw e10;
        } catch (IllegalArgumentException e11) {
            throw new SdkException("Invalid encrypted data format", e11);
        } catch (Exception e12) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str + " failed, requestId=" + str2);
            if (str3 != null && !ga.k.t0(str3)) {
                sb2.append(", userId=".concat(str3));
            }
            throw new SdkException(sb2.toString(), e12);
        }
    }
}
