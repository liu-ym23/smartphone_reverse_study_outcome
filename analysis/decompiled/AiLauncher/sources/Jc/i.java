package Jc;

import Jc.h;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.AbstractC1314b;
import v0.InterfaceMenuItemC5651b;

@TargetApi(16)
/* loaded from: classes5.dex */
public class i extends h {

    public class a extends h.a implements ActionProvider.VisibilityListener {

        /* renamed from: f, reason: collision with root package name */
        public AbstractC1314b.InterfaceC0160b f3848f;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean b() {
            return this.f3843d.isVisible();
        }

        @Override // androidx.core.view.AbstractC1314b
        public View d(MenuItem menuItem) {
            return this.f3843d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC1314b
        public boolean g() {
            return this.f3843d.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC1314b
        public void j(AbstractC1314b.InterfaceC0160b interfaceC0160b) {
            this.f3848f = interfaceC0160b;
            ActionProvider actionProvider = this.f3843d;
            if (interfaceC0160b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            AbstractC1314b.InterfaceC0160b interfaceC0160b = this.f3848f;
            if (interfaceC0160b != null) {
                interfaceC0160b.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    public i(Context context, InterfaceMenuItemC5651b interfaceMenuItemC5651b) {
        super(context, interfaceMenuItemC5651b);
    }

    @Override // Jc.h
    public h.a h(ActionProvider actionProvider) {
        return new a(this.f3838b, actionProvider);
    }
}
