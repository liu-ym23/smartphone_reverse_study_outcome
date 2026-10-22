package org.tukaani.xz.rangecoder;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RangeDecoder extends RangeCoder {
    int code;
    int range;

    public abstract void normalize() throws IOException;

    public RangeDecoder() {
        this.range = 0;
        this.code = 0;
    }

    public int decodeBit(short[] probs, int index) throws IOException {
        normalize();
        short r0 = probs[index];
        int bound = (this.range >>> 11) * r0;
        if ((this.code ^ Integer.MIN_VALUE) >= (Integer.MIN_VALUE ^ bound)) goto L5;
        this.range = bound;
        probs[index] = (short) (((2048 - r0) >>> 5) + r0);
        return 0;
    L5:
        int bit = this.range;
        this.range = bit - bound;
        this.code -= bound;
        probs[index] = (short) (r0 - (r0 >>> 5));
        return 1;
    }

    public int decodeBitTree(short[] probs) throws IOException {
        int symbol = 1;
    L3:
        symbol = (symbol << 1) | decodeBit(probs, symbol);
        if (symbol < probs.length) goto L3;
        return symbol - probs.length;
    }

    public int decodeReverseBitTree(short[] probs) throws IOException {
        int symbol = 1;
        int i = 0;
        int result = 0;
    L3:
        int bit = decodeBit(probs, symbol);
        symbol = (symbol << 1) | bit;
        int i2 = i + 1;
        result = result | (bit << i);
        if (symbol >= probs.length) goto L5;
        i = i2;
        goto L3
    L5:
        return result;
    }

    public int decodeDirectBits(int count) throws IOException {
        int result = 0;
    L3:
        normalize();
        this.range >>>= 1;
        int t = (this.code - this.range) >>> 31;
        this.code -= this.range & (t - 1);
        result = (result << 1) | (1 - t);
        count = count - 1;
        if (count != 0) goto L3;
        return result;
    }
}
