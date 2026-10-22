package j9;

import androidx.compose.foundation.layout.FillElement;
import androidx.lifecycle.i0;
import com.stepos.agentsafetycenter.R;
import g9.f1;
import g9.o1;
import g9.p0;
import g9.s0;
import g9.u0;
import g9.w0;
import g9.y0;
import g9.z0;
import java.lang.invoke.VarHandle;
import k0.c1;
import s8.j2;
import s8.l1;
import s8.l2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6722c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6723f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6724g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6725h;
    public /* synthetic */ Object i;

    public /* synthetic */ v(int i) {
        this.f6722c = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f6722c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                b0.b((String) this.f6723f, (xb.l) this.f6725h, (xb.l) this.i, (w0.m) this.f6724g, (k0.s) obj, k0.z.D(385));
                break;
            case 1:
                ((Integer) obj2).getClass();
                l1.e((String) this.f6723f, (String) this.f6725h, (String) this.i, (w0.m) this.f6724g, (k0.s) obj, k0.z.D(3073));
                break;
            case 2:
                xb.a aVar = (xb.a) this.f6723f;
                c1 c1Var = (c1) this.f6725h;
                f1 f1Var = (f1) this.i;
                c1 c1Var2 = (c1) this.f6724g;
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i3 = 0;
                if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    sVar.S();
                    break;
                } else {
                    String strO = t2.a.o(R.string.permission_manager_title, sVar);
                    FillElement fillElement = androidx.compose.foundation.layout.c.f904c;
                    long j10 = l2.f11764a;
                    boolean z10 = ((y0) c1Var.getValue()).f4655c;
                    j2 j2Var = new j2(i3);
                    j2Var.f11696g = c1Var;
                    j2Var.f11695f = f1Var;
                    j2Var.f11697h = c1Var2;
                    VarHandle.storeStoreFence();
                    l9.a.d(strO, aVar, fillElement, j10, z10, null, null, s0.h.d(-738044682, j2Var, sVar), sVar, 12586368, 96);
                    break;
                }
            default:
                f1 f1Var2 = (f1) this.f6723f;
                kc.t tVar = (kc.t) this.f6725h;
                p0 p0Var = (p0) this.i;
                c1 c1Var3 = (c1) this.f6724g;
                o1 o1Var = (o1) obj;
                z0 z0Var = (z0) obj2;
                o1Var.getClass();
                z0Var.getClass();
                String str = o1Var.f4563a;
                s0 s0Var = o1Var.f4571j;
                f1Var2.getClass();
                u0 u0Var = u0.f4625f;
                z0 z0Var2 = (z0) f1Var2.f4450b.get(str);
                if (z0Var2 == null) {
                    w0 w0Var = (w0) f1Var2.f4449a.get(str);
                    z0Var2 = w0Var != null ? w0Var.f4644h : z0.f4661f;
                }
                f1Var2.c(u0Var, str, z0Var2, z0Var, s0Var);
                kc.w.u(tVar, null, null, new i0(p0Var, o1Var, z0Var, f1Var2, null, 8), 3);
                c1Var3.setValue(null);
                break;
        }
        return vVar;
    }
}
