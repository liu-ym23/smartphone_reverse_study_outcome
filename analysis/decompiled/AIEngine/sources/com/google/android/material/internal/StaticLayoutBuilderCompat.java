package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StaticLayoutBuilderCompat {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f5040a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f5041b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5042c;

    /* renamed from: d, reason: collision with root package name */
    public int f5043d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5049k;

    /* renamed from: m, reason: collision with root package name */
    public com.google.android.material.button.a f5051m;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f5044e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f5045f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f5046g = 0.0f;
    public float h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f5047i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5048j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f5050l = null;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class StaticLayoutBuilderCompatException extends Exception {
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f5040a = charSequence;
        this.f5041b = textPaint;
        this.f5042c = i10;
        this.f5043d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f5040a == null) {
            this.f5040a = "";
        }
        int iMax = Math.max(0, this.f5042c);
        CharSequence charSequenceEllipsize = this.f5040a;
        int i10 = this.f5045f;
        TextPaint textPaint = this.f5041b;
        if (i10 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f5050l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f5043d);
        this.f5043d = iMin;
        if (this.f5049k && this.f5045f == 1) {
            this.f5044e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f5044e);
        builderObtain.setIncludePad(this.f5048j);
        builderObtain.setTextDirection(this.f5049k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f5050l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f5045f);
        float f8 = this.f5046g;
        if (f8 != 0.0f || this.h != 1.0f) {
            builderObtain.setLineSpacing(f8, this.h);
        }
        if (this.f5045f > 1) {
            builderObtain.setHyphenationFrequency(this.f5047i);
        }
        com.google.android.material.button.a aVar = this.f5051m;
        if (aVar != null) {
            builderObtain.setBreakStrategy(((TextInputLayout) aVar.f4761g).f5221x.getBreakStrategy());
        }
        return builderObtain.build();
    }
}
