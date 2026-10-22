package s4;

import x4.C1290B;
import x4.C1298J;

/* loaded from: classes.dex */
public final class J0<T> extends C1290B<T> {

    /* renamed from: e, reason: collision with root package name */
    private final ThreadLocal<V3.m<Z3.i, Object>> f20306e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public J0(Z3.i iVar, Z3.e<? super T> eVar) {
        K0 k02 = K0.f20314a;
        super(iVar.a(k02) == null ? iVar.C(k02) : iVar, eVar);
        this.f20306e = new ThreadLocal<>();
        if (eVar.getContext().a(Z3.f.f6654N) instanceof AbstractC1056E) {
            return;
        }
        Object objC = C1298J.c(iVar, null);
        C1298J.a(iVar, objC);
        O0(iVar, objC);
    }

    @Override // x4.C1290B, s4.AbstractC1060a
    protected void J0(Object obj) {
        if (this.threadLocalIsSet) {
            V3.m<Z3.i, Object> mVar = this.f20306e.get();
            if (mVar != null) {
                C1298J.a(mVar.a(), mVar.b());
            }
            this.f20306e.remove();
        }
        Object objA = C1053B.a(obj, this.f23827d);
        Z3.e<T> eVar = this.f23827d;
        Z3.i context = eVar.getContext();
        Object objC = C1298J.c(context, null);
        J0<?> j0G = objC != C1298J.f23835a ? C1055D.g(eVar, context, objC) : null;
        try {
            this.f23827d.resumeWith(objA);
            V3.v vVar = V3.v.f5542a;
            if (j0G == null || j0G.N0()) {
                C1298J.a(context, objC);
            }
        } catch (Throwable th) {
            if (j0G == null || j0G.N0()) {
                C1298J.a(context, objC);
            }
            throw th;
        }
    }

    public final boolean N0() {
        boolean z5 = this.threadLocalIsSet && this.f20306e.get() == null;
        this.f20306e.remove();
        return !z5;
    }

    public final void O0(Z3.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f20306e.set(V3.r.a(iVar, obj));
    }
}
