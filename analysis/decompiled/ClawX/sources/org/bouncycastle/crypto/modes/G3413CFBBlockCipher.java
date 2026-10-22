package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class G3413CFBBlockCipher extends StreamBlockCipher {
    private byte[] R;
    private byte[] R_init;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean forEncryption;
    private byte[] gamma;
    private byte[] inBuf;
    private boolean initialized;

    /* renamed from: m, reason: collision with root package name */
    private int f4525m;

    /* renamed from: s, reason: collision with root package name */
    private final int f4526s;

    public G3413CFBBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    private void initArrays() {
        int i8 = this.f4525m;
        this.R = new byte[i8];
        this.R_init = new byte[i8];
    }

    private void setupDefaultParams() {
        this.f4525m = this.blockSize * 2;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte b9) {
        if (this.byteCount == 0) {
            this.gamma = createGamma();
        }
        byte[] bArr = this.gamma;
        int i8 = this.byteCount;
        byte b10 = (byte) (bArr[i8] ^ b9);
        byte[] bArr2 = this.inBuf;
        int i9 = i8 + 1;
        this.byteCount = i9;
        if (this.forEncryption) {
            b9 = b10;
        }
        bArr2[i8] = b9;
        if (i9 == getBlockSize()) {
            this.byteCount = 0;
            generateR(this.inBuf);
        }
        return b10;
    }

    public byte[] createGamma() {
        byte[] bArrMSB = GOST3413CipherUtil.MSB(this.R, this.blockSize);
        byte[] bArr = new byte[bArrMSB.length];
        this.cipher.processBlock(bArrMSB, 0, bArr, 0);
        return GOST3413CipherUtil.MSB(bArr, this.f4526s);
    }

    public void generateR(byte[] bArr) {
        byte[] bArrLSB = GOST3413CipherUtil.LSB(this.R, this.f4525m - this.f4526s);
        System.arraycopy(bArrLSB, 0, this.R, 0, bArrLSB.length);
        System.arraycopy(bArr, 0, this.R, bArrLSB.length, this.f4525m - bArrLSB.length);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f4526s;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length < this.blockSize) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f4525m = iv.length;
            initArrays();
            byte[] bArrClone = Arrays.clone(iv);
            this.R_init = bArrClone;
            System.arraycopy(bArrClone, 0, this.R, 0, bArrClone.length);
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.cipher;
                cipherParameters = parametersWithIV.getParameters();
                blockCipher.init(true, cipherParameters);
            }
        } else {
            setupDefaultParams();
            initArrays();
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.R, 0, bArr.length);
            if (cipherParameters != null) {
                blockCipher = this.cipher;
                blockCipher.init(true, cipherParameters);
            }
        }
        this.initialized = true;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        processBytes(bArr, i8, getBlockSize(), bArr2, i9);
        return getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.byteCount = 0;
        Arrays.clear(this.inBuf);
        Arrays.clear(this.gamma);
        if (this.initialized) {
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.R, 0, bArr.length);
            this.cipher.reset();
        }
    }

    public G3413CFBBlockCipher(BlockCipher blockCipher, int i8) {
        super(blockCipher);
        this.initialized = false;
        if (i8 < 0 || i8 > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (blockCipher.getBlockSize() * 8));
        }
        this.blockSize = blockCipher.getBlockSize();
        this.cipher = blockCipher;
        this.f4526s = i8 / 8;
        this.inBuf = new byte[getBlockSize()];
    }
}
