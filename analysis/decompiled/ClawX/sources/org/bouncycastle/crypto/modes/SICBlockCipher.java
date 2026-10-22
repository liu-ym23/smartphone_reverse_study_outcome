package org.bouncycastle.crypto.modes;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class SICBlockCipher extends StreamBlockCipher implements CTRModeCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    @Deprecated
    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.IV = new byte[blockSize];
        this.counter = new byte[blockSize];
        this.counterOut = new byte[blockSize];
        this.byteCount = 0;
    }

    private void adjustCounter(long j4) {
        int i8 = 5;
        if (j4 >= 0) {
            long j8 = (this.byteCount + j4) / this.blockSize;
            long j9 = j8;
            if (j8 > 255) {
                while (i8 >= 1) {
                    long j10 = 1 << (i8 * 8);
                    while (j9 >= j10) {
                        incrementCounterAt(i8);
                        j9 -= j10;
                    }
                    i8--;
                }
            }
            incrementCounter((int) j9);
            this.byteCount = (int) ((j4 + this.byteCount) - (this.blockSize * j8));
            return;
        }
        long j11 = ((-j4) - this.byteCount) / this.blockSize;
        long j12 = j11;
        if (j11 > 255) {
            while (i8 >= 1) {
                long j13 = 1 << (i8 * 8);
                while (j12 > j13) {
                    decrementCounterAt(i8);
                    j12 -= j13;
                }
                i8--;
            }
        }
        for (long j14 = 0; j14 != j12; j14++) {
            decrementCounterAt(0);
        }
        int i9 = (int) ((this.blockSize * j11) + this.byteCount + j4);
        if (i9 >= 0) {
            this.byteCount = 0;
        } else {
            decrementCounterAt(0);
            this.byteCount = this.blockSize + i9;
        }
    }

    private void checkCounter() {
        byte[] bArr = this.IV;
        if (bArr.length < this.blockSize) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                if (this.counter[length] != this.IV[length]) {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    private void checkLastIncrement() {
        byte[] bArr = this.IV;
        if (bArr.length < this.blockSize && this.counter[bArr.length - 1] != bArr[bArr.length - 1]) {
            throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
        }
    }

    private void decrementCounterAt(int i8) {
        byte b9;
        int length = this.counter.length - i8;
        do {
            length--;
            if (length < 0) {
                return;
            }
            b9 = (byte) (r1[length] - 1);
            this.counter[length] = b9;
        } while (b9 == -1);
    }

    private void incrementCounter() {
        byte b9;
        int length = this.counter.length;
        do {
            length--;
            if (length < 0) {
                return;
            }
            byte[] bArr = this.counter;
            b9 = (byte) (bArr[length] + 1);
            bArr[length] = b9;
        } while (b9 == 0);
    }

    private void incrementCounterAt(int i8) {
        byte b9;
        int length = this.counter.length - i8;
        do {
            length--;
            if (length < 0) {
                return;
            }
            byte[] bArr = this.counter;
            b9 = (byte) (bArr[length] + 1);
            bArr[length] = b9;
        } while (b9 == 0);
    }

    public static CTRModeCipher newInstance(BlockCipher blockCipher) {
        return new SICBlockCipher(blockCipher);
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b9) {
        int i8 = this.byteCount;
        if (i8 == 0) {
            checkLastIncrement();
            this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
            byte[] bArr = this.counterOut;
            int i9 = this.byteCount;
            this.byteCount = i9 + 1;
            return (byte) (bArr[i9] ^ b9);
        }
        byte[] bArr2 = this.counterOut;
        int i10 = i8 + 1;
        this.byteCount = i10;
        byte b10 = (byte) (b9 ^ bArr2[i8]);
        if (i10 == this.counter.length) {
            this.byteCount = 0;
            incrementCounter();
        }
        return b10;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long getPosition() {
        byte[] bArr = this.counter;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i8 = length - 1;
        while (i8 >= 1) {
            byte[] bArr3 = this.IV;
            int i9 = i8 < bArr3.length ? (bArr2[i8] & 255) - (bArr3[i8] & 255) : bArr2[i8] & 255;
            if (i9 < 0) {
                int i10 = i8 - 1;
                bArr2[i10] = (byte) (bArr2[i10] - 1);
                i9 += 256;
            }
            bArr2[i8] = (byte) i9;
            i8--;
        }
        return (Pack.bigEndianToLong(bArr2, length - 8) * this.blockSize) + this.byteCount;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrClone = Arrays.clone(parametersWithIV.getIV());
        this.IV = bArrClone;
        int i8 = this.blockSize;
        if (i8 < bArrClone.length) {
            throw new IllegalArgumentException(f.e(new StringBuilder("CTR/SIC mode requires IV no greater than: "), this.blockSize, " bytes."));
        }
        int i9 = 8 > i8 / 2 ? i8 / 2 : 8;
        if (i8 - bArrClone.length <= i9) {
            if (parametersWithIV.getParameters() != null) {
                this.cipher.init(true, parametersWithIV.getParameters());
            }
            reset();
        } else {
            throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.blockSize - i9) + " bytes.");
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        SICBlockCipher sICBlockCipher;
        if (this.byteCount != 0) {
            sICBlockCipher = this;
            sICBlockCipher.processBytes(bArr, i8, this.blockSize, bArr2, i9);
        } else {
            sICBlockCipher = this;
            int i10 = sICBlockCipher.blockSize;
            if (i8 + i10 > bArr.length) {
                throw new DataLengthException("input buffer too small");
            }
            if (i9 + i10 > bArr2.length) {
                throw new OutputLengthException("output buffer too short");
            }
            sICBlockCipher.cipher.processBlock(sICBlockCipher.counter, 0, sICBlockCipher.counterOut, 0);
            for (int i11 = 0; i11 < sICBlockCipher.blockSize; i11++) {
                bArr2[i9 + i11] = (byte) (bArr[i8 + i11] ^ sICBlockCipher.counterOut[i11]);
            }
            sICBlockCipher.incrementCounter();
        }
        return sICBlockCipher.blockSize;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher, org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        byte b9;
        if (i8 + i9 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = this.byteCount;
            if (i12 == 0) {
                checkLastIncrement();
                this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
                byte b10 = bArr[i8 + i11];
                byte[] bArr3 = this.counterOut;
                int i13 = this.byteCount;
                this.byteCount = i13 + 1;
                b9 = (byte) (b10 ^ bArr3[i13]);
            } else {
                byte b11 = bArr[i8 + i11];
                byte[] bArr4 = this.counterOut;
                int i14 = i12 + 1;
                this.byteCount = i14;
                b9 = (byte) (bArr4[i12] ^ b11);
                if (i14 == this.counter.length) {
                    this.byteCount = 0;
                    incrementCounter();
                }
            }
            bArr2[i10 + i11] = b9;
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.counter, (byte) 0);
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.counter, 0, bArr.length);
        this.cipher.reset();
        this.byteCount = 0;
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long seekTo(long j4) {
        reset();
        return skip(j4);
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long skip(long j4) {
        adjustCounter(j4);
        checkCounter();
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        return j4;
    }

    private void incrementCounter(int i8) {
        byte[] bArr = this.counter;
        byte b9 = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + ((byte) i8));
        if ((b9 & 255) + i8 > 255) {
            incrementCounterAt(1);
        }
    }
}
