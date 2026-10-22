package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.h;

/* JADX INFO: loaded from: classes4.dex */
public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final AtomicLong consumerIndex;
    final int mask;
    final AtomicLong producerIndex;

    public SpscExactAtomicArrayQueue(int r10) {
        super(h.a(r10));
        int r11 = length();
        this.mask = r11 - 1;
        this.capacitySkip = r11 - r10;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // java.util.Collection
    public boolean contains(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.producerIndex != this.consumerIndex) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T r10) {
        if (r10 == null) goto L10;
        long r11 = this.producerIndex.get();
        int r12 = this.mask;
        if (get(((int) (((long) this.capacitySkip) + r11)) & r12) == null) goto L7;
        return false;
    L7:
        int r13 = r12 & ((int) r11);
        this.producerIndex.lazySet(r11 + 1);
        lazySet(r13, r10);
        return true;
    L10:
        throw null;
    }

    @Override // java.util.Queue
    public T peek() {
        return get(((int) this.consumerIndex.get()) & this.mask);
    }

    @Override // java.util.Queue
    public T poll() {
        long r10 = this.consumerIndex.get();
        int r11 = ((int) r10) & this.mask;
        T r12 = get(r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        this.consumerIndex.lazySet(r10 + 1);
        lazySet(r11, null);
        return r12;
    }

    @Override // java.util.Collection
    public boolean remove(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long r10 = this.consumerIndex.get();
    L3:
        long r11 = this.producerIndex.get();
        long r12 = this.consumerIndex.get();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
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
    public <E> E[] toArray(E[] r10) {
        throw new UnsupportedOperationException();
    }
}
