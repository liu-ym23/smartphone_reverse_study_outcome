package com.bytedanceos.common.ui.animation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import com.bytedanceos.common.R$id;

/* JADX INFO: loaded from: classes2.dex */
public class SqueezeAnimation extends Animation {
    private final int mMeasuredHeight;
    private final View mView;

    public SqueezeAnimation(View r10, int r11) {
        this.mView = r10;
        this.mMeasuredHeight = r11;
        r10.setTag(R$id.convert_view_discarded, Boolean.TRUE);
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float r10, Transformation r11) {
        int r12 = this.mMeasuredHeight;
        int r13 = r12 - ((int) (r12 * r10));
        ViewGroup.LayoutParams r14 = this.mView.getLayoutParams();
        if (r10 != 1.0f) goto L6;
        r14.height = 1;
        this.mView.setVisibility(8);
    L8:
        this.mView.requestLayout();
        return;
    L6:
        if (r14.height == r13) goto L8;
        r14.height = r13;
        goto L8
    }

    @Override // android.view.animation.Animation
    public void initialize(int r10, int r11, int r12, int r13) {
        super.initialize(r10, r11, r12, r13);
        setDuration(300);
        setInterpolator(new DecelerateInterpolator(1.5f));
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
