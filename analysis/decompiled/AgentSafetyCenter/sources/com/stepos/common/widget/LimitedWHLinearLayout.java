package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class LimitedWHLinearLayout extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public int f2607c;

    /* renamed from: f, reason: collision with root package name */
    public int f2608f;

    public LimitedWHLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2607c = Reader.READ_DONE;
        this.f2608f = Reader.READ_DONE;
    }

    public int getMaxHeight() {
        return this.f2607c;
    }

    public int getMaxWidth() {
        return this.f2608f;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LimitedWHLinearLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        boolean z10;
        super.onMeasure(i, i3);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int i10 = this.f2607c;
        boolean z11 = true;
        if (measuredHeight > i10) {
            i3 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = this.f2608f;
        if (measuredWidth > i11) {
            i = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        } else {
            z11 = z10;
        }
        if (z11) {
            super.onMeasure(i, i3);
        }
    }

    public void setMaxHeight(int i) {
        this.f2607c = i;
    }

    public void setMaxWidth(int i) {
        this.f2608f = i;
    }

    public LimitedWHLinearLayout(Context context) {
        super(context);
        this.f2607c = Reader.READ_DONE;
        this.f2608f = Reader.READ_DONE;
    }
}
