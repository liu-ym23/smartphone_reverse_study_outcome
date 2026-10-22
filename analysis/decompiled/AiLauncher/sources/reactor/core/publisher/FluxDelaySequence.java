package reactor.core.publisher;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;

/* loaded from: classes5.dex */
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
        qc.d f39490s;
        final TimeUnit timeUnit = TimeUnit.NANOSECONDS;

        /* renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f39491w;

        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onComplete();
                } finally {
                    DelaySubscriber.this.f39491w.dispose();
                }
            }
        }

        public final class OnError implements Runnable {

            /* renamed from: t, reason: collision with root package name */
            private final Throwable f39492t;

            public OnError(Throwable th) {
                this.f39492t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.actual.onError(this.f39492t);
                } finally {
                    DelaySubscriber.this.f39491w.dispose();
                }
            }
        }

        public DelaySubscriber(CoreSubscriber<? super T> coreSubscriber, Duration duration, Scheduler.Worker worker) {
            this.actual = Operators.serialize(coreSubscriber);
            this.f39491w = worker;
            this.delay = duration.toNanos();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void delayedNext(T t10) {
            DELAYED.decrementAndGet(this);
            this.actual.onNext(t10);
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39490s.cancel();
            this.f39491w.dispose();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (DELAYED.compareAndSet(this, 0L, -1L)) {
                this.actual.onComplete();
            } else {
                this.f39491w.schedule(new OnComplete(), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
                return;
            }
            this.done = true;
            if (DELAYED.compareAndSet(this, 0L, -1L)) {
                this.actual.onError(th);
            } else {
                this.f39491w.schedule(new OnError(th), this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(final T t10) {
            if (this.done || this.delayed < 0) {
                Operators.onNextDropped(t10, currentContext());
            } else {
                DELAYED.incrementAndGet(this);
                this.f39491w.schedule(new Runnable() { // from class: reactor.core.publisher.D0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f39459a.delayedNext(t10);
                    }
                }, this.delay, this.timeUnit);
            }
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39490s, dVar)) {
                this.f39490s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            this.f39490s.request(j10);
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            if (attr == Scannable.Attr.PARENT) {
                return this.f39490s;
            }
            if (attr == Scannable.Attr.RUN_ON) {
                return this.f39491w;
            }
            if (attr == Scannable.Attr.TERMINATED) {
                return Boolean.valueOf(this.done);
            }
            if (attr == Scannable.Attr.CANCELLED) {
                return Boolean.valueOf(this.f39491w.isDisposed() && !this.done);
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
