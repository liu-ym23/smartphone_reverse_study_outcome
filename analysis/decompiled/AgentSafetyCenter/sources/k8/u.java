package k8;

import android.content.Intent;
import com.stepos.agentsafetycenter.MainActivity;
import k0.c1;
import k0.k1;
import m8.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f7348c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ MainActivity f7349f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f7350g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ m8.a f7351h;
    public final /* synthetic */ MainActivity i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ xb.l f7352j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c1 f7353k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(d0 d0Var, MainActivity mainActivity, k0 k0Var, m8.a aVar, MainActivity mainActivity2, xb.l lVar, c1 c1Var, nb.c cVar) {
        super(2, cVar);
        this.f7348c = d0Var;
        this.f7349f = mainActivity;
        this.f7350g = k0Var;
        this.f7351h = aVar;
        this.i = mainActivity2;
        this.f7352j = lVar;
        this.f7353k = c1Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new u(this.f7348c, this.f7349f, this.f7350g, this.f7351h, this.i, this.f7352j, this.f7353k, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        u uVar = (u) create((kc.t) obj, (nb.c) obj2);
        jb.v vVar = jb.v.f6774a;
        uVar.invokeSuspend(vVar);
        return vVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        jb.v vVar = jb.v.f6774a;
        d0 d0Var = this.f7348c;
        if (d0Var != null) {
            MainActivity mainActivity = this.f7349f;
            mainActivity.f2492c.setValue(null);
            k0 k0Var = this.f7350g;
            k0Var.Q("action_entry", true);
            x xVar = x.f7359a;
            boolean zEquals = d0Var.equals(xVar);
            k1 k1Var = mainActivity.f2493f;
            c1 c1Var = this.f7353k;
            if (zEquals) {
                k1Var.setValue(Boolean.FALSE);
                k0Var.o();
                if (this.f7351h.f8287t != null) {
                    k0Var.q();
                }
                c1Var.setValue(xVar);
                return vVar;
            }
            int i = MainActivity.f2491h;
            lb.i iVar = new lb.i();
            iVar.add("stepos.intent.action.AGENT_PERMISSION_MANAGER");
            iVar.add("stepos.intent.action.AGENT_SCREEN_PERCEPTION");
            lb.i iVarN = h5.t.n(iVar);
            Intent intent = this.i.getIntent();
            k1Var.setValue(Boolean.valueOf(kb.l.s0(iVarN, intent != null ? intent.getAction() : null)));
            if (!d0Var.equals(y.f7360a)) {
                if (d0Var.equals(b0.f7283a)) {
                    this.f7352j.invoke(d0Var);
                    return vVar;
                }
                c1Var.setValue(d0Var);
                return vVar;
            }
        }
        return vVar;
    }
}
