package com.bytedance.android.ec.core.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class TexMarginSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f46054a;

    public TexMarginSpan() {
        this.f46054a = LazyKt.lazy(TexMarginSpan$fontMetrices$2.INSTANCE);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (int) r100.measureText(r101, r102, r103);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        r108.getFontMetrics((Paint.FontMetrics) this.f46054a.getValue());
        if (r101 == null) goto L8;
        CharSequence r109 = r101.subSequence(r102, r103);
        if (r109 == null) goto L8;
        String r110 = r109.toString();
        if (r110 == null) goto L8;
    L9:
        r100.drawText(r110, r104, r106 - (((Paint.FontMetrics) this.f46054a.getValue()).descent / 2), r108);
        return;
    L8:
        r110 = "";
        goto L9
    }
}
