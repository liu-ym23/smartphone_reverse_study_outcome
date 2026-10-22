package com.android.server.locksettings.recoverablekeystore;

import android.util.Log;
import android.util.Pair;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class WrappedKey {
    private static final String APPLICATION_KEY_ALGORITHM = "AES";
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final String KEY_WRAP_CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    private static final String TAG = "WrappedKey";
    private final byte[] mKeyMaterial;
    private final byte[] mKeyMetadata;
    private final byte[] mNonce;
    private final int mPlatformKeyGenerationId;
    private final int mRecoveryStatus;

    public static WrappedKey fromSecretKey(PlatformEncryptionKey wrappingKey, SecretKey key, byte[] metadata) throws InvalidKeyException, KeyStoreException {
        if (key.getEncoded() == null) goto L20;
        Cipher cipher = Cipher.getInstance(KEY_WRAP_CIPHER_ALGORITHM);     // Catch: Throwable -> L16
        cipher.init(3, wrappingKey.getKey());
        byte[] encryptedKeyMaterial = cipher.wrap(key);     // Catch: IllegalBlockSizeException -> L9
        return new WrappedKey(cipher.getIV(), encryptedKeyMaterial, metadata, wrappingKey.getGenerationId(), 1);
    L9:
        e = move-exception;
        Throwable cause = e.getCause();
        if ((cause instanceof KeyStoreException) == false) goto L15;
        throw ((KeyStoreException) cause);
    L15:
        throw new RuntimeException("IllegalBlockSizeException should not be thrown by AES/GCM/NoPadding mode.", e);
    L18:
        throw new RuntimeException("Android does not support AES/GCM/NoPadding. This should never happen.");
    L20:
        throw new InvalidKeyException("key does not expose encoded material. It cannot be wrapped.");
    }

    public WrappedKey(byte[] nonce, byte[] keyMaterial, byte[] keyMetadata, int platformKeyGenerationId) {
        this(nonce, keyMaterial, keyMetadata, platformKeyGenerationId, 1);
    }

    public WrappedKey(byte[] nonce, byte[] keyMaterial, byte[] keyMetadata, int platformKeyGenerationId, int recoveryStatus) {
        this.mNonce = nonce;
        this.mKeyMaterial = keyMaterial;
        this.mKeyMetadata = keyMetadata;
        this.mPlatformKeyGenerationId = platformKeyGenerationId;
        this.mRecoveryStatus = recoveryStatus;
    }

    public byte[] getNonce() {
        return this.mNonce;
    }

    public byte[] getKeyMaterial() {
        return this.mKeyMaterial;
    }

    public byte[] getKeyMetadata() {
        return this.mKeyMetadata;
    }

    public int getPlatformKeyGenerationId() {
        return this.mPlatformKeyGenerationId;
    }

    public int getRecoveryStatus() {
        return this.mRecoveryStatus;
    }

    public static Map<String, Pair<SecretKey, byte[]>> unwrapKeys(PlatformDecryptionKey platformKey, Map<String, WrappedKey> wrappedKeys) throws NoSuchAlgorithmException, NoSuchPaddingException, BadPlatformKeyException, InvalidKeyException, InvalidAlgorithmParameterException {
        HashMap<String, Pair<SecretKey, byte[]>> unwrappedKeys = new HashMap();
        Cipher cipher = Cipher.getInstance(KEY_WRAP_CIPHER_ALGORITHM);
        int platformKeyGenerationId = platformKey.getGenerationId();
        Iterator<String> r3 = wrappedKeys.keySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        String alias = r3.next();
        WrappedKey wrappedKey = wrappedKeys.get(alias);
        if (wrappedKey.getPlatformKeyGenerationId() != platformKeyGenerationId) goto L13;
        cipher.init(4, platformKey.getKey(), new GCMParameterSpec(128, wrappedKey.getNonce()));
        SecretKey key = (SecretKey) cipher.unwrap(wrappedKey.getKeyMaterial(), APPLICATION_KEY_ALGORITHM, 3);     // Catch: Throwable -> L10
        unwrappedKeys.put(alias, Pair.create(key, wrappedKey.getKeyMetadata()));
    L10:
        e = move-exception;
        Log.e(TAG, String.format(Locale.US, "Error unwrapping recoverable key with alias '%s'", new Object[]{alias}), e);
        goto L4
    L13:
        throw new BadPlatformKeyException(String.format(Locale.US, "WrappedKey with alias '%s' was wrapped with platform key %d, not platform key %d", new Object[]{alias, Integer.valueOf(wrappedKey.getPlatformKeyGenerationId()), Integer.valueOf(platformKey.getGenerationId())}));
    L14:
        return unwrappedKeys;
    }
}
