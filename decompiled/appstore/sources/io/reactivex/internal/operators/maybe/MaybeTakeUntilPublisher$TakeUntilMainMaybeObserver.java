package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    private static final long serialVersionUID = -2187421758664251153L;
    final MaybeObserver<? super T> downstream;
    final TakeUntilOtherMaybeObserver<U> other;

    public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
        private static final long serialVersionUID = -1266041316834525931L;
        final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> parent;

        public TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> r10) {
            this.parent = r10;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r10) {
            SubscriptionHelper.cancel(this);
            this.parent.otherComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    public MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver(MaybeObserver<? super T> r10) {
        this.downstream = r10;
        this.other = new TakeUntilOtherMaybeObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T r10) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void otherError(Throwable r10) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        qf.a.e(r10);
    }
}
