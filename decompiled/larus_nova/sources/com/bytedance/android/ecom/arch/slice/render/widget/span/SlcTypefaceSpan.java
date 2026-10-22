package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/widget/span/SlcTypefaceSpan;", "Landroid/text/style/TypefaceSpan;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcTypefaceSpan extends TypefaceSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Typeface f50975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f50977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f50978d;

    public final int hashCode() {
        int r100 = (((this.f50976b + 31) * 31) + this.f50977c) * 31;
        String r101 = this.f50978d;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final void a(TextPaint r100) {
    L7:
        th = move-exception;
        nq.a.c(th, null, 2);
        return;
    L3:
        if (this.f50975a != null) goto L5;
        this.f50975a = com.bytedance.android.ecom.arch.slice.render.util.i.c(r100.getTypeface(), this.f50977c, this.f50976b, this.f50978d);     // Catch: Throwable -> L7
    L5:
        r100.setTypeface(this.f50975a);     // Catch: Throwable -> L7
        com.bytedance.android.ecom.arch.slice.render.util.i.a(r100, this.f50976b);     // Catch: Throwable -> L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if ((!Intrinsics.areEqual(SlcTypefaceSpan.class, r100.getClass())) == true) goto L19;
        SlcTypefaceSpan r101 = (SlcTypefaceSpan) r100;
        if (this.f50976b == r101.f50976b) goto L13;
    L17:
        return false;
    L13:
        if (this.f50977c != r101.f50977c) goto L17;
        if (Intrinsics.areEqual(this.f50978d, r101.f50978d) == false) goto L17;
        return true;
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        a(r100);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        a(r100);
    }

    public SlcTypefaceSpan(int r100, int r101, String r102) {
        super(null);
        this.f50976b = r100;
        this.f50977c = r101;
        this.f50978d = r102;
    }
}
