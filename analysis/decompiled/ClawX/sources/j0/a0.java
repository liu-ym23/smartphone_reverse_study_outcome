package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a0 extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.w f3310a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3311b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f3312c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(c0 c0Var, h5.c cVar) {
        super(cVar);
        this.f3312c = c0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.f3311b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.f3312c.j(null, false, this);
    }
}
