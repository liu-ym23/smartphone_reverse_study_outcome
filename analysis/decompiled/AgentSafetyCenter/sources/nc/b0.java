package nc;

/* loaded from: classes.dex */
public final class b0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f8823c;

    /* renamed from: f, reason: collision with root package name */
    public int f8824f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g0.f f8825g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8826h;
    public h i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(g0.f fVar, nb.c cVar) {
        super(cVar);
        this.f8825g = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8823c = obj;
        this.f8824f |= Integer.MIN_VALUE;
        return this.f8825g.emit(null, this);
    }
}
