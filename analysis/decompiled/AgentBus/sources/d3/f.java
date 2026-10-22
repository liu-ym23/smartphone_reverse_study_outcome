package d3;

import c.o;
import la.u0;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public i5.f f2812a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2813b;

    public final void a() {
        i5.f fVar = this.f2812a;
        if (fVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.f2813b) {
            fVar.B(this, null);
        }
        g gVar = (g) fVar.f4654h;
        c.m mVar = (c.m) fVar.f4653g;
        gVar.getClass();
        if (equals(gVar.f2821h) && -1 == gVar.f2820g) {
            d dVarC = gVar.f2819f;
            if (dVarC == null) {
                dVarC = gVar.c(-1);
            }
            gVar.f2819f = null;
            gVar.f2820g = 0;
            gVar.f2821h = null;
            if (dVarC == null) {
                ((o) mVar.f1709a).f1711a.run();
            } else {
                dVarC.b();
            }
            u0 u0Var = gVar.f2814a;
            u0Var.getClass();
            u0Var.g(null, h.f2828a);
        }
        this.f2813b = false;
    }

    public void b(boolean z4) {
    }
}
