package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends w0.l implements u1.v {

    /* renamed from: s, reason: collision with root package name */
    public xb.l f11262s;

    /* renamed from: t, reason: collision with root package name */
    public long f11263t;

    @Override // u1.v
    public final void m(long j10) {
        if (o2.k.b(this.f11263t, j10)) {
            return;
        }
        this.f11262s.invoke(o2.k.a(j10));
        this.f11263t = j10;
    }

    @Override // w0.l
    public final boolean q0() {
        return true;
    }
}
