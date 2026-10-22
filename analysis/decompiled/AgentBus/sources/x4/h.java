package x4;

/* loaded from: classes.dex */
public final class h extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i f11175f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f11176g;

    /* renamed from: h, reason: collision with root package name */
    public ra.d f11177h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f11178i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f11179j;

    /* renamed from: k, reason: collision with root package name */
    public int f11180k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, i7.c cVar) {
        super(cVar);
        this.f11179j = iVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11178i = obj;
        this.f11180k |= Integer.MIN_VALUE;
        return this.f11179j.i(null, this);
    }
}
