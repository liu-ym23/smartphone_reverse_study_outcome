package w6;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10790f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f10791g;

    /* renamed from: h, reason: collision with root package name */
    public int f10792h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, i7.c cVar) {
        super(cVar);
        this.f10791g = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10790f = obj;
        this.f10792h |= Integer.MIN_VALUE;
        return this.f10791g.c(null, null, this);
    }
}
