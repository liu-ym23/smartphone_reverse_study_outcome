package com.stepos.alphame.utils.pool;

import android.graphics.Bitmap;
import com.stepos.alphame.utils.pool.bitmap.BitmapPool;
import com.stepos.alphame.utils.pool.bitmap.LruBitmapPool;

/* loaded from: classes.dex */
public final class PoolManager {
    public static final int BITMAP_POOL_SIZE = 26214400;
    private static PoolManager sInstance;
    private final BitmapPool bitmapPool = new LruBitmapPool(BITMAP_POOL_SIZE);

    private PoolManager() {
    }

    public static Bitmap acquireBitmap(int i4, int i5, Bitmap.Config config) {
        Bitmap bitmap = getInstance().bitmapPool.get(i4, i5, config);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    public static synchronized PoolManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new PoolManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static void releaseBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        getInstance().bitmapPool.put(bitmap);
    }

    public static void trimMemory(int i4) {
        getInstance().bitmapPool.trimMemory(i4);
    }
}
