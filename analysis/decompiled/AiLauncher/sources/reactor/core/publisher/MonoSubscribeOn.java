package reactor.core.publisher;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class MonoSubscribeOn<T> extends InternalMonoOperator<T, T> {
    final Scheduler scheduler;

    public static final class SubscribeOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final qc.b<? extends T> parent;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qc.d f39671s;
        volatile Thread thread;
        final Scheduler.Worker worker;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, qc.d> f39670S = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, qc.d.class, "s");
        static final AtomicLongFieldUpdater<SubscribeOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(SubscribeOnSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, Thread> THREAD = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, Thread.class, "thread");

        public SubscribeOnSubscriber(qc.b<? extends T> bVar, CoreSubscriber<? super T> coreSubscriber, Scheduler.Worker worker) {
            this.actual = coreSubscriber;
            this.parent = bVar;
            this.worker = worker;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            Operators.terminate(f39670S, this);
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
            THREAD.lazySet(this, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                this.worker.dispose();
                THREAD.lazySet(this, null);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            this.actual.onNext(t10);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.setOnce(f39670S, this, dVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    trySchedule(andSet, dVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                qc.d dVar = this.f39671s;
                if (dVar != null) {
                    trySchedule(j10, dVar);
                    return;
                }
                AtomicLongFieldUpdater<SubscribeOnSubscriber> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qc.d dVar2 = this.f39671s;
                if (dVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
                    return;
                }
                trySchedule(j10, dVar2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            THREAD.lazySet(this, Thread.currentThread());
            this.parent.subscribe(this);
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39671s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.PARENT ? this.f39671s : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void trySchedule(final long j10, final qc.d dVar) {
            if (Thread.currentThread() == THREAD.get(this)) {
                dVar.request(j10);
                return;
            }
            try {
                this.worker.schedule(new Runnable() { // from class: reactor.core.publisher.U1
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.request(j10);
                    }
                });
            } catch (RejectedExecutionException e10) {
                if (this.worker.isDisposed()) {
                    return;
                }
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onRejectedExecution(e10, this, null, null, coreSubscriber.currentContext()));
            }
        }
    }

    public MonoSubscribeOn(Mono<? extends T> mono, Scheduler scheduler) {
        super(mono);
        this.scheduler = scheduler;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(this.source, coreSubscriber, workerCreateWorker);
        coreSubscriber.onSubscribe(subscribeOnSubscriber);
        try {
            workerCreateWorker.schedule(subscribeOnSubscriber);
        } catch (RejectedExecutionException e10) {
            if (subscribeOnSubscriber.f39671s != Operators.cancelledSubscription()) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, subscribeOnSubscriber, null, null, coreSubscriber.currentContext()));
            }
        }
        return null;
    }
}
