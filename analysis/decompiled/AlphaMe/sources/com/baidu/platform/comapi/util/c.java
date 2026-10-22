package com.baidu.platform.comapi.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class c {
    public static Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        try {
            int iWidth = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();
            int iHeight = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                if (iWidth <= bitmap.getWidth()) {
                    iWidth = bitmap.getWidth();
                }
                if (iHeight <= bitmap.getHeight()) {
                    iHeight = bitmap.getHeight();
                }
            }
            if (iWidth <= 0) {
                iWidth = 1;
            }
            if (iHeight <= 0) {
                iHeight = 1;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            return null;
        }
    }
}
