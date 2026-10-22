package com.stepos.policy.sdk.util;

import V3.m;
import V3.r;
import j4.k;
import j4.y;
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

/* loaded from: classes.dex */
public final class PolicySdkSafeCertEncryptor {
    public static final PolicySdkSafeCertEncryptor INSTANCE = new PolicySdkSafeCertEncryptor();

    private PolicySdkSafeCertEncryptor() {
    }

    public final m<m<Integer, String>, Cipher> encryptorByPublicKey(InputStream inputStream) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, CertificateException {
        k.g(inputStream, "fis");
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
        k.e(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate x509Certificate = (X509Certificate) certificateGenerateCertificate;
        byte[] byteArray = x509Certificate.getSerialNumber().toByteArray();
        k.f(byteArray, "loadedCert.serialNumber.toByteArray()");
        StringBuilder sb = new StringBuilder();
        for (byte b6 : byteArray) {
            y yVar = y.f17839a;
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b6)}, 1));
            k.f(str, "format(format, *args)");
            sb.append(str);
        }
        String string = sb.toString();
        k.f(string, "serialNumber.toString()");
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, x509Certificate.getPublicKey());
        return r.a(r.a(Integer.valueOf(x509Certificate.getVersion()), string), cipher);
    }
}
