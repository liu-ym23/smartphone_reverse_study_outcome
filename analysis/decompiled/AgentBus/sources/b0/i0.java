package b0;

/* loaded from: classes.dex */
public final class i0 extends l0.w implements b3 {

    /* renamed from: g, reason: collision with root package name */
    public final p7.a f1186g;

    /* renamed from: h, reason: collision with root package name */
    public h0 f1187h = new h0(l0.m.k().g());

    public i0(p7.a aVar) {
        this.f1186g = aVar;
    }

    @Override // l0.v
    public final l0.x a() {
        return this.f1187h;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b0.h0 e(b0.h0 r21, l0.f r22, boolean r23, p7.a r24) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.i0.e(b0.h0, l0.f, boolean, p7.a):b0.h0");
    }

    @Override // l0.v
    public final void f(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.f1187h = (h0) xVar;
    }

    public final h0 g() {
        l0.f fVarK = l0.m.k();
        return e((h0) l0.m.j(this.f1187h, fVarK), fVarK, false, this.f1186g);
    }

    @Override // b0.b3
    public final Object getValue() {
        p7.k kVarE = l0.m.k().e();
        if (kVarE != null) {
            kVarE.invoke(this);
        }
        l0.f fVarK = l0.m.k();
        return e((h0) l0.m.j(this.f1187h, fVarK), fVarK, true, this.f1186g).f1170f;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DerivedState(value=");
        h0 h0Var = (h0) l0.m.i(this.f1187h);
        sb2.append(h0Var.c(this, l0.m.k()) ? String.valueOf(h0Var.f1170f) : "<Not calculated>");
        sb2.append(")@");
        sb2.append(hashCode());
        return sb2.toString();
    }
}
