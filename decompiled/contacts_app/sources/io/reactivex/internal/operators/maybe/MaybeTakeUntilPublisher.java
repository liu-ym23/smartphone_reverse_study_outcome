package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> other;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;
        final MaybeObserver<? super T> downstream;
        final TakeUntilOtherMaybeObserver<U> other;

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> parent;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription r3) {
                SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object r1) {
                SubscriptionHelper.cancel(this);
                this.parent.otherComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.parent.otherComplete();
            }
        }

        TakeUntilMainMaybeObserver(MaybeObserver<? super T> r1) {
            this.downstream = r1;
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
        public void onSubscribe(Disposable r1) {
            DisposableHelper.setOnce(this, r1);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T r3) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onSuccess(r3);
            return;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable r3) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onComplete();
            return;
        }

        void otherError(Throwable r2) {
            if (DisposableHelper.dispose(this) == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L6;
            this.downstream.onComplete();
            return;
        }
    }

    public MaybeTakeUntilPublisher(MaybeSource<T> r1, Publisher<U> r2) {
        super(r1);
        this.other = r2;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> r3) {
        TakeUntilMainMaybeObserver r0 = new TakeUntilMainMaybeObserver(r3);
        r3.onSubscribe(r0);
        this.other.subscribe(r0.other);
        this.source.subscribe(r0);
    }
}
