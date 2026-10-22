package com.obric.oui.common.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import d.h.b.o;

/* JADX INFO: compiled from: ODrawableHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final ColorMatrixColorFilter a(int r5) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r5), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r5), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r5), 0.0f, 0.0f, 0.0f, (Color.alpha(r5) * 1.0f) / 255, 0.0f});
    }

    public static final Bitmap a(Drawable r5) {
        o.e(r5, "<this>");
        int r0 = r5.getIntrinsicWidth();
        int r1 = r5.getIntrinsicHeight();
        if (r5.getOpacity() == (-1)) goto L5;
        Bitmap.Config r2 = Bitmap.Config.ARGB_8888;
    L6:
        Bitmap r3 = Bitmap.createBitmap(r0, r1, r2);
        Canvas r4 = new Canvas(r3);
        r5.setBounds(0, 0, r0, r1);
        r5.draw(r4);
        o.c(r3, "bitmap");
        return r3;
    L5:
        r2 = Bitmap.Config.RGB_565;
        goto L6
    }
}
