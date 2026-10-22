package kc;

import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements j1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7428a;

    /* renamed from: b, reason: collision with root package name */
    public Object f7429b;

    public /* synthetic */ e(int i) {
        this.f7428a = i;
    }

    public final String toString() {
        switch (this.f7428a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f7429b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((xb.l) this.f7429b).getClass().getSimpleName() + '@' + w.m(this) + ']';
            default:
                return "DisposeOnCancel[" + ((g0) this.f7429b) + ']';
        }
    }
}
