package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final ThumbnailStreamOpener opener;

    public static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        private final ContentResolver contentResolver;

        static {
            PATH_PROJECTION = new String[]{"_data"};
        }

        public ImageThumbnailQuery(ContentResolver r10) {
            this.contentResolver = r10;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri r10) {
            String r11 = r10.getLastPathSegment();
            return this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{r11}, null);
        }
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = null;
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        private final ContentResolver contentResolver;

        static {
            PATH_PROJECTION = new String[]{"_data"};
        }

        public VideoThumbnailQuery(ContentResolver r10) {
            this.contentResolver = r10;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri r10) {
            String r11 = r10.getLastPathSegment();
            return this.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{r11}, null);
        }
    }

    @VisibleForTesting
    public ThumbFetcher(Uri r10, ThumbnailStreamOpener r11) {
        this.mediaStoreImageUri = r10;
        this.opener = r11;
    }

    private static ThumbFetcher build(Context r10, Uri r11, ThumbnailQuery r12) {
        ArrayPool r13 = Glide.get(r10).getArrayPool();
        return new ThumbFetcher(r11, new ThumbnailStreamOpener(Glide.get(r10).getRegistry().getImageHeaderParsers(), r12, r13, r10.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context r10, Uri r11) {
        return build(r10, r11, new ImageThumbnailQuery(r10.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context r10, Uri r11) {
        return build(r10, r11, new VideoThumbnailQuery(r10.getContentResolver()));
    }

    private InputStream openThumbInputStream() throws FileNotFoundException {
        InputStream r10 = this.opener.open(this.mediaStoreImageUri);
        if (r10 == null) goto L5;
        int r11 = this.opener.getOrientation(this.mediaStoreImageUri);
    L6:
        if (r11 != (-1)) goto L8;
        return r10;
    L8:
        return new ExifOrientationStream(r10, r11);
    L5:
        r11 = -1;
        goto L6
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream r10 = this.inputStream;
        if (r10 == null) goto L9;
        r10.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super InputStream> r11) {
        InputStream r12 = openThumbInputStream();     // Catch: FileNotFoundException -> L5
        this.inputStream = r12;     // Catch: FileNotFoundException -> L5
        r11.onDataReady(r12);
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Failed to find thumbnail file", e);
    L9:
        r11.onLoadFailed(e);
    }
}
