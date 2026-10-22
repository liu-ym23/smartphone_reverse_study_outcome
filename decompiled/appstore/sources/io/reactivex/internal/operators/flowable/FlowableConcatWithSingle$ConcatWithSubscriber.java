package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatWithSingle$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
    private static final long serialVersionUID = -7346385463600070225L;
    SingleSource<? extends T> other;
    final AtomicReference<Disposable> otherDisposable;

    public FlowableConcatWithSingle$ConcatWithSubscriber(Subscriber<? super T> r10, SingleSource<? extends T> r11) {
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
        this.upstream = SubscriptionHelper.CANCELLED;
        SingleSource<? extends T> r10 = this.other;
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

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this.otherDisposable, r10);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r10) {
        complete(r10);
    }
}
