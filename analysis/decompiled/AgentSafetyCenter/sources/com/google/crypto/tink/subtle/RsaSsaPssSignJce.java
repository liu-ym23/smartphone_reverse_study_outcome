package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            z.l("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPrivateCrtKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPrivateCrtKey.getPublicExponent());
        this.privateKey = rSAPrivateCrtKey;
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
        this.sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i;
    }

    private byte[] emsaPssEncode(byte[] bArr, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(bArr);
        int digestLength = engineFactory.getDigestLength();
        int i3 = ((i - 1) / 8) + 1;
        int i10 = this.saltLength;
        if (i3 < digestLength + i10 + 2) {
            z.l("encoding error");
            return null;
        }
        byte[] bArrRandBytes = Random.randBytes(i10);
        int i11 = digestLength + 8;
        byte[] bArr2 = new byte[this.saltLength + i11];
        System.arraycopy(bArrDigest, 0, bArr2, 8, digestLength);
        System.arraycopy(bArrRandBytes, 0, bArr2, i11, bArrRandBytes.length);
        byte[] bArrDigest2 = engineFactory.digest(bArr2);
        int i12 = (i3 - digestLength) - 1;
        byte[] bArr3 = new byte[i12];
        int i13 = this.saltLength;
        bArr3[((i3 - i13) - digestLength) - 2] = 1;
        System.arraycopy(bArrRandBytes, 0, bArr3, ((i3 - i13) - digestLength) - 1, bArrRandBytes.length);
        byte[] bArrMgf1 = SubtleUtil.mgf1(bArrDigest2, i12, this.mgf1Hash);
        byte[] bArr4 = new byte[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            bArr4[i14] = (byte) (bArr3[i14] ^ bArrMgf1[i14]);
        }
        for (int i15 = 0; i15 < (i3 * 8) - i; i15++) {
            int i16 = i15 / 8;
            bArr4[i16] = (byte) ((~(1 << (7 - (i15 % 8)))) & bArr4[i16]);
        }
        int i17 = digestLength + i12;
        byte[] bArr5 = new byte[i17 + 1];
        System.arraycopy(bArr4, 0, bArr5, 0, i12);
        System.arraycopy(bArrDigest2, 0, bArr5, i12, bArrDigest2.length);
        bArr5[i17] = -68;
        return bArr5;
    }

    private byte[] rsasp1(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        EngineFactory<EngineWrapper.TCipher, Cipher> engineFactory = EngineFactory.CIPHER;
        Cipher engineFactory2 = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        engineFactory2.init(2, this.privateKey);
        byte[] bArrDoFinal = engineFactory2.doFinal(bArr);
        Cipher engineFactory3 = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        engineFactory3.init(1, this.publicKey);
        if (new BigInteger(1, bArr).equals(new BigInteger(1, engineFactory3.doFinal(bArrDoFinal)))) {
            return bArrDoFinal;
        }
        f.o("Security bug: RSA signature computation error");
        return null;
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) {
        return rsasp1(emsaPssEncode(bArr, this.publicKey.getModulus().bitLength() - 1));
    }
}
