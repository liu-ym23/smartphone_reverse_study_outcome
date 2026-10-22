package com.bumptech.glide.load.engine.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context r10) {
        this(r10, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context r10, int r11) {
        this(r10, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, r11);
    }

    public ExternalCacheDiskCacheFactory(final Context r10, final String r11, int r12) {
        super(new AnonymousClass1(r10, r11), r12);
    }
}
