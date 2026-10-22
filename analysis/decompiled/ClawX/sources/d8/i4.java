package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i4 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2025f;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2025f = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        byte[] bArr = this.f2025f;
        return "\\# " + bArr.length + " " + b8.h.O(bArr);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.h(this.f2025f);
    }
}
