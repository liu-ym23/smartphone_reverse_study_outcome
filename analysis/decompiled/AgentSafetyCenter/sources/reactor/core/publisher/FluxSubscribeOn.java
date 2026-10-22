package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CorePublisher;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxSubscribeOn<T> extends InternalFluxOperator<T, T> {
    final boolean requestOnSeparateThread;
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SubscribeOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final boolean requestOnSeparateThread;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10678s;
        final CorePublisher<? extends T> source;
        volatile Thread thread;
        final Scheduler.Worker worker;
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, qd.e.class, "s");
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

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            qd.e andSet;
            if (this.f10678s != Operators.cancelledSubscription() && (andSet = S.getAndSet(this, Operators.cancelledSubscription())) != null && andSet != Operators.cancelledSubscription()) {
                andSet.cancel();
            }
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                this.worker.dispose();
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.setOnce(S, this, eVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    requestUpstream(andSet, eVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                AtomicReferenceFieldUpdater<SubscribeOnSubscriber, qd.e> atomicReferenceFieldUpdater = S;
                qd.e eVar = atomicReferenceFieldUpdater.get(this);
                if (eVar != null) {
                    requestUpstream(j10, eVar);
                    return;
                }
                AtomicLongFieldUpdater<SubscribeOnSubscriber> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qd.e eVar2 = atomicReferenceFieldUpdater.get(this);
                if (eVar2 != null) {
                    long andSet = atomicLongFieldUpdater.getAndSet(this, 0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, eVar2);
                    }
                }
            }
        }

        public void requestUpstream(long j10, qd.e eVar) {
            if (!this.requestOnSeparateThread || Thread.currentThread() == THREAD.get(this)) {
                eVar.request(j10);
                return;
            }
            try {
                Scheduler.Worker worker = this.worker;
                s0 s0Var = new s0(0);
                s0Var.f10856f = eVar;
                s0Var.f10857g = j10;
                VarHandle.storeStoreFence();
                worker.schedule(s0Var);
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
                return this.f10678s;
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10678s == Operators.cancelledSubscription());
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
            if (subscribeOnSubscriber.f10678s != Operators.cancelledSubscription()) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, subscribeOnSubscriber, null, null, coreSubscriber.currentContext()));
            }
        }
        return null;
    }
}
