package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class SingleTakeUntil$TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = 5170026210238877381L;
    final SingleTakeUntil$TakeUntilMainObserver<?> parent;

    public SingleTakeUntil$TakeUntilOtherSubscriber(SingleTakeUntil$TakeUntilMainObserver<?> r10) {
        this.parent = r10;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.otherError(new CancellationException());
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.parent.otherError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.parent.otherError(new CancellationException());
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
