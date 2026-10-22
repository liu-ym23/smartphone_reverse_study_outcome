package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* loaded from: classes3.dex */
public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f3721a;
    public int b;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3721a = Integer.MAX_VALUE;
        this.b = Integer.MAX_VALUE;
    }

    public int getMaxHeight() {
        return this.f3721a;
    }

    public int getMaxWidth() {
        return this.b;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        boolean z10;
        super.onMeasure(i, i6);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i10 = this.f3721a;
        boolean z11 = true;
        if (measuredHeight > i10) {
            i6 = View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY);
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = this.b;
        if (measuredWidth > i11) {
            i = View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY);
        } else {
            z11 = z10;
        }
        if (z11) {
            super.onMeasure(i, i6);
        }
    }

    public void setMaxHeight(int i) {
        this.f3721a = i;
    }

    public void setMaxWidth(int i) {
        this.b = i;
    }
}
