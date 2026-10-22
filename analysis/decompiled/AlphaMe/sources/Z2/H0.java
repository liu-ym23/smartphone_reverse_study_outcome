package Z2;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class H0 extends A {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2167a = 0;

    static {
        new H0();
    }

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        M0 m02 = (M0) coroutineContext.get(M0.f2185b);
        if (m02 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        m02.f2186a = true;
    }

    @Override // Z2.A
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // Z2.A
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
