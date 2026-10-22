package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f4456c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ad.z f4457f;

    /* renamed from: g, reason: collision with root package name */
    public int f4458g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ad.z zVar, pb.c cVar) {
        super(cVar);
        this.f4457f = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f4456c = obj;
        this.f4458g |= Integer.MIN_VALUE;
        return this.f4457f.m(false, this);
    }
}
