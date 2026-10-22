package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
public class v implements ViewGroupOverlayImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f5101a;

    public v(ViewGroup r10) {
        this.f5101a = r10.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r10) {
        this.f5101a.add(r10);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r10) {
        this.f5101a.remove(r10);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View r10) {
        this.f5101a.add(r10);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View r10) {
        this.f5101a.remove(r10);
    }
}
