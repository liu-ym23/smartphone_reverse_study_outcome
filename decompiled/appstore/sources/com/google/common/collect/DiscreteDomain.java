package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    /* JADX INFO: renamed from: com.google.common.collect.DiscreteDomain$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        private static final BigIntegerDomain INSTANCE = null;
        private static final BigInteger MAX_LONG = null;
        private static final BigInteger MIN_LONG = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new BigIntegerDomain();
            MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
            MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        }

        public BigIntegerDomain() {
            super(true, null);
        }

        public static /* synthetic */ BigIntegerDomain access$300() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r10, Comparable r11) {
            return distance((BigInteger) r10, (BigInteger) r11);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable next(Comparable r10) {
            return next((BigInteger) r10);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable offset(Comparable r10, long r11) {
            return offset((BigInteger) r10, r11);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r10) {
            return previous((BigInteger) r10);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        public long distance(BigInteger r10, BigInteger r11) {
            return r11.subtract(r10).max(MIN_LONG).min(MAX_LONG).longValue();
        }

        public BigInteger next(BigInteger r10) {
            return r10.add(BigInteger.ONE);
        }

        public BigInteger offset(BigInteger r10, long r11) {
            CollectPreconditions.checkNonnegative(r11, "distance");
            return r10.add(BigInteger.valueOf(r11));
        }

        public BigInteger previous(BigInteger r10) {
            return r10.subtract(BigInteger.ONE);
        }
    }

    public static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        private static final IntegerDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new IntegerDomain();
        }

        public IntegerDomain() {
            super(true, null);
        }

        public static /* synthetic */ IntegerDomain access$000() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r10, Comparable r11) {
            return distance((Integer) r10, (Integer) r11);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable next(Comparable r10) {
            return next((Integer) r10);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable offset(Comparable r10, long r11) {
            return offset((Integer) r10, r11);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r10) {
            return previous((Integer) r10);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        public long distance(Integer r10, Integer r11) {
            return ((long) r11.intValue()) - ((long) r10.intValue());
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.valueOf(Channel.UNLIMITED);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        public Integer next(Integer r10) {
            int r11 = r10.intValue();
            if (r11 != Integer.MAX_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r11 + 1);
        }

        public Integer offset(Integer r10, long r11) {
            CollectPreconditions.checkNonnegative(r11, "distance");
            return Integer.valueOf(Ints.checkedCast(r10.longValue() + r11));
        }

        public Integer previous(Integer r10) {
            int r11 = r10.intValue();
            if (r11 != Integer.MIN_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r11 - 1);
        }
    }

    public static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        private static final LongDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new LongDomain();
        }

        public LongDomain() {
            super(true, null);
        }

        public static /* synthetic */ LongDomain access$200() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r10, Comparable r11) {
            return distance((Long) r10, (Long) r11);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable next(Comparable r10) {
            return next((Long) r10);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable offset(Comparable r10, long r11) {
            return offset((Long) r10, r11);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r10) {
            return previous((Long) r10);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        public long distance(Long r10, Long r11) {
            long r12 = r11.longValue() - r10.longValue();
            if (r11.longValue() <= r10.longValue()) goto L9;
            if (r12 >= 0) goto L9;
            return Long.MAX_VALUE;
        L9:
            if (r11.longValue() < r10.longValue()) goto L11;
        L14:
            return r12;
        L11:
            if (r12 <= 0) goto L14;
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        public Long next(Long r10) {
            long r11 = r10.longValue();
            if (r11 != Long.MAX_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r11 + 1);
        }

        public Long offset(Long r10, long r11) {
            CollectPreconditions.checkNonnegative(r11, "distance");
            long r12 = r10.longValue() + r11;
            if (r12 >= 0) goto L10;
            if (r10.longValue() >= 0) goto L7;
            boolean r13 = true;
        L8:
            Preconditions.checkArgument(r13, "overflow");
            goto L10
        L7:
            r13 = false;
        L10:
            return Long.valueOf(r12);
        }

        public Long previous(Long r10) {
            long r11 = r10.longValue();
            if (r11 != Long.MIN_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r11 - 1);
        }
    }

    public /* synthetic */ DiscreteDomain(boolean r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.access$300();
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.access$000();
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.access$200();
    }

    public abstract long distance(C r10, C r11);

    @CanIgnoreReturnValue
    public C maxValue() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C minValue() {
        throw new NoSuchElementException();
    }

    public abstract C next(C r10);

    public C offset(C r10, long r11) {
        CollectPreconditions.checkNonnegative(r11, "distance");
        long r12 = 0;
    L4:
        if (r12 >= r11) goto L6;
        r10 = (C) next(r10);
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    public abstract C previous(C r10);

    public DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean r10) {
        this.supportsFastOffset = r10;
    }
}
