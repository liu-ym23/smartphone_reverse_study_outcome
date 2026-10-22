package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableConcatMapSingle$ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    long emitted;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapSingleObserver<R> inner;
    R item;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int prefetch;
    final SimplePlainQueue<T> queue;
    final AtomicLong requested;
    volatile int state;
    Subscription upstream;

    public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
        private static final long serialVersionUID = -3051469169682093892L;
        final FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> parent;

        public ConcatMapSingleObserver(FlowableConcatMapSingle$ConcatMapSingleSubscriber<?, R> r10) {
            this.parent = r10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable r10) {
            DisposableHelper.replace(this, r10);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(R r10) {
            this.parent.innerSuccess(r10);
        }
    }

    public FlowableConcatMapSingle$ConcatMapSingleSubscriber(Subscriber<? super R> r10, Function<? super T, ? extends SingleSource<? extends R>> r11, int r12, ErrorMode r13) {
        this.downstream = r10;
        this.mapper = r11;
        this.prefetch = r12;
        this.errorMode = r13;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
        this.inner = new ConcatMapSingleObserver(this);
        this.queue = new SpscArrayQueue(r12);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.inner.dispose();
        if (getAndIncrement() != 0) goto L6;
        this.queue.clear();
        this.item = null;
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        Subscriber<? super R> r10 = this.downstream;
        ErrorMode r11 = this.errorMode;
        SimplePlainQueue<T> r12 = this.queue;
        AtomicThrowable r13 = this.errors;
        AtomicLong r14 = this.requested;
        int r15 = this.prefetch;
        int r16 = r15 - (r15 >> 1);
        int r17 = 1;
    L7:
        if (this.cancelled == true) goto L8;
        int r18 = this.state;
        if (r13.get() == null) goto L19;
        if (r11 == ErrorMode.IMMEDIATE) goto L16;
        if (r11 != ErrorMode.BOUNDARY) goto L19;
        if (r18 != 0) goto L19;
    L16:
        r12.clear();
        this.item = null;
        r10.onError(r13.terminate());
        return;
    L19:
        if (r18 == 0) goto L20;
        if (r18 != 2) goto L47;
        long r19 = this.emitted;
        if (r19 == r14.get()) goto L47;
        R r20 = this.item;
        this.item = null;
        r10.onNext(r20);
        this.emitted = r19 + 1;
        this.state = 0;
    L47:
        r17 = addAndGet(-r17);
        if (r17 != 0) goto L7;
        return;
    L20:
        boolean r21 = this.done;
        T r22 = r12.poll();
        if (r22 != null) goto L23;
        boolean r110 = true;
    L24:
        if (r21 == false) goto L31;
        if (r110 == false) goto L31;
        Throwable r111 = r13.terminate();
        if (r111 != null) goto L29;
        r10.onComplete();
        return;
    L29:
        r10.onError(r111);
        return;
    L31:
        if (r110 == true) goto L47;
        int r23 = this.consumed + 1;
        if (r23 != r16) goto L36;
        this.consumed = 0;
        this.upstream.request(r16);
    L50:
        SingleSource r24 = (SingleSource) a.b(this.mapper.apply(r22), "The mapper returned a null SingleSource");     // Catch: Throwable -> L39
        this.state = 1;
        r24.subscribe(this.inner);
    L39:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        r12.clear();
        r13.addThrowable(th);
        r10.onError(r13.terminate());
        return;
    L36:
        this.consumed = r23;
        goto L50
    L23:
        r110 = false;
        goto L24
    L8:
        r12.clear();
        this.item = null;
        goto L47
    }

    public void innerError(Throwable r10) {
        if (this.errors.addThrowable(r10) == true) goto L5;
        qf.a.e(r10);
        return;
    L5:
        if (this.errorMode == ErrorMode.END) goto L7;
        this.upstream.cancel();
    L7:
        this.state = 0;
        drain();
    }

    public void innerSuccess(R r10) {
        this.item = r10;
        this.state = 2;
        drain();
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
        if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
        this.inner.dispose();
    L7:
        this.done = true;
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        if (this.queue.offer(r10) == true) goto L6;
        this.upstream.cancel();
        onError(new MissingBackpressureException("queue full?!"));
        return;
    L6:
        drain();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
    }
}
