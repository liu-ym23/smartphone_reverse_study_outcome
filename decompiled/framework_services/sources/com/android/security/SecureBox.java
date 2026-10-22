package com.android.security;

import com.android.internal.util.ArrayUtils;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class SecureBox {
    private static final BigInteger BIG_INT_02 = null;
    private static final String CIPHER_ALG = "AES";
    private static final byte[] CONSTANT_01 = null;
    private static final String EC_ALG = "EC";
    private static final int EC_COORDINATE_LEN_BYTES = 32;
    private static final String EC_P256_COMMON_NAME = "secp256r1";
    private static final String EC_P256_OPENSSL_NAME = "prime256v1";
    private static final BigInteger EC_PARAM_A = null;
    private static final BigInteger EC_PARAM_B = null;
    private static final BigInteger EC_PARAM_P = null;
    static final ECParameterSpec EC_PARAM_SPEC = null;
    private static final int EC_PUBLIC_KEY_LEN_BYTES = 65;
    private static final byte EC_PUBLIC_KEY_PREFIX = 4;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final String ENC_ALG = "AES/GCM/NoPadding";
    private static final int GCM_KEY_LEN_BYTES = 16;
    private static final int GCM_NONCE_LEN_BYTES = 12;
    private static final int GCM_TAG_LEN_BYTES = 16;
    private static final byte[] HKDF_INFO_WITHOUT_PUBLIC_KEY = null;
    private static final byte[] HKDF_INFO_WITH_PUBLIC_KEY = null;
    private static final byte[] HKDF_SALT = null;
    private static final String KA_ALG = "ECDH";
    private static final String MAC_ALG = "HmacSHA256";
    private static final byte[] VERSION = null;

    private static final enum AesGcmOperation extends Enum<AesGcmOperation> {
        private static final /* synthetic */ AesGcmOperation[] $VALUES = null;
        public static final AesGcmOperation DECRYPT = null;
        public static final AesGcmOperation ENCRYPT = null;

        private static /* synthetic */ AesGcmOperation[] $values() {
            return new AesGcmOperation[]{ENCRYPT, DECRYPT};
        }

        private AesGcmOperation(String r1, int r2) {
            super(r1, r2);
        }

        public static AesGcmOperation valueOf(String name) {
            return (AesGcmOperation) Enum.valueOf(AesGcmOperation.class, name);
        }

        public static AesGcmOperation[] values() {
            return (AesGcmOperation[]) $VALUES.clone();
        }

        static {
            ENCRYPT = new AesGcmOperation("ENCRYPT", 0);
            DECRYPT = new AesGcmOperation("DECRYPT", 1);
            $VALUES = $values();
        }
    }

    static {
        VERSION = new byte[]{2, 0};
        HKDF_SALT = ArrayUtils.concat(new byte[][]{"SECUREBOX".getBytes(StandardCharsets.UTF_8), VERSION});
        HKDF_INFO_WITH_PUBLIC_KEY = "P256 HKDF-SHA-256 AES-128-GCM".getBytes(StandardCharsets.UTF_8);
        HKDF_INFO_WITHOUT_PUBLIC_KEY = "SHARED HKDF-SHA-256 AES-128-GCM".getBytes(StandardCharsets.UTF_8);
        CONSTANT_01 = new byte[]{1};
        EMPTY_BYTE_ARRAY = new byte[0];
        BIG_INT_02 = BigInteger.valueOf(2);
        EC_PARAM_P = new BigInteger("ffffffff00000001000000000000000000000000ffffffffffffffffffffffff", 16);
        EC_PARAM_A = EC_PARAM_P.subtract(new BigInteger("3"));
        EC_PARAM_B = new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16);
        EllipticCurve curveSpec = new EllipticCurve(new ECFieldFp(EC_PARAM_P), EC_PARAM_A, EC_PARAM_B);
        ECPoint generator = new ECPoint(new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16), new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16));
        BigInteger generatorOrder = new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
        EC_PARAM_SPEC = new ECParameterSpec(curveSpec, generator, generatorOrder, 1);
    }

    private SecureBox() {
    }

    public static KeyPair genKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EC_ALG);
        keyPairGenerator.initialize(new ECGenParameterSpec(EC_P256_OPENSSL_NAME));     // Catch: InvalidAlgorithmParameterException -> L5
        return keyPairGenerator.generateKeyPair();
    L13:
        keyPairGenerator.initialize(new ECGenParameterSpec(EC_P256_COMMON_NAME));     // Catch: InvalidAlgorithmParameterException -> L8
        return keyPairGenerator.generateKeyPair();
    L8:
        ex = move-exception;
        throw new NoSuchAlgorithmException("Unable to find the NIST P-256 curve", ex);
    }

    public static byte[] encrypt(PublicKey theirPublicKey, byte[] sharedSecret, byte[] header, byte[] payload) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] sharedSecret2 = emptyByteArrayIfNull(sharedSecret);
        if (theirPublicKey == null) goto L5;
    L9:
        byte[] header2 = emptyByteArrayIfNull(header);
        byte[] payload2 = emptyByteArrayIfNull(payload);
        if (theirPublicKey != null) goto L12;
        KeyPair senderKeyPair = null;
        byte[] dhSecret = EMPTY_BYTE_ARRAY;
        byte[] hkdfInfo = HKDF_INFO_WITHOUT_PUBLIC_KEY;
    L13:
        byte[] randNonce = genRandomNonce();
        byte[] keyingMaterial = ArrayUtils.concat(new byte[][]{dhSecret, sharedSecret2});
        SecretKey encryptionKey = hkdfDeriveKey(keyingMaterial, HKDF_SALT, hkdfInfo);
        byte[] ciphertext = aesGcmEncrypt(encryptionKey, randNonce, payload2, header2);
        if (senderKeyPair != null) goto L18;
        return ArrayUtils.concat(new byte[][]{VERSION, randNonce, ciphertext});
    L18:
        return ArrayUtils.concat(new byte[][]{VERSION, encodePublicKey(senderKeyPair.getPublic()), randNonce, ciphertext});
    L12:
        senderKeyPair = genKeyPair();
        dhSecret = dhComputeSecret(senderKeyPair.getPrivate(), theirPublicKey);
        hkdfInfo = HKDF_INFO_WITH_PUBLIC_KEY;
        goto L13
    L5:
        if (sharedSecret2.length != 0) goto L9;
        throw new IllegalArgumentException("Both the public key and shared secret are empty");
    }

    public static byte[] decrypt(PrivateKey ourPrivateKey, byte[] sharedSecret, byte[] header, byte[] encryptedPayload) throws NoSuchAlgorithmException, InvalidKeyException, AEADBadTagException {
        byte[] sharedSecret2 = emptyByteArrayIfNull(sharedSecret);
        if (ourPrivateKey == null) goto L5;
    L9:
        byte[] header2 = emptyByteArrayIfNull(header);
        if (encryptedPayload == null) goto L21;
        ByteBuffer ciphertextBuffer = ByteBuffer.wrap(encryptedPayload);
        byte[] version = readEncryptedPayload(ciphertextBuffer, VERSION.length);
        if (Arrays.equals(version, VERSION) == false) goto L19;
        if (ourPrivateKey != null) goto L15;
        byte[] senderPublicKeyBytes = EMPTY_BYTE_ARRAY;
        byte[] dhSecret = HKDF_INFO_WITHOUT_PUBLIC_KEY;
    L16:
        byte[] randNonce = readEncryptedPayload(ciphertextBuffer, 12);
        byte[] ciphertext = readEncryptedPayload(ciphertextBuffer, ciphertextBuffer.remaining());
        byte[] keyingMaterial = ArrayUtils.concat(new byte[][]{senderPublicKeyBytes, sharedSecret2});
        SecretKey decryptionKey = hkdfDeriveKey(keyingMaterial, HKDF_SALT, dhSecret);
        return aesGcmDecrypt(decryptionKey, randNonce, ciphertext, header2);
    L15:
        byte[] senderPublicKeyBytes2 = readEncryptedPayload(ciphertextBuffer, 65);
        byte[] dhSecret2 = dhComputeSecret(ourPrivateKey, decodePublicKey(senderPublicKeyBytes2));
        senderPublicKeyBytes = dhSecret2;
        dhSecret = HKDF_INFO_WITH_PUBLIC_KEY;
        goto L16
    L19:
        throw new AEADBadTagException("The payload was not encrypted by SecureBox v2");
    L21:
        throw new NullPointerException("Encrypted payload must not be null.");
    L5:
        if (sharedSecret2.length != 0) goto L9;
        throw new IllegalArgumentException("Both the private key and shared secret are empty");
    }

    private static byte[] readEncryptedPayload(ByteBuffer buffer, int length) throws AEADBadTagException {
        byte[] output = new byte[length];
        buffer.get(output);     // Catch: BufferUnderflowException -> L5
        return output;
    L7:
        throw new AEADBadTagException("The encrypted payload is too short");
    }

    private static byte[] dhComputeSecret(PrivateKey ourPrivateKey, PublicKey theirPublicKey) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyAgreement agreement = KeyAgreement.getInstance(KA_ALG);
        agreement.init(ourPrivateKey);     // Catch: RuntimeException -> L6
        agreement.doPhase(theirPublicKey, true);
        return agreement.generateSecret();
    L6:
        ex = move-exception;
        throw new InvalidKeyException(ex);
    }

    private static SecretKey hkdfDeriveKey(byte[] secret, byte[] salt, byte[] info) throws NoSuchAlgorithmException {
        Mac mac = Mac.getInstance(MAC_ALG);
        mac.init(new SecretKeySpec(salt, MAC_ALG));     // Catch: InvalidKeyException -> L11
        byte[] pseudorandomKey = mac.doFinal(secret);
        mac.init(new SecretKeySpec(pseudorandomKey, MAC_ALG));     // Catch: InvalidKeyException -> L8
        mac.update(info);
        byte[] hkdfOutput = mac.doFinal(CONSTANT_01);
        return new SecretKeySpec(Arrays.copyOf(hkdfOutput, 16), CIPHER_ALG);
    L8:
        ex = move-exception;
        throw new RuntimeException(ex);
    L11:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    private static byte[] aesGcmEncrypt(SecretKey key, byte[] nonce, byte[] plaintext, byte[] aad) throws NoSuchAlgorithmException, InvalidKeyException {
        return aesGcmInternal(AesGcmOperation.ENCRYPT, key, nonce, plaintext, aad);
    L4:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    private static byte[] aesGcmDecrypt(SecretKey key, byte[] nonce, byte[] ciphertext, byte[] aad) throws NoSuchAlgorithmException, InvalidKeyException, AEADBadTagException {
        return aesGcmInternal(AesGcmOperation.DECRYPT, key, nonce, ciphertext, aad);
    }

    private static byte[] aesGcmInternal(AesGcmOperation operation, SecretKey key, byte[] nonce, byte[] text, byte[] aad) throws NoSuchAlgorithmException, InvalidKeyException, AEADBadTagException {
        Cipher cipher = Cipher.getInstance(ENC_ALG);     // Catch: NoSuchPaddingException -> L23
        GCMParameterSpec spec = new GCMParameterSpec(128, nonce);
    L7:
        ex = move-exception;
        throw new RuntimeException(ex);
    L5:
        if (operation != AesGcmOperation.DECRYPT) goto L9;
        cipher.init(2, key, spec);     // Catch: InvalidAlgorithmParameterException -> L7
    L29:
        cipher.updateAAD(aad);     // Catch: Throwable -> L13 AEADBadTagException -> L15
        return cipher.doFinal(text);
    L15:
        ex = move-exception;
        throw ex;
    L13:
        ex = move-exception;
        throw new RuntimeException(ex);
    L9:
        cipher.init(1, key, spec);     // Catch: InvalidAlgorithmParameterException -> L7
    L23:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    public static byte[] encodePublicKey(PublicKey publicKey) {
        ECPoint point = ((ECPublicKey) publicKey).getW();
        byte[] x = point.getAffineX().toByteArray();
        byte[] y = point.getAffineY().toByteArray();
        byte[] output = new byte[65];
        System.arraycopy(y, 0, output, 65 - y.length, y.length);
        System.arraycopy(x, 0, output, 33 - x.length, x.length);
        output[0] = 4;
        return output;
    }

    public static PublicKey decodePublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeyException {
        BigInteger x = new BigInteger(1, Arrays.copyOfRange(keyBytes, 1, 33));
        BigInteger y = new BigInteger(1, Arrays.copyOfRange(keyBytes, 33, 65));
        validateEcPoint(x, y);
        KeyFactory keyFactory = KeyFactory.getInstance(EC_ALG);
        return keyFactory.generatePublic(new ECPublicKeySpec(new ECPoint(x, y), EC_PARAM_SPEC));
    L5:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    private static void validateEcPoint(BigInteger x, BigInteger y) throws InvalidKeyException {
        if (x.compareTo(EC_PARAM_P) >= 0) goto L16;
        if (y.compareTo(EC_PARAM_P) >= 0) goto L16;
        if (x.signum() == (-1)) goto L16;
        if (y.signum() == (-1)) goto L16;
        BigInteger lhs = y.modPow(BIG_INT_02, EC_PARAM_P);
        BigInteger rhs = x.modPow(BIG_INT_02, EC_PARAM_P).add(EC_PARAM_A).mod(EC_PARAM_P).multiply(x).add(EC_PARAM_B).mod(EC_PARAM_P);
        if (lhs.equals(rhs) == false) goto L14;
        return;
    L14:
        throw new InvalidKeyException("Point lies outside of the expected curve");
    L16:
        throw new InvalidKeyException("Point lies outside of the expected curve");
    }

    private static byte[] genRandomNonce() throws NoSuchAlgorithmException {
        byte[] nonce = new byte[12];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    private static byte[] emptyByteArrayIfNull(byte[] input) {
        if (input != null) goto L5;
        return EMPTY_BYTE_ARRAY;
    L5:
        return input;
    }
}
