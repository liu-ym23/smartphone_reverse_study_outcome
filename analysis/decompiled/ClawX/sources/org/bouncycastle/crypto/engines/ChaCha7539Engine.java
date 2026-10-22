package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ChaCha7539Engine extends Salsa20Engine {
    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i8 = iArr[12] + 1;
        iArr[12] = i8;
        if (i8 == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void generateKeyStream(byte[] bArr) {
        ChaChaEngine.chachaCore(this.rounds, this.engineState, this.f4474x);
        Pack.intToLittleEndian(this.f4474x, bArr, 0);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ChaCha7539";
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public long getCounter() {
        return this.engineState[12] & 4294967295L;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public int getNonceSize() {
        return 12;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void resetCounter() {
        this.engineState[12] = 0;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i8 = iArr[12];
        if (i8 == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr[12] = i8 - 1;
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 32) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
            }
            packTauOrSigma(bArr.length, this.engineState, 0);
            Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 8);
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 13, 3);
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void advanceCounter(long j4) {
        int i8 = (int) (j4 >>> 32);
        int i9 = (int) j4;
        if (i8 > 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
        int[] iArr = this.engineState;
        int i10 = iArr[12];
        int i11 = i9 + i10;
        iArr[12] = i11;
        if (i10 != 0 && i11 < i10) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    @Override // org.bouncycastle.crypto.engines.Salsa20Engine
    public void retreatCounter(long j4) {
        int i8 = (int) (j4 >>> 32);
        int i9 = (int) j4;
        if (i8 != 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int[] iArr = this.engineState;
        int i10 = iArr[12];
        if ((i10 & 4294967295L) < (4294967295L & i9)) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr[12] = i10 - i9;
    }
}
