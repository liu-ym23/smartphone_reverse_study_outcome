package Z2;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes2.dex */
public final class S implements T {

    /* renamed from: a, reason: collision with root package name */
    public final Future f2191a;

    public S(ScheduledFuture scheduledFuture) {
        this.f2191a = scheduledFuture;
    }

    @Override // Z2.T
    public final void dispose() {
        this.f2191a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f2191a + ']';
    }
}
