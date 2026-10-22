package org.tukaani.xz.lzma;

import java.io.IOException;
import java.lang.reflect.Array;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

/* JADX INFO: loaded from: classes3.dex */
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

    class LengthEncoder extends LZMACoder.LengthCoder {
        private static final int PRICE_UPDATE_INTERVAL = 32;
        private final int[] counters;
        private final int[][] prices;
        final /* synthetic */ LZMAEncoder this$0;

        LengthEncoder(LZMAEncoder this$0, int pb, int niceLen) {
            this.this$0 = this$0;
            super(this$0);
            int posStates = 1 << pb;
            this.counters = new int[posStates];
            int lenSymbols = Math.max((niceLen - 2) + 1, 16);
            this.prices = (int[][]) Array.newInstance(Integer.TYPE, new int[]{posStates, lenSymbols});
        }

        @Override // org.tukaani.xz.lzma.LZMACoder.LengthCoder
        void reset() {
            super.reset();
            int i = 0;
        L4:
            if (i >= this.counters.length) goto L7;
            this.counters[i] = 0;
            i = i + 1;
            goto L4
        }

        void encode(int len, int posState) throws IOException {
            int len2 = len - 2;
            if (len2 >= 8) goto L5;
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBit(this.choice, 0, 0);
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBitTree(this.low[posState], len2);
        L9:
            int[] r0 = this.counters;
            r0[posState] = r0[posState] - 1;
            return;
        L5:
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBit(this.choice, 0, 1);
            int len3 = len2 - 8;
            if (len3 >= 8) goto L8;
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBit(this.choice, 1, 0);
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBitTree(this.mid[posState], len3);
            goto L9
        L8:
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBit(this.choice, 1, 1);
            LZMAEncoder.m10591$$Nest$fgetrc(this.this$0).encodeBitTree(this.high, len3 - 8);
            goto L9
        }

        int getPrice(int len, int posState) {
            return this.prices[posState][len - 2];
        }

        void updatePrices() {
            int posState = 0;
        L4:
            if (posState >= this.counters.length) goto L10;
            if (this.counters[posState] > 0) goto L8;
            this.counters[posState] = 32;
            updatePrices(posState);
        L8:
            posState = posState + 1;
            goto L4
        }

        private void updatePrices(int posState) {
            int choice0Price = RangeEncoder.getBitPrice(this.choice[0], 0);
            int i = 0;
        L4:
            if (i >= 8) goto L6;
            this.prices[posState][i] = RangeEncoder.getBitTreePrice(this.low[posState], i) + choice0Price;
            i = i + 1;
            goto L4
        L6:
            int choice0Price2 = RangeEncoder.getBitPrice(this.choice[0], 1);
            int choice1Price = RangeEncoder.getBitPrice(this.choice[1], 0);
        L8:
            if (i >= 16) goto L10;
            this.prices[posState][i] = (choice0Price2 + choice1Price) + RangeEncoder.getBitTreePrice(this.mid[posState], i - 8);
            i = i + 1;
            goto L8
        L10:
            int choice1Price2 = RangeEncoder.getBitPrice(this.choice[1], 1);
        L12:
            if (i >= this.prices[posState].length) goto L14;
            this.prices[posState][i] = (choice0Price2 + choice1Price2) + RangeEncoder.getBitTreePrice(this.high, (i - 8) - 8);
            i = i + 1;
            goto L12
        }
    }

    class LiteralEncoder extends LZMACoder.LiteralCoder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final LiteralSubencoder[] subencoders;
        final /* synthetic */ LZMAEncoder this$0;

        private class LiteralSubencoder extends LZMACoder.LiteralCoder.LiteralSubcoder {
            final /* synthetic */ LiteralEncoder this$1;

            /* synthetic */ LiteralSubencoder(LiteralEncoder r1, LZMAEncoderIA r2) {
                this(r1);
            }

            private LiteralSubencoder(LiteralEncoder r1) {
                this.this$1 = r1;
                super(r1);
            }

            void encode() throws IOException {
                int symbol = this.this$1.this$0.lz.getByte(this.this$1.this$0.readAhead) | 256;
                if (this.this$1.this$0.state.isLiteral() == false) goto L7;
            L4:
                int subencoderIndex = symbol >>> 8;
                int bit = (symbol >>> 7) & 1;
                LZMAEncoder.m10591$$Nest$fgetrc(this.this$1.this$0).encodeBit(this.probs, subencoderIndex, bit);
                symbol = symbol << 1;
                if (symbol < 65536) goto L4;
            L10:
                this.this$1.this$0.state.updateLiteral();
                return;
            L7:
                int matchByte = this.this$1.this$0.lz.getByte((this.this$1.this$0.reps[0] + 1) + this.this$1.this$0.readAhead);
                int offset = 256;
            L8:
                matchByte = matchByte << 1;
                int matchBit = matchByte & offset;
                int subencoderIndex2 = (offset + matchBit) + (symbol >>> 8);
                int bit2 = (symbol >>> 7) & 1;
                LZMAEncoder.m10591$$Nest$fgetrc(this.this$1.this$0).encodeBit(this.probs, subencoderIndex2, bit2);
                symbol = symbol << 1;
                offset = offset & (~(matchByte ^ symbol));
                if (symbol < 65536) goto L8;
                goto L10
            }

            int getNormalPrice(int symbol) {
                int price = 0;
                int symbol2 = symbol | 256;
            L3:
                int subencoderIndex = symbol2 >>> 8;
                int bit = (symbol2 >>> 7) & 1;
                price = price + RangeEncoder.getBitPrice(this.probs[subencoderIndex], bit);
                symbol2 = symbol2 << 1;
                if (symbol2 < 65536) goto L3;
                return price;
            }

            int getMatchedPrice(int symbol, int matchByte) {
                int price = 0;
                int offset = 256;
                int symbol2 = symbol | 256;
            L3:
                matchByte = matchByte << 1;
                int matchBit = matchByte & offset;
                int subencoderIndex = (offset + matchBit) + (symbol2 >>> 8);
                int bit = (symbol2 >>> 7) & 1;
                price = price + RangeEncoder.getBitPrice(this.probs[subencoderIndex], bit);
                symbol2 = symbol2 << 1;
                offset = offset & (~(matchByte ^ symbol2));
                if (symbol2 < 65536) goto L3;
                return price;
            }
        }

        static {
        }

        LiteralEncoder(LZMAEncoder this$0, int lc, int lp) {
            this.this$0 = this$0;
            super(this$0, lc, lp);
            this.subencoders = new LiteralSubencoder[1 << (lc + lp)];
            int i = 0;
        L4:
            if (i >= this.subencoders.length) goto L7;
            this.subencoders[i] = new LiteralSubencoder(this, null);
            i = i + 1;
            goto L4
        }

        void reset() {
            int i = 0;
        L4:
            if (i >= this.subencoders.length) goto L7;
            this.subencoders[i].reset();
            i = i + 1;
            goto L4
        }

        void encodeInit() throws IOException {
            this.subencoders[0].encode();
        }

        void encode() throws IOException {
            int i = getSubcoderIndex(this.this$0.lz.getByte(this.this$0.readAhead + 1), this.this$0.lz.getPos() - this.this$0.readAhead);
            this.subencoders[i].encode();
        }

        int getPrice(int curByte, int matchByte, int prevByte, int pos, State state) {
            int price = RangeEncoder.getBitPrice(this.this$0.isMatch[state.get()][this.this$0.posMask & pos], 0);
            int i = getSubcoderIndex(prevByte, pos);
            if (state.isLiteral() == false) goto L5;
            int r2 = this.subencoders[i].getNormalPrice(curByte);
        L7:
            return price + r2;
        L5:
            r2 = this.subencoders[i].getMatchedPrice(curByte, matchByte);
            goto L7
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetrc, reason: not valid java name */
    static /* bridge */ /* synthetic */ RangeEncoder m10591$$Nest$fgetrc(LZMAEncoder r0) {
        return r0.rc;
    }

    abstract int getNextSymbol();

    static {
    }

    public static int getMemoryUsage(int mode, int dictSize, int extraSizeBefore, int mf) {
        switch(mode) {
            case 1: goto L7;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        int m = 80 + LZMAEncoderNormal.getMemoryUsage(dictSize, extraSizeBefore, mf);
        return m;
    L7:
        int m2 = 80 + LZMAEncoderFast.getMemoryUsage(dictSize, extraSizeBefore, mf);
        return m2;
    L5:
        throw new IllegalArgumentException();
    }

    public static LZMAEncoder getInstance(RangeEncoder rc, int lc, int lp, int pb, int mode, int dictSize, int extraSizeBefore, int niceLen, int mf, int depthLimit, ArrayCache arrayCache) {
        switch(mode) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException();
    L6:
        return new LZMAEncoderNormal(rc, lc, lp, pb, dictSize, extraSizeBefore, niceLen, mf, depthLimit, arrayCache);
    L8:
        return new LZMAEncoderFast(rc, lc, lp, pb, dictSize, extraSizeBefore, niceLen, mf, depthLimit, arrayCache);
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        this.lz.putArraysToCache(arrayCache);
    }

    public static int getDistSlot(int dist) {
        if (dist > 4) goto L6;
        if (dist < 0) goto L6;
        return dist;
    L6:
        int n = dist;
        int i = 31;
        if (((-65536) & n) != 0) goto L10;
        n = n << 16;
        i = 15;
    L10:
        if (((-16777216) & n) != 0) goto L13;
        n = n << 8;
        i = i - 8;
    L13:
        if (((-268435456) & n) != 0) goto L16;
        n = n << 4;
        i = i - 4;
    L16:
        if (((-1073741824) & n) != 0) goto L19;
        n = n << 2;
        i = i - 2;
    L19:
        if ((Integer.MIN_VALUE & n) != 0) goto L22;
        i = i - 1;
    L22:
        return (i << 1) + ((dist >>> (i - 1)) & 1);
    }

    LZMAEncoder(RangeEncoder rc, LZEncoder lz, int lc, int lp, int pb, int dictSize, int niceLen) {
        super(pb);
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        this.fullDistPrices = (int[][]) Array.newInstance(Integer.TYPE, new int[]{4, 128});
        this.alignPrices = new int[16];
        this.back = 0;
        this.readAhead = -1;
        this.uncompressedSize = 0;
        this.rc = rc;
        this.lz = lz;
        this.niceLen = niceLen;
        this.literalEncoder = new LiteralEncoder(this, lc, lp);
        this.matchLenEncoder = new LengthEncoder(this, pb, niceLen);
        this.repLenEncoder = new LengthEncoder(this, pb, niceLen);
        this.distSlotPricesSize = getDistSlot(dictSize - 1) + 1;
        this.distSlotPrices = (int[][]) Array.newInstance(Integer.TYPE, new int[]{4, this.distSlotPricesSize});
        reset();
    }

    public LZEncoder getLZEncoder() {
        return this.lz;
    }

    @Override // org.tukaani.xz.lzma.LZMACoder
    public void reset() {
        super.reset();
        this.literalEncoder.reset();
        this.matchLenEncoder.reset();
        this.repLenEncoder.reset();
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        this.uncompressedSize += this.readAhead + 1;
        this.readAhead = -1;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void resetUncompressedSize() {
        this.uncompressedSize = 0;
    }

    public void encodeForLZMA1() throws IOException {
        if (this.lz.isStarted() == true) goto L8;
        if (encodeInit() == true) goto L8;
        return;
    L8:
        if (encodeSymbol() == true) goto L8;
    }

    public void encodeLZMA1EndMarker() throws IOException {
        int posState = (this.lz.getPos() - this.readAhead) & this.posMask;
        this.rc.encodeBit(this.isMatch[this.state.get()], posState, 1);
        this.rc.encodeBit(this.isRep, this.state.get(), 0);
        encodeMatch(-1, 2, posState);
    }

    public boolean encodeForLZMA2() {
        if (this.lz.isStarted() == true) goto L9;
        if (encodeInit() == true) goto L9;
        return false;
    L9:
        if (this.uncompressedSize > LZMA2_UNCOMPRESSED_LIMIT) goto L16;
        if (this.rc.getPendingSize() > LZMA2_COMPRESSED_LIMIT) goto L27;
        if (encodeSymbol() == true) goto L9;
        return false;
    L27:
        return true;
    L16:
        return true;
    L19:
        throw new Error();
    }

    private boolean encodeInit() throws IOException {
        if (this.lz.hasEnoughData(0) == true) goto L5;
        return false;
    L5:
        skip(1);
        this.rc.encodeBit(this.isMatch[this.state.get()], 0, 0);
        this.literalEncoder.encodeInit();
        this.readAhead--;
        this.uncompressedSize++;
        return true;
    }

    private boolean encodeSymbol() throws IOException {
        if (this.lz.hasEnoughData(this.readAhead + 1) == true) goto L5;
        return false;
    L5:
        int len = getNextSymbol();
        int posState = (this.lz.getPos() - this.readAhead) & this.posMask;
        if (this.back != (-1)) goto L8;
        this.rc.encodeBit(this.isMatch[this.state.get()], posState, 0);
        this.literalEncoder.encode();
    L12:
        this.readAhead -= len;
        this.uncompressedSize += len;
        return true;
    L8:
        this.rc.encodeBit(this.isMatch[this.state.get()], posState, 1);
        if (this.back >= 4) goto L11;
        this.rc.encodeBit(this.isRep, this.state.get(), 1);
        encodeRepMatch(this.back, len, posState);
        goto L12
    L11:
        this.rc.encodeBit(this.isRep, this.state.get(), 0);
        encodeMatch(this.back - 4, len, posState);
        goto L12
    }

    private void encodeMatch(int dist, int len, int posState) throws IOException {
        this.state.updateMatch();
        this.matchLenEncoder.encode(len, posState);
        int distSlot = getDistSlot(dist);
        this.rc.encodeBitTree(this.distSlots[LZMACoder.getDistState(len)], distSlot);
        if (distSlot < 4) goto L8;
        int footerBits = (distSlot >>> 1) - 1;
        int base = ((distSlot & 1) | 2) << footerBits;
        int distReduced = dist - base;
        if (distSlot >= 14) goto L7;
        this.rc.encodeReverseBitTree(this.distSpecial[distSlot - 4], distReduced);
        goto L8
    L7:
        this.rc.encodeDirectBits(distReduced >>> 4, footerBits - 4);
        this.rc.encodeReverseBitTree(this.distAlign, distReduced & 15);
        this.alignPriceCount--;
    L8:
        this.reps[3] = this.reps[2];
        this.reps[2] = this.reps[1];
        this.reps[1] = this.reps[0];
        this.reps[0] = dist;
        this.distPriceCount--;
    }

    private void encodeRepMatch(int rep, int len, int posState) throws IOException {
        int r0 = 0;
        if (rep != 0) goto L9;
        this.rc.encodeBit(this.isRep0, this.state.get(), 0);
        RangeEncoder r2 = this.rc;
        short[] r3 = this.isRep0Long[this.state.get()];
        if (len == 1) goto L8;
        r0 = 1;
    L8:
        r2.encodeBit(r3, posState, r0);
    L17:
        if (len != 1) goto L19;
        this.state.updateShortRep();
        return;
    L19:
        this.repLenEncoder.encode(len, posState);
        this.state.updateLongRep();
        return;
    L9:
        int dist = this.reps[rep];
        this.rc.encodeBit(this.isRep0, this.state.get(), 1);
        if (rep != 1) goto L12;
        this.rc.encodeBit(this.isRep1, this.state.get(), 0);
    L16:
        this.reps[1] = this.reps[0];
        this.reps[0] = dist;
        goto L17
    L12:
        this.rc.encodeBit(this.isRep1, this.state.get(), 1);
        this.rc.encodeBit(this.isRep2, this.state.get(), rep - 2);
        if (rep != 3) goto L15;
        this.reps[3] = this.reps[2];
    L15:
        this.reps[2] = this.reps[1];
        goto L16
    }

    Matches getMatches() {
        this.readAhead++;
        Matches matches = this.lz.getMatches();
        return matches;
    }

    void skip(int len) {
        this.readAhead += len;
        this.lz.skip(len);
    }

    int getAnyMatchPrice(State state, int posState) {
        return RangeEncoder.getBitPrice(this.isMatch[state.get()][posState], 1);
    }

    int getNormalMatchPrice(int anyMatchPrice, State state) {
        return RangeEncoder.getBitPrice(this.isRep[state.get()], 0) + anyMatchPrice;
    }

    int getAnyRepPrice(int anyMatchPrice, State state) {
        return RangeEncoder.getBitPrice(this.isRep[state.get()], 1) + anyMatchPrice;
    }

    int getShortRepPrice(int anyRepPrice, State state, int posState) {
        return (RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + anyRepPrice) + RangeEncoder.getBitPrice(this.isRep0Long[state.get()][posState], 0);
    }

    int getLongRepPrice(int anyRepPrice, int rep, State state, int posState) {
        if (rep == 0) goto L10;
        int price = anyRepPrice + RangeEncoder.getBitPrice(this.isRep0[state.get()], 1);
        if (rep != 1) goto L9;
        return price + RangeEncoder.getBitPrice(this.isRep1[state.get()], 0);
    L9:
        return price + (RangeEncoder.getBitPrice(this.isRep1[state.get()], 1) + RangeEncoder.getBitPrice(this.isRep2[state.get()], rep - 2));
    L10:
        return anyRepPrice + (RangeEncoder.getBitPrice(this.isRep0[state.get()], 0) + RangeEncoder.getBitPrice(this.isRep0Long[state.get()][posState], 1));
    }

    int getLongRepAndLenPrice(int rep, int len, State state, int posState) {
        int anyMatchPrice = getAnyMatchPrice(state, posState);
        int anyRepPrice = getAnyRepPrice(anyMatchPrice, state);
        int longRepPrice = getLongRepPrice(anyRepPrice, rep, state, posState);
        return this.repLenEncoder.getPrice(len, posState) + longRepPrice;
    }

    int getMatchAndLenPrice(int normalMatchPrice, int dist, int len, int posState) {
        int price = this.matchLenEncoder.getPrice(len, posState) + normalMatchPrice;
        int distState = LZMACoder.getDistState(len);
        if (dist < 128) goto L7;
        int distSlot = getDistSlot(dist);
        return price + (this.distSlotPrices[distState][distSlot] + this.alignPrices[dist & 15]);
    L7:
        return price + this.fullDistPrices[distState][dist];
    }

    private void updateDistPrices() {
        this.distPriceCount = 128;
        int distState = 0;
    L4:
        if (distState >= 4) goto L17;
        int distSlot = 0;
    L7:
        if (distSlot >= this.distSlotPricesSize) goto L9;
        this.distSlotPrices[distState][distSlot] = RangeEncoder.getBitTreePrice(this.distSlots[distState], distSlot);
        distSlot = distSlot + 1;
        goto L7
    L9:
        int distSlot2 = 14;
    L11:
        if (distSlot2 >= this.distSlotPricesSize) goto L13;
        int count = ((distSlot2 >>> 1) - 1) - 4;
        int[] r4 = this.distSlotPrices[distState];
        r4[distSlot2] = r4[distSlot2] + RangeEncoder.getDirectBitsPrice(count);
        distSlot2 = distSlot2 + 1;
        goto L11
    L13:
        int dist = 0;
    L14:
        if (dist >= 4) goto L16;
        this.fullDistPrices[distState][dist] = this.distSlotPrices[distState][dist];
        dist = dist + 1;
        goto L14
    L16:
        distState = distState + 1;
        goto L4
    L17:
        int dist2 = 4;
        int distSlot3 = 4;
    L19:
        if (distSlot3 >= 14) goto L28;
        int footerBits = (distSlot3 >>> 1) - 1;
        int base = ((distSlot3 & 1) | 2) << footerBits;
        int limit = this.distSpecial[distSlot3 - 4].length;
        int i = 0;
    L21:
        if (i >= limit) goto L26;
        int distReduced = dist2 - base;
        int price = RangeEncoder.getReverseBitTreePrice(this.distSpecial[distSlot3 - 4], distReduced);
        int distState2 = 0;
    L23:
        if (distState2 >= 4) goto L25;
        this.fullDistPrices[distState2][dist2] = this.distSlotPrices[distState2][distSlot3] + price;
        distState2 = distState2 + 1;
        goto L23
    L25:
        dist2 = dist2 + 1;
        i = i + 1;
        goto L21
    L26:
        distSlot3 = distSlot3 + 1;
        goto L19
    }

    private void updateAlignPrices() {
        this.alignPriceCount = 16;
        int i = 0;
    L3:
        if (i >= 16) goto L6;
        this.alignPrices[i] = RangeEncoder.getReverseBitTreePrice(this.distAlign, i);
        i = i + 1;
        goto L3
    }

    void updatePrices() {
        if (this.distPriceCount > 0) goto L6;
        updateDistPrices();
    L6:
        if (this.alignPriceCount > 0) goto L8;
        updateAlignPrices();
    L8:
        this.matchLenEncoder.updatePrices();
        this.repLenEncoder.updatePrices();
    }
}
