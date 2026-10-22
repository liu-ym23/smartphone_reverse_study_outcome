package rc;

/* loaded from: classes5.dex */
public class s1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39398d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC5276d f39399e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39400f;

    public s1(AbstractC5276d abstractC5276d, AbstractC5276d abstractC5276d2, boolean z10) {
        this.f39398d = abstractC5276d;
        this.f39399e = abstractC5276d2;
        this.f39400f = z10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5276d abstractC5276d = this.f39398d;
        AbstractC5284h abstractC5284hF = abstractC5276d != null ? abstractC5276d.f(y02.C()) : new U0(0.0f, 0.0f, 0.0f, 0.0f);
        AbstractC5276d abstractC5276d2 = this.f39399e;
        AbstractC5284h abstractC5284hF2 = abstractC5276d2 != null ? abstractC5276d2.f(y02.B()) : new U0(0.0f, 0.0f, 0.0f, 0.0f);
        AbstractC5284h abstractC5284hF3 = new R0(0, 1.5f, 0.0f, 0.0f).f(y02.C());
        AbstractC5284h abstractC5284hF4 = new R0(0, 1.5f, 0.0f, 0.0f).f(y02.B());
        AbstractC5284h abstractC5284hF5 = new R0(5, 0.0f, 2.0f, 0.0f).f(y02);
        float fMax = Math.max(abstractC5284hF.k() + (abstractC5284hF3.k() * 2.0f), abstractC5284hF2.k() + (abstractC5284hF4.k() * 2.0f));
        AbstractC5284h abstractC5284hB = t1.b(this.f39400f, y02, fMax);
        Q q10 = new Q(abstractC5284hF, fMax, 2);
        Q q11 = new Q(abstractC5284hF2, fMax, 2);
        q1 q1Var = new q1();
        q1Var.b(q10);
        q1Var.b(abstractC5284hF5);
        q1Var.b(abstractC5284hB);
        q1Var.b(abstractC5284hF5);
        q1Var.b(q11);
        float fH = q1Var.h() + q1Var.g();
        float fH2 = abstractC5284hF5.h() + abstractC5284hF5.g() + q11.h() + q11.g();
        q1Var.m(fH2);
        q1Var.n(fH - fH2);
        return new Q(q1Var, q1Var.k() + (abstractC5284hF5.h() * 2.0f), 2);
    }
}
