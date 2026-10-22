package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends w0.l implements u1.k, u1.i1 {

    /* renamed from: s, reason: collision with root package name */
    public y.z f12956s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12957t;

    @Override // u1.i1
    public final void c0() {
        yb.u uVar = new yb.u();
        u1.f.r(this, new a1.b(10, uVar, this));
        y.z zVar = (y.z) uVar.f16098c;
        if (this.f12957t) {
            y.z zVar2 = this.f12956s;
            if (zVar2 != null) {
                zVar2.b();
            }
            if (zVar != null) {
                zVar.a();
            } else {
                zVar = null;
            }
            this.f12956s = zVar;
        }
    }

    @Override // w0.l
    public final boolean q0() {
        return false;
    }

    @Override // w0.l
    public final void v0() {
        y.z zVar = this.f12956s;
        if (zVar != null) {
            zVar.b();
        }
        this.f12956s = null;
    }
}
