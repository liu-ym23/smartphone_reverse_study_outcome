package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
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
final class FlowableBufferBoundary$BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
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
    final io.reactivex.internal.queue.a queue;
    final AtomicLong requested;
    final io.reactivex.disposables.a subscribers;
    final AtomicReference<Subscription> upstream;

    public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> parent;

        public BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> r10) {
            this.parent = r10;
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

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.openComplete(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r10) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, r10);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Open r10) {
            this.parent.open(r10);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary$BufferBoundarySubscriber(Subscriber<? super C> r10, Publisher<? extends Open> r11, Function<? super Open, ? extends Publisher<? extends Close>> r12, Callable<C> r13) {
        this.downstream = r10;
        this.bufferSupplier = r13;
        this.bufferOpen = r11;
        this.bufferClose = r12;
        this.queue = new io.reactivex.internal.queue.a(mf.b.a());
        this.subscribers = new io.reactivex.disposables.a();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.buffers = new LinkedHashMap();
        this.errors = new AtomicThrowable();
    }

    public void boundaryError(Disposable r10, Throwable r11) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.delete(r10);
        onError(r11);
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

    public void close(FlowableBufferBoundary$BufferCloseSubscriber<T, C> r10, long r11) {
        this.subscribers.delete(r10);
        if (this.subscribers.b() != 0) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        boolean r12 = true;
    L6:
        monitor-enter(this);
        Map<Long, C> r13 = this.buffers;     // Catch: Throwable -> L11
        if (r13 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        this.queue.offer(r13.remove(Long.valueOf(r11)));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r12 == false) goto L17;
        this.done = true;
    L17:
        drain();
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r12 = false;
        goto L6
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r10 = this.emitted;
        Subscriber<? super C> r11 = this.downstream;
        io.reactivex.internal.queue.a r12 = this.queue;
        int r13 = 1;
    L6:
        long r14 = this.requested.get();
    L8:
        if (r10 == r14) goto L30;
        if (this.cancelled == true) goto L11;
        boolean r15 = this.done;
        if (r15 == true) goto L16;
    L19:
        Collection r16 = (Collection) r12.poll();
        if (r16 != null) goto L22;
        boolean r17 = true;
    L23:
        if (r15 == false) goto L27;
        if (r17 == false) goto L27;
        r11.onComplete();
        return;
    L27:
        if (r17 == true) goto L30;
        r11.onNext(r16);
        r10 = r10 + 1;
        goto L8
    L22:
        r17 = false;
        goto L23
    L16:
        if (this.errors.get() == null) goto L19;
        r12.clear();
        r11.onError(this.errors.terminate());
        return;
    L11:
        r12.clear();
        return;
    L30:
        if (r10 == r14) goto L32;
    L45:
        this.emitted = r10;
        r13 = addAndGet(-r13);
        if (r13 != 0) goto L6;
        return;
    L32:
        if (this.cancelled == true) goto L33;
        if (this.done == false) goto L45;
        if (this.errors.get() != null) goto L39;
        if (r12.isEmpty() == false) goto L45;
        r11.onComplete();
        return;
    L39:
        r12.clear();
        r11.onError(this.errors.terminate());
        return;
    L33:
        r12.clear();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.subscribers.dispose();
        monitor-enter(this);
        Map<Long, C> r10 = this.buffers;     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<C> r11 = r10.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r11.hasNext() == false) goto L14;
        C r12 = r11.next();     // Catch: Throwable -> L8
        this.queue.offer(r12);     // Catch: Throwable -> L8
        goto L12
    L14:
        this.buffers = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.done = true;
        drain();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable r10) {
        if (this.errors.addThrowable(r10) == false) goto L13;
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
        qf.a.e(r10);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T r10) {
        monitor-enter(this);
        Map<Long, C> r11 = this.buffers;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        Iterator<C> r12 = r11.values().iterator();     // Catch: Throwable -> L7
    L11:
        if (r12.hasNext() == false) goto L13;
        r12.next().add(r10);     // Catch: Throwable -> L7
        goto L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L6;
        BufferOpenSubscriber r11 = new BufferOpenSubscriber(this);
        this.subscribers.add(r11);
        this.bufferOpen.subscribe(r11);
        r10.request(Long.MAX_VALUE);
        return;
    }

    public void open(Open r10) {
        Collection r11 = (Collection) io.reactivex.internal.functions.a.b(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");     // Catch: Throwable -> L17
        Publisher r12 = (Publisher) io.reactivex.internal.functions.a.b(this.bufferClose.apply(r10), "The bufferClose returned a null Publisher");     // Catch: Throwable -> L17
        long r13 = this.index;
        this.index = 1 + r13;
        monitor-enter(this);
        Map<Long, C> r14 = this.buffers;     // Catch: Throwable -> L9
        if (r14 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        r14.put(Long.valueOf(r13), (C) r11);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        FlowableBufferBoundary$BufferCloseSubscriber r15 = new FlowableBufferBoundary$BufferCloseSubscriber(this, r13);
        this.subscribers.add(r15);
        r12.subscribe(r15);
        return;
    L9:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        SubscriptionHelper.cancel(this.upstream);
        onError(th);
    }

    public void openComplete(BufferOpenSubscriber<Open> r10) {
        this.subscribers.delete(r10);
        if (this.subscribers.b() != 0) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        this.done = true;
        drain();
        return;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long r10) {
        io.reactivex.internal.util.a.a(this.requested, r10);
        drain();
    }
}
