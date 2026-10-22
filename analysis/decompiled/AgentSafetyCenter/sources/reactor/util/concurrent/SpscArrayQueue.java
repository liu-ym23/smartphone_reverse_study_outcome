package reactor.util.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class SpscArrayQueue<T> extends SpscArrayQueueP3<T> implements Queue<T> {
    private static final long serialVersionUID = 494623116936946976L;

    public SpscArrayQueue(int i) {
        super(Queues.ceilingNextPowerOfTwo(i));
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t10) {
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
    public boolean offer(T t10) {
        Objects.requireNonNull(t10, "e");
        long j10 = this.producerIndex;
        int i = ((int) j10) & this.mask;
        if (get(i) != null) {
            return false;
        }
        lazySet(i, t10);
        SpscArrayQueueProducer.PRODUCER_INDEX.lazySet(this, j10 + 1);
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
        long j10 = this.consumerIndex;
        int i = ((int) j10) & this.mask;
        T t10 = get(i);
        if (t10 != null) {
            lazySet(i, null);
            SpscArrayQueueConsumer.CONSUMER_INDEX.lazySet(this, j10 + 1);
        }
        return t10;
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
