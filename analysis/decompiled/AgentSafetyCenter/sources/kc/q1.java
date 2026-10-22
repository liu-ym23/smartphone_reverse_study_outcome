package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q1 extends p {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f7475f = 0;

    static {
        new q1();
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        u1 u1Var = (u1) gVar.get(u1.f7486f);
        if (u1Var != null) {
            u1Var.f7487c = true;
        } else {
            g5.f.o("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    @Override // kc.p
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
