package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements Subscription {
    private static final long serialVersionUID = 8664815189257569791L;
    final Subscriber<? super T> downstream;
    long emitted;
    final f parent;

    public FlowablePublishMulticast$MulticastSubscription(Subscriber<? super T> r10, f r11) {
        this.downstream = r10;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
        return;
    L6:
        throw null;
    }

    public boolean isCancelled() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        io.reactivex.internal.util.a.b(this, r10);
        throw null;
    }
}
