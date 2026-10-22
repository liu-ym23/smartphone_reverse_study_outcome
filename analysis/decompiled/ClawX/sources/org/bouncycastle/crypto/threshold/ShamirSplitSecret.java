package org.bouncycastle.crypto.threshold;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.threshold.ShamirSecretSplitter;

/* loaded from: classes.dex */
public class ShamirSplitSecret implements SplitSecret {
    private final Polynomial poly;
    private final ShamirSplitSecretShare[] secretShares;

    public ShamirSplitSecret(Polynomial polynomial, ShamirSplitSecretShare[] shamirSplitSecretShareArr) {
        this.secretShares = shamirSplitSecretShareArr;
        this.poly = polynomial;
    }

    public ShamirSplitSecret divide(int i8) {
        int i9 = 0;
        while (true) {
            ShamirSplitSecretShare[] shamirSplitSecretShareArr = this.secretShares;
            if (i9 >= shamirSplitSecretShareArr.length) {
                return this;
            }
            byte[] encoded = shamirSplitSecretShareArr[i9].getEncoded();
            for (int i10 = 0; i10 < encoded.length; i10++) {
                encoded[i10] = this.poly.gfDiv(encoded[i10] & 255, i8);
            }
            int i11 = i9 + 1;
            this.secretShares[i9] = new ShamirSplitSecretShare(encoded, i11);
            i9 = i11;
        }
    }

    @Override // org.bouncycastle.crypto.threshold.SplitSecret
    public byte[] getSecret() {
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = this.secretShares;
        int length = shamirSplitSecretShareArr.length;
        byte[] bArr = new byte[length];
        int i8 = length - 1;
        byte[] bArr2 = new byte[i8];
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, length, shamirSplitSecretShareArr[0].getEncoded().length);
        for (int i9 = 0; i9 < length; i9++) {
            bArr3[i9] = this.secretShares[i9].getEncoded();
            byte b9 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                if (i10 != i9) {
                    Polynomial polynomial = this.poly;
                    ShamirSplitSecretShare[] shamirSplitSecretShareArr2 = this.secretShares;
                    int i11 = shamirSplitSecretShareArr2[i10].f4591r;
                    bArr2[b9] = polynomial.gfDiv(i11, shamirSplitSecretShareArr2[i9].f4591r ^ i11);
                    b9 = (byte) (b9 + 1);
                }
            }
            byte bGfMul = 1;
            for (int i12 = 0; i12 != i8; i12++) {
                bGfMul = this.poly.gfMul(bGfMul & 255, bArr2[i12] & 255);
            }
            bArr[i9] = bGfMul;
        }
        return this.poly.gfVecMul(bArr, bArr3);
    }

    public ShamirSplitSecret multiple(int i8) {
        int i9 = 0;
        while (true) {
            ShamirSplitSecretShare[] shamirSplitSecretShareArr = this.secretShares;
            if (i9 >= shamirSplitSecretShareArr.length) {
                return this;
            }
            byte[] encoded = shamirSplitSecretShareArr[i9].getEncoded();
            for (int i10 = 0; i10 < encoded.length; i10++) {
                encoded[i10] = this.poly.gfMul(encoded[i10] & 255, i8);
            }
            int i11 = i9 + 1;
            this.secretShares[i9] = new ShamirSplitSecretShare(encoded, i11);
            i9 = i11;
        }
    }

    public ShamirSplitSecret(ShamirSecretSplitter.Algorithm algorithm, ShamirSecretSplitter.Mode mode, ShamirSplitSecretShare[] shamirSplitSecretShareArr) {
        this.secretShares = shamirSplitSecretShareArr;
        this.poly = Polynomial.newInstance(algorithm, mode);
    }

    @Override // org.bouncycastle.crypto.threshold.SplitSecret
    public ShamirSplitSecretShare[] getSecretShares() {
        return this.secretShares;
    }
}
