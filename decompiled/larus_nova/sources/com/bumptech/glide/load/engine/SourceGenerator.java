package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.GlideCacheUtils;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.LogTime;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f33697cb;
    private Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int loadDataListIndex;
    private DataCacheKey originalKey;
    private DataCacheGenerator sourceCacheGenerator;

    private boolean hasNextModelLoader() {
        if (this.loadDataListIndex >= this.helper.getLoadData().size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> r100 = this.loadData;
        if (r100 == null) goto L6;
        r100.fetcher.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        Object r100 = this.dataToCache;
        if (r100 == null) goto L5;
        this.dataToCache = null;
        cacheData(r100);
    L5:
        DataCacheGenerator r101 = this.sourceCacheGenerator;
        if (r101 != null) goto L8;
    L10:
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean r102 = false;
    L11:
        if (r102 == true) goto L21;
        if (hasNextModelLoader() == false) goto L21;
        List<ModelLoader.LoadData<?>> r103 = this.helper.getLoadData();
        int r104 = this.loadDataListIndex;
        this.loadDataListIndex = r104 + 1;
        this.loadData = (ModelLoader.LoadData) ListProtector.get(r103, r104);
        if (this.loadData == null) goto L11;
        if (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) == true) goto L20;
        if (this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()) == false) goto L11;
    L20:
        startNextLoad(this.loadData);
        r102 = true;
    L21:
        return r102;
    L8:
        if (r101.startNext() == false) goto L10;
        return true;
    }

    private void cacheData(Object r110) {
        long r100 = LogTime.getLogTime();
        Encoder<X> r101 = this.helper.getSourceEncoder(r110);     // Catch: Throwable -> L9 Exception -> L11
        DataCacheWriter r102 = new DataCacheWriter(r101, r110, this.helper.getOptions());     // Catch: Throwable -> L9 Exception -> L11
        this.originalKey = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());     // Catch: Throwable -> L9 Exception -> L11
        this.helper.getDiskCache().put(this.originalKey, r102);     // Catch: Throwable -> L9 Exception -> L11
        String r103 = "";
        if ((r110 instanceof FileInputStream) == false) goto L6;
        r103 = (String) readField(r110, "path");     // Catch: Throwable -> L9 Exception -> L11
        boolean r111 = isFileExits(r103);     // Catch: Throwable -> L9 Exception -> L11
    L7:
        GlideLogUtil.i(TAG, "Finished encoding source to cache, putDiskCache, key: " + this.originalKey + ", cacheDataPath: " + r103 + ", isExists: " + r111 + ", encoder: " + r101 + ", duration: " + LogTime.getElapsedMillis(r100));     // Catch: Throwable -> L9 Exception -> L11
    L13:
        this.loadData.fetcher.cleanup();
        this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
        return;
    L6:
        r111 = false;
    L9:
        th = move-exception;
        this.loadData.fetcher.cleanup();
        throw th;
    L11:
        e = move-exception;
        GlideCacheUtils.onWriteCacheFailed(e);     // Catch: Throwable -> L9
        GlideLogUtil.e(TAG, "cacheData exception:" + e);     // Catch: Throwable -> L9
        goto L13
    }

    public static boolean isFileExits(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Exception -> L9
        if (r101.exists() == true) goto L6;
        return false;
    L6:
        GlideLogUtil.i(TAG, "filename:" + r100 + ",file length:" + r101.length());     // Catch: Exception -> L9
        return true;
    L9:
        return false;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> r100) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new AnonymousClass1(this, r100));
    }

    public boolean isCurrentRequest(ModelLoader.LoadData<?> r100) {
        ModelLoader.LoadData<?> r101 = this.loadData;
        if (r101 == null) goto L6;
        if (r101 != r100) goto L6;
        return true;
    L6:
        return false;
    }

    public SourceGenerator(DecodeHelper<?> r100, DataFetcherGenerator.FetcherReadyCallback r101) {
        this.helper = r100;
        this.f33697cb = r101;
    }

    public static <T> T readField(Object r100, String r101) {
        Field r102 = r100.getClass().getDeclaredField(r101);     // Catch: Exception -> L7
        if (r102.isAccessible() == true) goto L5;
        r102.setAccessible(true);     // Catch: Exception -> L7
    L5:
        return (T) r102.get(r100);
    L7:
        e = move-exception;
        GlideLogUtil.e(TAG, "readField failed" + e);
        return null;
    }

    public void onDataReadyInternal(ModelLoader.LoadData<?> r100, Object r110) {
        DiskCacheStrategy r101 = this.helper.getDiskCacheStrategy();
        if (r110 != null) goto L5;
    L7:
        GlideLogUtil.i(TAG, "don't need to Cache, key:" + r100.sourceKey.toString());
        DataFetcherGenerator.FetcherReadyCallback r102 = this.f33697cb;
        Key r103 = r100.sourceKey;
        DataFetcher<?> r104 = r100.fetcher;
        r102.onDataFetcherReady(r103, r110, r104, r104.getDataSource(), this.originalKey);
        return;
    L5:
        if (r101.isDataCacheable(r100.fetcher.getDataSource()) == false) goto L7;
        GlideLogUtil.i(TAG, "need to Cache, key:" + r100.sourceKey.toString());
        this.dataToCache = r110;
        this.f33697cb.reschedule();
    }

    public void onLoadFailedInternal(ModelLoader.LoadData<?> r100, Exception r101) {
        DataFetcherGenerator.FetcherReadyCallback r102 = this.f33697cb;
        DataCacheKey r103 = this.originalKey;
        DataFetcher<?> r104 = r100.fetcher;
        r102.onDataFetcherFailed(r103, r101, r104, r104.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key r100, Exception r101, DataFetcher<?> r102, DataSource r103) {
        this.f33697cb.onDataFetcherFailed(r100, r101, r102, this.loadData.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key r100, Object r101, DataFetcher<?> r102, DataSource r110, Key r111) {
        this.f33697cb.onDataFetcherReady(r100, r101, r102, this.loadData.fetcher.getDataSource(), r100);
    }
}
