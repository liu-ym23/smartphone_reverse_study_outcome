package reactor.core.publisher;

import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class MonoDelayElement<T> extends InternalMonoOperator<T, T> {
    final long delay;
    final Scheduler timedScheduler;
    final TimeUnit unit;

    public static final class DelayElementSubscriber<T> implements InnerOperator<T, T>, Fuseable, Fuseable.QueueSubscription<T>, Runnable {
        final CoreSubscriber<? super T> actual;
        final long delay;
        boolean done;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5845s;
        final Scheduler scheduler;
        volatile Disposable task;
        final TimeUnit unit;
        T value;
        static final Disposable CANCELLED = Disposables.disposed();
        static final Disposable TERMINATED = Disposables.disposed();
        static final AtomicReferenceFieldUpdater<DelayElementSubscriber, Disposable> TASK = AtomicReferenceFieldUpdater.newUpdater(DelayElementSubscriber.class, Disposable.class, "task");

        public DelayElementSubscriber(CoreSubscriber<? super T> coreSubscriber, Scheduler scheduler, long j5, TimeUnit timeUnit) {
            this.actual = coreSubscriber;
            this.scheduler = scheduler;
            this.delay = j5;
            this.unit = timeUnit;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            Disposable disposable;
            Disposable disposable2;
            do {
                disposable = this.task;
                disposable2 = CANCELLED;
                if (disposable == disposable2 || disposable == TERMINATED) {
                    return;
                }
            } while (!TASK.compareAndSet(this, disposable, disposable2));
            if (disposable == null) {
                this.f5845s.cancel();
                return;
            }
            disposable.dispose();
            T t9 = this.value;
            this.value = null;
            Operators.onDiscard(t9, this.actual.currentContext());
        }

        @Override // java.util.Collection
        public void clear() {
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            this.done = true;
            this.value = t9;
            try {
                if (this.task == CANCELLED) {
                    this.value = null;
                    Operators.onDiscard(t9, this.actual.currentContext());
                    return;
                }
                Disposable disposableSchedule = this.scheduler.schedule(this, this.delay, this.unit);
                do {
                    Disposable disposable = this.task;
                    if (disposable == CANCELLED) {
                        disposableSchedule.dispose();
                        Operators.onDiscard(t9, this.actual.currentContext());
                        return;
                    } else if (disposable == TERMINATED) {
                        return;
                    }
                } while (!TASK.compareAndSet(this, null, disposableSchedule));
            } catch (RejectedExecutionException e) {
                this.value = null;
                Operators.onDiscard(t9, this.actual.currentContext());
                CoreSubscriber<? super T> coreSubscriber = this.actual;
                coreSubscriber.onError(Operators.onRejectedExecution(e, this, null, t9, coreSubscriber.currentContext()));
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5845s, eVar)) {
                this.f5845s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        public T poll() {
            return null;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5845s.request(j5);
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable;
            do {
                disposable = this.task;
                if (disposable == CANCELLED) {
                    return;
                }
            } while (!TASK.compareAndSet(this, disposable, TERMINATED));
            T t9 = this.value;
            this.value = null;
            this.actual.onNext(t9);
            this.actual.onComplete();
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr != Scannable.Attr.TERMINATED) {
                if (attr == Scannable.Attr.CANCELLED) {
                    return Boolean.valueOf(this.task == CANCELLED);
                }
                if (attr == Scannable.Attr.PREFETCH) {
                    return 0;
                }
                return attr == Scannable.Attr.PARENT ? this.f5845s : attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
            }
            Disposable disposable = this.task;
            if (!this.done || (disposable != TERMINATED && (disposable != null || this.value != null))) {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }
    }

    public MonoDelayElement(Mono<? extends T> mono, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        super(mono);
        this.delay = j5;
        Objects.requireNonNull(timeUnit, "unit");
        this.unit = timeUnit;
        Objects.requireNonNull(scheduler, "timedScheduler");
        this.timedScheduler = scheduler;
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.timedScheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DelayElementSubscriber(coreSubscriber, this.timedScheduler, this.delay, this.unit);
    }
}
