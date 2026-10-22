package k;

import K.AbstractC0072d;
import K.InterfaceC0071c;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: k.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ActionProviderVisibilityListenerC0664r extends AbstractC0072d implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0071c f13295a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionProvider f13296b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MenuItemC0668v f13297c;

    public ActionProviderVisibilityListenerC0664r(MenuItemC0668v menuItemC0668v, ActionProvider actionProvider) {
        this.f13297c = menuItemC0668v;
        this.f13296b = actionProvider;
    }

    @Override // K.AbstractC0072d
    public final boolean a() {
        return this.f13296b.hasSubMenu();
    }

    @Override // K.AbstractC0072d
    public final boolean b() {
        return this.f13296b.isVisible();
    }

    @Override // K.AbstractC0072d
    public final View c(MenuItem menuItem) {
        return this.f13296b.onCreateActionView(menuItem);
    }

    @Override // K.AbstractC0072d
    public final boolean d() {
        return this.f13296b.onPerformDefaultAction();
    }

    @Override // K.AbstractC0072d
    public final void e(SubMenu subMenu) {
        this.f13297c.getClass();
        this.f13296b.onPrepareSubMenu(subMenu);
    }

    @Override // K.AbstractC0072d
    public final boolean f() {
        return this.f13296b.overridesItemVisibility();
    }

    @Override // K.AbstractC0072d
    public final void g(InterfaceC0071c interfaceC0071c) {
        this.f13295a = interfaceC0071c;
        this.f13296b.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z4) {
        InterfaceC0071c interfaceC0071c = this.f13295a;
        if (interfaceC0071c != null) {
            interfaceC0071c.h();
        }
    }
}
