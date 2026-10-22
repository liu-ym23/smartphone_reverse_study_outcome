package org.bouncycastle.crypto.digests;

import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 28;
    static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X;
    private int xOff;

    public SHA224Digest() {
        this(CryptoServicePurpose.ANY);
    }

    private int Ch(int i8, int i9, int i10) {
        return (i8 & i9) ^ ((~i8) & i10);
    }

    private int Maj(int i8, int i9, int i10) {
        return ((i8 & i9) ^ (i8 & i10)) ^ (i9 & i10);
    }

    private int Sum0(int i8) {
        return (((i8 >>> 2) | (i8 << 30)) ^ ((i8 >>> 13) | (i8 << 19))) ^ ((i8 << 10) | (i8 >>> 22));
    }

    private int Sum1(int i8) {
        return (((i8 >>> 6) | (i8 << 26)) ^ ((i8 >>> 11) | (i8 << 21))) ^ ((i8 << 7) | (i8 >>> 25));
    }

    private int Theta0(int i8) {
        return (((i8 >>> 7) | (i8 << 25)) ^ ((i8 >>> 18) | (i8 << 14))) ^ (i8 >>> 3);
    }

    private int Theta1(int i8) {
        return (((i8 >>> 17) | (i8 << 15)) ^ ((i8 >>> 19) | (i8 << 13))) ^ (i8 >>> 10);
    }

    private void doCopy(SHA224Digest sHA224Digest) {
        super.copyIn(sHA224Digest);
        this.H1 = sHA224Digest.H1;
        this.H2 = sHA224Digest.H2;
        this.H3 = sHA224Digest.H3;
        this.H4 = sHA224Digest.H4;
        this.H5 = sHA224Digest.H5;
        this.H6 = sHA224Digest.H6;
        this.H7 = sHA224Digest.H7;
        this.H8 = sHA224Digest.H8;
        int[] iArr = sHA224Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA224Digest.xOff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA224Digest(this);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, BERTags.PRIVATE, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i8);
        Pack.intToBigEndian(this.H2, bArr, i8 + 4);
        Pack.intToBigEndian(this.H3, bArr, i8 + 8);
        Pack.intToBigEndian(this.H4, bArr, i8 + 12);
        Pack.intToBigEndian(this.H5, bArr, i8 + 16);
        Pack.intToBigEndian(this.H6, bArr, i8 + 20);
        Pack.intToBigEndian(this.H7, bArr, i8 + 24);
        reset();
        return 28;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-224";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 28;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest, org.bouncycastle.crypto.EncodableService
    public byte[] getEncodedState() {
        int i8 = this.xOff * 4;
        byte[] bArr = new byte[i8 + 53];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.H6, bArr, 36);
        Pack.intToBigEndian(this.H7, bArr, 40);
        Pack.intToBigEndian(this.H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i9 = 0; i9 != this.xOff; i9++) {
            Pack.intToBigEndian(this.X[i9], bArr, (i9 * 4) + 52);
        }
        bArr[i8 + 52] = (byte) this.purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i8 = 16; i8 <= 63; i8++) {
            int[] iArr = this.X;
            int iTheta1 = Theta1(iArr[i8 - 2]);
            int[] iArr2 = this.X;
            iArr[i8] = iTheta1 + iArr2[i8 - 7] + Theta0(iArr2[i8 - 15]) + this.X[i8 - 16];
        }
        int iSum0 = this.H1;
        int iSum02 = this.H2;
        int iSum03 = this.H3;
        int iSum04 = this.H4;
        int i9 = this.H5;
        int i10 = this.H6;
        int i11 = this.H7;
        int i12 = this.H8;
        int i13 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            int iSum1 = Sum1(i9) + Ch(i9, i10, i11);
            int[] iArr3 = K;
            int i15 = iSum1 + iArr3[i13] + this.X[i13] + i12;
            int i16 = iSum04 + i15;
            int iSum05 = Sum0(iSum0) + Maj(iSum0, iSum02, iSum03) + i15;
            int i17 = i13 + 1;
            int iSum12 = Sum1(i16) + Ch(i16, i9, i10) + iArr3[i17] + this.X[i17] + i11;
            int i18 = iSum03 + iSum12;
            int iSum06 = Sum0(iSum05) + Maj(iSum05, iSum0, iSum02) + iSum12;
            int i19 = i13 + 2;
            int iSum13 = Sum1(i18) + Ch(i18, i16, i9) + iArr3[i19] + this.X[i19] + i10;
            int i20 = iSum02 + iSum13;
            int iSum07 = Sum0(iSum06) + Maj(iSum06, iSum05, iSum0) + iSum13;
            int i21 = i13 + 3;
            int iSum14 = Sum1(i20) + Ch(i20, i18, i16) + iArr3[i21] + this.X[i21] + i9;
            int i22 = iSum0 + iSum14;
            int iSum08 = Sum0(iSum07) + Maj(iSum07, iSum06, iSum05) + iSum14;
            int i23 = i13 + 4;
            int iSum15 = Sum1(i22) + Ch(i22, i20, i18) + iArr3[i23] + this.X[i23] + i16;
            i12 = iSum05 + iSum15;
            iSum04 = Sum0(iSum08) + Maj(iSum08, iSum07, iSum06) + iSum15;
            int i24 = i13 + 5;
            int iSum16 = Sum1(i12) + Ch(i12, i22, i20) + iArr3[i24] + this.X[i24] + i18;
            i11 = iSum06 + iSum16;
            iSum03 = Sum0(iSum04) + Maj(iSum04, iSum08, iSum07) + iSum16;
            int i25 = i13 + 6;
            int iSum17 = Sum1(i11) + Ch(i11, i12, i22) + iArr3[i25] + this.X[i25] + i20;
            i10 = iSum07 + iSum17;
            iSum02 = Sum0(iSum03) + Maj(iSum03, iSum04, iSum08) + iSum17;
            int i26 = i13 + 7;
            int iSum18 = Sum1(i10) + Ch(i10, i11, i12) + iArr3[i26] + this.X[i26] + i22;
            i9 = iSum08 + iSum18;
            iSum0 = Sum0(iSum02) + Maj(iSum02, iSum03, iSum04) + iSum18;
            i13 += 8;
        }
        this.H1 += iSum0;
        this.H2 += iSum02;
        this.H3 += iSum03;
        this.H4 += iSum04;
        this.H5 += i9;
        this.H6 += i10;
        this.H7 += i11;
        this.H8 += i12;
        this.xOff = 0;
        for (int i27 = 0; i27 < 16; i27++) {
            this.X[i27] = 0;
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
        this.H1 = -1056596264;
        this.H2 = 914150663;
        this.H3 = 812702999;
        this.H4 = -150054599;
        this.H5 = -4191439;
        this.H6 = 1750603025;
        this.H7 = 1694076839;
        this.H8 = -1090891868;
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

    public SHA224Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        doCopy((SHA224Digest) memoable);
    }

    public SHA224Digest(SHA224Digest sHA224Digest) {
        super(sHA224Digest);
        this.X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        doCopy(sHA224Digest);
    }

    public SHA224Digest(byte[] bArr) {
        super(bArr);
        this.X = new int[64];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.H6 = Pack.bigEndianToInt(bArr, 36);
        this.H7 = Pack.bigEndianToInt(bArr, 40);
        this.H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i8 = 0; i8 != this.xOff; i8++) {
            this.X[i8] = Pack.bigEndianToInt(bArr, (i8 * 4) + 52);
        }
    }
}
