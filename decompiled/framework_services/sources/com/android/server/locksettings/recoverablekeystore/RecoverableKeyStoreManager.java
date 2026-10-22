package com.android.server.locksettings.recoverablekeystore;

import android.app.PendingIntent;
import android.app.RemoteLockscreenValidationResult;
import android.app.RemoteLockscreenValidationSession;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.os.UserHandle;
import android.security.keystore.recovery.KeyChainProtectionParams;
import android.security.keystore.recovery.KeyChainSnapshot;
import android.security.keystore.recovery.RecoveryCertPath;
import android.security.keystore.recovery.WrappedApplicationKey;
import android.util.ArrayMap;
import android.util.FeatureFlagUtils;
import android.util.Log;
import com.android.internal.util.HexDump;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockPatternView;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.security.SecureBox;
import com.android.server.locksettings.LockSettingsService;
import com.android.server.locksettings.recoverablekeystore.certificate.CertParsingException;
import com.android.server.locksettings.recoverablekeystore.certificate.CertUtils;
import com.android.server.locksettings.recoverablekeystore.certificate.CertValidationException;
import com.android.server.locksettings.recoverablekeystore.certificate.CertXml;
import com.android.server.locksettings.recoverablekeystore.certificate.SigXml;
import com.android.server.locksettings.recoverablekeystore.storage.ApplicationKeyStorage;
import com.android.server.locksettings.recoverablekeystore.storage.CleanupManager;
import com.android.server.locksettings.recoverablekeystore.storage.RecoverableKeyStoreDb;
import com.android.server.locksettings.recoverablekeystore.storage.RecoverySessionStorage;
import com.android.server.locksettings.recoverablekeystore.storage.RecoverySnapshotStorage;
import com.android.server.locksettings.recoverablekeystore.storage.RemoteLockscreenValidationSessionStorage;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.crypto.AEADBadTagException;

/* JADX INFO: loaded from: classes2.dex */
public class RecoverableKeyStoreManager {
    private static final int INVALID_REMOTE_GUESS_LIMIT = 5;
    private static final long SYNC_DELAY_MILLIS = 2000;
    private static final String TAG = "RecoverableKeyStoreMgr";
    private static RecoverableKeyStoreManager mInstance;
    private final ApplicationKeyStorage mApplicationKeyStorage;
    private final CleanupManager mCleanupManager;
    private final Context mContext;
    private final RecoverableKeyStoreDb mDatabase;
    private final ScheduledExecutorService mExecutorService;
    private final RecoverySnapshotListenersStorage mListenersStorage;
    private final PlatformKeyManager mPlatformKeyManager;
    private final RecoverableKeyGenerator mRecoverableKeyGenerator;
    private final RecoverySessionStorage mRecoverySessionStorage;
    private final RemoteLockscreenValidationSessionStorage mRemoteLockscreenValidationSessionStorage;
    private final RecoverySnapshotStorage mSnapshotStorage;
    private final TestOnlyInsecureCertificateHelper mTestCertHelper;

    public static synchronized RecoverableKeyStoreManager getInstance(Context context) {
        monitor-enter(RecoverableKeyStoreManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L23;
        RecoverableKeyStoreDb db = RecoverableKeyStoreDb.newInstance(context);     // Catch: Throwable -> L10
        if (FeatureFlagUtils.isEnabled(context, "settings_enable_lockscreen_transfer_api") == true) goto L9;
        RemoteLockscreenValidationSessionStorage lockscreenCheckSessions = null;
    L29:
        PlatformKeyManager platformKeyManager = PlatformKeyManager.getInstance(context, db);     // Catch: Throwable -> L10 KeyStoreException -> L15 NoSuchAlgorithmException -> L17
        ApplicationKeyStorage applicationKeyStorage = ApplicationKeyStorage.getInstance();     // Catch: Throwable -> L10 KeyStoreException -> L15 NoSuchAlgorithmException -> L17
        RecoverySnapshotStorage snapshotStorage = RecoverySnapshotStorage.newInstance();     // Catch: Throwable -> L10
        CleanupManager cleanupManager = CleanupManager.getInstance(context.getApplicationContext(), snapshotStorage, db, applicationKeyStorage);     // Catch: Throwable -> L10
        mInstance = new RecoverableKeyStoreManager(context.getApplicationContext(), db, new RecoverySessionStorage(), Executors.newScheduledThreadPool(1), snapshotStorage, new RecoverySnapshotListenersStorage(), platformKeyManager, applicationKeyStorage, new TestOnlyInsecureCertificateHelper(), cleanupManager, lockscreenCheckSessions);     // Catch: Throwable -> L10
        goto L23
    L15:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());     // Catch: Throwable -> L10
    L17:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L10
    L9:
        lockscreenCheckSessions = new RemoteLockscreenValidationSessionStorage();     // Catch: Throwable -> L10
    L23:
        RecoverableKeyStoreManager r0 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(RecoverableKeyStoreManager.class);
        return r0;
    }

    RecoverableKeyStoreManager(Context context, RecoverableKeyStoreDb recoverableKeyStoreDb, RecoverySessionStorage recoverySessionStorage, ScheduledExecutorService executorService, RecoverySnapshotStorage snapshotStorage, RecoverySnapshotListenersStorage listenersStorage, PlatformKeyManager platformKeyManager, ApplicationKeyStorage applicationKeyStorage, TestOnlyInsecureCertificateHelper testOnlyInsecureCertificateHelper, CleanupManager cleanupManager, RemoteLockscreenValidationSessionStorage remoteLockscreenValidationSessionStorage) {
        this.mContext = context;
        this.mDatabase = recoverableKeyStoreDb;
        this.mRecoverySessionStorage = recoverySessionStorage;
        this.mExecutorService = executorService;
        this.mListenersStorage = listenersStorage;
        this.mSnapshotStorage = snapshotStorage;
        this.mPlatformKeyManager = platformKeyManager;
        this.mApplicationKeyStorage = applicationKeyStorage;
        this.mTestCertHelper = testOnlyInsecureCertificateHelper;
        this.mCleanupManager = cleanupManager;
        this.mCleanupManager.verifyKnownUsers();     // Catch: Exception -> L5
    L13:
        this.mRecoverableKeyGenerator = RecoverableKeyGenerator.newInstance(this.mDatabase);     // Catch: NoSuchAlgorithmException -> L10
        this.mRemoteLockscreenValidationSessionStorage = remoteLockscreenValidationSessionStorage;
        return;
    L10:
        e = move-exception;
        Log.wtf(TAG, "AES keygen algorithm not available. AOSP must support this.", e);
        throw new ServiceSpecificException(22, e.getMessage());
    L5:
        e = move-exception;
        Log.e(TAG, "Failed to verify known users", e);
        goto L13
    }

    void initRecoveryService(String rootCertificateAlias, byte[] recoveryServiceCertFile) throws RemoteException {
        checkRecoverKeyStorePermission();
        int userId = UserHandle.getCallingUserId();
        int uid = Binder.getCallingUid();
        String rootCertificateAlias2 = this.mTestCertHelper.getDefaultCertificateAliasIfEmpty(rootCertificateAlias);
        if (this.mTestCertHelper.isValidRootCertificateAlias(rootCertificateAlias2) == false) goto L70;
        String activeRootAlias = this.mDatabase.getActiveRootOfTrust(userId, uid);
        if (activeRootAlias != null) goto L8;
        Log.d(TAG, "Root of trust for recovery agent + " + uid + " is assigned for the first time to " + rootCertificateAlias2);
    L10:
        long updatedRows = this.mDatabase.setActiveRootOfTrust(userId, uid, rootCertificateAlias2);
        if (updatedRows < 0) goto L68;
        CertXml certXml = CertXml.parse(recoveryServiceCertFile);     // Catch: CertParsingException -> L64
        long newSerial = certXml.getSerial();
        Long oldSerial = this.mDatabase.getRecoveryServiceCertSerial(userId, uid, rootCertificateAlias2);
        if (oldSerial != null) goto L16;
    L25:
        Log.i(TAG, "Updating the certificate with the new serial number " + newSerial);
        X509Certificate rootCert = this.mTestCertHelper.getRootCertificate(rootCertificateAlias2);
        Date validationDate = this.mTestCertHelper.getValidationDate(rootCertificateAlias2);
        Log.d(TAG, "Getting and validating a random endpoint certificate");     // Catch: CertValidationException -> L61
        CertPath certPath = certXml.getRandomEndpointCert(rootCert, validationDate);     // Catch: CertValidationException -> L61
        Log.d(TAG, "Saving the randomly chosen endpoint certificate to database");     // Catch: CertificateEncodingException -> L57
        long updatedCertPathRows = this.mDatabase.setRecoveryServiceCertPath(userId, uid, rootCertificateAlias2, certPath);     // Catch: CertificateEncodingException -> L57
        if (updatedCertPathRows <= 0) goto L51;
        long updatedCertSerialRows = this.mDatabase.setRecoveryServiceCertSerial(userId, uid, rootCertificateAlias2, newSerial);     // Catch: CertificateEncodingException -> L39
        if (updatedCertSerialRows < 0) goto L47;
        if (this.mDatabase.getSnapshotVersion(userId, uid) == null) goto L41;
        this.mDatabase.setShouldCreateSnapshot(userId, uid, true);     // Catch: CertificateEncodingException -> L39
        Log.i(TAG, "This is a certificate change. Snapshot must be updated");     // Catch: CertificateEncodingException -> L39
    L42:
        long updatedCounterIdRows = this.mDatabase.setCounterId(userId, uid, new SecureRandom().nextLong());     // Catch: CertificateEncodingException -> L39
        if (updatedCounterIdRows >= 0) goto L54;
        Log.e(TAG, "Failed to set the counter id in the local DB.");     // Catch: CertificateEncodingException -> L39
    L54:
        return;
    L41:
        Log.i(TAG, "This is a certificate change. Snapshot didn't exist");     // Catch: CertificateEncodingException -> L39
        goto L42
    L47:
        throw new ServiceSpecificException(22, "Failed to set the certificate serial number in the local DB.");     // Catch: CertificateEncodingException -> L39
    L48:
        e = e;
    L59:
        Log.e(TAG, "Failed to encode CertPath", e);
        throw new ServiceSpecificException(25, e.getMessage());
    L51:
        if (updatedCertPathRows >= 0) goto L54;
        throw new ServiceSpecificException(22, "Failed to set the certificate path in the local DB.");     // Catch: CertificateEncodingException -> L39
    L39:
        e = e;
    L57:
        e = e;
    L61:
        e = move-exception;
        Log.e(TAG, "Invalid endpoint cert", e);
        throw new ServiceSpecificException(28, e.getMessage());
    L16:
        if (oldSerial.longValue() < newSerial) goto L25;
        if (this.mTestCertHelper.isTestOnlyCertificateAlias(rootCertificateAlias2) == true) goto L25;
        if (oldSerial.longValue() != newSerial) goto L23;
        Log.i(TAG, "The cert file serial number is the same, so skip updating.");
        return;
    L23:
        Log.e(TAG, "The cert file serial number is older than the one in database.");
        throw new ServiceSpecificException(29, "The cert file serial number is older than the one in database.");
    L64:
        e = move-exception;
        Log.d(TAG, "Failed to parse the input as a cert file: " + HexDump.toHexString(recoveryServiceCertFile));
        throw new ServiceSpecificException(25, e.getMessage());
    L68:
        throw new ServiceSpecificException(22, "Failed to set the root of trust in the local DB.");
    L8:
        if (activeRootAlias.equals(rootCertificateAlias2) == true) goto L10;
        Log.i(TAG, "Root of trust for recovery agent " + uid + " is changed to " + rootCertificateAlias2 + " from  " + activeRootAlias);
        goto L10
    L70:
        throw new ServiceSpecificException(28, "Invalid root certificate alias");
    }

    public void initRecoveryServiceWithSigFile(String rootCertificateAlias, byte[] recoveryServiceCertFile, byte[] recoveryServiceSigFile) throws RemoteException {
        checkRecoverKeyStorePermission();
        String rootCertificateAlias2 = this.mTestCertHelper.getDefaultCertificateAliasIfEmpty(rootCertificateAlias);
        recoveryServiceCertFile.getClass();
        recoveryServiceSigFile.getClass();
        SigXml sigXml = SigXml.parse(recoveryServiceSigFile);     // Catch: CertParsingException -> L11
        X509Certificate rootCert = this.mTestCertHelper.getRootCertificate(rootCertificateAlias2);
        Date validationDate = this.mTestCertHelper.getValidationDate(rootCertificateAlias2);
        sigXml.verifyFileSignature(rootCert, recoveryServiceCertFile, validationDate);     // Catch: CertValidationException -> L8
        initRecoveryService(rootCertificateAlias2, recoveryServiceCertFile);
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "The signature over the cert file is invalid. Cert: " + HexDump.toHexString(recoveryServiceCertFile) + " Sig: " + HexDump.toHexString(recoveryServiceSigFile));
        throw new ServiceSpecificException(28, e.getMessage());
    L11:
        e = move-exception;
        Log.d(TAG, "Failed to parse the sig file: " + HexDump.toHexString(recoveryServiceSigFile));
        throw new ServiceSpecificException(25, e.getMessage());
    }

    public KeyChainSnapshot getKeyChainSnapshot() throws RemoteException {
        checkRecoverKeyStorePermission();
        int uid = Binder.getCallingUid();
        KeyChainSnapshot snapshot = this.mSnapshotStorage.get(uid);
        if (snapshot == null) goto L6;
        return snapshot;
    L6:
        throw new ServiceSpecificException(21);
    }

    public void setSnapshotCreatedPendingIntent(PendingIntent intent) throws RemoteException {
        checkRecoverKeyStorePermission();
        int uid = Binder.getCallingUid();
        this.mListenersStorage.setSnapshotListener(uid, intent);
    }

    public void setServerParams(byte[] serverParams) throws RemoteException {
        checkRecoverKeyStorePermission();
        int userId = UserHandle.getCallingUserId();
        int uid = Binder.getCallingUid();
        byte[] currentServerParams = this.mDatabase.getServerParams(userId, uid);
        if (Arrays.equals(serverParams, currentServerParams) == false) goto L6;
        Log.v(TAG, "Not updating server params - same as old value.");
        return;
    L6:
        long updatedRows = this.mDatabase.setServerParams(userId, uid, serverParams);
        if (updatedRows < 0) goto L17;
        if (currentServerParams != null) goto L12;
        Log.i(TAG, "Initialized server params.");
        return;
    L12:
        if (this.mDatabase.getSnapshotVersion(userId, uid) == null) goto L14;
        this.mDatabase.setShouldCreateSnapshot(userId, uid, true);
        Log.i(TAG, "Updated server params. Snapshot must be updated");
        return;
    L14:
        Log.i(TAG, "Updated server params. Snapshot didn't exist");
        return;
    L17:
        throw new ServiceSpecificException(22, "Database failure trying to set server params.");
    }

    public void setRecoveryStatus(String alias, int status) throws RemoteException {
        checkRecoverKeyStorePermission();
        alias.getClass();
        long updatedRows = this.mDatabase.setRecoveryStatus(Binder.getCallingUid(), alias, status);
        if (updatedRows < 0) goto L6;
        return;
    L6:
        throw new ServiceSpecificException(22, "Failed to set the key recovery status in the local DB.");
    }

    public Map<String, Integer> getRecoveryStatus() throws RemoteException {
        checkRecoverKeyStorePermission();
        return this.mDatabase.getStatusForAllKeys(Binder.getCallingUid());
    }

    public void setRecoverySecretTypes(int[] secretTypes) throws RemoteException {
        checkRecoverKeyStorePermission();
        secretTypes.getClass();
        int userId = UserHandle.getCallingUserId();
        int uid = Binder.getCallingUid();
        int[] currentSecretTypes = this.mDatabase.getRecoverySecretTypes(userId, uid);
        if (Arrays.equals(secretTypes, currentSecretTypes) == false) goto L6;
        Log.v(TAG, "Not updating secret types - same as old value.");
        return;
    L6:
        long updatedRows = this.mDatabase.setRecoverySecretTypes(userId, uid, secretTypes);
        if (updatedRows < 0) goto L18;
        if (currentSecretTypes.length != 0) goto L12;
        Log.i(TAG, "Initialized secret types.");
        return;
    L12:
        Log.i(TAG, "Updated secret types. Snapshot pending.");
        if (this.mDatabase.getSnapshotVersion(userId, uid) == null) goto L15;
        this.mDatabase.setShouldCreateSnapshot(userId, uid, true);
        Log.i(TAG, "Updated secret types. Snapshot must be updated");
        return;
    L15:
        Log.i(TAG, "Updated secret types. Snapshot didn't exist");
        return;
    L18:
        throw new ServiceSpecificException(22, "Database error trying to set secret types.");
    }

    public int[] getRecoverySecretTypes() throws RemoteException {
        checkRecoverKeyStorePermission();
        return this.mDatabase.getRecoverySecretTypes(UserHandle.getCallingUserId(), Binder.getCallingUid());
    }

    byte[] startRecoverySession(String sessionId, byte[] verifierPublicKey, byte[] vaultParams, byte[] vaultChallenge, List<KeyChainProtectionParams> secrets) throws RemoteException {
        checkRecoverKeyStorePermission();
        int uid = Binder.getCallingUid();
        if (secrets.size() != 1) goto L25;
        PublicKey publicKey = KeySyncUtils.deserializePublicKey(verifierPublicKey);     // Catch: InvalidKeySpecException -> L21
        if (publicKeysMatch(publicKey, vaultParams) == false) goto L20;
        byte[] keyClaimant = KeySyncUtils.generateKeyClaimant();
        byte[] kfHash = secrets.get(0).getSecret();
        this.mRecoverySessionStorage.add(uid, new RecoverySessionStorage.Entry(sessionId, kfHash, keyClaimant, vaultParams));
        Log.i(TAG, "Received VaultParams for recovery: " + HexDump.toHexString(vaultParams));
        byte[] thmKfHash = KeySyncUtils.calculateThmKfHash(kfHash);     // Catch: InvalidKeyException -> L11 NoSuchAlgorithmException -> L13
        return KeySyncUtils.encryptRecoveryClaim(publicKey, vaultParams, vaultChallenge, thmKfHash, keyClaimant);
    L11:
        e = move-exception;
        throw new ServiceSpecificException(25, e.getMessage());
    L13:
        e = move-exception;
        Log.wtf(TAG, "SecureBox algorithm missing. AOSP must support this.", e);
        throw new ServiceSpecificException(22, e.getMessage());
    L20:
        throw new ServiceSpecificException(28, "The public keys given in verifierPublicKey and vaultParams do not match.");
    L21:
        e = move-exception;
        throw new ServiceSpecificException(25, e.getMessage());
    L25:
        throw new UnsupportedOperationException("Only a single KeyChainProtectionParams is supported");
    }

    public byte[] startRecoverySessionWithCertPath(String sessionId, String rootCertificateAlias, RecoveryCertPath verifierCertPath, byte[] vaultParams, byte[] vaultChallenge, List<KeyChainProtectionParams> secrets) throws RemoteException {
        checkRecoverKeyStorePermission();
        String rootCertificateAlias2 = this.mTestCertHelper.getDefaultCertificateAliasIfEmpty(rootCertificateAlias);
        sessionId.getClass();
        verifierCertPath.getClass();
        vaultParams.getClass();
        vaultChallenge.getClass();
        secrets.getClass();
        CertPath certPath = verifierCertPath.getCertPath();     // Catch: CertificateException -> L15
        Date validationDate = this.mTestCertHelper.getValidationDate(rootCertificateAlias2);     // Catch: CertValidationException -> L12
        CertUtils.validateCertPath(this.mTestCertHelper.getRootCertificate(rootCertificateAlias2), certPath, validationDate);     // Catch: CertValidationException -> L12
        byte[] verifierPublicKey = certPath.getCertificates().get(0).getPublicKey().getEncoded();
        if (verifierPublicKey != null) goto L9;
        Log.e(TAG, "Failed to encode verifierPublicKey");
        throw new ServiceSpecificException(25, "Failed to encode verifierPublicKey");
    L9:
        return startRecoverySession(sessionId, verifierPublicKey, vaultParams, vaultChallenge, secrets);
    L12:
        e = move-exception;
        Log.e(TAG, "Failed to validate the given cert path", e);
        throw new ServiceSpecificException(28, e.getMessage());
    L15:
        e = move-exception;
        throw new ServiceSpecificException(25, e.getMessage());
    }

    public Map<String, String> recoverKeyChainSnapshot(String sessionId, byte[] encryptedRecoveryKey, List<WrappedApplicationKey> applicationKeys) throws RemoteException {
        checkRecoverKeyStorePermission();
        int userId = UserHandle.getCallingUserId();
        int uid = Binder.getCallingUid();
        RecoverySessionStorage.Entry sessionEntry = this.mRecoverySessionStorage.get(uid, sessionId);
        if (sessionEntry == null) goto L15;
        byte[] recoveryKey = decryptRecoveryKey(sessionEntry, encryptedRecoveryKey);     // Catch: Throwable -> L7 KeyStoreException -> L9
        Map<String, byte[]> keysByAlias = recoverApplicationKeys(recoveryKey, applicationKeys);     // Catch: Throwable -> L7 KeyStoreException -> L9
        Map<String, String> r5 = importKeyMaterials(userId, uid, keysByAlias);     // Catch: Throwable -> L7 KeyStoreException -> L9
        sessionEntry.destroy();
        this.mRecoverySessionStorage.remove(uid);
        return r5;
    L9:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());     // Catch: Throwable -> L7
    L15:
        throw new ServiceSpecificException(24, String.format(Locale.US, "Application uid=%d does not have pending session '%s'", new Object[]{Integer.valueOf(uid), sessionId}));
    L7:
        th = move-exception;
        sessionEntry.destroy();
        this.mRecoverySessionStorage.remove(uid);
        throw th;
    }

    private Map<String, String> importKeyMaterials(int userId, int uid, Map<String, byte[]> keysByAlias) throws KeyStoreException {
        ArrayMap<String, String> grantAliasesByAlias = new ArrayMap(keysByAlias.size());
        Iterator<String> r1 = keysByAlias.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String alias = r1.next();
        this.mApplicationKeyStorage.setSymmetricKeyEntry(userId, uid, alias, keysByAlias.get(alias));
        String grantAlias = getAlias(userId, uid, alias);
        Log.i(TAG, String.format(Locale.US, "Import %s -> %s", new Object[]{alias, grantAlias}));
        grantAliasesByAlias.put(alias, grantAlias);
        goto L4
    L6:
        return grantAliasesByAlias;
    }

    private String getAlias(int userId, int uid, String alias) {
        return this.mApplicationKeyStorage.getGrantAlias(userId, uid, alias);
    }

    public void closeSession(String sessionId) throws RemoteException {
        checkRecoverKeyStorePermission();
        sessionId.getClass();
        this.mRecoverySessionStorage.remove(Binder.getCallingUid(), sessionId);
    }

    public void removeKey(String alias) throws RemoteException {
        checkRecoverKeyStorePermission();
        alias.getClass();
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        boolean wasRemoved = this.mDatabase.removeKey(uid, alias);
        if (wasRemoved == false) goto L6;
        this.mDatabase.setShouldCreateSnapshot(userId, uid, true);
        this.mApplicationKeyStorage.deleteEntry(userId, uid, alias);
        return;
    }

    @Deprecated
    public String generateKey(String alias) throws RemoteException {
        return generateKeyWithMetadata(alias, null);
    }

    public String generateKeyWithMetadata(String alias, byte[] metadata) throws RemoteException {
        checkRecoverKeyStorePermission();
        alias.getClass();
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        PlatformEncryptionKey encryptionKey = this.mPlatformKeyManager.getEncryptKey(userId);     // Catch: InsecureUserException -> L14 Throwable -> L16 NoSuchAlgorithmException -> L18
        byte[] secretKey = this.mRecoverableKeyGenerator.generateAndStoreKey(encryptionKey, userId, uid, alias, metadata);     // Catch: Throwable -> L8
        this.mApplicationKeyStorage.setSymmetricKeyEntry(userId, uid, alias, secretKey);     // Catch: Throwable -> L8
        return getAlias(userId, uid, alias);
    L8:
        e = move-exception;
        Exception e = e;
    L13:
        throw new ServiceSpecificException(22, e.getMessage());
    L10:
        e = move-exception;
        e = e;
        goto L13
    L14:
        e = move-exception;
        throw new ServiceSpecificException(23, e.getMessage());
    L16:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Deprecated
    public String importKey(String alias, byte[] keyBytes) throws RemoteException {
        return importKeyWithMetadata(alias, keyBytes, null);
    }

    public String importKeyWithMetadata(String alias, byte[] keyBytes, byte[] metadata) throws RemoteException {
        checkRecoverKeyStorePermission();
        alias.getClass();
        keyBytes.getClass();
        if (keyBytes.length != 32) goto L28;
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        PlatformEncryptionKey encryptionKey = this.mPlatformKeyManager.getEncryptKey(userId);     // Catch: InsecureUserException -> L16 Throwable -> L18 NoSuchAlgorithmException -> L20
        this.mRecoverableKeyGenerator.importKey(encryptionKey, userId, uid, alias, keyBytes, metadata);     // Catch: Throwable -> L10
        this.mApplicationKeyStorage.setSymmetricKeyEntry(userId, uid, alias, keyBytes);     // Catch: Throwable -> L10
        return getAlias(userId, uid, alias);
    L10:
        e = move-exception;
        Exception e = e;
    L15:
        throw new ServiceSpecificException(22, e.getMessage());
    L12:
        e = move-exception;
        e = e;
        goto L15
    L16:
        e = move-exception;
        throw new ServiceSpecificException(23, e.getMessage());
    L18:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L28:
        Log.e(TAG, "The given key for import doesn't have the required length 256");
        throw new ServiceSpecificException(27, "The given key does not contain 256 bits.");
    }

    public String getKey(String alias) throws RemoteException {
        checkRecoverKeyStorePermission();
        alias.getClass();
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        return getAlias(userId, uid, alias);
    }

    private byte[] decryptRecoveryKey(RecoverySessionStorage.Entry sessionEntry, byte[] encryptedClaimResponse) throws RemoteException, ServiceSpecificException {
        byte[] locallyEncryptedKey = KeySyncUtils.decryptRecoveryClaimResponse(sessionEntry.getKeyClaimant(), sessionEntry.getVaultParams(), encryptedClaimResponse);     // Catch: NoSuchAlgorithmException -> L18 AEADBadTagException -> L20 InvalidKeyException -> L22
    L32:
        return KeySyncUtils.decryptRecoveryKey(sessionEntry.getLskfHash(), locallyEncryptedKey);
    L10:
        e = move-exception;
        Log.e(TAG, "Got InvalidKeyException during decrypting recovery key", e);
        throw new ServiceSpecificException(26, "Failed to decrypt recovery key " + e.getMessage());
    L6:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());
    L8:
        e = move-exception;
        Log.e(TAG, "Got AEADBadTagException during decrypting recovery key", e);
        throw new ServiceSpecificException(26, "Failed to decrypt recovery key " + e.getMessage());
    L22:
        e = move-exception;
        Log.e(TAG, "Got InvalidKeyException during decrypting recovery claim response", e);
        throw new ServiceSpecificException(26, "Failed to decrypt recovery key " + e.getMessage());
    L18:
        e = move-exception;
        throw new ServiceSpecificException(22, e.getMessage());
    L20:
        e = move-exception;
        Log.e(TAG, "Got AEADBadTagException during decrypting recovery claim response", e);
        throw new ServiceSpecificException(26, "Failed to decrypt recovery key " + e.getMessage());
    }

    private Map<String, byte[]> recoverApplicationKeys(byte[] recoveryKey, List<WrappedApplicationKey> applicationKeys) throws RemoteException {
        HashMap<String, byte[]> keyMaterialByAlias = new HashMap();
        Iterator<WrappedApplicationKey> r1 = applicationKeys.iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        WrappedApplicationKey applicationKey = r1.next();
        String alias = applicationKey.getAlias();
        byte[] encryptedKeyMaterial = applicationKey.getEncryptedKeyMaterial();
        byte[] keyMetadata = applicationKey.getMetadata();
        byte[] keyMaterial = KeySyncUtils.decryptApplicationKey(recoveryKey, encryptedKeyMaterial, keyMetadata);     // Catch: AEADBadTagException -> L8 InvalidKeyException -> L10 NoSuchAlgorithmException -> L12
        keyMaterialByAlias.put(alias, keyMaterial);     // Catch: AEADBadTagException -> L8 InvalidKeyException -> L10 NoSuchAlgorithmException -> L12
    L10:
        e = move-exception;
        Log.e(TAG, "Got InvalidKeyException during decrypting application key with alias: " + alias, e);
        throw new ServiceSpecificException(26, "Failed to recover key with alias '" + alias + "': " + e.getMessage());
    L12:
        e = move-exception;
        Log.wtf(TAG, "Missing SecureBox algorithm. AOSP required to support this.", e);
        throw new ServiceSpecificException(22, e.getMessage());
    L8:
        e = move-exception;
        Log.e(TAG, "Got AEADBadTagException during decrypting application key with alias: " + alias, e);
        goto L4
    L21:
        if (applicationKeys.isEmpty() == false) goto L23;
    L27:
        return keyMaterialByAlias;
    L23:
        if (keyMaterialByAlias.isEmpty() == false) goto L27;
        Log.e(TAG, "Failed to recover any of the application keys.");
        throw new ServiceSpecificException(26, "Failed to recover any of the application keys.");
    }

    public void lockScreenSecretAvailable(int credentialType, byte[] credential, int userId) {
        ScheduledExecutorService r0 = this.mExecutorService;     // Catch: InsecureUserException -> L13 KeyStoreException -> L15 NoSuchAlgorithmException -> L17
    L23:
        r0.schedule(KeySyncTask.newInstance(this.mContext, this.mDatabase, this.mSnapshotStorage, this.mListenersStorage, userId, credentialType, credential, false), 2000, TimeUnit.MILLISECONDS);     // Catch: InsecureUserException -> L7 KeyStoreException -> L9 NoSuchAlgorithmException -> L11
    L27:
        return;
    L7:
        e = move-exception;
        InsecureUserException e = e;
    L19:
        Log.wtf(TAG, "Impossible - insecure user, but user just entered lock screen", e);
        return;
    L9:
        e = move-exception;
        KeyStoreException e2 = e;
    L20:
        Log.e(TAG, "Key store error encountered during recoverable key sync", e2);
        return;
    L11:
        e = move-exception;
        NoSuchAlgorithmException e3 = e;
    L21:
        Log.wtf(TAG, "Should never happen - algorithm unavailable for KeySync", e3);
        return;
    L13:
        e = move-exception;
        e = e;
    L15:
        e = move-exception;
        e2 = e;
    L17:
        e = move-exception;
        e3 = e;
        goto L21
    }

    public void lockScreenSecretChanged(int credentialType, byte[] credential, int userId) {
        ScheduledExecutorService r0 = this.mExecutorService;     // Catch: InsecureUserException -> L13 KeyStoreException -> L15 NoSuchAlgorithmException -> L17
    L23:
        r0.schedule(KeySyncTask.newInstance(this.mContext, this.mDatabase, this.mSnapshotStorage, this.mListenersStorage, userId, credentialType, credential, true), 2000, TimeUnit.MILLISECONDS);     // Catch: InsecureUserException -> L7 KeyStoreException -> L9 NoSuchAlgorithmException -> L11
    L27:
        return;
    L7:
        e = move-exception;
        InsecureUserException e = e;
    L19:
        Log.e(TAG, "InsecureUserException during lock screen secret update", e);
        return;
    L9:
        e = move-exception;
        KeyStoreException e2 = e;
    L20:
        Log.e(TAG, "Key store error encountered during recoverable key sync", e2);
        return;
    L11:
        e = move-exception;
        NoSuchAlgorithmException e3 = e;
    L21:
        Log.wtf(TAG, "Should never happen - algorithm unavailable for KeySync", e3);
        return;
    L13:
        e = move-exception;
        e = e;
    L15:
        e = move-exception;
        e2 = e;
    L17:
        e = move-exception;
        e3 = e;
        goto L21
    }

    public RemoteLockscreenValidationSession startRemoteLockscreenValidation(LockSettingsService lockSettingsService) {
        if (this.mRemoteLockscreenValidationSessionStorage == null) goto L12;
        checkVerifyRemoteLockscreenPermission();
        int userId = UserHandle.getCallingUserId();
        long token = Binder.clearCallingIdentity();
        int savedCredentialType = lockSettingsService.getCredentialType(userId);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        int keyguardCredentialsType = lockPatternUtilsToKeyguardType(savedCredentialType);
        RemoteLockscreenValidationSessionStorage.LockscreenVerificationSession session = this.mRemoteLockscreenValidationSessionStorage.startSession(userId);
        PublicKey publicKey = session.getKeyPair().getPublic();
        byte[] encodedPublicKey = SecureBox.encodePublicKey(publicKey);
        int badGuesses = this.mDatabase.getBadRemoteGuessCounter(userId);
        int remainingAttempts = Math.max(5 - badGuesses, 0);
        return new RemoteLockscreenValidationSession.Builder().setLockType(keyguardCredentialsType).setRemainingAttempts(remainingAttempts).setSourcePublicKey(encodedPublicKey).build();
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        throw new UnsupportedOperationException("Under development");
    }

    public synchronized RemoteLockscreenValidationResult validateRemoteLockscreen(byte[] encryptedCredential, LockSettingsService lockSettingsService) {
        monitor-enter(this);
        checkVerifyRemoteLockscreenPermission();     // Catch: Throwable -> L8
        int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L8
        RemoteLockscreenValidationSessionStorage.LockscreenVerificationSession session = this.mRemoteLockscreenValidationSessionStorage.get(userId);     // Catch: Throwable -> L8
        int badGuesses = this.mDatabase.getBadRemoteGuessCounter(userId);     // Catch: Throwable -> L8
        int remainingAttempts = 5 - badGuesses;     // Catch: Throwable -> L8
        if (remainingAttempts > 0) goto L10;
        RemoteLockscreenValidationResult r4 = new RemoteLockscreenValidationResult.Builder().setResultCode(4).build();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r4;
    L10:
        if (session != null) goto L59;
        RemoteLockscreenValidationResult r5 = new RemoteLockscreenValidationResult.Builder().setResultCode(5).build();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L59:
        byte[] decryptedCredentials = SecureBox.decrypt(session.getKeyPair().getPrivate(), null, LockPatternUtils.ENCRYPTED_REMOTE_CREDENTIALS_HEADER, encryptedCredential);     // Catch: Throwable -> L8 AEADBadTagException -> L38 InvalidKeyException -> L40 NoSuchAlgorithmException -> L42
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
        int savedCredentialType = lockSettingsService.getCredentialType(userId);     // Catch: Throwable -> L35
        int keyguardCredentialsType = lockPatternUtilsToKeyguardType(savedCredentialType);     // Catch: Throwable -> L35
        LockscreenCredential credential = createLockscreenCredential(keyguardCredentialsType, decryptedCredentials);     // Catch: Throwable -> L35
        LockPatternUtils.zeroize(decryptedCredentials);     // Catch: Throwable -> L27
        VerifyCredentialResponse verifyResponse = lockSettingsService.verifyCredential(credential, userId, 0);     // Catch: Throwable -> L27
        RemoteLockscreenValidationResult r11 = handleVerifyCredentialResponse(verifyResponse, userId);     // Catch: Throwable -> L27
        if (credential == null) goto L24;
        credential.close();     // Catch: Throwable -> L22
    L24:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L22:
        th = th;
    L36:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L27:
        th = move-exception;
        if (credential != null) goto L52;
    L34:
        throw th;     // Catch: Throwable -> L35
    L52:
        credential.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22
    L35:
        th = th;
        goto L36
    L40:
        e = move-exception;
        Log.e(TAG, "Got InvalidKeyException during lock screen credentials decryption");     // Catch: Throwable -> L8
        throw new IllegalStateException(e);     // Catch: Throwable -> L8
    L42:
        e = move-exception;
        Log.wtf(TAG, "Missing SecureBox algorithm. AOSP required to support this.", e);     // Catch: Throwable -> L8
        throw new IllegalStateException(e);     // Catch: Throwable -> L8
    L38:
        e = move-exception;
        throw new IllegalStateException("Could not decrypt credentials guess", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private RemoteLockscreenValidationResult handleVerifyCredentialResponse(VerifyCredentialResponse response, int userId) {
        if (response.getResponseCode() != 0) goto L7;
        this.mDatabase.setBadRemoteGuessCounter(userId, 0);
        this.mRemoteLockscreenValidationSessionStorage.finishSession(userId);
        return new RemoteLockscreenValidationResult.Builder().setResultCode(1).build();
    L7:
        if (response.getResponseCode() != 1) goto L10;
        long timeout = response.getTimeout();
        return new RemoteLockscreenValidationResult.Builder().setResultCode(3).setTimeoutMillis(timeout).build();
    L10:
        int badGuesses = this.mDatabase.getBadRemoteGuessCounter(userId);
        this.mDatabase.setBadRemoteGuessCounter(userId, badGuesses + 1);
        return new RemoteLockscreenValidationResult.Builder().setResultCode(2).build();
    }

    private LockscreenCredential createLockscreenCredential(int lockType, byte[] password) {
        switch(lockType) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        List<LockPatternView.Cell> pattern = LockPatternUtils.byteArrayToPattern(password);
        return LockscreenCredential.createPattern(pattern);
    L7:
        CharSequence pinStr = new String(password);
        return LockscreenCredential.createPin(pinStr);
    L9:
        CharSequence passwordStr = new String(password, StandardCharsets.UTF_8);
        return LockscreenCredential.createPassword(passwordStr);
    L4:
        throw new IllegalStateException("Lockscreen is not set");
    }

    private void checkVerifyRemoteLockscreenPermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CHECK_REMOTE_LOCKSCREEN", "Caller " + Binder.getCallingUid() + " doesn't have CHECK_REMOTE_LOCKSCREEN permission.");
        int userId = UserHandle.getCallingUserId();
        int uid = Binder.getCallingUid();
        this.mCleanupManager.registerRecoveryAgent(userId, uid);
    }

    private int lockPatternUtilsToKeyguardType(int credentialsType) {
        switch(credentialsType) {
            case -1: goto L13;
            case 0: goto L5;
            case 1: goto L10;
            case 2: goto L5;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        return 0;
    L8:
        return 1;
    L10:
        return 2;
    L5:
        throw new IllegalStateException("Screen lock is not set");
    L13:
        throw new IllegalStateException("Screen lock is not set");
    }

    private void checkRecoverKeyStorePermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.RECOVER_KEYSTORE", "Caller " + Binder.getCallingUid() + " doesn't have RecoverKeyStore permission.");
        int userId = UserHandle.getCallingUserId();
        int uid = Binder.getCallingUid();
        this.mCleanupManager.registerRecoveryAgent(userId, uid);
    }

    private boolean publicKeysMatch(PublicKey publicKey, byte[] vaultParams) {
        byte[] encodedPublicKey = SecureBox.encodePublicKey(publicKey);
        return Arrays.equals(encodedPublicKey, Arrays.copyOf(vaultParams, encodedPublicKey.length));
    }
}
