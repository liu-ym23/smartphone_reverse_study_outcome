package com.android.server.locksettings.recoverablekeystore;

import android.content.Context;
import android.os.RemoteException;
import android.security.Scrypt;
import android.security.keystore.recovery.KeyChainProtectionParams;
import android.security.keystore.recovery.KeyChainSnapshot;
import android.security.keystore.recovery.KeyDerivationParams;
import android.security.keystore.recovery.WrappedApplicationKey;
import android.util.Log;
import android.util.Pair;
import com.android.internal.util.ArrayUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.server.locksettings.recoverablekeystore.storage.RecoverableKeyStoreDb;
import com.android.server.locksettings.recoverablekeystore.storage.RecoverySnapshotStorage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class KeySyncTask implements Runnable {
    private static final int LENGTH_PREFIX_BYTES = 4;
    private static final String LOCK_SCREEN_HASH_ALGORITHM = "SHA-256";
    private static final String RECOVERY_KEY_ALGORITHM = "AES";
    private static final int RECOVERY_KEY_SIZE_BITS = 256;
    private static final int SALT_LENGTH_BYTES = 16;
    static final int SCRYPT_PARAM_N = 4096;
    static final int SCRYPT_PARAM_OUTLEN_BYTES = 32;
    static final int SCRYPT_PARAM_P = 1;
    static final int SCRYPT_PARAM_R = 8;
    private static final String TAG = "KeySyncTask";
    private static final int TRUSTED_HARDWARE_MAX_ATTEMPTS = 10;
    private final byte[] mCredential;
    private final int mCredentialType;
    private final boolean mCredentialUpdated;
    private final PlatformKeyManager mPlatformKeyManager;
    private final RecoverableKeyStoreDb mRecoverableKeyStoreDb;
    private final RecoverySnapshotStorage mRecoverySnapshotStorage;
    private final Scrypt mScrypt;
    private final RecoverySnapshotListenersStorage mSnapshotListenersStorage;
    private final TestOnlyInsecureCertificateHelper mTestOnlyInsecureCertificateHelper;
    private final int mUserId;

    public static KeySyncTask newInstance(Context context, RecoverableKeyStoreDb recoverableKeyStoreDb, RecoverySnapshotStorage snapshotStorage, RecoverySnapshotListenersStorage recoverySnapshotListenersStorage, int userId, int credentialType, byte[] credential, boolean credentialUpdated) throws NoSuchAlgorithmException, KeyStoreException, InsecureUserException {
        return new KeySyncTask(recoverableKeyStoreDb, snapshotStorage, recoverySnapshotListenersStorage, userId, credentialType, credential, credentialUpdated, PlatformKeyManager.getInstance(context, recoverableKeyStoreDb), new TestOnlyInsecureCertificateHelper(), new Scrypt());
    }

    KeySyncTask(RecoverableKeyStoreDb recoverableKeyStoreDb, RecoverySnapshotStorage snapshotStorage, RecoverySnapshotListenersStorage recoverySnapshotListenersStorage, int userId, int credentialType, byte[] credential, boolean credentialUpdated, PlatformKeyManager platformKeyManager, TestOnlyInsecureCertificateHelper testOnlyInsecureCertificateHelper, Scrypt scrypt) {
        this.mSnapshotListenersStorage = recoverySnapshotListenersStorage;
        this.mRecoverableKeyStoreDb = recoverableKeyStoreDb;
        this.mUserId = userId;
        this.mCredentialType = credentialType;
        if (credential == null) goto L5;
        byte[] r0 = Arrays.copyOf(credential, credential.length);
    L6:
        this.mCredential = r0;
        this.mCredentialUpdated = credentialUpdated;
        this.mPlatformKeyManager = platformKeyManager;
        this.mRecoverySnapshotStorage = snapshotStorage;
        this.mTestOnlyInsecureCertificateHelper = testOnlyInsecureCertificateHelper;
        this.mScrypt = scrypt;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public void run() {
    L12:
        th = move-exception;
        if (this.mCredential == null) goto L23;
        LockPatternUtils.zeroize(this.mCredential);
    L23:
        throw th;
    L27:
        monitor-enter(KeySyncTask.class);     // Catch: Throwable -> L12 Exception -> L14
        syncKeys();     // Catch: Throwable -> L9
        monitor-exit(KeySyncTask.class);     // Catch: Throwable -> L9
        if (this.mCredential == null) goto L29;
        LockPatternUtils.zeroize(this.mCredential);
        return;
    L29:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12 Exception -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "Unexpected exception thrown during KeySyncTask", e);     // Catch: Throwable -> L12
        if (this.mCredential == null) goto L31;
        LockPatternUtils.zeroize(this.mCredential);
        return;
    }

    private void syncKeys() throws RemoteException {
        if (this.mCredential == null) goto L8;
        if (this.mCredential.length < 80) goto L8;
        Log.e(TAG, "Unexpected credential length for user " + this.mUserId);
    L8:
        if (this.mCredentialUpdated == true) goto L10;
    L12:
        int generation = this.mPlatformKeyManager.getGenerationId(this.mUserId);
        if (this.mCredentialType != (-1)) goto L19;
        Log.w(TAG, "Credentials are not set for user " + this.mUserId);
        if (generation >= 1001000) goto L49;
        this.mPlatformKeyManager.invalidatePlatformKey(this.mUserId, generation);
        return;
    L49:
        return;
    L19:
        if (isCustomLockScreen() == false) goto L25;
        Log.w(TAG, "Unsupported credential type " + this.mCredentialType + " for user " + this.mUserId);
        if (generation >= 1001000) goto L50;
        this.mRecoverableKeyStoreDb.invalidateKeysForUserIdOnCustomScreenLock(this.mUserId);
        return;
    L50:
        return;
    L25:
        if (this.mPlatformKeyManager.isDeviceLocked(this.mUserId) == true) goto L27;
    L30:
        List<Integer> recoveryAgents = this.mRecoverableKeyStoreDb.getRecoveryAgents(this.mUserId);
        Iterator<Integer> r3 = recoveryAgents.iterator();
    L32:
        if (r3.hasNext() == false) goto L40;
        int uid = r3.next().intValue();
        syncKeysForAgent(uid);     // Catch: IOException -> L36
    L36:
        e = move-exception;
        Log.e(TAG, "IOException during sync for agent " + uid, e);
        goto L32
    L40:
        if (recoveryAgents.isEmpty() == false) goto L51;
        Log.w(TAG, "No recovery agent initialized for user " + this.mUserId);
        return;
    L51:
        return;
    L27:
        if (this.mUserId != 0) goto L30;
        Log.w(TAG, "Can't sync keys for locked user " + this.mUserId);
        return;
    L10:
        if (this.mRecoverableKeyStoreDb.getBadRemoteGuessCounter(this.mUserId) == 0) goto L12;
        this.mRecoverableKeyStoreDb.setBadRemoteGuessCounter(this.mUserId, 0);
        goto L12
    }

    private boolean isCustomLockScreen() {
        if (this.mCredentialType != (-1)) goto L5;
    L11:
        return false;
    L5:
        if (this.mCredentialType == 1) goto L11;
        if (this.mCredentialType == 3) goto L11;
        if (this.mCredentialType == 4) goto L11;
        return true;
    }

    private void syncKeysForAgent(int recoveryAgentUid) throws IOException, RemoteException {
        if (shouldCreateSnapshot(recoveryAgentUid) == false) goto L5;
        boolean shouldRecreateCurrentVersion = false;
    L16:
        String rootCertAlias = this.mTestOnlyInsecureCertificateHelper.getDefaultCertificateAliasIfEmpty(this.mRecoverableKeyStoreDb.getActiveRootOfTrust(this.mUserId, recoveryAgentUid));
        CertPath certPath = this.mRecoverableKeyStoreDb.getRecoveryServiceCertPath(this.mUserId, recoveryAgentUid, rootCertAlias);
        if (certPath == null) goto L19;
        Log.d(TAG, "Using the public key in stored CertPath for syncing");
        PublicKey publicKey = certPath.getCertificates().get(0).getPublicKey();
    L20:
        if (publicKey != null) goto L23;
        Log.w(TAG, "Not initialized for KeySync: no public key set. Cancelling task.");
        return;
    L23:
        byte[] vaultHandle = this.mRecoverableKeyStoreDb.getServerParams(this.mUserId, recoveryAgentUid);
        if (vaultHandle != null) goto L28;
        Log.w(TAG, "No device ID set for user " + this.mUserId);
        return;
    L28:
        if (this.mTestOnlyInsecureCertificateHelper.isTestOnlyCertificateAlias(rootCertAlias) == false) goto L34;
        Log.w(TAG, "Insecure root certificate is used by recovery agent " + recoveryAgentUid);
        if (this.mTestOnlyInsecureCertificateHelper.doesCredentialSupportInsecureMode(this.mCredentialType, this.mCredential) == false) goto L32;
        Log.w(TAG, "Whitelisted credential is used to generate snapshot by recovery agent " + recoveryAgentUid);
        goto L34
    L32:
        Log.w(TAG, "Non whitelisted credential is used to generate recovery snapshot by " + recoveryAgentUid + " - ignore attempt.");
        return;
    L34:
        boolean useScryptToHashCredential = shouldUseScryptToHashCredential();
        byte[] salt = generateSalt();
        if (useScryptToHashCredential == false) goto L37;
        byte[] localLskfHash = hashCredentialsByScrypt(salt, this.mCredential);
    L97:
        Map<String, Pair<SecretKey, byte[]>> rawKeysWithMetadata = getKeysToSync(recoveryAgentUid);     // Catch: IOException -> L77 BadPlatformKeyException -> L80 InsecureUserException -> L83 GeneralSecurityException -> L86
    L40:
        if (this.mTestOnlyInsecureCertificateHelper.isTestOnlyCertificateAlias(rootCertAlias) == false) goto L42;
        Map<String, Pair<SecretKey, byte[]>> rawKeysWithMetadata2 = this.mTestOnlyInsecureCertificateHelper.keepOnlyWhitelistedInsecureKeys(rawKeysWithMetadata);
    L91:
        SecretKey recoveryKey = generateRecoveryKey();     // Catch: NoSuchAlgorithmException -> L74
        Map<String, byte[]> encryptedApplicationKeys = KeySyncUtils.encryptKeysWithRecoveryKey(recoveryKey, rawKeysWithMetadata2);     // Catch: Throwable -> L71
        if (this.mCredentialUpdated == false) goto L49;
        Long counterId = Long.valueOf(generateAndStoreCounterId(recoveryAgentUid));
    L53:
        Long counterId2 = counterId;
        byte[] vaultParams = KeySyncUtils.packVaultParams(publicKey, counterId2.longValue(), 10, vaultHandle);
        byte[] encryptedRecoveryKey = KeySyncUtils.thmEncryptRecoveryKey(publicKey, localLskfHash, vaultParams, recoveryKey);     // Catch: InvalidKeyException -> L65 NoSuchAlgorithmException -> L68
        if (useScryptToHashCredential == false) goto L57;
        KeyDerivationParams keyDerivationParams = KeyDerivationParams.createScryptParams(salt, 4096);
    L58:
        KeyChainProtectionParams keyChainProtectionParams = new KeyChainProtectionParams.Builder().setUserSecretType(100).setLockScreenUiFormat(getUiFormat(this.mCredentialType)).setKeyDerivationParams(keyDerivationParams).setSecret(new byte[0]).build();
        ArrayList<KeyChainProtectionParams> metadataList = new ArrayList();
        metadataList.add(keyChainProtectionParams);
        KeyChainSnapshot.Builder keyChainSnapshotBuilder = new KeyChainSnapshot.Builder().setSnapshotVersion(getSnapshotVersion(recoveryAgentUid, shouldRecreateCurrentVersion)).setMaxAttempts(10).setCounterId(counterId2.longValue()).setServerParams(vaultHandle).setKeyChainProtectionParams(metadataList).setWrappedApplicationKeys(createApplicationKeyEntries(encryptedApplicationKeys, rawKeysWithMetadata2)).setEncryptedRecoveryKeyBlob(encryptedRecoveryKey);
        keyChainSnapshotBuilder.setTrustedHardwareCertPath(certPath);     // Catch: CertificateException -> L62
        this.mRecoverySnapshotStorage.put(recoveryAgentUid, keyChainSnapshotBuilder.build());
        this.mSnapshotListenersStorage.recoverySnapshotAvailable(recoveryAgentUid);
        this.mRecoverableKeyStoreDb.setShouldCreateSnapshot(this.mUserId, recoveryAgentUid, false);
        return;
    L62:
        e = move-exception;
        Log.wtf(TAG, "Cannot serialize CertPath when calling setTrustedHardwareCertPath", e);
        return;
    L57:
        KeyDerivationParams keyDerivationParams2 = KeyDerivationParams.createSha256Params(salt);
        keyDerivationParams = keyDerivationParams2;
        goto L58
    L65:
        e = move-exception;
        Log.e(TAG, "Could not encrypt with recovery key", e);
        return;
    L68:
        e = move-exception;
        Log.wtf(TAG, "SecureBox encrypt algorithms unavailable", e);
        return;
    L49:
        Long counterId3 = this.mRecoverableKeyStoreDb.getCounterId(this.mUserId, recoveryAgentUid);
        if (counterId3 != null) goto L52;
        counterId = Long.valueOf(generateAndStoreCounterId(recoveryAgentUid));
        goto L53
    L52:
        counterId = counterId3;
    L71:
        e = move-exception;
        Log.wtf(TAG, "Should be impossible: could not encrypt application keys with random key", e);
        return;
    L74:
        e = move-exception;
        Log.wtf("AES should never be unavailable", e);
        return;
    L42:
        rawKeysWithMetadata2 = rawKeysWithMetadata;
    L80:
        e = move-exception;
        Log.e(TAG, "Loaded keys for same generation ID as platform key, so BadPlatformKeyException should be impossible.", e);
        return;
    L83:
        e = move-exception;
        Log.e(TAG, "A screen unlock triggered the key sync flow, so user must have lock screen. This should be impossible.", e);
        return;
    L77:
        e = move-exception;
        Log.e(TAG, "Local database error.", e);
        return;
    L86:
        e = move-exception;
        Log.e(TAG, "Failed to load recoverable keys for sync", e);
        return;
    L37:
        byte[] localLskfHash2 = this.mCredential;
        localLskfHash = hashCredentialsBySaltedSha256(salt, localLskfHash2);
        goto L97
    L19:
        Log.d(TAG, "Using the stored raw public key for syncing");
        publicKey = this.mRecoverableKeyStoreDb.getRecoveryServicePublicKey(this.mUserId, recoveryAgentUid);
        goto L20
    L5:
        if (this.mRecoverableKeyStoreDb.getSnapshotVersion(this.mUserId, recoveryAgentUid) != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        boolean shouldRecreateCurrentVersion2 = r3;
        if (shouldRecreateCurrentVersion2 == false) goto L13;
        Log.d(TAG, "Recreating most recent snapshot");
        shouldRecreateCurrentVersion = shouldRecreateCurrentVersion2;
        goto L16
    L13:
        Log.d(TAG, "Key sync not needed.");
        return;
    L7:
        if (this.mRecoverySnapshotStorage.get(recoveryAgentUid) != null) goto L9;
        r3 = true;
        goto L10
    }

    int getSnapshotVersion(int recoveryAgentUid, boolean shouldRecreateCurrentVersion) throws IOException {
        Long snapshotVersion = this.mRecoverableKeyStoreDb.getSnapshotVersion(this.mUserId, recoveryAgentUid);
        long r1 = 1;
        if (shouldRecreateCurrentVersion == false) goto L8;
        if (snapshotVersion == null) goto L7;
        r1 = snapshotVersion.longValue();
    L7:
        Long snapshotVersion2 = Long.valueOf(r1);
    L12:
        long updatedRows = this.mRecoverableKeyStoreDb.setSnapshotVersion(this.mUserId, recoveryAgentUid, snapshotVersion2.longValue());
        if (updatedRows >= 0) goto L15;
        Log.e(TAG, "Failed to set the snapshot version in the local DB.");
        throw new IOException("Failed to set the snapshot version in the local DB.");
    L15:
        return snapshotVersion2.intValue();
    L8:
        if (snapshotVersion == null) goto L11;
        r1 = 1 + snapshotVersion.longValue();
    L11:
        snapshotVersion2 = Long.valueOf(r1);
        goto L12
    }

    private long generateAndStoreCounterId(int recoveryAgentUid) throws IOException {
        long counter = new SecureRandom().nextLong();
        long updatedRows = this.mRecoverableKeyStoreDb.setCounterId(this.mUserId, recoveryAgentUid, counter);
        if (updatedRows < 0) goto L5;
        return counter;
    L5:
        Log.e(TAG, "Failed to set the snapshot version in the local DB.");
        throw new IOException("Failed to set counterId in the local DB.");
    }

    private Map<String, Pair<SecretKey, byte[]>> getKeysToSync(int recoveryAgentUid) throws InsecureUserException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPlatformKeyException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, RemoteException {
        PlatformDecryptionKey decryptKey = this.mPlatformKeyManager.getDecryptKey(this.mUserId);
        Map<String, WrappedKey> wrappedKeys = this.mRecoverableKeyStoreDb.getAllKeys(this.mUserId, recoveryAgentUid, decryptKey.getGenerationId());
        return WrappedKey.unwrapKeys(decryptKey, wrappedKeys);
    }

    private boolean shouldCreateSnapshot(int recoveryAgentUid) {
        int[] types = this.mRecoverableKeyStoreDb.getRecoverySecretTypes(this.mUserId, recoveryAgentUid);
        if (ArrayUtils.contains(types, 100) == true) goto L7;
        return false;
    L7:
        if (this.mCredentialUpdated == false) goto L13;
        if (this.mRecoverableKeyStoreDb.getSnapshotVersion(this.mUserId, recoveryAgentUid) == null) goto L13;
        this.mRecoverableKeyStoreDb.setShouldCreateSnapshot(this.mUserId, recoveryAgentUid, true);
        return true;
    L13:
        return this.mRecoverableKeyStoreDb.getShouldCreateSnapshot(this.mUserId, recoveryAgentUid);
    }

    static int getUiFormat(int credentialType) {
        if (credentialType != 1) goto L5;
        return 3;
    L5:
        if (credentialType != 3) goto L7;
        return 1;
    L7:
        return 2;
    }

    private static byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    static byte[] hashCredentialsBySaltedSha256(byte[] salt, byte[] credentialsBytes) {
        ByteBuffer byteBuffer = ByteBuffer.allocate((salt.length + credentialsBytes.length) + 8);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(salt.length);
        byteBuffer.put(salt);
        byteBuffer.putInt(credentialsBytes.length);
        byteBuffer.put(credentialsBytes);
        byte[] bytes = byteBuffer.array();
        byte[] hash = MessageDigest.getInstance(LOCK_SCREEN_HASH_ALGORITHM).digest(bytes);     // Catch: NoSuchAlgorithmException -> L5
        LockPatternUtils.zeroize(bytes);     // Catch: NoSuchAlgorithmException -> L5
        return hash;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private byte[] hashCredentialsByScrypt(byte[] salt, byte[] credentials) {
        return this.mScrypt.scrypt(credentials, salt, 4096, 8, 1, 32);
    }

    private static SecretKey generateRecoveryKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(RECOVERY_KEY_ALGORITHM);
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    private static List<WrappedApplicationKey> createApplicationKeyEntries(Map<String, byte[]> encryptedApplicationKeys, Map<String, Pair<SecretKey, byte[]>> originalKeysWithMetadata) {
        ArrayList<WrappedApplicationKey> keyEntries = new ArrayList();
        Iterator<String> r1 = encryptedApplicationKeys.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String alias = r1.next();
        keyEntries.add(new WrappedApplicationKey.Builder().setAlias(alias).setEncryptedKeyMaterial(encryptedApplicationKeys.get(alias)).setMetadata((byte[]) originalKeysWithMetadata.get(alias).second).build());
        goto L4
    L6:
        return keyEntries;
    }

    private boolean shouldUseScryptToHashCredential() {
        if (this.mCredentialType != 4) goto L5;
    L8:
        return true;
    L5:
        if (this.mCredentialType == 3) goto L8;
        return false;
    }
}
