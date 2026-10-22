package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowablePublishAlt$InnerSubscription<T> extends AtomicLong implements Subscription {
    private static final long serialVersionUID = 2845000326761540265L;
    final Subscriber<? super T> downstream;
    long emitted;
    final FlowablePublishAlt$PublishConnection<T> parent;

    public FlowablePublishAlt$InnerSubscription(Subscriber<? super T> r10, FlowablePublishAlt$PublishConnection<T> r11) {
        this.downstream = r10;
        this.parent = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
        this.parent.remove(this);
        this.parent.drain();
        return;
    }

    public boolean isCancelled() {
        if (get() != Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        io.reactivex.internal.util.a.b(this, r10);
        this.parent.drain();
    }
}
