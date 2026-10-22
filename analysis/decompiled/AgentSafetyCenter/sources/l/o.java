package l;

import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends n3.d implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public n3.c f7635a;

    /* renamed from: b, reason: collision with root package name */
    public ActionProvider f7636b;

    @Override // n3.d
    public final boolean a() {
        return this.f7636b.hasSubMenu();
    }

    @Override // n3.d
    public final boolean b() {
        return this.f7636b.isVisible();
    }

    @Override // n3.d
    public final View c(h3.b bVar) {
        return this.f7636b.onCreateActionView(bVar);
    }

    @Override // n3.d
    public final boolean d() {
        return this.f7636b.onPerformDefaultAction();
    }

    @Override // n3.d
    public final void e(SubMenu subMenu) {
        this.f7636b.onPrepareSubMenu(subMenu);
    }

    @Override // n3.d
    public final boolean f() {
        return this.f7636b.overridesItemVisibility();
    }

    @Override // n3.d
    public final void g(n3.c cVar) {
        this.f7635a = cVar;
        this.f7636b.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z10) {
        n3.c cVar = this.f7635a;
        if (cVar != null) {
            cVar.m();
        }
    }
}
