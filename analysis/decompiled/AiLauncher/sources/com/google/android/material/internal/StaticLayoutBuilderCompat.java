package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class StaticLayoutBuilderCompat {

    /* renamed from: o, reason: collision with root package name */
    public static final int f20980o = 1;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f20981a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f20982b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20983c;

    /* renamed from: e, reason: collision with root package name */
    public int f20985e;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20992l;

    /* renamed from: n, reason: collision with root package name */
    public o f20994n;

    /* renamed from: d, reason: collision with root package name */
    public int f20984d = 0;

    /* renamed from: f, reason: collision with root package name */
    public Layout.Alignment f20986f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    public int f20987g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public float f20988h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f20989i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public int f20990j = f20980o;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20991k = true;

    /* renamed from: m, reason: collision with root package name */
    public TextUtils.TruncateAt f20993m = null;

    public static class StaticLayoutBuilderCompatException extends Exception {
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f20981a = charSequence;
        this.f20982b = textPaint;
        this.f20983c = i10;
        this.f20985e = charSequence.length();
    }

    public static StaticLayoutBuilderCompat b(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i10);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.f20981a == null) {
            this.f20981a = "";
        }
        int iMax = Math.max(0, this.f20983c);
        CharSequence charSequenceEllipsize = this.f20981a;
        if (this.f20987g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f20982b, iMax, this.f20993m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f20985e);
        this.f20985e = iMin;
        if (this.f20992l && this.f20987g == 1) {
            this.f20986f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f20984d, iMin, this.f20982b, iMax);
        builderObtain.setAlignment(this.f20986f);
        builderObtain.setIncludePad(this.f20991k);
        builderObtain.setTextDirection(this.f20992l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f20993m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f20987g);
        float f10 = this.f20988h;
        if (f10 != 0.0f || this.f20989i != 1.0f) {
            builderObtain.setLineSpacing(f10, this.f20989i);
        }
        if (this.f20987g > 1) {
            builderObtain.setHyphenationFrequency(this.f20990j);
        }
        o oVar = this.f20994n;
        if (oVar != null) {
            oVar.a(builderObtain);
        }
        return builderObtain.build();
    }

    public StaticLayoutBuilderCompat c(Layout.Alignment alignment) {
        this.f20986f = alignment;
        return this;
    }

    public StaticLayoutBuilderCompat d(TextUtils.TruncateAt truncateAt) {
        this.f20993m = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat e(int i10) {
        this.f20990j = i10;
        return this;
    }

    public StaticLayoutBuilderCompat f(boolean z10) {
        this.f20991k = z10;
        return this;
    }

    public StaticLayoutBuilderCompat g(boolean z10) {
        this.f20992l = z10;
        return this;
    }

    public StaticLayoutBuilderCompat h(float f10, float f11) {
        this.f20988h = f10;
        this.f20989i = f11;
        return this;
    }

    public StaticLayoutBuilderCompat i(int i10) {
        this.f20987g = i10;
        return this;
    }

    public StaticLayoutBuilderCompat j(o oVar) {
        this.f20994n = oVar;
        return this;
    }
}
