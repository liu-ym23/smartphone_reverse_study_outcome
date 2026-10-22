package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] array;
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    final Iterable<? extends Publisher<? extends T>> iterable;

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(Subscriber<? super R> r2, Function<? super Object[], ? extends R> r3, int r4, int r5, boolean r6) {
            this.downstream = r2;
            this.combiner = r3;
            CombineLatestInnerSubscriber<T>[] r7 = new CombineLatestInnerSubscriber[r4];
            int r8 = 0;
        L3:
            if (r8 >= r4) goto L5;
            r7[r8] = new CombineLatestInnerSubscriber(this, r8, r5);
            r8 = r8 + 1;
            goto L3
        L5:
            this.subscribers = r7;
            this.latest = new Object[r4];
            this.queue = new SpscLinkedArrayQueue(r5);
            this.requested = new AtomicLong();
            this.error = new AtomicReference();
            this.delayErrors = r6;
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
            this.cancelled = true;
            cancelAll();
        }

        void subscribe(Publisher<? extends T>[] r5, int r6) {
            CombineLatestInnerSubscriber<T>[] r0 = this.subscribers;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L10;
            if (this.done == true) goto L14;
            if (this.cancelled == true) goto L15;
            r5[r1].subscribe(r0[r1]);
            r1 = r1 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }

        void innerValue(int r4, T r5) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L15
            int r1 = this.nonEmptySources;     // Catch: Throwable -> L15
            if (r0[r4] != null) goto L6;
            r1 = r1 + 1;     // Catch: Throwable -> L15
            this.nonEmptySources = r1;     // Catch: Throwable -> L15
        L6:
            r0[r4] = r5;     // Catch: Throwable -> L15
            if (r0.length != r1) goto L9;
            this.queue.offer(this.subscribers[r4], r0.clone());     // Catch: Throwable -> L15
            boolean r6 = false;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r6 == false) goto L13;
            this.subscribers[r4].requestOne();
            return;
        L13:
            drain();
            return;
        L9:
            r6 = true;
        L15:
            th = move-exception;
            throw th;
        }

        void innerComplete(int r3) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L15
            if (r0[r3] == null) goto L11;
            int r4 = this.completedSources + 1;     // Catch: Throwable -> L15
            if (r4 != r0.length) goto L8;
            this.done = true;     // Catch: Throwable -> L15
        L12:
            monitor-exit(this);     // Catch: Throwable -> L15
            drain();
            return;
        L8:
            this.completedSources = r4;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L11:
            this.done = true;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        void innerError(int r2, Throwable r3) {
            if (ExceptionHelper.addThrowable(this.error, r3) == true) goto L5;
            RxJavaPlugins.onError(r3);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            cancelAll();
            this.done = true;
            drain();
            return;
        L7:
            innerComplete(r2);
        }

        void drainOutput() {
            Subscriber<? super R> r0 = this.downstream;
            SpscLinkedArrayQueue<Object> r1 = this.queue;
            int r2 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            Throwable r3 = this.error.get();
            if (r3 != null) goto L9;
            boolean r4 = this.done;
            boolean r5 = r1.isEmpty();
            if (r5 == true) goto L14;
            r0.onNext(null);
        L14:
            if (r4 == false) goto L18;
            if (r5 == false) goto L18;
            r0.onComplete();
            return;
        L18:
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L9:
            r1.clear();
            r0.onError(r3);
            return;
        L5:
            r1.clear();
        }

        void drainAsync() {
            Subscriber<? super R> r0 = this.downstream;
            SpscLinkedArrayQueue<?> r1 = this.queue;
            int r3 = 1;
        L3:
            long r4 = this.requested.get();
            long r8 = 0;
        L5:
            if (r8 == r4) goto L21;
            boolean r11 = this.done;
            Object r12 = r1.poll();
            if (r12 != null) goto L9;
            boolean r13 = true;
        L11:
            if (checkTerminated(r11, r13, r0, r1) == true) goto L12;
            if (r13 == true) goto L21;
            r0.onNext((Object) ObjectHelper.requireNonNull(this.combiner.apply((Object[]) r1.poll()), "The combiner returned a null value"));
            ((CombineLatestInnerSubscriber) r12).requestOne();
            r8 = r8 + 1;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            cancelAll();
            ExceptionHelper.addThrowable(this.error, th);
            r0.onError(ExceptionHelper.terminate(this.error));
            return;
        L12:
            return;
        L9:
            r13 = false;
        L21:
            if (r8 != r4) goto L26;
            if (checkTerminated(this.done, r1.isEmpty(), r0, r1) == false) goto L26;
            return;
        L26:
            if (r8 != 0) goto L28;
        L30:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L3;
            return;
        L28:
            if (r4 == Long.MAX_VALUE) goto L30;
            this.requested.addAndGet(-r8);
            goto L30
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.outputFused == false) goto L8;
            drainOutput();
            return;
        L8:
            drainAsync();
        }

        boolean checkTerminated(boolean r3, boolean r4, Subscriber<?> r5, SpscLinkedArrayQueue<?> r6) {
            if (this.cancelled == false) goto L6;
            cancelAll();
            r6.clear();
            return true;
        L6:
            if (r3 == true) goto L8;
            return false;
        L8:
            if (this.delayErrors == false) goto L17;
            if (r4 == false) goto L28;
            cancelAll();
            Throwable r2 = ExceptionHelper.terminate(this.error);
            if (r2 != null) goto L13;
        L15:
            r5.onComplete();
        L16:
            return true;
        L13:
            if (r2 == ExceptionHelper.TERMINATED) goto L15;
            r5.onError(r2);
            goto L16
        L28:
            return false;
        L17:
            Throwable r7 = ExceptionHelper.terminate(this.error);
            if (r7 != null) goto L20;
        L23:
            if (r4 == false) goto L29;
            cancelAll();
            r5.onComplete();
            return true;
        L29:
            return false;
        L20:
            if (r7 == ExceptionHelper.TERMINATED) goto L23;
            cancelAll();
            r6.clear();
            r5.onError(r7);
            return true;
        }

        void cancelAll() {
            CombineLatestInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r3) {
            boolean r1 = false;
            if ((r3 & 4) == 0) goto L5;
            return 0;
        L5:
            int r4 = r3 & 2;
            if (r4 == 0) goto L8;
            r1 = true;
        L8:
            this.outputFused = r1;
            return r4;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Object r0 = this.queue.poll();
            if (r0 != null) goto L6;
            return null;
        L6:
            Object[] r1 = (Object[]) this.queue.poll();
            R r2 = (R) ObjectHelper.requireNonNull(this.combiner.apply(r1), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) r0).requestOne();
            return r2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> r1, int r2, int r3) {
            this.parent = r1;
            this.index = r2;
            this.prefetch = r3;
            this.limit = r3 - (r3 >> 2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, this.prefetch);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            this.parent.innerValue(this.index, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void requestOne() {
            int r0 = this.produced + 1;
            if (r0 != this.limit) goto L5;
            this.produced = 0;
            get().request(r0);
            return;
        L5:
            this.produced = r0;
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ FlowableCombineLatest this$0;

        SingletonArrayFunc(FlowableCombineLatest r1) {
            this.this$0 = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T r3) throws Exception {
            return this.this$0.combiner.apply(new Object[]{r3});
        }
    }

    public FlowableCombineLatest(Publisher<? extends T>[] r1, Function<? super Object[], ? extends R> r2, int r3, boolean r4) {
        this.array = r1;
        this.iterable = null;
        this.combiner = r2;
        this.bufferSize = r3;
        this.delayErrors = r4;
    }

    public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> r2, Function<? super Object[], ? extends R> r3, int r4, boolean r5) {
        this.array = null;
        this.iterable = r2;
        this.combiner = r3;
        this.bufferSize = r4;
        this.delayErrors = r5;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> r10) {
        Publisher<? extends T>[] r0 = this.array;
        if (r0 != null) goto L24;
        r0 = new Publisher[8];
        Iterator r2 = (Iterator) ObjectHelper.requireNonNull(this.iterable.iterator(), "The iterator returned is null");     // Catch: Throwable -> L21
        int r3 = 0;
    L35:
        if (r2.hasNext() == false) goto L25;
        Publisher<? extends T> r4 = (Publisher) ObjectHelper.requireNonNull(r2.next(), "The publisher returned by the iterator is null");     // Catch: Throwable -> L15
        if (r3 != r0.length) goto L14;
        Publisher<? extends T>[] r5 = new Publisher[(r3 >> 2) + r3];
        System.arraycopy(r0, 0, r5, 0, r3);
        r0 = r5;
    L14:
        r0[r3] = r4;
        r3 = r3 + 1;
    L15:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r10);
        return;
    L25:
        int r8 = r3;
        if (r8 != 0) goto L30;
        EmptySubscription.complete(r10);
        return;
    L30:
        if (r8 != 1) goto L33;
        r0[0].subscribe(new FlowableMap.MapSubscriber(r10, new SingletonArrayFunc(this)));
        return;
    L33:
        CombineLatestCoordinator r1 = new CombineLatestCoordinator(r10, this.combiner, r8, this.bufferSize, this.delayErrors);
        r10.onSubscribe(r1);
        r1.subscribe(r0, r8);
        return;
    L18:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r10);
        return;
    L21:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r10);
        return;
    L24:
        r3 = r0.length;
        goto L25
    }
}
