package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u3 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f12011c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ v3 f12012f;

    /* renamed from: g, reason: collision with root package name */
    public int f12013g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u3(v3 v3Var, pb.c cVar) {
        super(cVar);
        this.f12012f = v3Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f12011c = obj;
        this.f12013g |= Integer.MIN_VALUE;
        return this.f12012f.a(this);
    }
}
