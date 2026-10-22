package org.bouncycastle.crypto.digests;

import java.util.Iterator;
import java.util.Stack;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.params.Blake3Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Blake3Digest implements ExtendedDigest, Memoable, Xof {
    private static final int BLOCKLEN = 64;
    private static final int CHAINING0 = 0;
    private static final int CHAINING1 = 1;
    private static final int CHAINING2 = 2;
    private static final int CHAINING3 = 3;
    private static final int CHAINING4 = 4;
    private static final int CHAINING5 = 5;
    private static final int CHAINING6 = 6;
    private static final int CHAINING7 = 7;
    private static final int CHUNKEND = 2;
    private static final int CHUNKLEN = 1024;
    private static final int CHUNKSTART = 1;
    private static final int COUNT0 = 12;
    private static final int COUNT1 = 13;
    private static final int DATALEN = 14;
    private static final int DERIVECONTEXT = 32;
    private static final int DERIVEKEY = 64;
    private static final String ERR_OUTPUTTING = "Already outputting";
    private static final int FLAGS = 15;
    private static final int IV0 = 8;
    private static final int IV1 = 9;
    private static final int IV2 = 10;
    private static final int IV3 = 11;
    private static final int KEYEDHASH = 16;
    private static final int NUMWORDS = 8;
    private static final int PARENT = 4;
    private static final int ROOT = 8;
    private static final int ROUNDS = 7;
    private long outputAvailable;
    private boolean outputting;
    private final CryptoServicePurpose purpose;
    private final byte[] theBuffer;
    private final int[] theChaining;
    private long theCounter;
    private int theCurrBytes;
    private final int theDigestLen;
    private final byte[] theIndices;
    private final int[] theK;
    private final int[] theM;
    private int theMode;
    private int theOutputDataLen;
    private int theOutputMode;
    private int thePos;
    private final Stack theStack;
    private final int[] theV;
    private static final byte[] SIGMA = {2, 6, 3, 10, 7, 0, 4, 13, 1, 11, 12, 5, 9, 14, 15, 8};
    private static final int[] IV = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};

    public Blake3Digest() {
        this(256);
    }

    private void adjustChaining() {
        if (!this.outputting) {
            for (int i8 = 0; i8 < 8; i8++) {
                int[] iArr = this.theChaining;
                int[] iArr2 = this.theV;
                iArr[i8] = iArr2[i8 + 8] ^ iArr2[i8];
            }
            return;
        }
        for (int i9 = 0; i9 < 8; i9++) {
            int[] iArr3 = this.theV;
            int i10 = i9 + 8;
            iArr3[i9] = iArr3[i9] ^ iArr3[i10];
            iArr3[i10] = iArr3[i10] ^ this.theChaining[i9];
        }
        Pack.intToLittleEndian(this.theV, this.theBuffer, 0);
        this.thePos = 0;
    }

    private void adjustStack() {
        for (long j4 = this.theCounter; j4 > 0 && (j4 & 1) != 1; j4 >>= 1) {
            System.arraycopy((int[]) this.theStack.pop(), 0, this.theM, 0, 8);
            System.arraycopy(this.theChaining, 0, this.theM, 8, 8);
            initParentBlock();
            compress();
        }
        this.theStack.push(Arrays.copyOf(this.theChaining, 8));
    }

    private void compress() {
        initIndices();
        int i8 = 0;
        while (true) {
            performRound();
            if (i8 >= 6) {
                adjustChaining();
                return;
            } else {
                permuteIndices();
                i8++;
            }
        }
    }

    private void compressBlock(byte[] bArr, int i8) {
        initChunkBlock(64, false);
        initM(bArr, i8);
        compress();
        if (this.theCurrBytes == 0) {
            adjustStack();
        }
    }

    private void compressFinalBlock(int i8) {
        initChunkBlock(i8, true);
        initM(this.theBuffer, 0);
        compress();
        processStack();
    }

    private void incrementBlockCount() {
        this.theCounter++;
        this.theCurrBytes = 0;
    }

    private void initChunkBlock(int i8, boolean z) {
        System.arraycopy(this.theCurrBytes == 0 ? this.theK : this.theChaining, 0, this.theV, 0, 8);
        System.arraycopy(IV, 0, this.theV, 8, 4);
        int[] iArr = this.theV;
        long j4 = this.theCounter;
        iArr[12] = (int) j4;
        iArr[13] = (int) (j4 >> 32);
        iArr[14] = i8;
        int i9 = this.theMode;
        int i10 = this.theCurrBytes;
        iArr[FLAGS] = i9 + (i10 == 0 ? 1 : 0) + (z ? 2 : 0);
        int i11 = i10 + i8;
        this.theCurrBytes = i11;
        if (i11 >= 1024) {
            incrementBlockCount();
            int[] iArr2 = this.theV;
            iArr2[FLAGS] = iArr2[FLAGS] | 2;
        }
        if (z && this.theStack.isEmpty()) {
            setRoot();
        }
    }

    private void initIndices() {
        byte b9 = 0;
        while (true) {
            byte[] bArr = this.theIndices;
            if (b9 >= bArr.length) {
                return;
            }
            bArr[b9] = b9;
            b9 = (byte) (b9 + 1);
        }
    }

    private void initKey(byte[] bArr) {
        Pack.littleEndianToInt(bArr, 0, this.theK);
        this.theMode = 16;
    }

    private void initKeyFromContext() {
        System.arraycopy(this.theV, 0, this.theK, 0, 8);
        this.theMode = 64;
    }

    private void initM(byte[] bArr, int i8) {
        Pack.littleEndianToInt(bArr, i8, this.theM);
    }

    private void initNullKey() {
        System.arraycopy(IV, 0, this.theK, 0, 8);
    }

    private void initParentBlock() {
        System.arraycopy(this.theK, 0, this.theV, 0, 8);
        System.arraycopy(IV, 0, this.theV, 8, 4);
        int[] iArr = this.theV;
        iArr[12] = 0;
        iArr[13] = 0;
        iArr[14] = 64;
        iArr[FLAGS] = this.theMode | 4;
    }

    private void mixG(int i8, int i9, int i10, int i11, int i12) {
        int i13 = i8 << 1;
        int[] iArr = this.theV;
        int i14 = i13 + 1;
        int i15 = iArr[i10] + this.theM[this.theIndices[i13]] + iArr[i9];
        iArr[i9] = i15;
        iArr[i12] = Integers.rotateRight(iArr[i12] ^ i15, 16);
        int[] iArr2 = this.theV;
        int i16 = iArr2[i11] + iArr2[i12];
        iArr2[i11] = i16;
        iArr2[i10] = Integers.rotateRight(i16 ^ iArr2[i10], 12);
        int[] iArr3 = this.theV;
        int i17 = iArr3[i10] + this.theM[this.theIndices[i14]] + iArr3[i9];
        iArr3[i9] = i17;
        iArr3[i12] = Integers.rotateRight(iArr3[i12] ^ i17, 8);
        int[] iArr4 = this.theV;
        int i18 = iArr4[i11] + iArr4[i12];
        iArr4[i11] = i18;
        iArr4[i10] = Integers.rotateRight(i18 ^ iArr4[i10], 7);
    }

    private void nextOutputBlock() {
        this.theCounter++;
        System.arraycopy(this.theChaining, 0, this.theV, 0, 8);
        System.arraycopy(IV, 0, this.theV, 8, 4);
        int[] iArr = this.theV;
        long j4 = this.theCounter;
        iArr[12] = (int) j4;
        iArr[13] = (int) (j4 >> 32);
        iArr[14] = this.theOutputDataLen;
        iArr[FLAGS] = this.theOutputMode;
        compress();
    }

    private void performRound() {
        mixG(0, 0, 4, 8, 12);
        mixG(1, 1, 5, 9, 13);
        mixG(2, 2, 6, 10, 14);
        mixG(3, 3, 7, 11, FLAGS);
        mixG(4, 0, 5, 10, FLAGS);
        mixG(5, 1, 6, 11, 12);
        mixG(6, 2, 7, 8, 13);
        mixG(7, 3, 4, 9, 14);
    }

    private void permuteIndices() {
        byte b9 = 0;
        while (true) {
            byte[] bArr = this.theIndices;
            if (b9 >= bArr.length) {
                return;
            }
            bArr[b9] = SIGMA[bArr[b9]];
            b9 = (byte) (b9 + 1);
        }
    }

    private void processStack() {
        while (!this.theStack.isEmpty()) {
            System.arraycopy((int[]) this.theStack.pop(), 0, this.theM, 0, 8);
            System.arraycopy(this.theChaining, 0, this.theM, 8, 8);
            initParentBlock();
            if (this.theStack.isEmpty()) {
                setRoot();
            }
            compress();
        }
    }

    private void resetBlockCount() {
        this.theCounter = 0L;
        this.theCurrBytes = 0;
    }

    private void setRoot() {
        int[] iArr = this.theV;
        int i8 = iArr[FLAGS] | 8;
        iArr[FLAGS] = i8;
        this.theOutputMode = i8;
        this.theOutputDataLen = iArr[14];
        this.theCounter = 0L;
        this.outputting = true;
        this.outputAvailable = -1L;
        System.arraycopy(iArr, 0, this.theChaining, 0, 8);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new Blake3Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        return doFinal(bArr, i8, getDigestSize());
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doOutput(byte[] bArr, int i8, int i9) {
        int i10;
        if (i8 > bArr.length - i9) {
            throw new OutputLengthException("output buffer too short");
        }
        if (!this.outputting) {
            compressFinalBlock(this.thePos);
        }
        if (i9 >= 0) {
            long j4 = this.outputAvailable;
            if (j4 < 0 || i9 <= j4) {
                int i11 = this.thePos;
                if (i11 < 64) {
                    int iMin = Math.min(i9, 64 - i11);
                    System.arraycopy(this.theBuffer, this.thePos, bArr, i8, iMin);
                    this.thePos += iMin;
                    i8 += iMin;
                    i10 = i9 - iMin;
                } else {
                    i10 = i9;
                }
                while (i10 > 0) {
                    nextOutputBlock();
                    int iMin2 = Math.min(i10, 64);
                    System.arraycopy(this.theBuffer, 0, bArr, i8, iMin2);
                    this.thePos += iMin2;
                    i8 += iMin2;
                    i10 -= iMin2;
                }
                this.outputAvailable -= i9;
                return i9;
            }
        }
        throw new IllegalArgumentException("Insufficient bytes remaining");
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "BLAKE3";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.theDigestLen;
    }

    public void init(Blake3Parameters blake3Parameters) {
        byte[] key = blake3Parameters == null ? null : blake3Parameters.getKey();
        byte[] context = blake3Parameters != null ? blake3Parameters.getContext() : null;
        reset();
        if (key != null) {
            initKey(key);
            Arrays.fill(key, (byte) 0);
            return;
        }
        initNullKey();
        if (context == null) {
            this.theMode = 0;
            return;
        }
        this.theMode = 32;
        update(context, 0, context.length);
        doFinal(this.theBuffer, 0);
        initKeyFromContext();
        reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        resetBlockCount();
        this.thePos = 0;
        this.outputting = false;
        Arrays.fill(this.theBuffer, (byte) 0);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        if (this.outputting) {
            throw new IllegalStateException(ERR_OUTPUTTING);
        }
        byte[] bArr = this.theBuffer;
        if (bArr.length - this.thePos == 0) {
            compressBlock(bArr, 0);
            Arrays.fill(this.theBuffer, (byte) 0);
            this.thePos = 0;
        }
        byte[] bArr2 = this.theBuffer;
        int i8 = this.thePos;
        bArr2[i8] = b9;
        this.thePos = i8 + 1;
    }

    public Blake3Digest(int i8) {
        this(i8 <= 100 ? i8 * 8 : i8, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i8, int i9) {
        int iDoOutput = doOutput(bArr, i8, i9);
        reset();
        return iDoOutput;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        Blake3Digest blake3Digest = (Blake3Digest) memoable;
        this.theCounter = blake3Digest.theCounter;
        this.theCurrBytes = blake3Digest.theCurrBytes;
        this.theMode = blake3Digest.theMode;
        this.outputting = blake3Digest.outputting;
        this.outputAvailable = blake3Digest.outputAvailable;
        this.theOutputMode = blake3Digest.theOutputMode;
        this.theOutputDataLen = blake3Digest.theOutputDataLen;
        int[] iArr = blake3Digest.theChaining;
        int[] iArr2 = this.theChaining;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = blake3Digest.theK;
        int[] iArr4 = this.theK;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        int[] iArr5 = blake3Digest.theM;
        int[] iArr6 = this.theM;
        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
        this.theStack.clear();
        Iterator it = blake3Digest.theStack.iterator();
        while (it.hasNext()) {
            this.theStack.push(Arrays.clone((int[]) it.next()));
        }
        byte[] bArr = blake3Digest.theBuffer;
        byte[] bArr2 = this.theBuffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.thePos = blake3Digest.thePos;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        if (bArr == null || i9 == 0) {
            return;
        }
        if (this.outputting) {
            throw new IllegalStateException(ERR_OUTPUTTING);
        }
        int i12 = this.thePos;
        if (i12 != 0) {
            i10 = 64 - i12;
            if (i10 >= i9) {
                System.arraycopy(bArr, i8, this.theBuffer, i12, i9);
                i11 = this.thePos + i9;
                this.thePos = i11;
            } else {
                System.arraycopy(bArr, i8, this.theBuffer, i12, i10);
                compressBlock(this.theBuffer, 0);
                this.thePos = 0;
                Arrays.fill(this.theBuffer, (byte) 0);
            }
        } else {
            i10 = 0;
        }
        int i13 = (i8 + i9) - 64;
        int i14 = i10 + i8;
        while (i14 < i13) {
            compressBlock(bArr, i14);
            i14 += 64;
        }
        int i15 = i8 + (i9 - i14);
        System.arraycopy(bArr, i14, this.theBuffer, 0, i15);
        i11 = this.thePos + i15;
        this.thePos = i11;
    }

    public Blake3Digest(int i8, CryptoServicePurpose cryptoServicePurpose) {
        this.theBuffer = new byte[64];
        this.theK = new int[8];
        this.theChaining = new int[8];
        this.theV = new int[16];
        this.theM = new int[16];
        this.theIndices = new byte[16];
        this.theStack = new Stack();
        this.purpose = cryptoServicePurpose;
        this.theDigestLen = i8 / 8;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, getDigestSize() * 8, cryptoServicePurpose));
        init(null);
    }

    public Blake3Digest(Blake3Digest blake3Digest) {
        this.theBuffer = new byte[64];
        this.theK = new int[8];
        this.theChaining = new int[8];
        this.theV = new int[16];
        this.theM = new int[16];
        this.theIndices = new byte[16];
        this.theStack = new Stack();
        this.theDigestLen = blake3Digest.theDigestLen;
        this.purpose = blake3Digest.purpose;
        reset(blake3Digest);
    }
}
