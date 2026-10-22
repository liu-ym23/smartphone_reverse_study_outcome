package com.stepos.statsapp.v3.lib.plugin.secure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class SimpleCryptoAES {

    /* renamed from: d, reason: collision with root package name */
    private static final int f30918d = 32;

    /* renamed from: e, reason: collision with root package name */
    private static final int f30919e = 16;

    /* renamed from: a, reason: collision with root package name */
    private final String f30920a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f30921b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f30922c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static SimpleCryptoAES f30923a = new SimpleCryptoAES();

        private b() {
        }
    }

    @SuppressLint({"DeletedProvider"})
    private static SecretKey a(byte[] bArr) throws Exception {
        return null;
    }

    public static SimpleCryptoAES getInstance() {
        return b.f30923a;
    }

    public String b(String str, String str2, int i10) throws Exception {
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, a(str, 32), new IvParameterSpec(this.f30922c));
            return b(cipher.doFinal(str2.getBytes()));
        }
        SecretKey secretKeyA = a(str.getBytes());
        if (secretKeyA == null) {
            return null;
        }
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(1, secretKeyA);
        return b(cipher2.doFinal(str2.getBytes()));
    }

    public void init(Context context) {
        this.f30921b = a(context, "salt", 32);
        this.f30922c = a(context, "iv", 16);
    }

    private SimpleCryptoAES() {
        this.f30920a = "com.stepos.statsapp.v3.simple_crypto_AES";
    }

    public String a(String str, String str2, int i10) throws Exception {
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, a(str, 32), new IvParameterSpec(this.f30922c));
            return new String(cipher.doFinal(a(str2)));
        }
        SecretKey secretKeyA = a(str.getBytes());
        if (secretKeyA == null) {
            return null;
        }
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(2, secretKeyA);
        return new String(cipher2.doFinal(a(str2)));
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i10] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i10] & 15));
        }
        return stringBuffer.toString();
    }

    private static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = Integer.valueOf(str.substring(i11, i11 + 2), 16).byteValue();
        }
        return bArr;
    }

    private SecretKey a(String str, int i10) {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), this.f30921b, 100, i10 * 8)).getEncoded(), "AES");
        } catch (Exception e10) {
            throw new RuntimeException("Deal with exceptions properly!", e10);
        }
    }

    private byte[] a(Context context, String str, int i10) {
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, "com.stepos.statsapp.v3.simple_crypto_AES");
        String config = sharedPreferencesHelper.getConfig(str, "");
        if (!TextUtils.isEmpty(config)) {
            byte[] bArrDecode = Base64.decode(config, 2);
            if (bArrDecode.length == i10) {
                return bArrDecode;
            }
        }
        byte[] bArr = new byte[i10];
        new SecureRandom().nextBytes(bArr);
        sharedPreferencesHelper.commitConfig(str, Base64.encodeToString(bArr, 2));
        return bArr;
    }
}
