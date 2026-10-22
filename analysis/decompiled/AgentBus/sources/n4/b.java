package n4;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public q6.b f6840f;

    /* renamed from: g, reason: collision with root package name */
    public String f6841g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6842h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q6.b f6843i;

    /* renamed from: j, reason: collision with root package name */
    public int f6844j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(q6.b bVar, i7.c cVar) {
        super(cVar);
        this.f6843i = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6842h = obj;
        this.f6844j |= Integer.MIN_VALUE;
        return this.f6843i.E0(null, this);
    }
}
