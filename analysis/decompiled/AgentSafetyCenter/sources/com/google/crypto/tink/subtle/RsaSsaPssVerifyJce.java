package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class RsaSsaPssVerifyJce implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final Enums.HashType mgf1Hash;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssVerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            z.l("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i;
    }

    private void emsaPssVerify(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(bArr);
        int digestLength = engineFactory.getDigestLength();
        int length = bArr2.length;
        if (length < this.saltLength + digestLength + 2) {
            z.l("inconsistent");
            return;
        }
        byte b10 = 1;
        if (bArr2[bArr2.length - 1] != -68) {
            z.l("inconsistent");
            return;
        }
        int i3 = (length - digestLength) - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArr2, i3);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, bArrCopyOf.length, bArrCopyOf.length + digestLength);
        int i10 = 0;
        while (true) {
            int i11 = i10;
            byte b11 = b10;
            int i12 = i3;
            long j10 = (length * 8) - i;
            if (i10 < j10) {
                if (((bArrCopyOf[i11 / 8] >> (7 - (i11 % 8))) & 1) != 0) {
                    z.l("inconsistent");
                    return;
                } else {
                    i10 = i11 + 1;
                    b10 = b11;
                    i3 = i12;
                }
            } else {
                byte[] bArrMgf1 = SubtleUtil.mgf1(bArrCopyOfRange, i12, this.mgf1Hash);
                int length2 = bArrMgf1.length;
                byte[] bArr3 = new byte[length2];
                for (int i13 = 0; i13 < length2; i13++) {
                    bArr3[i13] = (byte) (bArrMgf1[i13] ^ bArrCopyOf[i13]);
                }
                for (int i14 = 0; i14 <= j10; i14++) {
                    int i15 = i14 / 8;
                    bArr3[i15] = (byte) ((~(b11 << (7 - (i14 % 8)))) & bArr3[i15]);
                }
                int i16 = 0;
                while (true) {
                    int i17 = this.saltLength;
                    if (i16 >= (r6 - i17) - 2) {
                        if (bArr3[(r6 - i17) - 2] != b11) {
                            z.l("inconsistent");
                            return;
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr3, length2 - i17, length2);
                        int i18 = digestLength + 8;
                        byte[] bArr4 = new byte[this.saltLength + i18];
                        System.arraycopy(bArrDigest, 0, bArr4, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr4, i18, bArrCopyOfRange2.length);
                        if (Bytes.equal(engineFactory.digest(bArr4), bArrCopyOfRange)) {
                            return;
                        }
                        z.l("inconsistent");
                        return;
                    }
                    if (bArr3[i16] != 0) {
                        z.l("inconsistent");
                        return;
                    }
                    i16++;
                }
            }
        }
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        int iBitLength2 = (modulus.bitLength() + 6) / 8;
        if (iBitLength != bArr.length) {
            z.l("invalid signature's length");
            return;
        }
        BigInteger bigIntegerBytes2Integer = SubtleUtil.bytes2Integer(bArr);
        if (bigIntegerBytes2Integer.compareTo(modulus) < 0) {
            emsaPssVerify(bArr2, SubtleUtil.integer2Bytes(bigIntegerBytes2Integer.modPow(publicExponent, modulus), iBitLength2), modulus.bitLength() - 1);
        } else {
            z.l("signature out of range");
        }
    }
}
