package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class CompletableAndThenPublisher$AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, CompletableObserver, Subscription {
    private static final long serialVersionUID = -8948264376121066672L;
    final Subscriber<? super R> downstream;
    Publisher<? extends R> other;
    final AtomicLong requested;
    Disposable upstream;

    public CompletableAndThenPublisher$AndThenPublisherSubscriber(Subscriber<? super R> r10, Publisher<? extends R> r11) {
        this.downstream = r10;
        this.other = r11;
        this.requested = new AtomicLong();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Publisher<? extends R> r10 = this.other;
        if (r10 != null) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.other = null;
        r10.subscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this, this.requested, r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        SubscriptionHelper.deferredSetOnce(this, this.requested, r10);
    }
}
