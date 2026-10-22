package com.stepos.common.datetimepicker.date;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* loaded from: classes.dex */
public class CustomTypefaceSpan extends TypefaceSpan {
    public static void c(Paint paint) {
        Typeface typeface = paint.getTypeface();
        if (typeface != null) {
            typeface.getStyle();
        }
        throw null;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        c(textPaint);
        throw null;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        c(textPaint);
        throw null;
    }
}
