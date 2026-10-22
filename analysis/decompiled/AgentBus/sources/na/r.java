package na;

import ia.d0;
import ia.k0;

/* loaded from: classes.dex */
public class r extends ia.a implements i7.d {

    /* renamed from: i, reason: collision with root package name */
    public final g7.d f6925i;

    public r(g7.d dVar, g7.l lVar) {
        super(lVar, true);
        this.f6925i = dVar;
    }

    @Override // ia.o1
    public final boolean W() {
        return true;
    }

    @Override // i7.d
    public final i7.d getCallerFrame() {
        g7.d dVar = this.f6925i;
        if (dVar instanceof i7.d) {
            return (i7.d) dVar;
        }
        return null;
    }

    public void o0() {
    }

    @Override // ia.o1
    public void w(Object obj) throws k0 {
        b.h(ib.k.C(this.f6925i), d0.u(obj));
    }

    @Override // ia.o1
    public void y(Object obj) {
        this.f6925i.resumeWith(d0.u(obj));
    }
}
