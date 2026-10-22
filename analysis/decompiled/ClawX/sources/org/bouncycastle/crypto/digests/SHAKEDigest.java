package org.bouncycastle.crypto.digests;

import a8.b;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.SavableDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Memoable;

/* loaded from: classes.dex */
public class SHAKEDigest extends KeccakDigest implements Xof, SavableDigest {
    public SHAKEDigest() {
        this(128);
    }

    private static int checkBitLength(int i8) {
        if (i8 == 128 || i8 == 256) {
            return i8;
        }
        throw new IllegalArgumentException(b.k(i8, "'bitStrength' ", " not supported for SHAKE"));
    }

    public Memoable copy() {
        return new SHAKEDigest(this);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, this.purpose);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        return doFinal(bArr, i8, getDigestSize());
    }

    public int doOutput(byte[] bArr, int i8, int i9) {
        if (!this.squeezing) {
            absorbBits(15, 4);
        }
        squeeze(bArr, i8, i9 * 8);
        return i9;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 4;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.state.length * 8) + this.dataQueue.length + 14];
        super.getEncodedState(bArr);
        return bArr;
    }

    public void reset(Memoable memoable) {
        copyIn((SHAKEDigest) memoable);
    }

    public SHAKEDigest(int i8) {
        super(checkBitLength(i8), CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] bArr, int i8, byte b9, int i9) {
        return doFinal(bArr, i8, getDigestSize(), b9, i9);
    }

    public SHAKEDigest(int i8, CryptoServicePurpose cryptoServicePurpose) {
        super(checkBitLength(i8), cryptoServicePurpose);
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i8, int i9) {
        int iDoOutput = doOutput(bArr, i8, i9);
        reset();
        return iDoOutput;
    }

    public SHAKEDigest(CryptoServicePurpose cryptoServicePurpose) {
        this(128, cryptoServicePurpose);
    }

    public int doFinal(byte[] bArr, int i8, int i9, byte b9, int i10) {
        if (i10 < 0 || i10 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i11 = (b9 & ((1 << i10) - 1)) | (15 << i10);
        int i12 = i10 + 4;
        if (i12 >= 8) {
            absorb((byte) i11);
            i12 = i10 - 4;
            i11 >>>= 8;
        }
        if (i12 > 0) {
            absorbBits(i11, i12);
        }
        squeeze(bArr, i8, i9 * 8);
        reset();
        return i9;
    }

    public SHAKEDigest(SHAKEDigest sHAKEDigest) {
        super(sHAKEDigest);
    }

    public SHAKEDigest(byte[] bArr) {
        super(bArr);
    }
}
