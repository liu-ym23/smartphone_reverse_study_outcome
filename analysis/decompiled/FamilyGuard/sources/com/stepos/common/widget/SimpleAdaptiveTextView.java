package com.stepos.common.widget;

import N1.l;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SimpleAdaptiveTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private float f14175a;

    class a implements l.b {
        a() {
        }

        @Override // N1.l.b
        public void a(TextView textView, int i5, int i6) {
            SimpleAdaptiveTextView.this.c(i5, i6);
        }

        @Override // N1.l.b
        public void b(TextView textView, int i5, float f5) {
            SimpleAdaptiveTextView.this.d(i5, f5);
        }
    }

    public SimpleAdaptiveTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setFallbackLineSpacing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i5, float f5) {
        super.setTextSize(i5, f5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.setTextSize(0, this.f14175a);
        super.onMeasure(i5, i6);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        N1.l.b(this, getMeasuredWidth(), new a());
        super.onMeasure(i5, iMakeMeasureSpec);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i5, float f5) {
        super.setTextSize(i5, f5);
        this.f14175a = TypedValue.applyDimension(i5, f5, getContext().getResources().getDisplayMetrics());
    }

    public SimpleAdaptiveTextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14175a = getTextSize();
    }
}
