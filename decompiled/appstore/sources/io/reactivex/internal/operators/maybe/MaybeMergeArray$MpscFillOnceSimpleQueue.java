package io.reactivex.internal.operators.maybe;

import io.reactivex.annotations.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements MaybeMergeArray$SimpleQueueWithConsumerIndex<T> {
    private static final long serialVersionUID = -7969063454040569579L;
    int consumerIndex;
    final AtomicInteger producerIndex;

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int r10) {
        super(r10);
        this.producerIndex = new AtomicInteger();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
    public void drop() {
        int r10 = this.consumerIndex;
        lazySet(r10, null);
        this.consumerIndex = r10 + 1;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (this.consumerIndex != producerIndex()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r10) {
        io.reactivex.internal.functions.a.b(r10, "value is null");
        int r11 = this.producerIndex.getAndIncrement();
        if (r11 >= length()) goto L6;
        lazySet(r11, r10);
        return true;
    L6:
        return false;
    }

    @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
    public T peek() {
        int r10 = this.consumerIndex;
        if (r10 != length()) goto L7;
        return null;
    L7:
        return get(r10);
    }

    @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        int r10 = this.consumerIndex;
        if (r10 != length()) goto L5;
        return null;
    L5:
        AtomicInteger r11 = this.producerIndex;
    L6:
        T r12 = get(r10);
        if (r12 != null) goto L8;
        if (r11.get() != r10) goto L6;
        return null;
    L8:
        this.consumerIndex = r10 + 1;
        lazySet(r10, null);
        return r12;
    }

    @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex
    public int producerIndex() {
        return this.producerIndex.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException();
    }
}
