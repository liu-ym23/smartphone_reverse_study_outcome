package com.android.server.locksettings;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
class RebootEscrowKey {
    private static final String KEY_ALGO = "AES";
    private static final int KEY_SIZE_BITS = 256;
    private final SecretKey mKey;

    private RebootEscrowKey(SecretKey key) {
        this.mKey = key;
    }

    static RebootEscrowKey fromKeyBytes(byte[] keyBytes) {
        return new RebootEscrowKey(new SecretKeySpec(keyBytes, KEY_ALGO));
    }

    static RebootEscrowKey generate() throws IOException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGO);     // Catch: NoSuchAlgorithmException -> L5
        keyGenerator.init(256, new SecureRandom());     // Catch: NoSuchAlgorithmException -> L5
        SecretKey secretKey = keyGenerator.generateKey();     // Catch: NoSuchAlgorithmException -> L5
        return new RebootEscrowKey(secretKey);
    L5:
        e = move-exception;
        throw new IOException("Could not generate new secret key", e);
    }

    SecretKey getKey() {
        return this.mKey;
    }

    byte[] getKeyBytes() {
        return this.mKey.getEncoded();
    }
}
