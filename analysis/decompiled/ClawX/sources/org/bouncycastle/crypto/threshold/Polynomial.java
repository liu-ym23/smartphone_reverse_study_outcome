package org.bouncycastle.crypto.threshold;

import org.bouncycastle.crypto.threshold.ShamirSecretSplitter;

/* loaded from: classes.dex */
abstract class Polynomial {
    public static Polynomial newInstance(ShamirSecretSplitter.Algorithm algorithm, ShamirSecretSplitter.Mode mode) {
        return mode == ShamirSecretSplitter.Mode.Native ? new PolynomialNative(algorithm) : new PolynomialTable(algorithm);
    }

    public abstract byte gfDiv(int i8, int i9);

    public abstract byte gfMul(int i8, int i9);

    public byte gfPow(int i8, byte b9) {
        byte bGfMul = 1;
        for (int i9 = 0; i9 < 8; i9++) {
            if (((1 << i9) & b9) != 0) {
                bGfMul = gfMul(bGfMul & 255, i8 & 255);
            }
            int i10 = i8 & 255;
            i8 = gfMul(i10, i10);
        }
        return bGfMul;
    }

    public byte[] gfVecMul(byte[] bArr, byte[][] bArr2) {
        byte[] bArr3 = new byte[bArr2[0].length];
        for (int i8 = 0; i8 < bArr2[0].length; i8++) {
            int iGfMul = 0;
            for (int i9 = 0; i9 < bArr.length; i9++) {
                iGfMul ^= gfMul(bArr[i9] & 255, bArr2[i9][i8] & 255);
            }
            bArr3[i8] = (byte) iGfMul;
        }
        return bArr3;
    }
}
