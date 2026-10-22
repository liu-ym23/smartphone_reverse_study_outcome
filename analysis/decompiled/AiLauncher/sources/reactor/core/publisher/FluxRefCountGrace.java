package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxRefCountGrace<T> extends Flux<T> implements Scannable, Fuseable {
    RefConnection connection;
    final Duration gracePeriod;

    /* renamed from: n, reason: collision with root package name */
    final int f39555n;
    final Scheduler scheduler;
    final ConnectableFlux<T> source;

    public static final class RefConnection implements Runnable, Consumer<Disposable> {
        static final AtomicReferenceFieldUpdater<RefConnection, Disposable> SOURCE_DISCONNECTOR = AtomicReferenceFieldUpdater.newUpdater(RefConnection.class, Disposable.class, "sourceDisconnector");
        boolean connected;
        final FluxRefCountGrace<?> parent;
        volatile Disposable sourceDisconnector;
        long subscriberCount;
        boolean terminated;
        Disposable timer;

        public RefConnection(FluxRefCountGrace<?> fluxRefCountGrace) {
            this.parent = fluxRefCountGrace;
        }

        public boolean isTerminated() {
            Disposable disposable = this.sourceDisconnector;
            if (this.terminated) {
                return true;
            }
            return disposable != null && disposable.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.timeout(this);
        }

        @Override // java.util.function.Consumer
        public void accept(Disposable disposable) {
            OperatorDisposables.replace(SOURCE_DISCONNECTOR, this, disposable);
        }
    }

    public static final class RefCountInner<T> implements Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        static final int CANCELLED_FLAG = Integer.MIN_VALUE;
        static final int MONITOR_SET_FLAG = 536870912;
        static final AtomicIntegerFieldUpdater<RefCountInner> STATE = AtomicIntegerFieldUpdater.newUpdater(RefCountInner.class, VoiceWakeupReceiver.EXTRA_STATE);
        static final int TERMINATED_FLAG = 1073741824;
        final CoreSubscriber<? super T> actual;
        RefConnection connection;
        Throwable error;
        final FluxRefCountGrace<T> parent;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39556s;
        volatile int state;

        public RefCountInner(CoreSubscriber<? super T> coreSubscriber, FluxRefCountGrace<T> fluxRefCountGrace) {
            this.actual = coreSubscriber;
            this.parent = fluxRefCountGrace;
        }

        public static boolean isCancelled(int i10) {
            return (i10 & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        }

        public static boolean isMonitorSet(int i10) {
            return (i10 & 536870912) == 536870912;
        }

        public static boolean isTerminated(int i10) {
            return (i10 & TERMINATED_FLAG) == TERMINATED_FLAG;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void cancel() {
            this.f39556s.cancel();
            int i10 = this.state;
            if (isTerminated(i10) || isCancelled(i10) || !STATE.compareAndSet(this, i10, Integer.MIN_VALUE | i10)) {
                return;
            }
            this.parent.cancel(this.connection);
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            int i10;
            do {
                i10 = this.state;
                if (isTerminated(i10) || isCancelled(i10)) {
                    return;
                }
            } while (!STATE.compareAndSet(this, i10, TERMINATED_FLAG | i10));
            if (isMonitorSet(i10)) {
                this.parent.terminated(this.connection);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            int i10;
            this.error = th;
            do {
                i10 = this.state;
                if (isTerminated(i10) || isCancelled(i10)) {
                    Operators.onErrorDropped(th, this.actual.currentContext());
                    return;
                }
            } while (!STATE.compareAndSet(this, i10, TERMINATED_FLAG | i10));
            if (isMonitorSet(i10)) {
                this.parent.terminated(this.connection);
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39556s, dVar)) {
                this.f39556s = dVar;
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.qs.poll();
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            this.f39556s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            qc.d dVar = this.f39556s;
            if (!(dVar instanceof Fuseable.QueueSubscription)) {
                return 0;
            }
            Fuseable.QueueSubscription<T> queueSubscription = (Fuseable.QueueSubscription) dVar;
            this.qs = queueSubscription;
            return queueSubscription.requestFusion(i10);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : attr == Scannable.Attr.PARENT ? this.f39556s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isTerminated(this.state)) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled(this.state)) : super.scanUnsafe(attr);
        }

        public void setRefConnection(RefConnection refConnection) {
            int i10;
            this.connection = refConnection;
            this.actual.onSubscribe(this);
            do {
                i10 = this.state;
                if (isCancelled(i10)) {
                    return;
                }
                if (isTerminated(i10)) {
                    this.parent.terminated(refConnection);
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                }
            } while (!STATE.compareAndSet(this, i10, 536870912 | i10));
        }

        @Override // java.util.Collection
        public int size() {
            return this.qs.size();
        }
    }

    public FluxRefCountGrace(ConnectableFlux<T> connectableFlux, int i10, Duration duration, Scheduler scheduler) {
        Objects.requireNonNull(connectableFlux, "source");
        this.source = ConnectableFlux.from((ConnectableFlux) connectableFlux);
        this.f39555n = i10;
        this.gracePeriod = duration;
        this.scheduler = scheduler;
    }

    public void cancel(RefConnection refConnection) {
        boolean z10;
        Disposable.Swap swap;
        synchronized (this) {
            try {
                if (refConnection.terminated) {
                    return;
                }
                long j10 = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j10;
                if (j10 == 0 && refConnection.connected) {
                    Disposable andSet = null;
                    if (this.gracePeriod.isZero()) {
                        z10 = false;
                        if (refConnection == this.connection) {
                            this.connection = null;
                            andSet = RefConnection.SOURCE_DISCONNECTOR.getAndSet(refConnection, Disposables.disposed());
                            swap = null;
                        } else {
                            swap = null;
                        }
                    } else {
                        swap = Disposables.swap();
                        refConnection.timer = swap;
                        z10 = true;
                    }
                    if (z10) {
                        swap.replace(this.scheduler.schedule(refConnection, this.gracePeriod.toNanos(), TimeUnit.NANOSECONDS));
                    } else if (andSet != null) {
                        andSet.dispose();
                    }
                }
            } finally {
            }
        }
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return this.source.getPrefetch();
    }

    @Override // reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        if (attr == Scannable.Attr.PREFETCH) {
            return Integer.valueOf(getPrefetch());
        }
        if (attr == Scannable.Attr.PARENT) {
            return this.source;
        }
        if (attr == Scannable.Attr.RUN_STYLE) {
            return Scannable.Attr.RunStyle.SYNC;
        }
        if (attr == InternalProducerAttr.INSTANCE) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // reactor.core.publisher.Flux, reactor.core.CorePublisher
    public void subscribe(CoreSubscriber<? super T> coreSubscriber) {
        RefConnection refConnection;
        boolean z10;
        Disposable disposable;
        RefCountInner refCountInner = new RefCountInner(coreSubscriber, this);
        this.source.subscribe((CoreSubscriber) refCountInner);
        synchronized (this) {
            try {
                refConnection = this.connection;
                if (refConnection == null || refConnection.isTerminated()) {
                    refConnection = new RefConnection(this);
                    this.connection = refConnection;
                }
                long j10 = refConnection.subscriberCount;
                if (j10 == 0 && (disposable = refConnection.timer) != null) {
                    disposable.dispose();
                }
                long j11 = j10 + 1;
                refConnection.subscriberCount = j11;
                if (refConnection.connected || j11 != this.f39555n) {
                    z10 = false;
                } else {
                    z10 = true;
                    refConnection.connected = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        refCountInner.setRefConnection(refConnection);
        if (z10) {
            this.source.connect(refConnection);
        }
    }

    public void terminated(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (!refConnection.terminated) {
                    refConnection.terminated = true;
                    this.connection = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void timeout(RefConnection refConnection) {
        Disposable andSet;
        synchronized (this) {
            try {
                andSet = null;
                if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                    this.connection = null;
                    andSet = RefConnection.SOURCE_DISCONNECTOR.getAndSet(refConnection, Disposables.disposed());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (andSet != null) {
            andSet.dispose();
        }
    }
}
