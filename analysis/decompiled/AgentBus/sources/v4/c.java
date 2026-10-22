package v4;

import o4.h1;
import o4.t1;

/* loaded from: classes.dex */
public final class c implements la.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10393f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t1 f10394g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f10395h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k f10396i;

    public c(Object obj, k kVar, t1 t1Var) {
        this.f10395h = obj;
        this.f10396i = kVar;
        this.f10394g = t1Var;
    }

    @Override // la.k
    public final Object emit(Object obj, g7.d dVar) {
        switch (this.f10393f) {
            case 0:
                k kVar = this.f10396i;
                t1 t1Var = this.f10394g;
                d5.b.d(this.f10395h, kVar, t1Var, (h1) obj);
                break;
            default:
                t1 t1Var2 = this.f10394g;
                d5.b.d(this.f10395h, this.f10396i, t1Var2, (h1) t1Var2.f7596x.f7345b.getValue());
                break;
        }
        return c7.r.f1986a;
    }

    public c(t1 t1Var, Object obj, k kVar) {
        this.f10394g = t1Var;
        this.f10395h = obj;
        this.f10396i = kVar;
    }
}
