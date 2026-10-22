package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File r100 = this.cacheDirectoryGetter.getCacheDirectory();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.mkdirs() == true) goto L13;
        if (r100.exists() == true) goto L10;
    L11:
        return null;
    L10:
        if (r100.isDirectory() == false) goto L11;
    L13:
        return DiskLruCacheWrapper.create(r100, this.diskCacheSize);
    }

    public DiskLruCacheFactory(final String r100, long r101) {
        this(new AnonymousClass1(r100), r101);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter r100, long r101) {
        this.diskCacheSize = r101;
        this.cacheDirectoryGetter = r100;
    }

    public DiskLruCacheFactory(final String r100, final String r101, long r102) {
        this(new AnonymousClass2(r100, r101), r102);
    }
}
