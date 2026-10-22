package stepos.support.v7.widget;

import android.view.MenuItem;
import stepos.support.v7.app.C0872q;

/* renamed from: stepos.support.v7.widget.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0898s implements L3.v, L3.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f15146a;

    public /* synthetic */ C0898s(ActionMenuView actionMenuView) {
        this.f15146a = actionMenuView;
    }

    @Override // L3.i
    public final boolean b(L3.k kVar, MenuItem menuItem) {
        t0 t0Var;
        InterfaceC0900u interfaceC0900u = this.f15146a.f14796A;
        return (interfaceC0900u == null || (t0Var = ((Toolbar) ((C0872q) interfaceC0900u).f14583b).f14999I) == null || !((stepos.support.v7.app.a0) t0Var).f14434a.f14440c.f14435a.onMenuItemSelected(0, menuItem)) ? false : true;
    }

    @Override // L3.i
    public final void c(L3.k kVar) {
        L3.i iVar = this.f15146a.f14804v;
        if (iVar != null) {
            iVar.c(kVar);
        }
    }

    @Override // L3.v
    public final void d(L3.k kVar, boolean z4) {
    }

    @Override // L3.v
    public final boolean g(L3.k kVar) {
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0898s(ActionMenuView actionMenuView, int i4) {
        this(actionMenuView);
        if (i4 != 1) {
        } else {
            this(actionMenuView);
        }
    }
}
