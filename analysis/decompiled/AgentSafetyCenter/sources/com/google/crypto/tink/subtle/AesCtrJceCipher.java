package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private final int blockSize;
    private final int ivSize;
    private final SecretKeySpec keySpec;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesCtrJceCipher.1
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance(AesCtrJceCipher.CIPHER_ALGORITHM);
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    };

    public AesCtrJceCipher(byte[] bArr, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            z.l("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
        int blockSize = localCipher.get().getBlockSize();
        this.blockSize = blockSize;
        if (i < 12 || i > blockSize) {
            z.l("invalid IV size");
            throw null;
        }
        this.ivSize = i;
    }

    private void doCtr(byte[] bArr, int i, int i3, byte[] bArr2, int i10, byte[] bArr3, boolean z10) throws GeneralSecurityException {
        Cipher cipher = localCipher.get();
        byte[] bArr4 = new byte[this.blockSize];
        System.arraycopy(bArr3, 0, bArr4, 0, this.ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.keySpec;
        if (z10) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i3, bArr2, i10) == i3) {
            return;
        }
        z.l("stored output's length does not match input's length");
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.ivSize;
        if (length < i) {
            z.l("ciphertext too short");
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int length2 = bArr.length;
        int i3 = this.ivSize;
        byte[] bArr3 = new byte[length2 - i3];
        doCtr(bArr, i3, bArr.length - i3, bArr3, 0, bArr2, false);
        return bArr3;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.ivSize;
        if (length > Reader.READ_DONE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Reader.READ_DONE - this.ivSize));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] bArrRandBytes = Random.randBytes(i);
        System.arraycopy(bArrRandBytes, 0, bArr2, 0, this.ivSize);
        doCtr(bArr, 0, bArr.length, bArr2, this.ivSize, bArrRandBytes, true);
        return bArr2;
    }
}
