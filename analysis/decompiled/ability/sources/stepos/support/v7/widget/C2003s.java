package stepos.support.v7.widget;

import android.view.MenuItem;
import android.view.View;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* renamed from: stepos.support.v7.widget.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2003s implements Va.A, Va.l, OnApplyWindowInsetsListener, InterfaceC2009y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f6629a;

    public /* synthetic */ C2003s(Object obj) {
        this.f6629a = obj;
    }

    @Override // Va.l
    public boolean e(Va.n nVar, MenuItem menuItem) {
        InterfaceC2009y interfaceC2009y = ((ActionMenuView) this.f6629a).l;
        if (interfaceC2009y != null) {
            C0 c02 = ((Toolbar) ((C2003s) interfaceC2009y).f6629a).f6568M;
            if (c02 != null ? ((stepos.support.v7.app.b0) ((a5.d) c02).b).c.f6290a.onMenuItemSelected(0, menuItem) : false) {
                return true;
            }
        }
        return false;
    }

    @Override // Va.A
    public void f(Va.n nVar, boolean z10) {
        if (nVar instanceof Va.F) {
            ((Va.F) nVar).f1429w.c(false);
        }
        Va.A a3 = ((C2005u) this.f6629a).e;
        if (a3 != null) {
            a3.f(nVar, z10);
        }
    }

    @Override // Va.l
    public void k(Va.n nVar) {
        h2.d dVar = ((ActionMenuView) this.f6629a).g;
        if (dVar != null) {
            dVar.k(nVar);
        }
    }

    @Override // Va.A
    public boolean n(Va.n nVar) {
        C2005u c2005u = (C2005u) this.f6629a;
        if (nVar == null) {
            return false;
        }
        ((Va.F) nVar).f1430x.getClass();
        c2005u.getClass();
        Va.A a3 = c2005u.e;
        return a3 != null && a3.n(nVar);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = (StepOSCollapsingToolbarLayout) this.f6629a;
        if (!ObjectsCompat.equals(stepOSCollapsingToolbarLayout.y, windowInsetsCompat)) {
            stepOSCollapsingToolbarLayout.y = windowInsetsCompat;
            stepOSCollapsingToolbarLayout.requestLayout();
        }
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(stepOSCollapsingToolbarLayout) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(stepOSCollapsingToolbarLayout.f6454w, windowInsetsCompat2)) {
            stepOSCollapsingToolbarLayout.f6454w = windowInsetsCompat2;
            stepOSCollapsingToolbarLayout.requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
