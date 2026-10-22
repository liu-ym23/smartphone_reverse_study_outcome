package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class RFC3394WrapEngine implements Wrapper {
    private static final byte[] DEFAULT_IV = {-90, -90, -90, -90, -90, -90, -90, -90};
    private final BlockCipher engine;
    private boolean forWrapping;
    private final byte[] iv;
    private KeyParameter param;
    private final boolean wrapCipherMode;

    public RFC3394WrapEngine(BlockCipher blockCipher) {
        this(blockCipher, false);
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.param = (KeyParameter) cipherParameters;
            System.arraycopy(DEFAULT_IV, 0, this.iv, 0, 8);
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
            this.param = (KeyParameter) parametersWithIV.getParameters();
            System.arraycopy(iv, 0, this.iv, 0, 8);
        }
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        }
        if (i9 < 16) {
            throw new InvalidCipherTextException("unwrap data too short");
        }
        int i10 = i9 / 8;
        if (i10 * 8 != i9) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        int i11 = 1;
        this.engine.init(!this.wrapCipherMode, this.param);
        byte[] bArr2 = this.iv;
        byte[] bArr3 = new byte[i9 - bArr2.length];
        byte[] bArr4 = new byte[bArr2.length];
        byte[] bArr5 = new byte[bArr2.length + 8];
        int i12 = i10 - 1;
        if (i12 == 1) {
            this.engine.processBlock(bArr, i8, bArr5, 0);
            System.arraycopy(bArr5, 0, bArr4, 0, this.iv.length);
            System.arraycopy(bArr5, this.iv.length, bArr3, 0, 8);
        } else {
            System.arraycopy(bArr, i8, bArr4, 0, bArr2.length);
            byte[] bArr6 = this.iv;
            System.arraycopy(bArr, bArr6.length + i8, bArr3, 0, i9 - bArr6.length);
            for (int i13 = 5; i13 >= 0; i13--) {
                int i14 = i12;
                while (i14 >= i11) {
                    System.arraycopy(bArr4, 0, bArr5, 0, this.iv.length);
                    int i15 = (i14 - 1) * 8;
                    System.arraycopy(bArr3, i15, bArr5, this.iv.length, 8);
                    int i16 = (i12 * i13) + i14;
                    int i17 = i11;
                    while (i16 != 0) {
                        int i18 = i11;
                        int length = this.iv.length - i17;
                        bArr5[length] = (byte) (bArr5[length] ^ ((byte) i16));
                        i16 >>>= 8;
                        i17++;
                        i11 = i18;
                    }
                    this.engine.processBlock(bArr5, 0, bArr5, 0);
                    System.arraycopy(bArr5, 0, bArr4, 0, 8);
                    System.arraycopy(bArr5, 8, bArr3, i15, 8);
                    i14--;
                    i11 = i11;
                }
            }
        }
        if (i12 != i11) {
            if (!Arrays.constantTimeAreEqual(bArr4, this.iv)) {
                throw new InvalidCipherTextException("checksum failed");
            }
        } else if (!Arrays.constantTimeAreEqual(bArr4, this.iv)) {
            System.arraycopy(bArr, i8, bArr4, 0, this.iv.length);
            byte[] bArr7 = this.iv;
            System.arraycopy(bArr, i8 + bArr7.length, bArr3, 0, i9 - bArr7.length);
            for (int i19 = 5; i19 >= 0; i19--) {
                System.arraycopy(bArr4, 0, bArr5, 0, this.iv.length);
                System.arraycopy(bArr3, 0, bArr5, this.iv.length, 8);
                int i20 = (i12 * i19) + 1;
                int i21 = 1;
                while (i20 != 0) {
                    int length2 = this.iv.length - i21;
                    bArr5[length2] = (byte) (((byte) i20) ^ bArr5[length2]);
                    i20 >>>= 8;
                    i21++;
                }
                this.engine.processBlock(bArr5, 0, bArr5, 0);
                System.arraycopy(bArr5, 0, bArr4, 0, 8);
                System.arraycopy(bArr5, 8, bArr3, 0, 8);
            }
            if (!Arrays.constantTimeAreEqual(bArr4, this.iv)) {
                throw new InvalidCipherTextException("checksum failed");
            }
        }
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i8, int i9) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        }
        if (i9 < 8) {
            throw new DataLengthException("wrap data must be at least 8 bytes");
        }
        int i10 = i9 / 8;
        if (i10 * 8 != i9) {
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        this.engine.init(this.wrapCipherMode, this.param);
        byte[] bArr2 = this.iv;
        byte[] bArr3 = new byte[bArr2.length + i9];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i8, bArr3, this.iv.length, i9);
        if (i10 == 1) {
            this.engine.processBlock(bArr3, 0, bArr3, 0);
            return bArr3;
        }
        byte[] bArr4 = new byte[this.iv.length + 8];
        for (int i11 = 0; i11 != 6; i11++) {
            for (int i12 = 1; i12 <= i10; i12++) {
                System.arraycopy(bArr3, 0, bArr4, 0, this.iv.length);
                int i13 = i12 * 8;
                System.arraycopy(bArr3, i13, bArr4, this.iv.length, 8);
                this.engine.processBlock(bArr4, 0, bArr4, 0);
                int i14 = (i10 * i11) + i12;
                int i15 = 1;
                while (i14 != 0) {
                    int length = this.iv.length - i15;
                    bArr4[length] = (byte) (((byte) i14) ^ bArr4[length]);
                    i14 >>>= 8;
                    i15++;
                }
                System.arraycopy(bArr4, 0, bArr3, 0, 8);
                System.arraycopy(bArr4, 8, bArr3, i13, 8);
            }
        }
        return bArr3;
    }

    public RFC3394WrapEngine(BlockCipher blockCipher, boolean z) {
        this.iv = new byte[8];
        this.param = null;
        this.forWrapping = true;
        this.engine = blockCipher;
        this.wrapCipherMode = !z;
    }
}
