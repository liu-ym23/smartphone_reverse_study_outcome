package reactor.core.scheduler;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.jvm.ExecutorServiceMetrics;
import io.micrometer.core.instrument.search.Search;
import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import reactor.core.Disposable;
import reactor.core.Scannable;
import reactor.util.Metrics;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes2.dex */
final class SchedulerMetricDecorator implements BiFunction<Scheduler, ScheduledExecutorService, ScheduledExecutorService>, Disposable {
    static final String METRICS_DECORATOR_KEY = "reactor.metrics.decorator";
    static final String TAG_SCHEDULER_ID = "reactor.scheduler.id";
    final WeakHashMap<Scheduler, String> seenSchedulers = new WeakHashMap<>();
    final Map<String, AtomicInteger> schedulerDifferentiator = new HashMap();
    final WeakHashMap<Scheduler, AtomicInteger> executorDifferentiator = new WeakHashMap<>();
    final MeterRegistry registry = Metrics.MicrometerConfiguration.getRegistry();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
            Collection collectionMeters = Search.in(SchedulerMetricDecorator.this.registry).tag("name", this.val$executorId).meters();
            MeterRegistry meterRegistry = SchedulerMetricDecorator.this.registry;
            meterRegistry.getClass();
            j jVar = new j();
            jVar.f10901c = meterRegistry;
            VarHandle.storeStoreFence();
            collectionMeters.forEach(jVar);
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

    @Override // java.util.function.BiFunction
    public synchronized ScheduledExecutorService apply(Scheduler scheduler, ScheduledExecutorService scheduledExecutorService) {
        String strComputeIfAbsent;
        String str = (String) Scannable.from(scheduler).scanOrDefault(Scannable.Attr.NAME, scheduler.getClass().getName());
        WeakHashMap<Scheduler, String> weakHashMap = this.seenSchedulers;
        i iVar = new i();
        iVar.f10899a = this;
        iVar.f10900b = str;
        VarHandle.storeStoreFence();
        strComputeIfAbsent = weakHashMap.computeIfAbsent(scheduler, iVar);
        return new C1MetricsRemovingScheduledExecutorService(scheduledExecutorService, strComputeIfAbsent + "-" + this.executorDifferentiator.computeIfAbsent(scheduler, new g(2)).getAndIncrement(), new Tag[]{Tag.of(TAG_SCHEDULER_ID, strComputeIfAbsent)});
    }

    @Override // reactor.core.Disposable
    public void dispose() {
        Collection collectionMeters = Search.in(this.registry).tagKeys(new String[]{TAG_SCHEDULER_ID}).meters();
        MeterRegistry meterRegistry = this.registry;
        meterRegistry.getClass();
        h hVar = new h();
        hVar.f10898c = meterRegistry;
        VarHandle.storeStoreFence();
        collectionMeters.forEach(hVar);
        this.seenSchedulers.clear();
        this.schedulerDifferentiator.clear();
        this.executorDifferentiator.clear();
    }
}
