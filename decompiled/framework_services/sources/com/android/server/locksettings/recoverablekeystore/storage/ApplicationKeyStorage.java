package com.android.server.locksettings.recoverablekeystore.storage;

import android.os.ServiceSpecificException;
import android.security.KeyStore2;
import android.security.keystore.KeyProtection;
import android.system.keystore2.KeyDescriptor;
import android.util.Log;
import com.android.server.locksettings.recoverablekeystore.KeyStoreProxy;
import com.android.server.locksettings.recoverablekeystore.KeyStoreProxyImpl;
import com.android.server.slice.SliceClientPermissions;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Locale;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationKeyStorage {
    private static final String APPLICATION_KEY_ALIAS_PREFIX = "com.android.server.locksettings.recoverablekeystore/application/";
    private static final String APPLICATION_KEY_GRANT_PREFIX = "recoverable_key:";
    private static final String TAG = "RecoverableAppKeyStore";
    private final KeyStoreProxy mKeyStore;

    public static ApplicationKeyStorage getInstance() throws KeyStoreException {
        return new ApplicationKeyStorage(new KeyStoreProxyImpl(KeyStoreProxyImpl.getAndLoadAndroidKeyStore()));
    }

    ApplicationKeyStorage(KeyStoreProxy keyStore) {
        this.mKeyStore = keyStore;
    }

    public String getGrantAlias(int userId, int uid, String alias) {
        Log.i(TAG, String.format(Locale.US, "Get %d/%d/%s", new Object[]{Integer.valueOf(userId), Integer.valueOf(uid), alias}));
        String keystoreAlias = getInternalAlias(userId, uid, alias);
        return makeKeystoreEngineGrantString(uid, keystoreAlias);
    }

    public void setSymmetricKeyEntry(int userId, int uid, String alias, byte[] secretKey) throws KeyStoreException {
        Log.i(TAG, String.format(Locale.US, "Set %d/%d/%s: %d bytes of key material", new Object[]{Integer.valueOf(userId), Integer.valueOf(uid), alias, Integer.valueOf(secretKey.length)}));
        this.mKeyStore.setEntry(getInternalAlias(userId, uid, alias), new KeyStore.SecretKeyEntry(new SecretKeySpec(secretKey, "AES")), new KeyProtection.Builder(3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());     // Catch: KeyStoreException -> L5
        return;
    L5:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());
    }

    public void deleteEntry(int userId, int uid, String alias) {
        Log.i(TAG, String.format(Locale.US, "Del %d/%d/%s", new Object[]{Integer.valueOf(userId), Integer.valueOf(uid), alias}));
        this.mKeyStore.deleteEntry(getInternalAlias(userId, uid, alias));     // Catch: KeyStoreException -> L5
        return;
    L5:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());
    }

    private String getInternalAlias(int userId, int uid, String alias) {
        return APPLICATION_KEY_ALIAS_PREFIX + userId + SliceClientPermissions.SliceAuthority.DELIMITER + uid + SliceClientPermissions.SliceAuthority.DELIMITER + alias;
    }

    private String makeKeystoreEngineGrantString(int uid, String alias) {
        if (alias != null) goto L5;
        return null;
    L5:
        KeyDescriptor key = new KeyDescriptor();
        key.domain = 0;
        key.nspace = -1;
        key.alias = alias;
        key.blob = null;
        return String.format("%s%016X", new Object[]{APPLICATION_KEY_GRANT_PREFIX, Long.valueOf(KeyStore2.getInstance().grant(key, uid, 261).nspace)});
    L9:
        e = move-exception;
        if (e.getNumericErrorCode() != 6) goto L14;
        Log.w(TAG, "Failed to get grant for KeyStore key - key not found");
        throw new ServiceSpecificException(30, e.getMessage());
    L14:
        Log.e(TAG, "Failed to get grant for KeyStore key.", e);
        throw new ServiceSpecificException(22, e.getMessage());
    }
}
