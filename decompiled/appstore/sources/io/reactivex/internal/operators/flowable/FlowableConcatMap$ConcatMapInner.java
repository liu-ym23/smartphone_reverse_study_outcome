package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
    private static final long serialVersionUID = 897683679971470653L;
    final FlowableConcatMap$ConcatMapSupport<R> parent;
    long produced;

    public FlowableConcatMap$ConcatMapInner(FlowableConcatMap$ConcatMapSupport<R> r10) {
        super(false);
        this.parent = r10;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        long r10 = this.produced;
        if (r10 == 0) goto L5;
        this.produced = 0;
        produced(r10);
    L5:
        this.parent.innerComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        long r11 = this.produced;
        if (r11 == 0) goto L5;
        this.produced = 0;
        produced(r11);
    L5:
        this.parent.innerError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(R r10) {
        this.produced++;
        this.parent.innerNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        setSubscription(r10);
    }
}
