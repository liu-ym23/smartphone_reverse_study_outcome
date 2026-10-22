package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableTimeout$TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final FlowableTimeout$TimeoutSelectorSupport parent;

    public FlowableTimeout$TimeoutConsumer(long r10, FlowableTimeout$TimeoutSelectorSupport r11) {
        this.idx = r10;
        this.parent = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription r10 = get();
        SubscriptionHelper r11 = SubscriptionHelper.CANCELLED;
        if (r10 == r11) goto L6;
        lazySet(r11);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        Subscription r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L5;
        lazySet(r12);
        this.parent.onTimeoutError(this.idx, r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object r10) {
        Subscription r11 = get();
        SubscriptionHelper r12 = SubscriptionHelper.CANCELLED;
        if (r11 == r12) goto L6;
        r11.cancel();
        lazySet(r12);
        this.parent.onTimeout(this.idx);
        return;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
    }
}
