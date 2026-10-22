package com.google.crypto.tink.aead.internal;

import b8.z;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.SubtleUtil;
import com.google.crypto.tink.subtle.Validators;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class InsecureNonceAesGcmJce {
    public static final int IV_SIZE_IN_BYTES = 12;
    public static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;
    private final boolean prependIv;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.aead.internal.InsecureNonceAesGcmJce.1
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    };

    public InsecureNonceAesGcmJce(byte[] bArr, boolean z10) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            z.l("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, "AES");
        this.prependIv = z10;
    }

    private static AlgorithmParameterSpec getParams(byte[] bArr, int i, int i3) {
        return (!SubtleUtil.isAndroid() || SubtleUtil.androidApiLevel() > 19) ? new GCMParameterSpec(128, bArr, i, i3) : new IvParameterSpec(bArr, i, i3);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            z.l("iv is wrong size");
            return null;
        }
        boolean z10 = this.prependIv;
        if (bArr2.length < (z10 ? 28 : 16)) {
            z.l("ciphertext too short");
            return null;
        }
        if (z10 && !ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
            z.l("iv does not match prepended iv");
            return null;
        }
        AlgorithmParameterSpec params = getParams(bArr);
        ThreadLocal<Cipher> threadLocal = localCipher;
        threadLocal.get().init(2, this.keySpec, params);
        if (bArr3 != null && bArr3.length != 0) {
            threadLocal.get().updateAAD(bArr3);
        }
        boolean z11 = this.prependIv;
        return threadLocal.get().doFinal(bArr2, z11 ? 12 : 0, z11 ? bArr2.length - 12 : bArr2.length);
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            z.l("iv is wrong size");
            return null;
        }
        if (bArr2.length > 2147483619) {
            z.l("plaintext too long");
            return null;
        }
        boolean z10 = this.prependIv;
        byte[] bArr4 = new byte[z10 ? bArr2.length + 28 : bArr2.length + 16];
        if (z10) {
            System.arraycopy(bArr, 0, bArr4, 0, 12);
        }
        AlgorithmParameterSpec params = getParams(bArr);
        ThreadLocal<Cipher> threadLocal = localCipher;
        threadLocal.get().init(1, this.keySpec, params);
        if (bArr3 != null && bArr3.length != 0) {
            threadLocal.get().updateAAD(bArr3);
        }
        int iDoFinal = threadLocal.get().doFinal(bArr2, 0, bArr2.length, bArr4, this.prependIv ? 12 : 0);
        if (iDoFinal == bArr2.length + 16) {
            return bArr4;
        }
        throw new GeneralSecurityException(a.k(iDoFinal - bArr2.length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
    }

    private static AlgorithmParameterSpec getParams(byte[] bArr) {
        return getParams(bArr, 0, bArr.length);
    }
}
