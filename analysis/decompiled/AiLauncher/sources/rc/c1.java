package rc;

/* loaded from: classes5.dex */
public class c1 {

    /* renamed from: f, reason: collision with root package name */
    public static final Cc.c f39240f = new Cc.c(0, 0, 0);

    /* renamed from: g, reason: collision with root package name */
    public static float f39241g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    public static float f39242h = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    public AbstractC5284h f39243a;

    /* renamed from: b, reason: collision with root package name */
    public final float f39244b;

    /* renamed from: c, reason: collision with root package name */
    public Cc.h f39245c = new Cc.h(0, 0, 0, 0);

    /* renamed from: d, reason: collision with root package name */
    public Cc.c f39246d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39247e = false;

    public c1(AbstractC5284h abstractC5284h, float f10, boolean z10) {
        this.f39243a = abstractC5284h;
        float f11 = f39241g;
        f10 = f11 != -1.0f ? f11 : f10;
        float f12 = f39242h;
        if (f12 != 0.0f) {
            this.f39244b = Math.abs(f12) * f10;
        } else {
            this.f39244b = f10;
        }
        if (z10) {
            return;
        }
        Cc.h hVar = this.f39245c;
        int i10 = (int) (f10 * 0.18f);
        hVar.f1981a += i10;
        hVar.f1983c += i10;
        hVar.f1982b += i10;
        hVar.f1984d += i10;
    }

    public int a() {
        return ((int) ((this.f39243a.h() * this.f39244b) + 0.99d + this.f39245c.f1981a)) + ((int) ((this.f39243a.g() * this.f39244b) + 0.99d + this.f39245c.f1983c));
    }

    public int b() {
        double dK = (this.f39243a.k() * this.f39244b) + 0.99d;
        Cc.h hVar = this.f39245c;
        return (int) (dK + hVar.f1982b + hVar.f1984d);
    }

    public void c(Cc.d dVar, Cc.g gVar, int i10, int i11) {
        Cc.f fVar = (Cc.f) gVar;
        fVar.q();
        Ec.a aVarC = fVar.c();
        Cc.c cVarK = fVar.k();
        fVar.m(null, Cc.i.f1987c);
        fVar.m(null, Cc.i.f1985a);
        fVar.m(null, Cc.i.f1986b);
        float f10 = this.f39244b;
        fVar.e(f10, f10);
        Cc.c cVar = this.f39246d;
        if (cVar != null) {
            fVar.d(cVar);
        } else if (dVar != null) {
            fVar.d(dVar.a());
        } else {
            fVar.d(f39240f);
        }
        AbstractC5284h abstractC5284h = this.f39243a;
        float f11 = i10 + this.f39245c.f1982b;
        float f12 = this.f39244b;
        abstractC5284h.c(fVar, f11 / f12, ((i11 + r2.f1981a) / f12) + abstractC5284h.h());
        fVar.g(null);
        fVar.f(aVarC);
        fVar.d(cVarK);
    }

    public void d(Cc.c cVar) {
        this.f39246d = cVar;
    }

    public void e(Cc.h hVar) {
        f(hVar, false);
    }

    public void f(Cc.h hVar, boolean z10) {
        this.f39245c = hVar;
        if (z10) {
            return;
        }
        int i10 = hVar.f1981a;
        float f10 = this.f39244b;
        hVar.f1981a = i10 + ((int) (f10 * 0.18f));
        hVar.f1983c += (int) (f10 * 0.18f);
        hVar.f1982b += (int) (f10 * 0.18f);
        hVar.f1984d += (int) (f10 * 0.18f);
    }
}
