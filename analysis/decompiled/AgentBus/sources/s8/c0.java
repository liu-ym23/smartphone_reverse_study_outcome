package s8;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class c0 extends ea.k {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f8.e f9531b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Set f9532c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q7.m f9533d;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(f8.e eVar, Set set, p7.k kVar) {
        this.f9531b = eVar;
        this.f9532c = set;
        this.f9533d = (q7.m) kVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [p7.k, q7.m] */
    @Override // ea.k
    public final boolean c(Object obj) {
        f8.e eVar = (f8.e) obj;
        q7.k.e(eVar, "current");
        if (eVar == this.f9531b) {
            return true;
        }
        o9.n nVarL0 = eVar.l0();
        q7.k.d(nVarL0, "current.staticScope");
        if (!(nVarL0 instanceof e0)) {
            return true;
        }
        this.f9532c.addAll((Collection) this.f9533d.invoke(nVarL0));
        return false;
    }

    @Override // ea.k
    public final /* bridge */ /* synthetic */ Object i() {
        return c7.r.f1986a;
    }
}
