package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DiscreteDomain<C extends Comparable> {

    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        private static final BigIntegerDomain INSTANCE = null;
        private static final BigInteger MAX_LONG = null;
        private static final BigInteger MIN_LONG = null;
        private static final long serialVersionUID = 0;

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        private BigIntegerDomain() {
        }

        static /* synthetic */ BigIntegerDomain access$200() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r1, Comparable r2) {
            return distance((BigInteger) r1, (BigInteger) r2);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable next(Comparable r1) {
            return next((BigInteger) r1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r1) {
            return previous((BigInteger) r1);
        }

        static {
            INSTANCE = new BigIntegerDomain();
            MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
            MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        }

        public BigInteger next(BigInteger r1) {
            return r1.add(BigInteger.ONE);
        }

        public BigInteger previous(BigInteger r1) {
            return r1.subtract(BigInteger.ONE);
        }

        public long distance(BigInteger r1, BigInteger r2) {
            return r2.subtract(r1).max(MIN_LONG).min(MAX_LONG).longValue();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        private static final IntegerDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        public String toString() {
            return "DiscreteDomain.integers()";
        }

        private IntegerDomain() {
        }

        static /* synthetic */ IntegerDomain access$000() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r1, Comparable r2) {
            return distance((Integer) r1, (Integer) r2);
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
        public /* bridge */ /* synthetic */ Comparable next(Comparable r1) {
            return next((Integer) r1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r1) {
            return previous((Integer) r1);
        }

        static {
            INSTANCE = new IntegerDomain();
        }

        public Integer next(Integer r1) {
            int r0 = r1.intValue();
            if (r0 != Integer.MAX_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r0 + 1);
        }

        public Integer previous(Integer r1) {
            int r0 = r1.intValue();
            if (r0 != Integer.MIN_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r0 - 1);
        }

        public long distance(Integer r3, Integer r4) {
            return ((long) r4.intValue()) - ((long) r3.intValue());
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        private static final LongDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        public String toString() {
            return "DiscreteDomain.longs()";
        }

        private LongDomain() {
        }

        static /* synthetic */ LongDomain access$100() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ long distance(Comparable r1, Comparable r2) {
            return distance((Long) r1, (Long) r2);
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
        public /* bridge */ /* synthetic */ Comparable next(Comparable r1) {
            return next((Long) r1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable previous(Comparable r1) {
            return previous((Long) r1);
        }

        static {
            INSTANCE = new LongDomain();
        }

        public Long next(Long r3) {
            long r2 = r3.longValue();
            if (r2 != Long.MAX_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r2 + 1);
        }

        public Long previous(Long r3) {
            long r2 = r3.longValue();
            if (r2 != Long.MIN_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r2 - 1);
        }

        public long distance(Long r7, Long r8) {
            long r0 = r8.longValue() - r7.longValue();
            if (r8.longValue() <= r7.longValue()) goto L9;
            if (r0 >= 0) goto L9;
            return Long.MAX_VALUE;
        L9:
            if (r8.longValue() < r7.longValue()) goto L11;
        L14:
            return r0;
        L11:
            if (r0 <= 0) goto L14;
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public abstract long distance(C r1, C r2);

    public abstract C next(C r1);

    public abstract C previous(C r1);

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.access$000();
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.access$100();
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.access$200();
    }

    protected DiscreteDomain() {
    }

    public C minValue() {
        throw new NoSuchElementException();
    }

    public C maxValue() {
        throw new NoSuchElementException();
    }
}
