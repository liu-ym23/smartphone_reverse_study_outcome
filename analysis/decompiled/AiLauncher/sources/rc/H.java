package rc;

import Ec.d;

/* loaded from: classes5.dex */
public class H extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public AbstractC5284h f39094n;

    /* renamed from: o, reason: collision with root package name */
    public float f39095o;

    /* renamed from: p, reason: collision with root package name */
    public float f39096p;

    /* renamed from: q, reason: collision with root package name */
    public Cc.c f39097q;

    /* renamed from: r, reason: collision with root package name */
    public Cc.c f39098r;

    public H(AbstractC5284h abstractC5284h, float f10, float f11) {
        this.f39094n = abstractC5284h;
        this.f39305d = abstractC5284h.f39305d + (f10 * 2.0f) + (2.0f * f11);
        this.f39306e = abstractC5284h.f39306e + f10 + f11;
        this.f39307f = abstractC5284h.f39307f + f10 + f11;
        this.f39308g = abstractC5284h.f39308g;
        this.f39095o = f10;
        this.f39096p = f11;
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        Cc.j jVarI = fVar.i();
        fVar.v(new Cc.b(this.f39095o, 0, 0));
        float f12 = this.f39095o / 2.0f;
        if (this.f39098r != null) {
            Cc.c cVarK = fVar.k();
            fVar.d(this.f39098r);
            float f13 = this.f39306e;
            float f14 = this.f39305d;
            float f15 = this.f39095o;
            fVar.j(new d.a(f10 + f12, (f11 - f13) + f12, f14 - f15, (f13 + this.f39307f) - f15));
            fVar.d(cVarK);
        }
        if (this.f39097q != null) {
            Cc.c cVarK2 = fVar.k();
            fVar.d(this.f39097q);
            float f16 = f10 + f12;
            float f17 = this.f39306e;
            float f18 = (f11 - f17) + f12;
            float f19 = this.f39305d;
            float f20 = this.f39095o;
            fVar.h(new d.a(f16, f18, f19 - f20, (f17 + this.f39307f) - f20));
            fVar.d(cVarK2);
        } else {
            float f21 = f10 + f12;
            float f22 = this.f39306e;
            float f23 = (f11 - f22) + f12;
            float f24 = this.f39305d;
            float f25 = this.f39095o;
            fVar.h(new d.a(f21, f23, f24 - f25, (f22 + this.f39307f) - f25));
        }
        fVar.v(jVarI);
        this.f39094n.c(fVar, f10 + this.f39096p + this.f39095o, f11);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return this.f39094n.i();
    }

    public H(AbstractC5284h abstractC5284h, float f10, float f11, Cc.c cVar, Cc.c cVar2) {
        this(abstractC5284h, f10, f11);
        this.f39097q = cVar;
        this.f39098r = cVar2;
    }
}
