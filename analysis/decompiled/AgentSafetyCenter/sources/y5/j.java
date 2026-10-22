package y5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15911c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l f15912f;

    /* renamed from: g, reason: collision with root package name */
    public int f15913g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l lVar, pb.c cVar) {
        super(cVar);
        this.f15912f = lVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15911c = obj;
        this.f15913g |= Integer.MIN_VALUE;
        return this.f15912f.b(null, this);
    }
}
