package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import g5.f;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AesEaxJce implements Aead {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BLOCK_SIZE_IN_BYTES = 16;
    static final int TAG_SIZE_IN_BYTES = 16;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2476b;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;

    /* renamed from: p, reason: collision with root package name */
    private final byte[] f2477p;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.1
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    };
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.2
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    };

    public AesEaxJce(byte[] bArr, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            z.l("Can not use AES-EAX in FIPS-mode.");
            throw null;
        }
        if (i != 12 && i != 16) {
            f.s("IV size should be either 12 or 16 bytes");
            throw null;
        }
        this.ivSizeInBytes = i;
        Validators.validateAesKeySize(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.keySpec = secretKeySpec;
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrMultiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
        this.f2476b = bArrMultiplyByX;
        this.f2477p = multiplyByX(bArrMultiplyByX);
    }

    private static byte[] multiplyByX(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i3 = i + 1;
            bArr2[i] = (byte) (((bArr[i] << 1) ^ ((bArr[i3] & 255) >>> 7)) & 255);
            i = i3;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private byte[] omac(Cipher cipher, int i, byte[] bArr, int i3, int i10) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i10 == 0) {
            return cipher.doFinal(xor(bArr2, this.f2476b));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i11 = 0;
        while (i10 - i11 > 16) {
            for (int i12 = 0; i12 < 16; i12++) {
                bArrDoFinal[i12] = (byte) (bArrDoFinal[i12] ^ bArr[(i3 + i11) + i12]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i11 += 16;
        }
        return cipher.doFinal(xor(bArrDoFinal, pad(Arrays.copyOfRange(bArr, i11 + i3, i3 + i10))));
    }

    private byte[] pad(byte[] bArr) {
        if (bArr.length == 16) {
            return xor(bArr, this.f2476b);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.f2477p, 16);
        for (int i = 0; i < bArr.length; i++) {
            bArrCopyOf[i] = (byte) (bArrCopyOf[i] ^ bArr[i]);
        }
        bArrCopyOf[bArr.length] = (byte) (bArrCopyOf[bArr.length] ^ 128);
        return bArrCopyOf;
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.ivSizeInBytes) - 16;
        if (length < 0) {
            z.l("ciphertext too short");
            return null;
        }
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, this.keySpec);
        byte[] bArrOmac = omac(cipher, 0, bArr, 0, this.ivSizeInBytes);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrOmac2 = omac(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrOmac3 = omac(cipher, 2, bArr, this.ivSizeInBytes, length);
        int length2 = bArr.length - 16;
        byte b10 = 0;
        for (int i = 0; i < 16; i++) {
            b10 = (byte) (b10 | (((bArr[length2 + i] ^ bArrOmac2[i]) ^ bArrOmac[i]) ^ bArrOmac3[i]));
        }
        if (b10 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = localCtrCipher.get();
        cipher2.init(1, this.keySpec, new IvParameterSpec(bArrOmac));
        return cipher2.doFinal(bArr, this.ivSizeInBytes, length);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.ivSizeInBytes;
        if (length > 2147483631 - i) {
            z.l("plaintext too long");
            return null;
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] bArrRandBytes = Random.randBytes(i);
        System.arraycopy(bArrRandBytes, 0, bArr3, 0, this.ivSizeInBytes);
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, this.keySpec);
        byte[] bArrOmac = omac(cipher, 0, bArrRandBytes, 0, bArrRandBytes.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrOmac2 = omac(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = localCtrCipher.get();
        cipher2.init(1, this.keySpec, new IvParameterSpec(bArrOmac));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.ivSizeInBytes);
        byte[] bArrOmac3 = omac(cipher, 2, bArr3, this.ivSizeInBytes, bArr.length);
        int length2 = bArr.length + this.ivSizeInBytes;
        for (int i3 = 0; i3 < 16; i3++) {
            bArr3[length2 + i3] = (byte) ((bArrOmac2[i3] ^ bArrOmac[i3]) ^ bArrOmac3[i3]);
        }
        return bArr3;
    }
}
