package com.bytedance.android.livesdk.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes11.dex */
public class a extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f161402a;

    public float a(float r100) {
        return r100;
    }

    public a(Drawable r100) {
        super(r100);
    }

    public float b(Paint r100, int r101) {
        Paint.FontMetricsInt r102 = r100.getFontMetricsInt();
        return ((((r102.descent + r101) + r101) + r102.ascent) / 2.0f) - (getDrawable().getBounds().bottom / 2.0f);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
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
        return r105.right + 0;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Drawable r109 = getDrawable();
        r100.save();
        r100.translate(a(r104), b(r108, r106));
        r109.draw(r100);
        r100.restore();
    }
}
