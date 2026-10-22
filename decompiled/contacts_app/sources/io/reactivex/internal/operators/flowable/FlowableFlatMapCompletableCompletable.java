package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int maxConcurrency;
    final Flowable<T> source;

    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final CompletableObserver downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends CompletableSource> mapper;
        final int maxConcurrency;
        final CompositeDisposable set;
        Subscription upstream;

        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;
            final /* synthetic */ FlatMapCompletableMainSubscriber this$0;

            InnerObserver(FlatMapCompletableMainSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.setOnce(this, r1);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }
        }

        FlatMapCompletableMainSubscriber(CompletableObserver r1, Function<? super T, ? extends CompletableSource> r2, boolean r3, int r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.delayErrors = r3;
            this.errors = new AtomicThrowable();
            this.set = new CompositeDisposable();
            this.maxConcurrency = r4;
            lazySet(1);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L9;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L7;
            r3.request(Long.MAX_VALUE);
            return;
        L7:
            r3.request(r2);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            CompletableSource r4 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r3), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
            getAndIncrement();
            InnerObserver r0 = new InnerObserver(this);
            if (this.disposed == false) goto L6;
            return;
        L6:
            if (this.set.add(r0) == false) goto L15;
            r4.subscribe(r0);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (this.errors.addThrowable(r3) == true) goto L5;
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            dispose();
            if (getAndSet(0) <= 0) goto L20;
            Throwable r4 = this.errors.terminate();
            this.downstream.onError(r4);
            return;
        L20:
            return;
        L7:
            if (decrementAndGet() != 0) goto L10;
            Throwable r5 = this.errors.terminate();
            this.downstream.onError(r5);
            return;
        L10:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L18;
            this.upstream.request(1);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() != 0) goto L9;
            Throwable r0 = this.errors.terminate();
            if (r0 == null) goto L7;
            this.downstream.onError(r0);
            return;
        L7:
            this.downstream.onComplete();
            return;
        L9:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        void innerComplete(FlatMapCompletableMainSubscriber<T>.InnerObserver r2) {
            this.set.delete(r2);
            onComplete();
        }

        void innerError(FlatMapCompletableMainSubscriber<T>.InnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            onError(r3);
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> r1, Function<? super T, ? extends CompletableSource> r2, boolean r3, int r4) {
        this.source = r1;
        this.mapper = r2;
        this.delayErrors = r3;
        this.maxConcurrency = r4;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r5) {
        this.source.subscribe(new FlatMapCompletableMainSubscriber(r5, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable(this.source, this.mapper, this.delayErrors, this.maxConcurrency));
    }
}
