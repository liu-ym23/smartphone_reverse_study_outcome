package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15986c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f15987f;

    /* renamed from: g, reason: collision with root package name */
    public int f15988g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(u uVar, pb.c cVar) {
        super(cVar);
        this.f15987f = uVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15986c = obj;
        this.f15988g |= Integer.MIN_VALUE;
        return this.f15987f.a(false, this);
    }
}
