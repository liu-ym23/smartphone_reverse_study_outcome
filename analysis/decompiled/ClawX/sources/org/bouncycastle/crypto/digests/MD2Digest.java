package org.bouncycastle.crypto.digests;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Memoable;

/* loaded from: classes.dex */
public class MD2Digest implements ExtendedDigest, Memoable {
    private static final int DIGEST_LENGTH = 16;
    private static final byte[] S = {41, 46, 67, -55, -94, -40, 124, 1, 61, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, 115, -116, -104, -109, 43, -39, PSSSigner.TRAILER_IMPLICIT, 76, -126, -54, 30, -101, 87, 60, -3, -44, -32, 22, 103, 66, 111, 24, -118, 23, -27, 18, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, 63, -108, -62, 16, -119, 11, 34, 95, 33, -128, AbstractJsonLexerKt.TC_INVALID, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, 25, 48, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, -49, 101, -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, 13, 110, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 36, -31, 123, 8, 12, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, 31, 26, -37, -103, -115, 51, -97, 17, -125, 20};
    private byte[] C;
    private int COff;
    private byte[] M;
    private byte[] X;
    private int mOff;
    private final CryptoServicePurpose purpose;
    private int xOff;

    public MD2Digest() {
        this(CryptoServicePurpose.ANY);
    }

    private void copyIn(MD2Digest mD2Digest) {
        byte[] bArr = mD2Digest.X;
        System.arraycopy(bArr, 0, this.X, 0, bArr.length);
        this.xOff = mD2Digest.xOff;
        byte[] bArr2 = mD2Digest.M;
        System.arraycopy(bArr2, 0, this.M, 0, bArr2.length);
        this.mOff = mD2Digest.mOff;
        byte[] bArr3 = mD2Digest.C;
        System.arraycopy(bArr3, 0, this.C, 0, bArr3.length);
        this.COff = mD2Digest.COff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new MD2Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        int length = this.M.length;
        int i9 = this.mOff;
        byte b9 = (byte) (length - i9);
        while (true) {
            byte[] bArr2 = this.M;
            if (i9 >= bArr2.length) {
                processCheckSum(bArr2);
                processBlock(this.M);
                processBlock(this.C);
                System.arraycopy(this.X, this.xOff, bArr, i8, 16);
                reset();
                return 16;
            }
            bArr2[i9] = b9;
            i9++;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD2";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    public void processBlock(byte[] bArr) {
        for (int i8 = 0; i8 < 16; i8++) {
            byte[] bArr2 = this.X;
            bArr2[i8 + 16] = bArr[i8];
            bArr2[i8 + 32] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < 18; i10++) {
            for (int i11 = 0; i11 < 48; i11++) {
                byte[] bArr3 = this.X;
                byte b9 = (byte) (S[i9] ^ bArr3[i11]);
                bArr3[i11] = b9;
                i9 = b9 & 255;
            }
            i9 = (i9 + i10) % 256;
        }
    }

    public void processCheckSum(byte[] bArr) {
        byte b9 = this.C[15];
        for (int i8 = 0; i8 < 16; i8++) {
            byte[] bArr2 = this.C;
            b9 = (byte) (S[(b9 ^ bArr[i8]) & 255] ^ bArr2[i8]);
            bArr2[i8] = b9;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.xOff = 0;
        int i8 = 0;
        while (true) {
            byte[] bArr = this.X;
            if (i8 == bArr.length) {
                break;
            }
            bArr[i8] = 0;
            i8++;
        }
        this.mOff = 0;
        int i9 = 0;
        while (true) {
            byte[] bArr2 = this.M;
            if (i9 == bArr2.length) {
                break;
            }
            bArr2[i9] = 0;
            i9++;
        }
        this.COff = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr3 = this.C;
            if (i10 == bArr3.length) {
                return;
            }
            bArr3[i10] = 0;
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        byte[] bArr = this.M;
        int i8 = this.mOff;
        int i9 = i8 + 1;
        this.mOff = i9;
        bArr[i8] = b9;
        if (i9 == 16) {
            processCheckSum(bArr);
            processBlock(this.M);
            this.mOff = 0;
        }
    }

    public MD2Digest(CryptoServicePurpose cryptoServicePurpose) {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        this.purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, 64, cryptoServicePurpose));
        reset();
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((MD2Digest) memoable);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        while (this.mOff != 0 && i9 > 0) {
            update(bArr[i8]);
            i8++;
            i9--;
        }
        while (i9 >= 16) {
            System.arraycopy(bArr, i8, this.M, 0, 16);
            processCheckSum(this.M);
            processBlock(this.M);
            i9 -= 16;
            i8 += 16;
        }
        while (i9 > 0) {
            update(bArr[i8]);
            i8++;
            i9--;
        }
    }

    public MD2Digest(MD2Digest mD2Digest) {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        CryptoServicePurpose cryptoServicePurpose = mD2Digest.purpose;
        this.purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, 64, cryptoServicePurpose));
        copyIn(mD2Digest);
    }
}
