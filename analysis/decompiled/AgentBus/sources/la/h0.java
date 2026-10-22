package la;

/* loaded from: classes.dex */
public final class h0 implements ia.p0 {

    /* renamed from: f, reason: collision with root package name */
    public final j0 f5923f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5924g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f5925h;

    /* renamed from: i, reason: collision with root package name */
    public final ia.m f5926i;

    public h0(j0 j0Var, long j2, Object obj, ia.m mVar) {
        this.f5923f = j0Var;
        this.f5924g = j2;
        this.f5925h = obj;
        this.f5926i = mVar;
    }

    @Override // ia.p0
    public final void a() {
        j0 j0Var = this.f5923f;
        synchronized (j0Var) {
            if (this.f5924g < j0Var.l()) {
                return;
            }
            Object[] objArr = j0Var.f5939m;
            q7.k.b(objArr);
            long j2 = this.f5924g;
            if (objArr[((int) j2) & (objArr.length - 1)] != this) {
                return;
            }
            k0.e(objArr, j2, k0.f5944a);
            j0Var.g();
        }
    }
}
