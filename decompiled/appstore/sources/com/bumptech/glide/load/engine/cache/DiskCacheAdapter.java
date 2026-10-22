package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheAdapter implements DiskCache {

    public static final class Factory implements DiskCache.Factory {
        public Factory() {
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }

    public DiskCacheAdapter() {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r10) {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key r10) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key r10, DiskCache.Writer r11) {
    }
}
