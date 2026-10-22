package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class ParallelSortedJoin$SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
    private static final long serialVersionUID = 6751017204873808094L;
    final int index;
    final ParallelSortedJoin$SortedJoinSubscription<T> parent;

    public ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription<T> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.innerError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public /* bridge */ /* synthetic */ void onNext(Object r10) {
        onNext((List) r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }

    public void onNext(List<T> r10) {
        this.parent.innerNext(r10, this.index);
    }
}
