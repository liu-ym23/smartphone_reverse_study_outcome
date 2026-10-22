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
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkSafeCertEncryptor {
    public static final PolicySdkSafeCertEncryptor INSTANCE = new PolicySdkSafeCertEncryptor();

    private PolicySdkSafeCertEncryptor() {
    }

    public final Pair<Pair<Integer, String>, Cipher> encryptorByPublicKey(InputStream fis) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, CertificateException {
        kotlin.jvm.internal.g.f(fis, "fis");
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(fis);
        kotlin.jvm.internal.g.d(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate x509Certificate = (X509Certificate) certificateGenerateCertificate;
        byte[] byteArray = x509Certificate.getSerialNumber().toByteArray();
        kotlin.jvm.internal.g.e(byteArray, "loadedCert.serialNumber.toByteArray()");
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : byteArray) {
            sb2.append(String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1)));
        }
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "serialNumber.toString()");
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, x509Certificate.getPublicKey());
        return new Pair<>(new Pair(Integer.valueOf(x509Certificate.getVersion()), string), cipher);
    }
}
