package la;

/* loaded from: classes.dex */
public final class s extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public g f5995f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f5996g;

    /* renamed from: h, reason: collision with root package name */
    public int f5997h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f5998i;

    /* renamed from: j, reason: collision with root package name */
    public Object f5999j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(g gVar, g7.d dVar) {
        super(dVar);
        this.f5998i = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f5996g = obj;
        this.f5997h |= Integer.MIN_VALUE;
        return this.f5998i.emit(null, this);
    }
}
