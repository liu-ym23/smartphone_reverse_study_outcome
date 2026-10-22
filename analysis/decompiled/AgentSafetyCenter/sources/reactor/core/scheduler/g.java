package reactor.core.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10897a;

    public /* synthetic */ g(int i) {
        this.f10897a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f10897a) {
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
