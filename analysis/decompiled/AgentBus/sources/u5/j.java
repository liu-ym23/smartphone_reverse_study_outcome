package u5;

import ia.b0;
import w7.e0;

/* loaded from: classes.dex */
public final class j extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f10137f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f10138g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c5.b f10139h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(t tVar, c5.b bVar, g7.d dVar) {
        super(2, dVar);
        this.f10138g = tVar;
        this.f10139h = bVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new j(this.f10138g, this.f10139h, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f10137f;
        c7.r rVar = c7.r.f1986a;
        if (i2 == 0) {
            e0.N(obj);
            this.f10137f = 1;
            Object objEmit = this.f10138g.f10185h.emit(this.f10139h, this);
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
