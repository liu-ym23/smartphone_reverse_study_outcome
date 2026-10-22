package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Base64;
import com.tmall.wireless.tangram.expression.TangramExprSupport;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6628a = "";

    static {
    }

    public static String a(byte[] r10, String r11) {
        byte[] r12 = Base64.decode(r10, 0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return "";
    L7:
        f6628a = r11;
        return b(r11, r12);
    L9:
        return "";
    }

    public static String b(String r10, byte[] r11) {
        String r12 = "";
        SecretKeySpec r13 = new SecretKeySpec(r10.getBytes(), "AES");     // Catch: Exception -> L11
        Cipher r14 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L11
        r14.init(2, r13);     // Catch: Exception -> L11
        String r15 = new String(r14.doFinal(r11));     // Catch: Exception -> L11
        int r16 = r15.indexOf(TangramExprSupport.VAR_START);     // Catch: Exception -> L8
        if (r16 == (-1)) goto L16;
        return r15.substring(0, r16);
    L16:
        return r15;
    L8:
        r12 = r15;
    L10:
        return r12;
    }
}
