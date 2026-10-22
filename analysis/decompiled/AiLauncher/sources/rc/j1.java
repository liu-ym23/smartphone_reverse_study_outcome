package rc;

/* loaded from: classes5.dex */
public class j1 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39333d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39334e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39335f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39336g;

    public j1(AbstractC5276d abstractC5276d, boolean z10, boolean z11) {
        this.f39336g = false;
        this.f39333d = abstractC5276d;
        this.f39335f = z10;
        this.f39334e = z11;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hB;
        float f10;
        AbstractC5276d abstractC5276d = this.f39333d;
        AbstractC5284h abstractC5284hF = abstractC5276d != null ? abstractC5276d.f(y02) : new U0(0.0f, 0.0f, 0.0f, 0.0f);
        float fK = new R0(3, 1.0f, 0.0f, 0.0f).f(y02).k();
        if (this.f39336g) {
            abstractC5284hB = t1.a(y02, abstractC5284hF.k());
            f10 = fK * 4.0f;
        } else {
            abstractC5284hB = t1.b(this.f39335f, y02, abstractC5284hF.k());
            f10 = -fK;
        }
        q1 q1Var = new q1();
        if (this.f39334e) {
            q1Var.b(abstractC5284hB);
            q1Var.b(new Q(abstractC5284hF, abstractC5284hB.k(), 2));
            float fG = q1Var.g() + q1Var.h();
            q1Var.m(abstractC5284hF.g());
            q1Var.n(fG - abstractC5284hF.g());
            return q1Var;
        }
        q1Var.b(new Q(abstractC5284hF, abstractC5284hB.k(), 2));
        q1Var.b(new U0(0.0f, f10, 0.0f, 0.0f));
        q1Var.b(abstractC5284hB);
        q1Var.m((q1Var.g() + q1Var.h()) - abstractC5284hF.h());
        q1Var.n(abstractC5284hF.h());
        return q1Var;
    }

    public j1(AbstractC5276d abstractC5276d, boolean z10) {
        this.f39335f = false;
        this.f39333d = abstractC5276d;
        this.f39334e = z10;
        this.f39336g = true;
    }
}
