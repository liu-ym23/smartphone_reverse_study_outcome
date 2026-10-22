package reactor.core.publisher;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoSubscribeOn<T> extends InternalMonoOperator<T, T> {
    final Scheduler scheduler;

    public static final class SubscribeOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final Z9.c parent;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile Z9.e f5867s;
        volatile Thread thread;
        final Scheduler.Worker worker;

        /* renamed from: S, reason: collision with root package name */
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, Z9.e> f5866S = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, Z9.e.class, "s");
        static final AtomicLongFieldUpdater<SubscribeOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(SubscribeOnSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, Thread> THREAD = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, Thread.class, "thread");

        public SubscribeOnSubscriber(Z9.c cVar, CoreSubscriber<? super T> coreSubscriber, Scheduler.Worker worker) {
            this.actual = coreSubscriber;
            this.parent = cVar;
            this.worker = worker;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Operators.terminate(f5866S, this);
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
            THREAD.lazySet(this, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                this.worker.dispose();
                THREAD.lazySet(this, null);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.setOnce(f5866S, this, eVar)) {
                long andSet = REQUESTED.getAndSet(this, 0L);
                if (andSet != 0) {
                    trySchedule(andSet, eVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                Z9.e eVar = this.f5867s;
                if (eVar != null) {
                    trySchedule(j5, eVar);
                    return;
                }
                AtomicLongFieldUpdater<SubscribeOnSubscriber> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j5);
                Z9.e eVar2 = this.f5867s;
                if (eVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
                    return;
                }
                trySchedule(j5, eVar2);
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
                return Boolean.valueOf(this.f5867s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.PARENT ? this.f5867s : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void trySchedule(long j5, Z9.e eVar) {
            if (Thread.currentThread() == THREAD.get(this)) {
                eVar.request(j5);
                return;
            }
            try {
                this.worker.schedule(new S(eVar, j5, 1));
            } catch (RejectedExecutionException e) {
                if (this.worker.isDisposed()) {
                    return;
                }
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onRejectedExecution(e, this, null, null, coreSubscriber.currentContext()));
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
        } catch (RejectedExecutionException e) {
            if (subscribeOnSubscriber.f5867s != Operators.cancelledSubscription()) {
                coreSubscriber.onError(Operators.onRejectedExecution(e, subscribeOnSubscriber, null, null, coreSubscriber.currentContext()));
            }
        }
        return null;
    }
}
