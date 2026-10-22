package Z2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import f3.C0720b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f6632a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f6633b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f6634c;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static a f6635a = new a();
    }

    private SecretKey b(String str, int i5) {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), this.f6633b, 100, i5 * 8)).getEncoded(), "AES");
        } catch (Exception e6) {
            throw new RuntimeException("Deal with exceptions properly!", e6);
        }
    }

    private static SecretKey c(byte[] bArr) {
        return null;
    }

    private byte[] d(Context context, String str, int i5) {
        C0720b c0720b = new C0720b(context, "com.stepos.statsapp.v3.simple_crypto_AES");
        String strM = c0720b.m(str, BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(strM)) {
            byte[] bArrDecode = Base64.decode(strM, 2);
            if (bArrDecode.length == i5) {
                return bArrDecode;
            }
        }
        byte[] bArr = new byte[i5];
        new SecureRandom().nextBytes(bArr);
        c0720b.e(str, Base64.encodeToString(bArr, 2));
        return bArr;
    }

    private static byte[] e(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = Integer.valueOf(str.substring(i6, i6 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static String g(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i5] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i5] & 15));
        }
        return stringBuffer.toString();
    }

    public static a h() {
        return b.f6635a;
    }

    public String a(String str, String str2, int i5) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i5 != 1) {
            if (i5 != 2) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, b(str, 32), new IvParameterSpec(this.f6634c));
            return new String(cipher.doFinal(e(str2)));
        }
        SecretKey secretKeyC = c(str.getBytes());
        if (secretKeyC == null) {
            return null;
        }
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(2, secretKeyC);
        return new String(cipher2.doFinal(e(str2)));
    }

    public String f(String str, String str2, int i5) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i5 != 1) {
            if (i5 != 2) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, b(str, 32), new IvParameterSpec(this.f6634c));
            return g(cipher.doFinal(str2.getBytes()));
        }
        SecretKey secretKeyC = c(str.getBytes());
        if (secretKeyC == null) {
            return null;
        }
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(1, secretKeyC);
        return g(cipher2.doFinal(str2.getBytes()));
    }

    public void i(Context context) {
        this.f6633b = d(context, "salt", 32);
        this.f6634c = d(context, "iv", 16);
    }

    private a() {
        this.f6632a = "com.stepos.statsapp.v3.simple_crypto_AES";
    }
}
