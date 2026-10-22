package rc;

import Ec.d;

/* loaded from: classes5.dex */
public class S extends AbstractC5284h {

    /* renamed from: n, reason: collision with root package name */
    public Cc.c f39161n;

    /* renamed from: o, reason: collision with root package name */
    public float f39162o;

    public S(float f10, float f11, float f12) {
        this.f39161n = null;
        this.f39162o = 0.0f;
        this.f39306e = f10;
        this.f39305d = f11;
        this.f39308g = f12;
    }

    @Override // rc.AbstractC5284h
    public void c(Cc.f fVar, float f10, float f11) {
        Cc.c cVarK = fVar.k();
        Cc.c cVar = this.f39161n;
        if (cVar != null) {
            fVar.d(cVar);
        }
        float f12 = this.f39162o;
        if (f12 == 0.0f) {
            float f13 = this.f39306e;
            fVar.j(new d.a(f10, f11 - f13, this.f39305d, f13));
        } else {
            float f14 = this.f39306e;
            fVar.j(new d.a(f10, (f11 - f14) + f12, this.f39305d, f14));
        }
        fVar.d(cVarK);
    }

    @Override // rc.AbstractC5284h
    public int i() {
        return -1;
    }

    public S(float f10, float f11, float f12, boolean z10) {
        this.f39161n = null;
        this.f39162o = 0.0f;
        this.f39306e = f10;
        this.f39305d = f11;
        if (z10) {
            this.f39308g = f12;
        } else {
            this.f39308g = 0.0f;
            this.f39162o = f12;
        }
    }
}
