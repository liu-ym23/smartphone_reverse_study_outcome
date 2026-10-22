package rc;

/* renamed from: rc.a0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5271a0 extends AbstractC5276d {

    /* renamed from: d, reason: collision with root package name */
    public AbstractC5276d f39199d;

    /* renamed from: e, reason: collision with root package name */
    public char f39200e;

    public C5271a0(AbstractC5276d abstractC5276d, char c10) {
        this.f39199d = abstractC5276d;
        this.f39200e = c10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        AbstractC5284h abstractC5284hF = this.f39199d.f(y02);
        q1 q1Var = new q1();
        q1Var.b(abstractC5284hF);
        q1Var.p(0.0f);
        char c10 = this.f39200e;
        if (c10 == 'l') {
            abstractC5284hF.o(-abstractC5284hF.k());
            return q1Var;
        }
        if (c10 != 'r') {
            abstractC5284hF.o((-abstractC5284hF.k()) / 2.0f);
            return q1Var;
        }
        abstractC5284hF.o(0.0f);
        return q1Var;
    }
}
