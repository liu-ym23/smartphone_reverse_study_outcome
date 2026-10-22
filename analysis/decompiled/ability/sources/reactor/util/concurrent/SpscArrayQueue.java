package reactor.util.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import reactor.util.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class SpscArrayQueue<T> extends SpscArrayQueueP3<T> implements Queue<T> {
    private static final long serialVersionUID = 494623116936946976L;

    public SpscArrayQueue(int i) {
        super(Queues.ceilingNextPowerOfTwo(i));
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t9) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t9) {
        Objects.requireNonNull(t9, "e");
        long j5 = this.producerIndex;
        int i = ((int) j5) & this.mask;
        if (get(i) != null) {
            return false;
        }
        lazySet(i, t9);
        SpscArrayQueueProducer.PRODUCER_INDEX.lazySet(this, j5 + 1);
        return true;
    }

    @Override // java.util.Queue
    @Nullable
    public T peek() {
        return get(((int) this.consumerIndex) & this.mask);
    }

    @Override // java.util.Queue
    @Nullable
    public T poll() {
        long j5 = this.consumerIndex;
        int i = ((int) j5) & this.mask;
        T t9 = get(i);
        if (t9 != null) {
            lazySet(i, null);
            SpscArrayQueueConsumer.CONSUMER_INDEX.lazySet(this, j5 + 1);
        }
        return t9;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
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

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <R> R[] toArray(R[] rArr) {
        throw new UnsupportedOperationException();
    }
}
