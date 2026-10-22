package com.stepos.common.widget;

import O6.v;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class SimpleAdaptiveTextView extends TextView {
    private float mTextSize;

    public class a implements v.b {
        public a() {
        }

        @Override // O6.v.b
        public void a(TextView textView, int i10, int i11) {
            SimpleAdaptiveTextView.this.c(i10, i11);
        }

        @Override // O6.v.b
        public void b(TextView textView, int i10, float f10) {
            SimpleAdaptiveTextView.this.d(i10, f10);
        }
    }

    public SimpleAdaptiveTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setFallbackLineSpacing(false);
    }

    @SuppressLint({"WrongCall"})
    public final void c(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public final void d(int i10, float f10) {
        super.setTextSize(i10, f10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.setTextSize(0, this.mTextSize);
        super.onMeasure(i10, i11);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        v.b(this, getMeasuredWidth(), new a());
        super.onMeasure(i10, iMakeMeasureSpec);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        this.mTextSize = TypedValue.applyDimension(i10, f10, getContext().getResources().getDisplayMetrics());
    }

    public SimpleAdaptiveTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mTextSize = getTextSize();
    }
}
