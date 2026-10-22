package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class LimitedWHLinearLayout extends LinearLayout {
    private int mMaxHeight;
    private int mMaxWidth;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mMaxWidth = Integer.MAX_VALUE;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        super.onMeasure(i10, i11);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i12 = this.mMaxHeight;
        boolean z11 = true;
        if (measuredHeight > i12) {
            i11 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = this.mMaxWidth;
        if (measuredWidth > i13) {
            i10 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else {
            z11 = z10;
        }
        if (z11) {
            super.onMeasure(i10, i11);
        }
    }

    public void setMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    public void setMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }
}
