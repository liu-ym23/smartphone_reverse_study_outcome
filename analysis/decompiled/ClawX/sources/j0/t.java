package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public c0 f3433a;

    /* renamed from: b, reason: collision with root package name */
    public int f3434b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3435c;
    public final /* synthetic */ c0 d;

    /* renamed from: e, reason: collision with root package name */
    public int f3436e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(c0 c0Var, h5.c cVar) {
        super(cVar);
        this.d = c0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3435c = obj;
        this.f3436e |= Integer.MIN_VALUE;
        return this.d.h(this);
    }
}
