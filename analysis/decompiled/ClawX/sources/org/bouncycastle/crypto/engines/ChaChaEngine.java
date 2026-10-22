package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public static void chachaCore(int i8, int[] iArr, int[] iArr2) {
        int i9 = 16;
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        }
        if (i8 % 2 != 0) {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        char c3 = 3;
        int i13 = iArr[3];
        char c8 = 4;
        int i14 = iArr[4];
        char c9 = 5;
        int i15 = iArr[5];
        char c10 = 6;
        int i16 = iArr[6];
        int i17 = 7;
        int i18 = iArr[7];
        int i19 = 8;
        int i20 = iArr[8];
        int i21 = iArr[9];
        int i22 = iArr[10];
        int i23 = iArr[11];
        int i24 = 12;
        int i25 = iArr[12];
        int i26 = iArr[13];
        int i27 = iArr[14];
        int iRotateLeft = iArr[15];
        int iRotateLeft2 = i27;
        int iRotateLeft3 = i26;
        int iRotateLeft4 = i25;
        int i28 = i23;
        int i29 = i22;
        int i30 = i21;
        int i31 = i20;
        int iRotateLeft5 = i18;
        int iRotateLeft6 = i16;
        int iRotateLeft7 = i15;
        int iRotateLeft8 = i14;
        int i32 = i13;
        int i33 = i12;
        int i34 = i11;
        int i35 = i10;
        int i36 = i8;
        while (i36 > 0) {
            int i37 = i35 + iRotateLeft8;
            char c11 = c3;
            int iRotateLeft9 = Integers.rotateLeft(iRotateLeft4 ^ i37, i9);
            int i38 = i31 + iRotateLeft9;
            int iRotateLeft10 = Integers.rotateLeft(iRotateLeft8 ^ i38, i24);
            int i39 = i37 + iRotateLeft10;
            int iRotateLeft11 = Integers.rotateLeft(iRotateLeft9 ^ i39, i19);
            int i40 = i38 + iRotateLeft11;
            int iRotateLeft12 = Integers.rotateLeft(iRotateLeft10 ^ i40, i17);
            int i41 = i34 + iRotateLeft7;
            char c12 = c8;
            int iRotateLeft13 = Integers.rotateLeft(iRotateLeft3 ^ i41, i9);
            int i42 = i30 + iRotateLeft13;
            char c13 = c9;
            int iRotateLeft14 = Integers.rotateLeft(iRotateLeft7 ^ i42, i24);
            int i43 = i41 + iRotateLeft14;
            int iRotateLeft15 = Integers.rotateLeft(iRotateLeft13 ^ i43, i19);
            int i44 = i42 + iRotateLeft15;
            int iRotateLeft16 = Integers.rotateLeft(iRotateLeft14 ^ i44, i17);
            int i45 = i33 + iRotateLeft6;
            char c14 = c10;
            int iRotateLeft17 = Integers.rotateLeft(iRotateLeft2 ^ i45, i9);
            int i46 = i29 + iRotateLeft17;
            int iRotateLeft18 = Integers.rotateLeft(iRotateLeft6 ^ i46, i24);
            int i47 = i45 + iRotateLeft18;
            int iRotateLeft19 = Integers.rotateLeft(iRotateLeft17 ^ i47, i19);
            int i48 = i46 + iRotateLeft19;
            int iRotateLeft20 = Integers.rotateLeft(iRotateLeft18 ^ i48, i17);
            int i49 = i32 + iRotateLeft5;
            int iRotateLeft21 = Integers.rotateLeft(iRotateLeft ^ i49, 16);
            int i50 = i28 + iRotateLeft21;
            int iRotateLeft22 = Integers.rotateLeft(iRotateLeft5 ^ i50, i24);
            int i51 = i49 + iRotateLeft22;
            int iRotateLeft23 = Integers.rotateLeft(iRotateLeft21 ^ i51, 8);
            int i52 = i50 + iRotateLeft23;
            int iRotateLeft24 = Integers.rotateLeft(iRotateLeft22 ^ i52, 7);
            int i53 = i39 + iRotateLeft16;
            int iRotateLeft25 = Integers.rotateLeft(iRotateLeft23 ^ i53, 16);
            int i54 = i48 + iRotateLeft25;
            int iRotateLeft26 = Integers.rotateLeft(iRotateLeft16 ^ i54, 12);
            i35 = i53 + iRotateLeft26;
            iRotateLeft = Integers.rotateLeft(iRotateLeft25 ^ i35, 8);
            i29 = i54 + iRotateLeft;
            iRotateLeft7 = Integers.rotateLeft(iRotateLeft26 ^ i29, 7);
            int i55 = i43 + iRotateLeft20;
            int iRotateLeft27 = Integers.rotateLeft(iRotateLeft11 ^ i55, 16);
            int i56 = i52 + iRotateLeft27;
            int iRotateLeft28 = Integers.rotateLeft(iRotateLeft20 ^ i56, 12);
            i34 = i55 + iRotateLeft28;
            iRotateLeft4 = Integers.rotateLeft(iRotateLeft27 ^ i34, 8);
            i28 = i56 + iRotateLeft4;
            iRotateLeft6 = Integers.rotateLeft(iRotateLeft28 ^ i28, 7);
            int i57 = i47 + iRotateLeft24;
            int iRotateLeft29 = Integers.rotateLeft(iRotateLeft15 ^ i57, 16);
            int i58 = i40 + iRotateLeft29;
            int iRotateLeft30 = Integers.rotateLeft(iRotateLeft24 ^ i58, 12);
            i33 = i57 + iRotateLeft30;
            iRotateLeft3 = Integers.rotateLeft(iRotateLeft29 ^ i33, 8);
            i31 = i58 + iRotateLeft3;
            iRotateLeft5 = Integers.rotateLeft(iRotateLeft30 ^ i31, 7);
            int i59 = i51 + iRotateLeft12;
            int iRotateLeft31 = Integers.rotateLeft(iRotateLeft19 ^ i59, 16);
            int i60 = i44 + iRotateLeft31;
            int iRotateLeft32 = Integers.rotateLeft(iRotateLeft12 ^ i60, 12);
            i32 = i59 + iRotateLeft32;
            iRotateLeft2 = Integers.rotateLeft(iRotateLeft31 ^ i32, 8);
            i30 = i60 + iRotateLeft2;
            iRotateLeft8 = Integers.rotateLeft(iRotateLeft32 ^ i30, 7);
            i36 -= 2;
            i9 = 16;
            c3 = c11;
            c8 = c12;
            c9 = c13;
            c10 = c14;
            i17 = 7;
            i19 = 8;
            i24 = 12;
        }
        char c15 = c3;
        char c16 = c8;
        char c17 = c9;
        char c18 = c10;
        iArr2[0] = i35 + iArr[0];
        iArr2[1] = i34 + iArr[1];
        iArr2[2] = i33 + iArr[2];
        iArr2[c15] = i32 + iArr[c15];
        iArr2[c16] = iRotateLeft8 + iArr[c16];
        iArr2[c17] = iRotateLeft7 + iArr[c17];
        iArr2[c18] = iRotateLeft6 + iArr[c18];
        iArr2[7] = iRotateLeft5 + iArr[7];
        iArr2[8] = i31 + iArr[8];
        iArr2[9] = i30 + iArr[9];
        iArr2[10] = i29 + iArr[10];
        iArr2[11] = i28 + iArr[11];
        iArr2[12] = iRotateLeft4 + iArr[12];
        iArr2[13] = iRotateLeft3 + iArr[13];
        iArr2[14] = iRotateLeft2 + iArr[14];
        iArr2[15] = iRotateLeft + iArr[15];
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i8 = iArr[12] + 1;
        iArr[12] = i8;
        if (i8 == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void generateKeyStream(byte[] bArr) {
        chachaCore(this.rounds, this.engineState, this.f4474x);
        Pack.intToLittleEndian(this.f4474x, bArr, 0);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ChaCha" + this.rounds;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public long getCounter() {
        int[] iArr = this.engineState;
        return (iArr[13] << 32) | (iArr[12] & 4294967295L);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i8 = iArr[12];
        if (i8 == 0 && iArr[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i9 = i8 - 1;
        iArr[12] = i9;
        if (i9 == -1) {
            iArr[13] = iArr[13] - 1;
        }
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 16 && bArr.length != 32) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
            packTauOrSigma(bArr.length, this.engineState, 0);
            Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 4);
            Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 8, 4);
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 14, 2);
    }

    public ChaChaEngine(int i8) {
        super(i8);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter(long j4) {
        int i8 = (int) (j4 >>> 32);
        int i9 = (int) j4;
        if (i8 > 0) {
            int[] iArr = this.engineState;
            iArr[13] = iArr[13] + i8;
        }
        int[] iArr2 = this.engineState;
        int i10 = iArr2[12];
        int i11 = i9 + i10;
        iArr2[12] = i11;
        if (i10 == 0 || i11 >= i10) {
            return;
        }
        iArr2[13] = iArr2[13] + 1;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter(long j4) {
        int i8 = (int) (j4 >>> 32);
        int i9 = (int) j4;
        if (i8 != 0) {
            int[] iArr = this.engineState;
            int i10 = iArr[13];
            if ((i10 & 4294967295L) < (i8 & 4294967295L)) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
            iArr[13] = i10 - i8;
        }
        int[] iArr2 = this.engineState;
        int i11 = iArr2[12];
        if ((i11 & 4294967295L) >= (4294967295L & i9)) {
            iArr2[12] = i11 - i9;
            return;
        }
        int i12 = iArr2[13];
        if (i12 == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr2[13] = i12 - 1;
        iArr2[12] = i11 - i9;
    }
}
