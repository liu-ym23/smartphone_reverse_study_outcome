package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error;
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested;
        Subscription upstream;

        FlattenIterableSubscriber(Subscriber<? super R> r1, Function<? super T, ? extends Iterable<? extends R>> r2, int r3) {
            this.downstream = r1;
            this.mapper = r2;
            this.prefetch = r3;
            this.limit = r3 - (r3 >> 2);
            this.error = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L16;
            this.upstream = r4;
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(3);
            if (r1 != 1) goto L11;
            this.fusionMode = r1;
            this.queue = r0;
            this.done = true;
            this.downstream.onSubscribe(this);
            return;
        L11:
            if (r1 != 2) goto L14;
            this.fusionMode = r1;
            this.queue = r0;
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            r4.request(this.prefetch);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.fusionMode == 0) goto L8;
        L11:
            drain();
            return;
        L8:
            if (this.queue.offer(r2) == true) goto L11;
            onError(new MissingBackpressureException("Queue is full?!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
        L7:
            RxJavaPlugins.onError(r2);
            return;
        L5:
            if (ExceptionHelper.addThrowable(this.error, r2) == false) goto L7;
            this.done = true;
            drain();
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
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<?> r2 = this.downstream;
            SimpleQueue<T> r3 = this.queue;
            boolean r5 = true;
            if (this.fusionMode == 1) goto L8;
            boolean r0 = true;
        L9:
            Iterator<? extends R> r6 = this.current;
            int r7 = 1;
        L11:
            if (r6 != null) goto L31;
            boolean r9 = this.done;
            T r10 = r3.poll();     // Catch: Throwable -> L28
            if (r10 != null) goto L16;
            boolean r11 = r5;
        L18:
            if (checkTerminated(r9, r11, r2, r3) == true) goto L19;
            if (r10 == null) goto L31;
            r6 = this.mapper.apply(r10).iterator();     // Catch: Throwable -> L25
            if (r6.hasNext() == false) goto L23;
            this.current = r6;
            goto L31
        L23:
            consumedOne(r0);
            r6 = null;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            ExceptionHelper.addThrowable(this.error, th);
            r2.onError(ExceptionHelper.terminate(this.error));
            return;
        L19:
            return;
        L16:
            r11 = false;
        L28:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            ExceptionHelper.addThrowable(this.error, th);
            Throwable r1 = ExceptionHelper.terminate(this.error);
            this.current = null;
            r3.clear();
            r2.onError(r1);
            return;
        L31:
            if (r6 == null) goto L70;
            long r12 = this.requested.get();
            long r13 = 0;
        L34:
            if (r13 == r12) goto L54;
            if (checkTerminated(this.done, false, r2, r3) == true) goto L37;
            r2.onNext((Object) ObjectHelper.requireNonNull(r6.next(), "The iterator returned a null value"));
            if (checkTerminated(this.done, false, r2, r3) == true) goto L41;
            r13 = r13 + 1;
            if (r6.hasNext() == true) goto L34;
            consumedOne(r0);
            this.current = null;
            r6 = null;
        L47:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.current = null;
            this.upstream.cancel();
            ExceptionHelper.addThrowable(this.error, th);
            r2.onError(ExceptionHelper.terminate(this.error));
            return;
        L41:
            return;
        L50:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.current = null;
            this.upstream.cancel();
            ExceptionHelper.addThrowable(this.error, th);
            r2.onError(ExceptionHelper.terminate(this.error));
            return;
        L37:
            return;
        L54:
            if (r13 != r12) goto L64;
            boolean r8 = this.done;
            if (r3.isEmpty() == false) goto L59;
            if (r6 != null) goto L59;
            boolean r14 = true;
        L61:
            if (checkTerminated(r8, r14, r2, r3) == false) goto L64;
            return;
        L59:
            r14 = false;
        L64:
            if (r13 != 0) goto L66;
        L68:
            if (r6 != null) goto L70;
        L73:
            r5 = true;
            goto L11
        L66:
            if (r12 == Long.MAX_VALUE) goto L68;
            this.requested.addAndGet(-r13);
        L70:
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L73;
            return;
        L8:
            r0 = false;
            goto L9
        }

        void consumedOne(boolean r3) {
            if (r3 == false) goto L8;
            int r4 = this.consumed + 1;
            if (r4 != this.limit) goto L6;
            this.consumed = 0;
            this.upstream.request(r4);
            return;
        L6:
            this.consumed = r4;
            return;
        }

        boolean checkTerminated(boolean r4, boolean r5, Subscriber<?> r6, SimpleQueue<?> r7) {
            if (this.cancelled == false) goto L6;
            this.current = null;
            r7.clear();
            return true;
        L6:
            if (r4 == true) goto L8;
            return false;
        L8:
            if (this.error.get() == null) goto L11;
            Throwable r8 = ExceptionHelper.terminate(this.error);
            this.current = null;
            r7.clear();
            r6.onError(r8);
            return true;
        L11:
            if (r5 == false) goto L16;
            r6.onComplete();
            return true;
        L16:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.current == null) goto L5;
        L7:
            return false;
        L5:
            if (this.queue.isEmpty() == false) goto L7;
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Iterator<? extends R> r0 = this.current;
        L4:
            if (r0 != null) goto L12;
            T r1 = this.queue.poll();
            if (r1 == null) goto L7;
            r0 = this.mapper.apply(r1).iterator();
            if (r0.hasNext() == true) goto L11;
            r0 = null;
            goto L4
        L11:
            this.current = r0;
            goto L12
        L7:
            return null;
        L12:
            R r2 = (R) ObjectHelper.requireNonNull(r0.next(), "The iterator returned a null value");
            if (r0.hasNext() == true) goto L15;
            this.current = null;
        L15:
            return r2;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 1) != 0) goto L5;
            return 0;
        L5:
            if (this.fusionMode != 1) goto L9;
            return 1;
        L9:
            return 0;
        }
    }

    public FlowableFlattenIterable(Flowable<T> r1, Function<? super T, ? extends Iterable<? extends R>> r2, int r3) {
        super(r1);
        this.mapper = r2;
        this.prefetch = r3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r4) {
        if ((this.source instanceof Callable) == true) goto L21;
        this.source.subscribe(new FlattenIterableSubscriber(r4, this.mapper, this.prefetch));
        return;
    L21:
        Object r0 = ((Callable) this.source).call();     // Catch: Throwable -> L14
        if (r0 != null) goto L19;
        EmptySubscription.complete(r4);
        return;
    L19:
        FlowableFromIterable.subscribe(r4, this.mapper.apply(r0).iterator());
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r4);
        return;
    L14:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r4);
    }
}
