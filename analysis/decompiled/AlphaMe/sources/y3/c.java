package y3;

import Z2.I;

/* loaded from: classes2.dex */
public final class c implements t3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16351a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f16352b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f16353c;

    public /* synthetic */ c(Object obj, x3.e eVar, int i4) {
        this.f16351a = i4;
        this.f16352b = obj;
        this.f16353c = eVar;
    }

    public final void a(t3.g gVar) {
        switch (this.f16351a) {
            case 0:
                try {
                    t3.b bVar = (t3.b) this.f16353c;
                    E3.b bVar2 = E3.c.f418g;
                    if (bVar2 != null) {
                        bVar = (t3.b) bVar2.call(bVar);
                    }
                    t3.g gVar2 = (t3.g) bVar.call(gVar);
                    try {
                        gVar2.getClass();
                        ((t3.a) this.f16352b).call(gVar2);
                        break;
                    } catch (Throwable th) {
                        I.D(th);
                        gVar2.f(th);
                        return;
                    }
                } catch (Throwable th2) {
                    I.D(th2);
                    gVar.f(th2);
                    return;
                }
            case 1:
                d dVar = new d(gVar, (x3.e) this.f16353c);
                gVar.d(dVar);
                ((t3.c) this.f16352b).d(dVar);
                break;
            case 2:
                t3.e eVarB = ((t3.f) this.f16352b).b();
                gVar.d(eVarB);
                eVarB.b(new m(this, gVar, eVarB, 0));
                break;
            default:
                gVar.i(new B3.j(gVar, this.f16352b, (x3.e) this.f16353c));
                break;
        }
    }

    @Override // x3.b
    public final /* bridge */ /* synthetic */ void call(Object obj) {
        switch (this.f16351a) {
            case 0:
                a((t3.g) obj);
                break;
            case 1:
                a((t3.g) obj);
                break;
            case 2:
                a((t3.g) obj);
                break;
            default:
                a((t3.g) obj);
                break;
        }
    }

    public c(t3.c cVar, t3.f fVar) {
        this.f16351a = 2;
        this.f16352b = fVar;
        this.f16353c = cVar;
    }
}
