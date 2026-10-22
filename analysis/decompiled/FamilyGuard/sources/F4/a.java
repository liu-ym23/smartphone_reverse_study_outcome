package F4;

import C4.A;
import C4.D;
import C4.F;
import C4.x;

/* loaded from: classes.dex */
public final class a implements x {

    /* renamed from: a, reason: collision with root package name */
    public final A f1755a;

    public a(A a6) {
        this.f1755a = a6;
    }

    @Override // C4.x
    public F a(x.a aVar) {
        G4.g gVar = (G4.g) aVar;
        D dA = gVar.a();
        k kVarH = gVar.h();
        return gVar.g(dA, kVarH, kVarH.k(aVar, !dA.f().equals("GET")));
    }
}
