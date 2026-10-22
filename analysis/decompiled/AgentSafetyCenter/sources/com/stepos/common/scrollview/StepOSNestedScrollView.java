package com.stepos.common.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import ve.d;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSNestedScrollView extends NestedScrollView {
    public final d K;
    public boolean L;

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.L = false;
        this.K = new d(context, this, null, 1);
        setOverScrollMode(2);
    }

    @Override // androidx.core.widget.NestedScrollView
    public final void e(int i) {
        super.e(i);
        this.K.f(0, i);
    }

    public d getSpringAnimationHelper() {
        return this.K;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (!this.K.n(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null && this.L) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setBottomOverScrollEnable(boolean z10) {
        this.K.f14933l = z10;
    }

    public void setOverScrollEnable(boolean z10) {
        this.K.f14931j = z10;
    }

    public void setShouldRequestDisallowInterceptTouchEventWhenOverScroll(boolean z10) {
        this.L = z10;
    }

    public void setTopOverScrollEnable(boolean z10) {
        this.K.f14932k = z10;
    }

    public StepOSNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StepOSNestedScrollView(Context context) {
        this(context, null);
    }
}
