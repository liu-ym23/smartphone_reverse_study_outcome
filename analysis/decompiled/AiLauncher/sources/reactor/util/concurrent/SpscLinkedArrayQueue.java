package reactor.util.concurrent;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.BiPredicate;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class SpscLinkedArrayQueue<T> extends AbstractQueue<T> implements BiPredicate<T, T> {
    AtomicReferenceArray<Object> consumerArray;
    volatile long consumerIndex;
    final int mask;
    AtomicReferenceArray<Object> producerArray;
    volatile long producerIndex;
    static final AtomicLongFieldUpdater<SpscLinkedArrayQueue> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscLinkedArrayQueue.class, "producerIndex");
    static final AtomicLongFieldUpdater<SpscLinkedArrayQueue> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscLinkedArrayQueue.class, "consumerIndex");
    static final Object NEXT = new Object();

    public SpscLinkedArrayQueue(int i10) {
        int iCeilingNextPowerOfTwo = Queues.ceilingNextPowerOfTwo(Math.max(8, i10));
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iCeilingNextPowerOfTwo + 1);
        this.consumerArray = atomicReferenceArray;
        this.producerArray = atomicReferenceArray;
        this.mask = iCeilingNextPowerOfTwo - 1;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t10) {
        Objects.requireNonNull(t10);
        long j10 = this.producerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerArray;
        int i10 = this.mask;
        long j11 = 1 + j10;
        if (atomicReferenceArray.get(((int) j11) & i10) != null) {
            int i11 = ((int) j10) & i10;
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i10 + 2);
            this.producerArray = atomicReferenceArray2;
            atomicReferenceArray2.lazySet(i11, t10);
            atomicReferenceArray.lazySet(i10 + 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i11, NEXT);
            PRODUCER_INDEX.lazySet(this, j11);
        } else {
            atomicReferenceArray.lazySet(((int) j10) & i10, t10);
            PRODUCER_INDEX.lazySet(this, j11);
        }
        return true;
    }

    @Override // java.util.Queue
    @Nullable
    public T peek() {
        long j10 = this.consumerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerArray;
        int i10 = this.mask;
        int i11 = ((int) j10) & i10;
        T t10 = (T) atomicReferenceArray.get(i11);
        if (t10 == null) {
            return null;
        }
        return t10 == NEXT ? (T) ((AtomicReferenceArray) atomicReferenceArray.get(i10 + 1)).get(i11) : t10;
    }

    @Override // java.util.Queue
    @Nullable
    public T poll() {
        long j10 = this.consumerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerArray;
        int i10 = this.mask;
        int i11 = ((int) j10) & i10;
        T t10 = (T) atomicReferenceArray.get(i11);
        if (t10 == null) {
            return null;
        }
        if (t10 == NEXT) {
            int i12 = i10 + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i12);
            atomicReferenceArray.lazySet(i12, null);
            Object obj = atomicReferenceArray2.get(i11);
            this.consumerArray = atomicReferenceArray2;
            t10 = (T) obj;
            atomicReferenceArray = atomicReferenceArray2;
        }
        atomicReferenceArray.lazySet(i11, null);
        CONSUMER_INDEX.lazySet(this, j10 + 1);
        return t10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long j10 = this.consumerIndex;
        while (true) {
            long j11 = this.producerIndex;
            long j12 = this.consumerIndex;
            if (j10 == j12) {
                return (int) (j11 - j10);
            }
            j10 = j12;
        }
    }

    @Override // java.util.function.BiPredicate
    public boolean test(T t10, T t11) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerArray;
        long j10 = this.producerIndex;
        int i10 = this.mask;
        long j11 = 2 + j10;
        if (atomicReferenceArray.get(((int) j11) & i10) != null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i10 + 2);
            this.producerArray = atomicReferenceArray2;
            int i11 = ((int) j10) & i10;
            atomicReferenceArray2.lazySet(i11 + 1, t11);
            atomicReferenceArray2.lazySet(i11, t10);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i11, NEXT);
            PRODUCER_INDEX.lazySet(this, j11);
        } else {
            int i12 = ((int) j10) & i10;
            atomicReferenceArray.lazySet(i12 + 1, t11);
            atomicReferenceArray.lazySet(i12, t10);
            PRODUCER_INDEX.lazySet(this, j11);
        }
        return true;
    }
}
