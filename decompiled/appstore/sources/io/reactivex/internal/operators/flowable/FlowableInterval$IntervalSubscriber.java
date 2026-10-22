package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableInterval$IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final Subscriber<? super Long> downstream;
    final AtomicReference<Disposable> resource;

    public FlowableInterval$IntervalSubscriber(Subscriber<? super Long> r10) {
        this.resource = new AtomicReference();
        this.downstream = r10;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.a.a(this, r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.resource.get() != DisposableHelper.DISPOSED) goto L5;
        return;
    L5:
        if (get() == 0) goto L7;
        Subscriber<? super Long> r10 = this.downstream;
        long r11 = this.count;
        this.count = r11 + 1;
        r10.onNext(Long.valueOf(r11));
        io.reactivex.internal.util.a.e(this, 1);
        return;
    L7:
        this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
        DisposableHelper.dispose(this.resource);
    }

    public void setResource(Disposable r10) {
        DisposableHelper.setOnce(this.resource, r10);
    }
}
