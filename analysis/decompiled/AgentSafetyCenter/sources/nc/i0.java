package nc;

import kc.x0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public j0 f8851c;

    /* renamed from: f, reason: collision with root package name */
    public h f8852f;

    /* renamed from: g, reason: collision with root package name */
    public l0 f8853g;

    /* renamed from: h, reason: collision with root package name */
    public x0 f8854h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j0 f8855j;

    /* renamed from: k, reason: collision with root package name */
    public int f8856k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(j0 j0Var, nb.c cVar) {
        super(cVar);
        this.f8855j = j0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.i = obj;
        this.f8856k |= Integer.MIN_VALUE;
        j0.i(this.f8855j, null, this);
        return ob.a.f9351c;
    }
}
