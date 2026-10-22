package rc;

/* renamed from: rc.r0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5304r0 extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public final AbstractC5284h f39385n;

    /* renamed from: o, reason: collision with root package name */
    public final AbstractC5284h f39386o;

    /* renamed from: p, reason: collision with root package name */
    public final AbstractC5284h f39387p;

    /* renamed from: q, reason: collision with root package name */
    public final float f39388q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f39389r;

    public C5304r0(AbstractC5284h abstractC5284h, AbstractC5284h abstractC5284h2, AbstractC5284h abstractC5284h3, float f10, boolean z10) {
        this.f39385n = abstractC5284h;
        this.f39386o = abstractC5284h2;
        this.f39387p = abstractC5284h3;
        this.f39388q = f10;
        this.f39389r = z10;
        this.f39305d = abstractC5284h.k();
        float f11 = 0.0f;
        this.f39306e = abstractC5284h.f39306e + (z10 ? abstractC5284h2.k() : 0.0f) + ((!z10 || abstractC5284h3 == null) ? 0.0f : abstractC5284h3.f39306e + abstractC5284h3.f39307f + f10);
        float fK = abstractC5284h.f39307f + (z10 ? 0.0f : abstractC5284h2.k());
        if (!z10 && abstractC5284h3 != null) {
            f11 = abstractC5284h3.f39306e + abstractC5284h3.f39307f + f10;
        }
        this.f39307f = fK + f11;
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        d(fVar, f10, f11);
        this.f39385n.c(fVar, f10, f11);
        float fK = (f11 - this.f39385n.f39306e) - this.f39386o.k();
        AbstractC5284h abstractC5284h = this.f39386o;
        abstractC5284h.m(abstractC5284h.h() + this.f39386o.g());
        this.f39386o.n(0.0f);
        if (this.f39389r) {
            AbstractC5284h abstractC5284h2 = this.f39386o;
            Ec.a aVarC = fVar.c();
            fVar.l(f10 + ((abstractC5284h2.f39306e + abstractC5284h2.f39307f) * 0.75d), fK);
            fVar.o(1.5707963267948966d);
            this.f39386o.c(fVar, 0.0f, 0.0f);
            fVar.f(aVarC);
            AbstractC5284h abstractC5284h3 = this.f39387p;
            if (abstractC5284h3 != null) {
                abstractC5284h3.c(fVar, f10, (fK - this.f39388q) - abstractC5284h3.f39307f);
            }
        }
        float f12 = f11 + this.f39385n.f39307f;
        if (this.f39389r) {
            return;
        }
        Ec.a aVarC2 = fVar.c();
        fVar.l(f10 + ((this.f39386o.h() + this.f39386o.f39307f) * 0.75d), f12);
        fVar.o(1.5707963267948966d);
        this.f39386o.c(fVar, 0.0f, 0.0f);
        fVar.f(aVarC2);
        float fK2 = f12 + this.f39386o.k();
        AbstractC5284h abstractC5284h4 = this.f39387p;
        if (abstractC5284h4 != null) {
            abstractC5284h4.c(fVar, f10, fK2 + this.f39388q + abstractC5284h4.f39306e);
        }
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return this.f39385n.i();
    }
}
