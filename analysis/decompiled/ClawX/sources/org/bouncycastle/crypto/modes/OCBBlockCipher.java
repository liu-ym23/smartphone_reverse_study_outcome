package org.bouncycastle.crypto.modes;

import a8.b;
import java.util.Vector;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Longs;

/* loaded from: classes.dex */
public class OCBBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] Checksum;
    private Vector L;
    private byte[] L_Asterisk;
    private byte[] L_Dollar;
    private byte[] OffsetHASH;
    private byte[] Sum;
    private boolean forEncryption;
    private byte[] hashBlock;
    private long hashBlockCount;
    private int hashBlockPos;
    private BlockCipher hashCipher;
    private byte[] initialAssociatedText;
    private byte[] macBlock;
    private int macSize;
    private byte[] mainBlock;
    private long mainBlockCount;
    private int mainBlockPos;
    private BlockCipher mainCipher;
    private byte[] KtopInput = null;
    private byte[] Stretch = new byte[24];
    private byte[] OffsetMAIN_0 = new byte[16];
    private byte[] OffsetMAIN = new byte[16];

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        }
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        }
        if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        }
        if (blockCipher2.getBlockSize() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        if (!blockCipher.getAlgorithmName().equals(blockCipher2.getAlgorithmName())) {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
        this.hashCipher = blockCipher;
        this.mainCipher = blockCipher2;
    }

    public static byte[] OCB_double(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - shiftLeft(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    public static void OCB_extend(byte[] bArr, int i8) {
        bArr[i8] = -128;
        while (true) {
            i8++;
            if (i8 >= 16) {
                return;
            } else {
                bArr[i8] = 0;
            }
        }
    }

    public static int OCB_ntz(long j4) {
        return Longs.numberOfTrailingZeros(j4);
    }

    public static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int i8 = 16;
        int i9 = 0;
        while (true) {
            i8--;
            if (i8 < 0) {
                return i9;
            }
            int i10 = bArr[i8] & 255;
            bArr2[i8] = (byte) (i9 | (i10 << 1));
            i9 = (i10 >>> 7) & 1;
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        Bytes.xorTo(16, bArr2, bArr);
    }

    public void clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.forEncryption) {
            bArr2 = null;
        } else {
            int i9 = this.mainBlockPos;
            int i10 = this.macSize;
            if (i9 < i10) {
                throw new InvalidCipherTextException("data too short");
            }
            int i11 = i9 - i10;
            this.mainBlockPos = i11;
            bArr2 = new byte[i10];
            System.arraycopy(this.mainBlock, i11, bArr2, 0, i10);
        }
        int i12 = this.hashBlockPos;
        if (i12 > 0) {
            OCB_extend(this.hashBlock, i12);
            updateHASH(this.L_Asterisk);
        }
        int i13 = this.mainBlockPos;
        if (i13 > 0) {
            if (this.forEncryption) {
                OCB_extend(this.mainBlock, i13);
                xor(this.Checksum, this.mainBlock);
            }
            xor(this.OffsetMAIN, this.L_Asterisk);
            byte[] bArr3 = new byte[16];
            this.hashCipher.processBlock(this.OffsetMAIN, 0, bArr3, 0);
            xor(this.mainBlock, bArr3);
            int length = bArr.length;
            int i14 = this.mainBlockPos;
            if (length < i8 + i14) {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(this.mainBlock, 0, bArr, i8, i14);
            if (!this.forEncryption) {
                OCB_extend(this.mainBlock, this.mainBlockPos);
                xor(this.Checksum, this.mainBlock);
            }
        }
        xor(this.Checksum, this.OffsetMAIN);
        xor(this.Checksum, this.L_Dollar);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr4 = this.Checksum;
        blockCipher.processBlock(bArr4, 0, bArr4, 0);
        xor(this.Checksum, this.Sum);
        int i15 = this.macSize;
        byte[] bArr5 = new byte[i15];
        this.macBlock = bArr5;
        System.arraycopy(this.Checksum, 0, bArr5, 0, i15);
        int i16 = this.mainBlockPos;
        if (this.forEncryption) {
            int length2 = bArr.length;
            int i17 = i8 + i16;
            int i18 = this.macSize;
            if (length2 < i17 + i18) {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(this.macBlock, 0, bArr, i17, i18);
            i16 += this.macSize;
        } else if (!Arrays.constantTimeAreEqual(this.macBlock, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        reset(false);
        return i16;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public String getAlgorithmName() {
        return this.mainCipher.getAlgorithmName() + "/OCB";
    }

    public byte[] getLSub(int i8) {
        while (i8 >= this.L.size()) {
            Vector vector = this.L;
            vector.addElement(OCB_double((byte[]) vector.lastElement()));
        }
        return (byte[]) this.L.elementAt(i8);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public byte[] getMac() {
        byte[] bArr = this.macBlock;
        return bArr == null ? new byte[this.macSize] : Arrays.clone(bArr);
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getOutputSize(int i8) {
        int i9 = i8 + this.mainBlockPos;
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
        return this.mainCipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        int i9 = i8 + this.mainBlockPos;
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
        boolean z2 = this.forEncryption;
        this.forEncryption = z;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            iv = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 64 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException(b.j(macSize, "Invalid value for MAC size: "));
            }
            this.macSize = macSize / 8;
            key = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to OCB");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = 16;
            key = (KeyParameter) parametersWithIV.getParameters();
        }
        this.hashBlock = new byte[16];
        this.mainBlock = new byte[z ? 16 : this.macSize + 16];
        if (iv == null) {
            iv = new byte[0];
        }
        if (iv.length > 15) {
            throw new IllegalArgumentException("IV must be no more than 15 bytes");
        }
        if (key != null) {
            this.hashCipher.init(true, key);
            this.mainCipher.init(z, key);
            this.KtopInput = null;
        } else if (z2 != z) {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
        byte[] bArr = new byte[16];
        this.L_Asterisk = bArr;
        this.hashCipher.processBlock(bArr, 0, bArr, 0);
        this.L_Dollar = OCB_double(this.L_Asterisk);
        Vector vector = new Vector();
        this.L = vector;
        vector.addElement(OCB_double(this.L_Dollar));
        int iProcessNonce = processNonce(iv);
        int i8 = iProcessNonce % 8;
        int i9 = iProcessNonce / 8;
        if (i8 == 0) {
            System.arraycopy(this.Stretch, i9, this.OffsetMAIN_0, 0, 16);
        } else {
            for (int i10 = 0; i10 < 16; i10++) {
                byte[] bArr2 = this.Stretch;
                int i11 = bArr2[i9] & 255;
                i9++;
                this.OffsetMAIN_0[i10] = (byte) (((bArr2[i9] & 255) >>> (8 - i8)) | (i11 << i8));
            }
        }
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        this.OffsetHASH = new byte[16];
        this.Sum = new byte[16];
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        this.Checksum = new byte[16];
        byte[] bArr3 = this.initialAssociatedText;
        if (bArr3 != null) {
            processAADBytes(bArr3, 0, bArr3.length);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADByte(byte b9) {
        byte[] bArr = this.hashBlock;
        int i8 = this.hashBlockPos;
        bArr[i8] = b9;
        int i9 = i8 + 1;
        this.hashBlockPos = i9;
        if (i9 == bArr.length) {
            processHashBlock();
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            byte[] bArr2 = this.hashBlock;
            int i11 = this.hashBlockPos;
            bArr2[i11] = bArr[i8 + i10];
            int i12 = i11 + 1;
            this.hashBlockPos = i12;
            if (i12 == bArr2.length) {
                processHashBlock();
            }
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processByte(byte b9, byte[] bArr, int i8) {
        byte[] bArr2 = this.mainBlock;
        int i9 = this.mainBlockPos;
        bArr2[i9] = b9;
        int i10 = i9 + 1;
        this.mainBlockPos = i10;
        if (i10 != bArr2.length) {
            return 0;
        }
        processMainBlock(bArr, i8);
        return 16;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (bArr.length < i8 + i9) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i9, i10, getUpdateOutputSize(i9))) {
            bArr = new byte[i9];
            System.arraycopy(bArr2, i8, bArr, 0, i9);
            i8 = 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < i9; i12++) {
            byte[] bArr3 = this.mainBlock;
            int i13 = this.mainBlockPos;
            bArr3[i13] = bArr[i8 + i12];
            int i14 = i13 + 1;
            this.mainBlockPos = i14;
            if (i14 == bArr3.length) {
                processMainBlock(bArr2, i10 + i11);
                i11 += 16;
            }
        }
        return i11;
    }

    public void processHashBlock() {
        long j4 = this.hashBlockCount + 1;
        this.hashBlockCount = j4;
        updateHASH(getLSub(OCB_ntz(j4)));
        this.hashBlockPos = 0;
    }

    public void processMainBlock(byte[] bArr, int i8) {
        if (bArr.length < i8 + 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.forEncryption) {
            xor(this.Checksum, this.mainBlock);
            this.mainBlockPos = 0;
        }
        byte[] bArr2 = this.OffsetMAIN;
        long j4 = this.mainBlockCount + 1;
        this.mainBlockCount = j4;
        xor(bArr2, getLSub(OCB_ntz(j4)));
        xor(this.mainBlock, this.OffsetMAIN);
        BlockCipher blockCipher = this.mainCipher;
        byte[] bArr3 = this.mainBlock;
        blockCipher.processBlock(bArr3, 0, bArr3, 0);
        xor(this.mainBlock, this.OffsetMAIN);
        System.arraycopy(this.mainBlock, 0, bArr, i8, 16);
        if (this.forEncryption) {
            return;
        }
        xor(this.Checksum, this.mainBlock);
        byte[] bArr4 = this.mainBlock;
        System.arraycopy(bArr4, 16, bArr4, 0, this.macSize);
        this.mainBlockPos = this.macSize;
    }

    public int processNonce(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i8 = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.macSize << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        byte b9 = bArr2[15];
        int i9 = b9 & 63;
        bArr2[15] = (byte) (b9 & 192);
        byte[] bArr3 = this.KtopInput;
        if (bArr3 == null || !Arrays.areEqual(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.KtopInput = bArr2;
            this.hashCipher.processBlock(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.Stretch, 0, 16);
            while (i8 < 8) {
                byte[] bArr5 = this.Stretch;
                int i10 = i8 + 16;
                byte b10 = bArr4[i8];
                i8++;
                bArr5[i10] = (byte) (b10 ^ bArr4[i8]);
            }
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.modes.AEADCipher
    public void reset() {
        reset(true);
    }

    public void updateHASH(byte[] bArr) {
        xor(this.OffsetHASH, bArr);
        xor(this.hashBlock, this.OffsetHASH);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr2 = this.hashBlock;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        xor(this.Sum, this.hashBlock);
    }

    public void reset(boolean z) {
        this.hashCipher.reset();
        this.mainCipher.reset();
        clear(this.hashBlock);
        clear(this.mainBlock);
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        clear(this.OffsetHASH);
        clear(this.Sum);
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        clear(this.Checksum);
        if (z) {
            this.macBlock = null;
        }
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
