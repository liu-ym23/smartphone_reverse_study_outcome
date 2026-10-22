package g9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f4430c;

    /* renamed from: f, reason: collision with root package name */
    public Object f4431f;

    /* renamed from: g, reason: collision with root package name */
    public sc.c f4432g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4433h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ad.z f4434j;

    /* renamed from: k, reason: collision with root package name */
    public int f4435k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ad.z zVar, pb.c cVar) {
        super(cVar);
        this.f4434j = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.i = obj;
        this.f4435k |= Integer.MIN_VALUE;
        Object objJ = this.f4434j.j(this);
        return objJ == ob.a.f9351c ? objJ : jb.i.a(objJ);
    }
}
