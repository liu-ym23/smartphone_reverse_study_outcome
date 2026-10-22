package stepos.support.v7.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* renamed from: stepos.support.v7.app.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1969s implements ContentFrameLayout.OnAttachListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1975y f6338a;

    public C1969s(AbstractC1975y abstractC1975y) {
        this.f6338a = abstractC1975y;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public final void onAttachedFromWindow() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public final void onDetachedFromWindow() {
        AbstractC1975y abstractC1975y = this.f6338a;
        stepos.support.v7.widget.H h = abstractC1975y.f6362q;
        if (h != null) {
            h.dismissPopups();
        }
        if (abstractC1975y.f6366v != null) {
            abstractC1975y.b.getDecorView().removeCallbacks(abstractC1975y.f6367w);
            if (abstractC1975y.f6366v.isShowing()) {
                try {
                    abstractC1975y.f6366v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            abstractC1975y.f6366v = null;
        }
        abstractC1975y.t();
        Va.n nVar = abstractC1975y.v(0).h;
        if (nVar != null) {
            nVar.c(true);
        }
    }
}
