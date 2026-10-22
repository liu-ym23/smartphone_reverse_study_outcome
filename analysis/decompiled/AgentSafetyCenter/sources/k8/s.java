package k8;

import com.stepos.agentsafetycenter.MainActivity;
import com.stepos.agentsafetycenter.R;
import java.util.List;
import k0.c1;
import m8.k0;
import s8.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7343c = 0;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7344f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7345g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7346h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ jb.b f7347j;

    public /* synthetic */ s(xb.l lVar, List list, kc.t tVar, xb.l lVar2, xb.l lVar3) {
        this.f7344f = lVar;
        this.f7345g = list;
        this.f7346h = tVar;
        this.i = lVar2;
        this.f7347j = lVar3;
    }

    @Override // xb.a
    public final Object invoke() {
        int i = this.f7343c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.f7344f;
                k0 k0Var = (k0) this.f7346h;
                c1 c1Var = (c1) this.i;
                MainActivity mainActivity2 = (MainActivity) this.f7345g;
                xb.a aVar = (xb.a) this.f7347j;
                int i3 = MainActivity.f2491h;
                if (((d0) c1Var.getValue()) instanceof x) {
                    mainActivity.finish();
                    mainActivity.overridePendingTransition(R.anim.stepos_activity_to_next_close_enter, R.anim.stepos_activity_to_next_close_exit);
                    return vVar;
                }
                d0 d0Var = (d0) c1Var.getValue();
                boolean zA = yb.k.a(d0Var, b0.f7283a);
                Object objE = a0.f7278a;
                if (!zA) {
                    if (d0Var instanceof c0) {
                        objE = ((c0) d0Var).f7289c;
                    } else {
                        boolean z10 = d0Var instanceof w;
                        x xVar = x.f7359a;
                        if (z10) {
                            k0Var.o();
                        } else if (yb.k.a(d0Var, z.f7361a) || yb.k.a(d0Var, objE) || yb.k.a(d0Var, y.f7360a)) {
                            objE = MainActivity.e(mainActivity2, aVar, d0Var);
                        } else if (!yb.k.a(d0Var, xVar)) {
                            g5.f.a();
                            return null;
                        }
                        objE = xVar;
                    }
                }
                c1Var.setValue(objE);
                return vVar;
            default:
                xb.l lVar = (xb.l) this.f7344f;
                Object obj = this.f7345g;
                kc.t tVar = (kc.t) this.f7346h;
                xb.l lVar2 = (xb.l) this.i;
                xb.l lVar3 = (xb.l) this.f7347j;
                lVar.invoke(obj);
                kc.w.u(tVar, null, null, new r0(lVar2, lVar3, null, 3), 3);
                return vVar;
        }
    }

    public /* synthetic */ s() {
    }
}
