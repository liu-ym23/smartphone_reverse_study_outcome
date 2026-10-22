package e3;

/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public com.stepos.statsrpk.d f4367a = new n();
    public com.stepos.statsrpk.d b = new n();
    public com.stepos.statsrpk.d c = new n();
    public com.stepos.statsrpk.d d = new n();
    public InterfaceC1415d e = new C1412a(0.0f);
    public InterfaceC1415d f = new C1412a(0.0f);
    public InterfaceC1415d g = new C1412a(0.0f);
    public InterfaceC1415d h = new C1412a(0.0f);
    public C1417f i;

    /* renamed from: j, reason: collision with root package name */
    public C1417f f4368j;
    public C1417f k;
    public C1417f l;

    public o() {
        int i = 0;
        this.i = new C1417f(i);
        this.f4368j = new C1417f(i);
        this.k = new C1417f(i);
        this.l = new C1417f(i);
    }

    public static void b(com.stepos.statsrpk.d dVar) {
        if (dVar instanceof n) {
            ((n) dVar).getClass();
        } else if (dVar instanceof C1416e) {
            ((C1416e) dVar).getClass();
        }
    }

    public final p a() {
        p pVar = new p();
        pVar.f4369a = this.f4367a;
        pVar.b = this.b;
        pVar.c = this.c;
        pVar.d = this.d;
        pVar.e = this.e;
        pVar.f = this.f;
        pVar.g = this.g;
        pVar.h = this.h;
        pVar.i = this.i;
        pVar.f4370j = this.f4368j;
        pVar.k = this.k;
        pVar.l = this.l;
        return pVar;
    }

    public final void c(float f) {
        this.e = new C1412a(f);
        this.f = new C1412a(f);
        this.g = new C1412a(f);
        this.h = new C1412a(f);
    }
}
