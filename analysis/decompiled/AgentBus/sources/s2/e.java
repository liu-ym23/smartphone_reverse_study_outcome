package s2;

/* loaded from: classes.dex */
public final class e extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public int f9353f;

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        return new e(1, dVar);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        e eVar = (e) create((g7.d) obj);
        c7.r rVar = c7.r.f1986a;
        eVar.invokeSuspend(rVar);
        return rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f9353f;
        if (i2 == 0) {
            w7.e0.N(obj);
            this.f9353f = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        w7.e0.N(obj);
        return c7.r.f1986a;
    }
}
