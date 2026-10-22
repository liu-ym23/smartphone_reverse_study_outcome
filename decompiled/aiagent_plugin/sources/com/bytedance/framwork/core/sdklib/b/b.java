package com.bytedance.framwork.core.sdklib.b;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: DecodeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(byte[] r4, String r5) {
        String r0 = "";
        byte[] r6 = Base64.decode(r4, 0);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r5) == false) goto L19;
        return "";
    L19:
        SecretKeySpec r2 = new SecretKeySpec(r5.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L16
        Cipher r7 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L16
        r7.init(2, r2);     // Catch: Exception -> L16
        String r8 = new String(r7.doFinal(r6));     // Catch: Exception -> L16
        int r9 = r8.indexOf("$");     // Catch: Exception -> L12
        if (r9 == (-1)) goto L23;
        return r8.substring(0, r9);
    L23:
        return r8;
    L12:
        r0 = r8;
    L14:
        return r0;
    L15:
        return "";
    }
}
