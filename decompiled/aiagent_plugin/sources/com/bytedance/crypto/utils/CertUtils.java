package com.bytedance.crypto.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CertUtils {
    private static final String TAG = "CertUtils";

    public CertUtils() {
    }

    public static String certsToPemString(List<Certificate> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L26;
        if (r10.isEmpty() == true) goto L26;
        if (r9 <= 0) goto L26;
        if (r9 > r10.size()) goto L26;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        Iterator r11 = r10.iterator();
        int r3 = 0;
    L11:
        if (r11.hasNext() == false) goto L24;
        Certificate r4 = (Certificate) ZeusTransformUtils.preCheckCast(r11.next(), Certificate.class, "com.obric.aiagent.plugin");
        if (r3 >= r9) goto L24;
        if (r4 == null) goto L22;
        r0.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r5 = Base64.getEncoder().encodeToString(r4.getEncoded());
        int r6 = 0;
    L18:
        if (r6 >= r5.length()) goto L20;
        int r7 = r6 + 64;
        r0.write(r5.substring(r6, Math.min(r7, r5.length())).getBytes());
        r6 = r7;
        goto L18
    L20:
        r0.write("\\n".getBytes());
        r0.write("-----END CERTIFICATE-----\\n".getBytes());
        r3 = r3 + 1;
        goto L11
    L22:
        throw new IllegalArgumentException("Certificate is null at index " + r3);
    L24:
        return r0.toString();
    L26:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }

    public static List<X509Certificate> convertToX509Certificates(byte[] r4) {
        ArrayList r1 = new ArrayList();
        Iterator<? extends Certificate> r5 = CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(r4)).iterator();     // Catch: CertificateException -> L10
    L5:
        if (r5.hasNext() == false) goto L12;
        Certificate r2 = (Certificate) ZeusTransformUtils.preCheckCast(r5.next(), Certificate.class, "com.obric.aiagent.plugin");     // Catch: CertificateException -> L10
        if (ZeusTransformUtils.instanceOf(r2, X509Certificate.class) == false) goto L5;
        r1.add((X509Certificate) ZeusTransformUtils.preCheckCast(r2, X509Certificate.class, "com.obric.aiagent.plugin"));     // Catch: CertificateException -> L10
    L12:
        return r1;
    L10:
        e = move-exception;
        LogUtils.e(TAG, "convertToX509Certificates failed, exception: " + e.getMessage());
        goto L12
    }

    public static byte[] pemStringToEncodedPubKey(String r3) {
        byte[] r4 = android.util.Base64.decode(r3.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""), 0);
        byte[] r0 = new byte[0];
        return KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(r4)).getEncoded();
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    public static X509Certificate pemStringToX509(String r3) {
        return (X509Certificate) ZeusTransformUtils.preCheckCast(CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.getDecoder().decode(r3.replace("-----BEGIN CERTIFICATE-----", "").replace("-----END CERTIFICATE-----", "").replace("\n", "")))), X509Certificate.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        LogUtils.e(TAG, "pemStringToX509 failed, exception: " + e.getMessage());
        return null;
    }

    public static boolean validateCertChain(X509Certificate r4, List<X509Certificate> r5) {
        List<? extends Certificate> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L15;
        if (r6 == null) goto L15;
        if (r6.isEmpty() == true) goto L15;
        HashSet r1 = new HashSet();
        r1.add(new TrustAnchor(r4, null));
        PKIXParameters r7 = new PKIXParameters(r1);     // Catch: Exception -> L12
        r7.setRevocationEnabled(false);     // Catch: Exception -> L12
        CertPathValidator.getInstance("PKIX").validate(CertificateFactory.getInstance("X.509").generateCertPath(r6), r7);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "validateCertChain failed, exception: " + e.getMessage());
        return false;
    L15:
        LogUtils.e(TAG, "Invalid params.");
        return false;
    }
}
