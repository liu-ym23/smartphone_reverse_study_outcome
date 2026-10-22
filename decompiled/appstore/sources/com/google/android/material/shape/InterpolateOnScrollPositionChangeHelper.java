package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class InterpolateOnScrollPositionChangeHelper {
    private final int[] containerLocation;
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final int[] scrollLocation;
    private View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View r10, MaterialShapeDrawable r11, ScrollView r12) {
        this.scrollLocation = new int[2];
        this.containerLocation = new int[2];
        this.scrollChangedListener = new AnonymousClass1(this);
        this.shapedView = r10;
        this.materialShapeDrawable = r11;
        this.containingScrollView = r12;
    }

    public void setContainingScrollView(ScrollView r10) {
        this.containingScrollView = r10;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable r10) {
        this.materialShapeDrawable = r10;
    }

    public void startListeningForScrollChanges(@NonNull ViewTreeObserver r10) {
        r10.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(@NonNull ViewTreeObserver r10) {
        r10.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView r10 = this.containingScrollView;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getChildCount() == 0) goto L18;
        this.containingScrollView.getLocationInWindow(this.scrollLocation);
        this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
        int r11 = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
        int r12 = this.shapedView.getHeight();
        int r13 = this.containingScrollView.getHeight();
        if (r11 >= 0) goto L10;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, (r11 / r12) + 1.0f)));
        this.shapedView.invalidate();
        return;
    L10:
        int r14 = r11 + r12;
        if (r14 <= r13) goto L14;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r14 - r13) / r12))));
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
