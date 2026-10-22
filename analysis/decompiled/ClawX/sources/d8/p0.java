package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p0 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2110f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f2111g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f2112h;

    public static void o(double d, double d9) {
        if (d < -90.0d || d > 90.0d) {
            throw new IllegalArgumentException("illegal longitude " + d);
        }
        if (d9 < -180.0d || d9 > 180.0d) {
            throw new IllegalArgumentException("illegal latitude " + d9);
        }
    }

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2111g = uVar.c();
        this.f2110f = uVar.c();
        this.f2112h = uVar.c();
        try {
            o(Double.parseDouble(w2.a(this.f2111g, false)), Double.parseDouble(w2.a(this.f2110f, false)));
        } catch (IllegalArgumentException e9) {
            throw new l4(e9.getMessage());
        }
    }

    @Override // d8.w2
    public final String k() {
        return w2.a(this.f2111g, true) + " " + w2.a(this.f2110f, true) + " " + w2.a(this.f2112h, true);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.i(this.f2111g);
        jVar.i(this.f2110f);
        jVar.i(this.f2112h);
    }
}
