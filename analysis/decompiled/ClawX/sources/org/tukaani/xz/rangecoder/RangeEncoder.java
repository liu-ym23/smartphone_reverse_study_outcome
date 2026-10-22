package org.tukaani.xz.rangecoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class RangeEncoder extends RangeCoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BIT_PRICE_SHIFT_BITS = 4;
    private static final int MOVE_REDUCING_BITS = 4;
    private static final int[] prices = new int[128];
    private byte cache;
    long cacheSize;
    private long low;
    private int range;

    static {
        for (int i8 = 8; i8 < 2048; i8 += 16) {
            int i9 = i8;
            int i10 = 0;
            for (int i11 = 0; i11 < 4; i11++) {
                i9 *= i9;
                i10 <<= 1;
                while (((-65536) & i9) != 0) {
                    i9 >>>= 1;
                    i10++;
                }
            }
            prices[i8 >> 4] = 161 - i10;
        }
    }

    public static int getBitPrice(int i8, int i9) {
        return prices[(i8 ^ ((-i9) & 2047)) >>> 4];
    }

    public static int getBitTreePrice(short[] sArr, int i8) {
        int length = i8 | sArr.length;
        int bitPrice = 0;
        do {
            int i9 = length & 1;
            length >>>= 1;
            bitPrice += getBitPrice(sArr[length], i9);
        } while (length != 1);
        return bitPrice;
    }

    public static int getDirectBitsPrice(int i8) {
        return i8 << 4;
    }

    public static int getReverseBitTreePrice(short[] sArr, int i8) {
        int length = i8 | sArr.length;
        int bitPrice = 0;
        int i9 = 1;
        do {
            int i10 = length & 1;
            length >>>= 1;
            bitPrice += getBitPrice(sArr[i9], i10);
            i9 = (i9 << 1) | i10;
        } while (length != 1);
        return bitPrice;
    }

    private void shiftLow() {
        long j4 = this.low;
        int i8 = (int) (j4 >>> 32);
        if (i8 != 0 || j4 < 4278190080L) {
            byte b9 = this.cache;
            while (true) {
                writeByte(b9 + i8);
                long j8 = this.cacheSize - 1;
                this.cacheSize = j8;
                if (j8 == 0) {
                    break;
                } else {
                    b9 = 255;
                }
            }
            this.cache = (byte) (this.low >>> 24);
        }
        this.cacheSize++;
        this.low = (this.low & 16777215) << 8;
    }

    public void encodeBit(short[] sArr, int i8, int i9) {
        short s8 = sArr[i8];
        int i10 = this.range;
        int i11 = (i10 >>> 11) * s8;
        if (i9 == 0) {
            this.range = i11;
            sArr[i8] = (short) (s8 + ((2048 - s8) >>> 5));
        } else {
            this.low += i11 & 4294967295L;
            this.range = i10 - i11;
            sArr[i8] = (short) (s8 - (s8 >>> 5));
        }
        int i12 = this.range;
        if (((-16777216) & i12) == 0) {
            this.range = i12 << 8;
            shiftLow();
        }
    }

    public void encodeBitTree(short[] sArr, int i8) {
        int length = sArr.length;
        int i9 = 1;
        do {
            length >>>= 1;
            int i10 = i8 & length;
            encodeBit(sArr, i9, i10);
            i9 <<= 1;
            if (i10 != 0) {
                i9 |= 1;
            }
        } while (length != 1);
    }

    public void encodeDirectBits(int i8, int i9) {
        do {
            int i10 = this.range >>> 1;
            this.range = i10;
            i9--;
            this.low += (0 - ((i8 >>> i9) & 1)) & i10;
            if (((-16777216) & i10) == 0) {
                this.range = i10 << 8;
                shiftLow();
            }
        } while (i9 != 0);
    }

    public void encodeReverseBitTree(short[] sArr, int i8) {
        int length = i8 | sArr.length;
        int i9 = 1;
        do {
            int i10 = length & 1;
            length >>>= 1;
            encodeBit(sArr, i9, i10);
            i9 = (i9 << 1) | i10;
        } while (length != 1);
    }

    public int finish() {
        for (int i8 = 0; i8 < 5; i8++) {
            shiftLow();
        }
        return -1;
    }

    public int getPendingSize() {
        throw new Error();
    }

    public void reset() {
        this.low = 0L;
        this.range = -1;
        this.cache = (byte) 0;
        this.cacheSize = 1L;
    }

    public abstract void writeByte(int i8);
}
