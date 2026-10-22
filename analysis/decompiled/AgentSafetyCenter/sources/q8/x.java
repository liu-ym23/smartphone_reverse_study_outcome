package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10194c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ y f10195f;

    /* renamed from: g, reason: collision with root package name */
    public int f10196g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(y yVar, pb.c cVar) {
        super(cVar);
        this.f10195f = yVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f10194c = obj;
        this.f10196g |= Integer.MIN_VALUE;
        return this.f10195f.a(this);
    }
}
