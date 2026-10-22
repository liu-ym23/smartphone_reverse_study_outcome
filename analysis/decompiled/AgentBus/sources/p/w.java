package p;

/* loaded from: classes.dex */
public final class w extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public s0 f8196f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8197g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0 f8198h;

    /* renamed from: i, reason: collision with root package name */
    public int f8199i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(s0 s0Var, i7.c cVar) {
        super(cVar);
        this.f8198h = s0Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8197g = obj;
        this.f8199i |= Integer.MIN_VALUE;
        return s0.o0(this.f8198h, this);
    }
}
