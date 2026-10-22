package stepos.support.v7.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m implements ContentFrameLayout.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImplV7 f12153a;

    public m(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f12153a = appCompatDelegateImplV7;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public final void onDetachedFromWindow() {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f12153a;
        stepos.support.v7.widget.j jVar = appCompatDelegateImplV7.f11990q;
        if (jVar != null) {
            jVar.n();
        }
        if (appCompatDelegateImplV7.f11994v != null) {
            appCompatDelegateImplV7.f12126b.getDecorView().removeCallbacks(appCompatDelegateImplV7.f11995w);
            if (appCompatDelegateImplV7.f11994v.isShowing()) {
                try {
                    appCompatDelegateImplV7.f11994v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            appCompatDelegateImplV7.f11994v = null;
        }
        appCompatDelegateImplV7.r();
        stepos.support.v7.view.menu.c cVar = appCompatDelegateImplV7.t(0).h;
        if (cVar != null) {
            cVar.c(true);
        }
    }
}
