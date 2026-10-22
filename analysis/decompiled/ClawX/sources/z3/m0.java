package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6477a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f6478b;

    /* renamed from: c, reason: collision with root package name */
    public int f6479c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(n0 n0Var, h5.c cVar) {
        super(cVar);
        this.f6478b = n0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f6477a = obj;
        this.f6479c |= Integer.MIN_VALUE;
        return this.f6478b.a(null, this);
    }
}
