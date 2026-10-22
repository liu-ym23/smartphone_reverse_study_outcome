package com.android.server.locksettings;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore2.AndroidKeyStoreLoadStoreParameter;
import android.util.Slog;
import com.android.server.locksettings.recoverablekeystore.KeyStoreProxyImpl;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class RebootEscrowKeyStoreManager {
    private static final String ANDROID_KEY_STORE_PROVIDER = "AndroidKeystore";
    public static final int KEY_LENGTH = 256;
    private static final int KEY_STORE_NAMESPACE = 120;
    public static final String REBOOT_ESCROW_KEY_STORE_ENCRYPTION_KEY_NAME = "reboot_escrow_key_store_encryption_key";
    private static final String TAG = "RebootEscrowKeyStoreManager";
    private final Object mKeyStoreLock;

    public RebootEscrowKeyStoreManager() {
        this.mKeyStoreLock = new Object();
    }

    private SecretKey getKeyStoreEncryptionKeyLocked() {
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_PROVIDER);     // Catch: Throwable -> L5
        keyStore.load(new AndroidKeyStoreLoadStoreParameter(120));     // Catch: Throwable -> L5
        return (SecretKey) keyStore.getKey(REBOOT_ESCROW_KEY_STORE_ENCRYPTION_KEY_NAME, null);
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to get encryption key from keystore.", e);
        return null;
    }

    protected SecretKey getKeyStoreEncryptionKey() {
        Object r0 = this.mKeyStoreLock;
        monitor-enter(r0);
        SecretKey r1 = getKeyStoreEncryptionKeyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected void clearKeyStoreEncryptionKey() {
        Object r0 = this.mKeyStoreLock;
        monitor-enter(r0);
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_PROVIDER);     // Catch: Throwable -> L6 Throwable -> L8
        keyStore.load(new AndroidKeyStoreLoadStoreParameter(120));     // Catch: Throwable -> L6 Throwable -> L8
        keyStore.deleteEntry(REBOOT_ESCROW_KEY_STORE_ENCRYPTION_KEY_NAME);     // Catch: Throwable -> L6 Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Unable to delete encryption key in keystore.", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    protected SecretKey generateKeyStoreEncryptionKeyIfNeeded() {
        Object r0 = this.mKeyStoreLock;
        monitor-enter(r0);
        SecretKey kk = getKeyStoreEncryptionKeyLocked();     // Catch: Throwable -> L8
        if (kk == null) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return kk;
    L21:
        KeyGenerator generator = KeyGenerator.getInstance("AES", KeyStoreProxyImpl.ANDROID_KEY_STORE_PROVIDER);     // Catch: Throwable -> L8 GeneralSecurityException -> L13
        KeyGenParameterSpec.Builder parameterSpecBuilder = new KeyGenParameterSpec.Builder(REBOOT_ESCROW_KEY_STORE_ENCRYPTION_KEY_NAME, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"});     // Catch: Throwable -> L8 GeneralSecurityException -> L13
        parameterSpecBuilder.setNamespace(120);     // Catch: Throwable -> L8 GeneralSecurityException -> L13
        generator.init(parameterSpecBuilder.build());     // Catch: Throwable -> L8 GeneralSecurityException -> L13
        SecretKey r4 = generator.generateKey();     // Catch: Throwable -> L8 GeneralSecurityException -> L13
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r4;
    L13:
        e = move-exception;
        Slog.e(TAG, "Unable to generate key from keystore.", e);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }
}
