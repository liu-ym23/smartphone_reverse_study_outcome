package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    Subscription upstream;

    public DefaultSubscriber() {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription r3) {
        if (EndConsumerHelper.validate(this.upstream, r3, getClass()) == false) goto L6;
        this.upstream = r3;
        onStart();
        return;
    }

    protected final void request(long r1) {
        Subscription r0 = this.upstream;
        if (r0 == null) goto L6;
        r0.request(r1);
        return;
    }

    protected final void cancel() {
        Subscription r0 = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        r0.cancel();
    }

    protected void onStart() {
        request(Long.MAX_VALUE);
    }
}
