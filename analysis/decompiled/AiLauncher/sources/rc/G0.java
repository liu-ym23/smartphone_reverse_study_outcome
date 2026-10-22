package rc;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes5.dex */
public class G0 extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public double f39086n;

    /* renamed from: o, reason: collision with root package name */
    public AbstractC5284h f39087o;

    /* renamed from: p, reason: collision with root package name */
    public float f39088p;

    /* renamed from: q, reason: collision with root package name */
    public float f39089q;

    /* renamed from: r, reason: collision with root package name */
    public float f39090r;

    /* renamed from: s, reason: collision with root package name */
    public float f39091s;

    /* renamed from: t, reason: collision with root package name */
    public float f39092t;

    /* renamed from: u, reason: collision with root package name */
    public float f39093u;

    public G0(AbstractC5284h abstractC5284h, double d10, float f10, float f11) {
        this.f39087o = abstractC5284h;
        double d11 = (3.141592653589793d * d10) / 180.0d;
        this.f39086n = d11;
        this.f39306e = abstractC5284h.f39306e;
        this.f39307f = abstractC5284h.f39307f;
        this.f39305d = abstractC5284h.f39305d;
        double dSin = Math.sin(d11);
        double dCos = Math.cos(this.f39086n);
        double d12 = f10;
        double d13 = 1.0d - dCos;
        double d14 = f11;
        this.f39092t = (float) ((d12 * d13) + (d14 * dSin));
        this.f39093u = (float) ((d14 * d13) - (d12 * dSin));
        float f12 = this.f39306e;
        float f13 = this.f39307f;
        float f14 = this.f39305d;
        this.f39088p = ((float) Math.max((-f12) * dSin, Math.max(f13 * dSin, Math.max((f14 * dCos) + (f13 * dSin), (f14 * dCos) - (f12 * dSin))))) + this.f39092t;
        float f15 = this.f39306e;
        float f16 = this.f39307f;
        float f17 = this.f39305d;
        this.f39089q = ((float) Math.min((-f15) * dSin, Math.min(f16 * dSin, Math.min((f17 * dCos) + (f16 * dSin), (f17 * dCos) - (f15 * dSin))))) + this.f39092t;
        float f18 = this.f39306e;
        float f19 = this.f39307f;
        float f20 = this.f39305d;
        this.f39090r = (float) Math.max(f18 * dCos, Math.max((-f19) * dCos, Math.max((f20 * dSin) - (f19 * dCos), (f20 * dSin) + (f18 * dCos))));
        float f21 = this.f39306e;
        float f22 = this.f39307f;
        float f23 = this.f39305d;
        float fMin = (float) Math.min(f21 * dCos, Math.min((-f22) * dCos, Math.min((f23 * dSin) - (f22 * dCos), (f23 * dSin) + (f21 * dCos))));
        this.f39091s = fMin;
        this.f39305d = this.f39088p - this.f39089q;
        float f24 = this.f39090r;
        float f25 = this.f39093u;
        this.f39306e = f24 + f25;
        this.f39307f = (-fMin) - f25;
    }

    public static Ec.c r(AbstractC5284h abstractC5284h, int i10) {
        Ec.c cVar = new Ec.c(0.0f, -abstractC5284h.f39307f);
        switch (i10) {
            case 0:
                cVar.f2511a = 0.0f;
                cVar.f2512b = -abstractC5284h.f39307f;
                break;
            case 1:
                cVar.f2511a = abstractC5284h.f39305d / 2.0f;
                cVar.f2512b = -abstractC5284h.f39307f;
                break;
            case 2:
                cVar.f2511a = abstractC5284h.f39305d;
                cVar.f2512b = -abstractC5284h.f39307f;
                break;
            case 3:
                cVar.f2511a = 0.0f;
                cVar.f2512b = abstractC5284h.f39306e;
                break;
            case 4:
                cVar.f2511a = abstractC5284h.f39305d / 2.0f;
                cVar.f2512b = abstractC5284h.f39306e;
                break;
            case 5:
                cVar.f2511a = abstractC5284h.f39305d;
                cVar.f2512b = abstractC5284h.f39306e;
                break;
            case 6:
                cVar.f2511a = 0.0f;
                cVar.f2512b = 0.0f;
                break;
            case 7:
                cVar.f2511a = abstractC5284h.f39305d;
                cVar.f2512b = 0.0f;
                break;
            case 8:
                cVar.f2511a = abstractC5284h.f39305d / 2.0f;
                cVar.f2512b = 0.0f;
                break;
            case 9:
                cVar.f2511a = 0.0f;
                cVar.f2512b = (abstractC5284h.f39306e - abstractC5284h.f39307f) / 2.0f;
                break;
            case 10:
                cVar.f2511a = abstractC5284h.f39305d / 2.0f;
                cVar.f2512b = (abstractC5284h.f39306e - abstractC5284h.f39307f) / 2.0f;
                break;
            case 11:
                cVar.f2511a = abstractC5284h.f39305d;
                cVar.f2512b = (abstractC5284h.f39306e - abstractC5284h.f39307f) / 2.0f;
                break;
        }
        return cVar;
    }

    public static int s(String str) {
        if (str == null || str.length() == 0) {
            return 6;
        }
        if (str.length() == 1) {
            str = str + "c";
        }
        if (str.equals("bl") || str.equals("lb")) {
            return 0;
        }
        if (str.equals("bc") || str.equals("cb")) {
            return 1;
        }
        if (str.equals("br") || str.equals("rb")) {
            return 2;
        }
        if (str.equals(Const.SP_KEY_CONTINUE_LOCATION) || str.equals("lc")) {
            return 9;
        }
        if (str.equals("cc")) {
            return 10;
        }
        if (str.equals("cr") || str.equals("cr")) {
            return 11;
        }
        if (str.equals("tl") || str.equals("lt")) {
            return 3;
        }
        if (str.equals("tc") || str.equals(Const.SP_KEY_CACHETIME)) {
            return 4;
        }
        if (str.equals("tr") || str.equals("rt")) {
            return 5;
        }
        if (str.equals("Bl") || str.equals("lB")) {
            return 6;
        }
        if (str.equals("Bc") || str.equals("cB")) {
            return 8;
        }
        return (str.equals("Br") || str.equals("rB")) ? 7 : 6;
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        d(fVar, f10, f11);
        this.f39087o.e(fVar, f10, f11, true);
        float f12 = f11 - this.f39093u;
        float f13 = f10 + (this.f39092t - this.f39089q);
        double d10 = f13;
        double d11 = f12;
        fVar.p(-this.f39086n, d10, d11);
        this.f39087o.c(fVar, f13, f12);
        this.f39087o.e(fVar, f13, f12, true);
        fVar.p(this.f39086n, d10, d11);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return this.f39087o.i();
    }

    public G0(AbstractC5284h abstractC5284h, double d10, Ec.c cVar) {
        this(abstractC5284h, d10, cVar.f2511a, cVar.f2512b);
    }

    public G0(AbstractC5284h abstractC5284h, double d10, int i10) {
        this(abstractC5284h, d10, r(abstractC5284h, i10));
    }
}
