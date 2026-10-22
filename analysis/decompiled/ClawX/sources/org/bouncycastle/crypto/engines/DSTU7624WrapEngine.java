package org.bouncycastle.crypto.engines;

import java.util.ArrayList;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class DSTU7624WrapEngine implements Wrapper {
    private static final int BYTES_IN_INTEGER = 4;
    private byte[] B;
    private ArrayList<byte[]> Btemp;
    private byte[] checkSumArray;
    private DSTU7624Engine engine;
    private boolean forWrapping;
    private byte[] intArray;
    private byte[] zeroArray;

    public DSTU7624WrapEngine(int i8) {
        DSTU7624Engine dSTU7624Engine = new DSTU7624Engine(i8);
        this.engine = dSTU7624Engine;
        this.B = new byte[dSTU7624Engine.getBlockSize() / 2];
        this.checkSumArray = new byte[this.engine.getBlockSize()];
        this.zeroArray = new byte[this.engine.getBlockSize()];
        this.Btemp = new ArrayList<>();
        this.intArray = new byte[4];
    }

    private void intToBytes(int i8, byte[] bArr, int i9) {
        bArr[i9 + 3] = (byte) (i8 >> 24);
        bArr[i9 + 2] = (byte) (i8 >> 16);
        bArr[i9 + 1] = (byte) (i8 >> 8);
        bArr[i9] = (byte) i8;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "DSTU7624WrapEngine";
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.forWrapping = z;
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameters passed to DSTU7624WrapEngine");
        }
        this.engine.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        }
        if (i9 % this.engine.getBlockSize() != 0) {
            throw new DataLengthException("unwrap data must be a multiple of " + this.engine.getBlockSize() + " bytes");
        }
        int blockSize = (i9 * 2) / this.engine.getBlockSize();
        int i10 = blockSize - 1;
        int i11 = i10 * 6;
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        byte[] bArr3 = new byte[this.engine.getBlockSize() / 2];
        System.arraycopy(bArr2, 0, bArr3, 0, this.engine.getBlockSize() / 2);
        this.Btemp.clear();
        int blockSize2 = i9 - (this.engine.getBlockSize() / 2);
        int blockSize3 = this.engine.getBlockSize() / 2;
        while (blockSize2 != 0) {
            byte[] bArr4 = new byte[this.engine.getBlockSize() / 2];
            System.arraycopy(bArr2, blockSize3, bArr4, 0, this.engine.getBlockSize() / 2);
            this.Btemp.add(bArr4);
            blockSize2 -= this.engine.getBlockSize() / 2;
            blockSize3 += this.engine.getBlockSize() / 2;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            System.arraycopy(this.Btemp.get(blockSize - 2), 0, bArr2, 0, this.engine.getBlockSize() / 2);
            System.arraycopy(bArr3, 0, bArr2, this.engine.getBlockSize() / 2, this.engine.getBlockSize() / 2);
            intToBytes(i11 - i12, this.intArray, 0);
            for (int i13 = 0; i13 < 4; i13++) {
                int blockSize4 = (this.engine.getBlockSize() / 2) + i13;
                bArr2[blockSize4] = (byte) (bArr2[blockSize4] ^ this.intArray[i13]);
            }
            this.engine.processBlock(bArr2, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr3, 0, this.engine.getBlockSize() / 2);
            for (int i14 = 2; i14 < blockSize; i14++) {
                int i15 = blockSize - i14;
                System.arraycopy(this.Btemp.get(i15 - 1), 0, this.Btemp.get(i15), 0, this.engine.getBlockSize() / 2);
            }
            System.arraycopy(bArr2, this.engine.getBlockSize() / 2, this.Btemp.get(0), 0, this.engine.getBlockSize() / 2);
        }
        System.arraycopy(bArr3, 0, bArr2, 0, this.engine.getBlockSize() / 2);
        int blockSize5 = this.engine.getBlockSize() / 2;
        for (int i16 = 0; i16 < i10; i16++) {
            System.arraycopy(this.Btemp.get(i16), 0, bArr2, blockSize5, this.engine.getBlockSize() / 2);
            blockSize5 += this.engine.getBlockSize() / 2;
        }
        System.arraycopy(bArr2, i9 - this.engine.getBlockSize(), this.checkSumArray, 0, this.engine.getBlockSize());
        byte[] bArr5 = new byte[i9 - this.engine.getBlockSize()];
        if (!Arrays.areEqual(this.checkSumArray, this.zeroArray)) {
            throw new InvalidCipherTextException("checksum failed");
        }
        System.arraycopy(bArr2, 0, bArr5, 0, i9 - this.engine.getBlockSize());
        return bArr5;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i8, int i9) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        }
        if (i9 % this.engine.getBlockSize() != 0) {
            throw new DataLengthException("wrap data must be a multiple of " + this.engine.getBlockSize() + " bytes");
        }
        if (i8 + i9 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        int blockSize = ((i9 / this.engine.getBlockSize()) + 1) * 2;
        int i10 = blockSize - 1;
        int i11 = i10 * 6;
        int blockSize2 = this.engine.getBlockSize() + i9;
        byte[] bArr2 = new byte[blockSize2];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        System.arraycopy(bArr2, 0, this.B, 0, this.engine.getBlockSize() / 2);
        this.Btemp.clear();
        int blockSize3 = blockSize2 - (this.engine.getBlockSize() / 2);
        int blockSize4 = this.engine.getBlockSize() / 2;
        while (blockSize3 != 0) {
            byte[] bArr3 = new byte[this.engine.getBlockSize() / 2];
            System.arraycopy(bArr2, blockSize4, bArr3, 0, this.engine.getBlockSize() / 2);
            this.Btemp.add(bArr3);
            blockSize3 -= this.engine.getBlockSize() / 2;
            blockSize4 += this.engine.getBlockSize() / 2;
        }
        int i12 = 0;
        while (i12 < i11) {
            System.arraycopy(this.B, 0, bArr2, 0, this.engine.getBlockSize() / 2);
            System.arraycopy(this.Btemp.get(0), 0, bArr2, this.engine.getBlockSize() / 2, this.engine.getBlockSize() / 2);
            this.engine.processBlock(bArr2, 0, bArr2, 0);
            i12++;
            intToBytes(i12, this.intArray, 0);
            for (int i13 = 0; i13 < 4; i13++) {
                int blockSize5 = (this.engine.getBlockSize() / 2) + i13;
                bArr2[blockSize5] = (byte) (bArr2[blockSize5] ^ this.intArray[i13]);
            }
            System.arraycopy(bArr2, this.engine.getBlockSize() / 2, this.B, 0, this.engine.getBlockSize() / 2);
            for (int i14 = 2; i14 < blockSize; i14++) {
                System.arraycopy(this.Btemp.get(i14 - 1), 0, this.Btemp.get(i14 - 2), 0, this.engine.getBlockSize() / 2);
            }
            System.arraycopy(bArr2, 0, this.Btemp.get(blockSize - 2), 0, this.engine.getBlockSize() / 2);
        }
        System.arraycopy(this.B, 0, bArr2, 0, this.engine.getBlockSize() / 2);
        int blockSize6 = this.engine.getBlockSize() / 2;
        for (int i15 = 0; i15 < i10; i15++) {
            System.arraycopy(this.Btemp.get(i15), 0, bArr2, blockSize6, this.engine.getBlockSize() / 2);
            blockSize6 += this.engine.getBlockSize() / 2;
        }
        return bArr2;
    }
}
