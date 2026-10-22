package com.google.common.util.concurrent;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = null;

    private static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        /* synthetic */ CompactStriped(int r1, Supplier r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private CompactStriped(int r4, Supplier<L> r5) {
            super(r4);
            int r1 = 0;
            if (r4 > 1073741824) goto L5;
            boolean r6 = true;
        L6:
            Preconditions.checkArgument(r6, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
        L7:
            Object[] r7 = this.array;
            if (r1 >= r7.length) goto L10;
            r7[r1] = r5.get();
            r1 = r1 + 1;
            goto L7
        L10:
            return;
        L5:
            r6 = false;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r1) {
            return (L) this.array[r1];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }
    }

    static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        LargeLazyStriped(int r2, Supplier<L> r3) {
            super(r2);
            if (this.mask != (-1)) goto L5;
            int r4 = Integer.MAX_VALUE;
        L6:
            this.size = r4;
            this.supplier = r3;
            this.locks = (ConcurrentMap<Integer, L>) new MapMaker().weakValues2().makeMap();
            return;
        L5:
            r4 = this.mask + 1;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r3) {
            if (this.size == Integer.MAX_VALUE) goto L5;
            Preconditions.checkElementIndex(r3, size());
        L5:
            L r0 = this.locks.get(Integer.valueOf(r3));
            if (r0 == null) goto L8;
            return r0;
        L8:
            L r1 = this.supplier.get();
            return (L) MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(r3), r1), r1);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    private static class PaddedLock extends ReentrantLock {
        long q1;
        long q2;
        long q3;

        PaddedLock() {
            super(false);
        }
    }

    private static class PaddedSemaphore extends Semaphore {
        long q1;
        long q2;
        long q3;

        PaddedSemaphore(int r2) {
            super(r2, false);
        }
    }

    private static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        PowerOfTwoStriped(int r4) {
            super(null);
            if (r4 <= 0) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkArgument(r1, "Stripes must be positive");
            if (r4 <= 1073741824) goto L9;
            int r5 = -1;
        L10:
            this.mask = r5;
            return;
        L9:
            r5 = Striped.access$200(r4) - 1;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        final int indexFor(Object r1) {
            int r2 = Striped.access$300(r1.hashCode());
            return this.mask & r2;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object r1) {
            return getAt(indexFor(r1));
        }
    }

    static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final Supplier<L> supplier;

        private static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            ArrayReference(L r1, int r2, ReferenceQueue<L> r3) {
                super(r1, r3);
                this.index = r2;
            }
        }

        SmallLazyStriped(int r2, Supplier<L> r3) {
            super(r2);
            this.queue = new ReferenceQueue();
            if (this.mask != (-1)) goto L5;
            int r4 = Integer.MAX_VALUE;
        L6:
            this.size = r4;
            this.locks = new AtomicReferenceArray(r4);
            this.supplier = r3;
            return;
        L5:
            r4 = this.mask + 1;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r6) {
            if (this.size == Integer.MAX_VALUE) goto L5;
            Preconditions.checkElementIndex(r6, size());
        L5:
            ArrayReference<? extends L> r0 = this.locks.get(r6);
            if (r0 != null) goto L8;
            L r2 = null;
        L9:
            if (r2 == null) goto L11;
            return r2;
        L11:
            L r3 = this.supplier.get();
            ArrayReference r4 = new ArrayReference(r3, r6, this.queue);
        L13:
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.locks, r6, r0, r4) == true) goto L20;
            r0 = this.locks.get(r6);
            if (r0 != null) goto L17;
            L r5 = null;
        L18:
            if (r5 == null) goto L13;
            return r5;
        L17:
            r5 = (L) r0.get();
            goto L18
        L20:
            drainQueue();
            return r3;
        L8:
            r2 = (L) r0.get();
            goto L9
        }

        private void drainQueue() {
        L2:
            Reference<? extends L> r0 = this.queue.poll();
            if (r0 == null) goto L5;
            ArrayReference r1 = (ArrayReference) r0;
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.locks, r1.index, r1, null);
            goto L2
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    private static int smear(int r2) {
        int r3 = r2 ^ ((r2 >>> 20) ^ (r2 >>> 12));
        int r0 = (r3 >>> 7) ^ r3;
        return (r3 >>> 4) ^ r0;
    }

    public abstract L get(Object r1);

    public abstract L getAt(int r1);

    abstract int indexFor(Object r1);

    public abstract int size();

    /* synthetic */ Striped(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ int access$200(int r0) {
        return ceilToPowerOfTwo(r0);
    }

    static /* synthetic */ int access$300(int r0) {
        return smear(r0);
    }

    private Striped() {
    }

    public Iterable<L> bulkGet(Iterable<?> r5) {
        Object[] r6 = Iterables.toArray(r5, Object.class);
        if (r6.length == 0) goto L5;
        int[] r0 = new int[r6.length];
        int r2 = 0;
    L8:
        if (r2 >= r6.length) goto L10;
        r0[r2] = indexFor(r6[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        Arrays.sort(r0);
        int r3 = r0[0];
        r6[0] = getAt(r3);
        int r1 = 1;
    L12:
        if (r1 >= r6.length) goto L19;
        int r4 = r0[r1];
        if (r4 != r3) goto L16;
        r6[r1] = r6[r1 - 1];
    L17:
        r1 = r1 + 1;
        goto L12
    L16:
        r6[r1] = getAt(r4);
        r3 = r4;
        goto L17
    L19:
        return Collections.unmodifiableList(Arrays.asList(r6));
    L5:
        return ImmutableList.of();
    }

    public static Striped<Lock> lock(int r3) {
        return new CompactStriped(r3, new AnonymousClass1(), null);
    }

    public static Striped<Lock> lazyWeakLock(int r1) {
        return lazy(r1, new AnonymousClass2());
    }

    private static <L> Striped<L> lazy(int r1, Supplier<L> r2) {
        if (r1 >= 1024) goto L6;
        return new SmallLazyStriped(r1, r2);
    L6:
        return new LargeLazyStriped(r1, r2);
    }

    public static Striped<Semaphore> semaphore(int r2, final int r3) {
        return new CompactStriped(r2, new AnonymousClass3(r3), null);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int r1, final int r2) {
        return lazy(r1, new AnonymousClass4(r2));
    }

    public static Striped<ReadWriteLock> readWriteLock(int r3) {
        return new CompactStriped(r3, READ_WRITE_LOCK_SUPPLIER, null);
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int r1) {
        return lazy(r1, READ_WRITE_LOCK_SUPPLIER);
    }

    static {
        READ_WRITE_LOCK_SUPPLIER = new AnonymousClass5();
    }

    private static int ceilToPowerOfTwo(int r1) {
        return 1 << IntMath.log2(r1, RoundingMode.CEILING);
    }
}
