package m9;

/* loaded from: classes4.dex */
public final class g0 extends e0 {
    public final kotlinx.coroutines.c e;
    public final h0 f;
    public final C1722o g;
    public final Object h;

    public g0(kotlinx.coroutines.c cVar, h0 h0Var, C1722o c1722o, Object obj) {
        this.e = cVar;
        this.f = h0Var;
        this.g = c1722o;
        this.h = obj;
    }

    @Override // m9.e0
    public final boolean i() {
        return false;
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        C1722o c1722o = this.g;
        C1722o c1722oX = kotlinx.coroutines.c.X(c1722o);
        kotlinx.coroutines.c cVar = this.e;
        h0 h0Var = this.f;
        Object obj = this.h;
        if (c1722oX == null || !cVar.f0(h0Var, c1722oX, obj)) {
            h0Var.f5329a.c(new s9.g(2), 2);
            C1722o c1722oX2 = kotlinx.coroutines.c.X(c1722o);
            if (c1722oX2 == null || !cVar.f0(h0Var, c1722oX2, obj)) {
                cVar.x(cVar.H(h0Var, obj));
            }
        }
    }
}
