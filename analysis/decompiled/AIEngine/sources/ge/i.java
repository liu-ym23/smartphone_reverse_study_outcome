package ge;

import android.annotation.TargetApi;
import android.view.ActionProvider;
import android.view.View;
import ge.h;
import v0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@TargetApi(16)
/* loaded from: classes.dex */
public final class i extends h {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends h.a implements ActionProvider.VisibilityListener {

        /* renamed from: d, reason: collision with root package name */
        public b.a f9174d;

        @Override // v0.b
        public final boolean b() {
            return this.f9169b.isVisible();
        }

        @Override // v0.b
        public final View d(p0.b bVar) {
            return this.f9169b.onCreateActionView(bVar);
        }

        @Override // v0.b
        public final boolean g() {
            return this.f9169b.overridesItemVisibility();
        }

        @Override // v0.b
        public final void h(b.a aVar) {
            this.f9174d = aVar;
            this.f9169b.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public final void onActionProviderVisibilityChanged(boolean z) {
            b.a aVar = this.f9174d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // ge.h
    public final h.a e(ActionProvider actionProvider) {
        return new a(actionProvider);
    }
}
