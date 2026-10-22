package com.bumptech.glide.load.engine.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context r100) {
        this(r100, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public InternalCacheDiskCacheFactory(Context r100, long r101) {
        this(r100, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, r101);
    }

    public InternalCacheDiskCacheFactory(final Context r100, final String r101, long r102) {
        super(new AnonymousClass1(r100, r101), r102);
    }
}
