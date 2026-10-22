package com.stepos.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* loaded from: classes3.dex */
public class SimpleAdaptiveTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public float f3765a;

    public SimpleAdaptiveTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3765a = getTextSize();
        setFallbackLineSpacing(false);
    }

    public static void a(SimpleAdaptiveTextView simpleAdaptiveTextView, int i, int i6) {
        super.onMeasure(i, i6);
    }

    public static void b(SimpleAdaptiveTextView simpleAdaptiveTextView, float f) {
        super.setTextSize(0, f);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i6) {
        super.setTextSize(0, this.f3765a);
        super.onMeasure(i, i6);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY);
        a5.l.a(this, getMeasuredWidth(), new A0.b(this, 4));
        super.onMeasure(i, iMakeMeasureSpec);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.f3765a = TypedValue.applyDimension(i, f, getContext().getResources().getDisplayMetrics());
    }
}
