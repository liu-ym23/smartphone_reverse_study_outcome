package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f6229cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex;
    private int sourceIdIndex;
    private Key sourceKey;

    public ResourceCacheGenerator(DecodeHelper<?> r10, DataFetcherGenerator.FetcherReadyCallback r11) {
        this.resourceClassIndex = -1;
        this.helper = r10;
        this.f6229cb = r11;
    }

    private boolean hasNextModelLoader() {
        if (this.modelLoaderIndex >= this.modelLoaders.size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> r10 = this.loadData;
        if (r10 == null) goto L6;
        r10.fetcher.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object r10) {
        this.f6229cb.onDataFetcherReady(this.sourceKey, r10, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception r10) {
        this.f6229cb.onDataFetcherFailed(this.currentKey, r10, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        List<Key> r10 = this.helper.getCacheKeys();
        boolean r11 = false;
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        List<Class<?>> r12 = this.helper.getRegisteredResourceClasses();
        if (r12.isEmpty() == false) goto L13;
        if (File.class.equals(this.helper.getTranscodeClass()) == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());
    L13:
        if (this.modelLoaders != null) goto L15;
    L27:
        int r13 = this.resourceClassIndex + 1;
        this.resourceClassIndex = r13;
        if (r13 < r12.size()) goto L33;
        int r14 = this.sourceIdIndex + 1;
        this.sourceIdIndex = r14;
        if (r14 >= r10.size()) goto L31;
        this.resourceClassIndex = 0;
        goto L33
    L31:
        return false;
    L33:
        Key r15 = r10.get(this.sourceIdIndex);
        Class<?> r16 = r12.get(this.resourceClassIndex);
        this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), r15, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(r16), r16, this.helper.getOptions());
        File r17 = this.helper.getDiskCache().get(this.currentKey);
        this.cacheFile = r17;
        if (r17 == null) goto L13;
        this.sourceKey = r15;
        this.modelLoaders = this.helper.getModelLoaders(r17);
        this.modelLoaderIndex = 0;
        goto L13
    L15:
        if (hasNextModelLoader() == false) goto L27;
        this.loadData = null;
    L18:
        if (r11 == true) goto L26;
        if (hasNextModelLoader() == false) goto L26;
        List<ModelLoader<File, ?>> r18 = this.modelLoaders;
        int r19 = this.modelLoaderIndex;
        this.modelLoaderIndex = r19 + 1;
        this.loadData = r18.get(r19).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
        if (this.loadData == null) goto L18;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L18;
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
        r11 = true;
    L26:
        return r11;
    }
}
