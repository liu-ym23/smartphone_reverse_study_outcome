package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class j<V extends View> extends CoordinatorLayout.c<V> {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private k viewOffsetHelper;

    public j() {
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int g() {
        return getTopAndBottomOffset();
    }

    public int getLeftAndRightOffset() {
        k kVar = this.viewOffsetHelper;
        if (kVar != null) {
            return kVar.f4605e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        k kVar = this.viewOffsetHelper;
        if (kVar != null) {
            return kVar.f4604d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        k kVar = this.viewOffsetHelper;
        return kVar != null && kVar.f4607g;
    }

    public boolean isVerticalOffsetEnabled() {
        k kVar = this.viewOffsetHelper;
        return kVar != null && kVar.f4606f;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
        coordinatorLayout.B(i10, v3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
        layoutChild(coordinatorLayout, v3, i10);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new k(v3);
        }
        k kVar = this.viewOffsetHelper;
        View view = kVar.f4601a;
        kVar.f4602b = view.getTop();
        kVar.f4603c = view.getLeft();
        this.viewOffsetHelper.a();
        int i11 = this.tempTopBottomOffset;
        if (i11 != 0) {
            k kVar2 = this.viewOffsetHelper;
            if (kVar2.f4606f && kVar2.f4604d != i11) {
                kVar2.f4604d = i11;
                kVar2.a();
            }
            this.tempTopBottomOffset = 0;
        }
        int i12 = this.tempLeftRightOffset;
        if (i12 == 0) {
            return true;
        }
        k kVar3 = this.viewOffsetHelper;
        if (kVar3.f4607g && kVar3.f4605e != i12) {
            kVar3.f4605e = i12;
            kVar3.a();
        }
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        k kVar = this.viewOffsetHelper;
        if (kVar != null) {
            kVar.f4607g = z;
        }
    }

    public boolean setLeftAndRightOffset(int i10) {
        k kVar = this.viewOffsetHelper;
        if (kVar == null) {
            this.tempLeftRightOffset = i10;
            return false;
        }
        if (!kVar.f4607g || kVar.f4605e == i10) {
            return false;
        }
        kVar.f4605e = i10;
        kVar.a();
        return true;
    }

    public boolean setTopAndBottomOffset(int i10) {
        k kVar = this.viewOffsetHelper;
        if (kVar == null) {
            this.tempTopBottomOffset = i10;
            return false;
        }
        if (!kVar.f4606f || kVar.f4604d == i10) {
            return false;
        }
        kVar.f4604d = i10;
        kVar.a();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        k kVar = this.viewOffsetHelper;
        if (kVar != null) {
            kVar.f4606f = z;
        }
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
