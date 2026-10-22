package org.bouncycastle.crypto.modes;

import a8.b;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class CFBBlockCipher extends StreamBlockCipher implements CFBModeCipher {
    private byte[] IV;
    private int blockSize;
    private int byteCount;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher;
    private boolean encrypting;
    private byte[] inBuf;

    public CFBBlockCipher(BlockCipher blockCipher, int i8) {
        super(blockCipher);
        this.cipher = null;
        if (i8 > blockCipher.getBlockSize() * 8 || i8 < 8 || i8 % 8 != 0) {
            throw new IllegalArgumentException(b.k(i8, "CFB", " not supported"));
        }
        this.cipher = blockCipher;
        this.blockSize = i8 / 8;
        this.IV = new byte[blockCipher.getBlockSize()];
        this.cfbV = new byte[blockCipher.getBlockSize()];
        this.cfbOutV = new byte[blockCipher.getBlockSize()];
        this.inBuf = new byte[this.blockSize];
    }

    private byte decryptByte(byte b9) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.inBuf;
        int i8 = this.byteCount;
        bArr[i8] = b9;
        byte[] bArr2 = this.cfbOutV;
        int i9 = i8 + 1;
        this.byteCount = i9;
        byte b10 = (byte) (b9 ^ bArr2[i8]);
        int i10 = this.blockSize;
        if (i9 == i10) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy(bArr3, i10, bArr3, 0, bArr3.length - i10);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i11 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i11, i11);
        }
        return b10;
    }

    private byte encryptByte(byte b9) {
        if (this.byteCount == 0) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        }
        byte[] bArr = this.cfbOutV;
        int i8 = this.byteCount;
        byte b10 = (byte) (b9 ^ bArr[i8]);
        byte[] bArr2 = this.inBuf;
        int i9 = i8 + 1;
        this.byteCount = i9;
        bArr2[i8] = b10;
        int i10 = this.blockSize;
        if (i9 == i10) {
            this.byteCount = 0;
            byte[] bArr3 = this.cfbV;
            System.arraycopy(bArr3, i10, bArr3, 0, bArr3.length - i10);
            byte[] bArr4 = this.inBuf;
            byte[] bArr5 = this.cfbV;
            int length = bArr5.length;
            int i11 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i11, i11);
        }
        return b10;
    }

    public static CFBModeCipher newInstance(BlockCipher blockCipher, int i8) {
        return new CFBBlockCipher(blockCipher, i8);
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b9) {
        return this.encrypting ? encryptByte(b9) : decryptByte(b9);
    }

    public int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        processBytes(bArr, i8, this.blockSize, bArr2, i9);
        return this.blockSize;
    }

    public int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        processBytes(bArr, i8, this.blockSize, bArr2, i9);
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    public byte[] getCurrentIV() {
        return Arrays.clone(this.cfbV);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.encrypting = z;
        if (!(cipherParameters instanceof ParametersWithIV)) {
            reset();
            if (cipherParameters != null) {
                this.cipher.init(true, cipherParameters);
                return;
            }
            return;
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] iv = parametersWithIV.getIV();
        int length = iv.length;
        byte[] bArr = this.IV;
        if (length < bArr.length) {
            System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
            int i8 = 0;
            while (true) {
                byte[] bArr2 = this.IV;
                if (i8 >= bArr2.length - iv.length) {
                    break;
                }
                bArr2[i8] = 0;
                i8++;
            }
        } else {
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
        }
        reset();
        if (parametersWithIV.getParameters() != null) {
            this.cipher.init(true, parametersWithIV.getParameters());
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        processBytes(bArr, i8, this.blockSize, bArr2, i9);
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.cfbV, 0, bArr.length);
        Arrays.fill(this.inBuf, (byte) 0);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
