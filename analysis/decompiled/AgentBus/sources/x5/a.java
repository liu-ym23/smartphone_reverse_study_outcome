package x5;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public long f11215f;

    /* renamed from: g, reason: collision with root package name */
    public Object f11216g;

    /* renamed from: h, reason: collision with root package name */
    public ra.d f11217h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f11218i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b f11219j;

    /* renamed from: k, reason: collision with root package name */
    public int f11220k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, i7.c cVar) {
        super(cVar);
        this.f11219j = bVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11218i = obj;
        this.f11220k |= Integer.MIN_VALUE;
        return this.f11219j.a(0L, this);
    }
}
