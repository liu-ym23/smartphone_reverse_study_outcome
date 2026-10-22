package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    final Publisher<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
        final Publisher<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        Map<Long, C> buffers;
        volatile boolean cancelled;
        volatile boolean done;
        final Subscriber<? super C> downstream;
        long emitted;
        final AtomicThrowable errors;
        long index;
        final SpscLinkedArrayQueue<C> queue;
        final AtomicLong requested;
        final CompositeDisposable subscribers;
        final AtomicReference<Subscription> upstream;

        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> parent;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription r3) {
                SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open r1) {
                this.parent.open(r1);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable r2) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.boundaryError(this, r2);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.openComplete(this);
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

        BufferBoundarySubscriber(Subscriber<? super C> r1, Publisher<? extends Open> r2, Function<? super Open, ? extends Publisher<? extends Close>> r3, Callable<C> r4) {
            this.downstream = r1;
            this.bufferSupplier = r4;
            this.bufferOpen = r2;
            this.bufferClose = r3;
            this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
            this.subscribers = new CompositeDisposable();
            this.requested = new AtomicLong();
            this.upstream = new AtomicReference();
            this.buffers = new LinkedHashMap();
            this.errors = new AtomicThrowable();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            if (SubscriptionHelper.setOnce(this.upstream, r3) == false) goto L6;
            BufferOpenSubscriber r0 = new BufferOpenSubscriber(this);
            this.subscribers.add(r0);
            this.bufferOpen.subscribe(r0);
            r3.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r3) {
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L13
            if (r0 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L13
        L9:
            if (r1.hasNext() == false) goto L11;
            r1.next().add(r3);     // Catch: Throwable -> L13
            goto L9
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L13;
            this.subscribers.dispose();
            monitor-enter(this);
            this.buffers = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            this.done = true;
            drain();
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscribers.dispose();
            monitor-enter(this);
            Map<Long, C> r0 = this.buffers;     // Catch: Throwable -> L16
            if (r0 != null) goto L8;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L8:
            Iterator<C> r1 = r0.values().iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L12;
            C r2 = r1.next();     // Catch: Throwable -> L16
            this.queue.offer(r2);     // Catch: Throwable -> L16
            goto L10
        L12:
            this.buffers = null;     // Catch: Throwable -> L16
            monitor-exit(this);     // Catch: Throwable -> L16
            this.done = true;
            drain();
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r2) {
            BackpressureHelper.add(this.requested, r2);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.cancel(this.upstream) == false) goto L15;
            this.cancelled = true;
            this.subscribers.dispose();
            monitor-enter(this);
            this.buffers = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            if (getAndIncrement() == 0) goto L18;
            this.queue.clear();
            return;
        L18:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        void open(Open r6) {
            Collection r0 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L16
            Publisher r7 = (Publisher) ObjectHelper.requireNonNull(this.bufferClose.apply(r6), "The bufferClose returned a null Publisher");     // Catch: Throwable -> L16
            long r1 = this.index;
            this.index = 1 + r1;
            monitor-enter(this);
            Map<Long, C> r3 = this.buffers;     // Catch: Throwable -> L13
            if (r3 != null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L9:
            r3.put(Long.valueOf(r1), (C) r0);     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            BufferCloseSubscriber r2 = new BufferCloseSubscriber(this, r1);
            this.subscribers.add(r2);
            r7.subscribe(r2);
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            SubscriptionHelper.cancel(this.upstream);
            onError(th);
        }

        void openComplete(BufferOpenSubscriber<Open> r2) {
            this.subscribers.delete(r2);
            if (this.subscribers.size() != 0) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
            return;
        }

        void close(BufferCloseSubscriber<T, C> r4, long r5) {
            this.subscribers.delete(r4);
            if (this.subscribers.size() != 0) goto L5;
            SubscriptionHelper.cancel(this.upstream);
            boolean r6 = true;
        L6:
            monitor-enter(this);
            Map<Long, C> r1 = this.buffers;     // Catch: Throwable -> L17
            if (r1 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L11:
            this.queue.offer(r1.remove(Long.valueOf(r5)));     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            if (r6 == false) goto L15;
            this.done = true;
        L15:
            drain();
            return;
        L17:
            th = move-exception;
            throw th;
        L5:
            r6 = false;
            goto L6
        }

        void boundaryError(Disposable r2, Throwable r3) {
            SubscriptionHelper.cancel(this.upstream);
            this.subscribers.delete(r2);
            onError(r3);
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            long r0 = this.emitted;
            Subscriber<? super C> r2 = this.downstream;
            SpscLinkedArrayQueue<C> r3 = this.queue;
            int r5 = 1;
        L6:
            long r6 = this.requested.get();
        L8:
            if (r0 == r6) goto L30;
            if (this.cancelled == true) goto L11;
            boolean r9 = this.done;
            if (r9 == true) goto L16;
        L19:
            C r10 = r3.poll();
            if (r10 != null) goto L22;
            boolean r11 = true;
        L23:
            if (r9 == false) goto L27;
            if (r11 == false) goto L27;
            r2.onComplete();
            return;
        L27:
            if (r11 == true) goto L30;
            r2.onNext(r10);
            r0 = r0 + 1;
            goto L8
        L22:
            r11 = false;
            goto L23
        L16:
            if (this.errors.get() == null) goto L19;
            r3.clear();
            r2.onError(this.errors.terminate());
            return;
        L11:
            r3.clear();
            return;
        L30:
            if (r0 == r6) goto L32;
        L45:
            this.emitted = r0;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L6;
            return;
        L32:
            if (this.cancelled == true) goto L33;
            if (this.done == false) goto L45;
            if (this.errors.get() != null) goto L39;
            if (r3.isEmpty() == false) goto L45;
            r2.onComplete();
            return;
        L39:
            r3.clear();
            r2.onError(this.errors.terminate());
            return;
        L33:
            r3.clear();
        }
    }

    static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundarySubscriber<T, C, ?, ?> parent;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> r1, long r2) {
            this.parent = r1;
            this.index = r2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this, r3, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object r3) {
            Subscription r4 = get();
            if (r4 == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            r4.cancel();
            this.parent.close(this, this.index);
            return;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (get() == SubscriptionHelper.CANCELLED) goto L5;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.close(this, this.index);
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

    public FlowableBufferBoundary(Flowable<T> r1, Publisher<? extends Open> r2, Function<? super Open, ? extends Publisher<? extends Close>> r3, Callable<U> r4) {
        super(r1);
        this.bufferOpen = r2;
        this.bufferClose = r3;
        this.bufferSupplier = r4;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> r5) {
        BufferBoundarySubscriber r0 = new BufferBoundarySubscriber(r5, this.bufferOpen, this.bufferClose, this.bufferSupplier);
        r5.onSubscribe(r0);
        this.source.subscribe(r0);
    }
}
