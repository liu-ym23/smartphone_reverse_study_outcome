package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: DecodeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4969a = "";

    static {
    }

    public static String a(byte[] r2, String r3) {
        byte[] r4 = Base64.decode(r2, 0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return "";
    L7:
        f4969a = r3;
        return a(r3, r4);
    L9:
        return "";
    }

    private static String a(String r3, byte[] r4) {
        String r0 = "";
        SecretKeySpec r1 = new SecretKeySpec(r3.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L11
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L11
        r5.init(2, r1);     // Catch: Exception -> L11
        String r6 = new String(r5.doFinal(r4));     // Catch: Exception -> L11
        int r7 = r6.indexOf("$");     // Catch: Exception -> L8
        if (r7 == (-1)) goto L16;
        return r6.substring(0, r7);
    L16:
        return r6;
    L8:
        r0 = r6;
    L10:
        return r0;
    }
}
