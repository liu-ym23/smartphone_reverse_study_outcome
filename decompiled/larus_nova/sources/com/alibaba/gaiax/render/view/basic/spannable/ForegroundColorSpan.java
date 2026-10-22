package com.alibaba.gaiax.render.view.basic.spannable;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes28.dex */
public class ForegroundColorSpan extends MetricAffectingSpan {
    private final int mColor;

    public int getForegroundColor() {
        return this.mColor;
    }

    public ForegroundColorSpan(int r100) {
        this.mColor = r100;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        r100.setColor(this.mColor);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r100) {
        r100.setColor(this.mColor);
    }
}
