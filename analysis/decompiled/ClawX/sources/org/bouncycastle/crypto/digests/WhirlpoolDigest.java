package org.bouncycastle.crypto.digests;

import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.asn1.x509.DisplayText;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT;
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private long[] _K;
    private long[] _L;
    private short[] _bitCount;
    private long[] _block;
    private byte[] _buffer;
    private int _bufferPos;
    private long[] _hash;
    private final long[] _rc;
    private long[] _state;
    private final CryptoServicePurpose purpose;
    private static final int[] SBOX = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, BERTags.FLAGS, 215, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, 228, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, 25, 73, 217, 242, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, BERTags.PRIVATE, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, 197, 37, 89, 132, Ed448PrivateKeyParameters.SIGNATURE_SIZE, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, 235, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, 204, 66, 152, 164, 40, 92, 248, 134};
    private static final long[] C0 = new long[256];
    private static final long[] C1 = new long[256];
    private static final long[] C2 = new long[256];
    private static final long[] C3 = new long[256];
    private static final long[] C4 = new long[256];
    private static final long[] C5 = new long[256];
    private static final long[] C6 = new long[256];
    private static final long[] C7 = new long[256];

    static {
        short[] sArr = new short[32];
        EIGHT = sArr;
        sArr[31] = 8;
        for (int i8 = 0; i8 < 256; i8++) {
            int i9 = SBOX[i8];
            int iMulX = mulX(i9);
            int iMulX2 = mulX(iMulX);
            int i10 = iMulX2 ^ i9;
            int iMulX3 = mulX(iMulX2);
            int i11 = iMulX3 ^ i9;
            C0[i8] = packIntoLong(i9, i9, iMulX2, i9, iMulX3, i10, iMulX, i11);
            C1[i8] = packIntoLong(i11, i9, i9, iMulX2, i9, iMulX3, i10, iMulX);
            C2[i8] = packIntoLong(iMulX, i11, i9, i9, iMulX2, i9, iMulX3, i10);
            C3[i8] = packIntoLong(i10, iMulX, i11, i9, i9, iMulX2, i9, iMulX3);
            C4[i8] = packIntoLong(iMulX3, i10, iMulX, i11, i9, i9, iMulX2, i9);
            C5[i8] = packIntoLong(i9, iMulX3, i10, iMulX, i11, i9, i9, iMulX2);
            C6[i8] = packIntoLong(iMulX2, i9, iMulX3, i10, iMulX, i11, i9, i9);
            C7[i8] = packIntoLong(i9, iMulX2, i9, iMulX3, i10, iMulX, i11, i9);
        }
    }

    public WhirlpoolDigest() {
        this(CryptoServicePurpose.ANY);
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i8 = 0; i8 < 32; i8++) {
            bArr[i8] = (byte) (this._bitCount[i8] & 255);
        }
        return bArr;
    }

    private void finish() {
        byte[] bArrCopyBitLength = copyBitLength();
        byte[] bArr = this._buffer;
        int i8 = this._bufferPos;
        bArr[i8] = (byte) (bArr[i8] | 128);
        int i9 = i8 + 1;
        this._bufferPos = i9;
        if (i9 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            update((byte) 0);
        }
        System.arraycopy(bArrCopyBitLength, 0, this._buffer, 32, bArrCopyBitLength.length);
        processFilledBuffer(this._buffer, 0);
    }

    private void increment() {
        int i8 = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i9 = (sArr[length] & 255) + EIGHT[length] + i8;
            i8 = i9 >>> 8;
            sArr[length] = (short) (i9 & 255);
        }
    }

    private static int mulX(int i8) {
        return ((-(i8 >>> 7)) & REDUCTION_POLYNOMIAL) ^ (i8 << 1);
    }

    private static long packIntoLong(int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        return (((((((i9 << 48) ^ (i8 << 56)) ^ (i10 << 40)) ^ (i11 << 32)) ^ (i12 << 24)) ^ (i13 << 16)) ^ (i14 << 8)) ^ i15;
    }

    private void processFilledBuffer(byte[] bArr, int i8) {
        Pack.bigEndianToLong(this._buffer, 0, this._block);
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new WhirlpoolDigest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        finish();
        Pack.longToBigEndian(this._hash, bArr, i8);
        reset();
        return getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Whirlpool";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    public void processBlock() {
        char c3;
        char c8;
        for (int i8 = 0; i8 < 8; i8++) {
            long[] jArr = this._state;
            long j4 = this._block[i8];
            long[] jArr2 = this._K;
            long j8 = this._hash[i8];
            jArr2[i8] = j8;
            jArr[i8] = j4 ^ j8;
        }
        for (int i9 = 1; i9 <= 10; i9++) {
            int i10 = 0;
            while (true) {
                c3 = ' ';
                c8 = '(';
                if (i10 >= 8) {
                    break;
                }
                long[] jArr3 = this._L;
                jArr3[i10] = 0;
                long[] jArr4 = C0;
                long[] jArr5 = this._K;
                long j9 = jArr4[((int) (jArr5[i10 & 7] >>> 56)) & 255];
                jArr3[i10] = j9;
                long j10 = C1[((int) (jArr5[(i10 - 1) & 7] >>> 48)) & 255] ^ j9;
                jArr3[i10] = j10;
                long j11 = j10 ^ C2[((int) (jArr5[(i10 - 2) & 7] >>> 40)) & 255];
                jArr3[i10] = j11;
                long j12 = j11 ^ C3[((int) (jArr5[(i10 - 3) & 7] >>> 32)) & 255];
                jArr3[i10] = j12;
                long j13 = j12 ^ C4[((int) (jArr5[(i10 - 4) & 7] >>> 24)) & 255];
                jArr3[i10] = j13;
                long j14 = j13 ^ C5[((int) (jArr5[(i10 - 5) & 7] >>> 16)) & 255];
                jArr3[i10] = j14;
                long j15 = j14 ^ C6[((int) (jArr5[(i10 - 6) & 7] >>> 8)) & 255];
                jArr3[i10] = j15;
                jArr3[i10] = j15 ^ C7[((int) jArr5[(i10 - 7) & 7]) & 255];
                i10++;
            }
            long[] jArr6 = this._L;
            long[] jArr7 = this._K;
            System.arraycopy(jArr6, 0, jArr7, 0, jArr7.length);
            long[] jArr8 = this._K;
            jArr8[0] = jArr8[0] ^ this._rc[i9];
            int i11 = 0;
            while (i11 < 8) {
                long[] jArr9 = this._L;
                long j16 = this._K[i11];
                jArr9[i11] = j16;
                long[] jArr10 = C0;
                long[] jArr11 = this._state;
                char c9 = c3;
                char c10 = c8;
                long j17 = jArr10[((int) (jArr11[i11 & 7] >>> 56)) & 255] ^ j16;
                jArr9[i11] = j17;
                long j18 = j17 ^ C1[((int) (jArr11[(i11 - 1) & 7] >>> 48)) & 255];
                jArr9[i11] = j18;
                long j19 = j18 ^ C2[((int) (jArr11[(i11 - 2) & 7] >>> c10)) & 255];
                jArr9[i11] = j19;
                long j20 = j19 ^ C3[((int) (jArr11[(i11 - 3) & 7] >>> c9)) & 255];
                jArr9[i11] = j20;
                long j21 = j20 ^ C4[((int) (jArr11[(i11 - 4) & 7] >>> 24)) & 255];
                jArr9[i11] = j21;
                long j22 = j21 ^ C5[((int) (jArr11[(i11 - 5) & 7] >>> 16)) & 255];
                jArr9[i11] = j22;
                long j23 = j22 ^ C6[((int) (jArr11[(i11 - 6) & 7] >>> 8)) & 255];
                jArr9[i11] = j23;
                jArr9[i11] = j23 ^ C7[((int) jArr11[(i11 - 7) & 7]) & 255];
                i11++;
                c8 = c10;
                c3 = c9;
            }
            long[] jArr12 = this._L;
            long[] jArr13 = this._state;
            System.arraycopy(jArr12, 0, jArr13, 0, jArr13.length);
        }
        for (int i12 = 0; i12 < 8; i12++) {
            long[] jArr14 = this._hash;
            jArr14[i12] = jArr14[i12] ^ (this._state[i12] ^ this._block[i12]);
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, (short) 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0L);
        Arrays.fill(this._K, 0L);
        Arrays.fill(this._L, 0L);
        Arrays.fill(this._block, 0L);
        Arrays.fill(this._state, 0L);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        byte[] bArr = this._buffer;
        int i8 = this._bufferPos;
        bArr[i8] = b9;
        int i9 = i8 + 1;
        this._bufferPos = i9;
        if (i9 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    public WhirlpoolDigest(CryptoServicePurpose cryptoServicePurpose) {
        long[] jArr = new long[11];
        this._rc = jArr;
        this._buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this._hash = new long[8];
        this._K = new long[8];
        this._L = new long[8];
        this._block = new long[8];
        this._state = new long[8];
        jArr[0] = 0;
        for (int i8 = 1; i8 <= 10; i8++) {
            int i9 = (i8 - 1) * 8;
            this._rc[i8] = (((((((C0[i9] & (-72057594037927936L)) ^ (C1[i9 + 1] & 71776119061217280L)) ^ (C2[i9 + 2] & 280375465082880L)) ^ (C3[i9 + 3] & 1095216660480L)) ^ (C4[i9 + 4] & 4278190080L)) ^ (C5[i9 + 5] & 16711680)) ^ (C6[i9 + 6] & 65280)) ^ (C7[i9 + 7] & 255);
        }
        this.purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, getDigestSize(), cryptoServicePurpose));
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        WhirlpoolDigest whirlpoolDigest = (WhirlpoolDigest) memoable;
        long[] jArr = whirlpoolDigest._rc;
        long[] jArr2 = this._rc;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = whirlpoolDigest._buffer;
        byte[] bArr2 = this._buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = whirlpoolDigest._hash;
        long[] jArr4 = this._hash;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = whirlpoolDigest._K;
        long[] jArr6 = this._K;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = whirlpoolDigest._L;
        long[] jArr8 = this._L;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = whirlpoolDigest._block;
        long[] jArr10 = this._block;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = whirlpoolDigest._state;
        long[] jArr12 = this._state;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        while (i9 > 0) {
            update(bArr[i8]);
            i8++;
            i9--;
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        this._rc = new long[11];
        this._buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this._hash = new long[8];
        this._K = new long[8];
        this._L = new long[8];
        this._block = new long[8];
        this._state = new long[8];
        CryptoServicePurpose cryptoServicePurpose = whirlpoolDigest.purpose;
        this.purpose = cryptoServicePurpose;
        reset(whirlpoolDigest);
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, getDigestSize(), cryptoServicePurpose));
    }
}
