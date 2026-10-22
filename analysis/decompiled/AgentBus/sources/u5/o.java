package u5;

import ia.b0;
import w7.e0;

/* loaded from: classes.dex */
public final class o extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f10151f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f10152g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c5.b f10153h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(t tVar, c5.b bVar, g7.d dVar) {
        super(2, dVar);
        this.f10152g = tVar;
        this.f10153h = bVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new o(this.f10152g, this.f10153h, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((o) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f10151f;
        c7.r rVar = c7.r.f1986a;
        if (i2 == 0) {
            e0.N(obj);
            this.f10151f = 1;
            Object objEmit = this.f10152g.f10185h.emit(this.f10153h, this);
            if (objEmit != aVar) {
                objEmit = rVar;
            }
            if (objEmit == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
        }
        return rVar;
    }
}
