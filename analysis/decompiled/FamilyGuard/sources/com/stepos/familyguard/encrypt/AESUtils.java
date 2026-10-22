package com.stepos.familyguard.encrypt;

import P1.a;
import android.content.Context;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class AESUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final IvParameterSpec f14776a;

    /* renamed from: b, reason: collision with root package name */
    private static final SecretKeySpec f14777b;

    static {
        System.loadLibrary("lib-encrypt");
        f14776a = getIvParameterSpec(a.a());
        f14777b = getSecretKeySpec(a.a());
    }

    public static String a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, f14777b, f14776a);
            return new String(cipher.doFinal(Base64.decode(str, 0)), StandardCharsets.UTF_8);
        } catch (Exception e6) {
            e6.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String b(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, f14777b, f14776a);
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 0), StandardCharsets.UTF_8);
        } catch (Exception e6) {
            e6.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    private static native IvParameterSpec getIvParameterSpec(Context context);

    private static native SecretKeySpec getSecretKeySpec(Context context);
}
