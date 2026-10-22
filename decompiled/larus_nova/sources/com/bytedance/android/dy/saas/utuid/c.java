package com.bytedance.android.dy.saas.utuid;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.TypeCastException;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f42643a = 0;

    static {
    }

    public static String d(String r100) {
        return c("SHA-1", r100);
    }

    public static String a(String r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(r101.getBytes(Charset.forName("UTF8")), CryptoConst.ALGORITHM_AES);
        byte[] r103 = Base64.decode(r100, 2);
        Cipher r104 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        r104.init(2, r102);
        return new String(r104.doFinal(r103), Charset.forName("UTF8"));
    }

    public static String b(String r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(r101.getBytes(Charset.forName("UTF8")), CryptoConst.ALGORITHM_AES);
        byte[] r103 = r100.getBytes(Charset.forName("UTF8"));
        Cipher r104 = Cipher.getInstance("AES/ECB/PKCS5Padding");
        r104.init(1, r102);
        return Base64.encodeToString(r104.doFinal(r103), 2);
    }

    public static String c(String r100, String r101) {
        MessageDigest r102 = MessageDigest.getInstance(r100);
        Charset r103 = Charsets.UTF_8;
        if (r101 == null) goto L10;
        byte[] r104 = r102.digest(r101.getBytes(r103));
        StringBuilder r105 = new StringBuilder(r104.length * 2);
        int r106 = r104.length;
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L8;
        byte r108 = r104[r107];
        r105.append("0123456789ABCDEF".charAt((r108 >> 4) & 15));
        r105.append("0123456789ABCDEF".charAt(r108 & 15));
        r107 = r107 + 1;
        goto L5
    L8:
        return r105.toString();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
