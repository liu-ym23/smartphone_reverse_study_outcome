package a5;

/* loaded from: classes.dex */
public final class g extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h f234f;

    /* renamed from: g, reason: collision with root package name */
    public Object f235g;

    /* renamed from: h, reason: collision with root package name */
    public h5.d f236h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f237i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h f238j;

    /* renamed from: k, reason: collision with root package name */
    public int f239k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i7.c cVar) {
        super(cVar);
        this.f238j = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f237i = obj;
        this.f239k |= Integer.MIN_VALUE;
        return h.a(this.f238j, null, this);
    }
}
