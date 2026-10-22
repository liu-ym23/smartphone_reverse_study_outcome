package com.bytedance.framwork.core.sdklib.util;

import android.text.TextUtils;
import android.util.Base64;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static String a(byte[] r10, String r11) {
        String r12 = "";
        byte[] r13 = Base64.decode(r10, 0);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r11) == false) goto L19;
        return "";
    L19:
        SecretKeySpec r14 = new SecretKeySpec(r11.getBytes(), "AES");     // Catch: Exception -> L16
        Cipher r15 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L16
        r15.init(2, r14);     // Catch: Exception -> L16
        String r16 = new String(r15.doFinal(r13));     // Catch: Exception -> L16
        int r17 = r16.indexOf(TangramExprSupport.VAR_START);     // Catch: Exception -> L12
        if (r17 == (-1)) goto L23;
        return r16.substring(0, r17);
    L23:
        return r16;
    L12:
        r12 = r16;
    L14:
        return r12;
    L15:
        return "";
    }
}
