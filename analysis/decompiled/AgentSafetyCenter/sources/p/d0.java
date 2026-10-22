package p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public gc.j f9538f;

    /* renamed from: g, reason: collision with root package name */
    public e0 f9539g;

    /* renamed from: h, reason: collision with root package name */
    public long[] f9540h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f9541j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f9542k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e0 f9543l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ gc.j f9544m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(e0 e0Var, gc.j jVar, nb.c cVar) {
        super(cVar);
        this.f9543l = e0Var;
        this.f9544m = jVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        d0 d0Var = new d0(this.f9543l, this.f9544m, cVar);
        d0Var.f9542k = obj;
        return d0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d0) create((gc.l) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        gc.l lVar;
        e0 e0Var;
        long[] jArr;
        int i;
        gc.j jVar;
        ob.a aVar = ob.a.f9351c;
        int i3 = this.f9541j;
        if (i3 == 0) {
            id.c.I(obj);
            lVar = (gc.l) this.f9542k;
            e0Var = this.f9543l;
            c0 c0Var = e0Var.f9548f;
            jArr = c0Var.f9531c;
            i = c0Var.f9533e;
            jVar = this.f9544m;
        } else {
            if (i3 != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.i;
            jArr = this.f9540h;
            e0Var = this.f9539g;
            jVar = this.f9538f;
            lVar = (gc.l) this.f9542k;
            id.c.I(obj);
        }
        if (i == Integer.MAX_VALUE) {
            return jb.v.f6774a;
        }
        int i10 = (int) ((jArr[i] >> 31) & 2147483647L);
        jVar.f4697f = i;
        Object obj2 = e0Var.f9548f.f9530b[i];
        this.f9542k = lVar;
        this.f9538f = jVar;
        this.f9539g = e0Var;
        this.f9540h = jArr;
        this.i = i10;
        this.f9541j = 1;
        lVar.b(obj2, this);
        return aVar;
    }
}
