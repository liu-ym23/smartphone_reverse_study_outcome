package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class OAEPEncoding implements AsymmetricBlockCipher {
    private final byte[] defHash;
    private final AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private final Digest mgf1Hash;
    private final int mgf1NoMemoLimit;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, DigestFactory.createSHA1(), null);
    }

    private static int getMGF1NoMemoLimit(Digest digest) {
        if ((digest instanceof Memoable) && (digest instanceof ExtendedDigest)) {
            return ((ExtendedDigest) digest).getByteLength() - 1;
        }
        return Integer.MAX_VALUE;
    }

    private void maskGeneratorFunction1(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, int i11) {
        int i12;
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        int i13 = i11 + i10;
        int i14 = i13 - digestSize;
        this.mgf1Hash.update(bArr, i8, i9);
        if (i9 > this.mgf1NoMemoLimit) {
            Memoable memoable = (Memoable) this.mgf1Hash;
            Memoable memoableCopy = memoable.copy();
            i12 = 0;
            while (i10 < i14) {
                Pack.intToBigEndian(i12, bArr4, 0);
                this.mgf1Hash.update(bArr4, 0, 4);
                this.mgf1Hash.doFinal(bArr3, 0);
                memoable.reset(memoableCopy);
                Bytes.xorTo(digestSize, bArr3, 0, bArr2, i10);
                i10 += digestSize;
                i12++;
            }
        } else {
            int i15 = i10;
            int i16 = 0;
            while (i15 < i14) {
                Pack.intToBigEndian(i16, bArr4, 0);
                this.mgf1Hash.update(bArr4, 0, 4);
                this.mgf1Hash.doFinal(bArr3, 0);
                this.mgf1Hash.update(bArr, i8, i9);
                Bytes.xorTo(digestSize, bArr3, 0, bArr2, i15);
                i15 += digestSize;
                i16++;
            }
            i12 = i16;
            i10 = i15;
        }
        Pack.intToBigEndian(i12, bArr4, 0);
        this.mgf1Hash.update(bArr4, 0, 4);
        this.mgf1Hash.doFinal(bArr3, 0);
        Bytes.xorTo(i13 - i10, bArr3, 0, bArr2, i10);
    }

    public byte[] decodeBlock(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        byte[] bArr2;
        int outputBlockSize = getOutputBlockSize();
        int outputBlockSize2 = this.engine.getOutputBlockSize();
        byte[] bArr3 = new byte[outputBlockSize2];
        byte[] bArrProcessBlock = this.engine.processBlock(bArr, i8, i9);
        int length = ((outputBlockSize2 - bArrProcessBlock.length) | outputBlockSize) >> 31;
        int iMin = Math.min(outputBlockSize2, bArrProcessBlock.length);
        System.arraycopy(bArrProcessBlock, 0, bArr3, outputBlockSize2 - iMin, iMin);
        Arrays.fill(bArrProcessBlock, (byte) 0);
        this.mgf1Hash.reset();
        byte[] bArr4 = this.defHash;
        maskGeneratorFunction1(bArr3, bArr4.length, outputBlockSize2 - bArr4.length, bArr3, 0, bArr4.length);
        byte[] bArr5 = this.defHash;
        maskGeneratorFunction1(bArr3, 0, bArr5.length, bArr3, bArr5.length, outputBlockSize2 - bArr5.length);
        int i10 = 0;
        while (true) {
            bArr2 = this.defHash;
            if (i10 == bArr2.length) {
                break;
            }
            length |= bArr3[bArr2.length + i10] ^ bArr2[i10];
            i10++;
        }
        int i11 = -1;
        for (int length2 = bArr2.length * 2; length2 != outputBlockSize2; length2++) {
            i11 += (((-(bArr3[length2] & 255)) & i11) >> 31) & length2;
        }
        if (((i11 >> 31) | length | (bArr3[i11 + 1] ^ 1)) != 0) {
            Arrays.fill(bArr3, (byte) 0);
            throw new InvalidCipherTextException("data wrong");
        }
        int i12 = i11 + 2;
        int i13 = outputBlockSize2 - i12;
        byte[] bArr6 = new byte[i13];
        System.arraycopy(bArr3, i12, bArr6, 0, i13);
        Arrays.fill(bArr3, (byte) 0);
        return bArr6;
    }

    public byte[] encodeBlock(byte[] bArr, int i8, int i9) {
        int inputBlockSize = getInputBlockSize();
        if (i9 > inputBlockSize) {
            throw new DataLengthException("input data too long");
        }
        int length = (this.defHash.length * 2) + inputBlockSize + 1;
        byte[] bArr2 = new byte[length];
        int i10 = length - i9;
        System.arraycopy(bArr, i8, bArr2, i10, i9);
        bArr2[i10 - 1] = 1;
        byte[] bArr3 = this.defHash;
        System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
        int length2 = this.defHash.length;
        byte[] bArr4 = new byte[length2];
        this.random.nextBytes(bArr4);
        System.arraycopy(bArr4, 0, bArr2, 0, this.defHash.length);
        this.mgf1Hash.reset();
        byte[] bArr5 = this.defHash;
        maskGeneratorFunction1(bArr4, 0, length2, bArr2, bArr5.length, length - bArr5.length);
        byte[] bArr6 = this.defHash;
        maskGeneratorFunction1(bArr2, bArr6.length, length - bArr6.length, bArr2, 0, bArr6.length);
        return this.engine.processBlock(bArr2, 0, length);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize - 1) - (this.defHash.length * 2) : inputBlockSize;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.random = z ? CryptoServicesRegistrar.getSecureRandom(cipherParameters instanceof ParametersWithRandom ? ((ParametersWithRandom) cipherParameters).getRandom() : null) : null;
        this.forEncryption = z;
        this.engine.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i8, int i9) {
        return this.forEncryption ? encodeBlock(bArr, i8, i9) : decodeBlock(bArr, i8, i9);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.mgf1Hash = digest2;
        this.mgf1NoMemoLimit = getMGF1NoMemoLimit(digest2);
        byte[] bArr2 = new byte[digest.getDigestSize()];
        this.defHash = bArr2;
        digest.reset();
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(bArr2, 0);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }
}
