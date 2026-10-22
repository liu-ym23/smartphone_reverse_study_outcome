package reactor.core.publisher;

import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
final class FluxDelaySequence<T> extends InternalFluxOperator<T, T> {
    final Duration delay;
    final Scheduler scheduler;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class DelaySubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<DelaySubscriber> DELAYED = AtomicLongFieldUpdater.newUpdater(DelaySubscriber.class, "delayed");
        final CoreSubscriber<? super T> actual;
        final long delay;
        volatile long delayed;
        volatile boolean done;

        /* renamed from: s, reason: collision with root package name */
        qd.e f10602s;
        final TimeUnit timeUnit = TimeUnit.NANOSECONDS;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f10603w;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onComplete();
                } finally {
                    DelaySubscriber.this.f10603w.dispose();
                }
            }
        }

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public final class OnError implements Runnable {

            /* renamed from: t, reason: collision with root package name */
            private final Throwable f10604t;

            public OnError(Throwable th) {
                this.f10604t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onError(this.f10604t);
                } finally {
                    DelaySubscriber.this.f10603w.dispose();
                }
            }
        }

        public DelaySubscriber(CoreSubscriber<? super T> coreSubscriber, Duration duration, Scheduler.Worker worker) {
            this.actual = Operators.serialize(coreSubscriber);
            this.f10603w = worker;
            this.delay = duration.toNanos();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: delayedNext, reason: merged with bridge method [inline-methods] */
        public void lambda$onNext$0(T t10) {
            DELAYED.decrementAndGet(this);
            this.actual.onNext(t10);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void cancel() {
            this.f10602s.cancel();
            this.f10603w.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (DELAYED.compareAndSet(this, 0L, -1L)) {
                this.actual.onComplete();
            } else {
                this.f10603w.schedule(new OnComplete(), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.done = true;
            if (DELAYED.compareAndSet(this, 0L, -1L)) {
                this.actual.onError(th);
            } else {
                this.f10603w.schedule(new OnError(th), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.done || this.delayed < 0) {
                Operators.onNextDropped(t10, currentContext());
                return;
            }
            DELAYED.incrementAndGet(this);
            Scheduler.Worker worker = this.f10603w;
            l0 l0Var = new l0(0);
            l0Var.f10817f = this;
            l0Var.f10818g = t10;
            VarHandle.storeStoreFence();
            worker.schedule(l0Var, this.delay, this.timeUnit);
        }

        @Override // reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10602s, eVar)) {
                this.f10602s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qd.e
        public void request(long j10) {
            this.f10602s.request(j10);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f10602s;
            }
            if (attr == Scannable.Attr.RUN_ON) {
                return this.f10603w;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f10603w.isDisposed() && !this.done);
            }
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
        }
    }

    public FluxDelaySequence(Flux<T> flux, Duration duration, Scheduler scheduler) {
        super(flux);
        this.delay = duration;
        this.scheduler = scheduler;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_ON ? this.scheduler : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.ASYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new DelaySubscriber(coreSubscriber, this.delay, this.scheduler.createWorker());
    }
}
