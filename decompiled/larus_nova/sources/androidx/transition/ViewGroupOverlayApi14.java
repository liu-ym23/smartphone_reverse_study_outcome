package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes17.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    public static ViewGroupOverlayApi14 createFrom(ViewGroup r100) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(r100);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View r100) {
        this.mOverlayViewGroup.add(r100);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View r100) {
        this.mOverlayViewGroup.remove(r100);
    }

    public ViewGroupOverlayApi14(Context r100, ViewGroup r101, View r102) {
        super(r100, r101, r102);
    }
}
