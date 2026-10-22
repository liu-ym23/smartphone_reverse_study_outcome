package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends ImageSpan {
    public c(Context r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        super(r100, r101);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Rect r105 = getDrawable().getBounds();
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r106 = r100.getFontMetricsInt();
        int r107 = r106.bottom - r106.top;
        int r108 = (r105.bottom - r105.top) / 2;
        int r109 = r107 / 4;
        int r110 = r108 - r109;
        int r111 = -(r108 + r109);
        r104.ascent = r111;
        r104.top = r111;
        r104.bottom = r110;
        r104.descent = r110;
    L6:
        return r105.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        Drawable r109 = getDrawable();
        r100.save();
        int r110 = r107 - r109.getBounds().bottom;
        if (((ImageSpan) this).mVerticalAlignment != 1) goto L5;
        int r111 = r110 - r108.getFontMetricsInt().descent;
    L6:
        r100.translate(r104, r111);
        r109.draw(r100);
        r100.restore();
        return;
    L5:
        Paint.FontMetricsInt r112 = r108.getFontMetricsInt();
        r111 = ((((r112.descent + r106) + r106) + r112.ascent) / 2) - (r109.getBounds().bottom / 2);
        goto L6
    }
}
