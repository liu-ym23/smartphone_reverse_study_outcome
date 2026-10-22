package i8;

/* loaded from: classes.dex */
public final class o implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4830f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f4831g;

    public /* synthetic */ o(q qVar, int i2) {
        this.f4830f = i2;
        this.f4831g = qVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f4830f) {
            case 0:
                e9.f fVar = (e9.f) obj;
                if (fVar != null) {
                    q qVar = this.f4831g;
                    return qVar.j(fVar, qVar.i().f(fVar, n8.c.f6882k));
                }
                q.h(8);
                throw null;
            default:
                e9.f fVar2 = (e9.f) obj;
                if (fVar2 != null) {
                    q qVar2 = this.f4831g;
                    return qVar2.j(fVar2, qVar2.i().a(fVar2, n8.c.f6882k));
                }
                q.h(4);
                throw null;
        }
    }
}
