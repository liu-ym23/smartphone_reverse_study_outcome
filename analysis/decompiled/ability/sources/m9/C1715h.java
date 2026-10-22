package m9;

import java.util.concurrent.ScheduledFuture;

/* renamed from: m9.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1715h implements InterfaceC1716i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5328a;
    public final Object b;

    public /* synthetic */ C1715h(Object obj, int i) {
        this.f5328a = i;
        this.b = obj;
    }

    @Override // m9.InterfaceC1716i
    public final void b(Throwable th) {
        switch (this.f5328a) {
            case 0:
                ((ScheduledFuture) this.b).cancel(false);
                break;
            case 1:
                ((S7.k) this.b).invoke(th);
                break;
            default:
                ((InterfaceC1693K) this.b).dispose();
                break;
        }
    }

    public final String toString() {
        switch (this.f5328a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((S7.k) this.b).getClass().getSimpleName() + '@' + AbstractC1683A.i(this) + ']';
            default:
                return "DisposeOnCancel[" + ((InterfaceC1693K) this.b) + ']';
        }
    }
}
