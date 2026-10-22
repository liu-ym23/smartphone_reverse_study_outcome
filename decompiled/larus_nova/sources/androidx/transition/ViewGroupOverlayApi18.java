package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes17.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    @Override // androidx.transition.ViewOverlayImpl
    public void clear() {
        this.mViewGroupOverlay.clear();
    }

    public ViewGroupOverlayApi18(ViewGroup r100) {
        this.mViewGroupOverlay = r100.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r100) {
        this.mViewGroupOverlay.add(r100);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r100) {
        this.mViewGroupOverlay.remove(r100);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View r100) {
        this.mViewGroupOverlay.add(r100);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View r100) {
        this.mViewGroupOverlay.remove(r100);
    }
}
