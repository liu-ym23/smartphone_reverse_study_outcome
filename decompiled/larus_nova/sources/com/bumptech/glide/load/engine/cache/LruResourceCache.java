package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

/* JADX INFO: loaded from: classes39.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(long r100) {
        super(r100);
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    public int getSize2(Resource<?> r100) {
        if (r100 != null) goto L6;
        return super.getSize(null);
    L6:
        return r100.getSize();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource remove(Key r100) {
        return (Resource) super.remove(r100);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener r100) {
        this.listener = r100;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int r100) {
        if (r100 < 40) goto L6;
        clearMemory();
        return;
    L6:
        if (r100 < 20) goto L8;
    L9:
        trimToSize(getMaxSize() / 2);
        return;
    L8:
        if (r100 == 15) goto L9;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimToRetainRatio(float r100) {
        trimToSize((long) Math.floor(getMaxSize() * r100));
    }

    @Override // com.bumptech.glide.util.LruCache
    public /* bridge */ /* synthetic */ int getSize(Resource<?> r100) {
        return getSize2(r100);
    }

    /* JADX INFO: renamed from: onItemEvicted, reason: avoid collision after fix types in other method */
    public void onItemEvicted2(Key r100, Resource<?> r101) {
        MemoryCache.ResourceRemovedListener r102 = this.listener;
        if (r102 == null) goto L7;
        if (r101 == null) goto L8;
        r102.onResourceRemoved(r101);
        return;
    L8:
        return;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource put(Key r100, Resource r101) {
        return (Resource) super.put(r100, r101);
    }

    @Override // com.bumptech.glide.util.LruCache
    public /* bridge */ /* synthetic */ void onItemEvicted(Key r100, Resource<?> r101) {
        onItemEvicted2(r100, r101);
    }
}
