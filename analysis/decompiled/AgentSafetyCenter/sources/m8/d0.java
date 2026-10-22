package m8;

import s8.d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public k8.a f8327c;

    /* renamed from: f, reason: collision with root package name */
    public d1 f8328f;

    /* renamed from: g, reason: collision with root package name */
    public s8.t f8329g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8330h;
    public final /* synthetic */ k0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f8331j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.i = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8330h = obj;
        this.f8331j |= Integer.MIN_VALUE;
        return this.i.L(null, this);
    }
}
