package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(@NonNull Resource<?> r10);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    @Nullable
    Resource<?> put(@NonNull Key r10, @Nullable Resource<?> r11);

    @Nullable
    Resource<?> remove(@NonNull Key r10);

    void setResourceRemovedListener(@NonNull ResourceRemovedListener r10);

    void setSizeMultiplier(float r10);

    void trimMemory(int r10);
}
