package org.bouncycastle.crypto.digests;

import a8.b;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.SavableDigest;
import org.bouncycastle.util.Memoable;

/* loaded from: classes.dex */
public class SHA3Digest extends KeccakDigest implements SavableDigest {
    public SHA3Digest() {
        this(256, CryptoServicePurpose.ANY);
    }

    private static int checkBitLength(int i8) {
        if (i8 == 224 || i8 == 256 || i8 == 384 || i8 == 512) {
            return i8;
        }
        throw new IllegalArgumentException(b.k(i8, "'bitLength' ", " not supported for SHA-3"));
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA3Digest(this);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        absorbBits(2, 2);
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA3-" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest, org.bouncycastle.crypto.EncodableService
    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.state.length * 8) + this.dataQueue.length + 14];
        super.getEncodedState(bArr);
        return bArr;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((SHA3Digest) memoable);
    }

    public SHA3Digest(int i8) {
        super(checkBitLength(i8), CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] bArr, int i8, byte b9, int i9) {
        if (i9 < 0 || i9 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i10 = (b9 & ((1 << i9) - 1)) | (2 << i9);
        int i11 = i9 + 2;
        if (i11 >= 8) {
            absorb((byte) i10);
            i11 = i9 - 6;
            i10 >>>= 8;
        }
        return super.doFinal(bArr, i8, (byte) i10, i11);
    }

    public SHA3Digest(int i8, CryptoServicePurpose cryptoServicePurpose) {
        super(checkBitLength(i8), cryptoServicePurpose);
    }

    public SHA3Digest(CryptoServicePurpose cryptoServicePurpose) {
        this(256, cryptoServicePurpose);
    }

    public SHA3Digest(SHA3Digest sHA3Digest) {
        super(sHA3Digest);
    }

    public SHA3Digest(byte[] bArr) {
        super(bArr);
    }
}
