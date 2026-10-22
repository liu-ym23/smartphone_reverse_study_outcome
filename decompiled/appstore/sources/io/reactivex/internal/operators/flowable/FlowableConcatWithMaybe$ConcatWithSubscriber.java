package io.reactivex.internal.operators.flowable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatWithMaybe$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    boolean inMaybe;
    MaybeSource<? extends T> other;
    final AtomicReference<Disposable> otherDisposable;

    public FlowableConcatWithMaybe$ConcatWithSubscriber(Subscriber<? super T> r10, MaybeSource<? extends T> r11) {
        super(r10);
        this.other = r11;
        this.otherDisposable = new AtomicReference();
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.inMaybe == false) goto L5;
        this.downstream.onComplete();
        return;
    L5:
        this.inMaybe = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        MaybeSource<? extends T> r10 = this.other;
        this.other = null;
        r10.subscribe(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        this.produced++;
        this.downstream.onNext((Object) r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.otherDisposable, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        complete(r10);
    }
}
