package com.stepos.activeview.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: classes.dex */
public class ImageCacheUtils {
    private static volatile ImageCacheUtils imageCacheUtilsInstance;
    private ImageCache mImageCache;

    public class BitmapCache implements ImageCache {
        private LruCache<String, Bitmap> mMemoryCache;

        public BitmapCache() {
            this.mMemoryCache = new LruCache<String, Bitmap>(this, ((int) Runtime.getRuntime().maxMemory()) / 4) { // from class: com.stepos.activeview.utils.ImageCacheUtils.BitmapCache.1
                @Override // android.util.LruCache
                public int sizeOf(String str, Bitmap bitmap) {
                    return bitmap.getHeight() * bitmap.getRowBytes();
                }
            };
        }

        @Override // com.stepos.activeview.utils.ImageCache
        public void clearCache() {
            LruCache<String, Bitmap> lruCache = this.mMemoryCache;
            if (lruCache == null || lruCache.size() <= 0) {
                return;
            }
            this.mMemoryCache.evictAll();
        }

        @Override // com.stepos.activeview.utils.ImageCache
        public Bitmap getBitmap(String str) {
            return this.mMemoryCache.get(Md5Helper.MD5Encode(str));
        }

        @Override // com.stepos.activeview.utils.ImageCache
        public void putBitmap(String str, Bitmap bitmap) {
            String strMD5Encode = Md5Helper.MD5Encode(str);
            if (ImageCacheUtils.this.getBitmapFromImageCache(strMD5Encode) != null || bitmap == null) {
                return;
            }
            this.mMemoryCache.put(strMD5Encode, bitmap);
        }

        @Override // com.stepos.activeview.utils.ImageCache
        public void removeBitmap(String str) {
            LruCache<String, Bitmap> lruCache = this.mMemoryCache;
            if (lruCache != null) {
                lruCache.remove(Md5Helper.MD5Encode(str));
            }
        }
    }

    private ImageCacheUtils() {
    }

    private ImageCache getCache() {
        if (this.mImageCache == null) {
            this.mImageCache = new BitmapCache();
        }
        return this.mImageCache;
    }

    public static ImageCacheUtils getInstance() {
        if (imageCacheUtilsInstance == null) {
            synchronized (ImageCacheUtils.class) {
                try {
                    if (imageCacheUtilsInstance == null) {
                        imageCacheUtilsInstance = new ImageCacheUtils();
                    }
                } finally {
                }
            }
        }
        return imageCacheUtilsInstance;
    }

    public void clearCache() {
        getCache().clearCache();
        this.mImageCache = null;
    }

    public Bitmap getBitmapFromImageCache(String str) {
        Bitmap bitmap = getCache().getBitmap(str);
        if (bitmap == null || !bitmap.isRecycled()) {
            return bitmap;
        }
        return null;
    }

    public void putBitmapToImageCache(String str, Bitmap bitmap) {
        getCache().putBitmap(str, bitmap);
    }

    public void removeBitmapFromCache(String str) {
        getCache().removeBitmap(str);
    }

    public void setImageCache(ImageCache imageCache) {
        ImageCache imageCache2 = this.mImageCache;
        if (imageCache2 != null) {
            imageCache2.clearCache();
        }
        this.mImageCache = imageCache;
    }
}
