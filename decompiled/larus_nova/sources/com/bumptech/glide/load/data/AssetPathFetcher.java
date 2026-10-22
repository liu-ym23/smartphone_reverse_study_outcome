package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    public abstract void close(T r100) throws IOException;

    public abstract T loadResource(AssetManager r100, String r101) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T r100 = this.data;
        if (r100 != null) goto L8;
        return;
    L8:
        close(r100);     // Catch: IOException -> L7
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public AssetPathFetcher(AssetManager r100, String r101) {
        this.assetManager = r100;
        this.assetPath = r101;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority r100, DataFetcher.DataCallback<? super T> r101) {
        T r102 = loadResource(this.assetManager, this.assetPath);     // Catch: IOException -> L5
        this.data = r102;     // Catch: IOException -> L5
        r101.onDataReady(r102);
        return;
    L5:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to load data from asset manager", e);
        r101.onLoadFailed(e);
    }
}
