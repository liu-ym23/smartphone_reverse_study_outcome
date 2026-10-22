package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;

/* loaded from: classes.dex */
public class CSHAKEDigest extends SHAKEDigest {
    private static final byte[] padding = new byte[100];
    private byte[] diff;

    public CSHAKEDigest(int i8, CryptoServicePurpose cryptoServicePurpose, byte[] bArr, byte[] bArr2) {
        super(i8, cryptoServicePurpose);
        if ((bArr == null || bArr.length == 0) && (bArr2 == null || bArr2.length == 0)) {
            this.diff = null;
        } else {
            this.diff = Arrays.concatenate(XofUtils.leftEncode(this.rate / 8), encodeString(bArr), encodeString(bArr2));
            diffPadAndAbsorb();
        }
    }

    private void copyIn(CSHAKEDigest cSHAKEDigest) {
        super.copyIn((KeccakDigest) cSHAKEDigest);
        this.diff = Arrays.clone(cSHAKEDigest.diff);
    }

    private void diffPadAndAbsorb() {
        int i8 = this.rate / 8;
        byte[] bArr = this.diff;
        absorb(bArr, 0, bArr.length);
        int length = this.diff.length % i8;
        if (length == 0) {
            return;
        }
        while (true) {
            i8 -= length;
            byte[] bArr2 = padding;
            if (i8 <= bArr2.length) {
                absorb(bArr2, 0, i8);
                return;
            } else {
                absorb(bArr2, 0, bArr2.length);
                length = bArr2.length;
            }
        }
    }

    private byte[] encodeString(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? XofUtils.leftEncode(0L) : Arrays.concatenate(XofUtils.leftEncode(bArr.length * 8), bArr);
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new CSHAKEDigest(this);
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.crypto.Xof
    public int doOutput(byte[] bArr, int i8, int i9) {
        if (this.diff == null) {
            return super.doOutput(bArr, i8, i9);
        }
        if (!this.squeezing) {
            absorbBits(0, 2);
        }
        squeeze(bArr, i8, i9 * 8);
        return i9;
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "CSHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.crypto.digests.EncodableDigest, org.bouncycastle.crypto.EncodableService
    public byte[] getEncodedState() {
        int length = (this.state.length * 8) + this.dataQueue.length + 14;
        byte[] bArr = this.diff;
        if (bArr == null) {
            byte[] bArr2 = new byte[length];
            super.getEncodedState(bArr2);
            return bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + length];
        super.getEncodedState(bArr3);
        byte[] bArr4 = this.diff;
        System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        if (this.diff != null) {
            diffPadAndAbsorb();
        }
    }

    public CSHAKEDigest(int i8, byte[] bArr, byte[] bArr2) {
        this(i8, CryptoServicePurpose.ANY, bArr, bArr2);
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((CSHAKEDigest) memoable);
    }

    public CSHAKEDigest(CSHAKEDigest cSHAKEDigest) {
        super(cSHAKEDigest);
        this.diff = Arrays.clone(cSHAKEDigest.diff);
    }

    public CSHAKEDigest(byte[] bArr) {
        super(bArr);
        int length = (this.state.length * 8) + this.dataQueue.length + 14;
        if (bArr.length == length) {
            this.diff = null;
            return;
        }
        byte[] bArr2 = new byte[bArr.length - length];
        this.diff = bArr2;
        System.arraycopy(bArr, length, bArr2, 0, bArr2.length);
    }
}
