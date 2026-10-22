package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: compiled from: ViewGroupOverlayApi18.java */
/* JADX INFO: loaded from: classes.dex */
class z implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f2876a;

    z(ViewGroup r1) {
        this.f2876a = r1.getOverlay();
    }

    @Override // androidx.transition.ae
    public void a(Drawable r1) {
        this.f2876a.add(r1);
    }

    @Override // androidx.transition.ae
    public void b(Drawable r1) {
        this.f2876a.remove(r1);
    }

    @Override // androidx.transition.aa
    public void a(View r1) {
        this.f2876a.add(r1);
    }

    @Override // androidx.transition.aa
    public void b(View r1) {
        this.f2876a.remove(r1);
    }
}
