package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected Subscription upstream;

    public DeferredScalarSubscriber(Subscriber<? super R> r1) {
        super(r1);
    }

    public void onSubscribe(Subscription r3) {
        if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
        this.upstream = r3;
        this.downstream.onSubscribe(this);
        r3.request(Long.MAX_VALUE);
        return;
    }

    public void onError(Throwable r2) {
        this.value = null;
        this.downstream.onError(r2);
    }

    public void onComplete() {
        if (this.hasValue == false) goto L5;
        complete(this.value);
        return;
    L5:
        this.downstream.onComplete();
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }
}
