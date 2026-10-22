package org.bouncycastle.crypto.digests;

import a8.b;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;
    private static final int[] T = new int[64];
    private int[] V;
    private int[] W;
    private int[] inwords;
    private int xOff;

    static {
        int i8;
        int i9 = 0;
        while (true) {
            if (i9 >= 16) {
                break;
            }
            T[i9] = (2043430169 >>> (32 - i9)) | (2043430169 << i9);
            i9++;
        }
        for (i8 = 16; i8 < 64; i8++) {
            int i10 = i8 % 32;
            T[i8] = (2055708042 >>> (32 - i10)) | (2055708042 << i10);
        }
    }

    public SM3Digest() {
        this(CryptoServicePurpose.ANY);
    }

    private int FF0(int i8, int i9, int i10) {
        return (i8 ^ i9) ^ i10;
    }

    private int FF1(int i8, int i9, int i10) {
        return ((i9 | i10) & i8) | (i9 & i10);
    }

    private int GG0(int i8, int i9, int i10) {
        return (i8 ^ i9) ^ i10;
    }

    private int GG1(int i8, int i9, int i10) {
        return (i8 & i9) | ((~i8) & i10);
    }

    private int P0(int i8) {
        return (((i8 << 9) | (i8 >>> 23)) ^ i8) ^ ((i8 << 17) | (i8 >>> 15));
    }

    private int P1(int i8) {
        return (((i8 << 15) | (i8 >>> 17)) ^ i8) ^ ((i8 << 23) | (i8 >>> 9));
    }

    private void copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.V;
        int[] iArr2 = this.V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.inwords;
        int[] iArr4 = this.inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.xOff = sM3Digest.xOff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SM3Digest(this);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 256, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        finish();
        Pack.intToBigEndian(this.V, bArr, i8);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SM3";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i8;
        int i9 = 0;
        while (true) {
            i8 = 16;
            if (i9 >= 16) {
                break;
            }
            this.W[i9] = this.inwords[i9];
            i9++;
        }
        for (int i10 = 16; i10 < 68; i10++) {
            int[] iArr = this.W;
            int i11 = iArr[i10 - 3];
            int i12 = iArr[i10 - 13];
            iArr[i10] = (P1(((i11 >>> 17) | (i11 << 15)) ^ (iArr[i10 - 16] ^ iArr[i10 - 9])) ^ ((i12 >>> 25) | (i12 << 7))) ^ this.W[i10 - 6];
        }
        int[] iArr2 = this.V;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        int i15 = iArr2[2];
        char c3 = 3;
        int i16 = iArr2[3];
        char c8 = 4;
        int iP0 = iArr2[4];
        char c9 = 5;
        int i17 = iArr2[5];
        char c10 = 6;
        int i18 = iArr2[6];
        int i19 = iArr2[7];
        int i20 = i18;
        int i21 = 0;
        while (i21 < i8) {
            int i22 = (i13 << 12) | (i13 >>> 20);
            int i23 = i22 + iP0 + T[i21];
            int i24 = (i23 << 7) | (i23 >>> 25);
            char c11 = c3;
            int i25 = i24 ^ i22;
            char c12 = c8;
            int[] iArr3 = this.W;
            char c13 = c9;
            int i26 = iArr3[i21];
            int iD = b.D(FF0(i13, i14, i15), i16, i25, iArr3[i21 + 4] ^ i26);
            int iD2 = b.D(GG0(iP0, i17, i20), i19, i24, i26);
            int i27 = (i14 << 9) | (i14 >>> 23);
            int i28 = (i17 << 19) | (i17 >>> 13);
            i21++;
            i16 = i15;
            i17 = iP0;
            c8 = c12;
            c9 = c13;
            c10 = c10;
            iP0 = P0(iD2);
            i15 = i27;
            i19 = i20;
            i20 = i28;
            i8 = 16;
            i14 = i13;
            i13 = iD;
            c3 = c11;
        }
        char c14 = c3;
        char c15 = c8;
        char c16 = c9;
        char c17 = c10;
        int i29 = i19;
        int i30 = i20;
        int i31 = i13;
        int i32 = 16;
        while (i32 < 64) {
            int i33 = (i31 << 12) | (i31 >>> 20);
            int i34 = i33 + iP0 + T[i32];
            int i35 = (i34 >>> 25) | (i34 << 7);
            int[] iArr4 = this.W;
            int i36 = iArr4[i32];
            int iD3 = b.D(FF1(i31, i14, i15), i16, i33 ^ i35, iArr4[i32 + 4] ^ i36);
            int iD4 = b.D(GG1(iP0, i17, i30), i29, i35, i36);
            int i37 = (i17 << 19) | (i17 >>> 13);
            i32++;
            i16 = i15;
            i17 = iP0;
            iP0 = P0(iD4);
            i15 = (i14 >>> 23) | (i14 << 9);
            i29 = i30;
            i14 = i31;
            i31 = iD3;
            i30 = i37;
        }
        int[] iArr5 = this.V;
        iArr5[0] = i31 ^ iArr5[0];
        iArr5[1] = iArr5[1] ^ i14;
        iArr5[2] = iArr5[2] ^ i15;
        iArr5[c14] = iArr5[c14] ^ i16;
        iArr5[c15] = iArr5[c15] ^ iP0;
        iArr5[c16] = iArr5[c16] ^ i17;
        iArr5[c17] = i30 ^ iArr5[c17];
        iArr5[7] = iArr5[7] ^ i29;
        this.xOff = 0;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long j4) {
        int i8 = this.xOff;
        if (i8 > 14) {
            this.inwords[i8] = 0;
            this.xOff = i8 + 1;
            processBlock();
        }
        while (true) {
            int i9 = this.xOff;
            if (i9 >= 14) {
                int[] iArr = this.inwords;
                int i10 = i9 + 1;
                this.xOff = i10;
                iArr[i9] = (int) (j4 >>> 32);
                this.xOff = i9 + 2;
                iArr[i10] = (int) j4;
                return;
            }
            this.inwords[i9] = 0;
            this.xOff = i9 + 1;
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i8) {
        int[] iArr = this.inwords;
        int i9 = this.xOff;
        this.xOff = i9 + 1;
        iArr[i9] = Pack.bigEndianToInt(bArr, i8);
        if (this.xOff >= 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        int[] iArr = this.V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.xOff = 0;
    }

    public SM3Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(cryptoServicePurpose);
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn((GeneralDigest) sM3Digest);
        copyIn(sM3Digest);
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super(sM3Digest);
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        copyIn(sM3Digest);
    }
}
