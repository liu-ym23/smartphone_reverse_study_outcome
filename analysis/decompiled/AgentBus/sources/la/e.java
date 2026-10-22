package la;

/* loaded from: classes.dex */
public class e extends ma.e {

    /* renamed from: i, reason: collision with root package name */
    public final i7.i f5913i;

    /* JADX WARN: Multi-variable type inference failed */
    public e(p7.n nVar, g7.l lVar, int i2, ka.a aVar) {
        super(lVar, i2, aVar);
        this.f5913i = (i7.i) nVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [i7.i, p7.n] */
    @Override // ma.e
    public Object b(ka.t tVar, g7.d dVar) {
        Object objInvoke = this.f5913i.invoke(tVar, dVar);
        return objInvoke == h7.a.f4212f ? objInvoke : c7.r.f1986a;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [i7.i, p7.n] */
    @Override // ma.e
    public ma.e c(g7.l lVar, int i2, ka.a aVar) {
        return new e(this.f5913i, lVar, i2, aVar);
    }

    @Override // ma.e
    public final String toString() {
        return "block[" + this.f5913i + "] -> " + super.toString();
    }
}
