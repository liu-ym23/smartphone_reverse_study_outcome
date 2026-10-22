package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableWithLatestFromMany$WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> parent;

    public FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber<?, ?> r10, int r11) {
        this.parent = r10;
        this.index = r11;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this.index, this.hasValue);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.innerError(this.index, r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        if (this.hasValue == true) goto L5;
        this.hasValue = true;
    L5:
        this.parent.innerNext(this.index, r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
