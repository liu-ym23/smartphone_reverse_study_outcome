package org.bouncycastle.crypto.signers;

import a8.b;
import java.security.SecureRandom;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class ISO9796d2PSSSigner implements SignerWithRecovery {
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
    private int hLen;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private int preMStart;
    private byte[] preSig;
    private int preTLength;
    private SecureRandom random;
    private byte[] recoveredMessage;
    private int saltLength;
    private byte[] standardSalt;
    private int trailer;

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i8) {
        this(asymmetricBlockCipher, digest, i8, false);
    }

    private void ItoOSP(int i8, byte[] bArr) {
        bArr[0] = (byte) (i8 >>> 24);
        bArr[1] = (byte) (i8 >>> 16);
        bArr[2] = (byte) (i8 >>> 8);
        bArr[3] = (byte) i8;
    }

    private void LtoOSP(long j4, byte[] bArr) {
        bArr[0] = (byte) (j4 >>> 56);
        bArr[1] = (byte) (j4 >>> 48);
        bArr[2] = (byte) (j4 >>> 40);
        bArr[3] = (byte) (j4 >>> 32);
        bArr[4] = (byte) (j4 >>> 24);
        bArr[5] = (byte) (j4 >>> 16);
        bArr[6] = (byte) (j4 >>> 8);
        bArr[7] = (byte) j4;
    }

    private void clearBlock(byte[] bArr) {
        for (int i8 = 0; i8 != bArr.length; i8++) {
            bArr[i8] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z = this.messageLength == bArr2.length;
        for (int i8 = 0; i8 != bArr2.length; i8++) {
            if (bArr[i8] != bArr2[i8]) {
                z = false;
            }
        }
        return z;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i8, int i9, int i10) {
        int i11;
        byte[] bArr2 = new byte[i10];
        byte[] bArr3 = new byte[this.hLen];
        byte[] bArr4 = new byte[4];
        this.digest.reset();
        int i12 = 0;
        while (true) {
            i11 = this.hLen;
            if (i12 >= i10 / i11) {
                break;
            }
            ItoOSP(i12, bArr4);
            this.digest.update(bArr, i8, i9);
            this.digest.update(bArr4, 0, 4);
            this.digest.doFinal(bArr3, 0);
            int i13 = this.hLen;
            System.arraycopy(bArr3, 0, bArr2, i12 * i13, i13);
            i12++;
        }
        if (i11 * i12 < i10) {
            ItoOSP(i12, bArr4);
            this.digest.update(bArr, i8, i9);
            this.digest.update(bArr4, 0, 4);
            this.digest.doFinal(bArr3, 0);
            int i14 = i12 * this.hLen;
            System.arraycopy(bArr3, 0, bArr2, i14, i10 - i14);
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.digest.doFinal(bArr, 0);
        byte[] bArr2 = new byte[8];
        LtoOSP(this.messageLength * 8, bArr2);
        this.digest.update(bArr2, 0, 8);
        this.digest.update(this.mBuf, 0, this.messageLength);
        this.digest.update(bArr, 0, digestSize);
        byte[] bArr3 = this.standardSalt;
        if (bArr3 == null) {
            bArr3 = new byte[this.saltLength];
            this.random.nextBytes(bArr3);
        }
        this.digest.update(bArr3, 0, bArr3.length);
        int digestSize2 = this.digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.digest.doFinal(bArr4, 0);
        int i8 = this.trailer == 188 ? 1 : 2;
        byte[] bArr5 = this.block;
        int length = bArr5.length;
        int i9 = this.messageLength;
        int length2 = (((length - i9) - bArr3.length) - this.hLen) - i8;
        bArr5[length2 - 1] = 1;
        System.arraycopy(this.mBuf, 0, bArr5, length2, i9);
        System.arraycopy(bArr3, 0, this.block, length2 + this.messageLength, bArr3.length);
        byte[] bArrMaskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, digestSize2, (this.block.length - this.hLen) - i8);
        for (int i10 = 0; i10 != bArrMaskGeneratorFunction1.length; i10++) {
            byte[] bArr6 = this.block;
            bArr6[i10] = (byte) (bArr6[i10] ^ bArrMaskGeneratorFunction1[i10]);
        }
        byte[] bArr7 = this.block;
        int length3 = bArr7.length;
        int i11 = this.hLen;
        System.arraycopy(bArr4, 0, bArr7, (length3 - i11) - i8, i11);
        int i12 = this.trailer;
        if (i12 == 188) {
            byte[] bArr8 = this.block;
            bArr8[bArr8.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr9 = this.block;
            bArr9[bArr9.length - 2] = (byte) (i12 >>> 8);
            bArr9[bArr9.length - 1] = (byte) i12;
        }
        byte[] bArr10 = this.block;
        bArr10[0] = (byte) (bArr10[0] & AbstractJsonLexerKt.TC_INVALID);
        byte[] bArrProcessBlock = this.cipher.processBlock(bArr10, 0, bArr10.length);
        int i13 = this.messageLength;
        byte[] bArr11 = new byte[i13];
        this.recoveredMessage = bArr11;
        byte[] bArr12 = this.mBuf;
        this.fullMessage = i13 <= bArr12.length;
        System.arraycopy(bArr12, 0, bArr11, 0, i13);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        this.messageLength = 0;
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[PHI: r1
      0x0016: PHI (r1v6 org.bouncycastle.crypto.params.RSAKeyParameters) = (r1v3 org.bouncycastle.crypto.params.RSAKeyParameters), (r1v11 org.bouncycastle.crypto.params.RSAKeyParameters) binds: [B:17:0x0043, B:5:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.crypto.Signer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void init(boolean r4, org.bouncycastle.crypto.CipherParameters r5) {
        /*
            r3 = this;
            int r0 = r3.saltLength
            boolean r1 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithRandom
            r2 = 0
            if (r1 == 0) goto L1c
            org.bouncycastle.crypto.params.ParametersWithRandom r5 = (org.bouncycastle.crypto.params.ParametersWithRandom) r5
            org.bouncycastle.crypto.CipherParameters r1 = r5.getParameters()
            org.bouncycastle.crypto.params.RSAKeyParameters r1 = (org.bouncycastle.crypto.params.RSAKeyParameters) r1
            if (r4 == 0) goto L16
            java.security.SecureRandom r5 = r5.getRandom()
            goto L17
        L16:
            r5 = r2
        L17:
            r3.random = r5
            r3.standardSalt = r2
            goto L4a
        L1c:
            boolean r1 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithSalt
            if (r1 == 0) goto L40
            org.bouncycastle.crypto.params.ParametersWithSalt r5 = (org.bouncycastle.crypto.params.ParametersWithSalt) r5
            org.bouncycastle.crypto.CipherParameters r0 = r5.getParameters()
            r1 = r0
            org.bouncycastle.crypto.params.RSAKeyParameters r1 = (org.bouncycastle.crypto.params.RSAKeyParameters) r1
            r3.random = r2
            byte[] r5 = r5.getSalt()
            r3.standardSalt = r5
            int r0 = r5.length
            int r5 = r5.length
            int r2 = r3.saltLength
            if (r5 != r2) goto L38
            goto L4a
        L38:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Fixed salt is of wrong length"
            r3.<init>(r4)
            throw r3
        L40:
            r1 = r5
            org.bouncycastle.crypto.params.RSAKeyParameters r1 = (org.bouncycastle.crypto.params.RSAKeyParameters) r1
            if (r4 == 0) goto L16
            java.security.SecureRandom r5 = org.bouncycastle.crypto.CryptoServicesRegistrar.getSecureRandom()
            goto L17
        L4a:
            org.bouncycastle.crypto.AsymmetricBlockCipher r5 = r3.cipher
            r5.init(r4, r1)
            java.math.BigInteger r4 = r1.getModulus()
            int r4 = r4.bitLength()
            r3.keyBits = r4
            int r4 = r4 + 7
            int r4 = r4 / 8
            byte[] r4 = new byte[r4]
            r3.block = r4
            int r5 = r3.trailer
            r1 = 188(0xbc, float:2.63E-43)
            int r4 = r4.length
            if (r5 != r1) goto L77
            org.bouncycastle.crypto.Digest r5 = r3.digest
            int r5 = r5.getDigestSize()
            int r4 = r4 - r5
            int r4 = r4 - r0
            int r4 = r4 + (-2)
            byte[] r4 = new byte[r4]
            r3.mBuf = r4
            goto L85
        L77:
            org.bouncycastle.crypto.Digest r5 = r3.digest
            int r5 = r5.getDigestSize()
            int r4 = r4 - r5
            int r4 = r4 - r0
            int r4 = r4 + (-3)
            byte[] r4 = new byte[r4]
            r3.mBuf = r4
        L85:
            r3.reset()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.signers.ISO9796d2PSSSigner.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        byte[] bArr = this.mBuf;
        if (bArr != null) {
            clearBlock(bArr);
        }
        byte[] bArr2 = this.recoveredMessage;
        if (bArr2 != null) {
            clearBlock(bArr2);
            this.recoveredMessage = null;
        }
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b9) {
        if (this.preSig == null) {
            int i8 = this.messageLength;
            byte[] bArr = this.mBuf;
            if (i8 < bArr.length) {
                this.messageLength = i8 + 1;
                bArr[i8] = b9;
                return;
            }
        }
        this.digest.update(b9);
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) {
        int i8;
        byte[] bArrProcessBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        int length = bArrProcessBlock.length;
        int i9 = this.keyBits;
        if (length < (i9 + 7) / 8) {
            int i10 = (i9 + 7) / 8;
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArrProcessBlock, 0, bArr2, i10 - bArrProcessBlock.length, bArrProcessBlock.length);
            clearBlock(bArrProcessBlock);
            bArrProcessBlock = bArr2;
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 255) ^ 188) == 0) {
            i8 = 1;
        } else {
            i8 = 2;
            int i11 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & 255) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & 255);
            Integer trailer = ISOTrailers.getTrailer(this.digest);
            if (trailer == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = trailer.intValue();
            if (i11 != iIntValue && (iIntValue != 15052 || i11 != 16588)) {
                throw new IllegalStateException(b.j(i11, "signer initialised with wrong digest for trailer "));
            }
        }
        this.digest.doFinal(new byte[this.hLen], 0);
        int length2 = bArrProcessBlock.length;
        int i12 = this.hLen;
        byte[] bArrMaskGeneratorFunction1 = maskGeneratorFunction1(bArrProcessBlock, (length2 - i12) - i8, i12, (bArrProcessBlock.length - i12) - i8);
        for (int i13 = 0; i13 != bArrMaskGeneratorFunction1.length; i13++) {
            bArrProcessBlock[i13] = (byte) (bArrProcessBlock[i13] ^ bArrMaskGeneratorFunction1[i13]);
        }
        bArrProcessBlock[0] = (byte) (bArrProcessBlock[0] & AbstractJsonLexerKt.TC_INVALID);
        int i14 = 0;
        while (i14 != bArrProcessBlock.length && bArrProcessBlock[i14] != 1) {
            i14++;
        }
        int i15 = i14 + 1;
        if (i15 >= bArrProcessBlock.length) {
            clearBlock(bArrProcessBlock);
        }
        this.fullMessage = i15 > 1;
        byte[] bArr3 = new byte[(bArrMaskGeneratorFunction1.length - i15) - this.saltLength];
        this.recoveredMessage = bArr3;
        System.arraycopy(bArrProcessBlock, i15, bArr3, 0, bArr3.length);
        byte[] bArr4 = this.recoveredMessage;
        System.arraycopy(bArr4, 0, this.mBuf, 0, bArr4.length);
        this.preSig = bArr;
        this.preBlock = bArrProcessBlock;
        this.preMStart = i15;
        this.preTLength = i8;
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        int i8 = this.hLen;
        byte[] bArr2 = new byte[i8];
        this.digest.doFinal(bArr2, 0);
        byte[] bArr3 = this.preSig;
        if (bArr3 == null) {
            try {
                updateWithRecoveredMessage(bArr);
            } catch (Exception unused) {
                return false;
            }
        } else if (!Arrays.areEqual(bArr3, bArr)) {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        byte[] bArr4 = this.preBlock;
        int i9 = this.preMStart;
        int i10 = this.preTLength;
        this.preSig = null;
        this.preBlock = null;
        byte[] bArr5 = new byte[8];
        LtoOSP(this.recoveredMessage.length * 8, bArr5);
        this.digest.update(bArr5, 0, 8);
        byte[] bArr6 = this.recoveredMessage;
        if (bArr6.length != 0) {
            this.digest.update(bArr6, 0, bArr6.length);
        }
        this.digest.update(bArr2, 0, i8);
        byte[] bArr7 = this.standardSalt;
        if (bArr7 != null) {
            this.digest.update(bArr7, 0, bArr7.length);
        } else {
            this.digest.update(bArr4, i9 + this.recoveredMessage.length, this.saltLength);
        }
        int digestSize = this.digest.getDigestSize();
        byte[] bArr8 = new byte[digestSize];
        this.digest.doFinal(bArr8, 0);
        int length = (bArr4.length - i10) - digestSize;
        boolean z = true;
        for (int i11 = 0; i11 != digestSize; i11++) {
            if (bArr8[i11] != bArr4[length + i11]) {
                z = false;
            }
        }
        clearBlock(bArr4);
        clearBlock(bArr8);
        if (!z) {
            this.fullMessage = false;
            this.messageLength = 0;
            clearBlock(this.recoveredMessage);
            return false;
        }
        if (this.messageLength == 0 || isSameAs(this.mBuf, this.recoveredMessage)) {
            this.messageLength = 0;
            clearBlock(this.mBuf);
            return true;
        }
        this.messageLength = 0;
        clearBlock(this.mBuf);
        return false;
    }

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i8, boolean z) {
        int iIntValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest;
        this.hLen = digest.getDigestSize();
        this.saltLength = i8;
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
        if (this.preSig == null) {
            while (i9 > 0 && this.messageLength < this.mBuf.length) {
                update(bArr[i8]);
                i8++;
                i9--;
            }
        }
        if (i9 > 0) {
            this.digest.update(bArr, i8, i9);
        }
    }
}
