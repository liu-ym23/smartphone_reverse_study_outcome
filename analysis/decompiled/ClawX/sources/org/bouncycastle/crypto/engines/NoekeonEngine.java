package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class NoekeonEngine implements BlockCipher {
    private static final int SIZE = 16;
    private static final byte[] roundConstants = {-128, 27, 54, 108, -40, -85, 77, -102, 47, 94, PSSSigner.TRAILER_IMPLICIT, 99, -58, -105, 53, 106, -44};
    private boolean _forEncryption;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f4467k = new int[4];
    private boolean _initialised = false;

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBigEndianToInt = Pack.bigEndianToInt(bArr, i8);
        int iBigEndianToInt2 = Pack.bigEndianToInt(bArr, i8 + 4);
        int iBigEndianToInt3 = Pack.bigEndianToInt(bArr, i8 + 8);
        int iBigEndianToInt4 = Pack.bigEndianToInt(bArr, i8 + 12);
        int[] iArr = this.f4467k;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = 16;
        while (true) {
            int i15 = iBigEndianToInt ^ iBigEndianToInt3;
            int iRotateLeft = i15 ^ (Integers.rotateLeft(i15, 8) ^ Integers.rotateLeft(i15, 24));
            int i16 = iBigEndianToInt2 ^ i11;
            int i17 = iBigEndianToInt4 ^ i13;
            int i18 = i16 ^ i17;
            int iRotateLeft2 = i18 ^ (Integers.rotateLeft(i18, 24) ^ Integers.rotateLeft(i18, 8));
            int i19 = i16 ^ iRotateLeft;
            int i20 = (iBigEndianToInt3 ^ i12) ^ iRotateLeft2;
            int i21 = i17 ^ iRotateLeft;
            int i22 = ((iBigEndianToInt ^ i10) ^ iRotateLeft2) ^ (roundConstants[i14] & 255);
            i14--;
            if (i14 < 0) {
                Pack.intToBigEndian(i22, bArr2, i9);
                Pack.intToBigEndian(i19, bArr2, i9 + 4);
                Pack.intToBigEndian(i20, bArr2, i9 + 8);
                Pack.intToBigEndian(i21, bArr2, i9 + 12);
                return 16;
            }
            int iRotateLeft3 = Integers.rotateLeft(i19, 1);
            int iRotateLeft4 = Integers.rotateLeft(i20, 5);
            int iRotateLeft5 = Integers.rotateLeft(i21, 2);
            int i23 = iRotateLeft3 ^ (iRotateLeft5 | iRotateLeft4);
            int i24 = ~i23;
            int i25 = i22 ^ (iRotateLeft4 & i24);
            int i26 = (iRotateLeft4 ^ (i24 ^ iRotateLeft5)) ^ i25;
            int i27 = i23 ^ (i25 | i26);
            int i28 = iRotateLeft5 ^ (i26 & i27);
            iBigEndianToInt2 = Integers.rotateLeft(i27, 31);
            iBigEndianToInt3 = Integers.rotateLeft(i26, 27);
            int iRotateLeft6 = Integers.rotateLeft(i25, 30);
            iBigEndianToInt = i28;
            iBigEndianToInt4 = iRotateLeft6;
        }
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBigEndianToInt = Pack.bigEndianToInt(bArr, i8);
        int iBigEndianToInt2 = Pack.bigEndianToInt(bArr, i8 + 4);
        int iBigEndianToInt3 = Pack.bigEndianToInt(bArr, i8 + 8);
        int iBigEndianToInt4 = Pack.bigEndianToInt(bArr, i8 + 12);
        int[] iArr = this.f4467k;
        int i10 = 0;
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        while (true) {
            int i15 = iBigEndianToInt ^ (roundConstants[i10] & 255);
            int i16 = i15 ^ iBigEndianToInt3;
            int iRotateLeft = i16 ^ (Integers.rotateLeft(i16, 8) ^ Integers.rotateLeft(i16, 24));
            int i17 = iBigEndianToInt2 ^ i12;
            int i18 = iBigEndianToInt4 ^ i14;
            int i19 = i17 ^ i18;
            int iRotateLeft2 = (Integers.rotateLeft(i19, 24) ^ Integers.rotateLeft(i19, 8)) ^ i19;
            int i20 = (i15 ^ i11) ^ iRotateLeft2;
            int i21 = i17 ^ iRotateLeft;
            int i22 = (iBigEndianToInt3 ^ i13) ^ iRotateLeft2;
            int i23 = i18 ^ iRotateLeft;
            i10++;
            if (i10 > 16) {
                Pack.intToBigEndian(i20, bArr2, i9);
                Pack.intToBigEndian(i21, bArr2, i9 + 4);
                Pack.intToBigEndian(i22, bArr2, i9 + 8);
                Pack.intToBigEndian(i23, bArr2, i9 + 12);
                return 16;
            }
            int iRotateLeft3 = Integers.rotateLeft(i21, 1);
            int iRotateLeft4 = Integers.rotateLeft(i22, 5);
            int iRotateLeft5 = Integers.rotateLeft(i23, 2);
            int i24 = iRotateLeft3 ^ (iRotateLeft5 | iRotateLeft4);
            int i25 = ~i24;
            int i26 = i20 ^ (iRotateLeft4 & i25);
            int i27 = (iRotateLeft4 ^ (i25 ^ iRotateLeft5)) ^ i26;
            int i28 = i24 ^ (i26 | i27);
            int i29 = iRotateLeft5 ^ (i27 & i28);
            iBigEndianToInt2 = Integers.rotateLeft(i28, 31);
            iBigEndianToInt3 = Integers.rotateLeft(i27, 27);
            int iRotateLeft6 = Integers.rotateLeft(i26, 30);
            iBigEndianToInt = i29;
            iBigEndianToInt4 = iRotateLeft6;
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Noekeon";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to Noekeon init - "));
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length != 16) {
            throw new IllegalArgumentException("Key length not 128 bits.");
        }
        Pack.bigEndianToInt(key, 0, this.f4467k, 0, 4);
        if (!z) {
            int[] iArr = this.f4467k;
            int i8 = iArr[0];
            int i9 = iArr[1];
            int i10 = iArr[2];
            int i11 = iArr[3];
            int i12 = i8 ^ i10;
            int iRotateLeft = i12 ^ (Integers.rotateLeft(i12, 8) ^ Integers.rotateLeft(i12, 24));
            int i13 = i9 ^ i11;
            int iRotateLeft2 = (Integers.rotateLeft(i13, 8) ^ Integers.rotateLeft(i13, 24)) ^ i13;
            int i14 = i9 ^ iRotateLeft;
            int i15 = i11 ^ iRotateLeft;
            int[] iArr2 = this.f4467k;
            iArr2[0] = i8 ^ iRotateLeft2;
            iArr2[1] = i14;
            iArr2[2] = i10 ^ iRotateLeft2;
            iArr2[3] = i15;
        }
        this._forEncryption = z;
        this._initialised = true;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i8 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 <= bArr2.length - 16) {
            return this._forEncryption ? encryptBlock(bArr, i8, bArr2, i9) : decryptBlock(bArr, i8, bArr2, i9);
        }
        throw new OutputLengthException("output buffer too short");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
