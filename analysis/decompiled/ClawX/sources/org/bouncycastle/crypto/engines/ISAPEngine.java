package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ISAPEngine extends AEADBaseEngine {
    private static final int ISAP_STATE_SZ = 40;
    private final ISAP_AEAD ISAPAEAD;
    private int ISAP_rH;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f4465k;
    private byte[] npub;

    public abstract class ISAPAEAD_A implements ISAP_AEAD {
        protected long ISAP_IV1_64;
        protected long ISAP_IV2_64;
        protected long ISAP_IV3_64;
        protected long[] k64;
        AsconPermutationFriend.AsconPermutation mac;
        protected long[] npub64;

        /* renamed from: p, reason: collision with root package name */
        AsconPermutationFriend.AsconPermutation f4466p;

        public ISAPAEAD_A() {
            ISAPEngine.this.ISAP_rH = 64;
            ISAPEngine.this.BlockSize = (ISAPEngine.this.ISAP_rH + 7) >> 3;
            this.f4466p = new AsconPermutationFriend.AsconPermutation();
            this.mac = new AsconPermutationFriend.AsconPermutation();
        }

        private int getLongSize(int i8) {
            return (i8 + 7) >>> 3;
        }

        private void isap_rk(AsconPermutationFriend.AsconPermutation asconPermutation, long j4, byte[] bArr, int i8) {
            long[] jArr = this.k64;
            asconPermutation.set(jArr[0], jArr[1], j4, 0L, 0L);
            asconPermutation.p(12);
            for (int i9 = 0; i9 < (i8 << 3) - 1; i9++) {
                asconPermutation.f4448x0 ^= ((((bArr[i9 >>> 3] >>> (7 - (i9 & 7))) & 1) << 7) & 255) << 56;
                PX2(asconPermutation);
            }
            asconPermutation.f4448x0 ^= (bArr[i8 - 1] & 1) << 63;
            asconPermutation.p(12);
        }

        public abstract void PX1(AsconPermutationFriend.AsconPermutation asconPermutation);

        public abstract void PX2(AsconPermutationFriend.AsconPermutation asconPermutation);

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbFinalAADBlock() {
            int i8 = 0;
            while (true) {
                int i9 = ISAPEngine.this.m_aadPos;
                if (i8 >= i9) {
                    AsconPermutationFriend.AsconPermutation asconPermutation = this.mac;
                    asconPermutation.f4448x0 = (128 << ((7 - i9) << 3)) ^ asconPermutation.f4448x0;
                    asconPermutation.p(12);
                    this.mac.f4452x4 ^= 1;
                    return;
                }
                this.mac.f4448x0 ^= (r1.m_aad[i8] & 255) << ((7 - i8) << 3);
                i8++;
            }
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbMacBlock(byte[] bArr, int i8) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.mac;
            asconPermutation.f4448x0 = Pack.bigEndianToLong(bArr, i8) ^ asconPermutation.f4448x0;
            this.mac.p(12);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void init() {
            this.npub64 = new long[getLongSize(ISAPEngine.this.npub.length)];
            this.k64 = new long[getLongSize(ISAPEngine.this.f4465k.length)];
            Pack.bigEndianToLong(ISAPEngine.this.npub, 0, this.npub64);
            Pack.bigEndianToLong(ISAPEngine.this.f4465k, 0, this.k64);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
            Pack.longToBigEndian(Pack.bigEndianToLong(bArr, i8) ^ this.f4466p.f4448x0, bArr2, i9);
            PX1(this.f4466p);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncFinalBlock(byte[] bArr, int i8) {
            byte[] bArrLongToLittleEndian = Pack.longToLittleEndian(this.f4466p.f4448x0);
            ISAPEngine iSAPEngine = ISAPEngine.this;
            int i9 = iSAPEngine.m_bufPos;
            Bytes.xor(i9, bArrLongToLittleEndian, iSAPEngine.BlockSize - i9, iSAPEngine.m_buf, 0, bArr, i8);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processMACFinal(byte[] bArr, int i8, int i9, byte[] bArr2) {
            int i10 = i8;
            int i11 = 0;
            while (i11 < i9) {
                this.mac.f4448x0 ^= (bArr[i10] & 255) << ((7 - i11) << 3);
                i11++;
                i10++;
            }
            AsconPermutationFriend.AsconPermutation asconPermutation = this.mac;
            asconPermutation.f4448x0 ^= 128 << ((7 - i9) << 3);
            asconPermutation.p(12);
            Pack.longToBigEndian(this.mac.f4448x0, bArr2, 0);
            Pack.longToBigEndian(this.mac.f4449x1, bArr2, 8);
            AsconPermutationFriend.AsconPermutation asconPermutation2 = this.mac;
            long j4 = asconPermutation2.f4450x2;
            long j8 = asconPermutation2.f4451x3;
            long j9 = asconPermutation2.f4452x4;
            isap_rk(asconPermutation2, this.ISAP_IV2_64, bArr2, ISAPEngine.this.KEY_SIZE);
            AsconPermutationFriend.AsconPermutation asconPermutation3 = this.mac;
            asconPermutation3.f4450x2 = j4;
            asconPermutation3.f4451x3 = j8;
            asconPermutation3.f4452x4 = j9;
            asconPermutation3.p(12);
            Pack.longToBigEndian(this.mac.f4448x0, bArr2, 0);
            Pack.longToBigEndian(this.mac.f4449x1, bArr2, 8);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void reset() {
            isap_rk(this.f4466p, this.ISAP_IV3_64, ISAPEngine.this.npub, ISAPEngine.this.IV_SIZE);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4466p;
            long[] jArr = this.npub64;
            asconPermutation.f4451x3 = jArr[0];
            asconPermutation.f4452x4 = jArr[1];
            PX1(asconPermutation);
            AsconPermutationFriend.AsconPermutation asconPermutation2 = this.mac;
            long[] jArr2 = this.npub64;
            asconPermutation2.set(jArr2[0], jArr2[1], this.ISAP_IV1_64, 0L, 0L);
            this.mac.p(12);
        }
    }

    public class ISAPAEAD_A_128 extends ISAPAEAD_A {
        public ISAPAEAD_A_128() {
            super();
            this.ISAP_IV1_64 = 108156764298152972L;
            this.ISAP_IV2_64 = 180214358336080908L;
            this.ISAP_IV3_64 = 252271952374008844L;
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        public void PX1(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.p(12);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        public void PX2(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.p(12);
        }
    }

    public class ISAPAEAD_A_128A extends ISAPAEAD_A {
        public ISAPAEAD_A_128A() {
            super();
            this.ISAP_IV1_64 = 108156764297430540L;
            this.ISAP_IV2_64 = 180214358335358476L;
            this.ISAP_IV3_64 = 252271952373286412L;
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        public void PX1(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.p(6);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        public void PX2(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.round(75L);
        }
    }

    public abstract class ISAPAEAD_K implements ISAP_AEAD {
        protected short[] ISAP_IV1_16;
        protected short[] ISAP_IV2_16;
        protected short[] ISAP_IV3_16;
        protected final int ISAP_STATE_SZ_CRYPTO_NPUBBYTES;
        protected short[] iv16;
        protected short[] k16;
        private final int[] KeccakF400RoundConstants = {1, 32898, 32906, 32768, 32907, 1, 32897, 32777, 138, 136, 32777, 10, 32907, 139, 32905, 32771, 32770, 128, 32778, 10};
        protected short[] SX = new short[25];
        protected short[] macSX = new short[25];
        protected short[] E = new short[25];
        protected short[] C = new short[5];
        protected short[] macE = new short[25];
        protected short[] macC = new short[5];

        public ISAPAEAD_K() {
            this.ISAP_STATE_SZ_CRYPTO_NPUBBYTES = 40 - ISAPEngine.this.IV_SIZE;
            ISAPEngine.this.ISAP_rH = 144;
            ISAPEngine.this.BlockSize = (ISAPEngine.this.ISAP_rH + 7) >> 3;
        }

        private short ROL16(short s8, int i8) {
            int i9 = 65535 & s8;
            return (short) ((i9 >>> (16 - i8)) ^ (i9 << i8));
        }

        private void byteToShortXor(byte[] bArr, int i8, short[] sArr, int i9) {
            for (int i10 = 0; i10 < i9; i10++) {
                sArr[i10] = (short) (sArr[i10] ^ Pack.littleEndianToShort(bArr, (i10 << 1) + i8));
            }
        }

        public abstract void PermuteRoundsBX(short[] sArr, short[] sArr2, short[] sArr3);

        public abstract void PermuteRoundsHX(short[] sArr, short[] sArr2, short[] sArr3);

        public abstract void PermuteRoundsKX(short[] sArr, short[] sArr2, short[] sArr3);

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbFinalAADBlock() {
            int i8 = 0;
            while (true) {
                ISAPEngine iSAPEngine = ISAPEngine.this;
                int i9 = iSAPEngine.m_aadPos;
                if (i8 >= i9) {
                    short[] sArr = this.macSX;
                    int i10 = i9 >> 1;
                    sArr[i10] = (short) ((128 << ((i9 & 1) << 3)) ^ sArr[i10]);
                    PermuteRoundsHX(sArr, this.macE, this.macC);
                    short[] sArr2 = this.macSX;
                    sArr2[24] = (short) (sArr2[24] ^ 256);
                    return;
                }
                short[] sArr3 = this.macSX;
                int i11 = i8 >> 1;
                sArr3[i11] = (short) (((iSAPEngine.m_aad[i8] & 255) << ((i8 & 1) << 3)) ^ sArr3[i11]);
                i8++;
            }
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbMacBlock(byte[] bArr, int i8) {
            byteToShortXor(bArr, i8, this.macSX, ISAPEngine.this.BlockSize >> 1);
            PermuteRoundsHX(this.macSX, this.macE, this.macC);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void init() {
            this.k16 = new short[ISAPEngine.this.f4465k.length >> 1];
            byte[] bArr = ISAPEngine.this.f4465k;
            short[] sArr = this.k16;
            Pack.littleEndianToShort(bArr, 0, sArr, 0, sArr.length);
            this.iv16 = new short[ISAPEngine.this.npub.length >> 1];
            byte[] bArr2 = ISAPEngine.this.npub;
            short[] sArr2 = this.iv16;
            Pack.littleEndianToShort(bArr2, 0, sArr2, 0, sArr2.length);
        }

        public void isap_rk(short[] sArr, byte[] bArr, int i8, short[] sArr2, int i9, short[] sArr3) {
            short[] sArr4 = new short[25];
            short[] sArr5 = new short[25];
            System.arraycopy(this.k16, 0, sArr4, 0, 8);
            System.arraycopy(sArr, 0, sArr4, 8, 4);
            PermuteRoundsKX(sArr4, sArr5, sArr3);
            for (int i10 = 0; i10 < (i8 << 3) - 1; i10++) {
                sArr4[0] = (short) (sArr4[0] ^ (((bArr[i10 >> 3] >>> (7 - (i10 & 7))) & 1) << 7));
                PermuteRoundsBX(sArr4, sArr5, sArr3);
            }
            sArr4[0] = (short) (sArr4[0] ^ ((bArr[i8 - 1] & 1) << 7));
            PermuteRoundsKX(sArr4, sArr5, sArr3);
            System.arraycopy(sArr4, 0, sArr2, 0, i9 == this.ISAP_STATE_SZ_CRYPTO_NPUBBYTES ? 17 : 8);
        }

        public void prepareThetaX(short[] sArr, short[] sArr2) {
            sArr2[0] = (short) ((((sArr[0] ^ sArr[5]) ^ sArr[10]) ^ sArr[15]) ^ sArr[20]);
            sArr2[1] = (short) ((((sArr[1] ^ sArr[6]) ^ sArr[11]) ^ sArr[16]) ^ sArr[21]);
            sArr2[2] = (short) ((((sArr[2] ^ sArr[7]) ^ sArr[12]) ^ sArr[17]) ^ sArr[22]);
            sArr2[3] = (short) ((((sArr[3] ^ sArr[8]) ^ sArr[13]) ^ sArr[18]) ^ sArr[23]);
            sArr2[4] = (short) (sArr[24] ^ (((sArr[4] ^ sArr[9]) ^ sArr[14]) ^ sArr[19]));
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
            int i10 = 0;
            while (i10 < ISAPEngine.this.BlockSize) {
                bArr2[i9] = (byte) (bArr[i8] ^ (this.SX[i10 >> 1] >>> ((i10 & 1) << 3)));
                i10++;
                i9++;
                i8++;
            }
            PermuteRoundsKX(this.SX, this.E, this.C);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncFinalBlock(byte[] bArr, int i8) {
            int i9 = 0;
            while (true) {
                ISAPEngine iSAPEngine = ISAPEngine.this;
                if (i9 >= iSAPEngine.m_bufPos) {
                    return;
                }
                bArr[i8] = (byte) (iSAPEngine.m_buf[i9] ^ (this.SX[i9 >> 1] >>> ((i9 & 1) << 3)));
                i9++;
                i8++;
            }
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processMACFinal(byte[] bArr, int i8, int i9, byte[] bArr2) {
            int i10 = 0;
            while (i10 < i9) {
                short[] sArr = this.macSX;
                int i11 = i10 >> 1;
                sArr[i11] = (short) (((bArr[i8] & 255) << ((i10 & 1) << 3)) ^ sArr[i11]);
                i10++;
                i8++;
            }
            short[] sArr2 = this.macSX;
            int i12 = i9 >> 1;
            sArr2[i12] = (short) ((128 << ((i9 & 1) << 3)) ^ sArr2[i12]);
            PermuteRoundsHX(sArr2, this.macE, this.macC);
            Pack.shortToLittleEndian(this.macSX, 0, 8, bArr2, 0);
            short[] sArr3 = this.ISAP_IV2_16;
            int i13 = ISAPEngine.this.KEY_SIZE;
            isap_rk(sArr3, bArr2, i13, this.macSX, i13, this.macC);
            PermuteRoundsHX(this.macSX, this.macE, this.macC);
            Pack.shortToLittleEndian(this.macSX, 0, 8, bArr2, 0);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void reset() {
            Arrays.fill(this.SX, (short) 0);
            isap_rk(this.ISAP_IV3_16, ISAPEngine.this.npub, ISAPEngine.this.IV_SIZE, this.SX, this.ISAP_STATE_SZ_CRYPTO_NPUBBYTES, this.C);
            System.arraycopy(this.iv16, 0, this.SX, 17, 8);
            PermuteRoundsKX(this.SX, this.E, this.C);
            Arrays.fill(this.macSX, 12, 25, (short) 0);
            System.arraycopy(this.iv16, 0, this.macSX, 0, 8);
            System.arraycopy(this.ISAP_IV1_16, 0, this.macSX, 8, 4);
            PermuteRoundsHX(this.macSX, this.macE, this.macC);
        }

        public void rounds12X(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            rounds_8_18(sArr, sArr2, sArr3);
        }

        public void rounds_12_18(short[] sArr, short[] sArr2, short[] sArr3) {
            thetaRhoPiChiIotaPrepareTheta(12, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(13, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(14, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(15, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(16, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(17, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(18, sArr, sArr2, sArr3);
            thetaRhoPiChiIota(sArr2, sArr, sArr3);
        }

        public void rounds_4_18(short[] sArr, short[] sArr2, short[] sArr3) {
            thetaRhoPiChiIotaPrepareTheta(4, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(5, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(6, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(7, sArr2, sArr, sArr3);
            rounds_8_18(sArr, sArr2, sArr3);
        }

        public void rounds_8_18(short[] sArr, short[] sArr2, short[] sArr3) {
            thetaRhoPiChiIotaPrepareTheta(8, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(9, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(10, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(11, sArr2, sArr, sArr3);
            rounds_12_18(sArr, sArr2, sArr3);
        }

        public void thetaRhoPiChiIota(short[] sArr, short[] sArr2, short[] sArr3) {
            short sROL16 = (short) (sArr3[4] ^ ROL16(sArr3[1], 1));
            short sROL162 = (short) (sArr3[0] ^ ROL16(sArr3[2], 1));
            short sROL163 = (short) (sArr3[1] ^ ROL16(sArr3[3], 1));
            short sROL164 = (short) (sArr3[2] ^ ROL16(sArr3[4], 1));
            short sROL165 = (short) (sArr3[3] ^ ROL16(sArr3[0], 1));
            short s8 = (short) (sArr[0] ^ sROL16);
            sArr[0] = s8;
            short s9 = (short) (sArr[6] ^ sROL162);
            sArr[6] = s9;
            short sROL166 = ROL16(s9, 12);
            short s10 = (short) (sArr[12] ^ sROL163);
            sArr[12] = s10;
            short sROL167 = ROL16(s10, 11);
            short s11 = (short) (sArr[18] ^ sROL164);
            sArr[18] = s11;
            short sROL168 = ROL16(s11, 5);
            short s12 = (short) (sArr[24] ^ sROL165);
            sArr[24] = s12;
            short sROL169 = ROL16(s12, 14);
            sArr2[0] = (short) (this.KeccakF400RoundConstants[19] ^ (((~sROL166) & sROL167) ^ s8));
            sArr2[1] = (short) (((~sROL167) & sROL168) ^ sROL166);
            sArr2[2] = (short) (((~sROL168) & sROL169) ^ sROL167);
            sArr2[3] = (short) (((~sROL169) & s8) ^ sROL168);
            sArr2[4] = (short) (((~s8) & sROL166) ^ sROL169);
            short s13 = (short) (sArr[3] ^ sROL164);
            sArr[3] = s13;
            short sROL1610 = ROL16(s13, 12);
            short s14 = (short) (sArr[9] ^ sROL165);
            sArr[9] = s14;
            short sROL1611 = ROL16(s14, 4);
            short s15 = (short) (sArr[10] ^ sROL16);
            sArr[10] = s15;
            short sROL1612 = ROL16(s15, 3);
            short s16 = (short) (sArr[16] ^ sROL162);
            sArr[16] = s16;
            short sROL1613 = ROL16(s16, 13);
            short s17 = (short) (sArr[22] ^ sROL163);
            sArr[22] = s17;
            short sROL1614 = ROL16(s17, 13);
            sArr2[5] = (short) (((~sROL1611) & sROL1612) ^ sROL1610);
            sArr2[6] = (short) (((~sROL1612) & sROL1613) ^ sROL1611);
            sArr2[7] = (short) (sROL1612 ^ ((~sROL1613) & sROL1614));
            sArr2[8] = (short) (((~sROL1614) & sROL1610) ^ sROL1613);
            sArr2[9] = (short) (((~sROL1610) & sROL1611) ^ sROL1614);
            short s18 = (short) (sArr[1] ^ sROL162);
            sArr[1] = s18;
            short sROL1615 = ROL16(s18, 1);
            short s19 = (short) (sArr[7] ^ sROL163);
            sArr[7] = s19;
            short sROL1616 = ROL16(s19, 6);
            short s20 = (short) (sArr[13] ^ sROL164);
            sArr[13] = s20;
            short sROL1617 = ROL16(s20, 9);
            short s21 = (short) (sArr[19] ^ sROL165);
            sArr[19] = s21;
            short sROL1618 = ROL16(s21, 8);
            short s22 = (short) (sArr[20] ^ sROL16);
            sArr[20] = s22;
            short sROL1619 = ROL16(s22, 2);
            sArr2[10] = (short) (((~sROL1616) & sROL1617) ^ sROL1615);
            sArr2[11] = (short) (((~sROL1617) & sROL1618) ^ sROL1616);
            sArr2[12] = (short) (((~sROL1618) & sROL1619) ^ sROL1617);
            sArr2[13] = (short) (((~sROL1619) & sROL1615) ^ sROL1618);
            sArr2[14] = (short) (((~sROL1615) & sROL1616) ^ sROL1619);
            short s23 = (short) (sArr[4] ^ sROL165);
            sArr[4] = s23;
            short sROL1620 = ROL16(s23, 11);
            short s24 = (short) (sArr[5] ^ sROL16);
            sArr[5] = s24;
            short sROL1621 = ROL16(s24, 4);
            short s25 = (short) (sArr[11] ^ sROL162);
            sArr[11] = s25;
            short sROL1622 = ROL16(s25, 10);
            short s26 = (short) (sArr[17] ^ sROL163);
            sArr[17] = s26;
            short sROL1623 = ROL16(s26, 15);
            short s27 = (short) (sArr[23] ^ sROL164);
            sArr[23] = s27;
            short sROL1624 = ROL16(s27, 8);
            sArr2[15] = (short) (((~sROL1621) & sROL1622) ^ sROL1620);
            sArr2[16] = (short) (((~sROL1622) & sROL1623) ^ sROL1621);
            sArr2[17] = (short) (sROL1622 ^ ((~sROL1623) & sROL1624));
            sArr2[18] = (short) (((~sROL1624) & sROL1620) ^ sROL1623);
            sArr2[19] = (short) ((sROL1621 & (~sROL1620)) ^ sROL1624);
            short s28 = (short) (sArr[2] ^ sROL163);
            sArr[2] = s28;
            short sROL1625 = ROL16(s28, 14);
            short s29 = (short) (sArr[8] ^ sROL164);
            sArr[8] = s29;
            short sROL1626 = ROL16(s29, 7);
            short s30 = (short) (sArr[14] ^ sROL165);
            sArr[14] = s30;
            short sROL1627 = ROL16(s30, 7);
            short s31 = (short) (sROL16 ^ sArr[15]);
            sArr[15] = s31;
            short sROL1628 = ROL16(s31, 9);
            short s32 = (short) (sROL162 ^ sArr[21]);
            sArr[21] = s32;
            short sROL1629 = ROL16(s32, 2);
            sArr2[20] = (short) (((~sROL1626) & sROL1627) ^ sROL1625);
            sArr2[21] = (short) (((~sROL1627) & sROL1628) ^ sROL1626);
            sArr2[22] = (short) (sROL1627 ^ ((~sROL1628) & sROL1629));
            sArr2[23] = (short) (sROL1628 ^ ((~sROL1629) & sROL1625));
            sArr2[24] = (short) (sROL1629 ^ ((~sROL1625) & sROL1626));
        }

        public void thetaRhoPiChiIotaPrepareTheta(int i8, short[] sArr, short[] sArr2, short[] sArr3) {
            short sROL16 = (short) (sArr3[4] ^ ROL16(sArr3[1], 1));
            short sROL162 = (short) (sArr3[0] ^ ROL16(sArr3[2], 1));
            short sROL163 = (short) (sArr3[1] ^ ROL16(sArr3[3], 1));
            short sROL164 = (short) (sArr3[2] ^ ROL16(sArr3[4], 1));
            short sROL165 = (short) (sArr3[3] ^ ROL16(sArr3[0], 1));
            short s8 = (short) (sArr[0] ^ sROL16);
            sArr[0] = s8;
            short s9 = (short) (sArr[6] ^ sROL162);
            sArr[6] = s9;
            short sROL166 = ROL16(s9, 12);
            short s10 = (short) (sArr[12] ^ sROL163);
            sArr[12] = s10;
            short sROL167 = ROL16(s10, 11);
            short s11 = (short) (sArr[18] ^ sROL164);
            sArr[18] = s11;
            short sROL168 = ROL16(s11, 5);
            short s12 = (short) (sArr[24] ^ sROL165);
            sArr[24] = s12;
            short sROL169 = ROL16(s12, 14);
            short s13 = (short) (this.KeccakF400RoundConstants[i8] ^ (((~sROL166) & sROL167) ^ s8));
            sArr2[0] = s13;
            sArr3[0] = s13;
            short s14 = (short) (((~sROL167) & sROL168) ^ sROL166);
            sArr2[1] = s14;
            sArr3[1] = s14;
            short s15 = (short) (((~sROL168) & sROL169) ^ sROL167);
            sArr2[2] = s15;
            sArr3[2] = s15;
            short s16 = (short) (((~sROL169) & s8) ^ sROL168);
            sArr2[3] = s16;
            sArr3[3] = s16;
            short s17 = (short) (((~s8) & sROL166) ^ sROL169);
            sArr2[4] = s17;
            sArr3[4] = s17;
            short s18 = (short) (sArr[3] ^ sROL164);
            sArr[3] = s18;
            short sROL1610 = ROL16(s18, 12);
            short s19 = (short) (sArr[9] ^ sROL165);
            sArr[9] = s19;
            short sROL1611 = ROL16(s19, 4);
            short s20 = (short) (sArr[10] ^ sROL16);
            sArr[10] = s20;
            short sROL1612 = ROL16(s20, 3);
            short s21 = (short) (sArr[16] ^ sROL162);
            sArr[16] = s21;
            short sROL1613 = ROL16(s21, 13);
            short s22 = (short) (sArr[22] ^ sROL163);
            sArr[22] = s22;
            short sROL1614 = ROL16(s22, 13);
            short s23 = (short) (((~sROL1611) & sROL1612) ^ sROL1610);
            sArr2[5] = s23;
            sArr3[0] = (short) (sArr3[0] ^ s23);
            short s24 = (short) (((~sROL1612) & sROL1613) ^ sROL1611);
            sArr2[6] = s24;
            sArr3[1] = (short) (sArr3[1] ^ s24);
            short s25 = (short) (((~sROL1613) & sROL1614) ^ sROL1612);
            sArr2[7] = s25;
            sArr3[2] = (short) (sArr3[2] ^ s25);
            short s26 = (short) (((~sROL1614) & sROL1610) ^ sROL1613);
            sArr2[8] = s26;
            sArr3[3] = (short) (sArr3[3] ^ s26);
            short s27 = (short) (((~sROL1610) & sROL1611) ^ sROL1614);
            sArr2[9] = s27;
            sArr3[4] = (short) (s27 ^ sArr3[4]);
            short s28 = (short) (sArr[1] ^ sROL162);
            sArr[1] = s28;
            short sROL1615 = ROL16(s28, 1);
            short s29 = (short) (sArr[7] ^ sROL163);
            sArr[7] = s29;
            short sROL1616 = ROL16(s29, 6);
            short s30 = (short) (sArr[13] ^ sROL164);
            sArr[13] = s30;
            short sROL1617 = ROL16(s30, 9);
            short s31 = (short) (sArr[19] ^ sROL165);
            sArr[19] = s31;
            short sROL1618 = ROL16(s31, 8);
            short s32 = (short) (sArr[20] ^ sROL16);
            sArr[20] = s32;
            short sROL1619 = ROL16(s32, 2);
            short s33 = (short) (((~sROL1616) & sROL1617) ^ sROL1615);
            sArr2[10] = s33;
            sArr3[0] = (short) (sArr3[0] ^ s33);
            short s34 = (short) (((~sROL1617) & sROL1618) ^ sROL1616);
            sArr2[11] = s34;
            sArr3[1] = (short) (sArr3[1] ^ s34);
            short s35 = (short) (((~sROL1618) & sROL1619) ^ sROL1617);
            sArr2[12] = s35;
            sArr3[2] = (short) (s35 ^ sArr3[2]);
            short s36 = (short) (((~sROL1619) & sROL1615) ^ sROL1618);
            sArr2[13] = s36;
            sArr3[3] = (short) (s36 ^ sArr3[3]);
            short s37 = (short) (((~sROL1615) & sROL1616) ^ sROL1619);
            sArr2[14] = s37;
            sArr3[4] = (short) (s37 ^ sArr3[4]);
            short s38 = (short) (sArr[4] ^ sROL165);
            sArr[4] = s38;
            short sROL1620 = ROL16(s38, 11);
            short s39 = (short) (sArr[5] ^ sROL16);
            sArr[5] = s39;
            short sROL1621 = ROL16(s39, 4);
            short s40 = (short) (sArr[11] ^ sROL162);
            sArr[11] = s40;
            short sROL1622 = ROL16(s40, 10);
            short s41 = (short) (sArr[17] ^ sROL163);
            sArr[17] = s41;
            short sROL1623 = ROL16(s41, 15);
            short s42 = (short) (sArr[23] ^ sROL164);
            sArr[23] = s42;
            short sROL1624 = ROL16(s42, 8);
            short s43 = (short) (((~sROL1621) & sROL1622) ^ sROL1620);
            sArr2[15] = s43;
            sArr3[0] = (short) (sArr3[0] ^ s43);
            short s44 = (short) (((~sROL1622) & sROL1623) ^ sROL1621);
            sArr2[16] = s44;
            sArr3[1] = (short) (sArr3[1] ^ s44);
            short s45 = (short) (sROL1622 ^ ((~sROL1623) & sROL1624));
            sArr2[17] = s45;
            sArr3[2] = (short) (s45 ^ sArr3[2]);
            short s46 = (short) (((~sROL1624) & sROL1620) ^ sROL1623);
            sArr2[18] = s46;
            sArr3[3] = (short) (s46 ^ sArr3[3]);
            short s47 = (short) (((~sROL1620) & sROL1621) ^ sROL1624);
            sArr2[19] = s47;
            sArr3[4] = (short) (s47 ^ sArr3[4]);
            short s48 = (short) (sArr[2] ^ sROL163);
            sArr[2] = s48;
            short sROL1625 = ROL16(s48, 14);
            short s49 = (short) (sArr[8] ^ sROL164);
            sArr[8] = s49;
            short sROL1626 = ROL16(s49, 7);
            short s50 = (short) (sArr[14] ^ sROL165);
            sArr[14] = s50;
            short sROL1627 = ROL16(s50, 7);
            short s51 = (short) (sROL16 ^ sArr[15]);
            sArr[15] = s51;
            short sROL1628 = ROL16(s51, 9);
            short s52 = (short) (sROL162 ^ sArr[21]);
            sArr[21] = s52;
            short sROL1629 = ROL16(s52, 2);
            short s53 = (short) (((~sROL1626) & sROL1627) ^ sROL1625);
            sArr2[20] = s53;
            sArr3[0] = (short) (s53 ^ sArr3[0]);
            short s54 = (short) (((~sROL1627) & sROL1628) ^ sROL1626);
            sArr2[21] = s54;
            sArr3[1] = (short) (s54 ^ sArr3[1]);
            short s55 = (short) (sROL1627 ^ ((~sROL1628) & sROL1629));
            sArr2[22] = s55;
            sArr3[2] = (short) (s55 ^ sArr3[2]);
            short s56 = (short) (sROL1628 ^ ((~sROL1629) & sROL1625));
            sArr2[23] = s56;
            sArr3[3] = (short) (s56 ^ sArr3[3]);
            short s57 = (short) (sROL1629 ^ ((~sROL1625) & sROL1626));
            sArr2[24] = s57;
            sArr3[4] = (short) (s57 ^ sArr3[4]);
        }
    }

    public class ISAPAEAD_K_128 extends ISAPAEAD_K {
        public ISAPAEAD_K_128() {
            super();
            this.ISAP_IV1_16 = new short[]{-32767, 400, 3092, 3084};
            this.ISAP_IV2_16 = new short[]{-32766, 400, 3092, 3084};
            this.ISAP_IV3_16 = new short[]{-32765, 400, 3092, 3084};
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsBX(short[] sArr, short[] sArr2, short[] sArr3) {
            rounds12X(sArr, sArr2, sArr3);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsHX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(0, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(1, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(2, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(3, sArr2, sArr, sArr3);
            rounds_4_18(sArr, sArr2, sArr3);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsKX(short[] sArr, short[] sArr2, short[] sArr3) {
            rounds12X(sArr, sArr2, sArr3);
        }
    }

    public class ISAPAEAD_K_128A extends ISAPAEAD_K {
        public ISAPAEAD_K_128A() {
            super();
            this.ISAP_IV1_16 = new short[]{-32767, 400, 272, 2056};
            this.ISAP_IV2_16 = new short[]{-32766, 400, 272, 2056};
            this.ISAP_IV3_16 = new short[]{-32765, 400, 272, 2056};
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsBX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(19, sArr, sArr2, sArr3);
            System.arraycopy(sArr2, 0, sArr, 0, sArr2.length);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsHX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            rounds_4_18(sArr, sArr2, sArr3);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsKX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            rounds_12_18(sArr, sArr2, sArr3);
        }
    }

    public interface ISAP_AEAD {
        void absorbFinalAADBlock();

        void absorbMacBlock(byte[] bArr, int i8);

        void init();

        void processEncBlock(byte[] bArr, int i8, byte[] bArr2, int i9);

        void processEncFinalBlock(byte[] bArr, int i8);

        void processMACFinal(byte[] bArr, int i8, int i9, byte[] bArr2);

        void reset();
    }

    public enum IsapType {
        ISAP_A_128A,
        ISAP_K_128A,
        ISAP_A_128,
        ISAP_K_128
    }

    public ISAPEngine(IsapType isapType) {
        String str;
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        this.KEY_SIZE = 16;
        int iOrdinal = isapType.ordinal();
        if (iOrdinal == 0) {
            this.ISAPAEAD = new ISAPAEAD_A_128A();
            str = "ISAP-A-128A AEAD";
        } else if (iOrdinal == 1) {
            this.ISAPAEAD = new ISAPAEAD_K_128A();
            str = "ISAP-K-128A AEAD";
        } else if (iOrdinal == 2) {
            this.ISAPAEAD = new ISAPAEAD_A_128();
            str = "ISAP-A-128 AEAD";
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Incorrect ISAP parameter");
            }
            this.ISAPAEAD = new ISAPAEAD_K_128();
            str = "ISAP-K-128 AEAD";
        }
        this.algorithmName = str;
        this.AADBufferSize = this.BlockSize;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Counter);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD3(state, z);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ byte[] getMac() {
        return super.getMac();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i8) {
        return super.getOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i8) {
        return super.getUpdateOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b9) {
        super.processAADByte(b9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i8, int i9) {
        super.processAADBytes(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i8) {
        this.ISAPAEAD.absorbMacBlock(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        this.ISAPAEAD.processEncBlock(bArr, i8, bArr2, i9);
        this.ISAPAEAD.absorbMacBlock(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        this.ISAPAEAD.processEncBlock(bArr, i8, bArr2, i9);
        this.ISAPAEAD.absorbMacBlock(bArr2, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b9, byte[] bArr, int i8) {
        return super.processByte(b9, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        return super.processBytes(bArr, i8, i9, bArr2, i10);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalAAD() {
        this.ISAPAEAD.absorbFinalAADBlock();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        this.ISAPAEAD.processEncFinalBlock(bArr, i8);
        if (this.forEncryption) {
            this.ISAPAEAD.processMACFinal(bArr, i8, this.m_bufPos, this.mac);
        } else {
            this.ISAPAEAD.processMACFinal(this.m_buf, 0, this.m_bufPos, this.mac);
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        this.npub = bArr2;
        this.f4465k = bArr;
        this.ISAPAEAD.init();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        this.ISAPAEAD.reset();
    }
}
