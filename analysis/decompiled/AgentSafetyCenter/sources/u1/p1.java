package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public u0.t f13895a;

    /* renamed from: b, reason: collision with root package name */
    public e f13896b;

    /* renamed from: c, reason: collision with root package name */
    public e f13897c;

    /* renamed from: d, reason: collision with root package name */
    public e f13898d;

    /* renamed from: e, reason: collision with root package name */
    public e f13899e;

    /* renamed from: f, reason: collision with root package name */
    public e f13900f;

    /* renamed from: g, reason: collision with root package name */
    public e f13901g;

    /* renamed from: h, reason: collision with root package name */
    public e f13902h;

    public final void a(o1 o1Var, xb.l lVar, xb.a aVar) {
        u0.s sVarB;
        u0.t tVar = this.f13895a;
        synchronized (tVar.f13706g) {
            sVarB = tVar.b(lVar);
        }
        u0.s sVar = tVar.i;
        long j10 = tVar.f13708j;
        if (j10 != -1 && j10 != s0.h.b()) {
            k0.q1.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j10 + "), currentThread={id=" + s0.h.b() + ", name=" + Thread.currentThread().getName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
        }
        try {
            tVar.i = sVarB;
            tVar.f13708j = s0.h.b();
            sVarB.a(o1Var, tVar.f13704e, aVar);
        } finally {
            tVar.i = sVar;
            tVar.f13708j = j10;
        }
    }
}
