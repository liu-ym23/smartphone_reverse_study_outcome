package com.bumptech.glide.load.engine.cache;

import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class LarkDiskLruCacheFactory extends DiskLruCacheFactory {
    private final DiskLruCacheFactory.CacheDirectoryGetter avatarCacheDirectoryGetter;
    private final DiskLruCacheFactory.CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;
    private final SafeKeyGenerator.IKeyGeneratorHandler handler;

    @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory, com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File r100 = this.cacheDirectoryGetter.getCacheDirectory();
        File r101 = this.avatarCacheDirectoryGetter.getCacheDirectory();
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r100.mkdirs() == true) goto L14;
        if (r100.exists() == true) goto L11;
    L12:
        return null;
    L11:
        if (r100.isDirectory() == false) goto L12;
    L14:
        if (r101.mkdirs() == true) goto L21;
        if (r101.exists() == true) goto L18;
    L19:
        return null;
    L18:
        if (r101.isDirectory() == false) goto L19;
    L21:
        return DiskLruCacheWrapper.create(r100, r101, this.diskCacheSize, this.handler);
    L22:
        return null;
    }

    public LarkDiskLruCacheFactory(DiskLruCacheFactory.CacheDirectoryGetter r100, DiskLruCacheFactory.CacheDirectoryGetter r101, long r102, SafeKeyGenerator.IKeyGeneratorHandler r103) {
        super(r100, r102);
        this.diskCacheSize = r102;
        this.cacheDirectoryGetter = r100;
        this.avatarCacheDirectoryGetter = r101;
        this.handler = r103;
    }
}
