package k8;

import androidx.lifecycle.i0;
import com.stepos.agentsafetycenter.MainActivity;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7327c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7328f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f7329g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7330h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f7331j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f7332k;

    public /* synthetic */ o(int i) {
        this.f7327c = i;
    }

    @Override // xb.a
    public final Object invoke() throws Exception {
        boolean z10;
        int i = this.f7327c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                kc.t tVar = (kc.t) this.f7328f;
                c1 c1Var = (c1) this.f7329g;
                MainActivity mainActivity = (MainActivity) this.f7332k;
                c1 c1Var2 = (c1) this.f7330h;
                c1 c1Var3 = (c1) this.i;
                c1 c1Var4 = (c1) this.f7331j;
                int i3 = MainActivity.f2491h;
                c1Var.setValue(Boolean.FALSE);
                kc.w.u(tVar, null, null, new i0(mainActivity, c1Var2, c1Var3, c1Var4, null, 2), 3);
                break;
            default:
                t0.b bVar = (t0.b) this.f7328f;
                t0.k kVar = (t0.k) this.f7329g;
                t0.g gVar = (t0.g) this.f7330h;
                String str = (String) this.i;
                Object obj = this.f7331j;
                Object[] objArr = (Object[]) this.f7332k;
                boolean z11 = true;
                if (bVar.f13107f != gVar) {
                    bVar.f13107f = gVar;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (yb.k.a(bVar.f13108g, str)) {
                    z11 = z10;
                } else {
                    bVar.f13108g = str;
                }
                bVar.f13106c = kVar;
                bVar.f13109h = obj;
                bVar.i = objArr;
                t0.f fVar = bVar.f13110j;
                if (fVar != null && z11) {
                    ((p5.m) fVar).V();
                    bVar.f13110j = null;
                    bVar.d();
                    break;
                }
                break;
        }
        return vVar;
    }
}
