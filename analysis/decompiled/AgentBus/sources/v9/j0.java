package v9;

/* loaded from: classes.dex */
public final class j0 extends k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final j0 f10559b = new j0(0);

    /* renamed from: c, reason: collision with root package name */
    public static final j0 f10560c = new j0(1);

    /* renamed from: d, reason: collision with root package name */
    public static final j0 f10561d = new j0(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10562a;

    public /* synthetic */ j0(int i2) {
        this.f10562a = i2;
    }

    @Override // v9.k0
    public final y9.j a(l0 l0Var, y9.h hVar) {
        switch (this.f10562a) {
            case 0:
                q7.k.e(l0Var, "state");
                q7.k.e(hVar, "type");
                return l0Var.f10568c.P(hVar);
            case 1:
                q7.k.e(l0Var, "state");
                q7.k.e(hVar, "type");
                throw new UnsupportedOperationException("Should not be called");
            default:
                q7.k.e(l0Var, "state");
                q7.k.e(hVar, "type");
                return l0Var.f10568c.l0(hVar);
        }
    }
}
