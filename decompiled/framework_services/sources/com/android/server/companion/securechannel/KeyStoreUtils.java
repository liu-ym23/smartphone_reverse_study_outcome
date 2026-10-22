package com.android.server.companion.securechannel;

import android.security.keystore.KeyGenParameterSpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes.dex */
final class KeyStoreUtils {
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    private static final String TAG = "CDM_SecureChannelKeyStore";

    private KeyStoreUtils() {
    }

    static KeyStore loadKeyStore() throws GeneralSecurityException {
        KeyStore androidKeyStore = KeyStore.getInstance("AndroidKeyStore");
        androidKeyStore.load(null);     // Catch: IOException -> L5
        return androidKeyStore;
    L5:
        e = move-exception;
        throw new KeyStoreException("Failed to load Android Keystore.", e);
    }

    static byte[] getEncodedCertificateChain(String alias) throws GeneralSecurityException {
        KeyStore ks = loadKeyStore();
        Certificate[] certificateChain = ks.getCertificateChain(alias);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int r3 = certificateChain.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L6;
        Certificate certificate = certificateChain[r4];
        buffer.writeBytes(certificate.getEncoded());
        r4 = r4 + 1;
        goto L3
    L6:
        return buffer.toByteArray();
    }

    static void generateAttestationKeyPair(String alias, byte[] attestationChallenge) throws GeneralSecurityException {
        KeyGenParameterSpec parameterSpec = new KeyGenParameterSpec.Builder(alias, 12).setAttestationChallenge(attestationChallenge).setDigests(new String[]{"SHA-256"}).build();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        keyPairGenerator.initialize(parameterSpec);
        keyPairGenerator.generateKeyPair();
    }

    static boolean aliasExists(String alias) {
        KeyStore ks = loadKeyStore();     // Catch: GeneralSecurityException -> L4
        return ks.containsAlias(alias);
    L5:
        return false;
    }

    static void cleanUp(String alias) {
        KeyStore ks = loadKeyStore();     // Catch: Exception -> L6
        if (ks.containsAlias(alias) == false) goto L12;
        ks.deleteEntry(alias);     // Catch: Exception -> L6
        return;
    L12:
        return;
    }
}
