package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public long f10180c;

    /* renamed from: f, reason: collision with root package name */
    public long f10181f;

    /* renamed from: g, reason: collision with root package name */
    public int f10182g;

    /* renamed from: h, reason: collision with root package name */
    public int f10183h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t f10184j;

    /* renamed from: k, reason: collision with root package name */
    public int f10185k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(t tVar, pb.c cVar) {
        super(cVar);
        this.f10184j = tVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f10185k |= Integer.MIN_VALUE;
        return this.f10184j.k(0L, null, 0, 0, 0L, this);
    }
}
