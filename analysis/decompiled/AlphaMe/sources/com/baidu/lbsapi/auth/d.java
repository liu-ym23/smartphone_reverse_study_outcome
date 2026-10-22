package com.baidu.lbsapi.auth;

import android.content.Context;
import androidx.room.AbstractC0351g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* loaded from: classes.dex */
class d {

    public static class a {
        public static String a(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i4 = 0; i4 < bArr.length; i4++) {
                sb.append(cArr[(bArr[i4] & 240) >> 4]);
                sb.append(cArr[bArr[i4] & 15]);
            }
            return sb.toString();
        }
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] strArrB = b(context, packageName);
        if (strArrB == null || strArrB.length <= 0) {
            return null;
        }
        int length = strArrB.length;
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = strArrB[i4] + ";" + packageName;
            if (b.f4919a) {
                b.a("mcode" + strArr[i4]);
            }
        }
        return strArr;
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return AbstractC0351g.q(a(context, packageName), ";", packageName);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String[] b(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "getFingerPrint："
            r1 = 0
            r2 = 0
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            r4 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r8, r4)     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            android.content.pm.SigningInfo r3 = r3.signingInfo     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            if (r3 != 0) goto L25
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            r3 = 64
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r3)     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            android.content.pm.Signature[] r7 = r7.signatures     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            goto L34
        L1f:
            r7 = move-exception
            r8 = r2
            goto L66
        L22:
            r7 = move-exception
            r8 = r2
            goto L7a
        L25:
            boolean r7 = r3.hasMultipleSigners()     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            if (r7 == 0) goto L30
            android.content.pm.Signature[] r7 = r3.getApkContentsSigners()     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            goto L34
        L30:
            android.content.pm.Signature[] r7 = r3.getSigningCertificateHistory()     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
        L34:
            if (r7 == 0) goto L64
            int r8 = r7.length     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            if (r8 <= 0) goto L64
            int r8 = r7.length     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.security.cert.CertificateException -> L1f android.content.pm.PackageManager.NameNotFoundException -> L22
            r3 = r1
        L3d:
            int r4 = r7.length     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            if (r3 >= r4) goto L80
            java.lang.String r4 = "X.509"
            java.security.cert.CertificateFactory r4 = java.security.cert.CertificateFactory.getInstance(r4)     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            r6 = r7[r3]     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            byte[] r6 = r6.toByteArray()     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            r5.<init>(r6)     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            java.security.cert.Certificate r4 = r4.generateCertificate(r5)     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            java.lang.String r4 = a(r4)     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            r8[r3] = r4     // Catch: java.security.cert.CertificateException -> L60 android.content.pm.PackageManager.NameNotFoundException -> L62
            int r3 = r3 + 1
            goto L3d
        L60:
            r7 = move-exception
            goto L66
        L62:
            r7 = move-exception
            goto L7a
        L64:
            r8 = r2
            goto L80
        L66:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
        L6b:
            java.lang.String r7 = r7.toString()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            com.baidu.lbsapi.auth.b.a(r7)
            goto L80
        L7a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            goto L6b
        L80:
            if (r8 == 0) goto Lc4
            int r7 = r8.length
            if (r7 <= 0) goto Lc4
            int r7 = r8.length
            java.lang.String[] r2 = new java.lang.String[r7]
            r7 = r1
        L89:
            int r0 = r8.length
            if (r7 >= r0) goto Lc4
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r3 = r1
        L92:
            r4 = r8[r7]
            int r4 = r4.length()
            if (r3 >= r4) goto Lbb
            r4 = r8[r7]
            char r4 = r4.charAt(r3)
            r0.append(r4)
            if (r3 <= 0) goto Lb8
            int r4 = r3 % 2
            r5 = 1
            if (r4 != r5) goto Lb8
            r4 = r8[r7]
            int r4 = r4.length()
            int r4 = r4 - r5
            if (r3 >= r4) goto Lb8
            java.lang.String r4 = ":"
            r0.append(r4)
        Lb8:
            int r3 = r3 + 1
            goto L92
        Lbb:
            java.lang.String r0 = r0.toString()
            r2[r7] = r0
            int r7 = r7 + 1
            goto L89
        Lc4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.d.b(android.content.Context, java.lang.String):java.lang.String[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[LOOP:0: B:22:0x0084->B:31:0x00a4, LOOP_START, PHI: r1
      0x0084: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:21:0x0082, B:31:0x00a4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "getFingerPrint："
            r1 = 0
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r5, r3)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.SigningInfo r2 = r2.signingInfo     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            if (r2 != 0) goto L22
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            r2 = 64
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r2)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.Signature[] r4 = r4.signatures     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            goto L45
        L1e:
            r4 = move-exception
            goto L61
        L20:
            r4 = move-exception
            goto L75
        L22:
            boolean r2 = r2.hasMultipleSigners()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            if (r2 == 0) goto L37
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r3)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.SigningInfo r4 = r4.signingInfo     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.Signature[] r4 = r4.getApkContentsSigners()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            goto L45
        L37:
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r3)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.SigningInfo r4 = r4.signingInfo     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            android.content.pm.Signature[] r4 = r4.getSigningCertificateHistory()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
        L45:
            java.lang.String r5 = "X.509"
            java.security.cert.CertificateFactory r5 = java.security.cert.CertificateFactory.getInstance(r5)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            r4 = r4[r1]     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            byte[] r4 = r4.toByteArray()     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            r2.<init>(r4)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            java.security.cert.Certificate r4 = r5.generateCertificate(r2)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            java.lang.String r4 = a(r4)     // Catch: java.security.cert.CertificateException -> L1e android.content.pm.PackageManager.NameNotFoundException -> L20
            goto L7d
        L61:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
        L66:
            java.lang.String r4 = r4.toString()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.baidu.lbsapi.auth.b.a(r4)
            goto L7b
        L75:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            goto L66
        L7b:
            java.lang.String r4 = ""
        L7d:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            if (r4 == 0) goto La7
        L84:
            int r0 = r4.length()
            if (r1 >= r0) goto La7
            char r0 = r4.charAt(r1)
            r5.append(r0)
            if (r1 <= 0) goto La4
            int r0 = r1 % 2
            r2 = 1
            if (r0 != r2) goto La4
            int r0 = r4.length()
            int r0 = r0 - r2
            if (r1 >= r0) goto La4
            java.lang.String r0 = ":"
            r5.append(r0)
        La4:
            int r1 = r1 + 1
            goto L84
        La7:
            java.lang.String r4 = r5.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.d.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e4) {
            b.a("getFingerprintAs：" + e4.toString());
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e4) {
            b.a("generateSHA1：" + e4.toString());
            return null;
        }
    }
}
