package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatWithCompletable$ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
    private static final long serialVersionUID = -7346385463600070225L;
    final Subscriber<? super T> downstream;
    boolean inCompletable;
    CompletableSource other;
    Subscription upstream;

    public FlowableConcatWithCompletable$ConcatWithSubscriber(Subscriber<? super T> r10, CompletableSource r11) {
        this.downstream = r10;
        this.other = r11;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.inCompletable == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inCompletable = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        CompletableSource r10 = this.other;
        this.other = null;
        r10.subscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        this.upstream.request(r10);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
