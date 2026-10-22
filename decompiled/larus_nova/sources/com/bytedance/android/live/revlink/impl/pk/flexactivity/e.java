package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f96719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f96720b;

    public e(int r100, int r101) {
        this.f96719a = r100;
        this.f96720b = r101;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (int) (r100.measureText(r101, r102, r103) + 14);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r211, "paint");
        int r100 = r211.getColor();
        r211.setColor(this.f96719a);
        r110.drawRoundRect(new RectF(r114 + 3, r115 + 1, r114 + ((int) (r211.measureText(r111, r112, r113) + 8)), r210 - 1), 2.0f, 2.0f, r211);
        r211.setColor(this.f96720b);
        r110.drawText(r111, r112, r113, r114 + 7, r116, r211);
        r211.setColor(r100);
    }
}
