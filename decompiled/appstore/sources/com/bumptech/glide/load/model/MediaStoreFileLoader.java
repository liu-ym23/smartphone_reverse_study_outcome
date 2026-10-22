package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        public Factory(Context r10) {
            this.context = r10;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory r10) {
            return new MediaStoreFileLoader(this.context);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = null;
        private final Context context;
        private final Uri uri;

        static {
            PROJECTION = new String[]{"_data"};
        }

        public FilePathFetcher(Context r10, Uri r11) {
            this.context = r10;
            this.uri = r11;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super File> r11) {
            Cursor r12 = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            String r13 = null;
            if (r12 == null) goto L14;
        L8:
            th = move-exception;
            r12.close();
            throw th;
        L5:
            if (r12.moveToFirst() == false) goto L10;
            r13 = r12.getString(r12.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L8
        L10:
            r12.close();
        L14:
            if (TextUtils.isEmpty(r13) == false) goto L16;
            r11.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.uri));
            return;
        L16:
            r11.onDataReady(new File(r13));
        }
    }

    public MediaStoreFileLoader(Context r10) {
        this.context = r10;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ ModelLoader.LoadData<File> buildLoadData(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) {
        return buildLoadData2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public /* bridge */ /* synthetic */ boolean handles(@NonNull Uri r10) {
        return handles2(r10);
    }

    /* JADX INFO: renamed from: buildLoadData, reason: avoid collision after fix types in other method */
    public ModelLoader.LoadData<File> buildLoadData2(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) {
        return new ModelLoader.LoadData(new ObjectKey(r10), new FilePathFetcher(this.context, r10));
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull Uri r10) {
        return MediaStoreUtil.isMediaStoreUri(r10);
    }
}
