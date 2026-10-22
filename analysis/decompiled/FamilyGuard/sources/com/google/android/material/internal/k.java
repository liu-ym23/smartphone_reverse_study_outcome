package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: o, reason: collision with root package name */
    static final int f13017o = 1;

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f13018a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f13019b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13020c;

    /* renamed from: e, reason: collision with root package name */
    private int f13022e;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13029l;

    /* renamed from: n, reason: collision with root package name */
    private l f13031n;

    /* renamed from: d, reason: collision with root package name */
    private int f13021d = 0;

    /* renamed from: f, reason: collision with root package name */
    private Layout.Alignment f13023f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    private int f13024g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private float f13025h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f13026i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private int f13027j = f13017o;

    /* renamed from: k, reason: collision with root package name */
    private boolean f13028k = true;

    /* renamed from: m, reason: collision with root package name */
    private TextUtils.TruncateAt f13030m = null;

    public static class a extends Exception {
    }

    private k(CharSequence charSequence, TextPaint textPaint, int i5) {
        this.f13018a = charSequence;
        this.f13019b = textPaint;
        this.f13020c = i5;
        this.f13022e = charSequence.length();
    }

    public static k b(CharSequence charSequence, TextPaint textPaint, int i5) {
        return new k(charSequence, textPaint, i5);
    }

    public StaticLayout a() {
        if (this.f13018a == null) {
            this.f13018a = BuildConfig.FLAVOR;
        }
        int iMax = Math.max(0, this.f13020c);
        CharSequence charSequenceEllipsize = this.f13018a;
        if (this.f13024g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f13019b, iMax, this.f13030m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f13022e);
        this.f13022e = iMin;
        if (this.f13029l && this.f13024g == 1) {
            this.f13023f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f13021d, iMin, this.f13019b, iMax);
        builderObtain.setAlignment(this.f13023f);
        builderObtain.setIncludePad(this.f13028k);
        builderObtain.setTextDirection(this.f13029l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f13030m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f13024g);
        float f5 = this.f13025h;
        if (f5 != 0.0f || this.f13026i != 1.0f) {
            builderObtain.setLineSpacing(f5, this.f13026i);
        }
        if (this.f13024g > 1) {
            builderObtain.setHyphenationFrequency(this.f13027j);
        }
        l lVar = this.f13031n;
        if (lVar != null) {
            lVar.a(builderObtain);
        }
        return builderObtain.build();
    }

    public k c(Layout.Alignment alignment) {
        this.f13023f = alignment;
        return this;
    }

    public k d(TextUtils.TruncateAt truncateAt) {
        this.f13030m = truncateAt;
        return this;
    }

    public k e(int i5) {
        this.f13027j = i5;
        return this;
    }

    public k f(boolean z5) {
        this.f13028k = z5;
        return this;
    }

    public k g(boolean z5) {
        this.f13029l = z5;
        return this;
    }

    public k h(float f5, float f6) {
        this.f13025h = f5;
        this.f13026i = f6;
        return this;
    }

    public k i(int i5) {
        this.f13024g = i5;
        return this;
    }

    public k j(l lVar) {
        this.f13031n = lVar;
        return this;
    }
}
