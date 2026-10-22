package com.bumptech.glide.load.engine;

import androidx.collection.SieveCacheKt;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private static final String TAG = "ResourceCacheGenerator";
    private File cacheFile;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f33696cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex;
    private int sourceIdIndex;
    private Key sourceKey;

    private boolean hasNextModelLoader() {
        if (this.modelLoaderIndex >= this.modelLoaders.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidCache() {
        File r100 = this.cacheFile;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L19;
        long r103 = this.cacheFile.length();
        if (r103 > 0) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == true) goto L18;
        GlideLogUtil.e(TAG, "cache is invalid, delete:" + this.cacheFile.delete());
    L18:
        return r101;
    L12:
        if (r103 >= SieveCacheKt.NodeLinkMask) goto L14;
    L19:
        return r102;
    L5:
        if (r100.exists() == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> r100 = this.loadData;
        if (r100 == null) goto L6;
        r100.fetcher.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        List<Key> r100 = this.helper.getCacheKeys();
        boolean r101 = false;
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        List<Class<?>> r102 = this.helper.getRegisteredResourceClasses();
        if (r102.isEmpty() == false) goto L13;
        if (File.class.equals(this.helper.getTranscodeClass()) == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());
    L13:
        if (this.modelLoaders != null) goto L15;
    L29:
        int r103 = this.resourceClassIndex + 1;
        this.resourceClassIndex = r103;
        if (r103 < r102.size()) goto L35;
        int r104 = this.sourceIdIndex + 1;
        this.sourceIdIndex = r104;
        if (r104 >= r100.size()) goto L33;
        this.resourceClassIndex = 0;
        goto L35
    L33:
        return false;
    L35:
        Key r105 = (Key) ListProtector.get(r100, this.sourceIdIndex);
        Class r110 = (Class) ListProtector.get(r102, this.resourceClassIndex);
        this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), r105, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(r110), r110, this.helper.getOptions());
        this.cacheFile = this.helper.getDiskCache().get(this.currentKey);
        GlideLogUtil.i(TAG, "getDiskCache, path:" + this.cacheFile + ", currentKey:" + this.currentKey);
        if (this.cacheFile == null) goto L13;
        if (isValidCache() == false) goto L39;
        this.sourceKey = r105;
        this.modelLoaders = this.helper.getModelLoaders(this.cacheFile);
        this.modelLoaderIndex = 0;
        goto L13
    L39:
        this.cacheFile = null;
        return false;
    L15:
        if (hasNextModelLoader() == false) goto L29;
        this.loadData = null;
    L19:
        if (this.cacheFile == null) goto L28;
        if (r101 == true) goto L28;
        if (hasNextModelLoader() == false) goto L28;
        List<ModelLoader<File, ?>> r106 = this.modelLoaders;
        int r107 = this.modelLoaderIndex;
        this.modelLoaderIndex = r107 + 1;
        this.loadData = ((ModelLoader) ListProtector.get(r106, r107)).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
        if (this.loadData == null) goto L19;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L19;
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
        r101 = true;
    L28:
        return r101;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object r100) {
        this.f33696cb.onDataFetcherReady(this.sourceKey, r100, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception r100) {
        this.f33696cb.onDataFetcherFailed(this.currentKey, r100, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    public ResourceCacheGenerator(DecodeHelper<?> r100, DataFetcherGenerator.FetcherReadyCallback r101) {
        this.resourceClassIndex = -1;
        this.helper = r100;
        this.f33696cb = r101;
    }
}
