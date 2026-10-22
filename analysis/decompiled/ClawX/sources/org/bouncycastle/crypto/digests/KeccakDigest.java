package org.bouncycastle.crypto.digests;

import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class KeccakDigest implements ExtendedDigest {
    private static long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
    protected int bitsInQueue;
    protected byte[] dataQueue;
    protected int fixedOutputLength;
    protected CryptoServicePurpose purpose;
    protected int rate;
    protected boolean squeezing;
    protected long[] state;

    public KeccakDigest() {
        this(288, CryptoServicePurpose.ANY);
    }

    private void KeccakAbsorb(byte[] bArr, int i8) {
        int i9 = this.rate >>> 6;
        for (int i10 = 0; i10 < i9; i10++) {
            long[] jArr = this.state;
            jArr[i10] = jArr[i10] ^ Pack.littleEndianToLong(bArr, i8);
            i8 += 8;
        }
        KeccakPermutation();
    }

    private void KeccakExtract() {
        KeccakPermutation();
        Pack.longToLittleEndian(this.state, 0, this.rate >>> 6, this.dataQueue, 0);
        this.bitsInQueue = this.rate;
    }

    private void KeccakPermutation() {
        long[] jArr = this.state;
        long j4 = jArr[0];
        long j8 = jArr[1];
        char c3 = 2;
        long j9 = jArr[2];
        char c8 = 3;
        long j10 = jArr[3];
        char c9 = 4;
        long j11 = jArr[4];
        long j12 = jArr[5];
        long j13 = jArr[6];
        long j14 = jArr[7];
        long j15 = jArr[8];
        long j16 = jArr[9];
        long j17 = jArr[10];
        long j18 = jArr[11];
        long j19 = jArr[12];
        long j20 = jArr[13];
        long j21 = jArr[14];
        long j22 = jArr[15];
        long j23 = jArr[16];
        long j24 = jArr[17];
        long j25 = jArr[18];
        long j26 = jArr[19];
        long j27 = jArr[20];
        long j28 = jArr[21];
        long j29 = jArr[22];
        long j30 = jArr[23];
        int i8 = 24;
        long j31 = jArr[24];
        int i9 = 0;
        while (i9 < i8) {
            long j32 = (((j4 ^ j12) ^ j17) ^ j22) ^ j27;
            long j33 = (((j8 ^ j13) ^ j18) ^ j23) ^ j28;
            long j34 = (((j9 ^ j14) ^ j19) ^ j24) ^ j29;
            long j35 = (((j10 ^ j15) ^ j20) ^ j25) ^ j30;
            long j36 = (((j11 ^ j16) ^ j21) ^ j26) ^ j31;
            long j37 = ((j33 << 1) | (j33 >>> (-1))) ^ j36;
            long j38 = ((j34 << 1) | (j34 >>> (-1))) ^ j32;
            long j39 = ((j35 << 1) | (j35 >>> (-1))) ^ j33;
            long j40 = ((j36 << 1) | (j36 >>> (-1))) ^ j34;
            long j41 = ((j32 << 1) | (j32 >>> (-1))) ^ j35;
            long j42 = j4 ^ j37;
            long j43 = j12 ^ j37;
            long j44 = j17 ^ j37;
            long j45 = j22 ^ j37;
            long j46 = j27 ^ j37;
            long j47 = j8 ^ j38;
            long j48 = j13 ^ j38;
            long j49 = j18 ^ j38;
            long j50 = j23 ^ j38;
            long j51 = j28 ^ j38;
            long j52 = j9 ^ j39;
            long j53 = j14 ^ j39;
            long j54 = j19 ^ j39;
            long j55 = j24 ^ j39;
            long j56 = j29 ^ j39;
            long j57 = j10 ^ j40;
            long j58 = j15 ^ j40;
            long j59 = j20 ^ j40;
            long j60 = j25 ^ j40;
            long j61 = j30 ^ j40;
            long j62 = j11 ^ j41;
            long j63 = j16 ^ j41;
            long j64 = j21 ^ j41;
            long j65 = j26 ^ j41;
            long j66 = j31 ^ j41;
            long j67 = (j47 << 1) | (j47 >>> 63);
            char c10 = c3;
            long j68 = (j48 << 44) | (j48 >>> 20);
            char c11 = c8;
            long j69 = (j63 << 20) | (j63 >>> 44);
            char c12 = c9;
            long j70 = (j56 << 61) | (j56 >>> c11);
            int i10 = i8;
            long j71 = (j64 << 39) | (j64 >>> 25);
            int i11 = i9;
            long j72 = (j46 << 18) | (j46 >>> 46);
            long[] jArr2 = jArr;
            long j73 = (j52 << 62) | (j52 >>> c10);
            long j74 = (j54 << 43) | (j54 >>> 21);
            long j75 = (j59 << 25) | (j59 >>> 39);
            long j76 = (j65 << 8) | (j65 >>> 56);
            long j77 = (j61 << 56) | (j61 >>> 8);
            long j78 = (j45 << 41) | (j45 >>> 23);
            long j79 = (j62 << 27) | (j62 >>> 37);
            long j80 = (j66 << 14) | (j66 >>> 50);
            long j81 = (j51 << c10) | (j51 >>> 62);
            long j82 = (j58 << 55) | (j58 >>> 9);
            long j83 = (j50 << 45) | (j50 >>> 19);
            long j84 = (j43 << 36) | (j43 >>> 28);
            long j85 = (j57 << 28) | (j57 >>> 36);
            long j86 = (j60 << 21) | (j60 >>> 43);
            long j87 = (j55 << 15) | (j55 >>> 49);
            long j88 = (j49 << 10) | (j49 >>> 54);
            long j89 = (j53 << 6) | (j53 >>> 58);
            long j90 = (j44 << c11) | (j44 >>> 61);
            long j91 = j42 ^ ((~j68) & j74);
            j8 = j68 ^ ((~j74) & j86);
            long j92 = j74 ^ ((~j86) & j80);
            long j93 = ((~j80) & j42) ^ j86;
            long j94 = j80 ^ (j68 & (~j42));
            long j95 = j85 ^ ((~j69) & j90);
            long j96 = ((~j90) & j83) ^ j69;
            long j97 = ((~j83) & j70) ^ j90;
            j15 = j83 ^ ((~j70) & j85);
            long j98 = ((~j85) & j69) ^ j70;
            j17 = j67 ^ ((~j89) & j75);
            long j99 = ((~j75) & j76) ^ j89;
            long j100 = ((~j76) & j72) ^ j75;
            long j101 = j76 ^ ((~j72) & j67);
            long j102 = ((~j67) & j89) ^ j72;
            long j103 = j79 ^ ((~j84) & j88);
            long j104 = ((~j88) & j87) ^ j84;
            long j105 = j88 ^ ((~j87) & j77);
            j25 = j87 ^ ((~j77) & j79);
            long j106 = j77 ^ ((~j79) & j84);
            long j107 = j73 ^ ((~j82) & j71);
            long j108 = j82 ^ ((~j71) & j78);
            long j109 = j71 ^ ((~j78) & j81);
            j30 = j78 ^ ((~j81) & j73);
            long j110 = j81 ^ ((~j73) & j82);
            j4 = j91 ^ KeccakRoundConstants[i11];
            i9 = i11 + 1;
            j13 = j96;
            j19 = j100;
            j21 = j102;
            j20 = j101;
            j14 = j97;
            c9 = c12;
            j10 = j93;
            j27 = j107;
            j26 = j106;
            c8 = c11;
            j23 = j104;
            j18 = j99;
            j28 = j108;
            j29 = j109;
            j16 = j98;
            j24 = j105;
            j22 = j103;
            j11 = j94;
            j12 = j95;
            j9 = j92;
            c3 = c10;
            j31 = j110;
            jArr = jArr2;
            i8 = i10;
        }
        long[] jArr3 = jArr;
        jArr3[0] = j4;
        jArr3[1] = j8;
        jArr3[c3] = j9;
        jArr3[c8] = j10;
        jArr3[c9] = j11;
        jArr3[5] = j12;
        jArr3[6] = j13;
        jArr3[7] = j14;
        jArr3[8] = j15;
        jArr3[9] = j16;
        jArr3[10] = j17;
        jArr3[11] = j18;
        jArr3[12] = j19;
        jArr3[13] = j20;
        jArr3[14] = j21;
        jArr3[15] = j22;
        jArr3[16] = j23;
        jArr3[17] = j24;
        jArr3[18] = j25;
        jArr3[19] = j26;
        jArr3[20] = j27;
        jArr3[21] = j28;
        jArr3[22] = j29;
        jArr3[23] = j30;
        jArr3[i8] = j31;
    }

    private static CryptoServicePurpose getCryptoServicePurpose(byte b9) {
        return CryptoServicePurpose.values()[b9];
    }

    private void init(int i8) {
        if (i8 != 128 && i8 != 224 && i8 != 256 && i8 != 288 && i8 != 384 && i8 != 512) {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
        initSponge(1600 - (i8 << 1));
    }

    private void initSponge(int i8) {
        if (i8 <= 0 || i8 >= 1600 || i8 % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.rate = i8;
        int i9 = 0;
        while (true) {
            long[] jArr = this.state;
            if (i9 >= jArr.length) {
                Arrays.fill(this.dataQueue, (byte) 0);
                this.bitsInQueue = 0;
                this.squeezing = false;
                this.fixedOutputLength = (1600 - i8) / 2;
                return;
            }
            jArr[i9] = 0;
            i9++;
        }
    }

    private void padAndSwitchToSqueezingPhase() {
        byte[] bArr = this.dataQueue;
        int i8 = this.bitsInQueue;
        int i9 = i8 >>> 3;
        bArr[i9] = (byte) (bArr[i9] | ((byte) (1 << (i8 & 7))));
        int i10 = i8 + 1;
        this.bitsInQueue = i10;
        if (i10 == this.rate) {
            KeccakAbsorb(bArr, 0);
        } else {
            int i11 = i10 >>> 6;
            int i12 = i10 & 63;
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                long[] jArr = this.state;
                jArr[i14] = jArr[i14] ^ Pack.littleEndianToLong(this.dataQueue, i13);
                i13 += 8;
            }
            if (i12 > 0) {
                long[] jArr2 = this.state;
                jArr2[i11] = (((1 << i12) - 1) & Pack.littleEndianToLong(this.dataQueue, i13)) ^ jArr2[i11];
            }
        }
        long[] jArr3 = this.state;
        int i15 = (this.rate - 1) >>> 6;
        jArr3[i15] = jArr3[i15] ^ Long.MIN_VALUE;
        this.bitsInQueue = 0;
        this.squeezing = true;
    }

    public void absorb(byte b9) {
        int i8 = this.bitsInQueue;
        if (i8 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.squeezing) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        byte[] bArr = this.dataQueue;
        bArr[i8 >>> 3] = b9;
        int i9 = i8 + 8;
        this.bitsInQueue = i9;
        if (i9 == this.rate) {
            KeccakAbsorb(bArr, 0);
            this.bitsInQueue = 0;
        }
    }

    public void absorbBits(int i8, int i9) {
        if (i9 < 1 || i9 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i10 = this.bitsInQueue;
        if (i10 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.squeezing) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        this.dataQueue[i10 >>> 3] = (byte) (i8 & ((1 << i9) - 1));
        this.bitsInQueue = i10 + i9;
    }

    public void copyIn(KeccakDigest keccakDigest) {
        if (this.purpose != keccakDigest.purpose) {
            throw new IllegalArgumentException("attempt to copy digest of different purpose");
        }
        long[] jArr = keccakDigest.state;
        System.arraycopy(jArr, 0, this.state, 0, jArr.length);
        byte[] bArr = keccakDigest.dataQueue;
        System.arraycopy(bArr, 0, this.dataQueue, 0, bArr.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, getDigestSize() * 8, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        squeeze(bArr, i8, this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Keccak-" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.rate / 8;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    public byte[] getEncodedState(byte[] bArr) {
        bArr[0] = (byte) this.purpose.ordinal();
        int i8 = 1;
        int i9 = 0;
        while (true) {
            long[] jArr = this.state;
            if (i9 == jArr.length) {
                byte[] bArr2 = this.dataQueue;
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                int length = i8 + this.dataQueue.length;
                Pack.intToBigEndian(this.rate, bArr, length);
                Pack.intToBigEndian(this.bitsInQueue, bArr, length + 4);
                Pack.intToBigEndian(this.fixedOutputLength, bArr, length + 8);
                bArr[length + 12] = this.squeezing;
                return bArr;
            }
            Pack.longToBigEndian(jArr[i9], bArr, i8);
            i8 += 8;
            i9++;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        init(this.fixedOutputLength);
    }

    public void squeeze(byte[] bArr, int i8, long j4) {
        if (!this.squeezing) {
            padAndSwitchToSqueezingPhase();
        }
        long j8 = 0;
        if (j4 % 8 != 0) {
            throw new IllegalStateException("outputLength not a multiple of 8");
        }
        while (j8 < j4) {
            if (this.bitsInQueue == 0) {
                KeccakExtract();
            }
            int iMin = (int) Math.min(this.bitsInQueue, j4 - j8);
            System.arraycopy(this.dataQueue, (this.rate - this.bitsInQueue) / 8, bArr, ((int) (j8 / 8)) + i8, iMin / 8);
            this.bitsInQueue -= iMin;
            j8 += iMin;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        absorb(b9);
    }

    public KeccakDigest(int i8) {
        this(i8, CryptoServicePurpose.ANY);
    }

    public void absorb(byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        int i12 = this.bitsInQueue;
        if (i12 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.squeezing) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        int i13 = i12 >>> 3;
        int i14 = this.rate >>> 3;
        int i15 = i14 - i13;
        if (i9 < i15) {
            System.arraycopy(bArr, i8, this.dataQueue, i13, i9);
            i11 = this.bitsInQueue + (i9 << 3);
        } else {
            if (i13 > 0) {
                System.arraycopy(bArr, i8, this.dataQueue, i13, i15);
                KeccakAbsorb(this.dataQueue, 0);
            } else {
                i15 = 0;
            }
            while (true) {
                i10 = i9 - i15;
                if (i10 < i14) {
                    break;
                }
                KeccakAbsorb(bArr, i8 + i15);
                i15 += i14;
            }
            System.arraycopy(bArr, i8 + i15, this.dataQueue, 0, i10);
            i11 = i10 << 3;
        }
        this.bitsInQueue = i11;
    }

    public int doFinal(byte[] bArr, int i8, byte b9, int i9) {
        if (i9 > 0) {
            absorbBits(b9, i9);
        }
        squeeze(bArr, i8, this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        absorb(bArr, i8, i9);
    }

    public KeccakDigest(int i8, CryptoServicePurpose cryptoServicePurpose) {
        this.state = new long[25];
        this.dataQueue = new byte[BERTags.PRIVATE];
        this.purpose = cryptoServicePurpose;
        init(i8);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    public KeccakDigest(CryptoServicePurpose cryptoServicePurpose) {
        this(288, cryptoServicePurpose);
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        long[] jArr = new long[25];
        this.state = jArr;
        this.dataQueue = new byte[BERTags.PRIVATE];
        this.purpose = keccakDigest.purpose;
        long[] jArr2 = keccakDigest.state;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr = keccakDigest.dataQueue;
        System.arraycopy(bArr, 0, this.dataQueue, 0, bArr.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    public KeccakDigest(byte[] bArr) {
        this.state = new long[25];
        this.dataQueue = new byte[BERTags.PRIVATE];
        this.purpose = getCryptoServicePurpose(bArr[0]);
        long[] jArr = this.state;
        Pack.bigEndianToLong(bArr, 1, jArr, 0, jArr.length);
        int length = (this.state.length * 8) + 1;
        byte[] bArr2 = this.dataQueue;
        System.arraycopy(bArr, length, bArr2, 0, bArr2.length);
        int length2 = length + this.dataQueue.length;
        this.rate = Pack.bigEndianToInt(bArr, length2);
        this.bitsInQueue = Pack.bigEndianToInt(bArr, length2 + 4);
        this.fixedOutputLength = Pack.bigEndianToInt(bArr, length2 + 8);
        this.squeezing = bArr[length2 + 12] != 0;
    }

    public KeccakDigest(byte[] bArr, CryptoServicePurpose cryptoServicePurpose) {
        this(bArr);
        if (!this.purpose.equals(cryptoServicePurpose)) {
            throw new IllegalStateException("digest encoded for a different purpose");
        }
    }
}
