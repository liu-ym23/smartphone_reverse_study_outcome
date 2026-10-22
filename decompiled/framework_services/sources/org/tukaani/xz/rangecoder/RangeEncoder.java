package org.tukaani.xz.rangecoder;

import android.hardware.audio.common.V2_0.AudioFormat;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RangeEncoder extends RangeCoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BIT_PRICE_SHIFT_BITS = 4;
    private static final int MOVE_REDUCING_BITS = 4;
    private static final int[] prices = null;
    private byte cache;
    long cacheSize;
    private long low;
    private int range;

    abstract void writeByte(int r1) throws IOException;

    static {
        prices = new int[128];
        int i = 8;
    L4:
        if (i >= 2048) goto L15;
        int w = i;
        int bitCount = 0;
        int j = 0;
    L7:
        if (j >= 4) goto L13;
        w = w * w;
        bitCount = bitCount << 1;
    L10:
        if (((-65536) & w) == 0) goto L12;
        w = w >>> 1;
        bitCount = bitCount + 1;
        goto L10
    L12:
        j = j + 1;
        goto L7
    L13:
        prices[i >> 4] = 161 - bitCount;
        i = i + 16;
        goto L4
    }

    public RangeEncoder() {
    }

    public void reset() {
        this.low = 0;
        this.range = -1;
        this.cache = 0;
        this.cacheSize = 1;
    }

    public int getPendingSize() {
        throw new Error();
    }

    public int finish() throws IOException {
        int i = 0;
    L4:
        if (i >= 5) goto L6;
        shiftLow();
        i = i + 1;
        goto L4
    L6:
        return -1;
    }

    private void shiftLow() throws IOException {
        int lowHi = (int) (this.low >>> 32);
        if (lowHi == 0) goto L5;
    L6:
        int temp = this.cache;
    L7:
        writeByte(temp + lowHi);
        temp = 255;
        long r4 = this.cacheSize - 1;
        this.cacheSize = r4;
        if (r4 != 0) goto L7;
        this.cache = (byte) (this.low >>> 24);
    L10:
        this.cacheSize++;
        this.low = (this.low & 16777215) << 8;
        return;
    L5:
        if (this.low >= 4278190080L) goto L10;
        goto L6
    }

    public void encodeBit(short[] probs, int index, int bit) throws IOException {
        short r0 = probs[index];
        int bound = (this.range >>> 11) * r0;
        if (bit != 0) goto L5;
        this.range = bound;
        probs[index] = (short) (((2048 - r0) >>> 5) + r0);
    L7:
        if ((this.range & AudioFormat.MAIN_MASK) != 0) goto L10;
        this.range <<= 8;
        shiftLow();
        return;
    L10:
        return;
    L5:
        this.low += ((long) bound) & 4294967295L;
        this.range -= bound;
        probs[index] = (short) (r0 - (r0 >>> 5));
        goto L7
    }

    public static int getBitPrice(int prob, int bit) {
        return prices[(((-bit) & 2047) ^ prob) >>> 4];
    }

    public void encodeBitTree(short[] probs, int symbol) throws IOException {
        int index = 1;
        int mask = probs.length;
    L3:
        mask = mask >>> 1;
        int bit = symbol & mask;
        encodeBit(probs, index, bit);
        index = index << 1;
        if (bit == 0) goto L6;
        index = index | 1;
    L6:
        if (mask != 1) goto L3;
    }

    public static int getBitTreePrice(short[] probs, int symbol) {
        int price = 0;
        int symbol2 = symbol | probs.length;
    L3:
        int bit = symbol2 & 1;
        symbol2 = symbol2 >>> 1;
        price = price + getBitPrice(probs[symbol2], bit);
        if (symbol2 != 1) goto L3;
        return price;
    }

    public void encodeReverseBitTree(short[] probs, int symbol) throws IOException {
        int index = 1;
        int symbol2 = symbol | probs.length;
    L3:
        int bit = symbol2 & 1;
        symbol2 = symbol2 >>> 1;
        encodeBit(probs, index, bit);
        index = (index << 1) | bit;
        if (symbol2 != 1) goto L3;
    }

    public static int getReverseBitTreePrice(short[] probs, int symbol) {
        int price = 0;
        int index = 1;
        int symbol2 = symbol | probs.length;
    L3:
        int bit = symbol2 & 1;
        symbol2 = symbol2 >>> 1;
        price = price + getBitPrice(probs[index], bit);
        index = (index << 1) | bit;
        if (symbol2 != 1) goto L3;
        return price;
    }

    public void encodeDirectBits(int value, int count) throws IOException {
    L2:
        this.range >>>= 1;
        count = count - 1;
        this.low += (long) (this.range & (0 - ((value >>> count) & 1)));
        if ((this.range & AudioFormat.MAIN_MASK) != 0) goto L5;
        this.range <<= 8;
        shiftLow();
    L5:
        if (count != 0) goto L2;
    }

    public static int getDirectBitsPrice(int count) {
        return count << 4;
    }
}
