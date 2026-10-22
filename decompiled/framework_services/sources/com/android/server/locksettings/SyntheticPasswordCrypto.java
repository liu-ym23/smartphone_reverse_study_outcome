package com.android.server.locksettings;

import android.security.AndroidKeyStoreMaintenance;
import android.security.keystore.KeyProtection;
import android.security.keystore2.AndroidKeyStoreLoadStoreParameter;
import android.system.keystore2.KeyDescriptor;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.locksettings.recoverablekeystore.KeyStoreProxyImpl;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
class SyntheticPasswordCrypto {
    private static final int AES_GCM_IV_SIZE = 12;
    private static final int AES_GCM_KEY_SIZE = 32;
    private static final int AES_GCM_TAG_SIZE = 16;
    private static final byte[] PROTECTOR_SECRET_PERSONALIZATION = null;
    private static final String TAG = "SyntheticPasswordCrypto";
    private static final int USER_AUTHENTICATION_VALIDITY = 15;

    SyntheticPasswordCrypto() {
    }

    static {
        PROTECTOR_SECRET_PERSONALIZATION = "application-id".getBytes();
    }

    private static byte[] decrypt(SecretKey key, byte[] blob) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (blob != null) goto L5;
        return null;
    L5:
        byte[] iv = Arrays.copyOfRange(blob, 0, 12);
        byte[] ciphertext = Arrays.copyOfRange(blob, 12, blob.length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, key, new GCMParameterSpec(128, iv));
        return cipher.doFinal(ciphertext);
    }

    private static byte[] encrypt(SecretKey key, byte[] blob) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidParameterSpecException {
        if (blob != null) goto L5;
        return null;
    L5:
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, key);
        byte[] ciphertext = cipher.doFinal(blob);
        byte[] iv = cipher.getIV();
        if (iv.length != 12) goto L14;
        GCMParameterSpec spec = (GCMParameterSpec) cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
        if (spec.getTLen() != 128) goto L12;
        return ArrayUtils.concat(new byte[][]{iv, ciphertext});
    L12:
        throw new IllegalArgumentException("Invalid tag length: " + spec.getTLen() + " bits");
    L14:
        throw new IllegalArgumentException("Invalid iv length: " + iv.length + " bytes");
    }

    public static byte[] encrypt(byte[] keyBytes, byte[] personalization, byte[] message) {
        byte[] keyHash = personalizedHash(personalization, new byte[][]{keyBytes});
        SecretKeySpec key = new SecretKeySpec(Arrays.copyOf(keyHash, 32), "AES");
        return encrypt(key, message);
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to encrypt", e);
        return null;
    }

    public static byte[] decrypt(byte[] keyBytes, byte[] personalization, byte[] ciphertext) {
        byte[] keyHash = personalizedHash(personalization, new byte[][]{keyBytes});
        SecretKeySpec key = new SecretKeySpec(Arrays.copyOf(keyHash, 32), "AES");
        return decrypt(key, ciphertext);
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to decrypt", e);
        return null;
    }

    public static byte[] decryptBlobV1(String protectorKeyAlias, byte[] blob, byte[] protectorSecret) {
        KeyStore keyStore = getKeyStore();     // Catch: Exception -> L6
        SecretKey protectorKey = (SecretKey) keyStore.getKey(protectorKeyAlias, null);     // Catch: Exception -> L6
        if (protectorKey == null) goto L9;
        byte[] intermediate = decrypt(protectorSecret, PROTECTOR_SECRET_PERSONALIZATION, blob);     // Catch: Exception -> L6
        return decrypt(protectorKey, intermediate);
    L9:
        throw new IllegalStateException("SP protector key is missing: " + protectorKeyAlias);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to decrypt V1 blob", e);
        throw new IllegalStateException("Failed to decrypt blob", e);
    }

    static String androidKeystoreProviderName() {
        return KeyStoreProxyImpl.ANDROID_KEY_STORE_PROVIDER;
    }

    static int keyNamespace() {
        return 103;
    }

    private static KeyStore getKeyStore() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        KeyStore keyStore = KeyStore.getInstance(androidKeystoreProviderName());
        keyStore.load(new AndroidKeyStoreLoadStoreParameter(keyNamespace()));
        return keyStore;
    }

    public static byte[] decryptBlob(String protectorKeyAlias, byte[] blob, byte[] protectorSecret) {
        KeyStore keyStore = getKeyStore();     // Catch: Throwable -> L6
        SecretKey protectorKey = (SecretKey) keyStore.getKey(protectorKeyAlias, null);     // Catch: Throwable -> L6
        if (protectorKey == null) goto L9;
        byte[] intermediate = decrypt(protectorKey, blob);     // Catch: Throwable -> L6
        return decrypt(protectorSecret, PROTECTOR_SECRET_PERSONALIZATION, intermediate);
    L9:
        throw new IllegalStateException("SP protector key is missing: " + protectorKeyAlias);     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to decrypt blob", e);
        throw new IllegalStateException("Failed to decrypt blob", e);
    }

    public static byte[] createBlob(String protectorKeyAlias, byte[] data, byte[] protectorSecret, long sid) {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L6
        keyGenerator.init(256, new SecureRandom());     // Catch: Throwable -> L6
        SecretKey protectorKey = keyGenerator.generateKey();     // Catch: Throwable -> L6
        KeyStore keyStore = getKeyStore();     // Catch: Throwable -> L6
        KeyProtection.Builder builder = new KeyProtection.Builder(2).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setCriticalToDeviceEncryption(true);     // Catch: Throwable -> L6
        if (sid == 0) goto L8;
        builder.setUserAuthenticationRequired(true).setBoundToSpecificSecureUserId(sid).setUserAuthenticationValidityDurationSeconds(15);     // Catch: Throwable -> L6
    L8:
        KeyProtection protNonRollbackResistant = builder.build();     // Catch: Throwable -> L6
        builder.setRollbackResistant(true);     // Catch: Throwable -> L6
        KeyProtection protRollbackResistant = builder.build();     // Catch: Throwable -> L6
        KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(protectorKey);     // Catch: Throwable -> L6
        keyStore.setEntry(protectorKeyAlias, entry, protRollbackResistant);     // Catch: Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 KeyStoreException -> L11
        Slog.i(TAG, "Using rollback-resistant key");     // Catch: Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 KeyStoreException -> L11
    L13:
        byte[] intermediate = encrypt(protectorSecret, PROTECTOR_SECRET_PERSONALIZATION, data);     // Catch: Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6
        return encrypt(protectorKey, intermediate);
    L12:
        Slog.w(TAG, "Rollback-resistant keys unavailable.  Falling back to non-rollback-resistant key");     // Catch: Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6
        keyStore.setEntry(protectorKeyAlias, entry, protNonRollbackResistant);     // Catch: Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6 Throwable -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to create blob", e);
        throw new IllegalStateException("Failed to encrypt blob", e);
    }

    public static void destroyProtectorKey(String keyAlias) {
        KeyStore keyStore = getKeyStore();     // Catch: Throwable -> L5
        keyStore.deleteEntry(keyAlias);     // Catch: Throwable -> L5
        Slog.i(TAG, "Deleted SP protector key " + keyAlias);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to delete SP protector key " + keyAlias, e);
    }

    protected static byte[] personalizedHash(byte[] personalization, byte[]... message) {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");     // Catch: NoSuchAlgorithmException -> L8
        if (personalization.length > 128) goto L13;
        digest.update(Arrays.copyOf(personalization, 128));     // Catch: NoSuchAlgorithmException -> L8
        int r2 = message.length;     // Catch: NoSuchAlgorithmException -> L8
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        byte[] data = message[r3];     // Catch: NoSuchAlgorithmException -> L8
        digest.update(data);     // Catch: NoSuchAlgorithmException -> L8
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L8
        goto L6
    L11:
        return digest.digest();
    L13:
        throw new IllegalArgumentException("Personalization too long");     // Catch: NoSuchAlgorithmException -> L8
    L8:
        e = move-exception;
        throw new IllegalStateException("NoSuchAlgorithmException for SHA-512", e);
    }

    static boolean migrateLockSettingsKey(String alias) {
        KeyDescriptor legacyKey = new KeyDescriptor();
        legacyKey.domain = 0;
        legacyKey.nspace = -1;
        legacyKey.alias = alias;
        KeyDescriptor newKey = new KeyDescriptor();
        newKey.domain = 2;
        newKey.nspace = keyNamespace();
        newKey.alias = alias;
        Slog.i(TAG, "Migrating key " + alias);
        int err = AndroidKeyStoreMaintenance.migrateKeyNamespace(legacyKey, newKey);
        if (err != 0) goto L6;
        return true;
    L6:
        if (err != 7) goto L10;
        Slog.i(TAG, "Key does not exist");
        return true;
    L10:
        if (err != 20) goto L13;
        Slog.i(TAG, "Key already exists");
        return true;
    L13:
        Slog.e(TAG, TextUtils.formatSimple("Failed to migrate key: %d", new Object[]{Integer.valueOf(err)}));
        return false;
    }
}
