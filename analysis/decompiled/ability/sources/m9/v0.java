package m9;

/* loaded from: classes4.dex */
public final class v0 extends AbstractC1729v {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5336a = 0;

    static {
        new v0();
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        z0 z0Var = (z0) hVar.get(z0.b);
        if (z0Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        z0Var.f5340a = true;
    }

    @Override // m9.AbstractC1729v
    public final boolean isDispatchNeeded(H7.h hVar) {
        return false;
    }

    @Override // m9.AbstractC1729v
    public final AbstractC1729v limitedParallelism(int i, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
