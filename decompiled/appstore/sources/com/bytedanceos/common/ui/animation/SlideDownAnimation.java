package com.bytedanceos.common.ui.animation;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.bytedanceos.common.R$id;

/* JADX INFO: loaded from: classes2.dex */
public class SlideDownAnimation extends Animation {
    private final int mMeasuredHeight;
    private final View mView;

    public SlideDownAnimation(View r10, int r11) {
        this.mView = r10;
        this.mMeasuredHeight = r11;
        r10.setTag(R$id.convert_view_discarded, Boolean.TRUE);
        r10.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        r10.setVisibility(8);
        r10.requestLayout();
    }

    private void clip(View r10, int r11) {
        r10.setClipBounds(new Rect(r10.getLeft(), this.mMeasuredHeight - r11, r10.getRight(), this.mMeasuredHeight + 1));
        r10.setTop(r10.getTop() - (this.mMeasuredHeight - r11));
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float r10, Transformation r11) {
        int r12 = Math.max((int) (this.mMeasuredHeight * r10), 1);
        ViewGroup.LayoutParams r13 = this.mView.getLayoutParams();
        if (r13.height == r12) goto L8;
        r13.height = r12;
        if (r12 <= 1) goto L8;
        clip(this.mView, r12);
    L8:
        if (this.mView.getVisibility() != 8) goto L10;
        this.mView.setVisibility(0);
    L10:
        this.mView.requestLayout();
    }

    @Override // android.view.animation.Animation
    public void initialize(int r10, int r11, int r12, int r13) {
        super.initialize(r10, r11, r12, r13);
        setDuration(300);
        setInterpolator(new DecelerateInterpolator(1.5f));
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return false;
    }
}
