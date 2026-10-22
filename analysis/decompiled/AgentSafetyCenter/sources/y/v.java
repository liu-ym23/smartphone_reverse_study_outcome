package y;

import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15828c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f15829f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f15830g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f15831h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f15832j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Object obj, int i, b0 b0Var, s0.c cVar, int i3) {
        super(2);
        this.f15829f = obj;
        this.f15830g = i;
        this.i = b0Var;
        this.f15832j = cVar;
        this.f15831h = i3;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f15828c) {
            case 0:
                ((Number) obj2).intValue();
                x.h hVar = (x.h) this.i;
                t.n.c(hVar, this.f15829f, this.f15830g, this.f15832j, (k0.s) obj, k0.z.D(this.f15831h | 1));
                break;
            default:
                ((Number) obj2).intValue();
                b0 b0Var = (b0) this.i;
                s0.c cVar = (s0.c) this.f15832j;
                c1.a(this.f15829f, this.f15830g, b0Var, cVar, (k0.s) obj, k0.z.D(this.f15831h | 1));
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x.h hVar, Object obj, int i, Object obj2, int i3) {
        super(2);
        this.i = hVar;
        this.f15829f = obj;
        this.f15830g = i;
        this.f15832j = obj2;
        this.f15831h = i3;
    }
}
