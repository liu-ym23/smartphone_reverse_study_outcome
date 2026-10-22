package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public class e<V extends View> extends CoordinatorLayout.c<V> {
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

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        coordinatorLayout.Q(v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        layoutChild(coordinatorLayout, v10, i10);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new f(v10);
        }
        this.viewOffsetHelper.f();
        this.viewOffsetHelper.a();
        int i11 = this.tempTopBottomOffset;
        if (i11 != 0) {
            this.viewOffsetHelper.i(i11);
            this.tempTopBottomOffset = 0;
        }
        int i12 = this.tempLeftRightOffset;
        if (i12 == 0) {
            return true;
        }
        this.viewOffsetHelper.h(i12);
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            fVar.g(z10);
        }
    }

    public boolean setLeftAndRightOffset(int i10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.h(i10);
        }
        this.tempLeftRightOffset = i10;
        return false;
    }

    public boolean setTopAndBottomOffset(int i10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            return fVar.i(i10);
        }
        this.tempTopBottomOffset = i10;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z10) {
        f fVar = this.viewOffsetHelper;
        if (fVar != null) {
            fVar.j(z10);
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
