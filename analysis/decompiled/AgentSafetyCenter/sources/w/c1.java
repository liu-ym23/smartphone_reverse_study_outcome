package w;

import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 extends yb.l implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14960c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(int i, int i3) {
        super(i);
        this.f14960c = i3;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f14960c;
        k0.y0 y0Var = k0.m.f6974a;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj2;
                ((Number) obj3).intValue();
                sVar.X(359872873);
                WeakHashMap weakHashMap = z0.f15068u;
                z0 z0VarE = c.e(sVar);
                boolean zF = sVar.f(z0VarE);
                Object objM = sVar.M();
                if (zF || objM == y0Var) {
                    objM = new f0(z0VarE.f15073e);
                    sVar.i0(objM);
                }
                f0 f0Var = (f0) objM;
                sVar.q(false);
                return f0Var;
            default:
                k0.s sVar2 = (k0.s) obj2;
                ((Number) obj3).intValue();
                sVar2.X(359872873);
                WeakHashMap weakHashMap2 = z0.f15068u;
                z0 z0VarE2 = c.e(sVar2);
                boolean zF2 = sVar2.f(z0VarE2);
                Object objM2 = sVar2.M();
                if (zF2 || objM2 == y0Var) {
                    objM2 = new f0(z0VarE2.f15074f);
                    sVar2.i0(objM2);
                }
                f0 f0Var2 = (f0) objM2;
                sVar2.q(false);
                return f0Var2;
        }
    }
}
