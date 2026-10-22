package m4;

/* loaded from: classes.dex */
public final class k extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public x f6234f;

    /* renamed from: g, reason: collision with root package name */
    public a6.y f6235g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6236h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6237i;

    /* renamed from: j, reason: collision with root package name */
    public int f6238j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(x xVar, i7.c cVar) {
        super(cVar);
        this.f6237i = xVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f6236h = obj;
        this.f6238j |= Integer.MIN_VALUE;
        return this.f6237i.h(null, null, this);
    }
}
