package Va;

import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.ActionProvider;

/* loaded from: classes4.dex */
public final class w extends r implements ActionProvider.VisibilityListener {
    public ActionProvider.VisibilityListener c;

    @Override // androidx.core.view.ActionProvider
    public final boolean isVisible() {
        return this.f1463a.isVisible();
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z10) {
        ActionProvider.VisibilityListener visibilityListener = this.c;
        if (visibilityListener != null) {
            visibilityListener.onActionProviderVisibilityChanged(z10);
        }
    }

    @Override // androidx.core.view.ActionProvider
    public final View onCreateActionView(MenuItem menuItem) {
        return this.f1463a.onCreateActionView(menuItem);
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean overridesItemVisibility() {
        return this.f1463a.overridesItemVisibility();
    }

    @Override // androidx.core.view.ActionProvider
    public final void refreshVisibility() {
        this.f1463a.refreshVisibility();
    }

    @Override // androidx.core.view.ActionProvider
    public final void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
        this.c = visibilityListener;
        this.f1463a.setVisibilityListener(visibilityListener != null ? this : null);
    }
}
