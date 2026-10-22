package zd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends k {

    /* renamed from: d, reason: collision with root package name */
    public final String f16592d;

    /* renamed from: e, reason: collision with root package name */
    public final vd.b f16593e;

    /* renamed from: f, reason: collision with root package name */
    public final String f16594f;

    /* renamed from: g, reason: collision with root package name */
    public final h f16595g;

    public l(String str, String str2, h hVar, String str3, yd.a aVar, yd.a aVar2, vd.b bVar) {
        super(str, aVar, aVar2);
        this.f16592d = str2;
        this.f16595g = hVar;
        if (str3 == null) {
            g5.f.g("Value must be provided.");
            throw null;
        }
        this.f16594f = str3;
        if (bVar != null) {
            this.f16593e = bVar;
        } else {
            g5.f.g("Style must be provided.");
            throw null;
        }
    }

    @Override // zd.k, zd.g
    public final String a() {
        return super.a() + ", tag=" + this.f16592d + ", style=" + this.f16593e + "," + this.f16595g + ", value=" + this.f16594f;
    }

    @Override // zd.g
    public final int b() {
        return 7;
    }
}
