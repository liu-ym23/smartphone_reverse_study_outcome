package o4;

/* loaded from: classes.dex */
public final class a3 extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public b3 f7273f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f7274g;

    /* renamed from: h, reason: collision with root package name */
    public String f7275h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f7276i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b3 f7277j;

    /* renamed from: k, reason: collision with root package name */
    public int f7278k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a3(b3 b3Var, g7.d dVar) {
        super(dVar);
        this.f7277j = b3Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f7276i = obj;
        this.f7278k |= Integer.MIN_VALUE;
        return this.f7277j.j(null, this);
    }
}
