package ma;

import ia.b0;
import w7.e0;

/* loaded from: classes.dex */
public final class h extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6486f = 1;

    /* renamed from: g, reason: collision with root package name */
    public int f6487g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6488h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k f6489i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ la.k f6490j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, la.k kVar2, g7.d dVar) {
        super(2, dVar);
        this.f6489i = kVar;
        this.f6490j = kVar2;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f6486f) {
            case 0:
                return new h(this.f6489i, this.f6490j, this.f6488h, dVar);
            default:
                h hVar = new h(this.f6489i, this.f6490j, dVar);
                hVar.f6488h = obj;
                return hVar;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f6486f) {
        }
        return ((h) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [i7.i, p7.o] */
    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6486f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f6487g;
                if (i2 == 0) {
                    e0.N(obj);
                    ?? r10 = this.f6489i.f6501j;
                    Object obj2 = this.f6488h;
                    this.f6487g = 1;
                    if (r10.j(this.f6490j, obj2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f6487g;
                if (i10 == 0) {
                    e0.N(obj);
                    b0 b0Var = (b0) this.f6488h;
                    q7.v vVar = new q7.v();
                    k kVar = this.f6489i;
                    la.j jVar = kVar.f6485i;
                    j jVar2 = new j(vVar, b0Var, kVar, this.f6490j, 0);
                    this.f6487g = 1;
                    if (jVar.x(jVar2, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, la.k kVar2, Object obj, g7.d dVar) {
        super(2, dVar);
        this.f6489i = kVar;
        this.f6490j = kVar2;
        this.f6488h = obj;
    }
}
