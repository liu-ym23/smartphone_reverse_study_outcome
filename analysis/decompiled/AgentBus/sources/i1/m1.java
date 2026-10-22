package i1;

/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public final l0.t f4536a;

    /* renamed from: b, reason: collision with root package name */
    public final d f4537b = d.f4429q;

    /* renamed from: c, reason: collision with root package name */
    public final d f4538c = d.f4430r;

    /* renamed from: d, reason: collision with root package name */
    public final d f4539d = d.f4431s;

    /* renamed from: e, reason: collision with root package name */
    public final d f4540e = d.f4425m;

    /* renamed from: f, reason: collision with root package name */
    public final d f4541f = d.f4426n;

    /* renamed from: g, reason: collision with root package name */
    public final d f4542g = d.f4427o;

    /* renamed from: h, reason: collision with root package name */
    public final d f4543h = d.f4428p;

    public m1(j1.u uVar) {
        this.f4536a = new l0.t(uVar);
    }

    public final void a(l1 l1Var, p7.k kVar, p7.a aVar) {
        Object obj;
        l0.s sVar;
        l0.t tVar = this.f4536a;
        synchronized (tVar.f5805g) {
            d0.e eVar = tVar.f5804f;
            Object[] objArr = eVar.f2749f;
            int i2 = eVar.f2751h;
            int i10 = 0;
            while (true) {
                if (i10 >= i2) {
                    obj = null;
                    break;
                }
                obj = objArr[i10];
                if (((l0.s) obj).f5787a == kVar) {
                    break;
                } else {
                    i10++;
                }
            }
            sVar = (l0.s) obj;
            if (sVar == null) {
                q7.k.c(kVar, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
                q7.z.c(1, kVar);
                sVar = new l0.s(kVar);
                eVar.b(sVar);
            }
        }
        l0.s sVar2 = tVar.f5807i;
        long j2 = tVar.f5808j;
        if (j2 != -1 && j2 != j0.i.b()) {
            b0.u1.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j2 + "), currentThread={id=" + j0.i.b() + ", name=" + Thread.currentThread().getName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
        }
        try {
            tVar.f5807i = sVar;
            tVar.f5808j = j0.i.b();
            sVar.a(l1Var, tVar.f5803e, aVar);
        } finally {
            tVar.f5807i = sVar2;
            tVar.f5808j = j2;
        }
    }
}
