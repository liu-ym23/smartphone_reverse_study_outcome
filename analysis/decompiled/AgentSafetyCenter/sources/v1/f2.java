package v1;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.Set;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f2 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14422c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g2 f14423f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ xb.p f14424g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f2(g2 g2Var, xb.p pVar, int i) {
        super(2);
        this.f14422c = i;
        this.f14423f = g2Var;
        this.f14424g = pVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f14422c;
        jb.v vVar = jb.v.f6774a;
        xb.p pVar = this.f14424g;
        g2 g2Var = this.f14423f;
        int i3 = 1;
        int i10 = 0;
        switch (i) {
            case 0:
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                    break;
                } else {
                    AndroidCompositionLocals_androidKt.a(g2Var.f14428c, pVar, sVar, 0);
                    break;
                }
            default:
                k0.s sVar2 = (k0.s) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    sVar2.S();
                    break;
                } else {
                    t tVar = g2Var.f14428c;
                    Object tag = tVar.getTag(R.id.inspection_slot_table_set);
                    nb.c cVar = null;
                    Set set = (!(tag instanceof Set) || ((tag instanceof zb.a) && !(tag instanceof zb.d))) ? null : (Set) tag;
                    if (set == null) {
                        Object parent = tVar.getParent();
                        View view = parent instanceof View ? (View) parent : null;
                        Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                        set = (!(tag2 instanceof Set) || ((tag2 instanceof zb.a) && !(tag2 instanceof zb.d))) ? null : (Set) tag2;
                    }
                    if (set != null) {
                        k0.x xVar = sVar2.U;
                        if (xVar == null) {
                            k0.y yVar = sVar2.f7040h;
                            xVar = new k0.x();
                            xVar.f7106a = yVar;
                            VarHandle.storeStoreFence();
                            sVar2.U = xVar;
                        }
                        set.add(xVar);
                        sVar2.f7048q = true;
                        sVar2.C = true;
                        sVar2.f7035c.b();
                        sVar2.H.b();
                        i2 i2Var = sVar2.I;
                        k0.f2 f2Var = i2Var.f6938a;
                        i2Var.f6942e = f2Var.f6908n;
                        i2Var.f6943f = f2Var.f6909o;
                    }
                    boolean zH = sVar2.h(g2Var);
                    Object objM = sVar2.M();
                    k0.y0 y0Var = k0.m.f6974a;
                    if (zH || objM == y0Var) {
                        objM = new e2(g2Var, cVar, i10);
                        sVar2.i0(objM);
                    }
                    k0.z.h(tVar, sVar2, (xb.p) objM);
                    boolean zH2 = sVar2.h(g2Var);
                    Object objM2 = sVar2.M();
                    if (zH2 || objM2 == y0Var) {
                        objM2 = new e2(g2Var, cVar, i3);
                        sVar2.i0(objM2);
                    }
                    k0.z.h(tVar, sVar2, (xb.p) objM2);
                    k0.z.a(v0.e.f14321a.a(set), s0.h.d(-280240369, new f2(g2Var, pVar, i10), sVar2), sVar2, 56);
                    break;
                }
                break;
        }
        return vVar;
    }
}
