package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f10840a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f10841b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10842c;

    /* renamed from: d, reason: collision with root package name */
    public int f10843d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10850k;

    /* renamed from: m, reason: collision with root package name */
    public androidx.core.app.f f10852m;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f10844e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f10845f = Integer.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public float f10846g = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public float f10847h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f10848i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10849j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f10851l = null;

    public h(CharSequence charSequence, TextPaint textPaint, int i4) {
        this.f10840a = charSequence;
        this.f10841b = textPaint;
        this.f10842c = i4;
        this.f10843d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f10840a == null) {
            this.f10840a = "";
        }
        int iMax = Math.max(0, this.f10842c);
        CharSequence charSequenceEllipsize = this.f10840a;
        int i4 = this.f10845f;
        TextPaint textPaint = this.f10841b;
        if (i4 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f10851l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f10843d);
        this.f10843d = iMin;
        if (this.f10850k && this.f10845f == 1) {
            this.f10844e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f10844e);
        builderObtain.setIncludePad(this.f10849j);
        builderObtain.setTextDirection(this.f10850k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f10851l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f10845f);
        float f4 = this.f10846g;
        if (f4 != Property.DEFAULT_FLOAT_VALUE || this.f10847h != 1.0f) {
            builderObtain.setLineSpacing(f4, this.f10847h);
        }
        if (this.f10845f > 1) {
            builderObtain.setHyphenationFrequency(this.f10848i);
        }
        androidx.core.app.f fVar = this.f10852m;
        if (fVar != null) {
            builderObtain.setBreakStrategy(((TextInputLayout) fVar.f3281a).f10982u.getBreakStrategy());
        }
        return builderObtain.build();
    }
}
