package com.baidu.a;

import android.util.Base64;
import ch.qos.logback.core.net.ssl.SSL;
import com.stepos.activeview.utils.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import kotlin.UByte;

/* loaded from: classes.dex */
final class d {

    /* renamed from: b, reason: collision with root package name */
    private static String f4659b = a();

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f4658a = Pattern.compile("^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$");

    private static String a() {
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance(SSL.DEFAULT_SECURE_RANDOM_ALGORITHM).nextBytes(bArr);
            return a(bArr);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static String b(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, h(str), new IvParameterSpec("01020304".getBytes()));
            return new String(cipher.doFinal(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean c(String str) {
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    public static boolean d(String str) {
        return Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", str);
    }

    public static String e(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(Constants.UTF_8_CODE));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b4 : bArrDigest) {
                int i4 = b4 & UByte.MAX_VALUE;
                if (i4 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i4));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static String f(String str) {
        return a(f4659b, str.getBytes());
    }

    public static String g(String str) {
        return b(f4659b, Base64.decode(str, 0));
    }

    private static Key h(String str) {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
    }

    private static String a(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, h(str), new IvParameterSpec("01020304".getBytes()));
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(String str) {
        String strReplaceAll = str.replaceAll("[\\[\\]]", "");
        return c(strReplaceAll) || d(strReplaceAll);
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b4 : bArr) {
            a(stringBuffer, b4);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b4) {
        stringBuffer.append("0123456789ABCDEF".charAt((b4 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b4 & 15));
    }

    public static boolean a(String str) {
        return f4658a.matcher(str).matches();
    }
}
