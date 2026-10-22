package com.android.contacts.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class CenteredImageSpan extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;

    public CenteredImageSpan(Context r1, Bitmap r2, int r3) {
        super(r1, r2, r3);
    }

    public CenteredImageSpan(Context r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Rect r0 = getDrawable().getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r6 = r1.getFontMetricsInt();
        int r7 = r6.descent - r6.ascent;
        int r8 = r0.bottom - r0.top;
        int r9 = r6.ascent + (r7 / 2);
        int r10 = r8 / 2;
        r5.ascent = r9 - r10;
        r5.top = r5.ascent;
        r5.bottom = r9 + r10;
        r5.descent = r5.bottom;
    L6:
        return r0.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Drawable r0 = getCachedDrawable();
        r1.save();
        Paint.FontMetricsInt r10 = r9.getFontMetricsInt();
        r1.translate(r5, ((r7 + r10.descent) - ((r10.descent - r10.ascent) / 2)) - ((r0.getBounds().bottom - r0.getBounds().top) / 2));
        r0.draw(r1);
        r1.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> r0 = this.mDrawableRef;
        if (r0 == null) goto L5;
        Drawable r1 = r0.get();
    L6:
        if (r1 != null) goto L9;
        Drawable r2 = getDrawable();
        this.mDrawableRef = new WeakReference(r2);
        return r2;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
