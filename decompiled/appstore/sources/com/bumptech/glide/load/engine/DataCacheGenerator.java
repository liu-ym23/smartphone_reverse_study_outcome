package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final List<Key> cacheKeys;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f6224cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    public DataCacheGenerator(DecodeHelper<?> r10, DataFetcherGenerator.FetcherReadyCallback r11) {
        this(r10.getCacheKeys(), r10, r11);
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
        this.f6224cb.onDataFetcherReady(this.sourceKey, r10, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception r10) {
        this.f6224cb.onDataFetcherFailed(this.sourceKey, r10, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
    L2:
        boolean r10 = false;
        if (this.modelLoaders != null) goto L5;
    L17:
        int r11 = this.sourceIdIndex + 1;
        this.sourceIdIndex = r11;
        if (r11 >= this.cacheKeys.size()) goto L19;
        Key r12 = this.cacheKeys.get(this.sourceIdIndex);
        File r13 = this.helper.getDiskCache().get(new DataCacheKey(r12, this.helper.getSignature()));
        this.cacheFile = r13;
        if (r13 == null) goto L2;
        this.sourceKey = r12;
        this.modelLoaders = this.helper.getModelLoaders(r13);
        this.modelLoaderIndex = 0;
        goto L2
    L19:
        return false;
    L5:
        if (hasNextModelLoader() == false) goto L17;
        this.loadData = null;
    L8:
        if (r10 == true) goto L16;
        if (hasNextModelLoader() == false) goto L16;
        List<ModelLoader<File, ?>> r14 = this.modelLoaders;
        int r15 = this.modelLoaderIndex;
        this.modelLoaderIndex = r15 + 1;
        this.loadData = r14.get(r15).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
        if (this.loadData == null) goto L8;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L8;
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
        r10 = true;
    L16:
        return r10;
    }

    public DataCacheGenerator(List<Key> r10, DecodeHelper<?> r11, DataFetcherGenerator.FetcherReadyCallback r12) {
        this.sourceIdIndex = -1;
        this.cacheKeys = r10;
        this.helper = r11;
        this.f6224cb = r12;
    }
}
