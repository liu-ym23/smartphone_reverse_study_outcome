package com.baidu.mshield.b.f;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static PublicKey a(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L71;
        return null;
    L71:
        byte[] r100 = new byte[8192];     // Catch: Throwable -> L59
        JarFile r101 = new JarFile(r110);     // Catch: Throwable -> L59
        Enumeration<JarEntry> r111 = r101.entries();     // Catch: Throwable -> L58
        Certificate[] r102 = null;
    L9:
        if (r111.hasMoreElements() == false) goto L50;
        JarEntry r103 = r111.nextElement();     // Catch: Throwable -> L58
        if (r103.isDirectory() == true) goto L9;
        String r104 = r103.getName();     // Catch: Throwable -> L58
        if (r104.contains("../") == true) goto L9;
        if (r104.startsWith("META-INF/") == true) goto L9;
        Certificate[] r105 = a(r101, r103, r100);     // Catch: Throwable -> L58
        if (r105 == null) goto L47;
        if (r105.length == 0) goto L47;
        if (r102 == null) goto L25;
        int r106 = 0;
    L28:
        if (r106 >= r102.length) goto L9;
        int r107 = 0;
    L31:
        if (r107 >= r105.length) goto L38;
        Certificate r108 = r102[r106];     // Catch: Throwable -> L58
        if (r108 == null) goto L37;
        if (r108.equals(r105[r107]) == false) goto L37;
        boolean r109 = true;
    L39:
        if (r109 == false) goto L44;
        if (r102.length != r105.length) goto L44;
        r106 = r106 + 1;     // Catch: Throwable -> L58
    L44:
        r101.close();     // Catch: Throwable -> L58
        r101.close();     // Catch: IOException -> L63
    L46:
        return null;
    L37:
        r107 = r107 + 1;     // Catch: Throwable -> L58
        goto L31
    L38:
        r109 = false;
        goto L39
    L25:
        r102 = r105;
    L47:
        r101.close();     // Catch: Throwable -> L58
        r101.close();     // Catch: IOException -> L64
    L49:
        return null;
    L50:
        if (r102 != null) goto L52;
    L73:
        r101.close();     // Catch: IOException -> L66
    L57:
        return null;
    L52:
        if (r102.length <= 0) goto L73;
        PublicKey r112 = r102[0].getPublicKey();     // Catch: Throwable -> L58
        r101.close();     // Catch: IOException -> L65
    L55:
        return r112;
    L60:
        if (r101 != null) goto L79;
    L62:
        return null;
    L79:
        r101.close();     // Catch: IOException -> L67
    L59:
        r101 = null;
        goto L60
    }

    public static PublicKey a(Signature r100) {
        CertificateFactory r101 = CertificateFactory.getInstance("X.509");     // Catch: Throwable -> L9
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100.toByteArray());     // Catch: Throwable -> L9
        PublicKey r103 = r101.generateCertificate(r102).getPublicKey();     // Catch: Throwable -> L7
        r102.close();     // Catch: IOException -> L19
    L6:
        return r103;
    L7:
        th = th;
    L24:
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L15
        if (r102 != null) goto L22;
    L14:
        return null;
    L22:
        r102.close();     // Catch: IOException -> L20
    L15:
        th = move-exception;
        if (r102 != null) goto L26;
    L18:
        throw th;
    L26:
        r102.close();     // Catch: IOException -> L21
    L9:
        th = th;
        r102 = null;
        goto L24
    }

    public static Certificate[] a(JarFile r100, JarEntry r101, byte[] r102) {
        BufferedInputStream r103 = null;
        Certificate[] r104 = null;
        BufferedInputStream r105 = new BufferedInputStream(r100.getInputStream(r101));     // Catch: Throwable -> L13
    L36:
    L11:
        th = th;
        r103 = r105;
    L34:
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L19
        if (r103 == null) goto L18;
        r103.close();     // Catch: IOException -> L24
    L18:
        return new Certificate[0];
    L19:
        th = move-exception;
        if (r103 != null) goto L30;
    L22:
        throw th;
    L30:
        r103.close();     // Catch: IOException -> L25
        goto L22
    L5:
        if (r105.read(r102, 0, r102.length) != (-1)) goto L36;
        if (r101 == null) goto L32;
        r104 = r101.getCertificates();     // Catch: Throwable -> L11
    L32:
        r105.close();     // Catch: IOException -> L23
    L10:
        return r104;
    L13:
        th = th;
        goto L34
    }
}
