package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Blake2bDigest implements ExtendedDigest {
    private static final int BLOCK_LENGTH_BYTES = 128;
    private byte[] buffer;
    private int bufferPos;
    private long[] chainValue;
    private int depth;
    private int digestLength;

    /* renamed from: f0, reason: collision with root package name */
    private long f4410f0;

    /* renamed from: f1, reason: collision with root package name */
    private long f4411f1;
    private int fanout;
    private int innerHashLength;
    private long[] internalState;
    private boolean isLastNode;
    private byte[] key;
    private int keyLength;
    private int leafLength;
    private int nodeDepth;
    private long nodeOffset;
    private byte[] personalization;
    private final CryptoServicePurpose purpose;
    private byte[] salt;

    /* renamed from: t0, reason: collision with root package name */
    private long f4412t0;

    /* renamed from: t1, reason: collision with root package name */
    private long f4413t1;
    private static final long[] blake2b_IV = {7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};
    private static final byte[][] blake2b_sigma = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13}, new byte[]{2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9}, new byte[]{12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, new byte[]{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}};
    private static int ROUNDS = 12;

    public Blake2bDigest() {
        this(512, CryptoServicePurpose.ANY);
    }

    private void G(long j4, long j8, int i8, int i9, int i10, int i11) {
        long[] jArr = this.internalState;
        long j9 = jArr[i8] + jArr[i9] + j4;
        jArr[i8] = j9;
        jArr[i11] = Longs.rotateRight(jArr[i11] ^ j9, 32);
        long[] jArr2 = this.internalState;
        long j10 = jArr2[i10] + jArr2[i11];
        jArr2[i10] = j10;
        jArr2[i9] = Longs.rotateRight(j10 ^ jArr2[i9], 24);
        long[] jArr3 = this.internalState;
        long j11 = jArr3[i8] + jArr3[i9] + j8;
        jArr3[i8] = j11;
        jArr3[i11] = Longs.rotateRight(jArr3[i11] ^ j11, 16);
        long[] jArr4 = this.internalState;
        long j12 = jArr4[i10] + jArr4[i11];
        jArr4[i10] = j12;
        jArr4[i9] = Longs.rotateRight(j12 ^ jArr4[i9], 63);
    }

    private void compress(byte[] bArr, int i8) {
        initializeInternalState();
        long[] jArr = new long[16];
        Pack.littleEndianToLong(bArr, i8, jArr);
        int i9 = 0;
        for (int i10 = 0; i10 < ROUNDS; i10++) {
            byte[][] bArr2 = blake2b_sigma;
            byte[] bArr3 = bArr2[i10];
            G(jArr[bArr3[0]], jArr[bArr3[1]], 0, 4, 8, 12);
            byte[] bArr4 = bArr2[i10];
            G(jArr[bArr4[2]], jArr[bArr4[3]], 1, 5, 9, 13);
            byte[] bArr5 = bArr2[i10];
            G(jArr[bArr5[4]], jArr[bArr5[5]], 2, 6, 10, 14);
            byte[] bArr6 = bArr2[i10];
            G(jArr[bArr6[6]], jArr[bArr6[7]], 3, 7, 11, 15);
            byte[] bArr7 = bArr2[i10];
            G(jArr[bArr7[8]], jArr[bArr7[9]], 0, 5, 10, 15);
            byte[] bArr8 = bArr2[i10];
            G(jArr[bArr8[10]], jArr[bArr8[11]], 1, 6, 11, 12);
            byte[] bArr9 = bArr2[i10];
            G(jArr[bArr9[12]], jArr[bArr9[13]], 2, 7, 8, 13);
            byte[] bArr10 = bArr2[i10];
            G(jArr[bArr10[14]], jArr[bArr10[15]], 3, 4, 9, 14);
        }
        while (true) {
            long[] jArr2 = this.chainValue;
            if (i9 >= jArr2.length) {
                return;
            }
            long j4 = jArr2[i9];
            long[] jArr3 = this.internalState;
            jArr2[i9] = (j4 ^ jArr3[i9]) ^ jArr3[i9 + 8];
            i9++;
        }
    }

    private void init() {
        if (this.chainValue == null) {
            long[] jArr = {jArr[0] ^ ((this.digestLength | (this.keyLength << 8)) | (((this.fanout << 16) | (this.depth << 24)) | (this.leafLength << 32))), jArr[1] ^ this.nodeOffset, jArr[2] ^ (this.nodeDepth | (this.innerHashLength << 8)), jArr[3], j, jArr[5], 0, 0};
            this.chainValue = jArr;
            long[] jArr2 = blake2b_IV;
            long j4 = jArr2[4];
            byte[] bArr = this.salt;
            if (bArr != null) {
                jArr[4] = j4 ^ Pack.littleEndianToLong(bArr, 0);
                long[] jArr3 = this.chainValue;
                jArr3[5] = jArr3[5] ^ Pack.littleEndianToLong(this.salt, 8);
            }
            long[] jArr4 = this.chainValue;
            long j8 = jArr2[6];
            jArr4[6] = j8;
            jArr4[7] = jArr2[7];
            byte[] bArr2 = this.personalization;
            if (bArr2 != null) {
                jArr4[6] = Pack.littleEndianToLong(bArr2, 0) ^ j8;
                long[] jArr5 = this.chainValue;
                jArr5[7] = jArr5[7] ^ Pack.littleEndianToLong(this.personalization, 8);
            }
        }
    }

    private void initializeInternalState() {
        long[] jArr = this.chainValue;
        System.arraycopy(jArr, 0, this.internalState, 0, jArr.length);
        long[] jArr2 = blake2b_IV;
        System.arraycopy(jArr2, 0, this.internalState, this.chainValue.length, 4);
        long[] jArr3 = this.internalState;
        jArr3[12] = this.f4412t0 ^ jArr2[4];
        jArr3[13] = this.f4413t1 ^ jArr2[5];
        jArr3[14] = this.f4410f0 ^ jArr2[6];
        jArr3[15] = this.f4411f1 ^ jArr2[7];
    }

    public void clearKey() {
        byte[] bArr = this.key;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
            Arrays.fill(this.buffer, (byte) 0);
        }
    }

    public void clearSalt() {
        byte[] bArr = this.salt;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        if (i8 > bArr.length - this.digestLength) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f4410f0 = -1L;
        if (this.isLastNode) {
            this.f4411f1 = -1L;
        }
        long j4 = this.f4412t0;
        int i9 = this.bufferPos;
        long j8 = j4 + i9;
        this.f4412t0 = j8;
        if (i9 > 0 && j8 == 0) {
            this.f4413t1++;
        }
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.internalState, 0L);
        int i10 = this.digestLength;
        int i11 = i10 >>> 3;
        int i12 = i10 & 7;
        Pack.longToLittleEndian(this.chainValue, 0, i11, bArr, i8);
        if (i12 > 0) {
            byte[] bArr2 = new byte[8];
            Pack.longToLittleEndian(this.chainValue[i11], bArr2, 0);
            System.arraycopy(bArr2, 0, bArr, (i8 + this.digestLength) - i12, i12);
        }
        Arrays.fill(this.chainValue, 0L);
        reset();
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "BLAKE2b";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.bufferPos = 0;
        this.f4410f0 = 0L;
        this.f4411f1 = 0L;
        this.f4412t0 = 0L;
        this.f4413t1 = 0L;
        this.isLastNode = false;
        this.chainValue = null;
        Arrays.fill(this.buffer, (byte) 0);
        byte[] bArr = this.key;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
            this.bufferPos = 128;
        }
        init();
    }

    public void setAsLastNode() {
        this.isLastNode = true;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        int i8 = this.bufferPos;
        if (128 - i8 != 0) {
            this.buffer[i8] = b9;
            this.bufferPos = i8 + 1;
            return;
        }
        long j4 = this.f4412t0 + 128;
        this.f4412t0 = j4;
        if (j4 == 0) {
            this.f4413t1++;
        }
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        this.buffer[0] = b9;
        this.bufferPos = 1;
    }

    public Blake2bDigest(int i8) {
        this(i8, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        int i10;
        if (bArr == null || i9 == 0) {
            return;
        }
        int i11 = this.bufferPos;
        if (i11 != 0) {
            i10 = 128 - i11;
            if (i10 >= i9) {
                System.arraycopy(bArr, i8, this.buffer, i11, i9);
                this.bufferPos += i9;
            }
            System.arraycopy(bArr, i8, this.buffer, i11, i10);
            long j4 = this.f4412t0 + 128;
            this.f4412t0 = j4;
            if (j4 == 0) {
                this.f4413t1++;
            }
            compress(this.buffer, 0);
            this.bufferPos = 0;
            Arrays.fill(this.buffer, (byte) 0);
        } else {
            i10 = 0;
        }
        int i12 = i9 + i8;
        int i13 = i12 - 128;
        int i14 = i8 + i10;
        while (i14 < i13) {
            long j8 = this.f4412t0 + 128;
            this.f4412t0 = j8;
            if (j8 == 0) {
                this.f4413t1++;
            }
            compress(bArr, i14);
            i14 += 128;
        }
        i9 = i12 - i14;
        System.arraycopy(bArr, i14, this.buffer, 0, i9);
        this.bufferPos += i9;
    }

    public Blake2bDigest(int i8, CryptoServicePurpose cryptoServicePurpose) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0L;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.isLastNode = false;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f4412t0 = 0L;
        this.f4413t1 = 0L;
        this.f4410f0 = 0L;
        this.f4411f1 = 0L;
        this.purpose = cryptoServicePurpose;
        if (i8 < 8 || i8 > 512 || i8 % 8 != 0) {
            throw new IllegalArgumentException("BLAKE2b digest bit length must be a multiple of 8 and not greater than 512");
        }
        this.buffer = new byte[128];
        this.keyLength = 0;
        this.digestLength = i8 / 8;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, i8, cryptoServicePurpose));
        init();
    }

    public Blake2bDigest(Blake2bDigest blake2bDigest) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0L;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.isLastNode = false;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f4412t0 = 0L;
        this.f4413t1 = 0L;
        this.f4410f0 = 0L;
        this.f4411f1 = 0L;
        this.bufferPos = blake2bDigest.bufferPos;
        this.buffer = Arrays.clone(blake2bDigest.buffer);
        this.keyLength = blake2bDigest.keyLength;
        this.key = Arrays.clone(blake2bDigest.key);
        this.digestLength = blake2bDigest.digestLength;
        this.chainValue = Arrays.clone(blake2bDigest.chainValue);
        this.personalization = Arrays.clone(blake2bDigest.personalization);
        this.salt = Arrays.clone(blake2bDigest.salt);
        this.f4412t0 = blake2bDigest.f4412t0;
        this.f4413t1 = blake2bDigest.f4413t1;
        this.f4410f0 = blake2bDigest.f4410f0;
        this.purpose = blake2bDigest.purpose;
    }

    public Blake2bDigest(byte[] bArr) {
        this(bArr, CryptoServicePurpose.ANY);
    }

    public Blake2bDigest(byte[] bArr, int i8, byte[] bArr2, byte[] bArr3) {
        this(bArr, i8, bArr2, bArr3, CryptoServicePurpose.ANY);
    }

    public Blake2bDigest(byte[] bArr, int i8, byte[] bArr2, byte[] bArr3, CryptoServicePurpose cryptoServicePurpose) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0L;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.isLastNode = false;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f4412t0 = 0L;
        this.f4413t1 = 0L;
        this.f4410f0 = 0L;
        this.f4411f1 = 0L;
        this.purpose = cryptoServicePurpose;
        this.buffer = new byte[128];
        if (i8 < 1 || i8 > 64) {
            throw new IllegalArgumentException("Invalid digest length (required: 1 - 64)");
        }
        this.digestLength = i8;
        if (bArr2 != null) {
            if (bArr2.length != 16) {
                throw new IllegalArgumentException("salt length must be exactly 16 bytes");
            }
            byte[] bArr4 = new byte[16];
            this.salt = bArr4;
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        }
        if (bArr3 != null) {
            if (bArr3.length != 16) {
                throw new IllegalArgumentException("personalization length must be exactly 16 bytes");
            }
            byte[] bArr5 = new byte[16];
            this.personalization = bArr5;
            System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        }
        if (bArr != null) {
            byte[] bArr6 = new byte[bArr.length];
            this.key = bArr6;
            System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
            if (bArr.length > 64) {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
            this.keyLength = bArr.length;
            System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
            this.bufferPos = 128;
        }
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, i8 * 8, cryptoServicePurpose));
        init();
    }

    public Blake2bDigest(byte[] bArr, CryptoServicePurpose cryptoServicePurpose) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0L;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.isLastNode = false;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f4412t0 = 0L;
        this.f4413t1 = 0L;
        this.f4410f0 = 0L;
        this.f4411f1 = 0L;
        this.buffer = new byte[128];
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.key = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (bArr.length > 64) {
                throw new IllegalArgumentException("Keys > 64 are not supported");
            }
            this.keyLength = bArr.length;
            System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
            this.bufferPos = 128;
        }
        this.purpose = cryptoServicePurpose;
        this.digestLength = 64;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, 64 * 8, cryptoServicePurpose));
        init();
    }

    public Blake2bDigest(byte[] bArr, byte[] bArr2) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0L;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.isLastNode = false;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f4412t0 = 0L;
        this.f4413t1 = 0L;
        this.f4410f0 = 0L;
        this.f4411f1 = 0L;
        this.buffer = new byte[128];
        this.purpose = CryptoServicePurpose.ANY;
        this.digestLength = bArr2[0];
        this.keyLength = bArr2[1];
        this.fanout = bArr2[2];
        this.depth = bArr2[3];
        this.leafLength = Pack.littleEndianToInt(bArr2, 4);
        this.nodeOffset |= Pack.littleEndianToInt(bArr2, 8);
        this.nodeDepth = bArr2[16];
        this.innerHashLength = bArr2[17];
        init();
    }
}
