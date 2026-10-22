package s2;

/* loaded from: classes.dex */
public final class i0 extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public int f9384f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ u2.c f9385g;

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f9384f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            w7.e0.N(obj);
            return obj;
        }
        w7.e0.N(obj);
        u2.c cVar = this.f9385g;
        this.f9384f = 1;
        cVar.getClass();
        Object objA = u2.c.a(cVar, this);
        return objA == aVar ? aVar : objA;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        ((Boolean) obj2).getClass();
        i0 i0Var = new i0(3, (g7.d) obj3);
        i0Var.f9385g = (u2.c) obj;
        return i0Var.invokeSuspend(c7.r.f1986a);
    }
}
