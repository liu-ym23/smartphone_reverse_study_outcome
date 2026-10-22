package com.stepos.policy.sdk.util;

import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import jb.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkSafeCertEncryptor {
    public static final PolicySdkSafeCertEncryptor INSTANCE = new PolicySdkSafeCertEncryptor();

    private PolicySdkSafeCertEncryptor() {
    }

    public final g encryptorByPublicKey(InputStream inputStream) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, CertificateException {
        inputStream.getClass();
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
        certificateGenerateCertificate.getClass();
        X509Certificate x509Certificate = (X509Certificate) certificateGenerateCertificate;
        byte[] byteArray = x509Certificate.getSerialNumber().toByteArray();
        byteArray.getClass();
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : byteArray) {
            sb2.append(String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1)));
        }
        String string = sb2.toString();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, x509Certificate.getPublicKey());
        return new g(new g(Integer.valueOf(x509Certificate.getVersion()), string), cipher);
    }
}
