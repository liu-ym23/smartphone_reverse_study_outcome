package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.GlideLogUtil;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes39.dex */
final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = null;
    private static final String TAG = "DrawableToBitmap";

    static {
        NO_RECYCLE_BITMAP_POOL = new AnonymousClass1();
    }

    private DrawableToBitmapConverter() {
    }

    public static Resource<Bitmap> convert(BitmapPool r100, Drawable r101, int r102, int r103) {
        Drawable r104 = r101.getCurrent();
        boolean r105 = false;
        if ((r104 instanceof BitmapDrawable) == false) goto L6;
        Bitmap r106 = ((BitmapDrawable) r104).getBitmap();
    L9:
        if (r105 == true) goto L13;
        r100 = NO_RECYCLE_BITMAP_POOL;
    L13:
        return BitmapResource.obtain(r106, r100);
    L6:
        if ((r104 instanceof Animatable) == true) goto L8;
        r106 = drawToBitmap(r100, r104, r102, r103);
        r105 = true;
        goto L9
    L8:
        r106 = null;
        goto L9
    }

    private static Bitmap drawToBitmap(BitmapPool r100, Drawable r101, int r102, int r103) {
        if (r102 == Integer.MIN_VALUE) goto L5;
    L8:
        if (r103 != Integer.MIN_VALUE) goto L14;
        if (r101.getIntrinsicHeight() > 0) goto L14;
        GlideLogUtil.w(TAG, "Unable to draw " + r101 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
        return null;
    L14:
        if (r101.getIntrinsicWidth() <= 0) goto L17;
        r102 = r101.getIntrinsicWidth();
    L17:
        if (r101.getIntrinsicHeight() <= 0) goto L19;
        r103 = r101.getIntrinsicHeight();
    L19:
        Lock r104 = TransformationUtils.getBitmapDrawableLock();
        r104.lock();
        Bitmap r105 = r100.get(r102, r103, Bitmap.Config.ARGB_8888);
        Canvas r106 = new Canvas(r105);     // Catch: Throwable -> L23
        r101.setBounds(0, 0, r102, r103);     // Catch: Throwable -> L23
        r101.draw(r106);     // Catch: Throwable -> L23
        r106.setBitmap(null);     // Catch: Throwable -> L23
        r104.unlock();
        return r105;
    L23:
        th = move-exception;
        r104.unlock();
        throw th;
    L5:
        if (r101.getIntrinsicWidth() > 0) goto L8;
        GlideLogUtil.w(TAG, "Unable to draw " + r101 + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        return null;
    }
}
