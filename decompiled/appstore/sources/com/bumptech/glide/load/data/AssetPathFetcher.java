package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public AssetPathFetcher(AssetManager r10, String r11) {
        this.assetManager = r10;
        this.assetPath = r11;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T r10 = this.data;
        if (r10 != null) goto L8;
        return;
    L8:
        close(r10);     // Catch: IOException -> L7
        return;
    }

    public abstract void close(T r10) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super T> r11) {
        T r12 = loadResource(this.assetManager, this.assetPath);     // Catch: IOException -> L5
        this.data = r12;     // Catch: IOException -> L5
        r11.onDataReady(r12);
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Failed to load data from asset manager", e);
    L9:
        r11.onLoadFailed(e);
    }

    public abstract T loadResource(AssetManager r10, String r11) throws IOException;
}
