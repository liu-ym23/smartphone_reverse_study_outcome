package j9;

import i9.d0;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Set;
import k0.c1;
import k0.r2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.r {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f6663c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r2 f6664f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c1 f6665g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(List list, c1 c1Var, c1 c1Var2) {
        super(4);
        this.f6663c = list;
        this.f6664f = c1Var;
        this.f6665g = c1Var2;
    }

    @Override // xb.r
    public final Object c(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        x.b bVar = (x.b) obj;
        int iIntValue = ((Number) obj2).intValue();
        k0.s sVar = (k0.s) obj3;
        int iIntValue2 = ((Number) obj4).intValue();
        if ((iIntValue2 & 6) == 0) {
            i = (sVar.f(bVar) ? 4 : 2) | iIntValue2;
        } else {
            i = iIntValue2;
        }
        if ((iIntValue2 & 48) == 0) {
            i |= sVar.d(iIntValue) ? 32 : 16;
        }
        if ((i & 147) == 146 && sVar.B()) {
            sVar.S();
        } else {
            i9.c cVar = (i9.c) this.f6663c.get(iIntValue);
            sVar.X(-1086436005);
            boolean zContains = ((d0) this.f6664f.getValue()).f5853d.contains(cVar.f5844a);
            c1 c1Var = this.f6665g;
            boolean z10 = ((Set) c1Var.getValue()).contains(cVar.f5844a) || zContains;
            boolean z11 = !zContains;
            Object objM = sVar.M();
            Object obj5 = objM;
            if (objM == k0.m.f6974a) {
                f fVar = new f(0);
                fVar.f6662f = c1Var;
                VarHandle.storeStoreFence();
                sVar.i0(fVar);
                obj5 = fVar;
            }
            a.b(cVar, z10, z11, (xb.l) obj5, sVar, 3072);
            sVar.q(false);
        }
        return jb.v.f6774a;
    }
}
