package com.android.server.locksettings;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.UserNotAuthenticatedException;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class UnifiedProfilePasswordCache {
    private static final int CACHE_TIMEOUT_SECONDS = 0;
    private static final int KEY_LENGTH = 256;
    private static final String TAG = "UnifiedProfilePasswordCache";
    private final SparseArray<byte[]> mEncryptedPasswords;
    private final KeyStore mKeyStore;

    static {
        CACHE_TIMEOUT_SECONDS = (int) TimeUnit.DAYS.toSeconds(7);
    }

    public UnifiedProfilePasswordCache(KeyStore keyStore) {
        this.mEncryptedPasswords = new SparseArray();
        this.mKeyStore = keyStore;
    }

    public void storePassword(int userId, LockscreenCredential password, long parentSid) {
        if (parentSid != 0) goto L5;
        return;
    L5:
        SparseArray<byte[]> r0 = this.mEncryptedPasswords;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mEncryptedPasswords.contains(userId) == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        String keyName = getEncryptionKeyName(userId);     // Catch: Throwable -> L11
        KeyGenerator generator = KeyGenerator.getInstance("AES", this.mKeyStore.getProvider());     // Catch: Throwable -> L11 GeneralSecurityException -> L21
        generator.init(new KeyGenParameterSpec.Builder(keyName, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setNamespace(SyntheticPasswordCrypto.keyNamespace()).setEncryptionPaddings(new String[]{"NoPadding"}).setUserAuthenticationRequired(true).setBoundToSpecificSecureUserId(parentSid).setUserAuthenticationValidityDurationSeconds(CACHE_TIMEOUT_SECONDS).build());     // Catch: Throwable -> L11 GeneralSecurityException -> L21
        SecretKey key = generator.generateKey();     // Catch: Throwable -> L11 GeneralSecurityException -> L21
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Throwable -> L11 GeneralSecurityException -> L17
        cipher.init(1, key);     // Catch: Throwable -> L11 GeneralSecurityException -> L17
        byte[] ciphertext = cipher.doFinal(password.getCredential());     // Catch: Throwable -> L11 GeneralSecurityException -> L17
        byte[] iv = cipher.getIV();     // Catch: Throwable -> L11 GeneralSecurityException -> L17
        byte[] block = ArrayUtils.concat(new byte[][]{iv, ciphertext});     // Catch: Throwable -> L11 GeneralSecurityException -> L17
        this.mEncryptedPasswords.put(userId, block);     // Catch: Throwable -> L11 GeneralSecurityException -> L17
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L17:
        e = move-exception;
        Slog.d(TAG, "Cannot encrypt", e);     // Catch: Throwable -> L11
        goto L19
    L21:
        e = move-exception;
        Slog.e(TAG, "Cannot generate key", e);     // Catch: Throwable -> L11
    }

    public LockscreenCredential retrievePassword(int userId) {
        SparseArray<byte[]> r0 = this.mEncryptedPasswords;
        monitor-enter(r0);
        byte[] block = this.mEncryptedPasswords.get(userId);     // Catch: Throwable -> L8
        if (block != null) goto L36;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L36:
        Key key = this.mKeyStore.getKey(getEncryptionKeyName(userId), null);     // Catch: Throwable -> L8 Throwable -> L29
        if (key != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L14:
        byte[] iv = Arrays.copyOf(block, 12);     // Catch: Throwable -> L8
        byte[] ciphertext = Arrays.copyOfRange(block, 12, block.length);     // Catch: Throwable -> L8
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Throwable -> L8 GeneralSecurityException -> L19 UserNotAuthenticatedException -> L21
        cipher.init(2, key, new GCMParameterSpec(128, iv));     // Catch: Throwable -> L8 GeneralSecurityException -> L19 UserNotAuthenticatedException -> L21
        byte[] credential = cipher.doFinal(ciphertext);     // Catch: Throwable -> L8 GeneralSecurityException -> L19 UserNotAuthenticatedException -> L21
        LockscreenCredential result = LockscreenCredential.createUnifiedProfilePassword(credential);     // Catch: Throwable -> L8
        LockPatternUtils.zeroize(credential);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return result;
    L19:
        e = move-exception;
        Slog.d(TAG, "Cannot decrypt", e);     // Catch: Throwable -> L8
        return null;
    L26:
        Slog.i(TAG, "Device not unlocked for more than 7 days");     // Catch: Throwable -> L8
        return null;
    L29:
        e = move-exception;
        Slog.d(TAG, "Cannot get key", e);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public void removePassword(int userId) {
        SparseArray<byte[]> r0 = this.mEncryptedPasswords;
        monitor-enter(r0);
        String keyName = getEncryptionKeyName(userId);     // Catch: Throwable -> L8
        String legacyKeyName = getLegacyEncryptionKeyName(userId);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        Slog.d(TAG, "Cannot delete key", e);     // Catch: Throwable -> L8
    L19:
        if (this.mEncryptedPasswords.contains(userId) == false) goto L21;
        LockPatternUtils.zeroize(this.mEncryptedPasswords.get(userId));     // Catch: Throwable -> L8
        this.mEncryptedPasswords.remove(userId);     // Catch: Throwable -> L8
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L6:
        if (this.mKeyStore.containsAlias(keyName) == false) goto L13;
        this.mKeyStore.deleteEntry(keyName);     // Catch: Throwable -> L8 KeyStoreException -> L10
    L13:
        if (this.mKeyStore.containsAlias(legacyKeyName) == false) goto L19;
        this.mKeyStore.deleteEntry(legacyKeyName);     // Catch: Throwable -> L8 KeyStoreException -> L10
    L8:
        th = move-exception;
        throw th;
    }

    private static String getEncryptionKeyName(int userId) {
        return "com.android.server.locksettings.unified_profile_cache_v2_" + userId;
    }

    private static String getLegacyEncryptionKeyName(int userId) {
        return "com.android.server.locksettings.unified_profile_cache_" + userId;
    }
}
