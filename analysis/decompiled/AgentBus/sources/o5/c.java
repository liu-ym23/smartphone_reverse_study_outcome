package o5;

import c7.r;
import d5.m;
import ia.d0;
import la.a0;

/* loaded from: classes.dex */
public final class c implements la.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7736f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f7737g;

    public /* synthetic */ c(e eVar, int i2) {
        this.f7736f = i2;
        this.f7737g = eVar;
    }

    @Override // la.k
    public final Object emit(Object obj, g7.d dVar) {
        switch (this.f7736f) {
            case 0:
                this.f7737g.b();
                break;
            case 1:
                this.f7737g.b();
                break;
            default:
                d5.i iVar = (d5.i) obj;
                if (iVar instanceof d5.g) {
                    d5.e eVar = ((d5.g) iVar).f2876a;
                    if (eVar.f() == m.CHANNEL || eVar.f() == m.CONSOLE) {
                        e eVar2 = this.f7737g;
                        eVar2.b();
                        d0.s(eVar2.f7750i, null, null, new a0(eVar, eVar2.e((f) eVar2.f7748g.getValue()), eVar2, (g7.d) null, 7), 3);
                    }
                }
                break;
        }
        return r.f1986a;
    }
}
