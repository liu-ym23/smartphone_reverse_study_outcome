package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View[] f13557m;

    public MotionHelper(Context r10) {
        super(r10);
        this.f13554j = false;
        this.f13555k = false;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.f13556l;
    }

    public boolean isDecorator() {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUseOnHide() {
        return this.f13555k;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUsedOnShow() {
        return this.f13554j;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet r10) {
        super.k(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.MotionHelper);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.MotionHelper_onShow) goto L10;
        this.f13554j = r11.getBoolean(r14, this.f13554j);
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R$styleable.MotionHelper_onHide) goto L12;
        this.f13555k = r11.getBoolean(r14, this.f13555k);
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onFinishedMotionScene(MotionLayout r10) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onPostDraw(Canvas r10) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreDraw(Canvas r10) {
    }

    public void onPreSetup(MotionLayout r10, HashMap r11) {
    }

    public void onTransitionChange(MotionLayout r10, int r11, int r12, float r13) {
    }

    public void onTransitionCompleted(MotionLayout r10, int r11) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout r10, int r11, int r12) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout r10, int r11, boolean r12, float r13) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.Animatable
    public void setProgress(float r10) {
        this.f13556l = r10;
        int r11 = 0;
        if (this.f14052b <= 0) goto L8;
        this.f13557m = j((ConstraintLayout) getParent());
    L6:
        if (r11 >= this.f14052b) goto L15;
        t(this.f13557m[r11], r10);
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r12 = (ViewGroup) getParent();
        int r13 = r12.getChildCount();
    L9:
        if (r11 >= r13) goto L20;
        View r14 = r12.getChildAt(r11);
        if ((r14 instanceof MotionHelper) == true) goto L14;
        t(r14, r10);
    L14:
        r11 = r11 + 1;
        goto L9
    }

    public void t(View r10, float r11) {
    }

    public MotionHelper(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f13554j = false;
        this.f13555k = false;
        k(r11);
    }

    public MotionHelper(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13554j = false;
        this.f13555k = false;
        k(r11);
    }
}
