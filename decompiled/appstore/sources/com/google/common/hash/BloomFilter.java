package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: renamed from: com.google.common.hash.BloomFilter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        public SerialForm(BloomFilter<T> r10) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(BloomFilter.access$000(r10).data);
            this.numHashFunctions = BloomFilter.access$100(r10);
            this.funnel = BloomFilter.access$200(r10);
            this.strategy = BloomFilter.access$300(r10);
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(T r10, Funnel<? super T> r11, int r12, BloomFilterStrategies.LockFreeBitArray r13);

        int ordinal();

        <T> boolean put(T r10, Funnel<? super T> r11, int r12, BloomFilterStrategies.LockFreeBitArray r13);
    }

    public /* synthetic */ BloomFilter(BloomFilterStrategies.LockFreeBitArray r10, int r11, Funnel r12, Strategy r13, AnonymousClass1 r14) {
        this(r10, r11, r12, r13);
    }

    public static /* synthetic */ BloomFilterStrategies.LockFreeBitArray access$000(BloomFilter r10) {
        return r10.bits;
    }

    public static /* synthetic */ int access$100(BloomFilter r10) {
        return r10.numHashFunctions;
    }

    public static /* synthetic */ Funnel access$200(BloomFilter r10) {
        return r10.funnel;
    }

    public static /* synthetic */ Strategy access$300(BloomFilter r10) {
        return r10.strategy;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r10, int r11, double r12) {
        return create(r10, r11, r12);
    }

    @VisibleForTesting
    public static long optimalNumOfBits(long r10, double r11) {
        if (r11 != 0.0d) goto L6;
        r11 = Double.MIN_VALUE;
    L6:
        return (long) (((-r10) * Math.log(r11)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    public static int optimalNumOfHashFunctions(long r10, long r11) {
        return Math.max(1, (int) Math.round((r11 / r10) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream r10, Funnel<? super T> r11) throws IOException {
        Preconditions.checkNotNull(r10, "InputStream");
        Preconditions.checkNotNull(r11, "Funnel");
        int r12 = -1;
        DataInputStream r13 = new DataInputStream(r10);     // Catch: RuntimeException -> L14
        byte r14 = r13.readByte();     // Catch: RuntimeException -> L14
        int r15 = UnsignedBytes.toInt(r13.readByte());     // Catch: RuntimeException -> L12
        r12 = r13.readInt();     // Catch: RuntimeException -> L8
        BloomFilterStrategies r16 = BloomFilterStrategies.values()[r14];     // Catch: RuntimeException -> L8
        long[] r17 = new long[r12];     // Catch: RuntimeException -> L8
        int r18 = 0;
    L6:
        if (r18 >= r12) goto L10;
        r17[r18] = r13.readLong();     // Catch: RuntimeException -> L8
        r18 = r18 + 1;     // Catch: RuntimeException -> L8
        goto L6
    L10:
        return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(r17), r15, r11, r16);
    L8:
        e = e;
        int r19 = r12;
        r12 = r14;
        int r20 = r19;
    L17:
        throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + r12 + " numHashFunctions: " + r15 + " dataLength: " + r20, e);
    L12:
        e = e;
        r15 = -1;
        r12 = r14;
        r20 = -1;
    L14:
        e = e;
        r20 = -1;
        r15 = -1;
        goto L17
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T r10) {
        return mightContain(r10);
    }

    public long approximateElementCount() {
        double r10 = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.bitCount() / r10))) * r10) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    @VisibleForTesting
    public long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof BloomFilter) == false) goto L18;
        BloomFilter r11 = (BloomFilter) r10;
        if (this.numHashFunctions != r11.numHashFunctions) goto L17;
        if (this.funnel.equals(r11.funnel) == false) goto L17;
        if (this.bits.equals(r11.bits) == false) goto L17;
        if (this.strategy.equals(r11.strategy) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    public boolean isCompatible(BloomFilter<T> r10) {
        Preconditions.checkNotNull(r10);
        if (this != r10) goto L5;
    L13:
        return false;
    L5:
        if (this.numHashFunctions != r10.numHashFunctions) goto L13;
        if (bitSize() != r10.bitSize()) goto L13;
        if (this.strategy.equals(r10.strategy) == false) goto L13;
        if (this.funnel.equals(r10.funnel) == false) goto L13;
        return true;
    }

    public boolean mightContain(T r10) {
        return this.strategy.mightContain(r10, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(T r10) {
        return this.strategy.put(r10, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> r10) {
        Preconditions.checkNotNull(r10);
        if (this == r10) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "Cannot combine a BloomFilter with itself.");
        int r12 = this.numHashFunctions;
        int r13 = r10.numHashFunctions;
        if (r12 != r13) goto L9;
        boolean r14 = true;
    L10:
        Preconditions.checkArgument(r14, "BloomFilters must have the same number of hash functions (%s != %s)", r12, r13);
        if (bitSize() != r10.bitSize()) goto L13;
        boolean r15 = true;
    L14:
        Preconditions.checkArgument(r15, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), r10.bitSize());
        Preconditions.checkArgument(this.strategy.equals(r10.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, r10.strategy);
        Preconditions.checkArgument(this.funnel.equals(r10.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, r10.funnel);
        this.bits.putAll(r10.bits);
        return;
    L13:
        r15 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    public void writeTo(OutputStream r10) throws IOException {
        DataOutputStream r11 = new DataOutputStream(r10);
        r11.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        r11.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        r11.writeInt(this.bits.data.length());
        int r12 = 0;
    L4:
        if (r12 >= this.bits.data.length()) goto L6;
        r11.writeLong(this.bits.data.get(r12));
        r12 = r12 + 1;
        goto L4
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray r10, int r11, Funnel<? super T> r12, Strategy r13) {
        boolean r14 = false;
        if (r11 <= 0) goto L5;
        boolean r15 = true;
    L6:
        Preconditions.checkArgument(r15, "numHashFunctions (%s) must be > 0", r11);
        if (r11 > 255) goto L9;
        r14 = true;
    L9:
        Preconditions.checkArgument(r14, "numHashFunctions (%s) must be <= 255", r11);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(r10);
        this.numHashFunctions = r11;
        this.funnel = (Funnel) Preconditions.checkNotNull(r12);
        this.strategy = (Strategy) Preconditions.checkNotNull(r13);
        return;
    L5:
        r15 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r10, long r11, double r12) {
        return create(r10, r11, r12, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    public static <T> BloomFilter<T> create(Funnel<? super T> r10, long r11, double r12, Strategy r13) {
        Preconditions.checkNotNull(r10);
        boolean r14 = false;
        if (r11 < 0) goto L5;
        boolean r15 = true;
    L6:
        Preconditions.checkArgument(r15, "Expected insertions (%s) must be >= 0", r11);
        if (r12 <= 0.0d) goto L9;
        boolean r16 = true;
    L10:
        Preconditions.checkArgument(r16, "False positive probability (%s) must be > 0.0", Double.valueOf(r12));
        if (r12 >= 1.0d) goto L13;
        r14 = true;
    L13:
        Preconditions.checkArgument(r14, "False positive probability (%s) must be < 1.0", Double.valueOf(r12));
        Preconditions.checkNotNull(r13);
        if (r11 != 0) goto L16;
        r11 = 1;
    L16:
        long r17 = optimalNumOfBits(r11, r12);
        return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(r17), optimalNumOfHashFunctions(r11, r17), r10, r13);
    L19:
        e = move-exception;
        throw new IllegalArgumentException("Could not create BloomFilter of " + r17 + " bits", e);
    L9:
        r16 = false;
        goto L10
    L5:
        r15 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r10, int r11) {
        return create(r10, r11);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r10, long r11) {
        return create(r10, r11, 0.03d);
    }
}
