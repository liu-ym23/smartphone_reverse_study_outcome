package reactor.core.publisher;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.Scannable;
import reactor.core.publisher.MonoMetrics;
import reactor.util.Metrics;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
final class MonoMetricsFuseable<T> extends InternalMonoOperator<T, T> implements Fuseable {
    final String name;
    final MeterRegistry registryCandidate;
    final Tags tags;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class MetricsFuseableSubscriber<T> extends MonoMetrics.MetricsSubscriber<T> implements Fuseable, Fuseable.QueueSubscription<T> {
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

        @Override // reactor.core.publisher.MonoMetrics.MetricsSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onComplete() {
            int i = this.mode;
            boolean z10 = this.done;
            if (i == 2) {
                if (!z10) {
                    FluxMetrics.recordOnCompleteEmpty(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                }
                this.actual.onComplete();
            } else {
                if (z10) {
                    return;
                }
                this.done = true;
                FluxMetrics.recordOnCompleteEmpty(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.MonoMetrics.MetricsSubscriber, reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, qd.d
        public void onNext(T t10) {
            if (this.mode == 2) {
                this.actual.onNext(null);
                return;
            }
            if (this.done) {
                FluxMetrics.recordMalformed(this.sequenceName, this.commonTags, this.registry);
                Operators.onNextDropped(t10, this.actual.currentContext());
            } else {
                this.done = true;
                FluxMetrics.recordOnComplete(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                this.actual.onNext(t10);
                this.actual.onComplete();
            }
        }

        @Override // reactor.core.publisher.MonoMetrics.MetricsSubscriber, reactor.core.CoreSubscriber, qd.d
        public void onSubscribe(qd.e eVar) {
            if (Operators.validate(this.f10729s, eVar)) {
                FluxMetrics.recordOnSubscribe(this.sequenceName, this.commonTags, this.registry);
                this.subscribeToTerminateSample = Timer.start(this.clock);
                this.qs = Operators.as(eVar);
                this.f10729s = eVar;
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
                if (!this.done) {
                    if (tPoll == null && this.mode == 1) {
                        FluxMetrics.recordOnCompleteEmpty(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                    } else if (tPoll != null) {
                        FluxMetrics.recordOnComplete(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
                    }
                }
                this.done = true;
                return tPoll;
            } catch (Throwable th) {
                FluxMetrics.recordOnError(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample, th);
                throw th;
            }
        }

        @Override // reactor.core.Fuseable.QueueSubscription
        public int requestFusion(int i) {
            Fuseable.QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null) {
                return 0;
            }
            int iRequestFusion = queueSubscription.requestFusion(i);
            this.mode = iRequestFusion;
            return iRequestFusion;
        }

        @Override // reactor.core.publisher.MonoMetrics.MetricsSubscriber, reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
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

    public MonoMetricsFuseable(Mono<? extends T> mono) {
        super(mono);
        this.name = FluxMetrics.resolveName(mono);
        this.tags = FluxMetrics.resolveTags(mono, FluxMetrics.DEFAULT_TAGS_MONO);
        this.registryCandidate = Metrics.MicrometerConfiguration.getRegistry();
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.MonoOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalMonoOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new MetricsFuseableSubscriber(coreSubscriber, this.registryCandidate, Clock.SYSTEM, this.name, this.tags);
    }
}
