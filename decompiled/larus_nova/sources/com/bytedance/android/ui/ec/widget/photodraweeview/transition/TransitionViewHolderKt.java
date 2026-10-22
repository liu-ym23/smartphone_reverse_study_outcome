package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"findTransitionPhotoView", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPhotoDraweeView;", "Landroid/view/View;", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class TransitionViewHolderKt {
    public static final /* synthetic */ TransitionPhotoDraweeView access$findTransitionPhotoView(View r100) {
        return findTransitionPhotoView(r100);
    }

    private static final TransitionPhotoDraweeView findTransitionPhotoView(View r100) {
        if ((r100 instanceof TransitionPhotoDraweeView) == false) goto L7;
        return (TransitionPhotoDraweeView) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        TransitionPhotoDraweeView r104 = findTransitionPhotoView(r101.getChildAt(r103));
        if ((r104 instanceof TransitionPhotoDraweeView) == true) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r104;
    L14:
        return null;
    }
}
