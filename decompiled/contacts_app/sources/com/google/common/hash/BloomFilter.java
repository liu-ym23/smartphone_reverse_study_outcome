package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private static final Strategy DEFAULT_STRATEGY = null;
    private final BloomFilterStrategies.BitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: renamed from: com.google.common.hash.BloomFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> r2) {
            this.data = BloomFilter.access$000(r2).data;
            this.numHashFunctions = BloomFilter.access$100(r2);
            this.funnel = BloomFilter.access$200(r2);
            this.strategy = BloomFilter.access$300(r2);
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }

    interface Strategy extends Serializable {
        <T> boolean mightContain(T r1, Funnel<? super T> r2, int r3, BloomFilterStrategies.BitArray r4);

        int ordinal();

        <T> boolean put(T r1, Funnel<? super T> r2, int r3, BloomFilterStrategies.BitArray r4);
    }

    /* synthetic */ BloomFilter(BloomFilterStrategies.BitArray r1, int r2, Funnel r3, Strategy r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ BloomFilterStrategies.BitArray access$000(BloomFilter r0) {
        return r0.bits;
    }

    static /* synthetic */ int access$100(BloomFilter r0) {
        return r0.numHashFunctions;
    }

    static /* synthetic */ Funnel access$200(BloomFilter r0) {
        return r0.funnel;
    }

    static /* synthetic */ Strategy access$300(BloomFilter r0) {
        return r0.strategy;
    }

    private BloomFilter(BloomFilterStrategies.BitArray r6, int r7, Funnel<? super T> r8, Strategy r9) {
        if (r7 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "numHashFunctions (%s) must be > 0", new Object[]{Integer.valueOf(r7)});
        if (r7 > 255) goto L9;
        boolean r3 = true;
    L10:
        Preconditions.checkArgument(r3, "numHashFunctions (%s) must be <= 255", new Object[]{Integer.valueOf(r7)});
        this.bits = (BloomFilterStrategies.BitArray) Preconditions.checkNotNull(r6);
        this.numHashFunctions = r7;
        this.funnel = (Funnel) Preconditions.checkNotNull(r8);
        this.strategy = (Strategy) Preconditions.checkNotNull(r9);
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public BloomFilter<T> copy() {
        return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(T r4) {
        return this.strategy.mightContain(r4, this.funnel, this.numHashFunctions, this.bits);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T r1) {
        return mightContain(r1);
    }

    public boolean put(T r4) {
        return this.strategy.put(r4, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    long bitSize() {
        return this.bits.bitSize();
    }

    public boolean isCompatible(BloomFilter<T> r5) {
        Preconditions.checkNotNull(r5);
        if (this != r5) goto L5;
    L13:
        return false;
    L5:
        if (this.numHashFunctions != r5.numHashFunctions) goto L13;
        if (bitSize() != r5.bitSize()) goto L13;
        if (this.strategy.equals(r5.strategy) == false) goto L13;
        if (this.funnel.equals(r5.funnel) == false) goto L13;
        return true;
    }

    public void putAll(BloomFilter<T> r8) {
        Preconditions.checkNotNull(r8);
        if (this == r8) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Cannot combine a BloomFilter with itself.");
        int r3 = this.numHashFunctions;
        if (r3 != r8.numHashFunctions) goto L9;
        boolean r4 = true;
    L10:
        Preconditions.checkArgument(r4, "BloomFilters must have the same number of hash functions (%s != %s)", new Object[]{Integer.valueOf(r3), Integer.valueOf(r8.numHashFunctions)});
        if (bitSize() != r8.bitSize()) goto L13;
        boolean r5 = true;
    L14:
        Preconditions.checkArgument(r5, "BloomFilters must have the same size underlying bit arrays (%s != %s)", new Object[]{Long.valueOf(bitSize()), Long.valueOf(r8.bitSize())});
        Preconditions.checkArgument(this.strategy.equals(r8.strategy), "BloomFilters must have equal strategies (%s != %s)", new Object[]{this.strategy, r8.strategy});
        Preconditions.checkArgument(this.funnel.equals(r8.funnel), "BloomFilters must have equal funnels (%s != %s)", new Object[]{this.funnel, r8.funnel});
        this.bits.putAll(r8.bits);
        return;
    L13:
        r5 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof BloomFilter) == false) goto L18;
        BloomFilter r6 = (BloomFilter) r5;
        if (this.numHashFunctions != r6.numHashFunctions) goto L17;
        if (this.funnel.equals(r6.funnel) == false) goto L17;
        if (this.bits.equals(r6.bits) == false) goto L17;
        if (this.strategy.equals(r6.strategy) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    static {
        DEFAULT_STRATEGY = BloomFilterStrategies.MURMUR128_MITZ_64;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r1, int r2, double r3) {
        return create(r1, r2, r3, DEFAULT_STRATEGY);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> r5, int r6, double r7, Strategy r9) {
        Preconditions.checkNotNull(r5);
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Expected insertions (%s) must be >= 0", new Object[]{Integer.valueOf(r6)});
        if (r7 <= 0.0d) goto L9;
        boolean r3 = true;
    L10:
        Preconditions.checkArgument(r3, "False positive probability (%s) must be > 0.0", new Object[]{Double.valueOf(r7)});
        if (r7 >= 1.0d) goto L13;
        boolean r4 = true;
    L14:
        Preconditions.checkArgument(r4, "False positive probability (%s) must be < 1.0", new Object[]{Double.valueOf(r7)});
        Preconditions.checkNotNull(r9);
        if (r6 != 0) goto L17;
        r6 = 1;
    L17:
        long r0 = r6;
        long r8 = optimalNumOfBits(r0, r7);
        return new BloomFilter(new BloomFilterStrategies.BitArray(r8), optimalNumOfHashFunctions(r0, r8), r5, r9);
    L20:
        e = move-exception;
        throw new IllegalArgumentException("Could not create BloomFilter of " + r8 + " bits", e);
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, int r3) {
        return create(r2, r3, 0.03d);
    }

    static int optimalNumOfHashFunctions(long r0, long r2) {
        return Math.max(1, (int) Math.round((r2 / r0) * Math.log(2.0d)));
    }

    static long optimalNumOfBits(long r2, double r4) {
        if (r4 != 0.0d) goto L6;
        r4 = Double.MIN_VALUE;
    L6:
        return (long) (((-r2) * Math.log(r4)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    public void writeTo(OutputStream r5) throws IOException {
        DataOutputStream r0 = new DataOutputStream(r5);
        r0.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        r0.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        r0.writeInt(this.bits.data.length);
        long[] r4 = this.bits.data;
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0.writeLong(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public static <T> BloomFilter<T> readFrom(InputStream r9, Funnel<T> r10) throws IOException {
        Preconditions.checkNotNull(r9, "InputStream");
        Preconditions.checkNotNull(r10, "Funnel");
        int r0 = -1;
        DataInputStream r1 = new DataInputStream(r9);     // Catch: RuntimeException -> L14
        byte r11 = r1.readByte();     // Catch: RuntimeException -> L14
        int r2 = UnsignedBytes.toInt(r1.readByte());     // Catch: RuntimeException -> L12
        r0 = r1.readInt();     // Catch: RuntimeException -> L10
        BloomFilterStrategies r3 = BloomFilterStrategies.values()[r11];     // Catch: RuntimeException -> L10
        long[] r4 = new long[r0];     // Catch: RuntimeException -> L10
        int r5 = 0;
    L6:
        if (r5 >= r0) goto L8;
        r4[r5] = r1.readLong();     // Catch: RuntimeException -> L10
        r5 = r5 + 1;     // Catch: RuntimeException -> L10
        goto L6
    L8:
        return new BloomFilter(new BloomFilterStrategies.BitArray(r4), r2, r10, r3);
    L10:
        e = e;
        int r8 = r0;
        r0 = r11;
        int r12 = r8;
    L16:
        IOException r6 = new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + r0 + " numHashFunctions: " + r2 + " dataLength: " + r12);
        r6.initCause(e);
        throw r6;
    L12:
        e = e;
        r2 = -1;
        r0 = r11;
        r12 = -1;
    L14:
        e = e;
        r12 = -1;
        r2 = -1;
        goto L16
    }
}
