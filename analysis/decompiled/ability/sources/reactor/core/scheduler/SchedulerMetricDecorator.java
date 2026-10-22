package reactor.core.scheduler;

import androidx.autofill.HintConstants;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.jvm.ExecutorServiceMetrics;
import io.micrometer.core.instrument.search.Search;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.Metrics;

@Deprecated
/* loaded from: classes4.dex */
final class SchedulerMetricDecorator implements BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>, Disposable {
    static final String METRICS_DECORATOR_KEY = "reactor.metrics.decorator";
    static final String TAG_SCHEDULER_ID = "reactor.scheduler.id";
    final WeakHashMap<Scheduler, String> seenSchedulers = new WeakHashMap<>();
    final Map<String, AtomicInteger> schedulerDifferentiator = new HashMap();
    final WeakHashMap<Scheduler, AtomicInteger> executorDifferentiator = new WeakHashMap<>();
    final MeterRegistry registry = Metrics.MicrometerConfiguration.getRegistry();

    /* renamed from: reactor.core.scheduler.SchedulerMetricDecorator$1MetricsRemovingScheduledExecutorService, reason: invalid class name */
    public class C1MetricsRemovingScheduledExecutorService extends DelegatingScheduledExecutorService {
        final /* synthetic */ String val$executorId;
        final /* synthetic */ ScheduledExecutorService val$service;
        final /* synthetic */ Tag[] val$tags;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1MetricsRemovingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService, String str, Tag[] tagArr) {
            super(ExecutorServiceMetrics.monitor(SchedulerMetricDecorator.this.registry, scheduledExecutorService, str, tagArr));
            this.val$service = scheduledExecutorService;
            this.val$executorId = str;
            this.val$tags = tagArr;
        }

        public void removeMetrics() {
            Collection collectionMeters = Search.in(SchedulerMetricDecorator.this.registry).tag(HintConstants.AUTOFILL_HINT_NAME, this.val$executorId).meters();
            final MeterRegistry meterRegistry = SchedulerMetricDecorator.this.registry;
            meterRegistry.getClass();
            collectionMeters.forEach(new Consumer() { // from class: reactor.core.scheduler.j
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    meterRegistry.remove((Meter) obj);
                }
            });
        }

        @Override // reactor.core.scheduler.DelegatingScheduledExecutorService, java.util.concurrent.ExecutorService
        public void shutdown() {
            removeMetrics();
            super.shutdown();
        }

        @Override // reactor.core.scheduler.DelegatingScheduledExecutorService, java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            removeMetrics();
            return super.shutdownNow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$apply$1(String str, Scheduler scheduler) {
        int andIncrement = this.schedulerDifferentiator.computeIfAbsent(str, new g(1)).getAndIncrement();
        if (andIncrement == 0) {
            return str;
        }
        return str + "#" + andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AtomicInteger lambda$apply$2(Scheduler scheduler) {
        return new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AtomicInteger lambda$null$0(String str) {
        return new AtomicInteger(0);
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        Collection collectionMeters = Search.in(this.registry).tagKeys(new String[]{TAG_SCHEDULER_ID}).meters();
        final MeterRegistry meterRegistry = this.registry;
        meterRegistry.getClass();
        collectionMeters.forEach(new Consumer() { // from class: reactor.core.scheduler.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                meterRegistry.remove((Meter) obj);
            }
        });
        this.seenSchedulers.clear();
        this.schedulerDifferentiator.clear();
        this.executorDifferentiator.clear();
    }

    @Override // java.util.function.BiFunction
    public synchronized ScheduledExecutorService apply(Scheduler scheduler, ScheduledExecutorService scheduledExecutorService) {
        String strComputeIfAbsent;
        final String str = (String) Scannable.from(scheduler).scanOrDefault(Scannable.Attr.NAME, scheduler.getClass().getName());
        strComputeIfAbsent = this.seenSchedulers.computeIfAbsent(scheduler, new Function() { // from class: reactor.core.scheduler.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f5949a.lambda$apply$1(str, (Scheduler) obj);
            }
        });
        return new C1MetricsRemovingScheduledExecutorService(scheduledExecutorService, strComputeIfAbsent + "-" + this.executorDifferentiator.computeIfAbsent(scheduler, new g(2)).getAndIncrement(), new Tag[]{Tag.of(TAG_SCHEDULER_ID, strComputeIfAbsent)});
    }
}
