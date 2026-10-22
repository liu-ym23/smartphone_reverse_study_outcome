package com.obric.common.upgrade.util;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SignatureUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f32658a = null;

    static {
        f32658a = new g();
    }

    private g() {
    }

    public final String a(String r3, String r4, byte[] r5) {
        o.e(r3, "accessKey");
        o.e(r4, "secretKey");
        o.e(r5, "body");
        return r3 + ':' + a("POST", "", r5, r4);
    }

    private final String a(String r16, String r17, byte[] r18, String r19) {
        List r3 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"&"}, false, 0, 6, null);
        TreeSet r4 = new TreeSet();
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"));
        String r1 = "" + r16 + '\n' + p.a((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("&", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + '\n';
        if (r18.length != 0) goto L5;
        boolean r5 = true;
    L7:
        if ((!r5) == false) goto L9;
        MessageDigest r6 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        r6.update(r18);
        byte[] r0 = r6.digest();
        o.c(r0, "md5.digest()");
        r1 = r1 + a(r0) + '\n';
    L9:
        Mac r7 = Mac.getInstance("HmacSHA256");
        byte[] r8 = r19.getBytes(d.o.d.f38623b);
        o.c(r8, "this as java.lang.String).getBytes(charset)");
        r7.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r8, "HmacSHA256"), Key.class, "com.obric.aiagent.plugin"));
        byte[] r2 = r1.getBytes(d.o.d.f38623b);
        o.c(r2, "this as java.lang.String).getBytes(charset)");
        r7.update(r2);
        String r9 = Base64.encodeToString(r7.doFinal(), 2);
        o.c(r9, "encodeToString(hmac.doFinal(), Base64.NO_WRAP)");
        return r9;
    L5:
        r5 = false;
        goto L7
    }

    private final String a(byte[] r6) {
        StringBuilder r5 = new StringBuilder();
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = Integer.toHexString(r6[r1] & 255);
        if (r2.length() != 1) goto L7;
        r5.append("0");
    L7:
        r5.append(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        String r7 = r5.toString();
        o.c(r7, "result.toString()");
        return r7;
    }
}
