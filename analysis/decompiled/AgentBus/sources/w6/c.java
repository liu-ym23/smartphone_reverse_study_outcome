package w6;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10783f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f10784g;

    /* renamed from: h, reason: collision with root package name */
    public int f10785h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, i7.c cVar) {
        super(cVar);
        this.f10784g = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10783f = obj;
        this.f10785h |= Integer.MIN_VALUE;
        return this.f10784g.a(null, null, null, this);
    }
}
