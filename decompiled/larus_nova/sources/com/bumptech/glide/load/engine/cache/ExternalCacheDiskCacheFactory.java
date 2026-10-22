package com.bumptech.glide.load.engine.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context r100) {
        this(r100, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context r100, int r101) {
        this(r100, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, r101);
    }

    public ExternalCacheDiskCacheFactory(final Context r100, final String r101, int r102) {
        super(new AnonymousClass1(r100, r101), r102);
    }
}
