package com.baidu.mshield.b.f;

import android.content.pm.Signature;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes.dex */
public class b {
    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        com.baidu.mshield.b.c.a.a(th);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return new Certificate[0];
                    } catch (Throwable th2) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th2;
                    }
                }
            } while (bufferedInputStream2.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                bufferedInputStream2.close();
            } catch (IOException unused3) {
            }
            return certificates;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static PublicKey a(Signature signature) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            try {
                PublicKey publicKey = certificateFactory.generateCertificate(byteArrayInputStream).getPublicKey();
                try {
                    byteArrayInputStream.close();
                } catch (IOException unused) {
                }
                return publicKey;
            } catch (Throwable th) {
                th = th;
                try {
                    com.baidu.mshield.b.c.a.a(th);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
    
        if (r3.length == r4.length) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
    
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.security.PublicKey a(java.lang.String r10) throws java.io.IOException {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L8e
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L8e
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L8e
            java.util.Enumeration r10 = r2.entries()     // Catch: java.lang.Throwable -> L8f
            r3 = r1
        L16:
            boolean r4 = r10.hasMoreElements()     // Catch: java.lang.Throwable -> L8f
            r5 = 0
            if (r4 == 0) goto L7b
            java.lang.Object r4 = r10.nextElement()     // Catch: java.lang.Throwable -> L8f
            java.util.jar.JarEntry r4 = (java.util.jar.JarEntry) r4     // Catch: java.lang.Throwable -> L8f
            boolean r6 = r4.isDirectory()     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L2a
            goto L16
        L2a:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r7 = "../"
            boolean r7 = r6.contains(r7)     // Catch: java.lang.Throwable -> L8f
            if (r7 == 0) goto L37
            goto L16
        L37:
            java.lang.String r7 = "META-INF/"
            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L8f
            if (r6 == 0) goto L40
            goto L16
        L40:
            java.security.cert.Certificate[] r4 = a(r2, r4, r0)     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L74
            int r6 = r4.length     // Catch: java.lang.Throwable -> L8f
            if (r6 != 0) goto L4a
            goto L74
        L4a:
            if (r3 != 0) goto L4e
            r3 = r4
            goto L16
        L4e:
            r6 = r5
        L4f:
            int r7 = r3.length     // Catch: java.lang.Throwable -> L8f
            if (r6 >= r7) goto L16
            r7 = r5
        L53:
            int r8 = r4.length     // Catch: java.lang.Throwable -> L8f
            if (r7 >= r8) goto L6d
            r8 = r3[r6]     // Catch: java.lang.Throwable -> L8f
            if (r8 == 0) goto L6a
            r9 = r4[r7]     // Catch: java.lang.Throwable -> L8f
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Throwable -> L8f
            if (r8 == 0) goto L6a
            int r7 = r3.length     // Catch: java.lang.Throwable -> L8f
            int r8 = r4.length     // Catch: java.lang.Throwable -> L8f
            if (r7 == r8) goto L67
            goto L6d
        L67:
            int r6 = r6 + 1
            goto L4f
        L6a:
            int r7 = r7 + 1
            goto L53
        L6d:
            r2.close()     // Catch: java.lang.Throwable -> L8f
            r2.close()     // Catch: java.io.IOException -> L73
        L73:
            return r1
        L74:
            r2.close()     // Catch: java.lang.Throwable -> L8f
            r2.close()     // Catch: java.io.IOException -> L7a
        L7a:
            return r1
        L7b:
            if (r3 == 0) goto L8a
            int r10 = r3.length     // Catch: java.lang.Throwable -> L8f
            if (r10 <= 0) goto L8a
            r10 = r3[r5]     // Catch: java.lang.Throwable -> L8f
            java.security.PublicKey r10 = r10.getPublicKey()     // Catch: java.lang.Throwable -> L8f
            r2.close()     // Catch: java.io.IOException -> L89
        L89:
            return r10
        L8a:
            r2.close()     // Catch: java.io.IOException -> L8d
        L8d:
            return r1
        L8e:
            r2 = r1
        L8f:
            if (r2 == 0) goto L94
            r2.close()     // Catch: java.io.IOException -> L94
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.b.f.b.a(java.lang.String):java.security.PublicKey");
    }
}
