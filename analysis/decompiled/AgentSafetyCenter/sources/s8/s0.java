package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f11941c;

    /* renamed from: f, reason: collision with root package name */
    public int f11942f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11943g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11944h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(k0.c1 c1Var, k0.c1 c1Var2, nb.c cVar) {
        super(2, cVar);
        this.f11943g = c1Var;
        this.f11944h = c1Var2;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new s0(this.f11943g, this.f11944h, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((s0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i;
        ob.a aVar = ob.a.f9351c;
        int i3 = this.f11942f;
        jb.v vVar = jb.v.f6774a;
        k0.c1 c1Var = this.f11943g;
        if (i3 == 0) {
            id.c.I(obj);
            float f5 = w0.f12043g;
            Integer num = (Integer) c1Var.getValue();
            if (num != null) {
                int iIntValue = num.intValue();
                this.f11941c = iIntValue;
                this.f11942f = 1;
                if (kc.w.g(3000L, this) == aVar) {
                    return aVar;
                }
                i = iIntValue;
            }
            return vVar;
        }
        if (i3 != 1) {
            od.f.e("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = this.f11941c;
        id.c.I(obj);
        float f10 = w0.f12043g;
        Integer num2 = (Integer) c1Var.getValue();
        if (num2 != null && num2.intValue() == i) {
            c1Var.setValue(null);
            this.f11944h.setValue(null);
        }
        return vVar;
    }
}
