package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(Resource<?> r100);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    Resource<?> put(Key r100, Resource<?> r101);

    Resource<?> remove(Key r100);

    void setResourceRemovedListener(ResourceRemovedListener r100);

    void setSizeMultiplier(float r100);

    void trimMemory(int r100);

    void trimToRetainRatio(float r100);
}
