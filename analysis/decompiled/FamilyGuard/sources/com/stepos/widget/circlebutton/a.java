package com.stepos.widget.circlebutton;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import j4.k;

/* loaded from: classes.dex */
final class a implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f16126a;

    public a(int i5) {
        this.f16126a = i5;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i5, int i6, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        int i9;
        k.g(fontMetricsInt, "fm");
        int i10 = fontMetricsInt.descent;
        int i11 = fontMetricsInt.ascent;
        int i12 = i10 - i11;
        if (i12 <= 0 || (i9 = this.f16126a) <= 0) {
            return;
        }
        int i13 = i9 - i12;
        int i14 = i13 / 2;
        fontMetricsInt.ascent = i11 - i14;
        fontMetricsInt.descent = i10 + (i13 - i14);
    }
}
