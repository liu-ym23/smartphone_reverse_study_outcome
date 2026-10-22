package r;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class m extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g1.s f8889g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g1.o f8890h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i1.m0 f8891i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8892j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f8893k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f8894l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(g1.s sVar, g1.o oVar, i1.m0 m0Var, int i2, int i10, o oVar2) {
        super(1);
        this.f8889g = sVar;
        this.f8890h = oVar;
        this.f8891i = m0Var;
        this.f8892j = i2;
        this.f8893k = i10;
        this.f8894l = oVar2;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        d2.l lVarC0 = this.f8891i.c0();
        n0.e eVar = this.f8894l.f8905a;
        HashMap map = l.f8885a;
        this.f8890h.g();
        g1.s sVar = this.f8889g;
        g1.r.h((g1.r) obj, sVar, eVar.a(ib.k.a(sVar.f3756f, sVar.f3757g), ib.k.a(this.f8892j, this.f8893k), lVarC0));
        return c7.r.f1986a;
    }
}
