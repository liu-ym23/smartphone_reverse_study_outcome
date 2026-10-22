package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* JADX INFO: loaded from: classes39.dex */
class d {

    public static class a {
        public static String a(byte[] r100) {
            char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder r102 = new StringBuilder(r100.length * 2);
            int r103 = 0;
        L4:
            if (r103 >= r100.length) goto L7;
            r102.append(r101[(r100[r103] & 240) >> 4]);
            r102.append(r101[r100[r103] & 15]);
            r103 = r103 + 1;
            goto L4
        L7:
            return r102.toString();
        }
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String a(Context r100) {
        String r101 = r100.getPackageName();
        return a(r100, r101) + com.alipay.sdk.m.u.i.f25853b + r101;
    }

    private static String a(Context r100, String r101) {
        int r102 = 0;
    L18:
        e = move-exception;
        StringBuilder r103 = new StringBuilder("getFingerPrint：");
        String r104 = e.toString();
    L20:
        r103.append(r104);
        b.a(r103.toString());
        String r105 = "";
    L21:
        StringBuffer r106 = new StringBuffer();
        if (r105 == null) goto L34;
    L24:
        if (r102 >= r105.length()) goto L34;
        r106.append(r105.charAt(r102));
        if (r102 <= 0) goto L32;
        if ((r102 % 2) != 1) goto L32;
        if (r102 >= (r105.length() - 1)) goto L32;
        r106.append(":");
    L32:
        r102 = r102 + 1;
    L34:
        return r106.toString();
    L16:
        e = move-exception;
        r103 = new StringBuilder("getFingerPrint：");
        r104 = e.toString();
        goto L20
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        SigningInfo r107 = r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo;     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
        if (r107 != null) goto L10;
        PackageInfo r108 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
    L8:
        Signature[] r109 = r108.signatures;     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
    L14:
        r105 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r109[0].toByteArray())));     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
    L10:
        if (r107.hasMultipleSigners() == false) goto L12;
        r109 = r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getApkContentsSigners();     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
        goto L14
    L12:
        r109 = r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getSigningCertificateHistory();     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
        goto L14
    L13:
        r108 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: CertificateException -> L16 PackageManager.NameNotFoundException -> L18
        goto L8
    }

    public static String a(X509Certificate r100) {
        return a.a(a(r100.getEncoded()));
    L4:
        e = move-exception;
        b.a("getFingerprintAs：" + e.toString());
        return null;
    }

    public static byte[] a(byte[] r100) {
        return MessageDigest.getInstance("SHA1").digest(r100);
    L4:
        e = move-exception;
        b.a("generateSHA1：" + e.toString());
        return null;
    }

    public static String[] b(Context r100) {
        String r101 = r100.getPackageName();
        String[] r102 = b(r100, r101);
        if (r102 != null) goto L5;
    L12:
        return null;
    L5:
        if (r102.length <= 0) goto L12;
        int r103 = r102.length;
        String[] r104 = new String[r103];
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L17;
        r104[r105] = r102[r105] + com.alipay.sdk.m.u.i.f25853b + r101;
        if (b.f30442a == false) goto L11;
        b.a("mcode" + r104[r105]);
    L11:
        r105 = r105 + 1;
        goto L7
    L17:
        return r104;
    }

    private static String[] b(Context r100, String r101) {
        String[] r102 = null;
    L31:
        e = e;
        String[] r103 = null;
    L33:
        StringBuilder r104 = new StringBuilder("getFingerPrint：");
        String r105 = e.toString();
    L34:
        r104.append(r105);
        b.a(r104.toString());
    L35:
        if (r103 != null) goto L37;
    L53:
        return r102;
    L37:
        if (r103.length <= 0) goto L53;
        r102 = new String[r103.length];
        int r106 = 0;
    L40:
        if (r106 >= r103.length) goto L53;
        StringBuffer r107 = new StringBuffer();
        int r108 = 0;
    L42:
        String r109 = r103[r106];
        if (r109 == null) goto L52;
        if (r108 >= r109.length()) goto L52;
        r107.append(r103[r106].charAt(r108));
        if ((r108 % 2) != 1) goto L51;
        if (r108 >= (r103[r106].length() - 1)) goto L51;
        r107.append(":");
    L51:
        r108 = r108 + 1;
    L52:
        r102[r106] = r107.toString();
        r106 = r106 + 1;
    L28:
        e = e;
        r103 = null;
    L30:
        r104 = new StringBuilder("getFingerPrint：");
        r105 = e.toString();
        goto L34
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        SigningInfo r110 = r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo;     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
        if (r110 != null) goto L10;
        PackageInfo r111 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
    L8:
        Signature[] r112 = r111.signatures;     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
    L14:
        if (r112 != null) goto L16;
    L27:
        r103 = null;
        goto L35
    L16:
        if (r112.length <= 0) goto L27;
        r103 = new String[r112.length];     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
        int r113 = 0;
    L54:
    L25:
        e = e;
    L23:
        e = e;
        goto L30
    L20:
        if (r113 >= r112.length) goto L35;
        r103[r113] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r112[r113].toByteArray())));     // Catch: CertificateException -> L23 PackageManager.NameNotFoundException -> L25
        r113 = r113 + 1;
        goto L54
    L10:
        if (r110.hasMultipleSigners() == false) goto L12;
        r112 = r110.getApkContentsSigners();     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
        goto L14
    L12:
        r112 = r110.getSigningCertificateHistory();     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
        goto L14
    L13:
        r111 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: CertificateException -> L28 PackageManager.NameNotFoundException -> L31
        goto L8
    }
}
