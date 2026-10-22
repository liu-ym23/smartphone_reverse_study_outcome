package y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h<T> extends k {

    /* renamed from: c, reason: collision with root package name */
    public s.b<? extends T> f13945c;

    /* renamed from: d, reason: collision with root package name */
    public int f13946d;

    /* renamed from: e, reason: collision with root package name */
    public int f13947e;

    public h(long j10, s.b<? extends T> bVar) {
        super(j10);
        this.f13945c = bVar;
    }

    @Override // y.k
    public final void a(k kVar) {
        synchronized (e.f13939a) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.StateListStateRecord>");
            this.f13945c = ((h) kVar).f13945c;
            this.f13946d = ((h) kVar).f13946d;
            this.f13947e = ((h) kVar).f13947e;
            lb.n nVar = lb.n.f10413a;
        }
    }

    @Override // y.k
    public final k b(long j10) {
        return new h(j10, this.f13945c);
    }
}
