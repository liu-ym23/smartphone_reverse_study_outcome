package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatMapCompletable<T> extends Completable {
    final ErrorMode errorMode;
    final Function<? super T, ? extends CompletableSource> mapper;
    final int prefetch;
    final Flowable<T> source;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        int consumed;
        volatile boolean disposed;
        volatile boolean done;
        final CompletableObserver downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final ConcatMapInnerObserver inner;
        final Function<? super T, ? extends CompletableSource> mapper;
        final int prefetch;
        final SimplePlainQueue<T> queue;
        Subscription upstream;

        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                DisposableHelper.replace(this, r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver r1, Function<? super T, ? extends CompletableSource> r2, ErrorMode r3, int r4) {
            this.downstream = r1;
            this.mapper = r2;
            this.errorMode = r3;
            this.prefetch = r4;
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapInnerObserver(this);
            this.queue = new SpscArrayQueue(r4);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L6;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            r3.request(this.prefetch);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.queue.offer(r2) == false) goto L5;
            drain();
            return;
        L5:
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.inner.dispose();
            Throwable r3 = this.errors.terminate();
            if (r3 == ExceptionHelper.TERMINATED) goto L10;
            this.downstream.onError(r3);
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        L12:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
            this.upstream.cancel();
            Throwable r3 = this.errors.terminate();
            if (r3 == ExceptionHelper.TERMINATED) goto L10;
            this.downstream.onError(r3);
        L10:
            if (getAndIncrement() != 0) goto L15;
            this.queue.clear();
            return;
        L15:
            return;
        L12:
            this.active = false;
            drain();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.disposed == true) goto L7;
            if (this.active == true) goto L39;
            if (this.errorMode == ErrorMode.BOUNDARY) goto L14;
        L17:
            boolean r0 = this.done;
            T r1 = this.queue.poll();
            if (r1 != null) goto L20;
            boolean r4 = true;
        L21:
            if (r0 == false) goto L28;
            if (r4 == false) goto L28;
            Throwable r2 = this.errors.terminate();
            if (r2 == null) goto L26;
            this.downstream.onError(r2);
            return;
        L26:
            this.downstream.onComplete();
            return;
        L28:
            if (r4 == true) goto L39;
            int r3 = this.prefetch;
            int r5 = r3 - (r3 >> 1);
            int r6 = this.consumed + 1;
            if (r6 != r5) goto L32;
            this.consumed = 0;
            this.upstream.request(r5);
        L41:
            CompletableSource r7 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r1), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L35
            this.active = true;
            r7.subscribe(this.inner);
        L35:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.queue.clear();
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L32:
            this.consumed = r6;
            goto L41
        L20:
            r4 = false;
            goto L21
        L14:
            if (this.errors.get() == null) goto L17;
            this.queue.clear();
            this.downstream.onError(this.errors.terminate());
            return;
        L39:
            if (decrementAndGet() != 0) goto L6;
            return;
        L7:
            this.queue.clear();
        }
    }

    public FlowableConcatMapCompletable(Flowable<T> r1, Function<? super T, ? extends CompletableSource> r2, ErrorMode r3, int r4) {
        this.source = r1;
        this.mapper = r2;
        this.errorMode = r3;
        this.prefetch = r4;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver r5) {
        this.source.subscribe(new ConcatMapCompletableObserver(r5, this.mapper, this.errorMode, this.prefetch));
    }
}
