package la;

/* loaded from: classes.dex */
public final class l0 extends ma.d {

    /* renamed from: a, reason: collision with root package name */
    public long f5953a;

    /* renamed from: b, reason: collision with root package name */
    public ia.m f5954b;

    @Override // ma.d
    public final boolean a(ma.b bVar) {
        j0 j0Var = (j0) bVar;
        if (this.f5953a >= 0) {
            return false;
        }
        long j2 = j0Var.f5940n;
        if (j2 < j0Var.f5941o) {
            j0Var.f5941o = j2;
        }
        this.f5953a = j2;
        return true;
    }

    @Override // ma.d
    public final g7.d[] b(ma.b bVar) {
        long j2 = this.f5953a;
        this.f5953a = -1L;
        this.f5954b = null;
        return ((j0) bVar).r(j2);
    }
}
