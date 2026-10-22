package w9;

import v9.k0;
import v9.l0;
import v9.v;
import v9.v0;

/* loaded from: classes.dex */
public final class b extends k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f10928a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f10929b;

    public b(c cVar, v0 v0Var) {
        this.f10928a = cVar;
        this.f10929b = v0Var;
    }

    @Override // v9.k0
    public final y9.j a(l0 l0Var, y9.h hVar) {
        q7.k.e(l0Var, "state");
        q7.k.e(hVar, "type");
        c cVar = this.f10928a;
        y9.j jVarE = cVar.e(this.f10929b.g(1, (v) cVar.P(hVar)));
        q7.k.b(jVarE);
        return jVarE;
    }
}
