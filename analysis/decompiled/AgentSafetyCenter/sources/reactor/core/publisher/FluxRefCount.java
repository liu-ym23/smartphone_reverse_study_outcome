package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxRefCount<T> extends Flux<T> implements Scannable, Fuseable {

    @Nullable
    RefCountMonitor<T> connection;

    /* renamed from: n, reason: collision with root package name */
    final int f10662n;
    final ConnectableFlux<? extends T> source;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RefCountInner<T> implements Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        static final int CANCELLED_FLAG = Integer.MIN_VALUE;
        static final int MONITOR_SET_FLAG = 536870912;
        static final AtomicIntegerFieldUpdater<RefCountInner> STATE = AtomicIntegerFieldUpdater.newUpdater(RefCountInner.class, "state");
        static final int TERMINATED_FLAG = 1073741824;
        final CoreSubscriber<? super T> actual;
        RefCountMonitor<T> connection;
        Throwable error;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10663s;
        volatile int state;

        public RefCountInner(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
        }

        public static boolean isCancelled(int i) {
            return (i & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        }

        public static boolean isMonitorSet(int i) {
            return (i & MONITOR_SET_FLAG) == MONITOR_SET_FLAG;
        }

        public static boolean isTerminated(int i) {
            return (i & TERMINATED_FLAG) == TERMINATED_FLAG;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void cancel() {
            this.f10663s.cancel();
            int i = this.state;
            if (isTerminated(i) || isCancelled(i) || !STATE.compareAndSet(this, i, Integer.MIN_VALUE | i)) {
                return;
            }
            this.connection.innerCancelled();
        }

        @Override // java.util.Collection
        public void clear() {
            this.qs.clear();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            int i;
            do {
                i = this.state;
                if (isTerminated(i) || isCancelled(i)) {
                    return;
                }
            } while (!STATE.compareAndSet(this, i, TERMINATED_FLAG | i));
            if (isMonitorSet(i)) {
                this.connection.upstreamFinished();
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            int i;
            this.error = th;
            do {
                i = this.state;
                if (isTerminated(i) || isCancelled(i)) {
                    Operators.onErrorDropped(th, this.actual.currentContext());
                    return;
                }
            } while (!STATE.compareAndSet(this, i, TERMINATED_FLAG | i));
            if (isMonitorSet(i)) {
                this.connection.upstreamFinished();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10663s, eVar)) {
                this.f10663s = eVar;
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.qs.poll();
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qd.e
        public void request(long j10) {
            this.f10663s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            qd.e eVar = this.f10663s;
            if (!(eVar instanceof Fuseable.QueueSubscription)) {
                return 0;
            }
            Fuseable.QueueSubscription<T> queueSubscription = (Fuseable.QueueSubscription) eVar;
            this.qs = queueSubscription;
            return queueSubscription.requestFusion(i);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f10663s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isTerminated(this.state)) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled(this.state)) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void setRefCountMonitor(RefCountMonitor<T> refCountMonitor) {
            int i;
            this.connection = refCountMonitor;
            this.actual.onSubscribe(this);
            do {
                i = this.state;
                if (isCancelled(i)) {
                    return;
                }
                if (isTerminated(i)) {
                    refCountMonitor.upstreamFinished();
                    Throwable th = this.error;
                    CoreSubscriber<? super T> coreSubscriber = this.actual;
                    if (th != null) {
                        coreSubscriber.onError(th);
                        return;
                    } else {
                        coreSubscriber.onComplete();
                        return;
                    }
                }
            } while (!STATE.compareAndSet(this, i, MONITOR_SET_FLAG | i));
        }

        @Override // java.util.Collection
        public int size() {
            return this.qs.size();
        }
    }

    public FluxRefCount(ConnectableFlux<? extends T> connectableFlux, int i) {
        if (i <= 0) {
            g5.f.s(k0.a.j(i, "n > 0 required but it was "));
            throw null;
        }
        Objects.requireNonNull(connectableFlux, "source");
        this.source = ConnectableFlux.from((ConnectableFlux) connectableFlux);
        this.f10662n = i;
    }

    public void cancel(RefCountMonitor refCountMonitor) {
        synchronized (this) {
            try {
                if (refCountMonitor.terminated) {
                    return;
                }
                long j10 = refCountMonitor.subscribers - 1;
                refCountMonitor.subscribers = j10;
                if (j10 == 0 && refCountMonitor.connected) {
                    Disposable disposable = null;
                    if (refCountMonitor == this.connection) {
                        Disposable andSet = RefCountMonitor.DISCONNECT.getAndSet(refCountMonitor, Disposables.disposed());
                        this.connection = null;
                        disposable = andSet;
                    }
                    if (disposable != null) {
                        disposable.dispose();
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
        RefCountMonitor<T> refCountMonitor;
        boolean z10;
        RefCountInner refCountInner = new RefCountInner(coreSubscriber);
        this.source.subscribe((CoreSubscriber<? super Object>) refCountInner);
        synchronized (this) {
            try {
                refCountMonitor = this.connection;
                if (refCountMonitor == null || refCountMonitor.terminated) {
                    refCountMonitor = new RefCountMonitor<>(this);
                    this.connection = refCountMonitor;
                }
                long j10 = refCountMonitor.subscribers + 1;
                refCountMonitor.subscribers = j10;
                if (refCountMonitor.connected || j10 != this.f10662n) {
                    z10 = false;
                } else {
                    z10 = true;
                    refCountMonitor.connected = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        refCountInner.setRefCountMonitor(refCountMonitor);
        if (z10) {
            this.source.connect(refCountMonitor);
        }
    }

    public void terminated(RefCountMonitor refCountMonitor) {
        synchronized (this) {
            try {
                if (!refCountMonitor.terminated) {
                    refCountMonitor.terminated = true;
                    this.connection = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class RefCountMonitor<T> implements Consumer<Disposable> {
        static final AtomicReferenceFieldUpdater<RefCountMonitor, Disposable> DISCONNECT = AtomicReferenceFieldUpdater.newUpdater(RefCountMonitor.class, Disposable.class, "disconnect");
        boolean connected;
        volatile Disposable disconnect;
        final FluxRefCount<? extends T> parent;
        long subscribers;
        boolean terminated;

        public RefCountMonitor(FluxRefCount<? extends T> fluxRefCount) {
            this.parent = fluxRefCount;
        }

        public void innerCancelled() {
            this.parent.cancel(this);
        }

        public void upstreamFinished() {
            this.parent.terminated(this);
        }

        @Override // java.util.function.Consumer
        public void accept(Disposable disposable) {
            OperatorDisposables.replace(DISCONNECT, this, disposable);
        }
    }
}
