package com.stepos.core.ota.crypto;

import android.security.keystore.KeyGenParameterSpec;
import com.stepos.core.ota.domain.port.OtaLogger;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeystoreAtRestKeyStore implements AtRestKeyStore {

    @Deprecated
    public static final String ALIAS = "model_at_rest_kek";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int DEK_BYTES = 32;

    @Deprecated
    public static final String KEYSTORE = "AndroidKeyStore";

    @Deprecated
    public static final String TAG = "AtRestKeyStore";
    private final OtaLogger log;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public KeystoreAtRestKeyStore(OtaLogger log) {
        g.f(log, "log");
        this.log = log;
    }

    private final SecretKey generateKek() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(ALIAS, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setUserAuthenticationRequired(false).setRandomizedEncryptionRequired(true).build());
        this.log.i(TAG, "generated at-rest KEK alias=model_at_rest_kek");
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        g.e(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    private final SecretKey kek() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(ALIAS, null);
        SecretKey secretKey = key instanceof SecretKey ? (SecretKey) key : null;
        return secretKey != null ? secretKey : generateKek();
    }

    @Override // com.stepos.core.ota.crypto.AtRestKeyStore
    public DekMaterial newDek() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        return new DekMaterial(bArr, DekEnvelope.INSTANCE.wrap(kek(), bArr));
    }

    @Override // com.stepos.core.ota.crypto.AtRestKeyStore
    public byte[] unwrapDek(byte[] wrapped) {
        g.f(wrapped, "wrapped");
        return DekEnvelope.INSTANCE.unwrap(kek(), wrapped);
    }
}
