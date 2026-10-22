package y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m<T> extends k {

    /* renamed from: c, reason: collision with root package name */
    public s.c<? extends T> f13955c;

    /* renamed from: d, reason: collision with root package name */
    public int f13956d;

    public m(long j10, s.c<? extends T> cVar) {
        super(j10);
        this.f13955c = cVar;
    }

    @Override // y.k
    public final void a(k kVar) {
        synchronized (f.f13940a) {
            kotlin.jvm.internal.g.d(kVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.StateSetStateRecord>");
            this.f13955c = ((m) kVar).f13955c;
            this.f13956d = ((m) kVar).f13956d;
            lb.n nVar = lb.n.f10413a;
        }
    }

    @Override // y.k
    public final k b(long j10) {
        return new m(j10, this.f13955c);
    }
}
