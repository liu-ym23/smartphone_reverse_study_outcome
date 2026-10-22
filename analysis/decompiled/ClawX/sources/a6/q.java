package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q extends l1 implements p {

    /* renamed from: e, reason: collision with root package name */
    public final p1 f208e;

    public q(p1 p1Var) {
        this.f208e = p1Var;
    }

    @Override // a6.p
    public final boolean c(Throwable th) {
        return j().E(th);
    }

    @Override // a6.l1
    public final boolean k() {
        return true;
    }

    @Override // a6.l1
    public final void l(Throwable th) {
        this.f208e.x(j());
    }
}
