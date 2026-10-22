package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.Signature;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.a$a, reason: collision with other inner class name */
    public static class C0031a {
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

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return AbstractC0351g.q(a(context, packageName), ";", packageName);
    }

    private static String a(Context context, String str) {
        String strA;
        Signature[] signingCertificateHistory;
        try {
            if (context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.hasMultipleSigners()) {
                signingCertificateHistory = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners();
            } else {
                signingCertificateHistory = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getSigningCertificateHistory();
            }
            strA = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signingCertificateHistory[0].toByteArray())));
        } catch (Exception e4) {
            e4.printStackTrace();
            strA = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < strA.length(); i4++) {
            stringBuffer.append(strA.charAt(i4));
            if (i4 > 0 && i4 % 2 == 1 && i4 < strA.length() - 1) {
                stringBuffer.append(AwarenessDataItem.USERID_SPLITTER);
            }
        }
        return stringBuffer.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return C0031a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
