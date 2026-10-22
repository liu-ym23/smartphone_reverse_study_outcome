package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(long r10) {
        super(r10);
    }

    @Override // com.bumptech.glide.util.LruCache
    public /* bridge */ /* synthetic */ int getSize(@Nullable Resource<?> r10) {
        return getSize2(r10);
    }

    @Override // com.bumptech.glide.util.LruCache
    public /* bridge */ /* synthetic */ void onItemEvicted(@NonNull Key r10, @Nullable Resource<?> r11) {
        onItemEvicted2(r10, r11);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @Nullable
    public /* bridge */ /* synthetic */ Resource put(@NonNull Key r10, @Nullable Resource r11) {
        return (Resource) super.put(r10, r11);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @Nullable
    public /* bridge */ /* synthetic */ Resource remove(@NonNull Key r10) {
        return (Resource) super.remove(r10);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(@NonNull MemoryCache.ResourceRemovedListener r10) {
        this.listener = r10;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int r10) {
        if (r10 < 40) goto L6;
        clearMemory();
        return;
    L6:
        if (r10 < 20) goto L8;
    L9:
        trimToSize(getMaxSize() / 2);
        return;
    L8:
        if (r10 == 15) goto L9;
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    public int getSize2(@Nullable Resource<?> r10) {
        if (r10 != null) goto L6;
        return super.getSize(null);
    L6:
        return r10.getSize();
    }

    /* JADX INFO: renamed from: onItemEvicted, reason: avoid collision after fix types in other method */
    public void onItemEvicted2(@NonNull Key r10, @Nullable Resource<?> r11) {
        MemoryCache.ResourceRemovedListener r12 = this.listener;
        if (r12 == null) goto L7;
        if (r11 == null) goto L8;
        r12.onResourceRemoved(r11);
        return;
    L8:
        return;
    }
}
