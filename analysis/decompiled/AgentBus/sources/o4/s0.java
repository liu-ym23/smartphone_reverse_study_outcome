package o4;

import com.stepos.account.oauth.OAuthConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class s0 extends s7.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f7550b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ na.d f7551c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t1 f7552d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q7.v f7553e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i0 f7554f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ia.s f7555g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ia.s f7556h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f7557i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ia.s f7558j;

    public s0(f1 f1Var, na.d dVar, t1 t1Var, q7.v vVar, i0 i0Var, ia.s sVar, ia.s sVar2, AtomicBoolean atomicBoolean, ia.s sVar3) {
        this.f7550b = f1Var;
        this.f7551c = dVar;
        this.f7552d = t1Var;
        this.f7553e = vVar;
        this.f7554f = i0Var;
        this.f7555g = sVar;
        this.f7556h = sVar2;
        this.f7557i = atomicBoolean;
        this.f7558j = sVar3;
    }

    @Override // s7.a
    public final void K(ab.e0 e0Var, int i2, String str) {
        q7.k.e(e0Var, "ws");
        String str2 = this.f7550b.f7355l ? "cloud" : "edge";
        k5.t tVar = this.f7552d.f7583k;
        StringBuilder sbP = a1.a.p("[", str2, "/", this.f7550b.f7344a, "] [WS_CLOSED] onClosed: code=");
        sbP.append(i2);
        sbP.append(" reason=");
        sbP.append(str);
        k5.s.info$default(tVar, "OpenClawGateway", sbP.toString(), null, 4, null);
        if (!this.f7555g.V()) {
            ia.s sVar = this.f7555g;
            String strConcat = "Gateway closed: ".concat(str);
            q7.k.e(strConcat, OAuthConstants.FACTOR_RESULT_MESSAGE);
            sVar.l0(new g0(strConcat));
        }
        if (this.f7557i.compareAndSet(false, true)) {
            f1 f1Var = this.f7550b;
            "closed: ".concat(str);
            f1Var.k();
            this.f7558j.X(new h0(i2, str));
        }
    }

    @Override // s7.a
    public final void M(nb.g gVar, Exception exc, ab.z zVar) {
        String str = this.f7550b.f7355l ? "cloud" : "edge";
        k5.t tVar = this.f7552d.f7583k;
        String str2 = this.f7550b.f7344a;
        String simpleName = exc.getClass().getSimpleName();
        String message = exc.getMessage();
        Integer numValueOf = zVar != null ? Integer.valueOf(zVar.f687i) : null;
        StringBuilder sbP = a1.a.p("[", str, "/", str2, "] [WS_ERROR] onFailure: ");
        m.x.w(sbP, simpleName, ": ", message, " response=");
        sbP.append(numValueOf);
        k5.s.warn$default(tVar, "OpenClawGateway", sbP.toString(), null, 4, null);
        if (!this.f7555g.V()) {
            this.f7555g.l0(exc);
        }
        if (this.f7557i.compareAndSet(false, true)) {
            f1 f1Var = this.f7550b;
            exc.getMessage();
            f1Var.k();
            ia.s sVar = this.f7558j;
            String message2 = exc.getMessage();
            if (message2 == null) {
                message2 = exc.getClass().getSimpleName();
            }
            sVar.X(new h0(-1, message2));
        }
    }

    @Override // s7.a
    public final void N(ab.e0 e0Var, String str) {
        q7.k.e(e0Var, "ws");
        f1 f1Var = this.f7550b;
        ia.d0.s(this.f7551c, f1Var.f7350g, null, new la.a0(f1Var, str, this.f7552d, this.f7556h, null, 4), 2);
    }

    @Override // s7.a
    public final void P(ab.e0 e0Var, ab.z zVar) {
        this.f7550b.f7357n = e0Var;
        na.d dVar = this.f7551c;
        pa.e eVar = ia.n0.f4982a;
        ia.d0.s(dVar, pa.d.f8556h, null, new r0(this.f7552d, this.f7550b, this.f7553e, this.f7554f, this.f7555g, e0Var, dVar, this.f7556h, null), 2);
    }
}
