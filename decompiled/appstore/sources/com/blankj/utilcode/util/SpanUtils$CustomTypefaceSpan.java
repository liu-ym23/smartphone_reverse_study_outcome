package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ParcelCreator"})
class SpanUtils$CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface newType;

    public /* synthetic */ SpanUtils$CustomTypefaceSpan(Typeface r10, f r11) {
        this(r10);
    }

    private void apply(Paint r10, Typeface r11) {
        Typeface r12 = r10.getTypeface();
        if (r12 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = r13 & (~r11.getStyle());
        if ((r14 & 1) == 0) goto L10;
        r10.setFakeBoldText(true);
    L10:
        if ((r14 & 2) == 0) goto L12;
        r10.setTextSkewX(-0.25f);
    L12:
        r10.getShader();
        r10.setTypeface(r11);
        return;
    L5:
        r13 = r12.getStyle();
        goto L6
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r10) {
        apply(r10, this.newType);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r10) {
        apply(r10, this.newType);
    }

    private SpanUtils$CustomTypefaceSpan(Typeface r10) {
        super("");
        this.newType = r10;
    }
}
