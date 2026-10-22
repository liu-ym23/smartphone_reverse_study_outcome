package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class SingleTakeUntil<T, U> extends Single<T> {
    final Publisher<U> other;
    final SingleSource<T> source;

    static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -622603812305745221L;
        final SingleObserver<? super T> downstream;
        final TakeUntilOtherSubscriber other;

        TakeUntilMainObserver(SingleObserver<? super T> r1) {
            this.downstream = r1;
            this.other = new TakeUntilOtherSubscriber(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.other.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T r3) {
            this.other.dispose();
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onSuccess(r3);
            return;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r3) {
            this.other.dispose();
            if (get() != DisposableHelper.DISPOSED) goto L5;
        L8:
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L8;
            this.downstream.onError(r3);
        }

        void otherError(Throwable r3) {
            if (get() == DisposableHelper.DISPOSED) goto L10;
            Disposable r0 = getAndSet(DisposableHelper.DISPOSED);
            if (r0 == DisposableHelper.DISPOSED) goto L10;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            this.downstream.onError(r3);
            return;
        L10:
            RxJavaPlugins.onError(r3);
        }
    }

    static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final TakeUntilMainObserver<?> parent;

        TakeUntilOtherSubscriber(TakeUntilMainObserver<?> r1) {
            this.parent = r1;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r1) {
            if (SubscriptionHelper.cancel(this) == false) goto L6;
            this.parent.otherError(new CancellationException());
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.parent.otherError(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.otherError(new CancellationException());
            return;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }
    }

    public SingleTakeUntil(SingleSource<T> r1, Publisher<U> r2) {
        this.source = r1;
        this.other = r2;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> r3) {
        TakeUntilMainObserver r0 = new TakeUntilMainObserver(r3);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
        this.source.subscribe(r0);
    }
}
