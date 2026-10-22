package l0;

/* loaded from: classes.dex */
public final class u extends x {

    /* renamed from: c, reason: collision with root package name */
    public f0.c f5809c;

    /* renamed from: d, reason: collision with root package name */
    public int f5810d;

    /* renamed from: e, reason: collision with root package name */
    public int f5811e;

    public u(long j2, f0.c cVar) {
        super(j2);
        this.f5809c = cVar;
    }

    @Override // l0.x
    public final void a(x xVar) {
        synchronized (r.f5786a) {
            q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.StateListStateRecord>");
            this.f5809c = ((u) xVar).f5809c;
            this.f5810d = ((u) xVar).f5810d;
            this.f5811e = ((u) xVar).f5811e;
        }
    }

    @Override // l0.x
    public final x b(long j2) {
        return new u(j2, this.f5809c);
    }
}
