package o4;

/* loaded from: classes.dex */
public final class x0 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f1 f7679f;

    /* renamed from: g, reason: collision with root package name */
    public f f7680g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7681h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f1 f7682i;

    /* renamed from: j, reason: collision with root package name */
    public int f7683j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(f1 f1Var, i7.c cVar) {
        super(cVar);
        this.f7682i = f1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7681h = obj;
        this.f7683j |= Integer.MIN_VALUE;
        return this.f7682i.j(this);
    }
}
