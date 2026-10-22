package com.google.android.material.appbar;

import android.view.View;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l extends b3.a {
    private m viewOffsetHelper;
    private int tempTopBottomOffset = 0;
    private int tempLeftRightOffset = 0;

    public l() {
    }

    public int getLeftAndRightOffset() {
        m mVar = this.viewOffsetHelper;
        if (mVar != null) {
            return mVar.f2379e;
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        m mVar = this.viewOffsetHelper;
        if (mVar != null) {
            return mVar.f2378d;
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        m mVar = this.viewOffsetHelper;
        return mVar != null && mVar.f2381g;
    }

    public boolean isVerticalOffsetEnabled() {
        m mVar = this.viewOffsetHelper;
        return mVar != null && mVar.f2380f;
    }

    public void layoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        aVar.B(i, view);
    }

    @Override // b3.a
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        layoutChild(aVar, view, i);
        if (this.viewOffsetHelper == null) {
            m mVar = new m();
            mVar.f2380f = true;
            mVar.f2381g = true;
            mVar.f2375a = view;
            VarHandle.storeStoreFence();
            this.viewOffsetHelper = mVar;
        }
        m mVar2 = this.viewOffsetHelper;
        View view2 = mVar2.f2375a;
        mVar2.f2376b = view2.getTop();
        mVar2.f2377c = view2.getLeft();
        this.viewOffsetHelper.a();
        int i3 = this.tempTopBottomOffset;
        if (i3 != 0) {
            m mVar3 = this.viewOffsetHelper;
            if (mVar3.f2380f && mVar3.f2378d != i3) {
                mVar3.f2378d = i3;
                mVar3.a();
            }
            this.tempTopBottomOffset = 0;
        }
        int i10 = this.tempLeftRightOffset;
        if (i10 != 0) {
            m mVar4 = this.viewOffsetHelper;
            if (mVar4.f2381g && mVar4.f2379e != i10) {
                mVar4.f2379e = i10;
                mVar4.a();
            }
            this.tempLeftRightOffset = 0;
        }
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z10) {
        m mVar = this.viewOffsetHelper;
        if (mVar != null) {
            mVar.f2381g = z10;
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        m mVar = this.viewOffsetHelper;
        if (mVar == null) {
            this.tempLeftRightOffset = i;
            return false;
        }
        if (!mVar.f2381g || mVar.f2379e == i) {
            return false;
        }
        mVar.f2379e = i;
        mVar.a();
        return true;
    }

    public boolean setTopAndBottomOffset(int i) {
        m mVar = this.viewOffsetHelper;
        if (mVar == null) {
            this.tempTopBottomOffset = i;
            return false;
        }
        if (!mVar.f2380f || mVar.f2378d == i) {
            return false;
        }
        mVar.f2378d = i;
        mVar.a();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z10) {
        m mVar = this.viewOffsetHelper;
        if (mVar != null) {
            mVar.f2380f = z10;
        }
    }

    public l(int i) {
    }
}
