package com.android.server.locksettings.recoverablekeystore;

import android.util.Pair;
import com.android.internal.util.ArrayUtils;
import com.android.security.SecureBox;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.AEADBadTagException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class KeySyncUtils {
    private static final byte[] ENCRYPTED_APPLICATION_KEY_HEADER = null;
    private static final int KEY_CLAIMANT_LENGTH_BYTES = 16;
    private static final byte[] LOCALLY_ENCRYPTED_RECOVERY_KEY_HEADER = null;
    private static final String PUBLIC_KEY_FACTORY_ALGORITHM = "EC";
    private static final byte[] RECOVERY_CLAIM_HEADER = null;
    private static final String RECOVERY_KEY_ALGORITHM = "AES";
    private static final int RECOVERY_KEY_SIZE_BITS = 256;
    private static final byte[] RECOVERY_RESPONSE_HEADER = null;
    private static final byte[] THM_ENCRYPTED_RECOVERY_KEY_HEADER = null;
    private static final byte[] THM_KF_HASH_PREFIX = null;

    static {
        THM_ENCRYPTED_RECOVERY_KEY_HEADER = "V1 THM_encrypted_recovery_key".getBytes(StandardCharsets.UTF_8);
        LOCALLY_ENCRYPTED_RECOVERY_KEY_HEADER = "V1 locally_encrypted_recovery_key".getBytes(StandardCharsets.UTF_8);
        ENCRYPTED_APPLICATION_KEY_HEADER = "V1 encrypted_application_key".getBytes(StandardCharsets.UTF_8);
        RECOVERY_CLAIM_HEADER = "V1 KF_claim".getBytes(StandardCharsets.UTF_8);
        RECOVERY_RESPONSE_HEADER = "V1 reencrypted_recovery_key".getBytes(StandardCharsets.UTF_8);
        THM_KF_HASH_PREFIX = "THM_KF_hash".getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] thmEncryptRecoveryKey(PublicKey publicKey, byte[] lockScreenHash, byte[] vaultParams, SecretKey recoveryKey) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] encryptedRecoveryKey = locallyEncryptRecoveryKey(lockScreenHash, recoveryKey);
        byte[] thmKfHash = calculateThmKfHash(lockScreenHash);
        byte[] header = ArrayUtils.concat(new byte[][]{THM_ENCRYPTED_RECOVERY_KEY_HEADER, vaultParams});
        return SecureBox.encrypt(publicKey, thmKfHash, header, encryptedRecoveryKey);
    }

    public static byte[] calculateThmKfHash(byte[] lockScreenHash) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(THM_KF_HASH_PREFIX);
        messageDigest.update(lockScreenHash);
        return messageDigest.digest();
    }

    static byte[] locallyEncryptRecoveryKey(byte[] lockScreenHash, SecretKey recoveryKey) throws NoSuchAlgorithmException, InvalidKeyException {
        return SecureBox.encrypt(null, lockScreenHash, LOCALLY_ENCRYPTED_RECOVERY_KEY_HEADER, recoveryKey.getEncoded());
    }

    public static SecretKey generateRecoveryKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(RECOVERY_KEY_ALGORITHM);
        keyGenerator.init(256, new SecureRandom());
        return keyGenerator.generateKey();
    }

    public static Map<String, byte[]> encryptKeysWithRecoveryKey(SecretKey recoveryKey, Map<String, Pair<SecretKey, byte[]>> keys) throws NoSuchAlgorithmException, InvalidKeyException {
        HashMap<String, byte[]> encryptedKeys = new HashMap();
        Iterator<String> r1 = keys.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String alias = r1.next();
        SecretKey key = (SecretKey) keys.get(alias).first;
        byte[] metadata = (byte[]) keys.get(alias).second;
        if (metadata != null) goto L8;
        byte[] header = ENCRYPTED_APPLICATION_KEY_HEADER;
    L9:
        byte[] encryptedKey = SecureBox.encrypt(null, recoveryKey.getEncoded(), header, key.getEncoded());
        encryptedKeys.put(alias, encryptedKey);
        goto L4
    L8:
        byte[] header2 = ENCRYPTED_APPLICATION_KEY_HEADER;
        header = ArrayUtils.concat(new byte[][]{header2, metadata});
        goto L9
    L10:
        return encryptedKeys;
    }

    public static byte[] generateKeyClaimant() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        return key;
    }

    public static byte[] encryptRecoveryClaim(PublicKey publicKey, byte[] vaultParams, byte[] challenge, byte[] thmKfHash, byte[] keyClaimant) throws NoSuchAlgorithmException, InvalidKeyException {
        return SecureBox.encrypt(publicKey, null, ArrayUtils.concat(new byte[][]{RECOVERY_CLAIM_HEADER, vaultParams, challenge}), ArrayUtils.concat(new byte[][]{thmKfHash, keyClaimant}));
    }

    public static byte[] decryptRecoveryClaimResponse(byte[] keyClaimant, byte[] vaultParams, byte[] encryptedResponse) throws NoSuchAlgorithmException, InvalidKeyException, AEADBadTagException {
        return SecureBox.decrypt(null, keyClaimant, ArrayUtils.concat(new byte[][]{RECOVERY_RESPONSE_HEADER, vaultParams}), encryptedResponse);
    }

    public static byte[] decryptRecoveryKey(byte[] lskfHash, byte[] encryptedRecoveryKey) throws NoSuchAlgorithmException, InvalidKeyException, AEADBadTagException {
        return SecureBox.decrypt(null, lskfHash, LOCALLY_ENCRYPTED_RECOVERY_KEY_HEADER, encryptedRecoveryKey);
    }

    public static byte[] decryptApplicationKey(byte[] recoveryKey, byte[] encryptedApplicationKey, byte[] applicationKeyMetadata) throws NoSuchAlgorithmException, InvalidKeyException, AEADBadTagException {
        if (applicationKeyMetadata != null) goto L4;
        byte[] header = ENCRYPTED_APPLICATION_KEY_HEADER;
    L6:
        return SecureBox.decrypt(null, recoveryKey, header, encryptedApplicationKey);
    L4:
        byte[] header2 = ENCRYPTED_APPLICATION_KEY_HEADER;
        header = ArrayUtils.concat(new byte[][]{header2, applicationKeyMetadata});
        goto L6
    }

    public static PublicKey deserializePublicKey(byte[] key) throws InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(PUBLIC_KEY_FACTORY_ALGORITHM);     // Catch: NoSuchAlgorithmException -> L5
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(key);
        return keyFactory.generatePublic(publicKeySpec);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static byte[] packVaultParams(PublicKey thmPublicKey, long counterId, int maxAttempts, byte[] vaultHandle) {
        int vaultParamsLength = vaultHandle.length + 77;
        return ByteBuffer.allocate(vaultParamsLength).order(ByteOrder.LITTLE_ENDIAN).put(SecureBox.encodePublicKey(thmPublicKey)).putLong(counterId).putInt(maxAttempts).put(vaultHandle).array();
    }

    private KeySyncUtils() {
    }
}
