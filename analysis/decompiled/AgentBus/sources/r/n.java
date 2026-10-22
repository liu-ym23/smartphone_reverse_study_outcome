package r;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class n extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g1.s[] f8897g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f8898h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i1.m0 f8899i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q7.t f8900j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q7.t f8901k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f8902l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(g1.s[] sVarArr, List list, i1.m0 m0Var, q7.t tVar, q7.t tVar2, o oVar) {
        super(1);
        this.f8897g = sVarArr;
        this.f8898h = list;
        this.f8899i = m0Var;
        this.f8900j = tVar;
        this.f8901k = tVar2;
        this.f8902l = oVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g1.r rVar = (g1.r) obj;
        g1.s[] sVarArr = this.f8897g;
        int length = sVarArr.length;
        int i2 = 0;
        int i10 = 0;
        while (i2 < length) {
            g1.s sVar = sVarArr[i2];
            int i11 = i10 + 1;
            q7.k.c(sVar, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            g1.o oVar = (g1.o) this.f8898h.get(i10);
            d2.l lVarC0 = this.f8899i.c0();
            int i12 = this.f8900j.f8818f;
            int i13 = this.f8901k.f8818f;
            n0.e eVar = this.f8902l.f8905a;
            HashMap map = l.f8885a;
            oVar.g();
            g1.r.h(rVar, sVar, eVar.a(ib.k.a(sVar.f3756f, sVar.f3757g), ib.k.a(i12, i13), lVarC0));
            i2++;
            i10 = i11;
        }
        return c7.r.f1986a;
    }
}
