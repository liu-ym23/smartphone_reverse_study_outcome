package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends MetricAffectingSpan implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f50985f;

    public c(int r100) {
        this.f50985f = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        r100.baselineShift += this.f50985f;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Paint.FontMetricsInt r101 = r100.getFontMetricsInt();
        int r102 = r101.top;
        int r103 = this.f50985f;
        this.f50980a = r102 + r103;
        this.f50981b = r101.ascent + r103;
        this.f50982c = r101.descent + r103;
        this.f50983d = r101.bottom + r103;
        this.f50984e = true;
        r100.baselineShift += r103;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        if ((r100 instanceof Spanned) == false) goto L9;
        Spanned r106 = (Spanned) r100;
        int r107 = r106.getSpanStart(this);
        int r108 = r106.getSpanEnd(this);
        if (r107 < 0) goto L8;
        if (r107 >= r102) goto L26;
        if (r108 > r101) goto L9;
        return;
    L26:
        return;
    L8:
        return;
    L9:
        int r109 = this.f50985f;
        if (r109 >= 0) goto L13;
        if (r101 <= 0) goto L13;
        return;
    L13:
        if (r109 <= 0) goto L18;
        if (r102 >= r100.length()) goto L18;
        return;
    L18:
        if (this.f50984e == false) goto L30;
        int r110 = this.f50985f;
        if (r110 >= 0) goto L23;
        r105.top = Math.min(r105.top, this.f50980a);
        r105.ascent = Math.min(r105.ascent, this.f50981b);
        return;
    L23:
        if (r110 <= 0) goto L29;
        r105.descent = Math.max(r105.descent, this.f50982c);
        r105.bottom = Math.max(r105.bottom, this.f50983d);
        return;
    L29:
        return;
    }
}
