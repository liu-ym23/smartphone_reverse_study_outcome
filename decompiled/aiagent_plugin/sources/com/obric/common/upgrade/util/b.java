package com.obric.common.upgrade.util;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: FileMD5Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32649a = null;

    static {
        f32649a = new b();
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(File r7) {
        DigestInputStream r0 = 0;
        r0 = 0;
        if (r7 != null) goto L64;
    L61:
        return null;
    L64:
        if (r7.exists() == false) goto L61;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Throwable -> L29 IOException -> L31 NoSuchAlgorithmException -> L42
        FileInputStream r2 = new FileInputStream(r7);     // Catch: Throwable -> L29 IOException -> L31 NoSuchAlgorithmException -> L42
    L71:
        DigestInputStream r8 = new DigestInputStream((InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.aiagent.plugin"), r1);     // Catch: Throwable -> L23 IOException -> L25 NoSuchAlgorithmException -> L27
    L67:
    L19:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L50
        if (r8 == null) goto L38;
        r8.close();     // Catch: IOException -> L36
    L38:
        if (r2 == null) goto L49;
        r2.close();     // Catch: IOException -> L36
    L49:
        return null;
    L21:
        e = e;
    L44:
        e.printStackTrace();     // Catch: Throwable -> L50
        if (r8 == null) goto L47;
        r8.close();     // Catch: IOException -> L36
    L47:
        if (r2 == null) goto L49;
        r2.close();     // Catch: IOException -> L36
    L12:
        if (r8.read(new byte[8192]) != (-1)) goto L12;
        byte[] r3 = r1.digest();     // Catch: IOException -> L19 NoSuchAlgorithmException -> L21 Throwable -> L50
        o.c(r3, "digest");     // Catch: IOException -> L19 NoSuchAlgorithmException -> L21 Throwable -> L50
        String r6 = a(r3);     // Catch: IOException -> L19 NoSuchAlgorithmException -> L21 Throwable -> L50
        r8.close();     // Catch: IOException -> L16
        r2.close();     // Catch: IOException -> L16
    L18:
        return r6;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L25:
        e = e;
        r8 = null;
    L27:
        e = e;
        r8 = null;
    L23:
        th = th;
    L52:
        if (r0 != 0) goto L62;
    L56:
        if (r2 == null) goto L60;
        r2.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L60:
        throw th;
    L62:
        r0.close();     // Catch: IOException -> L54
    L31:
        e = e;
        r8 = null;
        r2 = null;
    L42:
        e = e;
        r8 = null;
        r2 = null;
    L29:
        th = th;
        r2 = null;
    L50:
        th = th;
        r0 = r7;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L49
    }

    private final String a(byte[] r6) {
        StringBuilder r5 = new StringBuilder();
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = Integer.toHexString(r6[r1] & 255);
        if (r2.length() != 1) goto L7;
        r5.append('0');
    L7:
        r5.append(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        String r7 = r5.toString();
        o.c(r7, "sb.toString()");
        return r7;
    }
}
