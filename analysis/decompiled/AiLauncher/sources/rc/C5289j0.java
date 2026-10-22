package rc;

/* renamed from: rc.j0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5289j0 extends AbstractC5276d {

    /* renamed from: g, reason: collision with root package name */
    public static R0 f39329g = new R0(1, 0.0f, 1.0f, 0.0f);

    /* renamed from: d, reason: collision with root package name */
    public C5274c f39330d;

    /* renamed from: e, reason: collision with root package name */
    public int f39331e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39332f;

    public C5289j0(boolean z10, C5274c c5274c, int i10) {
        this.f39332f = z10;
        this.f39330d = c5274c;
        this.f39331e = i10;
    }

    @Override // rc.AbstractC5276d
    public AbstractC5284h f(Y0 y02) {
        C5274c c5274c;
        int i10;
        float fP = y02.p();
        if (fP != Float.POSITIVE_INFINITY) {
            if (this.f39331e != 2) {
                q1 q1Var = new q1();
                AbstractC5276d abstractC5276d = this.f39330d.f39230o.get(0).get(0);
                int i11 = this.f39331e == 1 ? 2 : 0;
                int i12 = abstractC5276d.f39250c;
                if (i12 != -1) {
                    i11 = i12;
                }
                q1Var.b(new Q(abstractC5276d.f(y02), fP, i11));
                AbstractC5284h abstractC5284hF = f39329g.f(y02);
                int i13 = 1;
                while (true) {
                    c5274c = this.f39330d;
                    i10 = c5274c.f39232q;
                    if (i13 >= i10 - 1) {
                        break;
                    }
                    AbstractC5276d abstractC5276d2 = c5274c.f39230o.get(i13).get(0);
                    int i14 = abstractC5276d2.f39250c;
                    if (i14 == -1) {
                        i14 = 2;
                    }
                    q1Var.b(abstractC5284hF);
                    q1Var.b(new Q(abstractC5276d2.f(y02), fP, i14));
                    i13++;
                }
                if (i10 > 1) {
                    AbstractC5276d abstractC5276d3 = c5274c.f39230o.get(i10 - 1).get(0);
                    int i15 = this.f39331e != 1 ? 1 : 2;
                    int i16 = abstractC5276d3.f39250c;
                    if (i16 != -1) {
                        i15 = i16;
                    }
                    q1Var.b(abstractC5284hF);
                    q1Var.b(new Q(abstractC5276d3.f(y02), fP, i15));
                }
                float fH = (q1Var.h() + q1Var.g()) / 2.0f;
                q1Var.n(fH);
                q1Var.m(fH);
                return q1Var;
            }
        }
        return new C5279e0(this.f39332f, this.f39330d, "").f(y02);
    }
}
