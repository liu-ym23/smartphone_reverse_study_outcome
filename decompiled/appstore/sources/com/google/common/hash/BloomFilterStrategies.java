package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
abstract enum BloomFilterStrategies extends Enum<BloomFilterStrategies> implements BloomFilter.Strategy {
    private static final /* synthetic */ BloomFilterStrategies[] $VALUES = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_32 = null;
    public static final BloomFilterStrategies MURMUR128_MITZ_64 = null;

    public static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        public LockFreeBitArray(long r10) {
            this(new long[Ints.checkedCast(LongMath.divide(r10, 64, RoundingMode.CEILING))]);
        }

        public static long[] toPlainArray(AtomicLongArray r10) {
            int r11 = r10.length();
            long[] r12 = new long[r11];
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L5;
            r12[r13] = r10.get(r13);
            r13 = r13 + 1;
            goto L3
        L5:
            return r12;
        }

        public long bitCount() {
            return this.bitCount.sum();
        }

        public long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        public LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof LockFreeBitArray) == true) goto L5;
            return false;
        L5:
            return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) r10).data));
        }

        public boolean get(long r10) {
            long r11 = this.data.get((int) (r10 >>> 6));
            if (((1 << ((int) r10)) & r11) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }

        public void putAll(LockFreeBitArray r14) {
            int r10 = 0;
            if (this.data.length() != r14.data.length()) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "BitArrays must be of equal length (%s != %s)", this.data.length(), r14.data.length());
        L8:
            if (r10 >= this.data.length()) goto L17;
            long r12 = r14.data.get(r10);
        L10:
            long r13 = this.data.get(r10);
            long r15 = r13 | r12;
            if (r13 == r15) goto L16;
            if (this.data.compareAndSet(r10, r13, r15) == false) goto L10;
            this.bitCount.add(Long.bitCount(r15) - Long.bitCount(r13));
        L16:
            r10 = r10 + 1;
            goto L8
        L17:
            return;
        L5:
            r11 = false;
            goto L6
        }

        public boolean set(long r11) {
            if (get(r11) == false) goto L5;
            return false;
        L5:
            int r10 = (int) (r11 >>> 6);
            long r12 = 1 << ((int) r11);
        L6:
            long r13 = this.data.get(r10);
            long r14 = r13 | r12;
            if (r13 == r14) goto L8;
            if (this.data.compareAndSet(r10, r13, r14) == false) goto L6;
            this.bitCount.increment();
            return true;
        L8:
            return false;
        }

        public LockFreeBitArray(long[] r10) {
            int r11 = 0;
            if (r10.length <= 0) goto L5;
            boolean r12 = true;
        L6:
            Preconditions.checkArgument(r12, "data length is zero!");
            this.data = new AtomicLongArray(r10);
            this.bitCount = LongAddables.create();
            int r13 = r10.length;
            long r14 = 0;
        L7:
            if (r11 >= r13) goto L9;
            r14 = r14 + ((long) Long.bitCount(r10[r11]));
            r11 = r11 + 1;
            goto L7
        L9:
            this.bitCount.add(r14);
            return;
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        final String r10 = "MURMUR128_MITZ_32";
        final int r11 = 0;
        BloomFilterStrategies r12 = new AnonymousClass1(r10, r11);
        MURMUR128_MITZ_32 = r12;
        final String r13 = "MURMUR128_MITZ_64";
        final int r14 = 1;
        BloomFilterStrategies r15 = new AnonymousClass2(r13, r14);
        MURMUR128_MITZ_64 = r15;
        $VALUES = new BloomFilterStrategies[]{r12, r15};
    }

    private BloomFilterStrategies(String r10, int r11) {
        super(r10, r11);
    }

    public static BloomFilterStrategies valueOf(String r10) {
        return (BloomFilterStrategies) Enum.valueOf(BloomFilterStrategies.class, r10);
    }

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[]) $VALUES.clone();
    }

    public /* synthetic */ BloomFilterStrategies(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }
}
