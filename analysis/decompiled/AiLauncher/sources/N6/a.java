package N6;

import Lc.c;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public class a extends ScrollView {
    private boolean mShouldRequestDisallow;
    private final c mSpringAnimationHelper;

    public boolean a() {
        return this.mSpringAnimationHelper.Q();
    }

    @Override // android.widget.ScrollView
    public void fling(int i10) {
        super.fling(i10);
        this.mSpringAnimationHelper.C(0, i10);
    }

    public c getSpringAnimationHelper() {
        return this.mSpringAnimationHelper;
    }

    @Override // android.widget.ScrollView, android.view.View
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
}
