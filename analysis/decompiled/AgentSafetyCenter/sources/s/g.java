package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final n6.a f11005a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11006b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11007c;

    /* renamed from: d, reason: collision with root package name */
    public final yb.l f11008d;

    /* renamed from: e, reason: collision with root package name */
    public final k0.k1 f11009e;

    /* renamed from: f, reason: collision with root package name */
    public n f11010f;

    /* renamed from: g, reason: collision with root package name */
    public long f11011g;

    /* renamed from: h, reason: collision with root package name */
    public long f11012h = Long.MIN_VALUE;
    public final k0.k1 i = k0.z.v(Boolean.TRUE);

    /* JADX WARN: Multi-variable type inference failed */
    public g(Object obj, n6.a aVar, n nVar, long j10, Object obj2, long j11, xb.a aVar2) {
        this.f11005a = aVar;
        this.f11006b = obj2;
        this.f11007c = j11;
        this.f11008d = (yb.l) aVar2;
        this.f11009e = k0.z.v(obj);
        this.f11010f = d.h(nVar);
        this.f11011g = j10;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [xb.a, yb.l] */
    public final void a() {
        this.i.setValue(Boolean.FALSE);
        this.f11008d.invoke();
    }
}
