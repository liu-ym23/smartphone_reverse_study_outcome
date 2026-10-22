package reactor.core.publisher;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import java.util.concurrent.TimeUnit;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.FluxMetrics;
import reactor.util.Metrics;
import reactor.util.annotation.Nullable;

@Deprecated
/* loaded from: classes5.dex */
final class FluxMetricsFuseable<T> extends InternalFluxOperator<T, T> implements Fuseable {
    final String name;
    final MeterRegistry registryCandidate;
    final Tags tags;

    public static final class MetricsFuseableSubscriber<T> extends FluxMetrics.MetricsSubscriber<T> implements Fuseable, Fuseable.QueueSubscription<T> {
        int mode;

        @Nullable
        Fuseable.QueueSubscription<T> qs;

        public MetricsFuseableSubscriber(CoreSubscriber<? super T> coreSubscriber, MeterRegistry meterRegistry, Clock clock, String str, Tags tags) {
            super(coreSubscriber, meterRegistry, clock, str, tags);
        }

        @Override // java.util.Collection
        public void clear() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription != null) {
                queueSubscription.clear();
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            return queueSubscription == null || queueSubscription.isEmpty();
        }

        @Override // reactor.core.publisher.FluxMetrics.MetricsSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qc.c
        public void onNext(T t10) {
            if (this.mode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                FluxMetrics.recordMalformed(this.sequenceName, this.commonTags, this.registry);
                Operators.onNextDropped(t10, this.actual.currentContext());
                return;
            }
            long j10 = this.lastNextEventNanos;
            long jMonotonicTime = this.clock.monotonicTime();
            this.lastNextEventNanos = jMonotonicTime;
            this.onNextIntervalTimer.record(jMonotonicTime - j10, TimeUnit.NANOSECONDS);
            this.actual.onNext(t10);
        }

        @Override // reactor.core.publisher.FluxMetrics.MetricsSubscriber, reactor.core.CoreSubscriber, qc.c
        public void onSubscribe(qc.d dVar) {
            if (Operators.validate(this.f39534s, dVar)) {
                FluxMetrics.recordOnSubscribe(this.sequenceName, this.commonTags, this.registry);
                this.subscribeToTerminateSample = Timer.start(this.clock);
                this.lastNextEventNanos = this.clock.monotonicTime();
                this.qs = Operators.as(dVar);
                this.f39534s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.util.Queue
        @Nullable
        public T poll() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return null;
            }
            try {
                T tPoll = queueSubscription.poll();
                if (tPoll == null && this.mode == 1) {
                    if (this.onNextIntervalTimer.count() == 0) {
                        FluxMetrics.recordOnCompleteEmpty(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                    } else {
                        FluxMetrics.recordOnComplete(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                    }
                }
                if (tPoll != null) {
                    long j10 = this.lastNextEventNanos;
                    long jMonotonicTime = this.clock.monotonicTime();
                    this.lastNextEventNanos = jMonotonicTime;
                    this.onNextIntervalTimer.record(jMonotonicTime - j10, TimeUnit.NANOSECONDS);
                }
                return tPoll;
            } catch (Throwable th) {
                FluxMetrics.recordOnError(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample, th);
                throw th;
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i10) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            int iRequestFusion = queueSubscription.requestFusion(i10);
            this.mode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // java.util.Collection
        public int size() {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            return queueSubscription.size();
        }
    }

    public FluxMetricsFuseable(Flux<? extends T> flux) {
        super(flux);
        this.name = FluxMetrics.resolveName(flux);
        this.tags = FluxMetrics.resolveTags(flux, FluxMetrics.DEFAULT_TAGS_FLUX);
        this.registryCandidate = Metrics.MicrometerConfiguration.getRegistry();
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new MetricsFuseableSubscriber(coreSubscriber, this.registryCandidate, Clock.SYSTEM, this.name, this.tags);
    }
}
