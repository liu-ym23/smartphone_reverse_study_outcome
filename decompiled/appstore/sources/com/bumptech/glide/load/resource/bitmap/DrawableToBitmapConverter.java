package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = null;
    private static final String TAG = "DrawableToBitmap";

    static {
        NO_RECYCLE_BITMAP_POOL = new AnonymousClass1();
    }

    private DrawableToBitmapConverter() {
    }

    @Nullable
    public static Resource<Bitmap> convert(BitmapPool r10, Drawable r11, int r12, int r13) {
        Drawable r14 = r11.getCurrent();
        boolean r15 = false;
        if ((r14 instanceof BitmapDrawable) == false) goto L6;
        Bitmap r16 = ((BitmapDrawable) r14).getBitmap();
    L9:
        if (r15 == true) goto L13;
        r10 = NO_RECYCLE_BITMAP_POOL;
    L13:
        return BitmapResource.obtain(r16, r10);
    L6:
        if ((r14 instanceof Animatable) == true) goto L8;
        r16 = drawToBitmap(r10, r14, r12, r13);
        r15 = true;
        goto L9
    L8:
        r16 = null;
        goto L9
    }

    @Nullable
    private static Bitmap drawToBitmap(BitmapPool r10, Drawable r11, int r12, int r13) {
        if (r12 == Integer.MIN_VALUE) goto L5;
    L10:
        if (r13 != Integer.MIN_VALUE) goto L18;
        if (r11.getIntrinsicHeight() > 0) goto L18;
        if (Log.isLoggable(TAG, 5) == false) goto L16;
        Log.w(TAG, "Unable to draw " + r11 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
    L16:
        return null;
    L18:
        if (r11.getIntrinsicWidth() <= 0) goto L21;
        r12 = r11.getIntrinsicWidth();
    L21:
        if (r11.getIntrinsicHeight() <= 0) goto L23;
        r13 = r11.getIntrinsicHeight();
    L23:
        Lock r14 = TransformationUtils.getBitmapDrawableLock();
        r14.lock();
        Bitmap r15 = r10.get(r12, r13, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r15);     // Catch: Throwable -> L27
        r11.setBounds(0, 0, r12, r13);     // Catch: Throwable -> L27
        r11.draw(r16);     // Catch: Throwable -> L27
        r16.setBitmap(null);     // Catch: Throwable -> L27
        r14.unlock();
        return r15;
    L27:
        th = move-exception;
        r14.unlock();
        throw th;
    L5:
        if (r11.getIntrinsicWidth() > 0) goto L10;
        if (Log.isLoggable(TAG, 5) == false) goto L9;
        Log.w(TAG, "Unable to draw " + r11 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
    L9:
        return null;
    }
}
