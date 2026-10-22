package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class RFC5649WrapEngine implements Wrapper {
    private static final byte[] DEFAULT_IV = {-90, 89, 89, -90};
    private final BlockCipher engine;
    private final byte[] preIV = new byte[4];
    private KeyParameter param = null;
    private boolean forWrapping = true;

    public RFC5649WrapEngine(BlockCipher blockCipher) {
        this.engine = blockCipher;
    }

    private byte[] padPlaintext(byte[] bArr) {
        int length = bArr.length;
        int i8 = (8 - (length % 8)) % 8;
        byte[] bArr2 = new byte[length + i8];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        if (i8 != 0) {
            System.arraycopy(new byte[i8], 0, bArr2, length, i8);
        }
        return bArr2;
    }

    private byte[] rfc3394UnwrapNoIvCheck(byte[] bArr, int i8, int i9, byte[] bArr2) {
        int i10 = i9 - 8;
        byte[] bArr3 = new byte[i10];
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, i8, bArr4, 0, 8);
        System.arraycopy(bArr, i8 + 8, bArr3, 0, i10);
        this.engine.init(false, this.param);
        int i11 = (i9 / 8) - 1;
        for (int i12 = 5; i12 >= 0; i12--) {
            for (int i13 = i11; i13 >= 1; i13--) {
                int i14 = (i13 - 1) * 8;
                System.arraycopy(bArr3, i14, bArr4, 8, 8);
                int i15 = (i11 * i12) + i13;
                int i16 = 1;
                while (i15 != 0) {
                    int i17 = 8 - i16;
                    bArr4[i17] = (byte) (bArr4[i17] ^ ((byte) i15));
                    i15 >>>= 8;
                    i16++;
                }
                this.engine.processBlock(bArr4, 0, bArr4, 0);
                System.arraycopy(bArr4, 8, bArr3, i14, 8);
            }
        }
        System.arraycopy(bArr4, 0, bArr2, 0, 8);
        return bArr3;
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
            System.arraycopy(DEFAULT_IV, 0, this.preIV, 0, 4);
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length != 4) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
            this.param = (KeyParameter) parametersWithIV.getParameters();
            System.arraycopy(iv, 0, this.preIV, 0, 4);
        }
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i8, int i9) throws InvalidCipherTextException {
        byte[] bArrRfc3394UnwrapNoIvCheck;
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int i10 = i9 / 8;
        if (i10 * 8 != i9) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        if (i10 <= 1) {
            throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
        }
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        byte[] bArr3 = new byte[i9];
        byte[] bArr4 = new byte[8];
        if (i10 == 2) {
            this.engine.init(false, this.param);
            int blockSize = this.engine.getBlockSize();
            for (int i11 = 0; i11 < i9; i11 += blockSize) {
                this.engine.processBlock(bArr2, i11, bArr3, i11);
            }
            System.arraycopy(bArr3, 0, bArr4, 0, 8);
            int i12 = i9 - 8;
            bArrRfc3394UnwrapNoIvCheck = new byte[i12];
            System.arraycopy(bArr3, 8, bArrRfc3394UnwrapNoIvCheck, 0, i12);
        } else {
            bArrRfc3394UnwrapNoIvCheck = rfc3394UnwrapNoIvCheck(bArr, i8, i9, bArr4);
        }
        int i13 = 4;
        byte[] bArr5 = new byte[4];
        System.arraycopy(bArr4, 0, bArr5, 0, 4);
        int iBigEndianToInt = Pack.bigEndianToInt(bArr4, 4);
        boolean zConstantTimeAreEqual = Arrays.constantTimeAreEqual(bArr5, this.preIV);
        int length = bArrRfc3394UnwrapNoIvCheck.length;
        if (iBigEndianToInt <= length - 8) {
            zConstantTimeAreEqual = false;
        }
        if (iBigEndianToInt > length) {
            zConstantTimeAreEqual = false;
        }
        int i14 = length - iBigEndianToInt;
        if (i14 >= 8 || i14 < 0) {
            zConstantTimeAreEqual = false;
        } else {
            i13 = i14;
        }
        byte[] bArr6 = new byte[i13];
        System.arraycopy(bArrRfc3394UnwrapNoIvCheck, bArrRfc3394UnwrapNoIvCheck.length - i13, bArr6, 0, i13);
        if (!Arrays.constantTimeAreEqual(bArr6, new byte[i13])) {
            zConstantTimeAreEqual = false;
        }
        if (!zConstantTimeAreEqual) {
            throw new InvalidCipherTextException("checksum failed");
        }
        byte[] bArr7 = new byte[iBigEndianToInt];
        System.arraycopy(bArrRfc3394UnwrapNoIvCheck, 0, bArr7, 0, iBigEndianToInt);
        return bArr7;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i8, int i9) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        }
        byte[] bArr2 = new byte[8];
        System.arraycopy(this.preIV, 0, bArr2, 0, 4);
        Pack.intToBigEndian(i9, bArr2, 4);
        byte[] bArr3 = new byte[i9];
        System.arraycopy(bArr, i8, bArr3, 0, i9);
        byte[] bArrPadPlaintext = padPlaintext(bArr3);
        if (bArrPadPlaintext.length != 8) {
            RFC3394WrapEngine rFC3394WrapEngine = new RFC3394WrapEngine(this.engine);
            rFC3394WrapEngine.init(true, new ParametersWithIV(this.param, bArr2));
            return rFC3394WrapEngine.wrap(bArrPadPlaintext, 0, bArrPadPlaintext.length);
        }
        int length = bArrPadPlaintext.length + 8;
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr2, 0, bArr4, 0, 8);
        System.arraycopy(bArrPadPlaintext, 0, bArr4, 8, bArrPadPlaintext.length);
        this.engine.init(true, this.param);
        int blockSize = this.engine.getBlockSize();
        for (int i10 = 0; i10 < length; i10 += blockSize) {
            this.engine.processBlock(bArr4, i10, bArr4, i10);
        }
        return bArr4;
    }
}
