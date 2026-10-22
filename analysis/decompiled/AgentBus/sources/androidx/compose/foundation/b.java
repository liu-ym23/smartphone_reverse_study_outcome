package androidx.compose.foundation;

import b0.k;
import b0.p;
import o.g0;
import p7.o;
import q.i;
import q7.m;

/* loaded from: classes.dex */
public final class b extends m implements o {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g0 f717g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f718h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p7.a f719i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(g0 g0Var, boolean z4, p7.a aVar) {
        super(3);
        this.f717g = g0Var;
        this.f718h = z4;
        this.f719i = aVar;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        p pVar = (p) obj2;
        ((Number) obj3).intValue();
        pVar.S(-1525724089);
        Object objJ = pVar.J();
        if (objJ == k.f1229a) {
            objJ = new i();
            pVar.b0(objJ);
        }
        i iVar = (i) objJ;
        n0.m mVarC = c.a(this.f717g, iVar).c(new ClickableElement(iVar, null, this.f718h, this.f719i));
        pVar.q(false);
        return mVarC;
    }
}
