package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
public class MemoryCacheAdapter implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public MemoryCacheAdapter() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getCurrentSize() {
        return 0;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getMaxSize() {
        return 0;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource<?> remove(Key r100) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float r100) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int r100) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimToRetainRatio(float r100) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener r100) {
        this.listener = r100;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public Resource<?> put(Key r100, Resource<?> r101) {
        if (r101 == null) goto L6;
        this.listener.onResourceRemoved(r101);
        return null;
    L6:
        return null;
    }
}
