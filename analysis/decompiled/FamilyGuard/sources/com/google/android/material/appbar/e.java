package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
class e<V extends View> extends CoordinatorLayout.c<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private f viewOffsetHelper;

    public e() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.b();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.c();
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        f fVar = this.viewOffsetHelper;
        return fVar != null && fVar.d();
    }

    public boolean isVerticalOffsetEnabled() {
        f fVar = this.viewOffsetHelper;
        return fVar != null && fVar.e();
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        coordinatorLayout.W(v5, i5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
        layoutChild(coordinatorLayout, v5, i5);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new f(v5);
        }
        this.viewOffsetHelper.f();
        this.viewOffsetHelper.a();
        int i6 = this.tempTopBottomOffset;
        if (i6 != 0) {
            this.viewOffsetHelper.i(i6);
            this.tempTopBottomOffset = 0;
        }
        int i7 = this.tempLeftRightOffset;
        if (i7 == 0) {
            return true;
        }
        this.viewOffsetHelper.h(i7);
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z5) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            fVar.g(z5);
        }
    }

    public boolean setLeftAndRightOffset(int i5) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.h(i5);
        }
        this.tempLeftRightOffset = i5;
        return false;
    }

    public boolean setTopAndBottomOffset(int i5) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.i(i5);
        }
        this.tempTopBottomOffset = i5;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z5) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            fVar.j(z5);
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
