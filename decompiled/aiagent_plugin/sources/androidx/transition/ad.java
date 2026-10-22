package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class ad implements ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f2790a;

    ad(View r1) {
        this.f2790a = r1.getOverlay();
    }

    @Override // androidx.transition.ae
    public void a(Drawable r1) {
        this.f2790a.add(r1);
    }

    @Override // androidx.transition.ae
    public void b(Drawable r1) {
        this.f2790a.remove(r1);
    }
}
