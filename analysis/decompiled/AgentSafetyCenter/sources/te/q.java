package te;

import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class q extends n3.d implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public ActionProvider f13391a;

    /* renamed from: b, reason: collision with root package name */
    public n3.c f13392b;

    @Override // n3.d
    public final boolean a() {
        return this.f13391a.hasSubMenu();
    }

    @Override // n3.d
    public final boolean b() {
        return this.f13391a.isVisible();
    }

    @Override // n3.d
    public final View c(h3.b bVar) {
        return this.f13391a.onCreateActionView(bVar);
    }

    @Override // n3.d
    public final boolean d() {
        return this.f13391a.onPerformDefaultAction();
    }

    @Override // n3.d
    public final void e(SubMenu subMenu) {
        this.f13391a.onPrepareSubMenu(subMenu);
    }

    @Override // n3.d
    public final boolean f() {
        return this.f13391a.overridesItemVisibility();
    }

    @Override // n3.d
    public final void g(n3.c cVar) {
        this.f13392b = cVar;
        this.f13391a.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z10) {
        n3.c cVar = this.f13392b;
        if (cVar != null) {
            cVar.m();
        }
    }
}
