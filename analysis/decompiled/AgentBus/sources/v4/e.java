package v4;

import ia.b0;
import k5.s;
import o4.t1;
import w7.e0;

/* loaded from: classes.dex */
public final class e extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f10403f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f10404g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(k kVar, boolean z4, g7.d dVar) {
        super(2, dVar);
        this.f10403f = kVar;
        this.f10404g = z4;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new e(this.f10403f, this.f10404g, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        e eVar = (e) create((b0) obj, (g7.d) obj2);
        c7.r rVar = c7.r.f1986a;
        eVar.invokeSuspend(rVar);
        return rVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        t1 t1Var;
        h7.a aVar = h7.a.f4212f;
        e0.N(obj);
        try {
            t1 t1Var2 = this.f10403f.f10432f0;
            if (t1Var2 != null) {
                t1Var2.k(this.f10404g);
            }
        } catch (Throwable th) {
            s.warn$default(this.f10403f.f10429e, "AgentBusContainer", "screen edge client setScreenInteractive(" + this.f10404g + ") failed: " + th.getMessage(), null, 4, null);
        }
        try {
            y4.m mVar = this.f10403f.f10434g0;
            if (mVar != null && (t1Var = mVar.f11619r) != null) {
                t1Var.k(this.f10404g);
            }
        } catch (Throwable th2) {
            s.warn$default(this.f10403f.f10429e, "AgentBusContainer", "screen cloud client setScreenInteractive(" + this.f10404g + ") failed: " + th2.getMessage(), null, 4, null);
        }
        return c7.r.f1986a;
    }
}
