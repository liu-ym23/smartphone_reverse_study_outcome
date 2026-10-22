package com.stepos.common.scrollview;

import Lc.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
public class StepOSNestedScrollView extends NestedScrollView {
    private boolean mShouldRequestDisallow;
    private final c mSpringAnimationHelper;

    public interface a extends Lc.a {
    }

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void W(a aVar) {
        this.mSpringAnimationHelper.q(aVar);
    }

    public boolean X() {
        return this.mSpringAnimationHelper.Q();
    }

    public c getSpringAnimationHelper() {
        return this.mSpringAnimationHelper;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.mSpringAnimationHelper.Y(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.mShouldRequestDisallow) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView
    public void p(int i10) {
        super.p(i10);
        this.mSpringAnimationHelper.C(0, i10);
    }

    public void setBottomOverScrollEnable(boolean z10) {
        this.mSpringAnimationHelper.b0(z10);
    }

    public void setOverScrollEnable(boolean z10) {
        this.mSpringAnimationHelper.g0(z10);
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z10) {
        this.mShouldRequestDisallow = z10;
    }

    public void setTopOverScrollEnable(boolean z10) {
        this.mSpringAnimationHelper.j0(z10);
    }

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mShouldRequestDisallow = false;
        this.mSpringAnimationHelper = new c(context, this, null, 1);
        setOverScrollMode(2);
    }
}
