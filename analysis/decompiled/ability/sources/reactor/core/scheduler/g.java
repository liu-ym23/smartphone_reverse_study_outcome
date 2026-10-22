package reactor.core.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Predicate;

/* loaded from: classes4.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5947a;

    public /* synthetic */ g(int i) {
        this.f5947a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5947a) {
            case 0:
                return ParallelScheduler.lambda$inners$2((ScheduledExecutorService) obj);
            case 1:
                return SchedulerMetricDecorator.lambda$null$0((String) obj);
            case 2:
                return SchedulerMetricDecorator.lambda$apply$2((Scheduler) obj);
            case 3:
                return ReactorBlockHoundIntegration.lambda$applyTo$0((Predicate) obj);
            case 4:
                return Integer.valueOf(Integer.parseInt((String) obj));
            default:
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
        }
    }
}
