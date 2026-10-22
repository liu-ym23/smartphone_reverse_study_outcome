package com.bytedance.crypto.e2eetrans;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IAttestationService {
    void destroy();

    String extractChallenge(X509Certificate r1);

    byte[] generateSharedSecret(PublicKey r1);

    List<X509Certificate> getCertificateChain(String r1);

    boolean validateCertificateChain(List<X509Certificate> r1);
}
