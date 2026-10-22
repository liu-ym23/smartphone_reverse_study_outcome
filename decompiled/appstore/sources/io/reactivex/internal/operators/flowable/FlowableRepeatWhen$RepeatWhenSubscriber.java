package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableRepeatWhen$RepeatWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Object> {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRepeatWhen$RepeatWhenSubscriber(Subscriber<? super T> r10, io.reactivex.processors.a r11, Subscription r12) {
        super(r10, r11, r12);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        again(0);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.receiver.cancel();
        this.downstream.onError(r10);
    }
}
