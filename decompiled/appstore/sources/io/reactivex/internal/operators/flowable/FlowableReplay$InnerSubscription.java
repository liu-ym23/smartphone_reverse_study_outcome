package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
    static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    boolean emitting;
    Object index;
    boolean missed;
    final FlowableReplay$ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;

    public FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber<T> r10, Subscriber<? super T> r11) {
        this.parent = r10;
        this.child = r11;
        this.totalRequested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (getAndSet(CANCELLED) == CANCELLED) goto L6;
        this.parent.remove(this);
        this.parent.manageRequests();
        this.index = null;
        return;
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public long produced(long r10) {
        return io.reactivex.internal.util.a.f(this, r10);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == true) goto L5;
        return;
    L5:
        if (io.reactivex.internal.util.a.b(this, r10) == CANCELLED) goto L9;
        io.reactivex.internal.util.a.a(this.totalRequested, r10);
        this.parent.manageRequests();
        this.parent.buffer.replay(this);
        return;
    }
}
