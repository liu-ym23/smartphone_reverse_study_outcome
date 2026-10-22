package reactor.core.scheduler;

import reactor.core.Disposable;
import reactor.core.scheduler.SchedulerState;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class l implements Disposable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ SchedulerState.DisposeAwaiterRunnable f10904c;

    @Override // reactor.core.Disposable
    public final void dispose() {
        this.f10904c.cancel();
    }
}
