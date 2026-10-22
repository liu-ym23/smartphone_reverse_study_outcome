package x4;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i f11167f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f11168g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f11169h;

    /* renamed from: i, reason: collision with root package name */
    public int f11170i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(i iVar, i7.c cVar) {
        super(cVar);
        this.f11169h = iVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11168g = obj;
        this.f11170i |= Integer.MIN_VALUE;
        return i.b(this.f11169h, this);
    }
}
