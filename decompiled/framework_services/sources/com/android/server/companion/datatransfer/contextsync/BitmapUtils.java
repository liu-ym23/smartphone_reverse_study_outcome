package com.android.server.companion.datatransfer.contextsync;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class BitmapUtils {
    private static final int APP_ICON_BITMAP_DIMENSION = 256;

    public BitmapUtils() {
    }

    public static byte[] renderDrawableToByteArray(Drawable drawable) {
        if ((drawable instanceof BitmapDrawable) == false) goto L13;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (bitmap.getWidth() <= 256) goto L7;
    L11:
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 256, 256, true);
        byte[] renderedBitmap = renderBitmapToByteArray(scaledBitmap);
        scaledBitmap.recycle();
        return renderedBitmap;
    L7:
        if (bitmap.getHeight() > 256) goto L11;
        return renderBitmapToByteArray(bitmap);
    L13:
        Bitmap bitmap2 = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);     // Catch: Throwable -> L17
        drawable.setBounds(0, 0, bitmap2.getWidth(), bitmap2.getHeight());     // Catch: Throwable -> L17
        drawable.draw(canvas);     // Catch: Throwable -> L17
        byte[] r2 = renderBitmapToByteArray(bitmap2);     // Catch: Throwable -> L17
        bitmap2.recycle();
        return r2;
    L17:
        th = move-exception;
        bitmap2.recycle();
        throw th;
    }

    private static byte[] renderBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
