package io.reactivex.internal.operators.flowable;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowablePublishAlt<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {
    final int bufferSize;
    final AtomicReference<PublishConnection<T>> current;
    final Publisher<T> source;

    static final class InnerSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 2845000326761540265L;
        final Subscriber<? super T> downstream;
        long emitted;
        final PublishConnection<T> parent;

        InnerSubscription(Subscriber<? super T> r1, PublishConnection<T> r2) {
            this.downstream = r1;
            this.parent = r2;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            BackpressureHelper.addCancel(this, r1);
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.remove(this);
            this.parent.drain();
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class PublishConnection<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = null;
        static final InnerSubscription[] TERMINATED = null;
        private static final long serialVersionUID = -1672047311619175801L;
        final int bufferSize;
        final AtomicBoolean connect;
        int consumed;
        final AtomicReference<PublishConnection<T>> current;
        volatile boolean done;
        Throwable error;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<InnerSubscription<T>[]> subscribers;
        final AtomicReference<Subscription> upstream;

        static {
            EMPTY = new InnerSubscription[0];
            TERMINATED = new InnerSubscription[0];
        }

        PublishConnection(AtomicReference<PublishConnection<T>> r1, int r2) {
            this.current = r1;
            this.upstream = new AtomicReference();
            this.connect = new AtomicBoolean();
            this.bufferSize = r2;
            this.subscribers = new AtomicReference(EMPTY);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscribers.getAndSet(TERMINATED);
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.subscribers.get() != TERMINATED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r4) {
            if (SubscriptionHelper.setOnce(this.upstream, r4) == true) goto L5;
            return;
        L5:
            if ((r4 instanceof QueueSubscription) == false) goto L14;
            QueueSubscription r0 = (QueueSubscription) r4;
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r4.request(this.bufferSize);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.bufferSize);
            r4.request(this.bufferSize);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
            RxJavaPlugins.onError(r2);
            return;
        L5:
            this.error = r2;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            SimpleQueue<T> r0 = this.queue;
            int r2 = this.consumed;
            int r3 = this.bufferSize;
            int r4 = r3 - (r3 >> 2);
            if (this.sourceMode == 1) goto L8;
            boolean r5 = true;
        L9:
            int r7 = 1;
            SimpleQueue<T> r6 = r0;
            int r1 = r2;
        L10:
            if (r6 == null) goto L53;
            InnerSubscription<T>[] r8 = this.subscribers.get();
            int r9 = r8.length;
            long r10 = Long.MAX_VALUE;
            int r12 = 0;
            boolean r13 = false;
        L12:
            if (r12 >= r9) goto L17;
            InnerSubscription<T> r14 = r8[r12];
            long r15 = r14.get();
            if (r15 == Long.MIN_VALUE) goto L16;
            r10 = Math.min(r15 - r14.emitted, r10);
            r13 = true;
        L16:
            r12 = r12 + 1;
            goto L12
        L17:
            long r16 = 0;
            if (r13 == true) goto L21;
            r10 = 0;
        L21:
            if (r10 == r16) goto L51;
            boolean r11 = this.done;
            T r17 = r6.poll();     // Catch: Throwable -> L47
            if (r17 != null) goto L26;
            boolean r18 = true;
        L28:
            if (checkTerminated(r11, r18) == true) goto L29;
            if (r18 == true) goto L51;
            int r19 = r8.length;
            int r110 = 0;
        L34:
            if (r110 >= r19) goto L39;
            InnerSubscription<T> r20 = r8[r110];
            if (r20.isCancelled() == true) goto L38;
            r20.downstream.onNext(r17);
            r20.emitted++;
        L38:
            r110 = r110 + 1;
            goto L34
        L39:
            if (r5 == false) goto L43;
            r1 = r1 + 1;
            if (r1 != r4) goto L43;
            this.upstream.get().request(r4);
            r1 = 0;
        L43:
            r10 = r10 - 1;
            if (r8 != this.subscribers.get()) goto L10;
            r16 = 0;
            goto L21
        L29:
            return;
        L26:
            r18 = false;
        L47:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.get().cancel();
            r6.clear();
            this.done = true;
            signalError(th);
            return;
        L51:
            if (checkTerminated(this.done, r6.isEmpty()) == false) goto L53;
            return;
        L53:
            this.consumed = r1;
            r7 = addAndGet(-r7);
            if (r7 == 0) goto L55;
            if (r6 != null) goto L10;
            r6 = this.queue;
            goto L10
        L55:
            return;
        L8:
            r5 = false;
            goto L9
        }

        boolean checkTerminated(boolean r3, boolean r4) {
            int r0 = 0;
            if (r3 == false) goto L16;
            if (r4 == false) goto L16;
            Throwable r5 = this.error;
            if (r5 == null) goto L8;
            signalError(r5);
            return true;
        L8:
            InnerSubscription<T>[] r2 = this.subscribers.getAndSet(TERMINATED);
            int r6 = r2.length;
        L9:
            if (r0 >= r6) goto L20;
            InnerSubscription<T> r7 = r2[r0];
            if (r7.isCancelled() == true) goto L13;
            r7.downstream.onComplete();
        L13:
            r0 = r0 + 1;
            goto L9
        L20:
            return true;
        L16:
            return false;
        }

        void signalError(Throwable r5) {
            InnerSubscription<T>[] r4 = this.subscribers.getAndSet(TERMINATED);
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            InnerSubscription<T> r2 = r4[r1];
            if (r2.isCancelled() == true) goto L7;
            r2.downstream.onError(r5);
        L7:
            r1 = r1 + 1;
            goto L3
        }

        boolean add(InnerSubscription<T> r5) {
        L2:
            InnerSubscription<T>[] r0 = this.subscribers.get();
            if (r0 == TERMINATED) goto L4;
            int r1 = r0.length;
            InnerSubscription[] r3 = new InnerSubscription[r1 + 1];
            System.arraycopy(r0, 0, r3, 0, r1);
            r3[r1] = r5;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, r0, r3) == false) goto L2;
            return true;
        L4:
            return false;
        }

        void remove(InnerSubscription<T> r7) {
        L2:
            InnerSubscription<T>[] r0 = this.subscribers.get();
            int r1 = r0.length;
            if (r1 == 0) goto L20;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            if (r0[r3] == r7) goto L12;
            r3 = r3 + 1;
        L12:
            if (r3 < 0) goto L13;
            if (r1 != 1) goto L17;
            InnerSubscription[] r2 = EMPTY;
        L19:
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, r0, r2) == false) goto L2;
            return;
        L17:
            InnerSubscription[] r5 = new InnerSubscription[r1 - 1];
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
    }

    public FlowablePublishAlt(Publisher<T> r1, int r2) {
        this.source = r1;
        this.bufferSize = r2;
        this.current = new AtomicReference();
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    public int publishBufferSize() {
        return this.bufferSize;
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> r5) {
    L2:
        PublishConnection<T> r0 = this.current.get();
        if (r0 != null) goto L5;
    L6:
        PublishConnection<T> r1 = new PublishConnection(this.current, this.bufferSize);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, r0, r1) == false) goto L2;
        r0 = r1;
    L10:
        boolean r2 = false;
        if (r0.connect.get() == false) goto L13;
    L22:
        r5.accept(r0);     // Catch: Throwable -> L19
        if (r2 == false) goto L27;
        this.source.subscribe(r0);
        return;
    L27:
        return;
    L19:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.wrapOrThrow(th);
    L13:
        if (r0.connect.compareAndSet(false, true) == false) goto L22;
        r2 = true;
        goto L22
    L5:
        if (r0.isDisposed() == false) goto L10;
        goto L6
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r5) {
    L2:
        PublishConnection<T> r0 = this.current.get();
        if (r0 != null) goto L8;
        PublishConnection<T> r1 = new PublishConnection(this.current, this.bufferSize);
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, r0, r1) == false) goto L2;
        r0 = r1;
    L8:
        InnerSubscription<T> r4 = new InnerSubscription(r5, r0);
        r5.onSubscribe(r4);
        if (r0.add(r4) == true) goto L11;
        Throwable r6 = r0.error;
        if (r6 == null) goto L18;
        r5.onError(r6);
        return;
    L18:
        r5.onComplete();
        return;
    L11:
        if (r4.isCancelled() == false) goto L13;
        r0.remove(r4);
        return;
    L13:
        r0.drain();
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(Disposable r2) {
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.current, (PublishConnection) r2, null);
    }
}
