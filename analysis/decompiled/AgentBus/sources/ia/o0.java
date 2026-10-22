package ia;

import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final class o0 implements p0 {

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledFuture f4990f;

    public o0(ScheduledFuture scheduledFuture) {
        this.f4990f = scheduledFuture;
    }

    @Override // ia.p0
    public final void a() {
        this.f4990f.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f4990f + ']';
    }
}
