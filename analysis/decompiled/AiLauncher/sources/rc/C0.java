package rc;

/* loaded from: classes5.dex */
public class C0 extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public AbstractC5284h f39028n;

    public C0(AbstractC5284h abstractC5284h) {
        this.f39028n = abstractC5284h;
        this.f39305d = abstractC5284h.f39305d;
        this.f39306e = abstractC5284h.f39306e;
        this.f39307f = abstractC5284h.f39307f;
        this.f39308g = abstractC5284h.f39308g;
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        d(fVar, f10, f11);
        fVar.l(f10, f11);
        fVar.e(-1.0d, 1.0d);
        this.f39028n.c(fVar, -this.f39305d, 0.0f);
        fVar.e(-1.0d, 1.0d);
        fVar.l(-f10, -f11);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return this.f39028n.i();
    }
}
