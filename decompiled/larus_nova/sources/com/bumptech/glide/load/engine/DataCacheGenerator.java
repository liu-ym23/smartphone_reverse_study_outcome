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
class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private static final String TAG = "DataCacheGenerator";
    private File cacheFile;
    private final List<Key> cacheKeys;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f33691cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
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
    L2:
        boolean r100 = false;
        if (this.modelLoaders != null) goto L5;
    L19:
        int r101 = this.sourceIdIndex + 1;
        this.sourceIdIndex = r101;
        if (r101 >= this.cacheKeys.size()) goto L21;
        Key r102 = (Key) ListProtector.get(this.cacheKeys, this.sourceIdIndex);
        DataCacheKey r103 = new DataCacheKey(r102, this.helper.getSignature());
        this.cacheFile = this.helper.getDiskCache().get(r103);
        GlideLogUtil.i(TAG, "getDiskCache, path:" + this.cacheFile + ", originalKey:" + r103);
        if (this.cacheFile == null) goto L2;
        if (isValidCache() == false) goto L26;
        this.sourceKey = r102;
        this.modelLoaders = this.helper.getModelLoaders(this.cacheFile);
        this.modelLoaderIndex = 0;
        goto L2
    L26:
        this.cacheFile = null;
        return false;
    L21:
        return false;
    L5:
        if (hasNextModelLoader() == false) goto L19;
        this.loadData = null;
    L9:
        if (this.cacheFile == null) goto L18;
        if (r100 == true) goto L18;
        if (hasNextModelLoader() == false) goto L18;
        List<ModelLoader<File, ?>> r104 = this.modelLoaders;
        int r105 = this.modelLoaderIndex;
        this.modelLoaderIndex = r105 + 1;
        this.loadData = ((ModelLoader) ListProtector.get(r104, r105)).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
        if (this.loadData == null) goto L9;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L9;
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
        r100 = true;
    L18:
        return r100;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object r100) {
        this.f33691cb.onDataFetcherReady(this.sourceKey, r100, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(Exception r100) {
        this.f33691cb.onDataFetcherFailed(this.sourceKey, r100, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    public DataCacheGenerator(DecodeHelper<?> r100, DataFetcherGenerator.FetcherReadyCallback r101) {
        this(r100.getCacheKeys(), r100, r101);
    }

    public DataCacheGenerator(List<Key> r100, DecodeHelper<?> r101, DataFetcherGenerator.FetcherReadyCallback r102) {
        this.sourceIdIndex = -1;
        this.cacheKeys = r100;
        this.helper = r101;
        this.f33691cb = r102;
    }
}
