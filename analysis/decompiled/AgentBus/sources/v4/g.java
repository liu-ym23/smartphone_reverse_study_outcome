package v4;

import ia.b0;
import k5.s;
import o4.t1;
import w7.e0;

/* loaded from: classes.dex */
public final class g extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f10407f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f10408g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f10409h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f10410i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(boolean z4, boolean z10, k kVar, String str, g7.d dVar) {
        super(2, dVar);
        this.f10407f = z4;
        this.f10408g = z10;
        this.f10409h = kVar;
        this.f10410i = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new g(this.f10407f, this.f10408g, this.f10409h, this.f10410i, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        g gVar = (g) create((b0) obj, (g7.d) obj2);
        c7.r rVar = c7.r.f1986a;
        gVar.invokeSuspend(rVar);
        return rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        t1 t1Var;
        y4.m mVar;
        t1 t1Var2;
        k kVar = this.f10409h;
        h7.a aVar = h7.a.f4212f;
        e0.N(obj);
        try {
            if (this.f10407f && !this.f10408g && (mVar = kVar.f10434g0) != null && (t1Var2 = mVar.f11619r) != null) {
                t1Var2.n(false);
            }
            y4.m mVar2 = kVar.f10434g0;
            if (mVar2 != null && (t1Var = mVar2.f11619r) != null) {
                t1Var.f7596x.l();
                t1Var.f7597y.l();
            }
            s.warn$default(kVar.f10429e, "AgentBusContainer", "Cloud bridge reconnect triggered: ".concat(this.f10410i), null, 4, null);
        } catch (Exception e10) {
            s.warn$default(kVar.f10429e, "AgentBusContainer", a1.a.w("Failed to reconnect cloud bridge: ", e10.getMessage()), null, 4, null);
        }
        return c7.r.f1986a;
    }
}
