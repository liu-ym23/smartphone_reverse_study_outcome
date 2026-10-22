package rc;

/* loaded from: classes5.dex */
public class P extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public float f39143d;

    /* renamed from: e, reason: collision with root package name */
    public float f39144e;

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        S s10 = new S(y02.n().N(y02.m()), this.f39143d, this.f39144e, false);
        q1 q1Var = new q1();
        q1Var.b(s10);
        q1Var.f39309h = 13;
        return q1Var;
    }

    public void i(float f10) {
        this.f39144e = f10;
    }

    public void j(float f10) {
        this.f39143d = f10;
    }
}
