package com.android.server.locksettings;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
class AesEncryptionUtil {
    private static final String CIPHER_ALGO = "AES/GCM/NoPadding";

    private AesEncryptionUtil() {
    }

    static byte[] decrypt(SecretKey key, DataInputStream cipherStream) throws IOException {
        key.getClass();
        cipherStream.getClass();
        int ivSize = cipherStream.readInt();
        if (ivSize < 0) goto L17;
        if (ivSize > 32) goto L17;
        byte[] iv = new byte[ivSize];
        cipherStream.readFully(iv);
        int rawCipherTextSize = cipherStream.readInt();
        if (rawCipherTextSize < 0) goto L15;
        byte[] rawCipherText = new byte[rawCipherTextSize];
        cipherStream.readFully(rawCipherText);
        Cipher c = Cipher.getInstance(CIPHER_ALGO);     // Catch: Throwable -> L11
        c.init(2, key, new GCMParameterSpec(128, iv));     // Catch: Throwable -> L11
        byte[] plainText = c.doFinal(rawCipherText);     // Catch: Throwable -> L11
        return plainText;
    L11:
        e = move-exception;
        throw new IOException("Could not decrypt cipher text", e);
    L15:
        throw new IOException("Invalid cipher text size: " + rawCipherTextSize);
    L17:
        throw new IOException("IV out of range: " + ivSize);
    }

    static byte[] decrypt(SecretKey key, byte[] cipherText) throws IOException {
        key.getClass();
        cipherText.getClass();
        DataInputStream cipherStream = new DataInputStream(new ByteArrayInputStream(cipherText));
        return decrypt(key, cipherStream);
    }

    static byte[] encrypt(SecretKey key, byte[] plainText) throws IOException {
        key.getClass();
        plainText.getClass();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGO);     // Catch: Throwable -> L6
        cipher.init(1, key);     // Catch: Throwable -> L6
        byte[] cipherText = cipher.doFinal(plainText);     // Catch: Throwable -> L6
        byte[] iv = cipher.getIV();     // Catch: Throwable -> L6
        dos.writeInt(iv.length);
        dos.write(iv);
        dos.writeInt(cipherText.length);
        dos.write(cipherText);
        return bos.toByteArray();
    L6:
        e = move-exception;
        throw new IOException("Could not encrypt input data", e);
    }
}
