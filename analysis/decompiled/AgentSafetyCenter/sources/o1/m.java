package o1;

import u1.a2;
import u1.s1;
import u1.y1;
import v1.a1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends w0.l implements a2, s1, u1.k {

    /* renamed from: s, reason: collision with root package name */
    public a f9063s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9064t;

    @Override // u1.s1
    public final void A() {
        E0();
    }

    public final void B0() {
        a aVar;
        yb.u uVar = new yb.u();
        u1.f.x(this, new f(uVar));
        m mVar = (m) uVar.f16098c;
        if (mVar == null || (aVar = mVar.f9063s) == null) {
            aVar = this.f9063s;
        }
        C0(aVar);
    }

    public final void C0(o oVar) {
        p pVar = (p) u1.f.h(this, a1.f14375u);
        if (pVar != null) {
            v1.q qVar = (v1.q) pVar;
            if (oVar == null) {
                o.f9066a.getClass();
                oVar = q.f9067a;
            }
            v1.e0.f14407a.a(qVar.f14524a, oVar);
        }
    }

    public final void D0() {
        yb.q qVar = new yb.q();
        qVar.f16094c = true;
        u1.f.y(this, new e(qVar, 0));
        if (qVar.f16094c) {
            B0();
        }
    }

    public final void E0() {
        if (this.f9064t) {
            this.f9064t = false;
            if (this.f15126r) {
                yb.u uVar = new yb.u();
                u1.f.x(this, new n1.h(uVar, 1));
                m mVar = (m) uVar.f16098c;
                if (mVar != null) {
                    mVar.B0();
                } else {
                    C0(null);
                }
            }
        }
    }

    @Override // u1.a2
    public final /* bridge */ /* synthetic */ Object k() {
        return "androidx.compose.ui.input.pointer.PointerHoverIcon";
    }

    @Override // u1.s1
    public final long l() {
        int i = y1.f13975b;
        return y1.f13974a;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // u1.s1
    public final void q(j jVar, k kVar, long j10) {
        if (kVar == k.f9060f) {
            ?? r42 = jVar.f9056a;
            int size = r42.size();
            for (int i = 0; i < size; i++) {
                int i3 = ((s) r42.get(i)).i;
                if (i3 != 3 && i3 != 4) {
                    int i10 = jVar.f9058c;
                    if (i10 == 4) {
                        this.f9064t = true;
                        D0();
                        return;
                    } else {
                        if (i10 == 5) {
                            E0();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    @Override // w0.l
    public final void u0() {
        E0();
    }
}
