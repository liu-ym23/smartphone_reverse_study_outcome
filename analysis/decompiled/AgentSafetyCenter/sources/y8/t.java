package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f15994c;

    /* renamed from: f, reason: collision with root package name */
    public Object f15995f;

    /* renamed from: g, reason: collision with root package name */
    public int f15996g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f15997h;
    public final /* synthetic */ u i;

    /* renamed from: j, reason: collision with root package name */
    public int f15998j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, pb.c cVar) {
        super(cVar);
        this.i = uVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15997h = obj;
        this.f15998j |= Integer.MIN_VALUE;
        return this.i.c(false, this);
    }
}
