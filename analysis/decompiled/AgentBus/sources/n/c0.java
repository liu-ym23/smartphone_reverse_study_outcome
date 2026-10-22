package n;

/* loaded from: classes.dex */
public final class c0 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f6567f;

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        c0 c0Var = new c0(2, dVar);
        c0Var.f6567f = ((Number) obj).floatValue();
        return c0Var;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((c0) create(Float.valueOf(((Number) obj).floatValue()), (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        w7.e0.N(obj);
        return Boolean.valueOf(this.f6567f > 0.0f);
    }
}
