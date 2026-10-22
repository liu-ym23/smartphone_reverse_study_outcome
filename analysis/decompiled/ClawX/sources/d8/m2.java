package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m2 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2088f;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2088f = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        if (this.f2088f != null) {
            if (p2.a()) {
                sb.append("(\n");
                sb.append(a.a.H(this.f2088f, true));
            } else {
                sb.append(a.a.f0(this.f2088f));
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.h(this.f2088f);
    }
}
