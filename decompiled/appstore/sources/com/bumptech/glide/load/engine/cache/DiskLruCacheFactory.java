package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(final String r10, long r11) {
        this(new AnonymousClass1(r10), r11);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File r10 = this.cacheDirectoryGetter.getCacheDirectory();
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.mkdirs() == true) goto L13;
        if (r10.exists() == true) goto L10;
    L11:
        return null;
    L10:
        if (r10.isDirectory() == false) goto L11;
    L13:
        return DiskLruCacheWrapper.create(r10, this.diskCacheSize);
    }

    public DiskLruCacheFactory(final String r10, final String r11, long r12) {
        this(new AnonymousClass2(r10, r11), r12);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter r10, long r11) {
        this.diskCacheSize = r11;
        this.cacheDirectoryGetter = r10;
    }
}
