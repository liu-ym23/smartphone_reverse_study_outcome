package u5;

import ia.b0;
import ia.d0;
import w7.e0;

/* loaded from: classes.dex */
public final class q extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f10158f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s f10159g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c5.b f10160h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(s sVar, c5.b bVar, g7.d dVar) {
        super(2, dVar);
        this.f10159g = sVar;
        this.f10160h = bVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new q(this.f10159g, this.f10160h, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((q) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f10158f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
            return obj;
        }
        e0.N(obj);
        p pVar = new p(this.f10159g, this.f10160h, null);
        this.f10158f = 1;
        Object objC = d0.C(35000L, pVar, this);
        return objC == aVar ? aVar : objC;
    }
}
