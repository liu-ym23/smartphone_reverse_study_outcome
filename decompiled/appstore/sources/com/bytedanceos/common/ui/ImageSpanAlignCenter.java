package com.bytedanceos.common.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ImageSpanAlignCenter extends ImageSpan {
    private static final char[] ELLIPSIS_NORMAL = null;
    private static final char[] ELLIPSIS_TWO_DOTS = null;
    private WeakReference<Drawable> mDrawableRef;

    static {
        ELLIPSIS_NORMAL = new char[]{8230};
        ELLIPSIS_TWO_DOTS = new char[]{8229};
    }

    public ImageSpanAlignCenter(Context r10, int r11) {
        super(r10, r11);
    }

    private Drawable getCachedDrawable(Paint r10) {
        WeakReference<Drawable> r11 = this.mDrawableRef;
        if (r11 == null) goto L5;
        Drawable r12 = r11.get();
    L6:
        if (r12 != null) goto L12;
        r12 = getDrawable();
        int r13 = r10.getFontMetricsInt(null);
        int r14 = r12.getIntrinsicWidth();
        int r15 = r12.getIntrinsicHeight();
        if (r13 <= r15) goto L10;
        int r16 = (r13 - r15) / 2;
    L11:
        r12.setBounds(new Rect(0, r16, r14, Math.min(r13, r15) + r16));
        this.mDrawableRef = new WeakReference(r12);
        goto L12
    L10:
        r16 = 0;
    L12:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
        String r19 = r11.toString().substring(r12, r13);
        if (ELLIPSIS_NORMAL[0] != r19.charAt(0)) goto L5;
    L8:
        r10.save();
        r10.drawText(r19, r14, r16, r18);
        r10.restore();
        return;
    L5:
        if (ELLIPSIS_TWO_DOTS[0] == r19.charAt(0)) goto L8;
        Drawable r20 = getCachedDrawable(r18);
        r10.save();
        Paint.FontMetricsInt r21 = new Paint.FontMetricsInt();
        r18.getFontMetricsInt(r21);
        r20.getBounds();
        r10.translate(r14, r16 + r21.ascent);
        r20.draw(r10);
        r10.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r10, CharSequence r11, int r12, int r13, Paint.FontMetricsInt r14) {
        Rect r15 = getCachedDrawable(r10).getBounds();
        if (r14 == null) goto L6;
        Paint.FontMetricsInt r16 = new Paint.FontMetricsInt();
        r10.getFontMetricsInt(r16);
        r14.ascent = r16.ascent;
        r14.descent = r16.descent;
        r14.top = r16.top;
        r14.bottom = r16.bottom;
    L6:
        return r15.right;
    }

    public ImageSpanAlignCenter(Drawable r10) {
        super(r10);
    }
}
