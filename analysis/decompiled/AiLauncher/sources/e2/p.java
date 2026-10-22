package e2;

/* loaded from: classes2.dex */
public final class p<T> implements b2.e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final m f32278a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32279b;

    /* renamed from: c, reason: collision with root package name */
    public final b2.b f32280c;

    /* renamed from: d, reason: collision with root package name */
    public final b2.d<T, byte[]> f32281d;

    /* renamed from: e, reason: collision with root package name */
    public final q f32282e;

    public p(m mVar, String str, b2.b bVar, b2.d<T, byte[]> dVar, q qVar) {
        this.f32278a = mVar;
        this.f32279b = str;
        this.f32280c = bVar;
        this.f32281d = dVar;
        this.f32282e = qVar;
    }

    public static /* synthetic */ void b(Exception exc) {
    }

    @Override // b2.e
    public void a(b2.c<T> cVar) {
        c(cVar, o.b());
    }

    public void c(b2.c<T> cVar, b2.g gVar) {
        this.f32282e.a(l.a().e(this.f32278a).c(cVar).f(this.f32279b).d(this.f32281d).b(this.f32280c).a(), gVar);
    }
}
