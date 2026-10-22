package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;

    static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final MergeSubscriber<T, U> parent;
        long produced;
        volatile SimpleQueue<U> queue;

        InnerSubscriber(MergeSubscriber<T, U> r1, long r2) {
            this.id = r2;
            this.parent = r1;
            int r3 = r1.bufferSize;
            this.bufferSize = r3;
            this.limit = r3 >> 2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.setOnce(this, r4) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof QueueSubscription) == false) goto L13;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.fusionMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L13;
            this.fusionMode = r1;
            this.queue = r0;
        L13:
            r4.request(this.bufferSize);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U r3) {
            if (this.fusionMode == 2) goto L5;
            this.parent.tryEmit(r3, this);
            return;
        L5:
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.innerError(this, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        void requestMore(long r3) {
            if (this.fusionMode == 1) goto L9;
            long r0 = this.produced + r3;
            if (r0 < this.limit) goto L7;
            this.produced = 0;
            get().request(r0);
            return;
        L7:
            this.produced = r0;
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != SubscriptionHelper.CANCELLED) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final InnerSubscriber<?, ?>[] CANCELLED = null;
        static final InnerSubscriber<?, ?>[] EMPTY = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super U> downstream;
        final AtomicThrowable errs;
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends Publisher<? extends U>> mapper;
        final int maxConcurrency;
        volatile SimplePlainQueue<U> queue;
        final AtomicLong requested;
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        long uniqueId;
        Subscription upstream;

        static {
            EMPTY = new InnerSubscriber[0];
            CANCELLED = new InnerSubscriber[0];
        }

        MergeSubscriber(Subscriber<? super U> r3, Function<? super T, ? extends Publisher<? extends U>> r4, boolean r5, int r6, int r7) {
            this.errs = new AtomicThrowable();
            AtomicReference<InnerSubscriber<?, ?>[]> r0 = new AtomicReference();
            this.subscribers = r0;
            this.requested = new AtomicLong();
            this.downstream = r3;
            this.mapper = r4;
            this.delayErrors = r5;
            this.maxConcurrency = r6;
            this.bufferSize = r7;
            this.scalarLimit = Math.max(1, r6 >> 1);
            r0.lazySet(EMPTY);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.validate(this.upstream, r3) == false) goto L11;
            this.upstream = r3;
            this.downstream.onSubscribe(this);
            if (this.cancelled == true) goto L12;
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L9;
            r3.request(Long.MAX_VALUE);
            return;
        L9:
            r3.request(r2);
            return;
        L12:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T r6) {
            if (this.done == false) goto L30;
            return;
        L30:
            Publisher r7 = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(r6), "The mapper returned a null Publisher");     // Catch: Throwable -> L25
            if ((r7 instanceof Callable) == true) goto L28;
            long r1 = this.uniqueId;
            this.uniqueId = 1 + r1;
            InnerSubscriber r0 = new InnerSubscriber(this, r1);
            if (addInner(r0) == false) goto L37;
            r7.subscribe(r0);
            return;
        L37:
            return;
        L28:
            Object r8 = ((Callable) r7).call();     // Catch: Throwable -> L18
            if (r8 == null) goto L12;
            tryEmitScalar(r8);
            return;
        L12:
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L14;
            return;
        L14:
            if (this.cancelled == true) goto L34;
            int r9 = this.scalarEmitted + 1;
            this.scalarEmitted = r9;
            int r2 = this.scalarLimit;
            if (r9 != r2) goto L35;
            this.scalarEmitted = 0;
            this.upstream.request(r2);
            return;
        L35:
            return;
        L34:
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errs.addThrowable(th);
            drain();
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            onError(th);
        }

        boolean addInner(InnerSubscriber<T, U> r5) {
        L2:
            InnerSubscriber<?, ?>[] r0 = this.subscribers.get();
            if (r0 == CANCELLED) goto L4;
            int r1 = r0.length;
            InnerSubscriber[] r3 = new InnerSubscriber[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, r0, r3) == false) goto L2;
            return true;
        L4:
            r5.dispose();
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void removeInner(InnerSubscriber<T, U> r7) {
        L2:
            InnerSubscriber<?, ?>[] r0 = this.subscribers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L4;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3] == r7) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            InnerSubscriber<?, ?>[] r2 = EMPTY;
        L19:
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, r0, r2) == false) goto L2;
            return;
        L17:
            InnerSubscriber<?, ?>[] r5 = new InnerSubscriber[r1 - 1];
            System.arraycopy(r0, 0, r5, 0, r3);
            System.arraycopy(r0, r3 + 1, r5, r3, (r1 - r3) - 1);
            r2 = r5;
            goto L19
        L13:
            return;
        L11:
            r3 = -1;
            goto L12
        }

        SimpleQueue<U> getMainQueue() {
            SimplePlainQueue<U> r0 = this.queue;
            if (r0 == null) goto L5;
        L9:
            return r0;
        L5:
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L7;
            r0 = new SpscLinkedArrayQueue(this.bufferSize);
        L8:
            this.queue = r0;
            goto L9
        L7:
            r0 = new SpscArrayQueue(this.maxConcurrency);
            goto L8
        }

        void tryEmitScalar(U r9) {
            if (get() != 0) goto L31;
            if (compareAndSet(0, 1) == false) goto L31;
            long r3 = this.requested.get();
            SimpleQueue<U> r5 = this.queue;
            if (r3 == 0) goto L21;
            if (r5 != null) goto L10;
        L11:
            this.downstream.onNext(r9);
            if (r3 == Long.MAX_VALUE) goto L15;
            this.requested.decrementAndGet();
        L15:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L28;
            if (this.cancelled == true) goto L28;
            int r10 = this.scalarEmitted + 1;
            this.scalarEmitted = r10;
            int r1 = this.scalarLimit;
            if (r10 != r1) goto L28;
            this.scalarEmitted = 0;
            this.upstream.request(r1);
        L28:
            if (decrementAndGet() != 0) goto L37;
            return;
        L37:
            drainLoop();
            return;
        L10:
            if (r5.isEmpty() == true) goto L11;
        L21:
            if (r5 != null) goto L24;
            r5 = getMainQueue();
        L24:
            if (r5.offer(r9) == true) goto L28;
            onError(new IllegalStateException("Scalar queue full?!"));
            return;
        L31:
            if (getMainQueue().offer(r9) == true) goto L35;
            onError(new IllegalStateException("Scalar queue full?!"));
            return;
        L35:
            if (getAndIncrement() == 0) goto L37;
        }

        SimpleQueue<U> getInnerQueue(InnerSubscriber<T, U> r2) {
            SimpleQueue<U> r0 = r2.queue;
            if (r0 != null) goto L6;
            SpscArrayQueue r1 = new SpscArrayQueue(this.bufferSize);
            r2.queue = r1;
            return r1;
        L6:
            return r0;
        }

        void tryEmit(U r7, InnerSubscriber<T, U> r8) {
            if (get() == 0) goto L5;
        L24:
            SimpleQueue r0 = r8.queue;
            if (r0 != null) goto L28;
            r0 = new SpscArrayQueue(this.bufferSize);
            r8.queue = r0;
        L28:
            if (r0.offer(r7) == true) goto L32;
            onError(new MissingBackpressureException("Inner queue full?!"));
            return;
        L32:
            if (getAndIncrement() == 0) goto L34;
            return;
        L34:
            drainLoop();
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L24;
            long r2 = this.requested.get();
            SimpleQueue<U> r1 = r8.queue;
            if (r2 == 0) goto L15;
            if (r1 != null) goto L10;
        L11:
            this.downstream.onNext(r7);
            if (r2 == Long.MAX_VALUE) goto L14;
            this.requested.decrementAndGet();
        L14:
            r8.requestMore(1);
        L22:
            if (decrementAndGet() != 0) goto L34;
            return;
        L10:
            if (r1.isEmpty() == true) goto L11;
        L15:
            if (r1 != null) goto L18;
            r1 = getInnerQueue(r8);
        L18:
            if (r1.offer(r7) == true) goto L22;
            onError(new MissingBackpressureException("Inner queue full?!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L7;
            RxJavaPlugins.onError(r2);
            return;
        L7:
            if (this.errs.addThrowable(r2) == false) goto L9;
            this.done = true;
            drain();
            return;
        L9:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            BackpressureHelper.add(this.requested, r2);
            drain();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == true) goto L10;
            this.cancelled = true;
            this.upstream.cancel();
            disposeAll();
            if (getAndIncrement() != 0) goto L11;
            SimplePlainQueue<U> r1 = this.queue;
            if (r1 == null) goto L12;
            r1.clear();
            return;
        L12:
            return;
        L11:
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainLoop() {
            Subscriber<? super U> r2 = this.downstream;
            int r4 = 1;
        L4:
            if (checkTerminate() == true) goto L5;
            SimplePlainQueue<U> r0 = this.queue;
            long r5 = this.requested.get();
            if (r5 != Long.MAX_VALUE) goto L9;
            boolean r9 = true;
        L10:
            long r14 = 0;
            long r16 = 0;
            if (r0 == null) goto L31;
        L12:
            long r7 = 0;
            Object r18 = null;
        L14:
            if (r5 == 0) goto L22;
            U r10 = r0.poll();
            if (checkTerminate() == true) goto L17;
            if (r10 == null) goto L19;
            r2.onNext(r10);
            r16 = r16 + 1;
            r7 = r7 + 1;
            r5 = r5 - 1;
            r18 = r10;
            goto L14
        L19:
            r18 = r10;
            goto L22
        L17:
            return;
        L22:
            if (r7 == 0) goto L27;
            if (r9 == false) goto L25;
            r5 = Long.MAX_VALUE;
            goto L27
        L25:
            r5 = this.requested.addAndGet(-r7);
        L27:
            if (r5 == 0) goto L31;
            if (r18 != null) goto L12;
        L31:
            boolean r1 = this.done;
            SimplePlainQueue<U> r8 = this.queue;
            InnerSubscriber<?, ?>[] r11 = this.subscribers.get();
            int r12 = r11.length;
            if (r1 == false) goto L43;
            if (r8 != null) goto L35;
        L36:
            if (r12 != 0) goto L43;
            Throwable r3 = this.errs.terminate();
            if (r3 == ExceptionHelper.TERMINATED) goto L167;
            if (r3 != null) goto L41;
            r2.onComplete();
            return;
        L41:
            r2.onError(r3);
            return;
        L167:
            return;
        L35:
            if (r8.isEmpty() == true) goto L36;
        L43:
            int r19 = r4;
            if (r12 == 0) goto L123;
            long r6 = this.lastId;
            int r13 = this.lastIndex;
            if (r12 > r13) goto L48;
        L49:
            if (r12 > r13) goto L51;
            r13 = 0;
        L51:
            int r15 = 0;
        L52:
            if (r15 >= r12) goto L60;
            if (r11[r13].id == r6) goto L60;
            r13 = r13 + 1;
            if (r13 != r12) goto L59;
            r13 = 0;
        L59:
            r15 = r15 + 1;
        L60:
            this.lastIndex = r13;
            this.lastId = r11[r13].id;
        L61:
            int r17 = r13;
            boolean r20 = false;
            int r21 = 0;
        L62:
            if (r21 >= r12) goto L121;
            if (checkTerminate() == true) goto L65;
            InnerSubscriber<T, U> r22 = r11[r17];
            Object r110 = null;
        L68:
            if (checkTerminate() == true) goto L69;
            SimpleQueue<U> r111 = r22.queue;
            if (r111 == null) goto L72;
            int r112 = r12;
            Object r23 = r110;
            long r113 = r14;
        L75:
            if (r5 == r14) goto L92;
            U r114 = r111.poll();     // Catch: Throwable -> L83
            if (r114 == null) goto L78;
            r2.onNext(r114);
            if (checkTerminate() == true) goto L81;
            r5 = r5 - 1;
            r113 = r113 + 1;
            r23 = r114;
            r14 = 0;
            goto L75
        L81:
            return;
        L78:
            r23 = r114;
            r14 = 0;
        L83:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r22.dispose();
            this.errs.addThrowable(th);
            if (this.delayErrors == true) goto L88;
            this.upstream.cancel();
        L88:
            if (checkTerminate() == true) goto L89;
            removeInner(r22);
            r21 = r21 + 1;
            r20 = true;
            int r24 = 1;
        L120:
            r21 = r21 + r24;
            r12 = r112;
            r14 = 0;
            goto L62
        L89:
            return;
        L92:
            if (r113 == r14) goto L97;
            if (r9 == true) goto L95;
            r5 = this.requested.addAndGet(-r113);
        L96:
            r22.requestMore(r113);
            long r115 = 0;
        L99:
            if (r5 == r115) goto L103;
            if (r23 == null) goto L103;
            r12 = r112;
            r110 = r23;
            r14 = 0;
        L103:
            boolean r116 = r22.done;
            SimpleQueue<U> r117 = r22.queue;
            if (r116 == false) goto L114;
            if (r117 != null) goto L107;
        L108:
            removeInner(r22);
            if (checkTerminate() == true) goto L110;
            r16 = r16 + 1;
            r20 = true;
            goto L114
        L110:
            return;
        L107:
            if (r117.isEmpty() == true) goto L108;
        L114:
            if (r5 == 0) goto L115;
            r17 = r17 + 1;
            if (r17 != r112) goto L119;
            r17 = 0;
        L119:
            r24 = 1;
            goto L120
        L115:
            boolean r118 = r20;
        L122:
            this.lastIndex = r17;
            this.lastId = r11[r17].id;
            long r25 = r16;
            long r26 = 0;
        L125:
            if (r25 != r26) goto L127;
        L129:
            if (r118 == true) goto L130;
            r4 = addAndGet(-r19);
            if (r4 != 0) goto L4;
            return;
        L130:
            r4 = r19;
            goto L4
        L127:
            if (this.cancelled == true) goto L129;
            this.upstream.request(r25);
            goto L129
        L95:
            r5 = Long.MAX_VALUE;
            goto L96
        L97:
            r115 = r14;
            goto L99
        L72:
            r112 = r12;
            goto L103
        L69:
            return;
        L65:
            return;
        L121:
            r118 = r20;
            goto L122
        L48:
            if (r11[r13].id == r6) goto L61;
        L123:
            r26 = 0;
            r25 = r16;
            r118 = false;
            goto L125
        L9:
            r9 = false;
            goto L10
        }

        boolean checkTerminate() {
            if (this.cancelled == false) goto L7;
            clearScalarQueue();
            return true;
        L7:
            if (this.delayErrors == false) goto L9;
            return false;
        L9:
            if (this.errs.get() == null) goto L16;
            clearScalarQueue();
            Throwable r0 = this.errs.terminate();
            if (r0 == ExceptionHelper.TERMINATED) goto L13;
            this.downstream.onError(r0);
        L13:
            return true;
        L16:
            return false;
        }

        void clearScalarQueue() {
            SimplePlainQueue<U> r0 = this.queue;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        void disposeAll() {
            InnerSubscriber<?, ?>[] r0 = this.subscribers.get();
            InnerSubscriber<?, ?>[] r1 = CANCELLED;
            if (r0 == r1) goto L16;
            InnerSubscriber<?, ?>[] r2 = this.subscribers.getAndSet(r1);
            if (r2 == r1) goto L17;
            int r3 = r2.length;
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L9;
            r2[r4].dispose();
            r4 = r4 + 1;
            goto L7
        L9:
            Throwable r5 = this.errs.terminate();
            if (r5 != null) goto L12;
            return;
        L12:
            if (r5 == ExceptionHelper.TERMINATED) goto L19;
            RxJavaPlugins.onError(r5);
            return;
        L19:
            return;
        L17:
            return;
        }

        void innerError(InnerSubscriber<T, U> r3, Throwable r4) {
            if (this.errs.addThrowable(r4) == false) goto L10;
            r3.done = true;
            if (this.delayErrors == true) goto L9;
            this.upstream.cancel();
            InnerSubscriber<?, ?>[] r5 = this.subscribers.getAndSet(CANCELLED);
            int r6 = r5.length;
            int r0 = 0;
        L7:
            if (r0 >= r6) goto L9;
            r5[r0].dispose();
            r0 = r0 + 1;
        L9:
            drain();
            return;
        L10:
            RxJavaPlugins.onError(r4);
        }
    }

    public FlowableFlatMap(Flowable<T> r1, Function<? super T, ? extends Publisher<? extends U>> r2, boolean r3, int r4, int r5) {
        super(r1);
        this.mapper = r2;
        this.delayErrors = r3;
        this.maxConcurrency = r4;
        this.bufferSize = r5;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r5) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, r5, this.mapper) == false) goto L5;
        return;
    L5:
        this.source.subscribe(subscribe(r5, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> r7, Function<? super T, ? extends Publisher<? extends U>> r8, boolean r9, int r10, int r11) {
        return new MergeSubscriber(r7, r8, r9, r10, r11);
    }
}
