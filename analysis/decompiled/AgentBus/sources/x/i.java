package x;

import ia.b0;
import ia.d0;
import w7.e0;

/* loaded from: classes.dex */
public final class i extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11017f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f11018g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f11019h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(j jVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f11017f = i2;
        this.f11019h = jVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f11017f) {
            case 0:
                i iVar = new i(this.f11019h, dVar, 0);
                iVar.f11018g = obj;
                return iVar;
            default:
                i iVar2 = new i(this.f11019h, dVar, 1);
                iVar2.f11018g = obj;
                return iVar2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f11017f) {
        }
        return ((i) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f11017f;
        j jVar = this.f11019h;
        g7.d dVar = null;
        int i10 = 3;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                b0 b0Var = (b0) this.f11018g;
                d0.s(b0Var, null, null, new h(jVar, dVar, 0), 3);
                d0.s(b0Var, null, null, new h(jVar, dVar, 1), 3);
                return d0.s(b0Var, null, null, new h(jVar, dVar, 2), 3);
            default:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                return d0.s((b0) this.f11018g, null, null, new h(jVar, dVar, i10), 3);
        }
    }
}
