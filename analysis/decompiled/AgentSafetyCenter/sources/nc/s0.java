package nc;

import kc.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public t0 f8918c;

    /* renamed from: f, reason: collision with root package name */
    public h f8919f;

    /* renamed from: g, reason: collision with root package name */
    public u0 f8920g;

    /* renamed from: h, reason: collision with root package name */
    public x0 f8921h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f8922j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ t0 f8923k;

    /* renamed from: l, reason: collision with root package name */
    public int f8924l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(t0 t0Var, nb.c cVar) {
        super(cVar);
        this.f8923k = t0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f8922j = obj;
        this.f8924l |= Integer.MIN_VALUE;
        this.f8923k.collect(null, this);
        return ob.a.f9351c;
    }
}
