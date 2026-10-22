package com.bytedance.android.ec.core.widget.price;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* JADX INFO: loaded from: classes43.dex */
class PriceTypefaceSpan extends TypefaceSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f46119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f46120b;

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100, this.f46119a, this.f46120b);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        a(r100, this.f46119a, this.f46120b);
    }

    public PriceTypefaceSpan(Typeface r100, boolean r101) {
        super("");
        this.f46119a = r100;
        this.f46120b = r101;
    }

    public static void a(Paint r100, Typeface r101, boolean r102) {
        Typeface r103 = r100.getTypeface();
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = r104 & (~r101.getStyle());
        if ((r105 & 1) == 0) goto L11;
        if (r102 == false) goto L11;
        r100.setFakeBoldText(true);
    L11:
        if ((r105 & 2) == 0) goto L13;
        r100.setTextSkewX(-0.25f);
    L13:
        r100.getShader();
        r100.setTypeface(r101);
        return;
    L5:
        r104 = r103.getStyle();
        goto L6
    }
}
