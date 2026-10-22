package v1;

import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g2 implements k0.u, androidx.lifecycle.v {

    /* renamed from: c, reason: collision with root package name */
    public t f14428c;

    /* renamed from: f, reason: collision with root package name */
    public k0.y f14429f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14430g;

    /* renamed from: h, reason: collision with root package name */
    public androidx.lifecycle.q f14431h;
    public xb.p i;

    public final void a() {
        if (!this.f14430g) {
            this.f14430g = true;
            this.f14428c.getView().setTag(R.id.wrapped_composition_tag, null);
            androidx.lifecycle.q qVar = this.f14431h;
            if (qVar != null) {
                qVar.c(this);
            }
        }
        this.f14429f.l();
    }

    public final void b(xb.p pVar) {
        this.f14428c.setOnViewTreeOwnersAvailable(new i0(5, this, pVar));
    }

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        if (oVar == androidx.lifecycle.o.ON_DESTROY) {
            a();
        } else {
            if (oVar != androidx.lifecycle.o.ON_CREATE || this.f14430g) {
                return;
            }
            b(this.i);
        }
    }
}
