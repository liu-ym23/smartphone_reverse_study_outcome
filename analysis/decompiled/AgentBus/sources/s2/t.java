package s2;

/* loaded from: classes.dex */
public final class t extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public z f9426f;

    /* renamed from: g, reason: collision with root package name */
    public h0 f9427g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9428h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f9429i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f9430j;

    /* renamed from: k, reason: collision with root package name */
    public int f9431k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(z zVar, g7.d dVar) {
        super(dVar);
        this.f9430j = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9429i = obj;
        this.f9431k |= Integer.MIN_VALUE;
        return z.b(this.f9430j, false, this);
    }
}
