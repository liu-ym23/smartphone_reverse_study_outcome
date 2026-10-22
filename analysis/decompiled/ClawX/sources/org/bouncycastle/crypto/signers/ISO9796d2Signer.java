package org.bouncycastle.crypto.signers;

import a8.b;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }

    private void clearBlock(byte[] bArr) {
        for (int i8 = 0; i8 != bArr.length; i8++) {
            bArr[i8] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z;
        int i8 = this.messageLength;
        byte[] bArr3 = this.mBuf;
        if (i8 > bArr3.length) {
            z = bArr3.length <= bArr2.length;
            for (int i9 = 0; i9 != this.mBuf.length; i9++) {
                if (bArr[i9] != bArr2[i9]) {
                    z = false;
                }
            }
            return z;
        }
        z = i8 == bArr2.length;
        for (int i10 = 0; i10 != bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                z = false;
            }
        }
        return z;
    }

    private boolean returnFalse(byte[] bArr) {
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        int length;
        int i8;
        int i9;
        int i10;
        int digestSize = this.digest.getDigestSize();
        if (this.trailer == 188) {
            byte[] bArr = this.block;
            length = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, length);
            byte[] bArr2 = this.block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i8 = 8;
        } else {
            byte[] bArr3 = this.block;
            length = (bArr3.length - digestSize) - 2;
            this.digest.doFinal(bArr3, length);
            byte[] bArr4 = this.block;
            int length2 = bArr4.length - 2;
            int i11 = this.trailer;
            bArr4[length2] = (byte) (i11 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i11;
            i8 = 16;
        }
        int i12 = this.messageLength;
        int i13 = ((((digestSize + i12) * 8) + i8) + 4) - this.keyBits;
        if (i13 > 0) {
            int i14 = i12 - ((i13 + 7) / 8);
            i9 = length - i14;
            System.arraycopy(this.mBuf, 0, this.block, i9, i14);
            this.recoveredMessage = new byte[i14];
            i10 = 96;
        } else {
            i9 = length - i12;
            System.arraycopy(this.mBuf, 0, this.block, i9, i12);
            this.recoveredMessage = new byte[this.messageLength];
            i10 = 64;
        }
        int i15 = i9 - 1;
        if (i15 > 0) {
            for (int i16 = i15; i16 != 0; i16--) {
                this.block[i16] = -69;
            }
            byte[] bArr5 = this.block;
            bArr5[i15] = (byte) (bArr5[i15] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (11 | i10);
        } else {
            byte[] bArr6 = this.block;
            bArr6[0] = 10;
            bArr6[0] = (byte) (10 | i10);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr7 = this.block;
        byte[] bArrProcessBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        this.fullMessage = (i10 & 32) == 0;
        byte[] bArr8 = this.mBuf;
        byte[] bArr9 = this.recoveredMessage;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return bArrProcessBlock;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z, rSAKeyParameters);
        int iBitLength = rSAKeyParameters.getModulus().bitLength();
        this.keyBits = iBitLength;
        byte[] bArr = new byte[(iBitLength + 7) / 8];
        this.block = bArr;
        int i8 = this.trailer;
        int length = bArr.length;
        if (i8 == 188) {
            this.mBuf = new byte[(length - this.digest.getDigestSize()) - 2];
        } else {
            this.mBuf = new byte[(length - this.digest.getDigestSize()) - 3];
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b9) {
        this.digest.update(b9);
        int i8 = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i8 < bArr.length) {
            bArr[i8] = b9;
        }
        this.messageLength = i8 + 1;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        int i8;
        byte[] bArrProcessBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((bArrProcessBlock[0] & 192) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 15) ^ 12) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 255) ^ 188) == 0) {
            i8 = 1;
        } else {
            i8 = 2;
            int i9 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & 255) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & 255);
            Integer trailer = ISOTrailers.getTrailer(this.digest);
            if (trailer == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = trailer.intValue();
            if (i9 != iIntValue && (iIntValue != 15052 || i9 != 16588)) {
                throw new IllegalStateException(b.j(i9, "signer initialised with wrong digest for trailer "));
            }
        }
        int i10 = 0;
        while (i10 != bArrProcessBlock.length && ((bArrProcessBlock[i10] & 15) ^ 10) != 0) {
            i10++;
        }
        int i11 = i10 + 1;
        int length = ((bArrProcessBlock.length - i8) - this.digest.getDigestSize()) - i11;
        if (length <= 0) {
            throw new InvalidCipherTextException("malformed block");
        }
        if ((bArrProcessBlock[0] & 32) == 0) {
            this.fullMessage = true;
            byte[] bArr2 = new byte[length];
            this.recoveredMessage = bArr2;
            System.arraycopy(bArrProcessBlock, i11, bArr2, 0, length);
        } else {
            this.fullMessage = false;
            byte[] bArr3 = new byte[length];
            this.recoveredMessage = bArr3;
            System.arraycopy(bArrProcessBlock, i11, bArr3, 0, length);
        }
        this.preSig = bArr;
        this.preBlock = bArrProcessBlock;
        Digest digest = this.digest;
        byte[] bArr4 = this.recoveredMessage;
        digest.update(bArr4, 0, bArr4.length);
        byte[] bArr5 = this.recoveredMessage;
        this.messageLength = bArr5.length;
        System.arraycopy(bArr5, 0, this.mBuf, 0, bArr5.length);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrProcessBlock;
        int i8;
        byte[] bArr2 = this.preSig;
        if (bArr2 == null) {
            try {
                bArrProcessBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (!Arrays.areEqual(bArr2, bArr)) {
                throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
            }
            bArrProcessBlock = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
        }
        if (((bArrProcessBlock[0] & 192) ^ 64) != 0) {
            return returnFalse(bArrProcessBlock);
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 15) ^ 12) != 0) {
            return returnFalse(bArrProcessBlock);
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 255) ^ 188) == 0) {
            i8 = 1;
        } else {
            i8 = 2;
            int i9 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & 255) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & 255);
            Integer trailer = ISOTrailers.getTrailer(this.digest);
            if (trailer == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = trailer.intValue();
            if (i9 != iIntValue && (iIntValue != 15052 || i9 != 16588)) {
                throw new IllegalStateException(b.j(i9, "signer initialised with wrong digest for trailer "));
            }
        }
        int i10 = 0;
        while (i10 != bArrProcessBlock.length && ((bArrProcessBlock[i10] & 15) ^ 10) != 0) {
            i10++;
        }
        int i11 = i10 + 1;
        int digestSize = this.digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        int length = (bArrProcessBlock.length - i8) - digestSize;
        int i12 = length - i11;
        if (i12 <= 0) {
            return returnFalse(bArrProcessBlock);
        }
        if ((bArrProcessBlock[0] & 32) == 0) {
            this.fullMessage = true;
            if (this.messageLength > i12) {
                return returnFalse(bArrProcessBlock);
            }
            this.digest.reset();
            this.digest.update(bArrProcessBlock, i11, i12);
            this.digest.doFinal(bArr3, 0);
            boolean z = true;
            for (int i13 = 0; i13 != digestSize; i13++) {
                int i14 = length + i13;
                byte b9 = (byte) (bArrProcessBlock[i14] ^ bArr3[i13]);
                bArrProcessBlock[i14] = b9;
                if (b9 != 0) {
                    z = false;
                }
            }
            if (!z) {
                return returnFalse(bArrProcessBlock);
            }
            byte[] bArr4 = new byte[i12];
            this.recoveredMessage = bArr4;
            System.arraycopy(bArrProcessBlock, i11, bArr4, 0, i12);
        } else {
            this.fullMessage = false;
            this.digest.doFinal(bArr3, 0);
            boolean z2 = true;
            for (int i15 = 0; i15 != digestSize; i15++) {
                int i16 = length + i15;
                byte b10 = (byte) (bArrProcessBlock[i16] ^ bArr3[i15]);
                bArrProcessBlock[i16] = b10;
                if (b10 != 0) {
                    z2 = false;
                }
            }
            if (!z2) {
                return returnFalse(bArrProcessBlock);
            }
            byte[] bArr5 = new byte[i12];
            this.recoveredMessage = bArr5;
            System.arraycopy(bArrProcessBlock, i11, bArr5, 0, i12);
        }
        if (this.messageLength != 0 && !isSameAs(this.mBuf, this.recoveredMessage)) {
            return returnFalse(bArrProcessBlock);
        }
        clearBlock(this.mBuf);
        clearBlock(bArrProcessBlock);
        this.messageLength = 0;
        return true;
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        int iIntValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest;
        if (z) {
            iIntValue = 188;
        } else {
            Integer trailer = ISOTrailers.getTrailer(digest);
            if (trailer == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + digest.getAlgorithmName());
            }
            iIntValue = trailer.intValue();
        }
        this.trailer = iIntValue;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i8, int i9) {
        while (i9 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i8]);
            i8++;
            i9--;
        }
        this.digest.update(bArr, i8, i9);
        this.messageLength += i9;
    }
}
