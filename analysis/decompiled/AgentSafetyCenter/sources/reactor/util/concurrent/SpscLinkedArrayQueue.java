package reactor.util.concurrent;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.BiPredicate;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class SpscLinkedArrayQueue<T> extends AbstractQueue<T> implements BiPredicate<T, T> {
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
    public boolean offer(T t10) {
        Objects.requireNonNull(t10);
        long j10 = this.producerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerArray;
        int i = this.mask;
        long j11 = 1 + j10;
        if (atomicReferenceArray.get(((int) j11) & i) != null) {
            int i3 = ((int) j10) & i;
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i + 2);
            this.producerArray = atomicReferenceArray2;
            atomicReferenceArray2.lazySet(i3, t10);
            atomicReferenceArray.lazySet(i + 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i3, NEXT);
            PRODUCER_INDEX.lazySet(this, j11);
        } else {
            atomicReferenceArray.lazySet(((int) j10) & i, t10);
            PRODUCER_INDEX.lazySet(this, j11);
        }
        return true;
    }

    @Override // java.util.Queue
    @Nullable
    public T peek() {
        long j10 = this.consumerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerArray;
        int i = this.mask;
        int i3 = ((int) j10) & i;
        T t10 = (T) atomicReferenceArray.get(i3);
        if (t10 == null) {
            return null;
        }
        return t10 == NEXT ? (T) ((AtomicReferenceArray) atomicReferenceArray.get(i + 1)).get(i3) : t10;
    }

    @Override // java.util.Queue
    @Nullable
    public T poll() {
        long j10 = this.consumerIndex;
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerArray;
        int i = this.mask;
        int i3 = ((int) j10) & i;
        T t10 = (T) atomicReferenceArray.get(i3);
        if (t10 == null) {
            return null;
        }
        if (t10 == NEXT) {
            int i10 = i + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i10);
            atomicReferenceArray.lazySet(i10, null);
            Object obj = atomicReferenceArray2.get(i3);
            this.consumerArray = atomicReferenceArray2;
            t10 = (T) obj;
            atomicReferenceArray = atomicReferenceArray2;
        }
        atomicReferenceArray.lazySet(i3, null);
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
        int i = this.mask;
        long j11 = 2 + j10;
        if (atomicReferenceArray.get(((int) j11) & i) != null) {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i + 2);
            this.producerArray = atomicReferenceArray2;
            int i3 = ((int) j10) & i;
            atomicReferenceArray2.lazySet(i3 + 1, t11);
            atomicReferenceArray2.lazySet(i3, t10);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i3, NEXT);
            PRODUCER_INDEX.lazySet(this, j11);
        } else {
            int i10 = ((int) j10) & i;
            atomicReferenceArray.lazySet(i10 + 1, t11);
            atomicReferenceArray.lazySet(i10, t10);
            PRODUCER_INDEX.lazySet(this, j11);
        }
        return true;
    }
}
