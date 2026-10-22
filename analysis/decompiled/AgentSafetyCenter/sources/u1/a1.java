package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public w0.l f13725a;

    /* renamed from: b, reason: collision with root package name */
    public int f13726b;

    /* renamed from: c, reason: collision with root package name */
    public m0.e f13727c;

    /* renamed from: d, reason: collision with root package name */
    public m0.e f13728d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13729e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f13730f;

    public final boolean a(int i, int i3) {
        m0.e eVar = this.f13727c;
        int i10 = this.f13726b;
        w0.k kVar = (w0.k) eVar.f8158c[i + i10];
        w0.k kVar2 = (w0.k) this.f13728d.f8158c[i10 + i3];
        return yb.k.a(kVar, kVar2) || kVar.getClass() == kVar2.getClass();
    }
}
