package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f14022a;

    /* renamed from: b, reason: collision with root package name */
    private int f14023b;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14022a = Integer.MAX_VALUE;
        this.f14023b = Integer.MAX_VALUE;
    }

    public int getMaxHeight() {
        return this.f14022a;
    }

    public int getMaxWidth() {
        return this.f14023b;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        boolean z5;
        super.onMeasure(i5, i6);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i7 = this.f14022a;
        boolean z6 = true;
        if (measuredHeight > i7) {
            i6 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            z5 = true;
        } else {
            z5 = false;
        }
        int i8 = this.f14023b;
        if (measuredWidth > i8) {
            i5 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            z6 = z5;
        }
        if (z6) {
            super.onMeasure(i5, i6);
        }
    }

    public void setMaxHeight(int i5) {
        this.f14022a = i5;
    }

    public void setMaxWidth(int i5) {
        this.f14023b = i5;
    }
}
