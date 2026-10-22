package com.bytedance.android.shopping.anchorv3.activities.quick.richtext;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* JADX INFO: loaded from: classes12.dex */
class SpanUtils$CustomTypefaceSpan extends TypefaceSpan {
    public static void a(Paint r100) {
        Typeface r101 = r100.getTypeface();
        if (r101 == null) goto L7;
        r101.getStyle();
    L7:
        throw null;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100);
        throw null;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        a(r100);
        throw null;
    }
}
