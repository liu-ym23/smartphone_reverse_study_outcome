package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$internal$util$ErrorMode = null;

        static {
            int[] r0 = new int[ErrorMode.values().length];
            $SwitchMap$io$reactivex$internal$util$ErrorMode = r0;
            r0[ErrorMode.BOUNDARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$io$reactivex$internal$util$ErrorMode[ErrorMode.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final AtomicThrowable errors;
        final ConcatMapInner<R> inner;
        final int limit;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        int sourceMode;
        Subscription upstream;

        abstract void drain();

        abstract void subscribeActual();

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> r1, int r2) {
            this.mapper = r1;
            this.prefetch = r2;
            this.limit = r2 - (r2 >> 2);
            this.inner = new ConcatMapInner(this);
            this.errors = new AtomicThrowable();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            subscribeActual();
            drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            subscribeActual();
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            r4.request(this.prefetch);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T r3) {
            if (this.sourceMode != 2) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r3) == true) goto L8;
            this.upstream.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void innerComplete() {
            this.active = false;
            drain();
        }
    }

    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final Subscriber<? super R> downstream;
        final boolean veryEnd;

        ConcatMapDelayed(Subscriber<? super R> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, boolean r4) {
            super(r2, r3);
            this.downstream = r1;
            this.veryEnd = r4;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == true) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (this.veryEnd == true) goto L7;
            this.upstream.cancel();
            this.done = true;
        L7:
            this.active = false;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.inner.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (this.cancelled == true) goto L6;
            if (this.active == true) goto L62;
            boolean r0 = this.done;
            if (r0 == true) goto L12;
        L66:
            T r1 = this.queue.poll();     // Catch: Throwable -> L58
            if (r1 != null) goto L21;
            boolean r4 = true;
        L22:
            if (r0 == false) goto L29;
            if (r4 == false) goto L29;
            Throwable r2 = this.errors.terminate();
            if (r2 == null) goto L27;
            this.downstream.onError(r2);
            return;
        L27:
            this.downstream.onComplete();
            return;
        L29:
            if (r4 == true) goto L62;
            Publisher r3 = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r1), "The mapper returned a null Publisher");     // Catch: Throwable -> L55
            if (this.sourceMode == 1) goto L38;
            int r5 = this.consumed + 1;
            if (r5 != this.limit) goto L36;
            this.consumed = 0;
            this.upstream.request(r5);
            goto L38
        L36:
            this.consumed = r5;
        L38:
            if ((r3 instanceof Callable) == false) goto L54;
            Object r6 = ((Callable) r3).call();     // Catch: Throwable -> L42
        L48:
            if (r6 == null) goto L5;
            if (this.inner.isUnbounded() == true) goto L52;
            this.active = true;
            this.inner.setSubscription(new WeakScalarSubscription(r6, this.inner));
            goto L62
        L52:
            this.downstream.onNext(r6);
        L42:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            if (this.veryEnd == false) goto L45;
            r6 = null;
            goto L48
        L45:
            this.upstream.cancel();
            this.downstream.onError(this.errors.terminate());
            return;
        L54:
            this.active = true;
            r3.subscribe(this.inner);
        L55:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L21:
            r4 = false;
        L58:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L12:
            if (this.veryEnd == true) goto L66;
            if (this.errors.get() == null) goto L66;
            this.downstream.onError(this.errors.terminate());
            return;
        L62:
            if (decrementAndGet() != 0) goto L5;
            return;
        }
    }

    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final Subscriber<? super R> downstream;
        final AtomicInteger wip;

        ConcatMapImmediate(Subscriber<? super R> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3) {
            super(r2, r3);
            this.downstream = r1;
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.downstream.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L7;
            this.inner.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.downstream.onError(this.errors.terminate());
            return;
        L9:
            return;
        L7:
            RxJavaPlugins.onError(r2);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r4) {
            if (get() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L12;
            this.downstream.onNext(r4);
            if (compareAndSet(1, 0) == false) goto L9;
            return;
        L9:
            this.downstream.onError(this.errors.terminate());
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L7;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.downstream.onError(this.errors.terminate());
            return;
        L9:
            return;
        L7:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.inner.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (this.cancelled == true) goto L6;
            if (this.active == true) goto L55;
            boolean r0 = this.done;
            T r1 = this.queue.poll();     // Catch: Throwable -> L51
            if (r1 != null) goto L14;
            boolean r4 = true;
        L15:
            if (r0 == false) goto L19;
            if (r4 == false) goto L19;
            this.downstream.onComplete();
            return;
        L19:
            if (r4 == true) goto L55;
            Publisher r2 = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r1), "The mapper returned a null Publisher");     // Catch: Throwable -> L48
            if (this.sourceMode == 1) goto L28;
            int r3 = this.consumed + 1;
            if (r3 != this.limit) goto L26;
            this.consumed = 0;
            this.upstream.request(r3);
            goto L28
        L26:
            this.consumed = r3;
        L28:
            if ((r2 instanceof Callable) == false) goto L47;
            Object r5 = ((Callable) r2).call();     // Catch: Throwable -> L44
            if (r5 == null) goto L5;
            if (this.inner.isUnbounded() == true) goto L36;
            this.active = true;
            this.inner.setSubscription(new WeakScalarSubscription(r5, this.inner));
            goto L55
        L36:
            if (get() != 0) goto L5;
            if (compareAndSet(0, 1) == false) goto L5;
            this.downstream.onNext(r5);
            if (compareAndSet(1, 0) == true) goto L5;
            this.downstream.onError(this.errors.terminate());
            return;
        L44:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L47:
            this.active = true;
            r2.subscribe(this.inner);
        L48:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L14:
            r4 = false;
        L51:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            this.errors.addThrowable(th);
            this.downstream.onError(this.errors.terminate());
            return;
        L55:
            if (this.wip.decrementAndGet() != 0) goto L5;
            return;
        }
    }

    static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final ConcatMapSupport<R> parent;
        long produced;

        ConcatMapInner(ConcatMapSupport<R> r2) {
            super(false);
            this.parent = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r1) {
            setSubscription(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r5) {
            this.produced++;
            this.parent.innerNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r6) {
            long r0 = this.produced;
            if (r0 == 0) goto L5;
            this.produced = 0;
            produced(r0);
        L5:
            this.parent.innerError(r6);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long r0 = this.produced;
            if (r0 == 0) goto L5;
            this.produced = 0;
            produced(r0);
        L5:
            this.parent.innerComplete();
        }
    }

    interface ConcatMapSupport<T> {
        void innerComplete();

        void innerError(Throwable r1);

        void innerNext(T r1);
    }

    static final class WeakScalarSubscription<T> implements Subscription {
        final Subscriber<? super T> downstream;
        boolean once;
        final T value;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        WeakScalarSubscription(T r1, Subscriber<? super T> r2) {
            this.value = r1;
            this.downstream = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r3) {
            if (r3 > 0) goto L5;
            return;
        L5:
            if (this.once == true) goto L9;
            this.once = true;
            Subscriber<? super T> r4 = this.downstream;
            r4.onNext(this.value);
            r4.onComplete();
            return;
        }
    }

    public FlowableConcatMap(Flowable<T> r1, Function<? super T, ? extends Publisher<? extends R>> r2, int r3, ErrorMode r4) {
        super(r1);
        this.mapper = r2;
        this.prefetch = r3;
        this.errorMode = r4;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> r2, Function<? super T, ? extends Publisher<? extends R>> r3, int r4, ErrorMode r5) {
        int r6 = AnonymousClass1.$SwitchMap$io$reactivex$internal$util$ErrorMode[r5.ordinal()];
        if (r6 == 1) goto L11;
        if (r6 == 2) goto L9;
        return new ConcatMapImmediate(r2, r3, r4);
    L9:
        return new ConcatMapDelayed(r2, r3, r4, true);
    L11:
        return new ConcatMapDelayed(r2, r3, r4, false);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> r4) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, r4, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(subscribe(r4, this.mapper, this.prefetch, this.errorMode));
    }
}
