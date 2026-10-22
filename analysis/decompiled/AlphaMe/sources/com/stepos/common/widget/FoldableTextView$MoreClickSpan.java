package com.stepos.common.widget;

import android.annotation.SuppressLint;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes.dex */
class FoldableTextView$MoreClickSpan extends TypefaceSpan {
    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(textPaint.linkColor);
    }
}
