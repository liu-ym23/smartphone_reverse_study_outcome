package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = null;
    private static final Supplier<ReadWriteLock> WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = null;

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        public /* synthetic */ CompactStriped(int r10, Supplier r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r10) {
            return (L) this.array[r10];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }

        private CompactStriped(int r10, Supplier<L> r11) {
            super(r10);
            int r12 = 0;
            if (r10 > 1073741824) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
        L7:
            Object[] r14 = this.array;
            if (r12 >= r14.length) goto L10;
            r14[r12] = r11.get();
            r12 = r12 + 1;
            goto L7
        L10:
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        public LargeLazyStriped(int r10, Supplier<L> r11) {
            super(r10);
            int r12 = this.mask;
            if (r12 != (-1)) goto L5;
            int r13 = Channel.UNLIMITED;
        L6:
            this.size = r13;
            this.supplier = r11;
            this.locks = new MapMaker().weakValues().makeMap();
            return;
        L5:
            r13 = r12 + 1;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r10) {
            if (this.size == Integer.MAX_VALUE) goto L5;
            Preconditions.checkElementIndex(r10, size());
        L5:
            L r11 = this.locks.get(Integer.valueOf(r10));
            if (r11 == null) goto L8;
            return r11;
        L8:
            L r12 = this.supplier.get();
            return (L) MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(r10), r12), r12);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int r10) {
            super(r10, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        public PowerOfTwoStriped(int r10) {
            super(null);
            if (r10 <= 0) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "Stripes must be positive");
            if (r10 <= 1073741824) goto L9;
            int r12 = -1;
        L10:
            this.mask = r12;
            return;
        L9:
            r12 = Striped.access$200(r10) - 1;
            goto L10
        L5:
            r11 = false;
            goto L6
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object r10) {
            return getAt(indexFor(r10));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int indexFor(Object r10) {
            int r11 = Striped.access$300(r10.hashCode());
            return this.mask & r11;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final Supplier<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            public ArrayReference(L r10, int r11, ReferenceQueue<L> r12) {
                super(r10, r12);
                this.index = r11;
            }
        }

        public SmallLazyStriped(int r10, Supplier<L> r11) {
            super(r10);
            this.queue = new ReferenceQueue();
            int r12 = this.mask;
            if (r12 != (-1)) goto L5;
            int r13 = Channel.UNLIMITED;
        L6:
            this.size = r13;
            this.locks = new AtomicReferenceArray(r13);
            this.supplier = r11;
            return;
        L5:
            r13 = r12 + 1;
            goto L6
        }

        private void drainQueue() {
        L2:
            Reference<? extends L> r10 = this.queue.poll();
            if (r10 == null) goto L5;
            ArrayReference r11 = (ArrayReference) r10;
            b.a(this.locks, r11.index, r11, null);
            goto L2
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int r10) {
            if (this.size == Integer.MAX_VALUE) goto L5;
            Preconditions.checkElementIndex(r10, size());
        L5:
            ArrayReference<? extends L> r11 = this.locks.get(r10);
            if (r11 != null) goto L8;
            L r12 = null;
        L9:
            if (r12 == null) goto L11;
            return r12;
        L11:
            L r13 = this.supplier.get();
            ArrayReference r14 = new ArrayReference(r13, r10, this.queue);
        L13:
            if (b.a(this.locks, r10, r11, r14) == true) goto L20;
            r11 = this.locks.get(r10);
            if (r11 != null) goto L17;
            L r15 = null;
        L18:
            if (r15 == null) goto L13;
            return r15;
        L17:
            r15 = r11.get();
            goto L18
        L20:
            drainQueue();
            return r13;
        L8:
            r12 = r11.get();
            goto L9
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition r10, WeakSafeReadWriteLock r11) {
            this.delegate = r10;
            this.strongReference = r11;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock r10, WeakSafeReadWriteLock r11) {
            this.delegate = r10;
            this.strongReference = r11;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public Lock delegate() {
            return this.delegate;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate;

        public WeakSafeReadWriteLock() {
            this.delegate = new ReentrantReadWriteLock();
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    static {
        READ_WRITE_LOCK_SUPPLIER = new AnonymousClass5();
        WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = new AnonymousClass6();
    }

    public /* synthetic */ Striped(AnonymousClass1 r10) {
        this();
    }

    public static /* synthetic */ int access$200(int r10) {
        return ceilToPowerOfTwo(r10);
    }

    public static /* synthetic */ int access$300(int r10) {
        return smear(r10);
    }

    private static int ceilToPowerOfTwo(int r10) {
        return 1 << IntMath.log2(r10, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int r10, Supplier<L> r11) {
        return new CompactStriped(r10, r11, null);
    }

    private static <L> Striped<L> lazy(int r10, Supplier<L> r11) {
        if (r10 >= 1024) goto L6;
        return new SmallLazyStriped(r10, r11);
    L6:
        return new LargeLazyStriped(r10, r11);
    }

    public static Striped<Lock> lazyWeakLock(int r10) {
        return lazy(r10, new AnonymousClass2());
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int r10) {
        return lazy(r10, WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int r10, final int r11) {
        return lazy(r10, new AnonymousClass4(r11));
    }

    public static Striped<Lock> lock(int r10) {
        return custom(r10, new AnonymousClass1());
    }

    public static Striped<ReadWriteLock> readWriteLock(int r10) {
        return custom(r10, READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> semaphore(int r10, final int r11) {
        return custom(r10, new AnonymousClass3(r11));
    }

    private static int smear(int r10) {
        int r11 = r10 ^ ((r10 >>> 20) ^ (r10 >>> 12));
        int r12 = (r11 >>> 7) ^ r11;
        return (r11 >>> 4) ^ r12;
    }

    public Iterable<L> bulkGet(Iterable<?> r10) {
        Object[] r11 = Iterables.toArray(r10, Object.class);
        if (r11.length == 0) goto L5;
        int[] r12 = new int[r11.length];
        int r13 = 0;
    L8:
        if (r13 >= r11.length) goto L10;
        r12[r13] = indexFor(r11[r13]);
        r13 = r13 + 1;
        goto L8
    L10:
        Arrays.sort(r12);
        int r14 = r12[0];
        r11[0] = getAt(r14);
        int r15 = 1;
    L12:
        if (r15 >= r11.length) goto L19;
        int r16 = r12[r15];
        if (r16 != r14) goto L16;
        r11[r15] = r11[r15 - 1];
    L17:
        r15 = r15 + 1;
        goto L12
    L16:
        r11[r15] = getAt(r16);
        r14 = r16;
        goto L17
    L19:
        return Collections.unmodifiableList(Arrays.asList(r11));
    L5:
        return ImmutableList.of();
    }

    public abstract L get(Object r10);

    public abstract L getAt(int r10);

    public abstract int indexFor(Object r10);

    public abstract int size();

    private Striped() {
    }
}
