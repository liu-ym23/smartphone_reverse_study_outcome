package j1;

import android.view.View;
import b0.p2;
import b0.s2;
import com.stepos.agentbus.R;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class m2 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5254g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n2 f5255h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p7.n f5256i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m2(n2 n2Var, p7.n nVar, int i2) {
        super(2);
        this.f5254g = i2;
        this.f5255h = n2Var;
        this.f5256i = nVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5254g) {
            case 0:
                b0.p pVar = (b0.p) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (pVar.L(iIntValue & 1, (iIntValue & 3) != 2)) {
                    q0.a(this.f5255h.f5283f, this.f5256i, pVar, 0);
                } else {
                    pVar.O();
                }
                break;
            default:
                b0.p pVar2 = (b0.p) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (pVar2.L(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    n2 n2Var = this.f5255h;
                    y yVar = n2Var.f5283f;
                    Object tag = yVar.getTag(R.id.inspection_slot_table_set);
                    g7.d dVar = null;
                    Set set = (!(tag instanceof Set) || ((tag instanceof r7.a) && !(tag instanceof r7.e))) ? null : (Set) tag;
                    if (set == null) {
                        Object parent = yVar.getParent();
                        View view = parent instanceof View ? (View) parent : null;
                        Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                        set = (!(tag2 instanceof Set) || ((tag2 instanceof r7.a) && !(tag2 instanceof r7.e))) ? null : (Set) tag2;
                    }
                    if (set != null) {
                        b0.w wVar = pVar2.R;
                        if (wVar == null) {
                            wVar = new b0.w(pVar2.f1277g);
                            pVar2.R = wVar;
                        }
                        set.add(wVar);
                        pVar2.f1286p = true;
                        pVar2.B = true;
                        pVar2.f1273c.f1315o = new HashMap();
                        p2 p2Var = pVar2.G;
                        p2Var.getClass();
                        p2Var.f1315o = new HashMap();
                        s2 s2Var = pVar2.H;
                        p2 p2Var2 = s2Var.f1346a;
                        s2Var.f1350e = p2Var2.f1315o;
                        s2Var.f1351f = p2Var2.f1316p;
                    }
                    boolean zH = pVar2.h(n2Var);
                    Object objJ = pVar2.J();
                    b0.b1 b1Var = b0.k.f1229a;
                    if (zH || objJ == b1Var) {
                        objJ = new l2(n2Var, dVar, 0);
                        pVar2.b0(objJ);
                    }
                    b0.b.e(pVar2, yVar, (p7.n) objJ);
                    boolean zH2 = pVar2.h(n2Var);
                    Object objJ2 = pVar2.J();
                    if (zH2 || objJ2 == b1Var) {
                        objJ2 = new l2(n2Var, dVar, 1);
                        pVar2.b0(objJ2);
                    }
                    b0.b.e(pVar2, yVar, (p7.n) objJ2);
                    b0.b.a(m0.f.f6127a.a(set), j0.i.d(-280240369, new m2(n2Var, this.f5256i, 0), pVar2), pVar2, 56);
                } else {
                    pVar2.O();
                }
                break;
        }
        return c7.r.f1986a;
    }
}
