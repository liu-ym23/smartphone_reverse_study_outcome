package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f190643a = "";

    public static String a(byte[] r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = f190643a;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return "";
    L15:
        return b(r101, Base64.decode(r100, 0));
    L12:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String b(String r100, byte[] r101) {
        String r102 = "";
        SecretKeySpec r103 = new SecretKeySpec(r100.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L11
        Cipher r104 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L11
        r104.init(2, r103);     // Catch: Exception -> L11
        String r105 = new String(r104.doFinal(r101));     // Catch: Exception -> L11
        int r106 = r105.indexOf("$");     // Catch: Exception -> L8
        if (r106 == (-1)) goto L16;
        return r105.substring(0, r106);
    L16:
        return r105;
    L8:
        r102 = r105;
    L10:
        return r102;
    }
}
