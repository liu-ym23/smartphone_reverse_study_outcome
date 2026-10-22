package com.android.server.companion.transport;

import android.util.Slog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class CryptoManager {
    private static final String ALGORITHM = "AES";
    private static final int SECRET_KEY_LENGTH = 32;
    private static final String TAG = "CDM_CryptoManager";
    private static final String TRANSFORMATION = "AES/CBC/PKCS7Padding";
    private Cipher mDecryptCipher;
    private Cipher mEncryptCipher;
    private final byte[] mPreSharedKey;
    private SecretKey mSecretKey;

    public CryptoManager(byte[] preSharedKey) {
        if (preSharedKey != null) goto L5;
        this.mPreSharedKey = Arrays.copyOf(new byte[0], 32);
    L6:
        this.mSecretKey = new SecretKeySpec(this.mPreSharedKey, ALGORITHM);
        this.mEncryptCipher = Cipher.getInstance(TRANSFORMATION);     // Catch: Throwable -> L9
        this.mEncryptCipher.init(1, this.mSecretKey);     // Catch: Throwable -> L9
        this.mDecryptCipher = Cipher.getInstance(TRANSFORMATION);     // Catch: Throwable -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
        return;
    L5:
        this.mPreSharedKey = Arrays.copyOf(preSharedKey, 32);
        goto L6
    }

    public byte[] encrypt(byte[] input) {
    L8:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
        return null;
    L4:
        if (this.mEncryptCipher != null) goto L6;
        return null;
    L6:
        byte[] encryptedBytes = this.mEncryptCipher.doFinal(input);     // Catch: Throwable -> L8
        ByteBuffer buffer = ByteBuffer.allocate(((this.mEncryptCipher.getIV().length + 4) + 4) + encryptedBytes.length).putInt(this.mEncryptCipher.getIV().length).put(this.mEncryptCipher.getIV()).putInt(encryptedBytes.length).put(encryptedBytes);     // Catch: Throwable -> L8
        return buffer.array();
    }

    public byte[] decrypt(byte[] input) {
        ByteBuffer buffer = ByteBuffer.wrap(input);
        byte[] iv = new byte[buffer.getInt()];
        buffer.get(iv);
        byte[] encryptedBytes = new byte[buffer.getInt()];
        buffer.get(encryptedBytes);
        this.mDecryptCipher.init(2, getKey(), new IvParameterSpec(iv));     // Catch: Throwable -> L5
        return this.mDecryptCipher.doFinal(encryptedBytes);
    L5:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
        return null;
    }

    private SecretKey getKey() {
        if (this.mSecretKey != null) goto L5;
        this.mSecretKey = new SecretKeySpec(this.mPreSharedKey, ALGORITHM);
        return this.mSecretKey;
    L5:
        return this.mSecretKey;
    }
}
