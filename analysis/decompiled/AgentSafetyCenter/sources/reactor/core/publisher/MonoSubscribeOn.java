package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class MonoSubscribeOn<T> extends InternalMonoOperator<T, T> {
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SubscribeOnSubscriber<T> implements InnerOperator<T, T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final qd.c parent;
        volatile long requested;

        /* renamed from: s, reason: collision with root package name */
        volatile qd.e f10739s;
        volatile Thread thread;
        final Scheduler.Worker worker;
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, qd.e> S = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, qd.e.class, "s");
        static final AtomicLongFieldUpdater<SubscribeOnSubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(SubscribeOnSubscriber.class, "requested");
        static final AtomicReferenceFieldUpdater<SubscribeOnSubscriber, Thread> THREAD = AtomicReferenceFieldUpdater.newUpdater(SubscribeOnSubscriber.class, Thread.class, "thread");

        public SubscribeOnSubscriber(qd.c cVar, CoreSubscriber<? super T> coreSubscriber, Scheduler.Worker worker) {
            this.actual = coreSubscriber;
            this.parent = cVar;
            this.worker = worker;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            Operators.terminate(S, this);
            this.worker.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
            THREAD.lazySet(this, null);
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                this.worker.dispose();
                THREAD.lazySet(this, null);
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
                    trySchedule(andSet, eVar);
                }
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            if (Operators.validate(j10)) {
                qd.e eVar = this.f10739s;
                if (eVar != null) {
                    trySchedule(j10, eVar);
                    return;
                }
                AtomicLongFieldUpdater<SubscribeOnSubscriber> atomicLongFieldUpdater = REQUESTED;
                Operators.addCap(atomicLongFieldUpdater, this, j10);
                qd.e eVar2 = this.f10739s;
                if (eVar2 == null || atomicLongFieldUpdater.getAndSet(this, 0L) == 0) {
                    return;
                }
                trySchedule(j10, eVar2);
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
                return Boolean.valueOf(this.f10739s == Operators.cancelledSubscription());
            }
            return attr == Scannable.Attr.PARENT ? this.f10739s : attr == Scannable.Attr.REQUESTED_FROM_DOWNSTREAM ? Long.valueOf(this.requested) : attr == Scannable.Attr.RUN_ON ? this.worker : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }

        public void trySchedule(long j10, qd.e eVar) {
            if (Thread.currentThread() == THREAD.get(this)) {
                eVar.request(j10);
                return;
            }
            try {
                Scheduler.Worker worker = this.worker;
                s0 s0Var = new s0(1);
                s0Var.f10856f = eVar;
                s0Var.f10857g = j10;
                VarHandle.storeStoreFence();
                worker.schedule(s0Var);
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
            if (subscribeOnSubscriber.f10739s != Operators.cancelledSubscription()) {
                coreSubscriber.onError(Operators.onRejectedExecution(e10, subscribeOnSubscriber, null, null, coreSubscriber.currentContext()));
            }
        }
        return null;
    }
}
