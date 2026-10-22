package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxSubscribeOn<T> extends InternalFluxOperator<T, T> {
    final boolean requestOnSeparateThread;
    final Scheduler scheduler;

    public static final class SubscribeOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final boolean requestOnSeparateThread;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39572s;
        final CorePublisher<? extends T> source;
        volatile Thread thread;
        final Scheduler.Worker worker;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, qc.d> f39571S = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, qc.d.class, "s");
        static final AtomicLongFieldUpdater<SubscribeOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(SubscribeOnSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, Thread> THREAD = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, Thread.class, "thread");

        public SubscribeOnSubscriber(CorePublisher<? extends T> corePublisher, CoreSubscriber<? super T> coreSubscriber, Scheduler.Worker worker, boolean z10) {
            this.actual = coreSubscriber;
            this.worker = worker;
            this.source = corePublisher;
            this.requestOnSeparateThread = z10;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            qc.d andSet;
            if (this.f39572s != Operators.cancelledSubscription() && (andSet = f39571S.getAndSet(this, Operators.cancelledSubscription())) != null && andSet != Operators.cancelledSubscription()) {
                andSet.cancel();
            }
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                this.worker.dispose();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39571S, this, dVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    requestUpstream(andSet, dVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                AtomicReferenceFieldUpdater<SubscribeOnSubscriber, qc.d> atomicReferenceFieldUpdater = f39571S;
                qc.d dVar = atomicReferenceFieldUpdater.get(this);
                if (dVar != null) {
                    requestUpstream(j10, dVar);
                    return;
                }
                AtomicLongFieldUpdater<SubscribeOnSubscriber> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qc.d dVar2 = atomicReferenceFieldUpdater.get(this);
                if (dVar2 != null) {
                    long andSet = atomicLongFieldUpdater.getAndSet(this, 0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, dVar2);
                    }
                }
            }
        }

        public void requestUpstream(final long j10, final qc.d dVar) {
            if (!this.requestOnSeparateThread || Thread.currentThread() == THREAD.get(this)) {
                dVar.request(j10);
                return;
            }
            try {
                this.worker.schedule(new Runnable() { // from class: reactor.core.publisher.T0
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.request(j10);
                    }
                });
            } catch (RejectedExecutionException e10) {
                if (!this.worker.isDisposed()) {
                    throw Operators.onRejectedExecution(e10, this, null, null, this.actual.currentContext());
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            THREAD.lazySet(this, Thread.currentThread());
            this.source.subscribe((CoreSubscriber<? super Object>) this);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39572s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39572s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }
    }

    public FluxSubscribeOn(Flux<? extends T> flux, Scheduler scheduler, boolean z10) {
        super(flux);
        Objects.requireNonNull(scheduler, "scheduler");
        this.scheduler = scheduler;
        this.requestOnSeparateThread = z10;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        Objects.requireNonNull(workerCreateWorker, "The scheduler returned a null Function");
        Scheduler.Worker worker = workerCreateWorker;
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(this.source, coreSubscriber, worker, this.requestOnSeparateThread);
        coreSubscriber.onSubscribe(subscribeOnSubscriber);
        try {
            worker.schedule(subscribeOnSubscriber);
        } catch (RejectedExecutionException e10) {
            if (subscribeOnSubscriber.f39572s != Operators.cancelledSubscription()) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, subscribeOnSubscriber, null, null, coreSubscriber.currentContext()));
            }
        }
        return null;
    }
}
