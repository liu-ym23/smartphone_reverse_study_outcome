package ia;

/* loaded from: classes.dex */
public final class q0 extends k1 {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4995j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f4996k;

    public /* synthetic */ q0(int i2, Object obj) {
        this.f4995j = i2;
        this.f4996k = obj;
    }

    @Override // ia.k1
    public final boolean k() {
        switch (this.f4995j) {
        }
        return false;
    }

    @Override // ia.k1
    public final void l(Throwable th) {
        switch (this.f4995j) {
            case 0:
                ((p0) this.f4996k).a();
                break;
            case 1:
                ((p7.k) this.f4996k).invoke(th);
                break;
            default:
                l1 l1Var = (l1) this.f4996k;
                Object obj = o1.f4991f.get(j());
                if (!(obj instanceof v)) {
                    l1Var.resumeWith(d0.z(obj));
                    break;
                } else {
                    l1Var.resumeWith(w7.e0.n(((v) obj).f5011a));
                    break;
                }
        }
    }
}
