package la;

/* loaded from: classes.dex */
public final class w extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public g f6018f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6019g;

    /* renamed from: h, reason: collision with root package name */
    public int f6020h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f6021i;

    /* renamed from: j, reason: collision with root package name */
    public Object f6022j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(g gVar, g7.d dVar) {
        super(dVar);
        this.f6021i = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6019g = obj;
        this.f6020h |= Integer.MIN_VALUE;
        return this.f6021i.emit(null, this);
    }
}
