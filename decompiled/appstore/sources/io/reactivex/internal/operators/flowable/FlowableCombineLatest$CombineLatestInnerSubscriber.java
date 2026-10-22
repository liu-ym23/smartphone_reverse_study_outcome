package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableCombineLatest$CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -8730235182291002949L;
    final int index;
    final int limit;
    final FlowableCombineLatest$CombineLatestCoordinator<T, ?> parent;
    final int prefetch;
    int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator<T, ?> r10, int r11, int r12) {
        this.parent = r10;
        this.index = r11;
        this.prefetch = r12;
        this.limit = r12 - (r12 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.innerError(this.index, r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.parent.innerValue(this.index, r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, this.prefetch);
    }

    public void requestOne() {
        int r10 = this.produced + 1;
        if (r10 != this.limit) goto L5;
        this.produced = 0;
        get().request(r10);
        return;
    L5:
        this.produced = r10;
    }
}
