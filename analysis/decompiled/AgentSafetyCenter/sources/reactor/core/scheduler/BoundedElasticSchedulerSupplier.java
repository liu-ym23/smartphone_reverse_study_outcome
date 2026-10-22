package reactor.core.scheduler;

import java.util.function.Supplier;
import reactor.util.Logger;
import reactor.util.Loggers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class BoundedElasticSchedulerSupplier implements Supplier<Scheduler> {
    static final Logger logger = Loggers.getLogger((Class<?>) BoundedElasticSchedulerSupplier.class);

    @Override // java.util.function.Supplier
    public Scheduler get() {
        if (Schedulers.DEFAULT_BOUNDED_ELASTIC_ON_VIRTUAL_THREADS) {
            logger.warn("Virtual Threads support is not available on the given JVM. Falling back to default BoundedElastic setup");
        }
        return Schedulers.newBoundedElastic(Schedulers.DEFAULT_BOUNDED_ELASTIC_SIZE, Schedulers.DEFAULT_BOUNDED_ELASTIC_QUEUESIZE, "boundedElastic", 60, true);
    }
}
