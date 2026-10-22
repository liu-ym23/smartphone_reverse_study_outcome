package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes3.dex */
public abstract class k extends CoordinatorLayout.Behavior {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private l viewOffsetHelper;

    public k() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        l lVar = this.viewOffsetHelper;
        if (lVar != null) {
            return lVar.e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        l lVar = this.viewOffsetHelper;
        if (lVar != null) {
            return lVar.d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        l lVar = this.viewOffsetHelper;
        return lVar != null && lVar.g;
    }

    public boolean isVerticalOffsetEnabled() {
        l lVar = this.viewOffsetHelper;
        return lVar != null && lVar.f;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.onLayoutChild(view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        layoutChild(coordinatorLayout, view, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new l(view);
        }
        l lVar = this.viewOffsetHelper;
        View view2 = lVar.f2295a;
        lVar.b = view2.getTop();
        lVar.c = view2.getLeft();
        this.viewOffsetHelper.a();
        int i6 = this.tempTopBottomOffset;
        if (i6 != 0) {
            l lVar2 = this.viewOffsetHelper;
            if (lVar2.f && lVar2.d != i6) {
                lVar2.d = i6;
                lVar2.a();
            }
            this.tempTopBottomOffset = 0;
        }
        int i10 = this.tempLeftRightOffset;
        if (i10 == 0) {
            return true;
        }
        l lVar3 = this.viewOffsetHelper;
        if (lVar3.g && lVar3.e != i10) {
            lVar3.e = i10;
            lVar3.a();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z10) {
        l lVar = this.viewOffsetHelper;
        if (lVar != null) {
            lVar.g = z10;
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        l lVar = this.viewOffsetHelper;
        if (lVar == null) {
            this.tempLeftRightOffset = i;
            return false;
        }
        if (!lVar.g || lVar.e == i) {
            return false;
        }
        lVar.e = i;
        lVar.a();
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        l lVar = this.viewOffsetHelper;
        if (lVar == null) {
            this.tempTopBottomOffset = i;
            return false;
        }
        if (!lVar.f || lVar.d == i) {
            return false;
        }
        lVar.d = i;
        lVar.a();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z10) {
        l lVar = this.viewOffsetHelper;
        if (lVar != null) {
            lVar.f = z10;
        }
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
