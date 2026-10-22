package reactor.util.concurrent;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.BiPredicate;
import reactor.util.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class SpscLinkedArrayQueue<T> extends AbstractQueue<T> implements BiPredicate<T, T> {
    AtomicReferenceArray<Object> consumerArray;
    volatile long consumerIndex;
    final int mask;
    AtomicReferenceArray<Object> producerArray;
    volatile long producerIndex;
    static final AtomicLongFieldUpdater<SpscLinkedArrayQueue> PRODUCER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscLinkedArrayQueue.class, "producerIndex");
    static final AtomicLongFieldUpdater<SpscLinkedArrayQueue> CONSUMER_INDEX = AtomicLongFieldUpdater.newUpdater(SpscLinkedArrayQueue.class, "consumerIndex");
    static final Object NEXT = new Object();

    public SpscLinkedArrayQueue(int i) {
        int iCeilingNextPowerOfTwo = Queues.ceilingNextPowerOfTwo(Math.max(8, i));
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
    public boolean offer(T t9) {
        Objects.requireNonNull(t9);
        long j5 = this.producerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerArray;
        int i = this.mask;
        long j6 = 1 + j5;
        if (atomicReferenceArray.get(((int) j6) & i) != null) {
            int i6 = ((int) j5) & i;
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i + 2);
            this.producerArray = atomicReferenceArray2;
            atomicReferenceArray2.lazySet(i6, t9);
            atomicReferenceArray.lazySet(i + 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i6, NEXT);
            PRODUCER_INDEX.lazySet(this, j6);
        } else {
            atomicReferenceArray.lazySet(((int) j5) & i, t9);
            PRODUCER_INDEX.lazySet(this, j6);
        }
        return true;
    }

    @Override // java.util.Queue
    @Nullable
    public T peek() {
        long j5 = this.consumerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerArray;
        int i = this.mask;
        int i6 = ((int) j5) & i;
        T t9 = (T) atomicReferenceArray.get(i6);
        if (t9 == null) {
            return null;
        }
        return t9 == NEXT ? (T) ((AtomicReferenceArray) atomicReferenceArray.get(i + 1)).get(i6) : t9;
    }

    @Override // java.util.Queue
    @Nullable
    public T poll() {
        long j5 = this.consumerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerArray;
        int i = this.mask;
        int i6 = ((int) j5) & i;
        T t9 = (T) atomicReferenceArray.get(i6);
        if (t9 == null) {
            return null;
        }
        if (t9 == NEXT) {
            int i10 = i + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i10);
            atomicReferenceArray.lazySet(i10, null);
            Object obj = atomicReferenceArray2.get(i6);
            this.consumerArray = atomicReferenceArray2;
            t9 = (T) obj;
            atomicReferenceArray = atomicReferenceArray2;
        }
        atomicReferenceArray.lazySet(i6, null);
        CONSUMER_INDEX.lazySet(this, j5 + 1);
        return t9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long j5 = this.consumerIndex;
        while (true) {
            long j6 = this.producerIndex;
            long j10 = this.consumerIndex;
            if (j5 == j10) {
                return (int) (j6 - j5);
            }
            j5 = j10;
        }
    }

    @Override // java.util.function.BiPredicate
    public boolean test(T t9, T t10) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerArray;
        long j5 = this.producerIndex;
        int i = this.mask;
        long j6 = 2 + j5;
        if (atomicReferenceArray.get(((int) j6) & i) != null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i + 2);
            this.producerArray = atomicReferenceArray2;
            int i6 = ((int) j5) & i;
            atomicReferenceArray2.lazySet(i6 + 1, t10);
            atomicReferenceArray2.lazySet(i6, t9);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i6, NEXT);
            PRODUCER_INDEX.lazySet(this, j6);
        } else {
            int i10 = ((int) j5) & i;
            atomicReferenceArray.lazySet(i10 + 1, t10);
            atomicReferenceArray.lazySet(i10, t9);
            PRODUCER_INDEX.lazySet(this, j6);
        }
        return true;
    }
}
