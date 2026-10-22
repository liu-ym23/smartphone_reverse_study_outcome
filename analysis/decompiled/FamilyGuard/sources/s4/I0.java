package s4;

/* loaded from: classes.dex */
public final class I0 extends AbstractC1056E {

    /* renamed from: c, reason: collision with root package name */
    public static final I0 f20305c = new I0();

    private I0() {
    }

    @Override // s4.AbstractC1056E
    public void Y(Z3.i iVar, Runnable runnable) {
        M0 m02 = (M0) iVar.a(M0.f20315c);
        if (m02 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        m02.f20316b = true;
    }

    @Override // s4.AbstractC1056E
    public boolean c0(Z3.i iVar) {
        return false;
    }

    @Override // s4.AbstractC1056E
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
