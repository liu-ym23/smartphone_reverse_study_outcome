package kc;

import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 implements g0 {

    /* renamed from: c, reason: collision with root package name */
    public ScheduledFuture f7433c;

    @Override // kc.g0
    public final void dispose() {
        this.f7433c.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f7433c + ']';
    }
}
