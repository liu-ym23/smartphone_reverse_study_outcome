package rc;

/* loaded from: classes5.dex */
public class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC5276d f39418a = W0.p("minus");

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC5276d f39419b = W0.p("leftarrow");

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC5276d f39420c = W0.p("rightarrow");

    public static AbstractC5284h a(Y0 y02, float f10) {
        AbstractC5284h abstractC5284hF = f39419b.f(y02);
        AbstractC5284h abstractC5284hF2 = f39420c.f(y02);
        float fK = abstractC5284hF.k() + abstractC5284hF2.k();
        float f11 = 0.0f;
        if (f10 < fK) {
            Q q10 = new Q(abstractC5284hF);
            q10.b(new U0(-Math.min(fK - f10, abstractC5284hF.k()), 0.0f, 0.0f, 0.0f));
            q10.b(abstractC5284hF2);
            return q10;
        }
        AbstractC5284h abstractC5284hF3 = new Q0(f39418a, "").f(y02);
        AbstractC5284h abstractC5284hF4 = new R0(5, -3.4f, 0.0f, 0.0f).f(y02);
        float fK2 = abstractC5284hF3.k() + abstractC5284hF4.k();
        float fK3 = fK + (abstractC5284hF4.k() * 2.0f);
        Q q11 = new Q();
        while (true) {
            if (f11 >= (f10 - fK3) - fK2) {
                q11.b(new L0(abstractC5284hF3, (r6 - f11) / abstractC5284hF3.k(), 1.0d));
                q11.a(0, abstractC5284hF4);
                q11.a(0, abstractC5284hF);
                q11.b(abstractC5284hF4);
                q11.b(abstractC5284hF2);
                return q11;
            }
            q11.b(abstractC5284hF3);
            q11.b(abstractC5284hF4);
            f11 += fK2;
        }
    }

    public static AbstractC5284h b(boolean z10, Y0 y02, float f10) {
        float f11;
        AbstractC5284h abstractC5284hF = (z10 ? f39419b : f39420c).f(y02);
        float fH = abstractC5284hF.h();
        float fG = abstractC5284hF.g();
        float fK = abstractC5284hF.k();
        if (f10 <= fK) {
            abstractC5284hF.m(fG / 2.0f);
            return abstractC5284hF;
        }
        AbstractC5284h abstractC5284hF2 = new Q0(f39418a, "").f(y02);
        AbstractC5284h abstractC5284hF3 = new R0(5, -4.0f, 0.0f, 0.0f).f(y02);
        float fK2 = abstractC5284hF2.k() + abstractC5284hF3.k();
        float fK3 = fK + abstractC5284hF3.k();
        Q q10 = new Q();
        float f12 = 0.0f;
        while (true) {
            f11 = f10 - fK3;
            if (f12 >= f11 - fK2) {
                break;
            }
            q10.b(abstractC5284hF2);
            q10.b(abstractC5284hF3);
            f12 += fK2;
        }
        float fK4 = (f11 - f12) / abstractC5284hF2.k();
        float f13 = (-2.0f) * fK4;
        q10.b(new R0(5, f13, 0.0f, 0.0f).f(y02));
        q10.b(new K0(f39418a, fK4, 1.0d).f(y02));
        if (z10) {
            q10.a(0, new R0(5, -3.5f, 0.0f, 0.0f).f(y02));
            q10.a(0, abstractC5284hF);
        } else {
            q10.b(new R0(5, f13 - 2.0f, 0.0f, 0.0f).f(y02));
            q10.b(abstractC5284hF);
        }
        q10.m(fG / 2.0f);
        q10.n(fH);
        return q10;
    }
}
