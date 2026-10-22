package reactor.core.publisher;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;

/* loaded from: classes4.dex */
final class FluxDelaySequence<T> extends InternalFluxOperator<T, T> {
    final Duration delay;
    final Scheduler scheduler;

    public static final class DelaySubscriber<T> implements InnerOperator<T, T> {
        static final AtomicLongFieldUpdater<DelaySubscriber> DELAYED = AtomicLongFieldUpdater.newUpdater(DelaySubscriber.class, "delayed");
        final CoreSubscriber<? super T> actual;
        final long delay;
        volatile long delayed;
        volatile boolean done;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5720s;
        final TimeUnit timeUnit = TimeUnit.NANOSECONDS;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f5721w;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onComplete();
                } finally {
                    DelaySubscriber.this.f5721w.dispose();
                }
            }
        }

        public final class OnError implements Runnable {

            /* renamed from: t, reason: collision with root package name */
            private final Throwable f5722t;

            public OnError(Throwable th) {
                this.f5722t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onError(this.f5722t);
                } finally {
                    DelaySubscriber.this.f5721w.dispose();
                }
            }
        }

        public DelaySubscriber(CoreSubscriber<? super T> coreSubscriber, Duration duration, Scheduler.Worker worker) {
            this.actual = Operators.serialize(coreSubscriber);
            this.f5721w = worker;
            this.delay = duration.toNanos();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: delayedNext, reason: merged with bridge method [inline-methods] */
        public void lambda$onNext$0(T t9) {
            DELAYED.decrementAndGet(this);
            this.actual.onNext(t9);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5720s.cancel();
            this.f5721w.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (DELAYED.compareAndSet(this, 0L, -1L)) {
                this.actual.onComplete();
            } else {
                this.f5721w.schedule(new OnComplete(), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.done = true;
            if (DELAYED.compareAndSet(this, 0L, -1L)) {
                this.actual.onError(th);
            } else {
                this.f5721w.schedule(new OnError(th), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done || this.delayed < 0) {
                Operators.onNextDropped(t9, currentContext());
            } else {
                DELAYED.incrementAndGet(this);
                this.f5721w.schedule(new K(this, t9, 0), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5720s, eVar)) {
                this.f5720s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            this.f5720s.request(j5);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f5720s;
            }
            if (attr == Scannable.Attr.RUN_ON) {
                return this.f5721w;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f5721w.isDisposed() && !this.done);
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
