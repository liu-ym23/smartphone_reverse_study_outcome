package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class SimpleAdaptiveTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public float f11781a;

    public SimpleAdaptiveTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11781a = getTextSize();
        setFallbackLineSpacing(false);
    }

    public static void a(SimpleAdaptiveTextView simpleAdaptiveTextView, int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    public static void b(SimpleAdaptiveTextView simpleAdaptiveTextView, float f4) {
        super.setTextSize(0, f4);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.setTextSize(0, this.f11781a);
        super.onMeasure(i4, i5);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        m2.o.a(this, getMeasuredWidth(), new com.google.android.gms.common.api.internal.p(18, this));
        super.onMeasure(i4, iMakeMeasureSpec);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i4, float f4) {
        super.setTextSize(i4, f4);
        this.f11781a = TypedValue.applyDimension(i4, f4, getContext().getResources().getDisplayMetrics());
    }
}
