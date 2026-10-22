package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s1 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public x1 f2162f;

    /* renamed from: g, reason: collision with root package name */
    public g4 f2163g;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2162f = new x1(uVar);
        this.f2163g = new g4(uVar);
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2162f);
        if (!this.f2163g.f2008a.isEmpty()) {
            sb.append(' ');
            sb.append(this.f2163g.toString());
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        this.f2162f.i(jVar, null);
        this.f2163g.b(jVar);
    }
}
