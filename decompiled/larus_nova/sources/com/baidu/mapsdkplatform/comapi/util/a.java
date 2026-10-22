package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.util.a$a, reason: collision with other inner class name */
    public static class C0648a {
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

    public static String a(Context r100) {
        String r101 = r100.getPackageName();
        return a(r100, r101) + i.f25853b + r101;
    }

    public static String a(X509Certificate r100) {
        return C0648a.a(a(r100.getEncoded()));
    L4:
        return null;
    }

    public static byte[] a(byte[] r100) {
        return MessageDigest.getInstance("SHA1").digest(r100);
    L4:
        return null;
    }

    private static String a(Context r100, String r101) {
        int r102 = 0;
    L12:
        e = move-exception;
        e.printStackTrace();
        String r103 = "";
    L14:
        StringBuffer r104 = new StringBuffer();
    L16:
        if (r102 >= r103.length()) goto L26;
        r104.append(r103.charAt(r102));
        if (r102 <= 0) goto L24;
        if ((r102 % 2) != 1) goto L24;
        if (r102 >= (r103.length() - 1)) goto L24;
        r104.append(":");
    L24:
        r102 = r102 + 1;
        goto L16
    L26:
        return r104.toString();
    L4:
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        Signature[] r105 = r100.getPackageManager().getPackageInfo(r101, 64).signatures;     // Catch: Exception -> L12
    L10:
        r103 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r105[0].toByteArray())));     // Catch: Exception -> L12
        goto L14
    L6:
        if (r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.hasMultipleSigners() == false) goto L8;
        r105 = r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getApkContentsSigners();     // Catch: Exception -> L12
        goto L10
    L8:
        r105 = r100.getPackageManager().getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo.getSigningCertificateHistory();     // Catch: Exception -> L12
        goto L10
    }
}
