package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;

    public LocalUriFetcher(ContentResolver r10, Uri r11) {
        this.contentResolver = r10;
        this.uri = r11;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T r10 = this.data;
        if (r10 == null) goto L9;
        close(r10);     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public abstract void close(T r10) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super T> r11) {
        T r12 = loadResource(this.uri, this.contentResolver);     // Catch: FileNotFoundException -> L5
        this.data = r12;     // Catch: FileNotFoundException -> L5
        r11.onDataReady(r12);
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Failed to open Uri", e);
    L9:
        r11.onLoadFailed(e);
    }

    public abstract T loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException;
}
