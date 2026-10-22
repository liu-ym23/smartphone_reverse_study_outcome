package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes17.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    @Override // androidx.transition.ViewOverlayImpl
    public void clear() {
        this.mViewOverlay.clear();
    }

    public ViewOverlayApi18(View r100) {
        this.mViewOverlay = r100.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable r100) {
        this.mViewOverlay.add(r100);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable r100) {
        this.mViewOverlay.remove(r100);
    }
}
