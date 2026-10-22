package com.stepos.widget.circlebutton;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import j4.k;

/* loaded from: classes.dex */
final class b extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f16127a;

    public b(float f5) {
        this.f16127a = f5;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        k.g(textPaint, "tp");
        textPaint.setLetterSpacing(this.f16127a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        k.g(textPaint, "tp");
        textPaint.setLetterSpacing(this.f16127a);
    }
}
