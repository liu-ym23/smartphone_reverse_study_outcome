package reactor.core.publisher;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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

/* loaded from: classes5.dex */
final class FluxRefCount<T> extends Flux<T> implements Scannable, Fuseable {

    @Nullable
    RefCountMonitor<T> connection;

    /* renamed from: n, reason: collision with root package name */
    final int f39553n;
    final ConnectableFlux<? extends T> source;

    public static final class RefCountInner<T> implements Fuseable.QueueSubscription<T>, InnerOperator<T, T> {
        static final int CANCELLED_FLAG = Integer.MIN_VALUE;
        static final int MONITOR_SET_FLAG = 536870912;
        static final AtomicIntegerFieldUpdater<RefCountInner> STATE = AtomicIntegerFieldUpdater.newUpdater(RefCountInner.class, VoiceWakeupReceiver.EXTRA_STATE);
        static final int TERMINATED_FLAG = 1073741824;
        final CoreSubscriber<? super T> actual;
        RefCountMonitor<T> connection;
        Throwable error;
        Fuseable.QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39554s;
        volatile int state;

        public RefCountInner(CoreSubscriber<? super T> coreSubscriber) {
            this.actual = coreSubscriber;
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
            this.f39554s.cancel();
            int i10 = this.state;
            if (isTerminated(i10) || isCancelled(i10) || !STATE.compareAndSet(this, i10, Integer.MIN_VALUE | i10)) {
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
                this.connection.upstreamFinished();
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
                this.connection.upstreamFinished();
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39554s, dVar)) {
                this.f39554s = dVar;
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            return this.qs.poll();
        }

        @Override // reactor.core.Fuseable.QueueSubscription, qc.d
        public void request(long j10) {
            this.f39554s.request(j10);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            qc.d dVar = this.f39554s;
            if (!(dVar instanceof Fuseable.QueueSubscription)) {
                return 0;
            }
            Fuseable.QueueSubscription<T> queueSubscription = (Fuseable.QueueSubscription) dVar;
            this.qs = queueSubscription;
            return queueSubscription.requestFusion(i10);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.PARENT ? this.f39554s : attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(isTerminated(this.state)) : attr == Scannable.Attr.CANCELLED ? Boolean.valueOf(isCancelled(this.state)) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }

        public void setRefCountMonitor(RefCountMonitor<T> refCountMonitor) {
            int i10;
            this.connection = refCountMonitor;
            this.actual.onSubscribe(this);
            do {
                i10 = this.state;
                if (isCancelled(i10)) {
                    return;
                }
                if (isTerminated(i10)) {
                    refCountMonitor.upstreamFinished();
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

    public FluxRefCount(ConnectableFlux<? extends T> connectableFlux, int i10) {
        if (i10 > 0) {
            Objects.requireNonNull(connectableFlux, "source");
            this.source = ConnectableFlux.from((ConnectableFlux) connectableFlux);
            this.f39553n = i10;
        } else {
            throw new IllegalArgumentException("n > 0 required but it was " + i10);
        }
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
                if (refCountMonitor.connected || j10 != this.f39553n) {
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
}
