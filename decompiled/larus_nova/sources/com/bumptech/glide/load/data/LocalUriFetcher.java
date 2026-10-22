package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.util.GlideLogUtil;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    public abstract void close(T r100) throws IOException;

    public abstract T loadResource(Uri r100, ContentResolver r101) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T r100 = this.data;
        if (r100 == null) goto L9;
        close(r100);     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public LocalUriFetcher(ContentResolver r100, Uri r101) {
        this.contentResolver = r100;
        this.uri = r101;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r100, DataFetcher.DataCallback<? super T> r101) {
        T r102 = loadResource(this.uri, this.contentResolver);     // Catch: FileNotFoundException -> L5
        this.data = r102;     // Catch: FileNotFoundException -> L5
        r101.onDataReady(r102);
        return;
    L5:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to open Uri", e);
        r101.onLoadFailed(e);
    }
}
