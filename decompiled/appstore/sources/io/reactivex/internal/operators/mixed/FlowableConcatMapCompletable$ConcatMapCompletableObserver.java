package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.a;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatMapCompletable$ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
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

    public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
        private static final long serialVersionUID = 5638352172918776687L;
        final FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> parent;

        public ConcatMapInnerObserver(FlowableConcatMapCompletable$ConcatMapCompletableObserver<?> r10) {
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this, r10);
        }
    }

    public FlowableConcatMapCompletable$ConcatMapCompletableObserver(CompletableObserver r10, Function<? super T, ? extends CompletableSource> r11, ErrorMode r12, int r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.errorMode = r12;
        this.prefetch = r13;
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapInnerObserver(this);
        this.queue = new SpscArrayQueue(r13);
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

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.disposed == true) goto L7;
        if (this.active == true) goto L39;
        if (this.errorMode == ErrorMode.BOUNDARY) goto L14;
    L17:
        boolean r10 = this.done;
        T r11 = this.queue.poll();
        if (r11 != null) goto L20;
        boolean r12 = true;
    L21:
        if (r10 == false) goto L28;
        if (r12 == false) goto L28;
        Throwable r13 = this.errors.terminate();
        if (r13 == null) goto L26;
        this.downstream.onError(r13);
        return;
    L26:
        this.downstream.onComplete();
        return;
    L28:
        if (r12 == true) goto L39;
        int r14 = this.prefetch;
        int r15 = r14 - (r14 >> 1);
        int r16 = this.consumed + 1;
        if (r16 != r15) goto L32;
        this.consumed = 0;
        this.upstream.request(r15);
    L41:
        CompletableSource r17 = (CompletableSource) a.b(this.mapper.apply(r11), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L35
        this.active = true;
        r17.subscribe(this.inner);
    L35:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.queue.clear();
        this.upstream.cancel();
        this.errors.addThrowable(th);
        this.downstream.onError(this.errors.terminate());
        return;
    L32:
        this.consumed = r16;
        goto L41
    L20:
        r12 = false;
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

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.upstream.cancel();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f20726a) goto L10;
        this.downstream.onError(r11);
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

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L12;
        this.inner.dispose();
        Throwable r11 = this.errors.terminate();
        if (r11 == ExceptionHelper.f20726a) goto L10;
        this.downstream.onError(r11);
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
    public void onNext(T r10) {
        if (this.queue.offer(r10) == false) goto L5;
        drain();
        return;
    L5:
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue full?!"));
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }
}
