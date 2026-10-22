package io.reactivex.internal.operators.maybe;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimpleQueue;

/* JADX INFO: loaded from: classes4.dex */
interface MaybeMergeArray$SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
    int consumerIndex();

    void drop();

    T peek();

    @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray$SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    T poll();

    int producerIndex();
}
