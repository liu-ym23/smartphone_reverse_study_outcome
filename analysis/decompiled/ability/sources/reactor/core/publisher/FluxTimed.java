package reactor.core.publisher;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.core.scheduler.Scheduler;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
final class FluxTimed<T> extends InternalFluxOperator<T, Timed<T>> {
    final Scheduler clock;

    public static final class ImmutableTimed<T> implements Timed<T> {
        final T event;
        final long eventElapsedNanos;
        final long eventElapsedSinceSubscriptionNanos;
        final long eventTimestampEpochMillis;

        public ImmutableTimed(long j5, long j6, long j10, T t9) {
            this.eventElapsedSinceSubscriptionNanos = j5;
            this.eventElapsedNanos = j6;
            this.eventTimestampEpochMillis = j10;
            this.event = t9;
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
            StringBuilder sb = new StringBuilder("Timed(");
            sb.append(this.event);
            sb.append("){eventElapsedNanos=");
            sb.append(this.eventElapsedNanos);
            sb.append(", eventElapsedSinceSubscriptionNanos=");
            sb.append(this.eventElapsedSinceSubscriptionNanos);
            sb.append(",  eventTimestampEpochMillis=");
            return B7.a.p(sb, this.eventTimestampEpochMillis, '}');
        }
    }

    public static final class TimedSubscriber<T> implements InnerOperator<T, Timed<T>> {
        final CoreSubscriber<? super Timed<T>> actual;
        final Scheduler clock;
        boolean done;
        long lastEventNanos;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5812s;
        long subscriptionNanos;

        public TimedSubscriber(CoreSubscriber<? super Timed<T>> coreSubscriber, Scheduler scheduler) {
            this.actual = coreSubscriber;
            this.clock = scheduler;
        }

        @Override // reactor.core.publisher.InnerProducer
        public CoreSubscriber<? super Timed<T>> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void cancel() {
            this.f5812s.cancel();
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
                Operators.onErrorDropped(th, currentContext());
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                Operators.onNextDropped(t9, currentContext());
                return;
            }
            long jNow = this.clock.now(TimeUnit.NANOSECONDS);
            ImmutableTimed immutableTimed = new ImmutableTimed(jNow - this.subscriptionNanos, jNow - this.lastEventNanos, this.clock.now(TimeUnit.MILLISECONDS), t9);
            this.lastEventNanos = jNow;
            this.actual.onNext(immutableTimed);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5812s, eVar)) {
                this.f5812s = eVar;
                long jNow = this.clock.now(TimeUnit.NANOSECONDS);
                this.subscriptionNanos = jNow;
                this.lastEventNanos = jNow;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public void request(long j5) {
            if (Operators.validate(j5)) {
                this.f5812s.request(j5);
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
