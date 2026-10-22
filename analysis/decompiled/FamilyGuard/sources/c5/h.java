package c5;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.AbstractC0457b;
import c5.g;

/* loaded from: classes.dex */
class h extends g {

    class a extends g.a implements ActionProvider.VisibilityListener {

        /* renamed from: f, reason: collision with root package name */
        AbstractC0457b.InterfaceC0123b f12014f;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean b() {
            return this.f12009d.isVisible();
        }

        @Override // androidx.core.view.AbstractC0457b
        public View d(MenuItem menuItem) {
            return this.f12009d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0457b
        public boolean g() {
            return this.f12009d.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC0457b
        public void j(AbstractC0457b.InterfaceC0123b interfaceC0123b) {
            this.f12014f = interfaceC0123b;
            ActionProvider actionProvider = this.f12009d;
            if (interfaceC0123b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z5) {
            AbstractC0457b.InterfaceC0123b interfaceC0123b = this.f12014f;
            if (interfaceC0123b != null) {
                interfaceC0123b.onActionProviderVisibilityChanged(z5);
            }
        }
    }

    h(Context context, A.b bVar) {
        super(context, bVar);
    }

    @Override // c5.g
    g.a h(ActionProvider actionProvider) {
        return new a(this.f12004b, actionProvider);
    }
}
