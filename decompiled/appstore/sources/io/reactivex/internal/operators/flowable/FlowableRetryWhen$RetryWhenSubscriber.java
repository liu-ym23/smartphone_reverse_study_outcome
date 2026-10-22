package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(Subscriber<? super T> r10, io.reactivex.processors.a r11, Subscription r12) {
        super(r10, r11, r12);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        again(r10);
    }
}
