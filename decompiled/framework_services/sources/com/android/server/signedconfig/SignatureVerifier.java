package com.android.server.signedconfig;

import android.os.Build;
import android.util.Slog;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureVerifier {
    private static final boolean DBG = false;
    private static final String DEBUG_KEY = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEmJKs4lSn+XRhMQmMid+Zbhbu13YrU1haIhVC5296InRu1x7A8PV1ejQyisBODGgRY6pqkAHRncBCYcgg5wIIJg==";
    private static final String PROD_KEY = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE+lky6wKyGL6lE1VrD0YTMHwb0Xwc+tzC8MvnrzVxodvTpVY/jV7V+Zktcx+pry43XPABFRXtbhTo+qykhyBA1g==";
    private static final String TAG = "SignedConfig";
    private final PublicKey mDebugKey;
    private final SignedConfigEvent mEvent;
    private final PublicKey mProdKey;

    public SignatureVerifier(SignedConfigEvent event) {
        this.mEvent = event;
        if (Build.IS_DEBUGGABLE == false) goto L5;
        PublicKey r0 = createKey(DEBUG_KEY);
    L6:
        this.mDebugKey = r0;
        this.mProdKey = createKey(PROD_KEY);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static PublicKey createKey(String base64) {
        byte[] key = Base64.getDecoder().decode(base64);     // Catch: IllegalArgumentException -> L9
        EncodedKeySpec keySpec = new X509EncodedKeySpec(key);     // Catch: IllegalArgumentException -> L9
        KeyFactory factory = KeyFactory.getInstance("EC");     // Catch: Throwable -> L6
        return factory.generatePublic(keySpec);
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to construct public key", e);
        return null;
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to base64 decode public key", e);
        return null;
    }

    private boolean verifyWithPublicKey(PublicKey key, byte[] data, byte[] signature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature verifier = Signature.getInstance("SHA256withECDSA");
        verifier.initVerify(key);
        verifier.update(data);
        return verifier.verify(signature);
    }

    public boolean verifySignature(String config, String base64Signature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        byte[] signature = Base64.getDecoder().decode(base64Signature);     // Catch: IllegalArgumentException -> L23
        byte[] data = config.getBytes(StandardCharsets.UTF_8);
        if (Build.IS_DEBUGGABLE == false) goto L14;
        if (this.mDebugKey != null) goto L9;
        Slog.w(TAG, "Debuggable build, but have no debug key");
        goto L14
    L9:
        if (verifyWithPublicKey(this.mDebugKey, data, signature) == false) goto L14;
        Slog.i(TAG, "Verified config using debug key");
        this.mEvent.verifiedWith = 1;
        return true;
    L14:
        if (this.mProdKey != null) goto L18;
        Slog.e(TAG, "No prod key; construction failed?");
        this.mEvent.status = 9;
        return false;
    L18:
        if (verifyWithPublicKey(this.mProdKey, data, signature) == false) goto L21;
        Slog.i(TAG, "Verified config using production key");
        this.mEvent.verifiedWith = 2;
        return true;
    L21:
        this.mEvent.status = 7;
        return false;
    L24:
        this.mEvent.status = 3;
        Slog.e(TAG, "Failed to base64 decode signature");
        return false;
    }
}
