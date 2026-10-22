package com.android.server.locksettings.recoverablekeystore;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.RemoteException;
import android.security.GateKeeper;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProtection;
import android.service.gatekeeper.IGateKeeperService;
import android.util.Log;
import com.android.server.locksettings.recoverablekeystore.storage.RecoverableKeyStoreDb;
import com.android.server.slice.SliceClientPermissions;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformKeyManager {
    private static final String DECRYPT_KEY_ALIAS_SUFFIX = "decrypt";
    private static final String ENCRYPT_KEY_ALIAS_SUFFIX = "encrypt";
    private static final byte[] GCM_INSECURE_NONCE_BYTES = null;
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final String KEY_ALGORITHM = "AES";
    private static final String KEY_ALIAS_PREFIX = "com.android.server.locksettings.recoverablekeystore/platform/";
    private static final int KEY_SIZE_BITS = 256;
    private static final String KEY_WRAP_CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    static final int MIN_GENERATION_ID_FOR_UNLOCKED_DEVICE_REQUIRED = 1001000;
    private static final String TAG = "PlatformKeyManager";
    private final Context mContext;
    private final RecoverableKeyStoreDb mDatabase;
    private final KeyStoreProxy mKeyStore;

    static {
        GCM_INSECURE_NONCE_BYTES = new byte[12];
    }

    public static PlatformKeyManager getInstance(Context context, RecoverableKeyStoreDb database) throws KeyStoreException, NoSuchAlgorithmException {
        return new PlatformKeyManager(context.getApplicationContext(), new KeyStoreProxyImpl(getAndLoadAndroidKeyStore()), database);
    }

    PlatformKeyManager(Context context, KeyStoreProxy keyStore, RecoverableKeyStoreDb database) {
        this.mKeyStore = keyStore;
        this.mContext = context;
        this.mDatabase = database;
    }

    public int getGenerationId(int userId) {
        return this.mDatabase.getPlatformKeyGenerationId(userId);
    }

    public boolean isDeviceLocked(int userId) {
        return ((KeyguardManager) this.mContext.getSystemService(KeyguardManager.class)).isDeviceLocked(userId);
    }

    public void invalidatePlatformKey(int userId, int generationId) {
        if (generationId == (-1)) goto L10;
        this.mKeyStore.deleteEntry(getEncryptAlias(userId, generationId));     // Catch: KeyStoreException -> L6
        this.mKeyStore.deleteEntry(getDecryptAlias(userId, generationId));     // Catch: KeyStoreException -> L6
        return;
    L7:
        return;
    }

    void regenerate(int userId) throws NoSuchAlgorithmException, KeyStoreException, IOException, RemoteException, InsecureUserException {
        int generationId = getGenerationId(userId);
        if (generationId != (-1)) goto L5;
        int nextId = 1;
    L6:
        generateAndLoadKey(userId, nextId);
        return;
    L5:
        invalidatePlatformKey(userId, generationId);
        nextId = generationId + 1;
        goto L6
    }

    public PlatformEncryptionKey getEncryptKey(int userId) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, RemoteException, InsecureUserException {
        init(userId);
        getDecryptKeyInternal(userId);     // Catch: UnrecoverableKeyException -> L5
        return getEncryptKeyInternal(userId);
    L6:
        Log.i(TAG, String.format(Locale.US, "Regenerating permanently invalid Platform key for user %d.", new Object[]{Integer.valueOf(userId)}));
        regenerate(userId);
        return getEncryptKeyInternal(userId);
    }

    private PlatformEncryptionKey getEncryptKeyInternal(int userId) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        int generationId = getGenerationId(userId);
        String alias = getEncryptAlias(userId, generationId);
        if (isKeyLoaded(userId, generationId) == false) goto L7;
        SecretKey key = (SecretKey) this.mKeyStore.getKey(alias, null);
        return new PlatformEncryptionKey(generationId, key);
    L7:
        throw new UnrecoverableKeyException("KeyStore doesn't contain key " + alias);
    }

    public PlatformDecryptionKey getDecryptKey(int userId) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, InsecureUserException, RemoteException {
        init(userId);
        PlatformDecryptionKey decryptionKey = getDecryptKeyInternal(userId);     // Catch: UnrecoverableKeyException -> L5
        ensureDecryptionKeyIsValid(userId, decryptionKey);     // Catch: UnrecoverableKeyException -> L5
        return decryptionKey;
    L6:
        Log.i(TAG, String.format(Locale.US, "Regenerating permanently invalid Platform key for user %d.", new Object[]{Integer.valueOf(userId)}));
        regenerate(userId);
        return getDecryptKeyInternal(userId);
    }

    private PlatformDecryptionKey getDecryptKeyInternal(int userId) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException {
        int generationId = getGenerationId(userId);
        String alias = getDecryptAlias(userId, generationId);
        if (isKeyLoaded(userId, generationId) == false) goto L7;
        SecretKey key = (SecretKey) this.mKeyStore.getKey(alias, null);
        return new PlatformDecryptionKey(generationId, key);
    L7:
        throw new UnrecoverableKeyException("KeyStore doesn't contain key " + alias);
    }

    private void ensureDecryptionKeyIsValid(int userId, PlatformDecryptionKey decryptionKey) throws UnrecoverableKeyException {
        Cipher.getInstance(KEY_WRAP_CIPHER_ALGORITHM).init(4, decryptionKey.getKey(), new GCMParameterSpec(128, GCM_INSECURE_NONCE_BYTES));     // Catch: Throwable -> L4 KeyPermanentlyInvalidatedException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, String.format(Locale.US, "The platform key for user %d became invalid.", new Object[]{Integer.valueOf(userId)}));
        throw new UnrecoverableKeyException(e.getMessage());
    }

    void init(int userId) throws KeyStoreException, NoSuchAlgorithmException, IOException, RemoteException, InsecureUserException {
        int generationId = getGenerationId(userId);
        if (isKeyLoaded(userId, generationId) == false) goto L7;
        Log.i(TAG, String.format(Locale.US, "Platform key generation %d exists already.", new Object[]{Integer.valueOf(generationId)}));
        return;
    L7:
        if (generationId != (-1)) goto L9;
        Log.i(TAG, "Generating initial platform key generation ID.");
        int generationId2 = 1;
    L10:
        generateAndLoadKey(userId, Math.max(generationId2, MIN_GENERATION_ID_FOR_UNLOCKED_DEVICE_REQUIRED));
        return;
    L9:
        Log.w(TAG, String.format(Locale.US, "Platform generation ID was %d but no entry was present in AndroidKeyStore. Generating fresh key.", new Object[]{Integer.valueOf(generationId)}));
        generationId2 = generationId + 1;
        goto L10
    }

    private String getEncryptAlias(int userId, int generationId) {
        return KEY_ALIAS_PREFIX + userId + SliceClientPermissions.SliceAuthority.DELIMITER + generationId + SliceClientPermissions.SliceAuthority.DELIMITER + ENCRYPT_KEY_ALIAS_SUFFIX;
    }

    private String getDecryptAlias(int userId, int generationId) {
        return KEY_ALIAS_PREFIX + userId + SliceClientPermissions.SliceAuthority.DELIMITER + generationId + SliceClientPermissions.SliceAuthority.DELIMITER + DECRYPT_KEY_ALIAS_SUFFIX;
    }

    private void setGenerationId(int userId, int generationId) throws IOException {
        this.mDatabase.setPlatformKeyGenerationId(userId, generationId);
    }

    private boolean isKeyLoaded(int userId, int generationId) throws KeyStoreException {
        if (this.mKeyStore.containsAlias(getEncryptAlias(userId, generationId)) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mKeyStore.containsAlias(getDecryptAlias(userId, generationId)) == false) goto L7;
        return true;
    }

    IGateKeeperService getGateKeeperService() {
        return GateKeeper.getService();
    }

    private void generateAndLoadKey(int userId, int generationId) throws NoSuchAlgorithmException, KeyStoreException, IOException, RemoteException, InsecureUserException {
        String encryptAlias = getEncryptAlias(userId, generationId);
        String decryptAlias = getDecryptAlias(userId, generationId);
        SecretKey secretKey = generateAesKey();
        KeyProtection.Builder decryptionKeyProtection = new KeyProtection.Builder(2).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"});
        if (userId != 0) goto L14;
        decryptionKeyProtection.setUnlockedDeviceRequired(true);
    L14:
        this.mKeyStore.setEntry(decryptAlias, new KeyStore.SecretKeyEntry(secretKey), decryptionKeyProtection.build());     // Catch: KeyStoreException -> L8
        this.mKeyStore.setEntry(encryptAlias, new KeyStore.SecretKeyEntry(secretKey), new KeyProtection.Builder(1).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());     // Catch: KeyStoreException -> L8
        setGenerationId(userId, generationId);
        return;
    L8:
        e = move-exception;
        if (isDeviceSecure(userId) == false) goto L12;
        throw e;
    L12:
        throw new InsecureUserException("Screenlock is not set");
    }

    private static SecretKey generateAesKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    private static KeyStore getAndLoadAndroidKeyStore() throws KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance(KeyStoreProxyImpl.ANDROID_KEY_STORE_PROVIDER);
        keyStore.load(null);     // Catch: Throwable -> L5
        return keyStore;
    L5:
        e = move-exception;
        throw new KeyStoreException("Unable to load keystore.", e);
    }

    private boolean isDeviceSecure(int userId) {
        return ((KeyguardManager) this.mContext.getSystemService(KeyguardManager.class)).isDeviceSecure(userId);
    }
}
