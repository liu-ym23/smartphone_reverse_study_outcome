package org.bouncycastle.crypto.threshold;

import org.bouncycastle.crypto.threshold.ShamirSecretSplitter;

/* loaded from: classes.dex */
class PolynomialNative extends Polynomial {
    private final int IRREDUCIBLE;

    /* renamed from: org.bouncycastle.crypto.threshold.PolynomialNative$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm;

        static {
            int[] iArr = new int[ShamirSecretSplitter.Algorithm.values().length];
            $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm = iArr;
            try {
                iArr[ShamirSecretSplitter.Algorithm.AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm[ShamirSecretSplitter.Algorithm.RSA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolynomialNative(ShamirSecretSplitter.Algorithm algorithm) {
        int i8;
        int i9 = AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm[algorithm.ordinal()];
        if (i9 == 1) {
            i8 = 283;
        } else {
            if (i9 != 2) {
                throw new IllegalArgumentException("The algorithm is not correct");
            }
            i8 = 285;
        }
        this.IRREDUCIBLE = i8;
    }

    @Override // org.bouncycastle.crypto.threshold.Polynomial
    public byte gfDiv(int i8, int i9) {
        return gfMul(i8, gfPow((byte) i9, (byte) -2) & 255);
    }

    @Override // org.bouncycastle.crypto.threshold.Polynomial
    public byte gfMul(int i8, int i9) {
        int i10 = 0;
        while (i9 > 0) {
            if ((i9 & 1) != 0) {
                i10 ^= i8;
            }
            i8 <<= 1;
            if ((i8 & 256) != 0) {
                i8 ^= this.IRREDUCIBLE;
            }
            i9 >>= 1;
        }
        while (i10 >= 256) {
            if ((i10 & 256) != 0) {
                i10 ^= this.IRREDUCIBLE;
            }
            i10 <<= 1;
        }
        return (byte) (i10 & 255);
    }
}
