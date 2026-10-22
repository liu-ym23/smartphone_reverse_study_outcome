package org.bouncycastle.crypto.signers;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.Prehash;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSABlindingParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class PSSSigner implements Signer {
    public static final byte TRAILER_IMPLICIT = -68;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest contentDigest1;
    private Digest contentDigest2;
    private int emBits;
    private int hLen;
    private byte[] mDash;
    private Digest mgfDigest;
    private int mgfhLen;
    private SecureRandom random;
    private int sLen;
    private boolean sSet;
    private byte[] salt;
    private byte trailer;

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i8) {
        this(asymmetricBlockCipher, digest, i8, TRAILER_IMPLICIT);
    }

    private void ItoOSP(int i8, byte[] bArr) {
        bArr[0] = (byte) (i8 >>> 24);
        bArr[1] = (byte) (i8 >>> 16);
        bArr[2] = (byte) (i8 >>> 8);
        bArr[3] = (byte) i8;
    }

    private void clearBlock(byte[] bArr) {
        for (int i8 = 0; i8 != bArr.length; i8++) {
            bArr[i8] = 0;
        }
    }

    public static PSSSigner createRawSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        return new PSSSigner(asymmetricBlockCipher, Prehash.forDigest(digest), digest, digest, digest.getDigestSize(), TRAILER_IMPLICIT);
    }

    private byte[] maskGenerator(byte[] bArr, int i8, int i9, int i10) {
        Digest digest = this.mgfDigest;
        if (!(digest instanceof Xof)) {
            return maskGeneratorFunction1(bArr, i8, i9, i10);
        }
        byte[] bArr2 = new byte[i10];
        digest.update(bArr, i8, i9);
        ((Xof) this.mgfDigest).doFinal(bArr2, 0, i10);
        return bArr2;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i8, int i9, int i10) {
        int i11;
        byte[] bArr2 = new byte[i10];
        byte[] bArr3 = new byte[this.mgfhLen];
        byte[] bArr4 = new byte[4];
        this.mgfDigest.reset();
        int i12 = 0;
        while (true) {
            i11 = this.mgfhLen;
            if (i12 >= i10 / i11) {
                break;
            }
            ItoOSP(i12, bArr4);
            this.mgfDigest.update(bArr, i8, i9);
            this.mgfDigest.update(bArr4, 0, 4);
            this.mgfDigest.doFinal(bArr3, 0);
            int i13 = this.mgfhLen;
            System.arraycopy(bArr3, 0, bArr2, i12 * i13, i13);
            i12++;
        }
        if (i11 * i12 < i10) {
            ItoOSP(i12, bArr4);
            this.mgfDigest.update(bArr, i8, i9);
            this.mgfDigest.update(bArr4, 0, 4);
            this.mgfDigest.doFinal(bArr3, 0);
            int i14 = i12 * this.mgfhLen;
            System.arraycopy(bArr3, 0, bArr2, i14, i10 - i14);
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        int digestSize = this.contentDigest1.getDigestSize();
        int i8 = this.hLen;
        if (digestSize != i8) {
            throw new IllegalStateException();
        }
        Digest digest = this.contentDigest1;
        byte[] bArr = this.mDash;
        digest.doFinal(bArr, (bArr.length - i8) - this.sLen);
        if (this.sLen != 0) {
            if (!this.sSet) {
                this.random.nextBytes(this.salt);
            }
            byte[] bArr2 = this.salt;
            byte[] bArr3 = this.mDash;
            int length = bArr3.length;
            int i9 = this.sLen;
            System.arraycopy(bArr2, 0, bArr3, length - i9, i9);
        }
        int i10 = this.hLen;
        byte[] bArr4 = new byte[i10];
        Digest digest2 = this.contentDigest2;
        byte[] bArr5 = this.mDash;
        digest2.update(bArr5, 0, bArr5.length);
        this.contentDigest2.doFinal(bArr4, 0);
        byte[] bArr6 = this.block;
        int length2 = bArr6.length;
        int i11 = this.sLen;
        int i12 = this.hLen;
        bArr6[(((length2 - i11) - 1) - i12) - 1] = 1;
        System.arraycopy(this.salt, 0, bArr6, ((bArr6.length - i11) - i12) - 1, i11);
        byte[] bArrMaskGenerator = maskGenerator(bArr4, 0, i10, (this.block.length - this.hLen) - 1);
        for (int i13 = 0; i13 != bArrMaskGenerator.length; i13++) {
            byte[] bArr7 = this.block;
            bArr7[i13] = (byte) (bArr7[i13] ^ bArrMaskGenerator[i13]);
        }
        byte[] bArr8 = this.block;
        int length3 = bArr8.length;
        int i14 = this.hLen;
        System.arraycopy(bArr4, 0, bArr8, (length3 - i14) - 1, i14);
        byte[] bArr9 = this.block;
        bArr9[0] = (byte) ((255 >>> ((bArr9.length * 8) - this.emBits)) & bArr9[0]);
        bArr9[bArr9.length - 1] = this.trailer;
        byte[] bArrProcessBlock = this.cipher.processBlock(bArr9, 0, bArr9.length);
        clearBlock(this.block);
        return bArrProcessBlock;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        CipherParameters parameters;
        RSAKeyParameters publicKey;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            parameters = parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            if (z) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            parameters = cipherParameters;
        }
        if (parameters instanceof RSABlindingParameters) {
            publicKey = ((RSABlindingParameters) parameters).getPublicKey();
            this.cipher.init(z, cipherParameters);
        } else {
            publicKey = (RSAKeyParameters) parameters;
            this.cipher.init(z, parameters);
        }
        int iBitLength = publicKey.getModulus().bitLength();
        int i8 = iBitLength - 1;
        this.emBits = i8;
        if (i8 < (this.sLen * 8) + (this.hLen * 8) + 9) {
            throw new IllegalArgumentException("key too small for specified hash and salt lengths");
        }
        this.block = new byte[(iBitLength + 6) / 8];
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.contentDigest1.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b9) {
        this.contentDigest1.update(b9);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        int length;
        byte b9;
        int digestSize = this.contentDigest1.getDigestSize();
        int i8 = this.hLen;
        if (digestSize != i8) {
            throw new IllegalStateException();
        }
        Digest digest = this.contentDigest1;
        byte[] bArr3 = this.mDash;
        digest.doFinal(bArr3, (bArr3.length - i8) - this.sLen);
        try {
            byte[] bArrProcessBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            byte[] bArr4 = this.block;
            Arrays.fill(bArr4, 0, bArr4.length - bArrProcessBlock.length, (byte) 0);
            byte[] bArr5 = this.block;
            System.arraycopy(bArrProcessBlock, 0, bArr5, bArr5.length - bArrProcessBlock.length, bArrProcessBlock.length);
            bArr2 = this.block;
            length = 255 >>> ((bArr2.length * 8) - this.emBits);
            b9 = bArr2[0];
        } catch (Exception unused) {
        }
        if ((b9 & 255) != (b9 & length) || bArr2[bArr2.length - 1] != this.trailer) {
            clearBlock(bArr2);
            return false;
        }
        int length2 = bArr2.length;
        int i9 = this.hLen;
        byte[] bArrMaskGenerator = maskGenerator(bArr2, (length2 - i9) - 1, i9, (bArr2.length - i9) - 1);
        for (int i10 = 0; i10 != bArrMaskGenerator.length; i10++) {
            byte[] bArr6 = this.block;
            bArr6[i10] = (byte) (bArr6[i10] ^ bArrMaskGenerator[i10]);
        }
        byte[] bArr7 = this.block;
        bArr7[0] = (byte) (length & bArr7[0]);
        int i11 = 0;
        while (true) {
            byte[] bArr8 = this.block;
            int length3 = bArr8.length;
            int i12 = this.hLen;
            int i13 = this.sLen;
            if (i11 != ((length3 - i12) - i13) - 2) {
                if (bArr8[i11] != 0) {
                    clearBlock(bArr8);
                    return false;
                }
                i11++;
            } else {
                if (bArr8[((bArr8.length - i12) - i13) - 2] != 1) {
                    clearBlock(bArr8);
                    return false;
                }
                if (this.sSet) {
                    byte[] bArr9 = this.salt;
                    byte[] bArr10 = this.mDash;
                    System.arraycopy(bArr9, 0, bArr10, bArr10.length - i13, i13);
                } else {
                    int length4 = ((bArr8.length - i13) - i12) - 1;
                    byte[] bArr11 = this.mDash;
                    System.arraycopy(bArr8, length4, bArr11, bArr11.length - i13, i13);
                }
                Digest digest2 = this.contentDigest2;
                byte[] bArr12 = this.mDash;
                digest2.update(bArr12, 0, bArr12.length);
                Digest digest3 = this.contentDigest2;
                byte[] bArr13 = this.mDash;
                digest3.doFinal(bArr13, bArr13.length - this.hLen);
                int length5 = this.block.length;
                int i14 = this.hLen;
                int i15 = (length5 - i14) - 1;
                int length6 = this.mDash.length - i14;
                while (true) {
                    byte[] bArr14 = this.mDash;
                    if (length6 == bArr14.length) {
                        clearBlock(bArr14);
                        clearBlock(this.block);
                        return true;
                    }
                    if ((this.block[i15] ^ bArr14[length6]) != 0) {
                        clearBlock(bArr14);
                        clearBlock(this.block);
                        return false;
                    }
                    i15++;
                    length6++;
                }
            }
        }
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i8, byte b9) {
        this(asymmetricBlockCipher, digest, digest, i8, b9);
    }

    public static PSSSigner createRawSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i8, byte b9) {
        return new PSSSigner(asymmetricBlockCipher, Prehash.forDigest(digest), digest, digest2, i8, b9);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i8, int i9) {
        this.contentDigest1.update(bArr, i8, i9);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i8) {
        this(asymmetricBlockCipher, digest, digest2, i8, TRAILER_IMPLICIT);
    }

    public static PSSSigner createRawSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr, byte b9) {
        return new PSSSigner(asymmetricBlockCipher, Prehash.forDigest(digest), digest, digest2, bArr, b9);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i8, byte b9) {
        this(asymmetricBlockCipher, digest, digest, digest2, i8, b9);
    }

    private PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, Digest digest3, int i8, byte b9) {
        this.cipher = asymmetricBlockCipher;
        this.contentDigest1 = digest;
        this.contentDigest2 = digest2;
        this.mgfDigest = digest3;
        this.hLen = digest2.getDigestSize();
        this.mgfhLen = digest3.getDigestSize();
        this.sSet = false;
        this.sLen = i8;
        this.salt = new byte[i8];
        this.mDash = new byte[i8 + 8 + this.hLen];
        this.trailer = b9;
    }

    private PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, Digest digest3, byte[] bArr, byte b9) {
        this.cipher = asymmetricBlockCipher;
        this.contentDigest1 = digest;
        this.contentDigest2 = digest2;
        this.mgfDigest = digest3;
        this.hLen = digest2.getDigestSize();
        this.mgfhLen = digest3.getDigestSize();
        this.sSet = true;
        int length = bArr.length;
        this.sLen = length;
        this.salt = bArr;
        this.mDash = new byte[length + 8 + this.hLen];
        this.trailer = b9;
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest2, bArr, TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr, byte b9) {
        this(asymmetricBlockCipher, digest, digest, digest2, bArr, b9);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr, TRAILER_IMPLICIT);
    }
}
