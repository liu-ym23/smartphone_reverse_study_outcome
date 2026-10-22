package u5;

import ia.b0;
import ia.d0;
import w7.e0;

/* loaded from: classes.dex */
public final class n extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f10149f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f10150g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(t tVar, g7.d dVar) {
        super(2, dVar);
        this.f10150g = tVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new n(this.f10150g, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((n) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f10149f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
            return obj;
        }
        e0.N(obj);
        this.f10149f = 1;
        Object objD = d0.D(25000L, new r(this.f10150g, null, 1), this);
        return objD == aVar ? aVar : objD;
    }
}
