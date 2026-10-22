package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import l8.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SimpleAdaptiveTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public float f7034a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements i.b {
        public a() {
        }

        @Override // l8.i.b
        public final void a(TextView textView, int i10, int i11) {
            SimpleAdaptiveTextView.a(SimpleAdaptiveTextView.this, i10, i11);
        }

        @Override // l8.i.b
        public final void b(TextView textView, float f8) {
            SimpleAdaptiveTextView.b(SimpleAdaptiveTextView.this, f8);
        }
    }

    public SimpleAdaptiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f7034a = getTextSize();
        setFallbackLineSpacing(false);
    }

    public static void a(SimpleAdaptiveTextView simpleAdaptiveTextView, int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public static void b(SimpleAdaptiveTextView simpleAdaptiveTextView, float f8) {
        super.setTextSize(0, f8);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.setTextSize(0, this.f7034a);
        super.onMeasure(i10, i11);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        l8.i.a(this, getMeasuredWidth(), new a());
        super.onMeasure(i10, iMakeMeasureSpec);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i10, float f8) {
        super.setTextSize(i10, f8);
        this.f7034a = TypedValue.applyDimension(i10, f8, getContext().getResources().getDisplayMetrics());
    }
}
