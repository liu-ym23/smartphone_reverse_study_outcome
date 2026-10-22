package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class SourceGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object>, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f6230cb;
    private Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int loadDataListIndex;
    private DataCacheKey originalKey;
    private DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper<?> r10, DataFetcherGenerator.FetcherReadyCallback r11) {
        this.helper = r10;
        this.f6230cb = r11;
    }

    private void cacheData(Object r10) {
        long r11 = LogTime.getLogTime();
        Encoder<X> r12 = this.helper.getSourceEncoder(r10);     // Catch: Throwable -> L7
        DataCacheWriter r13 = new DataCacheWriter(r12, r10, this.helper.getOptions());     // Catch: Throwable -> L7
        this.originalKey = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());     // Catch: Throwable -> L7
        this.helper.getDiskCache().put(this.originalKey, r13);     // Catch: Throwable -> L7
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        Log.v(TAG, "Finished encoding source to cache, key: " + this.originalKey + ", data: " + r10 + ", encoder: " + r12 + ", duration: " + LogTime.getElapsedMillis(r11));     // Catch: Throwable -> L7
    L9:
        this.loadData.fetcher.cleanup();
        this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
        return;
    L7:
        th = move-exception;
        this.loadData.fetcher.cleanup();
        throw th;
    }

    private boolean hasNextModelLoader() {
        if (this.loadDataListIndex >= this.helper.getLoadData().size()) goto L5;
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

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key r10, Exception r11, DataFetcher<?> r12, DataSource r13) {
        this.f6230cb.onDataFetcherFailed(r10, r11, r12, this.loadData.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key r10, Object r11, DataFetcher<?> r12, DataSource r13, Key r14) {
        this.f6230cb.onDataFetcherReady(r10, r11, r12, this.loadData.fetcher.getDataSource(), r10);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onDataReady(Object r10) {
        DiskCacheStrategy r11 = this.helper.getDiskCacheStrategy();
        if (r10 != null) goto L5;
    L7:
        this.f6230cb.onDataFetcherReady(this.loadData.sourceKey, r10, this.loadData.fetcher, this.loadData.fetcher.getDataSource(), this.originalKey);
        return;
    L5:
        if (r11.isDataCacheable(this.loadData.fetcher.getDataSource()) == false) goto L7;
        this.dataToCache = r10;
        this.f6230cb.reschedule();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public void onLoadFailed(@NonNull Exception r10) {
        this.f6230cb.onDataFetcherFailed(this.originalKey, r10, this.loadData.fetcher, this.loadData.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        Object r10 = this.dataToCache;
        if (r10 == null) goto L5;
        this.dataToCache = null;
        cacheData(r10);
    L5:
        DataCacheGenerator r11 = this.sourceCacheGenerator;
        if (r11 != null) goto L8;
    L10:
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean r12 = false;
    L11:
        if (r12 == true) goto L21;
        if (hasNextModelLoader() == false) goto L21;
        List<ModelLoader.LoadData<?>> r13 = this.helper.getLoadData();
        int r14 = this.loadDataListIndex;
        this.loadDataListIndex = r14 + 1;
        this.loadData = r13.get(r14);
        if (this.loadData == null) goto L11;
        if (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) == true) goto L20;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L11;
    L20:
        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
        r12 = true;
    L21:
        return r12;
    L8:
        if (r11.startNext() == false) goto L10;
        return true;
    }
}
