package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f6934a;

    /* renamed from: b, reason: collision with root package name */
    public int f6935b;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6934a = Integer.MAX_VALUE;
        this.f6935b = Integer.MAX_VALUE;
    }

    public int getMaxHeight() {
        return this.f6934a;
    }

    public int getMaxWidth() {
        return this.f6935b;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        boolean z;
        super.onMeasure(i10, i11);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i12 = this.f6934a;
        boolean z3 = true;
        if (measuredHeight > i12) {
            i11 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            z = true;
        } else {
            z = false;
        }
        int i13 = this.f6935b;
        if (measuredWidth > i13) {
            i10 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else {
            z3 = z;
        }
        if (z3) {
            super.onMeasure(i10, i11);
        }
    }

    public void setMaxHeight(int i10) {
        this.f6934a = i10;
    }

    public void setMaxWidth(int i10) {
        this.f6935b = i10;
    }
}
