package m9;

import java.util.concurrent.ScheduledFuture;

/* renamed from: m9.J, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1692J implements InterfaceC1693K {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f5316a;

    public C1692J(ScheduledFuture scheduledFuture) {
        this.f5316a = scheduledFuture;
    }

    @Override // m9.InterfaceC1693K
    public final void dispose() {
        this.f5316a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f5316a + ']';
    }
}
