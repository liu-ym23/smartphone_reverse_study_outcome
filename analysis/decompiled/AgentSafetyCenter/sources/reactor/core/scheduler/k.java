package reactor.core.scheduler;

import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.SchedulerState;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ SchedulerState.DisposeAwaiter f10902c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10903f;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        SchedulerState.DisposeAwaiterRunnable.awaitInPool(this.f10902c, this.f10903f, (FluxSink) obj, 100);
    }
}
