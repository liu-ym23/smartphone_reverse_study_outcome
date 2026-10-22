package com.android.ttcjpaysdk.base.theme.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes28.dex */
public class BitmapUtil {
    public BitmapUtil() {
    }

    public static Bitmap drawableToBitmap(Drawable r100, int r101, int r102) {
        if ((r100 instanceof BitmapDrawable) == false) goto L7;
        return ((BitmapDrawable) r100).getBitmap();
    L7:
        if (r100.getIntrinsicWidth() <= 0) goto L11;
        r101 = r100.getIntrinsicWidth();
    L11:
        if (r100.getIntrinsicHeight() <= 0) goto L14;
        r102 = r100.getIntrinsicHeight();
    L14:
        Bitmap r103 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        r100.setBounds(0, 0, r101, r102);
        r100.draw(r104);
        return r103;
    }
}
