package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;
    protected final boolean useMediaStoreApisIfAvailable;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this(contentResolver, uri, false);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t9 = this.data;
        if (t9 != null) {
            try {
                close(t9);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void close(T t9) throws IOException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T tLoadResource = loadResource(this.uri, this.contentResolver);
            this.data = tLoadResource;
            dataCallback.onDataReady(tLoadResource);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open Uri", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    public abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public AssetFileDescriptor openAssetFileDescriptor(Uri uri) throws FileNotFoundException {
        return (this.useMediaStoreApisIfAvailable && MediaStoreUtil.isMediaStoreUri(uri) && MediaStoreUtil.isMediaStoreOpenFileApisAvailable()) ? MediaStoreUtil.openAssetFileDescriptor(uri, this.contentResolver) : this.contentResolver.openAssetFileDescriptor(uri, "r");
    }

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z10) {
        this.contentResolver = contentResolver;
        this.uri = uri;
        this.useMediaStoreApisIfAvailable = z10;
    }
}
