package L3;

import K.InterfaceC0071c;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes2.dex */
public final class r extends m implements ActionProvider.VisibilityListener {

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0071c f1337c;

    @Override // K.AbstractC0072d
    public final boolean b() {
        return this.f1331a.isVisible();
    }

    @Override // K.AbstractC0072d
    public final View c(MenuItem menuItem) {
        return this.f1331a.onCreateActionView(menuItem);
    }

    @Override // K.AbstractC0072d
    public final boolean f() {
        return this.f1331a.overridesItemVisibility();
    }

    @Override // K.AbstractC0072d
    public final void g(InterfaceC0071c interfaceC0071c) {
        this.f1337c = interfaceC0071c;
        this.f1331a.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z4) {
        InterfaceC0071c interfaceC0071c = this.f1337c;
        if (interfaceC0071c != null) {
            interfaceC0071c.h();
        }
    }
}
