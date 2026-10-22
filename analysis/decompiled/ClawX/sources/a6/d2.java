package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d2 extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d2 f150c = new d2();

    @Override // a6.b0
    public final void C(f5.h hVar, Runnable runnable) {
        h2 h2Var = (h2) hVar.o(h2.f168c);
        if (h2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        h2Var.f169b = true;
    }

    @Override // a6.b0
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
