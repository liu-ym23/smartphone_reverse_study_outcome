package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int capacityHint;
    final Publisher<B> other;

    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B> parent;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> r1) {
            this.parent = r1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B r1) {
            if (this.done == false) goto L5;
            return;
        L5:
            this.parent.innerNext();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r2);
            return;
        L6:
            this.done = true;
            this.parent.innerError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.parent.innerComplete();
        }
    }

    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object NEXT_WINDOW = null;
        private static final long serialVersionUID = 2233020065421370272L;
        final WindowBoundaryInnerSubscriber<T, B> boundarySubscriber;
        final int capacityHint;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        long emitted;
        final AtomicThrowable errors;
        final MpscLinkedQueue<Object> queue;
        final AtomicLong requested;
        final AtomicBoolean stopWindows;
        final AtomicReference<Subscription> upstream;
        UnicastProcessor<T> window;
        final AtomicInteger windows;

        static {
            NEXT_WINDOW = new Object();
        }

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> r1, int r2) {
            this.downstream = r1;
            this.capacityHint = r2;
            this.boundarySubscriber = new WindowBoundaryInnerSubscriber(this);
            this.upstream = new AtomicReference();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.requested = new AtomicLong();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r3) {
            SubscriptionHelper.setOnce(this.upstream, r3, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            this.queue.offer(r2);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            this.boundarySubscriber.dispose();
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.boundarySubscriber.dispose();
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.stopWindows.compareAndSet(false, true) == false) goto L8;
            this.boundarySubscriber.dispose();
            if (this.windows.decrementAndGet() != 0) goto L9;
            SubscriptionHelper.cancel(this.upstream);
            return;
        L9:
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            BackpressureHelper.add(this.requested, r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() != 0) goto L6;
            SubscriptionHelper.cancel(this.upstream);
            return;
        }

        void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        void innerError(Throwable r2) {
            SubscriptionHelper.cancel(this.upstream);
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r2);
        }

        void innerComplete() {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Subscriber<? super Flowable<T>> r0 = this.downstream;
            MpscLinkedQueue<Object> r1 = this.queue;
            AtomicThrowable r2 = this.errors;
            long r3 = this.emitted;
            int r6 = 1;
        L7:
            if (this.windows.get() == 0) goto L8;
            UnicastProcessor<T> r7 = this.window;
            boolean r9 = this.done;
            if (r9 == true) goto L13;
        L19:
            Object r10 = r1.poll();
            if (r10 != null) goto L22;
            boolean r11 = true;
        L23:
            if (r9 == false) goto L34;
            if (r11 == false) goto L34;
            Throwable r4 = r2.terminate();
            if (r4 != null) goto L30;
            if (r7 == null) goto L29;
            this.window = null;
            r7.onComplete();
        L29:
            r0.onComplete();
            return;
        L30:
            if (r7 == null) goto L32;
            this.window = null;
            r7.onError(r4);
        L32:
            r0.onError(r4);
            return;
        L34:
            if (r11 == true) goto L35;
            if (r10 != NEXT_WINDOW) goto L40;
            if (r7 == null) goto L44;
            this.window = null;
            r7.onComplete();
        L44:
            if (this.stopWindows.get() == true) goto L7;
            UnicastProcessor<T> r8 = UnicastProcessor.create(this.capacityHint, this);
            this.window = r8;
            this.windows.getAndIncrement();
            if (r3 != this.requested.get()) goto L47;
            SubscriptionHelper.cancel(this.upstream);
            this.boundarySubscriber.dispose();
            r2.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
            this.done = true;
            goto L7
        L47:
            r3 = r3 + 1;
            r0.onNext(r8);
            goto L7
        L40:
            r7.onNext((T) r10);
            goto L7
        L35:
            this.emitted = r3;
            r6 = addAndGet(-r6);
            if (r6 != 0) goto L7;
            return;
        L22:
            r11 = false;
            goto L23
        L13:
            if (r2.get() == null) goto L19;
            r1.clear();
            Throwable r5 = r2.terminate();
            if (r7 == null) goto L17;
            this.window = null;
            r7.onError(r5);
        L17:
            r0.onError(r5);
            return;
        L8:
            r1.clear();
            this.window = null;
        }
    }

    public FlowableWindowBoundary(Flowable<T> r1, Publisher<B> r2, int r3) {
        super(r1);
        this.other = r2;
        this.capacityHint = r3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> r3) {
        WindowBoundaryMainSubscriber r0 = new WindowBoundaryMainSubscriber(r3, this.capacityHint);
        r3.onSubscribe(r0);
        r0.innerNext();
        this.other.subscribe(r0.boundarySubscriber);
        this.source.subscribe(r0);
    }
}
