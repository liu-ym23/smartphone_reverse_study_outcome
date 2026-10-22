package com.baidu.platform.comapi.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: classes39.dex */
public class c {
    public static Bitmap a(Drawable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT <= 26) goto L8;
    L39:
    L38:
        return null;
    L12:
        if (r100.getBounds().isEmpty() == true) goto L14;
        int r101 = r100.getBounds().width();     // Catch: Exception -> L38
    L16:
        if (r100.getBounds().isEmpty() == true) goto L18;
        int r102 = r100.getBounds().height();     // Catch: Exception -> L38
    L20:
        if ((r100 instanceof BitmapDrawable) == false) goto L32;
        Bitmap r103 = ((BitmapDrawable) r100).getBitmap();     // Catch: Exception -> L38
        if (r103 == null) goto L32;
        if (r101 > r103.getWidth()) goto L28;
        r101 = r103.getWidth();     // Catch: Exception -> L38
    L28:
        if (r102 > r103.getHeight()) goto L32;
        r102 = r103.getHeight();     // Catch: Exception -> L38
    L32:
        if (r101 > 0) goto L34;
        r101 = 1;
    L34:
        if (r102 > 0) goto L36;
        r102 = 1;
    L36:
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L38
        Canvas r105 = new Canvas(r104);     // Catch: Exception -> L38
        r100.setBounds(0, 0, r105.getWidth(), r105.getHeight());     // Catch: Exception -> L38
        r100.draw(r105);     // Catch: Exception -> L38
        return r104;
    L18:
        r102 = r100.getIntrinsicHeight();     // Catch: Exception -> L38
        goto L20
    L14:
        r101 = r100.getIntrinsicWidth();     // Catch: Exception -> L38
        goto L16
    L8:
        if ((r100 instanceof BitmapDrawable) == false) goto L39;
        return ((BitmapDrawable) r100).getBitmap();
    }
}
