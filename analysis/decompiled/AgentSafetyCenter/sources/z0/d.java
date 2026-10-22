package z0;

import b.g;
import t.n;
import t.o;
import u1.a2;
import u1.f;
import u1.v;
import w0.l;
import yb.k;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends l implements a2, v {

    /* renamed from: s, reason: collision with root package name */
    public c f16142s;

    /* renamed from: t, reason: collision with root package name */
    public d f16143t;

    /* renamed from: u, reason: collision with root package name */
    public d f16144u;

    /* renamed from: v, reason: collision with root package name */
    public long f16145v;

    public final boolean B0() {
        d dVar = this.f16143t;
        if (dVar != null) {
            return dVar.B0();
        }
        d dVar2 = this.f16144u;
        if (dVar2 != null) {
            return dVar2.B0();
        }
        return false;
    }

    public final void C0() {
        d dVar = this.f16144u;
        if (dVar != null) {
            dVar.C0();
            return;
        }
        d dVar2 = this.f16143t;
        if (dVar2 != null) {
            dVar2.C0();
        }
    }

    public final void D0() {
        d dVar = this.f16144u;
        if (dVar != null) {
            dVar.D0();
        }
        d dVar2 = this.f16143t;
        if (dVar2 != null) {
            dVar2.D0();
        }
        this.f16143t = null;
    }

    public final void E0(sa.c cVar) {
        a2 a2Var;
        d dVar;
        d dVar2 = this.f16143t;
        if (dVar2 == null || !n.d(dVar2, o.h(cVar))) {
            if (this.f15114c.f15126r) {
                u uVar = new u();
                f.y(this, new g(uVar, this, cVar, 12));
                a2Var = (a2) uVar.f16098c;
            } else {
                a2Var = null;
            }
            dVar = (d) a2Var;
        } else {
            dVar = dVar2;
        }
        if (dVar != null && dVar2 == null) {
            dVar.C0();
            dVar.E0(cVar);
            d dVar3 = this.f16144u;
            if (dVar3 != null) {
                dVar3.D0();
            }
        } else if (dVar == null && dVar2 != null) {
            d dVar4 = this.f16144u;
            if (dVar4 != null) {
                dVar4.C0();
                dVar4.E0(cVar);
            }
            dVar2.D0();
        } else if (!k.a(dVar, dVar2)) {
            if (dVar != null) {
                dVar.C0();
                dVar.E0(cVar);
            }
            if (dVar2 != null) {
                dVar2.D0();
            }
        } else if (dVar != null) {
            dVar.E0(cVar);
        } else {
            d dVar5 = this.f16144u;
            if (dVar5 != null) {
                dVar5.E0(cVar);
            }
        }
        this.f16143t = dVar;
    }

    public final void F0() {
        d dVar = this.f16144u;
        if (dVar != null) {
            dVar.F0();
            return;
        }
        d dVar2 = this.f16143t;
        if (dVar2 != null) {
            dVar2.F0();
        }
    }

    @Override // u1.a2
    public final Object k() {
        return this.f16142s;
    }

    @Override // u1.v
    public final void m(long j10) {
        this.f16145v = j10;
    }

    @Override // w0.l
    public final void u0() {
        this.f16144u = null;
        this.f16143t = null;
    }
}
