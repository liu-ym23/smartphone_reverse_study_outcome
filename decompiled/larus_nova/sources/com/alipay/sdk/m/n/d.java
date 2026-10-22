package com.alipay.sdk.m.n;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes28.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25615a = "RSA";

    public d() {
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:33554514), block:B:29:0x0052 */
    public static byte[] a(String r100, String r101) {
        byte[] r102 = null;
        r102 = null;
        r102 = null;
        ByteArrayOutputStream r103 = null;
        PublicKey r104 = b(f25615a, r101);     // Catch: Throwable -> L17 Exception -> L19
        Cipher r105 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Throwable -> L17 Exception -> L19
        r105.init(1, r104);     // Catch: Throwable -> L17 Exception -> L19
        byte[] r106 = r100.getBytes("UTF-8");     // Catch: Throwable -> L17 Exception -> L19
        int r107 = r105.getBlockSize();     // Catch: Throwable -> L17 Exception -> L19
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L17 Exception -> L19
        int r109 = 0;
    L39:
    L15:
        e = e;
    L21:
        com.alipay.sdk.m.u.e.a(e);     // Catch: Throwable -> L28
        if (r108 == null) goto L27;
        r108.close();     // Catch: IOException -> L25
    L41:
    L27:
        return r102;
    L6:
        if (r109 >= r106.length) goto L12;
        if ((r106.length - r109) >= r107) goto L10;
        int r110 = r106.length - r109;     // Catch: Exception -> L15 Throwable -> L28
    L11:
        r108.write(r105.doFinal(r106, r109, r110));     // Catch: Exception -> L15 Throwable -> L28
        r109 = r109 + r107;     // Catch: Exception -> L15 Throwable -> L28
        goto L39
    L10:
        r110 = r107;
        goto L11
    L12:
        r102 = r108.toByteArray();     // Catch: Exception -> L15 Throwable -> L28
        r108.close();     // Catch: IOException -> L25
        goto L41
    L28:
        th = th;
        r103 = r2;
    L30:
        if (r103 != null) goto L36;
    L35:
        throw th;
    L36:
        r103.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        com.alipay.sdk.m.u.e.a(e);
    L19:
        e = e;
        r108 = null;
    L17:
        th = th;
    L25:
        e = move-exception;
        com.alipay.sdk.m.u.e.a(e);
        goto L27
    }

    public static PublicKey b(String r100, String r101) throws NoSuchAlgorithmException, Exception {
        X509EncodedKeySpec r102 = new X509EncodedKeySpec(a.a(r101));
        return KeyFactory.getInstance(r100).generatePublic(r102);
    }
}
