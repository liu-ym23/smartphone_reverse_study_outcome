package org.bouncycastle.crypto.modes;

import a8.b;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes.dex */
public class PGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;
    private boolean inlineIv;
    private byte[] tmp;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.cipher = blockCipher;
        this.inlineIv = z;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.IV = new byte[blockSize];
        this.FR = new byte[blockSize];
        this.FRE = new byte[blockSize];
        this.tmp = new byte[blockSize];
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = this.blockSize;
        if (i8 + i10 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i11 = 0;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        for (int i12 = 0; i12 < this.blockSize; i12++) {
            bArr2[i9 + i12] = encryptByte(bArr[i8 + i12], i12);
        }
        while (true) {
            int i13 = this.blockSize;
            if (i11 >= i13) {
                return i13;
            }
            this.FR[i11] = bArr[i8 + i11];
            i11++;
        }
    }

    private int decryptBlockWithIV(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10;
        int i11 = this.blockSize;
        if (i8 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i12 = this.count;
        if (i12 == 0) {
            for (int i13 = 0; i13 < this.blockSize; i13++) {
                this.FR[i13] = bArr[i8 + i13];
            }
            this.cipher.processBlock(this.FR, 0, this.FRE, 0);
            this.count += this.blockSize;
            return 0;
        }
        if (i12 != i11) {
            if (i12 >= i11 + 2) {
                System.arraycopy(bArr, i8, this.tmp, 0, i11);
                bArr2[i9] = encryptByte(this.tmp[0], this.blockSize - 2);
                bArr2[i9 + 1] = encryptByte(this.tmp[1], this.blockSize - 1);
                System.arraycopy(this.tmp, 0, this.FR, this.blockSize - 2, 2);
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i14 = 0;
                while (true) {
                    i10 = this.blockSize;
                    if (i14 >= i10 - 2) {
                        break;
                    }
                    bArr2[i9 + i14 + 2] = encryptByte(this.tmp[i14 + 2], i14);
                    i14++;
                }
                System.arraycopy(this.tmp, 2, this.FR, 0, i10 - 2);
            }
            return this.blockSize;
        }
        System.arraycopy(bArr, i8, this.tmp, 0, i11);
        byte[] bArr3 = this.FR;
        System.arraycopy(bArr3, 2, bArr3, 0, this.blockSize - 2);
        byte[] bArr4 = this.FR;
        int i15 = this.blockSize;
        byte[] bArr5 = this.tmp;
        bArr4[i15 - 2] = bArr5[0];
        bArr4[i15 - 1] = bArr5[1];
        this.cipher.processBlock(bArr4, 0, this.FRE, 0);
        int i16 = 0;
        while (true) {
            int i17 = this.blockSize;
            if (i16 >= i17 - 2) {
                System.arraycopy(this.tmp, 2, this.FR, 0, i17 - 2);
                this.count += 2;
                return this.blockSize - 2;
            }
            bArr2[i9 + i16] = encryptByte(this.tmp[i16 + 2], i16);
            i16++;
        }
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = this.blockSize;
        if (i8 + i10 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i11 = 0;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        for (int i12 = 0; i12 < this.blockSize; i12++) {
            bArr2[i9 + i12] = encryptByte(bArr[i8 + i12], i12);
        }
        while (true) {
            int i13 = this.blockSize;
            if (i11 >= i13) {
                return i13;
            }
            this.FR[i11] = bArr2[i9 + i11];
            i11++;
        }
    }

    private int encryptBlockWithIV(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10;
        int i11;
        int i12 = this.blockSize;
        if (i8 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        int i13 = this.count;
        if (i13 != 0) {
            if (i13 >= i12 + 2) {
                if (i12 + i9 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i14 = 0;
                while (true) {
                    i10 = this.blockSize;
                    if (i14 >= i10) {
                        break;
                    }
                    bArr2[i9 + i14] = encryptByte(bArr[i8 + i14], i14);
                    i14++;
                }
                System.arraycopy(bArr2, i9, this.FR, 0, i10);
            }
            return this.blockSize;
        }
        if ((i12 * 2) + i9 + 2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int i15 = 0;
        while (true) {
            i11 = this.blockSize;
            if (i15 >= i11) {
                break;
            }
            bArr2[i9 + i15] = encryptByte(this.IV[i15], i15);
            i15++;
        }
        System.arraycopy(bArr2, i9, this.FR, 0, i11);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int i16 = this.blockSize;
        bArr2[i9 + i16] = encryptByte(this.IV[i16 - 2], 0);
        int i17 = this.blockSize;
        bArr2[i9 + i17 + 1] = encryptByte(this.IV[i17 - 1], 1);
        System.arraycopy(bArr2, i9 + 2, this.FR, 0, this.blockSize);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int i18 = 0;
        while (true) {
            int i19 = this.blockSize;
            if (i18 >= i19) {
                System.arraycopy(bArr2, i9 + i19 + 2, this.FR, 0, i19);
                int i20 = this.count;
                int i21 = this.blockSize;
                this.count = (i21 * 2) + 2 + i20;
                return (i21 * 2) + 2;
            }
            bArr2[b.D(i9, i19, 2, i18)] = encryptByte(bArr[i8 + i18], i18);
            i18++;
        }
    }

    private byte encryptByte(byte b9, int i8) {
        return (byte) (this.FRE[i8] ^ b9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        StringBuilder sb;
        String str;
        if (this.inlineIv) {
            sb = new StringBuilder();
            sb.append(this.cipher.getAlgorithmName());
            str = "/PGPCFBwithIV";
        } else {
            sb = new StringBuilder();
            sb.append(this.cipher.getAlgorithmName());
            str = "/PGPCFB";
        }
        sb.append(str);
        return sb.toString();
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
        if (!(cipherParameters instanceof ParametersWithIV)) {
            reset();
            this.cipher.init(true, cipherParameters);
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
        this.cipher.init(true, parametersWithIV.getParameters());
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        return this.inlineIv ? this.forEncryption ? encryptBlockWithIV(bArr, i8, bArr2, i9) : decryptBlockWithIV(bArr, i8, bArr2, i9) : this.forEncryption ? encryptBlock(bArr, i8, bArr2, i9) : decryptBlock(bArr, i8, bArr2, i9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.count = 0;
        int i8 = 0;
        while (true) {
            byte[] bArr = this.FR;
            if (i8 == bArr.length) {
                this.cipher.reset();
                return;
            }
            if (this.inlineIv) {
                bArr[i8] = 0;
            } else {
                bArr[i8] = this.IV[i8];
            }
            i8++;
        }
    }
}
