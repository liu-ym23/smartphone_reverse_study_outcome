package org.tukaani.xz.lzma;

import java.io.IOException;
import java.lang.reflect.Array;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.lzma.LZMACoder;
import org.tukaani.xz.rangecoder.RangeEncoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class LZMAEncoder extends LZMACoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ALIGN_PRICE_UPDATE_INTERVAL = 16;
    private static final int DIST_PRICE_UPDATE_INTERVAL = 128;
    private static final int LZMA2_COMPRESSED_LIMIT = 65510;
    private static final int LZMA2_UNCOMPRESSED_LIMIT = 2096879;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    private int alignPriceCount;
    private final int[] alignPrices;
    int back;
    private int distPriceCount;
    private final int[][] distSlotPrices;
    private final int distSlotPricesSize;
    private final int[][] fullDistPrices;
    final LiteralEncoder literalEncoder;
    final LZEncoder lz;
    final LengthEncoder matchLenEncoder;
    final int niceLen;
    private final RangeEncoder rc;
    int readAhead;
    final LengthEncoder repLenEncoder;
    private int uncompressedSize;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public class LiteralEncoder extends LZMACoder.LiteralCoder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final LiteralSubencoder[] subencoders;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        public class LiteralSubencoder extends LZMACoder.LiteralCoder.LiteralSubcoder {
            private LiteralSubencoder() {
                super();
            }

            public void encode() {
                LZMAEncoder lZMAEncoder = LZMAEncoder.this;
                int i8 = 256;
                int i9 = lZMAEncoder.lz.getByte(lZMAEncoder.readAhead) | 256;
                if (LZMAEncoder.this.state.isLiteral()) {
                    do {
                        LZMAEncoder.this.rc.encodeBit(this.probs, i9 >>> 8, (i9 >>> 7) & 1);
                        i9 <<= 1;
                    } while (i9 < 65536);
                } else {
                    LZMAEncoder lZMAEncoder2 = LZMAEncoder.this;
                    int i10 = lZMAEncoder2.lz.getByte(lZMAEncoder2.reps[0] + 1 + lZMAEncoder2.readAhead);
                    do {
                        i10 <<= 1;
                        LZMAEncoder.this.rc.encodeBit(this.probs, (i10 & i8) + i8 + (i9 >>> 8), (i9 >>> 7) & 1);
                        i9 <<= 1;
                        i8 &= ~(i10 ^ i9);
                    } while (i9 < 65536);
                }
                LZMAEncoder.this.state.updateLiteral();
            }

            public int getMatchedPrice(int i8, int i9) {
                int i10 = 256;
                int i11 = i8 | 256;
                int bitPrice = 0;
                do {
                    i9 <<= 1;
                    bitPrice += RangeEncoder.getBitPrice(this.probs[(i9 & i10) + i10 + (i11 >>> 8)], (i11 >>> 7) & 1);
                    i11 <<= 1;
                    i10 &= ~(i9 ^ i11);
                } while (i11 < 65536);
                return bitPrice;
            }

            public int getNormalPrice(int i8) {
                int i9 = i8 | 256;
                int bitPrice = 0;
                do {
                    bitPrice += RangeEncoder.getBitPrice(this.probs[i9 >>> 8], (i9 >>> 7) & 1);
                    i9 <<= 1;
                } while (i9 < 65536);
                return bitPrice;
            }
        }

        public LiteralEncoder(int i8, int i9) {
            super(i8, i9);
            this.subencoders = new LiteralSubencoder[1 << (i8 + i9)];
            int i10 = 0;
            while (true) {
                LiteralSubencoder[] literalSubencoderArr = this.subencoders;
                if (i10 >= literalSubencoderArr.length) {
                    return;
                }
                literalSubencoderArr[i10] = new LiteralSubencoder();
                i10++;
            }
        }

        public void encode() {
            LZMAEncoder lZMAEncoder = LZMAEncoder.this;
            this.subencoders[getSubcoderIndex(lZMAEncoder.lz.getByte(lZMAEncoder.readAhead + 1), LZMAEncoder.this.lz.getPos() - LZMAEncoder.this.readAhead)].encode();
        }

        public void encodeInit() {
            this.subencoders[0].encode();
        }

        public int getPrice(int i8, int i9, int i10, int i11, State state) {
            int bitPrice = RangeEncoder.getBitPrice(LZMAEncoder.this.isMatch[state.get()][LZMAEncoder.this.posMask & i11], 0);
            int subcoderIndex = getSubcoderIndex(i10, i11);
            return bitPrice + (state.isLiteral() ? this.subencoders[subcoderIndex].getNormalPrice(i8) : this.subencoders[subcoderIndex].getMatchedPrice(i8, i9));
        }

        public void reset() {
            int i8 = 0;
            while (true) {
                LiteralSubencoder[] literalSubencoderArr = this.subencoders;
                if (i8 >= literalSubencoderArr.length) {
                    return;
                }
                literalSubencoderArr[i8].reset();
                i8++;
            }
        }
    }

    public LZMAEncoder(RangeEncoder rangeEncoder, LZEncoder lZEncoder, int i8, int i9, int i10, int i11, int i12) {
        super(i10);
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        Class cls = Integer.TYPE;
        this.fullDistPrices = (int[][]) Array.newInstance((Class<?>) cls, 4, 128);
        this.alignPrices = new int[16];
        this.back = 0;
        this.readAhead = -1;
        this.uncompressedSize = 0;
        this.rc = rangeEncoder;
        this.lz = lZEncoder;
        this.niceLen = i12;
        this.literalEncoder = new LiteralEncoder(i8, i9);
        this.matchLenEncoder = new LengthEncoder(i10, i12);
        this.repLenEncoder = new LengthEncoder(i10, i12);
        int distSlot = getDistSlot(i11 - 1) + 1;
        this.distSlotPricesSize = distSlot;
        this.distSlotPrices = (int[][]) Array.newInstance((Class<?>) cls, 4, distSlot);
        reset();
    }

    private boolean encodeInit() {
        if (!this.lz.hasEnoughData(0)) {
            return false;
        }
        skip(1);
        this.rc.encodeBit(this.isMatch[this.state.get()], 0, 0);
        this.literalEncoder.encodeInit();
        this.readAhead--;
        this.uncompressedSize++;
        return true;
    }

    private void encodeMatch(int i8, int i9, int i10) {
        this.state.updateMatch();
        this.matchLenEncoder.encode(i9, i10);
        int distSlot = getDistSlot(i8);
        this.rc.encodeBitTree(this.distSlots[LZMACoder.getDistState(i9)], distSlot);
        if (distSlot >= 4) {
            int i11 = distSlot >>> 1;
            int i12 = i8 - (((distSlot & 1) | 2) << (i11 - 1));
            if (distSlot < 14) {
                this.rc.encodeReverseBitTree(this.distSpecial[distSlot - 4], i12);
            } else {
                this.rc.encodeDirectBits(i12 >>> 4, i11 - 5);
                this.rc.encodeReverseBitTree(this.distAlign, i12 & 15);
                this.alignPriceCount--;
            }
        }
        int[] iArr = this.reps;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = i8;
        this.distPriceCount--;
    }

    private void encodeRepMatch(int i8, int i9, int i10) {
        if (i8 == 0) {
            this.rc.encodeBit(this.isRep0, this.state.get(), 0);
            this.rc.encodeBit(this.isRep0Long[this.state.get()], i10, i9 != 1 ? 1 : 0);
        } else {
            int i11 = this.reps[i8];
            this.rc.encodeBit(this.isRep0, this.state.get(), 1);
            if (i8 == 1) {
                this.rc.encodeBit(this.isRep1, this.state.get(), 0);
            } else {
                this.rc.encodeBit(this.isRep1, this.state.get(), 1);
                this.rc.encodeBit(this.isRep2, this.state.get(), i8 - 2);
                if (i8 == 3) {
                    int[] iArr = this.reps;
                    iArr[3] = iArr[2];
                }
                int[] iArr2 = this.reps;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.reps;
            iArr3[1] = iArr3[0];
            iArr3[0] = i11;
        }
        if (i9 == 1) {
            this.state.updateShortRep();
        } else {
            this.repLenEncoder.encode(i9, i10);
            this.state.updateLongRep();
        }
    }

    private boolean encodeSymbol() {
        if (!this.lz.hasEnoughData(this.readAhead + 1)) {
            return false;
        }
        int nextSymbol = getNextSymbol();
        int pos = (this.lz.getPos() - this.readAhead) & this.posMask;
        if (this.back == -1) {
            this.rc.encodeBit(this.isMatch[this.state.get()], pos, 0);
            this.literalEncoder.encode();
        } else {
            this.rc.encodeBit(this.isMatch[this.state.get()], pos, 1);
            if (this.back < 4) {
                this.rc.encodeBit(this.isRep, this.state.get(), 1);
                encodeRepMatch(this.back, nextSymbol, pos);
            } else {
                this.rc.encodeBit(this.isRep, this.state.get(), 0);
                encodeMatch(this.back - 4, nextSymbol, pos);
            }
        }
        this.readAhead -= nextSymbol;
        this.uncompressedSize += nextSymbol;
        return true;
    }

    public static int getDistSlot(int i8) {
        if (i8 <= 4 && i8 >= 0) {
            return i8;
        }
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i8);
        return ((31 - iNumberOfLeadingZeros) << 1) + ((i8 >>> (30 - iNumberOfLeadingZeros)) & 1);
    }

    public static LZMAEncoder getInstance(RangeEncoder rangeEncoder, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, ArrayCache arrayCache) {
        if (i11 == 1) {
            return new LZMAEncoderFast(rangeEncoder, i8, i9, i10, i12, i13, i14, i15, i16, arrayCache);
        }
        if (i11 == 2) {
            return new LZMAEncoderNormal(rangeEncoder, i8, i9, i10, i12, i13, i14, i15, i16, arrayCache);
        }
        throw new IllegalArgumentException();
    }

    public static int getMemoryUsage(int i8, int i9, int i10, int i11) {
        int memoryUsage;
        if (i8 == 1) {
            memoryUsage = LZMAEncoderFast.getMemoryUsage(i9, i10, i11);
        } else {
            if (i8 != 2) {
                throw new IllegalArgumentException();
            }
            memoryUsage = LZMAEncoderNormal.getMemoryUsage(i9, i10, i11);
        }
        return memoryUsage + 80;
    }

    private void updateAlignPrices() {
        this.alignPriceCount = 16;
        for (int i8 = 0; i8 < 16; i8++) {
            this.alignPrices[i8] = RangeEncoder.getReverseBitTreePrice(this.distAlign, i8);
        }
    }

    private void updateDistPrices() {
        this.distPriceCount = 128;
        int i8 = 0;
        while (true) {
            if (i8 >= 4) {
                break;
            }
            for (int i9 = 0; i9 < this.distSlotPricesSize; i9++) {
                this.distSlotPrices[i8][i9] = RangeEncoder.getBitTreePrice(this.distSlots[i8], i9);
            }
            for (int i10 = 14; i10 < this.distSlotPricesSize; i10++) {
                int[] iArr = this.distSlotPrices[i8];
                iArr[i10] = RangeEncoder.getDirectBitsPrice((i10 >>> 1) - 5) + iArr[i10];
            }
            for (int i11 = 0; i11 < 4; i11++) {
                this.fullDistPrices[i8][i11] = this.distSlotPrices[i8][i11];
            }
            i8++;
        }
        int i12 = 4;
        for (int i13 = 4; i13 < 14; i13++) {
            int i14 = ((i13 & 1) | 2) << ((i13 >>> 1) - 1);
            int i15 = i13 - 4;
            int length = this.distSpecial[i15].length;
            for (int i16 = 0; i16 < length; i16++) {
                int reverseBitTreePrice = RangeEncoder.getReverseBitTreePrice(this.distSpecial[i15], i12 - i14);
                for (int i17 = 0; i17 < 4; i17++) {
                    this.fullDistPrices[i17][i12] = this.distSlotPrices[i17][i13] + reverseBitTreePrice;
                }
                i12++;
            }
        }
    }

    public void encodeForLZMA1() {
        if (this.lz.isStarted() || encodeInit()) {
            while (encodeSymbol()) {
            }
        }
    }

    public boolean encodeForLZMA2() {
        try {
            if (!this.lz.isStarted() && !encodeInit()) {
                return false;
            }
            while (this.uncompressedSize <= LZMA2_UNCOMPRESSED_LIMIT && this.rc.getPendingSize() <= LZMA2_COMPRESSED_LIMIT) {
                if (!encodeSymbol()) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            throw new Error();
        }
    }

    public void encodeLZMA1EndMarker() {
        int pos = (this.lz.getPos() - this.readAhead) & this.posMask;
        this.rc.encodeBit(this.isMatch[this.state.get()], pos, 1);
        this.rc.encodeBit(this.isRep, this.state.get(), 0);
        encodeMatch(-1, 2, pos);
    }

    public int getAnyMatchPrice(State state, int i8) {
        return RangeEncoder.getBitPrice(this.isMatch[state.get()][i8], 1);
    }

    public int getAnyRepPrice(int i8, State state) {
        return RangeEncoder.getBitPrice(this.isRep[state.get()], 1) + i8;
    }

    public LZEncoder getLZEncoder() {
        return this.lz;
    }

    public int getLongRepAndLenPrice(int i8, int i9, State state, int i10) {
        return getLongRepPrice(getAnyRepPrice(getAnyMatchPrice(state, i10), state), i8, state, i10) + this.repLenEncoder.getPrice(i9, i10);
    }

    public int getLongRepPrice(int i8, int i9, State state, int i10) {
        if (i9 == 0) {
            return RangeEncoder.getBitPrice(this.isRep0Long[state.get()][i10], 1) + RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + i8;
        }
        int bitPrice = RangeEncoder.getBitPrice(this.isRep0[state.get()], 1) + i8;
        if (i9 == 1) {
            return RangeEncoder.getBitPrice(this.isRep1[state.get()], 0) + bitPrice;
        }
        return RangeEncoder.getBitPrice(this.isRep2[state.get()], i9 - 2) + RangeEncoder.getBitPrice(this.isRep1[state.get()], 1) + bitPrice;
    }

    public int getMatchAndLenPrice(int i8, int i9, int i10, int i11) {
        int price = i8 + this.matchLenEncoder.getPrice(i10, i11);
        int distState = LZMACoder.getDistState(i10);
        if (i9 < 128) {
            return price + this.fullDistPrices[distState][i9];
        }
        return this.distSlotPrices[distState][getDistSlot(i9)] + this.alignPrices[i9 & 15] + price;
    }

    public Matches getMatches() {
        this.readAhead++;
        return this.lz.getMatches();
    }

    public abstract int getNextSymbol();

    public int getNormalMatchPrice(int i8, State state) {
        return RangeEncoder.getBitPrice(this.isRep[state.get()], 0) + i8;
    }

    public int getShortRepPrice(int i8, State state, int i9) {
        return RangeEncoder.getBitPrice(this.isRep0Long[state.get()][i9], 0) + RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + i8;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        this.lz.putArraysToCache(arrayCache);
    }

    @Override // org.tukaani.xz.lzma.LZMACoder
    public void reset() {
        super.reset();
        this.literalEncoder.reset();
        this.matchLenEncoder.reset();
        this.repLenEncoder.reset();
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        this.uncompressedSize = this.readAhead + 1 + this.uncompressedSize;
        this.readAhead = -1;
    }

    public void resetUncompressedSize() {
        this.uncompressedSize = 0;
    }

    public void skip(int i8) {
        this.readAhead += i8;
        this.lz.skip(i8);
    }

    public void updatePrices() {
        if (this.distPriceCount <= 0) {
            updateDistPrices();
        }
        if (this.alignPriceCount <= 0) {
            updateAlignPrices();
        }
        this.matchLenEncoder.updatePrices();
        this.repLenEncoder.updatePrices();
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public class LengthEncoder extends LZMACoder.LengthCoder {
        private static final int PRICE_UPDATE_INTERVAL = 32;
        private final int[] counters;
        private final int[][] prices;

        public LengthEncoder(int i8, int i9) {
            super();
            int i10 = 1 << i8;
            this.counters = new int[i10];
            this.prices = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i10, Math.max(i9 - 1, 16));
        }

        public void encode(int i8, int i9) {
            int i10 = i8 - 2;
            if (i10 < 8) {
                LZMAEncoder.this.rc.encodeBit(this.choice, 0, 0);
                LZMAEncoder.this.rc.encodeBitTree(this.low[i9], i10);
            } else {
                LZMAEncoder.this.rc.encodeBit(this.choice, 0, 1);
                int i11 = i8 - 10;
                if (i11 < 8) {
                    LZMAEncoder.this.rc.encodeBit(this.choice, 1, 0);
                    LZMAEncoder.this.rc.encodeBitTree(this.mid[i9], i11);
                } else {
                    LZMAEncoder.this.rc.encodeBit(this.choice, 1, 1);
                    LZMAEncoder.this.rc.encodeBitTree(this.high, i8 - 18);
                }
            }
            int[] iArr = this.counters;
            iArr[i9] = iArr[i9] - 1;
        }

        public int getPrice(int i8, int i9) {
            return this.prices[i9][i8 - 2];
        }

        @Override // org.tukaani.xz.lzma.LZMACoder.LengthCoder
        public void reset() {
            super.reset();
            int i8 = 0;
            while (true) {
                int[] iArr = this.counters;
                if (i8 >= iArr.length) {
                    return;
                }
                iArr[i8] = 0;
                i8++;
            }
        }

        public void updatePrices() {
            int i8 = 0;
            while (true) {
                int[] iArr = this.counters;
                if (i8 >= iArr.length) {
                    return;
                }
                if (iArr[i8] <= 0) {
                    iArr[i8] = 32;
                    updatePrices(i8);
                }
                i8++;
            }
        }

        private void updatePrices(int i8) {
            int bitPrice = RangeEncoder.getBitPrice(this.choice[0], 0);
            int i9 = 0;
            while (i9 < 8) {
                this.prices[i8][i9] = RangeEncoder.getBitTreePrice(this.low[i8], i9) + bitPrice;
                i9++;
            }
            int bitPrice2 = RangeEncoder.getBitPrice(this.choice[0], 1);
            int bitPrice3 = RangeEncoder.getBitPrice(this.choice[1], 0);
            while (i9 < 16) {
                this.prices[i8][i9] = RangeEncoder.getBitTreePrice(this.mid[i8], i9 - 8) + bitPrice2 + bitPrice3;
                i9++;
            }
            int bitPrice4 = RangeEncoder.getBitPrice(this.choice[1], 1);
            while (true) {
                int[] iArr = this.prices[i8];
                if (i9 >= iArr.length) {
                    return;
                }
                iArr[i9] = RangeEncoder.getBitTreePrice(this.high, i9 - 16) + bitPrice2 + bitPrice4;
                i9++;
            }
        }
    }
}
