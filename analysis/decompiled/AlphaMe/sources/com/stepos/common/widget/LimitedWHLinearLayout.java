package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f11688a;

    /* renamed from: b, reason: collision with root package name */
    public int f11689b;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11688a = Integer.MAX_VALUE;
        this.f11689b = Integer.MAX_VALUE;
    }

    public int getMaxHeight() {
        return this.f11688a;
    }

    public int getMaxWidth() {
        return this.f11689b;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        boolean z4;
        super.onMeasure(i4, i5);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i6 = this.f11688a;
        boolean z5 = true;
        if (measuredHeight > i6) {
            i5 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            z4 = true;
        } else {
            z4 = false;
        }
        int i7 = this.f11689b;
        if (measuredWidth > i7) {
            i4 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            z5 = z4;
        }
        if (z5) {
            super.onMeasure(i4, i5);
        }
    }

    public void setMaxHeight(int i4) {
        this.f11688a = i4;
    }

    public void setMaxWidth(int i4) {
        this.f11689b = i4;
    }
}
