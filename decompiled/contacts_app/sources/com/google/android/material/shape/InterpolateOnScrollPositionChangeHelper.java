package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class InterpolateOnScrollPositionChangeHelper {
    private final int[] containerLocation;
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final int[] scrollLocation;
    private View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View r3, MaterialShapeDrawable r4, ScrollView r5) {
        this.scrollLocation = new int[2];
        this.containerLocation = new int[2];
        this.scrollChangedListener = new AnonymousClass1(this);
        this.shapedView = r3;
        this.materialShapeDrawable = r4;
        this.containingScrollView = r5;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable r1) {
        this.materialShapeDrawable = r1;
    }

    public void setContainingScrollView(ScrollView r1) {
        this.containingScrollView = r1;
    }

    public void startListeningForScrollChanges(ViewTreeObserver r1) {
        r1.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(ViewTreeObserver r1) {
        r1.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView r0 = this.containingScrollView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getChildCount() == 0) goto L18;
        this.containingScrollView.getLocationInWindow(this.scrollLocation);
        this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
        int r1 = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
        int r2 = this.shapedView.getHeight();
        int r3 = this.containingScrollView.getHeight();
        if (r1 >= 0) goto L10;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, (r1 / r2) + 1.0f)));
        this.shapedView.invalidate();
        return;
    L10:
        int r4 = r1 + r2;
        if (r4 <= r3) goto L14;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r4 - r3) / r2))));
        this.shapedView.invalidate();
        return;
    L14:
        if (this.materialShapeDrawable.getInterpolation() == 1.0f) goto L21;
        this.materialShapeDrawable.setInterpolation(1.0f);
        this.shapedView.invalidate();
        return;
    L21:
        return;
    L18:
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}
