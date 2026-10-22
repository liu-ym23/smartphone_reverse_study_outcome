package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRefCount<T> extends Flowable<T> {
    RefConnection connection;
    final int n;
    final Scheduler scheduler;
    final ConnectableFlowable<T> source;
    final long timeout;
    final TimeUnit unit;

    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final FlowableRefCount<?> parent;
        long subscriberCount;
        Disposable timer;

        @Override // io.reactivex.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Disposable r1) throws Exception {
            accept2(r1);
        }

        RefConnection(FlowableRefCount<?> r1) {
            this.parent = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.timeout(this);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Disposable r3) throws Exception {
            DisposableHelper.replace(this, r3);
            FlowableRefCount<?> r0 = this.parent;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.disconnectedEarly == false) goto L7;
            ((ResettableConnectable) this.parent.source).resetIf(r3);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }
    }

    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final Subscriber<? super T> downstream;
        final FlowableRefCount<T> parent;
        Subscription upstream;

        RefCountSubscriber(Subscriber<? super T> r1, FlowableRefCount<T> r2, RefConnection r3) {
            this.downstream = r1;
            this.parent = r2;
            this.connection = r3;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r3) {
            if (compareAndSet(false, true) == false) goto L5;
            this.parent.terminated(this.connection);
            this.downstream.onError(r3);
            return;
        L5:
            RxJavaPlugins.onError(r3);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.terminated(this.connection);
            this.downstream.onComplete();
            return;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r1) {
            this.upstream.request(r1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.cancel(this.connection);
            return;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription r2) {
            if (SubscriptionHelper.validate(this.upstream, r2) == false) goto L6;
            this.upstream = r2;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> r8) {
        this(r8, 1, 0, TimeUnit.NANOSECONDS, null);
    }

    public FlowableRefCount(ConnectableFlowable<T> r1, int r2, long r3, TimeUnit r5, Scheduler r6) {
        this.source = r1;
        this.n = r2;
        this.timeout = r3;
        this.unit = r5;
        this.scheduler = r6;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> r6) {
        monitor-enter(this);
        RefConnection r0 = this.connection;     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
        r0 = new RefConnection(this);     // Catch: Throwable -> L22
        this.connection = r0;     // Catch: Throwable -> L22
    L6:
        long r1 = r0.subscriberCount;     // Catch: Throwable -> L22
        if (r1 == 0) goto L9;
    L11:
        long r2 = r1 + 1;     // Catch: Throwable -> L22
        r0.subscriberCount = r2;     // Catch: Throwable -> L22
        if (r0.connected == false) goto L14;
    L16:
        boolean r3 = false;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L22
        this.source.subscribe(new RefCountSubscriber(r6, this, r0));
        if (r3 == false) goto L27;
        this.source.connect(r0);
        return;
    L27:
        return;
    L14:
        if (r2 != this.n) goto L16;
        r3 = true;
        r0.connected = true;     // Catch: Throwable -> L22
        goto L17
    L9:
        if (r0.timer == null) goto L11;
        r0.timer.dispose();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    void cancel(RefConnection r5) {
        monitor-enter(this);
        RefConnection r0 = this.connection;     // Catch: Throwable -> L25
        if (r0 == null) goto L23;
        if (r0 != r5) goto L23;
        long r1 = r5.subscriberCount - 1;     // Catch: Throwable -> L25
        r5.subscriberCount = r1;     // Catch: Throwable -> L25
        if (r1 == 0) goto L10;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L10:
        if (r5.connected == false) goto L21;
        if (this.timeout != 0) goto L17;
        timeout(r5);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L17:
        SequentialDisposable r2 = new SequentialDisposable();     // Catch: Throwable -> L25
        r5.timer = r2;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        r2.replace(this.scheduler.scheduleDirect(r5, this.timeout, this.unit));
        return;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    void terminated(RefConnection r9) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if ((this.source instanceof FlowablePublishClassic) == false) goto L12;
        RefConnection r0 = this.connection;     // Catch: Throwable -> L20
        if (r0 == null) goto L9;
        if (r0 != r9) goto L9;
        this.connection = null;     // Catch: Throwable -> L20
        clearTimer(r9);     // Catch: Throwable -> L20
    L9:
        long r1 = r9.subscriberCount - 1;     // Catch: Throwable -> L20
        r9.subscriberCount = r1;     // Catch: Throwable -> L20
        if (r1 != 0) goto L18;
        reset(r9);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L12:
        RefConnection r2 = this.connection;     // Catch: Throwable -> L20
        if (r2 == null) goto L18;
        if (r2 != r9) goto L18;
        clearTimer(r9);     // Catch: Throwable -> L20
        long r6 = r9.subscriberCount - 1;     // Catch: Throwable -> L20
        r9.subscriberCount = r6;     // Catch: Throwable -> L20
        if (r6 != 0) goto L18;
        this.connection = null;     // Catch: Throwable -> L20
        reset(r9);     // Catch: Throwable -> L20
        goto L18
    }

    void clearTimer(RefConnection r1) {
        if (r1.timer == null) goto L6;
        r1.timer.dispose();
        r1.timer = null;
        return;
    }

    void reset(RefConnection r2) {
        ConnectableFlowable<T> r1 = this.source;
        if ((r1 instanceof Disposable) == false) goto L6;
        ((Disposable) r1).dispose();
        return;
    L6:
        if ((r1 instanceof ResettableConnectable) == false) goto L10;
        ((ResettableConnectable) r1).resetIf(r2.get());
        return;
    }

    void timeout(RefConnection r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (r5.subscriberCount == 0) goto L6;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L6:
        if (r5 != this.connection) goto L15;
        this.connection = null;     // Catch: Throwable -> L17
        Disposable r0 = r5.get();     // Catch: Throwable -> L17
        DisposableHelper.dispose(r5);     // Catch: Throwable -> L17
        ConnectableFlowable<T> r1 = this.source;     // Catch: Throwable -> L17
        if ((r1 instanceof Disposable) == false) goto L11;
        ((Disposable) r1).dispose();     // Catch: Throwable -> L17
        goto L15
    L11:
        if ((r1 instanceof ResettableConnectable) == false) goto L15;
        if (r0 != null) goto L14;
        r5.disconnectedEarly = true;     // Catch: Throwable -> L17
        goto L15
    L14:
        ((ResettableConnectable) r1).resetIf(r0);     // Catch: Throwable -> L17
        goto L15
    }
}
