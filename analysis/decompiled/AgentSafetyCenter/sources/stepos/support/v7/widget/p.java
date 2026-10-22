package stepos.support.v7.widget;

import android.view.MenuItem;
import android.view.View;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p implements te.u, te.j, n3.s, t {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f12784c;

    @Override // te.u
    public void b(te.l lVar, boolean z10) {
        if (lVar instanceof te.z) {
            ((te.z) lVar).f13414w.c(false);
        }
        te.u uVar = ((q) this.f12784c).i;
        if (uVar != null) {
            uVar.b(lVar, z10);
        }
    }

    @Override // te.j
    public boolean c(te.l lVar, MenuItem menuItem) {
        t tVar = ((ActionMenuView) this.f12784c).E;
        if (tVar != null) {
            s1 s1Var = ((Toolbar) ((p) tVar).f12784c).M;
            if (s1Var != null ? ((stepos.support.v7.app.o0) s1Var).f12408c.f12454c.f12411c.onMenuItemSelected(0, menuItem) : false) {
                return true;
            }
        }
        return false;
    }

    @Override // te.j
    public void d(te.l lVar) {
        stepos.support.v7.app.f fVar = ((ActionMenuView) this.f12784c).f12608z;
        if (fVar != null) {
            fVar.d(lVar);
        }
    }

    @Override // te.u
    public boolean e(te.l lVar) {
        q qVar = (q) this.f12784c;
        if (lVar == null) {
            return false;
        }
        ((te.z) lVar).f13415x.getClass();
        te.u uVar = qVar.i;
        return uVar != null && uVar.e(lVar);
    }

    @Override // n3.s
    public n3.m1 p(View view, n3.m1 m1Var) {
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = (StepOSCollapsingToolbarLayout) this.f12784c;
        if (!Objects.equals(stepOSCollapsingToolbarLayout.C, m1Var)) {
            stepOSCollapsingToolbarLayout.C = m1Var;
            stepOSCollapsingToolbarLayout.requestLayout();
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.m1 m1Var2 = stepOSCollapsingToolbarLayout.getFitsSystemWindows() ? m1Var : null;
        if (!Objects.equals(stepOSCollapsingToolbarLayout.A, m1Var2)) {
            stepOSCollapsingToolbarLayout.A = m1Var2;
            stepOSCollapsingToolbarLayout.requestLayout();
        }
        return m1Var.f8737a.c();
    }
}
