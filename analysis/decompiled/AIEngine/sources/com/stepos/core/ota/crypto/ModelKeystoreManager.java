package com.stepos.core.ota.crypto;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.stepos.core.ota.crypto.attest.AttestationParser;
import com.stepos.core.ota.d;
import com.stepos.core.ota.domain.port.OtaLogger;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelKeystoreManager implements DeviceKeyStore {

    @Deprecated
    public static final String ALIAS = "model_fek_key";

    @Deprecated
    public static final String CURVE = "secp256r1";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String KEYSTORE = "AndroidKeyStore";

    @Deprecated
    public static final String TAG = "ModelKeystore";
    private final OtaLogger log;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public ModelKeystoreManager(OtaLogger log) {
        g.f(log, "log");
        this.log = log;
    }

    private final String describe(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String message = th.getMessage();
        if (message == null) {
            message = "(no message)";
        }
        return d.i(simpleName, ": ", message);
    }

    private final void generate(KeyGenParameterSpec keyGenParameterSpec) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        keyPairGenerator.initialize(keyGenParameterSpec);
        keyPairGenerator.generateKeyPair();
    }

    private final void generateKeyPair(KeyStore keyStore, byte[] bArr) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Object objA;
        try {
            generate(spec(bArr));
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB == null) {
            return;
        }
        this.log.w(TAG, "attested key generation failed, falling back to a raw key: " + describe(thB));
        try {
            keyStore.deleteEntry(ALIAS);
            n nVar = n.f10413a;
        } catch (Throwable th2) {
            c.a(th2);
        }
        generate(spec(null));
    }

    private final boolean isAttested(Certificate[] certificateArr) {
        Object objE0 = l.e0(certificateArr);
        X509Certificate x509Certificate = objE0 instanceof X509Certificate ? (X509Certificate) objE0 : null;
        return (x509Certificate == null || certificateArr.length < 2 || x509Certificate.getExtensionValue(AttestationParser.ATTESTATION_OID) == null) ? false : true;
    }

    private final KeyStore keystore() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    }

    private static final CharSequence publicKeyFingerprint$lambda$1$lambda$0(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final KeyGenParameterSpec spec(byte[] bArr) {
        KeyGenParameterSpec.Builder userAuthenticationRequired = new KeyGenParameterSpec.Builder(ALIAS, 64).setAlgorithmParameterSpec(new ECGenParameterSpec(CURVE)).setDigests("SHA-256").setUserAuthenticationRequired(false);
        if (bArr != null) {
            userAuthenticationRequired.setAttestationChallenge(bArr);
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = userAuthenticationRequired.build();
        g.e(keyGenParameterSpecBuild, "build(...)");
        return keyGenParameterSpecBuild;
    }

    private final boolean supported() {
        return Build.VERSION.SDK_INT >= 31;
    }

    @Override // com.stepos.core.ota.crypto.DeviceKeyStore
    public void delete() {
        try {
            keystore().deleteEntry(ALIAS);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
    }

    @Override // com.stepos.core.ota.crypto.DeviceKeyStore
    public boolean isUsable() {
        Object objA;
        try {
            objA = Boolean.valueOf(supported() && keystore().getKey(ALIAS, null) != null);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    @Override // com.stepos.core.ota.crypto.DeviceKeyStore
    public PrivateKey privateKeyOrNull() {
        Object objA;
        try {
            Object key = keystore().getKey(ALIAS, null);
            objA = key instanceof PrivateKey ? (PrivateKey) key : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (PrivateKey) (objA instanceof Result.Failure ? null : objA);
    }

    @Override // com.stepos.core.ota.crypto.DeviceKeyStore
    public String publicKeyFingerprint() {
        Object objA;
        X509Certificate x509Certificate;
        try {
            Certificate certificate = keystore().getCertificate(ALIAS);
            x509Certificate = certificate instanceof X509Certificate ? (X509Certificate) certificate : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (x509Certificate == null) {
            return null;
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(x509Certificate.getPublicKey().getEncoded());
        g.e(bArrDigest, "digest(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (byte b10 : bArrDigest) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(publicKeyFingerprint$lambda$1$lambda$0(b10));
        }
        sb2.append((CharSequence) "");
        objA = sb2.toString();
        return (String) (objA instanceof Result.Failure ? null : objA);
    }

    @Override // com.stepos.core.ota.crypto.DeviceKeyStore
    /* renamed from: regenerate-IoAF18A */
    public Object mo119regenerateIoAF18A(byte[] challenge) {
        g.f(challenge, "challenge");
        try {
            if (!supported()) {
                throw new IllegalStateException(("ECDH key agreement needs API 31, device is API " + Build.VERSION.SDK_INT).toString());
            }
            KeyStore keystore = keystore();
            try {
                keystore.deleteEntry(ALIAS);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
            generateKeyPair(keystore, challenge);
            Certificate[] certificateChain = keystore.getCertificateChain(ALIAS);
            if (certificateChain == null) {
                throw new IllegalStateException("certificate chain unavailable after generation");
            }
            if (certificateChain.length == 0) {
                throw new IllegalStateException("empty certificate chain");
            }
            boolean zIsAttested = isAttested(certificateChain);
            this.log.i(TAG, "key generated attested=" + zIsAttested + " chainCerts=" + certificateChain.length);
            ArrayList arrayList = new ArrayList(certificateChain.length);
            for (Certificate certificate : certificateChain) {
                arrayList.add(Base64.encodeToString(certificate.getEncoded(), 2));
            }
            return new DeviceKeyMaterial(arrayList, zIsAttested);
        } catch (Throwable th2) {
            return c.a(th2);
        }
    }
}
