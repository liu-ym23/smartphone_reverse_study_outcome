package i9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public b f5919c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5920f;

    /* renamed from: g, reason: collision with root package name */
    public long f5921g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f5922h;
    public final /* synthetic */ b0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f5923j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(b0 b0Var, pb.c cVar) {
        super(cVar);
        this.i = b0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f5922h = obj;
        this.f5923j |= Integer.MIN_VALUE;
        return this.i.o(null, this);
    }
}
