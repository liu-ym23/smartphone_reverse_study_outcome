package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* loaded from: classes3.dex */
public class SquareTextView extends TextView {
    public SquareTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth != measuredHeight) {
            int iMax = Math.max(measuredWidth, measuredHeight);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMax, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(iMax, BasicMeasure.EXACTLY));
        }
    }
}
