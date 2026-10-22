package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m1 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public o1 f13524c;

    /* renamed from: f, reason: collision with root package name */
    public jb.b f13525f;

    /* renamed from: g, reason: collision with root package name */
    public xb.a f13526g;

    /* renamed from: h, reason: collision with root package name */
    public float f13527h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o1 f13528j;

    /* renamed from: k, reason: collision with root package name */
    public int f13529k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(o1 o1Var, pb.c cVar) {
        super(cVar);
        this.f13528j = o1Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f13529k |= Integer.MIN_VALUE;
        return this.f13528j.a(null, null, this);
    }
}
