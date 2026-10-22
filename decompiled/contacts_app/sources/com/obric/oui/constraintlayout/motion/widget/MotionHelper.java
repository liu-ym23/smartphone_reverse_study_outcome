package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public boolean isDecorator() {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onFinishedMotionScene(MotionLayout r1) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onPostDraw(Canvas r1) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreDraw(Canvas r1) {
    }

    public void onPreSetup(MotionLayout r1, HashMap<View, MotionController> r2) {
    }

    public void onTransitionChange(MotionLayout r1, int r2, int r3, float r4) {
    }

    public void onTransitionCompleted(MotionLayout r1, int r2) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout r1, int r2, int r3) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout r1, int r2, boolean r3, float r4) {
    }

    public void setProgress(View r1, float r2) {
    }

    public MotionHelper(Context r1) {
        super(r1);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    public MotionHelper(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r2);
    }

    public MotionHelper(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r2);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r5) {
        super.init(r5);
        if (r5 == null) goto L19;
        TypedArray r6 = getContext().obtainStyledAttributes(r5, R.styleable.MotionHelper);
        int r0 = r6.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r6.getIndex(r1);
        if (r2 != R.styleable.MotionHelper_onShow) goto L10;
        this.mUseOnShow = r6.getBoolean(r2, this.mUseOnShow);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != R.styleable.MotionHelper_onHide) goto L12;
        this.mUseOnHide = r6.getBoolean(r2, this.mUseOnHide);
        goto L12
    L13:
        r6.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.mProgress;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Animatable
    public void setProgress(float r6) {
        this.mProgress = r6;
        int r1 = 0;
        if (this.mCount <= 0) goto L8;
        this.views = getViews((ConstraintLayout) getParent());
    L6:
        if (r1 >= this.mCount) goto L15;
        setProgress(this.views[r1], r6);
        r1 = r1 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r0 = (ViewGroup) getParent();
        int r2 = r0.getChildCount();
    L9:
        if (r1 >= r2) goto L20;
        View r3 = r0.getChildAt(r1);
        if ((r3 instanceof MotionHelper) == true) goto L14;
        setProgress(r3, r6);
    L14:
        r1 = r1 + 1;
        goto L9
    }
}
