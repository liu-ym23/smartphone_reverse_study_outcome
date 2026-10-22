package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public final class Kangaroo {
    private static final int DIGESTLEN = 32;

    public static abstract class KangarooBase implements ExtendedDigest, Xof {
        private static final int BLKSIZE = 8192;
        private final byte[] singleByte = new byte[1];
        private boolean squeezing;
        private final int theChainLen;
        private int theCurrNode;
        private final KangarooSponge theLeaf;
        private byte[] thePersonal;
        private int theProcessed;
        private final KangarooSponge theTree;
        private static final byte[] SINGLE = {7};
        private static final byte[] INTERMEDIATE = {11};
        private static final byte[] FINAL = {-1, -1, 6};
        private static final byte[] FIRST = {3, 0, 0, 0, 0, 0, 0, 0};

        public KangarooBase(int i8, int i9, int i10, CryptoServicePurpose cryptoServicePurpose) {
            this.theTree = new KangarooSponge(i8, i9);
            this.theLeaf = new KangarooSponge(i8, i9);
            this.theChainLen = i8 >> 2;
            buildPersonal(null);
            CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, i8, cryptoServicePurpose));
        }

        private void buildPersonal(byte[] bArr) {
            int length = bArr == null ? 0 : bArr.length;
            byte[] bArrLengthEncode = lengthEncode(length);
            byte[] bArrCopyOf = bArr == null ? new byte[bArrLengthEncode.length + length] : Arrays.copyOf(bArr, bArrLengthEncode.length + length);
            this.thePersonal = bArrCopyOf;
            System.arraycopy(bArrLengthEncode, 0, bArrCopyOf, length, bArrLengthEncode.length);
        }

        private static byte[] lengthEncode(long j4) {
            byte b9;
            if (j4 != 0) {
                long j8 = j4;
                b9 = 1;
                while (true) {
                    j8 >>= 8;
                    if (j8 == 0) {
                        break;
                    }
                    b9 = (byte) (b9 + 1);
                }
            } else {
                b9 = 0;
            }
            byte[] bArr = new byte[b9 + 1];
            bArr[b9] = b9;
            for (int i8 = 0; i8 < b9; i8++) {
                bArr[i8] = (byte) (j4 >> (((b9 - i8) - 1) * 8));
            }
            return bArr;
        }

        private void processData(byte[] bArr, int i8, int i9) {
            if (this.squeezing) {
                throw new IllegalStateException("attempt to absorb while squeezing");
            }
            KangarooSponge kangarooSponge = this.theCurrNode == 0 ? this.theTree : this.theLeaf;
            int i10 = 8192 - this.theProcessed;
            if (i10 >= i9) {
                kangarooSponge.absorb(bArr, i8, i9);
                this.theProcessed += i9;
                return;
            }
            if (i10 > 0) {
                kangarooSponge.absorb(bArr, i8, i10);
                this.theProcessed += i10;
            }
            while (i10 < i9) {
                if (this.theProcessed == BLKSIZE) {
                    switchLeaf(true);
                }
                int iMin = Math.min(i9 - i10, BLKSIZE);
                this.theLeaf.absorb(bArr, i8 + i10, iMin);
                this.theProcessed += iMin;
                i10 += iMin;
            }
        }

        private void switchFinal() {
            switchLeaf(false);
            byte[] bArrLengthEncode = lengthEncode(this.theCurrNode);
            this.theTree.absorb(bArrLengthEncode, 0, bArrLengthEncode.length);
            KangarooSponge kangarooSponge = this.theTree;
            byte[] bArr = FINAL;
            kangarooSponge.absorb(bArr, 0, bArr.length);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchLeaf(boolean z) {
            if (this.theCurrNode == 0) {
                KangarooSponge kangarooSponge = this.theTree;
                byte[] bArr = FIRST;
                kangarooSponge.absorb(bArr, 0, bArr.length);
            } else {
                KangarooSponge kangarooSponge2 = this.theLeaf;
                byte[] bArr2 = INTERMEDIATE;
                kangarooSponge2.absorb(bArr2, 0, bArr2.length);
                int i8 = this.theChainLen;
                byte[] bArr3 = new byte[i8];
                this.theLeaf.squeeze(bArr3, 0, i8);
                this.theTree.absorb(bArr3, 0, this.theChainLen);
                this.theLeaf.initSponge();
            }
            if (z) {
                this.theCurrNode++;
            }
            this.theProcessed = 0;
        }

        private void switchSingle() {
            this.theTree.absorb(SINGLE, 0, 1);
            this.theTree.padAndSwitchToSqueezingPhase();
        }

        private void switchToSqueezing() {
            byte[] bArr = this.thePersonal;
            processData(bArr, 0, bArr.length);
            if (this.theCurrNode == 0) {
                switchSingle();
            } else {
                switchFinal();
            }
        }

        @Override // org.bouncycastle.crypto.Digest
        public int doFinal(byte[] bArr, int i8) {
            return doFinal(bArr, i8, getDigestSize());
        }

        @Override // org.bouncycastle.crypto.Xof
        public int doOutput(byte[] bArr, int i8, int i9) {
            if (!this.squeezing) {
                switchToSqueezing();
            }
            if (i9 < 0) {
                throw new IllegalArgumentException("Invalid output length");
            }
            this.theTree.squeeze(bArr, i8, i9);
            return i9;
        }

        @Override // org.bouncycastle.crypto.ExtendedDigest
        public int getByteLength() {
            return this.theTree.theRateBytes;
        }

        @Override // org.bouncycastle.crypto.Digest
        public int getDigestSize() {
            return this.theChainLen >> 1;
        }

        public void init(KangarooParameters kangarooParameters) {
            buildPersonal(kangarooParameters.getPersonalisation());
            reset();
        }

        @Override // org.bouncycastle.crypto.Digest
        public void reset() {
            this.theTree.initSponge();
            this.theLeaf.initSponge();
            this.theCurrNode = 0;
            this.theProcessed = 0;
            this.squeezing = false;
        }

        @Override // org.bouncycastle.crypto.Digest
        public void update(byte b9) {
            byte[] bArr = this.singleByte;
            bArr[0] = b9;
            update(bArr, 0, 1);
        }

        @Override // org.bouncycastle.crypto.Xof
        public int doFinal(byte[] bArr, int i8, int i9) {
            if (this.squeezing) {
                throw new IllegalStateException("Already outputting");
            }
            int iDoOutput = doOutput(bArr, i8, i9);
            reset();
            return iDoOutput;
        }

        @Override // org.bouncycastle.crypto.Digest
        public void update(byte[] bArr, int i8, int i9) {
            processData(bArr, i8, i9);
        }
    }

    public static class KangarooParameters implements CipherParameters {
        private byte[] thePersonal;

        public static class Builder {
            private byte[] thePersonal;

            public KangarooParameters build() {
                KangarooParameters kangarooParameters = new KangarooParameters();
                byte[] bArr = this.thePersonal;
                if (bArr != null) {
                    kangarooParameters.thePersonal = bArr;
                }
                return kangarooParameters;
            }

            public Builder setPersonalisation(byte[] bArr) {
                this.thePersonal = Arrays.clone(bArr);
                return this;
            }
        }

        public byte[] getPersonalisation() {
            return Arrays.clone(this.thePersonal);
        }
    }

    public static class KangarooSponge {
        private static final long[] KeccakRoundConstants = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};
        private int bytesInQueue;
        private boolean squeezing;
        private final byte[] theQueue;
        private final int theRateBytes;
        private final int theRounds;
        private final long[] theState = new long[25];

        public KangarooSponge(int i8, int i9) {
            int i10 = (1600 - (i8 << 1)) >> 3;
            this.theRateBytes = i10;
            this.theRounds = i9;
            this.theQueue = new byte[i10];
            initSponge();
        }

        private void KangarooAbsorb(byte[] bArr, int i8) {
            int i9 = this.theRateBytes >> 3;
            for (int i10 = 0; i10 < i9; i10++) {
                long[] jArr = this.theState;
                jArr[i10] = jArr[i10] ^ Pack.littleEndianToLong(bArr, i8);
                i8 += 8;
            }
            KangarooPermutation();
        }

        private void KangarooExtract() {
            Pack.longToLittleEndian(this.theState, 0, this.theRateBytes >> 3, this.theQueue, 0);
        }

        private void KangarooPermutation() {
            KangarooSponge kangarooSponge = this;
            long[] jArr = kangarooSponge.theState;
            long j4 = jArr[0];
            long j8 = jArr[1];
            long j9 = jArr[2];
            char c3 = 3;
            long j10 = jArr[3];
            char c8 = 4;
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
            long j31 = jArr[24];
            int length = KeccakRoundConstants.length - kangarooSponge.theRounds;
            int i8 = 0;
            while (i8 < kangarooSponge.theRounds) {
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
                char c9 = c3;
                long j68 = (j48 << 44) | (j48 >>> 20);
                char c10 = c8;
                long j69 = (j63 << 20) | (j63 >>> 44);
                long j70 = (j56 << 61) | (j56 >>> c9);
                long j71 = (j64 << 39) | (j64 >>> 25);
                long j72 = (j46 << 18) | (j46 >>> 46);
                int i9 = i8;
                long j73 = (j52 << 62) | (j52 >>> 2);
                long j74 = (j54 << 43) | (j54 >>> 21);
                long j75 = (j59 << 25) | (j59 >>> 39);
                long j76 = (j65 << 8) | (j65 >>> 56);
                long j77 = (j61 << 56) | (j61 >>> 8);
                long j78 = (j45 << 41) | (j45 >>> 23);
                long j79 = (j62 << 27) | (j62 >>> 37);
                long j80 = (j66 << 14) | (j66 >>> 50);
                long j81 = (j51 << 2) | (j51 >>> 62);
                long j82 = (j58 << 55) | (j58 >>> 9);
                long j83 = (j50 << 45) | (j50 >>> 19);
                long j84 = (j43 << 36) | (j43 >>> 28);
                long j85 = (j57 << 28) | (j57 >>> 36);
                long j86 = (j60 << 21) | (j60 >>> 43);
                long j87 = (j55 << 15) | (j55 >>> 49);
                long j88 = (j49 << 10) | (j49 >>> 54);
                long j89 = (j53 << 6) | (j53 >>> 58);
                long j90 = (j44 << c9) | (j44 >>> 61);
                long j91 = ((~j68) & j74) ^ j42;
                long j92 = ((~j74) & j86) ^ j68;
                long j93 = j74 ^ ((~j86) & j80);
                long j94 = j86 ^ ((~j80) & j42);
                long j95 = ((~j42) & j68) ^ j80;
                long j96 = j85 ^ ((~j69) & j90);
                long j97 = ((~j90) & j83) ^ j69;
                int i10 = length;
                long j98 = ((~j83) & j70) ^ j90;
                j15 = j83 ^ ((~j70) & j85);
                long j99 = ((~j85) & j69) ^ j70;
                j17 = j67 ^ ((~j89) & j75);
                long j100 = ((~j75) & j76) ^ j89;
                long j101 = ((~j76) & j72) ^ j75;
                j20 = j76 ^ ((~j72) & j67);
                long j102 = ((~j67) & j89) ^ j72;
                long j103 = j79 ^ ((~j84) & j88);
                long j104 = ((~j88) & j87) ^ j84;
                long j105 = j88 ^ ((~j87) & j77);
                long j106 = j87 ^ ((~j77) & j79);
                long j107 = j77 ^ ((~j79) & j84);
                long j108 = j73 ^ ((~j82) & j71);
                long j109 = ((~j71) & j78) ^ j82;
                long j110 = j71 ^ ((~j78) & j81);
                j30 = j78 ^ ((~j81) & j73);
                j31 = j81 ^ ((~j73) & j82);
                j4 = j91 ^ KeccakRoundConstants[i10 + i9];
                j19 = j101;
                j14 = j98;
                jArr = jArr;
                c3 = c9;
                j13 = j97;
                length = i10;
                j26 = j107;
                j23 = j104;
                j18 = j100;
                j25 = j106;
                j21 = j102;
                j27 = j108;
                j28 = j109;
                j29 = j110;
                j16 = j99;
                j11 = j95;
                j24 = j105;
                j22 = j103;
                j10 = j94;
                c8 = c10;
                j12 = j96;
                j9 = j93;
                j8 = j92;
                i8 = i9 + 1;
                kangarooSponge = this;
            }
            long[] jArr2 = jArr;
            jArr2[0] = j4;
            jArr2[1] = j8;
            jArr2[2] = j9;
            jArr2[c3] = j10;
            jArr2[c8] = j11;
            jArr2[5] = j12;
            jArr2[6] = j13;
            jArr2[7] = j14;
            jArr2[8] = j15;
            jArr2[9] = j16;
            jArr2[10] = j17;
            jArr2[11] = j18;
            jArr2[12] = j19;
            jArr2[13] = j20;
            jArr2[14] = j21;
            jArr2[15] = j22;
            jArr2[16] = j23;
            jArr2[17] = j24;
            jArr2[18] = j25;
            jArr2[19] = j26;
            jArr2[20] = j27;
            jArr2[21] = j28;
            jArr2[22] = j29;
            jArr2[23] = j30;
            jArr2[24] = j31;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void absorb(byte[] bArr, int i8, int i9) {
            int i10;
            if (this.squeezing) {
                throw new IllegalStateException("attempt to absorb while squeezing");
            }
            int i11 = 0;
            while (i11 < i9) {
                if (this.bytesInQueue == this.theRateBytes) {
                    KangarooAbsorb(this.theQueue, 0);
                    this.bytesInQueue = 0;
                }
                int i12 = this.bytesInQueue;
                if (i12 != 0 || i11 > i9 - this.theRateBytes) {
                    int iMin = Math.min(this.theRateBytes - i12, i9 - i11);
                    System.arraycopy(bArr, i8 + i11, this.theQueue, this.bytesInQueue, iMin);
                    this.bytesInQueue += iMin;
                    i11 += iMin;
                } else {
                    do {
                        KangarooAbsorb(bArr, i8 + i11);
                        i10 = this.theRateBytes;
                        i11 += i10;
                    } while (i11 <= i9 - i10);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initSponge() {
            Arrays.fill(this.theState, 0L);
            Arrays.fill(this.theQueue, (byte) 0);
            this.bytesInQueue = 0;
            this.squeezing = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void padAndSwitchToSqueezingPhase() {
            int i8 = this.bytesInQueue;
            while (true) {
                int i9 = this.theRateBytes;
                if (i8 >= i9) {
                    byte[] bArr = this.theQueue;
                    int i10 = i9 - 1;
                    bArr[i10] = (byte) (bArr[i10] ^ 128);
                    KangarooAbsorb(bArr, 0);
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                    this.squeezing = true;
                    return;
                }
                this.theQueue[i8] = 0;
                i8++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void squeeze(byte[] bArr, int i8, int i9) {
            if (!this.squeezing) {
                padAndSwitchToSqueezingPhase();
            }
            int i10 = 0;
            while (i10 < i9) {
                if (this.bytesInQueue == 0) {
                    KangarooPermutation();
                    KangarooExtract();
                    this.bytesInQueue = this.theRateBytes;
                }
                int iMin = Math.min(this.bytesInQueue, i9 - i10);
                System.arraycopy(this.theQueue, this.theRateBytes - this.bytesInQueue, bArr, i8 + i10, iMin);
                this.bytesInQueue -= iMin;
                i10 += iMin;
            }
        }
    }

    public static class KangarooTwelve extends KangarooBase {
        public KangarooTwelve() {
            this(32, CryptoServicePurpose.ANY);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
            return super.doFinal(bArr, i8);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Xof
        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i8, int i9) {
            return super.doOutput(bArr, i8, i9);
        }

        @Override // org.bouncycastle.crypto.Digest
        public String getAlgorithmName() {
            return "KangarooTwelve";
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.ExtendedDigest
        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase
        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ void update(byte b9) {
            super.update(b9);
        }

        public KangarooTwelve(int i8, CryptoServicePurpose cryptoServicePurpose) {
            super(128, 12, i8, cryptoServicePurpose);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Xof
        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8, int i9) {
            return super.doFinal(bArr, i8, i9);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i8, int i9) {
            super.update(bArr, i8, i9);
        }

        public KangarooTwelve(CryptoServicePurpose cryptoServicePurpose) {
            this(32, cryptoServicePurpose);
        }
    }

    public static class MarsupilamiFourteen extends KangarooBase {
        public MarsupilamiFourteen() {
            this(32, CryptoServicePurpose.ANY);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
            return super.doFinal(bArr, i8);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Xof
        public /* bridge */ /* synthetic */ int doOutput(byte[] bArr, int i8, int i9) {
            return super.doOutput(bArr, i8, i9);
        }

        @Override // org.bouncycastle.crypto.Digest
        public String getAlgorithmName() {
            return "MarsupilamiFourteen";
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.ExtendedDigest
        public /* bridge */ /* synthetic */ int getByteLength() {
            return super.getByteLength();
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ int getDigestSize() {
            return super.getDigestSize();
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase
        public /* bridge */ /* synthetic */ void init(KangarooParameters kangarooParameters) {
            super.init(kangarooParameters);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ void update(byte b9) {
            super.update(b9);
        }

        public MarsupilamiFourteen(int i8, CryptoServicePurpose cryptoServicePurpose) {
            super(256, 14, i8, cryptoServicePurpose);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Xof
        public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8, int i9) {
            return super.doFinal(bArr, i8, i9);
        }

        @Override // org.bouncycastle.crypto.digests.Kangaroo.KangarooBase, org.bouncycastle.crypto.Digest
        public /* bridge */ /* synthetic */ void update(byte[] bArr, int i8, int i9) {
            super.update(bArr, i8, i9);
        }

        public MarsupilamiFourteen(CryptoServicePurpose cryptoServicePurpose) {
            this(32, cryptoServicePurpose);
        }
    }
}
