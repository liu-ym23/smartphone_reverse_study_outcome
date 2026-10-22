package ia;

import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4959a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4960b;

    public /* synthetic */ h(int i2, Object obj) {
        this.f4959a = i2;
        this.f4960b = obj;
    }

    @Override // ia.i
    public final void a(Throwable th) {
        switch (this.f4959a) {
            case 0:
                ((ScheduledFuture) this.f4960b).cancel(false);
                break;
            case 1:
                ((p7.k) this.f4960b).invoke(th);
                break;
            default:
                ((p0) this.f4960b).a();
                break;
        }
    }

    public final String toString() {
        switch (this.f4959a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f4960b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((p7.k) this.f4960b).getClass().getSimpleName() + '@' + d0.k(this) + ']';
            default:
                return "DisposeOnCancel[" + ((p0) this.f4960b) + ']';
        }
    }
}
