package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t0 extends l1 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f214e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f215f;

    public /* synthetic */ t0(int i8, Object obj) {
        this.f214e = i8;
        this.f215f = obj;
    }

    @Override // a6.l1
    public final boolean k() {
        switch (this.f214e) {
        }
        return false;
    }

    @Override // a6.l1
    public final void l(Throwable th) throws o0 {
        switch (this.f214e) {
            case 0:
                ((s0) this.f215f).b();
                break;
            case 1:
                ((p5.l) this.f215f).invoke(th);
                break;
            default:
                m1 m1Var = (m1) this.f215f;
                Object obj = p1.f206a.get(j());
                if (!(obj instanceof v)) {
                    m1Var.resumeWith(i0.y(obj));
                    break;
                } else {
                    m1Var.resumeWith(a.a.o(((v) obj).f222a));
                    break;
                }
        }
    }
}
