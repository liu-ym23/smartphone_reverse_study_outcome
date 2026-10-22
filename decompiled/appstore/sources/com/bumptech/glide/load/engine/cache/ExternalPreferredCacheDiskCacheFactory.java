package com.bumptech.glide.load.engine.cache;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context r10) {
        this(r10, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context r10, long r11) {
        this(r10, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, r11);
    }

    public ExternalPreferredCacheDiskCacheFactory(final Context r10, final String r11, long r12) {
        super(new AnonymousClass1(r10, r11), r12);
    }
}
