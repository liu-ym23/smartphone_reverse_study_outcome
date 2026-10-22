package reactor.core.publisher;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import reactor.core.CoreSubscriber;
import reactor.core.Scannable;
import reactor.util.Logger;
import reactor.util.Loggers;
import reactor.util.Metrics;
import stepai.android.llm.base.twoway.FlowType;

@Deprecated
/* loaded from: classes4.dex */
final class FluxMetrics<T> extends InternalFluxOperator<T, T> {
    static final String METER_FLOW_DURATION = ".flow.duration";
    static final String METER_MALFORMED = ".malformed.source";
    static final String METER_ON_NEXT_DELAY = ".onNext.delay";
    static final String METER_REQUESTED = ".requested";
    static final String METER_SUBSCRIBED = ".subscribed";
    static final String REACTOR_DEFAULT_NAME = "reactor";
    static final String TAG_KEY_EXCEPTION = "exception";
    final String name;
    final MeterRegistry registryCandidate;
    final Tags tags;
    static final Tags DEFAULT_TAGS_FLUX = Tags.of("type", "Flux");
    static final Tags DEFAULT_TAGS_MONO = Tags.of("type", "Mono");
    static final Tag TAG_ON_ERROR = Tag.of("status", "error");
    static final Tags TAG_ON_COMPLETE = Tags.of(new String[]{"status", FlowType.COMPLETED, "exception", ""});
    static final Tags TAG_ON_COMPLETE_EMPTY = Tags.of(new String[]{"status", "completedEmpty", "exception", ""});
    static final Tags TAG_CANCEL = Tags.of(new String[]{"status", "cancelled", "exception", ""});
    static final Logger log = Loggers.getLogger((Class<?>) FluxMetrics.class);

    public static class MetricsSubscriber<T> implements InnerOperator<T, T> {
        final CoreSubscriber<? super T> actual;
        final Clock clock;
        final Tags commonTags;
        boolean done;
        long lastNextEventNanos = -1;
        final Timer onNextIntervalTimer;
        final MeterRegistry registry;
        final DistributionSummary requestedCounter;

        /* renamed from: s, reason: collision with root package name */
        Z9.e f5764s;
        final String sequenceName;
        Timer.Sample subscribeToTerminateSample;

        public MetricsSubscriber(CoreSubscriber<? super T> coreSubscriber, MeterRegistry meterRegistry, Clock clock, String str, Tags tags) {
            this.actual = coreSubscriber;
            this.clock = clock;
            this.sequenceName = str;
            this.commonTags = tags;
            this.registry = meterRegistry;
            this.onNextIntervalTimer = Timer.builder(androidx.appfunctions.metadata.a.l(str, FluxMetrics.METER_ON_NEXT_DELAY)).tags(tags).description("Measures delays between onNext signals (or between onSubscribe and first onNext)").register(meterRegistry);
            if (FluxMetrics.REACTOR_DEFAULT_NAME.equals(str)) {
                this.requestedCounter = null;
            } else {
                this.requestedCounter = DistributionSummary.builder(androidx.appfunctions.metadata.a.l(str, FluxMetrics.METER_REQUESTED)).tags(tags).description("Counts the amount requested to a named Flux by all subscribers, until at least one requests an unbounded amount").register(meterRegistry);
            }
        }

        @Override // reactor.core.publisher.InnerProducer
        public final CoreSubscriber<? super T> actual() {
            return this.actual;
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public final void cancel() {
            FluxMetrics.recordCancel(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
            this.f5764s.cancel();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            if (this.onNextIntervalTimer.count() == 0) {
                FluxMetrics.recordOnCompleteEmpty(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
            } else {
                FluxMetrics.recordOnComplete(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample);
            }
            this.actual.onComplete();
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public final void onError(Throwable th) {
            if (this.done) {
                FluxMetrics.recordMalformed(this.sequenceName, this.commonTags, this.registry);
                Operators.onErrorDropped(th, this.actual.currentContext());
            } else {
                this.done = true;
                FluxMetrics.recordOnError(this.sequenceName, this.commonTags, this.registry, this.subscribeToTerminateSample, th);
                this.actual.onError(th);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerConsumer, reactor.core.CoreSubscriber, Z9.d
        public void onNext(T t9) {
            if (this.done) {
                FluxMetrics.recordMalformed(this.sequenceName, this.commonTags, this.registry);
                Operators.onNextDropped(t9, this.actual.currentContext());
                return;
            }
            long j5 = this.lastNextEventNanos;
            long jMonotonicTime = this.clock.monotonicTime();
            this.lastNextEventNanos = jMonotonicTime;
            this.onNextIntervalTimer.record(jMonotonicTime - j5, TimeUnit.NANOSECONDS);
            this.actual.onNext(t9);
        }

        @Override // reactor.core.CoreSubscriber, Z9.d
        public void onSubscribe(Z9.e eVar) {
            if (Operators.validate(this.f5764s, eVar)) {
                FluxMetrics.recordOnSubscribe(this.sequenceName, this.commonTags, this.registry);
                this.subscribeToTerminateSample = Timer.start(this.clock);
                this.lastNextEventNanos = this.clock.monotonicTime();
                this.f5764s = eVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // reactor.core.publisher.InnerOperator, reactor.core.publisher.InnerProducer, Z9.e
        public final void request(long j5) {
            if (Operators.validate(j5)) {
                DistributionSummary distributionSummary = this.requestedCounter;
                if (distributionSummary != null) {
                    distributionSummary.record(j5);
                }
                this.f5764s.request(j5);
            }
        }

        @Override // reactor.core.Scannable
        public Object scanUnsafe(Scannable.Attr attr) {
            return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
        }
    }

    public FluxMetrics(Flux<? extends T> flux) {
        super(flux);
        this.name = resolveName(flux);
        this.tags = resolveTags(flux, DEFAULT_TAGS_FLUX);
        this.registryCandidate = Metrics.MicrometerConfiguration.getRegistry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Tag lambda$resolveTags$0(Map.Entry entry) {
        return Tag.of((String) entry.getKey(), (String) entry.getValue());
    }

    public static void recordCancel(String str, Tags tags, MeterRegistry meterRegistry, Timer.Sample sample) {
        sample.stop(Timer.builder(androidx.appfunctions.metadata.a.l(str, METER_FLOW_DURATION)).tags(tags.and(TAG_CANCEL)).description("Times the duration elapsed between a subscription and the cancellation of the sequence").register(meterRegistry));
    }

    public static void recordMalformed(String str, Tags tags, MeterRegistry meterRegistry) {
        meterRegistry.counter(androidx.appfunctions.metadata.a.l(str, METER_MALFORMED), tags).increment();
    }

    public static void recordOnComplete(String str, Tags tags, MeterRegistry meterRegistry, Timer.Sample sample) {
        sample.stop(Timer.builder(androidx.appfunctions.metadata.a.l(str, METER_FLOW_DURATION)).tags(tags.and(TAG_ON_COMPLETE)).description("Times the duration elapsed between a subscription and the onComplete termination of a sequence that did emit some elements").register(meterRegistry));
    }

    public static void recordOnCompleteEmpty(String str, Tags tags, MeterRegistry meterRegistry, Timer.Sample sample) {
        sample.stop(Timer.builder(androidx.appfunctions.metadata.a.l(str, METER_FLOW_DURATION)).tags(tags.and(TAG_ON_COMPLETE_EMPTY)).description("Times the duration elapsed between a subscription and the onComplete termination of a sequence that didn't emit any element").register(meterRegistry));
    }

    public static void recordOnError(String str, Tags tags, MeterRegistry meterRegistry, Timer.Sample sample, Throwable th) {
        sample.stop(Timer.builder(androidx.appfunctions.metadata.a.l(str, METER_FLOW_DURATION)).tags(tags.and(new Tag[]{TAG_ON_ERROR})).tag("exception", th.getClass().getName()).description("Times the duration elapsed between a subscription and the onError termination of the sequence, with the exception name as a tag.").register(meterRegistry));
    }

    public static void recordOnSubscribe(String str, Tags tags, MeterRegistry meterRegistry) {
        Counter.builder(androidx.appfunctions.metadata.a.l(str, METER_SUBSCRIBED)).tags(tags).description("Counts how many Reactor sequences have been subscribed to").register(meterRegistry).increment();
    }

    public static String resolveName(Z9.c cVar) {
        Scannable scannableFrom = Scannable.from(cVar);
        if (scannableFrom.isScanAvailable()) {
            String strName = scannableFrom.name();
            return scannableFrom.stepName().equals(strName) ? REACTOR_DEFAULT_NAME : strName;
        }
        log.warn("Attempting to activate metrics but the upstream is not Scannable. You might want to use `name()` (and optionally `tags()`) right before `metrics()`");
        return REACTOR_DEFAULT_NAME;
    }

    public static Tags resolveTags(Z9.c cVar, Tags tags) {
        Scannable scannableFrom = Scannable.from(cVar);
        return scannableFrom.isScanAvailable() ? tags.and((List) scannableFrom.tagsDeduplicated().entrySet().stream().map(new C1885a(9)).collect(Collectors.toList())) : tags;
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.FluxOperator, reactor.core.Scannable
    public Object scanUnsafe(Scannable.Attr attr) {
        return attr == Scannable.Attr.RUN_STYLE ? Scannable.Attr.RunStyle.SYNC : super.scanUnsafe(attr);
    }

    @Override // reactor.core.publisher.InternalFluxOperator, reactor.core.publisher.OptimizableOperator
    public CoreSubscriber<? super T> subscribeOrReturn(CoreSubscriber<? super T> coreSubscriber) {
        return new MetricsSubscriber(coreSubscriber, this.registryCandidate, Clock.SYSTEM, this.name, this.tags);
    }
}
