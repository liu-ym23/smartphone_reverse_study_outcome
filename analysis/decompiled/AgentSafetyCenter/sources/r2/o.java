package r2;

import android.view.View;
import android.view.ViewTreeObserver;
import u1.n1;
import v1.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends w0.l implements b1.m, ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: s, reason: collision with root package name */
    public View f10431s;

    /* renamed from: t, reason: collision with root package name */
    public ViewTreeObserver f10432t;

    /* renamed from: u, reason: collision with root package name */
    public n f10433u;

    /* renamed from: v, reason: collision with root package name */
    public n f10434v;

    public final b1.q B0() {
        if (!this.f15114c.f15126r) {
            r1.a.b("visitLocalDescendants called on an unattached node");
        }
        w0.l lVar = this.f15114c;
        if ((lVar.f15117h & 1024) != 0) {
            boolean z10 = false;
            for (w0.l lVar2 = lVar.f15118j; lVar2 != null; lVar2 = lVar2.f15118j) {
                if ((lVar2.f15116g & 1024) != 0) {
                    w0.l lVarE = lVar2;
                    m0.e eVar = null;
                    while (lVarE != null) {
                        if (lVarE instanceof b1.q) {
                            b1.q qVar = (b1.q) lVarE;
                            if (z10) {
                                return qVar;
                            }
                            z10 = true;
                        } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                            int i = 0;
                            for (w0.l lVar3 = ((u1.m) lVarE).f13866t; lVar3 != null; lVar3 = lVar3.f15118j) {
                                if ((lVar3.f15116g & 1024) != 0) {
                                    i++;
                                    if (i == 1) {
                                        lVarE = lVar3;
                                    } else {
                                        if (eVar == null) {
                                            eVar = new m0.e(new w0.l[16]);
                                        }
                                        if (lVarE != null) {
                                            eVar.b(lVarE);
                                            lVarE = null;
                                        }
                                        eVar.b(lVar3);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        lVarE = u1.f.e(eVar);
                    }
                }
            }
        }
        od.f.e("Could not find focus target of embedded view wrapper");
        return null;
    }

    @Override // b1.m
    public final void U(b1.j jVar) {
        jVar.c(false);
        jVar.d(this.f10433u);
        jVar.b(this.f10434v);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        if (u1.f.u(this).f13800q == null) {
            return;
        }
        View viewC = j.c(this);
        b1.h focusOwner = ((t) u1.f.v(this)).getFocusOwner();
        n1 n1VarV = u1.f.v(this);
        boolean z10 = (view == null || view.equals(n1VarV) || !j.a(viewC, view)) ? false : true;
        boolean z11 = (view2 == null || view2.equals(n1VarV) || !j.a(viewC, view2)) ? false : true;
        if (z10 && z11) {
            this.f10431s = view2;
            return;
        }
        if (!z11) {
            if (!z10) {
                this.f10431s = null;
                return;
            }
            this.f10431s = null;
            if (B0().D0().a()) {
                ((b1.i) focusOwner).b(8, false, false);
                return;
            }
            return;
        }
        this.f10431s = view2;
        b1.q qVarB0 = B0();
        int iOrdinal = qVarB0.D0().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            return;
        }
        if (iOrdinal == 3) {
            b1.e.v(qVarB0);
        } else {
            g5.f.a();
        }
    }

    @Override // w0.l
    public final void t0() {
        ViewTreeObserver viewTreeObserver = u1.f.w(this).getViewTreeObserver();
        this.f10432t = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // w0.l
    public final void u0() {
        ViewTreeObserver viewTreeObserver = this.f10432t;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.f10432t = null;
        u1.f.w(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.f10431s = null;
    }
}
