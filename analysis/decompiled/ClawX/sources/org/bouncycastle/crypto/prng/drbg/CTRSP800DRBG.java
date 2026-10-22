package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public class CTRSP800DRBG implements SP80090DRBG {
    private static final int AES_MAX_BITS_REQUEST = 262144;
    private static final long AES_RESEED_MAX = 140737488355328L;
    private static final byte[] K_BITS = Hex.decodeStrict("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    private static final int TDEA_MAX_BITS_REQUEST = 4096;
    private static final long TDEA_RESEED_MAX = 2147483648L;
    private byte[] _Key;
    private byte[] _V;
    private BlockCipher _engine;
    private EntropySource _entropySource;
    private boolean _isTDEA;
    private int _keySizeInBits;
    private long _reseedCounter = 0;
    private int _securityStrength;
    private int _seedLength;

    public CTRSP800DRBG(BlockCipher blockCipher, int i8, int i9, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this._isTDEA = false;
        this._entropySource = entropySource;
        this._engine = blockCipher;
        this._keySizeInBits = i8;
        this._securityStrength = i9;
        this._seedLength = (blockCipher.getBlockSize() * 8) + i8;
        this._isTDEA = isTDEA(blockCipher);
        if (i9 > 256) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (getMaxSecurityStrength(blockCipher, i8) < i9) {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        }
        if (entropySource.entropySize() < i9) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        CTR_DRBG_Instantiate_algorithm(getEntropy(), bArr2, bArr);
    }

    private void BCC(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int blockSize = this._engine.getBlockSize();
        byte[] bArr5 = new byte[blockSize];
        int length = bArr4.length / blockSize;
        byte[] bArr6 = new byte[blockSize];
        this._engine.init(true, new KeyParameter(expandKey(bArr2)));
        this._engine.processBlock(bArr3, 0, bArr5, 0);
        for (int i8 = 0; i8 < length; i8++) {
            Bytes.xor(blockSize, bArr5, 0, bArr4, i8 * blockSize, bArr6, 0);
            this._engine.processBlock(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    private byte[] Block_Cipher_df(byte[] bArr, int i8) {
        int blockSize = this._engine.getBlockSize();
        int length = bArr.length;
        int i9 = i8 / 8;
        byte[] bArr2 = new byte[((((length + 9) + blockSize) - 1) / blockSize) * blockSize];
        copyIntToByteArray(bArr2, length, 0);
        copyIntToByteArray(bArr2, i9, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[length + 8] = -128;
        int i10 = this._keySizeInBits;
        int i11 = (i10 / 8) + blockSize;
        byte[] bArr3 = new byte[i11];
        byte[] bArr4 = new byte[blockSize];
        byte[] bArr5 = new byte[blockSize];
        int i12 = i10 / 8;
        byte[] bArr6 = new byte[i12];
        System.arraycopy(K_BITS, 0, bArr6, 0, i12);
        int i13 = 0;
        while (true) {
            int i14 = i13 * blockSize;
            if (i14 * 8 >= (blockSize * 8) + this._keySizeInBits) {
                break;
            }
            copyIntToByteArray(bArr5, i13, 0);
            BCC(bArr4, bArr6, bArr5, bArr2);
            int i15 = i11 - i14;
            if (i15 > blockSize) {
                i15 = blockSize;
            }
            System.arraycopy(bArr4, 0, bArr3, i14, i15);
            i13++;
        }
        byte[] bArr7 = new byte[blockSize];
        System.arraycopy(bArr3, 0, bArr6, 0, i12);
        System.arraycopy(bArr3, i12, bArr7, 0, blockSize);
        byte[] bArr8 = new byte[i9];
        this._engine.init(true, new KeyParameter(expandKey(bArr6)));
        int i16 = 0;
        while (true) {
            int i17 = i16 * blockSize;
            if (i17 >= i9) {
                return bArr8;
            }
            this._engine.processBlock(bArr7, 0, bArr7, 0);
            int i18 = i9 - i17;
            if (i18 > blockSize) {
                i18 = blockSize;
            }
            System.arraycopy(bArr7, 0, bArr8, i17, i18);
            i16++;
        }
    }

    private void CTR_DRBG_Instantiate_algorithm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrBlock_Cipher_df = Block_Cipher_df(Arrays.concatenate(bArr, bArr2, bArr3), this._seedLength);
        int blockSize = this._engine.getBlockSize();
        byte[] bArr4 = new byte[(this._keySizeInBits + 7) / 8];
        this._Key = bArr4;
        byte[] bArr5 = new byte[blockSize];
        this._V = bArr5;
        CTR_DRBG_Update(bArrBlock_Cipher_df, bArr4, bArr5);
        this._reseedCounter = 1L;
    }

    private void CTR_DRBG_Reseed_algorithm(byte[] bArr) {
        CTR_DRBG_Update(Block_Cipher_df(Arrays.concatenate(getEntropy(), bArr), this._seedLength), this._Key, this._V);
        this._reseedCounter = 1L;
    }

    private void CTR_DRBG_Update(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this._engine.getBlockSize()];
        int blockSize = this._engine.getBlockSize();
        this._engine.init(true, new KeyParameter(expandKey(bArr2)));
        int i8 = 0;
        while (true) {
            int i9 = i8 * blockSize;
            if (i9 >= bArr.length) {
                Bytes.xorTo(bArr.length, bArr, bArr4);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            } else {
                addOneTo(bArr3);
                this._engine.processBlock(bArr3, 0, bArr5, 0);
                int i10 = length - i9;
                if (i10 > blockSize) {
                    i10 = blockSize;
                }
                System.arraycopy(bArr5, 0, bArr4, i9, i10);
                i8++;
            }
        }
    }

    private void addOneTo(byte[] bArr) {
        int i8 = 1;
        for (int i9 = 1; i9 <= bArr.length; i9++) {
            int i10 = (bArr[bArr.length - i9] & 255) + i8;
            i8 = i10 > 255 ? 1 : 0;
            bArr[bArr.length - i9] = (byte) i10;
        }
    }

    private void copyIntToByteArray(byte[] bArr, int i8, int i9) {
        bArr[i9] = (byte) (i8 >> 24);
        bArr[i9 + 1] = (byte) (i8 >> 16);
        bArr[i9 + 2] = (byte) (i8 >> 8);
        bArr[i9 + 3] = (byte) i8;
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private int getMaxSecurityStrength(BlockCipher blockCipher, int i8) {
        if (isTDEA(blockCipher) && i8 == 168) {
            return 112;
        }
        if (blockCipher.getAlgorithmName().equals("AES")) {
            return i8;
        }
        return -1;
    }

    private boolean isTDEA(BlockCipher blockCipher) {
        return blockCipher.getAlgorithmName().equals("DESede") || blockCipher.getAlgorithmName().equals("TDEA");
    }

    private void padKey(byte[] bArr, int i8, byte[] bArr2, int i9) {
        bArr2[i9] = (byte) (bArr[i8] & 254);
        int i10 = i8 + 1;
        bArr2[i9 + 1] = (byte) ((bArr[i8] << 7) | ((bArr[i10] & 252) >>> 1));
        int i11 = bArr[i10] << 6;
        int i12 = i8 + 2;
        bArr2[i9 + 2] = (byte) (i11 | ((bArr[i12] & 248) >>> 2));
        int i13 = bArr[i12] << 5;
        int i14 = i8 + 3;
        bArr2[i9 + 3] = (byte) (i13 | ((bArr[i14] & 240) >>> 3));
        int i15 = bArr[i14] << 4;
        int i16 = i8 + 4;
        bArr2[i9 + 4] = (byte) (i15 | ((bArr[i16] & 224) >>> 4));
        int i17 = bArr[i16] << 3;
        int i18 = i8 + 5;
        bArr2[i9 + 5] = (byte) (i17 | ((bArr[i18] & 192) >>> 5));
        int i19 = i8 + 6;
        bArr2[i9 + 6] = (byte) ((bArr[i18] << 2) | ((bArr[i19] & 128) >>> 6));
        int i20 = i9 + 7;
        bArr2[i20] = (byte) (bArr[i19] << 1);
        while (i9 <= i20) {
            byte b9 = bArr2[i9];
            bArr2[i9] = (byte) (((((b9 >> 7) ^ ((((((b9 >> 1) ^ (b9 >> 2)) ^ (b9 >> 3)) ^ (b9 >> 4)) ^ (b9 >> 5)) ^ (b9 >> 6))) ^ 1) & 1) | (b9 & 254));
            i9++;
        }
    }

    public byte[] expandKey(byte[] bArr) {
        if (!this._isTDEA) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        padKey(bArr, 0, bArr2, 0);
        padKey(bArr, 7, bArr2, 8);
        padKey(bArr, 14, bArr2, 16);
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArrBlock_Cipher_df;
        boolean z2 = this._isTDEA;
        long j4 = this._reseedCounter;
        if (z2) {
            if (j4 > TDEA_RESEED_MAX) {
                return -1;
            }
            if (Utils.isTooLarge(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else {
            if (j4 > AES_RESEED_MAX) {
                return -1;
            }
            if (Utils.isTooLarge(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z) {
            CTR_DRBG_Reseed_algorithm(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArrBlock_Cipher_df = Block_Cipher_df(bArr2, this._seedLength);
            CTR_DRBG_Update(bArrBlock_Cipher_df, this._Key, this._V);
        } else {
            bArrBlock_Cipher_df = new byte[this._seedLength / 8];
        }
        int length = this._V.length;
        byte[] bArr3 = new byte[length];
        this._engine.init(true, new KeyParameter(expandKey(this._Key)));
        for (int i8 = 0; i8 <= bArr.length / length; i8++) {
            int i9 = i8 * length;
            int length2 = bArr.length - i9 > length ? length : bArr.length - (this._V.length * i8);
            if (length2 != 0) {
                addOneTo(this._V);
                this._engine.processBlock(this._V, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i9, length2);
            }
        }
        CTR_DRBG_Update(bArrBlock_Cipher_df, this._Key, this._V);
        this._reseedCounter++;
        return bArr.length * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._V.length * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) {
        CTR_DRBG_Reseed_algorithm(bArr);
    }
}
