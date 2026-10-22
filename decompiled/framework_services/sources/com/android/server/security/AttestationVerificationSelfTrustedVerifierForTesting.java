package com.android.server.security;

import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Slog;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.x509.Certificate;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class AttestationVerificationSelfTrustedVerifierForTesting {
    private static final String ANDROID_KEYMINT_KEY_DESCRIPTION_EXTENSION_OID = "1.3.6.1.4.1.11129.2.1.17";
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final int ATTESTATION_CHALLENGE_INDEX = 4;
    private static final String GOLDEN_ALIAS = null;
    private static final String TAG = "AVF";
    private static volatile AttestationVerificationSelfTrustedVerifierForTesting sAttestationVerificationSelfTrustedVerifier;
    private final KeyStore mAndroidKeyStore;
    private final CertPathValidator mCertPathValidator;
    private final CertificateFactory mCertificateFactory;
    private X509Certificate mGoldenRootCert;

    static {
        GOLDEN_ALIAS = AttestationVerificationSelfTrustedVerifierForTesting.class.getCanonicalName() + ".Golden";
        sAttestationVerificationSelfTrustedVerifier = null;
    }

    static AttestationVerificationSelfTrustedVerifierForTesting getInstance() throws Exception {
        if (sAttestationVerificationSelfTrustedVerifier != null) goto L16;
        monitor-enter(AttestationVerificationSelfTrustedVerifierForTesting.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sAttestationVerificationSelfTrustedVerifier != null) goto L11;
        sAttestationVerificationSelfTrustedVerifier = new AttestationVerificationSelfTrustedVerifierForTesting();     // Catch: Throwable -> L9
    L11:
        monitor-exit(AttestationVerificationSelfTrustedVerifierForTesting.class);     // Catch: Throwable -> L9
    L16:
        return sAttestationVerificationSelfTrustedVerifier;
    }

    private AttestationVerificationSelfTrustedVerifierForTesting() throws Exception {
        this.mCertificateFactory = CertificateFactory.getInstance("X.509");
        this.mCertPathValidator = CertPathValidator.getInstance("PKIX");
        this.mAndroidKeyStore = KeyStore.getInstance("AndroidKeyStore");
        this.mAndroidKeyStore.load(null);
        if (this.mAndroidKeyStore.containsAlias(GOLDEN_ALIAS) == true) goto L5;
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        KeyGenParameterSpec parameterSpec = new KeyGenParameterSpec.Builder(GOLDEN_ALIAS, 12).setAttestationChallenge(GOLDEN_ALIAS.getBytes()).setDigests(new String[]{"SHA-256", "SHA-512"}).build();
        kpg.initialize(parameterSpec);
        kpg.generateKeyPair();
    L5:
        X509Certificate[] goldenCerts = (X509Certificate[]) ((KeyStore.PrivateKeyEntry) this.mAndroidKeyStore.getEntry(GOLDEN_ALIAS, null)).getCertificateChain();
        this.mGoldenRootCert = goldenCerts[goldenCerts.length - 1];
    }

    int verifyAttestation(int localBindingType, Bundle requirements, byte[] attestation) {
        List<X509Certificate> certificates = new ArrayList();
        ByteArrayInputStream bis = new ByteArrayInputStream(attestation);
    L33:
    L8:
        e = move-exception;
        Slog.e("Unable to parse certificates from attestation", e.getLocalizedMessage());
        return 4;
    L5:
        if (bis.available() <= 0) goto L10;
        certificates.add((X509Certificate) this.mCertificateFactory.generateCertificate(bis));     // Catch: CertificateException -> L8
        goto L33
    L10:
        int result = 0;
        if (localBindingType == 3) goto L13;
    L27:
        Slog.e(TAG, "Local binding requirements verification failure." + localBindingType);
        return 8;
    L13:
        if (validateRequirements(requirements) == false) goto L27;
        byte[] challenge = getChallengeFromCert(certificates.get(0));     // Catch: Throwable -> L24
        if (Arrays.equals(requirements.getByteArray("localbinding.challenge"), challenge) == true) goto L21;
        Slog.e(TAG, "Self-Trusted validation failed; challenge mismatch.");
        result = 0 | 8;
    L21:
        if (verifyCertificateChain(certificates) == false) goto L23;
        return result;
    L23:
        return result | 4;
    L24:
        t = move-exception;
        Slog.e("Unable to parse challenge from certificate.", t.getLocalizedMessage());
        int result2 = 4 | 0;
        return result2;
    }

    private boolean verifyCertificateChain(List<X509Certificate> certificates) {
        if (certificates.size() >= 2) goto L12;
        Slog.e(TAG, "Certificate chain less than 2 in size.");
        return false;
    L12:
        CertPath certificatePath = this.mCertificateFactory.generateCertPath(certificates);     // Catch: Throwable -> L9
        PKIXParameters validationParams = new PKIXParameters(getTrustAnchors());     // Catch: Throwable -> L9
        validationParams.setRevocationEnabled(false);     // Catch: Throwable -> L9
        this.mCertPathValidator.validate(certificatePath, validationParams);     // Catch: Throwable -> L9
        return true;
    L9:
        t = move-exception;
        Slog.e(TAG, "Invalid certificate chain", t);
        return false;
    }

    private Set<TrustAnchor> getTrustAnchors() {
        return Collections.singleton(new TrustAnchor(this.mGoldenRootCert, null));
    }

    private boolean validateRequirements(Bundle requirements) {
        if (requirements.size() == 1) goto L7;
        Slog.e(TAG, "Requirements does not contain exactly 1 key.");
        return false;
    L7:
        if (requirements.containsKey("localbinding.challenge") == true) goto L10;
        Slog.e(TAG, "Requirements does not contain key: localbinding.challenge");
        return false;
    L10:
        return true;
    }

    private byte[] getChallengeFromCert(X509Certificate x509Certificate) throws CertificateEncodingException, IOException {
        Certificate certificate = Certificate.getInstance(new ASN1InputStream(x509Certificate.getEncoded()).readObject());
        ASN1Sequence keyAttributes = certificate.getTBSCertificate().getExtensions().getExtensionParsedValue(new ASN1ObjectIdentifier(ANDROID_KEYMINT_KEY_DESCRIPTION_EXTENSION_OID));
        return keyAttributes.getObjectAt(4).getOctets();
    }
}
