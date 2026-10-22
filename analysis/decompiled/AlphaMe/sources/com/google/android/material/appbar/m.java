package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public abstract class m extends A.b {
    private n viewOffsetHelper;
    private int tempTopBottomOffset = 0;
    private int tempLeftRightOffset = 0;

    public m() {
    }

    public int getLeftAndRightOffset() {
        n nVar = this.viewOffsetHelper;
        if (nVar != null) {
            return nVar.f10337e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        n nVar = this.viewOffsetHelper;
        if (nVar != null) {
            return nVar.f10336d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        n nVar = this.viewOffsetHelper;
        return nVar != null && nVar.f10339g;
    }

    public boolean isVerticalOffsetEnabled() {
        n nVar = this.viewOffsetHelper;
        return nVar != null && nVar.f10338f;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        coordinatorLayout.B(i4, view);
    }

    @Override // A.b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        layoutChild(coordinatorLayout, view, i4);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new n(view);
        }
        n nVar = this.viewOffsetHelper;
        View view2 = nVar.f10333a;
        nVar.f10334b = view2.getTop();
        nVar.f10335c = view2.getLeft();
        this.viewOffsetHelper.a();
        int i5 = this.tempTopBottomOffset;
        if (i5 != 0) {
            n nVar2 = this.viewOffsetHelper;
            if (nVar2.f10338f && nVar2.f10336d != i5) {
                nVar2.f10336d = i5;
                nVar2.a();
            }
            this.tempTopBottomOffset = 0;
        }
        int i6 = this.tempLeftRightOffset;
        if (i6 == 0) {
            return true;
        }
        n nVar3 = this.viewOffsetHelper;
        if (nVar3.f10339g && nVar3.f10337e != i6) {
            nVar3.f10337e = i6;
            nVar3.a();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z4) {
        n nVar = this.viewOffsetHelper;
        if (nVar != null) {
            nVar.f10339g = z4;
        }
    }

    public boolean setLeftAndRightOffset(int i4) {
        n nVar = this.viewOffsetHelper;
        if (nVar == null) {
            this.tempLeftRightOffset = i4;
            return false;
        }
        if (!nVar.f10339g || nVar.f10337e == i4) {
            return false;
        }
        nVar.f10337e = i4;
        nVar.a();
        return true;
    }

    public boolean setTopAndBottomOffset(int i4) {
        n nVar = this.viewOffsetHelper;
        if (nVar == null) {
            this.tempTopBottomOffset = i4;
            return false;
        }
        if (!nVar.f10338f || nVar.f10336d == i4) {
            return false;
        }
        nVar.f10336d = i4;
        nVar.a();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z4) {
        n nVar = this.viewOffsetHelper;
        if (nVar != null) {
            nVar.f10338f = z4;
        }
    }

    public m(int i4) {
    }
}
