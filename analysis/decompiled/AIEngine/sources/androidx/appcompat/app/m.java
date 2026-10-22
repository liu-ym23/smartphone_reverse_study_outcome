package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.d0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m implements ContentFrameLayout.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f343a;

    public m(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f343a = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public final void onDetachedFromWindow() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f343a;
        d0 d0Var = appCompatDelegateImpl.f277u;
        if (d0Var != null) {
            d0Var.n();
        }
        if (appCompatDelegateImpl.z != null) {
            appCompatDelegateImpl.f272o.getDecorView().removeCallbacks(appCompatDelegateImpl.A);
            if (appCompatDelegateImpl.z.isShowing()) {
                try {
                    appCompatDelegateImpl.z.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            appCompatDelegateImpl.z = null;
        }
        h0 h0Var = appCompatDelegateImpl.B;
        if (h0Var != null) {
            h0Var.b();
        }
        androidx.appcompat.view.menu.f fVar = appCompatDelegateImpl.E(0).h;
        if (fVar != null) {
            fVar.c(true);
        }
    }
}
