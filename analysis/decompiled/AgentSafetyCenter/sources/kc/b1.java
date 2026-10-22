package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 extends g {

    /* renamed from: m, reason: collision with root package name */
    public e1 f7417m;

    @Override // kc.g
    public final Throwable q(e1 e1Var) {
        Throwable thB;
        e1 e1Var2 = this.f7417m;
        e1Var2.getClass();
        Object obj = e1.f7431c.get(e1Var2);
        return (!(obj instanceof d1) || (thB = ((d1) obj).b()) == null) ? obj instanceof n ? ((n) obj).f7461a : e1Var.o() : thB;
    }

    @Override // kc.g
    public final String y() {
        return "AwaitContinuation";
    }
}
