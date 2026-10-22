package org.bouncycastle.crypto.digests;

import a8.b;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X;
    private int xOff;

    public SHA1Digest() {
        this(CryptoServicePurpose.ANY);
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        int[] iArr = sHA1Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    private int f(int i8, int i9, int i10) {
        return (i8 & i9) | ((~i8) & i10);
    }

    private int g(int i8, int i9, int i10) {
        return ((i9 | i10) & i8) | (i9 & i10);
    }

    private int h(int i8, int i9, int i10) {
        return (i8 ^ i9) ^ i10;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 128, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i8);
        Pack.intToBigEndian(this.H2, bArr, i8 + 4);
        Pack.intToBigEndian(this.H3, bArr, i8 + 8);
        Pack.intToBigEndian(this.H4, bArr, i8 + 12);
        Pack.intToBigEndian(this.H5, bArr, i8 + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest, org.bouncycastle.crypto.EncodableService
    public byte[] getEncodedState() {
        int i8 = this.xOff * 4;
        byte[] bArr = new byte[i8 + 41];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.xOff, bArr, 36);
        for (int i9 = 0; i9 != this.xOff; i9++) {
            Pack.intToBigEndian(this.X[i9], bArr, (i9 * 4) + 40);
        }
        bArr[i8 + 40] = (byte) this.purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i8 = 16; i8 < 80; i8++) {
            int[] iArr = this.X;
            int i9 = ((iArr[i8 - 3] ^ iArr[i8 - 8]) ^ iArr[i8 - 14]) ^ iArr[i8 - 16];
            iArr[i8] = (i9 >>> 31) | (i9 << 1);
        }
        int iD = this.H1;
        int iD2 = this.H2;
        int i10 = this.H3;
        int i11 = this.H4;
        int i12 = this.H5;
        int i13 = 0;
        for (int i14 = 0; i14 < 4; i14++) {
            int iD3 = b.D(((iD << 5) | (iD >>> 27)) + f(iD2, i10, i11), this.X[i13], Y1, i12);
            int i15 = (iD2 >>> 2) | (iD2 << 30);
            int iD4 = b.D(((iD3 << 5) | (iD3 >>> 27)) + f(iD, i15, i10), this.X[i13 + 1], Y1, i11);
            int i16 = (iD >>> 2) | (iD << 30);
            int iD5 = b.D(((iD4 << 5) | (iD4 >>> 27)) + f(iD3, i16, i15), this.X[i13 + 2], Y1, i10);
            i12 = (iD3 >>> 2) | (iD3 << 30);
            int i17 = i13 + 4;
            iD2 = b.D(((iD5 << 5) | (iD5 >>> 27)) + f(iD4, i12, i16), this.X[i13 + 3], Y1, i15);
            i11 = (iD4 >>> 2) | (iD4 << 30);
            i13 += 5;
            iD = b.D(((iD2 << 5) | (iD2 >>> 27)) + f(iD5, i11, i12), this.X[i17], Y1, i16);
            i10 = (iD5 >>> 2) | (iD5 << 30);
        }
        for (int i18 = 0; i18 < 4; i18++) {
            int iD6 = b.D(((iD << 5) | (iD >>> 27)) + h(iD2, i10, i11), this.X[i13], Y2, i12);
            int i19 = (iD2 >>> 2) | (iD2 << 30);
            int iD7 = b.D(((iD6 << 5) | (iD6 >>> 27)) + h(iD, i19, i10), this.X[i13 + 1], Y2, i11);
            int i20 = (iD >>> 2) | (iD << 30);
            int iD8 = b.D(((iD7 << 5) | (iD7 >>> 27)) + h(iD6, i20, i19), this.X[i13 + 2], Y2, i10);
            i12 = (iD6 >>> 2) | (iD6 << 30);
            int i21 = i13 + 4;
            iD2 = b.D(((iD8 << 5) | (iD8 >>> 27)) + h(iD7, i12, i20), this.X[i13 + 3], Y2, i19);
            i11 = (iD7 >>> 2) | (iD7 << 30);
            i13 += 5;
            iD = b.D(((iD2 << 5) | (iD2 >>> 27)) + h(iD8, i11, i12), this.X[i21], Y2, i20);
            i10 = (iD8 >>> 2) | (iD8 << 30);
        }
        for (int i22 = 0; i22 < 4; i22++) {
            int iD9 = b.D(((iD << 5) | (iD >>> 27)) + g(iD2, i10, i11), this.X[i13], Y3, i12);
            int i23 = (iD2 >>> 2) | (iD2 << 30);
            int iD10 = b.D(((iD9 << 5) | (iD9 >>> 27)) + g(iD, i23, i10), this.X[i13 + 1], Y3, i11);
            int i24 = (iD >>> 2) | (iD << 30);
            int iD11 = b.D(((iD10 << 5) | (iD10 >>> 27)) + g(iD9, i24, i23), this.X[i13 + 2], Y3, i10);
            i12 = (iD9 >>> 2) | (iD9 << 30);
            int i25 = i13 + 4;
            iD2 = b.D(((iD11 << 5) | (iD11 >>> 27)) + g(iD10, i12, i24), this.X[i13 + 3], Y3, i23);
            i11 = (iD10 >>> 2) | (iD10 << 30);
            i13 += 5;
            iD = b.D(((iD2 << 5) | (iD2 >>> 27)) + g(iD11, i11, i12), this.X[i25], Y3, i24);
            i10 = (iD11 >>> 2) | (iD11 << 30);
        }
        for (int i26 = 0; i26 <= 3; i26++) {
            int iD12 = b.D(((iD << 5) | (iD >>> 27)) + h(iD2, i10, i11), this.X[i13], Y4, i12);
            int i27 = (iD2 >>> 2) | (iD2 << 30);
            int iD13 = b.D(((iD12 << 5) | (iD12 >>> 27)) + h(iD, i27, i10), this.X[i13 + 1], Y4, i11);
            int i28 = (iD >>> 2) | (iD << 30);
            int iD14 = b.D(((iD13 << 5) | (iD13 >>> 27)) + h(iD12, i28, i27), this.X[i13 + 2], Y4, i10);
            i12 = (iD12 >>> 2) | (iD12 << 30);
            int i29 = i13 + 4;
            iD2 = b.D(((iD14 << 5) | (iD14 >>> 27)) + h(iD13, i12, i28), this.X[i13 + 3], Y4, i27);
            i11 = (iD13 >>> 2) | (iD13 << 30);
            i13 += 5;
            iD = b.D(((iD2 << 5) | (iD2 >>> 27)) + h(iD14, i11, i12), this.X[i29], Y4, i28);
            i10 = (iD14 >>> 2) | (iD14 << 30);
        }
        this.H1 += iD;
        this.H2 += iD2;
        this.H3 += i10;
        this.H4 += i11;
        this.H5 += i12;
        this.xOff = 0;
        for (int i30 = 0; i30 < 16; i30++) {
            this.X[i30] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long j4) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j4 >>> 32);
        iArr[15] = (int) j4;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i8) {
        this.X[this.xOff] = Pack.bigEndianToInt(bArr, i8);
        int i9 = this.xOff + 1;
        this.xOff = i9;
        if (i9 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i8 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i8 == iArr.length) {
                return;
            }
            iArr[i8] = 0;
            i8++;
        }
    }

    public SHA1Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.X = new int[80];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.X = new int[80];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.X = new int[80];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.xOff = Pack.bigEndianToInt(bArr, 36);
        for (int i8 = 0; i8 != this.xOff; i8++) {
            this.X[i8] = Pack.bigEndianToInt(bArr, (i8 * 4) + 40);
        }
    }
}
