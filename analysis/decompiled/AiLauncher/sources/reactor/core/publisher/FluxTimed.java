package reactor.core.publisher;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes5.dex */
final class FluxTimed<T> extends InternalFluxOperator<T, Timed<T>> {
    final Scheduler clock;

    public static final class ImmutableTimed<T> implements Timed<T> {
        final T event;
        final long eventElapsedNanos;
        final long eventElapsedSinceSubscriptionNanos;
        final long eventTimestampEpochMillis;

        public ImmutableTimed(long j10, long j11, long j12, T t10) {
            this.eventElapsedSinceSubscriptionNanos = j10;
            this.eventElapsedNanos = j11;
            this.eventTimestampEpochMillis = j12;
            this.event = t10;
        }

        @Override // reactor.core.publisher.Timed
        public Duration elapsed() {
            return Duration.ofNanos(this.eventElapsedNanos);
        }

        @Override // reactor.core.publisher.Timed
        public Duration elapsedSinceSubscription() {
            return Duration.ofNanos(this.eventElapsedSinceSubscriptionNanos);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ImmutableTimed.class == obj.getClass()) {
                ImmutableTimed immutableTimed = (ImmutableTimed) obj;
                if (this.eventElapsedSinceSubscriptionNanos == immutableTimed.eventElapsedSinceSubscriptionNanos && this.eventElapsedNanos == immutableTimed.eventElapsedNanos && this.eventTimestampEpochMillis == immutableTimed.eventTimestampEpochMillis && this.event.equals(immutableTimed.event)) {
                    return true;
                }
            }
            return false;
        }

        @Override // reactor.core.publisher.Timed, java.util.function.Supplier
        public T get() {
            return this.event;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.eventElapsedSinceSubscriptionNanos), Long.valueOf(this.eventElapsedNanos), Long.valueOf(this.eventTimestampEpochMillis), this.event);
        }

        @Override // reactor.core.publisher.Timed
        public Instant timestamp() {
            return Instant.ofEpochMilli(this.eventTimestampEpochMillis);
        }

        public String toString() {
            return "Timed(" + this.event + "){eventElapsedNanos=" + this.eventElapsedNanos + ", eventElapsedSinceSubscriptionNanos=" + this.eventElapsedSinceSubscriptionNanos + ",  eventTimestampEpochMillis=" + this.eventTimestampEpochMillis + '}';
        }
    }

    public static final class TimedSubscriber<T> implements InnerOperator<T, Timed<T>> {
        final CoreSubscriber<? super Timed<T>> actual;
        final Scheduler clock;
        boolean done;
        long lastEventNanos;

        /* renamed from: s, reason: collision with root package name */
        qc.d f39594s;
        long subscriptionNanos;

        public TimedSubscriber(CoreSubscriber<? super Timed<T>> coreSubscriber, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.clock = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Timed<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void cancel() {
            this.f39594s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onError(Throwable th) {
            if (this.done) {
                Operators.onErrorDropped(th, currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.done) {
                Operators.onNextDropped(t10, currentContext());
                return;
            }
            long jNow = this.clock.now(TimeUnit.NANOSECONDS);
            ImmutableTimed immutableTimed = new ImmutableTimed(jNow - this.subscriptionNanos, jNow - this.lastEventNanos, this.clock.now(TimeUnit.MILLISECONDS), t10);
            this.lastEventNanos = jNow;
            this.actual.onNext(immutableTimed);
        }

        @Override // reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39594s, dVar)) {
                this.f39594s = dVar;
                long jNow = this.clock.now(TimeUnit.NANOSECONDS);
                this.subscriptionNanos = jNow;
                this.lastEventNanos = jNow;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, qc.d
        public void request(long j10) {
            if (Operators.validate(j10)) {
                this.f39594s.request(j10);
            }
        }

        @Override // reactor.core.Scannable
        @Nullable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.TERMINATED ? Boolean.valueOf(this.done) : attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxTimed(Flux<? extends T> flux, Scheduler scheduler) {
        super(flux);
        this.clock = scheduler;
    }

    @Override // reactor.core.publisher.Flux
    public int getPrefetch() {
        return 0;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    @Nullable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super Timed<T>> coreSubscriber) {
        return new TimedSubscriber(coreSubscriber, this.clock);
    }
}
