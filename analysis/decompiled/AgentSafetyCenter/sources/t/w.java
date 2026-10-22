package t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends w0.l implements u1.n {

    /* renamed from: s, reason: collision with root package name */
    public v.k f13073s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13074t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13075u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13076v;

    @Override // u1.n
    public final void b(u1.i0 i0Var) {
        i0Var.b();
        f1.b bVar = i0Var.f13838c;
        if (this.f13074t) {
            f1.d.k0(i0Var, d1.p.c(0.3f, d1.p.f3019b), bVar.e(), 122);
        } else if (this.f13075u || this.f13076v) {
            f1.d.k0(i0Var, d1.p.c(0.1f, d1.p.f3019b), bVar.e(), 122);
        }
    }

    @Override // w0.l
    public final void t0() {
        kc.w.u(p0(), null, null, new androidx.room.e(this, null, 11), 3);
    }
}
