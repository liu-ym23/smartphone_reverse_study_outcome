package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* loaded from: classes.dex */
public class OpenPGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;

    public OpenPGPCFBBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.IV = new byte[blockSize];
        this.FR = new byte[blockSize];
        this.FRE = new byte[blockSize];
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10;
        int i11 = this.blockSize;
        if (i8 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i12 = this.count;
        int i13 = 2;
        int i14 = 0;
        if (i12 > i11) {
            byte b9 = bArr[i8];
            this.FR[i11 - 2] = b9;
            bArr2[i9] = encryptByte(b9, i11 - 2);
            byte b10 = bArr[i8 + 1];
            byte[] bArr3 = this.FR;
            int i15 = this.blockSize;
            bArr3[i15 - 1] = b10;
            bArr2[i9 + 1] = encryptByte(b10, i15 - 1);
            this.cipher.processBlock(this.FR, 0, this.FRE, 0);
            while (i13 < this.blockSize) {
                byte b11 = bArr[i8 + i13];
                int i16 = i13 - 2;
                this.FR[i16] = b11;
                bArr2[i9 + i13] = encryptByte(b11, i16);
                i13++;
            }
        } else {
            if (i12 != 0) {
                if (i12 == i11) {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    byte b12 = bArr[i8];
                    byte b13 = bArr[i8 + 1];
                    bArr2[i9] = encryptByte(b12, 0);
                    bArr2[i9 + 1] = encryptByte(b13, 1);
                    byte[] bArr4 = this.FR;
                    System.arraycopy(bArr4, 2, bArr4, 0, this.blockSize - 2);
                    byte[] bArr5 = this.FR;
                    int i17 = this.blockSize;
                    bArr5[i17 - 2] = b12;
                    bArr5[i17 - 1] = b13;
                    this.cipher.processBlock(bArr5, 0, this.FRE, 0);
                    while (true) {
                        i10 = this.blockSize;
                        if (i13 >= i10) {
                            break;
                        }
                        byte b14 = bArr[i8 + i13];
                        int i18 = i13 - 2;
                        this.FR[i18] = b14;
                        bArr2[i9 + i13] = encryptByte(b14, i18);
                        i13++;
                    }
                }
            } else {
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                while (true) {
                    i10 = this.blockSize;
                    if (i14 >= i10) {
                        break;
                    }
                    int i19 = i8 + i14;
                    this.FR[i14] = bArr[i19];
                    bArr2[i9 + i14] = encryptByte(bArr[i19], i14);
                    i14++;
                }
            }
            this.count += i10;
        }
        return this.blockSize;
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10;
        int i11 = this.blockSize;
        if (i8 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i12 = this.count;
        int i13 = 2;
        int i14 = 0;
        if (i12 > i11) {
            byte[] bArr3 = this.FR;
            int i15 = i11 - 2;
            byte bEncryptByte = encryptByte(bArr[i8], i11 - 2);
            bArr2[i9] = bEncryptByte;
            bArr3[i15] = bEncryptByte;
            byte[] bArr4 = this.FR;
            int i16 = this.blockSize;
            int i17 = i16 - 1;
            byte bEncryptByte2 = encryptByte(bArr[i8 + 1], i16 - 1);
            bArr2[i9 + 1] = bEncryptByte2;
            bArr4[i17] = bEncryptByte2;
            this.cipher.processBlock(this.FR, 0, this.FRE, 0);
            while (i13 < this.blockSize) {
                byte[] bArr5 = this.FR;
                int i18 = i13 - 2;
                byte bEncryptByte3 = encryptByte(bArr[i8 + i13], i18);
                bArr2[i9 + i13] = bEncryptByte3;
                bArr5[i18] = bEncryptByte3;
                i13++;
            }
        } else {
            if (i12 != 0) {
                if (i12 == i11) {
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    bArr2[i9] = encryptByte(bArr[i8], 0);
                    bArr2[i9 + 1] = encryptByte(bArr[i8 + 1], 1);
                    byte[] bArr6 = this.FR;
                    System.arraycopy(bArr6, 2, bArr6, 0, this.blockSize - 2);
                    System.arraycopy(bArr2, i9, this.FR, this.blockSize - 2, 2);
                    this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                    while (true) {
                        i10 = this.blockSize;
                        if (i13 >= i10) {
                            break;
                        }
                        byte[] bArr7 = this.FR;
                        int i19 = i13 - 2;
                        byte bEncryptByte4 = encryptByte(bArr[i8 + i13], i19);
                        bArr2[i9 + i13] = bEncryptByte4;
                        bArr7[i19] = bEncryptByte4;
                        i13++;
                    }
                }
            } else {
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                while (true) {
                    i10 = this.blockSize;
                    if (i14 >= i10) {
                        break;
                    }
                    byte[] bArr8 = this.FR;
                    byte bEncryptByte5 = encryptByte(bArr[i8 + i14], i14);
                    bArr2[i9 + i14] = bEncryptByte5;
                    bArr8[i14] = bEncryptByte5;
                    i14++;
                }
            }
            this.count += i10;
        }
        return this.blockSize;
    }

    private byte encryptByte(byte b9, int i8) {
        return (byte) (this.FRE[i8] ^ b9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OpenPGPCFB";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        reset();
        this.cipher.init(true, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        return this.forEncryption ? encryptBlock(bArr, i8, bArr2, i9) : decryptBlock(bArr, i8, bArr2, i9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.count = 0;
        byte[] bArr = this.IV;
        byte[] bArr2 = this.FR;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
    }
}
