package com.stepos.core.ota.confirmui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MaxHeightScrollView extends ScrollView {
    private int maxHeightPx;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MaxHeightScrollView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.g.f(context, "context");
    }

    public final int getMaxHeightPx() {
        return this.maxHeightPx;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.maxHeightPx;
        if (i12 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
    }

    public final void setMaxHeightPx(int i10) {
        this.maxHeightPx = i10;
    }

    public /* synthetic */ MaxHeightScrollView(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.e eVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.g.f(context, "context");
    }
}
