package i8;

import java.util.List;
import v9.x0;

/* loaded from: classes.dex */
public final class a implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4736f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f4737g;

    public /* synthetic */ a(b bVar, int i2) {
        this.f4736f = i2;
        this.f4737g = bVar;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f4736f;
        b bVar = this.f4737g;
        switch (i2) {
            case 0:
                o9.n nVarP0 = bVar.p0();
                c6.i iVar = new c6.i(2, this);
                x9.f fVar = x0.f10604a;
                if (x9.i.f(bVar)) {
                    return x9.i.c(x9.h.f11310p, bVar.toString());
                }
                v9.m0 m0VarH = bVar.h();
                if (m0VarH == null) {
                    x0.a(12);
                    throw null;
                }
                if (nVarP0 == null) {
                    x0.a(13);
                    throw null;
                }
                List listD = x0.d(m0VarH.getParameters());
                v9.i0.f10557g.getClass();
                return v9.d.t(v9.i0.f10558h, m0VarH, listD, false, nVarP0, iVar);
            case 1:
                return new o9.i(bVar.p0());
            default:
                return new v(bVar);
        }
    }
}
