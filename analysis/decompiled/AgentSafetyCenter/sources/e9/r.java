package e9;

import g9.f1;
import g9.o1;
import g9.s0;
import g9.u0;
import java.util.List;
import k0.c1;
import k0.e2;
import k0.i2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3716c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3717f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3718g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3719h;

    public /* synthetic */ r(int i) {
        this.f3716c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f3716c) {
            case 0:
                kc.t tVar = (kc.t) this.f3717f;
                c1 c1Var = (c1) this.f3718g;
                h hVar = (h) this.f3719h;
                c1Var.setValue(Boolean.FALSE);
                kc.w.u(tVar, null, null, new t(hVar, null, 3), 3);
                break;
            case 1:
                kc.t tVar2 = (kc.t) this.f3717f;
                c1 c1Var2 = (c1) this.f3718g;
                i9.b0 b0Var = (i9.b0) this.f3719h;
                String str = (String) c1Var2.getValue();
                nb.c cVar = null;
                c1Var2.setValue(null);
                if (str != null) {
                    kc.w.u(tVar2, null, null, new androidx.lifecycle.h0(b0Var, str, cVar, 10), 3);
                }
                return jb.v.f6774a;
            case 2:
                k0.s sVar = (k0.s) this.f3717f;
                l0.a aVar = (l0.a) this.f3718g;
                e2 e2Var = (e2) this.f3719h;
                l0.b bVar = sVar.M;
                l0.a aVar2 = bVar.f7659b;
                try {
                    bVar.f7659b = aVar;
                    e2 e2Var2 = sVar.G;
                    int[] iArr = sVar.f7046o;
                    p.u uVar = sVar.f7053v;
                    sVar.f7046o = null;
                    sVar.f7053v = null;
                    try {
                        sVar.G = e2Var;
                        boolean z10 = bVar.f7662e;
                        try {
                            bVar.f7662e = false;
                            throw null;
                        } finally {
                        }
                    } catch (Throwable th) {
                        sVar.G = e2Var2;
                        sVar.f7046o = iArr;
                        sVar.f7053v = uVar;
                        throw th;
                    }
                } catch (Throwable th2) {
                    bVar.f7659b = aVar2;
                    throw th2;
                }
            case 3:
                k0.b bVar2 = (k0.b) this.f3717f;
                i2 i2Var = (i2) this.f3718g;
                l0.j0 j0Var = (l0.j0) this.f3719h;
                if (bVar2 != null) {
                    i2Var.a(i2Var.c(bVar2) - i2Var.f6956t);
                }
                List listC = t2.a.c(i2Var, null, i2Var.f6956t, null);
                v0.a aVar3 = (v0.a) kb.l.D0(listC);
                Integer num = aVar3 != null ? aVar3.f14316a : null;
                List listC2 = j0Var.c(num);
                if (num != null && !listC2.isEmpty()) {
                    v0.a aVar4 = (v0.a) kb.l.w0(listC2);
                    List listU0 = kb.l.u0(1, listC2);
                    aVar4.getClass();
                    listC2 = kb.l.F0(ac.a.E(new v0.a(null, num)), listU0);
                }
                return kb.l.F0(listC, listC2);
            default:
                f1 f1Var = (f1) this.f3717f;
                o1 o1Var = (o1) this.f3719h;
                c1 c1Var3 = (c1) this.f3718g;
                String str2 = o1Var.f4563a;
                s0 s0Var = o1Var.f4571j;
                f1Var.getClass();
                f1Var.c(u0.f4624c, str2, null, null, s0Var);
                c1Var3.setValue(o1Var);
                break;
        }
        return jb.v.f6774a;
    }
}
