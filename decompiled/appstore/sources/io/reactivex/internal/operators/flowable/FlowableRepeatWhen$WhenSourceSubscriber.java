package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final Subscriber<? super T> downstream;
    protected final io.reactivex.processors.a processor;
    private long produced;
    protected final Subscription receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(Subscriber<? super T> r10, io.reactivex.processors.a r11, Subscription r12) {
        super(false);
        this.downstream = r10;
        this.processor = r11;
        this.receiver = r12;
    }

    public final void again(U r10) {
        setSubscription(EmptySubscription.INSTANCE);
        long r11 = this.produced;
        if (r11 == 0) goto L5;
        this.produced = 0;
        produced(r11);
    L5:
        this.receiver.request(1);
        this.processor.onNext(r10);
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T r10) {
        this.produced++;
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription r10) {
        setSubscription(r10);
    }
}
