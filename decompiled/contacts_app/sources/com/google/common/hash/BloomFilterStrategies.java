package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
abstract enum BloomFilterStrategies extends Enum<BloomFilterStrategies> implements BloomFilter.Strategy {
    private static final /* synthetic */ BloomFilterStrategies[] $VALUES = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_32 = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_64 = null;

    static final class BitArray {
        long bitCount;
        final long[] data;

        BitArray(long r4) {
            this(new long[Ints.checkedCast(LongMath.divide(r4, 64, RoundingMode.CEILING))]);
        }

        BitArray(long[] r7) {
            int r1 = 0;
            if (r7.length <= 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "data length is zero!");
            this.data = r7;
            int r2 = r7.length;
            long r3 = 0;
        L7:
            if (r1 >= r2) goto L9;
            r3 = r3 + ((long) Long.bitCount(r7[r1]));
            r1 = r1 + 1;
            goto L7
        L9:
            this.bitCount = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        boolean set(long r7) {
            if (get(r7) == true) goto L6;
            long[] r0 = this.data;
            int r1 = (int) (r7 >>> 6);
            r0[r1] = (1 << ((int) r7)) | r0[r1];
            this.bitCount++;
            return true;
        L6:
            return false;
        }

        boolean get(long r5) {
            long r0 = this.data[(int) (r5 >>> 6)];
            if (((1 << ((int) r5)) & r0) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        long bitSize() {
            return ((long) this.data.length) * 64;
        }

        long bitCount() {
            return this.bitCount;
        }

        BitArray copy() {
            return new BitArray((long[]) this.data.clone());
        }

        void putAll(BitArray r8) {
            long[] r0 = this.data;
            int r4 = 0;
            if (r0.length != r8.data.length) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "BitArrays must be of equal length (%s != %s)", new Object[]{Integer.valueOf(r0.length), Integer.valueOf(r8.data.length)});
            this.bitCount = 0;
        L7:
            long[] r2 = this.data;
            if (r4 >= r2.length) goto L10;
            long r3 = r2[r4] | r8.data[r4];
            r2[r4] = r3;
            this.bitCount += (long) Long.bitCount(r3);
            r4 = r4 + 1;
            goto L7
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof BitArray) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(this.data, ((BitArray) r2).data);
        }

        public int hashCode() {
            return Arrays.hashCode(this.data);
        }
    }

    private BloomFilterStrategies(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ BloomFilterStrategies(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static BloomFilterStrategies valueOf(String r1) {
        return (BloomFilterStrategies) Enum.valueOf(BloomFilterStrategies.class, r1);
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) $VALUES.clone();
    }

    static {
        final String r1 = "MURMUR128_MITZ_32";
        final int r2 = 0;
        BloomFilterStrategies r0 = new AnonymousClass1(r1, r2);
        MURMUR128_MITZ_32 = r0;
        final String r3 = "MURMUR128_MITZ_64";
        final int r4 = 1;
        BloomFilterStrategies r5 = new AnonymousClass2(r3, r4);
        MURMUR128_MITZ_64 = r5;
        $VALUES = new BloomFilterStrategies[]{r0, r5};
    }
}
