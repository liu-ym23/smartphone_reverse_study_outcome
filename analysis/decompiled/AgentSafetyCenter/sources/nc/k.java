package nc;

/* loaded from: classes.dex */
public final class k extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8867c;

    /* renamed from: f, reason: collision with root package name */
    public int f8868f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f8869g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8870h;
    public h i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, nb.c cVar) {
        super(cVar);
        this.f8869g = lVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8867c = obj;
        this.f8868f |= Integer.MIN_VALUE;
        return this.f8869g.collect(null, this);
    }
}
