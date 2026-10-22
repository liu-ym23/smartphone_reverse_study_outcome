package com.bytedance.android.livesdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.length() < 49) goto L26;
        String r101 = r100.substring(1, 33);
        if (r101 != null) goto L9;
    L12:
        String r102 = null;
    L13:
        String r103 = r100.substring(33, 49);
        if (r103 == null) goto L27;
        if (r102 == null) goto L28;
        String r104 = r100.substring(49);
        if (TextUtils.isEmpty(r104) == true) goto L29;
        byte[] r105 = Base64.decode(r104, 0);     // Catch: Exception -> L22
        SecretKeySpec r106 = new SecretKeySpec(r102.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L22
        Cipher r107 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L22
        r107.init(2, r106, new IvParameterSpec(r103.getBytes()));     // Catch: Exception -> L22
        return new String(r107.doFinal(r105));
    L29:
        return null;
    L28:
        return r100;
    L27:
        return r100;
    L9:
        if (r101.length() != 32) goto L12;
        r102 = r101.substring(16, 32) + r101.substring(0, 16);
        goto L13
    L26:
        return r100;
    }
}
