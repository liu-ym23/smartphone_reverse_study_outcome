package o;

import b0.l1;

/* loaded from: classes.dex */
public final class a1 extends n0.l implements i1.v {

    /* renamed from: t, reason: collision with root package name */
    public y0 f7014t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7015u;

    @Override // i1.v
    public final i1.l0 G(i1.m0 m0Var, g1.o oVar, long j2) {
        boolean z4 = this.f7015u;
        p.e0 e0Var = p.e0.f8081f;
        if ((z4 ? e0Var : p.e0.f8082g) == e0Var) {
            if (d2.a.g(j2) == Integer.MAX_VALUE) {
                throw new IllegalStateException("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
            }
        } else if (d2.a.h(j2) == Integer.MAX_VALUE) {
            throw new IllegalStateException("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
        g1.s sVarB = oVar.b(d2.a.a(j2, this.f7015u ? d2.a.h(j2) : Integer.MAX_VALUE, this.f7015u ? Integer.MAX_VALUE : d2.a.g(j2), 5));
        int i2 = sVarB.f3756f;
        int iH = d2.a.h(j2);
        if (i2 > iH) {
            i2 = iH;
        }
        int i10 = sVarB.f3757g;
        int iG = d2.a.g(j2);
        if (i10 > iG) {
            i10 = iG;
        }
        int i11 = sVarB.f3757g - i10;
        int i12 = sVarB.f3756f - i2;
        if (!this.f7015u) {
            i11 = i12;
        }
        y0 y0Var = this.f7014t;
        l1 l1Var = y0Var.f7162i;
        l1 l1Var2 = y0Var.f7159f;
        l1Var.g(i11);
        l0.f fVar = (l0.f) l0.m.f5773b.z();
        p7.k kVarE = fVar != null ? fVar.e() : null;
        l0.f fVarF = l0.r.f(fVar);
        try {
            if (l1Var2.e() > i11) {
                l1Var2.g(i11);
            }
            l0.r.i(fVar, fVarF, kVarE);
            this.f7014t.f7160g.g(this.f7015u ? i10 : i2);
            return m0Var.l0(i2, i10, d7.a0.f2944f, new z0(this, i11, sVarB));
        } catch (Throwable th) {
            l0.r.i(fVar, fVarF, kVarE);
            throw th;
        }
    }
}
