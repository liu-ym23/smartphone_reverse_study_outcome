package org.bouncycastle.crypto.threshold;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class ShamirSecretSplitter implements SecretSplitter {

    /* renamed from: l, reason: collision with root package name */
    protected int f4590l;
    private final Polynomial poly;
    protected SecureRandom random;

    public enum Algorithm {
        AES,
        RSA
    }

    public enum Mode {
        Native,
        Table
    }

    public ShamirSecretSplitter(Algorithm algorithm, Mode mode, int i8, SecureRandom secureRandom) {
        if (i8 < 0 || i8 > 65534) {
            throw new IllegalArgumentException("Invalid input: l ranges from 0 to 65534 (2^16-2) bytes.");
        }
        this.poly = Polynomial.newInstance(algorithm, mode);
        this.f4590l = i8;
        this.random = secureRandom;
    }

    private byte[][] initP(int i8, int i9) {
        if (i8 < 1 || i8 > 255) {
            throw new IllegalArgumentException("Invalid input: m must be less than 256 and positive.");
        }
        if (i9 < i8 || i9 > 255) {
            throw new IllegalArgumentException("Invalid input: n must be less than 256 and greater than or equal to n.");
        }
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i9, i8);
        for (int i10 = 0; i10 < i9; i10++) {
            for (int i11 = 0; i11 < i8; i11++) {
                bArr[i10][i11] = this.poly.gfPow((byte) (i10 + 1), (byte) i11);
            }
        }
        return bArr;
    }

    @Override // org.bouncycastle.crypto.threshold.SecretSplitter
    public ShamirSplitSecret resplit(byte[] bArr, int i8, int i9) {
        byte[][] bArrInitP = initP(i8, i9);
        int i10 = 0;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i8, this.f4590l);
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = new ShamirSplitSecretShare[this.f4590l];
        bArr2[0] = Arrays.clone(bArr);
        for (int i11 = 1; i11 < i8; i11++) {
            this.random.nextBytes(bArr2[i11]);
        }
        while (i10 < bArrInitP.length) {
            int i12 = i10 + 1;
            shamirSplitSecretShareArr[i10] = new ShamirSplitSecretShare(this.poly.gfVecMul(bArrInitP[i10], bArr2), i12);
            i10 = i12;
        }
        return new ShamirSplitSecret(this.poly, shamirSplitSecretShareArr);
    }

    @Override // org.bouncycastle.crypto.threshold.SecretSplitter
    public ShamirSplitSecret split(int i8, int i9) {
        byte[][] bArrInitP = initP(i8, i9);
        int i10 = 0;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i8, this.f4590l);
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = new ShamirSplitSecretShare[this.f4590l];
        for (int i11 = 0; i11 < i8; i11++) {
            this.random.nextBytes(bArr[i11]);
        }
        while (i10 < bArrInitP.length) {
            int i12 = i10 + 1;
            shamirSplitSecretShareArr[i10] = new ShamirSplitSecretShare(this.poly.gfVecMul(bArrInitP[i10], bArr), i12);
            i10 = i12;
        }
        return new ShamirSplitSecret(this.poly, shamirSplitSecretShareArr);
    }

    @Override // org.bouncycastle.crypto.threshold.SecretSplitter
    public ShamirSplitSecret splitAround(SecretShare secretShare, int i8, int i9) {
        byte[][] bArrInitP = initP(i8, i9);
        int i10 = 1;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i8, this.f4590l);
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = new ShamirSplitSecretShare[this.f4590l];
        byte[] encoded = secretShare.getEncoded();
        shamirSplitSecretShareArr[0] = new ShamirSplitSecretShare(encoded, 1);
        for (int i11 = 0; i11 < i8; i11++) {
            this.random.nextBytes(bArr[i11]);
        }
        for (int i12 = 0; i12 < this.f4590l; i12++) {
            byte b9 = bArr[1][i12];
            for (int i13 = 2; i13 < i8; i13++) {
                b9 = (byte) (b9 ^ bArr[i13][i12]);
            }
            bArr[0][i12] = (byte) (b9 ^ encoded[i12]);
        }
        while (i10 < bArrInitP.length) {
            int i14 = i10 + 1;
            shamirSplitSecretShareArr[i10] = new ShamirSplitSecretShare(this.poly.gfVecMul(bArrInitP[i10], bArr), i14);
            i10 = i14;
        }
        return new ShamirSplitSecret(this.poly, shamirSplitSecretShareArr);
    }
}
