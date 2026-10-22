package reactor.core.scheduler;

import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ SchedulerMetricDecorator f10899a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ String f10900b;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f10899a.lambda$apply$1(this.f10900b, (Scheduler) obj);
    }
}
