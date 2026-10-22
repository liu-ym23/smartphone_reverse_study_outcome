package com.stepos.common.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import ie.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class StepOSNestedScrollView extends NestedScrollView {
    public final d J;
    public boolean K;

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.K = false;
        this.J = new d(context, this, null, 1);
        setOverScrollMode(2);
    }

    @Override // androidx.core.widget.NestedScrollView
    public final void e(int i10) {
        super.e(i10);
        this.J.f(0, i10);
    }

    public d getSpringAnimationHelper() {
        return this.J;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.J.n(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.K) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setBottomOverScrollEnable(boolean z) {
        this.J.f9607l = z;
    }

    public void setOverScrollEnable(boolean z) {
        this.J.f9605j = z;
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z) {
        this.K = z;
    }

    public void setTopOverScrollEnable(boolean z) {
        this.J.f9606k = z;
    }
}
