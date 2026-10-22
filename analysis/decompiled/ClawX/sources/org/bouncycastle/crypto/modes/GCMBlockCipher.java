package org.bouncycastle.crypto.modes;

import a8.b;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.gcm.BasicGCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.crypto.modes.gcm.Tables4kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class GCMBlockCipher implements GCMModeCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] H;
    private byte[] J0;
    private byte[] S;
    private byte[] S_at;
    private byte[] S_atPre;
    private byte[] atBlock;
    private int atBlockPos;
    private long atLength;
    private long atLengthPre;
    private int blocksRemaining;
    private byte[] bufBlock;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] counter;
    private GCMExponentiator exp;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private boolean initialised;
    private byte[] lastKey;
    private byte[] macBlock;
    private int macSize;
    private GCMMultiplier multiplier;
    private byte[] nonce;
    private long totalLength;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    private void checkStatus() {
        if (this.initialised) {
            return;
        }
        if (!this.forEncryption) {
            throw new IllegalStateException("GCM cipher needs to be initialised");
        }
        throw new IllegalStateException("GCM cipher cannot be reused for encryption");
    }

    private void decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (bArr2.length - i9 < 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.totalLength == 0) {
            initCipher();
        }
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        gHASHBlock(this.S, bArr, i8);
        GCMUtil.xor(bArr3, 0, bArr, i8, bArr2, i9);
        this.totalLength += 16;
    }

    private void encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (bArr2.length - i9 < 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.totalLength == 0) {
            initCipher();
        }
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        GCMUtil.xor(bArr3, bArr, i8);
        gHASHBlock(this.S, bArr3);
        System.arraycopy(bArr3, 0, bArr2, i9, 16);
        this.totalLength += 16;
    }

    private void gHASH(byte[] bArr, byte[] bArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9 += 16) {
            gHASHPartial(bArr, bArr2, i9, Math.min(i8 - i9, 16));
        }
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2) {
        GCMUtil.xor(bArr, bArr2);
        this.multiplier.multiplyH(bArr);
    }

    private void gHASHPartial(byte[] bArr, byte[] bArr2, int i8, int i9) {
        GCMUtil.xor(bArr, bArr2, i8, i9);
        this.multiplier.multiplyH(bArr);
    }

    private void getNextCTRBlock(byte[] bArr) {
        int i8 = this.blocksRemaining;
        if (i8 == 0) {
            throw new IllegalStateException("Attempt to process too many blocks");
        }
        this.blocksRemaining = i8 - 1;
        byte[] bArr2 = this.counter;
        int i9 = (bArr2[15] & 255) + 1;
        bArr2[15] = (byte) i9;
        int i10 = (i9 >>> 8) + (bArr2[14] & 255);
        bArr2[14] = (byte) i10;
        int i11 = (i10 >>> 8) + (bArr2[13] & 255);
        bArr2[13] = (byte) i11;
        bArr2[12] = (byte) ((i11 >>> 8) + (bArr2[12] & 255));
        this.cipher.processBlock(bArr2, 0, bArr, 0);
    }

    private void initCipher() {
        if (this.atLength > 0) {
            System.arraycopy(this.S_at, 0, this.S_atPre, 0, 16);
            this.atLengthPre = this.atLength;
        }
        int i8 = this.atBlockPos;
        if (i8 > 0) {
            gHASHPartial(this.S_atPre, this.atBlock, 0, i8);
            this.atLengthPre += this.atBlockPos;
        }
        if (this.atLengthPre > 0) {
            System.arraycopy(this.S_atPre, 0, this.S, 0, 16);
        }
    }

    public static GCMModeCipher newInstance(BlockCipher blockCipher) {
        return new GCMBlockCipher(blockCipher);
    }

    private void processPartial(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        byte[] bArr3 = new byte[16];
        getNextCTRBlock(bArr3);
        if (this.forEncryption) {
            GCMUtil.xor(bArr, i8, bArr3, 0, i9);
            gHASHPartial(this.S, bArr, i8, i9);
        } else {
            gHASHPartial(this.S, bArr, i8, i9);
            GCMUtil.xor(bArr, i8, bArr3, 0, i9);
        }
        System.arraycopy(bArr, i8, bArr2, i10, i9);
        this.totalLength += i9;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException {
        GCMBlockCipher gCMBlockCipher;
        byte[] bArr2;
        int i9;
        checkStatus();
        if (this.totalLength == 0) {
            initCipher();
        }
        int i10 = this.bufOff;
        if (!this.forEncryption) {
            int i11 = this.macSize;
            if (i10 < i11) {
                throw new InvalidCipherTextException("data too short");
            }
            i10 -= i11;
            if (bArr.length - i8 < i10) {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (bArr.length - i8 < this.macSize + i10) {
            throw new OutputLengthException("Output buffer too short");
        }
        int i12 = i10;
        if (i12 > 0) {
            gCMBlockCipher = this;
            bArr2 = bArr;
            i9 = i8;
            gCMBlockCipher.processPartial(this.bufBlock, 0, i12, bArr2, i9);
        } else {
            gCMBlockCipher = this;
            bArr2 = bArr;
            i9 = i8;
        }
        long j4 = gCMBlockCipher.atLength;
        int i13 = gCMBlockCipher.atBlockPos;
        long j8 = j4 + i13;
        gCMBlockCipher.atLength = j8;
        if (j8 > gCMBlockCipher.atLengthPre) {
            if (i13 > 0) {
                gCMBlockCipher.gHASHPartial(gCMBlockCipher.S_at, gCMBlockCipher.atBlock, 0, i13);
            }
            if (gCMBlockCipher.atLengthPre > 0) {
                GCMUtil.xor(gCMBlockCipher.S_at, gCMBlockCipher.S_atPre);
            }
            long j9 = ((gCMBlockCipher.totalLength * 8) + 127) >>> 7;
            byte[] bArr3 = new byte[16];
            if (gCMBlockCipher.exp == null) {
                BasicGCMExponentiator basicGCMExponentiator = new BasicGCMExponentiator();
                gCMBlockCipher.exp = basicGCMExponentiator;
                basicGCMExponentiator.init(gCMBlockCipher.H);
            }
            gCMBlockCipher.exp.exponentiateX(j9, bArr3);
            GCMUtil.multiply(gCMBlockCipher.S_at, bArr3);
            GCMUtil.xor(gCMBlockCipher.S, gCMBlockCipher.S_at);
        }
        byte[] bArr4 = new byte[16];
        Pack.longToBigEndian(gCMBlockCipher.atLength * 8, bArr4, 0);
        Pack.longToBigEndian(gCMBlockCipher.totalLength * 8, bArr4, 8);
        gCMBlockCipher.gHASHBlock(gCMBlockCipher.S, bArr4);
        byte[] bArr5 = new byte[16];
        gCMBlockCipher.cipher.processBlock(gCMBlockCipher.J0, 0, bArr5, 0);
        GCMUtil.xor(bArr5, gCMBlockCipher.S);
        int i14 = gCMBlockCipher.macSize;
        byte[] bArr6 = new byte[i14];
        gCMBlockCipher.macBlock = bArr6;
        System.arraycopy(bArr5, 0, bArr6, 0, i14);
        if (gCMBlockCipher.forEncryption) {
            System.arraycopy(gCMBlockCipher.macBlock, 0, bArr2, i9 + gCMBlockCipher.bufOff, gCMBlockCipher.macSize);
            i12 += gCMBlockCipher.macSize;
        } else {
            int i15 = gCMBlockCipher.macSize;
            byte[] bArr7 = new byte[i15];
            System.arraycopy(gCMBlockCipher.bufBlock, i12, bArr7, 0, i15);
            if (!Arrays.constantTimeAreEqual(gCMBlockCipher.macBlock, bArr7)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        gCMBlockCipher.reset(false);
        return i12;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        byte[] bArr = this.macBlock;
        return bArr == null ? new byte[this.macSize] : Arrays.clone(bArr);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i8) {
        int i9 = i8 + this.bufOff;
        boolean z = this.forEncryption;
        int i10 = this.macSize;
        if (z) {
            return i9 + i10;
        }
        if (i9 < i10) {
            return 0;
        }
        return i9 - i10;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        int i9 = i8 + this.bufOff;
        if (!this.forEncryption) {
            int i10 = this.macSize;
            if (i9 < i10) {
                return 0;
            }
            i9 -= i10;
        }
        return i9 - (i9 % 16);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] iv;
        KeyParameter key;
        byte[] bArr;
        this.forEncryption = z;
        this.macBlock = null;
        this.initialised = true;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            iv = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 32 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException(b.j(macSize, "Invalid value for MAC size: "));
            }
            this.macSize = macSize / 8;
            key = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = 16;
            key = (KeyParameter) parametersWithIV.getParameters();
        }
        this.bufBlock = new byte[z ? 16 : this.macSize + 16];
        if (iv == null || iv.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z && (bArr = this.nonce) != null && Arrays.areEqual(bArr, iv)) {
            if (key == null) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
            byte[] bArr2 = this.lastKey;
            if (bArr2 != null && Arrays.areEqual(bArr2, key.getKey())) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.nonce = iv;
        if (key != null) {
            this.lastKey = key.getKey();
        }
        if (key != null) {
            this.cipher.init(true, key);
            byte[] bArr3 = new byte[16];
            this.H = bArr3;
            this.cipher.processBlock(bArr3, 0, bArr3, 0);
            this.multiplier.init(this.H);
            this.exp = null;
        } else if (this.H == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr4 = new byte[16];
        this.J0 = bArr4;
        byte[] bArr5 = this.nonce;
        if (bArr5.length == 12) {
            System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
            this.J0[15] = 1;
        } else {
            gHASH(bArr4, bArr5, bArr5.length);
            byte[] bArr6 = new byte[16];
            Pack.longToBigEndian(this.nonce.length * 8, bArr6, 8);
            gHASHBlock(this.J0, bArr6);
        }
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0L;
        this.atLengthPre = 0L;
        this.counter = Arrays.clone(this.J0);
        this.blocksRemaining = -2;
        this.bufOff = 0;
        this.totalLength = 0L;
        byte[] bArr7 = this.initialAssociatedText;
        if (bArr7 != null) {
            processAADBytes(bArr7, 0, bArr7.length);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b9) {
        checkStatus();
        byte[] bArr = this.atBlock;
        int i8 = this.atBlockPos;
        bArr[i8] = b9;
        int i9 = i8 + 1;
        this.atBlockPos = i9;
        if (i9 == 16) {
            gHASHBlock(this.S_at, bArr);
            this.atBlockPos = 0;
            this.atLength += 16;
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i8, int i9) {
        checkStatus();
        int i10 = this.atBlockPos;
        if (i10 > 0) {
            int i11 = 16 - i10;
            if (i9 < i11) {
                System.arraycopy(bArr, i8, this.atBlock, i10, i9);
                this.atBlockPos += i9;
                return;
            } else {
                System.arraycopy(bArr, i8, this.atBlock, i10, i11);
                gHASHBlock(this.S_at, this.atBlock);
                this.atLength += 16;
                i8 += i11;
                i9 -= i11;
            }
        }
        int i12 = i9 + i8;
        int i13 = i12 - 16;
        while (i8 <= i13) {
            gHASHBlock(this.S_at, bArr, i8);
            this.atLength += 16;
            i8 += 16;
        }
        int i14 = i12 - i8;
        this.atBlockPos = i14;
        System.arraycopy(bArr, i8, this.atBlock, 0, i14);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b9, byte[] bArr, int i8) {
        checkStatus();
        byte[] bArr2 = this.bufBlock;
        int i9 = this.bufOff;
        bArr2[i9] = b9;
        int i10 = i9 + 1;
        this.bufOff = i10;
        if (i10 != bArr2.length) {
            return 0;
        }
        if (this.forEncryption) {
            encryptBlock(bArr2, 0, bArr, i8);
            this.bufOff = 0;
        } else {
            decryptBlock(bArr2, 0, bArr, i8);
            byte[] bArr3 = this.bufBlock;
            System.arraycopy(bArr3, 16, bArr3, 0, this.macSize);
            this.bufOff = this.macSize;
        }
        return 16;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11;
        checkStatus();
        if (bArr.length - i8 < i9) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i9, i10, getUpdateOutputSize(i9))) {
            bArr = new byte[i9];
            System.arraycopy(bArr2, i8, bArr, 0, i9);
            i8 = 0;
        }
        int i12 = 16;
        if (this.forEncryption) {
            int i13 = this.bufOff;
            if (i13 > 0) {
                int i14 = 16 - i13;
                if (i9 < i14) {
                    System.arraycopy(bArr, i8, this.bufBlock, i13, i9);
                } else {
                    System.arraycopy(bArr, i8, this.bufBlock, i13, i14);
                    encryptBlock(this.bufBlock, 0, bArr2, i10);
                    i8 += i14;
                    i9 -= i14;
                }
            } else {
                i12 = 0;
            }
            int i15 = i9 + i8;
            int i16 = i15 - 16;
            while (i8 <= i16) {
                encryptBlock(bArr, i8, bArr2, i10 + i12);
                i8 += 16;
                i12 += 16;
            }
            int i17 = i15 - i8;
            this.bufOff = i17;
            System.arraycopy(bArr, i8, this.bufBlock, 0, i17);
            return i12;
        }
        byte[] bArr3 = this.bufBlock;
        int length = bArr3.length;
        int i18 = this.bufOff;
        int i19 = length - i18;
        if (i9 >= i19) {
            if (i18 >= 16) {
                decryptBlock(bArr3, 0, bArr2, i10);
                byte[] bArr4 = this.bufBlock;
                int i20 = this.bufOff - 16;
                this.bufOff = i20;
                System.arraycopy(bArr4, 16, bArr4, 0, i20);
                if (i9 < i19 + 16) {
                    System.arraycopy(bArr, i8, this.bufBlock, this.bufOff, i9);
                    this.bufOff += i9;
                    return 16;
                }
                i11 = 16;
            } else {
                i11 = 0;
            }
            byte[] bArr5 = this.bufBlock;
            int length2 = (i9 + i8) - bArr5.length;
            int i21 = this.bufOff;
            int i22 = 16 - i21;
            System.arraycopy(bArr, i8, bArr5, i21, i22);
            decryptBlock(this.bufBlock, 0, bArr2, i10 + i11);
            int i23 = i8 + i22;
            int i24 = i11 + 16;
            while (i23 <= length2) {
                decryptBlock(bArr, i23, bArr2, i10 + i24);
                i23 += 16;
                i24 += 16;
            }
            byte[] bArr6 = this.bufBlock;
            int length3 = (bArr6.length + length2) - i23;
            this.bufOff = length3;
            System.arraycopy(bArr, i23, bArr6, 0, length3);
            return i24;
        }
        System.arraycopy(bArr, i8, bArr3, i18, i9);
        this.bufOff += i9;
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
        gCMMultiplier = gCMMultiplier == null ? new Tables4kGCMMultiplier() : gCMMultiplier;
        this.cipher = blockCipher;
        this.multiplier = gCMMultiplier;
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2, int i8) {
        GCMUtil.xor(bArr, bArr2, i8);
        this.multiplier.multiplyH(bArr);
    }

    public static GCMModeCipher newInstance(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        return new GCMBlockCipher(blockCipher, gCMMultiplier);
    }

    private void reset(boolean z) {
        this.cipher.reset();
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0L;
        this.atLengthPre = 0L;
        this.counter = Arrays.clone(this.J0);
        this.blocksRemaining = -2;
        this.bufOff = 0;
        this.totalLength = 0L;
        byte[] bArr = this.bufBlock;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        if (z) {
            this.macBlock = null;
        }
        if (this.forEncryption) {
            this.initialised = false;
            return;
        }
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }
}
